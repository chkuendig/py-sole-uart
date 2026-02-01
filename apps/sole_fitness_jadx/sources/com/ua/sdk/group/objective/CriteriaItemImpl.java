package com.ua.sdk.group.objective;

import android.os.Parcel;

/* loaded from: classes2.dex */
public class CriteriaItemImpl implements CriteriaItem<Object> {
    String name;
    private Object value;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public CriteriaItemImpl() {
    }

    private CriteriaItemImpl(Parcel parcel) {
        this.value = parcel.readValue(Object.class.getClassLoader());
    }

    @Override // com.ua.sdk.group.objective.CriteriaItem
    public String getName() {
        return this.name;
    }

    @Override // com.ua.sdk.group.objective.CriteriaItem
    public Object getValue() {
        return this.value;
    }

    @Override // com.ua.sdk.group.objective.CriteriaItem
    public void setValue(Object obj) {
        this.value = obj;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.value);
    }
}
