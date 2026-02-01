package androidx.health.connect.client;

import androidx.health.connect.client.feature.HealthConnectVersionInfo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.MapsKt;

/* compiled from: HealthConnectFeatures.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/health/connect/client/HealthConnectFeatures;", "", "getFeatureStatus", "", "feature", "Companion", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface HealthConnectFeatures {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int FEATURE_HEALTH_DATA_BACKGROUND_READ = 1;
    public static final int FEATURE_HEALTH_DATA_HISTORIC_READ = 4;
    public static final int FEATURE_PLANNED_EXERCISE = 3;
    public static final int FEATURE_SKIN_TEMPERATURE = 2;
    public static final int FEATURE_STATUS_AVAILABLE = 2;
    public static final int FEATURE_STATUS_UNAVAILABLE = 1;

    int getFeatureStatus(int feature);

    /* compiled from: HealthConnectFeatures.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0002\u000f\u0010B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f0\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Landroidx/health/connect/client/HealthConnectFeatures$Companion;", "", "()V", "FEATURE_HEALTH_DATA_BACKGROUND_READ", "", "FEATURE_HEALTH_DATA_HISTORIC_READ", "FEATURE_PLANNED_EXERCISE", "FEATURE_SKIN_TEMPERATURE", "FEATURE_STATUS_AVAILABLE", "FEATURE_STATUS_UNAVAILABLE", "FEATURE_TO_VERSION_INFO_MAP", "", "Landroidx/health/connect/client/feature/HealthConnectVersionInfo;", "getFEATURE_TO_VERSION_INFO_MAP$connect_client_release", "()Ljava/util/Map;", "Feature", "FeatureStatus", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public static final int FEATURE_HEALTH_DATA_BACKGROUND_READ = 1;
        public static final int FEATURE_HEALTH_DATA_HISTORIC_READ = 4;
        public static final int FEATURE_PLANNED_EXERCISE = 3;
        public static final int FEATURE_SKIN_TEMPERATURE = 2;
        public static final int FEATURE_STATUS_AVAILABLE = 2;
        public static final int FEATURE_STATUS_UNAVAILABLE = 1;
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Map<Integer, HealthConnectVersionInfo> FEATURE_TO_VERSION_INFO_MAP = MapsKt.emptyMap();

        /* compiled from: HealthConnectFeatures.kt */
        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Landroidx/health/connect/client/HealthConnectFeatures$Companion$Feature;", "", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface Feature {
        }

        /* compiled from: HealthConnectFeatures.kt */
        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Landroidx/health/connect/client/HealthConnectFeatures$Companion$FeatureStatus;", "", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface FeatureStatus {
        }

        private Companion() {
        }

        public final Map<Integer, HealthConnectVersionInfo> getFEATURE_TO_VERSION_INFO_MAP$connect_client_release() {
            return FEATURE_TO_VERSION_INFO_MAP;
        }
    }
}
