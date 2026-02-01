package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.0.0 */
/* loaded from: classes2.dex */
final class zzhq implements Runnable {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ zzia zzb;

    zzhq(zzia zziaVar, AtomicReference atomicReference) {
        this.zzb = zziaVar;
        this.zza = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zza) {
            try {
                this.zza.set(Long.valueOf(this.zzb.zzs.zzf().zzi(this.zzb.zzs.zzh().zzl(), zzdy.zzL)));
            } finally {
                this.zza.notify();
            }
        }
    }
}
