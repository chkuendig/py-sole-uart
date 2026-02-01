package com.facebook.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.gatekeeper.GateKeeper;
import com.facebook.internal.gatekeeper.GateKeeperRuntimeCache;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FetchedAppGateKeepersManager.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001:\u00013B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0004H\u0002J\"\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\u0006\u0010!\u001a\u00020\u001fH\u0007J\u001c\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001f0#2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004J\u0017\u0010$\u001a\u00020\u001f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0002\u0010%J\u0006\u0010&\u001a\u00020'J\u0012\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0012H\u0007J\u001f\u0010)\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00042\b\u0010*\u001a\u0004\u0018\u00010\u0015H\u0001¢\u0006\u0002\b+J\b\u0010,\u001a\u00020'H\u0002J\u0018\u0010-\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u001fH\u0007J\b\u0010/\u001a\u00020'H\u0007J\u001a\u00100\u001a\u00020'2\b\b\u0002\u0010\u001d\u001a\u00020\u00042\u0006\u00101\u001a\u000202H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001b¨\u00064"}, d2 = {"Lcom/facebook/internal/FetchedAppGateKeepersManager;", "", "()V", "APPLICATION_FIELDS", "", "APPLICATION_GATEKEEPER_CACHE_TIMEOUT", "", "APPLICATION_GATEKEEPER_EDGE", "APPLICATION_GATEKEEPER_FIELD", "APPLICATION_GRAPH_DATA", "APPLICATION_PLATFORM", "APPLICATION_SDK_VERSION", "APP_GATEKEEPERS_PREFS_KEY_FORMAT", "APP_GATEKEEPERS_PREFS_STORE", "APP_PLATFORM", "TAG", "callbacks", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/facebook/internal/FetchedAppGateKeepersManager$Callback;", "fetchedAppGateKeepers", "", "Lorg/json/JSONObject;", "gateKeeperRuntimeCache", "Lcom/facebook/internal/gatekeeper/GateKeeperRuntimeCache;", "isLoading", "Ljava/util/concurrent/atomic/AtomicBoolean;", "timestamp", "Ljava/lang/Long;", "getAppGateKeepersQueryResponse", "applicationId", "getGateKeeperForKey", "", "name", "defaultValue", "getGateKeepersForApplication", "", "isTimestampValid", "(Ljava/lang/Long;)Z", "loadAppGateKeepersAsync", "", "callback", "parseAppGateKeepersFromJSON", "gateKeepersJSON", "parseAppGateKeepersFromJSON$facebook_core_release", "pollCallbacks", "queryAppGateKeepers", "forceRequery", "resetRuntimeGateKeeperCache", "setRuntimeGateKeeper", "gateKeeper", "Lcom/facebook/internal/gatekeeper/GateKeeper;", "Callback", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class FetchedAppGateKeepersManager {
    private static final String APPLICATION_FIELDS = "fields";
    private static final long APPLICATION_GATEKEEPER_CACHE_TIMEOUT = 3600000;
    private static final String APPLICATION_GATEKEEPER_EDGE = "mobile_sdk_gk";
    private static final String APPLICATION_GATEKEEPER_FIELD = "gatekeepers";
    private static final String APPLICATION_GRAPH_DATA = "data";
    private static final String APPLICATION_PLATFORM = "platform";
    private static final String APPLICATION_SDK_VERSION = "sdk_version";
    private static final String APP_GATEKEEPERS_PREFS_KEY_FORMAT = "com.facebook.internal.APP_GATEKEEPERS.%s";
    private static final String APP_GATEKEEPERS_PREFS_STORE = "com.facebook.internal.preferences.APP_GATEKEEPERS";
    private static final String APP_PLATFORM = "android";
    private static GateKeeperRuntimeCache gateKeeperRuntimeCache;
    private static Long timestamp;
    public static final FetchedAppGateKeepersManager INSTANCE = new FetchedAppGateKeepersManager();
    private static final String TAG = Reflection.getOrCreateKotlinClass(FetchedAppGateKeepersManager.class).getSimpleName();
    private static final AtomicBoolean isLoading = new AtomicBoolean(false);
    private static final ConcurrentLinkedQueue<Callback> callbacks = new ConcurrentLinkedQueue<>();
    private static final Map<String, JSONObject> fetchedAppGateKeepers = new ConcurrentHashMap();

    /* compiled from: FetchedAppGateKeepersManager.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/facebook/internal/FetchedAppGateKeepersManager$Callback;", "", "onCompleted", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public interface Callback {
        void onCompleted();
    }

    private FetchedAppGateKeepersManager() {
    }

    public static final /* synthetic */ AtomicBoolean access$isLoading$p(FetchedAppGateKeepersManager fetchedAppGateKeepersManager) {
        return isLoading;
    }

    public final void loadAppGateKeepersAsync() {
        loadAppGateKeepersAsync(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0042 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0044 A[Catch: all -> 0x008a, TRY_ENTER, TryCatch #0 {, blocks: (B:5:0x0005, B:6:0x000a, B:8:0x0018, B:10:0x0020, B:13:0x0025, B:17:0x0044, B:19:0x0055, B:20:0x0058, B:25:0x0069, B:23:0x0060, B:26:0x006c, B:28:0x0072, B:32:0x007c), top: B:40:0x0005, inners: #1 }] */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final synchronized void loadAppGateKeepersAsync(Callback callback) {
        final String applicationId;
        FetchedAppGateKeepersManager fetchedAppGateKeepersManager;
        final Context applicationContext;
        if (callback != null) {
            callbacks.add(callback);
            applicationId = FacebookSdk.getApplicationId();
            fetchedAppGateKeepersManager = INSTANCE;
            if (!fetchedAppGateKeepersManager.isTimestampValid(timestamp) && fetchedAppGateKeepers.containsKey(applicationId)) {
                fetchedAppGateKeepersManager.pollCallbacks();
                return;
            }
            applicationContext = FacebookSdk.getApplicationContext();
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            final String str = String.format(APP_GATEKEEPERS_PREFS_KEY_FORMAT, Arrays.copyOf(new Object[]{applicationId}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "java.lang.String.format(format, *args)");
            if (applicationContext != null) {
                return;
            }
            JSONObject jSONObject = null;
            String string = applicationContext.getSharedPreferences(APP_GATEKEEPERS_PREFS_STORE, 0).getString(str, null);
            if (!Utility.isNullOrEmpty(string)) {
                try {
                    jSONObject = new JSONObject(string);
                } catch (JSONException e) {
                    Utility.logd(Utility.LOG_TAG, e);
                }
                if (jSONObject != null) {
                    parseAppGateKeepersFromJSON$facebook_core_release(applicationId, jSONObject);
                }
            }
            Executor executor = FacebookSdk.getExecutor();
            if (executor != null) {
                if (isLoading.compareAndSet(false, true)) {
                    executor.execute(new Runnable() { // from class: com.facebook.internal.FetchedAppGateKeepersManager.loadAppGateKeepersAsync.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (CrashShieldHandler.isObjectCrashing(this)) {
                                return;
                            }
                            try {
                                if (CrashShieldHandler.isObjectCrashing(this)) {
                                    return;
                                }
                                try {
                                    JSONObject appGateKeepersQueryResponse = FetchedAppGateKeepersManager.INSTANCE.getAppGateKeepersQueryResponse(applicationId);
                                    if (appGateKeepersQueryResponse.length() != 0) {
                                        FetchedAppGateKeepersManager.parseAppGateKeepersFromJSON$facebook_core_release(applicationId, appGateKeepersQueryResponse);
                                        applicationContext.getSharedPreferences(FetchedAppGateKeepersManager.APP_GATEKEEPERS_PREFS_STORE, 0).edit().putString(str, appGateKeepersQueryResponse.toString()).apply();
                                        FetchedAppGateKeepersManager fetchedAppGateKeepersManager2 = FetchedAppGateKeepersManager.INSTANCE;
                                        FetchedAppGateKeepersManager.timestamp = Long.valueOf(System.currentTimeMillis());
                                    }
                                    FetchedAppGateKeepersManager.INSTANCE.pollCallbacks();
                                    FetchedAppGateKeepersManager.access$isLoading$p(FetchedAppGateKeepersManager.INSTANCE).set(false);
                                } catch (Throwable th) {
                                    CrashShieldHandler.handleThrowable(th, this);
                                }
                            } catch (Throwable th2) {
                                CrashShieldHandler.handleThrowable(th2, this);
                            }
                        }
                    });
                    return;
                }
                return;
            }
            return;
        }
        applicationId = FacebookSdk.getApplicationId();
        fetchedAppGateKeepersManager = INSTANCE;
        if (!fetchedAppGateKeepersManager.isTimestampValid(timestamp)) {
        }
        applicationContext = FacebookSdk.getApplicationContext();
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        final String str2 = String.format(APP_GATEKEEPERS_PREFS_KEY_FORMAT, Arrays.copyOf(new Object[]{applicationId}, 1));
        Intrinsics.checkNotNullExpressionValue(str2, "java.lang.String.format(format, *args)");
        if (applicationContext != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pollCallbacks() {
        Handler handler = new Handler(Looper.getMainLooper());
        while (true) {
            ConcurrentLinkedQueue<Callback> concurrentLinkedQueue = callbacks;
            if (concurrentLinkedQueue.isEmpty()) {
                return;
            }
            final Callback callbackPoll = concurrentLinkedQueue.poll();
            if (callbackPoll != null) {
                handler.post(new Runnable() { // from class: com.facebook.internal.FetchedAppGateKeepersManager.pollCallbacks.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (CrashShieldHandler.isObjectCrashing(this)) {
                            return;
                        }
                        try {
                            if (CrashShieldHandler.isObjectCrashing(this)) {
                                return;
                            }
                            try {
                                callbackPoll.onCompleted();
                            } catch (Throwable th) {
                                CrashShieldHandler.handleThrowable(th, this);
                            }
                        } catch (Throwable th2) {
                            CrashShieldHandler.handleThrowable(th2, this);
                        }
                    }
                });
            }
        }
    }

    @JvmStatic
    public static final JSONObject queryAppGateKeepers(String applicationId, boolean forceRequery) {
        Intrinsics.checkNotNullParameter(applicationId, "applicationId");
        if (!forceRequery) {
            Map<String, JSONObject> map = fetchedAppGateKeepers;
            if (map.containsKey(applicationId)) {
                JSONObject jSONObject = map.get(applicationId);
                return jSONObject != null ? jSONObject : new JSONObject();
            }
        }
        JSONObject appGateKeepersQueryResponse = INSTANCE.getAppGateKeepersQueryResponse(applicationId);
        Context applicationContext = FacebookSdk.getApplicationContext();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(APP_GATEKEEPERS_PREFS_KEY_FORMAT, Arrays.copyOf(new Object[]{applicationId}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "java.lang.String.format(format, *args)");
        applicationContext.getSharedPreferences(APP_GATEKEEPERS_PREFS_STORE, 0).edit().putString(str, appGateKeepersQueryResponse.toString()).apply();
        return parseAppGateKeepersFromJSON$facebook_core_release(applicationId, appGateKeepersQueryResponse);
    }

    public final Map<String, Boolean> getGateKeepersForApplication(String applicationId) {
        loadAppGateKeepersAsync();
        if (applicationId != null) {
            Map<String, JSONObject> map = fetchedAppGateKeepers;
            if (map.containsKey(applicationId)) {
                GateKeeperRuntimeCache gateKeeperRuntimeCache2 = gateKeeperRuntimeCache;
                List<GateKeeper> listDumpGateKeepers = gateKeeperRuntimeCache2 != null ? gateKeeperRuntimeCache2.dumpGateKeepers(applicationId) : null;
                if (listDumpGateKeepers != null) {
                    HashMap map2 = new HashMap();
                    for (GateKeeper gateKeeper : listDumpGateKeepers) {
                        map2.put(gateKeeper.getName(), Boolean.valueOf(gateKeeper.getValue()));
                    }
                    return map2;
                }
                HashMap map3 = new HashMap();
                JSONObject jSONObject = map.get(applicationId);
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String key = itKeys.next();
                    Intrinsics.checkNotNullExpressionValue(key, "key");
                    map3.put(key, Boolean.valueOf(jSONObject.optBoolean(key)));
                }
                GateKeeperRuntimeCache gateKeeperRuntimeCache3 = gateKeeperRuntimeCache;
                if (gateKeeperRuntimeCache3 == null) {
                    gateKeeperRuntimeCache3 = new GateKeeperRuntimeCache();
                }
                ArrayList arrayList = new ArrayList(map3.size());
                for (Map.Entry entry : map3.entrySet()) {
                    arrayList.add(new GateKeeper((String) entry.getKey(), ((Boolean) entry.getValue()).booleanValue()));
                }
                gateKeeperRuntimeCache3.setGateKeepers(applicationId, arrayList);
                gateKeeperRuntimeCache = gateKeeperRuntimeCache3;
                return map3;
            }
        }
        return new HashMap();
    }

    @JvmStatic
    public static final boolean getGateKeeperForKey(String name, String applicationId, boolean defaultValue) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(name, "name");
        Map<String, Boolean> gateKeepersForApplication = INSTANCE.getGateKeepersForApplication(applicationId);
        return (gateKeepersForApplication.containsKey(name) && (bool = gateKeepersForApplication.get(name)) != null) ? bool.booleanValue() : defaultValue;
    }

    public static /* synthetic */ void setRuntimeGateKeeper$default(String str, GateKeeper gateKeeper, int i, Object obj) {
        if ((i & 1) != 0) {
            str = FacebookSdk.getApplicationId();
        }
        setRuntimeGateKeeper(str, gateKeeper);
    }

    @JvmStatic
    public static final void setRuntimeGateKeeper(String applicationId, GateKeeper gateKeeper) {
        Intrinsics.checkNotNullParameter(applicationId, "applicationId");
        Intrinsics.checkNotNullParameter(gateKeeper, "gateKeeper");
        GateKeeperRuntimeCache gateKeeperRuntimeCache2 = gateKeeperRuntimeCache;
        if ((gateKeeperRuntimeCache2 != null ? gateKeeperRuntimeCache2.getGateKeeper(applicationId, gateKeeper.getName()) : null) != null) {
            GateKeeperRuntimeCache gateKeeperRuntimeCache3 = gateKeeperRuntimeCache;
            if (gateKeeperRuntimeCache3 != null) {
                gateKeeperRuntimeCache3.setGateKeeper(applicationId, gateKeeper);
                return;
            }
            return;
        }
        Log.w(TAG, "Missing gatekeeper runtime cache");
    }

    @JvmStatic
    public static final void resetRuntimeGateKeeperCache() {
        GateKeeperRuntimeCache gateKeeperRuntimeCache2 = gateKeeperRuntimeCache;
        if (gateKeeperRuntimeCache2 != null) {
            GateKeeperRuntimeCache.resetCache$default(gateKeeperRuntimeCache2, null, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject getAppGateKeepersQueryResponse(String applicationId) {
        Bundle bundle = new Bundle();
        bundle.putString(APPLICATION_PLATFORM, "android");
        bundle.putString(APPLICATION_SDK_VERSION, FacebookSdk.getSdkVersion());
        bundle.putString("fields", APPLICATION_GATEKEEPER_FIELD);
        GraphRequest.Companion companion = GraphRequest.INSTANCE;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("%s/%s", Arrays.copyOf(new Object[]{applicationId, APPLICATION_GATEKEEPER_EDGE}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "java.lang.String.format(format, *args)");
        GraphRequest graphRequestNewGraphPathRequest = companion.newGraphPathRequest(null, str, null);
        graphRequestNewGraphPathRequest.setSkipClientToken(true);
        graphRequestNewGraphPathRequest.setParameters(bundle);
        JSONObject jsonObject = graphRequestNewGraphPathRequest.executeAndWait().getJsonObject();
        return jsonObject != null ? jsonObject : new JSONObject();
    }

    @JvmStatic
    public static final synchronized JSONObject parseAppGateKeepersFromJSON$facebook_core_release(String applicationId, JSONObject gateKeepersJSON) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONArray jSONArrayOptJSONArray;
        Intrinsics.checkNotNullParameter(applicationId, "applicationId");
        jSONObject = fetchedAppGateKeepers.get(applicationId);
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (gateKeepersJSON == null || (jSONArrayOptJSONArray = gateKeepersJSON.optJSONArray("data")) == null || (jSONObject2 = jSONArrayOptJSONArray.optJSONObject(0)) == null) {
            jSONObject2 = new JSONObject();
        }
        JSONArray jSONArrayOptJSONArray2 = jSONObject2.optJSONArray(APPLICATION_GATEKEEPER_FIELD);
        if (jSONArrayOptJSONArray2 == null) {
            jSONArrayOptJSONArray2 = new JSONArray();
        }
        int length = jSONArrayOptJSONArray2.length();
        for (int i = 0; i < length; i++) {
            try {
                JSONObject jSONObject3 = jSONArrayOptJSONArray2.getJSONObject(i);
                jSONObject.put(jSONObject3.getString(SDKConstants.PARAM_KEY), jSONObject3.getBoolean("value"));
            } catch (JSONException e) {
                Utility.logd(Utility.LOG_TAG, e);
            }
        }
        fetchedAppGateKeepers.put(applicationId, jSONObject);
        return jSONObject;
    }

    private final boolean isTimestampValid(Long timestamp2) {
        return timestamp2 != null && System.currentTimeMillis() - timestamp2.longValue() < 3600000;
    }
}
