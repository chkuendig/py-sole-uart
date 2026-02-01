package androidx.health.platform.client;

import android.content.Context;
import androidx.health.platform.client.impl.ServiceBackedHealthDataClient;
import androidx.health.platform.client.impl.ipc.ClientConfiguration;
import com.android.SdkConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HealthDataService.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004J&\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/health/platform/client/HealthDataService;", "", "()V", "ANDROID_HEALTH_PLATFORM_CLIENT_NAME", "", "ANDROID_HEALTH_PLATFORM_PROVIDER_PACKAGE", "ANDROID_HEALTH_PLATFORM_SERVICE_BIND_ACTION", "getClient", "Landroidx/health/platform/client/HealthDataAsyncClient;", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "enabledPackage", "clientName", "servicePackageName", "bindAction", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class HealthDataService {
    private static final String ANDROID_HEALTH_PLATFORM_CLIENT_NAME = "HealthData";
    private static final String ANDROID_HEALTH_PLATFORM_PROVIDER_PACKAGE = "com.google.android.apps.healthdata";
    public static final String ANDROID_HEALTH_PLATFORM_SERVICE_BIND_ACTION = "androidx.health.ACTION_BIND_HEALTH_DATA_SERVICE";
    public static final HealthDataService INSTANCE = new HealthDataService();

    private HealthDataService() {
    }

    public final HealthDataAsyncClient getClient(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ServiceBackedHealthDataClient(context, new ClientConfiguration(ANDROID_HEALTH_PLATFORM_CLIENT_NAME, "com.google.android.apps.healthdata", ANDROID_HEALTH_PLATFORM_SERVICE_BIND_ACTION));
    }

    public final HealthDataAsyncClient getClient(Context context, String clientName, String servicePackageName, String bindAction) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(clientName, "clientName");
        Intrinsics.checkNotNullParameter(servicePackageName, "servicePackageName");
        Intrinsics.checkNotNullParameter(bindAction, "bindAction");
        if (servicePackageName.length() == 0) {
            throw new IllegalArgumentException("Service package name must not be empty.".toString());
        }
        return new ServiceBackedHealthDataClient(context, new ClientConfiguration(clientName, servicePackageName, bindAction));
    }

    public final HealthDataAsyncClient getClient(Context context, String enabledPackage) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(enabledPackage, "enabledPackage");
        return getClient(context, ANDROID_HEALTH_PLATFORM_CLIENT_NAME, enabledPackage, ANDROID_HEALTH_PLATFORM_SERVICE_BIND_ACTION);
    }
}
