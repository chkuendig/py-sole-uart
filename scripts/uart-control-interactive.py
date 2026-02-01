#!/usr/bin/env python3
"""
Interactive Sole Treadmill BLE Test Script
Tests the Sole serial-over-BLE protocol commands

WARNING: This can START your treadmill - make sure belt is clear!
"""

import asyncio
import sys
from datetime import datetime
from bleak import BleakClient

# Sole Service UUIDs
SOLE_SERVICE = "49535343-fe7d-4ae5-8fa9-9fafd205e455"
SOLE_NOTIFY_CHAR = "49535343-1e4d-4bd9-ba61-23c647249616"
SOLE_WRITE_CHAR = "49535343-8841-43f4-a8d4-ecbe34729bb3"


def build_message(msg_type: int, payload: bytes = b"") -> bytes:
    """Build a Sole serial message with framing."""
    length = 1 + len(payload)  # type byte + payload
    message = bytes([0x5B, length, msg_type]) + payload + bytes([0x5D])
    return message


def build_ack(msg_type: int) -> bytes:
    """Build an ACK message for a given type."""
    return bytes([0x5B, 0x04, 0x00, msg_type, ord('O'), ord('K'), 0x5D])


# Pre-built messages
MSG_GET_DEVICE_INFO = build_message(0xF0)
MSG_SET_WORKOUT_MODE_START = build_message(0x02, bytes([0x02]))  # Mode 2 = Start
MSG_SET_WORKOUT_MODE_IDLE = build_message(0x02, bytes([0x01]))   # Mode 1 = Idle
MSG_SET_WORKOUT_MODE_PAUSE = build_message(0x02, bytes([0x06]))  # Mode 6 = Pause
MSG_COMMAND_START = build_message(0xF1, bytes([0x01]))  # Start
MSG_COMMAND_STOP = build_message(0xF1, bytes([0x06]))   # Stop
MSG_COMMAND_SPEED_UP = build_message(0xF1, bytes([0x02]))
MSG_COMMAND_SPEED_DOWN = build_message(0xF1, bytes([0x03]))


def build_speed_message(speed_kmh: float) -> bytes:
    """Build a Set Speed message. Speed is in 0.1 km/h units."""
    speed_value = int(speed_kmh * 10)
    return build_message(0x11, bytes([speed_value]))


def build_incline_message(incline_pct: int) -> bytes:
    """Build a Set Incline message. Incline is in whole percent."""
    return build_message(0x12, bytes([incline_pct]))


