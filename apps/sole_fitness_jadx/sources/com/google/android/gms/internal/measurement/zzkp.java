package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.0.0 */
/* loaded from: classes2.dex */
final class zzkp extends zzkq {
    private zzkp() {
        super(null);
    }

    /* synthetic */ zzkp(zzkn zzknVar) {
        super(null);
    }

    @Override // com.google.android.gms.internal.measurement.zzkq
    final void zza(Object obj, long j) {
        ((zzke) zzml.zzf(obj, j)).zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzkq
    final <E> void zzb(Object obj, Object obj2, long j) {
        zzke zzkeVarZzd = (zzke) zzml.zzf(obj, j);
        zzke zzkeVar = (zzke) zzml.zzf(obj2, j);
        int size = zzkeVarZzd.size();
        int size2 = zzkeVar.size();
        if (size > 0 && size2 > 0) {
            if (!zzkeVarZzd.zzc()) {
                zzkeVarZzd = zzkeVarZzd.zzd(size2 + size);
            }
            zzkeVarZzd.addAll(zzkeVar);
        }
        if (size > 0) {
            zzkeVar = zzkeVarZzd;
        }
        zzml.zzs(obj, j, zzkeVar);
    }
}
