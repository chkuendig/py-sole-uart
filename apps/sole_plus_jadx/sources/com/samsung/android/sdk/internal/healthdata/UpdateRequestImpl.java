package com.samsung.android.sdk.internal.healthdata;

import android.os.Parcel;
import android.os.Parcelable;
import com.samsung.android.sdk.healthdata.HealthData;
import com.samsung.android.sdk.healthdata.HealthDataResolver;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public final class UpdateRequestImpl implements Parcelable, HealthDataResolver.UpdateRequest {
    public static final Parcelable.Creator<UpdateRequestImpl> CREATOR = new a();
    private final String a;
    private final HealthData b;
    private final HealthDataResolver.Filter c;
    private List<String> d;
    private final String e;
    private final String f;
    private final long g;
    private final long h;

    static class a implements Parcelable.Creator<UpdateRequestImpl> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        public UpdateRequestImpl createFromParcel(Parcel parcel) {
            return new UpdateRequestImpl(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public UpdateRequestImpl[] newArray(int i) {
            return new UpdateRequestImpl[i];
        }
    }

    public UpdateRequestImpl(String str, HealthData healthData, HealthDataResolver.Filter filter, List<String> list, String str2, String str3, Long l, Long l2) {
        this.a = str;
        this.b = healthData;
        this.c = filter;
        this.d = list;
        this.e = str2;
        this.f = str3;
        this.g = l.longValue();
        this.h = l2.longValue();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public HealthData getDataObject() {
        return this.b;
    }

    public String getDataType() {
        return this.a;
    }

    public List<String> getDeviceUuids() {
        return this.d;
    }

    public HealthDataResolver.Filter getFilter() {
        return this.c;
    }

    public long getLocalTimeBegin() {
        return this.g;
    }

    public long getLocalTimeEnd() {
        return this.h;
    }

    public String getLocalTimeOffsetProperty() {
        return this.f;
    }

    public String getLocalTimeProperty() {
        return this.e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeParcelable(this.b, 0);
        parcel.writeParcelable(this.c, 0);
        parcel.writeStringList(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeLong(this.g);
        parcel.writeLong(this.h);
    }

    public UpdateRequestImpl(Parcel parcel) {
        this.d = null;
        this.a = parcel.readString();
        this.b = (HealthData) parcel.readParcelable(HealthData.class.getClassLoader());
        this.c = (HealthDataResolver.Filter) parcel.readParcelable(HealthDataResolver.Filter.class.getClassLoader());
        ArrayList arrayList = new ArrayList();
        this.d = arrayList;
        parcel.readStringList(arrayList);
        this.e = parcel.readString();
        this.f = parcel.readString();
        this.g = parcel.readLong();
        this.h = parcel.readLong();
    }
}
