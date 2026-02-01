"""Sole UART - Async Python client for Sole treadmill UART protocol over Bluetooth LE."""

from .client import SoleClient
from .const import HeartRateType, MessageType, WorkoutMode
from .discovery import find_sole_device, has_sole_uart_service, is_sole_device
from .models import DeviceInfo, MachineState, WorkoutData

__version__ = "0.1.0"

__all__ = [
    # Main client
    "SoleClient",
    # Discovery
    "find_sole_device",
    "is_sole_device",
    "has_sole_uart_service",
    # Models
    "DeviceInfo",
    "WorkoutData",
    "MachineState",
    # Enums
    "WorkoutMode",
    "HeartRateType",
    "MessageType",
]
