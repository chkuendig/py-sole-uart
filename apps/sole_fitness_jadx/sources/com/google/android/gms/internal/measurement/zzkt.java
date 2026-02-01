package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.0.0 */
/* loaded from: classes2.dex */
final class zzkt implements zzla {
    private final zzla[] zza;

    zzkt(zzla... zzlaVarArr) {
        this.zza = zzlaVarArr;
    }

    @Override // com.google.android.gms.internal.measurement.zzla
    public final zzkz zzb(Class<?> cls) {
        zzla[] zzlaVarArr = this.zza;
        for (int i = 0; i < 2; i++) {
            zzla zzlaVar = zzlaVarArr[i];
            if (zzlaVar.zzc(cls)) {
                return zzlaVar.zzb(cls);
            }
        }
        String strValueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(strValueOf.length() != 0 ? "No factory is available for message type: ".concat(strValueOf) : new String("No factory is available for message type: "));
    }

    @Override // com.google.android.gms.internal.measurement.zzla
    public final boolean zzc(Class<?> cls) {
        zzla[] zzlaVarArr = this.zza;
        for (int i = 0; i < 2; i++) {
            if (zzlaVarArr[i].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
