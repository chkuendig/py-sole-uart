package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.0.0 */
/* loaded from: classes2.dex */
final class zzim implements Runnable {
    final /* synthetic */ zzih zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ zzio zzc;

    zzim(zzio zzioVar, zzih zzihVar, long j) {
        this.zzc = zzioVar;
        this.zza = zzihVar;
        this.zzb = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zzC(this.zza, false, this.zzb);
        zzio zzioVar = this.zzc;
        zzioVar.zza = null;
        zzioVar.zzs.zzt().zzG(null);
    }
}
