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
public class Polygon extends Geometry {
    public static final Parcelable.Creator<Polygon> CREATOR = new Parcelable.Creator<Polygon>() { // from class: com.cocoahero.android.geojson.Polygon.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Polygon createFromParcel(Parcel parcel) {
            return (Polygon) GeoJSONObject.readParcel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Polygon[] newArray(int i) {
            return new Polygon[i];
        }
    };
    private final List<Ring> mRings;

    @Override // com.cocoahero.android.geojson.GeoJSONObject
    public String getType() {
        return GeoJSON.TYPE_POLYGON;
    }

    public Polygon() {
        this.mRings = new ArrayList();
    }

    public Polygon(Ring ring) {
        this.mRings = new ArrayList();
        addRing(ring);
    }

    public Polygon(JSONObject jSONObject) {
        super(jSONObject);
        this.mRings = new ArrayList();
        setRings(jSONObject.optJSONArray(Geometry.JSON_COORDINATES));
    }

    public Polygon(JSONArray jSONArray) {
        this.mRings = new ArrayList();
        setRings(jSONArray);
    }

    public void addRing(Ring ring) {
        this.mRings.add(ring);
    }

    public void removeRing(Ring ring) {
        this.mRings.remove(ring);
    }

    public List<Ring> getRings() {
        return this.mRings;
    }

    public void setRings(JSONArray jSONArray) {
        this.mRings.clear();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONArray jSONArrayOptJSONArray = jSONArray.optJSONArray(i);
                if (jSONArrayOptJSONArray != null) {
                    this.mRings.add(new Ring(jSONArrayOptJSONArray));
                }
            }
        }
    }

    public void setRings(List<Ring> list) {
        this.mRings.clear();
        if (list != null) {
            this.mRings.addAll(list);
        }
    }

    @Override // com.cocoahero.android.geojson.Geometry, com.cocoahero.android.geojson.GeoJSONObject
    public JSONObject toJSON() throws JSONException {
        JSONObject json = super.toJSON();
        JSONArray jSONArray = new JSONArray();
        Iterator<Ring> it = this.mRings.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().toJSON());
        }
        json.put(Geometry.JSON_COORDINATES, jSONArray);
        return json;
    }
}
