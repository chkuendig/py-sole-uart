#!/usr/bin/env python3
"""
Comprehensive Device Information Comparison

This script reads device information from ALL available sources and compares them:
1. Standard BLE Device Information Service (DIS) - 0x180A
2. Sole Proprietary UART Protocol - Command 0xF0
3. FTMS Service characteristics

Shows what's available from each protocol for Home Assistant integration.

Usage:
    python compare-device-info.py                    # Auto-scan
    python compare-device-info.py -a F5:C0:00:03:BE:69  # Specific device
"""

import argparse
import asyncio
import sys
from bleak import BleakClient, BleakScanner
from bleak.backends.device import BLEDevice

# =============================================================================
# UUIDs
# =============================================================================

# Standard Device Information Service (DIS)
DIS_SERVICE = "0000180a-0000-1000-8000-00805f9b34fb"
DIS_CHARS = {
    "manufacturer_name": "00002a29-0000-1000-8000-00805f9b34fb",
    "model_number": "00002a24-0000-1000-8000-00805f9b34fb",
    "serial_number": "00002a25-0000-1000-8000-00805f9b34fb",
    "hardware_revision": "00002a27-0000-1000-8000-00805f9b34fb",
    "firmware_revision": "00002a26-0000-1000-8000-00805f9b34fb",
    "software_revision": "00002a28-0000-1000-8000-00805f9b34fb",
    "system_id": "00002a23-0000-1000-8000-00805f9b34fb",
    "pnp_id": "00002a50-0000-1000-8000-00805f9b34fb",
}

# FTMS Service
FTMS_SERVICE = "00001826-0000-1000-8000-00805f9b34fb"
FTMS_CHARS = {
    "feature": "00002acc-0000-1000-8000-00805f9b34fb",
    "treadmill_data": "00002acd-0000-1000-8000-00805f9b34fb",
    "indoor_bike_data": "00002ad2-0000-1000-8000-00805f9b34fb",
    "cross_trainer_data": "00002ace-0000-1000-8000-00805f9b34fb",
    "training_status": "00002ad3-0000-1000-8000-00805f9b34fb",
    "speed_range": "00002ad4-0000-1000-8000-00805f9b34fb",
    "incline_range": "00002ad5-0000-1000-8000-00805f9b34fb",
    "control_point": "00002ad9-0000-1000-8000-00805f9b34fb",
    "status": "00002ada-0000-1000-8000-00805f9b34fb",
}

# Sole UART Service
SOLE_SERVICE = "49535343-fe7d-4ae5-8fa9-9fafd205e455"
SOLE_WRITE = "49535343-8841-43f4-a8d4-ecbe34729bb3"
SOLE_NOTIFY = "49535343-1e4d-4bd9-ba61-23c647249616"

# Device name prefixes for auto-scan
DEVICE_PREFIXES = [
    "SOLE", "Sole", "SPIRIT", "Spirit", "XTERRA", "Xterra", "FUEL", "Fuel",
    "E25", "E35", "E55", "E95", "F63", "F65", "F80", "F85",
    "B94", "R92", "LCB", "LCR", "TT8", "S77", "XT",
]

# Model number to name mapping (from PROTOCOL.md)
SOLE_MODELS = {
    144: "F63", 145: "F65", 146: "F80", 147: "F85", 148: "S77", 149: "TT8",
    16: "B74", 17: "R72", 18: "B94", 19: "R92", 20: "LCB", 21: "LCR",
    22: "E25", 23: "E35", 24: "E55", 25: "E95", 26: "E98", 27: "E95s",
}

# =============================================================================
# Data Collection
# =============================================================================

