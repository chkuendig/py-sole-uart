package com.samsung.android.sdk.internal.healthdata;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.samsung.android.sdk.healthdata.HealthDataResolver;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public final class ReadRequestImpl implements Parcelable, HealthDataResolver.ReadRequest {
    public static final Parcelable.Creator<ReadRequestImpl> CREATOR = new a();
    private final String a;
    private String b;
    private String c;
    private long d;
    private long e;
    private int f;
    private int g;
    private HealthDataResolver.Filter h;
    private List<Projection> i;
    private List<String> j;
    private byte k;
    private long l;
    private String m;
    private String n;
    private long o;
    private long p;

    static class a implements Parcelable.Creator<ReadRequestImpl> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        public ReadRequestImpl createFromParcel(Parcel parcel) {
            return new ReadRequestImpl(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ReadRequestImpl[] newArray(int i) {
            return new ReadRequestImpl[i];
        }
    }

    public ReadRequestImpl(String str) {
        this.i = null;
        this.j = null;
        this.a = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getCount() {
        return this.g;
    }

    public String getDataType() {
        return this.a;
    }

    public List<String> getDeviceUuids() {
        return this.j;
    }

    public long getEndTime() {
        return this.e;
    }

    public HealthDataResolver.Filter getFilter() {
        return this.h;
    }

    public long getLocalTimeBegin() {
        return this.o;
    }

    public long getLocalTimeEnd() {
        return this.p;
    }

    public String getLocalTimeOffsetProperty() {
        return this.n;
    }

    public String getLocalTimeProperty() {
        return this.m;
    }

    public int getOffset() {
        return this.f;
    }

    public String getPackageName() {
        return this.c;
    }

    public List<Projection> getProjections() {
        return this.i;
    }

    public String getSortOrder() {
        return this.b;
    }

    public long getStartTime() {
        return this.d;
    }

    public long getTimeAfter() {
        return this.l;
    }

    public byte isAliasOnly() {
        return this.k;
    }

    public boolean isEmpty() {
        return this.h == null && TextUtils.isEmpty(this.b);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeLong(this.d);
        parcel.writeLong(this.e);
        parcel.writeInt(this.f);
        parcel.writeInt(this.g);
        parcel.writeParcelable(this.h, 0);
        parcel.writeTypedList(this.i);
        parcel.writeStringList(this.j);
        parcel.writeByte(this.k);
        parcel.writeLong(this.l);
        parcel.writeString(this.m);
        parcel.writeString(this.n);
        parcel.writeLong(this.o);
        parcel.writeLong(this.p);
    }

    public static class Projection implements Parcelable {
        public static final Parcelable.Creator<Projection> CREATOR = new a();
        final String a;
        String b;

        static class a implements Parcelable.Creator<Projection> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            public Projection createFromParcel(Parcel parcel) {
                return new Projection(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public Projection[] newArray(int i) {
                return new Projection[i];
            }
        }

        public Projection(String str, String str2) {
            if (str == null || str.isEmpty()) {
                throw new IllegalArgumentException("Null or empty property for read request is not allowed");
            }
            this.a = str;
            this.b = str2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getAlias() {
            return this.b;
        }

        public String getProperty() {
            return this.a;
        }

        public void setAlias(String str) {
            this.b = str;
        }

        public String toString() {
            return this.a;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.a);
            parcel.writeString(this.b);
        }

        public Projection(Parcel parcel) {
            this.a = parcel.readString();
            this.b = parcel.readString();
        }
    }

    public ReadRequestImpl(String str, String str2, HealthDataResolver.Filter filter, List<Projection> list, List<String> list2, byte b, String str3, long j, long j2, int i, int i2, long j3, String str4, String str5, Long l, Long l2) {
        this.a = str;
        this.c = str2;
        this.b = str3;
        this.d = j;
        this.e = j2;
        this.f = i;
        this.g = i2;
        this.h = filter;
        this.i = list;
        this.j = list2;
        this.k = b;
        this.l = j3;
        this.m = str4;
        this.n = str5;
        this.o = l.longValue();
        this.p = l2.longValue();
    }

    public ReadRequestImpl(Parcel parcel) {
        this.i = null;
        this.j = null;
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readLong();
        this.e = parcel.readLong();
        this.f = parcel.readInt();
        this.g = parcel.readInt();
        this.h = (HealthDataResolver.Filter) parcel.readParcelable(HealthDataResolver.Filter.class.getClassLoader());
        this.i = parcel.createTypedArrayList(Projection.CREATOR);
        ArrayList arrayList = new ArrayList();
        this.j = arrayList;
        parcel.readStringList(arrayList);
        this.k = parcel.readByte();
        this.l = parcel.readLong();
        this.m = parcel.readString();
        this.n = parcel.readString();
        this.o = parcel.readLong();
        this.p = parcel.readLong();
    }
}
