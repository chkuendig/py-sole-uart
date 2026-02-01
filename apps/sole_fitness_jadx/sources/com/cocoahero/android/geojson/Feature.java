package com.cocoahero.android.geojson;

import android.os.Parcel;
import android.os.Parcelable;
import com.cocoahero.android.geojson.util.JSONUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class Feature extends GeoJSONObject {
    public static final Parcelable.Creator<Feature> CREATOR = new Parcelable.Creator<Feature>() { // from class: com.cocoahero.android.geojson.Feature.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Feature createFromParcel(Parcel parcel) {
            return (Feature) GeoJSONObject.readParcel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Feature[] newArray(int i) {
            return new Feature[i];
        }
    };
    private static final String JSON_GEOMETRY = "geometry";
    private static final String JSON_ID = "id";
    private static final String JSON_PROPERTIES = "properties";
    private Geometry mGeometry;
    private String mIdentifier;
    private JSONObject mProperties;

    @Override // com.cocoahero.android.geojson.GeoJSONObject
    public String getType() {
        return GeoJSON.TYPE_FEATURE;
    }

    public Feature() {
    }

    public Feature(JSONObject jSONObject) {
        super(jSONObject);
        this.mIdentifier = JSONUtils.optString(jSONObject, "id");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(JSON_GEOMETRY);
        if (jSONObjectOptJSONObject != null) {
            this.mGeometry = (Geometry) GeoJSON.parse(jSONObjectOptJSONObject);
        }
        this.mProperties = jSONObject.optJSONObject(JSON_PROPERTIES);
    }

    public Feature(Geometry geometry) {
        this.mGeometry = geometry;
    }

    public String getIdentifier() {
        return this.mIdentifier;
    }

    public void setIdentifier(String str) {
        this.mIdentifier = str;
    }

    public Geometry getGeometry() {
        return this.mGeometry;
    }

    public void setGeometry(Geometry geometry) {
        this.mGeometry = geometry;
    }

    public JSONObject getProperties() {
        return this.mProperties;
    }

    public void setProperties(JSONObject jSONObject) {
        this.mProperties = jSONObject;
    }

    @Override // com.cocoahero.android.geojson.GeoJSONObject
    public JSONObject toJSON() throws JSONException {
        JSONObject json = super.toJSON();
        json.put("id", this.mIdentifier);
        Geometry geometry = this.mGeometry;
        if (geometry != null) {
            json.put(JSON_GEOMETRY, geometry.toJSON());
        } else {
            json.put(JSON_GEOMETRY, JSONObject.NULL);
        }
        JSONObject jSONObject = this.mProperties;
        if (jSONObject != null) {
            json.put(JSON_PROPERTIES, jSONObject);
        } else {
            json.put(JSON_PROPERTIES, JSONObject.NULL);
        }
        return json;
    }
}
