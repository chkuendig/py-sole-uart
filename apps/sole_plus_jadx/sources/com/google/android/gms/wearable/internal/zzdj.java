package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataItem;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzdj extends DataBufferRef implements DataEvent {
    private final int zza;

    public zzdj(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.zza = i2;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* synthetic */ DataEvent freeze() {
        return new zzdi(this);
    }

    @Override // com.google.android.gms.wearable.DataEvent
    public final DataItem getDataItem() {
        return new zzdq(this.mDataHolder, this.mDataRow, this.zza);
    }

    @Override // com.google.android.gms.wearable.DataEvent
    public final int getType() {
        return getInteger("event_type");
    }

    public final String toString() {
        return "DataEventRef{ type=" + (getInteger("event_type") == 1 ? "changed" : getInteger("event_type") == 2 ? "deleted" : "unknown") + ", dataitem=" + getDataItem().toString() + " }";
    }
}
