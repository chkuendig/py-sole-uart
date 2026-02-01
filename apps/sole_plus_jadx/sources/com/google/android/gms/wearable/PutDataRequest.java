package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.wearable.internal.DataItemAssetParcelable;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public class PutDataRequest extends AbstractSafeParcelable {
    public static final String WEAR_URI_SCHEME = "wear";
    private final Uri zzc;
    private final Bundle zzd;
    private byte[] zze;
    private long zzf;
    public static final Parcelable.Creator<PutDataRequest> CREATOR = new zzl();
    private static final long zza = TimeUnit.MINUTES.toMillis(30);
    private static final Random zzb = new SecureRandom();

    private PutDataRequest(Uri uri) {
        this(uri, new Bundle(), null, zza);
    }

    public static PutDataRequest create(String str) {
        Preconditions.checkNotNull(str, "path must not be null");
        return zza(zzb(str));
    }

    public static PutDataRequest createFromDataItem(DataItem dataItem) {
        Preconditions.checkNotNull(dataItem, "source must not be null");
        PutDataRequest putDataRequestZza = zza(dataItem.getUri());
        for (Map.Entry<String, DataItemAsset> entry : dataItem.getAssets().entrySet()) {
            if (entry.getValue().getId() == null) {
                throw new IllegalStateException("Cannot create an asset for a put request without a digest: ".concat(String.valueOf(entry.getKey())));
            }
            putDataRequestZza.putAsset(entry.getKey(), Asset.createFromRef(entry.getValue().getId()));
        }
        putDataRequestZza.setData(dataItem.getData());
        return putDataRequestZza;
    }

    public static PutDataRequest createWithAutoAppendedId(String str) {
        Preconditions.checkNotNull(str, "pathPrefix must not be null");
        StringBuilder sb = new StringBuilder(str);
        if (!str.endsWith("/")) {
            sb.append("/");
        }
        sb.append("PN");
        sb.append(zzb.nextLong());
        return new PutDataRequest(zzb(sb.toString()));
    }

    public static PutDataRequest zza(Uri uri) {
        Preconditions.checkNotNull(uri, "uri must not be null");
        return new PutDataRequest(uri);
    }

    private static Uri zzb(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("An empty path was supplied.");
        }
        if (!str.startsWith("/")) {
            throw new IllegalArgumentException("A path must start with a single / .");
        }
        if (str.startsWith("//")) {
            throw new IllegalArgumentException("A path must start with a single / .");
        }
        return new Uri.Builder().scheme(WEAR_URI_SCHEME).path(str).build();
    }

    public Asset getAsset(String str) {
        Preconditions.checkNotNull(str, "key must not be null");
        return (Asset) this.zzd.getParcelable(str);
    }

    public Map<String, Asset> getAssets() {
        HashMap map = new HashMap();
        for (String str : this.zzd.keySet()) {
            map.put(str, (Asset) this.zzd.getParcelable(str));
        }
        return Collections.unmodifiableMap(map);
    }

    @Pure
    public byte[] getData() {
        return this.zze;
    }

    public Uri getUri() {
        return this.zzc;
    }

    public boolean hasAsset(String str) {
        Preconditions.checkNotNull(str, "key must not be null");
        return this.zzd.containsKey(str);
    }

    public boolean isUrgent() {
        return this.zzf == 0;
    }

    public PutDataRequest putAsset(String str, Asset asset) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(asset);
        this.zzd.putParcelable(str, asset);
        return this;
    }

    public PutDataRequest removeAsset(String str) {
        Preconditions.checkNotNull(str, "key must not be null");
        this.zzd.remove(str);
        return this;
    }

    public PutDataRequest setData(byte[] bArr) {
        this.zze = bArr;
        return this;
    }

    public PutDataRequest setUrgent() {
        this.zzf = 0L;
        return this;
    }

    public String toString() {
        return toString(Log.isLoggable(DataMap.TAG, 3));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Preconditions.checkNotNull(parcel, "dest must not be null");
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, getUri(), i, false);
        SafeParcelWriter.writeBundle(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeByteArray(parcel, 5, getData(), false);
        SafeParcelWriter.writeLong(parcel, 6, this.zzf);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    PutDataRequest(Uri uri, Bundle bundle, byte[] bArr, long j) {
        this.zzc = uri;
        this.zzd = bundle;
        bundle.setClassLoader((ClassLoader) Preconditions.checkNotNull(DataItemAssetParcelable.class.getClassLoader()));
        this.zze = bArr;
        this.zzf = j;
    }

    public String toString(boolean z) {
        StringBuilder sb = new StringBuilder("PutDataRequest[");
        byte[] bArr = this.zze;
        sb.append("dataSz=".concat((bArr == null ? AbstractJsonLexerKt.NULL : Integer.valueOf(bArr.length)).toString()));
        sb.append(", numAssets=" + this.zzd.size());
        sb.append(", uri=".concat(String.valueOf(String.valueOf(this.zzc))));
        sb.append(", syncDeadline=" + this.zzf);
        if (!z) {
            sb.append("]");
            return sb.toString();
        }
        sb.append("]\n  assets: ");
        for (String str : this.zzd.keySet()) {
            sb.append("\n    " + str + ": " + String.valueOf(this.zzd.getParcelable(str)));
        }
        sb.append("\n  ]");
        return sb.toString();
    }
}
