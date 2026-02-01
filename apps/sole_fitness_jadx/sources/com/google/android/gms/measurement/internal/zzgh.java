package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@20.0.0 */
/* loaded from: classes2.dex */
final class zzgh implements Runnable {
    final /* synthetic */ zzat zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzgn zzc;

    zzgh(zzgn zzgnVar, zzat zzatVar, String str) {
        this.zzc = zzgnVar;
        this.zza = zzatVar;
        this.zzb = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zza.zzA();
        this.zzc.zza.zzE(this.zza, this.zzb);
    }
}
