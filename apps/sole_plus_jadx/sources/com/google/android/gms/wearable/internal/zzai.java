package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.CapabilityInfo;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzai implements CapabilityApi.GetCapabilityResult {
    private final CapabilityInfo zza;
    private final Status zzb;

    public zzai(Status status, CapabilityInfo capabilityInfo) {
        this.zzb = status;
        this.zza = capabilityInfo;
    }

    @Override // com.google.android.gms.wearable.CapabilityApi.GetCapabilityResult
    public final CapabilityInfo getCapability() {
        return this.zza;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zzb;
    }
}
