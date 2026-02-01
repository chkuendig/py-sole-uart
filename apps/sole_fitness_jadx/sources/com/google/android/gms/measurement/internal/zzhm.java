package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.0.0 */
/* loaded from: classes2.dex */
final class zzhm implements Runnable {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ zzia zzd;

    zzhm(zzia zziaVar, AtomicReference atomicReference, String str, String str2, String str3) {
        this.zzd = zziaVar;
        this.zza = atomicReference;
        this.zzb = str2;
        this.zzc = str3;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        this.zzd.zzs.zzt().zzw(this.zza, null, this.zzb, this.zzc);
    }
}
