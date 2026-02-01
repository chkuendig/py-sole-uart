package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataItemAsset;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzdm extends DataBufferRef implements DataItemAsset {
    public zzdm(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* synthetic */ DataItemAsset freeze() {
        return new zzdk(this);
    }

    @Override // com.google.android.gms.wearable.DataItemAsset
    public final String getDataItemKey() {
        return getString("asset_key");
    }

    @Override // com.google.android.gms.wearable.DataItemAsset
    public final String getId() {
        return getString("asset_id");
    }
}
