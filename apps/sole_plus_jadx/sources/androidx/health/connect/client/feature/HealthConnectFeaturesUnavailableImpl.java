package androidx.health.connect.client.feature;

import androidx.health.connect.client.HealthConnectFeatures;
import kotlin.Metadata;

/* compiled from: HealthConnectFeaturesUnavailableImpl.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"Landroidx/health/connect/client/feature/HealthConnectFeaturesUnavailableImpl;", "Landroidx/health/connect/client/HealthConnectFeatures;", "()V", "getFeatureStatus", "", "feature", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class HealthConnectFeaturesUnavailableImpl implements HealthConnectFeatures {
    public static final HealthConnectFeaturesUnavailableImpl INSTANCE = new HealthConnectFeaturesUnavailableImpl();

    @Override // androidx.health.connect.client.HealthConnectFeatures
    public int getFeatureStatus(int feature) {
        return 1;
    }

    private HealthConnectFeaturesUnavailableImpl() {
    }
}
