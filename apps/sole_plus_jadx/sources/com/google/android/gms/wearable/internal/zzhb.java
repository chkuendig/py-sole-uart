package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
final class zzhb extends zza {
    final /* synthetic */ TaskCompletionSource zza;

    zzhb(zzhd zzhdVar, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzfp
    public final void zzC(zzff zzffVar) {
        TaskUtil.setResultOrApiException(zzib.zza(zzffVar.zza), zzffVar.zzb, this.zza);
    }
}
