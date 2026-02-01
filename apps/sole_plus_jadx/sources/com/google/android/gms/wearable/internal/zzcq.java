package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataItemBuffer;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
final class zzcq extends zzw {
    final /* synthetic */ Uri zza;
    final /* synthetic */ int zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzcq(zzcz zzczVar, GoogleApiClient googleApiClient, Uri uri, int i) {
        super(googleApiClient);
        this.zza = uri;
        this.zzb = i;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    protected final /* bridge */ /* synthetic */ Result createFailedResult(Status status) {
        return new DataItemBuffer(DataHolder.empty(status.getStatusCode()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzft) ((zzjj) anyClient).getService()).zzq(new zziu(this), this.zza, this.zzb);
    }
}
