package com.ua.sdk.datasourceidentifier;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.device.Device;

/* loaded from: classes2.dex */
public class DataSourceIdentifierBuilderImpl implements DataSourceIdentifierBuilder {
    public static final Parcelable.Creator<DataSourceIdentifierBuilderImpl> CREATOR = new Parcelable.Creator<DataSourceIdentifierBuilderImpl>() { // from class: com.ua.sdk.datasourceidentifier.DataSourceIdentifierBuilderImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DataSourceIdentifierBuilderImpl createFromParcel(Parcel parcel) {
            return new DataSourceIdentifierBuilderImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DataSourceIdentifierBuilderImpl[] newArray(int i) {
            return new DataSourceIdentifierBuilderImpl[i];
        }
    };
    Device device;
    String name;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ua.sdk.datasourceidentifier.DataSourceIdentifierBuilder
    public DataSourceIdentifierBuilder setName(String str) {
        this.name = str;
        return this;
    }

    @Override // com.ua.sdk.datasourceidentifier.DataSourceIdentifierBuilder
    public DataSourceIdentifierBuilder setDevice(Device device) {
        this.device = device;
        return this;
    }

    @Override // com.ua.sdk.datasourceidentifier.DataSourceIdentifierBuilder
    public DataSourceIdentifier build() {
        if (this.name == null) {
            throw new IllegalArgumentException("A name must be set!");
        }
        if (this.device == null) {
            throw new IllegalArgumentException("A device must be set!");
        }
        return new DataSourceIdentifierImpl(this.device, this.name);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeParcelable(this.device, i);
    }

    public DataSourceIdentifierBuilderImpl() {
    }

    private DataSourceIdentifierBuilderImpl(Parcel parcel) {
        this.name = parcel.readString();
        this.device = (Device) parcel.readParcelable(Device.class.getClassLoader());
    }
}
