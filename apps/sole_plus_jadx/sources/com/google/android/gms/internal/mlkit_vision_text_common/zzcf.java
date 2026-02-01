package com.google.android.gms.internal.mlkit_vision_text_common;

import java.util.AbstractMap;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.1.0 */
/* loaded from: classes4.dex */
final class zzcf extends zzbk {
    final /* synthetic */ zzcg zza;

    zzcf(zzcg zzcgVar) {
        this.zza = zzcgVar;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        zzx.zza(i, this.zza.zzc, "index");
        int i2 = i + i;
        return new AbstractMap.SimpleImmutableEntry(Objects.requireNonNull(this.zza.zzb[i2]), Objects.requireNonNull(this.zza.zzb[i2 + 1]));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.zzc;
    }
}
