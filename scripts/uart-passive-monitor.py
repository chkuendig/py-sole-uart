#!/usr/bin/env python3
"""
Passive UART Monitor for SOLE Fitness equipment.

This script uses the "echo technique" to passively monitor workout data
WITHOUT causing console lockout. It works by:

1. Connecting to the UART service
2. Enabling notifications
3. Echoing back WorkoutMode (0x03) messages unchanged
4. NOT sending SET_MODE (0x02) - which would cause lockout

This approach is based on the treadonme library and the SOLE Fitness app's
behavior. The treadmill broadcasts data when a workout is running, and
echoing the mode messages keeps the data stream flowing.

Usage:
    python uart_monitor.py              # Scan and connect to first device
    python uart_monitor.py -a XX:XX:XX  # Connect to specific device
    python uart_monitor.py --no-echo    # Don't echo (may stop data after timeout)
"""

import argparse
import asyncio
import logging
import signal
from datetime import datetime
from typing import Optional

from bleak import BleakClient, BleakScanner
from bleak.backends.device import BLEDevice
from bleak.backends.characteristic import BleakGATTCharacteristic

from sole_protocol import (
    ServiceUUID,
    CharacteristicUUID,
    Command,
    ProtocolParser,
    CommandBuilder,
    DeviceInfo,
    WorkoutData,
    EndWorkoutData,
    WorkoutMode,
)

logging.basicConfig(
    level=logging.INFO,
    format="%(asctime)s [%(levelname)s] %(message)s",
    datefmt="%H:%M:%S",
)
logger = logging.getLogger(__name__)


