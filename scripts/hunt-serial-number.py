#!/usr/bin/env python3
"""
Hunt for the actual serial number on Sole F65

Possible locations:
1. Other Sole proprietary services
2. Vendor-specific services (0xFFxx)
3. User Data Service
4. Hidden in a different message type
5. Maybe it's just the MAC address...
"""

import asyncio
import sys
from bleak import BleakClient, BleakScanner

DEVICE_MAC = "F5:C0:00:03:BE:69"

# Sole proprietary UUIDs
SOLE_WRITE_UUID = "49535343-8841-43f4-a8d4-ecbe34729bb3"
SOLE_NOTIFY_UUID = "49535343-1e4d-4bd9-ba61-23c647249616"

# Unknown Sole services from enumeration
SOLE_UNKNOWN_1 = "49535343-c9d0-cc83-a44a-6fe238d06d33"
SOLE_UNKNOWN_1_CHAR = "49535343-aca3-481c-91ec-d85e28a60318"

SOLE_UNKNOWN_2 = "49535343-5d82-6099-9348-7aac4d5fbc51"  
SOLE_UNKNOWN_2_CHAR = "49535343-026e-3a9b-954c-97daef17e26e"

# Extra characteristic on main Sole service
SOLE_EXTRA_CHAR = "49535343-4c8a-39b3-2f49-511cff073b7e"

# Vendor services
VENDOR_FFB0_CHAR = "0000ffb1-0000-1000-8000-00805f9b34fb"
VENDOR_FFE5_WRITE = "0000ffe9-0000-1000-8000-00805f9b34fb"
VENDOR_FFE5_NOTIFY = "0000ffe0-0000-1000-8000-00805f9b34fb"
VENDOR_F200_CHAR = "0000f202-0000-1000-8000-00805f9b34fb"

received_responses = []

def make_handler(name):
    def handler(sender, data: bytes):
        print(f"  << [{name}] {data.hex(' ')}")
        try:
            text = data.decode('utf-8', errors='replace')
            if text.isprintable():
                print(f"     ASCII: '{text}'")
        except:
            pass
        received_responses.append((name, data))
    return handler

