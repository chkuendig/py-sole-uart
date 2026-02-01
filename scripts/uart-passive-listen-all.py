#!/usr/bin/env python3
"""
Passive listener - subscribes to ALL notify characteristics and prints raw data.
No commands sent, just listens.
"""

import asyncio
from bleak import BleakClient, BleakScanner

ADDRESS = "F5:C0:00:03:BE:69"

# Known characteristics
SOLE_NOTIFY = "49535343-1e4d-4bd9-ba61-23c647249616"
FTMS_TREADMILL_DATA = "00002acd-0000-1000-8000-00805f9b34fb"  # FTMS Treadmill Data

def parse_sole_msg(data: bytes) -> str:
    """Parse Sole protocol message."""
    if len(data) < 3 or data[0] != 0x5B or data[-1] != 0x5D:
        return f"Invalid: {data.hex()}"
    
    msg_type = data[2]
    payload = data[3:-1]
    
    if msg_type == 0x03:  # WorkoutMode
        mode = payload[0] if payload else 0
        mode_names = {0: "OFF", 1: "IDLE", 2: "RUNNING", 3: "FINISHED", 
                      4: "STARTING", 5: "PAUSED", 0x80: "DEMO"}
        return f"WorkoutMode: 0x{mode:02x} ({mode_names.get(mode, '?')})"
    
    elif msg_type == 0x06:  # WorkoutData
        if len(payload) >= 9:
            minute = payload[0]
            second = payload[1]
            dist_hi, dist_lo = payload[2], payload[3]
            distance = ((dist_hi << 8) | dist_lo) / 100.0
            cal_hi, cal_lo = payload[4], payload[5]
            calories = (cal_hi << 8) | cal_lo
            hr = payload[6]
            speed = payload[7] / 10.0
            incline = payload[8]
            return (f"WorkoutData: time={minute}:{second:02d}, speed={speed:.1f}, "
                    f"incline={incline}%, dist={distance:.2f}km, cal={calories}, hr={hr}")
        return f"WorkoutData (short): {payload.hex()}"
    
    elif msg_type == 0xF0:  # DeviceInfo
        if len(payload) >= 6:
            model = payload[0]
            units = payload[2]
            max_speed = payload[3] / 10.0
            min_speed = payload[4] / 10.0
            max_incline = payload[5]
            return (f"DeviceInfo: model={model}, units={'metric' if units==0 else 'imperial'}, "
                    f"speed={min_speed}-{max_speed}km/h, maxIncline={max_incline}%")
        return f"DeviceInfo: {payload.hex()}"
    
    elif msg_type == 0x00:  # ACK
        acked = payload[0] if payload else 0
        return f"ACK for 0x{acked:02x}"
    
    elif msg_type == 0x10:  # ErrorCode
        code = payload[0] if payload else 0
        return f"ErrorCode: {code}"
    
    else:
        return f"Type 0x{msg_type:02x}: {payload.hex()}"


def parse_ftms_treadmill(data: bytes) -> str:
    """Parse FTMS Treadmill Data characteristic."""
    if len(data) < 2:
        return f"FTMS too short: {data.hex()}"
    
    flags = (data[1] << 8) | data[0]
    more_data = flags & 0x01
    
    result = []
    idx = 2
    
    # If More Data bit is NOT set, speed is present
    if not more_data and len(data) >= idx + 2:
        speed = ((data[idx+1] << 8) | data[idx]) / 100.0
        result.append(f"speed={speed:.2f}km/h")
        idx += 2
    
    # Check other flags...
    if flags & 0x02:  # Average Speed
        if len(data) >= idx + 2:
            idx += 2
    if flags & 0x04:  # Total Distance
        if len(data) >= idx + 3:
            dist = data[idx] | (data[idx+1] << 8) | (data[idx+2] << 16)
            result.append(f"dist={dist}m")
            idx += 3
    if flags & 0x08:  # Inclination
        if len(data) >= idx + 4:
            incline = ((data[idx+1] << 8) | data[idx])
            if incline > 32767:
                incline -= 65536
            incline /= 10.0
            result.append(f"incline={incline:.1f}%")
            idx += 4
    if flags & 0x100:  # Heart Rate
        if len(data) >= idx + 1:
            hr = data[idx]
            result.append(f"hr={hr}")
            idx += 1
    
    if not result:
        return f"FTMS flags=0x{flags:04x}: {data.hex()}"
    
    return f"FTMS: {', '.join(result)} (flags=0x{flags:04x}, raw={data.hex()})"


async def main():
    print(f"Scanning for {ADDRESS}...")
    device = await BleakScanner.find_device_by_address(ADDRESS, timeout=10)
    if not device:
        print("Device not found!")
        return
    
    print(f"Found: {device.name}")
    
    def on_sole_notify(sender, data):
        print(f"[SOLE] {parse_sole_msg(data)}")
    
    def on_ftms_notify(sender, data):
        print(f"[FTMS] {parse_ftms_treadmill(data)}")
    
    async with BleakClient(device) as client:
        print(f"Connected!")
        
        # List all services
        print("\n=== Services ===")
        for service in client.services:
            print(f"  {service.uuid}: {service.description}")
            for char in service.characteristics:
                props = ", ".join(char.properties)
                print(f"    {char.uuid}: {props}")
        
        # Subscribe to notifications
        print("\n=== Subscribing to notifications ===")
        
        # SOLE UART
        try:
            await client.start_notify(SOLE_NOTIFY, on_sole_notify)
            print(f"Subscribed to SOLE UART")
        except Exception as e:
            print(f"Failed to subscribe to SOLE: {e}")
        
        # FTMS Treadmill Data
        try:
            await client.start_notify(FTMS_TREADMILL_DATA, on_ftms_notify)
            print(f"Subscribed to FTMS Treadmill Data")
        except Exception as e:
            print(f"Failed to subscribe to FTMS: {e}")
        
        print("\n=== Listening (Ctrl+C to stop) ===\n")
        
        try:
            while True:
                await asyncio.sleep(1)
        except asyncio.CancelledError:
            pass
        
        print("\nDisconnecting...")


if __name__ == "__main__":
    try:
        asyncio.run(main())
    except KeyboardInterrupt:
        print("\nStopped.")
