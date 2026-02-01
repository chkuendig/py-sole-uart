package com.ua.sdk.recorder.data;

import com.ua.sdk.datapoint.DataFrame;
import com.ua.sdk.datapoint.DataTypeRef;
import com.ua.sdk.datasourceidentifier.DataSourceIdentifier;

/* loaded from: classes2.dex */
public interface DataFrameObserver {
    void onDataFrameUpdated(DataSourceIdentifier dataSourceIdentifier, DataTypeRef dataTypeRef, DataFrame dataFrame);
}
