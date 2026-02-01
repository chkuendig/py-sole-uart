#!/usr/bin/env python3
"""
Example: Monitor SOLE Fitness equipment in real-time.

This script scans for SOLE/Spirit/XTERRA equipment, connects to it,
and displays workout data as it comes in.

Usage:
    python example.py              # Scan and connect to first device
    python example.py --address XX:XX:XX:XX:XX:XX  # Connect to specific device
    python example.py --scan       # Just scan, don't connect
"""

import argparse
import asyncio
import logging
import signal
import sys
from datetime import datetime

from sole_client import SoleMonitor, SoleDevice
from sole_protocol import DeviceInfo, WorkoutData, EndWorkoutData, WorkoutMode
from sole_ftms import FTMSTreadmillData

# Configure logging
logging.basicConfig(
    level=logging.INFO,
    format="%(asctime)s [%(levelname)s] %(message)s",
    datefmt="%H:%M:%S",
)
logger = logging.getLogger(__name__)


class WorkoutMonitor:
    """Simple workout monitor with formatted output."""

    def __init__(self):
        self.monitor = SoleMonitor()
        self.monitor.on_device_info = self.on_device_info
        self.monitor.on_workout_data = self.on_workout_data
        self.monitor.on_workout_end = self.on_workout_end
        self.monitor.on_mode_change = self.on_mode_change
        self.monitor.on_ftms_data = self.on_ftms_data
        self.monitor.on_disconnect = self.on_disconnect

        self._last_update = datetime.now()
        self._last_ftms_update = datetime.now()
        self._device_info: DeviceInfo | None = None

    def on_device_info(self, info: DeviceInfo):
        """Handle device info received."""
        self._device_info = info
        print("\n" + "=" * 60)
        print(f"  Connected to: {info.brand.name} equipment")
        print(f"  Model: {info.model} ({info.device_type.name})")
        print(f"  Unit: {'Imperial' if info.unit else 'Metric'}")
        if info.device_type.name == "TREADMILL":
            print(f"  Speed range: {info.min_speed/10:.1f} - {info.max_speed/10:.1f} km/h")
            print(f"  Max incline: {info.max_incline}%")
        else:
            print(f"  Max level: {info.max_level}")
            print(f"  Max incline: {info.max_incline}")
        print("=" * 60 + "\n")

    def on_workout_data(self, data: WorkoutData):
        """Handle real-time workout data."""
        now = datetime.now()

        # Update display (throttle to avoid flicker)
        if (now - self._last_update).total_seconds() < 0.5:
            return
        self._last_update = now

        # Build status line
        time_str = f"{data.minutes:02d}:{data.seconds:02d}"

        if self._device_info and self._device_info.device_type.name == "TREADMILL":
            status = (
                f"\r[{time_str}] "
                f"Speed: {data.speed:4.1f} km/h | "
                f"Incline: {data.incline:2d}% | "
                f"Dist: {data.distance:5.2f} km | "
                f"Cal: {data.calories:4.0f} | "
                f"HR: {data.heart_rate:3d} bpm | "
                f"Pace: {data.pace_str}/km"
            )
        else:
            # Bike/Elliptical
            status = (
                f"\r[{time_str}] "
                f"RPM: {data.rpm:3d} | "
                f"Level: {data.level:2d} | "
                f"Speed: {data.speed:4.1f} | "
                f"Dist: {data.distance:5.2f} | "
                f"Cal: {data.calories:4.0f} | "
                f"HR: {data.heart_rate:3d} bpm | "
                f"Watt: {data.watt:3d}"
            )

        # Print without newline, overwriting previous line
        print(status, end="", flush=True)

    def on_workout_end(self, data: EndWorkoutData):
        """Handle workout summary."""
        minutes = data.total_seconds // 60
        seconds = data.total_seconds % 60

        print("\n\n" + "=" * 60)
        print("  WORKOUT COMPLETE")
        print("=" * 60)
        print(f"  Duration:   {minutes:02d}:{seconds:02d}")
        print(f"  Distance:   {data.distance:.2f} km")
        print(f"  Calories:   {data.calories:.0f}")
        print(f"  Avg Speed:  {data.speed:.1f} km/h")
        print(f"  Avg HR:     {data.heart_rate} bpm")
        print("=" * 60 + "\n")

    def on_ftms_data(self, data: FTMSTreadmillData):
        """Handle FTMS treadmill data (works for console-started workouts)."""
        now = datetime.now()

        # Throttle updates
        if (now - self._last_ftms_update).total_seconds() < 0.5:
            return
        self._last_ftms_update = now

        # Only show FTMS data if speed > 0 (actually moving)
        if data.speed_kmh > 0:
            parts = [f"Speed: {data.speed_kmh:.1f} km/h"]

            if data.incline_pct is not None:
                parts.append(f"Incline: {data.incline_pct:.1f}%")
            if data.distance_m is not None:
                parts.append(f"Dist: {data.distance_m/1000:.2f} km")
            if data.total_calories is not None:
                parts.append(f"Cal: {data.total_calories}")
            if data.heart_rate and data.heart_rate > 0:
                parts.append(f"HR: {data.heart_rate} bpm")
            if data.elapsed_seconds is not None:
                parts.append(f"Time: {data.elapsed_str}")

            status = "\r[FTMS] " + " | ".join(parts)
            print(status + " " * 10, end="", flush=True)

    def on_mode_change(self, mode: WorkoutMode):
        """Handle mode changes."""
        mode_names = {
            WorkoutMode.STOP: "Stopped",
            WorkoutMode.IDLE: "Idle",
            WorkoutMode.RUNNING: "Running",
            WorkoutMode.PAUSE: "Paused",
            WorkoutMode.COOLDOWN: "Cooldown",
            WorkoutMode.SUMMARY: "Summary",
            WorkoutMode.SLEEP: "Sleep",
            WorkoutMode.READY: "Ready (press START on treadmill)",
        }
        name = mode_names.get(mode, f"Unknown ({mode})")
        # Only print if mode changed significantly (avoid spam for READY)
        if not hasattr(self, '_last_mode') or self._last_mode != mode:
            self._last_mode = mode
            print(f"\n[Mode: {name}]")

    def on_disconnect(self):
        """Handle disconnection."""
        print("\n\n[!] Disconnected from device")

    async def run(self, address: str | None = None):
        """Main run loop."""
        device = None

        if address:
            # Connect to specified address
            print(f"Connecting to {address}...")
        else:
            # Scan for devices
            print("Scanning for SOLE fitness equipment...")
            devices = await SoleMonitor.scan(timeout=10.0)

            if not devices:
                print("No devices found. Make sure your equipment is powered on.")
                return

            print(f"\nFound {len(devices)} device(s):")
            for i, d in enumerate(devices):
                print(f"  [{i+1}] {d.name} ({d.address}) RSSI: {d.rssi}")

            # Use first device
            device = devices[0]
            address = device.ble_device
            print(f"\nConnecting to {device.name}...")

        # Connect
        if not await self.monitor.connect(address):
            print("Failed to connect")
            return

        print("Connected! Waiting for workout data...")
        print("(Start a workout on your equipment to see data)")
        print("Press Ctrl+C to exit\n")

        # Monitor until interrupted
        try:
            await self.monitor.start_monitoring()
        except asyncio.CancelledError:
            pass
        finally:
            await self.monitor.disconnect()


