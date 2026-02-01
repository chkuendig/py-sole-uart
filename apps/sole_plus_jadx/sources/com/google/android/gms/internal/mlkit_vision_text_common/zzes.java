package com.google.android.gms.internal.mlkit_vision_text_common;

import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.1.0 */
/* loaded from: classes4.dex */
public final class zzes {
    private final zzou zza;
    private final Boolean zzc;
    private final zzsd zze;
    private final Boolean zzb = null;
    private final zzod zzd = null;

    /* synthetic */ zzes(zzeq zzeqVar, zzer zzerVar) {
        this.zza = zzeqVar.zza;
        this.zzc = zzeqVar.zzb;
        this.zze = zzeqVar.zzc;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzes)) {
            return false;
        }
        zzes zzesVar = (zzes) obj;
        if (Objects.equal(this.zza, zzesVar.zza)) {
            Boolean bool = zzesVar.zzb;
            if (Objects.equal(null, null) && Objects.equal(this.zzc, zzesVar.zzc)) {
                zzod zzodVar = zzesVar.zzd;
                if (Objects.equal(null, null) && Objects.equal(this.zze, zzesVar.zze)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, null, this.zzc, null, this.zze);
    }

    public final zzou zza() {
        return this.zza;
    }

    public final zzsd zzb() {
        return this.zze;
    }

    public final Boolean zzc() {
        return this.zzc;
    }
}
