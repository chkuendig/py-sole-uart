#!/usr/bin/env python3
"""
FTMS-only passive listener for Sole treadmills.
Uses standard FTMS with Sole-specific initialization (0xe9 command).
Does NOT use the proprietary UART protocol - no console lockout!

Based on packet capture analysis of the official Sole+ iOS app.
See PROTOCOL.md for details.
"""
import asyncio
from bleak import BleakClient, BleakScanner

DEVICE_MAC = "F5:C0:00:03:BE:69"

# Standard FTMS characteristics
FTMS_SERVICE = "00001826-0000-1000-8000-00805f9b34fb"
FTMS_FEATURE = "00002acc-0000-1000-8000-00805f9b34fb"
FTMS_TREADMILL_DATA = "00002acd-0000-1000-8000-00805f9b34fb"
FTMS_CONTROL_POINT = "00002ad9-0000-1000-8000-00805f9b34fb"
FTMS_TRAINING_STATUS = "00002ad3-0000-1000-8000-00805f9b34fb"
FTMS_MACHINE_STATUS = "00002ada-0000-1000-8000-00805f9b34fb"
FTMS_INCLINE_RANGE = "00002ad5-0000-1000-8000-00805f9b34fb"
FTMS_SPEED_RANGE = "00002ad4-0000-1000-8000-00805f9b34fb"

# FTMS Control Point opcodes
FTMS_REQUEST_CONTROL = bytes([0x00])  # Standard FTMS
FTMS_SOLE_START = bytes([0xe9])       # Sole-specific (non-standard!)

def parse_ftms_feature(data: bytes) -> dict:
    """Parse FTMS Feature characteristic to see what's supported."""
    if len(data) < 4:
        return {"raw": data.hex()}

    # First 4 bytes: Fitness Machine Features
    features = int.from_bytes(data[0:4], 'little')
    result = {"features_raw": f"0x{features:08x}"}

    feature_bits = [
        (0, "Average Speed"),
        (1, "Cadence"),
        (2, "Total Distance"),
        (3, "Inclination"),
        (4, "Elevation Gain"),
        (5, "Pace"),
        (6, "Step Count"),
        (7, "Resistance Level"),
        (8, "Stride Count"),
        (9, "Expended Energy"),
        (10, "Heart Rate"),
        (11, "Metabolic Equivalent"),
        (12, "Elapsed Time"),
        (13, "Remaining Time"),
        (14, "Power Measurement"),
        (15, "Force on Belt"),
        (16, "Power Output"),
    ]

    supported = []
    for bit, name in feature_bits:
        if features & (1 << bit):
            supported.append(name)

    result["supported"] = supported

    # Next 4 bytes (if present): Target Setting Features
    if len(data) >= 8:
        targets = int.from_bytes(data[4:8], 'little')
        result["targets_raw"] = f"0x{targets:08x}"

    return result

