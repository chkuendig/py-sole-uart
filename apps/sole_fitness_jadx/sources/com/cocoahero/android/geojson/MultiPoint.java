package com.cocoahero.android.geojson;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class MultiPoint extends Geometry {
    public static final Parcelable.Creator<MultiPoint> CREATOR = new Parcelable.Creator<MultiPoint>() { // from class: com.cocoahero.android.geojson.MultiPoint.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MultiPoint createFromParcel(Parcel parcel) {
            return (MultiPoint) GeoJSONObject.readParcel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MultiPoint[] newArray(int i) {
            return new MultiPoint[i];
        }
    };
    private final PositionList mPositionList;

    @Override // com.cocoahero.android.geojson.GeoJSONObject
    public String getType() {
        return GeoJSON.TYPE_MULTI_POINT;
    }

    public MultiPoint() {
        this.mPositionList = new PositionList();
    }

    public MultiPoint(JSONObject jSONObject) {
        super(jSONObject);
        this.mPositionList = new PositionList();
        setPositions(jSONObject.optJSONArray(Geometry.JSON_COORDINATES));
    }

    public MultiPoint(JSONArray jSONArray) {
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

    @Override // com.cocoahero.android.geojson.Geometry, com.cocoahero.android.geojson.GeoJSONObject
    public JSONObject toJSON() throws JSONException {
        JSONObject json = super.toJSON();
        json.put(Geometry.JSON_COORDINATES, this.mPositionList.toJSON());
        return json;
    }
}
