package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import java.util.HashMap;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
final class zzin extends zzij {
    public zzin(BaseImplementation.ResultHolder resultHolder) {
        super(resultHolder);
    }

    @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzfp
    public final void zzk(zzdv zzdvVar) {
        Status statusZza = zzib.zza(zzdvVar.zza);
        List<zzas> list = zzdvVar.zzb;
        HashMap map = new HashMap();
        if (list != null) {
            for (zzas zzasVar : list) {
                map.put(zzasVar.getName(), new zzag(zzasVar));
            }
        }
        zzO(new zzah(statusZza, map));
    }
}
