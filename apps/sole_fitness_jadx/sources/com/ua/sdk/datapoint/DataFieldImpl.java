package com.ua.sdk.datapoint;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class DataFieldImpl implements DataField {
    public static Parcelable.Creator<DataFieldImpl> CREATOR = new Parcelable.Creator<DataFieldImpl>() { // from class: com.ua.sdk.datapoint.DataFieldImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DataFieldImpl createFromParcel(Parcel parcel) {
            return new DataFieldImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DataFieldImpl[] newArray(int i) {
            return new DataFieldImpl[i];
        }
    };
    private DataUnits dataUnits;
    private String id;
    private String type;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public DataFieldImpl() {
    }

    public DataFieldImpl(String str, String str2, DataUnits dataUnits) {
        this.id = str;
        this.type = str2;
        this.dataUnits = dataUnits;
    }

    private DataFieldImpl(Parcel parcel) {
        this.id = parcel.readString();
        this.type = parcel.readString();
        this.dataUnits = (DataUnits) parcel.readValue(DataUnits.class.getClassLoader());
    }

    @Override // com.ua.sdk.datapoint.DataField
    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    @Override // com.ua.sdk.datapoint.DataField
    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    @Override // com.ua.sdk.datapoint.DataField
    public DataUnits getUnits() {
        return this.dataUnits;
    }

    public void setUnits(DataUnits dataUnits) {
        this.dataUnits = dataUnits;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.id.equals(((DataFieldImpl) obj).id);
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.type);
        parcel.writeValue(this.dataUnits);
    }
}
