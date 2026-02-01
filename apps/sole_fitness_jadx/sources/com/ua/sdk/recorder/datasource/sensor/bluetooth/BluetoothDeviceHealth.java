package com.ua.sdk.recorder.datasource.sensor.bluetooth;

import com.ua.sdk.recorder.SensorHealth;
import com.ua.sdk.recorder.datasource.sensor.DeviceHealth;

/* loaded from: classes2.dex */
public class BluetoothDeviceHealth extends DeviceHealth {
    private int batteryRemaining;
    private int rssi;

    public void setRssi(int i) {
        this.rssi = i;
    }

    public void setBatteryRemaining(int i) {
        this.batteryRemaining = i;
    }

    @Override // com.ua.sdk.recorder.datasource.sensor.DeviceHealth
    public SensorHealth calculateOverallHealth() {
        SensorHealth sensorHealth;
        int iCalculateRssi = calculateRssi();
        if (iCalculateRssi >= 70) {
            sensorHealth = SensorHealth.VERY_GOOD;
        } else if (iCalculateRssi >= 50) {
            sensorHealth = SensorHealth.GOOD;
        } else if (iCalculateRssi >= 30) {
            sensorHealth = SensorHealth.AVERAGE;
        } else if (iCalculateRssi >= 20) {
            sensorHealth = SensorHealth.BAD;
        } else {
            sensorHealth = SensorHealth.VERY_BAD;
        }
        if (this.batteryRemaining > 25) {
            return sensorHealth;
        }
        int iOrdinal = sensorHealth.ordinal();
        if (iOrdinal < 4) {
            iOrdinal++;
        }
        if (this.batteryRemaining <= 10 && iOrdinal < 4) {
            iOrdinal++;
        }
        return SensorHealth.values()[iOrdinal];
    }

    private int calculateRssi() {
        int i = this.rssi;
        if (i <= -100) {
            return 0;
        }
        if (i >= -50) {
            return 100;
        }
        return (i + 100) * 2;
    }
}
