package com.cocoahero.android.geojson;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class Point extends Geometry {
    public static final Parcelable.Creator<Point> CREATOR = new Parcelable.Creator<Point>() { // from class: com.cocoahero.android.geojson.Point.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Point createFromParcel(Parcel parcel) {
            return (Point) GeoJSONObject.readParcel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Point[] newArray(int i) {
            return new Point[i];
        }
    };
    private Position mPosition;

    @Override // com.cocoahero.android.geojson.GeoJSONObject
    public String getType() {
        return GeoJSON.TYPE_POINT;
    }

    public Point() {
    }

    public Point(JSONObject jSONObject) {
        super(jSONObject);
        setPosition(jSONObject.optJSONArray(Geometry.JSON_COORDINATES));
    }

    public Point(JSONArray jSONArray) {
        setPosition(jSONArray);
    }

    public Point(Position position) {
        setPosition(position);
    }

    public Point(double d, double d2) {
        this.mPosition = new Position(d, d2);
    }

    public Point(double d, double d2, double d3) {
        this.mPosition = new Position(d, d2, d3);
    }

    public Position getPosition() {
        return this.mPosition;
    }

    public void setPosition(Position position) {
        this.mPosition = position;
    }

    public void setPosition(JSONArray jSONArray) {
        if (jSONArray != null) {
            this.mPosition = new Position(jSONArray);
        } else {
            this.mPosition = null;
        }
    }

    @Override // com.cocoahero.android.geojson.Geometry, com.cocoahero.android.geojson.GeoJSONObject
    public JSONObject toJSON() throws JSONException {
        JSONObject json = super.toJSON();
        Position position = this.mPosition;
        if (position != null) {
            json.put(Geometry.JSON_COORDINATES, position.toJSON());
        }
        return json;
    }
}
