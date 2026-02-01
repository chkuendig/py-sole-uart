package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@20.0.0 */
/* loaded from: classes2.dex */
final class zzkn implements Callable<String> {
    final /* synthetic */ zzp zza;
    final /* synthetic */ zzks zzb;

    zzkn(zzks zzksVar, zzp zzpVar) {
        this.zzb = zzksVar;
        this.zza = zzpVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ String call() throws Exception {
        if (this.zzb.zzh((String) Preconditions.checkNotNull(this.zza.zza)).zzk() && zzag.zzb(this.zza.zzv).zzk()) {
            return this.zzb.zzd(this.zza).zzu();
        }
        this.zzb.zzay().zzj().zza("Analytics storage consent denied. Returning null app instance id");
        return null;
    }
}
