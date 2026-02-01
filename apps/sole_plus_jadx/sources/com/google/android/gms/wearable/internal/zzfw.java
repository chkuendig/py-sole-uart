package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
final class zzfw extends zzij {
    private final WeakReference zza;
    private final WeakReference zzb;

    zzfw(Map map, Object obj, BaseImplementation.ResultHolder resultHolder) {
        super(resultHolder);
        this.zza = new WeakReference(map);
        this.zzb = new WeakReference(obj);
    }

    @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzfp
    public final void zzM(Status status) {
        Map map = (Map) this.zza.get();
        Object obj = this.zzb.get();
        if (status.getStatus().getStatusCode() == 4002 && map != null && obj != null) {
            synchronized (map) {
                zzjq zzjqVar = (zzjq) map.remove(obj);
                if (zzjqVar != null) {
                    zzjqVar.zzt();
                }
            }
        }
        zzO(status);
    }
}
