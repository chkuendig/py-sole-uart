#!/usr/bin/env python3
"""
Sole F65 Treadmill BLE Fan Test Script
Tests if fan state is reported via BLE and attempts to control fan
"""

import asyncio
import argparse
import logging
import sys
from bleak import BleakClient, BleakScanner

# Sole proprietary service/characteristic UUIDs
SOLE_SERVICE = "49535343-fe7d-4ae5-8fa9-9fafd205e455"
SOLE_NOTIFY_CHAR = "49535343-1e4d-4bd9-ba61-23c647249616"  # Write to treadmill
SOLE_WRITE_CHAR = "49535343-8841-43f4-a8d4-ecbe34729bb3"  # Read from treadmill

# Message types
MSG_DEVICE_INFO = 0xF0
MSG_F1_COMMAND = 0xF1
MSG_SET_INCLINE = 0x02
MSG_WORKOUT_MODE = 0x03
MSG_SET_SPEED = 0x04
MSG_WORKOUT_DATA = 0x06
MSG_WORKOUT_PARAMS = 0x07
MSG_UNKNOWN_08 = 0x08
MSG_UNKNOWN_22 = 0x22
MSG_UNKNOWN_24 = 0x24

# F1 sub-commands
F1_START = 0x01
F1_SPEED_UP = 0x02
F1_SPEED_DOWN = 0x03
F1_INCLINE_UP = 0x04
F1_INCLINE_DOWN = 0x05
F1_STOP = 0x06

logging.basicConfig(
    format='%(asctime)s.%(msecs)03d %(levelname)s: %(message)s',
    datefmt='%H:%M:%S',
    level=logging.INFO
)
log = logging.getLogger(__name__)

def build_message(data: bytes) -> bytes:
    """Build a Sole protocol message: 5B <len> <data...> 5D"""
    return bytes([0x5B, len(data)]) + data + bytes([0x5D])

def parse_message(data: bytes) -> tuple:
    """Parse a Sole protocol message, return (type, payload)"""
    if len(data) < 3 or data[0] != 0x5B or data[-1] != 0x5D:
        return None, data
    msg_len = data[1]
    if len(data) < msg_len + 2:
        return None, data
    msg_type = data[2] if msg_len > 0 else None
    payload = data[3:-1] if msg_len > 1 else b''
    return msg_type, payload

def describe_message(data: bytes) -> str:
    """Return a human-readable description of a message"""
    msg_type, payload = parse_message(data)
    hex_str = data.hex()
    
    if msg_type == MSG_DEVICE_INFO:
        return f"[DeviceInfo] {hex_str}"
    elif msg_type == MSG_WORKOUT_MODE:
        mode = payload[0] if payload else 0
        modes = {0: "OFF", 1: "IDLE", 2: "RUNNING", 3: "FINISHED", 4: "STARTING"}
        mode_name = modes.get(mode, f"UNKNOWN({mode})")
        return f"[WorkoutMode] {hex_str} mode={mode_name}"
    elif msg_type == MSG_WORKOUT_DATA:
        return f"[WorkoutData] {hex_str}"
    elif msg_type == MSG_F1_COMMAND:
        cmd = payload[0] if payload else 0
        return f"[F1Command] {hex_str} cmd=0x{cmd:02x}"
    elif msg_type == MSG_SET_SPEED:
        return f"[SetSpeed] {hex_str}"
    elif msg_type == MSG_SET_INCLINE:
        return f"[SetIncline] {hex_str}"
    elif msg_type == 0x00:  # ACK
        return f"[ACK] {hex_str}"
    else:
        return f"[Type 0x{msg_type:02x}] {hex_str}" if msg_type else f"[Unknown] {hex_str}"

