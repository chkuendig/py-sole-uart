package com.google.android.gms.wearable.internal;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
final class zziq extends zzij {
    private final zzce zza;

    public zziq(BaseImplementation.ResultHolder resultHolder, zzce zzceVar) {
        super(resultHolder);
        this.zza = (zzce) Preconditions.checkNotNull(zzceVar);
    }

    @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzfp
    public final void zzp(zzef zzefVar) {
        zzbz zzbzVar;
        if (zzefVar.zzb != null) {
            zzbzVar = new zzbz(new ParcelFileDescriptor.AutoCloseOutputStream(zzefVar.zzb));
            this.zza.zzc(new zzby(zzbzVar));
        } else {
            zzbzVar = null;
        }
        zzO(new zzbt(new Status(zzefVar.zza), zzbzVar));
    }
}