async def scan_only():
    """Just scan and list devices."""
    print("Scanning for SOLE fitness equipment (10 seconds)...\n")
    devices = await SoleMonitor.scan(timeout=10.0)

    if not devices:
        print("No devices found.")
        return

    print(f"\nFound {len(devices)} device(s):\n")
    print(f"{'Name':<20} {'Address':<20} {'RSSI':<8}")
    print("-" * 50)
    for d in devices:
        print(f"{d.name:<20} {d.address:<20} {d.rssi:<8}")


def main():
    parser = argparse.ArgumentParser(
        description="Monitor SOLE fitness equipment via Bluetooth LE"
    )
    parser.add_argument(
        "--address", "-a",
        help="BLE address of device to connect to"
    )
    parser.add_argument(
        "--scan", "-s",
        action="store_true",
        help="Just scan for devices, don't connect"
    )
    parser.add_argument(
        "--debug", "-d",
        action="store_true",
        help="Enable debug logging"
    )

    args = parser.parse_args()

    if args.debug:
        logging.getLogger().setLevel(logging.DEBUG)

    # Handle Ctrl+C gracefully
    loop = asyncio.new_event_loop()
    asyncio.set_event_loop(loop)

    if args.scan:
        loop.run_until_complete(scan_only())
    else:
        app = WorkoutMonitor()

        def signal_handler():
            app.monitor.stop_monitoring()

        loop.add_signal_handler(signal.SIGINT, signal_handler)
        loop.add_signal_handler(signal.SIGTERM, signal_handler)

        try:
            loop.run_until_complete(app.run(args.address))
        except KeyboardInterrupt:
            pass
        finally:
            loop.close()


if __name__ == "__main__":
    main()
