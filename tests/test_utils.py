"""Tests for message parsing and building utilities."""

import pytest
from sole_uart.const import MessageType
from sole_uart.models import DeviceInfo, HeartRateType, WorkoutData
from sole_uart.utils import (
    build_ack,
    build_message,
    get_message_type,
    parse_device_info,
    parse_workout_data,
    parse_workout_mode,
)


class TestMessageBuilding:
    """Test message construction."""

    def test_build_simple_message(self):
        """Test building a simple message without payload."""
        msg = build_message(MessageType.DEVICE_INFO)
        assert msg == b'\x5b\x01\xf0\x5d'  # [, 1, 0xf0, ]

    def test_build_message_with_payload(self):
        """Test building a message with payload."""
        msg = build_message(MessageType.COMMAND, b'\x01')
        assert msg == b'\x5b\x02\xf1\x01\x5d'  # [, 2, 0xf1, 0x01, ]

    def test_build_ack(self):
        """Test building ACK message."""
        ack = build_ack(MessageType.WORKOUT_DATA)
        assert ack == b'\x5b\x04\x00\x06\x4f\x4b\x5d'  # [, 4, 0, 6, O, K, ]

    def test_build_ack_for_device_info(self):
        """Test building ACK for device info."""
        ack = build_ack(MessageType.DEVICE_INFO)
        assert ack == b'\x5b\x04\x00\xf0\x4f\x4b\x5d'


class TestMessageParsing:
    """Test message parsing."""

    def test_get_message_type_device_info(self):
        """Test extracting message type from device info."""
        msg = b'\x5b\x08\xf0\x91\x00\x00\xc8\x0a\x0f\x12\x5d'
        msg_type = get_message_type(msg)
        assert msg_type == MessageType.DEVICE_INFO

    def test_get_message_type_workout_mode(self):
        """Test extracting message type from workout mode."""
        msg = b'\x5b\x02\x03\x01\x5d'
        msg_type = get_message_type(msg)
        assert msg_type == MessageType.WORKOUT_MODE

    def test_get_message_type_invalid_short(self):
        """Test invalid message (too short)."""
        msg = b'\x5b\x01'
        msg_type = get_message_type(msg)
        assert msg_type is None

    def test_get_message_type_invalid_framing(self):
        """Test invalid message (wrong framing)."""
        msg = b'\x00\x02\x03\x01\x00'
        msg_type = get_message_type(msg)
        assert msg_type is None


class TestDeviceInfoParsing:
    """Test DeviceInfo parsing."""

    def test_parse_device_info_f65_metric(self):
        """Test parsing F65 device info in metric units."""
        # F65: model=145, version=0, metric, max=20.0, min=1.0, incline=15, segment=18
        msg = b'\x5b\x08\xf0\x91\x00\x00\xc8\x0a\x0f\x12\x5d'
        info = parse_device_info(msg)

        assert info is not None
        assert info.model == 145  # 0x91 = F65
        assert info.version == 0
        assert info.units_metric is True
        assert info.max_speed == 20.0  # 200 / 10
        assert info.min_speed == 1.0   # 10 / 10
        assert info.max_incline == 15
        assert info.user_segment == 18
        assert info.units == "metric"

    def test_parse_device_info_f80_imperial(self):
        """Test parsing F80 device info in imperial units."""
        # F80: model=146, version=1, imperial, max=12.0mph, min=0.5mph, incline=15
        msg = b'\x5b\x08\xf0\x92\x01\x01\x78\x05\x0f\x12\x5d'
        info = parse_device_info(msg)

        assert info is not None
        assert info.model == 146  # 0x92 = F80
        assert info.version == 1
        assert info.units_metric is False
        assert info.max_speed == 12.0  # 120 / 10
        assert info.min_speed == 0.5   # 5 / 10
        assert info.max_incline == 15
        assert info.units == "imperial"

    def test_parse_device_info_invalid(self):
        """Test parsing invalid device info."""
        msg = b'\x5b\x02\x03\x01\x5d'  # WorkoutMode, not DeviceInfo
        info = parse_device_info(msg)
        assert info is None

    def test_parse_device_info_too_short(self):
        """Test parsing truncated device info."""
        msg = b'\x5b\x03\xf0\x91\x5d'
        info = parse_device_info(msg)
        assert info is None


