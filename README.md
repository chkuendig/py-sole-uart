# sole-uart

Async Python client library for Sole treadmill UART protocol over Bluetooth LE.

This library provides **passive monitoring** of Sole treadmills (F63, F65, F80, F85, TT8, etc.) via their proprietary UART-over-BLE protocol, enabling access to real-time workout data including **incline** (not available via FTMS).

## Features

- 🔍 **Passive Monitoring**: Monitors workout data without interfering with console control
- 📊 **Complete Data**: Access to speed, incline, distance, calories, heart rate, and time
- ⚡ **Async/Await**: Built on `asyncio` for modern Python applications
- 🏠 **Home Assistant Ready**: Compatible with Home Assistant's async architecture
- 🔌 **Auto-Discovery**: Automatically finds Sole treadmills via BLE scanning
- 📦 **Type Hints**: Full type annotations for better IDE support

## Installation

```bash
pip install sole-uart
```

Or for development:

```bash
# Create and activate virtual environment
python3 -m venv venv && source venv/bin/activate
# Install in editable mode with dev dependencies
pip install -e ".[dev]"
```

## Quick Start

### Using the Monitor Script

The easiest way to get started is with the included monitoring script:

```bash
# Auto-discover and monitor first Sole device
python scripts/monitor.py

# Connect to specific device
python scripts/monitor.py --address F5:C0:00:03:BE:69

# Enable debug logging
python scripts/monitor.py --debug
```

### Using the Library

```python
import asyncio
from sole_uart import SoleClient, find_sole_device

async def on_workout_data(data):
    print(f"Speed: {data.speed:.1f} km/h")
    print(f"Incline: {data.incline}%")
    print(f"Distance: {data.distance:.2f} km")
    print(f"Calories: {data.calories}")
    print(f"Time: {data.elapsed_time_formatted}")

async def main():
    # Find device
    device = await find_sole_device(timeout=10.0)
    if not device:
        print("No Sole treadmill found")
        return

    # Create client and set callback
    client = SoleClient(device)
    client.set_workout_data_callback(on_workout_data)

    # Connect and monitor
    await client.connect()

    try:
        # Monitor until interrupted
        while True:
            await asyncio.sleep(1)
    except KeyboardInterrupt:
        pass
    finally:
        await client.disconnect()

asyncio.run(main())
```

## API Reference

### SoleClient

Main client class for connecting to and monitoring Sole treadmills.

```python
from sole_uart import SoleClient

client = SoleClient(device)
```

#### Methods

- `async connect()` - Connect to treadmill and start monitoring
- `async disconnect()` - Disconnect from treadmill
- `set_workout_data_callback(callback)` - Set callback for workout data updates
- `set_state_callback(callback)` - Set callback for machine state changes
- `set_disconnect_callback(callback)` - Set callback for disconnection events

#### Properties

- `is_connected: bool` - Connection status
- `state: MachineState` - Current machine state
- `device_info: DeviceInfo` - Device capabilities and info
- `workout_data: WorkoutData` - Latest workout data

### Discovery Functions

```python
from sole_uart import find_sole_device, is_sole_device

# Find first Sole device
device = await find_sole_device(timeout=10.0)

# Find specific device by address
device = await find_sole_device(address="F5:C0:00:03:BE:69")

# Check if a device is a Sole treadmill
if is_sole_device(device):
    print("This is a Sole treadmill!")
```

### Data Models

#### WorkoutData

Real-time workout telemetry:

```python
@dataclass
class WorkoutData:
    minutes: int
    seconds: int
    distance: float          # km or miles
    calories: int
    heart_rate: int          # BPM
    speed: float             # km/h or mph
    incline: int             # percentage
    hr_type: HeartRateType   # NONE, CHEST, GRIP

    @property
    def elapsed_time_seconds(self) -> int
    @property
    def elapsed_time_formatted(self) -> str
```

#### DeviceInfo

Device capabilities:

```python
@dataclass
class DeviceInfo:
    model: int
    version: int
    units_metric: bool
    max_speed: float
    min_speed: float
    max_incline: int
    user_segment: int
```

#### MachineState

Current machine state:

