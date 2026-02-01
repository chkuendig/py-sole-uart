#!/usr/bin/env python3
"""
Parse Apple PacketLogger capture to extract Sole treadmill BLE data.
Uses the btsnoop library from https://github.com/traviswpeters/btsnoop
"""
import struct
import sys
from btsnoop.btsnoop import btsnoop as bts

# Sole protocol message types
MSG_TYPES = {
    0x00: "ACK", 0x02: "SetWorkoutMode", 0x03: "WorkoutMode",
    0x04: "WorkoutTarget", 0x06: "WorkoutData", 0x07: "UserProfile",
    0x08: "Program", 0x09: "HeartRateType", 0x10: "ErrorCode",
    0x11: "Speed", 0x12: "Incline", 0xF0: "DeviceInfo", 0xF1: "Command",
}

F1_COMMANDS = {0x01: "START", 0x02: "SPEED_UP", 0x03: "SPEED_DOWN",
               0x04: "INCLINE_UP", 0x05: "INCLINE_DOWN", 0x06: "STOP"}

ATT_OPCODES = {
    0x01: "ERR_RSP", 0x02: "MTU_REQ", 0x03: "MTU_RSP",
    0x04: "FIND_INFO_REQ", 0x05: "FIND_INFO_RSP",
    0x08: "READ_BY_TYPE_REQ", 0x09: "READ_BY_TYPE_RSP",
    0x0A: "READ_REQ", 0x0B: "READ_RSP",
    0x10: "READ_BY_GRP_REQ", 0x11: "READ_BY_GRP_RSP",
    0x12: "WRITE_REQ", 0x13: "WRITE_RSP",
    0x1B: "HANDLE_VALUE_NTF", 0x1D: "HANDLE_VALUE_IND",
    0x52: "WRITE_CMD",
}

# FTMS Control Point opcodes (real ones, not CCCD)
FTMS_CP_OPCODES = {
    0x00: "Request Control", 0x01: "Reset",
    0x02: "Set Target Speed", 0x03: "Set Target Inclination",
    0x04: "Set Target Resistance", 0x05: "Set Target Power",
    0x06: "Set Target Heart Rate", 0x07: "Start/Resume",
    0x08: "Stop/Pause", 0x80: "Response Code",
}


def parse_sole_message(data: bytes) -> str:
    """Parse a Sole protocol message."""
    if len(data) < 4 or data[0] != 0x5B or data[-1] != 0x5D:
        return None
    length = data[1]
    if len(data) != length + 3:
        return None
    msg_type = data[2]
    payload = data[3:-1]
    type_name = MSG_TYPES.get(msg_type, f"0x{msg_type:02x}")
    details = ""
    if msg_type == 0xF1 and payload:
        cmd = payload[0]
        details = f" = {F1_COMMANDS.get(cmd, f'0x{cmd:02x}')}"
    elif msg_type == 0x11 and payload:
        details = f" = {payload[0]/10:.1f} km/h"
    elif msg_type == 0x12 and payload:
        details = f" = {payload[0]}%"
    return f"{type_name}{details}"


def parse_ftms_treadmill_data(data: bytes) -> dict:
    """Parse FTMS Treadmill Data characteristic (0x2ACD)."""
    if len(data) < 2:
        return {"raw": data.hex()}

    flags = struct.unpack('<H', data[0:2])[0]
    result = {"flags": flags}
    idx = 2

    # Bit 0: More Data (inverted - 0 means speed present)
    if not (flags & 0x0001) and idx + 2 <= len(data):
        result["speed_kmh"] = struct.unpack('<H', data[idx:idx+2])[0] / 100.0
        idx += 2
    # Bit 1: Average Speed
    if (flags & 0x0002) and idx + 2 <= len(data):
        result["avg_speed_kmh"] = struct.unpack('<H', data[idx:idx+2])[0] / 100.0
        idx += 2
    # Bit 2: Total Distance (3 bytes)
    if (flags & 0x0004) and idx + 3 <= len(data):
        result["distance_m"] = struct.unpack('<I', data[idx:idx+3] + b'\x00')[0]
        idx += 3
    # Bit 3: Inclination + Ramp Angle (2+2 bytes)
    if (flags & 0x0008) and idx + 4 <= len(data):
        result["incline_pct"] = struct.unpack('<h', data[idx:idx+2])[0] / 10.0
        result["ramp_angle"] = struct.unpack('<h', data[idx+2:idx+4])[0] / 10.0
        idx += 4
    # Bit 4: Elevation Gain (2+2 bytes)
    if (flags & 0x0010) and idx + 4 <= len(data):
        idx += 4
    # Bit 5: Instantaneous Pace
    if (flags & 0x0020) and idx + 1 <= len(data):
        idx += 1
    # Bit 6: Average Pace
    if (flags & 0x0040) and idx + 1 <= len(data):
        idx += 1
    # Bit 7: Expended Energy (2+2+1 bytes)
    if (flags & 0x0080) and idx + 5 <= len(data):
        result["total_calories"] = struct.unpack('<H', data[idx:idx+2])[0]
        idx += 5
    # Bit 8: Heart Rate
    if (flags & 0x0100) and idx + 1 <= len(data):
        result["heart_rate"] = data[idx]
        idx += 1
    # Bit 9: Metabolic Equivalent
    if (flags & 0x0200) and idx + 1 <= len(data):
        idx += 1
    # Bit 10: Elapsed Time
    if (flags & 0x0400) and idx + 2 <= len(data):
        result["elapsed_time_s"] = struct.unpack('<H', data[idx:idx+2])[0]
        idx += 2

    return result


