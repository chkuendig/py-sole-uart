"""
SOLE Fitness BLE Protocol definitions.

Reverse-engineered from SOLE Fitness App v1.7.08 (Dyaco ideabussdk_sole SDK).

This module implements the proprietary UART protocol used by Dyaco-manufactured
fitness equipment sold under multiple brands:
- SOLE Fitness (F63, F65, F80, F85, E25, E35, E55, E95, B94, R92, LCB, LCR)
- Spirit Fitness (XT series, XE series, XBR/XBU series)
- XTERRA Fitness (TRX series)
- Fuel Fitness

The BLE layer uses ISSC/Microchip "Transparent UART" (UUID prefix 49535343).
All brands share identical firmware and command protocol.

See PROTOCOL_ANALYSIS.md for full protocol documentation.
"""

from dataclasses import dataclass, field
from enum import IntEnum
from typing import Optional
import struct


# =============================================================================
# BLE UUIDs
# =============================================================================

class ServiceUUID:
    """BLE Service UUIDs for SOLE equipment."""
    # Primary service (ISSC/Microchip transparent UART)
    PRIMARY = "49535343-fe7d-4ae5-8fa9-9fafd205e455"
    # Secondary/fallback service
    SECONDARY = "0000fff0-0000-1000-8000-00805f9b34fb"


class CharacteristicUUID:
    """BLE Characteristic UUIDs for SOLE equipment."""
    # Primary service characteristics
    PRIMARY_WRITE = "49535343-8841-43f4-a8d4-ecbe34729bb3"
    PRIMARY_NOTIFY = "49535343-1e4d-4bd9-ba61-23c647249616"
    # Secondary service characteristics
    SECONDARY_WRITE = "0000fff2-0000-1000-8000-00805f9b34fb"
    SECONDARY_NOTIFY = "0000fff1-0000-1000-8000-00805f9b34fb"
    # Client Characteristic Configuration Descriptor
    CCCD = "00002902-0000-1000-8000-00805f9b34fb"


# =============================================================================
# Protocol Constants
# =============================================================================

START_BYTE = 0x5B  # '['
END_BYTE = 0x5D    # ']'


class Command(IntEnum):
    """Protocol command codes."""
    SET_MODE = 0x02
    GET_MODE = 0x03
    SET_WORKOUT_TIME = 0x04
    GET_WORKOUT_DATA = 0x06
    SET_USER_PROFILE = 0x07
    SET_PROGRAM_MODE = 0x08
    GET_HR_TYPE = 0x09
    ERROR_CODE = 0x10
    GET_SPEED = 0x11
    GET_INCLINE = 0x12
    GET_LEVEL = 0x13
    GET_RPM = 0x14
    GET_HEART_RATE = 0x15
    SET_TARGET_WATT = 0x19
    SET_TARGET_HR = 0x20
    SET_MAX_SPEED = 0x21
    SET_MAX_INCLINE = 0x22
    SET_MAX_LEVEL = 0x23
    SET_USER_SPEED = 0x24
    SET_USER_INCLINE = 0x25
    SET_USER_LEVEL = 0x26
    END_WORKOUT = 0x32
    SET_FUSION_PROGRAM = 0x35
    PROGRAM_DATA = 0x40
    DEVICE_INFO = 0xF0
    DEVICE_STATUS = 0xF1
    # Note: Increment/Decrement commands (0xF102-0xF105) are built using 0xF1 + subcommand
    # See CommandBuilder.speed_up(), speed_down(), incline_up(), incline_down()


class DeviceType(IntEnum):
    """Equipment type."""
    TREADMILL = 0
    ELLIPTICAL = 1
    BIKE = 2


class DeviceBrand(IntEnum):
    """Equipment brand."""
    SOLE = 1
    SPIRIT = 0
    XTERRA = 2
    FUEL = 3


class WorkoutMode(IntEnum):
    """Workout/operating mode."""
    STOP = 0x01
    IDLE = 0x02
    RUNNING = 0x03
    PAUSE = 0x04
    COOLDOWN = 0x05
    SUMMARY = 0x06
    SLEEP = 0x07
    READY = 0x80  # Standby/ready mode, waiting for user to start


class HRType(IntEnum):
    """Heart rate sensor type."""
    NONE = 0
    HAND_GRIP = 1
    CHEST_STRAP = 2
    WIRELESS = 3


# =============================================================================
# Data Classes
# =============================================================================

