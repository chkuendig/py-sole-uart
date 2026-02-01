package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@20.0.0 */
/* loaded from: classes2.dex */
final class zzfy implements Runnable {
    final /* synthetic */ zzab zza;
    final /* synthetic */ zzgn zzb;

    zzfy(zzgn zzgnVar, zzab zzabVar) {
        this.zzb = zzgnVar;
        this.zza = zzabVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzA();
        if (this.zza.zzc.zza() == null) {
            this.zzb.zza.zzM(this.zza);
        } else {
            this.zzb.zza.zzR(this.zza);
        }
    }
}
