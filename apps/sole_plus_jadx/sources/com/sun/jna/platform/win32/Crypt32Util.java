package com.sun.jna.platform.win32;

import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinCrypt;
import com.sun.jna.ptr.PointerByReference;

/* loaded from: classes4.dex */
public abstract class Crypt32Util {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public static byte[] cryptProtectData(byte[] bArr) {
        return cryptProtectData(bArr, 0);
    }

    public static byte[] cryptProtectData(byte[] bArr, int i) {
        return cryptProtectData(bArr, null, i, "", null);
    }

    public static byte[] cryptProtectData(byte[] bArr, byte[] bArr2, int i, String str, WinCrypt.CRYPTPROTECT_PROMPTSTRUCT cryptprotect_promptstruct) {
        WinCrypt.DATA_BLOB data_blob = new WinCrypt.DATA_BLOB(bArr);
        WinCrypt.DATA_BLOB data_blob2 = new WinCrypt.DATA_BLOB();
        try {
            if (!Crypt32.INSTANCE.CryptProtectData(data_blob, str, bArr2 == null ? null : new WinCrypt.DATA_BLOB(bArr2), null, cryptprotect_promptstruct, i, data_blob2)) {
                throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
            }
            return data_blob2.getData();
        } finally {
            if (data_blob2.pbData != null) {
                Kernel32Util.freeLocalMemory(data_blob2.pbData);
            }
        }
    }

    public static byte[] cryptUnprotectData(byte[] bArr) {
        return cryptUnprotectData(bArr, 0);
    }

    public static byte[] cryptUnprotectData(byte[] bArr, int i) {
        return cryptUnprotectData(bArr, null, i, null);
    }

    public static byte[] cryptUnprotectData(byte[] bArr, byte[] bArr2, int i, WinCrypt.CRYPTPROTECT_PROMPTSTRUCT cryptprotect_promptstruct) {
        byte[] data;
        WinCrypt.DATA_BLOB data_blob = new WinCrypt.DATA_BLOB(bArr);
        WinCrypt.DATA_BLOB data_blob2 = new WinCrypt.DATA_BLOB();
        Win32Exception win32Exception = null;
        WinCrypt.DATA_BLOB data_blob3 = bArr2 == null ? null : new WinCrypt.DATA_BLOB(bArr2);
        PointerByReference pointerByReference = new PointerByReference();
        try {
            if (!Crypt32.INSTANCE.CryptUnprotectData(data_blob, pointerByReference, data_blob3, null, cryptprotect_promptstruct, i, data_blob2)) {
                win32Exception = new Win32Exception(Kernel32.INSTANCE.GetLastError());
                data = null;
            } else {
                data = data_blob2.getData();
            }
            if (data_blob2.pbData != null) {
                try {
                    Kernel32Util.freeLocalMemory(data_blob2.pbData);
                } catch (Win32Exception e) {
                    if (win32Exception == null) {
                        win32Exception = e;
                    } else {
                        win32Exception.addSuppressedReflected(e);
                    }
                }
            }
            if (pointerByReference.getValue() != null) {
                try {
                    Kernel32Util.freeLocalMemory(pointerByReference.getValue());
                } catch (Win32Exception e2) {
                    if (win32Exception == null) {
                        win32Exception = e2;
                    } else {
                        win32Exception.addSuppressedReflected(e2);
                    }
                }
            }
            if (win32Exception == null) {
                return data;
            }
            throw win32Exception;
        } finally {
        }
    }

    public static String CertNameToStr(int i, int i2, WinCrypt.DATA_BLOB data_blob) {
        int i3 = Boolean.getBoolean("w32.ascii") ? 1 : Native.WCHAR_SIZE;
        int iCertNameToStr = Crypt32.INSTANCE.CertNameToStr(i, data_blob, i2, Pointer.NULL, 0);
        Memory memory = new Memory(i3 * iCertNameToStr);
        Crypt32.INSTANCE.CertNameToStr(i, data_blob, i2, memory, iCertNameToStr);
        if (Boolean.getBoolean("w32.ascii")) {
            return memory.getString(0L);
        }
        return memory.getWideString(0L);
    }
}
