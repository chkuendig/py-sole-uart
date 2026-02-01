package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataItemAsset;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
final class zzct extends zzw {
    final /* synthetic */ DataItemAsset zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzct(zzcz zzczVar, GoogleApiClient googleApiClient, DataItemAsset dataItemAsset) {
        super(googleApiClient);
        this.zza = dataItemAsset;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    protected final /* synthetic */ Result createFailedResult(Status status) {
        return new zzcy(status, null);
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzjj) anyClient).zzu(this, Asset.createFromRef(this.zza.getId()));
    }
}
