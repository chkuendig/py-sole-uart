package com.google.android.gms.wearable.internal;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
final class zzip extends zzij {
    private final zzce zza;

    public zzip(BaseImplementation.ResultHolder resultHolder, zzce zzceVar) {
        super(resultHolder);
        this.zza = (zzce) Preconditions.checkNotNull(zzceVar);
    }

    @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzfp
    public final void zzo(zzed zzedVar) {
        zzbx zzbxVar;
        if (zzedVar.zzb != null) {
            zzbxVar = new zzbx(new ParcelFileDescriptor.AutoCloseInputStream(zzedVar.zzb));
            this.zza.zzc(new zzbw(zzbxVar));
        } else {
            zzbxVar = null;
        }
        zzO(new zzbs(new Status(zzedVar.zza), zzbxVar));
    }
}
