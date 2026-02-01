package com.google.android.gms.internal.mlkit_vision_text_common;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.1.0 */
/* loaded from: classes4.dex */
public enum zzot implements zzcv {
    TYPE_UNKNOWN(0),
    TYPE_THIN(1),
    TYPE_THICK(2),
    TYPE_GMV(3);

    private final int zzf;

    zzot(int i) {
        this.zzf = i;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzcv
    public final int zza() {
        return this.zzf;
    }
}
