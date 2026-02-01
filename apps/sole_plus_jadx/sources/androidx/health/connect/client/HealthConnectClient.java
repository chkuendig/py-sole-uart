package androidx.health.connect.client;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.UserManager;
import androidx.core.content.pm.PackageInfoCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.health.connect.client.aggregate.AggregationResult;
import androidx.health.connect.client.aggregate.AggregationResultGroupedByDuration;
import androidx.health.connect.client.aggregate.AggregationResultGroupedByPeriod;
import androidx.health.connect.client.feature.HealthConnectFeaturesUnavailableImpl;
import androidx.health.connect.client.impl.HealthConnectClientImpl;
import androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl;
import androidx.health.connect.client.records.Record;
import androidx.health.connect.client.request.AggregateGroupByDurationRequest;
import androidx.health.connect.client.request.AggregateGroupByPeriodRequest;
import androidx.health.connect.client.request.AggregateRequest;
import androidx.health.connect.client.request.ChangesTokenRequest;
import androidx.health.connect.client.request.ReadRecordsRequest;
import androidx.health.connect.client.response.ChangesResponse;
import androidx.health.connect.client.response.InsertRecordsResponse;
import androidx.health.connect.client.response.ReadRecordResponse;
import androidx.health.connect.client.response.ReadRecordsResponse;
import androidx.health.connect.client.time.TimeRangeFilter;
import androidx.health.platform.client.HealthDataService;
import com.android.SdkConstants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* compiled from: HealthConnectClient.kt */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 <2\u00020\u0001:\u0002;<J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH¦@¢\u0006\u0002\u0010\u0010J\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u000e\u001a\u00020\u0014H¦@¢\u0006\u0002\u0010\u0015J\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00122\u0006\u0010\u000e\u001a\u00020\u0018H¦@¢\u0006\u0002\u0010\u0019J&\u0010\u001a\u001a\u00020\u001b2\u000e\u0010\u001c\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001e0\u001d2\u0006\u0010\u001f\u001a\u00020 H¦@¢\u0006\u0002\u0010!J:\u0010\u001a\u001a\u00020\u001b2\u000e\u0010\u001c\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001e0\u001d2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00122\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u0012H¦@¢\u0006\u0002\u0010%J\u0016\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020#H¦@¢\u0006\u0002\u0010)J\u0016\u0010*\u001a\u00020#2\u0006\u0010\u000e\u001a\u00020+H¦@¢\u0006\u0002\u0010,J\u001c\u0010-\u001a\u00020.2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0012H¦@¢\u0006\u0002\u00100J4\u00101\u001a\b\u0012\u0004\u0012\u0002H302\"\b\b\u0000\u00103*\u00020\u001e2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H30\u001d2\u0006\u00104\u001a\u00020#H¦@¢\u0006\u0002\u00105J,\u00106\u001a\b\u0012\u0004\u0012\u0002H307\"\b\b\u0000\u00103*\u00020\u001e2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H308H¦@¢\u0006\u0002\u00109J\u001c\u0010:\u001a\u00020\u001b2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0012H¦@¢\u0006\u0002\u00100R\u001a\u0010\u0002\u001a\u00020\u00038VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006=À\u0006\u0003"}, d2 = {"Landroidx/health/connect/client/HealthConnectClient;", "", "features", "Landroidx/health/connect/client/HealthConnectFeatures;", "getFeatures$annotations", "()V", "getFeatures", "()Landroidx/health/connect/client/HealthConnectFeatures;", "permissionController", "Landroidx/health/connect/client/PermissionController;", "getPermissionController", "()Landroidx/health/connect/client/PermissionController;", "aggregate", "Landroidx/health/connect/client/aggregate/AggregationResult;", "request", "Landroidx/health/connect/client/request/AggregateRequest;", "(Landroidx/health/connect/client/request/AggregateRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "aggregateGroupByDuration", "", "Landroidx/health/connect/client/aggregate/AggregationResultGroupedByDuration;", "Landroidx/health/connect/client/request/AggregateGroupByDurationRequest;", "(Landroidx/health/connect/client/request/AggregateGroupByDurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "aggregateGroupByPeriod", "Landroidx/health/connect/client/aggregate/AggregationResultGroupedByPeriod;", "Landroidx/health/connect/client/request/AggregateGroupByPeriodRequest;", "(Landroidx/health/connect/client/request/AggregateGroupByPeriodRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteRecords", "", "recordType", "Lkotlin/reflect/KClass;", "Landroidx/health/connect/client/records/Record;", "timeRangeFilter", "Landroidx/health/connect/client/time/TimeRangeFilter;", "(Lkotlin/reflect/KClass;Landroidx/health/connect/client/time/TimeRangeFilter;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recordIdsList", "", "clientRecordIdsList", "(Lkotlin/reflect/KClass;Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getChanges", "Landroidx/health/connect/client/response/ChangesResponse;", "changesToken", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getChangesToken", "Landroidx/health/connect/client/request/ChangesTokenRequest;", "(Landroidx/health/connect/client/request/ChangesTokenRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertRecords", "Landroidx/health/connect/client/response/InsertRecordsResponse;", "records", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readRecord", "Landroidx/health/connect/client/response/ReadRecordResponse;", ExifInterface.GPS_DIRECTION_TRUE, "recordId", "(Lkotlin/reflect/KClass;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readRecords", "Landroidx/health/connect/client/response/ReadRecordsResponse;", "Landroidx/health/connect/client/request/ReadRecordsRequest;", "(Landroidx/health/connect/client/request/ReadRecordsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateRecords", "Api34Impl", "Companion", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface HealthConnectClient {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int DEFAULT_PROVIDER_MIN_VERSION_CODE = 68623;
    public static final String DEFAULT_PROVIDER_PACKAGE_NAME = "com.google.android.apps.healthdata";
    public static final String HEALTH_CONNECT_CLIENT_TAG = "HealthConnectClient";
    public static final int SDK_AVAILABLE = 3;
    public static final int SDK_UNAVAILABLE = 1;
    public static final int SDK_UNAVAILABLE_PROVIDER_UPDATE_REQUIRED = 2;

    @JvmStatic
    static Intent getHealthConnectManageDataIntent(Context context) {
        return INSTANCE.getHealthConnectManageDataIntent(context);
    }

    @JvmStatic
    static Intent getHealthConnectManageDataIntent(Context context, String str) {
        return INSTANCE.getHealthConnectManageDataIntent(context, str);
    }

    static String getHealthConnectSettingsAction() {
        return INSTANCE.getHealthConnectSettingsAction();
    }

    @JvmStatic
    static HealthConnectClient getOrCreate(Context context) {
        return INSTANCE.getOrCreate(context);
    }

    @JvmStatic
    static HealthConnectClient getOrCreate(Context context, String str) {
        return INSTANCE.getOrCreate(context, str);
    }

    @JvmStatic
    static int getSdkStatus(Context context) {
        return INSTANCE.getSdkStatus(context);
    }

    @JvmStatic
    static int getSdkStatus(Context context, String str) {
        return INSTANCE.getSdkStatus(context, str);
    }

    Object aggregate(AggregateRequest aggregateRequest, Continuation<? super AggregationResult> continuation);

    Object aggregateGroupByDuration(AggregateGroupByDurationRequest aggregateGroupByDurationRequest, Continuation<? super List<AggregationResultGroupedByDuration>> continuation);

    Object aggregateGroupByPeriod(AggregateGroupByPeriodRequest aggregateGroupByPeriodRequest, Continuation<? super List<AggregationResultGroupedByPeriod>> continuation);

    Object deleteRecords(KClass<? extends Record> kClass, TimeRangeFilter timeRangeFilter, Continuation<? super Unit> continuation);

    Object deleteRecords(KClass<? extends Record> kClass, List<String> list, List<String> list2, Continuation<? super Unit> continuation);

    Object getChanges(String str, Continuation<? super ChangesResponse> continuation);

    Object getChangesToken(ChangesTokenRequest changesTokenRequest, Continuation<? super String> continuation);

    PermissionController getPermissionController();

    Object insertRecords(List<? extends Record> list, Continuation<? super InsertRecordsResponse> continuation);

    <T extends Record> Object readRecord(KClass<T> kClass, String str, Continuation<? super ReadRecordResponse<T>> continuation);

    <T extends Record> Object readRecords(ReadRecordsRequest<T> readRecordsRequest, Continuation<? super ReadRecordsResponse<T>> continuation);

    Object updateRecords(List<? extends Record> list, Continuation<? super Unit> continuation);

    /* compiled from: HealthConnectClient.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void getFeatures$annotations() {
        }

        @Deprecated
        public static HealthConnectFeatures getFeatures(HealthConnectClient healthConnectClient) {
            return HealthConnectClient.super.getFeatures();
        }
    }

    default HealthConnectFeatures getFeatures() {
        return HealthConnectFeaturesUnavailableImpl.INSTANCE;
    }

    /* compiled from: HealthConnectClient.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001!B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0004H\u0007J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0004H\u0007J\u001a\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0004H\u0007J\u001d\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u001eJ\"\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00042\b\b\u0002\u0010 \u001a\u00020\u000bH\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u00020\u00048GX\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\u0002\u001a\u0004\b\t\u0010\u0006R\u0010\u0010\n\u001a\u00020\u000b8\u0000X\u0081T¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\u00048\u0000X\u0081T¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u00048\u0000X\u0081T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Landroidx/health/connect/client/HealthConnectClient$Companion;", "", "()V", "ACTION_HEALTH_CONNECT_MANAGE_DATA", "", "getACTION_HEALTH_CONNECT_MANAGE_DATA$connect_client_release", "()Ljava/lang/String;", "ACTION_HEALTH_CONNECT_SETTINGS", "getHealthConnectSettingsAction$annotations", "getHealthConnectSettingsAction", "DEFAULT_PROVIDER_MIN_VERSION_CODE", "", "DEFAULT_PROVIDER_PACKAGE_NAME", "HEALTH_CONNECT_CLIENT_TAG", "SDK_AVAILABLE", "SDK_UNAVAILABLE", "SDK_UNAVAILABLE_PROVIDER_UPDATE_REQUIRED", "getHealthConnectManageDataIntent", "Landroid/content/Intent;", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "providerPackageName", "getOrCreate", "Landroidx/health/connect/client/HealthConnectClient;", "getSdkStatus", "hasBindableService", "", "packageManager", "Landroid/content/pm/PackageManager;", "packageName", "hasBindableService$connect_client_release", "isPackageInstalled", "versionCode", "AvailabilityStatus", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final String ACTION_HEALTH_CONNECT_MANAGE_DATA;
        private static final String ACTION_HEALTH_CONNECT_SETTINGS;
        public static final int DEFAULT_PROVIDER_MIN_VERSION_CODE = 68623;
        public static final String DEFAULT_PROVIDER_PACKAGE_NAME = "com.google.android.apps.healthdata";
        public static final String HEALTH_CONNECT_CLIENT_TAG = "HealthConnectClient";
        public static final int SDK_AVAILABLE = 3;
        public static final int SDK_UNAVAILABLE = 1;
        public static final int SDK_UNAVAILABLE_PROVIDER_UPDATE_REQUIRED = 2;

        /* compiled from: HealthConnectClient.kt */
        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Landroidx/health/connect/client/HealthConnectClient$Companion$AvailabilityStatus;", "", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface AvailabilityStatus {
        }

        @JvmStatic
        public static /* synthetic */ void getHealthConnectSettingsAction$annotations() {
        }

        @JvmStatic
        public final Intent getHealthConnectManageDataIntent(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return getHealthConnectManageDataIntent$default(this, context, null, 2, null);
        }

        @JvmStatic
        public final HealthConnectClient getOrCreate(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return getOrCreate$default(this, context, null, 2, null);
        }

        @JvmStatic
        public final int getSdkStatus(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return getSdkStatus$default(this, context, null, 2, null);
        }

        private Companion() {
        }

        public final String getHealthConnectSettingsAction() {
            return ACTION_HEALTH_CONNECT_SETTINGS;
        }

        static {
            String str;
            String str2;
            if (Build.VERSION.SDK_INT >= 34) {
                str = "android.health.connect.action.HEALTH_HOME_SETTINGS";
            } else {
                str = "androidx.health.ACTION_HEALTH_CONNECT_SETTINGS";
            }
            ACTION_HEALTH_CONNECT_SETTINGS = str;
            if (Build.VERSION.SDK_INT >= 34) {
                str2 = "android.health.connect.action.MANAGE_HEALTH_DATA";
            } else {
                str2 = "androidx.health.ACTION_MANAGE_HEALTH_DATA";
            }
            ACTION_HEALTH_CONNECT_MANAGE_DATA = str2;
        }

        public final String getACTION_HEALTH_CONNECT_MANAGE_DATA$connect_client_release() {
            return ACTION_HEALTH_CONNECT_MANAGE_DATA;
        }

        public static /* synthetic */ int getSdkStatus$default(Companion companion, Context context, String str, int i, Object obj) {
            if ((i & 2) != 0) {
                str = "com.google.android.apps.healthdata";
            }
            return companion.getSdkStatus(context, str);
        }

        @JvmStatic
        public final int getSdkStatus(Context context, String providerPackageName) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(providerPackageName, "providerPackageName");
            int i = Build.VERSION.SDK_INT;
            if (34 <= i) {
                return Api34Impl.getSdkStatus(context);
            }
            if (28 > i || i >= 34) {
                return 1;
            }
            PackageManager packageManager = context.getPackageManager();
            Intrinsics.checkNotNullExpressionValue(packageManager, "context.packageManager");
            return isPackageInstalled$default(this, packageManager, providerPackageName, 0, 4, null) ? 3 : 2;
        }

        public static /* synthetic */ HealthConnectClient getOrCreate$default(Companion companion, Context context, String str, int i, Object obj) {
            if ((i & 2) != 0) {
                str = "com.google.android.apps.healthdata";
            }
            return companion.getOrCreate(context, str);
        }

        @JvmStatic
        public final HealthConnectClient getOrCreate(Context context, String providerPackageName) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(providerPackageName, "providerPackageName");
            int sdkStatus = getSdkStatus(context, providerPackageName);
            if (sdkStatus == 1) {
                throw new UnsupportedOperationException("SDK version too low or running in a profile");
            }
            if (sdkStatus == 2) {
                throw new IllegalStateException("Service not available");
            }
            if (Build.VERSION.SDK_INT >= 34) {
                return new HealthConnectClientUpsideDownImpl(context);
            }
            return new HealthConnectClientImpl(context, providerPackageName);
        }

        public static /* synthetic */ Intent getHealthConnectManageDataIntent$default(Companion companion, Context context, String str, int i, Object obj) {
            if ((i & 2) != 0) {
                str = "com.google.android.apps.healthdata";
            }
            return companion.getHealthConnectManageDataIntent(context, str);
        }

        @JvmStatic
        public final Intent getHealthConnectManageDataIntent(Context context, String providerPackageName) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(providerPackageName, "providerPackageName");
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent(ACTION_HEALTH_CONNECT_MANAGE_DATA);
            return (getSdkStatus(context, providerPackageName) != 3 || packageManager.resolveActivity(intent, 0) == null) ? new Intent(ACTION_HEALTH_CONNECT_SETTINGS) : intent;
        }

        static /* synthetic */ boolean isPackageInstalled$default(Companion companion, PackageManager packageManager, String str, int i, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                i = 68623;
            }
            return companion.isPackageInstalled(packageManager, str, i);
        }

        private final boolean isPackageInstalled(PackageManager packageManager, String packageName, int versionCode) throws PackageManager.NameNotFoundException {
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
                Intrinsics.checkNotNullExpressionValue(packageInfo, "{\n                    @S…= */ 0)\n                }");
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                if (applicationInfo == null || !applicationInfo.enabled) {
                    return false;
                }
                return (!Intrinsics.areEqual(packageName, "com.google.android.apps.healthdata") || PackageInfoCompat.getLongVersionCode(packageInfo) >= ((long) versionCode)) && hasBindableService$connect_client_release(packageManager, packageName);
            } catch (PackageManager.NameNotFoundException unused) {
                return false;
            }
        }

        public final boolean hasBindableService$connect_client_release(PackageManager packageManager, String packageName) {
            Intrinsics.checkNotNullParameter(packageManager, "packageManager");
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            Intent intent = new Intent();
            intent.setPackage(packageName);
            intent.setAction(HealthDataService.ANDROID_HEALTH_PLATFORM_SERVICE_BIND_ACTION);
            Intrinsics.checkNotNullExpressionValue(packageManager.queryIntentServices(intent, 0), "packageManager.queryIntentServices(bindIntent, 0)");
            return !r2.isEmpty();
        }
    }

    /* compiled from: HealthConnectClient.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\t"}, d2 = {"Landroidx/health/connect/client/HealthConnectClient$Api34Impl;", "", "()V", "getSdkStatus", "", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "isProfile", "", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Api34Impl {
        public static final Api34Impl INSTANCE = new Api34Impl();

        private Api34Impl() {
        }

        @JvmStatic
        public static final int getSdkStatus(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return (INSTANCE.isProfile(context) || context.getSystemService("healthconnect") == null) ? 1 : 3;
        }

        private final boolean isProfile(Context context) {
            Object systemService = context.getSystemService("user");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.UserManager");
            return ((UserManager) systemService).isProfile();
        }
    }
}
