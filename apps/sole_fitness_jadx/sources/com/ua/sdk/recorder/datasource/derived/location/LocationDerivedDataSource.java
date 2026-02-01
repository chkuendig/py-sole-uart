package com.ua.sdk.recorder.datasource.derived.location;

import com.ua.sdk.datapoint.BaseDataTypes;
import com.ua.sdk.datapoint.DataPoint;
import com.ua.sdk.datapoint.DataPointImpl;
import com.ua.sdk.datapoint.DataTypeRef;
import com.ua.sdk.datasourceidentifier.DataSourceIdentifier;
import com.ua.sdk.recorder.RecorderCalculator;
import com.ua.sdk.recorder.datasource.derived.DerivedDataSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public class LocationDerivedDataSource extends DerivedDataSource {
    private List<DataTypeRef> dataTypeRefTriggers;

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

    public LocationDerivedDataSource(DataSourceIdentifier dataSourceIdentifier, List<DataTypeRef> list) {
        super(dataSourceIdentifier, list);
        this.dataTypeRefTriggers = new ArrayList(Arrays.asList(BaseDataTypes.TYPE_LOCATION.getRef()));
    }

    @Override // com.ua.sdk.recorder.datasource.derived.DerivedDataSource
    public void deriveDataPoint(RecorderCalculator recorderCalculator, DataSourceIdentifier dataSourceIdentifier, DataTypeRef dataTypeRef, DataPoint dataPoint) {
        if (this.dataTypeRefTriggers.contains(dataTypeRef)) {
            DataPointImpl dataPointImpl = new DataPointImpl();
            dataPointImpl.setValue(BaseDataTypes.FIELD_LATITUDE, dataPoint.getValueDouble(BaseDataTypes.FIELD_LATITUDE));
            dataPointImpl.setValue(BaseDataTypes.FIELD_LONGITUDE, dataPoint.getValueDouble(BaseDataTypes.FIELD_LONGITUDE));
            dataPointImpl.setValue(BaseDataTypes.FIELD_HORIZONTAL_ACCURACY, dataPoint.getValueDouble(BaseDataTypes.FIELD_HORIZONTAL_ACCURACY));
            recorderCalculator.updateDataPoint(this.dataSourceIdentifier, dataPointImpl, BaseDataTypes.TYPE_LOCATION.getRef());
        }
    }

    @Override // com.ua.sdk.recorder.datasource.derived.DerivedDataSource
    public List<DataTypeRef> getDataTypeRefTriggers() {
        return this.dataTypeRefTriggers;
    }
}
