package com.sun.jna.platform.win32;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.Guid;
import com.sun.jna.platform.win32.ShlObj;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.ptr.PointerByReference;

/* loaded from: classes4.dex */
public abstract class Shell32Util {
    public static String getFolderPath(WinDef.HWND hwnd, int i, WinDef.DWORD dword) {
        char[] cArr = new char[260];
        WinNT.HRESULT hresultSHGetFolderPath = Shell32.INSTANCE.SHGetFolderPath(hwnd, i, null, dword, cArr);
        if (!hresultSHGetFolderPath.equals(W32Errors.S_OK)) {
            throw new Win32Exception(hresultSHGetFolderPath);
        }
        return Native.toString(cArr);
    }

    public static String getFolderPath(int i) {
        return getFolderPath(null, i, ShlObj.SHGFP_TYPE_CURRENT);
    }

    public static String getKnownFolderPath(Guid.GUID guid) throws Win32Exception {
        int flag = ShlObj.KNOWN_FOLDER_FLAG.NONE.getFlag();
        PointerByReference pointerByReference = new PointerByReference();
        WinNT.HRESULT hresultSHGetKnownFolderPath = Shell32.INSTANCE.SHGetKnownFolderPath(guid, flag, null, pointerByReference);
        if (!W32Errors.SUCCEEDED(hresultSHGetKnownFolderPath.intValue())) {
            throw new Win32Exception(hresultSHGetKnownFolderPath);
        }
        String wideString = pointerByReference.getValue().getWideString(0L);
        Ole32.INSTANCE.CoTaskMemFree(pointerByReference.getValue());
        return wideString;
    }

    public static final String getSpecialFolderPath(int i, boolean z) {
        char[] cArr = new char[260];
        if (!Shell32.INSTANCE.SHGetSpecialFolderPath(null, cArr, i, z)) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        return Native.toString(cArr);
    }
}
