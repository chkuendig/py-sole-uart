package com.facebook.appevents;

import android.content.SharedPreferences;
import com.facebook.FacebookSdk;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PerformanceGuardian.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\"B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0003J\u001a\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007J\u0012\u0010\u0019\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u0006H\u0002J,\u0010\u001b\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0007J:\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00062\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\n2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/facebook/appevents/PerformanceGuardian;", "", "()V", "ACTIVITY_PROCESS_TIME_THRESHOLD", "", "BANNED_ACTIVITY_STORE", "", "CACHE_APP_VERSION", "MAX_EXCEED_LIMIT_COUNT", "activityProcessTimeMapCodeless", "", "activityProcessTimeMapSe", "bannedCodelessActivitySet", "", "bannedSuggestedEventActivitySet", "initialized", "", "sharedPreferences", "Landroid/content/SharedPreferences;", "initializeIfNotYet", "", "isBannedActivity", "activityName", "useCase", "Lcom/facebook/appevents/PerformanceGuardian$UseCase;", "isCacheValid", "previousVersion", "limitProcessTime", "startTime", "", SDKConstants.PARAM_END_TIME, "updateActivityMap", "activityExceedLimitCountMap", "bannedActivitySet", "UseCase", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class PerformanceGuardian {
    private static final int ACTIVITY_PROCESS_TIME_THRESHOLD = 40;
    private static final String BANNED_ACTIVITY_STORE = "com.facebook.internal.BANNED_ACTIVITY";
    private static final String CACHE_APP_VERSION = "app_version";
    private static final int MAX_EXCEED_LIMIT_COUNT = 3;
    private static boolean initialized;
    private static SharedPreferences sharedPreferences;
    public static final PerformanceGuardian INSTANCE = new PerformanceGuardian();
    private static final Set<String> bannedSuggestedEventActivitySet = new HashSet();
    private static final Set<String> bannedCodelessActivitySet = new HashSet();
    private static final Map<String, Integer> activityProcessTimeMapCodeless = new HashMap();
    private static final Map<String, Integer> activityProcessTimeMapSe = new HashMap();

    /* compiled from: PerformanceGuardian.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/facebook/appevents/PerformanceGuardian$UseCase;", "", "(Ljava/lang/String;I)V", "CODELESS", "SUGGESTED_EVENT", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public enum UseCase {
        CODELESS,
        SUGGESTED_EVENT
    }

    @Metadata(k = 3, mv = {1, 5, 1})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[UseCase.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[UseCase.CODELESS.ordinal()] = 1;
            iArr[UseCase.SUGGESTED_EVENT.ordinal()] = 2;
            int[] iArr2 = new int[UseCase.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[UseCase.CODELESS.ordinal()] = 1;
            iArr2[UseCase.SUGGESTED_EVENT.ordinal()] = 2;
        }
    }

    private PerformanceGuardian() {
    }

    @JvmStatic
    private static final synchronized void initializeIfNotYet() {
        if (CrashShieldHandler.isObjectCrashing(PerformanceGuardian.class)) {
            return;
        }
        try {
            if (initialized) {
                return;
            }
            SharedPreferences sharedPreferences2 = FacebookSdk.getApplicationContext().getSharedPreferences(BANNED_ACTIVITY_STORE, 0);
            Intrinsics.checkNotNullExpressionValue(sharedPreferences2, "FacebookSdk.getApplicati…RE, Context.MODE_PRIVATE)");
            sharedPreferences = sharedPreferences2;
            if (sharedPreferences2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
            }
            if (!INSTANCE.isCacheValid(sharedPreferences2.getString(CACHE_APP_VERSION, ""))) {
                SharedPreferences sharedPreferences3 = sharedPreferences;
                if (sharedPreferences3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                }
                sharedPreferences3.edit().clear().apply();
            } else {
                Set<String> set = bannedCodelessActivitySet;
                SharedPreferences sharedPreferences4 = sharedPreferences;
                if (sharedPreferences4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                }
                Set<String> stringSet = sharedPreferences4.getStringSet(UseCase.CODELESS.toString(), new LinkedHashSet());
                set.addAll(stringSet != null ? stringSet : new LinkedHashSet());
                Set<String> set2 = bannedSuggestedEventActivitySet;
                SharedPreferences sharedPreferences5 = sharedPreferences;
                if (sharedPreferences5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                }
                Set<String> stringSet2 = sharedPreferences5.getStringSet(UseCase.SUGGESTED_EVENT.toString(), new LinkedHashSet());
                set2.addAll(stringSet2 != null ? stringSet2 : new LinkedHashSet());
            }
            initialized = true;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, PerformanceGuardian.class);
        }
    }

    @JvmStatic
    public static final boolean isBannedActivity(String activityName, UseCase useCase) {
        if (CrashShieldHandler.isObjectCrashing(PerformanceGuardian.class)) {
            return false;
        }
        try {
            Intrinsics.checkNotNullParameter(activityName, "activityName");
            initializeIfNotYet();
            if (useCase != null) {
                int i = WhenMappings.$EnumSwitchMapping$0[useCase.ordinal()];
                if (i == 1) {
                    return bannedCodelessActivitySet.contains(activityName);
                }
                if (i == 2) {
                    return bannedSuggestedEventActivitySet.contains(activityName);
                }
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, PerformanceGuardian.class);
            return false;
        }
    }

    @JvmStatic
    public static final void limitProcessTime(String activityName, UseCase useCase, long startTime, long endTime) {
        if (CrashShieldHandler.isObjectCrashing(PerformanceGuardian.class)) {
            return;
        }
        try {
            initializeIfNotYet();
            long j = endTime - startTime;
            if (activityName != null && j >= 40 && useCase != null) {
                int i = WhenMappings.$EnumSwitchMapping$1[useCase.ordinal()];
                if (i == 1) {
                    INSTANCE.updateActivityMap(useCase, activityName, activityProcessTimeMapCodeless, bannedCodelessActivitySet);
                } else {
                    if (i != 2) {
                        return;
                    }
                    INSTANCE.updateActivityMap(useCase, activityName, activityProcessTimeMapSe, bannedSuggestedEventActivitySet);
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, PerformanceGuardian.class);
        }
    }

    private final void updateActivityMap(UseCase useCase, String activityName, Map<String, Integer> activityExceedLimitCountMap, Set<String> bannedActivitySet) {
        Integer num;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            int iIntValue = 0;
            if (activityExceedLimitCountMap.containsKey(activityName) && (num = activityExceedLimitCountMap.get(activityName)) != null) {
                iIntValue = num.intValue();
            }
            int i = iIntValue + 1;
            activityExceedLimitCountMap.put(activityName, Integer.valueOf(i));
            if (i >= 3) {
                bannedActivitySet.add(activityName);
                SharedPreferences sharedPreferences2 = sharedPreferences;
                if (sharedPreferences2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                }
                sharedPreferences2.edit().putStringSet(useCase.toString(), bannedActivitySet).putString(CACHE_APP_VERSION, Utility.getAppVersion()).apply();
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private final boolean isCacheValid(String previousVersion) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            String appVersion = Utility.getAppVersion();
            if (appVersion == null || previousVersion == null) {
                return false;
            }
            if (previousVersion.length() == 0) {
                return false;
            }
            return Intrinsics.areEqual(previousVersion, appVersion);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }
}
