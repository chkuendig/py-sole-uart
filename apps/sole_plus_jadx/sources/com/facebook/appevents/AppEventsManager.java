package com.facebook.appevents;

import com.facebook.appevents.AppEventsManager;
import com.facebook.appevents.aam.MetadataIndexer;
import com.facebook.appevents.cloudbridge.AppEventsCAPIManager;
import com.facebook.appevents.eventdeactivation.EventDeactivationManager;
import com.facebook.appevents.iap.InAppPurchaseManager;
import com.facebook.appevents.integrity.BlocklistEventsManager;
import com.facebook.appevents.integrity.MACARuleMatchingManager;
import com.facebook.appevents.integrity.ProtectedModeManager;
import com.facebook.appevents.integrity.RedactedEventsManager;
import com.facebook.appevents.integrity.SensitiveParamsManager;
import com.facebook.appevents.ml.ModelManager;
import com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* compiled from: AppEventsManager.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/facebook/appevents/AppEventsManager;", "", "()V", "start", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class AppEventsManager {
    public static final AppEventsManager INSTANCE = new AppEventsManager();

    private AppEventsManager() {
    }

    /* compiled from: AppEventsManager.kt */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/facebook/appevents/AppEventsManager$start$1", "Lcom/facebook/internal/FetchedAppSettingsManager$FetchedAppSettingsCallback;", "onError", "", "onSuccess", "fetchedAppSettings", "Lcom/facebook/internal/FetchedAppSettings;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* renamed from: com.facebook.appevents.AppEventsManager$start$1, reason: invalid class name */
    public static final class AnonymousClass1 implements FetchedAppSettingsManager.FetchedAppSettingsCallback {
        @Override // com.facebook.internal.FetchedAppSettingsManager.FetchedAppSettingsCallback
        public void onError() {
        }

        AnonymousClass1() {
        }

        @Override // com.facebook.internal.FetchedAppSettingsManager.FetchedAppSettingsCallback
        public void onSuccess(FetchedAppSettings fetchedAppSettings) {
            FeatureManager featureManager = FeatureManager.INSTANCE;
            FeatureManager.checkFeature(FeatureManager.Feature.AAM, new FeatureManager.Callback() { // from class: com.facebook.appevents.AppEventsManager$start$1$$ExternalSyntheticLambda0
                @Override // com.facebook.internal.FeatureManager.Callback
                public final void onCompleted(boolean z) {
                    AppEventsManager.AnonymousClass1.m8059onSuccess$lambda0(z);
                }
            });
            FeatureManager featureManager2 = FeatureManager.INSTANCE;
            FeatureManager.checkFeature(FeatureManager.Feature.RestrictiveDataFiltering, new FeatureManager.Callback() { // from class: com.facebook.appevents.AppEventsManager$start$1$$ExternalSyntheticLambda3
                @Override // com.facebook.internal.FeatureManager.Callback
                public final void onCompleted(boolean z) {
                    AppEventsManager.AnonymousClass1.m8060onSuccess$lambda1(z);
                }
            });
            FeatureManager featureManager3 = FeatureManager.INSTANCE;
            FeatureManager.checkFeature(FeatureManager.Feature.PrivacyProtection, new FeatureManager.Callback() { // from class: com.facebook.appevents.AppEventsManager$start$1$$ExternalSyntheticLambda4
                @Override // com.facebook.internal.FeatureManager.Callback
                public final void onCompleted(boolean z) {
                    AppEventsManager.AnonymousClass1.m8062onSuccess$lambda2(z);
                }
            });
            FeatureManager featureManager4 = FeatureManager.INSTANCE;
            FeatureManager.checkFeature(FeatureManager.Feature.EventDeactivation, new FeatureManager.Callback() { // from class: com.facebook.appevents.AppEventsManager$start$1$$ExternalSyntheticLambda5
                @Override // com.facebook.internal.FeatureManager.Callback
                public final void onCompleted(boolean z) {
                    AppEventsManager.AnonymousClass1.m8063onSuccess$lambda3(z);
                }
            });
            FeatureManager featureManager5 = FeatureManager.INSTANCE;
            FeatureManager.checkFeature(FeatureManager.Feature.IapLogging, new FeatureManager.Callback() { // from class: com.facebook.appevents.AppEventsManager$start$1$$ExternalSyntheticLambda6
                @Override // com.facebook.internal.FeatureManager.Callback
                public final void onCompleted(boolean z) {
                    AppEventsManager.AnonymousClass1.m8064onSuccess$lambda4(z);
                }
            });
            FeatureManager featureManager6 = FeatureManager.INSTANCE;
            FeatureManager.checkFeature(FeatureManager.Feature.ProtectedMode, new FeatureManager.Callback() { // from class: com.facebook.appevents.AppEventsManager$start$1$$ExternalSyntheticLambda7
                @Override // com.facebook.internal.FeatureManager.Callback
                public final void onCompleted(boolean z) {
                    AppEventsManager.AnonymousClass1.m8065onSuccess$lambda5(z);
                }
            });
            FeatureManager featureManager7 = FeatureManager.INSTANCE;
            FeatureManager.checkFeature(FeatureManager.Feature.MACARuleMatching, new FeatureManager.Callback() { // from class: com.facebook.appevents.AppEventsManager$start$1$$ExternalSyntheticLambda8
                @Override // com.facebook.internal.FeatureManager.Callback
                public final void onCompleted(boolean z) {
                    AppEventsManager.AnonymousClass1.m8066onSuccess$lambda6(z);
                }
            });
            FeatureManager featureManager8 = FeatureManager.INSTANCE;
            FeatureManager.checkFeature(FeatureManager.Feature.BlocklistEvents, new FeatureManager.Callback() { // from class: com.facebook.appevents.AppEventsManager$start$1$$ExternalSyntheticLambda9
                @Override // com.facebook.internal.FeatureManager.Callback
                public final void onCompleted(boolean z) {
                    AppEventsManager.AnonymousClass1.m8067onSuccess$lambda7(z);
                }
            });
            FeatureManager featureManager9 = FeatureManager.INSTANCE;
            FeatureManager.checkFeature(FeatureManager.Feature.FilterRedactedEvents, new FeatureManager.Callback() { // from class: com.facebook.appevents.AppEventsManager$start$1$$ExternalSyntheticLambda10
                @Override // com.facebook.internal.FeatureManager.Callback
                public final void onCompleted(boolean z) {
                    AppEventsManager.AnonymousClass1.m8068onSuccess$lambda8(z);
                }
            });
            FeatureManager featureManager10 = FeatureManager.INSTANCE;
            FeatureManager.checkFeature(FeatureManager.Feature.FilterSensitiveParams, new FeatureManager.Callback() { // from class: com.facebook.appevents.AppEventsManager$start$1$$ExternalSyntheticLambda1
                @Override // com.facebook.internal.FeatureManager.Callback
                public final void onCompleted(boolean z) {
                    AppEventsManager.AnonymousClass1.m8069onSuccess$lambda9(z);
                }
            });
            FeatureManager featureManager11 = FeatureManager.INSTANCE;
            FeatureManager.checkFeature(FeatureManager.Feature.CloudBridge, new FeatureManager.Callback() { // from class: com.facebook.appevents.AppEventsManager$start$1$$ExternalSyntheticLambda2
                @Override // com.facebook.internal.FeatureManager.Callback
                public final void onCompleted(boolean z) {
                    AppEventsManager.AnonymousClass1.m8061onSuccess$lambda10(z);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: onSuccess$lambda-0, reason: not valid java name */
        public static final void m8059onSuccess$lambda0(boolean z) {
            if (z) {
                MetadataIndexer metadataIndexer = MetadataIndexer.INSTANCE;
                MetadataIndexer.enable();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: onSuccess$lambda-1, reason: not valid java name */
        public static final void m8060onSuccess$lambda1(boolean z) {
            if (z) {
                RestrictiveDataManager restrictiveDataManager = RestrictiveDataManager.INSTANCE;
                RestrictiveDataManager.enable();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: onSuccess$lambda-2, reason: not valid java name */
        public static final void m8062onSuccess$lambda2(boolean z) {
            if (z) {
                ModelManager modelManager = ModelManager.INSTANCE;
                ModelManager.enable();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: onSuccess$lambda-3, reason: not valid java name */
        public static final void m8063onSuccess$lambda3(boolean z) {
            if (z) {
                EventDeactivationManager eventDeactivationManager = EventDeactivationManager.INSTANCE;
                EventDeactivationManager.enable();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: onSuccess$lambda-4, reason: not valid java name */
        public static final void m8064onSuccess$lambda4(boolean z) {
            if (z) {
                InAppPurchaseManager inAppPurchaseManager = InAppPurchaseManager.INSTANCE;
                InAppPurchaseManager.enableAutoLogging();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: onSuccess$lambda-5, reason: not valid java name */
        public static final void m8065onSuccess$lambda5(boolean z) {
            if (z) {
                ProtectedModeManager protectedModeManager = ProtectedModeManager.INSTANCE;
                ProtectedModeManager.enable();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: onSuccess$lambda-6, reason: not valid java name */
        public static final void m8066onSuccess$lambda6(boolean z) {
            if (z) {
                MACARuleMatchingManager mACARuleMatchingManager = MACARuleMatchingManager.INSTANCE;
                MACARuleMatchingManager.enable();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: onSuccess$lambda-7, reason: not valid java name */
        public static final void m8067onSuccess$lambda7(boolean z) {
            if (z) {
                BlocklistEventsManager blocklistEventsManager = BlocklistEventsManager.INSTANCE;
                BlocklistEventsManager.enable();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: onSuccess$lambda-8, reason: not valid java name */
        public static final void m8068onSuccess$lambda8(boolean z) {
            if (z) {
                RedactedEventsManager redactedEventsManager = RedactedEventsManager.INSTANCE;
                RedactedEventsManager.enable();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: onSuccess$lambda-9, reason: not valid java name */
        public static final void m8069onSuccess$lambda9(boolean z) {
            if (z) {
                SensitiveParamsManager sensitiveParamsManager = SensitiveParamsManager.INSTANCE;
                SensitiveParamsManager.enable();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: onSuccess$lambda-10, reason: not valid java name */
        public static final void m8061onSuccess$lambda10(boolean z) {
            if (z) {
                AppEventsCAPIManager appEventsCAPIManager = AppEventsCAPIManager.INSTANCE;
                AppEventsCAPIManager.enable();
            }
        }
    }

    @JvmStatic
    public static final void start() {
        if (CrashShieldHandler.isObjectCrashing(AppEventsManager.class)) {
            return;
        }
        try {
            FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
            FetchedAppSettingsManager.getAppSettingsAsync(new AnonymousClass1());
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventsManager.class);
        }
    }
}
