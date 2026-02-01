package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.CapabilityInfo;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzah implements CapabilityApi.GetAllCapabilitiesResult {
    private final Status zza;
    private final Map zzb;

    public zzah(Status status, Map map) {
        this.zza = status;
        this.zzb = map;
    }

    @Override // com.google.android.gms.wearable.CapabilityApi.GetAllCapabilitiesResult
    public final Map<String, CapabilityInfo> getAllCapabilities() {
        return this.zzb;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zza;
    }
}
