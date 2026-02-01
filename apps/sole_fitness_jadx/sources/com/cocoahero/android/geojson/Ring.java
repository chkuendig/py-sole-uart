package com.cocoahero.android.geojson;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONArray;

/* loaded from: classes.dex */
public class Ring extends PositionList {
    public static final Parcelable.Creator<Ring> CREATOR = new Parcelable.Creator<Ring>() { // from class: com.cocoahero.android.geojson.Ring.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Ring createFromParcel(Parcel parcel) {
            return new Ring(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Ring[] newArray(int i) {
            return new Ring[i];
        }
    };

    public Ring() {
    }

    public Ring(JSONArray jSONArray) {
        super(jSONArray);
    }

    public Ring(double[][] dArr) {
        super(dArr);
    }

    protected Ring(Parcel parcel) {
        super(parcel);
    }

    public void close() {
        if (isLinearRing()) {
            return;
        }
        addPosition(getHead());
    }
}