class TestWorkoutDataParsing:
    """Test WorkoutData parsing."""

    def test_parse_workout_data_complete(self):
        """Test parsing complete workout data."""
        # Time=5:30, dist=1.52km, cal=85, hr=120, speed=6.2km/h, incline=5%
        msg = b'\x5b\x0f\x06\x05\x1e\x00\x98\x00\x55\x78\x3e\x05\x02\x00\x00\x00\x00\x5d'
        data = parse_workout_data(msg)

        assert data is not None
        assert data.minutes == 5
        assert data.seconds == 30
        assert data.elapsed_time_seconds == 330
        assert data.elapsed_time_formatted == "05:30"
        assert data.distance == 1.52  # (0x0098 = 152) / 100
        assert data.calories == 85    # 0x0055
        assert data.heart_rate == 120 # 0x78
        assert data.speed == 6.2      # 62 / 10
        assert data.incline == 5
        assert data.hr_type == HeartRateType.GRIP

    def test_parse_workout_data_no_hr(self):
        """Test parsing workout data without heart rate."""
        # HR=0, hr_type=NONE
        msg = b'\x5b\x0f\x06\x02\x00\x00\x32\x00\x28\x00\x28\x03\x00\x00\x00\x00\x00\x5d'
        data = parse_workout_data(msg)

        assert data is not None
        assert data.minutes == 2
        assert data.seconds == 0
        assert data.distance == 0.50  # 50 / 100
        assert data.calories == 40    # 0x0028
        assert data.heart_rate == 0
        assert data.speed == 4.0      # 40 / 10
        assert data.incline == 3
        assert data.hr_type == HeartRateType.NONE

    def test_parse_workout_data_chest_hr(self):
        """Test parsing workout data with chest HR sensor."""
        msg = b'\x5b\x0f\x06\x01\x00\x00\x10\x00\x0a\x50\x14\x00\x01\x00\x00\x00\x00\x5d'
        data = parse_workout_data(msg)

        assert data is not None
        assert data.heart_rate == 80  # 0x50
        assert data.hr_type == HeartRateType.CHEST

    def test_parse_workout_data_invalid(self):
        """Test parsing invalid workout data."""
        msg = b'\x5b\x02\x03\x01\x5d'  # WorkoutMode, not WorkoutData
        data = parse_workout_data(msg)
        assert data is None

    def test_parse_workout_data_too_short(self):
        """Test parsing truncated workout data."""
        msg = b'\x5b\x04\x06\x01\x00\x5d'
        data = parse_workout_data(msg)
        assert data is None


class TestWorkoutModeParsing:
    """Test WorkoutMode parsing."""

    def test_parse_workout_mode_idle(self):
        """Test parsing IDLE mode."""
        msg = b'\x5b\x02\x03\x01\x5d'
        mode = parse_workout_mode(msg)
        assert mode == 0x01

    def test_parse_workout_mode_running(self):
        """Test parsing RUNNING mode."""
        msg = b'\x5b\x02\x03\x04\x5d'
        mode = parse_workout_mode(msg)
        assert mode == 0x04

    def test_parse_workout_mode_demo(self):
        """Test parsing DEMO mode."""
        msg = b'\x5b\x02\x03\x80\x5d'
        mode = parse_workout_mode(msg)
        assert mode == 0x80

    def test_parse_workout_mode_invalid(self):
        """Test parsing invalid workout mode."""
        msg = b'\x5b\x08\xf0\x91\x00\x00\xc8\x0a\x0f\x12\x5d'  # DeviceInfo
        mode = parse_workout_mode(msg)
        assert mode is None

    def test_parse_workout_mode_too_short(self):
        """Test parsing truncated workout mode."""
        msg = b'\x5b\x01\x03\x5d'
        mode = parse_workout_mode(msg)
        assert mode is None


class TestModelVariations:
    """Test handling of different treadmill models."""

    def test_f65_running_mode(self):
        """Test F65 running mode (0x04)."""
        msg = b'\x5b\x02\x03\x04\x5d'
        mode = parse_workout_mode(msg)
        assert mode == 0x04

    def test_f80_running_mode(self):
        """Test F80 running mode (also 0x04)."""
        msg = b'\x5b\x02\x03\x04\x5d'
        mode = parse_workout_mode(msg)
        assert mode == 0x04

    def test_unknown_mode_handled(self):
        """Test unknown mode codes are parsed but not validated."""
        # Some hypothetical mode 0x99
        msg = b'\x5b\x02\x03\x99\x5d'
        mode = parse_workout_mode(msg)
        assert mode == 0x99


class TestPassiveProtocol:
    """Test that the library never builds control messages."""

    def test_no_set_workout_mode_builder(self):
        """Verify there's no function to build SET_WORKOUT_MODE messages."""
        # The library should NOT have a build_set_workout_mode function
        # because it's meant to be passive only
        import sole_uart.utils as utils
        assert not hasattr(utils, 'build_set_workout_mode')
        assert not hasattr(utils, 'build_control_command')

    def test_only_passive_messages(self):
        """Verify only passive messages can be built."""
        # GetDeviceInfo - handshake
        msg = build_message(MessageType.DEVICE_INFO)
        assert get_message_type(msg) == MessageType.DEVICE_INFO

        # ACKs - protocol requirement
        ack = build_ack(MessageType.WORKOUT_DATA)
        assert get_message_type(ack) == MessageType.ACK

        # Note: Echo is just writing back received data, not building new messages
