package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.MessageApi;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzgc implements MessageApi.SendMessageResult {
    private final Status zza;
    private final int zzb;

    public zzgc(Status status, int i) {
        this.zza = status;
        this.zzb = i;
    }

    @Override // com.google.android.gms.wearable.MessageApi.SendMessageResult
    public final int getRequestId() {
        return this.zzb;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zza;
    }
}
