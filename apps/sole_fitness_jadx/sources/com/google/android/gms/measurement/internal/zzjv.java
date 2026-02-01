package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.0.0 */
/* loaded from: classes2.dex */
final class zzjv implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzkd zzb;

    zzjv(zzkd zzkdVar, long j) {
        this.zzb = zzkdVar;
        this.zza = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzkd.zzl(this.zzb, this.zza);
    }
}