@dataclass
class DeviceInfo:
    """Device information received from DEVICE_INFO (0xF0) command."""
    model: int = 0
    device_type: DeviceType = DeviceType.TREADMILL
    brand: DeviceBrand = DeviceBrand.SOLE
    sales_version: int = 0  # 0 = international, 1 = US
    unit: int = 0  # 0 = metric, 1 = imperial
    max_speed: int = 0
    min_speed: int = 0
    max_incline: int = 0
    max_level: int = 0
    user_segment: int = 0
    show_incline_mode: int = 0
    has_max_incline: bool = False

    @property
    def is_metric(self) -> bool:
        return self.unit == 0

    @property
    def is_us_version(self) -> bool:
        return self.sales_version == 1


@dataclass
class WorkoutData:
    """Real-time workout data received from GET_WORKOUT_DATA (0x06) command."""
    # Time
    minutes: int = 0
    seconds: int = 0

    # Core metrics
    distance: float = 0.0  # in km or miles depending on unit
    calories: float = 0.0
    heart_rate: int = 0
    hr_type: HRType = HRType.NONE

    # Speed/cadence (depends on device type)
    speed: float = 0.0  # km/h or mph
    rpm: int = 0  # for bikes/ellipticals
    spm: int = 0  # steps per minute (elliptical)

    # Resistance
    incline: int = 0  # treadmill incline or elliptical ramp
    level: int = 0  # resistance level (bikes/ellipticals)

    # Power
    watt: int = 0
    mets: float = 0.0

    # Program info
    program_row: int = 0
    program_height: int = 0

    # Fusion/interval training
    fusion_interval_time: int = 0
    fusion_recovery_time: int = 0

    # Elliptical specific
    total_steps: int = 0
    vert: int = 0  # vertical feet

    # Calculated
    laps: int = 0
    pace_minutes: int = 0
    pace_seconds: int = 0
    cal_per_hour: float = 0.0

    @property
    def total_seconds(self) -> int:
        return self.minutes * 60 + self.seconds

    @property
    def pace_str(self) -> str:
        return f"{self.pace_minutes}:{self.pace_seconds:02d}"


@dataclass
class EndWorkoutData:
    """Workout summary received from END_WORKOUT (0x32) command."""
    total_seconds: int = 0
    distance: float = 0.0
    calories: float = 0.0
    speed: float = 0.0
    heart_rate: int = 0
    incline: int = 0
    level: int = 0
    rpm: int = 0
    watt: int = 0
    mets: float = 0.0


# =============================================================================
# Protocol Parser
# =============================================================================

