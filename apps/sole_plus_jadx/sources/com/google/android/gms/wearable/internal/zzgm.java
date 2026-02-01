package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
final class zzgm implements BaseImplementation.ResultHolder {
    final /* synthetic */ TaskCompletionSource zza;

    zzgm(zzgo zzgoVar, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
    public final void setFailedResult(Status status) {
        this.zza.setException(ApiExceptionUtil.fromStatus(status));
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        zzgn zzgnVar = (zzgn) obj;
        if (zzgnVar.getStatus().isSuccess()) {
            this.zza.setResult(zzgnVar.zza());
        } else {
            this.zza.setException(ApiExceptionUtil.fromStatus(zzgnVar.getStatus()));
        }
    }
}
