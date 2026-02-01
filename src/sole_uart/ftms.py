"""
FTMS (Fitness Machine Service) support for SOLE equipment.

The SOLE F65 and similar models support the standard Bluetooth FTMS protocol
in addition to the proprietary SOLE protocol. FTMS provides basic workout
data (speed, HR) that works even when the workout is started from the console.

The proprietary protocol provides more data (incline, calories, distance) but
only works when the workout is started/controlled from the app.
"""

import struct
from dataclasses import dataclass
from enum import IntEnum
from typing import Optional


class FTMSService:
    """FTMS Service UUIDs."""
    SERVICE = "00001826-0000-1000-8000-00805f9b34fb"

    # Characteristics
    FEATURE = "00002acc-0000-1000-8000-00805f9b34fb"
    TREADMILL_DATA = "00002acd-0000-1000-8000-00805f9b34fb"
    CROSS_TRAINER_DATA = "00002ace-0000-1000-8000-00805f9b34fb"
    INDOOR_BIKE_DATA = "00002ad2-0000-1000-8000-00805f9b34fb"
    TRAINING_STATUS = "00002ad3-0000-1000-8000-00805f9b34fb"
    SUPPORTED_SPEED_RANGE = "00002ad4-0000-1000-8000-00805f9b34fb"
    SUPPORTED_INCLINE_RANGE = "00002ad5-0000-1000-8000-00805f9b34fb"
    CONTROL_POINT = "00002ad9-0000-1000-8000-00805f9b34fb"
    STATUS = "00002ada-0000-1000-8000-00805f9b34fb"


class TrainingStatus(IntEnum):
    """FTMS Training Status values."""
    OTHER = 0x00
    IDLE = 0x01
    WARMING_UP = 0x02
    LOW_INTENSITY = 0x03
    HIGH_INTENSITY = 0x04
    RECOVERY = 0x05
    ISOMETRIC = 0x06
    HEART_RATE_CONTROL = 0x07
    FITNESS_TEST = 0x08
    SPEED_OUTSIDE_CONTROL = 0x09
    CADENCE_OUTSIDE_CONTROL = 0x0A
    RESISTANCE_OUTSIDE_CONTROL = 0x0B
    POWER_OUTSIDE_CONTROL = 0x0C
    MANUAL_MODE = 0x0D
    PRE_WORKOUT = 0x0E
    POST_WORKOUT = 0x0F


@dataclass
class FTMSTreadmillData:
    """Parsed FTMS Treadmill Data."""
    speed_kmh: float = 0.0
    avg_speed_kmh: Optional[float] = None
    distance_m: Optional[int] = None
    incline_pct: Optional[float] = None
    ramp_deg: Optional[float] = None
    pos_elevation_m: Optional[float] = None
    neg_elevation_m: Optional[float] = None
    pace_min_km: Optional[float] = None
    avg_pace_min_km: Optional[float] = None
    total_calories: Optional[int] = None
    cal_per_hour: Optional[int] = None
    cal_per_min: Optional[int] = None
    heart_rate: Optional[int] = None
    mets: Optional[float] = None
    elapsed_seconds: Optional[int] = None
    remaining_seconds: Optional[int] = None
    force_n: Optional[int] = None
    power_w: Optional[int] = None

    @property
    def speed_mph(self) -> float:
        return self.speed_kmh * 0.621371

    @property
    def elapsed_str(self) -> str:
        if self.elapsed_seconds is None:
            return "--:--"
        mins, secs = divmod(self.elapsed_seconds, 60)
        return f"{mins:02d}:{secs:02d}"


