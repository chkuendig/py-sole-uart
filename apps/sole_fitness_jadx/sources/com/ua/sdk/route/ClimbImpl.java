package com.ua.sdk.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.ua.sdk.internal.ApiTransferObject;

/* loaded from: classes2.dex */
public class ClimbImpl extends ApiTransferObject implements Climb, Parcelable {
    public static final Parcelable.Creator<ClimbImpl> CREATOR = new Parcelable.Creator<ClimbImpl>() { // from class: com.ua.sdk.route.ClimbImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ClimbImpl createFromParcel(Parcel parcel) {
            return new ClimbImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ClimbImpl[] newArray(int i) {
            return new ClimbImpl[i];
        }
    };

    @SerializedName("cat")
    String category;

    @SerializedName("change")
    Double change;

    @SerializedName("dis")
    Double distance;

    @SerializedName("end")
    Double end;

    @SerializedName("end_index")
    int endIndex;

    @SerializedName("elevation_max")
    Double maxElevation;

    @SerializedName("start")
    Double start;

    @SerializedName("start_index")
    int startIndex;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ua.sdk.route.Climb
    public Double getChangeMeters() {
        return null;
    }

    @Override // com.ua.sdk.route.Climb
    public Double getDistanceMeters() {
        return null;
    }

    @Override // com.ua.sdk.route.Climb
    public Double getEnd() {
        return null;
    }

    @Override // com.ua.sdk.route.Climb
    public Double getMaxElevation() {
        return null;
    }

    @Override // com.ua.sdk.route.Climb
    public Double getStart() {
        return null;
    }

    @Override // com.ua.sdk.route.Climb
    public String getCategory() {
        return this.category;
    }

    @Override // com.ua.sdk.route.Climb
    public int getEndIndex() {
        return this.endIndex;
    }

    @Override // com.ua.sdk.route.Climb
    public int getStartIndex() {
        return this.startIndex;
    }

    @Override // com.ua.sdk.internal.ApiTransferObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.category);
        parcel.writeValue(this.change);
        parcel.writeValue(this.distance);
        parcel.writeValue(this.maxElevation);
        parcel.writeValue(this.end);
        parcel.writeInt(this.endIndex);
        parcel.writeValue(this.start);
        parcel.writeInt(this.startIndex);
    }

    public ClimbImpl() {
    }

    private ClimbImpl(Parcel parcel) {
        this.category = parcel.readString();
        this.change = (Double) parcel.readValue(Double.class.getClassLoader());
        this.distance = (Double) parcel.readValue(Double.class.getClassLoader());
        this.maxElevation = (Double) parcel.readValue(Double.class.getClassLoader());
        this.end = (Double) parcel.readValue(Double.class.getClassLoader());
        this.endIndex = parcel.readInt();
        this.start = (Double) parcel.readValue(Double.class.getClassLoader());
        this.startIndex = parcel.readInt();
    }
}
