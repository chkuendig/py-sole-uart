package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
final class zze extends zzw {
    private Object zza;
    private ListenerHolder zzb;
    private final zzd zzc;

    private zze(GoogleApiClient googleApiClient, Object obj, ListenerHolder listenerHolder, zzd zzdVar) {
        super(googleApiClient);
        this.zza = Preconditions.checkNotNull(obj);
        this.zzb = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
        this.zzc = (zzd) Preconditions.checkNotNull(zzdVar);
    }

    static PendingResult zza(GoogleApiClient googleApiClient, zzd zzdVar, Object obj) {
        return googleApiClient.enqueue(new zze(googleApiClient, obj, googleApiClient.registerListener(obj), zzdVar));
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    protected final /* synthetic */ Result createFailedResult(Status status) {
        this.zza = null;
        this.zzb = null;
        return status;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        this.zzc.zza((zzjj) anyClient, this, this.zza, this.zzb);
        this.zza = null;
        this.zzb = null;
    }
}
