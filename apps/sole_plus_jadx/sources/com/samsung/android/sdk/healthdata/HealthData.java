package com.samsung.android.sdk.healthdata;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.camera.video.AudioStats;
import com.samsung.android.sdk.internal.healthdata.StreamUtil;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* loaded from: classes5.dex */
public final class HealthData implements Parcelable {
    public static final Parcelable.Creator<HealthData> CREATOR = new a();
    private String a;
    private String b;
    private final ContentValues c;
    private final Map<String, byte[]> d;
    private final Map<String, InputStream> e;
    private IDataResolver f;
    private String g;
    private Object h;

    static class a implements Parcelable.Creator<HealthData> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        public HealthData createFromParcel(Parcel parcel) {
            return new HealthData(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public HealthData[] newArray(int i) {
            return new HealthData[i];
        }
    }

    /* synthetic */ HealthData(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void a() {
        UUID uuidRandomUUID = UUID.randomUUID();
        while (uuidRandomUUID.getMostSignificantBits() == 0 && uuidRandomUUID.getLeastSignificantBits() < 100) {
            uuidRandomUUID = UUID.randomUUID();
        }
        this.a = uuidRandomUUID.toString();
    }

    public void clear() {
        this.a = null;
        this.b = null;
        this.g = null;
        Object obj = this.h;
        if (obj != null) {
            obj.hashCode();
        }
        this.h = null;
        this.c.clear();
        this.d.clear();
        this.e.clear();
        a();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Object get(String str) {
        return this.c.get(str);
    }

    public byte[] getBlob(String str) {
        byte[] byteArray;
        byte[] bArr = this.d.get(str);
        if (bArr != null) {
            return (byte[]) bArr.clone();
        }
        if (this.f == null || this.g == null || !this.c.containsKey(str)) {
            return null;
        }
        return (!(this.c.get(str) instanceof String) || (byteArray = StreamUtil.getByteArray(this.f, this.g, this.c.getAsString(str))) == null) ? this.c.getAsByteArray(str) : byteArray;
    }

    public Set<String> getBlobKeySet() {
        return this.d.keySet();
    }

    public ContentValues getContentValues() {
        return this.c;
    }

    public double getDouble(String str) {
        Double asDouble = this.c.getAsDouble(str);
        return asDouble == null ? AudioStats.AUDIO_AMPLITUDE_NONE : asDouble.doubleValue();
    }

    public float getFloat(String str) {
        Float asFloat = this.c.getAsFloat(str);
        if (asFloat == null) {
            return 0.0f;
        }
        return asFloat.floatValue();
    }

    public InputStream getInputStream(String str) {
        InputStream inputStream = this.e.get(str);
        if (inputStream == null) {
            byte[] bArr = this.d.get(str);
            if (bArr != null) {
                return new ByteArrayInputStream((byte[]) bArr.clone());
            }
            if (this.g != null && this.c.containsKey(str) && (this.c.get(str) instanceof String)) {
                return StreamUtil.getInputStream(this.f, this.g, this.c.getAsString(str));
            }
        }
        return inputStream;
    }

    public Set<String> getInputStreamKeySet() {
        return this.e.keySet();
    }

    public int getInt(String str) {
        Integer asInteger = this.c.getAsInteger(str);
        if (asInteger == null) {
            return 0;
        }
        return asInteger.intValue();
    }

    public Set<String> getKeySet() {
        return this.c.keySet();
    }

    public long getLong(String str) {
        Long asLong = this.c.getAsLong(str);
        if (asLong == null) {
            return 0L;
        }
        return asLong.longValue();
    }

    public String getSourceDevice() {
        return this.b;
    }

    public String getString(String str) {
        return this.c.getAsString(str);
    }

    public String getUuid() {
        String str = this.a;
        if (str != null) {
            return str;
        }
        throw new UnsupportedOperationException("getUuid() is not allowed for read operation. use getString() instead.");
    }

    public void putBlob(String str, byte[] bArr) {
        if (bArr == null) {
            this.c.put(str, (byte[]) null);
        } else {
            this.c.put(str, UUID.randomUUID().toString().getBytes(Charset.forName("UTF-8")));
        }
        this.e.remove(str);
        this.d.put(str, bArr);
    }

    public void putDouble(String str, double d) {
        this.c.put(str, Double.valueOf(d));
    }

    public void putFloat(String str, float f) {
        this.c.put(str, Float.valueOf(f));
    }

    public void putInputStream(String str, InputStream inputStream) {
        if (inputStream == null) {
            this.c.put(str, (byte[]) null);
        } else {
            this.c.put(str, UUID.randomUUID().toString().getBytes(Charset.forName("UTF-8")));
        }
        this.d.remove(str);
        this.e.put(str, inputStream);
    }

    public void putInt(String str, int i) {
        this.c.put(str, Integer.valueOf(i));
    }

    public void putLong(String str, long j) {
        this.c.put(str, Long.valueOf(j));
    }

    public void putNull(String str) {
        this.c.putNull(str);
        this.d.put(str, null);
        this.e.put(str, null);
    }

    public void putString(String str, String str2) {
        this.c.put(str, str2);
        this.d.remove(str);
        this.e.remove(str);
    }

    public void remove(String str) {
        this.c.remove(str);
    }

    public void setSourceDevice(String str) {
        this.b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        this.c.writeToParcel(parcel, 0);
    }

    public HealthData() {
        this.d = new HashMap();
        this.e = new HashMap();
        this.c = new ContentValues();
        a();
    }

    HealthData(IDataResolver iDataResolver, String str, Object obj) {
        this.d = new HashMap();
        this.e = new HashMap();
        this.c = new ContentValues();
        this.f = iDataResolver;
        this.g = str;
        this.h = obj;
    }

    private HealthData(Parcel parcel) {
        this.d = new HashMap();
        this.e = new HashMap();
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = (ContentValues) ContentValues.CREATOR.createFromParcel(parcel);
    }
}
