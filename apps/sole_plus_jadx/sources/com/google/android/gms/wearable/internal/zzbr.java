package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.wearable.ChannelApi;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
final class zzbr implements zzd {
    final /* synthetic */ String zza;
    final /* synthetic */ IntentFilter[] zzb;

    zzbr(String str, IntentFilter[] intentFilterArr) {
        this.zza = str;
        this.zzb = intentFilterArr;
    }

    @Override // com.google.android.gms.wearable.internal.zzd
    public final /* bridge */ /* synthetic */ void zza(zzjj zzjjVar, BaseImplementation.ResultHolder resultHolder, Object obj, ListenerHolder listenerHolder) throws RemoteException {
        zzjjVar.zzq(resultHolder, (ChannelApi.ChannelListener) obj, listenerHolder, this.zza, this.zzb);
    }
}
