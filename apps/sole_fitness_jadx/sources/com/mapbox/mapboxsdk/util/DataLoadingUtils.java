package com.mapbox.mapboxsdk.util;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.Log;
import com.cocoahero.android.geojson.Feature;
import com.cocoahero.android.geojson.FeatureCollection;
import com.cocoahero.android.geojson.GeoJSON;
import com.cocoahero.android.geojson.Geometry;
import com.cocoahero.android.geojson.LineString;
import com.cocoahero.android.geojson.MultiLineString;
import com.cocoahero.android.geojson.MultiPoint;
import com.cocoahero.android.geojson.MultiPolygon;
import com.cocoahero.android.geojson.Point;
import com.cocoahero.android.geojson.Polygon;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.overlay.Icon;
import com.mapbox.mapboxsdk.overlay.Marker;
import com.mapbox.mapboxsdk.overlay.PathOverlay;
import com.mapbox.mapboxsdk.util.constants.UtilConstants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Locale;
import org.apache.http.HttpHost;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes2.dex */
public class DataLoadingUtils {
    private static double rad(double d) {
        return (d * 3.141592653589793d) / 180.0d;
    }

    public static FeatureCollection loadGeoJSONFromUrl(String str) throws JSONException, IOException {
        InputStream inputStreamOpenStream;
        if (TextUtils.isEmpty(str)) {
            throw new NullPointerException("No GeoJSON URL passed in.");
        }
        if (UtilConstants.DEBUGMODE) {
            Log.d(DataLoadingUtils.class.getCanonicalName(), "Mapbox SDK downloading GeoJSON URL: " + str);
        }
        if (str.toLowerCase(Locale.US).indexOf(HttpHost.DEFAULT_SCHEME_NAME) == 0) {
            inputStreamOpenStream = NetworkUtils.getHttpURLConnection(new URL(str)).getInputStream();
        } else {
            inputStreamOpenStream = new URL(str).openStream();
        }
        FeatureCollection featureCollection = (FeatureCollection) GeoJSON.parse(readAll(new BufferedReader(new InputStreamReader(inputStreamOpenStream, Charset.forName("UTF-8")))));
        if (UtilConstants.DEBUGMODE) {
            Log.d(DataLoadingUtils.class.getCanonicalName(), "Parsed GeoJSON with " + featureCollection.getFeatures().size() + " features.");
        }
        return featureCollection;
    }

    public static FeatureCollection loadGeoJSONFromAssets(Context context, String str) throws JSONException, IOException {
        if (TextUtils.isEmpty(str)) {
            throw new NullPointerException("No GeoJSON File Name passed in.");
        }
        if (UtilConstants.DEBUGMODE) {
            Log.d(DataLoadingUtils.class.getCanonicalName(), "Mapbox SDK loading GeoJSON URL: " + str);
        }
        FeatureCollection featureCollection = (FeatureCollection) GeoJSON.parse(readAll(new BufferedReader(new InputStreamReader(context.getAssets().open(str), Charset.forName("UTF-8")))));
        if (UtilConstants.DEBUGMODE) {
            Log.d(DataLoadingUtils.class.getCanonicalName(), "Parsed GeoJSON with " + featureCollection.getFeatures().size() + " features.");
        }
        return featureCollection;
    }

