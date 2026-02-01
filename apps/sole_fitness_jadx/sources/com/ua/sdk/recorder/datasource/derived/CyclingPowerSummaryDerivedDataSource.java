package com.ua.sdk.recorder.datasource.derived;

import com.ua.sdk.datapoint.BaseDataTypes;
import com.ua.sdk.datapoint.DataField;
import com.ua.sdk.datapoint.DataPoint;
import com.ua.sdk.datapoint.DataPointImpl;
import com.ua.sdk.datapoint.DataTypeRef;
import com.ua.sdk.datasourceidentifier.DataSourceIdentifier;
import com.ua.sdk.recorder.RecorderCalculator;
import com.ua.sdk.recorder.datasource.Average;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public class CyclingPowerSummaryDerivedDataSource extends DerivedDataSource {
    private Average<Double> average;
    private List<DataTypeRef> dataTypeRefTriggers;
    private boolean recordData;
    private DataPointImpl summaryDataPoint;

    @Override // com.ua.sdk.recorder.datasource.DataSource
    public void connectDataSource() {
    }

    protected CyclingPowerSummaryDerivedDataSource(DataSourceIdentifier dataSourceIdentifier, List<DataTypeRef> list) {
        super(dataSourceIdentifier, list);
        this.dataTypeRefTriggers = new ArrayList(Arrays.asList(BaseDataTypes.TYPE_CYCLING_POWER.getRef()));
        this.average = new Average<>();
        this.recordData = false;
    }

    @Override // com.ua.sdk.recorder.datasource.derived.DerivedDataSource
    public void deriveDataPoint(RecorderCalculator recorderCalculator, DataSourceIdentifier dataSourceIdentifier, DataTypeRef dataTypeRef, DataPoint dataPoint) {
        if (this.dataTypeRefTriggers.contains(dataTypeRef) && this.recordData) {
            if (this.summaryDataPoint == null) {
                DataPointImpl dataPointImpl = new DataPointImpl();
                this.summaryDataPoint = dataPointImpl;
                dataPointImpl.setStartDatetime(dataPoint.getDatetime());
            }
            this.summaryDataPoint.setDatetime(dataPoint.getDatetime());
            DataField dataField = BaseDataTypes.FIELD_CYCLING_POWER_MAX;
            DataField dataField2 = BaseDataTypes.FIELD_CYCLING_POWER_MIN;
            DataField dataField3 = BaseDataTypes.FIELD_CYCLING_POWER_AVG;
            Double valueDouble = dataPoint.getValueDouble(BaseDataTypes.FIELD_CYCLING_POWER);
            Double valueDouble2 = this.summaryDataPoint.getValueDouble(dataField);
            Double valueDouble3 = this.summaryDataPoint.getValueDouble(dataField2);
            if (valueDouble2 == null || valueDouble.doubleValue() > valueDouble2.doubleValue()) {
                this.summaryDataPoint.setValue(dataField, valueDouble);
            }
            if (valueDouble3 == null || valueDouble.doubleValue() < valueDouble3.doubleValue()) {
                this.summaryDataPoint.setValue(dataField2, valueDouble);
            }
            this.average.addValue(valueDouble);
            this.summaryDataPoint.setValue(dataField3, Double.valueOf(this.average.getAverage()));
            recorderCalculator.updateDataPoint(this.dataSourceIdentifier, this.summaryDataPoint, BaseDataTypes.TYPE_CYCLING_POWER_SUMMARY.getRef());
        }
    }

    @Override // com.ua.sdk.recorder.datasource.derived.DerivedDataSource
    public List<DataTypeRef> getDataTypeRefTriggers() {
        return this.dataTypeRefTriggers;
    }

    @Override // com.ua.sdk.recorder.datasource.DataSource
    public void disconnectDataSource() {
        this.average.reset();
    }

    @Override // com.ua.sdk.recorder.datasource.DataSource
    public void startSegment() {
        this.recordData = true;
    }

    @Override // com.ua.sdk.recorder.datasource.DataSource
    public void stopSegment() {
        this.recordData = false;
    }
}
