package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.DataItemAsset;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzdk implements DataItemAsset {
    private final String zza;
    private final String zzb;

    public zzdk(DataItemAsset dataItemAsset) {
        this.zza = dataItemAsset.getId();
        this.zzb = dataItemAsset.getDataItemKey();
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* bridge */ /* synthetic */ DataItemAsset freeze() {
        return this;
    }

    @Override // com.google.android.gms.wearable.DataItemAsset
    public final String getDataItemKey() {
        return this.zzb;
    }

    @Override // com.google.android.gms.wearable.DataItemAsset
    public final String getId() {
        return this.zza;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("DataItemAssetEntity[@");
        sb.append(Integer.toHexString(hashCode()));
        if (this.zza == null) {
            sb.append(",noid");
        } else {
            sb.append(",");
            sb.append(this.zza);
        }
        sb.append(", key=");
        sb.append(this.zzb);
        sb.append("]");
        return sb.toString();
    }
}
