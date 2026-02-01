package com.ua.sdk.recorder.datasource.sensor.location;

import android.location.Location;
import android.location.LocationManager;
import com.ua.sdk.datapoint.BaseDataTypes;
import com.ua.sdk.datapoint.DataPointImpl;
import com.ua.sdk.datapoint.DataTypeRef;
import com.ua.sdk.datasourceidentifier.DataSourceIdentifier;
import com.ua.sdk.recorder.RecorderContext;
import com.ua.sdk.recorder.SensorStatus;
import com.ua.sdk.recorder.datasource.sensor.SensorDataSource;
import com.ua.sdk.recorder.datasource.sensor.location.LocationClient;
import com.ua.sdk.recorder.producer.SensorMessageProducer;
import java.util.Date;
import java.util.List;

/* loaded from: classes2.dex */
public class LocationSensorDataSource extends SensorDataSource {
    private LocationDeviceHealth deviceHealth;
    private LocationClient locationClient;

    @Override // com.ua.sdk.recorder.datasource.DataSource
    public void startSegment() {
    }

    @Override // com.ua.sdk.recorder.datasource.DataSource
    public void stopSegment() {
    }

    public LocationSensorDataSource(DataSourceIdentifier dataSourceIdentifier, List<DataTypeRef> list, SensorMessageProducer sensorMessageProducer, SensorDataSource.SensorDataSourceListener sensorDataSourceListener) {
        super(dataSourceIdentifier, list, sensorMessageProducer, sensorDataSourceListener);
        this.deviceHealth = new LocationDeviceHealth();
    }

    @Override // com.ua.sdk.recorder.datasource.DataSource
    public void configure(RecorderContext recorderContext) {
        super.configure(recorderContext);
        this.locationClient = new AndroidLocationClient((LocationManager) recorderContext.getApplicationContext().getSystemService("location"));
    }

    @Override // com.ua.sdk.recorder.datasource.DataSource
    public void connectDataSource() {
        this.locationClient.connect(new MyLocationClientListener());
    }

    @Override // com.ua.sdk.recorder.datasource.DataSource
    public void disconnectDataSource() {
        this.locationClient.disconnect();
    }

    protected class MyLocationClientListener implements LocationClient.LocationClientListener {
        protected MyLocationClientListener() {
        }

        @Override // com.ua.sdk.recorder.datasource.sensor.location.LocationClient.LocationClientListener
        public void onLocation(Location location) {
            long timestamp = ((long) LocationSensorDataSource.this.clock.getTimestamp()) * 1000;
            DataPointImpl dataPointImpl = new DataPointImpl();
            dataPointImpl.setDatetime(new Date(timestamp));
            dataPointImpl.setValue(BaseDataTypes.FIELD_LATITUDE, Double.valueOf(location.getLatitude()));
            dataPointImpl.setValue(BaseDataTypes.FIELD_LONGITUDE, Double.valueOf(location.getLongitude()));
            dataPointImpl.setValue(BaseDataTypes.FIELD_HORIZONTAL_ACCURACY, Double.valueOf(location.getAccuracy()));
            LocationSensorDataSource.this.sendData(dataPointImpl, BaseDataTypes.TYPE_LOCATION.getRef(), LocationSensorDataSource.this.dataSourceIdentifier);
            DataPointImpl dataPointImpl2 = new DataPointImpl();
            dataPointImpl2.setDatetime(new Date(timestamp));
            dataPointImpl2.setValue(BaseDataTypes.FIELD_ELEVATION, Double.valueOf(location.getAltitude()));
            dataPointImpl2.setValue(BaseDataTypes.FIELD_VERTICAL_ACCURACY, Double.valueOf(location.getAccuracy()));
            LocationSensorDataSource.this.sendData(dataPointImpl2, BaseDataTypes.TYPE_ELEVATION.getRef(), LocationSensorDataSource.this.dataSourceIdentifier);
            DataPointImpl dataPointImpl3 = new DataPointImpl();
            dataPointImpl3.setDatetime(new Date(timestamp));
            dataPointImpl3.setValue(BaseDataTypes.FIELD_BEARING, Double.valueOf(location.getBearing()));
            LocationSensorDataSource.this.sendData(dataPointImpl3, BaseDataTypes.TYPE_BEARING.getRef(), LocationSensorDataSource.this.dataSourceIdentifier);
            LocationSensorDataSource.this.deviceHealth.setAccuracy(location.getAccuracy());
        }

        @Override // com.ua.sdk.recorder.datasource.sensor.location.LocationClient.LocationClientListener
        public void onStatus(boolean z, boolean z2, float f) {
            LocationSensorDataSource locationSensorDataSource = LocationSensorDataSource.this;
            locationSensorDataSource.sensorHealth = locationSensorDataSource.deviceHealth.calculateOverallHealth();
            if (!z) {
                LocationSensorDataSource.this.sensorStatus = SensorStatus.DISCONNECTED;
            } else if (z2) {
                LocationSensorDataSource.this.sensorStatus = SensorStatus.CONNECTED;
            } else {
                LocationSensorDataSource.this.sensorStatus = SensorStatus.CONNECTING;
            }
            if (LocationSensorDataSource.this.sensorDataSourceListener != null) {
                LocationSensorDataSource.this.sensorDataSourceListener.onSensorStateChanged(LocationSensorDataSource.this.dataSourceIdentifier, LocationSensorDataSource.this.sensorStatus, LocationSensorDataSource.this.sensorHealth);
            }
        }
    }
}
