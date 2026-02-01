package com.ua.sdk.recorder.datasource.derived;

import com.ua.sdk.datapoint.BaseDataTypes;
import com.ua.sdk.datapoint.DataPoint;
import com.ua.sdk.datapoint.DataPointImpl;
import com.ua.sdk.datapoint.DataTypeRef;
import com.ua.sdk.datasourceidentifier.DataSourceIdentifier;
import com.ua.sdk.recorder.RecorderCalculator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public class DistanceDerivedDataSource extends DerivedDataSource {
    private List<DataTypeRef> dataTypeRefTriggers;
    private boolean isStarted;
    private DataPoint previousDataPoint;
    private DataPoint previousDistanceDataPoint;

    @Override // com.ua.sdk.recorder.datasource.DataSource
    public void connectDataSource() {
    }

    @Override // com.ua.sdk.recorder.datasource.DataSource
    public void disconnectDataSource() {
    }

    public DistanceDerivedDataSource(DataSourceIdentifier dataSourceIdentifier, List<DataTypeRef> list) {
        super(dataSourceIdentifier, list);
        this.dataTypeRefTriggers = new ArrayList(Arrays.asList(BaseDataTypes.TYPE_LOCATION.getRef()));
    }

    @Override // com.ua.sdk.recorder.datasource.derived.DerivedDataSource
    public void deriveDataPoint(RecorderCalculator recorderCalculator, DataSourceIdentifier dataSourceIdentifier, DataTypeRef dataTypeRef, DataPoint dataPoint) {
        if (this.dataTypeRefTriggers.contains(dataTypeRef) && this.isStarted) {
            DataPoint dataPoint2 = this.previousDataPoint;
            if (dataPoint2 != null) {
                DistanceBearingCalculator.calculateDistanceAndBearing(dataPoint2.getValueDouble(BaseDataTypes.FIELD_LATITUDE).doubleValue(), this.previousDataPoint.getValueDouble(BaseDataTypes.FIELD_LONGITUDE).doubleValue(), dataPoint.getValueDouble(BaseDataTypes.FIELD_LATITUDE).doubleValue(), dataPoint.getValueDouble(BaseDataTypes.FIELD_LONGITUDE).doubleValue(), new float[2]);
                DataPoint dataPoint3 = this.previousDistanceDataPoint;
                double dDoubleValue = (dataPoint3 == null ? 0.0d : dataPoint3.getValueDouble(BaseDataTypes.FIELD_DISTANCE).doubleValue()) + r12[0];
                DataPointImpl dataPointImpl = new DataPointImpl();
                dataPointImpl.setDatetime(dataPoint.getDatetime());
                dataPointImpl.setValue(BaseDataTypes.FIELD_DISTANCE, Double.valueOf(dDoubleValue));
                recorderCalculator.updateDataPoint(this.dataSourceIdentifier, dataPointImpl, BaseDataTypes.TYPE_DISTANCE.getRef());
                this.previousDistanceDataPoint = dataPointImpl;
            }
            this.previousDataPoint = dataPoint;
        }
    }

    @Override // com.ua.sdk.recorder.datasource.derived.DerivedDataSource
    public List<DataTypeRef> getDataTypeRefTriggers() {
        return this.dataTypeRefTriggers;
    }

    @Override // com.ua.sdk.recorder.datasource.DataSource
    public void startSegment() {
        this.isStarted = true;
    }

    @Override // com.ua.sdk.recorder.datasource.DataSource
    public void stopSegment() {
        this.isStarted = false;
    }
}
