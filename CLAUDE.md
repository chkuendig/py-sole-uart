# Sole Treadmill FTMS Protocol Reverse Engineering

## Project Overview

This project reverse-engineers the BLE protocol used by Sole treadmills (F63, F65, F80, TT8) with the goal of creating a fully passive listener that can monitor workout data without interfering with console control.

**Target Device**: Sole F85 (also tested on F65)
**MAC Address**: `F5:C0:00:03:BE:69`

## Key Sources

- **treadonme** (Go): https://github.com/swedishborgie/treadonme
- **qdomyos-zwift** (C++/Qt): https://github.com/cagnulein/qdomyos-zwift
- **SOLE+ Android Sources**: apps/sole_fitness_jadx/
- **SOLE Fitness Sources**: apps/sole_plus_jadx/

## Protocol Summary

Sole treadmills expose **two BLE interfaces**:

| Interface | UUID | Purpose |
|-----------|------|---------|
| FTMS (standard) | `00001826-...` | Read-only workout data |
| Sole UART (proprietary) | `49535343-FE7D-4AE5-8FA9-9FAFD205E455` | Full control |

### Sole UART Characteristics

| Characteristic | UUID | Direction |
|----------------|------|-----------|
| Write | `49535343-8841-43F4-A8D4-ECBE34729BB3` | Host → Treadmill |
| Notify | `49535343-1E4D-4BD9-BA61-23C647249616` | Treadmill → Host |

### Message Framing

```
0x5B | Length | Type | Payload... | 0x5D
 [      N      cmd     data         ]
```

### Key Message Types

| Type | Code | Description |
|------|------|-------------|
| ACK | `0x00` | Acknowledgement |
| WorkoutMode | `0x03` | Current state (sent every ~300ms) |
| WorkoutData | `0x06` | Live telemetry |
| DeviceInfo | `0xF0` | Device capabilities |
| Command | `0xF1` | Control (start/stop/speed/incline) |

### Workout Modes (observed on F65)

| Code | State |
|------|-------|
| `0x00` | OFF |
| `0x01` | IDLE |
| `0x02` | RUNNING |
| `0x03` | FINISHED |
| `0x04` | STARTING |
| `0x05` | PAUSED |
| `0x80` | DEMO (BLE commands ignored) |

## Current Challenge: Passive Listening

**Problem**: Connecting to the Sole UART service and sending GetDeviceInfo (`5b01f05d`) initiates a handshake that can lock out the physical console.

**Goal**: Create a listener that:
1. Receives workout data without taking control
2. Does not interfere with console operation
3. Can monitor a workout started from the console

### Approaches Tested

1. **FTMS-only** (`ftms_only.py`): Subscribe only to standard FTMS characteristics
   - Works without interference
   - Gets speed, distance, time, calories
   - ⚠️ **No incline data** (Sole doesn't send it via FTMS)
   - No SOLE-specific fields

2. **Passive UART monitor** (`passive_monitor.py`): Connect to UART, echo messages
   - Sends GetDeviceInfo to initiate communication
   - Echoes WorkoutMode and ACKs data
   - May still cause console lockout

3. **Listen all** (`listen_all.py`): Subscribe to all notify characteristics
   - Passive observation only
   - May miss UART data without handshake

## Documentation

- [PROTOCOL.md](PROTOCOL.md) - Full protocol specification (includes sensor mapping)
- [ftms-sole.md](ftms-sole.md) - Analysis and implementation notes

## Python Scripts

### Monitoring/Listening
- `ftms_only.py` - FTMS-only passive listener (safest)
- `listen_all.py` - Subscribe to all notifications
- `listen_active.py` - Active listener with handshake
- `passive_monitor.py` - Attempts passive UART monitoring

### Testing/Control
- `test_sole_ble.py` - Basic BLE connection test
- `test_startstop.py` - Start/stop command testing
- `test_incline.py` - Incline control testing
- `test_full_control.py` - Full control sequence
- `sole_fan_test.py` - Fan control investigation (not working)

### Utility
- `scan_advertisements.py` - Scan for BLE advertisements
- `read_device_info.py` - Read device information
- `release_control.py` - Release BLE control
- `parse_capture.py` - Parse Apple PacketLogger BLE captures

## Development Notes

### Dependencies
```bash
pip install bleak
```

### BLE Reset (if connection issues)
```bash
sudo bluetoothctl power off && sudo bluetoothctl power on
```

### Device Detection

To detect Sole/Dyaco devices with incomplete FTMS:

**Before connection (advertisement data only):**
1. Check for Microchip manufacturer ID (`0x0157`) in advertisement data
2. Fallback: Device name starts with "F63", "F65", "F80", "TT8", etc.

**After connection (GATT discovery complete) - most reliable:**
1. Check for both FTMS (`00001826-...`) AND Sole UART (`49535343-FE7D-...`) services
2. FTMS Feature (`0x2ACC`) returns `0x00000000` despite device having incline

> **Note**: Sole only advertises FTMS service UUID. The Sole UART service and FTMS characteristics are only visible after connecting.

See [PROTOCOL.md](PROTOCOL.md#detecting-soledyaco-devices-with-incomplete-ftms) for full detection logic and code example.

### Key Findings

1. **Two interfaces**: FTMS (passive monitoring) vs UART (control + console lockout)
2. **Sole+ app uses FTMS only**: Does NOT use proprietary UART protocol
3. **FTMS passive monitoring works**: Send Request Control (0x00) + 0xe9 to start receiving data
4. **Console lockout**: Only happens with UART handshake, NOT with FTMS
5. **DEMO mode (0x80)**: When in this mode, BLE commands are ignored
6. **Speed/incline control**: Only via UART, only incremental (up/down)
7. **Fan control**: Not exposed via BLE (console-only)
8. **Incline NOT in FTMS**: Sole never sets bit 3 in FTMS Treadmill Data flags - incline only available via UART (byte 8 of WorkoutData payload)

## Resolved

✅ **Passive monitoring works via FTMS** without console lockout. The Sole+ app packet capture confirmed the approach:
1. Enable notifications on FTMS characteristics
2. Write 0x00 (Request Control) to handle 0x004b
3. Write 0xe9 (Sole-specific) to handle 0x004b
4. Receive FTMS Treadmill Data on handle 0x002c
