#!/usr/bin/env python3
"""
Read Device Information from Sole F65 Treadmill

Reads from BOTH:
1. Standard BLE Device Information Service (0x180A)
2. Sole proprietary DeviceInfo (0xF0) command

This helps us understand what data is available for pyftms integration.
"""

import asyncio
import sys
from bleak import BleakClient, BleakScanner

# Sole F65 MAC address
DEVICE_MAC = "F5:C0:00:03:BE:69"

# Standard BLE Device Information Service (DIS)
DIS_SERVICE_UUID = "0000180a-0000-1000-8000-00805f9b34fb"
DIS_CHARACTERISTICS = {
    "manufacturer_name": "00002a29-0000-1000-8000-00805f9b34fb",
    "model_number": "00002a24-0000-1000-8000-00805f9b34fb",
    "serial_number": "00002a25-0000-1000-8000-00805f9b34fb",
    "hardware_revision": "00002a27-0000-1000-8000-00805f9b34fb",
    "firmware_revision": "00002a26-0000-1000-8000-00805f9b34fb",
    "software_revision": "00002a28-0000-1000-8000-00805f9b34fb",
    "system_id": "00002a23-0000-1000-8000-00805f9b34fb",
    "pnp_id": "00002a50-0000-1000-8000-00805f9b34fb",
}

# Sole proprietary service
SOLE_SERVICE_UUID = "49535343-fe7d-4ae5-8fa9-9fafd205e455"
SOLE_WRITE_UUID = "49535343-8841-43f4-a8d4-ecbe34729bb3"
SOLE_NOTIFY_UUID = "49535343-1e4d-4bd9-ba61-23c647249616"

# Other interesting services on Sole
OTHER_SERVICES = {
    "ftms": "00001826-0000-1000-8000-00805f9b34fb",  # Fitness Machine Service
    "user_data": "0000181c-0000-1000-8000-00805f9b34fb",  # User Data Service
    "sole_unknown_1": "49535343-5d82-6099-9348-7aac4d5fbc51",
    "sole_unknown_2": "49535343-c9d0-cc83-a44a-6fe238d06d33",
    "vendor_ffe5": "0000ffe5-0000-1000-8000-00805f9b34fb",
    "vendor_ffb0": "0000ffb0-0000-1000-8000-00805f9b34fb",
    "vendor_f200": "0000f200-0000-1000-8000-00805f9b34fb",
}

# FTMS Characteristics
FTMS_CHARACTERISTICS = {
    "ftms_feature": "00002acc-0000-1000-8000-00805f9b34fb",
    "treadmill_data": "00002acd-0000-1000-8000-00805f9b34fb",
    "training_status": "00002ad3-0000-1000-8000-00805f9b34fb",
    "speed_range": "00002ad4-0000-1000-8000-00805f9b34fb",
    "inclination_range": "00002ad5-0000-1000-8000-00805f9b34fb",
    "control_point": "00002ad9-0000-1000-8000-00805f9b34fb",
    "status": "00002ada-0000-1000-8000-00805f9b34fb",
}

received_data = {}

def notification_handler(sender, data: bytes):
    """Handle notifications from Sole service."""
    print(f"  << [{sender.uuid[-8:]}] {data.hex(' ')}")
    
    if len(data) < 3:
        return
    
    if data[0] != 0x5B or data[-1] != 0x5D:
        return
    
    msg_type = data[2]
    
    # DeviceInfo response (0xF0)
    if msg_type == 0xF0:
        received_data["sole_device_info"] = data
        parse_sole_device_info(data)
    
    # Store other interesting messages
    elif msg_type == 0x03:  # WorkoutMode
        received_data["workout_mode"] = data[3] if len(data) > 3 else None
    elif msg_type == 0x06:  # WorkoutData
        received_data["workout_data"] = data

