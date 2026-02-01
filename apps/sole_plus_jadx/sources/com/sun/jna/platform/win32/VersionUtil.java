package com.sun.jna.platform.win32;

import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.platform.win32.VerRsrc;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;

/* loaded from: classes4.dex */
public class VersionUtil {
    public static VerRsrc.VS_FIXEDFILEINFO getFileVersionInfo(String str) {
        int iGetFileVersionInfoSize = Version.INSTANCE.GetFileVersionInfoSize(str, new IntByReference());
        if (iGetFileVersionInfoSize == 0) {
            throw new Win32Exception(Native.getLastError());
        }
        Memory memory = new Memory(iGetFileVersionInfoSize);
        PointerByReference pointerByReference = new PointerByReference();
        if (!Version.INSTANCE.GetFileVersionInfo(str, 0, iGetFileVersionInfoSize, memory)) {
            throw new Win32Exception(Native.getLastError());
        }
        if (!Version.INSTANCE.VerQueryValue(memory, "\\", pointerByReference, new IntByReference())) {
            throw new UnsupportedOperationException("Unable to extract version info from the file: \"" + str + "\"");
        }
        VerRsrc.VS_FIXEDFILEINFO vs_fixedfileinfo = new VerRsrc.VS_FIXEDFILEINFO(pointerByReference.getValue());
        vs_fixedfileinfo.read();
        return vs_fixedfileinfo;
    }
}
