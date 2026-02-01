package com.google.android.gms.measurement.internal;

import androidx.collection.LruCache;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@20.0.0 */
/* loaded from: classes2.dex */
final class zzfj extends LruCache<String, com.google.android.gms.internal.measurement.zzc> {
    final /* synthetic */ zzfm zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzfj(zzfm zzfmVar, int i) {
        super(20);
        this.zza = zzfmVar;
    }

    @Override // androidx.collection.LruCache
    protected final /* bridge */ /* synthetic */ com.google.android.gms.internal.measurement.zzc create(String str) {
        String str2 = str;
        Preconditions.checkNotEmpty(str2);
        return zzfm.zzd(this.zza, str2);
    }
}
