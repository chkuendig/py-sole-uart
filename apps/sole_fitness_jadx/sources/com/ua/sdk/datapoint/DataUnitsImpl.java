package com.ua.sdk.datapoint;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class DataUnitsImpl implements DataUnits {
    public static Parcelable.Creator<DataUnitsImpl> CREATOR = new Parcelable.Creator<DataUnitsImpl>() { // from class: com.ua.sdk.datapoint.DataUnitsImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DataUnitsImpl createFromParcel(Parcel parcel) {
            return new DataUnitsImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DataUnitsImpl[] newArray(int i) {
            return new DataUnitsImpl[i];
        }
    };
    private String name;
    private String symbol;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public DataUnitsImpl(String str, String str2) {
        this.name = str;
        this.symbol = str2;
    }

    private DataUnitsImpl(Parcel parcel) {
        this.name = parcel.readString();
        this.symbol = parcel.readString();
    }

    @Override // com.ua.sdk.datapoint.DataUnits
    public String getSymbol() {
        return this.symbol;
    }

    @Override // com.ua.sdk.datapoint.DataUnits
    public String getName() {
        return this.name;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.name.equals(((DataUnitsImpl) obj).name);
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.symbol);
    }
}