    private static String readAll(Reader reader) throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i = reader.read();
            if (i != -1) {
                sb.append((char) i);
            } else {
                return sb.toString();
            }
        }
    }

    public static ArrayList<Object> createUIObjectsFromGeoJSONObjects(FeatureCollection featureCollection, Icon icon) throws JSONException {
        ArrayList<Object> arrayList = new ArrayList<>();
        for (Feature feature : featureCollection.getFeatures()) {
            int i = 0;
            int i2 = 1;
            if (feature.getGeometry() instanceof Point) {
                JSONArray jSONArray = (JSONArray) feature.getGeometry().toJSON().get(Geometry.JSON_COORDINATES);
                Marker marker = new Marker(feature.getProperties().optString("title"), "", new LatLng(((Double) jSONArray.get(1)).doubleValue(), ((Double) jSONArray.get(0)).doubleValue()));
                if (icon != null) {
                    marker.setIcon(icon);
                }
                arrayList.add(marker);
            } else if (feature.getGeometry() instanceof MultiPoint) {
                JSONArray jSONArray2 = (JSONArray) feature.getGeometry().toJSON().get(Geometry.JSON_COORDINATES);
                int i3 = 0;
                while (i3 < jSONArray2.length()) {
                    JSONArray jSONArray3 = (JSONArray) jSONArray2.get(i3);
                    Marker marker2 = new Marker(feature.getProperties().optString("title"), "", new LatLng(((Double) jSONArray3.get(i2)).doubleValue(), ((Double) jSONArray3.get(0)).doubleValue()));
                    if (icon != null) {
                        marker2.setIcon(icon);
                    }
                    arrayList.add(marker2);
                    i3++;
                    i2 = 1;
                }
            } else if (feature.getGeometry() instanceof LineString) {
                PathOverlay pathOverlay = new PathOverlay();
                JSONArray jSONArray4 = (JSONArray) feature.getGeometry().toJSON().get(Geometry.JSON_COORDINATES);
                for (int i4 = 0; i4 < jSONArray4.length(); i4++) {
                    JSONArray jSONArray5 = (JSONArray) jSONArray4.get(i4);
                    pathOverlay.addPoint(new LatLng(((Double) jSONArray5.get(1)).doubleValue(), ((Double) jSONArray5.get(0)).doubleValue()));
                }
                arrayList.add(pathOverlay);
            } else if (feature.getGeometry() instanceof MultiLineString) {
                JSONArray jSONArray6 = (JSONArray) feature.getGeometry().toJSON().get(Geometry.JSON_COORDINATES);
                for (int i5 = 0; i5 < jSONArray6.length(); i5++) {
                    PathOverlay pathOverlay2 = new PathOverlay();
                    JSONArray jSONArray7 = (JSONArray) jSONArray6.get(i5);
                    for (int i6 = 0; i6 < jSONArray7.length(); i6++) {
                        JSONArray jSONArray8 = (JSONArray) jSONArray7.get(i6);
                        pathOverlay2.addPoint(new LatLng(((Double) jSONArray8.get(1)).doubleValue(), ((Double) jSONArray8.get(0)).doubleValue()));
                    }
                    arrayList.add(pathOverlay2);
                }
            } else if (feature.getGeometry() instanceof Polygon) {
                PathOverlay pathOverlay3 = new PathOverlay();
                pathOverlay3.getPaint().setStyle(Paint.Style.FILL);
                JSONArray jSONArray9 = (JSONArray) feature.getGeometry().toJSON().get(Geometry.JSON_COORDINATES);
                for (int i7 = 0; i7 < jSONArray9.length(); i7++) {
                    JSONArray jSONArray10 = (JSONArray) jSONArray9.get(i7);
                    if ((i7 == 0 && !windingOrder(jSONArray10)) || (i7 != 0 && windingOrder(jSONArray10))) {
                        for (int i8 = 0; i8 < jSONArray10.length(); i8++) {
                            JSONArray jSONArray11 = (JSONArray) jSONArray10.get(i8);
                            pathOverlay3.addPoint(new LatLng(((Double) jSONArray11.get(1)).doubleValue(), ((Double) jSONArray11.get(0)).doubleValue()));
                        }
                    } else {
                        int i9 = 1;
                        int length = jSONArray10.length() - 1;
                        while (length >= 0) {
                            JSONArray jSONArray12 = (JSONArray) jSONArray10.get(length);
                            pathOverlay3.addPoint(new LatLng(((Double) jSONArray12.get(i9)).doubleValue(), ((Double) jSONArray12.get(0)).doubleValue()));
                            length--;
                            i9 = 1;
                        }
                    }
                    arrayList.add(pathOverlay3);
                }
            } else if (feature.getGeometry() instanceof MultiPolygon) {
                PathOverlay pathOverlay4 = new PathOverlay();
                pathOverlay4.getPaint().setStyle(Paint.Style.FILL);
                JSONArray jSONArray13 = (JSONArray) feature.getGeometry().toJSON().get(Geometry.JSON_COORDINATES);
                int i10 = 0;
                while (i10 < jSONArray13.length()) {
                    JSONArray jSONArray14 = (JSONArray) jSONArray13.get(i10);
                    int i11 = i;
                    while (i11 < jSONArray14.length()) {
                        JSONArray jSONArray15 = (JSONArray) jSONArray14.get(i11);
                        if ((i11 == 0 && !windingOrder(jSONArray15)) || (i11 != 0 && windingOrder(jSONArray15))) {
                            for (int i12 = i; i12 < jSONArray15.length(); i12++) {
                                JSONArray jSONArray16 = (JSONArray) jSONArray15.get(i12);
                                pathOverlay4.addPoint(new LatLng(((Double) jSONArray16.get(1)).doubleValue(), ((Double) jSONArray16.get(i)).doubleValue()));
                            }
                        } else {
                            int length2 = jSONArray15.length() - 1;
                            while (length2 >= 0) {
                                JSONArray jSONArray17 = (JSONArray) jSONArray15.get(length2);
                                pathOverlay4.addPoint(new LatLng(((Double) jSONArray17.get(1)).doubleValue(), ((Double) jSONArray17.get(i)).doubleValue()));
                                length2--;
                                jSONArray15 = jSONArray15;
                                i = 0;
                            }
                        }
                        arrayList.add(pathOverlay4);
                        i11++;
                        i = 0;
                    }
                    i10++;
                    i = 0;
                }
            }
        }
        return arrayList;
    }

    private static boolean windingOrder(JSONArray jSONArray) throws JSONException {
        float fRad;
        if (jSONArray.length() > 2) {
            fRad = 0.0f;
            int i = 0;
            while (i < jSONArray.length() - 1) {
                JSONArray jSONArray2 = (JSONArray) jSONArray.get(i);
                i++;
                JSONArray jSONArray3 = (JSONArray) jSONArray.get(i);
                fRad = (float) (fRad + (rad(((Double) jSONArray3.get(0)).doubleValue() - ((Double) jSONArray2.get(0)).doubleValue()) * (Math.sin(rad(((Double) jSONArray2.get(1)).doubleValue())) + 2.0d + Math.sin(rad(((Double) jSONArray3.get(1)).doubleValue())))));
            }
        } else {
            fRad = 0.0f;
        }
        return fRad > 0.0f;
    }
}
