package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzdn implements DataItem {
    private final Uri zza;
    private final byte[] zzb;
    private final Map zzc;

    public zzdn(DataItem dataItem) {
        this.zza = dataItem.getUri();
        this.zzb = dataItem.getData();
        HashMap map = new HashMap();
        for (Map.Entry<String, DataItemAsset> entry : dataItem.getAssets().entrySet()) {
            if (entry.getKey() != null) {
                map.put(entry.getKey(), entry.getValue().freeze());
            }
        }
        this.zzc = Collections.unmodifiableMap(map);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* bridge */ /* synthetic */ DataItem freeze() {
        return this;
    }

    @Override // com.google.android.gms.wearable.DataItem
    public final Map<String, DataItemAsset> getAssets() {
        return this.zzc;
    }

    @Override // com.google.android.gms.wearable.DataItem
    public final byte[] getData() {
        return this.zzb;
    }

    @Override // com.google.android.gms.wearable.DataItem
    public final Uri getUri() {
        return this.zza;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    @Override // com.google.android.gms.wearable.DataItem
    public final DataItem setData(byte[] bArr) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        boolean zIsLoggable = Log.isLoggable("DataItem", 3);
        StringBuilder sb = new StringBuilder("DataItemEntity{ ");
        sb.append("uri=".concat(String.valueOf(String.valueOf(this.zza))));
        byte[] bArr = this.zzb;
        sb.append(", dataSz=".concat((bArr == null ? AbstractJsonLexerKt.NULL : Integer.valueOf(bArr.length)).toString()));
        sb.append(", numAssets=" + this.zzc.size());
        if (zIsLoggable && !this.zzc.isEmpty()) {
            sb.append(", assets=[");
            String str = "";
            for (Map.Entry entry : this.zzc.entrySet()) {
                sb.append(str + ((String) entry.getKey()) + ": " + ((DataItemAsset) entry.getValue()).getId());
                str = ", ";
            }
            sb.append("]");
        }
        sb.append(" }");
        return sb.toString();
    }
}
