package com.ua.sdk.recorder.data;

import com.ua.sdk.datapoint.BaseDataTypes;

/* loaded from: classes2.dex */
public enum BluetoothServiceType {
    HEART_RATE(BaseDataTypes.ID_HEART_RATE),
    RUN_SPEED_CADENCE("run_speed_cadence"),
    BIKE_POWER("bike_power"),
    BIKE_SPEED_CADENCE("bike_speed_cadence"),
    ARMOUR_39("armour_39");

    private String type;

    BluetoothServiceType(String str) {
        this.type = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.type;
    }

    public static BluetoothServiceType fromString(String str) {
        if (str == null) {
            return null;
        }
        for (BluetoothServiceType bluetoothServiceType : values()) {
            if (bluetoothServiceType.type.equalsIgnoreCase(str)) {
                return bluetoothServiceType;
            }
        }
        return null;
    }
}