def parse_treadmill_data(data: bytes) -> FTMSTreadmillData:
    """
    Parse FTMS Treadmill Data characteristic (0x2ACD).

    Reference: Bluetooth FTMS specification, Section 4.9
    """
    result = FTMSTreadmillData()

    if len(data) < 2:
        return result

    flags = struct.unpack('<H', data[0:2])[0]
    offset = 2

    # Bit 0: More Data (0 = instantaneous speed present)
    if not (flags & 0x0001):
        if len(data) >= offset + 2:
            result.speed_kmh = struct.unpack('<H', data[offset:offset+2])[0] / 100.0
            offset += 2

    # Bit 1: Average Speed Present
    if (flags & 0x0002):
        if len(data) >= offset + 2:
            result.avg_speed_kmh = struct.unpack('<H', data[offset:offset+2])[0] / 100.0
            offset += 2

    # Bit 2: Total Distance Present (3 bytes, uint24)
    if (flags & 0x0004):
        if len(data) >= offset + 3:
            result.distance_m = data[offset] | (data[offset+1] << 8) | (data[offset+2] << 16)
            offset += 3

    # Bit 3: Inclination and Ramp Angle Present
    if (flags & 0x0008):
        if len(data) >= offset + 4:
            result.incline_pct = struct.unpack('<h', data[offset:offset+2])[0] / 10.0
            result.ramp_deg = struct.unpack('<h', data[offset+2:offset+4])[0] / 10.0
            offset += 4

    # Bit 4: Elevation Gain Present
    if (flags & 0x0010):
        if len(data) >= offset + 4:
            result.pos_elevation_m = struct.unpack('<H', data[offset:offset+2])[0] / 10.0
            result.neg_elevation_m = struct.unpack('<H', data[offset+2:offset+4])[0] / 10.0
            offset += 4

    # Bit 5: Instantaneous Pace Present
    if (flags & 0x0020):
        if len(data) >= offset + 1:
            result.pace_min_km = data[offset] / 10.0
            offset += 1

    # Bit 6: Average Pace Present
    if (flags & 0x0040):
        if len(data) >= offset + 1:
            result.avg_pace_min_km = data[offset] / 10.0
            offset += 1

    # Bit 7: Expended Energy Present
    if (flags & 0x0080):
        if len(data) >= offset + 5:
            result.total_calories = struct.unpack('<H', data[offset:offset+2])[0]
            result.cal_per_hour = struct.unpack('<H', data[offset+2:offset+4])[0]
            result.cal_per_min = data[offset+4]
            offset += 5

    # Bit 8: Heart Rate Present
    if (flags & 0x0100):
        if len(data) >= offset + 1:
            result.heart_rate = data[offset]
            offset += 1

    # Bit 9: Metabolic Equivalent Present
    if (flags & 0x0200):
        if len(data) >= offset + 1:
            result.mets = data[offset] / 10.0
            offset += 1

    # Bit 10: Elapsed Time Present
    if (flags & 0x0400):
        if len(data) >= offset + 2:
            result.elapsed_seconds = struct.unpack('<H', data[offset:offset+2])[0]
            offset += 2

    # Bit 11: Remaining Time Present
    if (flags & 0x0800):
        if len(data) >= offset + 2:
            result.remaining_seconds = struct.unpack('<H', data[offset:offset+2])[0]
            offset += 2

    # Bit 12: Force on Belt and Power Output Present
    if (flags & 0x1000):
        if len(data) >= offset + 4:
            result.force_n = struct.unpack('<h', data[offset:offset+2])[0]
            result.power_w = struct.unpack('<h', data[offset+2:offset+4])[0]
            offset += 4

    return result


@dataclass
class FTMSFeatures:
    """Parsed FTMS Feature characteristic."""
    avg_speed: bool = False
    cadence: bool = False
    total_distance: bool = False
    inclination: bool = False
    elevation_gain: bool = False
    pace: bool = False
    step_count: bool = False
    resistance_level: bool = False
    stride_count: bool = False
    expended_energy: bool = False
    heart_rate: bool = False
    metabolic_equivalent: bool = False
    elapsed_time: bool = False
    remaining_time: bool = False
    power_measurement: bool = False
    force_on_belt: bool = False


def parse_features(data: bytes) -> FTMSFeatures:
    """Parse FTMS Feature characteristic (0x2ACC)."""
    features = FTMSFeatures()

    if len(data) >= 4:
        bits = struct.unpack('<I', data[0:4])[0]

        features.avg_speed = bool(bits & 0x0001)
        features.cadence = bool(bits & 0x0002)
        features.total_distance = bool(bits & 0x0004)
        features.inclination = bool(bits & 0x0008)
        features.elevation_gain = bool(bits & 0x0010)
        features.pace = bool(bits & 0x0020)
        features.step_count = bool(bits & 0x0040)
        features.resistance_level = bool(bits & 0x0080)
        features.stride_count = bool(bits & 0x0100)
        features.expended_energy = bool(bits & 0x0200)
        features.heart_rate = bool(bits & 0x0400)
        features.metabolic_equivalent = bool(bits & 0x0800)
        features.elapsed_time = bool(bits & 0x1000)
        features.remaining_time = bool(bits & 0x2000)
        features.power_measurement = bool(bits & 0x4000)
        features.force_on_belt = bool(bits & 0x8000)

    return features
