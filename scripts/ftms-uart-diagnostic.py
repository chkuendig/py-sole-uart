#!/usr/bin/env python3
"""
FTMS vs UART Comparison Monitor

This diagnostic script tests the interaction between FTMS and UART protocols:

1. Phase 1: FTMS-only monitoring (30 seconds)
   - Subscribe to FTMS Treadmill Data only
   - Log all data received (including idle/zero values)

2. Phase 2: Add UART monitoring (30 seconds)
   - Keep FTMS subscription active
   - Add UART notification subscription (passive - no commands sent)
   - Compare: does FTMS data change? What UART data appears?

3. Phase 3: UART with echo (30 seconds)
   - Enable WorkoutMode echo (the treadonme technique)
   - See if this affects FTMS or unlocks more UART data

Usage:
    python ftms_uart_comparison.py              # Scan and connect
    python ftms_uart_comparison.py -a XX:XX:XX  # Connect to specific device
    python ftms_uart_comparison.py --phase 2    # Start at phase 2
"""

import argparse
import asyncio
import logging
import signal
from dataclasses import dataclass, field
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
    WorkoutMode,
)
from sole_ftms import (
    FTMSService,
    FTMSTreadmillData,
    parse_treadmill_data,
)

logging.basicConfig(
    level=logging.INFO,
    format="%(asctime)s.%(msecs)03d [%(levelname)s] %(message)s",
    datefmt="%H:%M:%S",
)
logger = logging.getLogger(__name__)


@dataclass
class DataStats:
    """Track statistics for a data source."""
    name: str
    message_count: int = 0
    last_message: Optional[datetime] = None
    last_data: Optional[str] = None
    unique_flags: set = field(default_factory=set)

    def record(self, data_str: str, flags: Optional[int] = None):
        self.message_count += 1
        self.last_message = datetime.now()
        self.last_data = data_str
        if flags is not None:
            self.unique_flags.add(flags)

    def summary(self) -> str:
        if self.message_count == 0:
            return f"{self.name}: No messages received"
        rate = self.message_count / 30.0  # per second over 30s phase
        flags_str = ", ".join(f"0x{f:04X}" for f in sorted(self.unique_flags)) if self.unique_flags else "N/A"
        return f"{self.name}: {self.message_count} msgs ({rate:.1f}/sec), flags seen: [{flags_str}]"


