"""
SOLE Fitness BLE Monitor - Monitor your SOLE/Spirit/XTERRA fitness equipment.
"""

from sole_protocol import (
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

from sole_client import (
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
