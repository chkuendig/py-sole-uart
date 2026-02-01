package com.mapbox.mapboxsdk.geometry;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import com.mapbox.mapboxsdk.api.ILatLng;
import com.mapbox.mapboxsdk.constants.GeoConstants;
import com.mapbox.mapboxsdk.constants.MathConstants;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class LatLng implements ILatLng, GeoConstants, MathConstants, Parcelable, Serializable {
    public static final Parcelable.Creator<LatLng> CREATOR = new Parcelable.Creator<LatLng>() { // from class: com.mapbox.mapboxsdk.geometry.LatLng.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LatLng createFromParcel(Parcel parcel) {
            return new LatLng(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LatLng[] newArray(int i) {
            return new LatLng[i];
        }
    };
    private double altitude;
    private double latitude;
    private double longitude;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLng(double d, double d2) {
        this.altitude = 0.0d;
        this.latitude = d;
        this.longitude = d2;
    }

    public LatLng(double d, double d2, double d3) {
        this.latitude = d;
        this.longitude = d2;
        this.altitude = d3;
    }

    public LatLng(Location location) {
        this(location.getLatitude(), location.getLongitude(), location.getAltitude());
    }

    public LatLng(LatLng latLng) {
        this.altitude = 0.0d;
        this.latitude = latLng.latitude;
        this.longitude = latLng.longitude;
        this.altitude = latLng.altitude;
    }

    @Override // com.mapbox.mapboxsdk.api.ILatLng
    public double getLongitude() {
        return this.longitude;
    }

    @Override // com.mapbox.mapboxsdk.api.ILatLng
    public double getLatitude() {
        return this.latitude;
    }

    @Override // com.mapbox.mapboxsdk.api.ILatLng
    public double getAltitude() {
        return this.altitude;
    }

    public String toString() {
        return this.latitude + "," + this.longitude + "," + this.altitude;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!obj.getClass().equals(getClass())) {
            return false;
        }
        LatLng latLng = (LatLng) obj;
        return latLng.latitude == this.latitude && latLng.longitude == this.longitude && latLng.altitude == this.altitude;
    }

    public int hashCode() {
        return (int) ((((this.latitude * 17.0d * 1000000.0d) + (this.longitude * 1000000.0d)) * 37.0d) + this.altitude);
    }

    private LatLng(Parcel parcel) {
        this.altitude = 0.0d;
        this.latitude = parcel.readDouble();
        this.longitude = parcel.readDouble();
        this.altitude = parcel.readDouble();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.latitude);
        parcel.writeDouble(this.longitude);
        parcel.writeDouble(this.altitude);
    }

    public int distanceTo(LatLng latLng) {
        double d = this.latitude * 0.01745329238474369d;
        double d2 = this.longitude * 0.01745329238474369d;
        double latitude = latLng.getLatitude() * 0.01745329238474369d;
        double longitude = latLng.getLongitude() * 0.01745329238474369d;
        double dCos = Math.cos(d);
        double dCos2 = Math.cos(latitude);
        return (int) (Math.acos((Math.cos(d2) * dCos * dCos2 * Math.cos(longitude)) + (dCos * Math.sin(d2) * dCos2 * Math.sin(longitude)) + (Math.sin(d) * Math.sin(latitude))) * 6378137.0d);
    }
}
