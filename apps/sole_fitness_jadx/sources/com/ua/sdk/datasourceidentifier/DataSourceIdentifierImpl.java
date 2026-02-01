package com.ua.sdk.datasourceidentifier;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.ua.sdk.EntityRef;
import com.ua.sdk.device.Device;
import com.ua.sdk.internal.ApiTransferObject;
import com.ua.sdk.internal.Link;
import com.ua.sdk.internal.LinkEntityRef;

/* loaded from: classes2.dex */
public class DataSourceIdentifierImpl extends ApiTransferObject implements DataSourceIdentifier {
    public static final Parcelable.Creator<DataSourceIdentifierImpl> CREATOR = new Parcelable.Creator<DataSourceIdentifierImpl>() { // from class: com.ua.sdk.datasourceidentifier.DataSourceIdentifierImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DataSourceIdentifierImpl createFromParcel(Parcel parcel) {
            return new DataSourceIdentifierImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DataSourceIdentifierImpl[] newArray(int i) {
            return new DataSourceIdentifierImpl[i];
        }
    };

    @SerializedName("device")
    Device device;

    @SerializedName("name")
    String name;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public DataSourceIdentifierImpl() {
    }

    public DataSourceIdentifierImpl(Device device, String str) {
        this.device = device;
        this.name = str;
    }

    @Override // com.ua.sdk.datasourceidentifier.DataSourceIdentifier
    public Device getDevice() {
        return this.device;
    }

    @Override // com.ua.sdk.datasourceidentifier.DataSourceIdentifier
    public String getName() {
        return this.name;
    }

    @Override // com.ua.sdk.Resource
    public EntityRef getRef() {
        Link link = getLink("self");
        if (link == null) {
            return null;
        }
        return new LinkEntityRef(link.getId(), link.getHref());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        String str = this.name;
        String str2 = ((DataSourceIdentifierImpl) obj).name;
        return str == null ? str2 == null : str.equals(str2);
    }

    public int hashCode() {
        String str = this.name;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @Override // com.ua.sdk.internal.ApiTransferObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.device, i);
        parcel.writeString(this.name);
    }

    private DataSourceIdentifierImpl(Parcel parcel) {
        this.device = (Device) parcel.readParcelable(Device.class.getClassLoader());
        this.name = parcel.readString();
    }
}
