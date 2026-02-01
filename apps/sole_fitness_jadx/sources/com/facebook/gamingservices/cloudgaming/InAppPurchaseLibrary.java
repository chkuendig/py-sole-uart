package com.facebook.gamingservices.cloudgaming;

import android.content.Context;
import com.facebook.gamingservices.cloudgaming.DaemonRequest;
import com.facebook.gamingservices.cloudgaming.internal.SDKLogger;
import com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class InAppPurchaseLibrary {

    @Deprecated
    public static final String DEVELOPER_PAYLOAD = "developerPayload";

    @Deprecated
    public static final String PRODUCT_ID = "productID";

    @Deprecated
    public static final String PURCHASE_TOKEN = "purchaseToken";

    public static void onReady(Context context, DaemonRequest.Callback callback) throws JSONException {
        DaemonRequest.executeAsync(context, (JSONObject) null, callback, SDKMessageEnum.ON_READY);
    }

    public static void getCatalog(Context context, DaemonRequest.Callback callback) throws JSONException {
        DaemonRequest.executeAsync(context, (JSONObject) null, callback, SDKMessageEnum.GET_CATALOG);
    }

    public static void getPurchases(Context context, DaemonRequest.Callback callback) throws JSONException {
        DaemonRequest.executeAsync(context, (JSONObject) null, callback, SDKMessageEnum.GET_PURCHASES);
    }

    public static void purchase(Context context, String str, String str2, DaemonRequest.Callback callback) {
        try {
            DaemonRequest.executeAsync(context, new JSONObject().put("productID", str).put("developerPayload", str2), callback, SDKMessageEnum.PURCHASE);
        } catch (JSONException e) {
            SDKLogger.logInternalError(context, SDKMessageEnum.PURCHASE, e);
        }
    }

    public static void consumePurchase(Context context, String str, DaemonRequest.Callback callback) {
        try {
            DaemonRequest.executeAsync(context, new JSONObject().put("purchaseToken", str), callback, SDKMessageEnum.CONSUME_PURCHASE);
        } catch (JSONException e) {
            SDKLogger.logInternalError(context, SDKMessageEnum.CONSUME_PURCHASE, e);
        }
    }

    public static void onReady(Context context, JSONObject jSONObject, DaemonRequest.Callback callback) throws JSONException {
        DaemonRequest.executeAsync(context, jSONObject, callback, SDKMessageEnum.ON_READY);
    }

    public static void getCatalog(Context context, JSONObject jSONObject, DaemonRequest.Callback callback) throws JSONException {
        DaemonRequest.executeAsync(context, jSONObject, callback, SDKMessageEnum.GET_CATALOG);
    }

    public static void getPurchases(Context context, JSONObject jSONObject, DaemonRequest.Callback callback) throws JSONException {
        DaemonRequest.executeAsync(context, jSONObject, callback, SDKMessageEnum.GET_PURCHASES);
    }

    public static void purchase(Context context, JSONObject jSONObject, DaemonRequest.Callback callback) throws JSONException {
        DaemonRequest.executeAsync(context, jSONObject, callback, SDKMessageEnum.PURCHASE);
    }

    public static void consumePurchase(Context context, JSONObject jSONObject, DaemonRequest.Callback callback) throws JSONException {
        DaemonRequest.executeAsync(context, jSONObject, callback, SDKMessageEnum.CONSUME_PURCHASE);
    }
}
