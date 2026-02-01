package com.google.android.gms.wearable;

import android.net.Uri;
import com.google.android.gms.common.data.Freezable;
import java.util.Map;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public interface DataItem extends Freezable<DataItem> {
    Map<String, DataItemAsset> getAssets();

    @Pure
    byte[] getData();

    Uri getUri();

    DataItem setData(byte[] bArr);
}
