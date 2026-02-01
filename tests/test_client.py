"""Tests for SoleClient."""

import pytest
from unittest.mock import AsyncMock, MagicMock, patch
from sole_uart.client import SoleClient
from sole_uart.const import MessageType, WorkoutMode
from sole_uart.models import WorkoutData


class TestSoleClientInit:
    """Test SoleClient initialization."""

    def test_init(self, mock_ble_device):
        """Test client initialization."""
        client = SoleClient(mock_ble_device)
        assert client._device == mock_ble_device
        assert not client.is_connected
        assert client.state.mode == WorkoutMode.OFF
        assert client.device_info is None
        assert client.workout_data is None

    def test_set_callbacks(self, mock_ble_device):
        """Test setting callbacks."""
        client = SoleClient(mock_ble_device)

        def workout_cb(data):
            pass

        def state_cb(state):
            pass

        def disconnect_cb():
            pass

        client.set_workout_data_callback(workout_cb)
        client.set_state_callback(state_cb)
        client.set_disconnect_callback(disconnect_cb)

        assert client._workout_data_callback == workout_cb
        assert client._state_callback == state_cb
        assert client._disconnect_callback == disconnect_cb


class TestSoleClientPassiveProtocol:
    """Test that client implements passive protocol correctly."""

    @pytest.mark.asyncio
    async def test_connect_sends_only_device_info(self, mock_ble_device):
        """Test that connect only sends GetDeviceInfo, not control commands."""
        client = SoleClient(mock_ble_device)

        with patch('sole_uart.client.establish_connection', new_callable=AsyncMock) as mock_conn:
            mock_client = AsyncMock()
            mock_conn.return_value = mock_client

            await client.connect()

            # Should send GetDeviceInfo
            assert mock_client.write_gatt_char.called
            call_args = mock_client.write_gatt_char.call_args
            sent_data = call_args[0][1]

            # Verify it's GetDeviceInfo (0xF0), not SET_WORKOUT_MODE (0x02)
            assert sent_data[2] == MessageType.DEVICE_INFO
            assert sent_data[2] != MessageType.SET_WORKOUT_MODE

    @pytest.mark.asyncio
    async def test_device_info_is_echoed(
        self, mock_ble_device, sample_device_info_msg
    ):
        """Test that DeviceInfo response is echoed back (handshake)."""
        client = SoleClient(mock_ble_device)

        with patch('sole_uart.client.establish_connection', new_callable=AsyncMock):
            mock_client = AsyncMock()
            client._client = mock_client
            client._connected = True

            # Simulate receiving DeviceInfo
            await client._on_notify(0, sample_device_info_msg)

            # Should echo it back
            assert mock_client.write_gatt_char.called
            call_args = mock_client.write_gatt_char.call_args
            echoed_data = call_args[0][1]
            assert echoed_data == sample_device_info_msg

    @pytest.mark.asyncio
    async def test_workout_mode_is_echoed(
        self, mock_ble_device, sample_workout_mode_running
    ):
        """Test that WorkoutMode is echoed back (passive monitoring)."""
        client = SoleClient(mock_ble_device)

        mock_client = AsyncMock()
        client._client = mock_client
        client._connected = True

        # Simulate receiving WorkoutMode
        await client._on_notify(0, sample_workout_mode_running)

        # Should echo it back (NOT send ACK)
        assert mock_client.write_gatt_char.called
        call_args = mock_client.write_gatt_char.call_args
        echoed_data = call_args[0][1]
        assert echoed_data == sample_workout_mode_running

    @pytest.mark.asyncio
    async def test_workout_data_is_acked(
        self, mock_ble_device, sample_workout_data_msg
    ):
        """Test that WorkoutData receives ACK."""
        client = SoleClient(mock_ble_device)

        mock_client = AsyncMock()
        client._client = mock_client
        client._connected = True

        # Simulate receiving WorkoutData
        await client._on_notify(0, sample_workout_data_msg)

        # Should send ACK
        assert mock_client.write_gatt_char.called
        call_args = mock_client.write_gatt_char.call_args
        ack_data = call_args[0][1]

        # Verify it's an ACK for WorkoutData
        assert ack_data[2] == MessageType.ACK
        assert ack_data[3] == MessageType.WORKOUT_DATA
        assert ack_data[4:6] == b'OK'


