package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import android.util.Size;
import androidx.camera.core.impl.Quirk;
import com.sun.jna.platform.win32.LMErr;
import com.sun.jna.platform.win32.WinError;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes.dex */
public class SmallDisplaySizeQuirk implements Quirk {
    private static final Map<String, Size> MODEL_TO_DISPLAY_SIZE_MAP;
    private static final String TAG = "SmallDisplaySizeQuirk";

    static {
        HashMap map = new HashMap();
        MODEL_TO_DISPLAY_SIZE_MAP = map;
        map.put("REDMI NOTE 8", new Size(WinError.ERROR_CANNOT_DETECT_DRIVER_FAILURE, LMErr.NERR_BadDevString));
        map.put("REDMI NOTE 7", new Size(WinError.ERROR_CANNOT_DETECT_DRIVER_FAILURE, LMErr.NERR_BadDevString));
        map.put("SM-A207M", new Size(WinError.ERROR_IMAGE_MACHINE_TYPE_MISMATCH_EXE, 1560));
        map.put("REDMI NOTE 7S", new Size(WinError.ERROR_CANNOT_DETECT_DRIVER_FAILURE, LMErr.NERR_BadDevString));
        map.put("SM-A127F", new Size(WinError.ERROR_IMAGE_MACHINE_TYPE_MISMATCH_EXE, 1600));
        map.put("SM-A536E", new Size(WinError.ERROR_CANNOT_DETECT_DRIVER_FAILURE, 2400));
        map.put("220233L2I", new Size(WinError.ERROR_IMAGE_MACHINE_TYPE_MISMATCH_EXE, 1600));
        map.put("V2149", new Size(WinError.ERROR_IMAGE_MACHINE_TYPE_MISMATCH_EXE, 1600));
        map.put("VIVO 1920", new Size(WinError.ERROR_CANNOT_DETECT_DRIVER_FAILURE, LMErr.NERR_BadDevString));
        map.put("CPH2223", new Size(WinError.ERROR_CANNOT_DETECT_DRIVER_FAILURE, 2400));
        map.put("V2029", new Size(WinError.ERROR_IMAGE_MACHINE_TYPE_MISMATCH_EXE, 1600));
        map.put("CPH1901", new Size(WinError.ERROR_IMAGE_MACHINE_TYPE_MISMATCH_EXE, 1520));
        map.put("REDMI Y3", new Size(WinError.ERROR_IMAGE_MACHINE_TYPE_MISMATCH_EXE, 1520));
        map.put("SM-A045M", new Size(WinError.ERROR_IMAGE_MACHINE_TYPE_MISMATCH_EXE, 1600));
        map.put("SM-A146U", new Size(WinError.ERROR_CANNOT_DETECT_DRIVER_FAILURE, 2408));
        map.put("CPH1909", new Size(WinError.ERROR_IMAGE_MACHINE_TYPE_MISMATCH_EXE, 1520));
        map.put("NOKIA 4.2", new Size(WinError.ERROR_IMAGE_MACHINE_TYPE_MISMATCH_EXE, 1520));
        map.put("SM-G960U1", new Size(WinError.ERROR_SCREEN_ALREADY_LOCKED, 2960));
        map.put("SM-A137F", new Size(WinError.ERROR_CANNOT_DETECT_DRIVER_FAILURE, 2408));
        map.put("VIVO 1816", new Size(WinError.ERROR_IMAGE_MACHINE_TYPE_MISMATCH_EXE, 1520));
        map.put("INFINIX X6817", new Size(WinError.ERROR_IMAGE_MACHINE_TYPE_MISMATCH_EXE, WinError.ERROR_INSTALL_SOURCE_ABSENT));
        map.put("SM-A037F", new Size(WinError.ERROR_IMAGE_MACHINE_TYPE_MISMATCH_EXE, 1600));
        map.put("NOKIA 2.4", new Size(WinError.ERROR_IMAGE_MACHINE_TYPE_MISMATCH_EXE, 1600));
        map.put("SM-A125M", new Size(WinError.ERROR_IMAGE_MACHINE_TYPE_MISMATCH_EXE, 1600));
        map.put("INFINIX X670", new Size(WinError.ERROR_CANNOT_DETECT_DRIVER_FAILURE, 2400));
    }

    static boolean load() {
        return MODEL_TO_DISPLAY_SIZE_MAP.containsKey(Build.MODEL.toUpperCase(Locale.US));
    }

    public Size getDisplaySize() {
        return MODEL_TO_DISPLAY_SIZE_MAP.get(Build.MODEL.toUpperCase(Locale.US));
    }
}
