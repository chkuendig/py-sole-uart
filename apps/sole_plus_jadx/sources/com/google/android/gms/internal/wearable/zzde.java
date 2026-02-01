package com.google.android.gms.internal.wearable;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
final class zzde implements zzdl {
    private final zzdl[] zza;

    zzde(zzdl... zzdlVarArr) {
        this.zza = zzdlVarArr;
    }

    @Override // com.google.android.gms.internal.wearable.zzdl
    public final zzdk zzb(Class cls) {
        zzdl[] zzdlVarArr = this.zza;
        for (int i = 0; i < 2; i++) {
            zzdl zzdlVar = zzdlVarArr[i];
            if (zzdlVar.zzc(cls)) {
                return zzdlVar.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(String.valueOf(cls.getName())));
    }

    @Override // com.google.android.gms.internal.wearable.zzdl
    public final boolean zzc(Class cls) {
        zzdl[] zzdlVarArr = this.zza;
        for (int i = 0; i < 2; i++) {
            if (zzdlVarArr[i].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
