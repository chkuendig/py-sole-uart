package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.HashMap;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzdq extends DataBufferRef implements DataItem {
    private final int zza;

    public zzdq(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.zza = i2;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* synthetic */ DataItem freeze() {
        return new zzdn(this);
    }

    @Override // com.google.android.gms.wearable.DataItem
    public final Map<String, DataItemAsset> getAssets() {
        HashMap map = new HashMap(this.zza);
        for (int i = 0; i < this.zza; i++) {
            zzdm zzdmVar = new zzdm(this.mDataHolder, this.mDataRow + i);
            if (zzdmVar.getString("asset_key") != null) {
                map.put(zzdmVar.getString("asset_key"), zzdmVar);
            }
        }
        return map;
    }

    @Override // com.google.android.gms.wearable.DataItem
    public final byte[] getData() {
        return getByteArray("data");
    }

    @Override // com.google.android.gms.wearable.DataItem
    public final Uri getUri() {
        return Uri.parse(getString("path"));
    }

    @Override // com.google.android.gms.wearable.DataItem
    public final DataItem setData(byte[] bArr) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        boolean zIsLoggable = Log.isLoggable("DataItem", 3);
        byte[] byteArray = getByteArray("data");
        Map<String, DataItemAsset> assets = getAssets();
        StringBuilder sb = new StringBuilder("DataItemRef{ ");
        sb.append("uri=".concat(String.valueOf(String.valueOf(getUri()))));
        sb.append(", dataSz=".concat((byteArray == null ? AbstractJsonLexerKt.NULL : Integer.valueOf(byteArray.length)).toString()));
        sb.append(", numAssets=" + assets.size());
        if (zIsLoggable && !assets.isEmpty()) {
            sb.append(", assets=[");
            String str = "";
            for (Map.Entry<String, DataItemAsset> entry : assets.entrySet()) {
                sb.append(str + entry.getKey() + ": " + entry.getValue().getId());
                str = ", ";
            }
            sb.append("]");
        }
        sb.append(" }");
        return sb.toString();
    }
}