class DeviceInfoCollector:
    """Collects device information from all available sources."""

    def __init__(self):
        self.dis_data = {}
        self.ftms_data = {}
        self.uart_data = {}
        self.uart_response = None
        self.mac_address = None

    async def collect_dis(self, client: BleakClient):
        """Collect Standard Device Information Service data."""
        print("\n📋 Reading Device Information Service (DIS)...")

        for name, uuid in DIS_CHARS.items():
            try:
                data = await client.read_gatt_char(uuid)

                # Parse based on characteristic type
                if name == "pnp_id" and len(data) >= 7:
                    vendor_src = data[0]
                    vendor_id = int.from_bytes(data[1:3], 'little')
                    product_id = int.from_bytes(data[3:5], 'little')
                    version = int.from_bytes(data[5:7], 'little')
                    self.dis_data[name] = {
                        "raw": data.hex(),
                        "vendor_src": "BT SIG" if vendor_src == 1 else "USB" if vendor_src == 2 else f"Unknown({vendor_src})",
                        "vendor_id": f"0x{vendor_id:04X}",
                        "product_id": f"0x{product_id:04X}",
                        "version": version,
                    }
                elif name == "system_id" and len(data) == 8:
                    # System ID is 8 bytes: manufacturer (5) + organizationally unique (3)
                    self.dis_data[name] = {
                        "raw": data.hex(),
                        "hex": data.hex().upper(),
                    }
                else:
                    # Try to decode as string
                    try:
                        text = data.decode('utf-8').strip('\x00')
                        self.dis_data[name] = text if text else data.hex()
                    except:
                        self.dis_data[name] = data.hex()

                print(f"  ✓ {name}")
            except Exception as e:
                self.dis_data[name] = None
                print(f"  ✗ {name}: {e}")

    async def collect_ftms(self, client: BleakClient):
        """Collect FTMS service data."""
        print("\n🏃 Reading FTMS Service...")

        for name, uuid in FTMS_CHARS.items():
            try:
                data = await client.read_gatt_char(uuid)

                # Parse based on characteristic
                if name == "feature" and len(data) >= 8:
                    machine_features = int.from_bytes(data[0:4], 'little')
                    target_features = int.from_bytes(data[4:8], 'little')

                    # Parse feature bits
                    features = []
                    feature_bits = [
                        (0, "Average Speed"), (1, "Cadence"), (2, "Total Distance"),
                        (3, "Inclination"), (4, "Elevation Gain"), (5, "Pace"),
                        (6, "Step Count"), (7, "Resistance Level"), (8, "Stride Count"),
                        (9, "Expended Energy"), (10, "Heart Rate"), (11, "Metabolic Equivalent"),
                        (12, "Elapsed Time"), (13, "Remaining Time"), (14, "Power Measurement"),
                        (15, "Force on Belt"), (16, "Power Output"),
                    ]
                    for bit, desc in feature_bits:
                        if machine_features & (1 << bit):
                            features.append(desc)

                    self.ftms_data[name] = {
                        "raw": data.hex(),
                        "machine_features": f"0x{machine_features:08X}",
                        "target_features": f"0x{target_features:08X}",
                        "features": features,
                    }

                elif name == "speed_range" and len(data) >= 6:
                    min_speed = int.from_bytes(data[0:2], 'little') / 100
                    max_speed = int.from_bytes(data[2:4], 'little') / 100
                    increment = int.from_bytes(data[4:6], 'little') / 100
                    self.ftms_data[name] = {
                        "raw": data.hex(),
                        "min": f"{min_speed:.1f} km/h",
                        "max": f"{max_speed:.1f} km/h",
                        "step": f"{increment:.1f} km/h",
                    }

                elif name == "incline_range" and len(data) >= 6:
                    min_incline = int.from_bytes(data[0:2], 'little', signed=True) / 10
                    max_incline = int.from_bytes(data[2:4], 'little', signed=True) / 10
                    increment = int.from_bytes(data[4:6], 'little') / 10
                    self.ftms_data[name] = {
                        "raw": data.hex(),
                        "min": f"{min_incline:.1f}%",
                        "max": f"{max_incline:.1f}%",
                        "step": f"{increment:.1f}%",
                    }
                else:
                    self.ftms_data[name] = {"raw": data.hex()}

                print(f"  ✓ {name}")
            except Exception as e:
                self.ftms_data[name] = None
                print(f"  ✗ {name}: {e}")

    async def collect_uart(self, client: BleakClient):
        """Collect Sole UART protocol device info."""
        print("\n🔧 Reading Sole UART Device Info (0xF0)...")

        # Set up notification handler
        response_received = asyncio.Event()

        def notification_handler(sender, data: bytes):
            if len(data) >= 3 and data[0] == 0x5B and data[-1] == 0x5D:
                if data[2] == 0xF0:  # DeviceInfo response
                    self.uart_response = bytes(data)
                    response_received.set()

        # Subscribe to notifications
        await client.start_notify(SOLE_NOTIFY, notification_handler)

        # Send GetDeviceInfo command
        cmd = bytes([0x5B, 0x01, 0xF0, 0x5D])
        await client.write_gatt_char(SOLE_WRITE, cmd, response=False)
        print(f"  >> Sent: {cmd.hex()}")

        # Wait for response (with timeout)
        try:
            await asyncio.wait_for(response_received.wait(), timeout=2.0)
            print(f"  << Received: {self.uart_response.hex()}")
            self._parse_uart_response()
        except asyncio.TimeoutError:
            print("  ✗ No response (timeout)")
        finally:
            await client.stop_notify(SOLE_NOTIFY)

    def _parse_uart_response(self):
        """Parse Sole UART DeviceInfo response."""
        if not self.uart_response or len(self.uart_response) < 10:
            return

        # Format: 5B [len] F0 [model] [sales] [units] [maxspd] [minspd] [maxinc] [userseg] ... 5D
        payload = self.uart_response[3:-1]

        if len(payload) >= 1:
            model_id = payload[0]
            model_name = SOLE_MODELS.get(model_id, f"Unknown({model_id})")

            # Determine device type
            if 128 <= model_id < 192:
                device_type = "Treadmill"
            elif model_id in [0, 1, 2, 14, 16, 17, 18, 19, 20, 21, 37, 38, 84, 85, 87, 88, 96, 97]:
                device_type = "Elliptical"
            else:
                device_type = "Bike"

            self.uart_data["model_id"] = model_id
            self.uart_data["model_name"] = model_name
            self.uart_data["device_type"] = device_type

        if len(payload) >= 2:
            sales = payload[1]
            self.uart_data["sales_version"] = "International" if sales == 0 else "US"

        if len(payload) >= 3:
            units = payload[2]
            self.uart_data["units"] = "Metric" if units == 0 else "Imperial"

        if len(payload) >= 4:
            self.uart_data["max_speed"] = f"{payload[3] / 10:.1f} km/h"

        if len(payload) >= 5:
            self.uart_data["min_speed"] = f"{payload[4] / 10:.1f} km/h"

        if len(payload) >= 6:
            self.uart_data["max_incline"] = f"{payload[5]}%"

        if len(payload) >= 7:
            self.uart_data["user_segments"] = payload[6]

        # Store raw for comparison
        self.uart_data["raw"] = self.uart_response.hex()

