package com.google.android.gms.wearable;

import android.net.Uri;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.internal.wearable.zzbu;
import com.google.android.gms.internal.wearable.zzcq;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public class DataMapItem {
    private final Uri zza;
    private final DataMap zzb;

    private DataMapItem(DataItem dataItem) {
        DataMap dataMapZza;
        this.zza = dataItem.getUri();
        DataItem dataItemFreeze = dataItem.freeze();
        byte[] data = dataItemFreeze.getData();
        if (data == null && !dataItemFreeze.getAssets().isEmpty()) {
            throw new IllegalArgumentException("Cannot create DataMapItem from a DataItem  that wasn't made with DataMapItem.");
        }
        if (data == null) {
            dataMapZza = new DataMap();
        } else {
            try {
                ArrayList arrayList = new ArrayList();
                int size = dataItemFreeze.getAssets().size();
                for (int i = 0; i < size; i++) {
                    DataItemAsset dataItemAsset = dataItemFreeze.getAssets().get(Integer.toString(i));
                    if (dataItemAsset == null) {
                        throw new IllegalStateException("Cannot find DataItemAsset referenced in data at " + i + " for " + dataItemFreeze.toString());
                    }
                    arrayList.add(Asset.createFromRef(dataItemAsset.getId()));
                }
                dataMapZza = com.google.android.gms.internal.wearable.zzl.zza(new com.google.android.gms.internal.wearable.zzk(com.google.android.gms.internal.wearable.zzx.zzd(data, zzbu.zza()), arrayList));
            } catch (zzcq | NullPointerException e) {
                Log.w("DataItem", "Unable to parse datamap from dataItem. uri=" + String.valueOf(dataItemFreeze.getUri()) + ", data=" + Base64.encodeToString(data, 0));
                throw new IllegalStateException("Unable to parse datamap from dataItem.  uri=".concat(String.valueOf(String.valueOf(dataItemFreeze.getUri()))), e);
            }
        }
        this.zzb = dataMapZza;
    }

    public static DataMapItem fromDataItem(DataItem dataItem) {
        Asserts.checkNotNull(dataItem, "dataItem must not be null");
        return new DataMapItem(dataItem);
    }

    public DataMap getDataMap() {
        return this.zzb;
    }

    public Uri getUri() {
        return this.zza;
    }
}
