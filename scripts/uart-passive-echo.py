#!/usr/bin/env python3
"""
Passive monitor for SOLE treadmill.
Establishes UART communication but does NOT take control.
Just echoes WorkoutMode and ACKs data messages.
Console should remain in control.
"""
import asyncio
from bleak import BleakClient, BleakScanner

DEVICE_MAC = "F5:C0:00:03:BE:69"
SOLE_SERVICE = "49535343-fe7d-4ae5-8fa9-9fafd205e455"
SOLE_WRITE_CHAR = "49535343-8841-43f4-a8d4-ecbe34729bb3"
SOLE_NOTIFY_CHAR = "49535343-1e4d-4bd9-ba61-23c647249616"

# Message types
MSG_ACK = 0x00
MSG_SET_WORKOUT_MODE = 0x02
MSG_WORKOUT_MODE = 0x03
MSG_WORKOUT_TARGET = 0x04
MSG_WORKOUT_DATA = 0x06
MSG_USER_PROFILE = 0x07
MSG_PROGRAM = 0x08
MSG_HEART_RATE_TYPE = 0x09
MSG_ERROR_CODE = 0x10
MSG_SPEED = 0x11
MSG_INCLINE = 0x12
MSG_END_WORKOUT = 0x32
MSG_DEVICE_INFO = 0xF0

# Workout modes
MODE_OFF = 0x00
MODE_IDLE = 0x01
MODE_START = 0x02  # Command to start
MODE_RUNNING = 0x04
MODE_PAUSE = 0x06
MODE_DONE = 0x07
MODE_DEMO = 0x80

MODE_NAMES = {
    0x00: "OFF",
    0x01: "IDLE", 
    0x02: "START",
    0x04: "RUNNING",
    0x06: "PAUSE",
    0x07: "DONE",
    0x80: "DEMO"
}

def build_command(cmd_id: int, payload: bytes = b"") -> bytes:
    """Build a SOLE protocol command: 0x5B <len> <cmd> [payload] 0x5D"""
    length = 1 + len(payload)
    return bytes([0x5B, length, cmd_id]) + payload + bytes([0x5D])

def build_ack(for_cmd: int) -> bytes:
    """Build ACK for a command: 0x5B 0x04 0x00 <cmd> 'OK' 0x5D"""
    return bytes([0x5B, 0x04, 0x00, for_cmd, ord('O'), ord('K'), 0x5D])

def parse_workout_data(data: bytes):
    """Parse WorkoutData (0x06) message."""
    if len(data) < 17:
        return None
    # Format: 5b 0f 06 <min> <sec> <dist_h> <dist_l> <cal_h> <cal_l> <hr> <speed> <incline> ...
    return {
        'minutes': data[3],
        'seconds': data[4],
        'distance': (data[5] << 8) | data[6],  # in 0.01 mile/km units
        'calories': (data[7] << 8) | data[8],
        'heart_rate': data[9],
        'speed': data[10],  # in 0.1 mph/kmh units
        'incline': data[11],
    }

