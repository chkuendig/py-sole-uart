package com.facebook.gamingservices.cloudgaming;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKLogger;
import java.net.HttpURLConnection;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DaemonReceiver {
    private static SDKLogger mLogger;
    private static ConcurrentHashMap<String, CompletableFuture<GraphResponse>> requestStore;
    private static DaemonReceiver single_instance;

    private DaemonReceiver(Context context) {
        IntentFilter intentFilter = new IntentFilter(SDKConstants.RECEIVER_INTENT);
        HandlerThread handlerThread = new HandlerThread(SDKConstants.RECEIVER_HANDLER);
        handlerThread.start();
        context.registerReceiver(new DaemonBroadcastReceiver(), intentFilter, null, new Handler(handlerThread.getLooper()));
        requestStore = new ConcurrentHashMap<>();
        mLogger = SDKLogger.getInstance(context);
    }

    synchronized ConcurrentHashMap<String, CompletableFuture<GraphResponse>> getRequestStore() {
        return requestStore;
    }

    static synchronized DaemonReceiver getInstance(Context context) {
        if (single_instance == null) {
            single_instance = new DaemonReceiver(context);
        }
        return single_instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static GraphResponse processResponse(JSONObject payload, String requestID) {
        if (!payload.isNull("success")) {
            return createSuccessResponse(payload, requestID);
        }
        if (!payload.isNull("error")) {
            return createErrorResponse(payload, requestID);
        }
        return createDefaultErrorResponse(requestID);
    }

    private static GraphResponse createSuccessResponse(JSONObject response, String requestID) {
        if (response.optJSONObject("success") != null) {
            mLogger.logSendingSuccessResponse(requestID);
            return new GraphResponse(new GraphRequest(), (HttpURLConnection) null, "", response.optJSONObject("success"));
        }
        if (response.optJSONArray("success") != null) {
            mLogger.logSendingSuccessResponse(requestID);
            return new GraphResponse(new GraphRequest(), (HttpURLConnection) null, "", response.optJSONArray("success"));
        }
        return createDefaultErrorResponse(requestID);
    }

    static GraphResponse createErrorResponse(FacebookRequestError error, String requestID) {
        mLogger.logSendingErrorResponse(error, requestID);
        return new GraphResponse(new GraphRequest(), null, error);
    }

    private static GraphResponse createErrorResponse(JSONObject response, String requestID) {
        JSONObject jSONObjectOptJSONObject = response.optJSONObject("error");
        if (jSONObjectOptJSONObject != null) {
            return createErrorResponse(new FacebookRequestError(jSONObjectOptJSONObject.optInt("code"), jSONObjectOptJSONObject.optString("type"), jSONObjectOptJSONObject.optString("message")), requestID);
        }
        return createDefaultErrorResponse(requestID);
    }

    private static GraphResponse createDefaultErrorResponse(String requestID) {
        return createErrorResponse(new FacebookRequestError(20, "UNSUPPORTED_FORMAT", "The response format is invalid."), requestID);
    }

    private static class DaemonBroadcastReceiver extends BroadcastReceiver {
        private DaemonBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) throws JSONException {
            CompletableFuture completableFuture;
            try {
                JSONObject jSONObject = new JSONObject(intent.getStringExtra(SDKConstants.RECEIVER_PAYLOAD));
                String string = jSONObject.getString(SDKConstants.REQUEST_ID);
                if (!DaemonReceiver.requestStore.containsKey(string) || (completableFuture = (CompletableFuture) DaemonReceiver.requestStore.remove(string)) == null) {
                    return;
                }
                completableFuture.complete(DaemonReceiver.processResponse(jSONObject, string));
            } catch (JSONException unused) {
            }
        }
    }
}
