package com.cocoahero.android.geojson;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class LineString extends Geometry {
    public static final Parcelable.Creator<LineString> CREATOR = new Parcelable.Creator<LineString>() { // from class: com.cocoahero.android.geojson.LineString.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LineString createFromParcel(Parcel parcel) {
            return (LineString) GeoJSONObject.readParcel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LineString[] newArray(int i) {
            return new LineString[i];
        }
    };
    private final PositionList mPositionList;

    @Override // com.cocoahero.android.geojson.GeoJSONObject
    public String getType() {
        return GeoJSON.TYPE_LINE_STRING;
    }

    public LineString() {
        this.mPositionList = new PositionList();
    }

    public LineString(JSONObject jSONObject) {
        super(jSONObject);
        this.mPositionList = new PositionList();
        setPositions(jSONObject.optJSONArray(Geometry.JSON_COORDINATES));
    }

    public LineString(JSONArray jSONArray) {
        this.mPositionList = new PositionList();
        setPositions(jSONArray);
    }

    public void addPosition(Position position) {
        this.mPositionList.addPosition(position);
    }

    public void removePosition(Position position) {
        this.mPositionList.removePosition(position);
    }

    public List<Position> getPositions() {
        return this.mPositionList.getPositions();
    }

    public void setPositions(JSONArray jSONArray) {
        this.mPositionList.setPositions(jSONArray);
    }

    public void setPositions(List<Position> list) {
        this.mPositionList.setPositions(list);
    }

    public boolean isLinearRing() {
        return this.mPositionList.isLinearRing();
    }

    @Override // com.cocoahero.android.geojson.Geometry, com.cocoahero.android.geojson.GeoJSONObject
    public JSONObject toJSON() throws JSONException {
        JSONObject json = super.toJSON();
        json.put(Geometry.JSON_COORDINATES, this.mPositionList.toJSON());
        return json;
    }
}
