#!/usr/bin/env python3
"""
Parse btsnoop/pklg capture file to extract Sole treadmill BLE protocol messages.
"""
import sys
from btsnoop import btsnoop

# Sole protocol message types
MSG_TYPES = {
    0x00: "ACK",
    0x02: "SetWorkoutMode",
    0x03: "WorkoutMode",
    0x04: "WorkoutTarget",
    0x06: "WorkoutData",
    0x07: "UserProfile",
    0x08: "Program",
    0x09: "HeartRateType",
    0x10: "ErrorCode",
    0x11: "Speed",
    0x12: "Incline",
    0x13: "Level",
    0x14: "RPM",
    0x15: "HeartRate",
    0x20: "TargetHeartRate",
    0x21: "MaxSpeed",
    0x22: "MaxIncline",
    0x23: "MaxLevel",
    0x25: "UserIncline",
    0x27: "UserLevel",
    0x32: "EndWorkout",
    0x40: "ProgramGraphics",
    0xF0: "DeviceInfo",
    0xF1: "Command",
}

F1_COMMANDS = {
    0x01: "START",
    0x02: "SPEED_UP",
    0x03: "SPEED_DOWN",
    0x04: "INCLINE_UP",
    0x05: "INCLINE_DOWN",
    0x06: "STOP",
}

WORKOUT_MODES = {
    0x00: "OFF",
    0x01: "IDLE",
    0x02: "START/RUNNING",
    0x04: "RUNNING",
    0x06: "PAUSE",
    0x07: "DONE",
    0x80: "DEMO",
}


def parse_sole_message(data: bytes) -> str:
    """Parse a Sole protocol message."""
    if len(data) < 4:
        return f"Too short: {data.hex()}"

    if data[0] != 0x5B or data[-1] != 0x5D:
        return f"Invalid framing: {data.hex()}"

    length = data[1]
    msg_type = data[2]
    payload = data[3:-1]

    type_name = MSG_TYPES.get(msg_type, f"Unknown(0x{msg_type:02x})")
    details = ""

    if msg_type == 0x00:  # ACK
        if payload:
            acked = payload[0]
            acked_name = MSG_TYPES.get(acked, f"0x{acked:02x}")
            details = f" for {acked_name}"

    elif msg_type == 0x03:  # WorkoutMode
        if payload:
            mode = payload[0]
            mode_name = WORKOUT_MODES.get(mode, f"0x{mode:02x}")
            details = f" = {mode_name}"

    elif msg_type == 0x06:  # WorkoutData
        if len(payload) >= 9:
            minute, second = payload[0], payload[1]
            distance = (payload[2] << 8) | payload[3]
            calories = (payload[4] << 8) | payload[5]
            hr, speed, incline = payload[6], payload[7], payload[8]
            details = f" time={minute}:{second:02d} speed={speed/10:.1f} incline={incline}% dist={distance/100:.2f} cal={calories} hr={hr}"

    elif msg_type == 0x11:  # Speed
        if payload:
            details = f" = {payload[0]/10:.1f} km/h"

    elif msg_type == 0x12:  # Incline
        if payload:
            details = f" = {payload[0]}%"

    elif msg_type == 0xF0:  # DeviceInfo
        if len(payload) >= 6:
            model, version, units = payload[0], payload[1], payload[2]
            max_speed, min_speed, max_incline = payload[3], payload[4], payload[5]
            details = f" model={model} units={'metric' if units==0 else 'imperial'} speed={min_speed/10:.1f}-{max_speed/10:.1f} maxIncline={max_incline}%"

    elif msg_type == 0xF1:  # Command
        if payload:
            cmd = payload[0]
            cmd_name = F1_COMMANDS.get(cmd, f"0x{cmd:02x}")
            details = f" = {cmd_name}"

    elif msg_type == 0x02:  # SetWorkoutMode
        if payload:
            mode = payload[0]
            mode_name = WORKOUT_MODES.get(mode, f"0x{mode:02x}")
            details = f" = {mode_name}"

    elif msg_type == 0x07:  # UserProfile
        if len(payload) >= 5:
            sex, age = payload[0], payload[1]
            weight = (payload[2] << 8) | payload[3]
            height = payload[4]
            sex_name = {1: "Male", 2: "Female"}.get(sex, f"{sex}")
            details = f" sex={sex_name} age={age} weight={weight/10:.1f}kg height={height}in"

    elif msg_type == 0x08:  # Program
        if len(payload) >= 2:
            prog = (payload[0] << 8) | payload[1]
            prog_names = {0x1001: "Manual", 0x2002: "Hill", 0x2003: "FatBurn",
                          0x2004: "Cardio", 0x2005: "Strength", 0x2006: "Interval"}
            details = f" = {prog_names.get(prog, f'0x{prog:04x}')}"

    return f"{type_name}{details}"


def find_sole_messages(data: bytes):
    """Find all Sole protocol messages in raw data."""
    messages = []
    i = 0
    while i < len(data) - 3:
        if data[i] == 0x5B:  # Start byte
            # Try to find valid message
            for end in range(i + 3, min(i + 50, len(data))):
                if data[end] == 0x5D:  # End byte
                    msg = data[i:end+1]
                    expected_len = msg[1] + 3  # length byte + start + end
                    if len(msg) == expected_len:
                        messages.append((i, msg))
                        i = end + 1
                        break
            else:
                i += 1
        else:
            i += 1
    return messages


def main():
    filename = sys.argv[1] if len(sys.argv) > 1 else "sole.btsnoop"

    print(f"Parsing {filename}...")
    print("=" * 100)

    try:
        records = btsnoop.parse(filename)
    except Exception as e:
        print(f"btsnoop.parse failed: {e}")
        print("Trying raw file parsing...")
        with open(filename, 'rb') as f:
            raw_data = f.read()

        # Find all Sole messages in the raw file
        messages = find_sole_messages(raw_data)
        print(f"Found {len(messages)} Sole messages in raw data:\n")
        for offset, msg in messages:
            parsed = parse_sole_message(msg)
            print(f"[0x{offset:06x}] {parsed:50s} raw={msg.hex()}")
        return

    sole_packets = []

    for i, record in enumerate(records):
        # Extract packet data
        pkt_data = record.data if hasattr(record, 'data') else record

        if isinstance(pkt_data, (bytes, bytearray)):
            # Search for Sole protocol messages
            messages = find_sole_messages(bytes(pkt_data))
            for offset, msg in messages:
                parsed = parse_sole_message(msg)
                sole_packets.append((i, parsed, msg))
                print(f"[{i:4d}] {parsed:50s} raw={msg.hex()}")

    print("=" * 100)
    print(f"\nTotal Sole protocol packets found: {len(sole_packets)}")

    # Summary by message type
    print("\n=== Message Type Summary ===")
    type_counts = {}
    for _, parsed, _ in sole_packets:
        msg_type = parsed.split()[0]
        type_counts[msg_type] = type_counts.get(msg_type, 0) + 1

    for msg_type in sorted(type_counts.keys()):
        print(f"  {msg_type}: {type_counts[msg_type]}")


if __name__ == "__main__":
    main()
