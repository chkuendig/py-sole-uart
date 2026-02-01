package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
final class zzif implements BaseImplementation.ResultHolder {
    final TaskCompletionSource zza;

    zzif(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
    public final void setFailedResult(Status status) {
        this.zza.setException(new ApiException(status));
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        Status status = (Status) obj;
        int statusCode = status.getStatusCode();
        if (statusCode == 0 || statusCode == 4001) {
            this.zza.setResult(null);
        } else {
            setFailedResult(status);
        }
    }
}