def parse_sole_device_info(data: bytes):
    """Parse Sole proprietary DeviceInfo response."""
    print("\n=== Sole DeviceInfo (0xF0) ===")
    print(f"Raw: {data.hex(' ')}")
    
    if len(data) < 10:
        print("  (packet too short)")
        return
    
    # Expected format: 5B 08 F0 <model> <version> <units> <maxspeed> <minspeed> <maxincline> <userseg> 5D
    # But my F65 returns more data...
    
    # Let's parse what we can
    payload = data[3:-1]  # Strip frame bytes
    
    print(f"Payload bytes ({len(payload)}): {' '.join(f'{b:02x}' for b in payload)}")
    
    # Try to extract known fields
    if len(payload) >= 1:
        print(f"  Byte 0: {payload[0]:02x} ({payload[0]}) - Model ID?")
    if len(payload) >= 2:
        print(f"  Byte 1: {payload[1]:02x} ({payload[1]}) - Version/Flags?")
    if len(payload) >= 3:
        print(f"  Byte 2: {payload[2]:02x} ({payload[2]}) - Units? (0=metric, 1=imperial)")
    if len(payload) >= 4:
        print(f"  Byte 3: {payload[3]:02x} ({payload[3]}) - Max speed? ({payload[3]/10:.1f} km/h)")
    if len(payload) >= 5:
        print(f"  Byte 4: {payload[4]:02x} ({payload[4]}) - Min speed? ({payload[4]/10:.1f} km/h)")
    if len(payload) >= 6:
        print(f"  Byte 5: {payload[5]:02x} ({payload[5]}) - Max incline? ({payload[5]}%)")
    if len(payload) >= 7:
        print(f"  Byte 6: {payload[6]:02x} ({payload[6]}) - User segment?")
    
    # Print remaining bytes
    for i, b in enumerate(payload[7:], start=7):
        print(f"  Byte {i}: {b:02x} ({b}) - Unknown")

async def read_standard_dis(client: BleakClient):
    """Read Standard BLE Device Information Service."""
    print("\n=== Standard Device Information Service (0x180A) ===")
    
    for name, uuid in DIS_CHARACTERISTICS.items():
        try:
            data = await client.read_gatt_char(uuid)
            if name == "pnp_id":
                # PnP ID is binary, format specially
                print(f"  {name}: {data.hex(' ')} (raw bytes)")
                if len(data) >= 7:
                    vendor_id_src = data[0]
                    vendor_id = int.from_bytes(data[1:3], 'little')
                    product_id = int.from_bytes(data[3:5], 'little')
                    version = int.from_bytes(data[5:7], 'little')
                    print(f"    Vendor ID Source: {vendor_id_src} (1=BT SIG, 2=USB)")
                    print(f"    Vendor ID: {vendor_id:#06x}")
                    print(f"    Product ID: {product_id:#06x}")
                    print(f"    Version: {version}")
            elif name == "system_id":
                print(f"  {name}: {data.hex(' ')} (raw bytes)")
            else:
                try:
                    text = data.decode('utf-8').strip('\x00')
                    print(f"  {name}: '{text}'")
                except:
                    print(f"  {name}: {data.hex(' ')} (raw bytes)")
        except Exception as e:
            print(f"  {name}: <not available> ({e})")

async def read_ftms_characteristics(client: BleakClient):
    """Read FTMS service characteristics."""
    print("\n=== FTMS Service (0x1826) ===")
    
    for name, uuid in FTMS_CHARACTERISTICS.items():
        try:
            data = await client.read_gatt_char(uuid)
            print(f"  {name}: {data.hex(' ')}")
            
            # Parse known formats
            if name == "ftms_feature" and len(data) >= 8:
                machine_features = int.from_bytes(data[0:4], 'little')
                target_features = int.from_bytes(data[4:8], 'little')
                print(f"    Machine Features: {machine_features:#010x}")
                print(f"    Target Features: {target_features:#010x}")
            
            elif name == "speed_range" and len(data) >= 6:
                min_speed = int.from_bytes(data[0:2], 'little') / 100
                max_speed = int.from_bytes(data[2:4], 'little') / 100
                increment = int.from_bytes(data[4:6], 'little') / 100
                print(f"    Min: {min_speed} km/h, Max: {max_speed} km/h, Step: {increment} km/h")
            
            elif name == "inclination_range" and len(data) >= 6:
                min_incl = int.from_bytes(data[0:2], 'little', signed=True) / 10
                max_incl = int.from_bytes(data[2:4], 'little', signed=True) / 10
                increment = int.from_bytes(data[4:6], 'little') / 10
                print(f"    Min: {min_incl}%, Max: {max_incl}%, Step: {increment}%")
                
        except Exception as e:
            print(f"  {name}: <not available> ({e})")

