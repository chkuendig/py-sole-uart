package com.facebook.appevents.ondeviceprocessing;

import android.content.Context;
import android.content.SharedPreferences;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEvent;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OnDeviceProcessingManager.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\u0007H\u0007J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0007J\u001c\u0010\u000e\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/facebook/appevents/ondeviceprocessing/OnDeviceProcessingManager;", "", "()V", "ALLOWED_IMPLICIT_EVENTS", "", "", "isEventEligibleForOnDeviceProcessing", "", "event", "Lcom/facebook/appevents/AppEvent;", "isOnDeviceProcessingEnabled", "sendCustomEventAsync", "", "applicationId", "sendInstallEventAsync", "preferencesName", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class OnDeviceProcessingManager {
    public static final OnDeviceProcessingManager INSTANCE = new OnDeviceProcessingManager();
    private static final Set<String> ALLOWED_IMPLICIT_EVENTS = SetsKt.setOf((Object[]) new String[]{AppEventsConstants.EVENT_NAME_PURCHASED, AppEventsConstants.EVENT_NAME_START_TRIAL, AppEventsConstants.EVENT_NAME_SUBSCRIBE});

    private OnDeviceProcessingManager() {
    }

    @JvmStatic
    public static final boolean isOnDeviceProcessingEnabled() {
        if (CrashShieldHandler.isObjectCrashing(OnDeviceProcessingManager.class)) {
            return false;
        }
        try {
            if ((FacebookSdk.getLimitEventAndDataUsage(FacebookSdk.getApplicationContext()) || Utility.isDataProcessingRestricted()) ? false : true) {
                return RemoteServiceWrapper.isServiceAvailable();
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, OnDeviceProcessingManager.class);
            return false;
        }
    }

    @JvmStatic
    public static final void sendInstallEventAsync(final String applicationId, final String preferencesName) {
        if (CrashShieldHandler.isObjectCrashing(OnDeviceProcessingManager.class)) {
            return;
        }
        try {
            final Context applicationContext = FacebookSdk.getApplicationContext();
            if (applicationContext == null || applicationId == null || preferencesName == null) {
                return;
            }
            FacebookSdk.getExecutor().execute(new Runnable() { // from class: com.facebook.appevents.ondeviceprocessing.OnDeviceProcessingManager.sendInstallEventAsync.1
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
                            SharedPreferences sharedPreferences = applicationContext.getSharedPreferences(preferencesName, 0);
                            String str = applicationId + "pingForOnDevice";
                            if (sharedPreferences.getLong(str, 0L) == 0) {
                                RemoteServiceWrapper.sendInstallEvent(applicationId);
                                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                                editorEdit.putLong(str, System.currentTimeMillis());
                                editorEdit.apply();
                            }
                        } catch (Throwable th) {
                            CrashShieldHandler.handleThrowable(th, this);
                        }
                    } catch (Throwable th2) {
                        CrashShieldHandler.handleThrowable(th2, this);
                    }
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, OnDeviceProcessingManager.class);
        }
    }

    @JvmStatic
    public static final void sendCustomEventAsync(final String applicationId, final AppEvent event) {
        if (CrashShieldHandler.isObjectCrashing(OnDeviceProcessingManager.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(applicationId, "applicationId");
            Intrinsics.checkNotNullParameter(event, "event");
            if (INSTANCE.isEventEligibleForOnDeviceProcessing(event)) {
                FacebookSdk.getExecutor().execute(new Runnable() { // from class: com.facebook.appevents.ondeviceprocessing.OnDeviceProcessingManager.sendCustomEventAsync.1
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
                                RemoteServiceWrapper.sendCustomEvents(applicationId, CollectionsKt.listOf(event));
                            } catch (Throwable th) {
                                CrashShieldHandler.handleThrowable(th, this);
                            }
                        } catch (Throwable th2) {
                            CrashShieldHandler.handleThrowable(th2, this);
                        }
                    }
                });
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, OnDeviceProcessingManager.class);
        }
    }

    private final boolean isEventEligibleForOnDeviceProcessing(AppEvent event) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            return (event.isImplicit() ^ true) || (event.isImplicit() && ALLOWED_IMPLICIT_EVENTS.contains(event.getName()));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }
}
