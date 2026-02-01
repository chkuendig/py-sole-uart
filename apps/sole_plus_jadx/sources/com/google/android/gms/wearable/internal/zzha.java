package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
final class zzha implements BaseImplementation.ResultHolder {
    final /* synthetic */ TaskCompletionSource zza;

    zzha(zzhd zzhdVar, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
    public final void setFailedResult(Status status) {
        this.zza.setException(ApiExceptionUtil.fromStatus(status));
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        zzhc zzhcVar = (zzhc) obj;
        if (zzhcVar.getStatus().isSuccess()) {
            this.zza.setResult(zzhcVar.zza());
        } else {
            this.zza.setException(ApiExceptionUtil.fromStatus(zzhcVar.getStatus()));
        }
    }
}
