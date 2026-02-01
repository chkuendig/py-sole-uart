package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
final class zzaa extends zzw {
    final /* synthetic */ int zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzaa(zzal zzalVar, GoogleApiClient googleApiClient, int i) {
        super(googleApiClient);
        this.zza = i;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    protected final /* synthetic */ Result createFailedResult(Status status) {
        return new zzah(status, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzft) ((zzjj) anyClient).getService()).zzi(new zzin(this), this.zza);
    }
}
