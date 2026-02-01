package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.DataApi;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzcx implements DataApi.DeleteDataItemsResult {
    private final Status zza;
    private final int zzb;

    public zzcx(Status status, int i) {
        this.zza = status;
        this.zzb = i;
    }

    @Override // com.google.android.gms.wearable.DataApi.DeleteDataItemsResult
    public final int getNumDeleted() {
        return this.zzb;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zza;
    }
}
