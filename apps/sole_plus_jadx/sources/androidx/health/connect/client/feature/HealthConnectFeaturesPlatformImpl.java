package androidx.health.connect.client.feature;

import android.os.Build;
import android.os.ext.SdkExtensions;
import androidx.health.connect.client.HealthConnectFeatures;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HealthConnectFeaturesPlatformImpl.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0001\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0007"}, d2 = {"Landroidx/health/connect/client/feature/HealthConnectFeaturesPlatformImpl;", "Landroidx/health/connect/client/HealthConnectFeatures;", "()V", "getFeatureStatus", "", "feature", "Companion", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class HealthConnectFeaturesPlatformImpl implements HealthConnectFeatures {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Override // androidx.health.connect.client.HealthConnectFeatures
    public int getFeatureStatus(int feature) {
        return INSTANCE.getFeatureStatus$connect_client_release(HealthConnectFeatures.INSTANCE.getFEATURE_TO_VERSION_INFO_MAP$connect_client_release(), feature);
    }

    /* compiled from: HealthConnectFeaturesPlatformImpl.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0081\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u00020\u0004*\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\u0004H\u0001¢\u0006\u0002\b\b¨\u0006\t"}, d2 = {"Landroidx/health/connect/client/feature/HealthConnectFeaturesPlatformImpl$Companion;", "", "()V", "getFeatureStatus", "", "", "Landroidx/health/connect/client/feature/HealthConnectVersionInfo;", "feature", "getFeatureStatus$connect_client_release", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getFeatureStatus$connect_client_release(Map<Integer, HealthConnectVersionInfo> map, int i) {
            HealthConnectPlatformVersion platformVersion;
            Intrinsics.checkNotNullParameter(map, "<this>");
            HealthConnectVersionInfo healthConnectVersionInfo = map.get(Integer.valueOf(i));
            if (healthConnectVersionInfo == null || (platformVersion = healthConnectVersionInfo.getPlatformVersion()) == null || platformVersion.getBuildVersionCode() > Build.VERSION.SDK_INT) {
                return 1;
            }
            return (platformVersion.getSdkExtensionVersion() != null && platformVersion.getSdkExtensionVersion().intValue() > SdkExtensions.getExtensionVersion(platformVersion.getBuildVersionCode())) ? 1 : 2;
        }
    }
}
