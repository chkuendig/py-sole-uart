package com.samsung.android.sdk.internal.healthdata;

import android.os.Parcel;
import android.os.Parcelable;
import com.samsung.android.sdk.healthdata.HealthData;
import com.samsung.android.sdk.healthdata.HealthDataResolver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public final class InsertRequestImpl implements Parcelable, HealthDataResolver.InsertRequest {
    public static final Parcelable.Creator<InsertRequestImpl> CREATOR = new a();
    private final String a;
    private final List<HealthData> b;

    static class a implements Parcelable.Creator<InsertRequestImpl> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        public InsertRequestImpl createFromParcel(Parcel parcel) {
            return new InsertRequestImpl(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public InsertRequestImpl[] newArray(int i) {
            return new InsertRequestImpl[i];
        }
    }

    /* synthetic */ InsertRequestImpl(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void a(HealthData healthData) {
        if (healthData == null) {
            throw new IllegalArgumentException("data is null");
        }
        if (healthData.getSourceDevice() == null) {
            throw new IllegalArgumentException("source device is not set");
        }
    }

    @Override // com.samsung.android.sdk.healthdata.HealthDataResolver.InsertRequest
    public void addHealthData(HealthData healthData) {
        a(healthData);
        this.b.add(healthData);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDataType() {
        return this.a;
    }

    public final List<HealthData> getItems() {
        return this.b;
    }

    public boolean isEmpty() {
        return this.b.isEmpty();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeTypedList(this.b);
    }

    public InsertRequestImpl(String str) {
        this.a = str;
        this.b = new ArrayList();
    }

    @Override // com.samsung.android.sdk.healthdata.HealthDataResolver.InsertRequest
    public void addHealthData(List<HealthData> list) {
        if (list != null) {
            Iterator<HealthData> it = list.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
            this.b.addAll(list);
            return;
        }
        throw new IllegalArgumentException("data list is null");
    }

    private InsertRequestImpl(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.createTypedArrayList(HealthData.CREATOR);
    }
}
