package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.BaseImplementation;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
class zzij extends zza {
    private BaseImplementation.ResultHolder zza;

    public zzij(BaseImplementation.ResultHolder resultHolder) {
        this.zza = resultHolder;
    }

    public final void zzO(Object obj) {
        BaseImplementation.ResultHolder resultHolder = this.zza;
        if (resultHolder != null) {
            resultHolder.setResult(obj);
            this.zza = null;
        }
    }
}
