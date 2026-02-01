package com.cocoahero.android.geojson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class Geometry extends GeoJSONObject {
    public static final String JSON_COORDINATES = "coordinates";

    public Geometry() {
    }

    public Geometry(JSONObject jSONObject) {
        super(jSONObject);
    }

    @Override // com.cocoahero.android.geojson.GeoJSONObject
    public JSONObject toJSON() throws JSONException {
        JSONObject json = super.toJSON();
        json.put(JSON_COORDINATES, new JSONArray());
        return json;
    }
}
