package com.ua.sdk.recorder.datasource.sensor.location;

import com.google.gson.annotations.SerializedName;
import com.ua.sdk.datapoint.BaseDataTypes;
import com.ua.sdk.datasourceidentifier.DataSourceIdentifier;
import com.ua.sdk.recorder.LocationSensorDataSourceConfiguration;
import com.ua.sdk.recorder.datasource.AbstractDataSourceConfiguration;
import com.ua.sdk.recorder.datasource.DataSource;
import com.ua.sdk.recorder.datasource.sensor.SensorDataSource;
import com.ua.sdk.recorder.producer.SensorMessageProducer;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class LocationSensorSensorDataSourceConfigurationImpl extends AbstractDataSourceConfiguration implements LocationSensorDataSourceConfiguration {

    @SerializedName("elevation_priority")
    public int elevationPriority;

    @SerializedName("location_priority")
    public int locationPriority;

    @Override // com.ua.sdk.recorder.LocationSensorDataSourceConfiguration
    public LocationSensorDataSourceConfiguration setLocationPriority(int i) {
        this.locationPriority = i;
        return this;
    }

    @Override // com.ua.sdk.recorder.LocationSensorDataSourceConfiguration
    public LocationSensorDataSourceConfiguration setElevationPriority(int i) {
        this.elevationPriority = i;
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ua.sdk.recorder.DataSourceConfiguration
    public LocationSensorDataSourceConfiguration setDataSourceIdentifier(DataSourceIdentifier dataSourceIdentifier) {
        this.dataSourceIdentifier = dataSourceIdentifier;
        return this;
    }

    @Override // com.ua.sdk.recorder.datasource.AbstractDataSourceConfiguration
    public DataSource build(SensorMessageProducer sensorMessageProducer, SensorDataSource.SensorDataSourceListener sensorDataSourceListener) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(BaseDataTypes.TYPE_LOCATION.getRef());
        arrayList.add(BaseDataTypes.TYPE_ELEVATION.getRef());
        return new LocationSensorDataSource(this.dataSourceIdentifier, arrayList, sensorMessageProducer, sensorDataSourceListener);
    }
}
