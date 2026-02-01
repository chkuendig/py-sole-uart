#!/usr/bin/env python3
"""Full control test - with proper ACKs (required!)"""

import asyncio
from bleak import BleakClient

ADDRESS = "F5:C0:00:03:BE:69"
SOLE_NOTIFY_CHAR = "49535343-1e4d-4bd9-ba61-23c647249616"
SOLE_WRITE_CHAR = "49535343-8841-43f4-a8d4-ecbe34729bb3"

def build_msg(msg_type, payload=b""):
    length = 1 + len(payload)
    return bytes([0x5B, length, msg_type]) + payload + bytes([0x5D])

def build_ack(msg_type):
    """Build ACK: 5b 04 00 <msg_type> 4f 4b 5d"""
    return bytes([0x5B, 0x04, 0x00, msg_type, 0x4F, 0x4B, 0x5D])

# F1 Commands - these work!
MSG_GET_INFO = build_msg(0xF0)
MSG_START = build_msg(0xF1, bytes([0x01]))      # Start
MSG_SPEED_UP = build_msg(0xF1, bytes([0x02]))   # Speed/Level Up
MSG_SPEED_DOWN = build_msg(0xF1, bytes([0x03])) # Speed/Level Down
MSG_INCLINE_UP = build_msg(0xF1, bytes([0x04])) # Incline Up
MSG_INCLINE_DOWN = build_msg(0xF1, bytes([0x05])) # Incline Down
MSG_STOP = build_msg(0xF1, bytes([0x06]))       # Stop

class Tester:
    def __init__(self):
        self.client = None
        self.mode = 0
        self.speed = 0
        self.incline = 0
        self.msg_counts = {}
        
    def on_notify(self, sender, data):
        if len(data) >= 3 and data[0] == 0x5B:
            msg_type = data[2]
            payload = data[3:-1]
            self.msg_counts[msg_type] = self.msg_counts.get(msg_type, 0) + 1
            
            if msg_type == 0x03:  # WorkoutMode
                self.mode = payload[0] if payload else 0
                print(f"\n  [MODE: 0x{self.mode:02x}]")
                asyncio.create_task(self.ack_mode(self.mode))
            elif msg_type == 0x00:  # ACK
                acked = payload[0] if payload else 0
                print(f"\n  [ACK 0x{acked:02x}]")
            elif msg_type == 0xF0:
                print(f"\n  [DevInfo] {data.hex()}")
            elif msg_type == 0x06:  # WorkoutData
                if len(payload) >= 9:
                    self.speed = payload[7]
                    self.incline = payload[8]
                    print(f"\n  [Data] Speed:{self.speed/10:.1f} km/h  Incline:{self.incline}%")
                asyncio.create_task(self.ack(msg_type))
            elif msg_type == 0x09:  # HeartRateType - ACK but don't spam console
                asyncio.create_task(self.ack(msg_type))
            elif msg_type == 0x11:  # Speed
                spd = payload[0] if payload else 0
                print(f"\n  [Speed] {spd/10:.1f} km/h")
                asyncio.create_task(self.ack(msg_type))
            elif msg_type == 0x12:  # Incline
                inc = payload[0] if payload else 0
                print(f"\n  [Incline] {inc}%")
                asyncio.create_task(self.ack(msg_type))
            elif msg_type == 0x32:  # EndWorkout
                print(f"\n  [EndWorkout]")
                asyncio.create_task(self.ack(msg_type))
            elif msg_type in {0x10, 0x13, 0x14, 0x15, 0x20, 0x21, 0x22, 0x23, 0x25, 0x27, 0x40}:
                asyncio.create_task(self.ack(msg_type))
    
    async def ack(self, msg_type):
        try:
            await self.client.write_gatt_char(SOLE_WRITE_CHAR, build_ack(msg_type))
        except: pass
    
    async def ack_mode(self, mode):
        try:
            await self.client.write_gatt_char(SOLE_WRITE_CHAR, build_msg(0x03, bytes([mode])))
        except: pass
    
    async def connect(self):
        print(f"Connecting to {ADDRESS}...")
        self.client = BleakClient(ADDRESS)
        await self.client.connect()
        print("Connected!")
        await self.client.start_notify(SOLE_NOTIFY_CHAR, self.on_notify)
        await asyncio.sleep(0.3)
    
    async def disconnect(self):
        if self.client and self.client.is_connected:
            try: await self.client.stop_notify(SOLE_NOTIFY_CHAR)
            except: pass
            await self.client.disconnect()
            print("\nDisconnected")
    
    async def send(self, msg, desc):
        print(f"\n>> {desc}")
        await self.client.write_gatt_char(SOLE_WRITE_CHAR, msg)
        await asyncio.sleep(0.3)
    
    async def run(self):
        await self.connect()
        await self.send(MSG_GET_INFO, "GetDeviceInfo")
        await asyncio.sleep(1)
        
        print("\n" + "="*50)
        print("SOLE F65 CONTROL (with ACKs)")
        print("="*50)
        print("  s = START")
        print("  x = STOP")
        print("  + = Speed UP")
        print("  - = Speed DOWN")
        print("  u = Incline UP")
        print("  d = Incline DOWN")
        print("  q = Quit")
        print("="*50)
        
        loop = asyncio.get_event_loop()
        while True:
            try:
                cmd = await loop.run_in_executor(None, lambda: input("\nCmd> ").strip().lower())
            except EOFError:
                break
                
            if cmd == 'q': break
            elif cmd == 's': await self.send(MSG_START, "START")
            elif cmd == 'x': await self.send(MSG_STOP, "STOP")
            elif cmd == '+': await self.send(MSG_SPEED_UP, "Speed UP")
            elif cmd == '-': await self.send(MSG_SPEED_DOWN, "Speed DOWN")
            elif cmd == 'u': await self.send(MSG_INCLINE_UP, "Incline UP")
            elif cmd == 'd': await self.send(MSG_INCLINE_DOWN, "Incline DOWN")
        
        await self.disconnect()

if __name__ == "__main__":
    asyncio.run(Tester().run())