async def enumerate_all_services(client: BleakClient):
    """List all services and characteristics."""
    print("\n=== All Services and Characteristics ===")
    
    for service in client.services:
        print(f"\nService: {service.uuid}")
        print(f"  Description: {service.description}")
        
        for char in service.characteristics:
            props = ", ".join(char.properties)
            print(f"    Char: {char.uuid}")
            print(f"      Properties: {props}")
            print(f"      Description: {char.description}")
            
            # Try to read if readable
            if "read" in char.properties:
                try:
                    data = await client.read_gatt_char(char)
                    # Try to decode as string
                    try:
                        text = data.decode('utf-8').strip('\x00')
                        if text.isprintable() and len(text) > 0:
                            print(f"      Value (str): '{text}'")
                        else:
                            print(f"      Value (hex): {data.hex(' ')}")
                    except:
                        print(f"      Value (hex): {data.hex(' ')}")
                except Exception as e:
                    print(f"      Value: <error: {e}>")

async def request_sole_device_info(client: BleakClient):
    """Request device info via Sole proprietary protocol."""
    print("\n=== Requesting Sole DeviceInfo (0xF0) ===")
    
    # Subscribe to notifications
    await client.start_notify(SOLE_NOTIFY_UUID, notification_handler)
    
    # Send GetDeviceInfo command
    cmd = bytes([0x5B, 0x01, 0xF0, 0x5D])
    print(f"  >> {cmd.hex(' ')}")
    await client.write_gatt_char(SOLE_WRITE_UUID, cmd, response=False)
    
    # Wait for response
    await asyncio.sleep(2.0)
    
    # Try some other info requests
    print("\n=== Trying other info commands ===")
    
    # Try requesting various message types
    info_commands = [
        (0x21, "MaxSpeed"),
        (0x22, "MaxIncline"),
        (0x23, "MaxLevel"),
        (0x10, "ErrorCode"),
    ]
    
    for cmd_id, name in info_commands:
        # Try reading (format: 5B 01 XX 5D)
        cmd = bytes([0x5B, 0x01, cmd_id, 0x5D])
        print(f"\n  Trying {name} ({cmd_id:#04x}): {cmd.hex(' ')}")
        try:
            await client.write_gatt_char(SOLE_WRITE_UUID, cmd, response=False)
            await asyncio.sleep(0.5)
        except Exception as e:
            print(f"    Error: {e}")
    
    await client.stop_notify(SOLE_NOTIFY_UUID)

async def main():
    print(f"Scanning for device {DEVICE_MAC}...")
    
    device = await BleakScanner.find_device_by_address(DEVICE_MAC, timeout=10.0)
    
    if not device:
        print(f"Device {DEVICE_MAC} not found!")
        print("Make sure the treadmill display is on (not in sleep mode)")
        sys.exit(1)
    
    print(f"Found device: {device.name}")
    
    async with BleakClient(device) as client:
        print(f"Connected: {client.is_connected}")
        
        # 1. Read standard Device Information Service
        await read_standard_dis(client)
        
        # 2. Read FTMS characteristics
        await read_ftms_characteristics(client)
        
        # 3. Request Sole proprietary device info
        await request_sole_device_info(client)
        
        # 4. Enumerate all services (verbose)
        print("\n" + "="*60)
        print("FULL SERVICE ENUMERATION")
        print("="*60)
        await enumerate_all_services(client)
        
        # Summary
        print("\n" + "="*60)
        print("SUMMARY - Data for pyftms DeviceInfo")
        print("="*60)
        print("""
pyftms DeviceInfo expects (from DIS 0x180A):
  - manufacturer (0x2A29)
  - model (0x2A24)
  - serial_number (0x2A25)
  - sw_version (0x2A28)
  - hw_version (0x2A27)

Sole also provides via proprietary protocol (0xF0):
  - Model ID (maps to F63/F65/F80/etc)
  - Max/Min Speed
  - Max Incline
  - Units (metric/imperial)
""")

if __name__ == "__main__":
    asyncio.run(main())
