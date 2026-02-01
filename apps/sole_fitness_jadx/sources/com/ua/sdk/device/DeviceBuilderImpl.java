package com.ua.sdk.device;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class DeviceBuilderImpl implements DeviceBuilder {
    public static final Parcelable.Creator<DeviceBuilderImpl> CREATOR = new Parcelable.Creator<DeviceBuilderImpl>() { // from class: com.ua.sdk.device.DeviceBuilderImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DeviceBuilderImpl createFromParcel(Parcel parcel) {
            return new DeviceBuilderImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DeviceBuilderImpl[] newArray(int i) {
            return new DeviceBuilderImpl[i];
        }
    };
    String description;
    String manufacturer;
    String model;
    String name;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ua.sdk.device.DeviceBuilder
    public DeviceBuilder setName(String str) {
        this.name = str;
        return this;
    }

    @Override // com.ua.sdk.device.DeviceBuilder
    public DeviceBuilder setModel(String str) {
        this.model = str;
        return this;
    }

    @Override // com.ua.sdk.device.DeviceBuilder
    public DeviceBuilder setDescription(String str) {
        this.description = str;
        return this;
    }

    @Override // com.ua.sdk.device.DeviceBuilder
    public DeviceBuilder setManufacturer(String str) {
        this.manufacturer = str;
        return this;
    }

    @Override // com.ua.sdk.device.DeviceBuilder
    public Device build() {
        if (this.name == null) {
            throw new IllegalArgumentException("A name must be set!");
        }
        if (this.model == null) {
            throw new IllegalArgumentException("A model must be set!");
        }
        if (this.manufacturer == null) {
            throw new IllegalArgumentException("A manufacturer must be set!");
        }
        return new DeviceImpl(this.name, this.manufacturer, this.description, this.model);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.model);
        parcel.writeString(this.description);
        parcel.writeString(this.manufacturer);
    }

    public DeviceBuilderImpl() {
    }

    private DeviceBuilderImpl(Parcel parcel) {
        this.name = parcel.readString();
        this.model = parcel.readString();
        this.description = parcel.readString();
        this.manufacturer = parcel.readString();
    }
}
