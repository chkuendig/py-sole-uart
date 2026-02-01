package com.sun.jna.platform.win32;

import com.sun.jna.platform.win32.Wdm;
import com.sun.jna.platform.win32.WinReg;
import com.sun.jna.ptr.IntByReference;

/* loaded from: classes4.dex */
public abstract class NtDllUtil {
    public static String getKeyName(WinReg.HKEY hkey) {
        IntByReference intByReference = new IntByReference();
        int iZwQueryKey = NtDll.INSTANCE.ZwQueryKey(hkey, 0, null, 0, intByReference);
        if (iZwQueryKey != -1073741789 || intByReference.getValue() <= 0) {
            throw new Win32Exception(iZwQueryKey);
        }
        Wdm.KEY_BASIC_INFORMATION key_basic_information = new Wdm.KEY_BASIC_INFORMATION(intByReference.getValue());
        int iZwQueryKey2 = NtDll.INSTANCE.ZwQueryKey(hkey, 0, key_basic_information, intByReference.getValue(), intByReference);
        if (iZwQueryKey2 != 0) {
            throw new Win32Exception(iZwQueryKey2);
        }
        return key_basic_information.getName();
    }
}
