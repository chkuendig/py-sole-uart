#!/usr/bin/env python3
"""
Detect Sole/Dyaco treadmills with incomplete FTMS implementation.

This script demonstrates the two-phase detection approach:
1. Pre-connection: Check advertisement data (manufacturer ID, device name)
2. Post-connection: Check for Sole UART service and FTMS characteristics
"""
import asyncio
from bleak import BleakScanner, BleakClient
from bleak.backends.device import BLEDevice
from bleak.backends.scanner import AdvertisementData

# Service UUIDs
FTMS_SERVICE = "00001826-0000-1000-8000-00805f9b34fb"
SOLE_UART_SERVICE = "49535343-fe7d-4ae5-8fa9-9fafd205e455"

# Standard BLE Service UUIDs (16-bit UUIDs in 128-bit form)
SERVICE_NAMES = {
    # Standard Bluetooth SIG services
    "00001800-0000-1000-8000-00805f9b34fb": "Generic Access",
    "00001801-0000-1000-8000-00805f9b34fb": "Generic Attribute",
    "0000180a-0000-1000-8000-00805f9b34fb": "Device Information",
    "0000180d-0000-1000-8000-00805f9b34fb": "Heart Rate",
    "0000180f-0000-1000-8000-00805f9b34fb": "Battery Service",
    "00001810-0000-1000-8000-00805f9b34fb": "Blood Pressure",
    "00001816-0000-1000-8000-00805f9b34fb": "Cycling Speed and Cadence",
    "00001818-0000-1000-8000-00805f9b34fb": "Cycling Power",
    "00001826-0000-1000-8000-00805f9b34fb": "Fitness Machine (FTMS)",
    # Sole/ISSC/Microchip proprietary
    "49535343-fe7d-4ae5-8fa9-9fafd205e455": "Sole UART (ISSC Transparent)",
    "49535343-5d82-6099-9348-7aac4d5fbc51": "Sole Unknown 1",
    "49535343-c9d0-cc83-a44a-6fe238d06d33": "Sole Unknown 2",
    # Nordic UART (common in fitness devices)
    "6e400001-b5a3-f393-e0a9-e50e24dcca9e": "Nordic UART Service",
}

# Sole UART Characteristics
SOLE_UART_CHARACTERISTICS = {
    "49535343-8841-43f4-a8d4-ecbe34729bb3": "Sole Write (TX to treadmill)",
    "49535343-1e4d-4bd9-ba61-23c647249616": "Sole Notify (RX from treadmill)",
    "49535343-4c8a-39b3-2f49-511cff073b7e": "Sole Extra (unknown)",
    "49535343-aca3-481c-91ec-d85e28a60318": "Sole Unknown Char 1",
    "49535343-026e-3a9b-954c-97daef17e26e": "Sole Unknown Char 2",
}

# Device Information Service characteristics
DIS_CHARACTERISTICS = {
    "00002a29-0000-1000-8000-00805f9b34fb": "Manufacturer Name",
    "00002a24-0000-1000-8000-00805f9b34fb": "Model Number",
    "00002a25-0000-1000-8000-00805f9b34fb": "Serial Number",
    "00002a27-0000-1000-8000-00805f9b34fb": "Hardware Revision",
    "00002a26-0000-1000-8000-00805f9b34fb": "Firmware Revision",
    "00002a28-0000-1000-8000-00805f9b34fb": "Software Revision",
    "00002a23-0000-1000-8000-00805f9b34fb": "System ID",
    "00002a50-0000-1000-8000-00805f9b34fb": "PnP ID",
}

