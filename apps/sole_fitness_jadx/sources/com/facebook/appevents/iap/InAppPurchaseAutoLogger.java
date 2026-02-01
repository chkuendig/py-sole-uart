package com.facebook.appevents.iap;

import android.content.Context;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InAppPurchaseAutoLogger.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseAutoLogger;", "", "()V", "BILLING_CLIENT_PURCHASE_NAME", "", "logPurchase", "", "startIapLogging", "context", "Landroid/content/Context;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class InAppPurchaseAutoLogger {
    private static final String BILLING_CLIENT_PURCHASE_NAME = "com.android.billingclient.api.Purchase";
    public static final InAppPurchaseAutoLogger INSTANCE = new InAppPurchaseAutoLogger();

    private InAppPurchaseAutoLogger() {
    }

    public static final /* synthetic */ void access$logPurchase(InAppPurchaseAutoLogger inAppPurchaseAutoLogger) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseAutoLogger.class)) {
            return;
        }
        try {
            inAppPurchaseAutoLogger.logPurchase();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseAutoLogger.class);
        }
    }

    @JvmStatic
    public static final void startIapLogging(Context context) {
        InAppPurchaseBillingClientWrapper orCreateInstance;
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseAutoLogger.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(context, "context");
            if (InAppPurchaseUtils.getClass(BILLING_CLIENT_PURCHASE_NAME) == null || (orCreateInstance = InAppPurchaseBillingClientWrapper.INSTANCE.getOrCreateInstance(context)) == null || !InAppPurchaseBillingClientWrapper.INSTANCE.isServiceConnected().get()) {
                return;
            }
            if (InAppPurchaseLoggerManager.eligibleQueryPurchaseHistory()) {
                orCreateInstance.queryPurchaseHistory("inapp", new Runnable() { // from class: com.facebook.appevents.iap.InAppPurchaseAutoLogger.startIapLogging.1
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
                                InAppPurchaseAutoLogger.access$logPurchase(InAppPurchaseAutoLogger.INSTANCE);
                            } catch (Throwable th) {
                                CrashShieldHandler.handleThrowable(th, this);
                            }
                        } catch (Throwable th2) {
                            CrashShieldHandler.handleThrowable(th2, this);
                        }
                    }
                });
            } else {
                orCreateInstance.queryPurchase("inapp", new Runnable() { // from class: com.facebook.appevents.iap.InAppPurchaseAutoLogger.startIapLogging.2
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
                                InAppPurchaseAutoLogger.access$logPurchase(InAppPurchaseAutoLogger.INSTANCE);
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
            CrashShieldHandler.handleThrowable(th, InAppPurchaseAutoLogger.class);
        }
    }

    private final void logPurchase() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            InAppPurchaseLoggerManager.filterPurchaseLogging(InAppPurchaseBillingClientWrapper.INSTANCE.getPurchaseDetailsMap(), InAppPurchaseBillingClientWrapper.INSTANCE.getSkuDetailsMap());
            InAppPurchaseBillingClientWrapper.INSTANCE.getPurchaseDetailsMap().clear();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }
}
