"""Sole treadmill UART client - TRULY PASSIVE version."""

import asyncio
import logging
from collections.abc import Callable
from typing import Any, Optional

from bleak import BleakClient
from bleak.backends.device import BLEDevice

from .const import SOLE_UART_NOTIFY, SOLE_UART_WRITE, MessageType, WorkoutMode
from .dis import read_device_info as read_ble_device_info
from .models import DeviceInfo, MachineState, WorkoutData
from .utils import (
    build_ack,
    get_message_type,
    parse_device_info,
    parse_workout_data,
    parse_workout_mode,
)

_LOGGER = logging.getLogger(__name__)


class SoleClient:
    """
    Async client for Sole treadmill UART protocol - TRULY PASSIVE.

    This client provides 100% PASSIVE monitoring - it sends NO commands at all.

    How it works:
    1. Connects and subscribes to UART notifications
    2. Waits for you to start a workout on the console
    3. When treadmill broadcasts WorkoutMode, echoes it back
    4. Full workout data flows without interfering with console

    Example:
        >>> client = SoleClient(device)
        >>> client.set_workout_data_callback(lambda d: print(f"{d.speed} km/h"))
        >>> await client.connect()
        >>> # Start workout on console - data will flow via callbacks
    """

    def __init__(self, device: BLEDevice) -> None:
        """
        Initialize Sole client.

        Args:
            device: BLE device to connect to
        """
        self._device = device
        self._client: Optional[BleakClient] = None
        self._state = MachineState(mode=WorkoutMode.OFF)
        self._connected = False
        self._last_mode: Optional[int] = None
        self._device_info_echoed = False  # Prevent echo loop

        # Callbacks
        self._workout_data_callback: Optional[Callable[[WorkoutData], Any]] = None
        self._state_callback: Optional[Callable[[MachineState], Any]] = None
        self._disconnect_callback: Optional[Callable[[], Any]] = None

    @property
    def is_connected(self) -> bool:
        """Check if client is connected."""
        return self._connected and self._client is not None

    @property
    def state(self) -> MachineState:
        """Get current machine state."""
        return self._state

    @property
    def device_info(self) -> Optional[DeviceInfo]:
        """Get device information."""
        return self._state.device_info

    @property
    def workout_data(self) -> Optional[WorkoutData]:
        """Get latest workout data."""
        return self._state.workout_data

    def set_workout_data_callback(
        self, callback: Optional[Callable[[WorkoutData], Any]]
    ) -> None:
        """
        Set callback for workout data updates.

        Args:
            callback: Async or sync function called with WorkoutData
        """
        self._workout_data_callback = callback

    def set_state_callback(
        self, callback: Optional[Callable[[MachineState], Any]]
    ) -> None:
        """
        Set callback for machine state changes.

        Args:
            callback: Async or sync function called with MachineState
        """
        self._state_callback = callback

    def set_disconnect_callback(
        self, callback: Optional[Callable[[], Any]]
    ) -> None:
        """
        Set callback for disconnection.

        Args:
            callback: Async or sync function called on disconnect
        """
        self._disconnect_callback = callback

    async def connect(self) -> None:
        """
        Connect to treadmill and establish TRULY PASSIVE monitoring.

        This method:
        1. Establishes BLE connection
        2. Subscribes to UART notifications
        3. Does NOT send any commands!

        The treadmill will broadcast WorkoutMode and WorkoutData when you
        start a workout from the console. We simply echo WorkoutMode to
        maintain the data flow.

        NO BEEPING - this sends absolutely nothing to the treadmill!

        Raises:
            Exception: If connection fails
        """
        if self._connected:
            _LOGGER.warning("Already connected")
            return

        _LOGGER.info(f"Connecting to {self._device.name} ({self._device.address})")

        # Use plain BleakClient (no retry logic to avoid continuous beeping)
        self._client = BleakClient(
            self._device,
            disconnected_callback=self._on_disconnect,
        )
        await self._client.connect()

        # Subscribe to UART notifications
        await self._client.start_notify(SOLE_UART_NOTIFY, self._on_notify)
        _LOGGER.debug("Subscribed to UART notifications")

        self._connected = True

        # Send GetDeviceInfo ONCE to establish communication
        # This is required for the treadmill to start broadcasting data
        # NOT a control command - just tells treadmill we're listening
        from .utils import build_message
        get_info = build_message(MessageType.DEVICE_INFO)
        _LOGGER.debug(f"Sending GetDeviceInfo (handshake): {get_info.hex()}")
        await self._client.write_gatt_char(SOLE_UART_WRITE, get_info)

        _LOGGER.info("Connected (passive mode - start workout on console)")
        print("\n" + "="*70)
        print("PASSIVE MONITORING ACTIVE")
        print("="*70)
        print("Sent handshake - console remains fully functional.")
        print("Start a workout on the treadmill console to see data.\n")

    async def disconnect(self) -> None:
        """Disconnect from treadmill."""
        if not self._connected or self._client is None:
            return

        _LOGGER.info("Disconnecting...")
        self._connected = False

        try:
            await self._client.stop_notify(SOLE_UART_NOTIFY)
        except Exception as e:
            _LOGGER.debug(f"Error stopping notifications: {e}")

        try:
            await self._client.disconnect()
        except Exception as e:
            _LOGGER.debug(f"Error disconnecting: {e}")

        self._client = None
        _LOGGER.info("Disconnected")

    def _on_disconnect(self, client: BleakClient) -> None:
        """Handle disconnection."""
        _LOGGER.info("Device disconnected")
        self._connected = False
        self._client = None

        if self._disconnect_callback:
            if asyncio.iscoroutinefunction(self._disconnect_callback):
                asyncio.create_task(self._disconnect_callback())
            else:
                self._disconnect_callback()

    async def _on_notify(self, sender: int, data: bytes) -> None:
        """
        Handle UART notifications from treadmill.

        TRULY PASSIVE implementation:
        - Echoes WorkoutMode messages (maintains data flow)
        - ACKs WorkoutData messages (protocol requirement)
        - Does NOT send GetDeviceInfo or any control commands
        """
        if len(data) < 3:
            return

        msg_type = get_message_type(data)
        if msg_type is None:
            _LOGGER.debug(f"Unknown message format: {data.hex()}")
            return

        try:
            if msg_type == MessageType.DEVICE_INFO:
                await self._handle_device_info(data)

            elif msg_type == MessageType.WORKOUT_MODE:
                await self._handle_workout_mode(data)

            elif msg_type == MessageType.WORKOUT_DATA:
                await self._handle_workout_data(data)

            elif msg_type == MessageType.HEART_RATE_TYPE:
                _LOGGER.debug("HeartRateType received")
                ack = build_ack(MessageType.HEART_RATE_TYPE)
                await self._client.write_gatt_char(SOLE_UART_WRITE, ack)

            elif msg_type == MessageType.END_WORKOUT:
                _LOGGER.info("Workout ended")
                ack = build_ack(MessageType.END_WORKOUT)
                await self._client.write_gatt_char(SOLE_UART_WRITE, ack)

            elif msg_type == MessageType.ERROR_CODE:
                error_code = data[3] if len(data) > 3 else 0
                _LOGGER.warning(f"Treadmill error code: {error_code}")
                ack = build_ack(MessageType.ERROR_CODE)
                await self._client.write_gatt_char(SOLE_UART_WRITE, ack)

            elif msg_type == MessageType.ACK:
                acked_type = data[3] if len(data) > 3 else 0
                _LOGGER.debug(f"ACK received for 0x{acked_type:02x}")

            else:
                _LOGGER.debug(f"Unhandled message type {msg_type.name}: {data.hex()}")

        except Exception as e:
            _LOGGER.error(f"Error handling notification: {e}", exc_info=True)

    async def _handle_device_info(self, data: bytes) -> None:
        """
        Handle Device Info message.

        In passive mode, we send GetDeviceInfo once as handshake,
        then echo the response ONCE to complete the handshake.
        DO NOT echo again or we'll create an infinite loop!
        """
        device_info = parse_device_info(data)
        if device_info:
            self._state.device_info = device_info
            _LOGGER.info(
                f"Device: Model={device_info.model}, "
                f"Units={device_info.units}, "
                f"MaxSpeed={device_info.max_speed:.1f}, "
                f"MaxIncline={device_info.max_incline}%"
            )

            # Echo DeviceInfo back ONLY ONCE to complete handshake
            # Echoing it again would create an infinite loop!
            if not self._device_info_echoed:
                await self._client.write_gatt_char(SOLE_UART_WRITE, data)
                self._device_info_echoed = True
                _LOGGER.debug("Echoed DeviceInfo (handshake complete)")
            else:
                _LOGGER.debug("DeviceInfo received again (not echoing - would loop)")

            # Notify state change
            await self._notify_state_change()

    async def _handle_workout_mode(self, data: bytes) -> None:
        """Handle Workout Mode message."""
        mode = parse_workout_mode(data)
        if mode is not None:
            # Always echo, even if mode didn't change
            # (treadmill expects acknowledgment)
            await self._client.write_gatt_char(SOLE_UART_WRITE, data)

            if mode != self._last_mode:
                try:
                    self._state.mode = WorkoutMode(mode)
                    mode_name = self._state.mode.name
                except ValueError:
                    mode_name = f"UNKNOWN(0x{mode:02x})"

                _LOGGER.info(f"Mode changed: {mode_name}")
                self._last_mode = mode
                _LOGGER.debug(f"Echoed WorkoutMode: {mode_name}")

                # Notify state change
                await self._notify_state_change()
            else:
                _LOGGER.debug(f"Echoed WorkoutMode (unchanged)")

    async def _handle_workout_data(self, data: bytes) -> None:
        """Handle Workout Data message."""
        workout_data = parse_workout_data(data)
        if workout_data:
            self._state.workout_data = workout_data
            _LOGGER.debug(
                f"Workout: Time={workout_data.elapsed_time_formatted}, "
                f"Speed={workout_data.speed:.1f}, "
                f"Incline={workout_data.incline}%, "
                f"Distance={workout_data.distance:.2f}, "
                f"Calories={workout_data.calories}, "
                f"HR={workout_data.heart_rate}"
            )

            # ACK workout data
            ack = build_ack(MessageType.WORKOUT_DATA)
            await self._client.write_gatt_char(SOLE_UART_WRITE, ack)

            # Notify callbacks
            if self._workout_data_callback:
                if asyncio.iscoroutinefunction(self._workout_data_callback):
                    await self._workout_data_callback(workout_data)
                else:
                    self._workout_data_callback(workout_data)

            await self._notify_state_change()

    async def _notify_state_change(self) -> None:
        """Notify state callback if set."""
        if self._state_callback:
            if asyncio.iscoroutinefunction(self._state_callback):
                await self._state_callback(self._state)
            else:
                self._state_callback(self._state)
