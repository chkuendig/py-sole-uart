package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.CapabilityInfo;
import com.google.android.gms.wearable.Node;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzag implements CapabilityInfo {
    private final String zza;
    private final Set zzb;

    public zzag(CapabilityInfo capabilityInfo) {
        String name = capabilityInfo.getName();
        Set<Node> nodes = capabilityInfo.getNodes();
        this.zza = name;
        this.zzb = nodes;
    }

    @Override // com.google.android.gms.wearable.CapabilityInfo
    public final String getName() {
        return this.zza;
    }

    @Override // com.google.android.gms.wearable.CapabilityInfo
    public final Set<Node> getNodes() {
        return this.zzb;
    }
}
