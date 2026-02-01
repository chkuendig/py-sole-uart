#!/usr/bin/env python3
"""
Active listener that initiates SOLE UART communication and listens for data.
Key insight from treadonme: You must send GetDeviceInfo (0xF0) first to start communication.
"""
import asyncio
import struct
from bleak import BleakClient, BleakScanner

MAC = "F5:C0:00:03:BE:69"

# SOLE UART Service
SOLE_SERVICE = "49535343-fe7d-4ae5-8fa9-9fafd205e455"
SOLE_NOTIFY = "49535343-1e4d-4bd9-ba61-23c647249616"  # Read/Notify
SOLE_WRITE = "49535343-8841-43f4-a8d4-ecbe34729bb3"   # Write

# FTMS
FTMS_TREADMILL_DATA = "00002acd-0000-1000-8000-00805f9b34fb"

# Message types
MSG_ACK = 0x00
MSG_SET_WORKOUT_MODE = 0x02
MSG_WORKOUT_MODE = 0x03
MSG_WORKOUT_TARGET = 0x04
MSG_WORKOUT_DATA = 0x06
MSG_USER_PROFILE = 0x07
MSG_PROGRAM = 0x08
MSG_HR_TYPE = 0x09
MSG_DEVICE_INFO = 0xF0
MSG_COMMAND = 0xF1

START_BYTE = 0x5B
END_BYTE = 0x5D


def encode_message(msg_type: int, payload: bytes = b"") -> bytes:
    """Encode a SOLE UART message: 0x5B <length> <type> <payload...> 0x5D"""
    length = 1 + len(payload)  # type + payload
    return bytes([START_BYTE, length, msg_type]) + payload + bytes([END_BYTE])


def build_ack(msg_type: int) -> bytes:
    """Build ACK message for a given message type"""
    # ACK format: 5B 04 00 <type> 4F 4B 5D
    return bytes([START_BYTE, 0x04, MSG_ACK, msg_type, 0x4F, 0x4B, END_BYTE])


def parse_sole_message(data: bytes) -> dict:
    """Parse a SOLE UART message"""
    if len(data) < 4 or data[0] != START_BYTE or data[-1] != END_BYTE:
        return {"type": "unknown", "raw": data.hex()}
    
    length = data[1]
    msg_type = data[2]
    payload = data[3:-1] if len(data) > 4 else b""
    
    result = {"type": msg_type, "length": length, "payload": payload.hex()}
    
    if msg_type == MSG_DEVICE_INFO and len(payload) >= 7:
        result["parsed"] = {
            "model": payload[0],
            "version": payload[1],
            "units": "metric" if payload[2] == 0 else "imperial",
            "max_speed": payload[3],
            "min_speed": payload[4],
            "max_incline": payload[5],
            "user_segment": payload[6] if len(payload) > 6 else 0,
        }
    elif msg_type == MSG_WORKOUT_MODE and len(payload) >= 1:
        modes = {0x01: "IDLE", 0x02: "START", 0x04: "RUNNING", 0x06: "PAUSE", 0x07: "DONE", 0x80: "DEMO"}
        result["parsed"] = {"mode": modes.get(payload[0], f"0x{payload[0]:02X}")}
    elif msg_type == MSG_WORKOUT_DATA and len(payload) >= 14:
        result["parsed"] = {
            "time": f"{payload[0]}:{payload[1]:02d}",
            "distance": (payload[2] << 8 | payload[3]) / 100,  # in miles or km
            "calories": payload[4] << 8 | payload[5],
            "heart_rate": payload[6],
            "speed": payload[7] / 10,  # in mph or km/h
            "incline": payload[8],
            "hr_type": payload[9],
            "interval_time": payload[10],
            "recovery_time": payload[11],
            "program_row": payload[12],
            "program_col": payload[13],
        }
    elif msg_type == MSG_HR_TYPE and len(payload) >= 2:
        result["parsed"] = {"type1": payload[0], "type2": payload[1]}
    elif msg_type == MSG_ACK and len(payload) >= 3:
        result["parsed"] = {"acked_type": f"0x{payload[0]:02X}"}
    
    return result


