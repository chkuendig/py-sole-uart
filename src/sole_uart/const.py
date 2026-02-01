"""Constants for Sole UART protocol."""

from enum import IntEnum

# Sole UART Service and Characteristics
SOLE_UART_SERVICE = "49535343-fe7d-4ae5-8fa9-9fafd205e455"
SOLE_UART_NOTIFY = "49535343-1e4d-4bd9-ba61-23c647249616"
SOLE_UART_WRITE = "49535343-8841-43f4-a8d4-ecbe34729bb3"

# Standard FTMS Service (for detection)
FTMS_SERVICE = "00001826-0000-1000-8000-00805f9b34fb"

# Device detection
MICROCHIP_COMPANY_ID = 0x0157
SOLE_NAME_PREFIXES = ("F63", "F65", "F80", "F85", "TT8", "E25", "E35")

# Message framing
MSG_START_BYTE = 0x5B  # ASCII '['
MSG_END_BYTE = 0x5D    # ASCII ']'


class MessageType(IntEnum):
    """UART message types."""
    ACK = 0x00
    SET_WORKOUT_MODE = 0x02
    WORKOUT_MODE = 0x03
    WORKOUT_TARGET = 0x04
    WORKOUT_DATA = 0x06
    USER_PROFILE = 0x07
    PROGRAM = 0x08
    HEART_RATE_TYPE = 0x09
    ERROR_CODE = 0x10
    SPEED = 0x11
    INCLINE = 0x12
    END_WORKOUT = 0x32
    DEVICE_INFO = 0xF0
    COMMAND = 0xF1


class WorkoutMode(IntEnum):
    """
    Workout mode states.

    Note: Mode codes vary between models:
    - F80: RUNNING = 0x04
    - F65: RUNNING appears to be 0x04 as well
    - Some models may use different codes

    This enum defines the most common codes, but the library
    handles unknown modes gracefully.
    """
    OFF = 0x00
    IDLE = 0x01
    FINISHED = 0x03
    RUNNING = 0x04  # F65/F80 running state
    PAUSED = 0x05
    DEMO = 0x80  # Demo mode - BLE commands ignored


class HeartRateType(IntEnum):
    """Heart rate sensor types."""
    NONE = 0x00
    CHEST = 0x01
    GRIP = 0x02


# ACK suffix
ACK_SUFFIX = bytes([ord('O'), ord('K')])  # 'OK'
