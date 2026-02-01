package androidx.camera.camera2.internal;

import androidx.camera.camera2.internal.SupportedSurfaceCombination;
import com.android.SdkConstants;
import com.sun.jna.platform.win32.WinError;

/* loaded from: classes.dex */
final class AutoValue_SupportedSurfaceCombination_FeatureSettings extends SupportedSurfaceCombination.FeatureSettings {
    private final int cameraMode;
    private final boolean previewStabilizationOn;
    private final int requiredMaxBitDepth;
    private final boolean ultraHdrOn;

    AutoValue_SupportedSurfaceCombination_FeatureSettings(int i, int i2, boolean z, boolean z2) {
        this.cameraMode = i;
        this.requiredMaxBitDepth = i2;
        this.previewStabilizationOn = z;
        this.ultraHdrOn = z2;
    }

    @Override // androidx.camera.camera2.internal.SupportedSurfaceCombination.FeatureSettings
    int getCameraMode() {
        return this.cameraMode;
    }

    @Override // androidx.camera.camera2.internal.SupportedSurfaceCombination.FeatureSettings
    int getRequiredMaxBitDepth() {
        return this.requiredMaxBitDepth;
    }

    @Override // androidx.camera.camera2.internal.SupportedSurfaceCombination.FeatureSettings
    boolean isPreviewStabilizationOn() {
        return this.previewStabilizationOn;
    }

    @Override // androidx.camera.camera2.internal.SupportedSurfaceCombination.FeatureSettings
    boolean isUltraHdrOn() {
        return this.ultraHdrOn;
    }

    public String toString() {
        return "FeatureSettings{cameraMode=" + this.cameraMode + ", requiredMaxBitDepth=" + this.requiredMaxBitDepth + ", previewStabilizationOn=" + this.previewStabilizationOn + ", ultraHdrOn=" + this.ultraHdrOn + SdkConstants.MANIFEST_PLACEHOLDER_SUFFIX;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SupportedSurfaceCombination.FeatureSettings)) {
            return false;
        }
        SupportedSurfaceCombination.FeatureSettings featureSettings = (SupportedSurfaceCombination.FeatureSettings) obj;
        return this.cameraMode == featureSettings.getCameraMode() && this.requiredMaxBitDepth == featureSettings.getRequiredMaxBitDepth() && this.previewStabilizationOn == featureSettings.isPreviewStabilizationOn() && this.ultraHdrOn == featureSettings.isUltraHdrOn();
    }

    public int hashCode() {
        int i = (((this.cameraMode ^ 1000003) * 1000003) ^ this.requiredMaxBitDepth) * 1000003;
        boolean z = this.previewStabilizationOn;
        int i2 = WinError.ERROR_NETWORK_UNREACHABLE;
        int i3 = (i ^ (z ? 1231 : 1237)) * 1000003;
        if (!this.ultraHdrOn) {
            i2 = 1237;
        }
        return i3 ^ i2;
    }
}
