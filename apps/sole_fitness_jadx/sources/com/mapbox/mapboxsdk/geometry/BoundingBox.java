package com.mapbox.mapboxsdk.geometry;

import android.os.Parcel;
import android.os.Parcelable;
import com.mapbox.mapboxsdk.api.ILatLng;
import com.mapbox.mapboxsdk.views.util.constants.MapViewConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class BoundingBox implements Parcelable, Serializable, MapViewConstants {
    public static final Parcelable.Creator<BoundingBox> CREATOR = new Parcelable.Creator<BoundingBox>() { // from class: com.mapbox.mapboxsdk.geometry.BoundingBox.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BoundingBox createFromParcel(Parcel parcel) {
            return BoundingBox.readFromParcel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BoundingBox[] newArray(int i) {
            return new BoundingBox[i];
        }
    };
    static final long serialVersionUID = 2;
    private final boolean mIsValid;
    private final double mLatNorth;
    private final double mLatSouth;
    private final double mLonEast;
    private final double mLonWest;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public BoundingBox(double d, double d2, double d3, double d4) {
        this.mLatNorth = d;
        this.mLonEast = d2;
        this.mLatSouth = d3;
        this.mLonWest = d4;
        this.mIsValid = d4 < d2 && d > d3;
    }

    public BoundingBox(LatLng latLng, LatLng latLng2) {
        this(latLng.getLatitude(), latLng.getLongitude(), latLng2.getLatitude(), latLng2.getLongitude());
    }

    public BoundingBox(BoundingBox boundingBox) {
        this.mLatNorth = boundingBox.getLatNorth();
        this.mLonEast = boundingBox.getLonEast();
        this.mLatSouth = boundingBox.getLatSouth();
        this.mLonWest = boundingBox.getLonWest();
        this.mIsValid = boundingBox.isValid();
    }

    public BoundingBox() {
        this(0.0d, 0.0d, 0.0d, 0.0d);
    }

    public LatLng getCenter() {
        return new LatLng((this.mLatNorth + this.mLatSouth) / 2.0d, (this.mLonEast + this.mLonWest) / 2.0d);
    }

    public double getLatNorth() {
        return this.mLatNorth;
    }

    public double getLatSouth() {
        return this.mLatSouth;
    }

    public double getLonEast() {
        return this.mLonEast;
    }

    public double getLonWest() {
        return this.mLonWest;
    }

    public boolean isValid() {
        return this.mIsValid;
    }

    public double getLatitudeSpan() {
        return Math.abs(this.mLatNorth - this.mLatSouth);
    }

    public double getLongitudeSpan() {
        return Math.abs(this.mLonEast - this.mLonWest);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("N:");
        stringBuffer.append(this.mLatNorth);
        stringBuffer.append("; E:");
        stringBuffer.append(this.mLonEast);
        stringBuffer.append("; S:");
        stringBuffer.append(this.mLatSouth);
        stringBuffer.append("; W:");
        stringBuffer.append(this.mLonWest);
        return stringBuffer.toString();
    }

    public static BoundingBox fromLatLngs(ArrayList<? extends LatLng> arrayList) {
        Iterator<? extends LatLng> it = arrayList.iterator();
        double dMin = 180.0d;
        double dMin2 = 90.0d;
        double dMax = -90.0d;
        double dMax2 = -180.0d;
        while (it.hasNext()) {
            LatLng next = it.next();
            double latitude = next.getLatitude();
            double longitude = next.getLongitude();
            dMin2 = Math.min(dMin2, latitude);
            dMin = Math.min(dMin, longitude);
            dMax = Math.max(dMax, latitude);
            dMax2 = Math.max(dMax2, longitude);
        }
        return new BoundingBox(dMax, dMax2, dMin2, dMin);
    }

    public boolean equals(BoundingBox boundingBox) {
        if (boundingBox == null) {
            return false;
        }
        if (boundingBox == this) {
            return true;
        }
        return this.mLatNorth == boundingBox.getLatNorth() && this.mLatSouth == boundingBox.getLatSouth() && this.mLonEast == boundingBox.getLonEast() && this.mLonWest == boundingBox.getLonWest();
    }

    public boolean contains(ILatLng iLatLng) {
        double latitude = iLatLng.getLatitude();
        double longitude = iLatLng.getLongitude();
        return latitude < this.mLatNorth && latitude > this.mLatSouth && longitude < this.mLonEast && longitude > this.mLonWest;
    }

    public BoundingBox union(BoundingBox boundingBox) {
        return union(boundingBox.getLatNorth(), boundingBox.getLonEast(), boundingBox.getLatSouth(), boundingBox.getLonWest());
    }

    public BoundingBox union(double d, double d2, double d3, double d4) {
        double d5 = this.mLatNorth;
        double d6 = d5 < d ? d : d5;
        double d7 = this.mLonEast;
        if (d7 < d2) {
            d7 = d2;
        }
        double d8 = this.mLatSouth;
        if (d8 > d3) {
            d8 = d3;
        }
        double d9 = this.mLonWest;
        if (d9 > d4) {
            d9 = d4;
        }
        return new BoundingBox(d6, d7, d8, d9);
    }

    public BoundingBox intersect(BoundingBox boundingBox) {
        double dMax = Math.max(this.mLonWest, boundingBox.getLonWest());
        return new BoundingBox(Math.min(this.mLatNorth, boundingBox.getLatNorth()), Math.min(this.mLonEast, boundingBox.getLonEast()), Math.max(this.mLatSouth, boundingBox.getLatSouth()), dMax);
    }

    public BoundingBox intersect(double d, double d2, double d3, double d4) {
        return intersect(new BoundingBox(d, d2, d3, d4));
    }

    public int hashCode() {
        double d = this.mLatNorth + 90.0d + ((this.mLatSouth + 90.0d) * 1000.0d);
        double d2 = this.mLonEast;
        return (int) (d + ((d2 + 180.0d) * 1000000.0d) + ((d2 + 180.0d) * 1.0E9d));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.mLatNorth);
        parcel.writeDouble(this.mLonEast);
        parcel.writeDouble(this.mLatSouth);
        parcel.writeDouble(this.mLonWest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static BoundingBox readFromParcel(Parcel parcel) {
        return new BoundingBox(parcel.readDouble(), parcel.readDouble(), parcel.readDouble(), parcel.readDouble());
    }
}