class ProtocolParser:
    """
    Parser for SOLE BLE protocol messages.

    Messages are framed as: [0x5B][LENGTH][CMD][DATA...][0x5D]
    Data is transmitted as hex-encoded ASCII strings.
    """

    def __init__(self):
        self.device_info: Optional[DeviceInfo] = None
        self._buffer = ""
        # Overflow tracking for certain models
        self._calc_dis_count = 0
        self._calc_cal_count = 0
        self._is_calc_dis = False
        self._is_calc_cal = False
        self._total_distance = 0.0
        self._total_calories = 0.0

    def feed(self, data: bytes) -> list:
        """
        Feed raw BLE data into the parser.

        Args:
            data: Raw bytes received from BLE notification

        Returns:
            List of parsed messages (WorkoutData, DeviceInfo, etc.)
        """
        # Convert bytes to hex string (protocol uses hex-encoded ASCII)
        if isinstance(data, bytes):
            hex_str = data.hex().upper()
        else:
            hex_str = str(data).upper()

        self._buffer += hex_str
        messages = []

        # Process complete messages
        while True:
            # Find start marker
            start_idx = self._buffer.find("5B")
            if start_idx == -1:
                self._buffer = ""
                break

            # Trim anything before start
            if start_idx > 0:
                self._buffer = self._buffer[start_idx:]

            # Need at least header: 5B + length(2) + cmd(2) + 5D = 8 chars
            if len(self._buffer) < 8:
                break

            # Parse length
            try:
                length = int(self._buffer[2:4], 16)
            except ValueError:
                self._buffer = self._buffer[2:]
                continue

            # Calculate full message length: 5B(2) + len(2) + data(length*2) + 5D(2)
            msg_len = 2 + 2 + (length * 2) + 2

            if len(self._buffer) < msg_len:
                break  # Wait for more data

            # Check end marker
            if self._buffer[msg_len-2:msg_len] != "5D":
                self._buffer = self._buffer[2:]
                continue

            # Extract and parse message
            msg = self._buffer[:msg_len]
            self._buffer = self._buffer[msg_len:]

            parsed = self._parse_message(msg)
            if parsed is not None:
                messages.append(parsed)

        return messages

    def _parse_message(self, msg: str):
        """Parse a complete message."""
        # Strip start/end markers
        inner = msg[2:-2]  # Remove 5B and 5D

        if len(inner) < 4:
            return None

        # Get command byte
        cmd = int(inner[2:4], 16)

        # Handle command 0x00 prefix (some responses use 00 XX format)
        if cmd == 0 and len(inner) >= 6:
            cmd = int(inner[4:6], 16)

        try:
            if cmd == Command.DEVICE_INFO:
                return self._parse_device_info(inner)
            elif cmd == Command.GET_WORKOUT_DATA:
                return self._parse_workout_data(inner)
            elif cmd == Command.END_WORKOUT:
                return self._parse_end_workout(inner)
            elif cmd == Command.GET_MODE:
                return self._parse_mode(inner)
            elif cmd == Command.ERROR_CODE:
                return self._parse_error(inner)
            else:
                # Return raw for unknown commands
                return {"cmd": cmd, "raw": inner}
        except Exception as e:
            return {"cmd": cmd, "error": str(e), "raw": inner}

    def _parse_device_info(self, data: str) -> DeviceInfo:
        """Parse DEVICE_INFO (0xF0) response."""
        info = DeviceInfo()

        info.model = int(data[4:6], 16)
        info.sales_version = int(data[6:8], 16)
        info.unit = int(data[8:10], 16)

        # Determine device type from model number
        model = info.model
        if (0 <= model < 3) or (16 <= model < 22) or (37 <= model < 39) or \
           (96 <= model < 98) or model in [14, 84, 85, 87, 88]:
            info.device_type = DeviceType.ELLIPTICAL
        elif model == 39 or (3 <= model < 16) or (22 <= model < 32) or \
             (48 <= model < 64) or (100 <= model <= 106) or (112 <= model <= 119) or \
             model in [83, 86, 99]:
            info.device_type = DeviceType.BIKE
        elif 128 <= model < 192:
            info.device_type = DeviceType.TREADMILL
        else:
            info.device_type = DeviceType.ELLIPTICAL

        # Determine brand from model number
        if (16 <= model < 32) or (144 <= model < 160):
            info.brand = DeviceBrand.SPIRIT
        elif (0 <= model < 16) or (83 <= model <= 88) or \
             (128 <= model < 144) or (96 <= model < 98):
            info.brand = DeviceBrand.SOLE
        elif (48 <= model < 64) or (160 <= model < 176) or (112 <= model <= 119):
            info.brand = DeviceBrand.XTERRA
        elif (32 <= model < 48) or (100 <= model <= 106) or (176 <= model < 192):
            info.brand = DeviceBrand.FUEL

        # Parse device-specific parameters
        if info.device_type in (DeviceType.ELLIPTICAL, DeviceType.BIKE):
            if len(data) >= 20:
                info.max_incline = int(data[10:12], 16)
                info.max_level = int(data[12:14], 16)
                info.user_segment = int(data[14:16], 16)
                info.show_incline_mode = int(data[16:18], 16)
                info.has_max_incline = int(data[18:20], 16) == 1
        elif info.device_type == DeviceType.TREADMILL:
            if len(data) >= 18:
                info.max_speed = int(data[10:12], 16)
                info.min_speed = int(data[12:14], 16)
                info.max_incline = int(data[14:16], 16)
                info.user_segment = int(data[16:18], 16)

        self.device_info = info
        return info

    def _parse_workout_data(self, data: str) -> WorkoutData:
        """Parse GET_WORKOUT_DATA (0x06) response."""
        workout = WorkoutData()

        # Common fields
        workout.minutes = int(data[4:6], 16)
        workout.seconds = int(data[6:8], 16)

        raw_distance = int(data[8:12], 16)
        raw_calories = int(data[12:16], 16)

        workout.distance = raw_distance / 100.0
        workout.heart_rate = int(data[16:18], 16)

        device_type = self.device_info.device_type if self.device_info else DeviceType.TREADMILL
        model = self.device_info.model if self.device_info else 0

        if device_type in (DeviceType.ELLIPTICAL, DeviceType.BIKE):
            # Special handling for certain elliptical models
            if model in [10, 30, 31]:
                workout.calories = raw_calories / 1.0
                workout.level = int(data[18:20], 16) + 1
                workout.incline = int(data[20:24], 16)
                workout.spm = int(data[24:28], 16)
                workout.total_steps = int(data[28:36], 16)
                workout.vert = int(data[36:44], 16)
                workout.watt = int(data[44:48], 16)
                workout.hr_type = HRType(int(data[48:50], 16)) if len(data) > 50 else HRType.NONE
                if len(data) >= 58:
                    workout.program_row = int(data[54:56], 16)
                    workout.program_height = int(data[56:58], 16)
            else:
                # Standard bike/elliptical
                workout.calories = raw_calories / 10.0
                workout.rpm = int(data[18:20], 16)
                workout.speed = int(data[20:24], 16) / 100.0
                workout.watt = int(data[24:28], 16)
                if len(data) >= 40:
                    workout.hr_type = HRType(int(data[32:34], 16)) if int(data[32:34], 16) < 4 else HRType.NONE
                    workout.fusion_interval_time = int(data[34:36], 16)
                    workout.fusion_recovery_time = int(data[36:38], 16)
                    workout.program_row = int(data[38:40], 16)
                workout.spm = workout.rpm * 2

            # Calculate METS
            if self.device_info and workout.watt > 0:
                weight = 70.0  # Default weight in kg
                mets = ((workout.watt * 6 / weight) * 1.8 + 7.0) / 3.5
                workout.mets = round(mets, 2) if workout.rpm > 0 else 1.0

        elif device_type == DeviceType.TREADMILL:
            workout.calories = raw_calories / 1.0
            workout.speed = int(data[18:20], 16) / 10.0
            workout.incline = int(data[20:22], 16)
            if len(data) >= 32:
                workout.hr_type = HRType(int(data[22:24], 16)) if int(data[22:24], 16) < 4 else HRType.NONE
                workout.fusion_interval_time = int(data[24:26], 16)
                workout.fusion_recovery_time = int(data[26:28], 16)
                workout.program_row = int(data[28:30], 16)
                workout.program_height = int(data[30:32], 16)

            # Calculate pace
            if workout.speed > 0:
                pace_total_seconds = int(3600 / workout.speed)
                workout.pace_minutes = pace_total_seconds // 60
                workout.pace_seconds = pace_total_seconds % 60

        return workout

    def _parse_end_workout(self, data: str) -> EndWorkoutData:
        """Parse END_WORKOUT (0x32) response."""
        end = EndWorkoutData()

        end.total_seconds = int(data[4:8], 16)
        end.distance = int(data[8:12], 16) / 100.0
        end.calories = int(data[12:16], 16)

        device_type = self.device_info.device_type if self.device_info else DeviceType.TREADMILL

        if device_type in (DeviceType.ELLIPTICAL, DeviceType.BIKE):
            end.calories = end.calories / 10.0
            if len(data) >= 26:
                end.speed = int(data[16:20], 16) / 100.0
                end.heart_rate = int(data[20:22], 16)
                end.incline = int(data[22:24], 16)
                end.level = int(data[24:26], 16)
        elif device_type == DeviceType.TREADMILL:
            if len(data) >= 24:
                end.speed = int(data[16:20], 16) / 100.0
                end.heart_rate = int(data[20:22], 16)
                end.incline = int(data[22:24], 16)

        return end

    def _parse_mode(self, data: str) -> dict:
        """Parse GET_MODE (0x03) response."""
        mode_val = int(data[4:6], 16)
        try:
            mode = WorkoutMode(mode_val)
        except ValueError:
            # Unknown mode value - return as int
            mode = mode_val
        return {"cmd": Command.GET_MODE, "mode": mode, "mode_value": mode_val}

    def _parse_error(self, data: str) -> dict:
        """Parse ERROR_CODE (0x10) response."""
        error_code = int(data[4:6], 16)
        return {"cmd": Command.ERROR_CODE, "error_code": error_code}


