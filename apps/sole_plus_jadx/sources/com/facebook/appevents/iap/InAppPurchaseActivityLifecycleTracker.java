package com.facebook.appevents.iap;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import com.android.SdkConstants;
import com.facebook.FacebookSdk;
import com.facebook.appevents.iap.InAppPurchaseActivityLifecycleTracker;
import com.facebook.appevents.internal.AutomaticAnalyticsLogger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: InAppPurchaseActivityLifecycleTracker.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J0\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0016\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u001bj\b\u0012\u0004\u0012\u00020\u0004`\u001c2\u0006\u0010\u001d\u001a\u00020\u000bH\u0002J\b\u0010\u001e\u001a\u00020\u0016H\u0007J\b\u0010\u001f\u001a\u00020\u0016H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0007*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\fR\u0012\u0010\r\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseActivityLifecycleTracker;", "", "()V", "BILLING_ACTIVITY_NAME", "", "SERVICE_INTERFACE_NAME", "TAG", "kotlin.jvm.PlatformType", "callbacks", "Landroid/app/Application$ActivityLifecycleCallbacks;", "hasBillingActivity", "", "Ljava/lang/Boolean;", "hasBillingService", "inAppBillingObj", "intent", "Landroid/content/Intent;", "isTracking", "Ljava/util/concurrent/atomic/AtomicBoolean;", "serviceConnection", "Landroid/content/ServiceConnection;", "initializeIfNotInitialized", "", "logPurchase", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "purchases", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "isSubscription", "startIapLogging", "startTracking", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class InAppPurchaseActivityLifecycleTracker {
    private static final String BILLING_ACTIVITY_NAME = "com.android.billingclient.api.ProxyBillingActivity";
    private static final String SERVICE_INTERFACE_NAME = "com.android.vending.billing.IInAppBillingService$Stub";
    private static Application.ActivityLifecycleCallbacks callbacks;
    private static Boolean hasBillingActivity;
    private static Boolean hasBillingService;
    private static Object inAppBillingObj;
    private static Intent intent;
    private static ServiceConnection serviceConnection;
    public static final InAppPurchaseActivityLifecycleTracker INSTANCE = new InAppPurchaseActivityLifecycleTracker();
    private static final String TAG = InAppPurchaseActivityLifecycleTracker.class.getCanonicalName();
    private static final AtomicBoolean isTracking = new AtomicBoolean(false);

    private InAppPurchaseActivityLifecycleTracker() {
    }

    @JvmStatic
    public static final void startIapLogging() {
        InAppPurchaseActivityLifecycleTracker inAppPurchaseActivityLifecycleTracker = INSTANCE;
        inAppPurchaseActivityLifecycleTracker.initializeIfNotInitialized();
        if (Intrinsics.areEqual((Object) hasBillingService, (Object) false)) {
            return;
        }
        AutomaticAnalyticsLogger automaticAnalyticsLogger = AutomaticAnalyticsLogger.INSTANCE;
        if (AutomaticAnalyticsLogger.isImplicitPurchaseLoggingEnabled()) {
            inAppPurchaseActivityLifecycleTracker.startTracking();
        }
    }

    private final void initializeIfNotInitialized() {
        if (hasBillingService != null) {
            return;
        }
        InAppPurchaseUtils inAppPurchaseUtils = InAppPurchaseUtils.INSTANCE;
        Boolean boolValueOf = Boolean.valueOf(InAppPurchaseUtils.getClass(SERVICE_INTERFACE_NAME) != null);
        hasBillingService = boolValueOf;
        if (Intrinsics.areEqual((Object) boolValueOf, (Object) false)) {
            return;
        }
        InAppPurchaseUtils inAppPurchaseUtils2 = InAppPurchaseUtils.INSTANCE;
        hasBillingActivity = Boolean.valueOf(InAppPurchaseUtils.getClass(BILLING_ACTIVITY_NAME) != null);
        InAppPurchaseEventManager inAppPurchaseEventManager = InAppPurchaseEventManager.INSTANCE;
        InAppPurchaseEventManager.clearSkuDetailsCache();
        Intent intent2 = new Intent("com.android.vending.billing.InAppBillingService.BIND").setPackage("com.android.vending");
        Intrinsics.checkNotNullExpressionValue(intent2, "Intent(\"com.android.vending.billing.InAppBillingService.BIND\")\n            .setPackage(\"com.android.vending\")");
        intent = intent2;
        serviceConnection = new ServiceConnection() { // from class: com.facebook.appevents.iap.InAppPurchaseActivityLifecycleTracker.initializeIfNotInitialized.1
            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName name) {
                Intrinsics.checkNotNullParameter(name, "name");
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName name, IBinder service) {
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(service, "service");
                InAppPurchaseActivityLifecycleTracker inAppPurchaseActivityLifecycleTracker = InAppPurchaseActivityLifecycleTracker.INSTANCE;
                InAppPurchaseEventManager inAppPurchaseEventManager2 = InAppPurchaseEventManager.INSTANCE;
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                InAppPurchaseActivityLifecycleTracker.inAppBillingObj = InAppPurchaseEventManager.asInterface(FacebookSdk.getApplicationContext(), service);
            }
        };
        callbacks = new AnonymousClass2();
    }

    /* compiled from: InAppPurchaseActivityLifecycleTracker.kt */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u000f"}, d2 = {"com/facebook/appevents/iap/InAppPurchaseActivityLifecycleTracker$initializeIfNotInitialized$2", "Landroid/app/Application$ActivityLifecycleCallbacks;", "onActivityCreated", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* renamed from: com.facebook.appevents.iap.InAppPurchaseActivityLifecycleTracker$initializeIfNotInitialized$2, reason: invalid class name */
    public static final class AnonymousClass2 implements Application.ActivityLifecycleCallbacks {
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(outState, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        AnonymousClass2() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            try {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                FacebookSdk.getExecutor().execute(new Runnable() { // from class: com.facebook.appevents.iap.InAppPurchaseActivityLifecycleTracker$initializeIfNotInitialized$2$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() throws JSONException {
                        InAppPurchaseActivityLifecycleTracker.AnonymousClass2.m8094onActivityResumed$lambda0();
                    }
                });
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: onActivityResumed$lambda-0, reason: not valid java name */
        public static final void m8094onActivityResumed$lambda0() throws JSONException {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            Context applicationContext = FacebookSdk.getApplicationContext();
            InAppPurchaseEventManager inAppPurchaseEventManager = InAppPurchaseEventManager.INSTANCE;
            InAppPurchaseActivityLifecycleTracker.INSTANCE.logPurchase(applicationContext, InAppPurchaseEventManager.getPurchasesInapp(applicationContext, InAppPurchaseActivityLifecycleTracker.inAppBillingObj), false);
            InAppPurchaseEventManager inAppPurchaseEventManager2 = InAppPurchaseEventManager.INSTANCE;
            InAppPurchaseActivityLifecycleTracker.INSTANCE.logPurchase(applicationContext, InAppPurchaseEventManager.getPurchasesSubs(applicationContext, InAppPurchaseActivityLifecycleTracker.inAppBillingObj), true);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            try {
                if (Intrinsics.areEqual((Object) InAppPurchaseActivityLifecycleTracker.hasBillingActivity, (Object) true) && Intrinsics.areEqual(activity.getLocalClassName(), InAppPurchaseActivityLifecycleTracker.BILLING_ACTIVITY_NAME)) {
                    FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                    FacebookSdk.getExecutor().execute(new Runnable() { // from class: com.facebook.appevents.iap.InAppPurchaseActivityLifecycleTracker$initializeIfNotInitialized$2$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() throws JSONException {
                            InAppPurchaseActivityLifecycleTracker.AnonymousClass2.m8095onActivityStopped$lambda1();
                        }
                    });
                }
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: onActivityStopped$lambda-1, reason: not valid java name */
        public static final void m8095onActivityStopped$lambda1() throws JSONException {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            Context applicationContext = FacebookSdk.getApplicationContext();
            InAppPurchaseEventManager inAppPurchaseEventManager = InAppPurchaseEventManager.INSTANCE;
            ArrayList<String> purchasesInapp = InAppPurchaseEventManager.getPurchasesInapp(applicationContext, InAppPurchaseActivityLifecycleTracker.inAppBillingObj);
            if (purchasesInapp.isEmpty()) {
                InAppPurchaseEventManager inAppPurchaseEventManager2 = InAppPurchaseEventManager.INSTANCE;
                purchasesInapp = InAppPurchaseEventManager.getPurchaseHistoryInapp(applicationContext, InAppPurchaseActivityLifecycleTracker.inAppBillingObj);
            }
            InAppPurchaseActivityLifecycleTracker.INSTANCE.logPurchase(applicationContext, purchasesInapp, false);
        }
    }

    private final void startTracking() {
        if (isTracking.compareAndSet(false, true)) {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            Context applicationContext = FacebookSdk.getApplicationContext();
            if (applicationContext instanceof Application) {
                Application application = (Application) applicationContext;
                Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = callbacks;
                if (activityLifecycleCallbacks == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("callbacks");
                    throw null;
                }
                application.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
                Intent intent2 = intent;
                if (intent2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("intent");
                    throw null;
                }
                ServiceConnection serviceConnection2 = serviceConnection;
                if (serviceConnection2 != null) {
                    applicationContext.bindService(intent2, serviceConnection2, 1);
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("serviceConnection");
                    throw null;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logPurchase(Context context, ArrayList<String> purchases, boolean isSubscription) throws JSONException {
        if (purchases.isEmpty()) {
            return;
        }
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = purchases.iterator();
        while (it.hasNext()) {
            String purchase = it.next();
            try {
                String sku = new JSONObject(purchase).getString("productId");
                Intrinsics.checkNotNullExpressionValue(sku, "sku");
                Intrinsics.checkNotNullExpressionValue(purchase, "purchase");
                map.put(sku, purchase);
                arrayList.add(sku);
            } catch (JSONException e) {
                Log.e(TAG, "Error parsing in-app purchase data.", e);
            }
        }
        InAppPurchaseEventManager inAppPurchaseEventManager = InAppPurchaseEventManager.INSTANCE;
        for (Map.Entry<String, String> entry : InAppPurchaseEventManager.getSkuDetails(context, arrayList, inAppBillingObj, isSubscription).entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            String str = (String) map.get(key);
            if (str != null) {
                AutomaticAnalyticsLogger automaticAnalyticsLogger = AutomaticAnalyticsLogger.INSTANCE;
                AutomaticAnalyticsLogger.logPurchase(str, value, isSubscription);
            }
        }
    }
}
