"""
SOLE Fitness BLE Client for monitoring equipment.

This client connects to SOLE/Spirit/XTERRA fitness equipment via Bluetooth LE
and monitors workout data in real-time without interfering with the equipment's
built-in display.
"""

import asyncio
import logging
from typing import Callable, Optional, Any
from dataclasses import dataclass

from bleak import BleakClient, BleakScanner
from bleak.backends.device import BLEDevice
from bleak.backends.characteristic import BleakGATTCharacteristic

from sole_protocol import (
    ServiceUUID,
    CharacteristicUUID,
    Command,
    ProtocolParser,
    CommandBuilder,
    DeviceInfo,
    WorkoutData,
    EndWorkoutData,
    WorkoutMode,
)
from sole_ftms import (
    FTMSService,
    FTMSTreadmillData,
    parse_treadmill_data as parse_ftms_treadmill,
)

logger = logging.getLogger(__name__)


@dataclass
class SoleDevice:
    """Discovered SOLE fitness device."""
    name: str
    address: str
    rssi: int
    ble_device: BLEDevice


class SoleMonitor:
    """
    BLE client for monitoring SOLE fitness equipment.

    This is a read-only monitor that listens to workout data broadcasts
    without sending commands that could interfere with equipment operation.

    Example usage:
        async def on_workout(data: WorkoutData):
            print(f"Speed: {data.speed} km/h, Calories: {data.calories}")

        monitor = SoleMonitor()
        monitor.on_workout_data = on_workout
        await monitor.connect("XX:XX:XX:XX:XX:XX")
        await monitor.start_monitoring()
    """

    # Device name prefixes for SOLE family equipment
    DEVICE_PREFIXES = [
        "SOLE", "Sole", "sole",
        "SPIRIT", "Spirit",
        "XTERRA", "Xterra",
        "FUEL", "Fuel",
        "E25", "E35", "E55", "E95",  # Ellipticals
        "F63", "F65", "F80", "F85",  # Treadmills
        "B94", "R92", "LCB", "LCR",  # Bikes
        "TT8", "S77", "XT",
    ]

    def __init__(self):
        self._client: Optional[BleakClient] = None
        self._parser = ProtocolParser()
        self._notify_char: Optional[str] = None
        self._write_char: Optional[str] = None
        self._running = False
        self._use_secondary_service = False
        self._notifications_started = False

        # FTMS support
        self._ftms_notify_char: Optional[str] = None

        # Callbacks
        self.on_device_info: Optional[Callable[[DeviceInfo], Any]] = None
        self.on_workout_data: Optional[Callable[[WorkoutData], Any]] = None
        self.on_workout_end: Optional[Callable[[EndWorkoutData], Any]] = None
        self.on_mode_change: Optional[Callable[[WorkoutMode], Any]] = None
        self.on_ftms_data: Optional[Callable[[FTMSTreadmillData], Any]] = None  # FTMS treadmill data
        self.on_raw_data: Optional[Callable[[bytes], Any]] = None
        self.on_disconnect: Optional[Callable[[], Any]] = None

    @property
    def is_connected(self) -> bool:
        return self._client is not None and self._client.is_connected

    @property
    def device_info(self) -> Optional[DeviceInfo]:
        return self._parser.device_info

    @classmethod
    async def scan(cls, timeout: float = 10.0) -> list[SoleDevice]:
        """
        Scan for SOLE fitness equipment.

        Args:
            timeout: Scan duration in seconds

        Returns:
            List of discovered devices
        """
        devices = []
        seen = set()

        def detection_callback(device: BLEDevice, advertisement_data):
            if device.address in seen:
                return
            seen.add(device.address)

            name = device.name or advertisement_data.local_name or ""

            # Check if this looks like SOLE equipment
            if any(name.startswith(prefix) for prefix in cls.DEVICE_PREFIXES):
                devices.append(SoleDevice(
                    name=name,
                    address=device.address,
                    rssi=advertisement_data.rssi,
                    ble_device=device,
                ))
                logger.info(f"Found: {name} ({device.address}) RSSI: {advertisement_data.rssi}")

        scanner = BleakScanner(detection_callback=detection_callback)
        await scanner.start()
        await asyncio.sleep(timeout)
        await scanner.stop()

        return sorted(devices, key=lambda d: d.rssi, reverse=True)

    async def connect(self, address_or_device: str | BLEDevice) -> bool:
        """
        Connect to a SOLE device.

        Args:
            address_or_device: BLE address string or BLEDevice object

        Returns:
            True if connection successful
        """
        if isinstance(address_or_device, str):
            device = address_or_device
        else:
            device = address_or_device

        logger.info(f"Connecting to {device}...")

        self._client = BleakClient(
            device,
            disconnected_callback=self._on_disconnect,
        )

        try:
            await self._client.connect()
            logger.info("Connected successfully")

            # Discover services and find the right characteristics
            await self._discover_characteristics()

            # Immediately subscribe to notifications and request device info
            # This prevents the device from timing out and disconnecting
            logger.info("Subscribing to notifications...")
            await self._client.start_notify(self._notify_char, self._handle_notification)
            self._notifications_started = True

            if self._write_char:
                logger.info("Requesting device info...")
                # Send device info request: [5B][01][F0][5D]
                cmd = bytes.fromhex("5B01F05D")
                await self._client.write_gatt_char(self._write_char, cmd)
                await asyncio.sleep(0.5)

            return True
        except Exception as e:
            logger.error(f"Connection failed: {e}")
            self._client = None
            return False

    async def _discover_characteristics(self):
        """Discover BLE services and characteristics."""
        services = self._client.services

        # Log all services for debugging
        logger.debug("Available services:")
        for service in services:
            logger.debug(f"  Service: {service.uuid}")
            for char in service.characteristics:
                props = ", ".join(char.properties)
                logger.debug(f"    Char: {char.uuid} [{props}]")

        # Try primary service first
        for service in services:
            service_uuid = str(service.uuid).lower()

            if service_uuid == ServiceUUID.PRIMARY.lower():
                logger.info(f"Found primary service: {service.uuid}")
                self._use_secondary_service = False

                for char in service.characteristics:
                    char_uuid = str(char.uuid).lower()
                    if char_uuid == CharacteristicUUID.PRIMARY_NOTIFY.lower():
                        self._notify_char = char.uuid
                        logger.info(f"Found notify characteristic: {char.uuid}")
                    elif char_uuid == CharacteristicUUID.PRIMARY_WRITE.lower():
                        self._write_char = char.uuid
                        logger.info(f"Found write characteristic: {char.uuid}")

            elif service_uuid == ServiceUUID.SECONDARY.lower():
                if self._notify_char is None:
                    logger.info(f"Using secondary service: {service.uuid}")
                    self._use_secondary_service = True

                    for char in service.characteristics:
                        char_uuid = str(char.uuid).lower()
                        if char_uuid == CharacteristicUUID.SECONDARY_NOTIFY.lower():
                            self._notify_char = char.uuid
                        elif char_uuid == CharacteristicUUID.SECONDARY_WRITE.lower():
                            self._write_char = char.uuid

        if self._notify_char is None:
            raise RuntimeError("Could not find notify characteristic")

        # Also look for FTMS service
        for service in services:
            if str(service.uuid).lower() == FTMSService.SERVICE.lower():
                logger.info(f"Found FTMS service: {service.uuid}")
                for char in service.characteristics:
                    if str(char.uuid).lower() == FTMSService.TREADMILL_DATA.lower():
                        self._ftms_notify_char = char.uuid
                        logger.info(f"Found FTMS Treadmill Data: {char.uuid}")

    async def disconnect(self):
        """Disconnect from the device."""
        self._running = False
        if self._client and self._client.is_connected:
            await self._client.disconnect()
        self._client = None

    def _on_disconnect(self, client: BleakClient):
        """Handle disconnection."""
        logger.warning("Disconnected from device")
        self._running = False
        self._notifications_started = False
        if self.on_disconnect:
            self.on_disconnect()

    async def start_monitoring(self, poll_interval: float = 0.5):
        """
        Start monitoring workout data.

        This enables notifications on the device and processes incoming data.
        Some devices require polling (sending GET_WORKOUT_DATA commands).

        Args:
            poll_interval: How often to request workout data (seconds)
        """
        if not self.is_connected:
            raise RuntimeError("Not connected to device")

        self._running = True

        # Subscribe to notifications if not already done during connect
        if not self._notifications_started:
            await self._client.start_notify(self._notify_char, self._handle_notification)
            self._notifications_started = True

        # Also subscribe to FTMS if available
        if self._ftms_notify_char:
            try:
                await self._client.start_notify(self._ftms_notify_char, self._handle_ftms_notification)
                logger.info("Subscribed to FTMS Treadmill Data")
            except Exception as e:
                logger.warning(f"Failed to subscribe to FTMS: {e}")

        logger.info("Started monitoring notifications")

        # Poll for workout data since some devices don't broadcast automatically
        poll_counter = 0
        while self._running and self.is_connected:
            # Send GET_WORKOUT_DATA command every poll_interval
            if self._write_char and poll_counter % int(poll_interval / 0.1) == 0:
                try:
                    # GET_WORKOUT_DATA command: [5B][01][06][5D]
                    cmd = bytes.fromhex("5B01065D")
                    await self._client.write_gatt_char(self._write_char, cmd, response=False)
                    logger.debug("Sent GET_WORKOUT_DATA request")
                except Exception as e:
                    logger.debug(f"Failed to send workout data request: {e}")

            poll_counter += 1
            await asyncio.sleep(0.1)

        # Clean up
        if self.is_connected:
            try:
                await self._client.stop_notify(self._notify_char)
                self._notifications_started = False
            except Exception:
                pass

    def stop_monitoring(self):
        """Stop monitoring (can be called from another task)."""
        self._running = False

    def _handle_notification(self, characteristic: BleakGATTCharacteristic, data: bytearray):
        """Handle incoming BLE notification."""
        # Always log raw data at debug level
        logger.debug(f"Raw BLE data: {bytes(data).hex().upper()}")

        # Log raw data if callback set
        if self.on_raw_data:
            self.on_raw_data(bytes(data))

        # Parse the data
        messages = self._parser.feed(bytes(data))

        for msg in messages:
            if isinstance(msg, DeviceInfo):
                logger.info(f"Device info: model={msg.model}, type={msg.device_type.name}, brand={msg.brand.name}")
                if self.on_device_info:
                    self.on_device_info(msg)

            elif isinstance(msg, WorkoutData):
                logger.debug(
                    f"Workout: {msg.minutes}:{msg.seconds:02d} | "
                    f"Dist: {msg.distance:.2f} | Cal: {msg.calories:.0f} | "
                    f"HR: {msg.heart_rate} | Speed: {msg.speed:.1f}"
                )
                if self.on_workout_data:
                    self.on_workout_data(msg)

            elif isinstance(msg, EndWorkoutData):
                logger.info(f"Workout ended: {msg.total_seconds}s, {msg.distance:.2f}km, {msg.calories:.0f}cal")
                if self.on_workout_end:
                    self.on_workout_end(msg)

            elif isinstance(msg, dict):
                cmd = msg.get("cmd")
                if cmd == Command.GET_MODE or cmd == 3:  # GET_MODE
                    mode = msg.get("mode")
                    mode_val = msg.get("mode_value", mode)
                    logger.debug(f"Mode: {mode} (0x{mode_val:02X})")
                    if self.on_mode_change:
                        if isinstance(mode, WorkoutMode):
                            self.on_mode_change(mode)
                        else:
                            # Pass unknown modes as WorkoutMode if possible
                            try:
                                self.on_mode_change(WorkoutMode(mode_val))
                            except ValueError:
                                pass  # Unknown mode value

    def _handle_ftms_notification(self, characteristic: BleakGATTCharacteristic, data: bytearray):
        """Handle FTMS Treadmill Data notification."""
        logger.debug(f"FTMS data: {bytes(data).hex().upper()}")

        ftms_data = parse_ftms_treadmill(bytes(data))

        if self.on_ftms_data:
            self.on_ftms_data(ftms_data)


class SoleController(SoleMonitor):
    """
    Extended client with control capabilities.

    WARNING: Sending commands while someone is using the equipment could
    be dangerous. Only use control features when appropriate.

    For most monitoring use cases, use SoleMonitor instead.
    """

    async def request_device_info(self) -> Optional[DeviceInfo]:
        """Request device information."""
        if not self.is_connected or not self._write_char:
            return None

        cmd = CommandBuilder.get_device_info()
        await self._client.write_gatt_char(self._write_char, cmd)

        # Wait briefly for response
        await asyncio.sleep(0.5)
        return self._parser.device_info

    async def request_workout_data(self):
        """Request current workout data (usually not needed, data is broadcast)."""
        if not self.is_connected or not self._write_char:
            return

        cmd = CommandBuilder.get_workout_data()
        await self._client.write_gatt_char(self._write_char, cmd)

    async def request_mode(self):
        """Request current operating mode."""
        if not self.is_connected or not self._write_char:
            return

        cmd = CommandBuilder.get_mode()
        await self._client.write_gatt_char(self._write_char, cmd)
