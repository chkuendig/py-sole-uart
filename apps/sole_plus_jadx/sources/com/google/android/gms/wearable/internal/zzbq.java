package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
final class zzbq extends zzw {
    final /* synthetic */ Uri zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ zzbu zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbq(zzbu zzbuVar, GoogleApiClient googleApiClient, Uri uri, long j, long j2) {
        super(googleApiClient);
        this.zzd = zzbuVar;
        this.zza = uri;
        this.zzb = j;
        this.zzc = j2;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* bridge */ /* synthetic */ Result createFailedResult(Status status) {
        return status;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzjj) anyClient).zzC(this, this.zzd.zza, this.zza, this.zzb, this.zzc);
    }
}
