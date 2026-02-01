package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build;
import android.util.Size;
import androidx.camera.core.impl.Quirk;
import com.sun.jna.platform.win32.WinError;

/* loaded from: classes.dex */
public class ExtraSupportedOutputSizeQuirk implements Quirk {
    static boolean load() {
        return isMotoE5Play();
    }

    private static boolean isMotoE5Play() {
        return "motorola".equalsIgnoreCase(Build.BRAND) && "moto e5 play".equalsIgnoreCase(Build.MODEL);
    }

    public Size[] getExtraSupportedResolutions(int i) {
        if (i == 34 && isMotoE5Play()) {
            return getMotoE5PlayExtraSupportedResolutions();
        }
        return new Size[0];
    }

    public <T> Size[] getExtraSupportedResolutions(Class<T> cls) {
        if (StreamConfigurationMap.isOutputSupportedFor(cls) && isMotoE5Play()) {
            return getMotoE5PlayExtraSupportedResolutions();
        }
        return new Size[0];
    }

    private Size[] getMotoE5PlayExtraSupportedResolutions() {
        return new Size[]{new Size(WinError.ERROR_SCREEN_ALREADY_LOCKED, WinError.ERROR_CANNOT_DETECT_DRIVER_FAILURE), new Size(960, WinError.ERROR_IMAGE_MACHINE_TYPE_MISMATCH_EXE)};
    }
}
