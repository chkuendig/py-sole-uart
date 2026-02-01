package com.sun.jna.platform.win32;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.Sspi;
import com.sun.jna.ptr.IntByReference;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public abstract class Secur32Util {

    public static class SecurityPackage {
        public String comment;
        public String name;
    }

    public static String getUserNameEx(int i) {
        char[] cArr = new char[128];
        IntByReference intByReference = new IntByReference(128);
        boolean zGetUserNameEx = Secur32.INSTANCE.GetUserNameEx(i, cArr, intByReference);
        if (!zGetUserNameEx) {
            if (Kernel32.INSTANCE.GetLastError() == 234) {
                cArr = new char[intByReference.getValue() + 1];
                zGetUserNameEx = Secur32.INSTANCE.GetUserNameEx(i, cArr, intByReference);
            } else {
                throw new Win32Exception(Native.getLastError());
            }
        }
        if (!zGetUserNameEx) {
            throw new Win32Exception(Native.getLastError());
        }
        return Native.toString(cArr);
    }

    public static SecurityPackage[] getSecurityPackages() {
        IntByReference intByReference = new IntByReference();
        Sspi.PSecPkgInfo pSecPkgInfo = new Sspi.PSecPkgInfo();
        int iEnumerateSecurityPackages = Secur32.INSTANCE.EnumerateSecurityPackages(intByReference, pSecPkgInfo);
        if (iEnumerateSecurityPackages != 0) {
            throw new Win32Exception(iEnumerateSecurityPackages);
        }
        Sspi.SecPkgInfo.ByReference[] array = pSecPkgInfo.toArray(intByReference.getValue());
        ArrayList arrayList = new ArrayList(intByReference.getValue());
        for (Sspi.SecPkgInfo.ByReference byReference : array) {
            SecurityPackage securityPackage = new SecurityPackage();
            securityPackage.name = byReference.Name.toString();
            securityPackage.comment = byReference.Comment.toString();
            arrayList.add(securityPackage);
        }
        int iFreeContextBuffer = Secur32.INSTANCE.FreeContextBuffer(pSecPkgInfo.pPkgInfo.getPointer());
        if (iFreeContextBuffer != 0) {
            throw new Win32Exception(iFreeContextBuffer);
        }
        return (SecurityPackage[]) arrayList.toArray(new SecurityPackage[0]);
    }
}