# FTMS Characteristics for device type detection
# Format: uuid -> (human_name, device_type_or_None)
FTMS_CHARACTERISTICS = {
    "00002acc-0000-1000-8000-00805f9b34fb": ("Fitness Machine Feature", None),
    "00002acd-0000-1000-8000-00805f9b34fb": ("Treadmill Data", "treadmill"),
    "00002ace-0000-1000-8000-00805f9b34fb": ("Cross Trainer Data", "cross_trainer"),
    "00002acf-0000-1000-8000-00805f9b34fb": ("Step Climber Data", "step_climber"),
    "00002ad0-0000-1000-8000-00805f9b34fb": ("Stair Climber Data", "stair_climber"),
    "00002ad1-0000-1000-8000-00805f9b34fb": ("Rower Data", "rower"),
    "00002ad2-0000-1000-8000-00805f9b34fb": ("Indoor Bike Data", "indoor_bike"),
    "00002ad3-0000-1000-8000-00805f9b34fb": ("Training Status", None),
    "00002ad4-0000-1000-8000-00805f9b34fb": ("Supported Speed Range", None),
    "00002ad5-0000-1000-8000-00805f9b34fb": ("Supported Inclination Range", None),
    "00002ad6-0000-1000-8000-00805f9b34fb": ("Supported Resistance Range", None),
    "00002ad7-0000-1000-8000-00805f9b34fb": ("Supported Heart Rate Range", None),
    "00002ad8-0000-1000-8000-00805f9b34fb": ("Supported Power Range", None),
    "00002ad9-0000-1000-8000-00805f9b34fb": ("Fitness Machine Control Point", None),
    "00002ada-0000-1000-8000-00805f9b34fb": ("Fitness Machine Status", None),
}

# Detection constants
MICROCHIP_COMPANY_ID = 0x0157
SOLE_NAME_PREFIXES = ("F63", "F65", "F80", "F85", "TT8", "E25", "E35", "E55", "E95")

# Known BLE company IDs
COMPANY_IDS = {
    0x004C: "Apple",
    0x0006: "Microsoft",
    0x000D: "Texas Instruments",
    0x0059: "Nordic Semiconductor",
    0x00E0: "Google",
    0x0157: "Microchip Technology",
}


def check_advertisement(name: str | None, manufacturer_data: dict | None) -> tuple[bool, str]:
    """
    Check advertisement data for Sole indicators.
    Returns (is_likely_sole, reason).
    """
    reasons = []

    # Check manufacturer ID
    if manufacturer_data:
        for company_id in manufacturer_data.keys():
            if company_id == MICROCHIP_COMPANY_ID:
                reasons.append(f"Microchip manufacturer ID (0x{company_id:04x})")

    # Check device name
    if name:
        for prefix in SOLE_NAME_PREFIXES:
            if name.startswith(prefix):
                reasons.append(f"Name matches Sole pattern '{prefix}*'")
                break

    if reasons:
        return True, "; ".join(reasons)
    return False, "No Sole indicators found"


async def scan_ftms_devices(timeout: float = 10.0) -> list[tuple[BLEDevice, AdvertisementData]]:
    """Scan for devices advertising FTMS service or with Microchip manufacturer ID."""
    print(f"Scanning for FTMS devices ({timeout}s)...")
    print("=" * 60)

    ftms_devices = []
    seen_addresses = set()

    def detection_callback(device: BLEDevice, adv_data: AdvertisementData):
        # Avoid duplicate processing
        if device.address in seen_addresses:
            return

        # Check if device advertises FTMS service
        service_uuids = [str(u).lower() for u in (adv_data.service_uuids or [])]
        has_ftms = FTMS_SERVICE.lower() in service_uuids

        # Check for Microchip manufacturer ID
        has_microchip = False
        manufacturer_info = ""
        if adv_data.manufacturer_data:
            for company_id, data in adv_data.manufacturer_data.items():
                company_name = COMPANY_IDS.get(company_id, "Unknown")
                manufacturer_info = f"Manufacturer: 0x{company_id:04x} ({company_name})"
                if company_id == MICROCHIP_COMPANY_ID:
                    has_microchip = True

        # Include device if it has FTMS OR Microchip manufacturer ID
        if has_ftms or has_microchip:
            seen_addresses.add(device.address)
            ftms_devices.append((device, adv_data))

            name = device.name or adv_data.local_name or "Unknown"
            reasons = []
            if has_ftms:
                reasons.append("FTMS service")
            if has_microchip:
                reasons.append("Microchip manufacturer")

            print(f"\nFound: {name} ({device.address})")
            print(f"  Reason: {', '.join(reasons)}")
            if manufacturer_info:
                print(f"  {manufacturer_info}")
            print(f"  Services: {adv_data.service_uuids or 'None'}")

    scanner = BleakScanner(detection_callback=detection_callback)
    await scanner.start()
    await asyncio.sleep(timeout)
    await scanner.stop()

    return ftms_devices


