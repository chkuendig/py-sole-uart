package com.facebook.appevents.aam;

import android.app.Activity;
import com.facebook.FacebookSdk;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MetadataIndexer.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\f\u001a\u00020\bH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/facebook/appevents/aam/MetadataIndexer;", "", "()V", "TAG", "", "enabled", "", "enable", "", "onActivityResumed", "activity", "Landroid/app/Activity;", "updateRules", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class MetadataIndexer {
    public static final MetadataIndexer INSTANCE = new MetadataIndexer();
    private static final String TAG = MetadataIndexer.class.getCanonicalName();
    private static boolean enabled;

    private MetadataIndexer() {
    }

    public static final /* synthetic */ boolean access$getEnabled$p(MetadataIndexer metadataIndexer) {
        if (CrashShieldHandler.isObjectCrashing(MetadataIndexer.class)) {
            return false;
        }
        try {
            return enabled;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MetadataIndexer.class);
            return false;
        }
    }

    public static final /* synthetic */ void access$setEnabled$p(MetadataIndexer metadataIndexer, boolean z) {
        if (CrashShieldHandler.isObjectCrashing(MetadataIndexer.class)) {
            return;
        }
        try {
            enabled = z;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MetadataIndexer.class);
        }
    }

    public static final /* synthetic */ void access$updateRules(MetadataIndexer metadataIndexer) {
        if (CrashShieldHandler.isObjectCrashing(MetadataIndexer.class)) {
            return;
        }
        try {
            metadataIndexer.updateRules();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MetadataIndexer.class);
        }
    }

    @JvmStatic
    public static final void onActivityResumed(Activity activity) {
        if (CrashShieldHandler.isObjectCrashing(MetadataIndexer.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(activity, "activity");
            try {
                if (enabled && !MetadataRule.INSTANCE.getRules().isEmpty()) {
                    MetadataViewObserver.INSTANCE.startTrackingActivity(activity);
                }
            } catch (Exception unused) {
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MetadataIndexer.class);
        }
    }

    private final void updateRules() {
        String rawAamRules;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            FetchedAppSettings fetchedAppSettingsQueryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
            if (fetchedAppSettingsQueryAppSettings == null || (rawAamRules = fetchedAppSettingsQueryAppSettings.getRawAamRules()) == null) {
                return;
            }
            MetadataRule.INSTANCE.updateRules(rawAamRules);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @JvmStatic
    public static final void enable() {
        try {
            if (CrashShieldHandler.isObjectCrashing(MetadataIndexer.class)) {
                return;
            }
            try {
                FacebookSdk.getExecutor().execute(new Runnable() { // from class: com.facebook.appevents.aam.MetadataIndexer.enable.1
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
                                if (AttributionIdentifiers.INSTANCE.isTrackingLimited(FacebookSdk.getApplicationContext())) {
                                    return;
                                }
                                MetadataIndexer.access$updateRules(MetadataIndexer.INSTANCE);
                                MetadataIndexer.access$setEnabled$p(MetadataIndexer.INSTANCE, true);
                            } catch (Throwable th) {
                                CrashShieldHandler.handleThrowable(th, this);
                            }
                        } catch (Throwable th2) {
                            CrashShieldHandler.handleThrowable(th2, this);
                        }
                    }
                });
            } catch (Exception e) {
                Utility.logd(TAG, e);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MetadataIndexer.class);
        }
    }
}
