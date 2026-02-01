package com.ua.sdk.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.UserDataStore;
import com.facebook.appevents.integrity.IntegrityManager;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes2.dex */
public class LocationImpl implements Location {
    public static Parcelable.Creator<LocationImpl> CREATOR = new Parcelable.Creator<LocationImpl>() { // from class: com.ua.sdk.location.LocationImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LocationImpl createFromParcel(Parcel parcel) {
            return new LocationImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LocationImpl[] newArray(int i) {
            return new LocationImpl[i];
        }
    };

    @SerializedName(IntegrityManager.INTEGRITY_TYPE_ADDRESS)
    String address;

    @SerializedName(UserDataStore.COUNTRY)
    String country;

    @SerializedName("locality")
    String locality;

    @SerializedName("region")
    String region;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LocationImpl() {
    }

    public LocationImpl(String str, String str2, String str3, String str4) {
        this.country = str;
        this.region = str2;
        this.locality = str3;
        this.address = str4;
    }

    @Override // com.ua.sdk.location.Location
    public String getCountry() {
        return this.country;
    }

    @Override // com.ua.sdk.location.Location
    public void setCountry(String str) {
        this.country = str;
    }

    @Override // com.ua.sdk.location.Location
    public String getRegion() {
        return this.region;
    }

    @Override // com.ua.sdk.location.Location
    public void setRegion(String str) {
        this.region = str;
    }

    @Override // com.ua.sdk.location.Location
    public String getLocality() {
        return this.locality;
    }

    @Override // com.ua.sdk.location.Location
    public void setLocality(String str) {
        this.locality = str;
    }

    @Override // com.ua.sdk.location.Location
    public String getAddress() {
        return this.address;
    }

    @Override // com.ua.sdk.location.Location
    public void setAddress(String str) {
        this.address = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.country);
        parcel.writeString(this.region);
        parcel.writeString(this.locality);
        parcel.writeString(this.address);
    }

    private LocationImpl(Parcel parcel) {
        this.country = parcel.readString();
        this.region = parcel.readString();
        this.locality = parcel.readString();
        this.address = parcel.readString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocationImpl)) {
            return false;
        }
        LocationImpl locationImpl = (LocationImpl) obj;
        String str = this.address;
        if (str == null ? locationImpl.address != null : !str.equals(locationImpl.address)) {
            return false;
        }
        String str2 = this.country;
        if (str2 == null ? locationImpl.country != null : !str2.equals(locationImpl.country)) {
            return false;
        }
        String str3 = this.locality;
        if (str3 == null ? locationImpl.locality != null : !str3.equals(locationImpl.locality)) {
            return false;
        }
        String str4 = this.region;
        String str5 = locationImpl.region;
        return str4 == null ? str5 == null : str4.equals(str5);
    }

    public int hashCode() {
        String str = this.country;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.region;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.locality;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.address;
        return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
    }
}
