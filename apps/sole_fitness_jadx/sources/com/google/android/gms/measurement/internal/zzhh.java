package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.0.0 */
/* loaded from: classes2.dex */
final class zzhh implements Runnable {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzia zzc;

    zzhh(zzia zziaVar, AtomicReference atomicReference, boolean z) {
        this.zzc = zziaVar;
        this.zza = atomicReference;
        this.zzb = z;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        this.zzc.zzs.zzt().zzx(this.zza, this.zzb);
    }
}
