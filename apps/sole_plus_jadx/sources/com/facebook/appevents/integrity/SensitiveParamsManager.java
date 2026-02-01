package com.facebook.appevents.integrity;

import com.facebook.FacebookSdk;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: SensitiveParamsManager.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0007J\b\u0010\u000f\u001a\u00020\u000eH\u0007J\b\u0010\u0010\u001a\u00020\u000eH\u0002J&\u0010\u0011\u001a\u00020\u000e2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\f2\u0006\u0010\u0013\u001a\u00020\u0004H\u0007J,\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00042\u001a\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0007j\b\u0012\u0004\u0012\u00020\u0004`\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\u0007j\b\u0012\u0004\u0012\u00020\u0004`\b0\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/facebook/appevents/integrity/SensitiveParamsManager;", "", "()V", "DEFAULT_SENSITIVE_PARAMS_KEY", "", "SENSITIVE_PARAMS_KEY", "defaultSensitiveParameters", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "enabled", "", "sensitiveParameters", "", "disable", "", "enable", "loadSensitiveParameters", "processFilterSensitiveParams", "parameters", "eventName", "shouldFilterOut", "parameterKey", "sensitiveParamsForEvent", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class SensitiveParamsManager {
    private static final String DEFAULT_SENSITIVE_PARAMS_KEY = "_MTSDK_Default_";
    private static final String SENSITIVE_PARAMS_KEY = "_filteredKey";
    private static boolean enabled;
    public static final SensitiveParamsManager INSTANCE = new SensitiveParamsManager();
    private static HashSet<String> defaultSensitiveParameters = new HashSet<>();
    private static Map<String, HashSet<String>> sensitiveParameters = new HashMap();

    private SensitiveParamsManager() {
    }

    @JvmStatic
    public static final void enable() {
        Map<String, HashSet<String>> map;
        if (CrashShieldHandler.isObjectCrashing(SensitiveParamsManager.class)) {
            return;
        }
        try {
            INSTANCE.loadSensitiveParameters();
            HashSet<String> hashSet = defaultSensitiveParameters;
            if ((hashSet != null && !hashSet.isEmpty()) || ((map = sensitiveParameters) != null && !map.isEmpty())) {
                enabled = true;
                return;
            }
            enabled = false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, SensitiveParamsManager.class);
        }
    }

    @JvmStatic
    public static final void disable() {
        if (CrashShieldHandler.isObjectCrashing(SensitiveParamsManager.class)) {
            return;
        }
        try {
            enabled = false;
            sensitiveParameters = new HashMap();
            defaultSensitiveParameters = new HashSet<>();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, SensitiveParamsManager.class);
        }
    }

    private final void loadSensitiveParameters() {
        int length;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            int i = 0;
            FetchedAppSettings fetchedAppSettingsQueryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
            if (fetchedAppSettingsQueryAppSettings == null) {
                return;
            }
            try {
                defaultSensitiveParameters = new HashSet<>();
                sensitiveParameters = new HashMap();
                JSONArray sensitiveParams = fetchedAppSettingsQueryAppSettings.getSensitiveParams();
                if (sensitiveParams == null || sensitiveParams.length() == 0 || (length = sensitiveParams.length()) <= 0) {
                    return;
                }
                while (true) {
                    int i2 = i + 1;
                    JSONObject jSONObject = sensitiveParams.getJSONObject(i);
                    boolean zHas = jSONObject.has("key");
                    boolean zHas2 = jSONObject.has("value");
                    if (zHas && zHas2) {
                        String sensitiveParamsScope = jSONObject.getString("key");
                        JSONArray jSONArray = jSONObject.getJSONArray("value");
                        if (sensitiveParamsScope != null && jSONArray != null) {
                            Utility utility = Utility.INSTANCE;
                            HashSet<String> hashSetConvertJSONArrayToHashSet = Utility.convertJSONArrayToHashSet(jSONArray);
                            if (hashSetConvertJSONArrayToHashSet != null) {
                                if (sensitiveParamsScope.equals(DEFAULT_SENSITIVE_PARAMS_KEY)) {
                                    defaultSensitiveParameters = hashSetConvertJSONArrayToHashSet;
                                } else {
                                    Map<String, HashSet<String>> map = sensitiveParameters;
                                    Intrinsics.checkNotNullExpressionValue(sensitiveParamsScope, "sensitiveParamsScope");
                                    map.put(sensitiveParamsScope, hashSetConvertJSONArrayToHashSet);
                                }
                            }
                        }
                    }
                    if (i2 >= length) {
                        return;
                    } else {
                        i = i2;
                    }
                }
            } catch (Exception unused) {
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @JvmStatic
    public static final void processFilterSensitiveParams(Map<String, String> parameters, String eventName) {
        if (CrashShieldHandler.isObjectCrashing(SensitiveParamsManager.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(parameters, "parameters");
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            if (enabled) {
                HashSet<String> hashSet = defaultSensitiveParameters;
                if ((hashSet == null || hashSet.isEmpty()) && !sensitiveParameters.containsKey(eventName)) {
                    return;
                }
                JSONArray jSONArray = new JSONArray();
                try {
                    HashSet<String> hashSet2 = sensitiveParameters.get(eventName);
                    for (String str : new ArrayList(parameters.keySet())) {
                        if (INSTANCE.shouldFilterOut(str, hashSet2)) {
                            parameters.remove(str);
                            jSONArray.put(str);
                        }
                    }
                } catch (Exception unused) {
                }
                if (jSONArray.length() > 0) {
                    parameters.put(SENSITIVE_PARAMS_KEY, jSONArray.toString());
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, SensitiveParamsManager.class);
        }
    }

    private final boolean shouldFilterOut(String parameterKey, HashSet<String> sensitiveParamsForEvent) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            if (!defaultSensitiveParameters.contains(parameterKey)) {
                HashSet<String> hashSet = sensitiveParamsForEvent;
                if (hashSet != null && !hashSet.isEmpty()) {
                    if (!sensitiveParamsForEvent.contains(parameterKey)) {
                        return false;
                    }
                }
                return false;
            }
            return true;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }
}
