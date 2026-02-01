package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.0.0 */
/* loaded from: classes2.dex */
final class zzil implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzio zzb;

    zzil(zzio zzioVar, long j) {
        this.zzb = zzioVar;
        this.zza = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzs.zzd().zzf(this.zza);
        this.zzb.zza = null;
    }
}
