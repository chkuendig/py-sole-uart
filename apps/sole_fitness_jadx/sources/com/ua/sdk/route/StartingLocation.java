package com.ua.sdk.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.cocoahero.android.geojson.GeoJSON;
import com.cocoahero.android.geojson.Geometry;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes2.dex */
public class StartingLocation implements Parcelable {
    public static final Parcelable.Creator<StartingLocation> CREATOR = new Parcelable.Creator<StartingLocation>() { // from class: com.ua.sdk.route.StartingLocation.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StartingLocation createFromParcel(Parcel parcel) {
            return new StartingLocation(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StartingLocation[] newArray(int i) {
            return new StartingLocation[i];
        }
    };

    @SerializedName(Geometry.JSON_COORDINATES)
    double[] coordinates;

    @SerializedName("type")
    String type;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public StartingLocation() {
        this.type = GeoJSON.TYPE_POINT;
        this.coordinates = new double[2];
    }

    public StartingLocation(Double d, Double d2) {
        this.type = GeoJSON.TYPE_POINT;
        this.coordinates = new double[]{d.doubleValue(), 0.0d};
        this.coordinates[1] = d2.doubleValue();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.type);
        parcel.writeValue(Double.valueOf(this.coordinates[0]));
        parcel.writeValue(Double.valueOf(this.coordinates[1]));
    }

    private StartingLocation(Parcel parcel) {
        this.type = parcel.readString();
        if (this.coordinates == null) {
            this.coordinates = new double[2];
        }
        this.coordinates[0] = ((Double) parcel.readValue(Double.class.getClassLoader())).doubleValue();
        this.coordinates[1] = ((Double) parcel.readValue(Double.class.getClassLoader())).doubleValue();
    }
}
