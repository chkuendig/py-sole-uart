package com.ua.sdk.datapoint;

import android.os.Parcelable;
import java.util.Date;

/* loaded from: classes2.dex */
public interface DataPoint extends Parcelable {
    Date getDatetime();

    Date getStartDatetime();

    Double getValueDouble(DataField dataField);

    Long getValueLong(DataField dataField);
}
