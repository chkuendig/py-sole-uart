package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.CapabilityApi;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzae implements CapabilityApi.AddLocalCapabilityResult, CapabilityApi.RemoveLocalCapabilityResult {
    private final Status zza;

    public zzae(Status status) {
        this.zza = status;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zza;
    }
}
