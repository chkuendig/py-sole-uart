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
public class BearingDerivedDataSource extends DerivedDataSource {
    private List<DataTypeRef> dataTypeRefTriggers;
    private DataPoint previousDataPoint;

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

    protected BearingDerivedDataSource(DataSourceIdentifier dataSourceIdentifier, List<DataTypeRef> list) {
        super(dataSourceIdentifier, list);
        this.dataTypeRefTriggers = new ArrayList(Arrays.asList(BaseDataTypes.TYPE_LOCATION.getRef()));
    }

    @Override // com.ua.sdk.recorder.datasource.derived.DerivedDataSource
    public void deriveDataPoint(RecorderCalculator recorderCalculator, DataSourceIdentifier dataSourceIdentifier, DataTypeRef dataTypeRef, DataPoint dataPoint) {
        if (this.dataTypeRefTriggers.contains(dataTypeRef)) {
            DataPoint dataPoint2 = this.previousDataPoint;
            if (dataPoint2 != null) {
                DistanceBearingCalculator.calculateDistanceAndBearing(dataPoint2.getValueDouble(BaseDataTypes.FIELD_LATITUDE).doubleValue(), this.previousDataPoint.getValueDouble(BaseDataTypes.FIELD_LONGITUDE).doubleValue(), dataPoint.getValueDouble(BaseDataTypes.FIELD_LATITUDE).doubleValue(), dataPoint.getValueDouble(BaseDataTypes.FIELD_LONGITUDE).doubleValue(), new float[2]);
                DataPointImpl dataPointImpl = new DataPointImpl();
                dataPointImpl.setValue(BaseDataTypes.FIELD_BEARING, Double.valueOf(r12[1]));
                dataPointImpl.setDatetime(dataPoint.getDatetime());
                recorderCalculator.updateDataPoint(this.dataSourceIdentifier, dataPointImpl, BaseDataTypes.TYPE_BEARING.getRef());
            }
            this.previousDataPoint = dataPoint;
        }
    }

    @Override // com.ua.sdk.recorder.datasource.derived.DerivedDataSource
    public List<DataTypeRef> getDataTypeRefTriggers() {
        return this.dataTypeRefTriggers;
    }
}
