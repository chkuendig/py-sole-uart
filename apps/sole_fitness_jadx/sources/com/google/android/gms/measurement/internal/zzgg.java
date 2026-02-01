package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzpe;

/* compiled from: com.google.android.gms:play-services-measurement@@20.0.0 */
/* loaded from: classes2.dex */
final class zzgg implements Runnable {
    final /* synthetic */ zzat zza;
    final /* synthetic */ zzp zzb;
    final /* synthetic */ zzgn zzc;

    zzgg(zzgn zzgnVar, zzat zzatVar, zzp zzpVar) {
        this.zzc = zzgnVar;
        this.zza = zzatVar;
        this.zzb = zzpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzat zzatVarZzb = this.zzc.zzb(this.zza, this.zzb);
        zzpe.zzc();
        if (this.zzc.zza.zzg().zzs(null, zzdy.zzat)) {
            this.zzc.zzw(zzatVarZzb, this.zzb);
        } else {
            this.zzc.zzB(zzatVarZzb, this.zzb);
        }
    }
}
