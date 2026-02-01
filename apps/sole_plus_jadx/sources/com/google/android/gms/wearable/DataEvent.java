package com.google.android.gms.wearable;

import com.google.android.gms.common.data.Freezable;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public interface DataEvent extends Freezable<DataEvent> {
    public static final int TYPE_CHANGED = 1;
    public static final int TYPE_DELETED = 2;

    DataItem getDataItem();

    int getType();
}
