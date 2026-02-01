package com.google.android.gms.internal.mlkit_vision_text_common;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.1.0 */
/* loaded from: classes4.dex */
final class zzcs implements zzcx {
    private final int zza;
    private final zzcw zzb;

    zzcs(int i, zzcw zzcwVar) {
        this.zza = i;
        this.zzb = zzcwVar;
    }

    @Override // java.lang.annotation.Annotation
    public final Class annotationType() {
        return zzcx.class;
    }

    @Override // java.lang.annotation.Annotation
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzcx)) {
            return false;
        }
        zzcx zzcxVar = (zzcx) obj;
        return this.zza == zzcxVar.zza() && this.zzb.equals(zzcxVar.zzb());
    }

    @Override // java.lang.annotation.Annotation
    public final int hashCode() {
        return (this.zza ^ 14552422) + (this.zzb.hashCode() ^ 2041407134);
    }

    @Override // java.lang.annotation.Annotation
    public final String toString() {
        return "@com.google.firebase.encoders.proto.Protobuf(tag=" + this.zza + "intEncoding=" + this.zzb + ')';
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzcx
    public final int zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzcx
    public final zzcw zzb() {
        return this.zzb;
    }
}
