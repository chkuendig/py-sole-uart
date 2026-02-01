package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@20.0.0 */
/* loaded from: classes2.dex */
final class zzjs implements Runnable {
    final /* synthetic */ zzks zza;
    final /* synthetic */ Runnable zzb;

    zzjs(zzju zzjuVar, zzks zzksVar, Runnable runnable) {
        this.zza = zzksVar;
        this.zzb = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzA();
        this.zza.zzz(this.zzb);
        this.zza.zzV();
    }
}
