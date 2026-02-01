package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@20.0.0 */
/* loaded from: classes2.dex */
final class zzi implements Runnable {
    final /* synthetic */ com.google.android.gms.internal.measurement.zzcf zza;
    final /* synthetic */ zzat zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ AppMeasurementDynamiteService zzd;

    zzi(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.zzcf zzcfVar, zzat zzatVar, String str) {
        this.zzd = appMeasurementDynamiteService;
        this.zza = zzcfVar;
        this.zzb = zzatVar;
        this.zzc = str;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        this.zzd.zza.zzt().zzB(this.zza, this.zzb, this.zzc);
    }
}