```python
@dataclass
class MachineState:
    mode: WorkoutMode
    device_info: Optional[DeviceInfo]
    workout_data: Optional[WorkoutData]

    @property
    def is_running(self) -> bool
    @property
    def is_idle(self) -> bool
    @property
    def mode_name(self) -> str
```

### Enums

```python
from sole_uart import WorkoutMode, HeartRateType

# Workout modes
class WorkoutMode(IntEnum):
    OFF = 0x00
    IDLE = 0x01
    RUNNING = 0x02
    FINISHED = 0x03
    STARTING = 0x04
    PAUSED = 0x05
    DEMO = 0x80

# Heart rate sensor types
class HeartRateType(IntEnum):
    NONE = 0x00
    CHEST = 0x01
    GRIP = 0x02
```

## How It Works

### Passive Monitoring

This library implements **passive monitoring** that does NOT interfere with console control:

1. **Connection**: Establishes BLE connection to Sole UART service
2. **Handshake**: Sends GetDeviceInfo to initiate communication
3. **Echo Protocol**: Echoes required messages (DeviceInfo, WorkoutMode) to maintain connection
4. **Data Reception**: Receives and parses workout data with proper ACKs
5. **No Control**: Does NOT send any control commands that would lock out the console

The treadmill console remains fully functional - you can start, stop, and adjust speed/incline from the physical buttons while monitoring via BLE.

### Why Not FTMS?

While Sole treadmills advertise standard FTMS (Fitness Machine Service), their implementation is incomplete:

- ❌ **No Incline Data**: Sole never sets the incline flag in FTMS Treadmill Data
- ❌ **Non-Standard Init**: Requires proprietary `0xe9` command (not in FTMS spec)
- ❌ **Limited Features**: FTMS Feature register returns `0x00000000`

This library uses the proprietary UART protocol to access **complete** data including incline.

## Compatibility

### Supported Devices

- Sole F63, F65, F80, F85 treadmills
- Sole TT8 treadmill
- Possibly other Dyaco-manufactured treadmills (Spirit, Xterra, Fuel)

### Requirements

- Python 3.11+
- Bluetooth LE adapter
- Linux, macOS, or Windows

### Home Assistant Integration

This library is designed to be compatible with Home Assistant:

```python
from homeassistant.components import bluetooth
from sole_uart import SoleClient, is_sole_device

# In your Home Assistant integration
device = bluetooth.async_ble_device_from_address(hass, address)
if is_sole_device(device):
    client = SoleClient(device)
    await client.connect()
```

## Troubleshooting

### Device Not Found

- Make sure treadmill display is **on** (not in sleep mode)
- Check Bluetooth is enabled on your computer
- Try specifying the device address manually
- Enable debug logging: `python scripts/monitor.py --debug`

### Connection Issues

- Only one BLE client can connect at a time
- If connection hangs, power cycle the treadmill
- On Linux, you may need to run with `sudo` or add user to `bluetooth` group

### Console Lockout

If the physical console becomes unresponsive:

1. This library should NOT cause lockout (it's passive)
2. If it happens, disconnect the BLE client
3. Power cycle the treadmill if needed

## Development

### Running Tests

```bash
pytest
```

### Code Formatting

```bash
ruff format .
ruff check .
```

## Protocol Documentation

For details on the Sole UART protocol, see:

- [PROTOCOL.md](PROTOCOL.md) - Complete UART and FTMS protocol specification
- [CLAUDE.md](CLAUDE.md) - Reverse engineering notes

## Credits

This library is based on protocol reverse engineering from:

- [treadonme](https://github.com/swedishborgie/treadonme) by swedishborgie
- [qdomyos-zwift](https://github.com/cagnulein/qdomyos-zwift) by cagnulein

## License

Apache 2.0 - See LICENSE file for details

## Contributing

Contributions welcome! Please:

1. Fork the repository
2. Create a feature branch
3. Add tests for new functionality
4. Ensure code passes `ruff` checks
5. Submit a pull request

## Disclaimer

⚠️ **WARNING**: This software allows modification of treadmill settings while operating. Use at your own risk. The authors are not responsible for any injury or equipment damage.

This is a third-party library and is not affiliated with or endorsed by Sole Fitness.