# =============================================================================
# Command Builder (for control, optional)
# =============================================================================

class ProgramType(IntEnum):
    """Workout program types (from treadonme)."""
    MANUAL = 0x1001
    HILL = 0x2002
    FAT_BURN = 0x2003
    CARDIO = 0x2004
    STRENGTH = 0x2005
    INTERVAL = 0x2006
    USER1 = 0x3007
    USER2 = 0x3008
    HR1 = 0x3009
    HR2 = 0x300A
    FUSION = 0x600C


class SexType(IntEnum):
    """User sex type."""
    MALE = 0
    FEMALE = 1


class CommandBuilder:
    """
    Builder for SOLE protocol commands.

    Note: For monitoring only, you typically don't need to send commands.
    The equipment broadcasts workout data automatically during operation.
    """

    @staticmethod
    def _build(cmd: int, data: str = "") -> bytes:
        """Build a command frame."""
        payload = f"{cmd:02X}{data}"
        length = len(payload) // 2
        frame = f"5B{length:02X}{payload}5D"
        return bytes.fromhex(frame)

    @classmethod
    def get_device_info(cls) -> bytes:
        """Request device information."""
        return cls._build(Command.DEVICE_INFO)

    @classmethod
    def get_mode(cls) -> bytes:
        """Request current operating mode."""
        return cls._build(Command.GET_MODE)

    @classmethod
    def get_workout_data(cls) -> bytes:
        """Request current workout data."""
        return cls._build(Command.GET_WORKOUT_DATA)

    # =========================================================================
    # Echo/Acknowledgment Commands (for passive monitoring)
    # =========================================================================

    @classmethod
    def echo_mode(cls, mode: int) -> bytes:
        """
        Echo back a WorkoutMode message (passive monitoring technique).

        When the treadmill sends a WorkoutMode (0x03) message, echo it back
        unchanged. This acknowledges receipt and keeps the data stream flowing
        WITHOUT taking control from the console.

        Args:
            mode: The mode value received from the treadmill

        Returns:
            Command bytes to send back
        """
        return cls._build(Command.GET_MODE, f"{mode:02X}")

    @classmethod
    def ack_command(cls, cmd: int) -> bytes:
        """
        Send an acknowledgment for a received command.

        Format: [0x00][CMD][0x4F][0x4B] where 0x4F4B = "OK"

        Args:
            cmd: The command code being acknowledged

        Returns:
            Acknowledgment bytes
        """
        return cls._build(0x00, f"{cmd:02X}4F4B")

    # =========================================================================
    # Control Commands (may cause console lockout - use with caution)
    # =========================================================================

    @classmethod
    def set_mode(cls, mode: WorkoutMode) -> bytes:
        """
        Set the workout mode.

        WARNING: This may take control from the console and cause lockout.
        For passive monitoring, use echo_mode() instead.

        Args:
            mode: Target workout mode

        Returns:
            Command bytes
        """
        return cls._build(Command.SET_MODE, f"{mode:02X}")

    @classmethod
    def set_user_profile(cls, sex: SexType = SexType.MALE, age: int = 30,
                         weight: int = 70, height: int = 175) -> bytes:
        """
        Set user profile for calorie calculations.

        Args:
            sex: Male (0) or Female (1)
            age: Age in years
            weight: Weight in kg (or lbs depending on device unit)
            height: Height in cm (or inches depending on device unit)

        Returns:
            Command bytes
        """
        data = f"{sex:02X}{age:02X}{weight:02X}{height:02X}"
        return cls._build(Command.SET_USER_PROFILE, data)

    @classmethod
    def set_program_mode(cls, program: ProgramType = ProgramType.MANUAL) -> bytes:
        """
        Set the workout program type.

        Args:
            program: Program type (MANUAL recommended for control without lockout)

        Returns:
            Command bytes
        """
        # Program is sent as 2 bytes
        data = f"{(program >> 8) & 0xFF:02X}{program & 0xFF:02X}"
        return cls._build(Command.SET_PROGRAM_MODE, data)

    @classmethod
    def set_max_speed(cls, speed_tenths: int) -> bytes:
        """
        Set target/max speed.

        **Applies to: Treadmills only** (deviceType=0, model 128-191)

        This controls the belt speed. Not applicable to bikes/ellipticals
        where the user controls their own cadence.

        Args:
            speed_tenths: Speed in tenths of km/h (e.g., 85 = 8.5 km/h)
                         Check device_info.max_speed and min_speed for valid range.

        Returns:
            Command bytes
        """
        # Speed is 0-indexed in protocol (subtract 1)
        val = max(0, speed_tenths - 1)
        return cls._build(Command.SET_MAX_SPEED, f"{val:02X}")

    @classmethod
    def set_max_incline(cls, incline_pct: int) -> bytes:
        """
        Set target/max incline (belt angle).

        **Applies to: Treadmills** (deviceType=0)
        **Applies to: Some Ellipticals** (deviceType=1) - check device_info.has_max_incline

        For treadmills: controls the belt angle/grade.
        For ellipticals: controls the ramp angle (if supported).
        Not applicable to bikes.

        Args:
            incline_pct: Incline percentage (0-15 typical for treadmills)
                        Check device_info.max_incline for valid range.

        Returns:
            Command bytes
        """
        # Incline is 0-indexed in protocol (subtract 1)
        val = max(0, incline_pct - 1)
        return cls._build(Command.SET_MAX_INCLINE, f"{val:02X}")

    @classmethod
    def set_max_level(cls, level: int) -> bytes:
        """
        Set resistance level.

        **Applies to: Bikes** (deviceType=2) and **Ellipticals** (deviceType=1)

        This controls how hard it is to pedal/stride. Higher level = more resistance.
        Not applicable to treadmills (use set_max_speed/set_max_incline instead).

        Args:
            level: Resistance level (1-20 typical)
                  Check device_info.max_level for valid range.

        Returns:
            Command bytes
        """
        # Level is 0-indexed in protocol (subtract 1)
        val = max(0, level - 1)
        return cls._build(Command.SET_MAX_LEVEL, f"{val:02X}")

    @classmethod
    def set_target_hr(cls, hr: int) -> bytes:
        """
        Set target heart rate.

        Args:
            hr: Target heart rate in bpm

        Returns:
            Command bytes
        """
        return cls._build(Command.SET_TARGET_HR, f"{hr:02X}")

    @classmethod
    def set_workout_time(cls, minutes: int) -> bytes:
        """
        Set workout duration.

        Args:
            minutes: Workout duration in minutes

        Returns:
            Command bytes
        """
        return cls._build(Command.SET_WORKOUT_TIME, f"{minutes:02X}")

    # =========================================================================
    # Increment/Decrement Commands (step up/down by 1 unit)
    # =========================================================================
    # These are simpler than absolute value commands - no data payload needed.
    # Good for button presses where you want to adjust by one step at a time.

    @classmethod
    def speed_up(cls) -> bytes:
        """
        Increment speed by 1 step (typically 0.1 km/h).

        **Applies to: Treadmills only** (deviceType=0)

        For bikes/ellipticals, use level_up() instead.
        This is the equivalent of pressing the speed+ button on the console.

        Returns:
            Command bytes (0xF102)
        """
        return cls._build(0xF1, "02")

    @classmethod
    def speed_down(cls) -> bytes:
        """
        Decrement speed by 1 step (typically 0.1 km/h).

        **Applies to: Treadmills only** (deviceType=0)

        For bikes/ellipticals, use level_down() instead.
        This is the equivalent of pressing the speed- button on the console.

        Returns:
            Command bytes (0xF103)
        """
        return cls._build(0xF1, "03")

    @classmethod
    def incline_up(cls) -> bytes:
        """
        Increment incline by 1% (or 0.5% on some models).

        **Applies to: Treadmills** (deviceType=0)
        **Applies to: Some Ellipticals** with adjustable ramp

        This is the equivalent of pressing the incline+ button on the console.

        Returns:
            Command bytes (0xF104)
        """
        return cls._build(0xF1, "04")

    @classmethod
    def incline_down(cls) -> bytes:
        """
        Decrement incline by 1% (or 0.5% on some models).

        **Applies to: Treadmills** (deviceType=0)
        **Applies to: Some Ellipticals** with adjustable ramp

        This is the equivalent of pressing the incline- button on the console.

        Returns:
            Command bytes (0xF105)
        """
        return cls._build(0xF1, "05")

    @classmethod
    def level_up(cls) -> bytes:
        """
        Increment resistance level by 1.

        **Applies to: Bikes** (deviceType=2) and **Ellipticals** (deviceType=1)

        For treadmills, use speed_up() instead.
        This is the equivalent of pressing the level+ button on the console.

        Returns:
            Command bytes (0xF102)

        Note: Uses same command code as speed_up() - the device interprets
        it based on device type.
        """
        return cls._build(0xF1, "02")

    @classmethod
    def level_down(cls) -> bytes:
        """
        Decrement resistance level by 1.

        **Applies to: Bikes** (deviceType=2) and **Ellipticals** (deviceType=1)

        For treadmills, use speed_down() instead.
        This is the equivalent of pressing the level- button on the console.

        Returns:
            Command bytes (0xF103)

        Note: Uses same command code as speed_down() - the device interprets
        it based on device type.
        """
        return cls._build(0xF1, "03")
