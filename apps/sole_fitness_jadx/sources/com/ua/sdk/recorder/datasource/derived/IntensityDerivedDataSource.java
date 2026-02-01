package com.ua.sdk.recorder.datasource.derived;

import com.ua.sdk.IntensityCalculator;
import com.ua.sdk.datapoint.BaseDataTypes;
import com.ua.sdk.datapoint.DataPoint;
import com.ua.sdk.datapoint.DataPointImpl;
import com.ua.sdk.datapoint.DataTypeRef;
import com.ua.sdk.datasourceidentifier.DataSourceIdentifier;
import com.ua.sdk.internal.IntensityCalculatorImpl;
import com.ua.sdk.recorder.RecorderCalculator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public class IntensityDerivedDataSource extends DerivedDataSource {
    private List<DataTypeRef> dataTypeRefTriggers;
    private IntensityCalculator intensityCalculator;

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

    protected IntensityDerivedDataSource(DataSourceIdentifier dataSourceIdentifier, List<DataTypeRef> list) {
        super(dataSourceIdentifier, list);
        this.intensityCalculator = new IntensityCalculatorImpl();
        this.dataTypeRefTriggers = new ArrayList(Arrays.asList(BaseDataTypes.TYPE_HEART_RATE.getRef()));
    }

    @Override // com.ua.sdk.recorder.datasource.derived.DerivedDataSource
    public void deriveDataPoint(RecorderCalculator recorderCalculator, DataSourceIdentifier dataSourceIdentifier, DataTypeRef dataTypeRef, DataPoint dataPoint) {
        if (this.dataTypeRefTriggers.contains(dataTypeRef)) {
            double dCalculateCurrentIntensity = this.intensityCalculator.calculateCurrentIntensity(this.recorderContext.getHeartRateZones(), dataPoint.getValueDouble(BaseDataTypes.FIELD_HEART_RATE).doubleValue());
            DataPointImpl dataPointImpl = new DataPointImpl();
            dataPointImpl.setValue(BaseDataTypes.FIELD_INTENSITY, Double.valueOf(dCalculateCurrentIntensity));
            dataPointImpl.setDatetime(dataPoint.getDatetime());
            recorderCalculator.updateDataPoint(this.dataSourceIdentifier, dataPointImpl, BaseDataTypes.TYPE_INTENSITY.getRef());
        }
    }

    @Override // com.ua.sdk.recorder.datasource.derived.DerivedDataSource
    public List<DataTypeRef> getDataTypeRefTriggers() {
        return this.dataTypeRefTriggers;
    }
}
