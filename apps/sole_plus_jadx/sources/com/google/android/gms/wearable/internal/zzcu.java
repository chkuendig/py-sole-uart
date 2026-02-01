package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.wearable.DataApi;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
final class zzcu implements zzd {
    final /* synthetic */ IntentFilter[] zza;

    zzcu(IntentFilter[] intentFilterArr) {
        this.zza = intentFilterArr;
    }

    @Override // com.google.android.gms.wearable.internal.zzd
    public final /* synthetic */ void zza(zzjj zzjjVar, BaseImplementation.ResultHolder resultHolder, Object obj, ListenerHolder listenerHolder) throws RemoteException {
        zzjjVar.zzr(resultHolder, (DataApi.DataListener) obj, listenerHolder, this.zza);
    }
}
