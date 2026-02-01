package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.PutDataRequest;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzcz implements DataApi {
    @Override // com.google.android.gms.wearable.DataApi
    public final PendingResult<Status> addListener(GoogleApiClient googleApiClient, DataApi.DataListener dataListener) {
        return zze.zza(googleApiClient, new zzcu(new IntentFilter[]{zzih.zza("com.google.android.gms.wearable.DATA_CHANGED")}), dataListener);
    }

    @Override // com.google.android.gms.wearable.DataApi
    public final PendingResult<DataApi.DeleteDataItemsResult> deleteDataItems(GoogleApiClient googleApiClient, Uri uri) {
        return deleteDataItems(googleApiClient, uri, 0);
    }

    @Override // com.google.android.gms.wearable.DataApi
    public final PendingResult<DataApi.DataItemResult> getDataItem(GoogleApiClient googleApiClient, Uri uri) {
        return googleApiClient.enqueue(new zzco(this, googleApiClient, uri));
    }

    @Override // com.google.android.gms.wearable.DataApi
    public final PendingResult<DataItemBuffer> getDataItems(GoogleApiClient googleApiClient) {
        return googleApiClient.enqueue(new zzcp(this, googleApiClient));
    }

    @Override // com.google.android.gms.wearable.DataApi
    public final PendingResult<DataApi.DataItemResult> putDataItem(GoogleApiClient googleApiClient, PutDataRequest putDataRequest) {
        return googleApiClient.enqueue(new zzcn(this, googleApiClient, putDataRequest));
    }

    @Override // com.google.android.gms.wearable.DataApi
    public final PendingResult<Status> removeListener(GoogleApiClient googleApiClient, DataApi.DataListener dataListener) {
        return googleApiClient.enqueue(new zzcv(this, googleApiClient, dataListener));
    }

    @Override // com.google.android.gms.wearable.DataApi
    public final PendingResult<DataApi.DeleteDataItemsResult> deleteDataItems(GoogleApiClient googleApiClient, Uri uri, int i) {
        Asserts.checkNotNull(uri, "uri must not be null");
        boolean z = true;
        if (i != 0) {
            if (i == 1) {
                i = 1;
            } else {
                z = false;
            }
        }
        Preconditions.checkArgument(z, "invalid filter type");
        return googleApiClient.enqueue(new zzcr(this, googleApiClient, uri, i));
    }

    @Override // com.google.android.gms.wearable.DataApi
    public final PendingResult<DataItemBuffer> getDataItems(GoogleApiClient googleApiClient, Uri uri) {
        return getDataItems(googleApiClient, uri, 0);
    }

    @Override // com.google.android.gms.wearable.DataApi
    public final PendingResult<DataApi.GetFdForAssetResult> getFdForAsset(GoogleApiClient googleApiClient, Asset asset) {
        if (asset == null) {
            throw new IllegalArgumentException("asset is null");
        }
        if (asset.getDigest() == null) {
            throw new IllegalArgumentException("invalid asset");
        }
        if (asset.zza() == null) {
            return googleApiClient.enqueue(new zzcs(this, googleApiClient, asset));
        }
        throw new IllegalArgumentException("invalid asset");
    }

    @Override // com.google.android.gms.wearable.DataApi
    public final PendingResult<Status> addListener(GoogleApiClient googleApiClient, DataApi.DataListener dataListener, Uri uri, int i) {
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
        return zze.zza(googleApiClient, new zzcu(new IntentFilter[]{zzih.zzb("com.google.android.gms.wearable.DATA_CHANGED", uri, i)}), dataListener);
    }

    @Override // com.google.android.gms.wearable.DataApi
    public final PendingResult<DataItemBuffer> getDataItems(GoogleApiClient googleApiClient, Uri uri, int i) {
        Asserts.checkNotNull(uri, "uri must not be null");
        boolean z = true;
        if (i != 0) {
            if (i == 1) {
                i = 1;
            } else {
                z = false;
            }
        }
        Preconditions.checkArgument(z, "invalid filter type");
        return googleApiClient.enqueue(new zzcq(this, googleApiClient, uri, i));
    }

    @Override // com.google.android.gms.wearable.DataApi
    public final PendingResult<DataApi.GetFdForAssetResult> getFdForAsset(GoogleApiClient googleApiClient, DataItemAsset dataItemAsset) {
        return googleApiClient.enqueue(new zzct(this, googleApiClient, dataItemAsset));
    }
}
