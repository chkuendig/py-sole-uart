package com.sun.jna.platform.win32;

import com.sun.jna.ptr.IntByReference;
import java.util.Arrays;

/* loaded from: classes4.dex */
public abstract class PsapiUtil {
    public static int[] enumProcesses() {
        int[] iArr;
        IntByReference intByReference = new IntByReference();
        int i = 0;
        do {
            i += 1024;
            iArr = new int[i];
            if (!Psapi.INSTANCE.EnumProcesses(iArr, i * 4, intByReference)) {
                throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
            }
        } while (i == intByReference.getValue() / 4);
        return Arrays.copyOf(iArr, intByReference.getValue() / 4);
    }
}
