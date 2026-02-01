#!/usr/bin/env python3
"""
Release control back to treadmill console.
Sends SetWorkoutMode(IDLE) to give control back.
"""
import asyncio
from bleak import BleakClient, BleakScanner

DEVICE_MAC = "F5:C0:00:03:BE:69"
SOLE_WRITE_CHAR = "49535343-8841-43f4-a8d4-ecbe34729bb3"
SOLE_NOTIFY_CHAR = "49535343-1e4d-4bd9-ba61-23c647249616"

def build_command(cmd_id: int, payload: bytes = b"") -> bytes:
    """Build a SOLE protocol command: 0x5B <len> <cmd> [payload] 0x5D"""
    length = 1 + len(payload)  # cmd + payload length
    return bytes([0x5B, length, cmd_id]) + payload + bytes([0x5D])

async def main():
    print(f"Scanning for {DEVICE_MAC}...")
    device = await BleakScanner.find_device_by_address(DEVICE_MAC, timeout=10.0)
    if not device:
        print("Device not found!")
        return
    
    print(f"Found: {device.name}")
    
    async with BleakClient(device) as client:
        print("Connected!")
        
        # Subscribe to notifications first
        def on_notify(sender, data):
            print(f"  <- RX: {data.hex()}")
        
        await client.start_notify(SOLE_NOTIFY_CHAR, on_notify)
        await asyncio.sleep(0.5)
        
        # Try different approaches to release control:
        
        # 1. Send ACK (0x00) - acknowledge any pending messages
        print("\n1. Sending ACK...")
        ack = build_command(0x00)
        print(f"  -> TX: {ack.hex()}")
        await client.write_gatt_char(SOLE_WRITE_CHAR, ack)
        await asyncio.sleep(0.5)
        
        # 2. Set WorkoutMode to IDLE (0x01) - should release BLE control
        print("\n2. Setting WorkoutMode to IDLE (0x01)...")
        set_idle = build_command(0x02, bytes([0x01]))  # SetWorkoutMode(IDLE)
        print(f"  -> TX: {set_idle.hex()}")
        await client.write_gatt_char(SOLE_WRITE_CHAR, set_idle)
        await asyncio.sleep(0.5)
        
        # 3. Set WorkoutMode to OFF (0x00) - completely stop
        print("\n3. Setting WorkoutMode to OFF (0x00)...")
        set_off = build_command(0x02, bytes([0x00]))  # SetWorkoutMode(OFF)
        print(f"  -> TX: {set_off.hex()}")
        await client.write_gatt_char(SOLE_WRITE_CHAR, set_off)
        await asyncio.sleep(0.5)
        
        # 4. Send another ACK
        print("\n4. Sending final ACK...")
        await client.write_gatt_char(SOLE_WRITE_CHAR, ack)
        await asyncio.sleep(0.5)
        
        print("\nDone! Console should be released now.")
        print("If still locked, power cycle the treadmill.")

if __name__ == "__main__":
    asyncio.run(main())
