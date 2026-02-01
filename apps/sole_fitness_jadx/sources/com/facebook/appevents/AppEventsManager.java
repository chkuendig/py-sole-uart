package com.facebook.appevents;

import com.facebook.appevents.aam.MetadataIndexer;
import com.facebook.appevents.eventdeactivation.EventDeactivationManager;
import com.facebook.appevents.iap.InAppPurchaseManager;
import com.facebook.appevents.ml.ModelManager;
import com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* compiled from: AppEventsManager.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/facebook/appevents/AppEventsManager;", "", "()V", "start", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AppEventsManager {
    public static final AppEventsManager INSTANCE = new AppEventsManager();

    private AppEventsManager() {
    }

    @JvmStatic
    public static final void start() {
        if (CrashShieldHandler.isObjectCrashing(AppEventsManager.class)) {
            return;
        }
        try {
            FetchedAppSettingsManager.getAppSettingsAsync(new FetchedAppSettingsManager.FetchedAppSettingsCallback() { // from class: com.facebook.appevents.AppEventsManager.start.1
                @Override // com.facebook.internal.FetchedAppSettingsManager.FetchedAppSettingsCallback
                public void onError() {
                }

                @Override // com.facebook.internal.FetchedAppSettingsManager.FetchedAppSettingsCallback
                public void onSuccess(FetchedAppSettings fetchedAppSettings) {
                    FeatureManager.checkFeature(FeatureManager.Feature.AAM, new FeatureManager.Callback() { // from class: com.facebook.appevents.AppEventsManager$start$1$onSuccess$1
                        @Override // com.facebook.internal.FeatureManager.Callback
                        public final void onCompleted(boolean z) {
                            if (z) {
                                MetadataIndexer.enable();
                            }
                        }
                    });
                    FeatureManager.checkFeature(FeatureManager.Feature.RestrictiveDataFiltering, new FeatureManager.Callback() { // from class: com.facebook.appevents.AppEventsManager$start$1$onSuccess$2
                        @Override // com.facebook.internal.FeatureManager.Callback
                        public final void onCompleted(boolean z) {
                            if (z) {
                                RestrictiveDataManager.enable();
                            }
                        }
                    });
                    FeatureManager.checkFeature(FeatureManager.Feature.PrivacyProtection, new FeatureManager.Callback() { // from class: com.facebook.appevents.AppEventsManager$start$1$onSuccess$3
                        @Override // com.facebook.internal.FeatureManager.Callback
                        public final void onCompleted(boolean z) {
                            if (z) {
                                ModelManager.enable();
                            }
                        }
                    });
                    FeatureManager.checkFeature(FeatureManager.Feature.EventDeactivation, new FeatureManager.Callback() { // from class: com.facebook.appevents.AppEventsManager$start$1$onSuccess$4
                        @Override // com.facebook.internal.FeatureManager.Callback
                        public final void onCompleted(boolean z) {
                            if (z) {
                                EventDeactivationManager.enable();
                            }
                        }
                    });
                    FeatureManager.checkFeature(FeatureManager.Feature.IapLogging, new FeatureManager.Callback() { // from class: com.facebook.appevents.AppEventsManager$start$1$onSuccess$5
                        @Override // com.facebook.internal.FeatureManager.Callback
                        public final void onCompleted(boolean z) {
                            if (z) {
                                InAppPurchaseManager.enableAutoLogging();
                            }
                        }
                    });
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventsManager.class);
        }
    }
}
