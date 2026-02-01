package com.samsung.android.sdk.internal.healthdata;

import android.os.Parcel;
import android.os.Parcelable;
import com.samsung.android.sdk.healthdata.HealthDataResolver;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public final class DeleteRequestImpl implements Parcelable, HealthDataResolver.DeleteRequest {
    public static final Parcelable.Creator<DeleteRequestImpl> CREATOR = new a();
    private final String a;
    private final HealthDataResolver.Filter b;
    private List<String> c;
    private final String d;
    private final String e;
    private final long f;
    private final long g;

    static class a implements Parcelable.Creator<DeleteRequestImpl> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        public DeleteRequestImpl createFromParcel(Parcel parcel) {
            return new DeleteRequestImpl(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public DeleteRequestImpl[] newArray(int i) {
            return new DeleteRequestImpl[i];
        }
    }

    /* synthetic */ DeleteRequestImpl(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDataType() {
        return this.a;
    }

    public List<String> getDeviceUuids() {
        return this.c;
    }

    public HealthDataResolver.Filter getFilter() {
        return this.b;
    }

    public long getLocalTimeBegin() {
        return this.f;
    }

    public long getLocalTimeEnd() {
        return this.g;
    }

    public String getLocalTimeOffsetProperty() {
        return this.e;
    }

    public String getLocalTimeProperty() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeParcelable(this.b, 0);
        parcel.writeStringList(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeLong(this.f);
        parcel.writeLong(this.g);
    }

    public DeleteRequestImpl(String str, HealthDataResolver.Filter filter, List<String> list, String str2, String str3, Long l, Long l2) {
        this.a = str;
        this.b = filter;
        this.c = list;
        this.d = str2;
        this.e = str3;
        this.f = l.longValue();
        this.g = l2.longValue();
    }

    private DeleteRequestImpl(Parcel parcel) {
        this.c = null;
        this.a = parcel.readString();
        this.b = (HealthDataResolver.Filter) parcel.readParcelable(HealthDataResolver.Filter.class.getClassLoader());
        ArrayList arrayList = new ArrayList();
        this.c = arrayList;
        parcel.readStringList(arrayList);
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readLong();
        this.g = parcel.readLong();
    }
}
