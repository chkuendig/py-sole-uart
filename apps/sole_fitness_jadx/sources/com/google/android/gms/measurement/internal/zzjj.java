package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.0.0 */
/* loaded from: classes2.dex */
final class zzjj implements Runnable {
    final /* synthetic */ ComponentName zza;
    final /* synthetic */ zzjn zzb;

    zzjj(zzjn zzjnVar, ComponentName componentName) {
        this.zzb = zzjnVar;
        this.zza = componentName;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjo.zzo(this.zzb.zza, this.zza);
    }
}
