"""Tests for data models."""

import pytest
from sole_uart.const import HeartRateType, WorkoutMode
from sole_uart.models import DeviceInfo, MachineState, WorkoutData


class TestDeviceInfo:
    """Test DeviceInfo model."""

    def test_device_info_metric(self):
        """Test DeviceInfo with metric units."""
        info = DeviceInfo(
            model=145,
            version=0,
            units_metric=True,
            max_speed=20.0,
            min_speed=1.0,
            max_incline=15,
            user_segment=18,
        )
        assert info.units == "metric"
        assert info.model == 145
        assert info.max_speed == 20.0

    def test_device_info_imperial(self):
        """Test DeviceInfo with imperial units."""
        info = DeviceInfo(
            model=146,
            version=1,
            units_metric=False,
            max_speed=12.0,
            min_speed=0.5,
            max_incline=15,
            user_segment=18,
        )
        assert info.units == "imperial"
        assert info.model == 146
        assert info.max_speed == 12.0


class TestWorkoutData:
    """Test WorkoutData model."""

    def test_workout_data_elapsed_time(self):
        """Test elapsed time calculations."""
        data = WorkoutData(
            minutes=10,
            seconds=30,
            distance=2.5,
            calories=150,
            heart_rate=130,
            speed=8.0,
            incline=3,
            hr_type=HeartRateType.CHEST,
        )
        assert data.elapsed_time_seconds == 630  # 10*60 + 30
        assert data.elapsed_time_formatted == "10:30"

    def test_workout_data_zero_seconds(self):
        """Test formatted time with zero seconds."""
        data = WorkoutData(
            minutes=5,
            seconds=0,
            distance=1.0,
            calories=50,
            heart_rate=0,
            speed=6.0,
            incline=0,
            hr_type=HeartRateType.NONE,
        )
        assert data.elapsed_time_formatted == "05:00"

    def test_workout_data_single_digit_seconds(self):
        """Test formatted time with single digit seconds."""
        data = WorkoutData(
            minutes=3,
            seconds=5,
            distance=0.5,
            calories=30,
            heart_rate=110,
            speed=5.0,
            incline=2,
            hr_type=HeartRateType.GRIP,
        )
        assert data.elapsed_time_formatted == "03:05"


class TestMachineState:
    """Test MachineState model."""

    def test_machine_state_off(self):
        """Test OFF state."""
        state = MachineState(mode=WorkoutMode.OFF)
        assert not state.is_running
        assert not state.is_idle
        assert state.mode_name == "OFF"

    def test_machine_state_idle(self):
        """Test IDLE state."""
        state = MachineState(mode=WorkoutMode.IDLE)
        assert not state.is_running
        assert state.is_idle
        assert state.mode_name == "IDLE"

    def test_machine_state_running(self):
        """Test RUNNING state."""
        state = MachineState(mode=WorkoutMode.RUNNING)
        assert state.is_running
        assert not state.is_idle
        assert state.mode_name == "RUNNING"

    def test_machine_state_paused(self):
        """Test PAUSED state."""
        state = MachineState(mode=WorkoutMode.PAUSED)
        assert state.is_running  # Paused still counts as running
        assert not state.is_idle
        assert state.mode_name == "PAUSED"

    def test_machine_state_demo(self):
        """Test DEMO mode."""
        state = MachineState(mode=WorkoutMode.DEMO)
        assert not state.is_running
        assert not state.is_idle
        assert state.mode_name == "DEMO"

    def test_machine_state_with_device_info(self):
        """Test state with device info."""
        info = DeviceInfo(
            model=145,
            version=0,
            units_metric=True,
            max_speed=20.0,
            min_speed=1.0,
            max_incline=15,
            user_segment=18,
        )
        state = MachineState(mode=WorkoutMode.IDLE, device_info=info)
        assert state.device_info is not None
        assert state.device_info.model == 145

    def test_machine_state_with_workout_data(self):
        """Test state with workout data."""
        workout = WorkoutData(
            minutes=5,
            seconds=30,
            distance=1.5,
            calories=80,
            heart_rate=120,
            speed=6.5,
            incline=3,
            hr_type=HeartRateType.CHEST,
        )
        state = MachineState(mode=WorkoutMode.RUNNING, workout_data=workout)
        assert state.workout_data is not None
        assert state.workout_data.speed == 6.5
        assert state.is_running

    def test_machine_state_unknown_mode(self):
        """Test handling of unknown mode code."""
        # Use a mode code that's not in the enum
        state = MachineState(mode=0x99)
        assert state.mode_name == "UNKNOWN(0x99)"

    def test_machine_state_model_variations(self):
        """Test that mode codes 0x02-0x05 are all considered running."""
        # F65/F80 variations - all workout-in-progress modes
        for mode_code in [0x02, 0x03, 0x04, 0x05]:
            state = MachineState(mode=mode_code)
            assert state.is_running, f"Mode 0x{mode_code:02x} should be running"


class TestHeartRateType:
    """Test HeartRateType enum."""

    def test_hr_types(self):
        """Test heart rate type values."""
        assert HeartRateType.NONE == 0x00
        assert HeartRateType.CHEST == 0x01
        assert HeartRateType.GRIP == 0x02

    def test_hr_type_names(self):
        """Test heart rate type names."""
        assert HeartRateType.NONE.name == "NONE"
        assert HeartRateType.CHEST.name == "CHEST"
        assert HeartRateType.GRIP.name == "GRIP"


class TestWorkoutMode:
    """Test WorkoutMode enum."""

    def test_workout_modes(self):
        """Test workout mode values."""
        assert WorkoutMode.OFF == 0x00
        assert WorkoutMode.IDLE == 0x01
        assert WorkoutMode.FINISHED == 0x03
        assert WorkoutMode.RUNNING == 0x04
        assert WorkoutMode.PAUSED == 0x05
        assert WorkoutMode.DEMO == 0x80

    def test_workout_mode_names(self):
        """Test workout mode names."""
        assert WorkoutMode.OFF.name == "OFF"
        assert WorkoutMode.IDLE.name == "IDLE"
        assert WorkoutMode.RUNNING.name == "RUNNING"
        assert WorkoutMode.DEMO.name == "DEMO"
