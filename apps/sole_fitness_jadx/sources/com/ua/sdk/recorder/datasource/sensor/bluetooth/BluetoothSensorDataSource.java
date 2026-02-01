package com.ua.sdk.recorder.datasource.sensor.bluetooth;

import com.ua.sdk.Convert;
import com.ua.sdk.datapoint.BaseDataTypes;
import com.ua.sdk.datapoint.DataPointImpl;
import com.ua.sdk.datapoint.DataTypeRef;
import com.ua.sdk.datasourceidentifier.DataSourceIdentifier;
import com.ua.sdk.recorder.RecorderContext;
import com.ua.sdk.recorder.SensorHealth;
import com.ua.sdk.recorder.SensorStatus;
import com.ua.sdk.recorder.datasource.sensor.SensorDataSource;
import com.ua.sdk.recorder.datasource.sensor.bluetooth.BluetoothClient;
import com.ua.sdk.recorder.producer.SensorMessageProducer;
import java.util.Date;
import java.util.List;

/* loaded from: classes2.dex */
public class BluetoothSensorDataSource extends SensorDataSource {
    private BluetoothClient bluetoothClient;
    private String deviceAddress;
    private BluetoothDeviceHealth deviceHealth;
    private MyBluetoothClientListener myBluetoothClientListener;

    public BluetoothSensorDataSource(DataSourceIdentifier dataSourceIdentifier, List<DataTypeRef> list, SensorMessageProducer sensorMessageProducer, BluetoothClient bluetoothClient, String str, SensorDataSource.SensorDataSourceListener sensorDataSourceListener) {
        super(dataSourceIdentifier, list, sensorMessageProducer, sensorDataSourceListener);
        this.deviceHealth = new BluetoothDeviceHealth();
        this.myBluetoothClientListener = new MyBluetoothClientListener();
        this.bluetoothClient = bluetoothClient;
        this.deviceAddress = str;
    }

    @Override // com.ua.sdk.recorder.datasource.DataSource
    public void configure(RecorderContext recorderContext) {
        super.configure(recorderContext);
        BluetoothClient bluetoothClient = this.bluetoothClient;
        if (bluetoothClient != null) {
            bluetoothClient.configure(recorderContext);
        }
    }

    @Override // com.ua.sdk.recorder.datasource.DataSource
    public void connectDataSource() {
        BluetoothClient bluetoothClient = this.bluetoothClient;
        if (bluetoothClient != null) {
            bluetoothClient.connect(this.myBluetoothClientListener, this.deviceAddress, this.recorderContext.getApplicationContext());
        }
    }

    @Override // com.ua.sdk.recorder.datasource.DataSource
    public void disconnectDataSource() {
        BluetoothClient bluetoothClient = this.bluetoothClient;
        if (bluetoothClient != null) {
            bluetoothClient.disconnect();
        }
    }

    @Override // com.ua.sdk.recorder.datasource.DataSource
    public void startSegment() {
        BluetoothClient bluetoothClient = this.bluetoothClient;
        if (bluetoothClient != null) {
            bluetoothClient.startSegment();
        }
    }

