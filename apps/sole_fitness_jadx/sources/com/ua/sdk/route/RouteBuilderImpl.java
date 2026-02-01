package com.ua.sdk.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class RouteBuilderImpl implements RouteBuilder, Parcelable {
    public static final Parcelable.Creator<RouteBuilderImpl> CREATOR = new Parcelable.Creator<RouteBuilderImpl>() { // from class: com.ua.sdk.route.RouteBuilderImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RouteBuilderImpl createFromParcel(Parcel parcel) {
            return new RouteBuilderImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RouteBuilderImpl[] newArray(int i) {
            return new RouteBuilderImpl[i];
        }
    };
    String description;
    String name;
    ArrayList<Point> points;
    String postalCode;
    String startPointType;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public RouteBuilderImpl() {
        this.points = new ArrayList<>();
    }

    @Override // com.ua.sdk.route.RouteBuilder
    public RouteBuilder setName(String str) {
        this.name = str;
        return this;
    }

    @Override // com.ua.sdk.route.RouteBuilder
    public RouteBuilder setDescription(String str) {
        this.description = str;
        return this;
    }

    @Override // com.ua.sdk.route.RouteBuilder
    public RouteBuilder setStartPointType(String str) {
        this.startPointType = str;
        return this;
    }

    @Override // com.ua.sdk.route.RouteBuilder
    public RouteBuilder setPoints(ArrayList<Point> arrayList) {
        this.points = arrayList;
        return this;
    }

    @Override // com.ua.sdk.route.RouteBuilder
    public RouteBuilder setPostalCode(String str) {
        this.postalCode = str;
        return this;
    }

    @Override // com.ua.sdk.route.RouteBuilder
    public Route build() {
        if (this.name == null) {
            throw new IllegalArgumentException("A name must be specified.");
        }
        ArrayList<Point> arrayList = this.points;
        if (arrayList == null || arrayList.isEmpty()) {
            throw new IllegalArgumentException("Points must be specified.");
        }
        return new RouteImpl(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.description);
        parcel.writeString(this.startPointType);
        parcel.writeList(this.points);
        parcel.writeString(this.postalCode);
    }

    private RouteBuilderImpl(Parcel parcel) {
        this.name = parcel.readString();
        this.description = parcel.readString();
        this.startPointType = parcel.readString();
        ArrayList<Point> arrayList = new ArrayList<>();
        this.points = arrayList;
        parcel.readList(arrayList, PointImpl.class.getClassLoader());
        this.postalCode = parcel.readString();
    }
}
