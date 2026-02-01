package com.sun.jna.platform.win32.COM;

import com.sun.jna.LastErrorException;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.Advapi32;
import com.sun.jna.platform.win32.Advapi32Util;
import com.sun.jna.platform.win32.Kernel32Util;
import com.sun.jna.platform.win32.OaIdl;
import com.sun.jna.platform.win32.Ole32;
import com.sun.jna.platform.win32.OleAuto;
import com.sun.jna.platform.win32.W32Errors;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.platform.win32.WinReg;
import com.sun.jna.ptr.IntByReference;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public abstract class COMUtils {
    public static final int E_UNEXPECTED = -2147418113;
    public static final int S_FALSE = 1;
    public static final int S_OK = 0;

    public static boolean FAILED(int i) {
        return i < 0;
    }

    public static boolean SUCCEEDED(int i) {
        return i >= 0;
    }

    public static boolean SUCCEEDED(WinNT.HRESULT hresult) {
        return SUCCEEDED(hresult.intValue());
    }

    public static boolean FAILED(WinNT.HRESULT hresult) {
        return FAILED(hresult.intValue());
    }

    public static void checkRC(WinNT.HRESULT hresult) {
        String str;
        if (FAILED(hresult)) {
            try {
                str = Kernel32Util.formatMessage(hresult) + "(HRESULT: " + Integer.toHexString(hresult.intValue()) + ")";
            } catch (LastErrorException unused) {
                str = "(HRESULT: " + Integer.toHexString(hresult.intValue()) + ")";
            }
            throw new COMException(str, hresult);
        }
    }

    public static void checkRC(WinNT.HRESULT hresult, OaIdl.EXCEPINFO excepinfo, IntByReference intByReference) {
        String value;
        Integer num;
        String value2;
        Integer num2;
        String str;
        Integer num3;
        String value3;
        if (!FAILED(hresult)) {
            if (excepinfo != null) {
                if (excepinfo.bstrSource != null) {
                    OleAuto.INSTANCE.SysFreeString(excepinfo.bstrSource);
                }
                if (excepinfo.bstrDescription != null) {
                    OleAuto.INSTANCE.SysFreeString(excepinfo.bstrDescription);
                }
                if (excepinfo.bstrHelpFile != null) {
                    OleAuto.INSTANCE.SysFreeString(excepinfo.bstrHelpFile);
                    return;
                }
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        Integer numValueOf = intByReference != null ? Integer.valueOf(intByReference.getValue()) : null;
        try {
            sb.append(Kernel32Util.formatMessage(hresult));
        } catch (LastErrorException unused) {
        }
        sb.append("(HRESULT: ");
        sb.append(Integer.toHexString(hresult.intValue()));
        sb.append(")");
        if (excepinfo != null) {
            Integer numValueOf2 = Integer.valueOf(excepinfo.wCode.intValue());
            Integer numValueOf3 = Integer.valueOf(excepinfo.scode.intValue());
            Integer numValueOf4 = Integer.valueOf(excepinfo.dwHelpContext.intValue());
            if (excepinfo.bstrSource != null) {
                value3 = excepinfo.bstrSource.getValue();
                sb.append("\nSource:      ");
                sb.append(value3);
            } else {
                value3 = null;
            }
            if (excepinfo.bstrDescription != null) {
                value = excepinfo.bstrDescription.getValue();
                sb.append("\nDescription: ");
                sb.append(value);
            } else {
                value = null;
            }
            num3 = numValueOf2;
            value2 = excepinfo.bstrHelpFile != null ? excepinfo.bstrHelpFile.getValue() : null;
            num2 = numValueOf3;
            num = numValueOf4;
            str = value3;
        } else {
            value = null;
            num = null;
            value2 = null;
            num2 = null;
            str = null;
            num3 = null;
        }
        throw new COMInvokeException(sb.toString(), hresult, numValueOf, value, num, value2, num2, str, num3);
    }

    public static ArrayList<COMInfo> getAllCOMInfoOnSystem() {
        WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
        WinReg.HKEYByReference hKEYByReference2 = new WinReg.HKEYByReference();
        ArrayList<COMInfo> arrayList = new ArrayList<>();
        try {
            hKEYByReference = Advapi32Util.registryGetKey(WinReg.HKEY_CLASSES_ROOT, "CLSID", 131097);
            Advapi32Util.InfoKey infoKeyRegistryQueryInfoKey = Advapi32Util.registryQueryInfoKey(hKEYByReference.getValue(), 131097);
            for (int i = 0; i < infoKeyRegistryQueryInfoKey.lpcSubKeys.getValue(); i++) {
                String string = Native.toString(Advapi32Util.registryRegEnumKey(hKEYByReference.getValue(), i).lpName);
                COMInfo cOMInfo = new COMInfo(string);
                hKEYByReference2 = Advapi32Util.registryGetKey(hKEYByReference.getValue(), string, 131097);
                Advapi32Util.InfoKey infoKeyRegistryQueryInfoKey2 = Advapi32Util.registryQueryInfoKey(hKEYByReference2.getValue(), 131097);
                for (int i2 = 0; i2 < infoKeyRegistryQueryInfoKey2.lpcSubKeys.getValue(); i2++) {
                    String string2 = Native.toString(Advapi32Util.registryRegEnumKey(hKEYByReference2.getValue(), i2).lpName);
                    if (string2.equals("InprocHandler32")) {
                        cOMInfo.inprocHandler32 = (String) Advapi32Util.registryGetValue(hKEYByReference2.getValue(), string2, null);
                    } else if (string2.equals("InprocServer32")) {
                        cOMInfo.inprocServer32 = (String) Advapi32Util.registryGetValue(hKEYByReference2.getValue(), string2, null);
                    } else if (string2.equals("LocalServer32")) {
                        cOMInfo.localServer32 = (String) Advapi32Util.registryGetValue(hKEYByReference2.getValue(), string2, null);
                    } else if (string2.equals("ProgID")) {
                        cOMInfo.progID = (String) Advapi32Util.registryGetValue(hKEYByReference2.getValue(), string2, null);
                    } else if (string2.equals("TypeLib")) {
                        cOMInfo.typeLib = (String) Advapi32Util.registryGetValue(hKEYByReference2.getValue(), string2, null);
                    }
                }
                Advapi32.INSTANCE.RegCloseKey(hKEYByReference2.getValue());
                arrayList.add(cOMInfo);
            }
            return arrayList;
        } finally {
            Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
            Advapi32.INSTANCE.RegCloseKey(hKEYByReference2.getValue());
        }
    }

    public static boolean comIsInitialized() {
        WinNT.HRESULT hresultCoInitializeEx = Ole32.INSTANCE.CoInitializeEx(Pointer.NULL, 0);
        if (hresultCoInitializeEx.equals(W32Errors.S_OK)) {
            Ole32.INSTANCE.CoUninitialize();
            return false;
        }
        if (hresultCoInitializeEx.equals(W32Errors.S_FALSE)) {
            Ole32.INSTANCE.CoUninitialize();
            return true;
        }
        if (hresultCoInitializeEx.intValue() == -2147417850) {
            return true;
        }
        checkRC(hresultCoInitializeEx);
        return false;
    }

    public static class COMInfo {
        public String clsid;
        public String inprocHandler32;
        public String inprocServer32;
        public String localServer32;
        public String progID;
        public String typeLib;

        public COMInfo() {
        }

        public COMInfo(String str) {
            this.clsid = str;
        }
    }
}
