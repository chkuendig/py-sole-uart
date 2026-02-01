package com.ua.sdk.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.ua.sdk.internal.ApiTransferObject;

/* loaded from: classes2.dex */
public class PointImpl extends ApiTransferObject implements Point, Parcelable {
    public static final Parcelable.Creator<PointImpl> CREATOR = new Parcelable.Creator<PointImpl>() { // from class: com.ua.sdk.route.PointImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PointImpl createFromParcel(Parcel parcel) {
            return new PointImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PointImpl[] newArray(int i) {
            return new PointImpl[i];
        }
    };

    @SerializedName("dis")
    Double distance;

    @SerializedName("elv")
    Double elevation;

    @SerializedName("lat")
    Double latitude;

    @SerializedName("lng")
    Double longitude;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PointImpl(Double d, Double d2, Double d3, Double d4) {
        this.latitude = d;
        this.longitude = d2;
        this.elevation = d3;
        this.distance = d4;
    }

    @Override // com.ua.sdk.route.Point
    public Double getLatitude() {
        return this.latitude;
    }

    @Override // com.ua.sdk.route.Point
    public Double getLongitude() {
        return this.longitude;
    }

    @Override // com.ua.sdk.route.Point
    public Double getElevation() {
        return this.elevation;
    }

    @Override // com.ua.sdk.route.Point
    public Double getDistanceMeters() {
        return this.distance;
    }

    @Override // com.ua.sdk.internal.ApiTransferObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.latitude);
        parcel.writeValue(this.longitude);
        parcel.writeValue(this.elevation);
        parcel.writeValue(this.distance);
    }

    private PointImpl(Parcel parcel) {
        this.latitude = (Double) parcel.readValue(Double.class.getClassLoader());
        this.longitude = (Double) parcel.readValue(Double.class.getClassLoader());
        this.elevation = (Double) parcel.readValue(Double.class.getClassLoader());
        this.distance = (Double) parcel.readValue(Double.class.getClassLoader());
    }
}
