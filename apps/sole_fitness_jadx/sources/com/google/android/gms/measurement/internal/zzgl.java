package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@20.0.0 */
/* loaded from: classes2.dex */
final class zzgl implements Runnable {
    final /* synthetic */ zzp zza;
    final /* synthetic */ zzgn zzb;

    zzgl(zzgn zzgnVar, zzp zzpVar) {
        this.zzb = zzgnVar;
        this.zza = zzpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzA();
        this.zzb.zza.zzK(this.zza);
    }
}