async def analyze_device(device: BLEDevice, adv_data: AdvertisementData) -> dict:
    """Analyze a device's advertisement data and connect to check services."""
    result = {
        "address": device.address,
        "name": device.name or adv_data.local_name,
        "rssi": adv_data.rssi,
        "advertisement": {},
        "pre_connection_sole_check": {},
        "post_connection": {},
    }

    print(f"\n{'=' * 60}")
    print(f"Analyzing: {result['name']} ({device.address})")
    print(f"RSSI: {adv_data.rssi} dBm")
    print("=" * 60)

    # === Pre-connection analysis ===
    print("\n--- Advertisement Data (Pre-Connection) ---")

    # Service UUIDs
    print(f"\nService UUIDs: {adv_data.service_uuids or 'None'}")
    result["advertisement"]["service_uuids"] = list(adv_data.service_uuids or [])

    # Manufacturer data
    print(f"\nManufacturer Data:")
    if adv_data.manufacturer_data:
        for company_id, data in adv_data.manufacturer_data.items():
            company_name = COMPANY_IDS.get(company_id, "Unknown")
            print(f"  Company ID 0x{company_id:04x} ({company_name}): {data.hex()}")
            result["advertisement"]["manufacturer_data"] = {
                "company_id": company_id,
                "company_name": company_name,
                "data": data.hex(),
            }
    else:
        print("  None")
        result["advertisement"]["manufacturer_data"] = None

    # Service data
    print(f"\nService Data:")
    if adv_data.service_data:
        for uuid, data in adv_data.service_data.items():
            print(f"  {uuid}: {data.hex()}")
        result["advertisement"]["service_data"] = {
            str(k): v.hex() for k, v in adv_data.service_data.items()
        }
    else:
        print("  None")
        result["advertisement"]["service_data"] = None

    # Pre-connection Sole check
    is_likely_sole, reason = check_advertisement(
        result["name"], adv_data.manufacturer_data
    )
    print(f"\n--- Pre-Connection Sole Check ---")
    print(f"Likely Sole device: {is_likely_sole}")
    print(f"Reason: {reason}")
    result["pre_connection_sole_check"] = {
        "is_likely_sole": is_likely_sole,
        "reason": reason,
    }

    # === Post-connection analysis ===
    if not is_likely_sole:
        print(f"\nSkipping connection (not likely a Sole device)")
        return result

    print(f"\n--- Connecting for Post-Connection Analysis ---")
    try:
        async with BleakClient(device, timeout=10.0) as client:
            print(f"Connected: {client.is_connected}")

            # Get all services
            services = client.services
            service_uuids = [str(s.uuid).lower() for s in services]

            print(f"\nDiscovered Services ({len(service_uuids)}):")
            for svc in services:
                svc_uuid = str(svc.uuid).lower()
                svc_name = SERVICE_NAMES.get(svc_uuid, "Unknown")
                print(f"  {svc.uuid} - {svc_name}")

            result["post_connection"]["services"] = service_uuids

            # Check for Sole UART service
            has_sole_uart = SOLE_UART_SERVICE.lower() in service_uuids
            has_ftms = FTMS_SERVICE.lower() in service_uuids

            print(f"\n--- Post-Connection Sole Check ---")
            print(f"Has FTMS service: {has_ftms}")
            print(f"Has Sole UART service: {has_sole_uart}")

            is_sole_incomplete_ftms = has_ftms and has_sole_uart
            print(f"Is Sole with incomplete FTMS: {is_sole_incomplete_ftms}")

            result["post_connection"]["has_ftms"] = has_ftms
            result["post_connection"]["has_sole_uart"] = has_sole_uart
            result["post_connection"]["is_sole_incomplete_ftms"] = is_sole_incomplete_ftms

            # Check FTMS characteristics for device type
            if has_ftms:
                ftms_service = services.get_service(FTMS_SERVICE)
                if ftms_service:
                    print(f"\n--- FTMS Characteristics ---")
                    device_type = None
                    chars_found = []

                    for char in ftms_service.characteristics:
                        char_uuid = str(char.uuid).lower()
                        props = ", ".join(char.properties)
                        if char_uuid in FTMS_CHARACTERISTICS:
                            name, dtype = FTMS_CHARACTERISTICS[char_uuid]
                            chars_found.append(name)
                            type_indicator = f" -> Device Type: {dtype}" if dtype else ""
                            print(f"  {char.uuid}")
                            print(f"    {name} [{props}]{type_indicator}")
                            if dtype:
                                device_type = dtype
                        else:
                            print(f"  {char.uuid}")
                            print(f"    Unknown FTMS Characteristic [{props}]")

                    result["post_connection"]["ftms_characteristics"] = chars_found
                    result["post_connection"]["device_type_from_chars"] = device_type
                    print(f"\nDevice type (from characteristic presence): {device_type or 'Unknown'}")
                    print(f"  Note: Sole exposes multiple data chars - need to check which actually sends data")

                    # Check which data characteristics actually send notifications
                    print(f"\n--- Testing Which Data Characteristics Actually Work ---")
                    print(f"  (Subscribing to each and waiting for data...)")

                    data_characteristics = {
                        "00002acd-0000-1000-8000-00805f9b34fb": "Treadmill",
                        "00002ace-0000-1000-8000-00805f9b34fb": "Cross Trainer",
                        "00002acf-0000-1000-8000-00805f9b34fb": "Step Climber",
                        "00002ad0-0000-1000-8000-00805f9b34fb": "Stair Climber",
                        "00002ad1-0000-1000-8000-00805f9b34fb": "Rower",
                        "00002ad2-0000-1000-8000-00805f9b34fb": "Indoor Bike",
                    }

                    received_data = {}

                    def make_handler(char_type: str):
                        def handler(sender, data):
                            if char_type not in received_data:
                                received_data[char_type] = data
                                print(f"    ✓ {char_type} Data received: {data.hex()[:40]}...")
                        return handler

                    # Subscribe to all data characteristics that exist
                    subscribed = []
                    for char_uuid, char_type in data_characteristics.items():
                        try:
                            char = ftms_service.get_characteristic(char_uuid)
                            if char and "notify" in char.properties:
                                await client.start_notify(char, make_handler(char_type))
                                subscribed.append((char_uuid, char_type))
                                print(f"  Subscribed to {char_type} Data ({char_uuid[:8]}...)")
                        except Exception as e:
                            pass  # Characteristic doesn't exist or can't subscribe

                    if subscribed:
                        # Test Control Point - does it respond to Request Control?
                        print(f"\n  Testing Control Point...")
                        cp_response = []

                        def cp_callback(sender, data):
                            cp_response.append(data)
                            print(f"    ✓ Control Point response: {data.hex()}")

                        try:
                            cp_uuid = "00002ad9-0000-1000-8000-00805f9b34fb"
                            cp_char = ftms_service.get_characteristic(cp_uuid)
                            if cp_char:
                                # Subscribe to indications first
                                await client.start_notify(cp_uuid, cp_callback)
                                print(f"    Subscribed to Control Point indications")
                                await asyncio.sleep(0.2)

                                # Send Request Control (0x00)
                                await client.write_gatt_char(cp_char, bytes([0x00]))
                                print(f"    Sent Request Control (0x00)")
                                await asyncio.sleep(0.5)

                                if not cp_response:
                                    print(f"    ✗ No response to Request Control")

                                await client.stop_notify(cp_uuid)
                            else:
                                print(f"    Control Point characteristic not found")
                        except Exception as e:
                            print(f"    Control Point error: {e}")

                        # Wait for data
                        print(f"\n  Waiting 5s for notifications...")
                        await asyncio.sleep(5.0)

                        # Unsubscribe
                        for char_uuid, char_type in subscribed:
                            try:
                                await client.stop_notify(char_uuid)
                            except:
                                pass

                        # Report results
                        print(f"\n  Results:")
                        if received_data:
                            actual_types = list(received_data.keys())
                            print(f"    Data received from: {', '.join(actual_types)}")
                            result["post_connection"]["actual_device_type"] = actual_types[0] if len(actual_types) == 1 else actual_types
                        else:
                            print(f"    No data received from any characteristic")
                            print(f"    (Treadmill may be in standby/demo mode)")
                            result["post_connection"]["actual_device_type"] = None
                    else:
                        print(f"  No data characteristics available to subscribe")

                    # Read all readable FTMS characteristics
                    print(f"\n--- FTMS Characteristic Values ---")
                    for char in ftms_service.characteristics:
                        char_uuid = str(char.uuid).lower()
                        if "read" in char.properties:
                            try:
                                data = await client.read_gatt_char(char)
                                char_name = FTMS_CHARACTERISTICS.get(char_uuid, ("Unknown", None))[0]
                                print(f"\n  {char_name} ({char.uuid}):")
                                print(f"    Raw: {data.hex()}")

                                # Parse specific characteristics
                                if char_uuid == "00002acc-0000-1000-8000-00805f9b34fb":
                                    # FTMS Feature
                                    if len(data) >= 4:
                                        features = int.from_bytes(data[0:4], "little")
                                        print(f"    Features: 0x{features:08x}")
                                        if features == 0:
                                            print(f"    -> All zeros (typical of Sole incomplete FTMS)")
                                        else:
                                            # Decode feature bits
                                            feature_bits = [
                                                (0, "Avg Speed"), (1, "Cadence"), (2, "Total Distance"),
                                                (3, "Inclination"), (4, "Elevation Gain"), (5, "Pace"),
                                                (6, "Step Count"), (7, "Resistance"), (8, "Stride Count"),
                                                (9, "Expended Energy"), (10, "Heart Rate"), (11, "Metabolic Equiv"),
                                                (12, "Elapsed Time"), (13, "Remaining Time"), (14, "Power"),
                                                (15, "Force on Belt"), (16, "User Data Retention"),
                                            ]
                                            supported = [name for bit, name in feature_bits if features & (1 << bit)]
                                            if supported:
                                                print(f"    Supported: {', '.join(supported)}")
                                        result["post_connection"]["ftms_features"] = f"0x{features:08x}"
                                    if len(data) >= 8:
                                        targets = int.from_bytes(data[4:8], "little")
                                        print(f"    Target Settings: 0x{targets:08x}")

                                elif char_uuid == "00002ad4-0000-1000-8000-00805f9b34fb":
                                    # Supported Speed Range
                                    if len(data) >= 6:
                                        min_speed = int.from_bytes(data[0:2], "little") / 100.0
                                        max_speed = int.from_bytes(data[2:4], "little") / 100.0
                                        increment = int.from_bytes(data[4:6], "little") / 100.0
                                        print(f"    Min: {min_speed:.2f} km/h")
                                        print(f"    Max: {max_speed:.2f} km/h")
                                        print(f"    Increment: {increment:.2f} km/h")

                                elif char_uuid == "00002ad5-0000-1000-8000-00805f9b34fb":
                                    # Supported Inclination Range
                                    if len(data) >= 6:
                                        min_incline = int.from_bytes(data[0:2], "little", signed=True) / 10.0
                                        max_incline = int.from_bytes(data[2:4], "little", signed=True) / 10.0
                                        increment = int.from_bytes(data[4:6], "little") / 10.0
                                        print(f"    Min: {min_incline:.1f}%")
                                        print(f"    Max: {max_incline:.1f}%")
                                        print(f"    Increment: {increment:.1f}%")

                                elif char_uuid == "00002ad6-0000-1000-8000-00805f9b34fb":
                                    # Supported Resistance Range
                                    if len(data) >= 6:
                                        min_res = int.from_bytes(data[0:2], "little", signed=True) / 10.0
                                        max_res = int.from_bytes(data[2:4], "little", signed=True) / 10.0
                                        increment = int.from_bytes(data[4:6], "little") / 10.0
                                        print(f"    Min: {min_res:.1f}")
                                        print(f"    Max: {max_res:.1f}")
                                        print(f"    Increment: {increment:.1f}")

                                elif char_uuid == "00002ad7-0000-1000-8000-00805f9b34fb":
                                    # Supported Heart Rate Range
                                    if len(data) >= 3:
                                        min_hr = data[0]
                                        max_hr = data[1]
                                        increment = data[2]
                                        print(f"    Min: {min_hr} bpm")
                                        print(f"    Max: {max_hr} bpm")
                                        print(f"    Increment: {increment} bpm")

                                elif char_uuid == "00002ad8-0000-1000-8000-00805f9b34fb":
                                    # Supported Power Range
                                    if len(data) >= 6:
                                        min_power = int.from_bytes(data[0:2], "little", signed=True)
                                        max_power = int.from_bytes(data[2:4], "little", signed=True)
                                        increment = int.from_bytes(data[4:6], "little")
                                        print(f"    Min: {min_power} W")
                                        print(f"    Max: {max_power} W")
                                        print(f"    Increment: {increment} W")

                            except Exception as e:
                                char_name = FTMS_CHARACTERISTICS.get(char_uuid, ("Unknown", None))[0]
                                print(f"\n  {char_name}: Could not read ({e})")

            # If Sole UART service exists, list its characteristics
            if has_sole_uart:
                sole_service = services.get_service(SOLE_UART_SERVICE)
                if sole_service:
                    print(f"\n--- Sole UART Characteristics ---")
                    for char in sole_service.characteristics:
                        char_uuid = str(char.uuid).lower()
                        char_name = SOLE_UART_CHARACTERISTICS.get(char_uuid, "Unknown")
                        props = ", ".join(char.properties)
                        print(f"  {char.uuid}")
                        print(f"    Name: {char_name}")
                        print(f"    Properties: [{props}]")

            # Try to read Device Information Service
            dis_uuid = "0000180a-0000-1000-8000-00805f9b34fb"
            if dis_uuid in service_uuids:
                dis_service = services.get_service(dis_uuid)
                if dis_service:
                    print(f"\n--- Device Information ---")
                    for char_uuid, char_name in DIS_CHARACTERISTICS.items():
                        try:
                            char = dis_service.get_characteristic(char_uuid)
                            if char:
                                value = await client.read_gatt_char(char)
                                # Try to decode as string
                                try:
                                    value_str = value.decode("utf-8").rstrip("\x00")
                                except:
                                    value_str = value.hex()
                                print(f"  {char_name}: {value_str}")
                        except Exception:
                            pass  # Characteristic not available

    except Exception as e:
        print(f"Connection failed: {e}")
        result["post_connection"]["error"] = str(e)

    return result