class ComparisonMonitor:
    """Monitor that compares FTMS and UART behavior."""

    DEVICE_PREFIXES = [
        "SOLE", "Sole", "SPIRIT", "Spirit", "XTERRA", "Xterra", "FUEL", "Fuel",
        "E25", "E35", "E55", "E95", "F63", "F65", "F80", "F85",
        "B94", "R92", "LCB", "LCR", "TT8", "S77", "XT",
    ]

    def __init__(self):
        self._client: Optional[BleakClient] = None
        self._parser = ProtocolParser()

        # Characteristics
        self._ftms_treadmill_char: Optional[str] = None
        self._ftms_bike_char: Optional[str] = None
        self._ftms_cross_trainer_char: Optional[str] = None
        self._uart_notify_char: Optional[str] = None
        self._uart_write_char: Optional[str] = None

        # State
        self._running = False
        self._current_phase = 0
        self._echo_enabled = False

        # Statistics per phase
        self._phase_stats: dict[int, dict[str, DataStats]] = {}

    @classmethod
    async def scan(cls, timeout: float = 10.0) -> list[BLEDevice]:
        """Scan for compatible devices."""
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
        """Connect to device."""
        logger.info(f"Connecting to {device}...")

        self._client = BleakClient(device, disconnected_callback=self._on_disconnect)

        try:
            await self._client.connect()
            logger.info("Connected!")
            await self._discover_characteristics()
            return True
        except Exception as e:
            logger.error(f"Connection failed: {e}")
            return False

    async def _discover_characteristics(self):
        """Discover all relevant characteristics."""
        services = self._client.services

        print("\n" + "=" * 60)
        print("  DISCOVERED SERVICES")
        print("=" * 60)

        for service in services:
            service_uuid = str(service.uuid).lower()

            # FTMS Service
            if service_uuid == FTMSService.SERVICE.lower():
                print(f"\n  FTMS Service: {service.uuid}")
                for char in service.characteristics:
                    char_uuid = str(char.uuid).lower()
                    props = ", ".join(char.properties)
                    print(f"    - {char.uuid} [{props}]")

                    if char_uuid == FTMSService.TREADMILL_DATA.lower():
                        self._ftms_treadmill_char = char.uuid
                        print(f"      ^ Treadmill Data")
                    elif char_uuid == FTMSService.INDOOR_BIKE_DATA.lower():
                        self._ftms_bike_char = char.uuid
                        print(f"      ^ Indoor Bike Data")
                    elif char_uuid == FTMSService.CROSS_TRAINER_DATA.lower():
                        self._ftms_cross_trainer_char = char.uuid
                        print(f"      ^ Cross Trainer Data")

            # UART Service (Primary)
            elif service_uuid == ServiceUUID.PRIMARY.lower():
                print(f"\n  UART Service (Primary/ISSC): {service.uuid}")
                for char in service.characteristics:
                    char_uuid = str(char.uuid).lower()
                    props = ", ".join(char.properties)
                    print(f"    - {char.uuid} [{props}]")

                    if char_uuid == CharacteristicUUID.PRIMARY_NOTIFY.lower():
                        self._uart_notify_char = char.uuid
                        print(f"      ^ Notify (RX)")
                    elif char_uuid == CharacteristicUUID.PRIMARY_WRITE.lower():
                        self._uart_write_char = char.uuid
                        print(f"      ^ Write (TX)")

            # UART Service (Secondary/Legacy)
            elif service_uuid == ServiceUUID.SECONDARY.lower():
                print(f"\n  UART Service (Secondary/Legacy): {service.uuid}")
                for char in service.characteristics:
                    char_uuid = str(char.uuid).lower()
                    props = ", ".join(char.properties)
                    print(f"    - {char.uuid} [{props}]")

                    if self._uart_notify_char is None:
                        if char_uuid == CharacteristicUUID.SECONDARY_NOTIFY.lower():
                            self._uart_notify_char = char.uuid
                            print(f"      ^ Notify (RX)")
                        elif char_uuid == CharacteristicUUID.SECONDARY_WRITE.lower():
                            self._uart_write_char = char.uuid
                            print(f"      ^ Write (TX)")

        print("\n" + "=" * 60)
        print(f"  FTMS Treadmill: {'Found' if self._ftms_treadmill_char else 'Not found'}")
        print(f"  FTMS Bike:      {'Found' if self._ftms_bike_char else 'Not found'}")
        print(f"  FTMS Cross:     {'Found' if self._ftms_cross_trainer_char else 'Not found'}")
        print(f"  UART Notify:    {'Found' if self._uart_notify_char else 'Not found'}")
        print(f"  UART Write:     {'Found' if self._uart_write_char else 'Not found'}")
        print("=" * 60 + "\n")

    def _on_disconnect(self, client):
        """Handle disconnection."""
        logger.warning("Disconnected!")
        self._running = False

    def _get_stats(self, name: str) -> DataStats:
        """Get or create stats for current phase."""
        if self._current_phase not in self._phase_stats:
            self._phase_stats[self._current_phase] = {}
        if name not in self._phase_stats[self._current_phase]:
            self._phase_stats[self._current_phase][name] = DataStats(name)
        return self._phase_stats[self._current_phase][name]

    def _handle_ftms_treadmill(self, char: BleakGATTCharacteristic, data: bytearray):
        """Handle FTMS Treadmill Data."""
        raw = bytes(data)
        flags = int.from_bytes(raw[0:2], 'little') if len(raw) >= 2 else 0

        parsed = parse_treadmill_data(raw)

        # Build a summary string
        parts = [f"spd={parsed.speed_kmh:.1f}"]
        if parsed.heart_rate:
            parts.append(f"hr={parsed.heart_rate}")
        if parsed.incline_pct is not None:
            parts.append(f"inc={parsed.incline_pct:.1f}")
        if parsed.distance_m is not None:
            parts.append(f"dist={parsed.distance_m}")
        if parsed.total_calories is not None:
            parts.append(f"cal={parsed.total_calories}")
        if parsed.elapsed_seconds is not None:
            parts.append(f"time={parsed.elapsed_seconds}s")

        summary = " ".join(parts)

        stats = self._get_stats("FTMS_Treadmill")
        stats.record(summary, flags)

        logger.info(f"[FTMS-TM] flags=0x{flags:04X} | {summary} | raw={raw.hex().upper()}")

    def _handle_ftms_bike(self, char: BleakGATTCharacteristic, data: bytearray):
        """Handle FTMS Indoor Bike Data."""
        raw = bytes(data)
        flags = int.from_bytes(raw[0:2], 'little') if len(raw) >= 2 else 0

        stats = self._get_stats("FTMS_Bike")
        stats.record(raw.hex().upper(), flags)

        logger.info(f"[FTMS-BK] flags=0x{flags:04X} | raw={raw.hex().upper()}")

    def _handle_ftms_cross(self, char: BleakGATTCharacteristic, data: bytearray):
        """Handle FTMS Cross Trainer Data."""
        raw = bytes(data)
        flags = int.from_bytes(raw[0:3], 'little') if len(raw) >= 3 else 0

        stats = self._get_stats("FTMS_CrossTrainer")
        stats.record(raw.hex().upper(), flags)

        logger.info(f"[FTMS-XT] flags=0x{flags:06X} | raw={raw.hex().upper()}")

    def _handle_uart(self, char: BleakGATTCharacteristic, data: bytearray):
        """Handle UART notification."""
        raw = bytes(data)

        stats = self._get_stats("UART")
        stats.record(raw.hex().upper())

        # Parse the message
        messages = self._parser.feed(raw)

        for msg in messages:
            if isinstance(msg, dict):
                cmd = msg.get("cmd")
                if cmd == Command.GET_MODE or cmd == 3:
                    mode_val = msg.get("mode_value", 0)
                    try:
                        mode_name = WorkoutMode(mode_val).name
                    except ValueError:
                        mode_name = f"0x{mode_val:02X}"

                    logger.info(f"[UART] Mode: {mode_name}")

                    # Echo if enabled
                    if self._echo_enabled and self._uart_write_char:
                        asyncio.create_task(self._echo_mode(mode_val))
                else:
                    logger.info(f"[UART] cmd=0x{cmd:02X} | {msg}")
            else:
                logger.info(f"[UART] {type(msg).__name__}: {msg}")

    async def _echo_mode(self, mode_val: int):
        """Echo WorkoutMode back."""
        try:
            cmd = CommandBuilder.echo_mode(mode_val)
            await self._client.write_gatt_char(self._uart_write_char, cmd, response=False)
            logger.debug(f"Echoed mode 0x{mode_val:02X}")
        except Exception as e:
            logger.debug(f"Echo failed: {e}")

    async def run_phase(self, phase: int, duration: float = 30.0):
        """Run a monitoring phase."""
        self._current_phase = phase

        print("\n" + "=" * 60)
        if phase == 1:
            print("  PHASE 1: FTMS Only")
            print("  - Subscribing to FTMS notifications only")
            print("  - No UART activity")
        elif phase == 2:
            print("  PHASE 2: FTMS + UART (Passive)")
            print("  - Keeping FTMS subscriptions")
            print("  - Adding UART notifications (no commands sent)")
        elif phase == 3:
            print("  PHASE 3: FTMS + UART (Echo Mode)")
            print("  - Enabling WorkoutMode echo")
            print("  - This may unlock more data flow")
        print(f"  Duration: {duration:.0f} seconds")
        print("=" * 60 + "\n")

        # Phase 1: Subscribe to FTMS
        if phase == 1:
            if self._ftms_treadmill_char:
                await self._client.start_notify(self._ftms_treadmill_char, self._handle_ftms_treadmill)
                logger.info("Subscribed to FTMS Treadmill Data")
            if self._ftms_bike_char:
                await self._client.start_notify(self._ftms_bike_char, self._handle_ftms_bike)
                logger.info("Subscribed to FTMS Indoor Bike Data")
            if self._ftms_cross_trainer_char:
                await self._client.start_notify(self._ftms_cross_trainer_char, self._handle_ftms_cross)
                logger.info("Subscribed to FTMS Cross Trainer Data")

        # Phase 2: Add UART (passive)
        elif phase == 2:
            if self._uart_notify_char:
                await self._client.start_notify(self._uart_notify_char, self._handle_uart)
                logger.info("Subscribed to UART notifications (passive - no commands)")

        # Phase 3: Enable echo
        elif phase == 3:
            self._echo_enabled = True
            logger.info("Enabled WorkoutMode echo")

        # Wait for duration
        start = datetime.now()
        while self._running and (datetime.now() - start).total_seconds() < duration:
            await asyncio.sleep(0.1)

        # Print phase summary
        self._print_phase_summary(phase)

    def _print_phase_summary(self, phase: int):
        """Print summary for a phase."""
        print("\n" + "-" * 60)
        print(f"  PHASE {phase} SUMMARY")
        print("-" * 60)

        if phase in self._phase_stats:
            for name, stats in self._phase_stats[phase].items():
                print(f"  {stats.summary()}")
                if stats.last_data:
                    # Truncate if too long
                    data = stats.last_data[:60] + "..." if len(stats.last_data) > 60 else stats.last_data
                    print(f"    Last: {data}")
        else:
            print("  No data received")

        print("-" * 60 + "\n")

    async def run(self, start_phase: int = 1, phase_duration: float = 30.0):
        """Run all phases."""
        self._running = True

        print("\n" + "=" * 60)
        print("  FTMS vs UART COMPARISON TEST")
        print("=" * 60)
        print("  This test will run 3 phases to compare protocol behavior:")
        print("  - Phase 1: FTMS only (baseline)")
        print("  - Phase 2: FTMS + UART passive")
        print("  - Phase 3: FTMS + UART with echo")
        print("")
        print("  TIP: Start a workout on the console during the test")
        print("       to see how data flow changes between phases.")
        print("=" * 60 + "\n")

        for phase in range(start_phase, 4):
            if not self._running:
                break
            await self.run_phase(phase, phase_duration)

        # Final comparison
        self._print_final_comparison()

    def _print_final_comparison(self):
        """Print final comparison across all phases."""
        print("\n" + "=" * 60)
        print("  FINAL COMPARISON")
        print("=" * 60)

        all_sources = set()
        for phase_data in self._phase_stats.values():
            all_sources.update(phase_data.keys())

        for source in sorted(all_sources):
            print(f"\n  {source}:")
            for phase in sorted(self._phase_stats.keys()):
                if source in self._phase_stats[phase]:
                    stats = self._phase_stats[phase][source]
                    flags_str = ", ".join(f"0x{f:04X}" for f in sorted(stats.unique_flags)) if stats.unique_flags else "-"
                    print(f"    Phase {phase}: {stats.message_count:4d} msgs, flags: [{flags_str}]")
                else:
                    print(f"    Phase {phase}: (not subscribed)")

        print("\n" + "=" * 60)
        print("  OBSERVATIONS")
        print("=" * 60)

        # Check if FTMS message count changed
        ftms_counts = []
        for phase in sorted(self._phase_stats.keys()):
            for name, stats in self._phase_stats[phase].items():
                if name.startswith("FTMS"):
                    ftms_counts.append((phase, name, stats.message_count))

        if len(ftms_counts) >= 2:
            p1_count = sum(c for p, n, c in ftms_counts if p == 1)
            p2_count = sum(c for p, n, c in ftms_counts if p == 2)
            p3_count = sum(c for p, n, c in ftms_counts if p == 3)

            if p2_count < p1_count * 0.8:
                print("  ! FTMS messages DECREASED after adding UART")
            elif p2_count > p1_count * 1.2:
                print("  ! FTMS messages INCREASED after adding UART")
            else:
                print("  - FTMS message rate stable across phases")

        print("=" * 60 + "\n")

    async def disconnect(self):
        """Disconnect from device."""
        self._running = False
        if self._client and self._client.is_connected:
            await self._client.disconnect()


