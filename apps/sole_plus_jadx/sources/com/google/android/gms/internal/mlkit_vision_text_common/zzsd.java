package com.google.android.gms.internal.mlkit_vision_text_common;

import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.1.0 */
/* loaded from: classes4.dex */
public final class zzsd {
    private final zzsb zza;
    private final Boolean zzb = null;
    private final String zzc = null;

    /* synthetic */ zzsd(zzsa zzsaVar, zzsc zzscVar) {
        this.zza = zzsaVar.zza;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzsd)) {
            return false;
        }
        zzsd zzsdVar = (zzsd) obj;
        if (Objects.equal(this.zza, zzsdVar.zza)) {
            Boolean bool = zzsdVar.zzb;
            if (Objects.equal(null, null)) {
                String str = zzsdVar.zzc;
                if (Objects.equal(null, null)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, null, null);
    }

    public final zzsb zza() {
        return this.zza;
    }
}