class PassiveMonitor:
    def __init__(self):
        self.client = None
        self.connected = False
        self.last_workout_mode = None
        
    async def on_notify(self, sender, data: bytes):
        """Handle notifications from treadmill."""
        if len(data) < 3:
            return
            
        msg_type = data[2]
        
        if msg_type == MSG_DEVICE_INFO:
            model = data[3] if len(data) > 3 else 0
            units = "metric" if (data[5] if len(data) > 5 else 0) == 0 else "imperial"
            max_speed = data[6] if len(data) > 6 else 0
            max_incline = data[8] if len(data) > 8 else 0
            print(f"[DEVICE] Model={model}, Units={units}, MaxSpeed={max_speed/10:.1f}, MaxIncline={max_incline}")
            # Echo back the device info (this is the handshake)
            await self.client.write_gatt_char(SOLE_WRITE_CHAR, data)
            print(f"  -> Echoed DeviceInfo")
            
        elif msg_type == MSG_WORKOUT_MODE:
            mode = data[3] if len(data) > 3 else 0
            mode_name = MODE_NAMES.get(mode, f"UNKNOWN(0x{mode:02x})")
            if mode != self.last_workout_mode:
                print(f"[MODE] WorkoutMode changed: {mode_name}")
                self.last_workout_mode = mode
            # CRITICAL: Echo the WorkoutMode message back (not ACK!)
            # This is what treadonme does
            await self.client.write_gatt_char(SOLE_WRITE_CHAR, data)
            
        elif msg_type == MSG_WORKOUT_DATA:
            wd = parse_workout_data(data)
            if wd:
                time_str = f"{wd['minutes']:02d}:{wd['seconds']:02d}"
                print(f"[DATA] Time={time_str}, Distance={wd['distance']/100:.2f}, "
                      f"Speed={wd['speed']/10:.1f}, Incline={wd['incline']}, "
                      f"Calories={wd['calories']}, HR={wd['heart_rate']}")
            # Send ACK for workout data
            ack = build_ack(MSG_WORKOUT_DATA)
            await self.client.write_gatt_char(SOLE_WRITE_CHAR, ack)
            
        elif msg_type == MSG_HEART_RATE_TYPE:
            print(f"[INFO] HeartRateType received")
            ack = build_ack(MSG_HEART_RATE_TYPE)
            await self.client.write_gatt_char(SOLE_WRITE_CHAR, ack)
            
        elif msg_type == MSG_END_WORKOUT:
            print(f"[INFO] EndWorkout received")
            ack = build_ack(MSG_END_WORKOUT)
            await self.client.write_gatt_char(SOLE_WRITE_CHAR, ack)
            
        elif msg_type == MSG_ERROR_CODE:
            error = data[3] if len(data) > 3 else 0
            print(f"[ERROR] ErrorCode: {error}")
            ack = build_ack(MSG_ERROR_CODE)
            await self.client.write_gatt_char(SOLE_WRITE_CHAR, ack)
            
        elif msg_type == MSG_ACK:
            acked = data[3] if len(data) > 3 else 0
            print(f"  <- ACK for 0x{acked:02x}")
            
        else:
            print(f"[???] Unknown message type 0x{msg_type:02x}: {data.hex()}")
            # Try ACK for unknown messages
            ack = build_ack(msg_type)
            await self.client.write_gatt_char(SOLE_WRITE_CHAR, ack)

    async def run(self):
        print(f"Scanning for {DEVICE_MAC}...")
        device = await BleakScanner.find_device_by_address(DEVICE_MAC, timeout=10.0)
        if not device:
            print("Device not found!")
            return
        
        print(f"Found: {device.name}")
        
        async with BleakClient(device) as client:
            self.client = client
            print("Connected!")
            
            # Subscribe to SOLE UART notifications
            await client.start_notify(SOLE_NOTIFY_CHAR, self.on_notify)
            print("Subscribed to SOLE UART")
            
            # Send GetDeviceInfo to initiate communication
            # This tells treadmill we want UART data
            get_info = build_command(MSG_DEVICE_INFO)
            print(f"\nSending GetDeviceInfo: {get_info.hex()}")
            await client.write_gatt_char(SOLE_WRITE_CHAR, get_info)
            
            print("\n=== Passive monitoring (Ctrl+C to stop) ===")
            print("NOTE: Console should remain in control.")
            print("      Start a workout on console to see WorkoutData.")
            print()
            
            try:
                while True:
                    await asyncio.sleep(1)
            except asyncio.CancelledError:
                pass
            
            print("\nDisconnecting...")

async def main():
    monitor = PassiveMonitor()
    try:
        await monitor.run()
    except KeyboardInterrupt:
        print("\nStopped.")

if __name__ == "__main__":
    asyncio.run(main())