async def main():
    print("="*60)
    print("Hunting for Serial Number on Sole F65")
    print("="*60)
    
    device = await BleakScanner.find_device_by_address(DEVICE_MAC, timeout=10.0)
    if not device:
        print("Device not found!")
        sys.exit(1)
    
    print(f"Found: {device.name}")
    
    async with BleakClient(device) as client:
        print(f"Connected: {client.is_connected}\n")
        
        # 1. Check if serial might be derived from MAC
        print("-"*60)
        print("1. MAC Address as Serial Number")
        print("-"*60)
        mac_clean = DEVICE_MAC.replace(":", "")
        print(f"   MAC: {DEVICE_MAC}")
        print(f"   MAC (no colons): {mac_clean}")
        print(f"   Last 6 chars: {mac_clean[-6:]}")
        # The F5:C0:00:03:BE:69 -> last part 03BE69 could be serial
        print(f"   Last 3 bytes as decimal: {int(mac_clean[-6:], 16)}")
        
        # 2. Try reading the vendor-specific characteristic (0xF200/0xF202)
        print("\n" + "-"*60)
        print("2. Vendor Service 0xF200")
        print("-"*60)
        try:
            data = await client.read_gatt_char(VENDOR_F200_CHAR)
            print(f"   0xF202: {data.hex(' ')}")
            try:
                print(f"   ASCII: '{data.decode('utf-8', errors='replace')}'")
            except:
                pass
        except Exception as e:
            print(f"   Error: {e}")
        
        # 3. Subscribe to all notify characteristics and probe
        print("\n" + "-"*60)
        print("3. Probing Sole Protocol for Serial")
        print("-"*60)
        
        await client.start_notify(SOLE_NOTIFY_UUID, make_handler("sole_main"))
        
        # Try various message types that might contain serial info
        probe_commands = [
            (0xF0, "DeviceInfo"),
            (0x00, "ACK/Info?"),
            (0x10, "ErrorCode"),
            (0x11, "Speed"),
            (0x12, "Incline"),
            (0x20, "TargetHR"),
            (0x21, "MaxSpeed"),
            (0x22, "MaxIncline"),
            (0x24, "UserSpeed?"),
            (0x25, "UserIncline"),
            (0x32, "EndWorkout"),
            (0x40, "ProgramGraphics"),
            (0xF2, "Unknown F2"),
            (0xF3, "Unknown F3"),
            (0xF4, "Unknown F4"),
            (0xF5, "Unknown F5"),
        ]
        
        for cmd, name in probe_commands:
            msg = bytes([0x5B, 0x01, cmd, 0x5D])
            print(f"\n   Trying {name} ({cmd:#04x}): {msg.hex(' ')}")
            try:
                await client.write_gatt_char(SOLE_WRITE_UUID, msg, response=False)
                await asyncio.sleep(0.3)
            except Exception as e:
                print(f"   Error: {e}")
        
        await client.stop_notify(SOLE_NOTIFY_UUID)
        
        # 4. Try the unknown Sole services
        print("\n" + "-"*60)
        print("4. Unknown Sole Service 1 (0x...c9d0...)")
        print("-"*60)
        try:
            await client.start_notify(SOLE_UNKNOWN_1_CHAR, make_handler("sole_unk1"))
            # Try writing something
            await client.write_gatt_char(SOLE_UNKNOWN_1_CHAR, bytes([0x00]), response=False)
            await asyncio.sleep(0.5)
            await client.stop_notify(SOLE_UNKNOWN_1_CHAR)
        except Exception as e:
            print(f"   Error: {e}")
        
        print("\n" + "-"*60)
        print("5. Unknown Sole Service 2 (0x...5d82...)")
        print("-"*60)
        try:
            await client.start_notify(SOLE_UNKNOWN_2_CHAR, make_handler("sole_unk2"))
            await client.write_gatt_char(SOLE_UNKNOWN_2_CHAR, bytes([0x00]), response=False)
            await asyncio.sleep(0.5)
            await client.stop_notify(SOLE_UNKNOWN_2_CHAR)
        except Exception as e:
            print(f"   Error: {e}")
        
        # 5. Try the extra Sole characteristic
        print("\n" + "-"*60)
        print("6. Extra Sole Characteristic (0x...4c8a...)")
        print("-"*60)
        try:
            await client.start_notify(SOLE_EXTRA_CHAR, make_handler("sole_extra"))
            # Try the DeviceInfo command on this one
            await client.write_gatt_char(SOLE_EXTRA_CHAR, bytes([0x5B, 0x01, 0xF0, 0x5D]), response=False)
            await asyncio.sleep(0.5)
            await client.stop_notify(SOLE_EXTRA_CHAR)
        except Exception as e:
            print(f"   Error: {e}")
        
        # 6. Check vendor FFB0/FFB1
        print("\n" + "-"*60)
        print("7. Vendor Service 0xFFB0")
        print("-"*60)
        try:
            await client.start_notify(VENDOR_FFB0_CHAR, make_handler("ffb0"))
            await client.write_gatt_char(VENDOR_FFB0_CHAR, bytes([0x00]), response=False)
            await asyncio.sleep(0.5)
            await client.stop_notify(VENDOR_FFB0_CHAR)
        except Exception as e:
            print(f"   Error: {e}")
        
        # 7. Check vendor FFE5
        print("\n" + "-"*60)
        print("8. Vendor Service 0xFFE5 (JL chip?)")
        print("-"*60)
        try:
            await client.start_notify(VENDOR_FFE5_NOTIFY, make_handler("ffe5"))
            await client.write_gatt_char(VENDOR_FFE5_WRITE, bytes([0x00]), response=False)
            await asyncio.sleep(0.5)
            await client.stop_notify(VENDOR_FFE5_NOTIFY)
        except Exception as e:
            print(f"   Error: {e}")
        
        # Summary
        print("\n" + "="*60)
        print("SUMMARY")
        print("="*60)
        
        print(f"\nReceived {len(received_responses)} responses:")
        for name, data in received_responses:
            print(f"  [{name}] {data.hex(' ')}")
        
        print(f"""
Conclusions:
- Standard DIS serial_number (0x2A25) = '00' (placeholder)
- MAC address: {DEVICE_MAC}
- MAC last 3 bytes: {mac_clean[-6:]} = {int(mac_clean[-6:], 16)}

If serial number isn't in protocol, options for unique_id:
1. Use MAC address (most reliable)
2. Use MAC last 6 chars: {mac_clean[-6:].lower()}
3. Use model + MAC: f65_{mac_clean[-6:].lower()}
""")

if __name__ == "__main__":
    asyncio.run(main())
