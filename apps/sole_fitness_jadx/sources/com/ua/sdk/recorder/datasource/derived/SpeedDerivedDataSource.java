package com.ua.sdk.recorder.datasource.derived;

import com.ua.sdk.datapoint.BaseDataTypes;
import com.ua.sdk.datapoint.DataPoint;
import com.ua.sdk.datapoint.DataPointImpl;
import com.ua.sdk.datapoint.DataTypeRef;
import com.ua.sdk.datasourceidentifier.DataSourceIdentifier;
import com.ua.sdk.recorder.RecorderCalculator;
import com.ua.sdk.recorder.datasource.RollingAverage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public class SpeedDerivedDataSource extends DerivedDataSource {
    private static final int ROLLING_AVG_SIZE = 8;
    private List<DataTypeRef> dataTypeRefTriggers;
    private DataPoint previousDataPoint;
    private Double previousDistance;
    private RollingAverage<Double> rollingAverage;

    @Override // com.ua.sdk.recorder.datasource.DataSource
    public void connectDataSource() {
    }

    @Override // com.ua.sdk.recorder.datasource.DataSource
    public void disconnectDataSource() {
    }

    @Override // com.ua.sdk.recorder.datasource.DataSource
    public void startSegment() {
    }

    @Override // com.ua.sdk.recorder.datasource.DataSource
    public void stopSegment() {
    }

    public SpeedDerivedDataSource(DataSourceIdentifier dataSourceIdentifier, List<DataTypeRef> list) {
        super(dataSourceIdentifier, list);
        this.dataTypeRefTriggers = new ArrayList(Arrays.asList(BaseDataTypes.TYPE_LOCATION.getRef()));
        this.rollingAverage = new RollingAverage<>(8);
    }

    @Override // com.ua.sdk.recorder.datasource.derived.DerivedDataSource
    public void deriveDataPoint(RecorderCalculator recorderCalculator, DataSourceIdentifier dataSourceIdentifier, DataTypeRef dataTypeRef, DataPoint dataPoint) {
        if (this.dataTypeRefTriggers.contains(dataTypeRef)) {
            DataPoint dataPoint2 = this.previousDataPoint;
            if (dataPoint2 != null) {
                DistanceBearingCalculator.calculateDistanceAndBearing(dataPoint2.getValueDouble(BaseDataTypes.FIELD_LATITUDE).doubleValue(), this.previousDataPoint.getValueDouble(BaseDataTypes.FIELD_LONGITUDE).doubleValue(), dataPoint.getValueDouble(BaseDataTypes.FIELD_LATITUDE).doubleValue(), dataPoint.getValueDouble(BaseDataTypes.FIELD_LONGITUDE).doubleValue(), new float[2]);
                Double d = this.previousDistance;
                double dDoubleValue = d == null ? 0.0d : d.doubleValue();
                double d2 = r12[0] + dDoubleValue;
                double time = (d2 - dDoubleValue) / ((dataPoint.getDatetime().getTime() - this.previousDataPoint.getDatetime().getTime()) / 1000);
                if (time < 50.0d && !Double.isInfinite(time) && !Double.isNaN(time)) {
                    this.rollingAverage.addValue(Double.valueOf(time));
                    double average = this.rollingAverage.getAverage();
                    DataPointImpl dataPointImpl = new DataPointImpl();
                    dataPointImpl.setDatetime(dataPoint.getDatetime());
                    dataPointImpl.setValue(BaseDataTypes.FIELD_SPEED, Double.valueOf(average));
                    recorderCalculator.updateDataPoint(this.dataSourceIdentifier, dataPointImpl, BaseDataTypes.TYPE_SPEED.getRef());
                }
                this.previousDistance = Double.valueOf(d2);
            }
            this.previousDataPoint = dataPoint;
        }
    }

    @Override // com.ua.sdk.recorder.datasource.derived.DerivedDataSource
    public List<DataTypeRef> getDataTypeRefTriggers() {
        return this.dataTypeRefTriggers;
    }
}