async def main():
    parser = argparse.ArgumentParser(description="FTMS vs UART comparison test")
    parser.add_argument("-a", "--address", help="BLE address to connect to")
    parser.add_argument("--phase", type=int, default=1, choices=[1, 2, 3],
                        help="Start at specific phase (default: 1)")
    parser.add_argument("--duration", type=float, default=30.0,
                        help="Duration per phase in seconds (default: 30)")
    parser.add_argument("-d", "--debug", action="store_true",
                        help="Enable debug logging")
    args = parser.parse_args()

    if args.debug:
        logging.getLogger().setLevel(logging.DEBUG)

    monitor = ComparisonMonitor()

    # Find device
    if args.address:
        device = args.address
    else:
        print("Scanning for devices...")
        devices = await ComparisonMonitor.scan(timeout=10.0)
        if not devices:
            print("No devices found.")
            return
        device = devices[0]
        print(f"\nUsing: {device.name} ({device.address})")

    # Connect
    if not await monitor.connect(device):
        return

    # Set up signal handlers
    loop = asyncio.get_event_loop()

    def signal_handler():
        monitor._running = False

    loop.add_signal_handler(signal.SIGINT, signal_handler)
    loop.add_signal_handler(signal.SIGTERM, signal_handler)

    try:
        await monitor.run(start_phase=args.phase, phase_duration=args.duration)
    finally:
        await monitor.disconnect()


if __name__ == "__main__":
    asyncio.run(main())
