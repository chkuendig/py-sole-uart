"""Utility functions for Sole UART protocol."""

from typing import Optional

from .const import (
    ACK_SUFFIX,
    MSG_END_BYTE,
    MSG_START_BYTE,
    HeartRateType,
    MessageType,
)
from .models import DeviceInfo, WorkoutData


def build_message(msg_type: MessageType, payload: bytes = b"") -> bytes:
    """
    Build a Sole UART protocol message.

    Format: 0x5B | Length | Type | Payload... | 0x5D

    Args:
        msg_type: Message type code
        payload: Optional payload bytes

    Returns:
        Complete framed message
    """
    length = 1 + len(payload)
    return bytes([MSG_START_BYTE, length, msg_type]) + payload + bytes([MSG_END_BYTE])


def build_ack(for_msg_type: MessageType) -> bytes:
    """
    Build an ACK message for a given message type.

    Format: 0x5B 0x04 0x00 <msg_type> 'OK' 0x5D

    Args:
        for_msg_type: Message type being acknowledged

    Returns:
        ACK message
    """
    return bytes([MSG_START_BYTE, 0x04, MessageType.ACK, for_msg_type]) + ACK_SUFFIX + bytes([MSG_END_BYTE])


def parse_device_info(data: bytes) -> Optional[DeviceInfo]:
    """
    Parse Device Info (0xF0) message.

    Format: 5B 08 F0 <model> <version> <units> <maxspeed> <minspeed> <maxincline> <userseg> 5D

    Args:
        data: Raw message bytes

    Returns:
        DeviceInfo object or None if invalid
    """
    if len(data) < 10 or data[0] != MSG_START_BYTE or data[-1] != MSG_END_BYTE:
        return None

    if data[2] != MessageType.DEVICE_INFO:
        return None

    return DeviceInfo(
        model=data[3],
        version=data[4],
        units_metric=(data[5] == 0),
        max_speed=data[6] / 10.0,
        min_speed=data[7] / 10.0,
        max_incline=data[8],
        user_segment=data[9],
    )


def parse_workout_data(data: bytes) -> Optional[WorkoutData]:
    """
    Parse Workout Data (0x06) message.

    Format: 5B 0F 06 <min> <sec> <dist_h> <dist_l> <cal_h> <cal_l> <hr> <speed> <incline> <hrtype> <inttime> <rectime> <prow> <pcol> 5D

    Args:
        data: Raw message bytes

    Returns:
        WorkoutData object or None if invalid
    """
    if len(data) < 17 or data[0] != MSG_START_BYTE or data[-1] != MSG_END_BYTE:
        return None

    if data[2] != MessageType.WORKOUT_DATA:
        return None

    # Parse heart rate type
    hr_type_raw = data[12] if len(data) > 12 else 0
    try:
        hr_type = HeartRateType(hr_type_raw)
    except ValueError:
        hr_type = HeartRateType.NONE

    return WorkoutData(
        minutes=data[3],
        seconds=data[4],
        distance=((data[5] << 8) | data[6]) / 100.0,
        calories=(data[7] << 8) | data[8],
        heart_rate=data[9],
        speed=data[10] / 10.0,
        incline=data[11],
        hr_type=hr_type,
        interval_time=data[13] if len(data) > 13 else None,
        recovery_time=data[14] if len(data) > 14 else None,
        program_row=data[15] if len(data) > 15 else None,
        program_col=data[16] if len(data) > 16 else None,
    )


def parse_workout_mode(data: bytes) -> Optional[int]:
    """
    Parse Workout Mode (0x03) message.

    Format: 5B 02 03 <mode> 5D

    Args:
        data: Raw message bytes

    Returns:
        Workout mode value or None if invalid
    """
    if len(data) < 5 or data[0] != MSG_START_BYTE or data[-1] != MSG_END_BYTE:
        return None

    if data[2] != MessageType.WORKOUT_MODE:
        return None

    return data[3]


def get_message_type(data: bytes) -> Optional[MessageType]:
    """
    Extract message type from raw message.

    Args:
        data: Raw message bytes

    Returns:
        MessageType or None if invalid
    """
    if len(data) < 4 or data[0] != MSG_START_BYTE or data[-1] != MSG_END_BYTE:
        return None

    try:
        return MessageType(data[2])
    except ValueError:
        return None
