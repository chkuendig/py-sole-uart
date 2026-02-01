package com.google.android.gms.wearable.internal;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataClient;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.PutDataRequest;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzdh extends DataClient {
    public static final /* synthetic */ int zza = 0;
    private final DataApi zzb;

    public zzdh(Activity activity, GoogleApi.Settings settings) {
        super(activity, settings);
        this.zzb = new zzcz();
    }

    private final Task zza(final DataClient.OnDataChangedListener onDataChangedListener, final IntentFilter[] intentFilterArr) {
        final ListenerHolder listenerHolderCreateListenerHolder = ListenerHolders.createListenerHolder(onDataChangedListener, getLooper(), "DataListener");
        return doRegisterEventListener(RegistrationMethods.builder().withHolder(listenerHolderCreateListenerHolder).register(new RemoteCall() { // from class: com.google.android.gms.wearable.internal.zzde
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                DataClient.OnDataChangedListener onDataChangedListener2 = onDataChangedListener;
                ListenerHolder listenerHolder = listenerHolderCreateListenerHolder;
                IntentFilter[] intentFilterArr2 = intentFilterArr;
                int i = zzdh.zza;
                ((zzjj) obj).zzr(new zzif((TaskCompletionSource) obj2), onDataChangedListener2, listenerHolder, intentFilterArr2);
            }
        }).unregister(new RemoteCall() { // from class: com.google.android.gms.wearable.internal.zzdf
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                DataClient.OnDataChangedListener onDataChangedListener2 = onDataChangedListener;
                int i = zzdh.zza;
                ((zzjj) obj).zzz(new zzie((TaskCompletionSource) obj2), onDataChangedListener2);
            }
        }).setMethodKey(24015).build());
    }

    @Override // com.google.android.gms.wearable.DataClient
    public final Task<Void> addListener(DataClient.OnDataChangedListener onDataChangedListener) {
        return zza(onDataChangedListener, new IntentFilter[]{zzih.zza("com.google.android.gms.wearable.DATA_CHANGED")});
    }

    @Override // com.google.android.gms.wearable.DataClient
    public final Task<Integer> deleteDataItems(Uri uri) {
        return PendingResultUtil.toTask(((zzcz) this.zzb).deleteDataItems(asGoogleApiClient(), uri, 0), zzdb.zza);
    }

    @Override // com.google.android.gms.wearable.DataClient
    public final Task<DataItem> getDataItem(Uri uri) {
        DataApi dataApi = this.zzb;
        GoogleApiClient googleApiClientAsGoogleApiClient = asGoogleApiClient();
        return PendingResultUtil.toTask(googleApiClientAsGoogleApiClient.enqueue(new zzco((zzcz) dataApi, googleApiClientAsGoogleApiClient, uri)), zzda.zza);
    }

    @Override // com.google.android.gms.wearable.DataClient
    public final Task<DataItemBuffer> getDataItems() {
        DataApi dataApi = this.zzb;
        GoogleApiClient googleApiClientAsGoogleApiClient = asGoogleApiClient();
        return PendingResultUtil.toTask(googleApiClientAsGoogleApiClient.enqueue(new zzcp((zzcz) dataApi, googleApiClientAsGoogleApiClient)), zzdc.zza);
    }

    @Override // com.google.android.gms.wearable.DataClient
    public final Task<DataClient.GetFdForAssetResponse> getFdForAsset(Asset asset) {
        DataApi dataApi = this.zzb;
        GoogleApiClient googleApiClientAsGoogleApiClient = asGoogleApiClient();
        if (asset == null) {
            throw new IllegalArgumentException("asset is null");
        }
        if (asset.getDigest() == null) {
            throw new IllegalArgumentException("invalid asset");
        }
        if (asset.zza() == null) {
            return PendingResultUtil.toTask(googleApiClientAsGoogleApiClient.enqueue(new zzcs((zzcz) dataApi, googleApiClientAsGoogleApiClient, asset)), zzdd.zza);
        }
        throw new IllegalArgumentException("invalid asset");
    }

    @Override // com.google.android.gms.wearable.DataClient
    public final Task<DataItem> putDataItem(PutDataRequest putDataRequest) {
        DataApi dataApi = this.zzb;
        GoogleApiClient googleApiClientAsGoogleApiClient = asGoogleApiClient();
        return PendingResultUtil.toTask(googleApiClientAsGoogleApiClient.enqueue(new zzcn((zzcz) dataApi, googleApiClientAsGoogleApiClient, putDataRequest)), zzda.zza);
    }

    @Override // com.google.android.gms.wearable.DataClient
    public final Task<Boolean> removeListener(DataClient.OnDataChangedListener onDataChangedListener) {
        return doUnregisterEventListener((ListenerHolder.ListenerKey) Preconditions.checkNotNull(ListenerHolders.createListenerHolder(onDataChangedListener, getLooper(), "DataListener").getListenerKey(), "Key must not be null"), 24005);
    }

    public zzdh(Context context, GoogleApi.Settings settings) {
        super(context, settings);
        this.zzb = new zzcz();
    }

    @Override // com.google.android.gms.wearable.DataClient
    public final Task<Void> addListener(DataClient.OnDataChangedListener onDataChangedListener, Uri uri, int i) {
        boolean z;
        Asserts.checkNotNull(uri, "uri must not be null");
        if (i == 0) {
            z = true;
        } else if (i == 1) {
            i = 1;
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "invalid filter type");
        return zza(onDataChangedListener, new IntentFilter[]{zzih.zzb("com.google.android.gms.wearable.DATA_CHANGED", uri, i)});
    }

    @Override // com.google.android.gms.wearable.DataClient
    public final Task<DataItemBuffer> getDataItems(Uri uri) {
        return PendingResultUtil.toTask(((zzcz) this.zzb).getDataItems(asGoogleApiClient(), uri, 0), zzdc.zza);
    }

    @Override // com.google.android.gms.wearable.DataClient
    public final Task<Integer> deleteDataItems(Uri uri, int i) {
        return PendingResultUtil.toTask(this.zzb.deleteDataItems(asGoogleApiClient(), uri, i), zzdb.zza);
    }

    @Override // com.google.android.gms.wearable.DataClient
    public final Task<DataItemBuffer> getDataItems(Uri uri, int i) {
        return PendingResultUtil.toTask(this.zzb.getDataItems(asGoogleApiClient(), uri, i), zzdc.zza);
    }

    @Override // com.google.android.gms.wearable.DataClient
    public final Task<DataClient.GetFdForAssetResponse> getFdForAsset(DataItemAsset dataItemAsset) {
        DataApi dataApi = this.zzb;
        GoogleApiClient googleApiClientAsGoogleApiClient = asGoogleApiClient();
        return PendingResultUtil.toTask(googleApiClientAsGoogleApiClient.enqueue(new zzct((zzcz) dataApi, googleApiClientAsGoogleApiClient, dataItemAsset)), zzdd.zza);
    }
}
