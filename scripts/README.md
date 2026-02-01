# SOLE Fitness BLE Scripts

Test scripts and utilities for SOLE/Spirit/XTERRA fitness equipment BLE protocols.

## Scripts Organization

### 📡 FTMS Tests (2 scripts)
- `ftms-passive-monitor.py` ⭐ - FTMS-only passive monitoring (NO console lockout)
- `ftms-uart-diagnostic.py` - Compare FTMS vs UART protocols

### 👂 UART Passive Monitoring (4 scripts)  
- `uart-passive-monitor.py` ⭐ - Production passive monitor (NO console lockout)
- `uart-passive-echo.py` - Echo technique monitoring
- `uart-passive-active.py` - Active listener with GetDeviceInfo
- `uart-passive-listen-all.py` - Most passive approach

### 🎮 UART Control (9 scripts) - ⚠️ May lock console!
- `uart_control.py` ⭐ - Interactive control tool
- `uart-control-*.py` - Various control tests

### 🛠️ Utilities (7 scripts)
- `detect-sole.py` ⭐ - Device detection
- `scan-advertisements.py`, `read-device-info.py`, parsers, etc.

### 📚 Examples (2 scripts)
- `example.py`, `monitor.py` - Using src/sole_uart library

See PROTOCOL_ANALYSIS.md for complete documentation.