class PassiveUARTMonitor:
    """
    Passive UART monitor using the echo technique.

    This monitor does NOT send SET_MODE, so it won't take control from the console.
    It simply echoes WorkoutMode messages to keep the data stream active.
    """

    DEVICE_PREFIXES = [
        "SOLE", "Sole", "sole", "SPIRIT", "Spirit",
        "XTERRA", "Xterra", "FUEL", "Fuel",
        "E25", "E35", "E55", "E95", "E96",
        "F63", "F65", "F80", "F85",
        "B94", "R92", "LCB", "LCR",
        "TT8", "S77", "XT",
    ]

    def __init__(self, echo_mode: bool = True, request_device_info: bool = False):
        """
        Initialize passive monitor.

        Args:
            echo_mode: If True, echo WorkoutMode messages (recommended)
            request_device_info: If True, send 0xF0 on connect (slightly less passive)
        """
        self._client: Optional[BleakClient] = None
        self._parser = ProtocolParser()
        self._notify_char: Optional[str] = None
        self._write_char: Optional[str] = None
        self._running = False
        self._echo_mode = echo_mode
        self._request_device_info = request_device_info

        self._last_mode: Optional[int] = None
        self._last_update = datetime.now()
        self._mode_echo_count = 0

    @classmethod
    async def scan(cls, timeout: float = 10.0) -> list[BLEDevice]:
        """Scan for SOLE fitness equipment."""
        devices = []
        seen = set()

        def callback(device: BLEDevice, adv_data):
            if device.address in seen:
                return
            seen.add(device.address)
            name = device.name or adv_data.local_name or ""
            if any(name.startswith(p) for p in cls.DEVICE_PREFIXES):
                devices.append(device)
                logger.info(f"Found: {name} ({device.address}) RSSI: {adv_data.rssi}")

        scanner = BleakScanner(detection_callback=callback)
        await scanner.start()
        await asyncio.sleep(timeout)
        await scanner.stop()
        return devices

    async def connect(self, device: str | BLEDevice) -> bool:
        """Connect to a device."""
        logger.info(f"Connecting to {device}...")

        self._client = BleakClient(device, disconnected_callback=self._on_disconnect)

        try:
            await self._client.connect()
            logger.info("Connected!")

            # Find characteristics
            await self._discover_characteristics()

            # Start notifications immediately
            await self._client.start_notify(self._notify_char, self._handle_notification)
            logger.info("Notifications enabled - waiting for workout data...")

            # Optionally request device info (slightly less passive)
            if self._request_device_info and self._write_char:
                logger.info("Requesting device info (0xF0)...")
                await self._client.write_gatt_char(
                    self._write_char,
                    CommandBuilder.get_device_info(),
                    response=False
                )

            return True
        except Exception as e:
            logger.error(f"Connection failed: {e}")
            return False

    async def _discover_characteristics(self):
        """Find UART service characteristics."""
        for service in self._client.services:
            service_uuid = str(service.uuid).lower()

            if service_uuid == ServiceUUID.PRIMARY.lower():
                logger.info(f"Found UART service: {service.uuid}")
                for char in service.characteristics:
                    char_uuid = str(char.uuid).lower()
                    if char_uuid == CharacteristicUUID.PRIMARY_NOTIFY.lower():
                        self._notify_char = char.uuid
                    elif char_uuid == CharacteristicUUID.PRIMARY_WRITE.lower():
                        self._write_char = char.uuid

            elif service_uuid == ServiceUUID.SECONDARY.lower():
                if self._notify_char is None:
                    logger.info(f"Found secondary UART service: {service.uuid}")
                    for char in service.characteristics:
                        char_uuid = str(char.uuid).lower()
                        if char_uuid == CharacteristicUUID.SECONDARY_NOTIFY.lower():
                            self._notify_char = char.uuid
                        elif char_uuid == CharacteristicUUID.SECONDARY_WRITE.lower():
                            self._write_char = char.uuid

        if not self._notify_char:
            raise RuntimeError("Could not find UART notify characteristic")

    def _on_disconnect(self, client):
        """Handle disconnection."""
        logger.warning("Disconnected from device")
        self._running = False

    def _handle_notification(self, char: BleakGATTCharacteristic, data: bytearray):
        """Handle incoming BLE notification."""
        raw = bytes(data)
        logger.debug(f"RX: {raw.hex().upper()}")

        # Parse messages
        messages = self._parser.feed(raw)

        for msg in messages:
            if isinstance(msg, dict) and msg.get("cmd") == Command.GET_MODE:
                # WorkoutMode message - this is what we echo!
                mode_val = msg.get("mode_value", 0)
                self._handle_mode(mode_val)

            elif isinstance(msg, DeviceInfo):
                self._handle_device_info(msg)

            elif isinstance(msg, WorkoutData):
                self._handle_workout_data(msg)

            elif isinstance(msg, EndWorkoutData):
                self._handle_end_workout(msg)

    def _handle_mode(self, mode_val: int):
        """Handle WorkoutMode message - echo it back!"""
        try:
            mode = WorkoutMode(mode_val)
            mode_name = mode.name
        except ValueError:
            mode_name = f"UNKNOWN(0x{mode_val:02X})"

        # Log mode changes
        if mode_val != self._last_mode:
            self._last_mode = mode_val
            logger.info(f"Mode: {mode_name}")

        # Echo the mode back (key to passive monitoring!)
        if self._echo_mode and self._write_char and self._client and self._client.is_connected:
            asyncio.create_task(self._echo_mode_async(mode_val))

    async def _echo_mode_async(self, mode_val: int):
        """Echo WorkoutMode back to treadmill."""
        try:
            cmd = CommandBuilder.echo_mode(mode_val)
            await self._client.write_gatt_char(self._write_char, cmd, response=False)
            self._mode_echo_count += 1
            logger.debug(f"Echoed mode 0x{mode_val:02X} (count: {self._mode_echo_count})")
        except Exception as e:
            logger.debug(f"Failed to echo mode: {e}")

    def _handle_device_info(self, info: DeviceInfo):
        """Handle device info."""
        print("\n" + "=" * 60)
        print(f"  Device: {info.brand.name} {info.device_type.name}")
        print(f"  Model: {info.model}")
        if info.device_type.name == "TREADMILL":
            print(f"  Speed: {info.min_speed/10:.1f} - {info.max_speed/10:.1f} km/h")
            print(f"  Max Incline: {info.max_incline}%")
        print("=" * 60 + "\n")

    def _handle_workout_data(self, data: WorkoutData):
        """Handle workout data."""
        now = datetime.now()
        if (now - self._last_update).total_seconds() < 0.5:
            return
        self._last_update = now

        time_str = f"{data.minutes:02d}:{data.seconds:02d}"

        device_type = self._parser.device_info.device_type.name if self._parser.device_info else "TREADMILL"

        if device_type == "TREADMILL":
            status = (
                f"\r[{time_str}] "
                f"Speed: {data.speed:4.1f} km/h | "
                f"Incline: {data.incline:2d}% | "
                f"Dist: {data.distance:5.2f} km | "
                f"Cal: {data.calories:4.0f} | "
                f"HR: {data.heart_rate:3d}"
            )
        else:
            status = (
                f"\r[{time_str}] "
                f"RPM: {data.rpm:3d} | "
                f"Level: {data.level:2d} | "
                f"Dist: {data.distance:5.2f} | "
                f"Cal: {data.calories:4.0f} | "
                f"HR: {data.heart_rate:3d}"
            )

        print(status + " " * 10, end="", flush=True)

    def _handle_end_workout(self, data: EndWorkoutData):
        """Handle workout summary."""
        mins = data.total_seconds // 60
        secs = data.total_seconds % 60
        print(f"\n\nWorkout Complete: {mins:02d}:{secs:02d}, {data.distance:.2f}km, {data.calories:.0f}cal")

    async def run(self):
        """Main monitoring loop."""
        self._running = True

        print("\nPassive UART Monitor")
        print("=" * 40)
        print(f"Echo mode: {'ON' if self._echo_mode else 'OFF'}")
        print("Waiting for workout data...")
        print("(Start a workout on the console)")
        print("Press Ctrl+C to exit\n")

        while self._running and self._client and self._client.is_connected:
            await asyncio.sleep(0.1)

    async def disconnect(self):
        """Disconnect from device."""
        self._running = False
        if self._client and self._client.is_connected:
            await self._client.disconnect()


