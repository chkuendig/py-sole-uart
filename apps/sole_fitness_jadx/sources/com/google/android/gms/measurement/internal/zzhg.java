package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.0.0 */
/* loaded from: classes2.dex */
final class zzhg implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ Object zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ zzia zze;

    zzhg(zzia zziaVar, String str, String str2, Object obj, long j) {
        this.zze = zziaVar;
        this.zza = str;
        this.zzb = str2;
        this.zzc = obj;
        this.zzd = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zze.zzZ(this.zza, this.zzb, this.zzc, this.zzd);
    }
}
