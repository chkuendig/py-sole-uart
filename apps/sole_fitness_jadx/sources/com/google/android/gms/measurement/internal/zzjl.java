package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.0.0 */
/* loaded from: classes2.dex */
final class zzjl implements Runnable {
    final /* synthetic */ zzjn zza;

    zzjl(zzjn zzjnVar) {
        this.zza = zzjnVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjo zzjoVar = this.zza.zza;
        Context contextZzau = zzjoVar.zzs.zzau();
        this.zza.zza.zzs.zzaw();
        zzjo.zzo(zzjoVar, new ComponentName(contextZzau, "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
