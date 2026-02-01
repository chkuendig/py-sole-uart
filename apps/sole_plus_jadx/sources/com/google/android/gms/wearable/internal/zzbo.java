package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
final class zzbo extends zzw {
    final /* synthetic */ zzbu zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbo(zzbu zzbuVar, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        this.zza = zzbuVar;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ Result createFailedResult(Status status) {
        return new zzbt(status, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        String str = this.zza.zza;
        zzce zzceVar = new zzce();
        ((zzft) ((zzjj) anyClient).getService()).zzl(new zziq(this, zzceVar), zzceVar, str);
    }
}
