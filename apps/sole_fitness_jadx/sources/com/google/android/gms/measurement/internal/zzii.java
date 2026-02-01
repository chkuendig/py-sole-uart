package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.0.0 */
/* loaded from: classes2.dex */
final class zzii implements Runnable {
    final /* synthetic */ Bundle zza;
    final /* synthetic */ zzih zzb;
    final /* synthetic */ zzih zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ zzio zze;

    zzii(zzio zzioVar, Bundle bundle, zzih zzihVar, zzih zzihVar2, long j) {
        this.zze = zzioVar;
        this.zza = bundle;
        this.zzb = zzihVar;
        this.zzc = zzihVar2;
        this.zzd = j;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        zzio.zzp(this.zze, this.zza, this.zzb, this.zzc, this.zzd);
    }
}
