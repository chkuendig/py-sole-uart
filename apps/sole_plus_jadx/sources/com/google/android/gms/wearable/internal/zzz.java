package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
final class zzz extends zzw {
    final /* synthetic */ String zza;
    final /* synthetic */ int zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzz(zzal zzalVar, GoogleApiClient googleApiClient, String str, int i) {
        super(googleApiClient);
        this.zza = str;
        this.zzb = i;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    protected final /* synthetic */ Result createFailedResult(Status status) {
        return new zzai(status, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzft) ((zzjj) anyClient).getService()).zzj(new zzio(this), this.zza, this.zzb);
    }
}
