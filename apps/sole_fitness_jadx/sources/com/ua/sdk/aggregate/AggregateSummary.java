package com.ua.sdk.aggregate;

import android.os.Parcelable;
import com.ua.sdk.datapoint.DataField;
import java.util.Date;

/* loaded from: classes2.dex */
public interface AggregateSummary extends Parcelable {
    Date getDatetime();

    Date getStartDatetime();

    Double getValueDouble(DataField dataField);

    Long getValueLong(DataField dataField);
}
