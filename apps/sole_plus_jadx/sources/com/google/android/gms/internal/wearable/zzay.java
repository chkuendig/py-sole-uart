package com.google.android.gms.internal.wearable;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
final class zzay extends zzba {
    final /* synthetic */ zzbh zza;
    private int zzb = 0;
    private final int zzc;

    zzay(zzbh zzbhVar) {
        this.zza = zzbhVar;
        this.zzc = zzbhVar.zzd();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    @Override // com.google.android.gms.internal.wearable.zzbc
    public final byte zza() {
        int i = this.zzb;
        if (i >= this.zzc) {
            throw new NoSuchElementException();
        }
        this.zzb = i + 1;
        return this.zza.zzb(i);
    }
}
