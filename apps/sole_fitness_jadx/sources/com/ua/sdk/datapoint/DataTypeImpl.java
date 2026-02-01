package com.ua.sdk.datapoint;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class DataTypeImpl implements DataType {
    public static Parcelable.Creator<DataTypeImpl> CREATOR = new Parcelable.Creator<DataTypeImpl>() { // from class: com.ua.sdk.datapoint.DataTypeImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DataTypeImpl createFromParcel(Parcel parcel) {
            return new DataTypeImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DataTypeImpl[] newArray(int i) {
            return new DataTypeImpl[i];
        }
    };
    private String description;
    private List<DataField> fields;
    private String id;
    private DataPeriod period;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public DataTypeImpl() {
    }

    public DataTypeImpl(String str, DataPeriod dataPeriod, String str2, List<DataField> list) {
        this.id = str;
        this.period = dataPeriod;
        this.description = str2;
        this.fields = list;
    }

    private DataTypeImpl(Parcel parcel) {
        this.id = parcel.readString();
        this.period = (DataPeriod) parcel.readValue(DataPeriod.class.getClassLoader());
        this.description = parcel.readString();
        ArrayList arrayList = new ArrayList();
        this.fields = arrayList;
        parcel.readList(arrayList, DataField.class.getClassLoader());
    }

    @Override // com.ua.sdk.datapoint.DataType
    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    @Override // com.ua.sdk.datapoint.DataType
    public DataPeriod getPeriod() {
        return this.period;
    }

    public void setPeriod(DataPeriod dataPeriod) {
        this.period = dataPeriod;
    }

    @Override // com.ua.sdk.datapoint.DataType
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    @Override // com.ua.sdk.datapoint.DataType
    public List<DataField> getFields() {
        return this.fields;
    }

    public void setFields(List<DataField> list) {
        this.fields = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.id.equals(((DataTypeImpl) obj).id);
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    @Override // com.ua.sdk.Resource
    public DataTypeRef getRef() {
        if (this.id == null) {
            return null;
        }
        return DataTypeRef.getBuilder().setId(this.id).build();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeValue(this.period);
        parcel.writeString(this.description);
        parcel.writeList(this.fields);
    }
}
