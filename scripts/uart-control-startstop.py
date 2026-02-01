#!/usr/bin/env python3
"""Test START and STOP - using both F1 commands and SetWorkoutMode"""

import asyncio
from bleak import BleakClient

ADDRESS = "F5:C0:00:03:BE:69"
SOLE_NOTIFY_CHAR = "49535343-1e4d-4bd9-ba61-23c647249616"
SOLE_WRITE_CHAR = "49535343-8841-43f4-a8d4-ecbe34729bb3"

def build_msg(msg_type, payload=b""):
    length = 1 + len(payload)
    return bytes([0x5B, length, msg_type]) + payload + bytes([0x5D])

# Commands (0xF1)
MSG_GET_INFO = build_msg(0xF0)
MSG_CMD_START = build_msg(0xF1, bytes([0x01]))  # CommandTypeStart
MSG_CMD_STOP = build_msg(0xF1, bytes([0x06]))   # CommandTypeStop

# SetWorkoutMode (0x02) - message type, not command!
MSG_MODE_START = build_msg(0x02, bytes([0x02]))   # WorkoutModeStart
MSG_MODE_PAUSE = build_msg(0x02, bytes([0x06]))   # WorkoutModePause  
MSG_MODE_DONE = build_msg(0x02, bytes([0x07]))    # WorkoutModeDone
MSG_MODE_IDLE = build_msg(0x02, bytes([0x01]))    # WorkoutModeIdle

# ACK for WorkoutMode (echo the mode back)
def build_ack_mode(mode):
    return build_msg(0x03, bytes([mode]))

class Tester:
    def __init__(self):
        self.client = None
        self.mode = 0
        self.last_mode = 0
        self.speed = 0
        self.incline = 0
        
    def on_notify(self, sender, data):
        if len(data) >= 3 and data[0] == 0x5B:
            msg_type = data[2]
            payload = data[3:-1]
            
            if msg_type == 0x03:  # WorkoutMode from treadmill
                self.mode = payload[0] if payload else 0
                if self.mode != self.last_mode:
                    mode_names = {0x01: "Idle", 0x02: "Start", 0x04: "Running", 0x06: "Pause", 0x07: "Done", 0x80: "0x80?"}
                    name = mode_names.get(self.mode, f"0x{self.mode:02x}")
                    print(f"\n*** MODE CHANGED: {name} (0x{self.mode:02x}) ***")
                    self.last_mode = self.mode
                    # Echo the mode back (ACK)
                    asyncio.create_task(self.ack_mode(self.mode))
            elif msg_type == 0x06:  # WorkoutData
                if len(payload) >= 9:
                    self.speed = payload[7]
                    self.incline = payload[8]
                print(f"\n  [WorkoutData] Speed:{self.speed/10:.1f} Incline:{self.incline}%")
            elif msg_type == 0x00:  # ACK
                acked = payload[0] if payload else 0
                acked_hi = payload[1] if len(payload) > 1 else 0
                acked_names = {0xF1: "Command", 0x02: "SetWorkoutMode", 0x03: "WorkoutMode"}
                name = acked_names.get(acked, f"0x{acked:02x}")
                print(f"\n  [ACK {name}]")
            elif msg_type == 0x02:  # SetWorkoutMode echo
                mode = payload[0] if payload else 0
                print(f"\n  [SetWorkoutMode Echo] mode=0x{mode:02x}")
            elif msg_type == 0xF0:
                print(f"\n  [DevInfo] {data.hex()}")
            else:
                print(f"\n  [Type 0x{msg_type:02x}] {data.hex()}")
    
    async def ack_mode(self, mode):
        """Echo WorkoutMode back as ACK"""
        ack = build_msg(0x03, bytes([mode]))
        try:
            await self.client.write_gatt_char(SOLE_WRITE_CHAR, ack)
            print(f"  -> ACK'd mode 0x{mode:02x}")
        except:
            pass
    
    async def connect(self):
        print(f"Connecting to {ADDRESS}...")
        self.client = BleakClient(ADDRESS)
        await self.client.connect()
        print("Connected!")
        await self.client.start_notify(SOLE_NOTIFY_CHAR, self.on_notify)
        await asyncio.sleep(0.5)
    
    async def disconnect(self):
        if self.client:
            await self.client.stop_notify(SOLE_NOTIFY_CHAR)
            await self.client.disconnect()
            print("\nDisconnected")
    
    async def send(self, msg, desc):
        print(f"\n>> {desc}: {msg.hex()}")
        await self.client.write_gatt_char(SOLE_WRITE_CHAR, msg)
        await asyncio.sleep(0.5)
    
    async def run(self):
        await self.connect()
        await self.send(MSG_GET_INFO, "Get Device Info")
        await asyncio.sleep(1)
        self.last_mode = self.mode
        
        print("\n" + "="*60)
        print("START/STOP TEST SCRIPT")
        print("="*60)
        print("F1 Commands:")
        print("  s = F1 Start (0x01)")
        print("  x = F1 Stop (0x06)")
        print()
        print("SetWorkoutMode (0x02):")
        print("  1 = Mode Idle (0x01)")
        print("  2 = Mode Start (0x02)")
        print("  6 = Mode Pause (0x06)")
        print("  7 = Mode Done (0x07)")
        print()
        print("q = Quit")
        print("="*60)
        
        loop = asyncio.get_event_loop()
        while True:
            cmd = await loop.run_in_executor(None, lambda: input("\nCmd> ").strip().lower())
            if cmd == 'q': 
                break
            elif cmd == 's': 
                await self.send(MSG_CMD_START, "F1 Start")
            elif cmd == 'x': 
                await self.send(MSG_CMD_STOP, "F1 Stop")
            elif cmd == '1':
                await self.send(MSG_MODE_IDLE, "SetWorkoutMode IDLE")
            elif cmd == '2':
                await self.send(MSG_MODE_START, "SetWorkoutMode START")
            elif cmd == '6':
                await self.send(MSG_MODE_PAUSE, "SetWorkoutMode PAUSE")
            elif cmd == '7':
                await self.send(MSG_MODE_DONE, "SetWorkoutMode DONE")
            else:
                print("Unknown command")
        
        await self.disconnect()

if __name__ == "__main__":
    asyncio.run(Tester().run())
