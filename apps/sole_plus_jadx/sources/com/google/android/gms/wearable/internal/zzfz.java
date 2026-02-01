package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.MessageApi;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
final class zzfz extends zzw {
    final /* synthetic */ MessageApi.MessageListener zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzfz(zzgd zzgdVar, GoogleApiClient googleApiClient, MessageApi.MessageListener messageListener) {
        super(googleApiClient);
        this.zza = messageListener;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* bridge */ /* synthetic */ Result createFailedResult(Status status) {
        return status;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzjj) anyClient).zzA(this, this.zza);
    }
}
