#!/usr/bin/env python3
"""
Scan BLE advertisements from Sole treadmill to see what data is broadcast
without requiring a connection.
"""

import asyncio
from bleak import BleakScanner
from bleak.backends.device import BLEDevice
from bleak.backends.scanner import AdvertisementData

TARGET_NAME = "F65"
TARGET_MAC = "F5:C0:00:03:BE:69"

def detection_callback(device: BLEDevice, adv_data: AdvertisementData):
    """Called for each advertisement received."""
    
    # Filter for our device
    if device.address != TARGET_MAC and (device.name and TARGET_NAME not in device.name):
        return
    
    print(f"\n{'='*60}")
    print(f"Device: {device.name} ({device.address})")
    print(f"RSSI: {adv_data.rssi} dBm")
    print(f"{'='*60}")
    
    # Show all available advertisement data
    print(f"\nLocal Name: {adv_data.local_name}")
    print(f"Connectable: {getattr(adv_data, 'connectable', 'N/A')}")
    
    print(f"\nService UUIDs: {adv_data.service_uuids}")
    
    if adv_data.service_data:
        print(f"\nService Data:")
        for uuid, data in adv_data.service_data.items():
            print(f"  {uuid}: {data.hex()} ({len(data)} bytes)")
            # Try to decode
            if len(data) >= 2:
                print(f"    Raw bytes: {' '.join(f'{b:02x}' for b in data)}")
    
    if adv_data.manufacturer_data:
        print(f"\nManufacturer Data:")
        for company_id, data in adv_data.manufacturer_data.items():
            print(f"  Company ID 0x{company_id:04x}: {data.hex()} ({len(data)} bytes)")
            print(f"    Raw bytes: {' '.join(f'{b:02x}' for b in data)}")
            
            # Common company IDs
            companies = {
                0x004C: "Apple",
                0x0006: "Microsoft", 
                0x000D: "Texas Instruments",
                0x0059: "Nordic Semiconductor",
                0x00E0: "Google",
                0x0157: "Microchip Technology",  # MCHP!
            }
            if company_id in companies:
                print(f"    Company: {companies[company_id]}")
    
    # TX Power
    if adv_data.tx_power is not None:
        print(f"\nTX Power: {adv_data.tx_power} dBm")
    
    # Platform-specific data
    if hasattr(adv_data, 'platform_data') and adv_data.platform_data:
        print(f"\nPlatform Data: {adv_data.platform_data}")


async def main():
    print("Scanning for Sole treadmill advertisements...")
    print("(Make sure the treadmill display is ON)")
    print("Press Ctrl+C to stop\n")
    
    scanner = BleakScanner(detection_callback=detection_callback)
    
    try:
        await scanner.start()
        # Run for 60 seconds or until interrupted
        await asyncio.sleep(60)
    except asyncio.CancelledError:
        pass
    finally:
        await scanner.stop()


if __name__ == "__main__":
    try:
        asyncio.run(main())
    except KeyboardInterrupt:
        print("\n\nScan stopped.")
