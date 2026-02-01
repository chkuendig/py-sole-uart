package com.ua.sdk.device;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.ua.sdk.EntityRef;
import com.ua.sdk.internal.ApiTransferObject;
import com.ua.sdk.internal.Link;
import com.ua.sdk.internal.LinkEntityRef;

/* loaded from: classes2.dex */
public class DeviceImpl extends ApiTransferObject implements Device {
    public static final Parcelable.Creator<DeviceImpl> CREATOR = new Parcelable.Creator<DeviceImpl>() { // from class: com.ua.sdk.device.DeviceImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DeviceImpl createFromParcel(Parcel parcel) {
            return new DeviceImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DeviceImpl[] newArray(int i) {
            return new DeviceImpl[i];
        }
    };

    @SerializedName("description")
    String description;

    @SerializedName("manufacturer")
    String manufacturer;

    @SerializedName("model")
    String model;

    @SerializedName("name")
    String name;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public DeviceImpl() {
    }

    public DeviceImpl(String str, String str2, String str3, String str4) {
        this.name = str;
        this.manufacturer = str2;
        this.description = str3;
        this.model = str4;
    }

    @Override // com.ua.sdk.device.Device
    public String getName() {
        return this.name;
    }

    @Override // com.ua.sdk.device.Device
    public String getManufacturer() {
        return this.manufacturer;
    }

    @Override // com.ua.sdk.device.Device
    public String getDescription() {
        return this.description;
    }

    @Override // com.ua.sdk.device.Device
    public String getModel() {
        return this.model;
    }

    @Override // com.ua.sdk.Resource
    public EntityRef getRef() {
        Link link = getLink("self");
        if (link == null) {
            return null;
        }
        return new LinkEntityRef(link.getId(), link.getHref());
    }

    @Override // com.ua.sdk.internal.ApiTransferObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.manufacturer);
        parcel.writeString(this.description);
        parcel.writeString(this.model);
    }

    private DeviceImpl(Parcel parcel) {
        this.name = parcel.readString();
        this.manufacturer = parcel.readString();
        this.description = parcel.readString();
        this.model = parcel.readString();
    }
}
