"""Pytest configuration and fixtures."""

import pytest
from unittest.mock import MagicMock, AsyncMock
from bleak.backends.device import BLEDevice


@pytest.fixture
def mock_ble_device():
    """Create a mock BLE device."""
    device = MagicMock(spec=BLEDevice)
    device.name = "F65"
    device.address = "F5:C0:00:03:BE:69"
    return device


@pytest.fixture
def mock_bleak_client():
    """Create a mock BleakClient."""
    client = AsyncMock()
    client.is_connected = True
    return client


@pytest.fixture
def sample_device_info_msg():
    """Sample DeviceInfo message from F65."""
    # F65: model=145, version=0, metric, max=20.0, min=1.0, incline=15, segment=18
    return b'\x5b\x08\xf0\x91\x00\x00\xc8\x0a\x0f\x12\x5d'


@pytest.fixture
def sample_workout_mode_idle():
    """Sample WorkoutMode message (IDLE)."""
    return b'\x5b\x02\x03\x01\x5d'


@pytest.fixture
def sample_workout_mode_running():
    """Sample WorkoutMode message (RUNNING)."""
    return b'\x5b\x02\x03\x04\x5d'


@pytest.fixture
def sample_workout_data_msg():
    """Sample WorkoutData message."""
    # Time=5:30, dist=1.52km, cal=85, hr=120, speed=6.2km/h, incline=5%
    return b'\x5b\x0f\x06\x05\x1e\x00\x98\x00\x55\x78\x3e\x05\x02\x00\x00\x00\x00\x5d'
