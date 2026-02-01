package com.cocoahero.android.geojson.util;

import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class JSONUtils {
    public static boolean isEmpty(JSONObject jSONObject) {
        return jSONObject == null || jSONObject.length() <= 0;
    }

    public static boolean isEmpty(JSONArray jSONArray) {
        return jSONArray == null || jSONArray.length() <= 0;
    }

    public static String optString(JSONObject jSONObject, String str) {
        return optString(jSONObject, str, (String) null);
    }

    public static String optString(JSONObject jSONObject, String str, String str2) {
        if (jSONObject != null) {
            return !jSONObject.isNull(str) ? jSONObject.optString(str, str2) : str2;
        }
        return null;
    }

    public static String optString(JSONArray jSONArray, int i) {
        return optString(jSONArray, i, (String) null);
    }

    public static String optString(JSONArray jSONArray, int i, String str) {
        if (jSONArray != null) {
            return !jSONArray.isNull(i) ? jSONArray.optString(i, str) : str;
        }
        return null;
    }
}
