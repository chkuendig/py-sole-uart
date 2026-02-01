package com.ua.sdk.recorder.datasource;

import com.ua.sdk.datapoint.DataTypeRef;
import com.ua.sdk.datasourceidentifier.DataSourceIdentifier;
import com.ua.sdk.recorder.RecorderClock;
import com.ua.sdk.recorder.RecorderContext;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class DataSource {
    protected RecorderClock clock;
    protected DataSourceIdentifier dataSourceIdentifier;
    protected List<DataTypeRef> dataTypeRefs;
    protected RecorderContext recorderContext;

    public abstract void connectDataSource();

    public abstract void disconnectDataSource();

    public abstract void startSegment();

    public abstract void stopSegment();

    public DataSource(DataSourceIdentifier dataSourceIdentifier, List<DataTypeRef> list) {
        this.dataSourceIdentifier = dataSourceIdentifier;
        this.dataTypeRefs = list;
    }

    public void configure(RecorderContext recorderContext) {
        this.recorderContext = recorderContext;
        this.clock = recorderContext.getClock();
    }

    public List<DataTypeRef> getDataTypeRefs() {
        return this.dataTypeRefs;
    }

    public DataSourceIdentifier getDataSourceIdentifier() {
        return this.dataSourceIdentifier;
    }
}
