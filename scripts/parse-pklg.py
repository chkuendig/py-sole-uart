#!/usr/bin/env python3
"""
Parse Apple PacketLogger (.pklg) capture file.
Format: records with [4-byte length][8-byte timestamp][type][data]
"""
import struct
import sys

def parse_pklg(filename: str):
    with open(filename, 'rb') as f:
        data = f.read()

    print(f"File: {filename} ({len(data)} bytes)")
    print("=" * 100)

    offset = 0
    records = []

    while offset < len(data) - 12:
        # Record header: 4-byte length (little-endian)
        rec_len = struct.unpack('<I', data[offset:offset+4])[0]

        if rec_len == 0 or rec_len > 5000:
            offset += 1
            continue

        if offset + 4 + rec_len > len(data):
            break

        # Get the record data
        rec_data = data[offset+4:offset+4+rec_len]
        records.append((offset, rec_len, rec_data))
        offset += 4 + rec_len

    print(f"Found {len(records)} records\n")

    # Look for ATT/GATT data in records
    # ATT PDUs: opcode (1 byte) + handle (2 bytes) + data
    att_opcodes = {
        0x01: "ERR_RSP",
        0x02: "MTU_REQ",
        0x03: "MTU_RSP",
        0x04: "FIND_INFO_REQ",
        0x05: "FIND_INFO_RSP",
        0x08: "READ_BY_TYPE_REQ",
        0x09: "READ_BY_TYPE_RSP",
        0x0a: "READ_REQ",
        0x0b: "READ_RSP",
        0x10: "READ_BY_GRP_REQ",
        0x11: "READ_BY_GRP_RSP",
        0x12: "WRITE_REQ",
        0x13: "WRITE_RSP",
        0x1b: "HANDLE_VALUE_NTF",
        0x1d: "HANDLE_VALUE_IND",
        0x52: "WRITE_CMD",
    }

    # Sole protocol
    sole_msg_types = {
        0x00: "ACK", 0x02: "SetWorkoutMode", 0x03: "WorkoutMode",
        0x04: "WorkoutTarget", 0x06: "WorkoutData", 0x07: "UserProfile",
        0x08: "Program", 0x09: "HeartRateType", 0x10: "ErrorCode",
        0x11: "Speed", 0x12: "Incline", 0xF0: "DeviceInfo", 0xF1: "Command",
    }

    print("=== Records with potential BLE/ATT data ===\n")

    sole_messages = []

    for idx, (offset, rec_len, rec_data) in enumerate(records):
        # Skip header/metadata records (usually at the start)
        if rec_len < 10:
            continue

        # Look for patterns in the record
        rec_hex = rec_data.hex()

        # Search for Sole message framing within the record
        for i in range(len(rec_data) - 4):
            if rec_data[i] == 0x5b:  # Potential Sole message start
                msg_len = rec_data[i+1] if i+1 < len(rec_data) else 0
                end_pos = i + msg_len + 2
                if msg_len > 0 and msg_len < 30 and end_pos < len(rec_data):
                    if rec_data[end_pos] == 0x5d:
                        sole_msg = rec_data[i:end_pos+1]
                        msg_type = rec_data[i+2] if i+2 < len(rec_data) else 0
                        type_name = sole_msg_types.get(msg_type, f"0x{msg_type:02x}")
                        sole_messages.append((idx, i, sole_msg, type_name))

        # Also look for FTMS Treadmill Data characteristic (0x2ACD)
        # It would appear after ATT notify/indicate
        if b'\x1b' in rec_data or b'\x52' in rec_data or b'\x12' in rec_data:
            # Print records with ATT-like opcodes
            if len(rec_hex) < 200:
                # Check for 0x5b anywhere
                if b'\x5b' in rec_data:
                    print(f"[{idx:4d}] len={rec_len:3d} offset=0x{offset:06x}")
                    print(f"       {rec_hex[:120]}...")

    print("\n" + "=" * 100)
    print(f"=== Found {len(sole_messages)} Sole protocol messages ===\n")

    for idx, i, msg, type_name in sole_messages:
        print(f"  Record {idx}, offset {i}: {type_name:20s} {msg.hex()}")

    if not sole_messages:
        print("No Sole UART protocol messages found in capture.")
        print("\nThis could mean:")
        print("  1. The Sole+ app uses FTMS instead of proprietary UART")
        print("  2. The capture doesn't include the GATT data layer")
        print("  3. Different encoding/encryption is used")

        # Let's look for any patterns that might be commands
        print("\n=== Looking for command-like patterns ===\n")
        for idx, (offset, rec_len, rec_data) in enumerate(records):
            # Look for small writes that could be controls
            if 8 < rec_len < 30:
                # Skip if mostly zeros
                if rec_data.count(b'\x00') < rec_len * 0.7:
                    print(f"[{idx:4d}] len={rec_len:3d}: {rec_data.hex()}")


def main():
    filename = sys.argv[1] if len(sys.argv) > 1 else "sole.pklg"
    parse_pklg(filename)


if __name__ == "__main__":
    main()