def parse_treadmill_data(data: bytes) -> dict:
    """Parse FTMS Treadmill Data characteristic (0x2ACD)"""
    if len(data) < 2:
        return {"raw": data.hex(), "error": "too short"}
    
    # Flags are 16-bit little-endian
    flags = int.from_bytes(data[0:2], 'little')
    result = {"flags": f"0x{flags:04x}", "raw": data.hex()}
    
    idx = 2
    
    # Bit 0: More Data (inverted - 0 means speed present, 1 means not present)
    if not (flags & 0x0001):
        if idx + 2 <= len(data):
            speed_raw = int.from_bytes(data[idx:idx+2], 'little')
            result["speed_kmh"] = speed_raw / 100.0
            idx += 2
    
    # Bit 1: Average Speed Present
    if flags & 0x0002:
        if idx + 2 <= len(data):
            avg_speed_raw = int.from_bytes(data[idx:idx+2], 'little')
            result["avg_speed_kmh"] = avg_speed_raw / 100.0
            idx += 2
    
    # Bit 2: Total Distance Present
    if flags & 0x0004:
        if idx + 3 <= len(data):
            distance_raw = int.from_bytes(data[idx:idx+3], 'little')
            result["distance_m"] = distance_raw
            idx += 3
    
    # Bit 3: Inclination and Ramp Angle Present
    if flags & 0x0008:
        if idx + 4 <= len(data):
            incline_raw = int.from_bytes(data[idx:idx+2], 'little', signed=True)
            ramp_raw = int.from_bytes(data[idx+2:idx+4], 'little', signed=True)
            result["incline_percent"] = incline_raw / 10.0
            result["ramp_angle_deg"] = ramp_raw / 10.0
            idx += 4
    
    # Bit 4: Elevation Gain Present
    if flags & 0x0010:
        if idx + 4 <= len(data):
            pos_elev = int.from_bytes(data[idx:idx+2], 'little')
            neg_elev = int.from_bytes(data[idx+2:idx+4], 'little')
            result["positive_elevation_m"] = pos_elev / 10.0
            result["negative_elevation_m"] = neg_elev / 10.0
            idx += 4
    
    # Bit 5: Instantaneous Pace Present
    if flags & 0x0020:
        if idx + 1 <= len(data):
            pace_raw = data[idx]
            result["pace_km_per_min"] = pace_raw / 10.0  # Actually s/km but simplified
            idx += 1
    
    # Bit 6: Average Pace Present
    if flags & 0x0040:
        if idx + 1 <= len(data):
            avg_pace_raw = data[idx]
            result["avg_pace_km_per_min"] = avg_pace_raw / 10.0
            idx += 1
    
    # Bit 7: Expended Energy Present
    if flags & 0x0080:
        if idx + 5 <= len(data):
            total_energy = int.from_bytes(data[idx:idx+2], 'little')
            energy_per_hour = int.from_bytes(data[idx+2:idx+4], 'little')
            energy_per_min = data[idx+4]
            result["total_calories"] = total_energy
            result["calories_per_hour"] = energy_per_hour
            result["calories_per_min"] = energy_per_min
            idx += 5
    
    # Bit 8: Heart Rate Present
    if flags & 0x0100:
        if idx + 1 <= len(data):
            result["heart_rate"] = data[idx]
            idx += 1
    
    # Bit 9: Metabolic Equivalent Present
    if flags & 0x0200:
        if idx + 1 <= len(data):
            met_raw = data[idx]
            result["metabolic_equivalent"] = met_raw / 10.0
            idx += 1
    
    # Bit 10: Elapsed Time Present
    if flags & 0x0400:
        if idx + 2 <= len(data):
            elapsed_raw = int.from_bytes(data[idx:idx+2], 'little')
            result["elapsed_time_s"] = elapsed_raw
            idx += 2
    
    # Bit 11: Remaining Time Present
    if flags & 0x0800:
        if idx + 2 <= len(data):
            remaining_raw = int.from_bytes(data[idx:idx+2], 'little')
            result["remaining_time_s"] = remaining_raw
            idx += 2
    
    return result

def parse_training_status(data: bytes) -> dict:
    """Parse FTMS Training Status characteristic (0x2AD3)"""
    if len(data) < 1:
        return {"raw": data.hex(), "error": "too short"}
    
    status_map = {
        0x00: "Other",
        0x01: "Idle",
        0x02: "Warming Up",
        0x03: "Low Intensity Interval",
        0x04: "High Intensity Interval",
        0x05: "Recovery Interval",
        0x06: "Isometric",
        0x07: "Heart Rate Control",
        0x08: "Fitness Test",
        0x09: "Speed Outside Control Range (Low)",
        0x0A: "Speed Outside Control Range (High)",
        0x0B: "Cool Down",
        0x0C: "Watt Control",
        0x0D: "Manual Mode (Quick Start)",
        0x0E: "Pre-Workout",
        0x0F: "Post-Workout",
    }
    
    flags = data[0]
    result = {"flags": f"0x{flags:02x}", "raw": data.hex()}
    
    if len(data) >= 2:
        status = data[1]
        result["status"] = status_map.get(status, f"Unknown({status})")
        result["status_code"] = status
    
    return result

