# SOLE Fitness BLE Protocol Analysis

Analysis of the SOLE Fitness App (v1.7.08) BLE communication protocol, reverse-engineered from the Android APK.

## Background

### Manufacturer and SDK

**Dyaco International** is a Taiwanese OEM that manufactures fitness equipment sold under multiple brands:
- **SOLE Fitness** - Premium brand (F63, F65, F80, F85 treadmills; E25, E35, E55, E95 ellipticals; B94, R92 bikes)
- **Spirit Fitness** - Commercial/premium (XT series treadmills; XE, XBR, XBU series)
- **XTERRA Fitness** - Mid-range (TRX treadmills)
- **Fuel Fitness** - Entry-level

All equipment shares the same BLE firmware and protocol, implemented via the **`ideabussdk_sole`** Android SDK.

### SDK Origin: IdeaBus

The SDK and original SOLE Fitness app were developed by **[IdeaBus Co., Ltd.](https://web.archive.org/web/20191024022546/http://ideabus.com.tw/en/about_us.php)** (Taiwan), a company specializing in Bluetooth fitness apps ([portfolio](https://web.archive.org/web/20191024022546/http://ideabus.com.tw/en/fitness.php), [SOLE privacy policy](https://web.archive.org/web/20190910072715/http://www.ideabus.com.tw/sole_policy.html)).

### BLE Hardware

The equipment uses **ISSC Technologies** (now Microchip) BLE chips with their "Transparent UART" profile:
- **UUID prefix**: `49535343-xxxx-xxxx-xxxx-xxxxxxxxxxxx` (ISSC vendor ID)
- This is NOT a standard Bluetooth SIG profile - it's a proprietary serial-over-BLE implementation

### Protocol Naming

There's no official name for this protocol. Common references:
- **"SOLE Protocol"** or **"Dyaco Protocol"** - in community projects
- **"ISSC Transparent UART"** - based on the BLE service type
- **"ideabus"** - internal SDK naming (`ideabussdk_sole`)

> **⚠️ IMPORTANT: This document primarily covers the Proprietary UART Protocol**
>
> The protocol details below (commands, model detection, data formats) are from the **SOLE Fitness app** which uses the proprietary UART service. The **Sole+ app** uses FTMS instead. See the [Protocol Comparison](#protocol-comparison) section for differences.

## TL;DR

Your F65 treadmill has **two BLE protocols** with **three monitoring approaches**:

| Approach | Protocol | Data Available | Console Lockout |
|----------|----------|---------------|-----------------|
| **FTMS Passive** | FTMS | Speed, HR only | ❌ No |
| **UART Passive** | UART | Full data (speed, incline, distance, cal, HR) | ❌ No |
| **UART Active** | UART | Full data + control | ⚠️ Maybe* |

*Console lockout behavior with UART Active is not fully understood - may depend on firmware, program type, or specific configuration. See [Passive UART Monitoring](#passive-uart-monitoring-treadonme-approach) for details.

### Option 1: FTMS Passive (Simplest)

Use **FTMS** for basic monitoring without interfering with the console:
1. Enable notifications on FTMS Treadmill Data (0x2ACD)
2. Optionally write `0x00` (Request Control) to FTMS Control Point (0x2AD9)
3. Receive speed + HR data - no console lockout!

**Limitation**: No incline, distance, or calories on F65.

### Option 2: UART Passive (Full Data, No Lockout)

Use **UART with echo technique** (from [treadonme](https://github.com/swedishborgie/treadonme)):
1. Connect to UART service, enable notifications
2. When you receive `WorkoutMode` (0x03) messages, **echo them back unchanged**
3. **DO NOT** send `SET_MODE` (0x02) - that causes lockout
4. Full workout data flows without taking control!

### Option 3: UART Active (Full Control)

Use **UART with SET_MODE** if you need device control:
1. Connect to UART service, send `0xF0` to get device info
2. Send `SET_MODE` (0x02) with mode `0x02` (IDLE) to "link" the workout
3. Full data flows + you can send control commands (speed/incline)

**Note**: Console lockout behavior is not fully understood. The treadonme README mentions "configurations that could cause the treadmill to disable the physical controls" as a bug encountered during testing, not guaranteed behavior. treadonme's `Start()` disconnects/reconnects after initialization, which may release control.

**Note on 0xE9**: The Sole+ app sends `0x00` + `0xE9` on every FTMS connection, but **0xE9 is NOT required** for passive monitoring. It's just a capability query for program upload support.

---

## Protocol Comparison

SOLE fitness equipment supports **two BLE protocols** with **three monitoring approaches**:

| Aspect | UART Active | UART Passive | FTMS |
|--------|-------------|--------------|------|
| **Service UUID** | `49535343-fe7d-...` | `49535343-fe7d-...` | `00001826-0000-...` |
| **Used by** | SOLE Fitness app | treadonme library | Sole+ app |
| **Console lockout** | ⚠️ Maybe* | ❌ No | ❌ No |
| **Data: Speed** | ✅ Yes | ✅ Yes | ✅ Yes |
| **Data: Incline** | ✅ Yes | ✅ Yes | ❌ No |
| **Data: Distance** | ✅ Yes | ✅ Yes | ❌ No |
| **Data: Calories** | ✅ Yes | ✅ Yes | ❌ No |
| **Data: Heart Rate** | ✅ Yes | ✅ Yes | ✅ Yes |
| **Device control** | ✅ Full | ❌ None | ❌ None |
| **Model detection** | ✅ Via 0xF0 | ❌ Not safe | ❌ Not available |
| **Technique** | Send SET_MODE | Echo WorkoutMode | Subscribe only |

### Passive UART Monitoring (treadonme approach)

> **Source**: [swedishborgie/treadonme](https://github.com/swedishborgie/treadonme) - Go library for SOLE treadmills

The treadonme library demonstrates that **passive UART monitoring IS possible** without console lockout. The key insight:

| Action | Console Lockout? | Data Available |
|--------|------------------|----------------|
| **Just subscribe to notifications** | ❌ No | Limited - mode only |
| **Echo back WorkoutMode (0x03) messages** | ❌ No | Full workout data |
| **Send SET_MODE (0x02)** | ⚠️ **Maybe** | Full control |

**How it works:**

1. Connect to UART service and enable notifications
2. When the treadmill broadcasts `WorkoutMode` (0x03) messages, **echo them back unchanged**
3. The treadmill interprets this as an acknowledgment and continues broadcasting data
4. **DO NOT** send `SET_MODE` (0x02) with your own mode value - that's what triggers lockout

```go
// From treadonme/tread.go - passive handling
case MessageTypeWorkoutMode:
    // These are special, we just need to echo what we heard.
    t.ackWorkoutMode(msg.(*MessageWorkoutMode))
```

**The `Start()` function** (from treadonme/tread.go):
```go
// Start() sends: UserProfile → ProgramManual → WorkoutTarget → SetWorkoutMode(Start)
// Then it DISCONNECTS and RECONNECTS - possibly releasing control back to console
func (t *Treadmill) Start() error {
    t.writeWithResponse(&MessageUserProfile{...})
    t.writeWithResponse(&MessageProgram{ProgramManual})      // Manual mode, not preset
    t.writeWithResponse(&MessageWorkoutTarget{})             // Empty target
    t.writeWithResponse(&MessageSetWorkoutMode{WorkoutModeStart})
    t.Close()                                                // Disconnect!
    // ... reconnect after 5 seconds
}
```

**About the treadonme README warning**: The warning about "configurations that could cause the treadmill to disable the physical controls" appears to describe a **firmware bug** encountered with certain configurations, not guaranteed lockout behavior. The developer notes this happened during "trial and error" testing.

**Console lockout is NOT fully understood**:
- SET_MODE (0x02) "links" the workout to the app
- Whether this locks out the console may depend on: firmware version, program type, specific configuration
- treadonme's `Start()` disconnects/reconnects after initialization - this might release control
- The safest approach for passive monitoring is still: **echo WorkoutMode, don't send SET_MODE**

### SOLE Fitness App: Both Techniques

The official SOLE Fitness app uses **both** the echo technique AND SET_MODE:

```java
// From SoleProtocol.java:1492 - Echo back received mode (passive acknowledgment)
public void sendModeReceived(int mode) {
    writeMessage(completeCommand("03" + getIntToHexString(mode, 2)));  // 0x03 = WorkoutMode
}

// Called automatically when receiving mode messages (line 2298):
int mode = Integer.parseInt(data.substring(4, 6), 16);
sendModeReceived(mode);  // Echo it back

// From SoleProtocol.java:1208 - Take control (causes lockout)
public void startWorkout() {
    writeMessage(completeCommand("0202"));  // 0x02 0x02 = SET_MODE to IDLE
}
```

**Key insight**: The app echoes WorkoutMode messages for acknowledgment, but **also** sends SET_MODE when the user initiates a workout from the app. The lockout happens because of `startWorkout()`, not because of the echo.

**Why echoing is required**: The treadmill broadcasts WorkoutMode (0x03) and expects an acknowledgment. If you don't echo it back, the treadmill may stop sending data. Echoing maintains the data stream without taking control.

**What SET_MODE actually does**: SET_MODE (0x02) with mode=IDLE (0x02) tells the treadmill "I want to control this workout." This is what causes the console lockout - not the act of receiving data.

**Passive monitoring works because**:
1. Treadmill broadcasts WorkoutMode + WorkoutData when a workout is running (regardless of who started it)
2. Echoing WorkoutMode keeps the data flowing
3. WorkoutData (CMD 0x06) is sent by the treadmill in modes 3/4/5 (RUNNING/COOLDOWN) regardless of SET_MODE
4. NOT sending SET_MODE means the console retains control

### Key Findings

1. **FTMS is passive-safe**: The Sole+ app uses FTMS, which does NOT lock out the console
2. **UART can be passive too**: By echoing WorkoutMode messages instead of sending SET_MODE (treadonme approach)
3. **SET_MODE (0x02) links the workout**: This command enables app control, but lockout behavior is unclear (may depend on firmware/config)
4. **Mode 0x80 = "BLE not linked"**: UART shows this when workout started from console without SET_MODE
5. **0xE9 is a capability query, not required for data**: Sole+ sends it to check program upload support, but passive monitoring likely works without it
6. **Incline NOT in FTMS**: SOLE never sets bit 3 in FTMS flags - incline only via UART
7. **Standard UUIDs, vendor commands**: Sole+ uses standard FTMS UUIDs but adds 0xE0-0xEF op codes for program upload

### Device Detection

Both the SOLE Fitness and Sole+ apps detect compatible equipment using **BLE device name matching** during scanning.

#### Detection Methods

| Method | Protocol | Passive? | Data Available |
|--------|----------|----------|----------------|
| **BLE Device Name** | Advertisement | ✅ Yes | Model name (e.g., "F65", "S77") |
| **FTMS Service UUID** | Advertisement | ✅ Yes | Confirms FTMS support |
| **Model Number (0-255)** | UART 0xF0 command | ❌ No | Full device info, brand, capabilities |
| **FTMS Features** | FTMS 0x2ACC read | ✅ Yes | Supported FTMS features only |

#### Supported Device Names

Equipment advertises with these BLE device name prefixes (case-insensitive):

**SOLE Treadmills:** F63, F65, F80, F85, S77, TT8

**SOLE Ellipticals:** E25, E35, E55, E95, E95S, E98, E96S

**SOLE Bikes:** B94, R92, LCB, LCR, SC200, SC300

**Spirit Treadmills:** CT800, CT850, XT185, XT285, XT385, XT485, XT685

**Spirit Ellipticals:** CE800, CE850, CS800, XE195, XE295, XE395, XE895, XG400

**Spirit Bikes:** CR800, CU800, XBR25, XBR55, XBU55, CRS800S

**XTERRA Treadmills:** TRX1000, TRX2500, TRX3500, TRX4500, TRX7.5, XT7.8, XT96, XT98, XT800 HRC, XT900 HRC, XTERRA 3000

**XTERRA Bikes:** SB4500

#### Detection Code Example

```python
# Python example for scanning compatible devices
DEVICE_PREFIXES = [
    # SOLE
    "SOLE", "Sole", "F63", "F65", "F80", "F85", "S77", "TT8",
    "E25", "E35", "E55", "E95", "E96", "E98", "B94", "R92", "LCB", "LCR",
    # Spirit
    "SPIRIT", "Spirit", "CT800", "CT850", "XT185", "XT285", "XT385", "XT485", "XT685",
    "CE800", "CE850", "XE", "XBR", "XBU", "CR800", "CU800",
    # XTERRA
    "XTERRA", "Xterra", "TRX",
    # Fuel
    "FUEL", "Fuel",
]

def is_compatible_device(device_name: str) -> bool:
    return any(device_name.startswith(prefix) for prefix in DEVICE_PREFIXES)
```

#### Protocol Detection

After finding a compatible device, determine which protocol to use:

1. **Check for FTMS service** (UUID `0x1826`):
   - If present → Can use FTMS (passive, limited data)
   - All newer equipment supports FTMS

2. **Check for UART service** (UUID `49535343-fe7d-4ae5-8fa9-9fafd205e455`):
   - If present → Can use proprietary protocol (full data)
   - The UUID prefix `49535343` = ASCII "ISSC" (the BLE chip vendor)
   - This is the **definitive way** to identify Dyaco equipment after connecting

3. **Get device info via UART** (send `0xF0`):
   - Returns model number, device type, brand, capabilities
   - Helps parse workout data correctly (treadmill vs bike format differs)
   - This is a read-only query, does NOT cause console lockout

**Two Approaches to Device Identification:**

| Approach | When | Method | Pros | Cons |
|----------|------|--------|------|------|
| **Name Matching** | During scan | Match BLE name prefixes | Fast filtering | May miss unknown models |
| **UUID Detection** | After connect | Check for ISSC UART service | Works for any Dyaco device | Requires connection first |

The official SOLE app uses name matching during scanning, then confirms with UUID check after connection. For a generic FTMS library, UUID detection alone is sufficient - if the ISSC UART service is present, the device is Dyaco equipment.

---

## BLE Services

### Proprietary UART Services

Dyaco equipment uses proprietary UART-over-BLE services for the full-featured protocol. There are **two variants** of this service, used by different hardware generations:

#### Primary Service: ISSC/Microchip Transparent UART

> **Source**: [MyBluetoothLE.java:29-31](sole_fitness_jadx/sources/com/dyaco/ideabussdk_sole/bluetooth/MyBluetoothLE.java#L29-L31)

The primary UART service uses a vendor-specific UUID with the prefix `49535343`, which is ASCII for **"ISSC"** - the vendor ID for ISSC Technologies (now part of Microchip Technology Inc.). This prefix identifies the BLE chip manufacturer, not the fitness equipment brand. All Dyaco brands (SOLE, Spirit, XTERRA, Fuel) use ISSC chips with this service.

**UUID Prefix Breakdown:**
```
49535343 = "ISSC" in ASCII hex
49 = 'I' (0x49)
53 = 'S' (0x53)
53 = 'S' (0x53)
43 = 'C' (0x43)
```

| UUID | Description |
|------|-------------|
| `49535343-fe7d-4ae5-8fa9-9fafd205e455` | Service UUID |
| `49535343-8841-43f4-a8d4-ecbe34729bb3` | Write Characteristic (TX) |
| `49535343-1e4d-4bd9-ba61-23c647249616` | Notify Characteristic (RX) |

**Used by**: Modern Dyaco equipment with updated BLE firmware (most current models).

#### Secondary Service: Generic UART (Legacy)

> **Source**: [MyBluetoothLE.java:32-34](sole_fitness_jadx/sources/com/dyaco/ideabussdk_sole/bluetooth/MyBluetoothLE.java#L32-L34)

The secondary service uses the **Bluetooth SIG base UUID** format (`0000xxxx-0000-1000-8000-00805f9b34fb`) with custom identifiers in the `0xFFF0-0xFFF2` range. This was a common pattern for generic UART services before vendor-specific profiles became standard.

| UUID | Description |
|------|-------------|
| `0000fff0-0000-1000-8000-00805f9b34fb` | Service UUID |
| `0000fff2-0000-1000-8000-00805f9b34fb` | Write Characteristic (TX) |
| `0000fff1-0000-1000-8000-00805f9b34fb` | Notify Characteristic (RX) |

**Used by**: Older Dyaco equipment with legacy BLE firmware.

#### How the App Detects and Handles Both Services

> **Source**: [MyBluetoothLE.java:106-163](sole_fitness_jadx/sources/com/dyaco/ideabussdk_sole/bluetooth/MyBluetoothLE.java#L106-L163)

The SOLE Fitness app scans for GATT services after connecting and handles both variants:

```java
// From MyBluetoothLE.java:114-141 - Service detection logic
for (BluetoothGattService service : gattServices) {
    if (service.getUuid().equals(MY_UUID_SERVICE)) {
        // Primary ISSC service found
        // Set up write/notify characteristics from 49535343-xxxx UUIDs
    } else if (service.getUuid().equals(SECOND_SERVICE)) {
        // Secondary/legacy service found
        this.isNewType = true;  // Flag set (confusingly named)
        // Set up write/notify characteristics from 0000fffx UUIDs
    }
}
```

**Key findings from code analysis:**

1. **Detection is automatic**: The app iterates through all GATT services and uses whichever UART service is present
2. **The `isNewType` flag is set but never used**: Despite setting `isNewType = true` when the secondary service is found ([MyBluetoothLE.java:141](sole_fitness_jadx/sources/com/dyaco/ideabussdk_sole/bluetooth/MyBluetoothLE.java#L141)), this flag is **never read** anywhere in the codebase
3. **Protocol is identical**: Both services use the **exact same command/response format** (`[0x5B][LENGTH][CMD][DATA...][0x5D]`)
4. **No parsing differences**: There are no conditional branches based on which service is used

#### FTMS Support by Service Type

| Service | Supports FTMS? | Notes |
|---------|---------------|-------|
| Primary (ISSC) | ✅ Yes | Modern equipment typically advertises both UART and FTMS |
| Secondary (Legacy) | ❌ Unlikely | Older hardware predates FTMS adoption |

**Evidence**: The **Sole+ app** (which only uses FTMS) has no references to either UART service UUID ([BleUuid.java](sole_plus_jadx/sources/com/soletreadmills/sole_v2/ble/BleUuid.java) contains only FTMS UUIDs). This suggests:
- Sole+ was designed for newer FTMS-capable equipment only
- Older equipment with secondary UART likely doesn't support FTMS
- The legacy SOLE Fitness app maintains backward compatibility via the secondary service

#### Practical Implications

| Scenario | Primary (ISSC) | Secondary (Legacy) |
|----------|---------------|-------------------|
| **Protocol commands** | Identical | Identical |
| **Data parsing** | Identical | Identical |
| **FTMS available** | Likely yes | Likely no |
| **Equipment age** | Newer models | Older models |

**For developers**: Simply try both service UUIDs when connecting. Use whichever is present - the protocol layer is completely interchangeable.

### FTMS Service (Standard Bluetooth)

| UUID | Description |
|------|-------------|
| `00001826-0000-1000-8000-00805f9b34fb` | Fitness Machine Service |
| `00002acc-0000-1000-8000-00805f9b34fb` | Fitness Machine Feature |
| `00002acd-0000-1000-8000-00805f9b34fb` | Treadmill Data (notify) |
| `00002ad2-0000-1000-8000-00805f9b34fb` | Indoor Bike Data (notify) |
| `00002ace-0000-1000-8000-00805f9b34fb` | Cross Trainer Data (notify) |
| `00002ad3-0000-1000-8000-00805f9b34fb` | Training Status (notify) |
| `00002ada-0000-1000-8000-00805f9b34fb` | Fitness Machine Status (notify) |
| `00002ad9-0000-1000-8000-00805f9b34fb` | Control Point (write/indicate) |

---

## FTMS Sole-Specific Extensions

> **Source**: Decompiled from Sole+ app v4.11 (`com.soletreadmills.sole_v2`)

The Sole+ app uses **standard FTMS UUIDs** but extends the Control Point (0x2AD9) with **vendor-specific op codes** in the 0xE0-0xEF range. These are NOT part of the Bluetooth FTMS specification.

### Initialization Sequence

From [FtmsDeviceManager.java](sole_plus_jadx/sources/com/soletreadmills/sole_v2/ble/manager/FtmsDeviceManager.java):1391-1392, the app sends these commands **unconditionally for ALL devices** on connection:

```java
// In initialize() method - sent for ALL devices
sendCmd(FitnessMachineControlPointCmd.requestControl(), ...);  // 0x00
sendCmd(FitnessMachineControlPointCmd.getSupportProgram(), ...);  // 0xE9
```

### Sole-Specific Control Point Op Codes

From [FitnessMachineControlPointOpCode.java](sole_plus_jadx/sources/com/soletreadmills/sole_v2/ble/code/FitnessMachineControlPointOpCode.java):

| Op Code | Hex | Name | Purpose |
|---------|-----|------|---------|
| -23 | **0xE9** | **SUPPORT_PROGRAM** | Query if device supports program features (sent on init) |
| -24 | 0xE8 | CURRENT_PROGRAM | Get current program info |
| -31 | 0xE1 | PROGRAM_E1 | Send program settings (age, weight, time, max speed, max level, target HR) |
| -30 | 0xE2 | PROGRAM_E2 | Speed profile array (entries 0-18) |
| -29 | 0xE3 | PROGRAM_E3 | Speed profile array (entries 19+) |
| -28 | 0xE4 | PROGRAM_E4 | Incline profile array (entries 0-18) |
| -27 | 0xE5 | PROGRAM_E5 | Incline profile array (entries 19+) |
| -26 | 0xE6 | PROGRAM_E6 | Level/resistance profile array (entries 0-18) |
| -25 | 0xE7 | PROGRAM_E7 | Level/resistance profile array (entries 19+) |
| -17 | 0xEF | SET_DISPLAY_HEART_RATE | Set target heart rate for display |

### Standard FTMS Control Point Op Codes (for reference)

| Op Code | Hex | Name |
|---------|-----|------|
| 0 | 0x00 | REQUEST_CONTROL |
| 1 | 0x01 | RESET |
| 2 | 0x02 | SET_TARGET_SPEED |
| 3 | 0x03 | SET_TARGET_INCLINATION |
| 4 | 0x04 | SET_TARGET_RESISTANCE_LEVEL |
| 5 | 0x05 | SET_TARGET_POWER |
| 6 | 0x06 | SET_TARGET_HEART_RATE |
| 7 | 0x07 | START_OR_RESUME |
| 8 | 0x08 | STOP_OR_PAUSE |
| -128 | 0x80 | RESPONSE_CODE |

### PROGRAM_E1 Payload Format

From [FitnessMachineControlPointCmd.java](sole_plus_jadx/sources/com/soletreadmills/sole_v2/ble/cmd/FitnessMachineControlPointCmd.java):95-145:

```
[0xE1] [program_type] [age] [weight] [time_lo] [time_hi] [speed_lo] [speed_hi] [00] [max_level] [00] [target_hr] [00] [00] [00]
```

| Byte | Field | Format |
|------|-------|--------|
| 0 | Op Code | 0xE1 |
| 1 | Program Type | 01=Manual, 02=Hill, 03=Fatburn, 04=Cardio, 05=Strength, 06=Interval, 07=Custom |
| 2 | Age | Unsigned byte |
| 3 | Weight | Unsigned byte (kg or lbs depending on device) |
| 4-5 | Time | Little-endian, seconds |
| 6-7 | Max Speed | Little-endian, speed × 100 (e.g., 1000 = 10.00 km/h) |
| 8 | Reserved | 0x00 |
| 9 | Max Level | Resistance level (bikes/ellipticals) |
| 10 | Reserved | 0x00 |
| 11 | Target HR | Heart rate zone target |
| 12-14 | Reserved | 0x00 |

### Key Insights

1. **0xE9 is NOT required for passive monitoring** - it's just a capability query for program upload features
2. **These commands are for program upload only** - 0xE1-E7 let you upload custom workout profiles to the device
3. **They do NOT provide additional metrics** - incline, distance, calories are still unavailable via FTMS
4. **They do NOT enable real-time device control** - speed/incline control still requires UART protocol

### When to Use Sole-Specific Commands

| Goal | Commands Needed |
|------|-----------------|
| **Passive speed/HR monitoring** | Just enable notifications on 0x2ACD (maybe 0x00 first) |
| **Check program upload support** | Send 0xE9, check response |
| **Upload custom workout program** | 0xE9 → 0xE1 (settings) → 0xE2-E7 (profiles) |
| **Get current program type** | Send 0xE8 |
| **Set display target HR** | Send 0xEF |

**Bottom line**: For passive monitoring, you likely don't need ANY of the 0xE0-0xEF commands.

---

## Proprietary UART Protocol Format

> **⚠️ Console Lockout Warning**: Using this protocol takes control from the treadmill console. For passive monitoring, use FTMS instead.

Messages are framed as:

```
[0x5B] [LENGTH] [CMD] [DATA...] [0x5D]
  '['    1 byte  1+    variable   ']'
```

- Start marker: `0x5B` (`[`)
- Length: Number of bytes after length field (excluding end marker)
- Command: 1 byte command code
- Data: Variable length, command-specific
- End marker: `0x5D` (`]`)

### Command Codes

| Cmd | Hex | Name | Description |
|-----|-----|------|-------------|
| 2 | 0x02 | SET_MODE | Set operating mode |
| 3 | 0x03 | GET_MODE | Current mode (broadcast continuously) |
| 4 | 0x04 | SET_WORKOUT_TIME | Set workout duration |
| 6 | 0x06 | GET_WORKOUT_DATA | Real-time workout metrics |
| 7 | 0x07 | SET_USER_PROFILE | Set age, weight, height, gender |
| 8 | 0x08 | SET_PROGRAM_MODE | Select workout program |
| 50 | 0x32 | END_WORKOUT | Workout summary data |
| 240 | 0xF0 | DEVICE_INFO | Device model, version, capabilities |
| 241 | 0xF1 | DEVICE_STATUS | Device status |

### Control Commands by Device Type

Different equipment types support different control commands:

| Command | Hex | Treadmill | Elliptical | Bike | Description |
|---------|-----|-----------|------------|------|-------------|
| SET_MAX_SPEED | 0x21 | ✅ | ❌ | ❌ | Belt speed (tenths of km/h) |
| SET_MAX_INCLINE | 0x22 | ✅ | ⚠️* | ❌ | Belt angle (%) |
| SET_MAX_LEVEL | 0x23 | ❌ | ✅ | ✅ | Resistance level (1-20) |
| SET_TARGET_HR | 0x20 | ✅ | ✅ | ✅ | Target heart rate (bpm) |
| SET_TARGET_WATT | 0x19 | ❌ | ✅ | ✅ | Target power (watts) |
| SET_USER_PROFILE | 0x07 | ✅ | ✅ | ✅ | Age, weight, height, sex |
| SET_PROGRAM_MODE | 0x08 | ✅ | ✅ | ✅ | Workout program type |
| SET_WORKOUT_TIME | 0x04 | ✅ | ✅ | ✅ | Duration (minutes) |

*Some ellipticals have adjustable ramp angle - check `has_max_incline` in DEVICE_INFO response.

**Key differences:**
- **Treadmills**: Control **speed** (belt speed) and **incline** (belt angle)
- **Bikes**: Control **level** (resistance) only - user controls their own cadence
- **Ellipticals**: Control **level** (resistance), some have **incline** (ramp angle)

### Increment/Decrement Commands (0xF1xx)

In addition to absolute value commands, the protocol supports step-up/step-down commands that change values by 1 unit. These are simpler (no data payload) and good for button-press interfaces:

| Command | Hex | Treadmill | Elliptical | Bike | Description |
|---------|-----|-----------|------------|------|-------------|
| SPEED_UP / LEVEL_UP | 0xF102 | Speed +1 | Level +1 | Level +1 | +0.1 km/h or +1 level |
| SPEED_DOWN / LEVEL_DOWN | 0xF103 | Speed -1 | Level -1 | Level -1 | -0.1 km/h or -1 level |
| INCLINE_UP | 0xF104 | Incline +1 | Incline +1* | ❌ | +1% (or 0.5% on some models) |
| INCLINE_DOWN | 0xF105 | Incline -1 | Incline -1* | ❌ | -1% (or 0.5% on some models) |

*Only for ellipticals with adjustable ramp.

**Command format:**
```
[5B][02][F1][subcommand][5D]
```
Where subcommand is: 02=up, 03=down, 04=incline up, 05=incline down

**When to use each:**
- **Absolute commands** (0x21-0x23): Set exact target values (e.g., "set speed to 8.5 km/h")
- **Increment commands** (0xF1xx): Step adjustment (e.g., "speed up one notch")

**Note:** The 0xF102/0xF103 commands are interpreted differently by device type:
- Treadmills: Speed up/down
- Bikes/Ellipticals: Level up/down

### Capability Detection via DEVICE_INFO (0xF0)

The DEVICE_INFO response tells you what controls are available:

**For Treadmills (deviceType=0):**
```
[5B][08][F0][model][sales][unit][max_speed][min_speed][max_incline][user_seg][5D]
```
- `max_speed` / `min_speed`: Speed range in tenths of km/h (e.g., 0xC8 = 20.0 km/h)
- `max_incline`: Maximum incline percentage (e.g., 0x0F = 15%)

**For Bikes/Ellipticals (deviceType=1,2):**
```
[5B][0A][F0][model][sales][unit][max_incline][max_level][user_seg][show_mode][has_incline][5D]
```
- `max_level`: Maximum resistance level (e.g., 0x14 = 20)
- `max_incline`: Maximum ramp angle (if supported)
- `has_incline`: 0x01 = device has adjustable incline/ramp

**Determining Device Type from Model Number:**

| Model Range | Device Type | Controls Available |
|-------------|-------------|-------------------|
| 128-191 | Treadmill | speed, incline |
| 0-2, 14, 16-21, 37-38, 84-85, 87-88, 96-97 | Elliptical | level, (incline*) |
| 3-15, 22-31, 39, 48-63, 83, 86, 99-106, 112-119 | Bike | level |

*Check `has_max_incline` field for ellipticals.

### Operating Modes (CMD 0x03)

| Mode | Hex | Description |
|------|-----|-------------|
| 1 | 0x01 | STOP |
| 2 | 0x02 | IDLE |
| 3 | 0x03 | RUNNING |
| 4 | 0x04 | PAUSE |
| 5 | 0x05 | COOLDOWN |
| 6 | 0x06 | SUMMARY |
| 7 | 0x07 | SLEEP |
| 128 | 0x80 | READY (BLE not linked to workout) |

### Device Info Response (CMD 0xF0)

The DEVICE_INFO response is the **primary source of device identification**. The format varies by device type.

Example (Treadmill): `5B08F0910000C80A0F125D`

**Common Fields (all device types):**

| Offset | Length | Field | Description |
|--------|--------|-------|-------------|
| 0 | 1 | Start | `0x5B` (`[`) |
| 1 | 1 | Length | Bytes after length (excluding end) |
| 2 | 1 | Command | `0xF0` |
| 3 | 1 | **Model** | Model number (0-255) - **primary identifier** |
| 4 | 1 | Sales Version | 0x00 = International, 0x01 = US |
| 5 | 1 | Unit | 0x00 = Metric, 0x01 = Imperial |

**Treadmill-specific fields (deviceType=0):**

| Offset | Length | Field | Example |
|--------|--------|-------|---------|
| 6 | 1 | Max Speed | 0xC8 = 200 (20.0 km/h) |
| 7 | 1 | Min Speed | 0x0A = 10 (1.0 km/h) |
| 8 | 1 | Max Incline | 0x0F = 15% |
| 9 | 1 | User Segment | Program segment count |

**Elliptical/Bike-specific fields (deviceType=1,2):**

| Offset | Length | Field | Example |
|--------|--------|-------|---------|
| 6 | 1 | Max Incline | Resistance/incline levels |
| 7 | 1 | Max Level | Maximum resistance level |
| 8 | 1 | User Segment | Program segment count |
| 9 | 1 | Show Incline Mode | Display mode |
| 10 | 1 | Has Max Incline | 0x01 = has feature |

---

## Model Number Identification

> **⚠️ UART Protocol Only**: This section describes device identification via the proprietary UART protocol. Getting the model number **requires sending a 0xF0 command** to the device - this is NOT passive. For passive identification, use the BLE device name from advertisements.

The **model number** (byte 3 of DEVICE_INFO response) is the canonical identifier. From it, the app derives device type, brand, and capabilities.

### Device Type Detection

From [SoleProtocol.java](sole_fitness_jadx/sources/com/dyaco/ideabussdk_sole/protocol/SoleProtocol.java):1946-1955:

| Device Type | ID | Model Ranges |
|-------------|----|--------------|
| **Treadmill** | 0 | 128-191 |
| **Elliptical** | 1 | 0-2, 14, 16-21, 37-38, 84-85, 87-88, 96-97 |
| **Bike** | 2 | 3-15, 22-31, 39, 48-63, 83, 86, 99-106, 112-119 |
| *Default* | 1 | Any other value → Elliptical |

```java
// Simplified logic from SoleProtocol.java
if (model >= 128 && model < 192) {
    deviceType = TREADMILL;  // 0
} else if (/* elliptical ranges */) {
    deviceType = ELLIPTICAL; // 1
} else if (/* bike ranges */) {
    deviceType = BIKE;       // 2
} else {
    deviceType = ELLIPTICAL; // default
}
```

### Brand Detection

From [SoleProtocol.java](sole_fitness_jadx/sources/com/dyaco/ideabussdk_sole/protocol/SoleProtocol.java):1957-1969:

| Brand | ID | Model Ranges |
|-------|----|--------------|
| **SOLE** | 0 | 16-31, 144-159 |
| **Spirit** | 1 | 0-15, 83-88, 96-97, 128-143 |
| **XTERRA** | 2 | 48-63, 112-119, 160-175 |
| **Fuel** | 3 | 32-47, 100-106, 176-191 |
| *Default* | 0 | Any other value → SOLE |

```java
// From SoleProtocol.java:1958-1969
if ((model >= 16 && model < 32) || (model >= 144 && model < 160)) {
    brand = SOLE;    // 0
} else if ((model >= 0 && model < 16) || (model >= 83 && model <= 88) ||
           (model >= 128 && model < 144) || (model >= 96 && model < 98)) {
    brand = SPIRIT;  // 1
} else if ((model >= 48 && model < 64) || (model >= 160 && model < 176) ||
           (model >= 112 && model <= 119)) {
    brand = XTERRA;  // 2
} else if ((model >= 32 && model < 48) || (model >= 100 && model <= 106) ||
           (model >= 176 && model < 192)) {
    brand = FUEL;    // 3
} else {
    brand = SOLE;    // default
}
```

### BLE Name Overrides (Firmware Bug Workarounds)

Some devices report **incorrect model numbers** in the DEVICE_INFO protocol response. The app works around this by detecting the BLE device name and overriding the model after parsing (from [SoleProtocol.java](sole_fitness_jadx/sources/com/dyaco/ideabussdk_sole/protocol/SoleProtocol.java):1933-1945):

**How it works:**
1. Model is first parsed from DEVICE_INFO response: `deviceModel = parseInt(response[3], 16)`
2. If BLE device name matches one of 5 known problematic devices, the model is **unconditionally overridden**
3. The original "wrong" model number is not logged - we don't know what incorrect value these devices report

**Override Table:**

| BLE Device Name | Forced Model # | Forced Model Name | Expected Constant | Brand | Type |
|-----------------|----------------|-------------------|-------------------|-------|------|
| `E95s` | 27 (0x1B) | E95s | MODEL_E95s = 27 ✓ | SOLE | Elliptical |
| `LCR` | 21 (0x15) | LCR | MODEL_LCR = 21 ✓ | SOLE | Bike |
| `S77` | 148 (0x94) | S77 | MODEL_S77 = 148 ✓ | SOLE | Treadmill |
| `XT385` | 130 (0x82) | XT185 | MODEL_XT385 = 128 ⚠️ | Spirit | Treadmill |
| `B94` | 18 (0x12) | B94 | MODEL_B94 = 18 ✓ | SOLE | Bike |

**Note on XT385:** The override sets model to 130 (XT185), but `MODEL_XT385 = 128` in Spirit_DeviceModelList.java. This appears to be intentional - perhaps this specific firmware variant needs XT185's protocol behavior, or there's a bug in the app.

```java
// From SoleProtocol.java:1933-1945
// First, parse model from protocol:
this.deviceModel = Integer.parseInt(response.substring(4, 6), 16);

// Then override if BLE name matches known problematic devices:
if ("E95s".equals(deviceName)) {
    deviceModel = 27;   // Forces SOLE E95s (elliptical)
} else if ("LCR".equals(deviceName)) {
    deviceModel = 21;   // Forces SOLE LCR (bike)
} else if ("S77".equals(deviceName)) {
    deviceModel = 148;  // Forces SOLE S77 (treadmill)
} else if ("XT385".equals(deviceName)) {
    deviceModel = 130;  // Forces Spirit XT185 (treadmill) - see note above
} else if ("B94".equals(deviceName)) {
    deviceModel = 18;   // Forces SOLE B94 (bike)
}
```

**Why this matters:** Model number determines device type, brand, capabilities, and protocol variations. If a device reports the wrong model, it could cause parsing errors or incorrect behavior.

### Model Number Summary Table

| Model Range | Device Type | Brand | Example Models |
|-------------|-------------|-------|----------------|
| 0-2 | Elliptical | Spirit | XBR25, XBR55, XBU55 |
| 3-15 | Bike | Spirit | XE195, XE295, XE395 |
| 14 | Elliptical | Spirit | CVC800 |
| 16-21 | Elliptical | SOLE | E25, E35, E55, E95 |
| 22-31 | Bike | SOLE | B94, R92, LCB, LCR |
| 32-47 | Bike | Fuel | FE500, FE600 |
| 48-63 | Bike | XTERRA | FS5.8e, FS5.3e, EC300 |
| 83-88 | Mixed | Spirit | CE800, CR800, CE850, CS800 |
| 96-97 | Elliptical | Spirit | IF700, IF300 |
| 99-106 | Bike | Fuel | FE900, EC1000, CT100-500 |
| 112-119 | Bike | XTERRA | FE900, EC1000, CT100-500 |
| 128-143 | Treadmill | Spirit | XT185, XT285, XT385, XT485, XT685, CT800 |
| 144-159 | Treadmill | SOLE | **F63, F65, F80, F85, S77** |
| 160-175 | Treadmill | XTERRA | TR3.0, TR6.45, TR6.65, TRX3500 |
| 176-191 | Treadmill | Fuel | FT500, FT520 |

**Note:** The F65 reports model **145** (0x91), which maps to:
- Device Type: Treadmill (145 is in 128-191)
- Brand: SOLE (145 is in 144-159)

---

## Complete Model Number to Name Mapping

The model number is the **index into the DEVICE_NAME_LIST array** in each brand's device list file. Below are all known model numbers extracted from the decompiled source.

### SOLE Models

From [Sole_DeviceModelList.java](sole_fitness_jadx/sources/com/dyaco/sole/custom/Sole_DeviceModelList.java):

| Model # | Hex | Name | Type |
|---------|-----|------|------|
| 16 | 0x10 | B74 | Bike |
| 17 | 0x11 | R72 | Bike |
| 18 | 0x12 | B94 | Bike |
| 19 | 0x13 | R92 | Bike |
| 20 | 0x14 | LCB | Bike |
| 21 | 0x15 | LCR | Bike |
| 22 | 0x16 | E25 | Elliptical |
| 23 | 0x17 | E35 | Elliptical |
| 24 | 0x18 | E55 | Elliptical |
| 25 | 0x19 | E95 | Elliptical |
| 26 | 0x1A | E98 | Elliptical |
| 27 | 0x1B | E95s | Elliptical |
| 28 | 0x1C | E98s | Elliptical |
| 29 | 0x1D | SC200 | Bike |
| 30 | 0x1E | SC200 | Bike |
| 31 | 0x1F | SC300 | Bike |
| 64 | 0x40 | E96S | Elliptical |
| **144** | **0x90** | **F63** | **Treadmill** |
| **145** | **0x91** | **F65** | **Treadmill** |
| **146** | **0x92** | **F80** | **Treadmill** |
| **147** | **0x93** | **F85** | **Treadmill** |
| **148** | **0x94** | **S77** | **Treadmill** |
| **149** | **0x95** | **TT8** | **Treadmill** |

### Spirit Models

From [Spirit_DeviceModelList.java](sole_fitness_jadx/sources/com/dyaco/sole/custom/Spirit_DeviceModelList.java):

| Model # | Hex | Name | Type |
|---------|-----|------|------|
| 0 | 0x00 | XBR25 | Elliptical |
| 1 | 0x01 | XBR55 | Elliptical |
| 2 | 0x02 | XBU55 | Elliptical |
| 3 | 0x03 | XE195 | Bike |
| 4 | 0x04 | XE295 | Bike |
| 5 | 0x05 | XG400 | Bike |
| 6 | 0x06 | XE395 | Bike |
| 7 | 0x07 | XE895 | Bike |
| 10 | 0x0A | XS895 | Bike |
| 11 | 0x0B | JE002 | Bike |
| 12 | 0x0C | CDAB900 | Bike |
| 13 | 0x0D | CRW_900 | Bike |
| 14 | 0x0E | CVC800 | Elliptical |
| 83 | 0x53 | CE800 | Elliptical |
| 84 | 0x54 | CR800 | Elliptical |
| 85 | 0x55 | CU800 | Elliptical |
| 86 | 0x56 | CE850 | Bike |
| 87 | 0x57 | CS800 | Elliptical |
| 88 | 0x58 | CRS800S | Elliptical |
| 96 | 0x60 | IF700 | Elliptical |
| 97 | 0x61 | IF300 | Elliptical |
| 98 | 0x62 | RG500 | Bike |
| 99 | 0x63 | CE800ENT | Bike |
| 128 | 0x80 | XT385 | Treadmill |
| 129 | 0x81 | XT285 | Treadmill |
| 130 | 0x82 | XT185 | Treadmill |
| 131 | 0x83 | XT485 | Treadmill |
| 132 | 0x84 | XT685 | Treadmill |
| 133 | 0x85 | XT385 | Treadmill |
| 135 | 0x87 | MT100T | Treadmill |
| 136 | 0x88 | CT800 | Treadmill |
| 137 | 0x89 | CT800ENT | Treadmill |
| 138 | 0x8A | CT850 | Treadmill |

### XTERRA Models

From [Xterra_DeviceModelList.java](sole_fitness_jadx/sources/com/dyaco/sole/custom/Xterra_DeviceModelList.java):

| Model # | Hex | Name | Type |
|---------|-----|------|------|
| 48 | 0x30 | FS5.8e | Bike |
| 49 | 0x31 | FS5.3e | Bike |
| 51 | 0x33 | XE88 | Bike |
| 52 | 0x34 | EC300 | Bike |
| 53 | 0x35 | XE78 | Bike |
| 54 | 0x36 | FE300 | Bike |
| 55 | 0x37 | FSX3500 | Bike |
| 56 | 0x38 | FSX1500 | Bike |
| 57 | 0x39 | FSX2500 | Bike |
| 58 | 0x3A | LE100 | Bike |
| 59 | 0x3B | LE500 | Bike |
| 112 | 0x70 | FE900 | Bike |
| 113 | 0x71 | EC1000 | Bike |
| 114 | 0x72 | EC900 | Bike |
| 115 | 0x73 | FE100 | Bike |
| 116 | 0x74 | CT100 | Bike |
| 117 | 0x75 | CT300 | Bike |
| 118 | 0x76 | CT500 | Bike |
| 119 | 0x77 | EC100 | Bike |
| 160 | 0xA0 | TR3.0 | Treadmill |
| 161 | 0xA1 | TR6.45 | Treadmill |
| 162 | 0xA2 | TR6.65 | Treadmill |
| 163 | 0xA3 | TRX3500 | Treadmill |
| 164 | 0xA4 | TRX4500 | Treadmill |
| 165 | 0xA5 | IT80 | Treadmill |
| 166 | 0xA6 | XT800 HRC | Treadmill |
| 167 | 0xA7 | XT900 HRC | Treadmill |
| 168 | 0xA8 | TRX7.5 | Treadmill |
| 169 | 0xA9 | XTERRA3000 | Treadmill |

### Fuel Models

From [Fuel_DeviceModelList.java](sole_fitness_jadx/sources/com/dyaco/sole/custom/Fuel_DeviceModelList.java):

| Model # | Hex | Name | Type |
|---------|-----|------|------|
| 37 | 0x25 | FE500 | Elliptical |
| 38 | 0x26 | FE500NEW | Elliptical |
| 39 | 0x27 | FE666 | Elliptical |
| 40 | 0x28 | FE600 | Elliptical |
| 100 | 0x64 | FE900 | Bike |
| 101 | 0x65 | EC1000 | Bike |
| 102 | 0x66 | CE900 | Bike |
| 103 | 0x67 | FE100 | Bike |
| 104 | 0x68 | CT100 | Bike |
| 105 | 0x69 | CT300 | Bike |
| 106 | 0x6A | CT500 | Bike |
| 176 | 0xB0 | FT500 | Treadmill |
| 177 | 0xB1 | FT335 | Treadmill |
| 178 | 0xB2 | FT520 | Treadmill |

---

### Workout Data Response (CMD 0x06)

The workout data format varies by device type. This is the **primary source of real-time metrics** during a workout.

> **Source**: [SoleProtocol.java](sole_fitness_jadx/sources/com/dyaco/ideabussdk_sole/protocol/SoleProtocol.java) lines 2039-2222

**For Treadmill (deviceType=0):**

| Offset | Length | Field | Scale | pyftms Property |
|--------|--------|-------|-------|-----------------|
| 4-5 | 1 | Minutes | 1 | `time_elapsed` (combined) |
| 6-7 | 1 | Seconds | 1 | `time_elapsed` (combined) |
| 8-11 | 2 | Distance | /100 (km) | `distance_total` (converted to m) |
| 12-15 | 2 | Calories | /1 | `energy_total` |
| 16-17 | 1 | Heart Rate | 1 | `heart_rate` |
| 18-19 | 1 | Speed | /10 (km/h) | `speed_instant` |
| 20-21 | 1 | Incline | 1 (%) | `inclination` |
| 22-23 | 1 | HR Type | enum | (not mapped) |
| 24-25 | 1 | Fusion Interval | 1 | (not mapped) |
| 26-27 | 1 | Fusion Recovery | 1 | (not mapped) |
| 28-29 | 1 | Program Row | 1 | (not mapped) |
| 30-31 | 1 | Program Height | 1 | (not mapped) |

**For Bike/Elliptical (deviceType=1 or 2):**

> **Source**: [SoleProtocol.java](sole_fitness_jadx/sources/com/dyaco/ideabussdk_sole/protocol/SoleProtocol.java) lines 2125-2174

| Offset | Length | Field | Scale | pyftms Property |
|--------|--------|-------|-------|-----------------|
| 4-5 | 1 | Minutes | 1 | `time_elapsed` (combined) |
| 6-7 | 1 | Seconds | 1 | `time_elapsed` (combined) |
| 8-11 | 2 | Distance | /100 (km) | `distance_total` (converted to m) |
| 12-15 | 2 | Calories | /10 | `energy_total` |
| 16-17 | 1 | Heart Rate | 1 | `heart_rate` |
| 18-19 | 1 | RPM | 1 | `cadence_instant` |
| 20-23 | 2 | Speed | /100 (km/h) | `speed_instant` |
| 24-27 | 2 | Watt | 1 | `power_instant` |
| 28-29 | 1 | Level* | 1 | `resistance_level` |
| 32-33 | 1 | HR Type | enum | (not mapped) |
| 34-35 | 1 | Fusion Interval | 1 | (not mapped) |
| 36-37 | 1 | Fusion Recovery | 1 | (not mapped) |
| 38-39 | 1 | Program Row | 1 | (not mapped) |

*\*Level field: Only present in specific models (31=SC200, 30=SC200, 10=XS895). See Special Models below.*

**Special Models (31, 30, 10) - Different Format:**

> **Source**: [SoleProtocol.java](sole_fitness_jadx/sources/com/dyaco/ideabussdk_sole/protocol/SoleProtocol.java) lines 2128-2140

These models (SC200 bikes and XS895) have a different extended format that includes:
- `nowLevel` (resistance level) at offset 18-19
- `nowIncline` (ramp angle) at offset 20-23
- `spm` (steps per minute) at offset 24-27
- `totalSteps` at offset 28-35
- `vert` (vertical distance) at offset 36-43
- `watt` at offset 44-47

### UART Properties Summary by Device Type

Based on the above workout data formats, these are the properties available via UART:

| Property | Treadmill | Bike/Elliptical | Notes |
|----------|-----------|-----------------|-------|
| `time_elapsed` | ✅ | ✅ | Combined from minutes + seconds |
| `speed_instant` | ✅ | ✅ | km/h |
| `distance_total` | ✅ | ✅ | Converted to meters |
| `energy_total` | ✅ | ✅ | Calories (different scale) |
| `heart_rate` | ✅ | ✅ | bpm |
| `inclination` | ✅ | ❌ | % (treadmill only) |
| `cadence_instant` | ❌ | ✅ | RPM (bikes/ellipticals only) |
| `power_instant` | ❌ | ✅ | Watts (bikes/ellipticals only) |
| `resistance_level` | ❌ | ⚠️ | Only on models 31, 30, 10 |

**⚠️ Important**: `resistance_level` is **NOT** in the standard workout data response for most bikes/ellipticals. The app tracks resistance as a control setting (`nowLevel`), but it's not continuously reported in workout data except for the specific models listed above.

---

## FTMS Treadmill Data Format

FTMS Treadmill Data (UUID `0x2ACD`) follows the Bluetooth FTMS specification:

```
[FLAGS (2 bytes)] [FIELDS based on flags...]
```

### Flag Bits

| Bit | Description | Data Size |
|-----|-------------|-----------|
| 0 | More Data (1=no speed) | - |
| 1 | Average Speed Present | 2 bytes |
| 2 | Total Distance Present | 3 bytes |
| 3 | Inclination Present | 4 bytes |
| 4 | Elevation Gain Present | 4 bytes |
| 5 | Instantaneous Pace Present | 1 byte |
| 6 | Average Pace Present | 1 byte |
| 7 | Expended Energy Present | 5 bytes |
| 8 | Heart Rate Present | 1 byte |
| 9 | Metabolic Equivalent Present | 1 byte |
| 10 | Elapsed Time Present | 2 bytes |
| 11 | Remaining Time Present | 2 bytes |
| 12 | Force on Belt Present | 4 bytes |

**Note:** The SOLE F65's FTMS implementation only sends speed and heart rate fields (flags `0x0100`). The Feature characteristic returns `0x00000000` indicating no optional features supported.

---

## Source Files

The decompiled source code is available at:

- [SoleProtocol.java](sole_fitness_jadx/sources/com/dyaco/ideabussdk_sole/protocol/SoleProtocol.java) - Main protocol implementation (~2400 lines)
- [CommandType.java](sole_fitness_jadx/sources/com/dyaco/ideabussdk_sole/protocol/CommandType.java) - Command constants
- [WorkoutData.java](sole_fitness_jadx/sources/com/dyaco/ideabussdk_sole/protocol/WorkoutData.java) - Workout data structure
- [EndWorkoutData.java](sole_fitness_jadx/sources/com/dyaco/ideabussdk_sole/protocol/EndWorkoutData.java) - End workout summary
- [MyBluetoothLE.java](sole_fitness_jadx/sources/com/dyaco/ideabussdk_sole/bluetooth/MyBluetoothLE.java) - BLE communication layer

---

## Python Monitoring Library

A Python library for monitoring SOLE equipment is provided in [sole_monitor/](sole_monitor/):

| File | Description |
|------|-------------|
| [sole_protocol.py](sole_monitor/sole_protocol.py) | Proprietary protocol constants and parser |
| [sole_ftms.py](sole_monitor/sole_ftms.py) | FTMS protocol support |
| [sole_client.py](sole_monitor/sole_client.py) | BLE client using bleak |
| [example.py](sole_monitor/example.py) | CLI monitoring tool |

### Quick Start

```bash
cd sole_monitor
pip install bleak

# Scan for devices
python example.py --scan

# Monitor (connects to first device found)
python example.py

# With debug output
python example.py --debug
```

### Programmatic Usage

```python
import asyncio
from sole_monitor import SoleMonitor, WorkoutData, FTMSTreadmillData

async def main():
    monitor = SoleMonitor()

    # Full data (requires app-controlled workout)
    def on_workout(data: WorkoutData):
        print(f"Speed: {data.speed}, Incline: {data.incline}%, Cal: {data.calories}")

    # Basic data (works for console workouts)
    def on_ftms(data: FTMSTreadmillData):
        print(f"FTMS Speed: {data.speed_kmh} km/h")

    monitor.on_workout_data = on_workout
    monitor.on_ftms_data = on_ftms

    devices = await SoleMonitor.scan()
    if devices:
        await monitor.connect(devices[0].ble_device)
        await monitor.start_monitoring()

asyncio.run(main())
```

---

## Limitations

1. **Console Workouts**: When the workout is started from the treadmill console (not the app), only basic FTMS data (speed, HR) is available. No incline, distance, or calories.

2. **Single Connection**: BLE only allows one central connection. If the SOLE app is connected, the monitoring library cannot connect.

3. **FTMS Implementation**: The F65's FTMS implementation is minimal. The Feature register returns `0x00000000` and only speed/HR are broadcast.

4. **Model Variations**: Different SOLE/Spirit/XTERRA models may have different protocol variations. The parsing is based on model number.

---

## Equipment Tested

- SOLE F65 Treadmill (Model 145, Spirit brand internally)

---

## Multi-Brand Compatibility

The protocol should work with **SOLE, Spirit, XTERRA, and Fuel** equipment. Here's the evidence from the decompiled source code:

### Evidence 1: Shared Dyaco SDK

All brands use the same BLE SDK: `com.dyaco.ideabussdk_sole`. Dyaco is the parent company that manufactures equipment for all these consumer brands. The core protocol implementation in [SoleProtocol.java](sole_fitness_jadx/sources/com/dyaco/ideabussdk_sole/protocol/SoleProtocol.java) is shared across all brands.

### Evidence 2: Brand Constants

From [Global.java](sole_fitness_jadx/sources/com/dyaco/sole/custom/Global.java):40-48:

```java
public static int BRAND = 0;
public static final int SOLE = 0;
public static final int SPIRIT = 1;
public static final int XTERRA = 2;
public static final int FUEL = 3;
```

### Evidence 3: Brand Detection from Model Number

The app determines the brand from the device's model number (from [SoleProtocol.java](sole_fitness_jadx/sources/com/dyaco/ideabussdk_sole/protocol/SoleProtocol.java):1957-1969):

| Model Range | Brand |
|-------------|-------|
| 16-31, 144-159 | SOLE |
| 0-15, 83-88, 96-97, 128-143 | Spirit |
| 48-63, 112-119, 160-175 | XTERRA |
| 32-47, 100-106, 176-191 | Fuel |

### Evidence 4: Separate Device Lists, Same Protocol

Each brand has its own device name list but uses the **same protocol parser and data structures**:

- [Sole_DeviceModelList.java](sole_fitness_jadx/sources/com/dyaco/sole/custom/Sole_DeviceModelList.java) - F63, F65, F80, F85, E25, E35, etc.
- [Spirit_DeviceModelList.java](sole_fitness_jadx/sources/com/dyaco/sole/custom/Spirit_DeviceModelList.java) - CT800, XT385, XT485, CE800, etc.
- [Xterra_DeviceModelList.java](sole_fitness_jadx/sources/com/dyaco/sole/custom/Xterra_DeviceModelList.java) - TR6.65, TRX4500, FS5.8e, etc.
- [Fuel_DeviceModelList.java](sole_fitness_jadx/sources/com/dyaco/sole/custom/Fuel_DeviceModelList.java) - FT500, FE900, CT100, etc.

From [DeviceModelList.java](sole_fitness_jadx/sources/com/dyaco/sole/custom/DeviceModelList.java):61-67:

```java
if (Global.BRAND == 0) {
    strArr = Sole_DeviceModelList.DEVICE_NAME_LIST;
} else if (Global.BRAND == 1) {
    strArr = Spirit_DeviceModelList.DEVICE_NAME_LIST;
} else {
    strArr = Global.BRAND == 2 ? Xterra_DeviceModelList.DEVICE_NAME_LIST
                               : Fuel_DeviceModelList.DEVICE_NAME_LIST;
}
```

### What This Means

- The BLE protocol (UUIDs, commands, data formats) is **identical** across all brands
- Only the UI/branding and device name mappings differ
- The F65 reports as model 145 with brand "Spirit" internally, confirming cross-brand firmware
- Any equipment using the Dyaco `ideabussdk_sole` SDK should be compatible
