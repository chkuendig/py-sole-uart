package androidx.camera.core.internal.utils;

import android.util.Size;
import androidx.camera.core.impl.utils.CompareSizesByArea;
import com.sun.jna.platform.win32.WinError;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes.dex */
public final class SizeUtil {
    public static final Size RESOLUTION_ZERO = new Size(0, 0);
    public static final Size RESOLUTION_QVGA = new Size(320, 240);
    public static final Size RESOLUTION_VGA = new Size(WinError.ERROR_MULTIPLE_FAULT_VIOLATION, 480);
    public static final Size RESOLUTION_480P = new Size(WinError.ERROR_IMAGE_MACHINE_TYPE_MISMATCH_EXE, 480);
    public static final Size RESOLUTION_720P = new Size(1280, WinError.ERROR_IMAGE_MACHINE_TYPE_MISMATCH_EXE);
    public static final Size RESOLUTION_1080P = new Size(WinError.ERROR_CANT_ACCESS_FILE, WinError.ERROR_CANNOT_DETECT_DRIVER_FAILURE);
    public static final Size RESOLUTION_1440P = new Size(WinError.ERROR_CANT_ACCESS_FILE, WinError.ERROR_SCREEN_ALREADY_LOCKED);

    public static int getArea(int i, int i2) {
        return i * i2;
    }

    private SizeUtil() {
    }

    public static int getArea(Size size) {
        return getArea(size.getWidth(), size.getHeight());
    }

    public static boolean isSmallerByArea(Size size, Size size2) {
        return getArea(size) < getArea(size2);
    }

    public static boolean isLongerInAnyEdge(Size size, Size size2) {
        return size.getWidth() > size2.getWidth() || size.getHeight() > size2.getHeight();
    }

    public static Size getMaxSize(List<Size> list) {
        if (list.isEmpty()) {
            return null;
        }
        return (Size) Collections.max(list, new CompareSizesByArea());
    }

    public static <T> T findNearestHigherFor(Size size, TreeMap<Size, T> treeMap) {
        Map.Entry<Size, T> entryCeilingEntry = treeMap.ceilingEntry(size);
        if (entryCeilingEntry != null) {
            return entryCeilingEntry.getValue();
        }
        Map.Entry<Size, T> entryFloorEntry = treeMap.floorEntry(size);
        if (entryFloorEntry != null) {
            return entryFloorEntry.getValue();
        }
        return null;
    }
}