class TestSoleClientCallbacks:
    """Test callback invocations."""

    @pytest.mark.asyncio
    async def test_workout_data_callback_invoked(
        self, mock_ble_device, sample_workout_data_msg
    ):
        """Test that workout data callback is invoked."""
        client = SoleClient(mock_ble_device)

        callback_data = None

        def workout_cb(data: WorkoutData):
            nonlocal callback_data
            callback_data = data

        client.set_workout_data_callback(workout_cb)

        mock_client = AsyncMock()
        client._client = mock_client
        client._connected = True

        # Simulate receiving WorkoutData
        await client._on_notify(0, sample_workout_data_msg)

        # Callback should have been invoked
        assert callback_data is not None
        assert callback_data.minutes == 5
        assert callback_data.seconds == 30
        assert callback_data.speed == 6.2

    @pytest.mark.asyncio
    async def test_async_workout_data_callback(
        self, mock_ble_device, sample_workout_data_msg
    ):
        """Test that async workout data callback works."""
        client = SoleClient(mock_ble_device)

        callback_data = None

        async def async_workout_cb(data: WorkoutData):
            nonlocal callback_data
            callback_data = data

        client.set_workout_data_callback(async_workout_cb)

        mock_client = AsyncMock()
        client._client = mock_client
        client._connected = True

        # Simulate receiving WorkoutData
        await client._on_notify(0, sample_workout_data_msg)

        # Callback should have been invoked
        assert callback_data is not None
        assert callback_data.speed == 6.2

    @pytest.mark.asyncio
    async def test_state_callback_on_mode_change(
        self, mock_ble_device, sample_workout_mode_running
    ):
        """Test that state callback is invoked on mode change."""
        client = SoleClient(mock_ble_device)

        callback_state = None

        def state_cb(state):
            nonlocal callback_state
            callback_state = state

        client.set_state_callback(state_cb)

        mock_client = AsyncMock()
        client._client = mock_client
        client._connected = True

        # Simulate receiving WorkoutMode
        await client._on_notify(0, sample_workout_mode_running)

        # Callback should have been invoked
        assert callback_state is not None
        assert callback_state.mode == WorkoutMode.RUNNING
        assert callback_state.is_running


class TestSoleClientStateManagement:
    """Test client state management."""

    @pytest.mark.asyncio
    async def test_device_info_updates_state(
        self, mock_ble_device, sample_device_info_msg
    ):
        """Test that DeviceInfo updates client state."""
        client = SoleClient(mock_ble_device)

        mock_client = AsyncMock()
        client._client = mock_client
        client._connected = True

        await client._on_notify(0, sample_device_info_msg)

        assert client.device_info is not None
        assert client.device_info.model == 145
        assert client.device_info.max_speed == 20.0

    @pytest.mark.asyncio
    async def test_workout_mode_updates_state(
        self, mock_ble_device, sample_workout_mode_running
    ):
        """Test that WorkoutMode updates client state."""
        client = SoleClient(mock_ble_device)

        mock_client = AsyncMock()
        client._client = mock_client
        client._connected = True

        await client._on_notify(0, sample_workout_mode_running)

        assert client.state.mode == WorkoutMode.RUNNING

    @pytest.mark.asyncio
    async def test_workout_data_updates_state(
        self, mock_ble_device, sample_workout_data_msg
    ):
        """Test that WorkoutData updates client state."""
        client = SoleClient(mock_ble_device)

        mock_client = AsyncMock()
        client._client = mock_client
        client._connected = True

        await client._on_notify(0, sample_workout_data_msg)

        assert client.workout_data is not None
        assert client.workout_data.speed == 6.2
        assert client.workout_data.incline == 5
