package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@20.0.0 */
/* loaded from: classes2.dex */
final class zzkk implements Runnable {
    final /* synthetic */ zzkt zza;
    final /* synthetic */ zzks zzb;

    zzkk(zzks zzksVar, zzkt zzktVar) {
        this.zzb = zzksVar;
        this.zza = zzktVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzks.zzy(this.zzb, this.zza);
        this.zzb.zzQ();
    }
}
