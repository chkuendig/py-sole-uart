#!/usr/bin/env python3
"""
Debug passive listener - shows ALL raw data received.
Run this while workout is active to see what treadmill broadcasts.
"""

import asyncio
from bleak import BleakClient, BleakScanner

ADDRESS = "F5:C0:00:03:BE:69"  # Change to your treadmill's address

# Sole UART characteristic
SOLE_NOTIFY = "49535343-1e4d-4bd9-ba61-23c647249616"
SOLE_WRITE = "49535343-8841-43f4-a8d4-ecbe34729bb3"

def parse_msg(data: bytes) -> str:
    """Quick parse of Sole message."""
    if len(data) < 3 or data[0] != 0x5B or data[-1] != 0x5D:
        return f"RAW: {data.hex()}"

    msg_type = data[2]
    msg_names = {
        0x00: "ACK",
        0x03: "WorkoutMode",
        0x06: "WorkoutData",
        0xF0: "DeviceInfo",
    }

    name = msg_names.get(msg_type, f"Type0x{msg_type:02x}")
    return f"{name}: {data.hex()}"


async def main():
    print(f"Scanning for {ADDRESS}...")
    device = await BleakScanner.find_device_by_address(ADDRESS, timeout=10)
    if not device:
        print("Device not found!")
        return

    print(f"Found: {device.name}")
    print(f"\nConnecting (PASSIVE - NO commands sent)...")

    received_count = 0

    def on_notify(sender, data):
        nonlocal received_count
        received_count += 1
        print(f"[{received_count}] {parse_msg(data)}")

    async with BleakClient(device) as client:
        print(f"Connected!")

        # Subscribe to notifications
        await client.start_notify(SOLE_NOTIFY, on_notify)
        print(f"Subscribed to SOLE UART notifications")

        print("\n" + "="*70)
        print("LISTENING FOR DATA (sending NO commands)")
        print("="*70)
        print("If workout is running, you should see WorkoutMode (0x03) messages")
        print("every ~300ms. If you see NOTHING, the treadmill isn't broadcasting.")
        print("\nPress Ctrl+C to stop\n")

        try:
            while True:
                await asyncio.sleep(1)
                if received_count == 0:
                    print(".", end="", flush=True)
        except KeyboardInterrupt:
            pass

        print(f"\n\nReceived {received_count} messages total")
        print("Disconnecting...")


if __name__ == "__main__":
    try:
        asyncio.run(main())
    except KeyboardInterrupt:
        print("\nStopped.")
