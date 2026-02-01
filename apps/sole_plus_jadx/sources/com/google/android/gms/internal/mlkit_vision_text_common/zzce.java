package com.google.android.gms.internal.mlkit_vision_text_common;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.1.0 */
/* loaded from: classes4.dex */
final class zzce extends zzbk {
    static final zzbk zza = new zzce(new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    zzce(Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzx.zza(i, this.zzc, "index");
        return Objects.requireNonNull(this.zzb[i]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzbk, com.google.android.gms.internal.mlkit_vision_text_common.zzbf
    final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzc);
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzbf
    final int zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzbf
    final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzbf
    final Object[] zze() {
        return this.zzb;
    }
}
