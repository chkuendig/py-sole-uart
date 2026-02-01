package com.google.android.gms.wearable;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.common.internal.Asserts;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public class PutDataMapRequest {
    private final PutDataRequest zza;
    private final DataMap zzb;

    private PutDataMapRequest(PutDataRequest putDataRequest, DataMap dataMap) {
        this.zza = putDataRequest;
        DataMap dataMap2 = new DataMap();
        this.zzb = dataMap2;
        if (dataMap != null) {
            dataMap2.putAll(dataMap);
        }
    }

    public static PutDataMapRequest create(String str) {
        Asserts.checkNotNull(str, "path must not be null");
        return new PutDataMapRequest(PutDataRequest.create(str), null);
    }

    public static PutDataMapRequest createFromDataMapItem(DataMapItem dataMapItem) {
        Asserts.checkNotNull(dataMapItem, "source must not be null");
        return new PutDataMapRequest(PutDataRequest.zza(dataMapItem.getUri()), dataMapItem.getDataMap());
    }

    public static PutDataMapRequest createWithAutoAppendedId(String str) {
        Asserts.checkNotNull(str, "pathPrefix must not be null");
        return new PutDataMapRequest(PutDataRequest.createWithAutoAppendedId(str), null);
    }

    public PutDataRequest asPutDataRequest() {
        com.google.android.gms.internal.wearable.zzk zzkVarZzb = com.google.android.gms.internal.wearable.zzl.zzb(this.zzb);
        this.zza.setData(zzkVarZzb.zza.zzK());
        int size = zzkVarZzb.zzb.size();
        for (int i = 0; i < size; i++) {
            String string = Integer.toString(i);
            Asset asset = (Asset) zzkVarZzb.zzb.get(i);
            if (string == null) {
                throw new IllegalStateException("asset key cannot be null: ".concat(String.valueOf(String.valueOf(asset))));
            }
            if (asset == null) {
                throw new IllegalStateException("asset cannot be null: key=".concat(string));
            }
            if (Log.isLoggable(DataMap.TAG, 3)) {
                Log.d(DataMap.TAG, "asPutDataRequest: adding asset: " + string + " " + asset.toString());
            }
            this.zza.putAsset(string, asset);
        }
        return this.zza;
    }

    public DataMap getDataMap() {
        return this.zzb;
    }

    public Uri getUri() {
        return this.zza.getUri();
    }

    public boolean isUrgent() {
        return this.zza.isUrgent();
    }

    public PutDataMapRequest setUrgent() {
        this.zza.setUrgent();
        return this;
    }
}
