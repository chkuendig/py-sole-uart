package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzgu implements NodeApi.GetLocalNodeResult {
    private final Status zza;
    private final Node zzb;

    public zzgu(Status status, Node node) {
        this.zza = status;
        this.zzb = node;
    }

    @Override // com.google.android.gms.wearable.NodeApi.GetLocalNodeResult
    public final Node getNode() {
        return this.zzb;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zza;
    }
}
