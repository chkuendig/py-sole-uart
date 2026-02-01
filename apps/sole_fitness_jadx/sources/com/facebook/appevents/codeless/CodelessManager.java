package com.facebook.appevents.codeless;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.codeless.ViewIndexingTrigger;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: CodelessManager.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0001¢\u0006\u0002\b\u0013J\b\u0010\u0014\u001a\u00020\u0011H\u0007J\b\u0010\u0015\u001a\u00020\u0011H\u0007J\r\u0010\u0016\u001a\u00020\u0004H\u0001¢\u0006\u0002\b\u0017J\r\u0010\u0018\u001a\u00020\bH\u0001¢\u0006\u0002\b\u0019J\r\u0010\u001a\u001a\u00020\bH\u0001¢\u0006\u0002\b\u001bJ\u0010\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\u0010\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\u0010\u0010 \u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\u0015\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\bH\u0001¢\u0006\u0002\b#R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/facebook/appevents/codeless/CodelessManager;", "", "()V", "deviceSessionID", "", "isAppIndexingEnabled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isCheckingSession", "", "isCodelessEnabled", "sensorManager", "Landroid/hardware/SensorManager;", "viewIndexer", "Lcom/facebook/appevents/codeless/ViewIndexer;", "viewIndexingTrigger", "Lcom/facebook/appevents/codeless/ViewIndexingTrigger;", "checkCodelessSession", "", "applicationId", "checkCodelessSession$facebook_core_release", "disable", "enable", "getCurrentDeviceSessionID", "getCurrentDeviceSessionID$facebook_core_release", "getIsAppIndexingEnabled", "getIsAppIndexingEnabled$facebook_core_release", "isDebugOnEmulator", "isDebugOnEmulator$facebook_core_release", "onActivityDestroyed", "activity", "Landroid/app/Activity;", "onActivityPaused", "onActivityResumed", "updateAppIndexing", "appIndexingEnabled", "updateAppIndexing$facebook_core_release", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class CodelessManager {
    private static String deviceSessionID;
    private static volatile boolean isCheckingSession;
    private static SensorManager sensorManager;
    private static ViewIndexer viewIndexer;
    public static final CodelessManager INSTANCE = new CodelessManager();
    private static final ViewIndexingTrigger viewIndexingTrigger = new ViewIndexingTrigger();
    private static final AtomicBoolean isCodelessEnabled = new AtomicBoolean(true);
    private static final AtomicBoolean isAppIndexingEnabled = new AtomicBoolean(false);

    @JvmStatic
    public static final boolean isDebugOnEmulator$facebook_core_release() {
        CrashShieldHandler.isObjectCrashing(CodelessManager.class);
        return false;
    }

    private CodelessManager() {
    }

    public static final /* synthetic */ String access$getDeviceSessionID$p(CodelessManager codelessManager) {
        if (CrashShieldHandler.isObjectCrashing(CodelessManager.class)) {
            return null;
        }
        try {
            return deviceSessionID;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CodelessManager.class);
            return null;
        }
    }

    public static final /* synthetic */ ViewIndexer access$getViewIndexer$p(CodelessManager codelessManager) {
        if (CrashShieldHandler.isObjectCrashing(CodelessManager.class)) {
            return null;
        }
        try {
            return viewIndexer;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CodelessManager.class);
            return null;
        }
    }

    public static final /* synthetic */ AtomicBoolean access$isAppIndexingEnabled$p(CodelessManager codelessManager) {
        if (CrashShieldHandler.isObjectCrashing(CodelessManager.class)) {
            return null;
        }
        try {
            return isAppIndexingEnabled;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CodelessManager.class);
            return null;
        }
    }

    public static final /* synthetic */ boolean access$isCheckingSession$p(CodelessManager codelessManager) {
        if (CrashShieldHandler.isObjectCrashing(CodelessManager.class)) {
            return false;
        }
        try {
            return isCheckingSession;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CodelessManager.class);
            return false;
        }
    }

    public static final /* synthetic */ void access$setCheckingSession$p(CodelessManager codelessManager, boolean z) {
        if (CrashShieldHandler.isObjectCrashing(CodelessManager.class)) {
            return;
        }
        try {
            isCheckingSession = z;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CodelessManager.class);
        }
    }

    public static final /* synthetic */ void access$setDeviceSessionID$p(CodelessManager codelessManager, String str) {
        if (CrashShieldHandler.isObjectCrashing(CodelessManager.class)) {
            return;
        }
        try {
            deviceSessionID = str;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CodelessManager.class);
        }
    }

    public static final /* synthetic */ void access$setViewIndexer$p(CodelessManager codelessManager, ViewIndexer viewIndexer2) {
        if (CrashShieldHandler.isObjectCrashing(CodelessManager.class)) {
            return;
        }
        try {
            viewIndexer = viewIndexer2;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CodelessManager.class);
        }
    }

    @JvmStatic
    public static final void onActivityResumed(Activity activity) {
        if (CrashShieldHandler.isObjectCrashing(CodelessManager.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (isCodelessEnabled.get()) {
                CodelessMatcher.INSTANCE.getInstance().add(activity);
                Context applicationContext = activity.getApplicationContext();
                final String applicationId = FacebookSdk.getApplicationId();
                final FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(applicationId);
                if ((appSettingsWithoutQuery != null && appSettingsWithoutQuery.getCodelessEventsEnabled()) || isDebugOnEmulator$facebook_core_release()) {
                    SensorManager sensorManager2 = (SensorManager) applicationContext.getSystemService("sensor");
                    sensorManager = sensorManager2;
                    if (sensorManager2 == null) {
                        return;
                    }
                    if (sensorManager2 != null) {
                        Sensor defaultSensor = sensorManager2.getDefaultSensor(1);
                        viewIndexer = new ViewIndexer(activity);
                        ViewIndexingTrigger viewIndexingTrigger2 = viewIndexingTrigger;
                        viewIndexingTrigger2.setOnShakeListener(new ViewIndexingTrigger.OnShakeListener() { // from class: com.facebook.appevents.codeless.CodelessManager.onActivityResumed.1
                            @Override // com.facebook.appevents.codeless.ViewIndexingTrigger.OnShakeListener
                            public final void onShake() {
                                FetchedAppSettings fetchedAppSettings = appSettingsWithoutQuery;
                                boolean z = fetchedAppSettings != null && fetchedAppSettings.getCodelessEventsEnabled();
                                boolean z2 = FacebookSdk.getCodelessSetupEnabled();
                                if (z && z2) {
                                    CodelessManager.checkCodelessSession$facebook_core_release(applicationId);
                                }
                            }
                        });
                        SensorManager sensorManager3 = sensorManager;
                        if (sensorManager3 == null) {
                            throw new IllegalStateException("Required value was null.".toString());
                        }
                        sensorManager3.registerListener(viewIndexingTrigger2, defaultSensor, 2);
                        if (appSettingsWithoutQuery != null && appSettingsWithoutQuery.getCodelessEventsEnabled()) {
                            ViewIndexer viewIndexer2 = viewIndexer;
                            if (viewIndexer2 == null) {
                                throw new IllegalStateException("Required value was null.".toString());
                            }
                            viewIndexer2.schedule();
                        }
                    } else {
                        throw new IllegalStateException("Required value was null.".toString());
                    }
                }
                if (!isDebugOnEmulator$facebook_core_release() || isAppIndexingEnabled.get()) {
                    return;
                }
                checkCodelessSession$facebook_core_release(applicationId);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CodelessManager.class);
        }
    }

    @JvmStatic
    public static final void onActivityPaused(Activity activity) {
        if (CrashShieldHandler.isObjectCrashing(CodelessManager.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (isCodelessEnabled.get()) {
                CodelessMatcher.INSTANCE.getInstance().remove(activity);
                ViewIndexer viewIndexer2 = viewIndexer;
                if (viewIndexer2 != null) {
                    viewIndexer2.unschedule();
                }
                SensorManager sensorManager2 = sensorManager;
                if (sensorManager2 != null) {
                    sensorManager2.unregisterListener(viewIndexingTrigger);
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CodelessManager.class);
        }
    }

    @JvmStatic
    public static final void onActivityDestroyed(Activity activity) {
        if (CrashShieldHandler.isObjectCrashing(CodelessManager.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(activity, "activity");
            CodelessMatcher.INSTANCE.getInstance().destroy(activity);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CodelessManager.class);
        }
    }

    @JvmStatic
    public static final void enable() {
        if (CrashShieldHandler.isObjectCrashing(CodelessManager.class)) {
            return;
        }
        try {
            isCodelessEnabled.set(true);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CodelessManager.class);
        }
    }

    @JvmStatic
    public static final void disable() {
        if (CrashShieldHandler.isObjectCrashing(CodelessManager.class)) {
            return;
        }
        try {
            isCodelessEnabled.set(false);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CodelessManager.class);
        }
    }

    @JvmStatic
    public static final void checkCodelessSession$facebook_core_release(final String applicationId) {
        if (CrashShieldHandler.isObjectCrashing(CodelessManager.class)) {
            return;
        }
        try {
            if (isCheckingSession) {
                return;
            }
            isCheckingSession = true;
            FacebookSdk.getExecutor().execute(new Runnable() { // from class: com.facebook.appevents.codeless.CodelessManager$checkCodelessSession$1
                @Override // java.lang.Runnable
                public final void run() {
                    String str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                    if (CrashShieldHandler.isObjectCrashing(this)) {
                        return;
                    }
                    try {
                        if (CrashShieldHandler.isObjectCrashing(this)) {
                            return;
                        }
                        try {
                            GraphRequest.Companion companion = GraphRequest.INSTANCE;
                            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                            boolean z = true;
                            String str2 = String.format(Locale.US, "%s/app_indexing_session", Arrays.copyOf(new Object[]{applicationId}, 1));
                            Intrinsics.checkNotNullExpressionValue(str2, "java.lang.String.format(locale, format, *args)");
                            GraphRequest graphRequestNewPostRequest = companion.newPostRequest(null, str2, null, null);
                            Bundle parameters = graphRequestNewPostRequest.getParameters();
                            if (parameters == null) {
                                parameters = new Bundle();
                            }
                            AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.INSTANCE.getAttributionIdentifiers(FacebookSdk.getApplicationContext());
                            JSONArray jSONArray = new JSONArray();
                            jSONArray.put(Build.MODEL != null ? Build.MODEL : "");
                            if ((attributionIdentifiers != null ? attributionIdentifiers.getAndroidAdvertiserId() : null) != null) {
                                jSONArray.put(attributionIdentifiers.getAndroidAdvertiserId());
                            } else {
                                jSONArray.put("");
                            }
                            jSONArray.put(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                            if (AppEventUtility.isEmulator()) {
                                str = AppEventsConstants.EVENT_PARAM_VALUE_YES;
                            }
                            jSONArray.put(str);
                            Locale currentLocale = Utility.getCurrentLocale();
                            jSONArray.put(currentLocale.getLanguage() + "_" + currentLocale.getCountry());
                            String string = jSONArray.toString();
                            Intrinsics.checkNotNullExpressionValue(string, "extInfoArray.toString()");
                            parameters.putString(Constants.DEVICE_SESSION_ID, CodelessManager.getCurrentDeviceSessionID$facebook_core_release());
                            parameters.putString(Constants.EXTINFO, string);
                            graphRequestNewPostRequest.setParameters(parameters);
                            JSONObject graphObject = graphRequestNewPostRequest.executeAndWait().getGraphObject();
                            AtomicBoolean atomicBooleanAccess$isAppIndexingEnabled$p = CodelessManager.access$isAppIndexingEnabled$p(CodelessManager.INSTANCE);
                            if (graphObject == null || !graphObject.optBoolean(Constants.APP_INDEXING_ENABLED, false)) {
                                z = false;
                            }
                            atomicBooleanAccess$isAppIndexingEnabled$p.set(z);
                            if (!CodelessManager.access$isAppIndexingEnabled$p(CodelessManager.INSTANCE).get()) {
                                CodelessManager.access$setDeviceSessionID$p(CodelessManager.INSTANCE, null);
                            } else {
                                ViewIndexer viewIndexerAccess$getViewIndexer$p = CodelessManager.access$getViewIndexer$p(CodelessManager.INSTANCE);
                                if (viewIndexerAccess$getViewIndexer$p != null) {
                                    viewIndexerAccess$getViewIndexer$p.schedule();
                                }
                            }
                            CodelessManager.access$setCheckingSession$p(CodelessManager.INSTANCE, false);
                        } catch (Throwable th) {
                            CrashShieldHandler.handleThrowable(th, this);
                        }
                    } catch (Throwable th2) {
                        CrashShieldHandler.handleThrowable(th2, this);
                    }
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CodelessManager.class);
        }
    }

    @JvmStatic
    public static final String getCurrentDeviceSessionID$facebook_core_release() {
        if (CrashShieldHandler.isObjectCrashing(CodelessManager.class)) {
            return null;
        }
        try {
            if (deviceSessionID == null) {
                deviceSessionID = UUID.randomUUID().toString();
            }
            String str = deviceSessionID;
            if (str != null) {
                return str;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CodelessManager.class);
            return null;
        }
    }

    @JvmStatic
    public static final boolean getIsAppIndexingEnabled$facebook_core_release() {
        if (CrashShieldHandler.isObjectCrashing(CodelessManager.class)) {
            return false;
        }
        try {
            return isAppIndexingEnabled.get();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CodelessManager.class);
            return false;
        }
    }

    @JvmStatic
    public static final void updateAppIndexing$facebook_core_release(boolean appIndexingEnabled) {
        if (CrashShieldHandler.isObjectCrashing(CodelessManager.class)) {
            return;
        }
        try {
            isAppIndexingEnabled.set(appIndexingEnabled);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CodelessManager.class);
        }
    }
}
