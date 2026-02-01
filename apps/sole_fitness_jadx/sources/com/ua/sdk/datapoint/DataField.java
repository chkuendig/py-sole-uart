package com.ua.sdk.datapoint;

import android.os.Parcelable;

/* loaded from: classes2.dex */
public interface DataField extends Parcelable {
    String getId();

    String getType();

    DataUnits getUnits();
}
