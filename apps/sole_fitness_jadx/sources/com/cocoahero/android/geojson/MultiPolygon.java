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
public class MultiPolygon extends Geometry {
    public static final Parcelable.Creator<MultiPolygon> CREATOR = new Parcelable.Creator<MultiPolygon>() { // from class: com.cocoahero.android.geojson.MultiPolygon.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MultiPolygon createFromParcel(Parcel parcel) {
            return (MultiPolygon) GeoJSONObject.readParcel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MultiPolygon[] newArray(int i) {
            return new MultiPolygon[i];
        }
    };
    private final List<Polygon> mPolygons;

    @Override // com.cocoahero.android.geojson.GeoJSONObject
    public String getType() {
        return GeoJSON.TYPE_MULTI_POLYGON;
    }

    public MultiPolygon() {
        this.mPolygons = new ArrayList();
    }

    public MultiPolygon(JSONObject jSONObject) {
        super(jSONObject);
        this.mPolygons = new ArrayList();
        setPolygons(jSONObject.optJSONArray(Geometry.JSON_COORDINATES));
    }

    public void addPolygon(Polygon polygon) {
        this.mPolygons.add(polygon);
    }

    public void removePolygon(Polygon polygon) {
        this.mPolygons.remove(polygon);
    }

    public List<Polygon> getPolygons() {
        return this.mPolygons;
    }

    public void setPolygons(JSONArray jSONArray) {
        this.mPolygons.clear();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONArray jSONArrayOptJSONArray = jSONArray.optJSONArray(i);
                if (jSONArrayOptJSONArray != null) {
                    this.mPolygons.add(new Polygon(jSONArrayOptJSONArray));
                }
            }
        }
    }

    public void setPolygons(List<Polygon> list) {
        this.mPolygons.clear();
        if (list != null) {
            this.mPolygons.addAll(list);
        }
    }

    @Override // com.cocoahero.android.geojson.Geometry, com.cocoahero.android.geojson.GeoJSONObject
    public JSONObject toJSON() throws JSONException {
        JSONObject json = super.toJSON();
        JSONArray jSONArray = new JSONArray();
        for (Polygon polygon : this.mPolygons) {
            JSONArray jSONArray2 = new JSONArray();
            Iterator<Ring> it = polygon.getRings().iterator();
            while (it.hasNext()) {
                jSONArray2.put(it.next().toJSON());
            }
            jSONArray.put(jSONArray2);
        }
        json.put(Geometry.JSON_COORDINATES, jSONArray);
        return json;
    }
}
