#!/usr/bin/env python3
"""
Sole F65 Incline Test Script
Tests various approaches to control incline
"""

import asyncio
from datetime import datetime
from bleak import BleakClient

ADDRESS = "F5:C0:00:03:BE:69"
SOLE_SERVICE = "49535343-fe7d-4ae5-8fa9-9fafd205e455"
SOLE_NOTIFY_CHAR = "49535343-1e4d-4bd9-ba61-23c647249616"
SOLE_WRITE_CHAR = "49535343-8841-43f4-a8d4-ecbe34729bb3"

def build_msg(msg_type: int, payload: bytes = b"") -> bytes:
    """Build Sole protocol message."""
    length = 1 + len(payload)
    return bytes([0x5B, length, msg_type]) + payload + bytes([0x5D])

def build_ack(msg_type: int) -> bytes:
    """Build ACK for message type."""
    return bytes([0x5B, 0x04, 0x00, msg_type, ord('O'), ord('K'), 0x5D])

# Messages
MSG_GET_DEVICE_INFO = build_msg(0xF0)
MSG_START = build_msg(0xF1, bytes([0x01]))
MSG_STOP = build_msg(0xF1, bytes([0x06]))
MSG_SPEED_UP = build_msg(0xF1, bytes([0x02]))
MSG_SPEED_DOWN = build_msg(0xF1, bytes([0x03]))
ACK_WORKOUT_DATA = build_ack(0x06)  # ACK for WorkoutData

# Potential incline commands to try
MSG_INCLINE_5 = build_msg(0x12, bytes([0x05]))  # Direct incline 5%
MSG_INCLINE_UP = build_msg(0xF1, bytes([0x04]))  # F1 0x04 - guess for incline up
MSG_INCLINE_DOWN = build_msg(0xF1, bytes([0x05]))  # F1 0x05 - guess for incline down
MSG_INCLINE_25 = build_msg(0x25, bytes([0x05]))  # UserIncline type = 0x25
MSG_MAX_INCLINE = build_msg(0x22, bytes([0x05]))  # MaxIncline type = 0x22


class InclineTester:
    def __init__(self):
        self.client = None
        self.mode = 0x80
        
    def notification_handler(self, sender, data):
        ts = datetime.now().strftime("%H:%M:%S.%f")[:-3]
        if len(data) >= 3 and data[0] == 0x5B and data[-1] == 0x5D:
            msg_type = data[2]
            payload = data[3:-1]
            
            type_names = {
                0x00: "ACK", 0x02: "SetMode", 0x03: "Mode",
                0x06: "WorkoutData", 0x11: "Speed", 0x12: "Incline",
                0xF0: "DeviceInfo", 0xF1: "Command",
            }
            type_name = type_names.get(msg_type, f"0x{msg_type:02x}")
            
            if msg_type == 0x03:
                self.mode = payload[0] if payload else 0
                # Only print mode changes
                print(f"  [Mode: 0x{self.mode:02x}]", end='\r')
            elif msg_type == 0x06:
                # WorkoutData - parse speed/incline
                if len(payload) >= 8:
                    speed = payload[7]  # Index 7 is speed
                    incline = payload[8] if len(payload) > 8 else 0
                    print(f"[{ts}] WorkoutData: speed={speed/10:.1f} km/h, incline={incline}%")
            else:
                print(f"[{ts}] RX {type_name}: {data.hex()}")
    
    async def connect(self):
        print(f"Connecting to {ADDRESS}...")
        self.client = BleakClient(ADDRESS)
        await self.client.connect()
        print(f"Connected!")
        await self.client.start_notify(SOLE_NOTIFY_CHAR, self.notification_handler)
        await asyncio.sleep(0.5)
    
    async def disconnect(self):
        if self.client:
            await self.client.stop_notify(SOLE_NOTIFY_CHAR)
            await self.client.disconnect()
            print("\nDisconnected")
    
    async def send(self, msg: bytes, desc: str, delay: float = 0.4):
        print(f"\n>>> TX {desc}: {msg.hex()}")
        await self.client.write_gatt_char(SOLE_WRITE_CHAR, msg)
        await asyncio.sleep(delay)
    
    async def run_test(self):
        await self.connect()
        
        # 1. Get device info
        await self.send(MSG_GET_DEVICE_INFO, "Get Device Info")
        
        print("\n" + "="*60)
        print("PLEASE NAVIGATE TO MANUAL WORKOUT ON TREADMILL")
        print("Press Enter when ready (or 'q' to quit)...")
        print("="*60)
        
        user = await asyncio.get_event_loop().run_in_executor(None, input)
        if user.strip().lower() == 'q':
            await self.disconnect()
            return
        
        print(f"\nCurrent mode: 0x{self.mode:02x}")
        
        # 2. Start the belt
        print("\n" + "="*60)
        print("SENDING START COMMAND - Belt will move!")
        print("="*60)
        await self.send(MSG_START, "START (0xF1 0x01)")
        
        await asyncio.sleep(2)
        
        # 3. Try incline commands
        print("\n" + "="*60)
        print("TESTING INCLINE COMMANDS")
        print("="*60)
        
        # Test 1: Direct incline 0x12
        print("\n--- Test 1: Direct Incline (0x12) set to 5% ---")
        await self.send(MSG_INCLINE_5, "Set Incline 5% (0x12 0x05)")
        await asyncio.sleep(2)
        
        # Test 2: Direct incline + ACK
        print("\n--- Test 2: Direct Incline + ACK ---")
        await self.send(MSG_INCLINE_5, "Set Incline 5% (0x12 0x05)")
        await self.send(ACK_WORKOUT_DATA, "ACK WorkoutData (0x06)", delay=0.3)
        await asyncio.sleep(2)
        
        # Test 3: UserIncline type 0x25
        print("\n--- Test 3: UserIncline (0x25) ---")
        await self.send(MSG_INCLINE_25, "UserIncline 5% (0x25 0x05)")
        await asyncio.sleep(2)
        
        # Test 4: MaxIncline type 0x22
        print("\n--- Test 4: MaxIncline (0x22) ---")
        await self.send(MSG_MAX_INCLINE, "MaxIncline 5% (0x22 0x05)")
        await asyncio.sleep(2)
        
        # Test 5: F1 commands 0x04/0x05 (guessing incline up/down)
        print("\n--- Test 5: Try F1 0x04 (maybe incline up?) ---")
        await self.send(MSG_INCLINE_UP, "F1 0x04 (incline up?)")
        await asyncio.sleep(2)
        
        print("\n--- Test 6: Try F1 0x05 (maybe incline down?) ---")
        await self.send(MSG_INCLINE_DOWN, "F1 0x05 (incline down?)")
        await asyncio.sleep(2)
        
        # Stop
        print("\n" + "="*60)
        print("STOPPING")
        print("="*60)
        await self.send(MSG_STOP, "STOP (0xF1 0x06)")
        
        await asyncio.sleep(1)
        await self.disconnect()


async def main():
    tester = InclineTester()
    try:
        await tester.run_test()
    except Exception as e:
        print(f"Error: {e}")
        import traceback
        traceback.print_exc()
        if tester.client:
            await tester.disconnect()

if __name__ == "__main__":
    asyncio.run(main())
