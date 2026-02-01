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
public class MultiLineString extends Geometry {
    public static final Parcelable.Creator<MultiLineString> CREATOR = new Parcelable.Creator<MultiLineString>() { // from class: com.cocoahero.android.geojson.MultiLineString.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MultiLineString createFromParcel(Parcel parcel) {
            return (MultiLineString) GeoJSONObject.readParcel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MultiLineString[] newArray(int i) {
            return new MultiLineString[i];
        }
    };
    private final List<LineString> mLineStrings;

    @Override // com.cocoahero.android.geojson.GeoJSONObject
    public String getType() {
        return GeoJSON.TYPE_MULTI_LINE_STRING;
    }

    public MultiLineString() {
        this.mLineStrings = new ArrayList();
    }

    public MultiLineString(JSONObject jSONObject) {
        super(jSONObject);
        this.mLineStrings = new ArrayList();
        setLineStrings(jSONObject.optJSONArray(Geometry.JSON_COORDINATES));
    }

    public MultiLineString(JSONArray jSONArray) {
        this.mLineStrings = new ArrayList();
        setLineStrings(jSONArray);
    }

    public void addLineString(LineString lineString) {
        this.mLineStrings.add(lineString);
    }

    public void removeLineString(LineString lineString) {
        this.mLineStrings.remove(lineString);
    }

    public List<LineString> getLineStrings() {
        return this.mLineStrings;
    }

    public void setLineStrings(JSONArray jSONArray) {
        this.mLineStrings.clear();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONArray jSONArrayOptJSONArray = jSONArray.optJSONArray(i);
                if (jSONArrayOptJSONArray != null) {
                    this.mLineStrings.add(new LineString(jSONArrayOptJSONArray));
                }
            }
        }
    }

    public void setLineStrings(List<LineString> list) {
        this.mLineStrings.clear();
        if (list != null) {
            this.mLineStrings.addAll(list);
        }
    }

    @Override // com.cocoahero.android.geojson.Geometry, com.cocoahero.android.geojson.GeoJSONObject
    public JSONObject toJSON() throws JSONException {
        JSONObject json = super.toJSON();
        JSONArray jSONArray = new JSONArray();
        for (LineString lineString : this.mLineStrings) {
            JSONArray jSONArray2 = new JSONArray();
            Iterator<Position> it = lineString.getPositions().iterator();
            while (it.hasNext()) {
                jSONArray2.put(it.next().toJSON());
            }
            jSONArray.put(jSONArray2);
        }
        json.put(Geometry.JSON_COORDINATES, jSONArray);
        return json;
    }
}
