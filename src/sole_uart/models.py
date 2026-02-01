"""Data models for Sole treadmill data."""

from dataclasses import dataclass
from typing import Optional

from .const import HeartRateType, WorkoutMode


@dataclass
class DeviceInfo:
    """Device information and capabilities."""
    model: int
    version: int
    units_metric: bool
    max_speed: float  # km/h or mph
    min_speed: float  # km/h or mph
    max_incline: int  # percentage
    user_segment: int

    @property
    def units(self) -> str:
        """Return units as string."""
        return "metric" if self.units_metric else "imperial"


@dataclass
class WorkoutData:
    """Live workout telemetry data."""
    minutes: int
    seconds: int
    distance: float  # km or miles (converted from raw/100)
    calories: int
    heart_rate: int  # BPM
    speed: float  # km/h or mph (converted from raw/10)
    incline: int  # percentage
    hr_type: HeartRateType
    interval_time: Optional[int] = None  # seconds
    recovery_time: Optional[int] = None  # seconds
    program_row: Optional[int] = None
    program_col: Optional[int] = None

    @property
    def elapsed_time_seconds(self) -> int:
        """Total elapsed time in seconds."""
        return self.minutes * 60 + self.seconds

    @property
    def elapsed_time_formatted(self) -> str:
        """Formatted elapsed time MM:SS."""
        return f"{self.minutes:02d}:{self.seconds:02d}"


@dataclass
class MachineState:
    """Current machine state."""
    mode: WorkoutMode
    device_info: Optional[DeviceInfo] = None
    workout_data: Optional[WorkoutData] = None

    @property
    def is_running(self) -> bool:
        """
        Check if workout is active.

        Considers mode codes that indicate an active workout,
        including model variations (0x02-0x05 range).
        """
        # Handle known running states
        if self.mode in (WorkoutMode.RUNNING, WorkoutMode.PAUSED):
            return True
        # Handle model variations - modes 0x02-0x05 are typically running/starting states
        # (excluding OFF=0x00, IDLE=0x01, and DEMO=0x80)
        return 0x02 <= self.mode <= 0x05

    @property
    def is_idle(self) -> bool:
        """Check if machine is idle and ready."""
        return self.mode == WorkoutMode.IDLE

    @property
    def mode_name(self) -> str:
        """Get human-readable mode name."""
        try:
            return WorkoutMode(self.mode).name
        except ValueError:
            return f"UNKNOWN(0x{self.mode:02x})"
