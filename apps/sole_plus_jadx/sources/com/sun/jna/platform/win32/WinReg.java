package com.sun.jna.platform.win32;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.ptr.ByReference;

/* loaded from: classes4.dex */
public interface WinReg {
    public static final HKEY HKEY_CLASSES_ROOT = new HKEY(Integer.MIN_VALUE);
    public static final HKEY HKEY_CURRENT_USER = new HKEY(-2147483647);
    public static final HKEY HKEY_LOCAL_MACHINE = new HKEY(WinPerf.PERF_QUERY_COSTLY);
    public static final HKEY HKEY_USERS = new HKEY(-2147483645);
    public static final HKEY HKEY_PERFORMANCE_DATA = new HKEY(-2147483644);
    public static final HKEY HKEY_PERFORMANCE_TEXT = new HKEY(-2147483568);
    public static final HKEY HKEY_PERFORMANCE_NLSTEXT = new HKEY(-2147483552);
    public static final HKEY HKEY_CURRENT_CONFIG = new HKEY(-2147483643);
    public static final HKEY HKEY_DYN_DATA = new HKEY(WinNT.IO_REPARSE_TAG_HSM2);

    public static class HKEY extends WinNT.HANDLE {
        public HKEY() {
        }

        public HKEY(Pointer pointer) {
            super(pointer);
        }

        public HKEY(int i) {
            super(new Pointer(i));
        }
    }

    public static class HKEYByReference extends ByReference {
        public HKEYByReference() {
            this(null);
        }

        public HKEYByReference(HKEY hkey) {
            super(Native.POINTER_SIZE);
            setValue(hkey);
        }

        public void setValue(HKEY hkey) {
            getPointer().setPointer(0L, hkey != null ? hkey.getPointer() : null);
        }

        public HKEY getValue() {
            Pointer pointer = getPointer().getPointer(0L);
            if (pointer == null) {
                return null;
            }
            if (WinBase.INVALID_HANDLE_VALUE.getPointer().equals(pointer)) {
                return (HKEY) WinBase.INVALID_HANDLE_VALUE;
            }
            HKEY hkey = new HKEY();
            hkey.setPointer(pointer);
            return hkey;
        }
    }
}
