package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.0.0 */
/* loaded from: classes2.dex */
final class zzal implements Runnable {
    final /* synthetic */ zzgq zza;
    final /* synthetic */ zzam zzb;

    zzal(zzam zzamVar, zzgq zzgqVar) {
        this.zzb = zzamVar;
        this.zza = zzgqVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        this.zza.zzaw();
        if (zzaa.zza()) {
            this.zza.zzaz().zzp(this);
            return;
        }
        boolean zZze = this.zzb.zze();
        this.zzb.zzd = 0L;
        if (zZze) {
            this.zzb.zzc();
        }
    }
}
