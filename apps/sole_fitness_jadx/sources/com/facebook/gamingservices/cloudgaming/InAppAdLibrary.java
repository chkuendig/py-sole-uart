package com.facebook.gamingservices.cloudgaming;

import android.content.Context;
import com.facebook.gamingservices.cloudgaming.DaemonRequest;
import com.facebook.gamingservices.cloudgaming.internal.SDKLogger;
import com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class InAppAdLibrary {

    @Deprecated
    public static final String PLACEMENT_ID = "placementID";

    public static void loadRewardedVideo(Context context, String str, DaemonRequest.Callback callback) {
        try {
            DaemonRequest.executeAsync(context, new JSONObject().put("placementID", str), callback, SDKMessageEnum.LOAD_REWARDED_VIDEO);
        } catch (JSONException e) {
            SDKLogger.logInternalError(context, SDKMessageEnum.LOAD_REWARDED_VIDEO, e);
        }
    }

    public static void loadInterstitialAd(Context context, String str, DaemonRequest.Callback callback) {
        try {
            DaemonRequest.executeAsync(context, new JSONObject().put("placementID", str), callback, SDKMessageEnum.LOAD_INTERSTITIAL_AD);
        } catch (JSONException e) {
            SDKLogger.logInternalError(context, SDKMessageEnum.LOAD_INTERSTITIAL_AD, e);
        }
    }

    public static void showRewardedVideo(Context context, String str, DaemonRequest.Callback callback) {
        try {
            DaemonRequest.executeAsync(context, new JSONObject().put("placementID", str), callback, SDKMessageEnum.SHOW_REWARDED_VIDEO);
        } catch (JSONException e) {
            SDKLogger.logInternalError(context, SDKMessageEnum.SHOW_REWARDED_VIDEO, e);
        }
    }

    public static void showInterstitialAd(Context context, String str, DaemonRequest.Callback callback) {
        try {
            DaemonRequest.executeAsync(context, new JSONObject().put("placementID", str), callback, SDKMessageEnum.SHOW_INTERSTITIAL_AD);
        } catch (JSONException e) {
            SDKLogger.logInternalError(context, SDKMessageEnum.SHOW_INTERSTITIAL_AD, e);
        }
    }

    public static void loadRewardedVideo(Context context, JSONObject jSONObject, DaemonRequest.Callback callback) throws JSONException {
        DaemonRequest.executeAsync(context, jSONObject, callback, SDKMessageEnum.LOAD_REWARDED_VIDEO);
    }

    public static void loadInterstitialAd(Context context, JSONObject jSONObject, DaemonRequest.Callback callback) throws JSONException {
        DaemonRequest.executeAsync(context, jSONObject, callback, SDKMessageEnum.LOAD_INTERSTITIAL_AD);
    }

    public static void showRewardedVideo(Context context, JSONObject jSONObject, DaemonRequest.Callback callback) throws JSONException {
        DaemonRequest.executeAsync(context, jSONObject, callback, SDKMessageEnum.SHOW_REWARDED_VIDEO);
    }

    public static void showInterstitialAd(Context context, JSONObject jSONObject, DaemonRequest.Callback callback) throws JSONException {
        DaemonRequest.executeAsync(context, jSONObject, callback, SDKMessageEnum.SHOW_INTERSTITIAL_AD);
    }
}
