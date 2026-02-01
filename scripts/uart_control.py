#!/usr/bin/env python3
"""
UART Control for SOLE Fitness equipment.

This script provides interactive control of SOLE treadmills/bikes via UART.
It uses MANUAL mode (like treadonme) to minimize console lockout issues.

WARNING: Console lockout behavior is not fully understood. Using this script
         MAY cause the console controls to become unresponsive. Use with caution.

Based on treadonme's approach:
1. Set user profile
2. Set program to MANUAL mode
3. Send control commands (speed, incline)

Usage:
    python uart_control.py              # Scan and connect
    python uart_control.py -a XX:XX:XX  # Connect to specific device

Interactive commands:
    s <speed>  - Set speed (km/h, e.g., "s 8.5")
    i <incline> - Set incline (%, e.g., "i 5")
    l <level>  - Set level for bikes (e.g., "l 10")
    start      - Send START mode
    stop       - Send STOP mode
    pause      - Send PAUSE mode
    info       - Request device info
    q          - Quit
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
    ProgramType,
    SexType,
)

logging.basicConfig(
    level=logging.INFO,
    format="%(asctime)s [%(levelname)s] %(message)s",
    datefmt="%H:%M:%S",
)
logger = logging.getLogger(__name__)


class UARTController:
    """
    UART controller for SOLE fitness equipment.

    WARNING: This may cause console lockout. Use the passive monitor
    (uart_monitor.py) if you just want to observe data.
    """

    DEVICE_PREFIXES = [
        "SOLE", "Sole", "sole", "SPIRIT", "Spirit",
        "XTERRA", "Xterra", "FUEL", "Fuel",
        "E25", "E35", "E55", "E95", "E96",
        "F63", "F65", "F80", "F85",
        "B94", "R92", "LCB", "LCR",
        "TT8", "S77", "XT",
    ]

    def __init__(self):
        self._client: Optional[BleakClient] = None
        self._parser = ProtocolParser()
        self._notify_char: Optional[str] = None
        self._write_char: Optional[str] = None
        self._running = False
        self._initialized = False

        self._last_mode: Optional[int] = None
        self._last_update = datetime.now()

    @classmethod
    async def scan(cls, timeout: float = 10.0) -> list[BLEDevice]:
        """Scan for devices."""
        devices = []
        seen = set()

        def callback(device: BLEDevice, adv_data):
            if device.address in seen:
                return
            seen.add(device.address)
            name = device.name or adv_data.local_name or ""
            if any(name.startswith(p) for p in cls.DEVICE_PREFIXES):
                devices.append(device)
                logger.info(f"Found: {name} ({device.address})")

        scanner = BleakScanner(detection_callback=callback)
        await scanner.start()
        await asyncio.sleep(timeout)
        await scanner.stop()
        return devices

    async def connect(self, device: str | BLEDevice) -> bool:
        """Connect to device."""
        logger.info(f"Connecting to {device}...")

        self._client = BleakClient(device, disconnected_callback=self._on_disconnect)

        try:
            await self._client.connect()
            logger.info("Connected!")

            await self._discover_characteristics()
            await self._client.start_notify(self._notify_char, self._handle_notification)

            # Request device info
            logger.info("Requesting device info...")
            await self._send(CommandBuilder.get_device_info())
            await asyncio.sleep(0.5)

            return True
        except Exception as e:
            logger.error(f"Connection failed: {e}")
            return False

    async def _discover_characteristics(self):
        """Find UART characteristics."""
        for service in self._client.services:
            service_uuid = str(service.uuid).lower()

            if service_uuid == ServiceUUID.PRIMARY.lower():
                for char in service.characteristics:
                    char_uuid = str(char.uuid).lower()
                    if char_uuid == CharacteristicUUID.PRIMARY_NOTIFY.lower():
                        self._notify_char = char.uuid
                    elif char_uuid == CharacteristicUUID.PRIMARY_WRITE.lower():
                        self._write_char = char.uuid

            elif service_uuid == ServiceUUID.SECONDARY.lower() and not self._notify_char:
                for char in service.characteristics:
                    char_uuid = str(char.uuid).lower()
                    if char_uuid == CharacteristicUUID.SECONDARY_NOTIFY.lower():
                        self._notify_char = char.uuid
                    elif char_uuid == CharacteristicUUID.SECONDARY_WRITE.lower():
                        self._write_char = char.uuid

        if not self._notify_char or not self._write_char:
            raise RuntimeError("Could not find UART characteristics")

    def _on_disconnect(self, client):
        """Handle disconnection."""
        logger.warning("Disconnected!")
        self._running = False

    async def _send(self, cmd: bytes):
        """Send a command."""
        if self._client and self._client.is_connected and self._write_char:
            logger.debug(f"TX: {cmd.hex().upper()}")
            await self._client.write_gatt_char(self._write_char, cmd, response=False)
        else:
            logger.warning("Cannot send - not connected")

    def _handle_notification(self, char: BleakGATTCharacteristic, data: bytearray):
        """Handle incoming data."""
        raw = bytes(data)
        logger.debug(f"RX: {raw.hex().upper()}")

        messages = self._parser.feed(raw)

        for msg in messages:
            if isinstance(msg, dict) and msg.get("cmd") == Command.GET_MODE:
                mode_val = msg.get("mode_value", 0)
                self._handle_mode(mode_val)

            elif isinstance(msg, DeviceInfo):
                self._handle_device_info(msg)

            elif isinstance(msg, WorkoutData):
                self._handle_workout_data(msg)

            elif isinstance(msg, EndWorkoutData):
                print(f"\nWorkout ended: {msg.distance:.2f}km, {msg.calories:.0f}cal")

    def _handle_mode(self, mode_val: int):
        """Handle mode message and echo it."""
        try:
            mode = WorkoutMode(mode_val)
            mode_name = mode.name
        except ValueError:
            mode_name = f"0x{mode_val:02X}"

        if mode_val != self._last_mode:
            self._last_mode = mode_val
            print(f"\n[Mode: {mode_name}]")

        # Echo mode back
        asyncio.create_task(self._echo_mode(mode_val))

    async def _echo_mode(self, mode_val: int):
        """Echo mode back."""
        try:
            await self._send(CommandBuilder.echo_mode(mode_val))
        except Exception:
            pass

    def _handle_device_info(self, info: DeviceInfo):
        """Handle device info."""
        print("\n" + "=" * 50)
        print(f"  Device: {info.brand.name} {info.device_type.name}")
        print(f"  Model: {info.model}")
        if info.device_type.name == "TREADMILL":
            print(f"  Speed: {info.min_speed/10:.1f} - {info.max_speed/10:.1f} km/h")
            print(f"  Max Incline: {info.max_incline}%")
        else:
            print(f"  Max Level: {info.max_level}")
        print("=" * 50)

    def _handle_workout_data(self, data: WorkoutData):
        """Handle workout data."""
        now = datetime.now()
        if (now - self._last_update).total_seconds() < 1.0:
            return
        self._last_update = now

        time_str = f"{data.minutes:02d}:{data.seconds:02d}"
        device_type = self._parser.device_info.device_type.name if self._parser.device_info else "TREADMILL"

        if device_type == "TREADMILL":
            print(f"\r[{time_str}] Speed:{data.speed:4.1f} Incline:{data.incline:2d}% "
                  f"Dist:{data.distance:.2f} Cal:{data.calories:.0f} HR:{data.heart_rate}   ",
                  end="", flush=True)
        else:
            print(f"\r[{time_str}] RPM:{data.rpm:3d} Level:{data.level:2d} "
                  f"Dist:{data.distance:.2f} Cal:{data.calories:.0f}   ",
                  end="", flush=True)

    async def initialize_manual_mode(self, age: int = 30, weight: int = 70, height: int = 175):
        """
        Initialize for manual mode control (treadonme approach).

        This sets up the session for control. Console lockout behavior
        is not fully understood - this may or may not lock out the console.
        """
        print("\nInitializing manual mode...")

        # Send user profile
        print("  Setting user profile...")
        await self._send(CommandBuilder.set_user_profile(
            sex=SexType.MALE,
            age=age,
            weight=weight,
            height=height
        ))
        await asyncio.sleep(0.2)

        # Set manual program mode
        print("  Setting MANUAL program...")
        await self._send(CommandBuilder.set_program_mode(ProgramType.MANUAL))
        await asyncio.sleep(0.2)

        self._initialized = True
        print("  Initialization complete!")
        print("\n  NOTE: Console lockout behavior is uncertain.")
        print("        If console becomes unresponsive, power cycle the equipment.\n")

    async def set_speed(self, speed_kmh: float):
        """Set speed in km/h."""
        speed_tenths = int(speed_kmh * 10)
        print(f"\nSetting speed to {speed_kmh:.1f} km/h...")
        await self._send(CommandBuilder.set_max_speed(speed_tenths))

    async def set_incline(self, incline_pct: int):
        """Set incline percentage."""
        print(f"\nSetting incline to {incline_pct}%...")
        await self._send(CommandBuilder.set_max_incline(incline_pct))

    async def set_level(self, level: int):
        """Set resistance level."""
        print(f"\nSetting level to {level}...")
        await self._send(CommandBuilder.set_max_level(level))

    async def set_mode(self, mode: WorkoutMode):
        """Set workout mode."""
        print(f"\nSetting mode to {mode.name}...")
        await self._send(CommandBuilder.set_mode(mode))

    async def disconnect(self):
        """Disconnect."""
        self._running = False
        if self._client and self._client.is_connected:
            await self._client.disconnect()


async def interactive_loop(controller: UARTController):
    """Interactive command loop."""
    print("\nInteractive Control Mode")
    print("=" * 40)
    print("Commands:")
    print("  s <speed>   - Set speed (km/h)")
    print("  i <incline> - Set incline (%)")
    print("  l <level>   - Set level")
    print("  s+ / s-     - Speed up/down by 1 step")
    print("  i+ / i-     - Incline up/down by 1%")
    print("  l+ / l-     - Level up/down by 1")
    print("  init        - Initialize manual mode")
    print("  start       - Send START")
    print("  stop        - Send STOP")
    print("  pause       - Send PAUSE")
    print("  info        - Request device info")
    print("  q           - Quit")
    print("=" * 40 + "\n")

    loop = asyncio.get_event_loop()

    while controller._running and controller._client and controller._client.is_connected:
        try:
            # Read input in a non-blocking way
            line = await loop.run_in_executor(None, input, "> ")
            line = line.strip().lower()

            if not line:
                continue

            parts = line.split()
            cmd = parts[0]

            if cmd == "q" or cmd == "quit":
                break

            elif cmd == "init":
                await controller.initialize_manual_mode()

            elif cmd == "s" and len(parts) >= 2:
                try:
                    speed = float(parts[1])
                    await controller.set_speed(speed)
                except ValueError:
                    print("Invalid speed value")

            elif cmd == "i" and len(parts) >= 2:
                try:
                    incline = int(parts[1])
                    await controller.set_incline(incline)
                except ValueError:
                    print("Invalid incline value")

            elif cmd == "l" and len(parts) >= 2:
                try:
                    level = int(parts[1])
                    await controller.set_level(level)
                except ValueError:
                    print("Invalid level value")

            elif cmd == "start":
                await controller.set_mode(WorkoutMode.RUNNING)

            elif cmd == "stop":
                await controller.set_mode(WorkoutMode.STOP)

            elif cmd == "pause":
                await controller.set_mode(WorkoutMode.PAUSE)

            elif cmd == "info":
                await controller._send(CommandBuilder.get_device_info())

            # Increment/decrement commands
            elif cmd == "s+":
                print("Speed up...")
                await controller._send(CommandBuilder.speed_up())

            elif cmd == "s-":
                print("Speed down...")
                await controller._send(CommandBuilder.speed_down())

            elif cmd == "i+":
                print("Incline up...")
                await controller._send(CommandBuilder.incline_up())

            elif cmd == "i-":
                print("Incline down...")
                await controller._send(CommandBuilder.incline_down())

            elif cmd == "l+":
                print("Level up...")
                await controller._send(CommandBuilder.level_up())

            elif cmd == "l-":
                print("Level down...")
                await controller._send(CommandBuilder.level_down())

            else:
                print(f"Unknown command: {cmd}")

        except EOFError:
            break
        except Exception as e:
            logger.error(f"Error: {e}")


async def main():
    parser = argparse.ArgumentParser(
        description="UART control for SOLE equipment (WARNING: may cause console lockout)"
    )
    parser.add_argument("-a", "--address", help="BLE address")
    parser.add_argument("-d", "--debug", action="store_true", help="Debug logging")
    args = parser.parse_args()

    if args.debug:
        logging.getLogger().setLevel(logging.DEBUG)

    print("\n" + "=" * 60)
    print("  SOLE UART Controller")
    print("  WARNING: This may cause console lockout!")
    print("  Use uart_monitor.py for passive monitoring instead.")
    print("=" * 60)

    controller = UARTController()

    # Find device
    if args.address:
        device = args.address
    else:
        print("\nScanning for devices...")
        devices = await UARTController.scan(timeout=10.0)
        if not devices:
            print("No devices found.")
            return
        device = devices[0]
        print(f"\nUsing: {device.name} ({device.address})")

    if not await controller.connect(device):
        return

    controller._running = True

    loop = asyncio.get_event_loop()

    def signal_handler():
        controller._running = False

    loop.add_signal_handler(signal.SIGINT, signal_handler)
    loop.add_signal_handler(signal.SIGTERM, signal_handler)

    try:
        await interactive_loop(controller)
    finally:
        await controller.disconnect()
        print("\nDisconnected.")


if __name__ == "__main__":
    asyncio.run(main())
