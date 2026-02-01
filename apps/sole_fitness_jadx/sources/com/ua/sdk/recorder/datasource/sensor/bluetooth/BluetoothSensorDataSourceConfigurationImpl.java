package com.ua.sdk.recorder.datasource.sensor.bluetooth;

import com.google.gson.annotations.SerializedName;
import com.ua.sdk.datasourceidentifier.DataSourceIdentifier;
import com.ua.sdk.recorder.BluetoothSensorDataSourceConfiguration;
import com.ua.sdk.recorder.data.BluetoothServiceType;
import com.ua.sdk.recorder.datasource.AbstractDataSourceConfiguration;
import com.ua.sdk.recorder.datasource.DataSource;
import com.ua.sdk.recorder.datasource.sensor.SensorDataSource;
import com.ua.sdk.recorder.producer.SensorMessageProducer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes2.dex */
public class BluetoothSensorDataSourceConfigurationImpl extends AbstractDataSourceConfiguration implements BluetoothSensorDataSourceConfiguration {

    @SerializedName("device_address")
    public String deviceAddress;

    @SerializedName("profile_type")
    public Set<BluetoothServiceType> serviceTypes;

    @Override // com.ua.sdk.recorder.BluetoothSensorDataSourceConfiguration
    public BluetoothSensorDataSourceConfiguration addProfileTypes(BluetoothServiceType... bluetoothServiceTypeArr) {
        if (this.serviceTypes == null) {
            this.serviceTypes = new HashSet();
        }
        this.serviceTypes.addAll(Arrays.asList(bluetoothServiceTypeArr));
        return this;
    }

    @Override // com.ua.sdk.recorder.BluetoothSensorDataSourceConfiguration
    public BluetoothSensorDataSourceConfiguration setDeviceAddress(String str) {
        this.deviceAddress = str;
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ua.sdk.recorder.DataSourceConfiguration
    public BluetoothSensorDataSourceConfiguration setDataSourceIdentifier(DataSourceIdentifier dataSourceIdentifier) {
        this.dataSourceIdentifier = dataSourceIdentifier;
        return this;
    }

    @Override // com.ua.sdk.recorder.datasource.AbstractDataSourceConfiguration
    public DataSource build(SensorMessageProducer sensorMessageProducer, SensorDataSource.SensorDataSourceListener sensorDataSourceListener) {
        Set<BluetoothServiceType> set = this.serviceTypes;
        if (set == null) {
            throw new IllegalArgumentException("Must specify at least one bluetooth service type");
        }
        if (this.deviceAddress == null) {
            throw new IllegalArgumentException("Must specify a valid device address");
        }
        BluetoothClient bluetoothClientBuild = new BluetoothClientBuilder(set).build();
        ArrayList arrayList = new ArrayList();
        Iterator<BluetoothServiceType> it = this.serviceTypes.iterator();
        while (it.hasNext()) {
            arrayList.addAll(BluetoothDataTypeRefMapper.getDataTypeRefFromService(it.next()));
        }
        return new BluetoothSensorDataSource(this.dataSourceIdentifier, arrayList, sensorMessageProducer, bluetoothClientBuild, this.deviceAddress, sensorDataSourceListener);
    }
}
