package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.0.0 */
/* loaded from: classes2.dex */
final class zzht implements Runnable {
    final /* synthetic */ Boolean zza;
    final /* synthetic */ zzia zzb;

    zzht(zzia zziaVar, Boolean bool) {
        this.zzb = zziaVar;
        this.zza = bool;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        this.zzb.zzac(this.zza, true);
    }
}
