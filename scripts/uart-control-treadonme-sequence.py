#!/usr/bin/env python3
"""Follow exact treadonme startup/stop sequence"""

import asyncio
from bleak import BleakClient

ADDRESS = "F5:C0:00:03:BE:69"
SOLE_NOTIFY_CHAR = "49535343-1e4d-4bd9-ba61-23c647249616"
SOLE_WRITE_CHAR = "49535343-8841-43f4-a8d4-ecbe34729bb3"

def build_msg(msg_type, payload=b""):
    length = 1 + len(payload)
    return bytes([0x5B, length, msg_type]) + payload + bytes([0x5D])

# Messages from treadonme
MSG_GET_INFO = build_msg(0xF0)

# UserProfile: sex=male(1), age=30, weight=155(2 bytes), height=72
# MessageTypeUserProfile = 0x07
MSG_USER_PROFILE = build_msg(0x07, bytes([0x01, 30, 0x00, 155, 72]))

# Program: Manual = 0x1001 -> bytes 0x10, 0x01
# MessageTypeProgram = 0x08  
MSG_PROGRAM_MANUAL = build_msg(0x08, bytes([0x10, 0x01]))

# WorkoutTarget: Time=0, Calories=0
# MessageTypeWorkoutTarget = 0x04
MSG_WORKOUT_TARGET = build_msg(0x04, bytes([0x00, 0x00, 0x00, 0x00]))

# SetWorkoutMode
# MessageTypeSetWorkoutMode = 0x02
MSG_MODE_START = build_msg(0x02, bytes([0x02]))  # WorkoutModeStart
MSG_MODE_PAUSE = build_msg(0x02, bytes([0x06]))  # WorkoutModePause
MSG_MODE_DONE = build_msg(0x02, bytes([0x07]))   # WorkoutModeDone

