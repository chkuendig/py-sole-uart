package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.wearable.MessageApi;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
final class zzgl implements BaseImplementation.ResultHolder {
    final /* synthetic */ TaskCompletionSource zza;

    zzgl(zzgo zzgoVar, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
    public final void setFailedResult(Status status) {
        this.zza.setException(ApiExceptionUtil.fromStatus(status));
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        MessageApi.SendMessageResult sendMessageResult = (MessageApi.SendMessageResult) obj;
        if (sendMessageResult.getStatus().isSuccess()) {
            this.zza.setResult(Integer.valueOf(sendMessageResult.getRequestId()));
        } else {
            this.zza.setException(ApiExceptionUtil.fromStatus(sendMessageResult.getStatus()));
        }
    }
}
