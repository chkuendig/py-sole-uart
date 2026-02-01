package com.ua.sdk.datapoint;

import com.ua.sdk.Entity;
import java.util.List;

/* loaded from: classes2.dex */
public interface DataType extends Entity<DataTypeRef> {
    String getDescription();

    List<DataField> getFields();

    String getId();

    DataPeriod getPeriod();
}
