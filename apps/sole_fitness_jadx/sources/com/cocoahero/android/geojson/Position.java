package com.cocoahero.android.geojson;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes.dex */
public class Position implements Parcelable {
    private static final int ALT_IDX = 2;
    public static final Parcelable.Creator<Position> CREATOR = new Parcelable.Creator<Position>() { // from class: com.cocoahero.android.geojson.Position.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Position createFromParcel(Parcel parcel) {
            return new Position(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Position[] newArray(int i) {
            return new Position[i];
        }
    };
    private static final int LAT_IDX = 1;
    private static final int LON_IDX = 0;
    private final double[] mStorage;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Position(JSONArray jSONArray) {
        this.mStorage = new double[]{jSONArray.optDouble(0, 0.0d), jSONArray.optDouble(1, 0.0d), jSONArray.optDouble(2, 0.0d)};
    }

    public Position(double[] dArr) {
        double[] dArr2 = new double[3];
        this.mStorage = dArr2;
        if (dArr.length == 2) {
            dArr2[0] = dArr[0];
            dArr2[1] = dArr[1];
        } else if (dArr.length == 3) {
            dArr2[0] = dArr[0];
            dArr2[1] = dArr[1];
            dArr2[2] = dArr[2];
        }
    }

    public Position(double d, double d2) {
        this.mStorage = new double[]{d2, d, 0.0d};
    }

    public Position(double d, double d2, double d3) {
        this.mStorage = new double[]{d2, d, d3};
    }

    public Position(Location location) {
        this.mStorage = new double[]{location.getLongitude(), location.getLatitude(), location.getAltitude()};
    }

    private Position(Parcel parcel) {
        this(parcel.createDoubleArray());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDoubleArray(this.mStorage);
    }

    public double getLatitude() {
        return this.mStorage[1];
    }

    public void setLatitude(double d) {
        this.mStorage[1] = d;
    }

    public double getLongitude() {
        return this.mStorage[0];
    }

    public void setLongitude(double d) {
        this.mStorage[0] = d;
    }

    public double getAltitude() {
        return this.mStorage[2];
    }

    public void setAltitude(double d) {
        this.mStorage[2] = d;
    }

    public JSONArray toJSON() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(1, getLatitude());
        jSONArray.put(0, getLongitude());
        jSONArray.put(2, getAltitude());
        return jSONArray;
    }

    public Location toLocation() {
        Location location = new Location("GeoJSON");
        location.setLatitude(getLatitude());
        location.setLongitude(getLongitude());
        location.setAltitude(getAltitude());
        return location;
    }

    public double[] toArray() {
        return this.mStorage;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Position) {
            return Arrays.equals(this.mStorage, ((Position) obj).mStorage);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.mStorage);
    }

    public String toString() {
        return Arrays.toString(this.mStorage);
    }
}
