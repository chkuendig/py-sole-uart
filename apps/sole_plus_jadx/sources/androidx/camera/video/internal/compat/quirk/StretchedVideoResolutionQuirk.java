package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import android.util.Size;
import androidx.camera.core.impl.Quirk;
import com.sun.jna.platform.win32.WinError;

/* loaded from: classes.dex */
public class StretchedVideoResolutionQuirk implements Quirk {
    static boolean load() {
        return isMotoE5Play();
    }

    private static boolean isMotoE5Play() {
        return "motorola".equalsIgnoreCase(Build.BRAND) && "moto e5 play".equalsIgnoreCase(Build.MODEL);
    }

    public Size getAlternativeResolution(int i) {
        if (i == 4) {
            return new Size(WinError.ERROR_MULTIPLE_FAULT_VIOLATION, 480);
        }
        if (i == 5) {
            return new Size(960, WinError.ERROR_IMAGE_MACHINE_TYPE_MISMATCH_EXE);
        }
        if (i != 6) {
            return null;
        }
        return new Size(WinError.ERROR_SCREEN_ALREADY_LOCKED, WinError.ERROR_CANNOT_DETECT_DRIVER_FAILURE);
    }
}
