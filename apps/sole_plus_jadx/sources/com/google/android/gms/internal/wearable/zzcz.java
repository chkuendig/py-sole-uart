package com.google.android.gms.internal.wearable;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
final class zzcz extends zzdb {
    private zzcz() {
        super(null);
    }

    /* synthetic */ zzcz(zzcy zzcyVar) {
        super(null);
    }

    @Override // com.google.android.gms.internal.wearable.zzdb
    final void zza(Object obj, long j) {
        ((zzcn) zzez.zzf(obj, j)).zzb();
    }

    @Override // com.google.android.gms.internal.wearable.zzdb
    final void zzb(Object obj, Object obj2, long j) {
        zzcn zzcnVarZzd = (zzcn) zzez.zzf(obj, j);
        zzcn zzcnVar = (zzcn) zzez.zzf(obj2, j);
        int size = zzcnVarZzd.size();
        int size2 = zzcnVar.size();
        if (size > 0 && size2 > 0) {
            if (!zzcnVarZzd.zzc()) {
                zzcnVarZzd = zzcnVarZzd.zzd(size2 + size);
            }
            zzcnVarZzd.addAll(zzcnVar);
        }
        if (size > 0) {
            zzcnVar = zzcnVarZzd;
        }
        zzez.zzs(obj, j, zzcnVar);
    }
}