# =============================================================================
# Display
# =============================================================================

def print_comparison(collector: DeviceInfoCollector, mac: str):
    """Print comprehensive comparison."""

    print("\n" + "=" * 80)
    print(" 📊 DEVICE INFORMATION COMPARISON")
    print("=" * 80)

    # Device Identity
    print("\n┌─ DEVICE IDENTITY " + "─" * 60)
    print("│")

    print("│ MAC Address:")
    print(f"│   {mac}")
    print(f"│   → Unique ID: {mac.replace(':', '').lower()}")
    print(f"│   → Short ID: {mac.replace(':', '')[-6:].lower()}")
    print("│")

    print("│ Model:")
    dis_model = collector.dis_data.get("model_number")
    uart_model = collector.uart_data.get("model_name")
    if dis_model:
        print(f"│   DIS:  {dis_model}")
    if uart_model:
        print(f"│   UART: {uart_model} (ID: {collector.uart_data.get('model_id')})")
        print(f"│   Type: {collector.uart_data.get('device_type')}")
    print("│")

    print("│ Manufacturer:")
    dis_mfr = collector.dis_data.get("manufacturer_name")
    if dis_mfr:
        print(f"│   DIS: {dis_mfr}")
    if "pnp_id" in collector.dis_data and collector.dis_data["pnp_id"]:
        pnp = collector.dis_data["pnp_id"]
        print(f"│   PnP: Vendor {pnp['vendor_id']}, Product {pnp['product_id']}")

    # Versions
    print("\n├─ VERSION INFORMATION " + "─" * 56)
    print("│")

    has_versions = False
    for key in ["serial_number", "hardware_revision", "firmware_revision", "software_revision"]:
        value = collector.dis_data.get(key)
        if value:
            has_versions = True
            label = key.replace("_", " ").title()
            if value == "00" or value == "0000":
                print(f"│ {label:20s}: {value} ⚠️  (placeholder)")
            else:
                print(f"│ {label:20s}: {value}")

    if not has_versions:
        print("│ ⚠️  No version information available from DIS")

    if collector.dis_data.get("system_id"):
        sys_id = collector.dis_data["system_id"]
        print(f"│ System ID:            {sys_id.get('hex', sys_id)}")

    # Capabilities - Speed/Incline
    print("\n├─ CAPABILITIES " + "─" * 62)
    print("│")

    # Speed Range
    uart_min = collector.uart_data.get("min_speed")
    uart_max = collector.uart_data.get("max_speed")
    ftms_speed = collector.ftms_data.get("speed_range")

    if uart_min or uart_max or ftms_speed:
        print("│ Speed Range:")
        if uart_min and uart_max:
            print(f"│   UART: {uart_min} - {uart_max}")
        if ftms_speed:
            print(f"│   FTMS: {ftms_speed['min']} - {ftms_speed['max']} (step: {ftms_speed['step']})")
        print("│")

    # Incline Range
    uart_incline = collector.uart_data.get("max_incline")
    ftms_incline = collector.ftms_data.get("incline_range")

    if uart_incline or ftms_incline:
        print("│ Incline Range:")
        if uart_incline:
            print(f"│   UART: 0% - {uart_incline}")
        if ftms_incline:
            print(f"│   FTMS: {ftms_incline['min']} - {ftms_incline['max']} (step: {ftms_incline['step']})")
        print("│")

    # FTMS Features
    ftms_feature = collector.ftms_data.get("feature")
    if ftms_feature and ftms_feature.get("features"):
        print("│ FTMS Supported Features:")
        features = ftms_feature["features"]
        if features:
            for feat in features:
                print(f"│   ✓ {feat}")
        else:
            print("│   ⚠️  No features reported (FTMS may be incomplete)")
        print("│")

    # Configuration
    print("├─ CONFIGURATION " + "─" * 60)
    print("│")

    if collector.uart_data.get("sales_version"):
        print(f"│ Market:  {collector.uart_data['sales_version']}")
    if collector.uart_data.get("units"):
        print(f"│ Units:   {collector.uart_data['units']}")
    if collector.uart_data.get("user_segments"):
        print(f"│ Program Segments: {collector.uart_data['user_segments']}")

    # Summary for Home Assistant
    print("\n├─ HOME ASSISTANT INTEGRATION SUMMARY " + "─" * 39)
    print("│")

    # Unique ID recommendation
    print("│ Recommended unique_id:")
    short_mac = mac.replace(':', '')[-6:].lower()
    model_prefix = uart_model.lower().replace(" ", "_") if uart_model else "sole"
    print(f"│   Option 1 (MAC):        {mac.replace(':', '').lower()}")
    print(f"│   Option 2 (Short MAC):  {short_mac}")
    print(f"│   Option 3 (Model+MAC):  {model_prefix}_{short_mac}")
    print("│")

    # Available info
    print("│ Device Info Available:")
    print(f"│   Name:              {'✓' if uart_model or dis_model else '✗'} {uart_model or dis_model or 'N/A'}")
    print(f"│   Manufacturer:      {'✓' if dis_mfr else '✗'} {dis_mfr or 'N/A'}")
    print(f"│   Model:             {'✓' if uart_model or dis_model else '✗'} {uart_model or dis_model or 'N/A'}")

    fw = collector.dis_data.get("firmware_revision")
    hw = collector.dis_data.get("hardware_revision")
    sw = collector.dis_data.get("software_revision")

    print(f"│   Firmware Version:  {'✓' if fw and fw != '00' else '✗'} {fw if fw and fw != '00' else 'Not available'}")
    print(f"│   Hardware Version:  {'✓' if hw and hw != '00' else '✗'} {hw if hw and hw != '00' else 'Not available'}")
    print(f"│   Software Version:  {'✓' if sw and sw != '00' else '✗'} {sw if sw and sw != '00' else 'Not available'}")
    print("│")

    # Data sources comparison
    print("│ Live Data Sources:")
    print("│   FTMS (passive):    Speed, HR only")
    print("│   UART (passive):    Speed, Incline, Distance, Calories, HR")
    print("│   UART (active):     Full control + data (⚠️ may lock console)")

    print("\n└" + "─" * 79)

    # Raw data for debugging
    print("\n" + "=" * 80)
    print(" 🔍 RAW DATA (for debugging)")
    print("=" * 80)

    if collector.uart_data.get("raw"):
        print(f"\nUART DeviceInfo (0xF0):")
        print(f"  {collector.uart_data['raw']}")

    if ftms_feature:
        print(f"\nFTMS Features:")
        print(f"  Machine: {ftms_feature['machine_features']}")
        print(f"  Target:  {ftms_feature['target_features']}")

    print()

