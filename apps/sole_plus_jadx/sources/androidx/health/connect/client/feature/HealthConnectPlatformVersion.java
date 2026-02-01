package androidx.health.connect.client.feature;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HealthConnectVersionInfo.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ$\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Landroidx/health/connect/client/feature/HealthConnectPlatformVersion;", "", "buildVersionCode", "", "sdkExtensionVersion", "(ILjava/lang/Integer;)V", "getBuildVersionCode", "()I", "getSdkExtensionVersion", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(ILjava/lang/Integer;)Landroidx/health/connect/client/feature/HealthConnectPlatformVersion;", "equals", "", "other", "hashCode", "toString", "", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class HealthConnectPlatformVersion {
    private final int buildVersionCode;
    private final Integer sdkExtensionVersion;

    public static /* synthetic */ HealthConnectPlatformVersion copy$default(HealthConnectPlatformVersion healthConnectPlatformVersion, int i, Integer num, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = healthConnectPlatformVersion.buildVersionCode;
        }
        if ((i2 & 2) != 0) {
            num = healthConnectPlatformVersion.sdkExtensionVersion;
        }
        return healthConnectPlatformVersion.copy(i, num);
    }

    /* renamed from: component1, reason: from getter */
    public final int getBuildVersionCode() {
        return this.buildVersionCode;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getSdkExtensionVersion() {
        return this.sdkExtensionVersion;
    }

    public final HealthConnectPlatformVersion copy(int buildVersionCode, Integer sdkExtensionVersion) {
        return new HealthConnectPlatformVersion(buildVersionCode, sdkExtensionVersion);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HealthConnectPlatformVersion)) {
            return false;
        }
        HealthConnectPlatformVersion healthConnectPlatformVersion = (HealthConnectPlatformVersion) other;
        return this.buildVersionCode == healthConnectPlatformVersion.buildVersionCode && Intrinsics.areEqual(this.sdkExtensionVersion, healthConnectPlatformVersion.sdkExtensionVersion);
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.buildVersionCode) * 31;
        Integer num = this.sdkExtensionVersion;
        return iHashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "HealthConnectPlatformVersion(buildVersionCode=" + this.buildVersionCode + ", sdkExtensionVersion=" + this.sdkExtensionVersion + ')';
    }

    public HealthConnectPlatformVersion(int i, Integer num) {
        this.buildVersionCode = i;
        this.sdkExtensionVersion = num;
    }

    public /* synthetic */ HealthConnectPlatformVersion(int i, Integer num, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : num);
    }

    public final int getBuildVersionCode() {
        return this.buildVersionCode;
    }

    public final Integer getSdkExtensionVersion() {
        return this.sdkExtensionVersion;
    }
}
