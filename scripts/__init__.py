"""
SOLE Fitness BLE Monitor - Monitor your SOLE/Spirit/XTERRA fitness equipment.

This directory contains test scripts and examples. The main library is in src/sole_uart/
"""

# Import from the library in src/
import sys
from pathlib import Path
sys.path.insert(0, str(Path(__file__).parent.parent / 'src'))

from sole_uart.protocol import (
    ServiceUUID,
    CharacteristicUUID,
    Command,
    DeviceType,
    DeviceBrand,
    WorkoutMode,
    HRType,
    DeviceInfo,
    WorkoutData,
    EndWorkoutData,
    ProtocolParser,
    CommandBuilder,
)

from sole_uart.client import (
    SoleDevice,
    SoleMonitor,
    SoleController,
)

__version__ = "0.1.0"
__all__ = [
    # UUIDs
    "ServiceUUID",
    "CharacteristicUUID",
    # Enums
    "Command",
    "DeviceType",
    "DeviceBrand",
    "WorkoutMode",
    "HRType",
    # Data classes
    "DeviceInfo",
    "WorkoutData",
    "EndWorkoutData",
    "SoleDevice",
    # Parser
    "ProtocolParser",
    "CommandBuilder",
    # Client
    "SoleMonitor",
    "SoleController",
]
