# SOLE Fitness BLE Monitor

A Python library for monitoring and controlling SOLE, Spirit, XTERRA, and Fuel fitness equipment via Bluetooth LE.

These brands are all manufactured by **Dyaco International** and share identical BLE firmware using the proprietary "ISSC Transparent UART" protocol (reverse-engineered from the `ideabussdk_sole` SDK). See [PROTOCOL_ANALYSIS.md](../PROTOCOL_ANALYSIS.md) for full documentation.

## Monitoring Options

| Script | Protocol | Console Lockout | Data Available |
|--------|----------|-----------------|----------------|
| `uart_monitor.py` | UART | No (passive) | Full (speed, incline, distance, cal, HR) |
| `uart_control.py` | UART | Maybe* | Full + control commands |
| `example.py` | UART/FTMS | No | Full/Basic depending on mode |

*Console lockout behavior with active control is not fully understood.

## Supported Equipment

- **SOLE**: F63, F65, F80, F85 treadmills; E25, E35, E55, E95 ellipticals; B94, R92, LCB, LCR bikes
- **Spirit**: XT series treadmills; XE, XBR, XBU series
- **XTERRA**: Various models
- **Fuel**: Various models

## Installation

```bash
pip install -r requirements.txt
```

Or install the package:

```bash
pip install -e .
```

## Quick Start

### Scan for devices

```bash
python example.py --scan
```

### Passive UART Monitoring (Recommended)

The safest way to monitor workouts without interfering with the console:

```bash
python uart_monitor.py                    # Scan and connect
python uart_monitor.py -a XX:XX:XX:XX:XX  # Connect to specific device
```

This uses the "echo technique" - it echoes WorkoutMode messages back without
sending SET_MODE, so it won't take control from the console.

### Basic Monitoring

```bash
python example.py
python example.py --address XX:XX:XX:XX:XX:XX
```

### Interactive Control (Use with Caution)

```bash
python uart_control.py
```

Interactive commands:
- `s <speed>` - Set speed (km/h, e.g., "s 8.5")
- `i <incline>` - Set incline (%, e.g., "i 5")
- `l <level>` - Set level for bikes
- `s+` / `s-` - Speed up/down by 1 step
- `i+` / `i-` - Incline up/down by 1%
- `l+` / `l-` - Level up/down by 1
- `init` - Initialize manual mode
- `start/stop/pause` - Mode control
- `q` - Quit

**WARNING**: Control commands may cause the console to become unresponsive.

## Library Usage

### Basic Monitoring

```python
import asyncio
from sole_monitor import SoleMonitor, WorkoutData, DeviceInfo

async def main():
    monitor = SoleMonitor()

    def on_workout(data: WorkoutData):
        print(f"Time: {data.minutes}:{data.seconds:02d}")
        print(f"Speed: {data.speed:.1f} km/h")
        print(f"Incline: {data.incline}%")

    monitor.on_workout_data = on_workout

    devices = await SoleMonitor.scan(timeout=10.0)
    if devices:
        await monitor.connect(devices[0].ble_device)
        await monitor.start_monitoring()

asyncio.run(main())
```

### Echo Technique (Passive Monitoring)

For truly passive monitoring that won't interfere with the console:

```python
from sole_protocol import CommandBuilder, Command

# When you receive a WorkoutMode (0x03) message, echo it back:
def handle_mode(mode_value: int):
    # Echo the mode back unchanged - keeps data flowing without lockout
    response = CommandBuilder.echo_mode(mode_value)
    await client.write_gatt_char(write_char, response)
```

### Control Commands (Use with Caution)

```python
from sole_protocol import CommandBuilder, ProgramType, WorkoutMode

# Initialize for manual mode control
await send(CommandBuilder.set_user_profile(age=30, weight=70, height=175))
await send(CommandBuilder.set_program_mode(ProgramType.MANUAL))

# Control commands
await send(CommandBuilder.set_max_speed(85))     # 8.5 km/h
await send(CommandBuilder.set_max_incline(5))    # 5%
await send(CommandBuilder.set_mode(WorkoutMode.RUNNING))
```

## Protocol Details

The equipment uses a simple framed protocol over BLE:

```
[0x5B][LENGTH][CMD][DATA...][0x5D]
```

- Start marker: `0x5B` (`[`)
- Length: 1 byte, count of bytes between length and end marker
- Command: 1 byte command code
- Data: Variable length, hex-encoded
- End marker: `0x5D` (`]`)

### BLE Services

| Service | UUID |
|---------|------|
| Primary (ISSC) | `49535343-fe7d-4ae5-8fa9-9fafd205e455` |
| Secondary | `0000fff0-0000-1000-8000-00805f9b34fb` |

### Key Commands

| Cmd | Hex | Description |
|-----|-----|-------------|
| 0x06 | GET_WORKOUT_DATA | Real-time workout metrics |
| 0x32 | END_WORKOUT | Workout summary |
| 0xF0 | DEVICE_INFO | Equipment model/capabilities |

### Workout Data Fields

For **treadmills**:
- Time (minutes, seconds)
- Distance (km)
- Calories
- Speed (km/h)
- Incline (%)
- Heart rate (bpm)
- Pace (min/km)

For **bikes/ellipticals**:
- Time, Distance, Calories
- RPM / Cadence
- Level (resistance)
- Watts
- Heart rate
- METS

## License

MIT
