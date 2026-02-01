package com.ua.sdk.heartrate;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.ua.sdk.EntityRef;
import com.ua.sdk.internal.ApiTransferObject;

/* loaded from: classes2.dex */
public class HeartRateZone extends ApiTransferObject implements Parcelable {
    public static final Parcelable.Creator<HeartRateZone> CREATOR = new Parcelable.Creator<HeartRateZone>() { // from class: com.ua.sdk.heartrate.HeartRateZone.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HeartRateZone createFromParcel(Parcel parcel) {
            return new HeartRateZone(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HeartRateZone[] newArray(int i) {
            return new HeartRateZone[i];
        }
    };

    @SerializedName("end")
    int end;

    @SerializedName("name")
    private String name;
    private transient EntityRef<HeartRateZones> selfRef;

    @SerializedName("start")
    private int start;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public HeartRateZone() {
    }

    public HeartRateZone(String str, int i, int i2) {
        this.name = str;
        this.start = i;
        this.end = i2;
    }

    private HeartRateZone(Parcel parcel) {
        super(parcel);
        this.name = parcel.readString();
        this.start = parcel.readInt();
        this.end = parcel.readInt();
    }

    public String getName() {
        return this.name;
    }

    public int getStart() {
        return this.start;
    }

    public int getEnd() {
        return this.end;
    }

    @Override // com.ua.sdk.internal.ApiTransferObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.name);
        parcel.writeInt(this.start);
        parcel.writeInt(this.end);
    }
}
