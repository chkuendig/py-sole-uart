package androidx.health.connect.client.feature;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HealthConnectVersionInfo.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0019\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\t\u0010\r\u001a\u00020\u0005HÆ\u0003J$\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Landroidx/health/connect/client/feature/HealthConnectVersionInfo;", "", "apkVersionCode", "", "platformVersion", "Landroidx/health/connect/client/feature/HealthConnectPlatformVersion;", "(Ljava/lang/Long;Landroidx/health/connect/client/feature/HealthConnectPlatformVersion;)V", "getApkVersionCode", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getPlatformVersion", "()Landroidx/health/connect/client/feature/HealthConnectPlatformVersion;", "component1", "component2", "copy", "(Ljava/lang/Long;Landroidx/health/connect/client/feature/HealthConnectPlatformVersion;)Landroidx/health/connect/client/feature/HealthConnectVersionInfo;", "equals", "", "other", "hashCode", "", "toString", "", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class HealthConnectVersionInfo {
    private final Long apkVersionCode;
    private final HealthConnectPlatformVersion platformVersion;

    public static /* synthetic */ HealthConnectVersionInfo copy$default(HealthConnectVersionInfo healthConnectVersionInfo, Long l, HealthConnectPlatformVersion healthConnectPlatformVersion, int i, Object obj) {
        if ((i & 1) != 0) {
            l = healthConnectVersionInfo.apkVersionCode;
        }
        if ((i & 2) != 0) {
            healthConnectPlatformVersion = healthConnectVersionInfo.platformVersion;
        }
        return healthConnectVersionInfo.copy(l, healthConnectPlatformVersion);
    }

    /* renamed from: component1, reason: from getter */
    public final Long getApkVersionCode() {
        return this.apkVersionCode;
    }

    /* renamed from: component2, reason: from getter */
    public final HealthConnectPlatformVersion getPlatformVersion() {
        return this.platformVersion;
    }

    public final HealthConnectVersionInfo copy(Long apkVersionCode, HealthConnectPlatformVersion platformVersion) {
        Intrinsics.checkNotNullParameter(platformVersion, "platformVersion");
        return new HealthConnectVersionInfo(apkVersionCode, platformVersion);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HealthConnectVersionInfo)) {
            return false;
        }
        HealthConnectVersionInfo healthConnectVersionInfo = (HealthConnectVersionInfo) other;
        return Intrinsics.areEqual(this.apkVersionCode, healthConnectVersionInfo.apkVersionCode) && Intrinsics.areEqual(this.platformVersion, healthConnectVersionInfo.platformVersion);
    }

    public int hashCode() {
        Long l = this.apkVersionCode;
        return ((l == null ? 0 : l.hashCode()) * 31) + this.platformVersion.hashCode();
    }

    public String toString() {
        return "HealthConnectVersionInfo(apkVersionCode=" + this.apkVersionCode + ", platformVersion=" + this.platformVersion + ')';
    }

    public HealthConnectVersionInfo(Long l, HealthConnectPlatformVersion platformVersion) {
        Intrinsics.checkNotNullParameter(platformVersion, "platformVersion");
        this.apkVersionCode = l;
        this.platformVersion = platformVersion;
    }

    public /* synthetic */ HealthConnectVersionInfo(Long l, HealthConnectPlatformVersion healthConnectPlatformVersion, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l, healthConnectPlatformVersion);
    }

    public final Long getApkVersionCode() {
        return this.apkVersionCode;
    }

    public final HealthConnectPlatformVersion getPlatformVersion() {
        return this.platformVersion;
    }
}
