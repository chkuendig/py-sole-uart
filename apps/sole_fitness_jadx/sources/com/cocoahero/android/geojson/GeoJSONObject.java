package com.cocoahero.android.geojson;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class GeoJSONObject implements Parcelable {
    public static final Parcelable.Creator<GeoJSONObject> CREATOR = new Parcelable.Creator<GeoJSONObject>() { // from class: com.cocoahero.android.geojson.GeoJSONObject.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GeoJSONObject createFromParcel(Parcel parcel) {
            return GeoJSONObject.readParcel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GeoJSONObject[] newArray(int i) {
            return new GeoJSONObject[i];
        }
    };
    public static final String JSON_TYPE = "type";

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public abstract String getType();

    protected static GeoJSONObject readParcel(Parcel parcel) {
        try {
            return GeoJSON.parse(parcel.readString());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public GeoJSONObject() {
    }

    public GeoJSONObject(JSONObject jSONObject) {
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        try {
            parcel.writeString(toJSON().toString());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", getType());
        return jSONObject;
    }
}
