package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.MessageApi;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
final class zzgb extends zzw {
    private MessageApi.MessageListener zza;
    private ListenerHolder zzb;
    private IntentFilter[] zzc;

    /* synthetic */ zzgb(GoogleApiClient googleApiClient, MessageApi.MessageListener messageListener, ListenerHolder listenerHolder, IntentFilter[] intentFilterArr, zzga zzgaVar) {
        super(googleApiClient);
        this.zza = (MessageApi.MessageListener) Preconditions.checkNotNull(messageListener);
        this.zzb = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
        this.zzc = (IntentFilter[]) Preconditions.checkNotNull(intentFilterArr);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* bridge */ /* synthetic */ Result createFailedResult(Status status) {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        return status;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzjj) anyClient).zzs(this, (MessageApi.MessageListener) Preconditions.checkNotNull(this.zza), (ListenerHolder) Preconditions.checkNotNull(this.zzb), (IntentFilter[]) Preconditions.checkNotNull(this.zzc));
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
    }
}
