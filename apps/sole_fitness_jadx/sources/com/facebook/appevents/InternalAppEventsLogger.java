package com.facebook.appevents;

import android.content.Context;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InternalAppEventsLogger.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB\u000f\b\u0000\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013J\u001a\u0010\u0014\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\"\u0010\u0014\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u001a\u0010\u0018\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u001a\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006J\u001a\u0010\u001a\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J.\u0010\u001a\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J)\u0010\u001a\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u001fJ$\u0010 \u001a\u00020\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/facebook/appevents/InternalAppEventsLogger;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "applicationId", "", "(Landroid/content/Context;Ljava/lang/String;)V", "activityName", SDKConstants.PARAM_ACCESS_TOKEN, "Lcom/facebook/AccessToken;", "(Ljava/lang/String;Ljava/lang/String;Lcom/facebook/AccessToken;)V", "loggerImpl", "Lcom/facebook/appevents/AppEventsLoggerImpl;", "(Lcom/facebook/appevents/AppEventsLoggerImpl;)V", "flush", "", "logChangedSettingsEvent", "parameters", "Landroid/os/Bundle;", "logEvent", "eventName", "valueToSum", "", "logEventFromSE", "buttonText", "logEventImplicitly", "purchaseAmount", "Ljava/math/BigDecimal;", FirebaseAnalytics.Param.CURRENCY, "Ljava/util/Currency;", "(Ljava/lang/String;Ljava/lang/Double;Landroid/os/Bundle;)V", "logPurchaseImplicitly", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class InternalAppEventsLogger {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final AppEventsLoggerImpl loggerImpl;

    @JvmStatic
    public static final Executor getAnalyticsExecutor() {
        return INSTANCE.getAnalyticsExecutor();
    }

    @JvmStatic
    public static final AppEventsLogger.FlushBehavior getFlushBehavior() {
        return INSTANCE.getFlushBehavior();
    }

    @JvmStatic
    public static final String getPushNotificationsRegistrationId() {
        return INSTANCE.getPushNotificationsRegistrationId();
    }

    @JvmStatic
    public static final void setInternalUserData(Map<String, String> map) {
        INSTANCE.setInternalUserData(map);
    }

    @JvmStatic
    public static final void setUserData(Bundle bundle) {
        INSTANCE.setUserData(bundle);
    }

    public InternalAppEventsLogger(AppEventsLoggerImpl loggerImpl) {
        Intrinsics.checkNotNullParameter(loggerImpl, "loggerImpl");
        this.loggerImpl = loggerImpl;
    }

    public InternalAppEventsLogger(Context context) {
        this(new AppEventsLoggerImpl(context, (String) null, (AccessToken) null));
    }

    public InternalAppEventsLogger(Context context, String str) {
        this(new AppEventsLoggerImpl(context, str, (AccessToken) null));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InternalAppEventsLogger(String activityName, String str, AccessToken accessToken) {
        this(new AppEventsLoggerImpl(activityName, str, accessToken));
        Intrinsics.checkNotNullParameter(activityName, "activityName");
    }

    public final void logEvent(String eventName, Bundle parameters) {
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            this.loggerImpl.logEvent(eventName, parameters);
        }
    }

    public final void logEvent(String eventName, double valueToSum, Bundle parameters) {
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            this.loggerImpl.logEvent(eventName, valueToSum, parameters);
        }
    }

    public final void logPurchaseImplicitly(BigDecimal purchaseAmount, Currency currency, Bundle parameters) {
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            this.loggerImpl.logPurchaseImplicitly(purchaseAmount, currency, parameters);
        }
    }

    public final void logEventFromSE(String eventName, String buttonText) {
        this.loggerImpl.logEventFromSE(eventName, buttonText);
    }

    public final void logEventImplicitly(String eventName, BigDecimal purchaseAmount, Currency currency, Bundle parameters) {
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            this.loggerImpl.logEventImplicitly(eventName, purchaseAmount, currency, parameters);
        }
    }

    public final void logEventImplicitly(String eventName) {
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            this.loggerImpl.logEventImplicitly(eventName, null, null);
        }
    }

    public final void logEventImplicitly(String eventName, Double valueToSum, Bundle parameters) {
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            this.loggerImpl.logEventImplicitly(eventName, valueToSum, parameters);
        }
    }

    public final void logEventImplicitly(String eventName, Bundle parameters) {
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            this.loggerImpl.logEventImplicitly(eventName, null, parameters);
        }
    }

    public final void logChangedSettingsEvent(Bundle parameters) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        if (((parameters.getInt("previous") & 2) != 0) || FacebookSdk.getAutoLogAppEventsEnabled()) {
            this.loggerImpl.logEventImplicitly("fb_sdk_settings_changed", null, parameters);
        }
    }

    public final void flush() {
        this.loggerImpl.flush();
    }

    /* compiled from: InternalAppEventsLogger.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J\u001c\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\fH\u0007J\u0012\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¨\u0006\u0010"}, d2 = {"Lcom/facebook/appevents/InternalAppEventsLogger$Companion;", "", "()V", "getAnalyticsExecutor", "Ljava/util/concurrent/Executor;", "getFlushBehavior", "Lcom/facebook/appevents/AppEventsLogger$FlushBehavior;", "getPushNotificationsRegistrationId", "", "setInternalUserData", "", "ud", "", "setUserData", "userData", "Landroid/os/Bundle;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final AppEventsLogger.FlushBehavior getFlushBehavior() {
            return AppEventsLoggerImpl.INSTANCE.getFlushBehavior();
        }

        @JvmStatic
        public final Executor getAnalyticsExecutor() {
            return AppEventsLoggerImpl.INSTANCE.getAnalyticsExecutor();
        }

        @JvmStatic
        public final String getPushNotificationsRegistrationId() {
            return AppEventsLoggerImpl.INSTANCE.getPushNotificationsRegistrationId();
        }

        @JvmStatic
        public final void setUserData(Bundle userData) {
            UserDataStore.setUserDataAndHash(userData);
        }

        @JvmStatic
        public final void setInternalUserData(Map<String, String> ud) {
            Intrinsics.checkNotNullParameter(ud, "ud");
            UserDataStore.setInternalUd(ud);
        }
    }
}
