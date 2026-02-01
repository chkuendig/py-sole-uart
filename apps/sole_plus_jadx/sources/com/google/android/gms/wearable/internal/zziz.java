package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.BaseImplementation;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.FutureTask;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
final class zziz extends zzij {
    private final List zza;

    zziz(BaseImplementation.ResultHolder resultHolder, List list) {
        super(resultHolder);
        this.zza = list;
    }

    @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzfp
    public final void zzI(zzho zzhoVar) {
        zzO(new zzcw(zzib.zza(zzhoVar.zza), zzhoVar.zzb));
        if (zzhoVar.zza != 0) {
            Iterator it = this.zza.iterator();
            while (it.hasNext()) {
                ((FutureTask) it.next()).cancel(true);
            }
        }
    }
}
