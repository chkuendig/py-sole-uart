package com.ua.sdk.recorder.datasource.sensor.location;

import com.ua.sdk.recorder.SensorHealth;
import com.ua.sdk.recorder.datasource.sensor.DeviceHealth;

/* loaded from: classes2.dex */
public class LocationDeviceHealth extends DeviceHealth {
    private float accuracy;

    public void setAccuracy(float f) {
        this.accuracy = f;
    }

    @Override // com.ua.sdk.recorder.datasource.sensor.DeviceHealth
    public SensorHealth calculateOverallHealth() {
        float f = this.accuracy;
        if (f > 400.0f) {
            return SensorHealth.VERY_BAD;
        }
        if (f > 275.0f) {
            return SensorHealth.BAD;
        }
        if (f > 150.0f) {
            return SensorHealth.AVERAGE;
        }
        if (f > 50.0f) {
            return SensorHealth.GOOD;
        }
        if (f > 0.0f) {
            return SensorHealth.VERY_GOOD;
        }
        return SensorHealth.UNKNOWN;
    }
}