class Tester:
    def __init__(self):
        self.client = None
        self.mode = 0
        self.last_mode = -1
        self.responses = asyncio.Queue()
        
    def on_notify(self, sender, data):
        if len(data) >= 3 and data[0] == 0x5B:
            msg_type = data[2]
            payload = data[3:-1]
            
            if msg_type == 0x03:  # WorkoutMode
                self.mode = payload[0] if payload else 0
                mode_names = {0x01: "Idle", 0x02: "Start", 0x04: "Running", 
                              0x06: "Pause", 0x07: "Done", 0x80: "0x80?"}
                name = mode_names.get(self.mode, f"0x{self.mode:02x}")
                if self.mode != self.last_mode:
                    print(f"  [MODE: {name}]")
                    self.last_mode = self.mode
                # Echo it back immediately!
                asyncio.create_task(self.echo_mode(self.mode))
            elif msg_type == 0x00:  # ACK
                acked = payload[0] if payload else 0
                print(f"  [ACK 0x{acked:02x}]")
                self.responses.put_nowait(('ack', acked))
            elif msg_type == 0x02:  # SetWorkoutMode echo
                mode = payload[0] if payload else 0
                print(f"  [SetWorkoutMode echo 0x{mode:02x}]")
                self.responses.put_nowait(('mode_echo', mode))
            elif msg_type == 0xF0:
                print(f"  [DevInfo] {data.hex()}")
                self.responses.put_nowait(('devinfo', data))
            elif msg_type == 0x09:  # HeartRateType
                print(f"  [HeartRateType] {data.hex()}")
                self.responses.put_nowait(('hrtype', data))
            elif msg_type == 0x06:  # WorkoutData
                if len(payload) >= 9:
                    spd = payload[7]
                    inc = payload[8]
                    print(f"  [WorkoutData] Speed:{spd/10:.1f} Incline:{inc}%")
            else:
                print(f"  [0x{msg_type:02x}] {data.hex()}")
    
    async def echo_mode(self, mode):
        """Echo WorkoutMode back (required ACK)"""
        echo = build_msg(0x03, bytes([mode]))
        try:
            await self.client.write_gatt_char(SOLE_WRITE_CHAR, echo)
        except Exception as e:
            print(f"  (echo failed: {e})")
    
    async def connect(self):
        print(f"Connecting to {ADDRESS}...")
        self.client = BleakClient(ADDRESS)
        await self.client.connect()
        print("Connected!")
        await self.client.start_notify(SOLE_NOTIFY_CHAR, self.on_notify)
        await asyncio.sleep(0.3)
    
    async def disconnect(self):
        if self.client and self.client.is_connected:
            try:
                await self.client.stop_notify(SOLE_NOTIFY_CHAR)
            except:
                pass
            await self.client.disconnect()
            print("Disconnected")
            self.client = None
    
    async def send_and_wait(self, msg, desc, wait_for='ack', timeout=2.0):
        """Send message and wait for response"""
        print(f">> {desc}: {msg.hex()}")
        # Clear queue
        while not self.responses.empty():
            try:
                self.responses.get_nowait()
            except:
                break
        
        await self.client.write_gatt_char(SOLE_WRITE_CHAR, msg)
        
        try:
            resp = await asyncio.wait_for(self.responses.get(), timeout)
            return resp
        except asyncio.TimeoutError:
            print(f"  (no response)")
            return None
    
    async def treadonme_start_sequence(self):
        """Follow exact treadonme Start() sequence"""
        print("\n" + "="*60)
        print("TREADONME START SEQUENCE")
        print("="*60)
        
        # 1. Get device info
        await self.send_and_wait(MSG_GET_INFO, "GetDeviceInfo", timeout=2)
        await asyncio.sleep(0.5)
        
        # Wait for HeartRateType (treadonme does this)
        print("Waiting for HeartRateType...")
        await asyncio.sleep(1)
        
        # 2. UserProfile
        await self.send_and_wait(MSG_USER_PROFILE, "UserProfile")
        await asyncio.sleep(0.3)
        
        # 3. Program (Manual)
        await self.send_and_wait(MSG_PROGRAM_MANUAL, "Program=Manual")
        await asyncio.sleep(0.3)
        
        # 4. WorkoutTarget
        await self.send_and_wait(MSG_WORKOUT_TARGET, "WorkoutTarget")
        await asyncio.sleep(0.3)
        
        # 5. SetWorkoutMode(Start)
        await self.send_and_wait(MSG_MODE_START, "SetWorkoutMode=Start", wait_for='mode_echo')
        
        # 6. Disconnect!
        print("\n>> Disconnecting (per treadonme)...")
        await self.disconnect()
        
        # 7. Wait 5 seconds
        print(">> Waiting 5 seconds...")
        await asyncio.sleep(5)
        
        # 8. Reconnect
        print(">> Reconnecting...")
        await self.connect()
        
        # 9. Get device info again
        await self.send_and_wait(MSG_GET_INFO, "GetDeviceInfo (after reconnect)")
        
        print("\n*** START SEQUENCE COMPLETE ***")
        print("Belt should be running now!")
    
    async def stop_sequence(self):
        """Try to stop"""
        print("\n" + "="*60)
        print("STOP SEQUENCE")
        print("="*60)
        
        # Send SetWorkoutMode PAUSE multiple times (like qdomyos-zwift)
        for i in range(3):
            await self.send_and_wait(MSG_MODE_PAUSE, f"SetWorkoutMode=Pause ({i+1}/3)")
            await asyncio.sleep(0.3)
        
        # Then send DONE
        for i in range(3):
            await self.send_and_wait(MSG_MODE_DONE, f"SetWorkoutMode=Done ({i+1}/3)")
            await asyncio.sleep(0.3)
        
        print("\n*** STOP SEQUENCE COMPLETE ***")
    
    async def run(self):
        await self.connect()
        
        print("\n" + "="*60)
        print("Commands:")
        print("  s = Full treadonme START sequence")
        print("  x = Full STOP sequence")
        print("  i = Get device info")
        print("  q = Quit")
        print("="*60)
        
        loop = asyncio.get_event_loop()
        while True:
            try:
                cmd = await loop.run_in_executor(None, lambda: input("\nCmd> ").strip().lower())
            except EOFError:
                break
                
            if cmd == 'q': 
                break
            elif cmd == 's':
                await self.treadonme_start_sequence()
            elif cmd == 'x':
                await self.stop_sequence()
            elif cmd == 'i':
                await self.send_and_wait(MSG_GET_INFO, "GetDeviceInfo")
        
        await self.disconnect()

if __name__ == "__main__":
    asyncio.run(Tester().run())