async def main():
    parser = argparse.ArgumentParser(
        description="Passive UART monitor for SOLE equipment (no console lockout)"
    )
    parser.add_argument("-a", "--address", help="BLE address to connect to")
    parser.add_argument("--no-echo", action="store_true",
                        help="Don't echo WorkoutMode (may cause data timeout)")
    parser.add_argument("--device-info", action="store_true",
                        help="Request device info on connect (0xF0)")
    parser.add_argument("-d", "--debug", action="store_true",
                        help="Enable debug logging")
    args = parser.parse_args()

    if args.debug:
        logging.getLogger().setLevel(logging.DEBUG)

    monitor = PassiveUARTMonitor(
        echo_mode=not args.no_echo,
        request_device_info=args.device_info
    )

    # Find device
    if args.address:
        device = args.address
    else:
        print("Scanning for devices...")
        devices = await PassiveUARTMonitor.scan(timeout=10.0)
        if not devices:
            print("No devices found.")
            return
        device = devices[0]
        print(f"\nUsing: {device.name} ({device.address})")

    # Connect and run
    if not await monitor.connect(device):
        return

    loop = asyncio.get_event_loop()

    def signal_handler():
        monitor._running = False

    loop.add_signal_handler(signal.SIGINT, signal_handler)
    loop.add_signal_handler(signal.SIGTERM, signal_handler)

    try:
        await monitor.run()
    finally:
        await monitor.disconnect()
        print(f"\n\nMode echoes sent: {monitor._mode_echo_count}")


if __name__ == "__main__":
    asyncio.run(main())