async def main():
    print(f"Scanning for {MAC}...")
    device = await BleakScanner.find_device_by_address(MAC, timeout=30)
    if not device:
        print("Device not found!")
        return
    
    print(f"Found: {device.name}")
    
    async with BleakClient(device, timeout=30) as client:
        print("Connected!")
        
        # Message queue for ACKing
        ack_queue = asyncio.Queue()
        
        def sole_notification(sender, data: bytearray):
            msg = parse_sole_message(bytes(data))
            msg_type = msg.get("type", -1)
            parsed = msg.get("parsed", {})
            
            type_names = {
                MSG_ACK: "ACK", MSG_WORKOUT_MODE: "WorkoutMode", MSG_WORKOUT_DATA: "WorkoutData",
                MSG_DEVICE_INFO: "DeviceInfo", MSG_HR_TYPE: "HRType", MSG_USER_PROFILE: "UserProfile",
            }
            name = type_names.get(msg_type, f"0x{msg_type:02X}")
            
            if msg_type == MSG_WORKOUT_DATA:
                p = parsed
                print(f"[SOLE] WorkoutData: time={p.get('time')}, dist={p.get('distance'):.2f}, "
                      f"cal={p.get('calories')}, speed={p.get('speed')}, incline={p.get('incline')}, "
                      f"hr={p.get('heart_rate')}")
            elif msg_type == MSG_WORKOUT_MODE:
                print(f"[SOLE] WorkoutMode: {parsed.get('mode')}")
            elif msg_type == MSG_DEVICE_INFO:
                p = parsed
                print(f"[SOLE] DeviceInfo: model={p.get('model')}, units={p.get('units')}, "
                      f"max_speed={p.get('max_speed')}, max_incline={p.get('max_incline')}")
            elif msg_type == MSG_HR_TYPE:
                print(f"[SOLE] HRType: {parsed}")
            else:
                print(f"[SOLE] {name}: {msg}")
            
            # Queue messages that need ACK
            if msg_type in (MSG_WORKOUT_MODE, MSG_WORKOUT_DATA, MSG_HR_TYPE, MSG_DEVICE_INFO):
                asyncio.get_event_loop().call_soon_threadsafe(
                    lambda: ack_queue.put_nowait(msg_type)
                )
        
        def ftms_notification(sender, data: bytearray):
            if len(data) >= 4:
                flags = data[0] | (data[1] << 8)
                if not (flags & 0x01):  # Speed present
                    speed = (data[2] | (data[3] << 8)) / 100
                    print(f"[FTMS] speed={speed:.2f} km/h")
        
        # Subscribe to notifications
        print("\n=== Subscribing to notifications ===")
        await client.start_notify(SOLE_NOTIFY, sole_notification)
        print("Subscribed to SOLE UART")
        
        try:
            await client.start_notify(FTMS_TREADMILL_DATA, ftms_notification)
            print("Subscribed to FTMS Treadmill Data")
        except Exception as e:
            print(f"Could not subscribe to FTMS: {e}")
        
        # ACK handler task
        async def ack_handler():
            while True:
                try:
                    msg_type = await asyncio.wait_for(ack_queue.get(), timeout=0.1)
                    ack = build_ack(msg_type)
                    await client.write_gatt_char(SOLE_WRITE, ack, response=True)
                    print(f"  -> Sent ACK for 0x{msg_type:02X}")
                except asyncio.TimeoutError:
                    pass
                except Exception as e:
                    print(f"ACK error: {e}")
        
        ack_task = asyncio.create_task(ack_handler())
        
        # Send GetDeviceInfo to initiate communication
        print("\n=== Initiating SOLE UART communication ===")
        get_device_info = encode_message(MSG_DEVICE_INFO)
        print(f"Sending GetDeviceInfo: {get_device_info.hex()}")
        await client.write_gatt_char(SOLE_WRITE, get_device_info, response=True)
        
        # Wait for DeviceInfo response
        await asyncio.sleep(1)
        
        print("\n=== Listening for data (Ctrl+C to stop) ===\n")
        
        try:
            while True:
                await asyncio.sleep(1)
        except KeyboardInterrupt:
            print("\nStopping...")
        finally:
            ack_task.cancel()
            try:
                await ack_task
            except asyncio.CancelledError:
                pass


if __name__ == "__main__":
    try:
        asyncio.run(main())
    except KeyboardInterrupt:
        print("\nStopped.")