class TreadmillController:
    def __init__(self, address: str):
        self.address = address
        self.client = None
        self.last_response = None
        self.response_event = asyncio.Event()
        
    def notification_handler(self, sender, data):
        """Handle incoming notifications."""
        timestamp = datetime.now().strftime("%H:%M:%S.%f")[:-3]
        hex_data = data.hex()
        
        # Parse the message
        if len(data) >= 3 and data[0] == 0x5B and data[-1] == 0x5D:
            msg_len = data[1]
            msg_type = data[2]
            payload = data[3:-1]
            
            type_names = {
                0x00: "ACK",
                0x02: "SetMode",
                0x03: "Mode",
                0x06: "WorkoutData",
                0x11: "Speed",
                0x12: "Incline",
                0xF0: "DeviceInfo",
                0xF1: "Command",
            }
            
            type_name = type_names.get(msg_type, f"0x{msg_type:02x}")
            
            # Only print non-mode messages or if verbose
            if msg_type != 0x03:  # Skip the constant mode messages
                print(f"[{timestamp}] RX {type_name}: {hex_data} (payload: {payload.hex()})")
                
            self.last_response = data
            self.response_event.set()
        else:
            print(f"[{timestamp}] RX RAW: {hex_data}")
    
    async def connect(self):
        """Connect to the treadmill."""
        print(f"Connecting to {self.address}...")
        self.client = BleakClient(self.address)
        await self.client.connect()
        print(f"Connected: {self.client.is_connected}")
        
        # Subscribe to notifications
        await self.client.start_notify(SOLE_NOTIFY_CHAR, self.notification_handler)
        print("Subscribed to notifications")
        
        # Give it a moment
        await asyncio.sleep(0.5)
    
    async def disconnect(self):
        """Disconnect from the treadmill."""
        if self.client and self.client.is_connected:
            await self.client.stop_notify(SOLE_NOTIFY_CHAR)
            await self.client.disconnect()
            print("Disconnected")
    
    async def send(self, message: bytes, description: str = ""):
        """Send a message and wait briefly for response."""
        self.response_event.clear()
        print(f"\nTX {description}: {message.hex()}")
        await self.client.write_gatt_char(SOLE_WRITE_CHAR, message)
        
        # Wait for response with timeout
        try:
            await asyncio.wait_for(self.response_event.wait(), timeout=1.0)
        except asyncio.TimeoutError:
            print("  (no response)")
        
        await asyncio.sleep(0.3)  # Treadmill needs delay between commands
    
    async def get_device_info(self):
        """Query device info."""
        await self.send(MSG_GET_DEVICE_INFO, "Get Device Info (0xF0)")
    
    async def start_workout(self):
        """Start the treadmill workout."""
        print("\n=== STARTING WORKOUT ===")
        # First set workout mode to start
        await self.send(MSG_SET_WORKOUT_MODE_START, "Set Workout Mode: Start (0x02 0x02)")
        await asyncio.sleep(0.5)
        # Then send start command
        await self.send(MSG_COMMAND_START, "Command: Start (0xF1 0x01)")
    
    async def stop_workout(self):
        """Stop the treadmill."""
        print("\n=== STOPPING WORKOUT ===")
        await self.send(MSG_COMMAND_STOP, "Command: Stop (0xF1 0x06)")
    
    async def set_speed(self, speed_kmh: float):
        """Set treadmill speed in km/h."""
        msg = build_speed_message(speed_kmh)
        await self.send(msg, f"Set Speed: {speed_kmh} km/h (0x11 0x{int(speed_kmh*10):02x})")
    
    async def set_incline(self, incline_pct: int):
        """Set treadmill incline in percent."""
        msg = build_incline_message(incline_pct)
        await self.send(msg, f"Set Incline: {incline_pct}% (0x12 0x{incline_pct:02x})")
    
    async def speed_up(self):
        """Send speed up command."""
        await self.send(MSG_COMMAND_SPEED_UP, "Command: Speed Up (0xF1 0x02)")
    
    async def speed_down(self):
        """Send speed down command."""
        await self.send(MSG_COMMAND_SPEED_DOWN, "Command: Speed Down (0xF1 0x03)")


async def interactive_mode(controller: TreadmillController):
    """Interactive command menu."""
    print("\n" + "="*50)
    print("INTERACTIVE TREADMILL CONTROL")
    print("="*50)
    print("Commands:")
    print("  i - Get device info")
    print("  s - START workout (CAUTION!)")
    print("  x - STOP workout")
    print("  + - Speed up")
    print("  - - Speed down")
    print("  1-9 - Set speed (1=1km/h, 5=5km/h, etc)")
    print("  u/d - Incline up/down")
    print("  q - Quit")
    print("="*50)
    
    while True:
        try:
            cmd = await asyncio.get_event_loop().run_in_executor(
                None, lambda: input("\nCommand> ").strip().lower()
            )
        except EOFError:
            break
            
        if cmd == 'q':
            break
        elif cmd == 'i':
            await controller.get_device_info()
        elif cmd == 's':
            confirm = await asyncio.get_event_loop().run_in_executor(
                None, lambda: input("Really START? Belt will move! (yes/no): ").strip().lower()
            )
            if confirm == 'yes':
                await controller.start_workout()
            else:
                print("Cancelled")
        elif cmd == 'x':
            await controller.stop_workout()
        elif cmd == '+':
            await controller.speed_up()
        elif cmd == '-':
            await controller.speed_down()
        elif cmd in '123456789':
            speed = float(cmd)
            await controller.set_speed(speed)
        elif cmd == 'u':
            await controller.set_incline(5)  # Example: 5%
        elif cmd == 'd':
            await controller.set_incline(0)
        else:
            print(f"Unknown command: {cmd}")


async def main():
    if len(sys.argv) < 2:
        # Default to F65 MAC
        address = "F5:C0:00:03:BE:69"
        print(f"Using default address: {address}")
    else:
        address = sys.argv[1]
    
    controller = TreadmillController(address)
    
    try:
        await controller.connect()
        
        # Always start with device info
        await controller.get_device_info()
        
        # Enter interactive mode
        await interactive_mode(controller)
        
    except Exception as e:
        print(f"Error: {e}")
        import traceback
        traceback.print_exc()
    finally:
        await controller.disconnect()


if __name__ == "__main__":
    asyncio.run(main())