async def main():
    print("Sole/Dyaco FTMS Device Detector")
    print("=" * 60)

    # Scan for FTMS devices
    devices = await scan_ftms_devices(timeout=10.0)

    if not devices:
        print("\nNo FTMS devices found.")
        return

    print(f"\n\nFound {len(devices)} FTMS device(s). Analyzing...\n")

    # Analyze each device
    results = []
    for device, adv_data in devices:
        result = await analyze_device(device, adv_data)
        results.append(result)

    # Summary
    print("\n" + "=" * 60)
    print("SUMMARY")
    print("=" * 60)

    for r in results:
        name = r["name"] or "Unknown"
        addr = r["address"]
        pre_sole = r["pre_connection_sole_check"].get("is_likely_sole", False)
        post_sole = r.get("post_connection", {}).get("is_sole_incomplete_ftms", None)
        device_type = r.get("post_connection", {}).get("device_type", "unknown")

        status = "?"
        if post_sole is True:
            status = "SOLE (confirmed)"
        elif post_sole is False:
            status = "Not Sole"
        elif pre_sole:
            status = "Likely Sole (not connected)"
        else:
            status = "Not Sole"

        print(f"\n{name} ({addr})")
        print(f"  Pre-connection: {'Likely Sole' if pre_sole else 'Not Sole'}")
        print(f"  Post-connection: {status}")
        print(f"  Device type: {device_type}")


if __name__ == "__main__":
    try:
        asyncio.run(main())
    except KeyboardInterrupt:
        print("\n\nInterrupted.")
    except Exception as e:
        print(f"\nError: {e}")
