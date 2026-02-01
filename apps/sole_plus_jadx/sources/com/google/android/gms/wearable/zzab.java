package com.google.android.gms.wearable;

import com.google.android.gms.wearable.internal.zzas;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
final class zzab implements Runnable {
    final /* synthetic */ zzas zza;
    final /* synthetic */ zzag zzb;

    zzab(zzag zzagVar, zzas zzasVar) {
        this.zzb = zzagVar;
        this.zza = zzasVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.onCapabilityChanged(this.zza);
    }
}
