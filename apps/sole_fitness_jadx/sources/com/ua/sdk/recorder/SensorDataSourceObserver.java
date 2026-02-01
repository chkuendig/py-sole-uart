package com.ua.sdk.recorder;

import com.ua.sdk.datasourceidentifier.DataSourceIdentifier;

/* loaded from: classes2.dex */
public interface SensorDataSourceObserver {
    void onSensorDataSourceStatus(DataSourceIdentifier dataSourceIdentifier, SensorStatus sensorStatus, SensorHealth sensorHealth);
}