async def main():
    print(f"Scanning for {DEVICE_MAC}...")
    device = await BleakScanner.find_device_by_address(DEVICE_MAC, timeout=10.0)
    if not device:
        print("Device not found!")
        return

    print(f"Found: {device.name}")

    async with BleakClient(device) as client:
        print("Connected!")
        print("\n=== FTMS Passive Monitor (Sole+ app compatible) ===")
        print("This uses FTMS only - no console lockout!\n")

        # Read FTMS Feature to see what's supported
        print("Reading FTMS capabilities...")
        try:
            feature_data = await client.read_gatt_char(FTMS_FEATURE)
            features = parse_ftms_feature(feature_data)
            print(f"  Features: {features.get('features_raw', 'unknown')}")
            if "supported" in features:
                print(f"  Supported: {', '.join(features['supported'])}")
        except Exception as e:
            print(f"  Could not read features: {e}")

        # Read incline range if available
        try:
            incline_data = await client.read_gatt_char(FTMS_INCLINE_RANGE)
            if len(incline_data) >= 6:
                min_incline = int.from_bytes(incline_data[0:2], 'little', signed=True) / 10.0
                max_incline = int.from_bytes(incline_data[2:4], 'little', signed=True) / 10.0
                step = int.from_bytes(incline_data[4:6], 'little') / 10.0
                print(f"  Incline range: {min_incline}% to {max_incline}% (step {step}%)")
        except Exception as e:
            print(f"  Incline range not available: {e}")

        print()

        # Callbacks
        def on_treadmill_data(sender, data):
            parsed = parse_treadmill_data(data)
            parts = []
            if "speed_kmh" in parsed:
                parts.append(f"speed={parsed['speed_kmh']:.2f}km/h")
            if "avg_speed_kmh" in parsed:
                parts.append(f"avg={parsed['avg_speed_kmh']:.2f}km/h")
            if "distance_m" in parsed:
                parts.append(f"dist={parsed['distance_m']}m")
            if "incline_percent" in parsed:
                parts.append(f"incline={parsed['incline_percent']:.1f}%")
            if "elapsed_time_s" in parsed:
                mins, secs = divmod(parsed['elapsed_time_s'], 60)
                parts.append(f"time={mins}:{secs:02d}")
            if "total_calories" in parsed:
                parts.append(f"cal={parsed['total_calories']}")
            if "heart_rate" in parsed:
                parts.append(f"hr={parsed['heart_rate']}")

            info = ", ".join(parts) if parts else f"flags={parsed['flags']}"
            # Show raw data for debugging
            print(f"[TREADMILL] {info}  (raw={data.hex()})")

        def on_training_status(sender, data):
            parsed = parse_training_status(data)
            status = parsed.get("status", "unknown")
            print(f"[STATUS]    {status}")

        def on_machine_status(sender, data):
            print(f"[MACHINE]   raw={data.hex()}")

        # Step 1: Subscribe to notifications BEFORE sending commands
        # (This matches what Sole+ app does)
        print("Subscribing to FTMS characteristics...")

        try:
            await client.start_notify(FTMS_TREADMILL_DATA, on_treadmill_data)
            print("  ✓ Treadmill Data")
        except Exception as e:
            print(f"  ✗ Treadmill Data: {e}")

        try:
            await client.start_notify(FTMS_TRAINING_STATUS, on_training_status)
            print("  ✓ Training Status")
        except Exception as e:
            print(f"  ✗ Training Status: {e}")

        try:
            await client.start_notify(FTMS_MACHINE_STATUS, on_machine_status)
            print("  ✓ Machine Status")
        except Exception as e:
            print(f"  ✗ Machine Status: {e}")

        # Step 2: Send FTMS Request Control (standard)
        print("\nSending FTMS initialization...")
        try:
            await client.write_gatt_char(FTMS_CONTROL_POINT, FTMS_REQUEST_CONTROL)
            print("  ✓ Request Control (0x00)")
        except Exception as e:
            print(f"  ✗ Request Control failed: {e}")

        # Step 3: Send Sole-specific start command (non-standard 0xe9)
        try:
            await client.write_gatt_char(FTMS_CONTROL_POINT, FTMS_SOLE_START)
            print("  ✓ Sole Start (0xe9)")
        except Exception as e:
            print(f"  ✗ Sole Start failed: {e}")

        print("\n=== Listening (Ctrl+C to stop) ===\n")

        # Track what we subscribed to for cleanup
        subscribed_chars = [FTMS_TREADMILL_DATA, FTMS_TRAINING_STATUS, FTMS_MACHINE_STATUS]

        try:
            while True:
                await asyncio.sleep(1)
        except KeyboardInterrupt:
            print("\n\nStopping...")
        finally:
            # Properly stop notifications before disconnect
            print("Cleaning up...")
            for char_uuid in subscribed_chars:
                try:
                    await client.stop_notify(char_uuid)
                except Exception:
                    pass  # Ignore errors during cleanup

            # Small delay to let cleanup complete
            await asyncio.sleep(0.5)
            print("Disconnecting...")

        print("Done.")

if __name__ == "__main__":
    try:
        asyncio.run(main())
    except KeyboardInterrupt:
        print("\nInterrupted.")
    except Exception as e:
        print(f"Error: {e}")
    finally:
        print("Exited cleanly.")