# =============================================================================
# Main
# =============================================================================

async def scan_devices() -> list[BLEDevice]:
    """Scan for compatible devices."""
    print("🔍 Scanning for devices...")
    devices = []
    seen = set()

    def callback(device: BLEDevice, adv_data):
        if device.address in seen:
            return
        seen.add(device.address)
        name = device.name or adv_data.local_name or ""
        if any(name.startswith(p) for p in DEVICE_PREFIXES):
            devices.append(device)
            print(f"  Found: {name} ({device.address}) RSSI: {adv_data.rssi}")

    scanner = BleakScanner(detection_callback=callback)
    await scanner.start()
    await asyncio.sleep(10.0)
    await scanner.stop()
    return devices

async def main():
    parser = argparse.ArgumentParser(description="Compare device info from all sources")
    parser.add_argument("-a", "--address", help="BLE MAC address to connect to")
    args = parser.parse_args()

    # Find device
    if args.address:
        device = await BleakScanner.find_device_by_address(args.address, timeout=10.0)
        if not device:
            print(f"❌ Device {args.address} not found!")
            print("   Make sure the treadmill display is on (not in sleep mode)")
            sys.exit(1)
    else:
        devices = await scan_devices()
        if not devices:
            print("❌ No compatible devices found!")
            sys.exit(1)
        device = devices[0]
        print(f"\n✓ Using: {device.name} ({device.address})")

    # Connect and collect data
    print(f"\n🔗 Connecting to {device.name}...")

    async with BleakClient(device) as client:
        if not client.is_connected:
            print("❌ Connection failed!")
            sys.exit(1)

        print("✓ Connected!")

        collector = DeviceInfoCollector()
        collector.mac_address = device.address

        # Collect from all sources
        await collector.collect_dis(client)
        await collector.collect_ftms(client)
        await collector.collect_uart(client)

        # Display comparison
        print_comparison(collector, device.address)

if __name__ == "__main__":
    try:
        asyncio.run(main())
    except KeyboardInterrupt:
        print("\n\n⚠️  Interrupted by user")
    except Exception as e:
        print(f"\n❌ Error: {e}")
        import traceback
        traceback.print_exc()
