package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@20.0.0 */
/* loaded from: classes2.dex */
final class zzes implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzet zzb;

    zzes(zzet zzetVar, boolean z) {
        this.zzb = zzetVar;
        this.zza = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzb.zzI(this.zza);
    }
}
