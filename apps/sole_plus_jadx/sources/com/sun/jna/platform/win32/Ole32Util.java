package com.sun.jna.platform.win32;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.Guid;
import com.sun.jna.platform.win32.WinNT;

/* loaded from: classes4.dex */
public abstract class Ole32Util {
    public static Guid.GUID getGUIDFromString(String str) {
        Guid.GUID guid = new Guid.GUID();
        WinNT.HRESULT hresultIIDFromString = Ole32.INSTANCE.IIDFromString(str, guid);
        if (hresultIIDFromString.equals(W32Errors.S_OK)) {
            return guid;
        }
        throw new RuntimeException(hresultIIDFromString.toString());
    }

    public static String getStringFromGUID(Guid.GUID guid) {
        char[] cArr = new char[39];
        int iStringFromGUID2 = Ole32.INSTANCE.StringFromGUID2(new Guid.GUID(guid.getPointer()), cArr, 39);
        if (iStringFromGUID2 == 0) {
            throw new RuntimeException("StringFromGUID2");
        }
        cArr[iStringFromGUID2 - 1] = 0;
        return Native.toString(cArr);
    }

    public static Guid.GUID generateGUID() {
        Guid.GUID guid = new Guid.GUID();
        WinNT.HRESULT hresultCoCreateGuid = Ole32.INSTANCE.CoCreateGuid(guid);
        if (hresultCoCreateGuid.equals(W32Errors.S_OK)) {
            return guid;
        }
        throw new RuntimeException(hresultCoCreateGuid.toString());
    }
}
