package com.cocoahero.android.geojson;

import com.cocoahero.android.geojson.util.JSONUtils;
import com.cocoahero.android.geojson.util.StreamUtils;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class GeoJSON {
    public static final String TYPE_FEATURE = "Feature";
    public static final String TYPE_FEATURE_COLLECTION = "FeatureCollection";
    public static final String TYPE_GEOMETRY_COLLECTION = "GeometryCollection";
    public static final String TYPE_LINE_STRING = "LineString";
    public static final String TYPE_MULTI_LINE_STRING = "MultiLineString";
    public static final String TYPE_MULTI_POINT = "MultiPoint";
    public static final String TYPE_MULTI_POLYGON = "MultiPolygon";
    public static final String TYPE_POINT = "Point";
    public static final String TYPE_POLYGON = "Polygon";

    public static GeoJSONObject parse(JSONObject jSONObject) {
        String strOptString = JSONUtils.optString(jSONObject, "type");
        if (TYPE_POINT.equalsIgnoreCase(strOptString)) {
            return new Point(jSONObject);
        }
        if (TYPE_MULTI_POINT.equalsIgnoreCase(strOptString)) {
            return new MultiPoint(jSONObject);
        }
        if (TYPE_LINE_STRING.equalsIgnoreCase(strOptString)) {
            return new LineString(jSONObject);
        }
        if (TYPE_MULTI_LINE_STRING.equalsIgnoreCase(strOptString)) {
            return new MultiLineString(jSONObject);
        }
        if (TYPE_POLYGON.equalsIgnoreCase(strOptString)) {
            return new Polygon(jSONObject);
        }
        if (TYPE_MULTI_POLYGON.equalsIgnoreCase(strOptString)) {
            return new MultiPolygon(jSONObject);
        }
        if (TYPE_GEOMETRY_COLLECTION.equalsIgnoreCase(strOptString)) {
            return new GeometryCollection(jSONObject);
        }
        if (TYPE_FEATURE.equalsIgnoreCase(strOptString)) {
            return new Feature(jSONObject);
        }
        if (TYPE_FEATURE_COLLECTION.equalsIgnoreCase(strOptString)) {
            return new FeatureCollection(jSONObject);
        }
        throw new IllegalArgumentException("The type '" + strOptString + "' is not a valid GeoJSON type.");
    }

    public static GeoJSONObject parse(String str) throws JSONException {
        return parse(new JSONObject(str));
    }

    public static GeoJSONObject parse(InputStream inputStream) throws JSONException, IOException {
        return parse(StreamUtils.toString(inputStream));
    }
}