def parse_hci_acl(data: bytes):
    """Parse HCI ACL packet and extract ATT data."""
    if len(data) < 5:
        return None, None, None
    handle_flags = struct.unpack('<H', data[0:2])[0]
    conn_handle = handle_flags & 0x0FFF
    acl_len = struct.unpack('<H', data[2:4])[0]
    if len(data) < 4 + acl_len or acl_len < 4:
        return conn_handle, None, None
    l2cap_len = struct.unpack('<H', data[4:6])[0]
    l2cap_cid = struct.unpack('<H', data[6:8])[0]
    if l2cap_cid != 0x0004:  # ATT CID
        return conn_handle, l2cap_cid, None
    att_data = data[8:8+l2cap_len]
    return conn_handle, l2cap_cid, att_data


def main():
    filename = sys.argv[1] if len(sys.argv) > 1 else "sole.btsnoop"

    print(f"Parsing {filename}...")
    print("=" * 100)

    with open(filename, 'rb') as f:
        records = list(bts._read_packetlogger_records(f, pklg_version2=True))

    print(f"Found {len(records)} PacketLogger records\n")

    # Collect all ATT operations
    all_writes = []
    all_notifies = []
    sole_messages = []

    for seq, length, pkt_type, timestamp, data in records:
        if len(data) < 1:
            continue

        hci_type = data[0]
        if hci_type != 0x02 or len(data) <= 5:  # HCI ACL
            continue

        conn_handle, l2cap_cid, att_data = parse_hci_acl(data[1:])
        if not att_data or len(att_data) < 1:
            continue

        att_opcode = att_data[0]

        # WRITE_CMD (0x52), WRITE_REQ (0x12)
        if att_opcode in (0x52, 0x12) and len(att_data) >= 3:
            handle = struct.unpack('<H', att_data[1:3])[0]
            payload = att_data[3:]
            all_writes.append((seq, timestamp, att_opcode, handle, payload))

            # Check for Sole message
            sole_parsed = parse_sole_message(payload)
            if sole_parsed:
                sole_messages.append((seq, "TX", handle, sole_parsed, payload))

        # HANDLE_VALUE_NTF (0x1B)
        elif att_opcode == 0x1B and len(att_data) >= 3:
            handle = struct.unpack('<H', att_data[1:3])[0]
            payload = att_data[3:]
            all_notifies.append((seq, timestamp, handle, payload))

            # Check for Sole message
            sole_parsed = parse_sole_message(payload)
            if sole_parsed:
                sole_messages.append((seq, "RX", handle, sole_parsed, payload))

    # Analyze writes - separate CCCD writes from actual commands
    cccd_writes = []
    command_writes = []

    for seq, ts, opcode, handle, payload in all_writes:
        # CCCD writes are typically 2 bytes: 0100 (enable notify) or 0200 (enable indicate)
        if len(payload) == 2 and payload in (b'\x01\x00', b'\x02\x00', b'\x00\x00'):
            cccd_writes.append((seq, handle, payload))
        elif len(payload) == 1 and payload[0] in (0x00, 0xe9):
            # Single byte might be FTMS Feature read or similar
            cccd_writes.append((seq, handle, payload))
        else:
            command_writes.append((seq, ts, opcode, handle, payload))

    # Analyze notifications - look for FTMS data
    ftms_data = []
    other_notifies = []

    for seq, ts, handle, payload in all_notifies:
        parsed = parse_ftms_treadmill_data(payload)
        if "speed_kmh" in parsed or "incline_pct" in parsed:
            ftms_data.append((seq, handle, parsed, payload))
        else:
            other_notifies.append((seq, handle, payload))

    # Print results
    print("=" * 100)
    print(f"=== CCCD Writes (enabling notifications): {len(cccd_writes)} ===\n")
    handles_enabled = set()
    for seq, handle, payload in cccd_writes:
        handles_enabled.add(handle)
        mode = "notify" if payload == b'\x01\x00' else "indicate" if payload == b'\x02\x00' else payload.hex()
        print(f"[{seq:5d}] handle=0x{handle:04x} enable {mode}")

    print("\n" + "=" * 100)
    print(f"=== Command Writes (actual commands): {len(command_writes)} ===\n")

    for seq, ts, opcode, handle, payload in command_writes:
        op_name = "WRITE_CMD" if opcode == 0x52 else "WRITE_REQ"

        # Try to interpret as FTMS Control Point
        interpretation = ""
        if len(payload) >= 1:
            cp_op = payload[0]
            if cp_op in FTMS_CP_OPCODES:
                interpretation = FTMS_CP_OPCODES[cp_op]
                if cp_op == 0x02 and len(payload) >= 3:  # Set Target Speed
                    speed = struct.unpack('<H', payload[1:3])[0] / 100.0
                    interpretation += f" ({speed:.2f} km/h)"
                elif cp_op == 0x03 and len(payload) >= 3:  # Set Target Inclination
                    incline = struct.unpack('<h', payload[1:3])[0] / 10.0
                    interpretation += f" ({incline:.1f}%)"
                elif cp_op == 0x08 and len(payload) >= 2:  # Stop/Pause
                    param = payload[1]
                    interpretation += f" ({'STOP' if param==1 else 'PAUSE' if param==2 else param})"
                elif cp_op == 0x80 and len(payload) >= 3:  # Response
                    req_op = FTMS_CP_OPCODES.get(payload[1], f"0x{payload[1]:02x}")
                    result = {1:"Success", 2:"Not Supported", 3:"Invalid", 4:"Failed"}.get(payload[2], payload[2])
                    interpretation = f"Response to {req_op}: {result}"

        print(f"[{seq:5d}] {op_name:10s} handle=0x{handle:04x} {interpretation:40s} raw={payload.hex()}")

    print("\n" + "=" * 100)
    print(f"=== Sole Protocol Messages: {len(sole_messages)} ===\n")

    for seq, direction, handle, parsed, raw in sole_messages:
        print(f"[{seq:5d}] {direction} handle=0x{handle:04x} {parsed:40s} raw={raw.hex()}")

    if not sole_messages:
        print("(none found)")

    print("\n" + "=" * 100)
    print(f"=== FTMS Treadmill Data Notifications: {len(ftms_data)} ===\n")

    # Show unique data states
    seen_states = set()
    for seq, handle, parsed, raw in ftms_data:
        state = (parsed.get("speed_kmh", 0), parsed.get("incline_pct", 0))
        if state not in seen_states or len(seen_states) < 20:
            seen_states.add(state)
            parts = []
            if "speed_kmh" in parsed:
                parts.append(f"speed={parsed['speed_kmh']:.2f}km/h")
            if "incline_pct" in parsed:
                parts.append(f"incline={parsed['incline_pct']:.1f}%")
            if "distance_m" in parsed:
                parts.append(f"dist={parsed['distance_m']}m")
            if "elapsed_time_s" in parsed:
                m, s = divmod(parsed['elapsed_time_s'], 60)
                parts.append(f"time={m}:{s:02d}")
            if "total_calories" in parsed:
                parts.append(f"cal={parsed['total_calories']}")
            print(f"[{seq:5d}] handle=0x{handle:04x} {', '.join(parts)}")

    if len(ftms_data) > 20:
        print(f"... and {len(ftms_data) - 20} more similar notifications")

    print("\n" + "=" * 100)
    print(f"=== Other Notifications: {len(other_notifies)} ===\n")

    # Group by handle
    by_handle = {}
    for seq, handle, payload in other_notifies:
        if handle not in by_handle:
            by_handle[handle] = []
        by_handle[handle].append((seq, payload))

    for handle in sorted(by_handle.keys()):
        items = by_handle[handle]
        print(f"Handle 0x{handle:04x}: {len(items)} notifications")
        for seq, payload in items[:3]:
            print(f"  [{seq:5d}] {payload.hex()}")
        if len(items) > 3:
            print(f"  ... and {len(items) - 3} more")

    # Summary
    print("\n" + "=" * 100)
    print("=== Summary ===\n")
    print(f"Total records: {len(records)}")
    print(f"CCCD writes (enable notifications): {len(cccd_writes)}")
    print(f"Command writes: {len(command_writes)}")
    print(f"Sole protocol messages: {len(sole_messages)}")
    print(f"FTMS treadmill data: {len(ftms_data)}")
    print(f"Other notifications: {len(other_notifies)}")
    print(f"\nHandles with notifications enabled: {sorted([f'0x{h:04x}' for h in handles_enabled])}")


if __name__ == "__main__":
    main()
