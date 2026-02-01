package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzgt implements NodeApi.GetConnectedNodesResult {
    private final Status zza;
    private final List zzb;

    public zzgt(Status status, List list) {
        this.zza = status;
        this.zzb = list;
    }

    @Override // com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult
    public final List<Node> getNodes() {
        return this.zzb;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zza;
    }
}
