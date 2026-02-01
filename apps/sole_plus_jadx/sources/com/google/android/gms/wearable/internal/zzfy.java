package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
final class zzfy extends zzw {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ byte[] zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzfy(zzgd zzgdVar, GoogleApiClient googleApiClient, String str, String str2, byte[] bArr) {
        super(googleApiClient);
        this.zza = str;
        this.zzb = str2;
        this.zzc = bArr;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    protected final /* bridge */ /* synthetic */ Result createFailedResult(Status status) {
        return new zzgc(status, -1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzft) ((zzjj) anyClient).getService()).zzz(new zzjc(this), this.zza, this.zzb, this.zzc);
    }
}
