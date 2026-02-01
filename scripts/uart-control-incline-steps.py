#!/usr/bin/env python3
"""
Sole F65 - Test Incline Up/Down Commands
F1 0x04 = Incline Up, F1 0x05 = Incline Down
"""

import asyncio
from datetime import datetime
from bleak import BleakClient

ADDRESS = "F5:C0:00:03:BE:69"
SOLE_NOTIFY_CHAR = "49535343-1e4d-4bd9-ba61-23c647249616"
SOLE_WRITE_CHAR = "49535343-8841-43f4-a8d4-ecbe34729bb3"

def build_msg(msg_type: int, payload: bytes = b"") -> bytes:
    length = 1 + len(payload)
    return bytes([0x5B, length, msg_type]) + payload + bytes([0x5D])

# Commands
MSG_GET_INFO = build_msg(0xF0)
MSG_START = build_msg(0xF1, bytes([0x01]))
MSG_STOP = build_msg(0xF1, bytes([0x06]))
MSG_SPEED_UP = build_msg(0xF1, bytes([0x02]))
MSG_SPEED_DOWN = build_msg(0xF1, bytes([0x03]))
MSG_INCLINE_UP = build_msg(0xF1, bytes([0x04]))
MSG_INCLINE_DOWN = build_msg(0xF1, bytes([0x05]))

class Tester:
    def __init__(self):
        self.client = None
        self.mode = 0x80
        self.speed = 0
        self.incline = 0
        
    def on_notify(self, sender, data):
        if len(data) >= 3 and data[0] == 0x5B:
            msg_type = data[2]
            payload = data[3:-1]
            
            if msg_type == 0x03:  # Mode
                self.mode = payload[0] if payload else 0
            elif msg_type == 0x06:  # WorkoutData
                if len(payload) >= 9:
                    self.speed = payload[7]
                    self.incline = payload[8]
                    print(f"  Speed: {self.speed/10:.1f} km/h | Incline: {self.incline}%")
            elif msg_type == 0x00:  # ACK
                print(f"  ACK received")
            elif msg_type == 0xF0:  # DeviceInfo
                print(f"  DeviceInfo: {data.hex()}")
    
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
            print("Disconnected")
    
    async def send(self, msg: bytes, desc: str):
        print(f"TX: {desc}")
        await self.client.write_gatt_char(SOLE_WRITE_CHAR, msg)
        await asyncio.sleep(0.4)
    
    async def run(self):
        await self.connect()
        await self.send(MSG_GET_INFO, "Get Device Info")
        
        print(f"\nMode: 0x{self.mode:02x} {'(DEMO - go to Manual workout!)' if self.mode == 0x80 else '(Ready)'}")
        print("\n" + "="*50)
        print("COMMANDS:")
        print("  s = START belt")
        print("  x = STOP belt")
        print("  + = Speed UP")
        print("  - = Speed DOWN")
        print("  u = Incline UP (F1 0x04)")
        print("  d = Incline DOWN (F1 0x05)")
        print("  q = Quit")
        print("="*50)
        
        while True:
            cmd = await asyncio.get_event_loop().run_in_executor(None, 
                lambda: input(f"\n[Mode:0x{self.mode:02x} Spd:{self.speed/10:.1f} Inc:{self.incline}%] > ").strip().lower())
            
            if cmd == 'q':
                break
            elif cmd == 's':
                await self.send(MSG_START, "START (F1 0x01)")
            elif cmd == 'x':
                await self.send(MSG_STOP, "STOP (F1 0x06)")
            elif cmd == '+':
                await self.send(MSG_SPEED_UP, "Speed UP (F1 0x02)")
            elif cmd == '-':
                await self.send(MSG_SPEED_DOWN, "Speed DOWN (F1 0x03)")
            elif cmd == 'u':
                await self.send(MSG_INCLINE_UP, "Incline UP (F1 0x04)")
            elif cmd == 'd':
                await self.send(MSG_INCLINE_DOWN, "Incline DOWN (F1 0x05)")
            elif cmd == 'i':
                await self.send(MSG_GET_INFO, "Get Device Info")
        
        await self.disconnect()

async def main():
    t = Tester()
    try:
        await t.run()
    except Exception as e:
        print(f"Error: {e}")
        import traceback
        traceback.print_exc()

if __name__ == "__main__":
    asyncio.run(main())
