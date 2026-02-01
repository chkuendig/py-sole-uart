package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.0.0 */
/* loaded from: classes2.dex */
final class zzfu implements Runnable {
    final /* synthetic */ zzgy zza;
    final /* synthetic */ zzfv zzb;

    zzfu(zzfv zzfvVar, zzgy zzgyVar) {
        this.zzb = zzfvVar;
        this.zza = zzgyVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws ClassNotFoundException {
        zzfv.zzA(this.zzb, this.zza);
        this.zzb.zzH(this.zza.zzg);
    }
}
