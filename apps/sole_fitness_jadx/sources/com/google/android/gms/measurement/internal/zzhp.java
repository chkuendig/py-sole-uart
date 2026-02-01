package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.0.0 */
/* loaded from: classes2.dex */
final class zzhp implements Runnable {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ zzia zzb;

    zzhp(zzia zziaVar, AtomicReference atomicReference) {
        this.zzb = zziaVar;
        this.zza = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zza) {
            try {
                this.zza.set(this.zzb.zzs.zzf().zzo(this.zzb.zzs.zzh().zzl(), zzdy.zzK));
            } finally {
                this.zza.notify();
            }
        }
    }
}
