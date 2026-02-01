package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
final class zzio extends zzij {
    public zzio(BaseImplementation.ResultHolder resultHolder) {
        super(resultHolder);
    }

    @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzfp
    public final void zzn(zzeb zzebVar) {
        Status statusZza = zzib.zza(zzebVar.zza);
        zzas zzasVar = zzebVar.zzb;
        zzO(new zzai(statusZza, zzasVar == null ? null : new zzag(zzasVar)));
    }
}
