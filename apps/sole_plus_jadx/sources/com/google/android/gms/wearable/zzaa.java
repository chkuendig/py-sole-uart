package com.google.android.gms.wearable;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
final class zzaa implements Runnable {
    final /* synthetic */ List zza;
    final /* synthetic */ zzag zzb;

    zzaa(zzag zzagVar, List list) {
        this.zzb = zzagVar;
        this.zza = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.onConnectedNodes(this.zza);
    }
}
