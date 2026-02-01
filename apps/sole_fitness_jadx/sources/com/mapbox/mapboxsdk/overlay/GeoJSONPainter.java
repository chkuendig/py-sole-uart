package com.mapbox.mapboxsdk.overlay;

import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.mapbox.mapboxsdk.util.DataLoadingUtils;
import com.mapbox.mapboxsdk.views.MapView;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class GeoJSONPainter {
    static final String TAG = "GeoJSONLayer";
    private final MapView mapView;
    private final Icon markerIcon;

    public GeoJSONPainter(MapView mapView, Icon icon) {
        this.mapView = mapView;
        this.markerIcon = icon;
    }

    public void loadFromURL(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        new LoadAndDisplay().execute(str);
    }

    private class LoadAndDisplay extends AsyncTask<String, Void, ArrayList<Object>> {
        private LoadAndDisplay() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public ArrayList<Object> doInBackground(String... strArr) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                return DataLoadingUtils.createUIObjectsFromGeoJSONObjects(DataLoadingUtils.loadGeoJSONFromUrl(strArr[0]), GeoJSONPainter.this.markerIcon);
            } catch (Exception e) {
                Log.e(GeoJSONPainter.TAG, "Error loading / parsing GeoJSON: " + e.toString());
                e.printStackTrace();
                return arrayList;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(ArrayList<Object> arrayList) {
            Iterator<Object> it = arrayList.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof Marker) {
                    GeoJSONPainter.this.mapView.addMarker((Marker) next);
                } else if (next instanceof PathOverlay) {
                    GeoJSONPainter.this.mapView.getOverlays().add((PathOverlay) next);
                }
            }
            if (arrayList.size() > 0) {
                GeoJSONPainter.this.mapView.invalidate();
            }
        }
    }
}