    @Override // com.ua.sdk.recorder.datasource.DataSource
    public void stopSegment() {
        BluetoothClient bluetoothClient = this.bluetoothClient;
        if (bluetoothClient != null) {
            bluetoothClient.stopSegment();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkUpdateHealth() {
        SensorHealth sensorHealthCalculateOverallHealth = this.deviceHealth.calculateOverallHealth();
        if (sensorHealthCalculateOverallHealth != this.sensorHealth) {
            this.sensorHealth = sensorHealthCalculateOverallHealth;
            if (this.sensorDataSourceListener != null) {
                this.sensorDataSourceListener.onSensorStateChanged(this.dataSourceIdentifier, this.sensorStatus, this.sensorHealth);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkUpdateStatus(SensorStatus sensorStatus) {
        if (sensorStatus != this.sensorStatus) {
            this.sensorStatus = sensorStatus;
            if (sensorStatus == SensorStatus.DISCONNECTED) {
                this.sensorHealth = SensorHealth.UNKNOWN;
            }
            if (this.sensorDataSourceListener != null) {
                this.sensorDataSourceListener.onSensorStateChanged(this.dataSourceIdentifier, this.sensorStatus, this.sensorHealth);
            }
        }
    }

    protected class MyBluetoothClientListener implements BluetoothClient.BluetoothClientListener {
        protected MyBluetoothClientListener() {
        }

        @Override // com.ua.sdk.recorder.datasource.sensor.bluetooth.BluetoothClient.BluetoothClientListener
        public void onConnectionStatusChanged(SensorStatus sensorStatus) {
            BluetoothSensorDataSource.this.checkUpdateStatus(sensorStatus);
        }

        @Override // com.ua.sdk.recorder.datasource.sensor.bluetooth.BluetoothClient.BluetoothClientListener
        public void onBatteryLevelMeasurement(long j) {
            BluetoothSensorDataSource.this.deviceHealth.setBatteryRemaining((int) j);
            BluetoothSensorDataSource.this.checkUpdateHealth();
        }

        @Override // com.ua.sdk.recorder.datasource.sensor.bluetooth.BluetoothClient.BluetoothClientListener
        public void onRssiMeasurement(long j) {
            BluetoothSensorDataSource.this.deviceHealth.setRssi((int) j);
            BluetoothSensorDataSource.this.checkUpdateHealth();
        }

        @Override // com.ua.sdk.recorder.datasource.sensor.bluetooth.BluetoothClient.BluetoothClientListener
        public void onHeartRateMeasurement(long j, long j2) {
            long timestamp = ((long) BluetoothSensorDataSource.this.clock.getTimestamp()) * 1000;
            DataPointImpl dataPointImpl = new DataPointImpl();
            dataPointImpl.setValue(BaseDataTypes.FIELD_HEART_RATE, Long.valueOf(j));
            dataPointImpl.setDatetime(new Date(timestamp));
            BluetoothSensorDataSource.this.sendData(dataPointImpl, BaseDataTypes.TYPE_HEART_RATE.getRef(), BluetoothSensorDataSource.this.dataSourceIdentifier);
            if (j2 != -1) {
                DataPointImpl dataPointImpl2 = new DataPointImpl();
                dataPointImpl2.setValue(BaseDataTypes.FIELD_ENERGY_EXPENDED, Long.valueOf(j2));
                dataPointImpl.setDatetime(new Date(timestamp));
                BluetoothSensorDataSource.this.sendData(dataPointImpl2, BaseDataTypes.TYPE_ENERGY_EXPENDED.getRef(), BluetoothSensorDataSource.this.dataSourceIdentifier);
            }
        }

        @Override // com.ua.sdk.recorder.datasource.sensor.bluetooth.BluetoothClient.BluetoothClientListener
        public void onRscMeasurement(double d, long j, double d2, double d3, boolean z) {
            long timestamp = ((long) BluetoothSensorDataSource.this.clock.getTimestamp()) * 1000;
            DataPointImpl dataPointImpl = new DataPointImpl();
            dataPointImpl.setValue(BaseDataTypes.FIELD_SPEED, Double.valueOf(d));
            dataPointImpl.setDatetime(new Date(timestamp));
            BluetoothSensorDataSource.this.sendData(dataPointImpl, BaseDataTypes.TYPE_SPEED.getRef(), BluetoothSensorDataSource.this.dataSourceIdentifier);
            DataPointImpl dataPointImpl2 = new DataPointImpl();
            dataPointImpl2.setDatetime(new Date(timestamp));
            dataPointImpl2.setValue(BaseDataTypes.FIELD_RUN_CADENCE, Long.valueOf(j));
            BluetoothSensorDataSource.this.sendData(dataPointImpl2, BaseDataTypes.TYPE_RUN_CADENCE.getRef(), BluetoothSensorDataSource.this.dataSourceIdentifier);
            if (d2 != -1.0d) {
                DataPointImpl dataPointImpl3 = new DataPointImpl();
                dataPointImpl3.setDatetime(new Date(timestamp));
                dataPointImpl3.setValue(BaseDataTypes.FIELD_STRIDE_LENGTH, Double.valueOf(d2));
                BluetoothSensorDataSource.this.sendData(dataPointImpl3, BaseDataTypes.TYPE_STRIDE_LENGTH.getRef(), BluetoothSensorDataSource.this.dataSourceIdentifier);
            }
            if (d3 != -1.0d) {
                DataPointImpl dataPointImpl4 = new DataPointImpl();
                dataPointImpl4.setDatetime(new Date(timestamp));
                dataPointImpl4.setValue(BaseDataTypes.FIELD_DISTANCE, Double.valueOf(d3));
                BluetoothSensorDataSource.this.sendData(dataPointImpl4, BaseDataTypes.TYPE_DISTANCE.getRef(), BluetoothSensorDataSource.this.dataSourceIdentifier);
            }
        }

        @Override // com.ua.sdk.recorder.datasource.sensor.bluetooth.BluetoothClient.BluetoothClientListener
        public void onCyclingPowerMeasurement(long j, double d, double d2, long j2, long j3, long j4, long j5, double d3, double d4, long j6, long j7, long j8, long j9, long j10) {
            long timestamp = ((long) BluetoothSensorDataSource.this.clock.getTimestamp()) * 1000;
            DataPointImpl dataPointImpl = new DataPointImpl();
            dataPointImpl.setDatetime(new Date(timestamp));
            dataPointImpl.setValue(BaseDataTypes.FIELD_CYCLING_POWER, Long.valueOf(j));
            BluetoothSensorDataSource.this.sendData(dataPointImpl, BaseDataTypes.TYPE_CYCLING_POWER.getRef(), BluetoothSensorDataSource.this.dataSourceIdentifier);
            if (d != -1.0d) {
                DataPointImpl dataPointImpl2 = new DataPointImpl();
                dataPointImpl2.setDatetime(new Date(timestamp));
                dataPointImpl2.setValue(BaseDataTypes.FIELD_CYCLING_POWER_BALANCE, Double.valueOf(d));
                BluetoothSensorDataSource.this.sendData(dataPointImpl2, BaseDataTypes.TYPE_CYCLING_POWER_BALANCE.getRef(), BluetoothSensorDataSource.this.dataSourceIdentifier);
            }
            if (d2 != -1.0d) {
                DataPointImpl dataPointImpl3 = new DataPointImpl();
                dataPointImpl3.setDatetime(new Date(timestamp));
                dataPointImpl3.setValue(BaseDataTypes.FIELD_ACCUMULATED_TORQUE, Double.valueOf(d2));
                BluetoothSensorDataSource.this.sendData(dataPointImpl3, BaseDataTypes.TYPE_ACCUMULATED_TORQUE.getRef(), BluetoothSensorDataSource.this.dataSourceIdentifier);
            }
            if (j2 != -1) {
                DataPointImpl dataPointImpl4 = new DataPointImpl();
                dataPointImpl4.setDatetime(new Date(timestamp));
                dataPointImpl4.setValue(BaseDataTypes.FIELD_WHEEL_REVOLUTIONS, Long.valueOf(j2));
                BluetoothSensorDataSource.this.sendData(dataPointImpl4, BaseDataTypes.TYPE_WHEEL_REVOLUTIONS.getRef(), BluetoothSensorDataSource.this.dataSourceIdentifier);
            }
            if (j3 != -1) {
                DataPointImpl dataPointImpl5 = new DataPointImpl();
                dataPointImpl5.setDatetime(new Date(timestamp));
                dataPointImpl5.setValue(BaseDataTypes.FIELD_CRANK_REVOLUTIONS, Long.valueOf(j3));
                BluetoothSensorDataSource.this.sendData(dataPointImpl5, BaseDataTypes.TYPE_CRANK_REVOLUTIONS.getRef(), BluetoothSensorDataSource.this.dataSourceIdentifier);
            }
            if (j4 != -1 || j5 != -1) {
                DataPointImpl dataPointImpl6 = new DataPointImpl();
                dataPointImpl6.setDatetime(new Date(timestamp));
                dataPointImpl6.setValue(BaseDataTypes.FIELD_MAX_FORCE, Long.valueOf(j4));
                dataPointImpl6.setValue(BaseDataTypes.FIELD_MIN_FORCE, Long.valueOf(j5));
                BluetoothSensorDataSource.this.sendData(dataPointImpl6, BaseDataTypes.TYPE_EXTREME_FORCES.getRef(), BluetoothSensorDataSource.this.dataSourceIdentifier);
            }
            if (d3 != -1.0d || d4 != -1.0d) {
                DataPointImpl dataPointImpl7 = new DataPointImpl();
                dataPointImpl7.setDatetime(new Date(timestamp));
                dataPointImpl7.setValue(BaseDataTypes.FIELD_MAX_TORQUE, Double.valueOf(d3));
                dataPointImpl7.setValue(BaseDataTypes.FIELD_MIN_TORQUE, Double.valueOf(d4));
                BluetoothSensorDataSource.this.sendData(dataPointImpl7, BaseDataTypes.TYPE_EXTREME_TORQUE.getRef(), BluetoothSensorDataSource.this.dataSourceIdentifier);
            }
            if (j6 != -1 || j7 != -1) {
                DataPointImpl dataPointImpl8 = new DataPointImpl();
                dataPointImpl8.setDatetime(new Date(timestamp));
                dataPointImpl8.setValue(BaseDataTypes.FIELD_MAX_ANGLE, Long.valueOf(j6));
                dataPointImpl8.setValue(BaseDataTypes.FIELD_MIN_ANGLE, Long.valueOf(j7));
                BluetoothSensorDataSource.this.sendData(dataPointImpl8, BaseDataTypes.TYPE_EXTREME_ANGLES.getRef(), BluetoothSensorDataSource.this.dataSourceIdentifier);
            }
            if (j8 != -1) {
                DataPointImpl dataPointImpl9 = new DataPointImpl();
                dataPointImpl9.setDatetime(new Date(timestamp));
                dataPointImpl9.setValue(BaseDataTypes.FIELD_TOP_DEAD_SPOT_ANGLE, Long.valueOf(j8));
                BluetoothSensorDataSource.this.sendData(dataPointImpl9, BaseDataTypes.TYPE_TOP_DEAD_SPOT_ANGLE.getRef(), BluetoothSensorDataSource.this.dataSourceIdentifier);
            }
            if (j9 != -1) {
                DataPointImpl dataPointImpl10 = new DataPointImpl();
                dataPointImpl10.setDatetime(new Date(timestamp));
                dataPointImpl10.setValue(BaseDataTypes.FIELD_BOTTOM_DEAD_SPOT_ANGLE, Long.valueOf(j9));
                BluetoothSensorDataSource.this.sendData(dataPointImpl10, BaseDataTypes.TYPE_BOTTOM_DEAD_SPOT_ANGLE.getRef(), BluetoothSensorDataSource.this.dataSourceIdentifier);
            }
            if (j10 != -1) {
                DataPointImpl dataPointImpl11 = new DataPointImpl();
                dataPointImpl11.setDatetime(new Date(timestamp));
                dataPointImpl11.setValue(BaseDataTypes.FIELD_ENERGY_EXPENDED, Long.valueOf(j10));
                BluetoothSensorDataSource.this.sendData(dataPointImpl11, BaseDataTypes.TYPE_ENERGY_EXPENDED.getRef(), BluetoothSensorDataSource.this.dataSourceIdentifier);
            }
        }

        @Override // com.ua.sdk.recorder.datasource.sensor.bluetooth.BluetoothClient.BluetoothClientListener
        public void onCSCMeasurement(long j, long j2) {
            long timestamp = ((long) BluetoothSensorDataSource.this.clock.getTimestamp()) * 1000;
            if (j != -1) {
                DataPointImpl dataPointImpl = new DataPointImpl();
                dataPointImpl.setDatetime(new Date(timestamp));
                dataPointImpl.setValue(BaseDataTypes.FIELD_WHEEL_REVOLUTIONS, Long.valueOf(j));
                BluetoothSensorDataSource.this.sendData(dataPointImpl, BaseDataTypes.TYPE_WHEEL_REVOLUTIONS.getRef(), BluetoothSensorDataSource.this.dataSourceIdentifier);
            }
            if (j2 != -1) {
                DataPointImpl dataPointImpl2 = new DataPointImpl();
                dataPointImpl2.setDatetime(new Date(timestamp));
                dataPointImpl2.setValue(BaseDataTypes.FIELD_CRANK_REVOLUTIONS, Long.valueOf(j2));
                BluetoothSensorDataSource.this.sendData(dataPointImpl2, BaseDataTypes.TYPE_CRANK_REVOLUTIONS.getRef(), BluetoothSensorDataSource.this.dataSourceIdentifier);
            }
        }

        @Override // com.ua.sdk.recorder.datasource.sensor.bluetooth.BluetoothClient.BluetoothClientListener
        public void onArmour39Measurement(long j, long j2, double d, long j3, long j4) {
            long timestamp = ((long) BluetoothSensorDataSource.this.clock.getTimestamp()) * 1000;
            DataPointImpl dataPointImpl = new DataPointImpl();
            dataPointImpl.setDatetime(new Date(timestamp));
            dataPointImpl.setValue(BaseDataTypes.FIELD_STEPS, Long.valueOf(j));
            BluetoothSensorDataSource.this.sendData(dataPointImpl, BaseDataTypes.TYPE_STEPS.getRef(), BluetoothSensorDataSource.this.dataSourceIdentifier);
            DataPointImpl dataPointImpl2 = new DataPointImpl();
            dataPointImpl2.setDatetime(new Date(timestamp));
            dataPointImpl2.setValue(BaseDataTypes.FIELD_ENERGY_EXPENDED, Convert.caloriesToJoules(Double.valueOf(j2)));
            BluetoothSensorDataSource.this.sendData(dataPointImpl2, BaseDataTypes.TYPE_ENERGY_EXPENDED.getRef(), BluetoothSensorDataSource.this.dataSourceIdentifier);
            DataPointImpl dataPointImpl3 = new DataPointImpl();
            dataPointImpl3.setDatetime(new Date(timestamp));
            dataPointImpl3.setValue(BaseDataTypes.FIELD_WILLPOWER, Double.valueOf(d));
            BluetoothSensorDataSource.this.sendData(dataPointImpl3, BaseDataTypes.TYPE_WILLPOWER.getRef(), BluetoothSensorDataSource.this.dataSourceIdentifier);
            DataPointImpl dataPointImpl4 = new DataPointImpl();
            dataPointImpl4.setDatetime(new Date(timestamp));
            dataPointImpl4.setValue(BaseDataTypes.FIELD_POSTURE, Long.valueOf(j3));
            BluetoothSensorDataSource.this.sendData(dataPointImpl4, BaseDataTypes.TYPE_POSTURE.getRef(), BluetoothSensorDataSource.this.dataSourceIdentifier);
            DataPointImpl dataPointImpl5 = new DataPointImpl();
            dataPointImpl5.setDatetime(new Date(timestamp));
            dataPointImpl5.setValue(BaseDataTypes.FIELD_RUN_CADENCE, Long.valueOf(j4));
            BluetoothSensorDataSource.this.sendData(dataPointImpl5, BaseDataTypes.TYPE_RUN_CADENCE.getRef(), BluetoothSensorDataSource.this.dataSourceIdentifier);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BluetoothSensorDataSource)) {
            return false;
        }
        String str = this.deviceAddress;
        String str2 = ((BluetoothSensorDataSource) obj).deviceAddress;
        return str == null ? str2 == null : str.equals(str2);
    }

    public int hashCode() {
        String str = this.deviceAddress;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }
}
