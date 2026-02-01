#!/usr/bin/env python3
"""
Debug script that shows ALL BLE traffic (sent AND received).
This will help identify if we're sending messages in a loop.
"""

import asyncio
from bleak import BleakClient, BleakScanner

SOLE_NOTIFY = "49535343-1e4d-4bd9-ba61-23c647249616"
SOLE_WRITE = "49535343-8841-43f4-a8d4-ecbe34729bb3"

# Sole device name prefixes
SOLE_PREFIXES = ("F63", "F65", "F80", "F85", "TT8", "E25", "E35", "SOLE", "Sole")

sent_count = 0
received_count = 0

def parse_msg(data: bytes) -> str:
    """Parse message."""
    if len(data) < 3 or data[0] != 0x5B or data[-1] != 0x5D:
        return f"RAW: {data.hex()}"

    msg_type = data[2]
    msg_names = {
        0x00: "ACK",
        0x03: "WorkoutMode",
        0x06: "WorkoutData",
        0xF0: "DeviceInfo",
    }

    return f"{msg_names.get(msg_type, f'Type0x{msg_type:02x}')}: {data.hex()}"


class DebugClient:
    def __init__(self, client):
        self.client = client
        self.original_write = client.write_gatt_char
        # Wrap the write method to log all sends
        client.write_gatt_char = self.logged_write

    async def logged_write(self, char_uuid, data, response=None):
        global sent_count
        sent_count += 1
        print(f">>> SENT [{sent_count}] {parse_msg(data)}")
        if response is None:
            return await self.original_write(char_uuid, data)
        else:
            return await self.original_write(char_uuid, data, response=response)


async def main():
    print("Scanning for Sole devices...")
    devices = await BleakScanner.discover(timeout=10.0)

    # Find Sole device
    device = None
    for d in devices:
        if d.name and any(d.name.startswith(prefix) for prefix in SOLE_PREFIXES):
            device = d
            break

    if not device:
        print("No Sole device found!")
        print("\nFound devices:")
        for d in devices[:10]:
            print(f"  {d.name} ({d.address})")
        return

    print(f"Found: {device.name} ({device.address})\n")

    def on_notify(sender, data):
        global received_count
        received_count += 1
        print(f"<<< RECV [{received_count}] {parse_msg(data)}")

    async with BleakClient(device) as client:
        print("Connected!")

        # Wrap client to log all writes
        debug = DebugClient(client)

        # Subscribe to notifications
        await client.start_notify(SOLE_NOTIFY, on_notify)
        print("Subscribed to notifications\n")

        print("="*70)
        print("MONITORING ALL BLE TRAFFIC")
        print("="*70)
        print(">>> = Messages WE send")
        print("<<< = Messages treadmill sends")
        print("\nWatching for message loops or excessive sending...")
        print("Press Ctrl+C to stop\n")

        # Send GetDeviceInfo ONCE
        get_info = bytes([0x5B, 0x01, 0xF0, 0x5D])
        await client.write_gatt_char(SOLE_WRITE, get_info)

        # Just wait and monitor
        try:
            for i in range(60):  # Monitor for 60 seconds
                await asyncio.sleep(1)
                if i % 10 == 9:
                    print(f"\n[{i+1}s] Sent: {sent_count}, Received: {received_count}")
        except KeyboardInterrupt:
            pass

        print(f"\n\nFinal counts:")
        print(f"  Messages sent: {sent_count}")
        print(f"  Messages received: {received_count}")
        print(f"  Average send rate: {sent_count/60:.1f} msg/sec")

        if sent_count > 100:
            print("\n⚠️  WARNING: Sent >100 messages - likely a send loop!")

        print("\nDisconnecting...")


if __name__ == "__main__":
    try:
        asyncio.run(main())
    except KeyboardInterrupt:
        print("\nStopped.")
