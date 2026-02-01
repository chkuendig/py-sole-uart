package com.mapbox.mapboxsdk.tileprovider.tilesource;

import android.os.AsyncTask;
import android.util.Log;
import com.mapbox.mapboxsdk.geometry.BoundingBox;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.tileprovider.modules.MBTilesFileArchive;
import com.mapbox.mapboxsdk.util.NetworkUtils;
import com.mapbox.mapboxsdk.util.constants.UtilConstants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.ResponseCache;
import java.net.URL;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class TileJsonTileLayer extends WebSourceTileLayer {
    private static final String TAG = "TileJsonTileLayer";
    private ResponseCache cache;
    private JSONObject tileJSON;

    protected String getBrandedJSONURL() {
        return null;
    }

    public TileJsonTileLayer(String str, String str2, boolean z) {
        super(str, str2, z);
        try {
            this.cache = NetworkUtils.getResponseCache(new File(System.getProperty("java.io.tmpdir"), UUID.randomUUID().toString()), 1024);
        } catch (Exception e) {
            Log.e(TAG, "Cache creation failed.", e);
        }
        String brandedJSONURL = getBrandedJSONURL();
        if (brandedJSONURL != null) {
            fetchBrandedJSONAndInit(brandedJSONURL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initWithTileJSON(JSONObject jSONObject) throws JSONException {
        setTileJSON(jSONObject != null ? jSONObject : new JSONObject());
        if (jSONObject != null) {
            if (this.tileJSON.has(MBTilesFileArchive.TABLE_TILES)) {
                try {
                    setURL(this.tileJSON.getJSONArray(MBTilesFileArchive.TABLE_TILES).getString(0).replace(".png", "{2x}.png"));
                } catch (JSONException e) {
                    Log.e(TAG, "Couldn't set tile url", e);
                }
            }
            this.mMinimumZoomLevel = getJSONFloat(this.tileJSON, "minzoom");
            this.mMaximumZoomLevel = getJSONFloat(this.tileJSON, "maxzoom");
            this.mName = this.tileJSON.optString("name");
            this.mDescription = this.tileJSON.optString("description");
            this.mAttribution = this.tileJSON.optString("attribution");
            this.mLegend = this.tileJSON.optString("legend");
            double[] jSONDoubleArray = getJSONDoubleArray(this.tileJSON, "center", 3);
            if (jSONDoubleArray != null) {
                this.mCenter = new LatLng(jSONDoubleArray[0], jSONDoubleArray[1], jSONDoubleArray[2]);
            }
            double[] jSONDoubleArray2 = getJSONDoubleArray(this.tileJSON, "bounds", 4);
            if (jSONDoubleArray2 != null) {
                this.mBoundingBox = new BoundingBox(jSONDoubleArray2[3], jSONDoubleArray2[2], jSONDoubleArray2[1], jSONDoubleArray2[0]);
            }
        }
        if (UtilConstants.DEBUGMODE) {
            Log.d(TAG, "TileJSON " + this.tileJSON.toString());
        }
    }

    public JSONObject getTileJSON() {
        return this.tileJSON;
    }

    public void setTileJSON(JSONObject jSONObject) {
        this.tileJSON = jSONObject;
    }

    private float getJSONFloat(JSONObject jSONObject, String str) {
        if (jSONObject.has(str)) {
            try {
                return (float) jSONObject.getDouble(str);
            } catch (JSONException unused) {
            }
        }
        return 0.0f;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0048 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private double[] getJSONDoubleArray(JSONObject jSONObject, String str, int i) throws JSONException {
        if (jSONObject.has(str)) {
            try {
                double[] dArr = new double[i];
                Object obj = jSONObject.get(str);
                int i2 = 0;
                if (obj instanceof JSONArray) {
                    JSONArray jSONArray = (JSONArray) obj;
                    if (jSONArray.length() == i) {
                        while (i2 < jSONArray.length()) {
                            dArr[i2] = jSONArray.getDouble(i2);
                            i2++;
                        }
                        i2 = 1;
                    }
                    if (i2 == 0) {
                        return dArr;
                    }
                } else {
                    String[] strArrSplit = jSONObject.getString(str).split(",");
                    if (strArrSplit.length == i) {
                        while (i2 < strArrSplit.length) {
                            dArr[i2] = Double.parseDouble(strArrSplit[i2]);
                            i2++;
                        }
                        i2 = 1;
                    }
                    if (i2 == 0) {
                    }
                }
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    byte[] readFully(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int i = inputStream.read(bArr);
            if (i != -1) {
                byteArrayOutputStream.write(bArr, 0, i);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.mapbox.mapboxsdk.tileprovider.tilesource.TileJsonTileLayer$1] */
    private void fetchBrandedJSONAndInit(String str) {
        new RetrieveJSONTask() { // from class: com.mapbox.mapboxsdk.tileprovider.tilesource.TileJsonTileLayer.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public void onPostExecute(JSONObject jSONObject) throws JSONException {
                TileJsonTileLayer.this.initWithTileJSON(jSONObject);
            }
        }.execute(new String[]{str});
    }

    class RetrieveJSONTask extends AsyncTask<String, Void, JSONObject> {
        RetrieveJSONTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0078 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r8v2 */
        /* JADX WARN: Type inference failed for: r8v4, types: [java.io.InputStream] */
        @Override // android.os.AsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public JSONObject doInBackground(String... strArr) throws Throwable {
            Throwable th;
            InputStream inputStream;
            try {
                try {
                    inputStream = NetworkUtils.getHttpURLConnection(new URL(strArr[0]), TileJsonTileLayer.this.cache).getInputStream();
                    try {
                        JSONObject jSONObject = new JSONObject(new String(TileJsonTileLayer.this.readFully(inputStream), "UTF-8"));
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e) {
                                Log.e(TileJsonTileLayer.TAG, "Error closing InputStream: " + e.toString());
                            }
                        }
                        return jSONObject;
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e3) {
                                Log.e(TileJsonTileLayer.TAG, "Error closing InputStream: " + e3.toString());
                            }
                        }
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (strArr != 0) {
                        try {
                            strArr.close();
                        } catch (IOException e4) {
                            Log.e(TileJsonTileLayer.TAG, "Error closing InputStream: " + e4.toString());
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                inputStream = null;
            } catch (Throwable th3) {
                th = th3;
                strArr = 0;
                if (strArr != 0) {
                }
                throw th;
            }
        }
    }
}
