#!/usr/bin/env python3
"""
Passive monitoring script for Sole treadmills.

This script demonstrates using the sole-uart library to:
1. Discover a Sole treadmill
2. Connect and establish passive monitoring
3. Display real-time workout data
4. Gracefully disconnect on Ctrl+C

Usage:
    python monitor.py                    # Auto-discover first Sole device
    python monitor.py --address MAC      # Connect to specific device
    python monitor.py --debug            # Enable debug logging
"""

import argparse
import asyncio
import logging
import sys
from signal import SIGINT, SIGTERM

# Add parent directory to path for development
sys.path.insert(0, str(__file__).rsplit('/', 2)[0])

from sole_uart import SoleClient, WorkoutData, MachineState, find_sole_device


def setup_logging(debug: bool = False) -> None:
    """Configure logging."""
    level = logging.DEBUG if debug else logging.INFO
    logging.basicConfig(
        level=level,
        format='%(asctime)s - %(name)s - %(levelname)s - %(message)s',
        datefmt='%H:%M:%S',
    )
    # Reduce bleak verbosity unless debug mode
    if not debug:
        logging.getLogger('bleak').setLevel(logging.WARNING)


def format_workout_display(data: WorkoutData) -> str:
    """Format workout data for display."""
    parts = [
        f"Time: {data.elapsed_time_formatted}",
        f"Speed: {data.speed:4.1f} km/h",
        f"Incline: {data.incline:2d}%",
        f"Distance: {data.distance:5.2f} km",
        f"Calories: {data.calories:4d}",
    ]

    if data.heart_rate > 0:
        parts.append(f"HR: {data.heart_rate:3d} bpm ({data.hr_type.name})")

    return " | ".join(parts)


class Monitor:
    """Treadmill monitor application."""

    def __init__(self, device_address: str = None):
        self.device_address = device_address
        self.client: SoleClient = None
        self.running = False
        self.logger = logging.getLogger(__name__)

    def on_workout_data(self, data: WorkoutData) -> None:
        """Handle workout data updates."""
        display = format_workout_display(data)
        print(f"\r{display}", end='', flush=True)

    def on_state_change(self, state: MachineState) -> None:
        """Handle machine state changes."""
        if state.mode != getattr(self, '_last_mode', None):
            print(f"\n[STATE] {state.mode_name}")
            self._last_mode = state.mode

    def on_disconnect(self) -> None:
        """Handle disconnection."""
        print("\n[DISCONNECT] Treadmill disconnected")
        self.running = False

    async def run(self) -> None:
        """Main monitoring loop."""
        # Find device
        print("Searching for Sole treadmill...")
        device = await find_sole_device(
            timeout=10.0,
            address=self.device_address,
        )

        if not device:
            print("❌ No Sole treadmill found")
            print("\nTips:")
            print("  - Make sure treadmill display is on (not in sleep mode)")
            print("  - Try specifying device address with --address")
            print("  - Enable debug mode with --debug for more details")
            return

        print(f"✓ Found: {device.name} ({device.address})\n")

        # Create client
        self.client = SoleClient(device)
        self.client.set_workout_data_callback(self.on_workout_data)
        self.client.set_state_callback(self.on_state_change)
        self.client.set_disconnect_callback(self.on_disconnect)

        # Connect
        try:
            await self.client.connect()
            print("✓ Connected and monitoring\n")
            print("=" * 80)
            print("PASSIVE MONITORING MODE")
            print("=" * 80)
            print("\nStart a workout on the treadmill console to see data.")
            print("Press Ctrl+C to stop monitoring.\n")

            if self.client.device_info:
                info = self.client.device_info
                print(f"Device Info:")
                print(f"  Model: {info.model}")
                print(f"  Units: {info.units}")
                print(f"  Speed Range: {info.min_speed:.1f} - {info.max_speed:.1f} km/h")
                print(f"  Max Incline: {info.max_incline}%")
                print()

            # Monitor until interrupted
            self.running = True
            while self.running and self.client.is_connected:
                await asyncio.sleep(0.1)

        except KeyboardInterrupt:
            print("\n\n[STOP] Keyboard interrupt")
        except Exception as e:
            print(f"\n❌ Error: {e}")
            self.logger.exception("Monitoring error")
        finally:
            # Disconnect
            if self.client and self.client.is_connected:
                print("\nDisconnecting...")
                await self.client.disconnect()
            print("✓ Disconnected\n")

    def stop(self) -> None:
        """Stop monitoring."""
        self.running = False


async def async_main(args: argparse.Namespace) -> None:
    """Async main entry point."""
    setup_logging(args.debug)

    monitor = Monitor(device_address=args.address)

    # Handle signals for clean shutdown
    loop = asyncio.get_running_loop()

    def signal_handler():
        monitor.stop()

    for sig in (SIGINT, SIGTERM):
        loop.add_signal_handler(sig, signal_handler)

    await monitor.run()


def main() -> None:
    """Main entry point."""
    parser = argparse.ArgumentParser(
        description="Passive monitor for Sole treadmills",
        formatter_class=argparse.RawDescriptionHelpFormatter,
    )
    parser.add_argument(
        '--address',
        '-a',
        help='Specific device MAC address (e.g., F5:C0:00:03:BE:69)',
    )
    parser.add_argument(
        '--debug',
        '-d',
        action='store_true',
        help='Enable debug logging',
    )

    args = parser.parse_args()

    try:
        asyncio.run(async_main(args))
    except KeyboardInterrupt:
        print("\nExiting...")


if __name__ == "__main__":
    main()