class SoleTreadmill:
    def __init__(self, address: str):
        self.address = address
        self.client = None
        self.messages = []
        self.connected = False
        
    def notification_handler(self, sender, data: bytearray):
        """Handle notifications from treadmill"""
        self.messages.append(bytes(data))
        log.info(f"<< {describe_message(bytes(data))}")
    
    async def connect(self):
        """Connect to treadmill"""
        log.info(f"Scanning for {self.address}...")
        device = await BleakScanner.find_device_by_address(self.address, timeout=10)
        if not device:
            log.error(f"Device {self.address} not found")
            return False
        
        log.info(f"Found: {device.name}")
        self.client = BleakClient(device)
        await self.client.connect()
        log.info("Connected!")
        
        # Subscribe to notifications
        await self.client.start_notify(SOLE_NOTIFY_CHAR, self.notification_handler)
        log.info("Subscribed to notifications")
        self.connected = True
        return True
    
    async def disconnect(self):
        """Disconnect from treadmill"""
        if self.client and self.client.is_connected:
            await self.client.stop_notify(SOLE_NOTIFY_CHAR)
            await self.client.disconnect()
            log.info("Disconnected")
        self.connected = False
    
    async def send(self, data: bytes, desc: str = ""):
        """Send data to treadmill"""
        log.info(f">> [{desc}] {data.hex()}")
        await self.client.write_gatt_char(SOLE_WRITE_CHAR, data)
        await asyncio.sleep(0.1)  # Small delay between commands
    
    async def send_and_wait(self, data: bytes, desc: str = "", wait: float = 0.3):
        """Send data and wait for response"""
        await self.send(data, desc)
        await asyncio.sleep(wait)
    
    async def full_init_f65(self):
        """Full F65 initialization sequence from qdomyos-zwift"""
        log.info("Starting F65 init sequence...")
        
        # Init commands from qdomyos-zwift
        initData01 = bytes([0x5b, 0x01, 0xf0, 0x5d])  # GetDeviceInfo
        initData01a = bytes([0x5b, 0x04, 0x00, 0x10, 0x4f, 0x4b, 0x5d])  # ACK
        initData02 = bytes([0x5b, 0x02, 0x03, 0x01, 0x5d])  # SetMode IDLE
        initData03 = bytes([0x5b, 0x04, 0x00, 0x09, 0x4f, 0x4b, 0x5d])  # ACK
        initData04 = bytes([0x5b, 0x06, 0x07, 0x01, 0x23, 0x00, 0x9b, 0xaa, 0x5d])  # WorkoutParams
        initData05 = bytes([0x5b, 0x03, 0x08, 0x10, 0x01, 0x5d])  # Unknown 0x08
        initData06 = bytes([0x5b, 0x05, 0x04, 0x00, 0x00, 0x00, 0x00, 0x5d])  # SetSpeed 0
        initData07 = bytes([0x5b, 0x02, 0x22, 0x09, 0x5d])  # Unknown 0x22
        initData08 = bytes([0x5b, 0x02, 0x02, 0x02, 0x5d])  # SetIncline
        initData09 = bytes([0x5b, 0x04, 0x00, 0x40, 0x4f, 0x4b, 0x5d])  # ACK
        
        # F65 specific init sequence
        await self.send_and_wait(initData01, "GetDeviceInfo", 0.5)
        await self.send_and_wait(initData01a, "ACK1", 0.1)
        
        # Send SetMode IDLE 4 times
        for i in range(4):
            await self.send_and_wait(initData02, f"SetMode IDLE ({i+1})", 0.1)
        
        await self.send_and_wait(initData01a, "ACK2", 0.1)
        await self.send_and_wait(initData02, "SetMode IDLE", 0.1)
        await self.send_and_wait(initData03, "ACK3", 0.1)
        await self.send_and_wait(initData01a, "ACK4", 0.1)
        
        await self.send_and_wait(initData04, "WorkoutParams", 0.1)
        await self.send_and_wait(initData05, "Init08_1", 0.1)
        await self.send_and_wait(initData05, "Init08_2", 0.1)
        await self.send_and_wait(initData06, "SetSpeed0", 0.1)
        await self.send_and_wait(initData07, "Init22", 0.1)
        
        # Send SetIncline 4 times
        for i in range(4):
            await self.send_and_wait(initData08, f"SetIncline ({i+1})", 0.1)
        
        await self.send_and_wait(initData01a, "ACK5", 0.1)
        await self.send_and_wait(initData09, "ACK6", 0.1)
        
        log.info("Init sequence complete")
        await asyncio.sleep(0.5)
    
    async def send_f1_command(self, cmd: int):
        """Send F1 sub-command"""
        msg = build_message(bytes([MSG_F1_COMMAND, cmd]))
        await self.send(msg, f"F1_0x{cmd:02x}")
    
    async def scan_messages(self, duration: int = 30):
        """Listen for messages for specified duration"""
        log.info(f"Scanning messages for {duration} seconds...")
        log.info("Toggle the fan on the console now!")
        self.messages.clear()
        await asyncio.sleep(duration)
        log.info(f"Received {len(self.messages)} messages")
        
        # Summarize unique message types
        types = {}
        for msg in self.messages:
            msg_type, _ = parse_message(msg)
            key = msg_type if msg_type else "unknown"
            types[key] = types.get(key, 0) + 1
        
        log.info("Message type summary:")
        for t, count in sorted(types.items(), key=lambda x: str(x[0])):
            if isinstance(t, int):
                log.info(f"  Type 0x{t:02x}: {count} messages")
            else:
                log.info(f"  {t}: {count} messages")

async def main():
    parser = argparse.ArgumentParser(description="Sole F65 Fan Test")
    parser.add_argument("address", help="Treadmill BLE MAC address")
    parser.add_argument("command", choices=["scan", "init", "f1", "raw"],
                       help="Command: scan=listen, init=full init+scan, f1=send F1 cmd, raw=send raw hex")
    parser.add_argument("-d", "--duration", type=int, default=60, help="Scan duration in seconds")
    parser.add_argument("-c", "--cmd", type=str, help="F1 command (hex) or raw bytes")
    
    args = parser.parse_args()
    
    treadmill = SoleTreadmill(args.address)
    
    try:
        if not await treadmill.connect():
            return 1
        
        if args.command == "scan":
            # Just send GetDeviceInfo and listen
            msg = build_message(bytes([MSG_DEVICE_INFO]))
            await treadmill.send(msg, "GetDeviceInfo")
            await asyncio.sleep(0.5)
            await treadmill.scan_messages(args.duration)
            
        elif args.command == "init":
            # Full init sequence then scan
            await treadmill.full_init_f65()
            await treadmill.scan_messages(args.duration)
            
        elif args.command == "f1":
            # Send F1 command
            if not args.cmd:
                log.error("Need -c/--cmd with F1 command (hex, e.g. 06 for stop)")
                return 1
            cmd = int(args.cmd, 16)
            await treadmill.send_f1_command(cmd)
            await treadmill.scan_messages(5)
            
        elif args.command == "raw":
            # Send raw hex bytes
            if not args.cmd:
                log.error("Need -c/--cmd with raw hex bytes")
                return 1
            data = bytes.fromhex(args.cmd.replace(" ", ""))
            await treadmill.send(data, "Raw")
            await treadmill.scan_messages(5)
        
        return 0
        
    except KeyboardInterrupt:
        log.info("Interrupted")
    finally:
        await treadmill.disconnect()

if __name__ == "__main__":
    sys.exit(asyncio.run(main()))
