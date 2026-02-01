package com.cocoahero.android.geojson;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class GeometryCollection extends Geometry {
    public static final Parcelable.Creator<GeometryCollection> CREATOR = new Parcelable.Creator<GeometryCollection>() { // from class: com.cocoahero.android.geojson.GeometryCollection.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GeometryCollection createFromParcel(Parcel parcel) {
            return (GeometryCollection) GeoJSONObject.readParcel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GeometryCollection[] newArray(int i) {
            return new GeometryCollection[i];
        }
    };
    public static final String JSON_GEOMETRIES = "geometries";
    private final List<Geometry> mGeometries;

    @Override // com.cocoahero.android.geojson.GeoJSONObject
    public String getType() {
        return GeoJSON.TYPE_GEOMETRY_COLLECTION;
    }

    public GeometryCollection() {
        this.mGeometries = new ArrayList();
    }

    public GeometryCollection(JSONObject jSONObject) {
        super(jSONObject);
        this.mGeometries = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(JSON_GEOMETRIES);
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    this.mGeometries.add((Geometry) GeoJSON.parse(jSONObjectOptJSONObject));
                }
            }
        }
    }

    public void addGeometry(Geometry geometry) {
        this.mGeometries.add(geometry);
    }

    public void removeGeometry(Geometry geometry) {
        this.mGeometries.remove(geometry);
    }

    public List<Geometry> getGeometries() {
        return this.mGeometries;
    }

    public void setGeometries(List<Geometry> list) {
        this.mGeometries.clear();
        if (list != null) {
            this.mGeometries.addAll(list);
        }
    }

    @Override // com.cocoahero.android.geojson.Geometry, com.cocoahero.android.geojson.GeoJSONObject
    public JSONObject toJSON() throws JSONException {
        JSONObject json = super.toJSON();
        JSONArray jSONArray = new JSONArray();
        Iterator<Geometry> it = this.mGeometries.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().toJSON());
        }
        json.put(JSON_GEOMETRIES, jSONArray);
        return json;
    }
}
