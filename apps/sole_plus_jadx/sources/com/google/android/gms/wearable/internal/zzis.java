package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.BaseImplementation;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
final class zzis extends zzij {
    public zzis(BaseImplementation.ResultHolder resultHolder) {
        super(resultHolder);
    }

    @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzfp
    public final void zzw(zzet zzetVar) {
        ArrayList arrayList = new ArrayList();
        List list = zzetVar.zzb;
        if (list != null) {
            arrayList.addAll(list);
        }
        zzO(new zzgt(zzib.zza(zzetVar.zza), arrayList));
    }
}
