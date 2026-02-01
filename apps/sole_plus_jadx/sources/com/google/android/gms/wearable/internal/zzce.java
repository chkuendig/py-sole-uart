package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.internal.Preconditions;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzce extends zzfl {
    private final Object zza = new Object();

    @Nullable
    private zzcf zzb;

    @Nullable
    private zzbi zzc;

    @Override // com.google.android.gms.wearable.internal.zzfm
    public final void zzb(int i, int i2) {
        zzcf zzcfVar;
        zzbi zzbiVar;
        synchronized (this.zza) {
            zzcfVar = this.zzb;
            zzbiVar = new zzbi(i, i2);
            this.zzc = zzbiVar;
        }
        if (zzcfVar != null) {
            zzcfVar.zza(zzbiVar);
        }
    }

    public final void zzc(zzcf zzcfVar) {
        zzbi zzbiVar;
        synchronized (this.zza) {
            this.zzb = (zzcf) Preconditions.checkNotNull(zzcfVar);
            zzbiVar = this.zzc;
        }
        if (zzbiVar != null) {
            zzcfVar.zza(zzbiVar);
        }
    }
}
