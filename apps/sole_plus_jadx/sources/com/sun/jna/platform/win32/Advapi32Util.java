package com.sun.jna.platform.win32;

import android.support.v4.media.session.PlaybackStateCompat;
import com.android.SdkConstants;
import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinBase;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.platform.win32.WinReg;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.LongByReference;
import com.sun.jna.ptr.PointerByReference;
import com.sun.jna.win32.W32APITypeMapper;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes4.dex */
public abstract class Advapi32Util {

    public static class Account {
        public int accountType;
        public String domain;
        public String fqn;
        public String name;
        public byte[] sid;
        public String sidString;
    }

    public enum EventLogType {
        Error,
        Warning,
        Informational,
        AuditSuccess,
        AuditFailure
    }

    public static int alignOnDWORD(int i) {
        return (i + 3) & (-4);
    }

    public static String getUserName() {
        char[] cArr = new char[128];
        IntByReference intByReference = new IntByReference(128);
        boolean zGetUserNameW = Advapi32.INSTANCE.GetUserNameW(cArr, intByReference);
        if (!zGetUserNameW) {
            if (Kernel32.INSTANCE.GetLastError() == 122) {
                cArr = new char[intByReference.getValue()];
                zGetUserNameW = Advapi32.INSTANCE.GetUserNameW(cArr, intByReference);
            } else {
                throw new Win32Exception(Native.getLastError());
            }
        }
        if (!zGetUserNameW) {
            throw new Win32Exception(Native.getLastError());
        }
        return Native.toString(cArr);
    }

    public static Account getAccountByName(String str) {
        return getAccountByName(null, str);
    }

    public static Account getAccountByName(String str, String str2) {
        IntByReference intByReference = new IntByReference(0);
        IntByReference intByReference2 = new IntByReference(0);
        PointerByReference pointerByReference = new PointerByReference();
        if (Advapi32.INSTANCE.LookupAccountName(str, str2, null, intByReference, null, intByReference2, pointerByReference)) {
            throw new RuntimeException("LookupAccountNameW was expected to fail with ERROR_INSUFFICIENT_BUFFER");
        }
        int iGetLastError = Kernel32.INSTANCE.GetLastError();
        if (intByReference.getValue() == 0 || iGetLastError != 122) {
            throw new Win32Exception(iGetLastError);
        }
        WinNT.PSID psid = new WinNT.PSID(new Memory(intByReference.getValue()));
        char[] cArr = new char[intByReference2.getValue() + 1];
        if (!Advapi32.INSTANCE.LookupAccountName(str, str2, psid, intByReference, cArr, intByReference2, pointerByReference)) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        Account account = new Account();
        account.accountType = pointerByReference.getPointer().getInt(0L);
        String[] strArrSplit = str2.split("\\\\", 2);
        String[] strArrSplit2 = str2.split(SdkConstants.PREFIX_RESOURCE_REF, 2);
        if (strArrSplit.length == 2) {
            account.name = strArrSplit[1];
        } else if (strArrSplit2.length == 2) {
            account.name = strArrSplit2[0];
        } else {
            account.name = str2;
        }
        if (intByReference2.getValue() > 0) {
            account.domain = Native.toString(cArr);
            account.fqn = account.domain + "\\" + account.name;
        } else {
            account.fqn = account.name;
        }
        account.sid = psid.getBytes();
        account.sidString = convertSidToStringSid(new WinNT.PSID(account.sid));
        return account;
    }

    public static Account getAccountBySid(WinNT.PSID psid) {
        return getAccountBySid((String) null, psid);
    }

    public static Account getAccountBySid(String str, WinNT.PSID psid) {
        IntByReference intByReference = new IntByReference();
        IntByReference intByReference2 = new IntByReference();
        PointerByReference pointerByReference = new PointerByReference();
        if (Advapi32.INSTANCE.LookupAccountSid(str, psid, null, intByReference, null, intByReference2, pointerByReference)) {
            throw new RuntimeException("LookupAccountSidW was expected to fail with ERROR_INSUFFICIENT_BUFFER");
        }
        int iGetLastError = Kernel32.INSTANCE.GetLastError();
        if (intByReference.getValue() == 0 || iGetLastError != 122) {
            throw new Win32Exception(iGetLastError);
        }
        char[] cArr = new char[intByReference2.getValue()];
        char[] cArr2 = new char[intByReference.getValue()];
        if (!Advapi32.INSTANCE.LookupAccountSid(str, psid, cArr2, intByReference, cArr, intByReference2, pointerByReference)) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        Account account = new Account();
        account.accountType = pointerByReference.getPointer().getInt(0L);
        account.name = Native.toString(cArr2);
        if (intByReference2.getValue() > 0) {
            account.domain = Native.toString(cArr);
            account.fqn = account.domain + "\\" + account.name;
        } else {
            account.fqn = account.name;
        }
        account.sid = psid.getBytes();
        account.sidString = convertSidToStringSid(psid);
        return account;
    }

    public static String convertSidToStringSid(WinNT.PSID psid) {
        PointerByReference pointerByReference = new PointerByReference();
        if (!Advapi32.INSTANCE.ConvertSidToStringSid(psid, pointerByReference)) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        Pointer value = pointerByReference.getValue();
        try {
            return value.getWideString(0L);
        } finally {
            Kernel32Util.freeLocalMemory(value);
        }
    }

    public static byte[] convertStringSidToSid(String str) {
        WinNT.PSIDByReference pSIDByReference = new WinNT.PSIDByReference();
        if (!Advapi32.INSTANCE.ConvertStringSidToSid(str, pSIDByReference)) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        WinNT.PSID value = pSIDByReference.getValue();
        try {
            return value.getBytes();
        } finally {
            Kernel32Util.freeLocalMemory(value.getPointer());
        }
    }

    public static boolean isWellKnownSid(String str, int i) {
        WinNT.PSIDByReference pSIDByReference = new WinNT.PSIDByReference();
        if (!Advapi32.INSTANCE.ConvertStringSidToSid(str, pSIDByReference)) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        WinNT.PSID value = pSIDByReference.getValue();
        try {
            return Advapi32.INSTANCE.IsWellKnownSid(value, i);
        } finally {
            Kernel32Util.freeLocalMemory(value.getPointer());
        }
    }

    public static boolean isWellKnownSid(byte[] bArr, int i) {
        return Advapi32.INSTANCE.IsWellKnownSid(new WinNT.PSID(bArr), i);
    }

    public static int getAceSize(int i) {
        return (Native.getNativeSize(WinNT.ACCESS_ALLOWED_ACE.class, null) + i) - 4;
    }

    public static Account getAccountBySid(String str) {
        return getAccountBySid((String) null, str);
    }

    public static Account getAccountBySid(String str, String str2) {
        return getAccountBySid(str, new WinNT.PSID(convertStringSidToSid(str2)));
    }

    public static Account[] getTokenGroups(WinNT.HANDLE handle) {
        Account accountBySid;
        IntByReference intByReference = new IntByReference();
        if (Advapi32.INSTANCE.GetTokenInformation(handle, 2, null, 0, intByReference)) {
            throw new RuntimeException("Expected GetTokenInformation to fail with ERROR_INSUFFICIENT_BUFFER");
        }
        int iGetLastError = Kernel32.INSTANCE.GetLastError();
        if (iGetLastError != 122) {
            throw new Win32Exception(iGetLastError);
        }
        WinNT.TOKEN_GROUPS token_groups = new WinNT.TOKEN_GROUPS(intByReference.getValue());
        if (!Advapi32.INSTANCE.GetTokenInformation(handle, 2, token_groups, intByReference.getValue(), intByReference)) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        ArrayList arrayList = new ArrayList();
        for (WinNT.SID_AND_ATTRIBUTES sid_and_attributes : token_groups.getGroups()) {
            try {
                accountBySid = getAccountBySid(sid_and_attributes.Sid);
            } catch (Exception unused) {
                Account account = new Account();
                account.sid = sid_and_attributes.Sid.getBytes();
                account.sidString = convertSidToStringSid(sid_and_attributes.Sid);
                account.name = account.sidString;
                account.fqn = account.sidString;
                account.accountType = 2;
                accountBySid = account;
            }
            arrayList.add(accountBySid);
        }
        return (Account[]) arrayList.toArray(new Account[0]);
    }

    public static Account getTokenPrimaryGroup(WinNT.HANDLE handle) {
        IntByReference intByReference = new IntByReference();
        if (Advapi32.INSTANCE.GetTokenInformation(handle, 5, null, 0, intByReference)) {
            throw new RuntimeException("Expected GetTokenInformation to fail with ERROR_INSUFFICIENT_BUFFER");
        }
        int iGetLastError = Kernel32.INSTANCE.GetLastError();
        if (iGetLastError != 122) {
            throw new Win32Exception(iGetLastError);
        }
        WinNT.TOKEN_PRIMARY_GROUP token_primary_group = new WinNT.TOKEN_PRIMARY_GROUP(intByReference.getValue());
        if (!Advapi32.INSTANCE.GetTokenInformation(handle, 5, token_primary_group, intByReference.getValue(), intByReference)) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        try {
            return getAccountBySid(token_primary_group.PrimaryGroup);
        } catch (Exception unused) {
            Account account = new Account();
            account.sid = token_primary_group.PrimaryGroup.getBytes();
            account.sidString = convertSidToStringSid(token_primary_group.PrimaryGroup);
            account.name = account.sidString;
            account.fqn = account.sidString;
            account.accountType = 2;
            return account;
        }
    }

    public static Account getTokenAccount(WinNT.HANDLE handle) {
        IntByReference intByReference = new IntByReference();
        if (Advapi32.INSTANCE.GetTokenInformation(handle, 1, null, 0, intByReference)) {
            throw new RuntimeException("Expected GetTokenInformation to fail with ERROR_INSUFFICIENT_BUFFER");
        }
        int iGetLastError = Kernel32.INSTANCE.GetLastError();
        if (iGetLastError != 122) {
            throw new Win32Exception(iGetLastError);
        }
        WinNT.TOKEN_USER token_user = new WinNT.TOKEN_USER(intByReference.getValue());
        if (!Advapi32.INSTANCE.GetTokenInformation(handle, 1, token_user, intByReference.getValue(), intByReference)) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        return getAccountBySid(token_user.User.Sid);
    }

    public static Account[] getCurrentUserGroups() {
        WinNT.HANDLEByReference hANDLEByReference = new WinNT.HANDLEByReference();
        Win32Exception e = null;
        try {
            try {
                if (!Advapi32.INSTANCE.OpenThreadToken(Kernel32.INSTANCE.GetCurrentThread(), 10, true, hANDLEByReference)) {
                    int iGetLastError = Kernel32.INSTANCE.GetLastError();
                    if (iGetLastError != 1008) {
                        throw new Win32Exception(iGetLastError);
                    }
                    if (!Advapi32.INSTANCE.OpenProcessToken(Kernel32.INSTANCE.GetCurrentProcess(), 10, hANDLEByReference)) {
                        throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                    }
                }
                Account[] tokenGroups = getTokenGroups(hANDLEByReference.getValue());
                WinNT.HANDLE value = hANDLEByReference.getValue();
                if (!WinBase.INVALID_HANDLE_VALUE.equals(value)) {
                    try {
                        Kernel32Util.closeHandle(value);
                    } catch (Win32Exception e2) {
                        e = e2;
                    }
                }
                if (e == null) {
                    return tokenGroups;
                }
                throw e;
            } catch (Win32Exception e3) {
                throw e3;
            }
        } catch (Throwable th) {
            WinNT.HANDLE value2 = hANDLEByReference.getValue();
            if (!WinBase.INVALID_HANDLE_VALUE.equals(value2)) {
                try {
                    Kernel32Util.closeHandle(value2);
                } catch (Win32Exception e4) {
                    if (0 == 0) {
                        e = e4;
                    } else {
                        e.addSuppressedReflected(e4);
                    }
                }
            }
            if (e != null) {
                throw e;
            }
            throw th;
        }
    }

    public static boolean registryKeyExists(WinReg.HKEY hkey, String str) {
        return registryKeyExists(hkey, str, 0);
    }

    public static boolean registryKeyExists(WinReg.HKEY hkey, String str, int i) {
        WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
        int iRegOpenKeyEx = Advapi32.INSTANCE.RegOpenKeyEx(hkey, str, 0, i | 131097, hKEYByReference);
        if (iRegOpenKeyEx == 0) {
            Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
            return true;
        }
        if (iRegOpenKeyEx == 2) {
            return false;
        }
        throw new Win32Exception(iRegOpenKeyEx);
    }

    public static boolean registryValueExists(WinReg.HKEY hkey, String str, String str2) {
        return registryValueExists(hkey, str, str2, 0);
    }

    public static boolean registryValueExists(WinReg.HKEY hkey, String str, String str2, int i) {
        int iRegCloseKey;
        int iRegCloseKey2;
        int iRegCloseKey3;
        WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
        int iRegOpenKeyEx = Advapi32.INSTANCE.RegOpenKeyEx(hkey, str, 0, i | 131097, hKEYByReference);
        if (iRegOpenKeyEx != 0) {
            if (iRegOpenKeyEx == 2) {
                return false;
            }
            throw new Win32Exception(iRegOpenKeyEx);
        }
        try {
            int iRegQueryValueEx = Advapi32.INSTANCE.RegQueryValueEx(hKEYByReference.getValue(), str2, 0, new IntByReference(), (Pointer) null, new IntByReference());
            if (iRegQueryValueEx != 0) {
                if (iRegQueryValueEx == 2) {
                    if (hKEYByReference.getValue() == WinBase.INVALID_HANDLE_VALUE || (iRegCloseKey3 = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue())) == 0) {
                        return false;
                    }
                    throw new Win32Exception(iRegCloseKey3);
                }
                if (iRegQueryValueEx != 122 && iRegQueryValueEx != 234) {
                    throw new Win32Exception(iRegQueryValueEx);
                }
            }
            if (hKEYByReference.getValue() == WinBase.INVALID_HANDLE_VALUE || (iRegCloseKey2 = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue())) == 0) {
                return true;
            }
            throw new Win32Exception(iRegCloseKey2);
        } catch (Throwable th) {
            if (hKEYByReference.getValue() != WinBase.INVALID_HANDLE_VALUE && (iRegCloseKey = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue())) != 0) {
                throw new Win32Exception(iRegCloseKey);
            }
            throw th;
        }
    }

    public static String registryGetStringValue(WinReg.HKEY hkey, String str, String str2) {
        return registryGetStringValue(hkey, str, str2, 0);
    }

    public static String registryGetStringValue(WinReg.HKEY hkey, String str, String str2, int i) {
        WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
        int iRegOpenKeyEx = Advapi32.INSTANCE.RegOpenKeyEx(hkey, str, 0, i | 131097, hKEYByReference);
        if (iRegOpenKeyEx != 0) {
            throw new Win32Exception(iRegOpenKeyEx);
        }
        try {
            String strRegistryGetStringValue = registryGetStringValue(hKEYByReference.getValue(), str2);
            int iRegCloseKey = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
            if (iRegCloseKey == 0) {
                return strRegistryGetStringValue;
            }
            throw new Win32Exception(iRegCloseKey);
        } catch (Throwable th) {
            int iRegCloseKey2 = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
            if (iRegCloseKey2 != 0) {
                throw new Win32Exception(iRegCloseKey2);
            }
            throw th;
        }
    }

    public static String registryGetStringValue(WinReg.HKEY hkey, String str) {
        IntByReference intByReference = new IntByReference();
        IntByReference intByReference2 = new IntByReference();
        int iRegQueryValueEx = Advapi32.INSTANCE.RegQueryValueEx(hkey, str, 0, intByReference2, (Pointer) null, intByReference);
        if (iRegQueryValueEx != 0 && iRegQueryValueEx != 122) {
            throw new Win32Exception(iRegQueryValueEx);
        }
        if (intByReference2.getValue() != 1 && intByReference2.getValue() != 2) {
            throw new RuntimeException("Unexpected registry type " + intByReference2.getValue() + ", expected REG_SZ or REG_EXPAND_SZ");
        }
        if (intByReference.getValue() == 0) {
            return "";
        }
        Memory memory = new Memory(intByReference.getValue() + Native.WCHAR_SIZE);
        memory.clear();
        int iRegQueryValueEx2 = Advapi32.INSTANCE.RegQueryValueEx(hkey, str, 0, intByReference2, memory, intByReference);
        if (iRegQueryValueEx2 != 0 && iRegQueryValueEx2 != 122) {
            throw new Win32Exception(iRegQueryValueEx2);
        }
        if (W32APITypeMapper.DEFAULT == W32APITypeMapper.UNICODE) {
            return memory.getWideString(0L);
        }
        return memory.getString(0L);
    }

    public static String registryGetExpandableStringValue(WinReg.HKEY hkey, String str, String str2) {
        return registryGetExpandableStringValue(hkey, str, str2, 0);
    }

    public static String registryGetExpandableStringValue(WinReg.HKEY hkey, String str, String str2, int i) {
        WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
        int iRegOpenKeyEx = Advapi32.INSTANCE.RegOpenKeyEx(hkey, str, 0, i | 131097, hKEYByReference);
        if (iRegOpenKeyEx != 0) {
            throw new Win32Exception(iRegOpenKeyEx);
        }
        try {
            String strRegistryGetExpandableStringValue = registryGetExpandableStringValue(hKEYByReference.getValue(), str2);
            int iRegCloseKey = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
            if (iRegCloseKey == 0) {
                return strRegistryGetExpandableStringValue;
            }
            throw new Win32Exception(iRegCloseKey);
        } catch (Throwable th) {
            int iRegCloseKey2 = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
            if (iRegCloseKey2 != 0) {
                throw new Win32Exception(iRegCloseKey2);
            }
            throw th;
        }
    }

    public static String registryGetExpandableStringValue(WinReg.HKEY hkey, String str) {
        IntByReference intByReference = new IntByReference();
        IntByReference intByReference2 = new IntByReference();
        int iRegQueryValueEx = Advapi32.INSTANCE.RegQueryValueEx(hkey, str, 0, intByReference2, (char[]) null, intByReference);
        if (iRegQueryValueEx != 0 && iRegQueryValueEx != 122) {
            throw new Win32Exception(iRegQueryValueEx);
        }
        if (intByReference2.getValue() != 2) {
            throw new RuntimeException("Unexpected registry type " + intByReference2.getValue() + ", expected REG_SZ");
        }
        if (intByReference.getValue() == 0) {
            return "";
        }
        Memory memory = new Memory(intByReference.getValue() + Native.WCHAR_SIZE);
        memory.clear();
        int iRegQueryValueEx2 = Advapi32.INSTANCE.RegQueryValueEx(hkey, str, 0, intByReference2, memory, intByReference);
        if (iRegQueryValueEx2 != 0 && iRegQueryValueEx2 != 122) {
            throw new Win32Exception(iRegQueryValueEx2);
        }
        if (W32APITypeMapper.DEFAULT == W32APITypeMapper.UNICODE) {
            return memory.getWideString(0L);
        }
        return memory.getString(0L);
    }

    public static String[] registryGetStringArray(WinReg.HKEY hkey, String str, String str2) {
        return registryGetStringArray(hkey, str, str2, 0);
    }

    public static String[] registryGetStringArray(WinReg.HKEY hkey, String str, String str2, int i) {
        WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
        int iRegOpenKeyEx = Advapi32.INSTANCE.RegOpenKeyEx(hkey, str, 0, i | 131097, hKEYByReference);
        if (iRegOpenKeyEx != 0) {
            throw new Win32Exception(iRegOpenKeyEx);
        }
        try {
            String[] strArrRegistryGetStringArray = registryGetStringArray(hKEYByReference.getValue(), str2);
            int iRegCloseKey = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
            if (iRegCloseKey == 0) {
                return strArrRegistryGetStringArray;
            }
            throw new Win32Exception(iRegCloseKey);
        } catch (Throwable th) {
            int iRegCloseKey2 = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
            if (iRegCloseKey2 != 0) {
                throw new Win32Exception(iRegCloseKey2);
            }
            throw th;
        }
    }

    public static String[] registryGetStringArray(WinReg.HKEY hkey, String str) {
        String string;
        IntByReference intByReference = new IntByReference();
        IntByReference intByReference2 = new IntByReference();
        int iRegQueryValueEx = Advapi32.INSTANCE.RegQueryValueEx(hkey, str, 0, intByReference2, (char[]) null, intByReference);
        if (iRegQueryValueEx != 0 && iRegQueryValueEx != 122) {
            throw new Win32Exception(iRegQueryValueEx);
        }
        if (intByReference2.getValue() != 7) {
            throw new RuntimeException("Unexpected registry type " + intByReference2.getValue() + ", expected REG_SZ");
        }
        Memory memory = new Memory(intByReference.getValue() + (Native.WCHAR_SIZE * 2));
        memory.clear();
        int iRegQueryValueEx2 = Advapi32.INSTANCE.RegQueryValueEx(hkey, str, 0, intByReference2, memory, intByReference);
        if (iRegQueryValueEx2 != 0 && iRegQueryValueEx2 != 122) {
            throw new Win32Exception(iRegQueryValueEx2);
        }
        ArrayList arrayList = new ArrayList();
        int length = 0;
        while (true) {
            long j = length;
            if (j >= memory.size()) {
                break;
            }
            if (W32APITypeMapper.DEFAULT == W32APITypeMapper.UNICODE) {
                string = memory.getWideString(j);
                length = length + (string.length() * Native.WCHAR_SIZE) + Native.WCHAR_SIZE;
            } else {
                string = memory.getString(j);
                length = length + string.length() + 1;
            }
            if (string.length() == 0) {
                break;
            }
            arrayList.add(string);
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static byte[] registryGetBinaryValue(WinReg.HKEY hkey, String str, String str2) {
        return registryGetBinaryValue(hkey, str, str2, 0);
    }

    public static byte[] registryGetBinaryValue(WinReg.HKEY hkey, String str, String str2, int i) {
        WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
        int iRegOpenKeyEx = Advapi32.INSTANCE.RegOpenKeyEx(hkey, str, 0, i | 131097, hKEYByReference);
        if (iRegOpenKeyEx != 0) {
            throw new Win32Exception(iRegOpenKeyEx);
        }
        try {
            byte[] bArrRegistryGetBinaryValue = registryGetBinaryValue(hKEYByReference.getValue(), str2);
            int iRegCloseKey = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
            if (iRegCloseKey == 0) {
                return bArrRegistryGetBinaryValue;
            }
            throw new Win32Exception(iRegCloseKey);
        } catch (Throwable th) {
            int iRegCloseKey2 = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
            if (iRegCloseKey2 != 0) {
                throw new Win32Exception(iRegCloseKey2);
            }
            throw th;
        }
    }

    public static byte[] registryGetBinaryValue(WinReg.HKEY hkey, String str) {
        IntByReference intByReference = new IntByReference();
        IntByReference intByReference2 = new IntByReference();
        int iRegQueryValueEx = Advapi32.INSTANCE.RegQueryValueEx(hkey, str, 0, intByReference2, (Pointer) null, intByReference);
        if (iRegQueryValueEx != 0 && iRegQueryValueEx != 122) {
            throw new Win32Exception(iRegQueryValueEx);
        }
        if (intByReference2.getValue() != 3) {
            throw new RuntimeException("Unexpected registry type " + intByReference2.getValue() + ", expected REG_BINARY");
        }
        byte[] bArr = new byte[intByReference.getValue()];
        int iRegQueryValueEx2 = Advapi32.INSTANCE.RegQueryValueEx(hkey, str, 0, intByReference2, bArr, intByReference);
        if (iRegQueryValueEx2 == 0 || iRegQueryValueEx2 == 122) {
            return bArr;
        }
        throw new Win32Exception(iRegQueryValueEx2);
    }

    public static int registryGetIntValue(WinReg.HKEY hkey, String str, String str2) {
        return registryGetIntValue(hkey, str, str2, 0);
    }

    public static int registryGetIntValue(WinReg.HKEY hkey, String str, String str2, int i) {
        WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
        int iRegOpenKeyEx = Advapi32.INSTANCE.RegOpenKeyEx(hkey, str, 0, i | 131097, hKEYByReference);
        if (iRegOpenKeyEx != 0) {
            throw new Win32Exception(iRegOpenKeyEx);
        }
        try {
            int iRegistryGetIntValue = registryGetIntValue(hKEYByReference.getValue(), str2);
            int iRegCloseKey = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
            if (iRegCloseKey == 0) {
                return iRegistryGetIntValue;
            }
            throw new Win32Exception(iRegCloseKey);
        } catch (Throwable th) {
            int iRegCloseKey2 = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
            if (iRegCloseKey2 != 0) {
                throw new Win32Exception(iRegCloseKey2);
            }
            throw th;
        }
    }

    public static int registryGetIntValue(WinReg.HKEY hkey, String str) {
        IntByReference intByReference = new IntByReference();
        IntByReference intByReference2 = new IntByReference();
        int iRegQueryValueEx = Advapi32.INSTANCE.RegQueryValueEx(hkey, str, 0, intByReference2, (char[]) null, intByReference);
        if (iRegQueryValueEx != 0 && iRegQueryValueEx != 122) {
            throw new Win32Exception(iRegQueryValueEx);
        }
        if (intByReference2.getValue() != 4) {
            throw new RuntimeException("Unexpected registry type " + intByReference2.getValue() + ", expected REG_DWORD");
        }
        IntByReference intByReference3 = new IntByReference();
        int iRegQueryValueEx2 = Advapi32.INSTANCE.RegQueryValueEx(hkey, str, 0, intByReference2, intByReference3, intByReference);
        if (iRegQueryValueEx2 != 0 && iRegQueryValueEx2 != 122) {
            throw new Win32Exception(iRegQueryValueEx2);
        }
        return intByReference3.getValue();
    }

    public static long registryGetLongValue(WinReg.HKEY hkey, String str, String str2) {
        return registryGetLongValue(hkey, str, str2, 0);
    }

    public static long registryGetLongValue(WinReg.HKEY hkey, String str, String str2, int i) {
        WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
        int iRegOpenKeyEx = Advapi32.INSTANCE.RegOpenKeyEx(hkey, str, 0, i | 131097, hKEYByReference);
        if (iRegOpenKeyEx != 0) {
            throw new Win32Exception(iRegOpenKeyEx);
        }
        try {
            long jRegistryGetLongValue = registryGetLongValue(hKEYByReference.getValue(), str2);
            int iRegCloseKey = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
            if (iRegCloseKey == 0) {
                return jRegistryGetLongValue;
            }
            throw new Win32Exception(iRegCloseKey);
        } catch (Throwable th) {
            int iRegCloseKey2 = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
            if (iRegCloseKey2 != 0) {
                throw new Win32Exception(iRegCloseKey2);
            }
            throw th;
        }
    }

    public static long registryGetLongValue(WinReg.HKEY hkey, String str) {
        IntByReference intByReference = new IntByReference();
        IntByReference intByReference2 = new IntByReference();
        int iRegQueryValueEx = Advapi32.INSTANCE.RegQueryValueEx(hkey, str, 0, intByReference2, (char[]) null, intByReference);
        if (iRegQueryValueEx != 0 && iRegQueryValueEx != 122) {
            throw new Win32Exception(iRegQueryValueEx);
        }
        if (intByReference2.getValue() != 11) {
            throw new RuntimeException("Unexpected registry type " + intByReference2.getValue() + ", expected REG_QWORD");
        }
        LongByReference longByReference = new LongByReference();
        int iRegQueryValueEx2 = Advapi32.INSTANCE.RegQueryValueEx(hkey, str, 0, intByReference2, longByReference, intByReference);
        if (iRegQueryValueEx2 != 0 && iRegQueryValueEx2 != 122) {
            throw new Win32Exception(iRegQueryValueEx2);
        }
        return longByReference.getValue();
    }

    public static Object registryGetValue(WinReg.HKEY hkey, String str, String str2) {
        IntByReference intByReference = new IntByReference();
        IntByReference intByReference2 = new IntByReference();
        int iRegGetValue = Advapi32.INSTANCE.RegGetValue(hkey, str, str2, 65535, intByReference, (Pointer) null, intByReference2);
        if (intByReference.getValue() == 0) {
            return null;
        }
        if (iRegGetValue != 0 && iRegGetValue != 122) {
            throw new Win32Exception(iRegGetValue);
        }
        Memory memory = new Memory(intByReference2.getValue() + Native.WCHAR_SIZE);
        memory.clear();
        int iRegGetValue2 = Advapi32.INSTANCE.RegGetValue(hkey, str, str2, 65535, intByReference, memory, intByReference2);
        if (iRegGetValue2 != 0) {
            throw new Win32Exception(iRegGetValue2);
        }
        if (intByReference.getValue() == 4) {
            return Integer.valueOf(memory.getInt(0L));
        }
        if (intByReference.getValue() == 11) {
            return Long.valueOf(memory.getLong(0L));
        }
        if (intByReference.getValue() == 3) {
            return memory.getByteArray(0L, intByReference2.getValue());
        }
        if (intByReference.getValue() != 1 && intByReference.getValue() != 2) {
            return null;
        }
        if (W32APITypeMapper.DEFAULT == W32APITypeMapper.UNICODE) {
            return memory.getWideString(0L);
        }
        return memory.getString(0L);
    }

    public static boolean registryCreateKey(WinReg.HKEY hkey, String str) {
        return registryCreateKey(hkey, str, 0);
    }

    public static boolean registryCreateKey(WinReg.HKEY hkey, String str, int i) {
        WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
        IntByReference intByReference = new IntByReference();
        int iRegCreateKeyEx = Advapi32.INSTANCE.RegCreateKeyEx(hkey, str, 0, null, 0, i | 131097, null, hKEYByReference, intByReference);
        if (iRegCreateKeyEx != 0) {
            throw new Win32Exception(iRegCreateKeyEx);
        }
        int iRegCloseKey = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
        if (iRegCloseKey == 0) {
            return 1 == intByReference.getValue();
        }
        throw new Win32Exception(iRegCloseKey);
    }

    public static boolean registryCreateKey(WinReg.HKEY hkey, String str, String str2) {
        return registryCreateKey(hkey, str, str2, 0);
    }

    public static boolean registryCreateKey(WinReg.HKEY hkey, String str, String str2, int i) {
        WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
        int iRegOpenKeyEx = Advapi32.INSTANCE.RegOpenKeyEx(hkey, str, 0, i | 4, hKEYByReference);
        if (iRegOpenKeyEx != 0) {
            throw new Win32Exception(iRegOpenKeyEx);
        }
        try {
            boolean zRegistryCreateKey = registryCreateKey(hKEYByReference.getValue(), str2);
            int iRegCloseKey = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
            if (iRegCloseKey == 0) {
                return zRegistryCreateKey;
            }
            throw new Win32Exception(iRegCloseKey);
        } catch (Throwable th) {
            int iRegCloseKey2 = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
            if (iRegCloseKey2 != 0) {
                throw new Win32Exception(iRegCloseKey2);
            }
            throw th;
        }
    }

    public static void registrySetIntValue(WinReg.HKEY hkey, String str, int i) {
        int iRegSetValueEx = Advapi32.INSTANCE.RegSetValueEx(hkey, str, 0, 4, new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 24) & 255)}, 4);
        if (iRegSetValueEx != 0) {
            throw new Win32Exception(iRegSetValueEx);
        }
    }

    public static void registrySetIntValue(WinReg.HKEY hkey, String str, String str2, int i) {
        registrySetIntValue(hkey, str, str2, i, 0);
    }

    public static void registrySetIntValue(WinReg.HKEY hkey, String str, String str2, int i, int i2) {
        WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
        int iRegOpenKeyEx = Advapi32.INSTANCE.RegOpenKeyEx(hkey, str, 0, i2 | 131103, hKEYByReference);
        if (iRegOpenKeyEx != 0) {
            throw new Win32Exception(iRegOpenKeyEx);
        }
        try {
            registrySetIntValue(hKEYByReference.getValue(), str2, i);
            int iRegCloseKey = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
            if (iRegCloseKey != 0) {
                throw new Win32Exception(iRegCloseKey);
            }
        } catch (Throwable th) {
            int iRegCloseKey2 = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
            if (iRegCloseKey2 != 0) {
                throw new Win32Exception(iRegCloseKey2);
            }
            throw th;
        }
    }

    public static void registrySetLongValue(WinReg.HKEY hkey, String str, long j) {
        int iRegSetValueEx = Advapi32.INSTANCE.RegSetValueEx(hkey, str, 0, 11, new byte[]{(byte) (j & 255), (byte) ((j >> 8) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 48) & 255), (byte) (255 & (j >> 56))}, 8);
        if (iRegSetValueEx != 0) {
            throw new Win32Exception(iRegSetValueEx);
        }
    }

    public static void registrySetLongValue(WinReg.HKEY hkey, String str, String str2, long j) {
        registrySetLongValue(hkey, str, str2, j, 0);
    }

    public static void registrySetLongValue(WinReg.HKEY hkey, String str, String str2, long j, int i) {
        WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
        int iRegOpenKeyEx = Advapi32.INSTANCE.RegOpenKeyEx(hkey, str, 0, i | 131103, hKEYByReference);
        if (iRegOpenKeyEx != 0) {
            throw new Win32Exception(iRegOpenKeyEx);
        }
        try {
            registrySetLongValue(hKEYByReference.getValue(), str2, j);
            int iRegCloseKey = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
            if (iRegCloseKey != 0) {
                throw new Win32Exception(iRegCloseKey);
            }
        } catch (Throwable th) {
            int iRegCloseKey2 = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
            if (iRegCloseKey2 != 0) {
                throw new Win32Exception(iRegCloseKey2);
            }
            throw th;
        }
    }

    public static void registrySetStringValue(WinReg.HKEY hkey, String str, String str2) {
        Memory memory;
        if (str2 == null) {
            str2 = "";
        }
        if (W32APITypeMapper.DEFAULT == W32APITypeMapper.UNICODE) {
            memory = new Memory((str2.length() + 1) * Native.WCHAR_SIZE);
            memory.setWideString(0L, str2);
        } else {
            memory = new Memory(str2.length() + 1);
            memory.setString(0L, str2);
        }
        Memory memory2 = memory;
        int iRegSetValueEx = Advapi32.INSTANCE.RegSetValueEx(hkey, str, 0, 1, memory2, (int) memory2.size());
        if (iRegSetValueEx != 0) {
            throw new Win32Exception(iRegSetValueEx);
        }
    }

    public static void registrySetStringValue(WinReg.HKEY hkey, String str, String str2, String str3) {
        registrySetStringValue(hkey, str, str2, str3, 0);
    }

    public static void registrySetStringValue(WinReg.HKEY hkey, String str, String str2, String str3, int i) {
        WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
        int iRegOpenKeyEx = Advapi32.INSTANCE.RegOpenKeyEx(hkey, str, 0, i | 131103, hKEYByReference);
        if (iRegOpenKeyEx != 0) {
            throw new Win32Exception(iRegOpenKeyEx);
        }
        try {
            registrySetStringValue(hKEYByReference.getValue(), str2, str3);
            int iRegCloseKey = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
            if (iRegCloseKey != 0) {
                throw new Win32Exception(iRegCloseKey);
            }
        } catch (Throwable th) {
            int iRegCloseKey2 = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
            if (iRegCloseKey2 != 0) {
                throw new Win32Exception(iRegCloseKey2);
            }
            throw th;
        }
    }

    public static void registrySetExpandableStringValue(WinReg.HKEY hkey, String str, String str2) {
        Memory memory;
        if (W32APITypeMapper.DEFAULT == W32APITypeMapper.UNICODE) {
            memory = new Memory((str2.length() + 1) * Native.WCHAR_SIZE);
            memory.setWideString(0L, str2);
        } else {
            memory = new Memory(str2.length() + 1);
            memory.setString(0L, str2);
        }
        Memory memory2 = memory;
        int iRegSetValueEx = Advapi32.INSTANCE.RegSetValueEx(hkey, str, 0, 2, memory2, (int) memory2.size());
        if (iRegSetValueEx != 0) {
            throw new Win32Exception(iRegSetValueEx);
        }
    }

    public static void registrySetExpandableStringValue(WinReg.HKEY hkey, String str, String str2, String str3) {
        registrySetExpandableStringValue(hkey, str, str2, str3, 0);
    }

    public static void registrySetExpandableStringValue(WinReg.HKEY hkey, String str, String str2, String str3, int i) {
        WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
        int iRegOpenKeyEx = Advapi32.INSTANCE.RegOpenKeyEx(hkey, str, 0, i | 131103, hKEYByReference);
        if (iRegOpenKeyEx != 0) {
            throw new Win32Exception(iRegOpenKeyEx);
        }
        try {
            registrySetExpandableStringValue(hKEYByReference.getValue(), str2, str3);
            int iRegCloseKey = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
            if (iRegCloseKey != 0) {
                throw new Win32Exception(iRegCloseKey);
            }
        } catch (Throwable th) {
            int iRegCloseKey2 = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
            if (iRegCloseKey2 != 0) {
                throw new Win32Exception(iRegCloseKey2);
            }
            throw th;
        }
    }

    public static void registrySetStringArray(WinReg.HKEY hkey, String str, String[] strArr) {
        int i = W32APITypeMapper.DEFAULT == W32APITypeMapper.UNICODE ? Native.WCHAR_SIZE : 1;
        int length = 0;
        for (String str2 : strArr) {
            length = length + (str2.length() * i) + i;
        }
        int i2 = length + i;
        Memory memory = new Memory(i2);
        memory.clear();
        int length2 = 0;
        for (String str3 : strArr) {
            if (W32APITypeMapper.DEFAULT == W32APITypeMapper.UNICODE) {
                memory.setWideString(length2, str3);
            } else {
                memory.setString(length2, str3);
            }
            length2 = length2 + (str3.length() * i) + i;
        }
        int iRegSetValueEx = Advapi32.INSTANCE.RegSetValueEx(hkey, str, 0, 7, memory, i2);
        if (iRegSetValueEx != 0) {
            throw new Win32Exception(iRegSetValueEx);
        }
    }

    public static void registrySetStringArray(WinReg.HKEY hkey, String str, String str2, String[] strArr) {
        registrySetStringArray(hkey, str, str2, strArr, 0);
    }

    public static void registrySetStringArray(WinReg.HKEY hkey, String str, String str2, String[] strArr, int i) {
        WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
        int iRegOpenKeyEx = Advapi32.INSTANCE.RegOpenKeyEx(hkey, str, 0, i | 131103, hKEYByReference);
        if (iRegOpenKeyEx != 0) {
            throw new Win32Exception(iRegOpenKeyEx);
        }
        try {
            registrySetStringArray(hKEYByReference.getValue(), str2, strArr);
            int iRegCloseKey = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
            if (iRegCloseKey != 0) {
                throw new Win32Exception(iRegCloseKey);
            }
        } catch (Throwable th) {
            int iRegCloseKey2 = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
            if (iRegCloseKey2 != 0) {
                throw new Win32Exception(iRegCloseKey2);
            }
            throw th;
        }
    }

    public static void registrySetBinaryValue(WinReg.HKEY hkey, String str, byte[] bArr) {
        int iRegSetValueEx = Advapi32.INSTANCE.RegSetValueEx(hkey, str, 0, 3, bArr, bArr.length);
        if (iRegSetValueEx != 0) {
            throw new Win32Exception(iRegSetValueEx);
        }
    }

    public static void registrySetBinaryValue(WinReg.HKEY hkey, String str, String str2, byte[] bArr) {
        registrySetBinaryValue(hkey, str, str2, bArr, 0);
    }

    public static void registrySetBinaryValue(WinReg.HKEY hkey, String str, String str2, byte[] bArr, int i) {
        WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
        int iRegOpenKeyEx = Advapi32.INSTANCE.RegOpenKeyEx(hkey, str, 0, i | 131103, hKEYByReference);
        if (iRegOpenKeyEx != 0) {
            throw new Win32Exception(iRegOpenKeyEx);
        }
        try {
            registrySetBinaryValue(hKEYByReference.getValue(), str2, bArr);
            int iRegCloseKey = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
            if (iRegCloseKey != 0) {
                throw new Win32Exception(iRegCloseKey);
            }
        } catch (Throwable th) {
            int iRegCloseKey2 = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
            if (iRegCloseKey2 != 0) {
                throw new Win32Exception(iRegCloseKey2);
            }
            throw th;
        }
    }

    public static void registryDeleteKey(WinReg.HKEY hkey, String str) {
        int iRegDeleteKey = Advapi32.INSTANCE.RegDeleteKey(hkey, str);
        if (iRegDeleteKey != 0) {
            throw new Win32Exception(iRegDeleteKey);
        }
    }

    public static void registryDeleteKey(WinReg.HKEY hkey, String str, String str2) {
        registryDeleteKey(hkey, str, str2, 0);
    }

    public static void registryDeleteKey(WinReg.HKEY hkey, String str, String str2, int i) {
        WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
        int iRegOpenKeyEx = Advapi32.INSTANCE.RegOpenKeyEx(hkey, str, 0, i | 131103, hKEYByReference);
        if (iRegOpenKeyEx != 0) {
            throw new Win32Exception(iRegOpenKeyEx);
        }
        try {
            registryDeleteKey(hKEYByReference.getValue(), str2);
            int iRegCloseKey = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
            if (iRegCloseKey != 0) {
                throw new Win32Exception(iRegCloseKey);
            }
        } catch (Throwable th) {
            int iRegCloseKey2 = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
            if (iRegCloseKey2 != 0) {
                throw new Win32Exception(iRegCloseKey2);
            }
            throw th;
        }
    }

    public static void registryDeleteValue(WinReg.HKEY hkey, String str) {
        int iRegDeleteValue = Advapi32.INSTANCE.RegDeleteValue(hkey, str);
        if (iRegDeleteValue != 0) {
            throw new Win32Exception(iRegDeleteValue);
        }
    }

    public static void registryDeleteValue(WinReg.HKEY hkey, String str, String str2) {
        registryDeleteValue(hkey, str, str2, 0);
    }

    public static void registryDeleteValue(WinReg.HKEY hkey, String str, String str2, int i) {
        WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
        int iRegOpenKeyEx = Advapi32.INSTANCE.RegOpenKeyEx(hkey, str, 0, i | 131103, hKEYByReference);
        if (iRegOpenKeyEx != 0) {
            throw new Win32Exception(iRegOpenKeyEx);
        }
        try {
            registryDeleteValue(hKEYByReference.getValue(), str2);
            int iRegCloseKey = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
            if (iRegCloseKey != 0) {
                throw new Win32Exception(iRegCloseKey);
            }
        } catch (Throwable th) {
            int iRegCloseKey2 = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
            if (iRegCloseKey2 != 0) {
                throw new Win32Exception(iRegCloseKey2);
            }
            throw th;
        }
    }

    public static String[] registryGetKeys(WinReg.HKEY hkey) {
        IntByReference intByReference = new IntByReference();
        IntByReference intByReference2 = new IntByReference();
        int iRegQueryInfoKey = Advapi32.INSTANCE.RegQueryInfoKey(hkey, null, null, null, intByReference, intByReference2, null, null, null, null, null, null);
        if (iRegQueryInfoKey != 0) {
            throw new Win32Exception(iRegQueryInfoKey);
        }
        ArrayList arrayList = new ArrayList(intByReference.getValue());
        char[] cArr = new char[intByReference2.getValue() + 1];
        for (int i = 0; i < intByReference.getValue(); i++) {
            int iRegEnumKeyEx = Advapi32.INSTANCE.RegEnumKeyEx(hkey, i, cArr, new IntByReference(intByReference2.getValue() + 1), null, null, null, null);
            if (iRegEnumKeyEx != 0) {
                throw new Win32Exception(iRegEnumKeyEx);
            }
            arrayList.add(Native.toString(cArr));
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static String[] registryGetKeys(WinReg.HKEY hkey, String str) {
        return registryGetKeys(hkey, str, 0);
    }

    public static String[] registryGetKeys(WinReg.HKEY hkey, String str, int i) {
        WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
        int iRegOpenKeyEx = Advapi32.INSTANCE.RegOpenKeyEx(hkey, str, 0, i | 131097, hKEYByReference);
        if (iRegOpenKeyEx != 0) {
            throw new Win32Exception(iRegOpenKeyEx);
        }
        try {
            String[] strArrRegistryGetKeys = registryGetKeys(hKEYByReference.getValue());
            int iRegCloseKey = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
            if (iRegCloseKey == 0) {
                return strArrRegistryGetKeys;
            }
            throw new Win32Exception(iRegCloseKey);
        } catch (Throwable th) {
            int iRegCloseKey2 = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
            if (iRegCloseKey2 != 0) {
                throw new Win32Exception(iRegCloseKey2);
            }
            throw th;
        }
    }

    public static WinReg.HKEYByReference registryGetKey(WinReg.HKEY hkey, String str, int i) {
        WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
        int iRegOpenKeyEx = Advapi32.INSTANCE.RegOpenKeyEx(hkey, str, 0, i, hKEYByReference);
        if (iRegOpenKeyEx == 0) {
            return hKEYByReference;
        }
        throw new Win32Exception(iRegOpenKeyEx);
    }

    public static void registryCloseKey(WinReg.HKEY hkey) {
        int iRegCloseKey = Advapi32.INSTANCE.RegCloseKey(hkey);
        if (iRegCloseKey != 0) {
            throw new Win32Exception(iRegCloseKey);
        }
    }

    public static TreeMap<String, Object> registryGetValues(WinReg.HKEY hkey) {
        int i;
        char c;
        String string;
        IntByReference intByReference = new IntByReference();
        IntByReference intByReference2 = new IntByReference();
        IntByReference intByReference3 = new IntByReference();
        int iRegQueryInfoKey = Advapi32.INSTANCE.RegQueryInfoKey(hkey, null, null, null, null, null, null, intByReference, intByReference2, intByReference3, null, null);
        if (iRegQueryInfoKey != 0) {
            throw new Win32Exception(iRegQueryInfoKey);
        }
        TreeMap<String, Object> treeMap = new TreeMap<>();
        char[] cArr = new char[intByReference2.getValue() + 1];
        Memory memory = new Memory(intByReference3.getValue() + (Native.WCHAR_SIZE * 2));
        int i2 = 0;
        while (i2 < intByReference.getValue()) {
            memory.clear();
            IntByReference intByReference4 = new IntByReference(intByReference2.getValue() + 1);
            IntByReference intByReference5 = new IntByReference(intByReference3.getValue());
            IntByReference intByReference6 = new IntByReference();
            int i3 = i2;
            int iRegEnumValue = Advapi32.INSTANCE.RegEnumValue(hkey, i2, cArr, intByReference4, (IntByReference) null, intByReference6, memory, intByReference5);
            if (iRegEnumValue != 0) {
                throw new Win32Exception(iRegEnumValue);
            }
            String string2 = Native.toString(cArr);
            if (intByReference5.getValue() == 0) {
                int value = intByReference6.getValue();
                if (value != 0) {
                    if (value != 1) {
                        c = 2;
                        if (value == 2) {
                            i = 0;
                        } else if (value == 3) {
                            i = 0;
                            treeMap.put(string2, new byte[0]);
                        } else if (value == 7) {
                            i = 0;
                            treeMap.put(string2, new String[0]);
                        } else {
                            throw new RuntimeException("Unsupported empty type: " + intByReference6.getValue());
                        }
                    } else {
                        i = 0;
                        c = 2;
                    }
                    treeMap.put(string2, new char[i]);
                } else {
                    i = 0;
                    c = 2;
                    treeMap.put(string2, null);
                }
            } else {
                i = 0;
                c = 2;
                int value2 = intByReference6.getValue();
                if (value2 == 1 || value2 == 2) {
                    if (W32APITypeMapper.DEFAULT == W32APITypeMapper.UNICODE) {
                        treeMap.put(string2, memory.getWideString(0L));
                    } else {
                        treeMap.put(string2, memory.getString(0L));
                    }
                } else if (value2 == 3) {
                    treeMap.put(string2, memory.getByteArray(0L, intByReference5.getValue()));
                } else if (value2 == 4) {
                    treeMap.put(string2, Integer.valueOf(memory.getInt(0L)));
                } else if (value2 == 7) {
                    ArrayList arrayList = new ArrayList();
                    int length = 0;
                    while (true) {
                        long j = length;
                        if (j >= memory.size()) {
                            break;
                        }
                        if (W32APITypeMapper.DEFAULT == W32APITypeMapper.UNICODE) {
                            string = memory.getWideString(j);
                            length = length + (string.length() * Native.WCHAR_SIZE) + Native.WCHAR_SIZE;
                        } else {
                            string = memory.getString(j);
                            length = length + string.length() + 1;
                        }
                        if (string.length() == 0) {
                            break;
                        }
                        arrayList.add(string);
                    }
                    treeMap.put(string2, arrayList.toArray(new String[0]));
                } else if (value2 == 11) {
                    treeMap.put(string2, Long.valueOf(memory.getLong(0L)));
                } else {
                    throw new RuntimeException("Unsupported type: " + intByReference6.getValue());
                }
            }
            i2 = i3 + 1;
        }
        return treeMap;
    }

    public static TreeMap<String, Object> registryGetValues(WinReg.HKEY hkey, String str) {
        return registryGetValues(hkey, str, 0);
    }

    public static TreeMap<String, Object> registryGetValues(WinReg.HKEY hkey, String str, int i) {
        WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
        int iRegOpenKeyEx = Advapi32.INSTANCE.RegOpenKeyEx(hkey, str, 0, i | 131097, hKEYByReference);
        if (iRegOpenKeyEx != 0) {
            throw new Win32Exception(iRegOpenKeyEx);
        }
        try {
            TreeMap<String, Object> treeMapRegistryGetValues = registryGetValues(hKEYByReference.getValue());
            int iRegCloseKey = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
            if (iRegCloseKey == 0) {
                return treeMapRegistryGetValues;
            }
            throw new Win32Exception(iRegCloseKey);
        } catch (Throwable th) {
            int iRegCloseKey2 = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
            if (iRegCloseKey2 != 0) {
                throw new Win32Exception(iRegCloseKey2);
            }
            throw th;
        }
    }

    public static InfoKey registryQueryInfoKey(WinReg.HKEY hkey, int i) {
        InfoKey infoKey = new InfoKey(hkey, i);
        int iRegQueryInfoKey = Advapi32.INSTANCE.RegQueryInfoKey(hkey, infoKey.lpClass, infoKey.lpcClass, null, infoKey.lpcSubKeys, infoKey.lpcMaxSubKeyLen, infoKey.lpcMaxClassLen, infoKey.lpcValues, infoKey.lpcMaxValueNameLen, infoKey.lpcMaxValueLen, infoKey.lpcbSecurityDescriptor, infoKey.lpftLastWriteTime);
        if (iRegQueryInfoKey == 0) {
            return infoKey;
        }
        throw new Win32Exception(iRegQueryInfoKey);
    }

    public static class InfoKey {
        public WinReg.HKEY hKey;
        public char[] lpClass;
        public IntByReference lpcClass;
        public IntByReference lpcMaxClassLen;
        public IntByReference lpcMaxSubKeyLen;
        public IntByReference lpcMaxValueLen;
        public IntByReference lpcMaxValueNameLen;
        public IntByReference lpcSubKeys;
        public IntByReference lpcValues;
        public IntByReference lpcbSecurityDescriptor;
        public WinBase.FILETIME lpftLastWriteTime;

        public InfoKey() {
            this.lpClass = new char[260];
            this.lpcClass = new IntByReference(260);
            this.lpcSubKeys = new IntByReference();
            this.lpcMaxSubKeyLen = new IntByReference();
            this.lpcMaxClassLen = new IntByReference();
            this.lpcValues = new IntByReference();
            this.lpcMaxValueNameLen = new IntByReference();
            this.lpcMaxValueLen = new IntByReference();
            this.lpcbSecurityDescriptor = new IntByReference();
            this.lpftLastWriteTime = new WinBase.FILETIME();
        }

        public InfoKey(WinReg.HKEY hkey, int i) {
            this.lpClass = new char[260];
            this.lpcClass = new IntByReference(260);
            this.lpcSubKeys = new IntByReference();
            this.lpcMaxSubKeyLen = new IntByReference();
            this.lpcMaxClassLen = new IntByReference();
            this.lpcValues = new IntByReference();
            this.lpcMaxValueNameLen = new IntByReference();
            this.lpcMaxValueLen = new IntByReference();
            this.lpcbSecurityDescriptor = new IntByReference();
            this.lpftLastWriteTime = new WinBase.FILETIME();
            this.hKey = hkey;
            this.lpcbSecurityDescriptor = new IntByReference(i);
        }
    }

    public static EnumKey registryRegEnumKey(WinReg.HKEY hkey, int i) {
        EnumKey enumKey = new EnumKey(hkey, i);
        int iRegEnumKeyEx = Advapi32.INSTANCE.RegEnumKeyEx(hkey, enumKey.dwIndex, enumKey.lpName, enumKey.lpcName, null, enumKey.lpClass, enumKey.lpcbClass, enumKey.lpftLastWriteTime);
        if (iRegEnumKeyEx == 0) {
            return enumKey;
        }
        throw new Win32Exception(iRegEnumKeyEx);
    }

    public static class EnumKey {
        public int dwIndex;
        public WinReg.HKEY hKey;
        public char[] lpClass;
        public char[] lpName;
        public IntByReference lpcName;
        public IntByReference lpcbClass;
        public WinBase.FILETIME lpftLastWriteTime;

        public EnumKey() {
            this.dwIndex = 0;
            this.lpName = new char[255];
            this.lpcName = new IntByReference(255);
            this.lpClass = new char[255];
            this.lpcbClass = new IntByReference(255);
            this.lpftLastWriteTime = new WinBase.FILETIME();
        }

        public EnumKey(WinReg.HKEY hkey, int i) {
            this.dwIndex = 0;
            this.lpName = new char[255];
            this.lpcName = new IntByReference(255);
            this.lpClass = new char[255];
            this.lpcbClass = new IntByReference(255);
            this.lpftLastWriteTime = new WinBase.FILETIME();
            this.hKey = hkey;
            this.dwIndex = i;
        }
    }

    public static String getEnvironmentBlock(Map<String, String> map) {
        StringBuilder sb = new StringBuilder(map.size() * 32);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (value != null) {
                sb.append(key).append("=").append(value).append((char) 0);
            }
        }
        return sb.append((char) 0).toString();
    }

    public static class EventLogRecord {
        private byte[] _data;
        private WinNT.EVENTLOGRECORD _record;
        private String _source;
        private String[] _strings;

        public WinNT.EVENTLOGRECORD getRecord() {
            return this._record;
        }

        public int getInstanceId() {
            return this._record.EventID.intValue();
        }

        @Deprecated
        public int getEventId() {
            return this._record.EventID.intValue();
        }

        public String getSource() {
            return this._source;
        }

        public int getStatusCode() {
            return this._record.EventID.intValue() & 65535;
        }

        public int getRecordNumber() {
            return this._record.RecordNumber.intValue();
        }

        public int getLength() {
            return this._record.Length.intValue();
        }

        public String[] getStrings() {
            return this._strings;
        }

        public EventLogType getType() {
            int iIntValue = this._record.EventType.intValue();
            if (iIntValue != 0) {
                if (iIntValue == 1) {
                    return EventLogType.Error;
                }
                if (iIntValue == 2) {
                    return EventLogType.Warning;
                }
                if (iIntValue != 4) {
                    if (iIntValue == 8) {
                        return EventLogType.AuditSuccess;
                    }
                    if (iIntValue == 16) {
                        return EventLogType.AuditFailure;
                    }
                    throw new RuntimeException("Invalid type: " + this._record.EventType.intValue());
                }
            }
            return EventLogType.Informational;
        }

        public byte[] getData() {
            return this._data;
        }

        public EventLogRecord(Pointer pointer) {
            this._record = new WinNT.EVENTLOGRECORD(pointer);
            this._source = pointer.getWideString(r0.size());
            if (this._record.DataLength.intValue() > 0) {
                this._data = pointer.getByteArray(this._record.DataOffset.intValue(), this._record.DataLength.intValue());
            }
            if (this._record.NumStrings.intValue() > 0) {
                ArrayList arrayList = new ArrayList();
                long jIntValue = this._record.StringOffset.intValue();
                for (int iIntValue = this._record.NumStrings.intValue(); iIntValue > 0; iIntValue--) {
                    arrayList.add(pointer.getWideString(jIntValue));
                    jIntValue = jIntValue + (r4.length() * Native.WCHAR_SIZE) + Native.WCHAR_SIZE;
                }
                this._strings = (String[]) arrayList.toArray(new String[0]);
            }
        }
    }

    public static class EventLogIterator implements Iterable<EventLogRecord>, Iterator<EventLogRecord> {
        private Memory _buffer;
        private boolean _done;
        private int _dwRead;
        private int _flags;
        private WinNT.HANDLE _h;
        private Pointer _pevlr;

        @Override // java.lang.Iterable
        public Iterator<EventLogRecord> iterator() {
            return this;
        }

        @Override // java.util.Iterator
        public void remove() {
        }

        public EventLogIterator(String str) {
            this(null, str, 4);
        }

        public EventLogIterator(String str, String str2, int i) {
            this._buffer = new Memory(PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH);
            this._done = false;
            this._dwRead = 0;
            this._pevlr = null;
            this._flags = i;
            WinNT.HANDLE handleOpenEventLog = Advapi32.INSTANCE.OpenEventLog(str, str2);
            this._h = handleOpenEventLog;
            if (handleOpenEventLog == null) {
                throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
            }
        }

        private boolean read() {
            if (this._done || this._dwRead > 0) {
                return false;
            }
            IntByReference intByReference = new IntByReference();
            IntByReference intByReference2 = new IntByReference();
            Advapi32 advapi32 = Advapi32.INSTANCE;
            WinNT.HANDLE handle = this._h;
            int i = this._flags | 1;
            Memory memory = this._buffer;
            if (!advapi32.ReadEventLog(handle, i, 0, memory, (int) memory.size(), intByReference, intByReference2)) {
                int iGetLastError = Kernel32.INSTANCE.GetLastError();
                if (iGetLastError == 122) {
                    this._buffer = new Memory(intByReference2.getValue());
                    Advapi32 advapi322 = Advapi32.INSTANCE;
                    WinNT.HANDLE handle2 = this._h;
                    int i2 = this._flags | 1;
                    Memory memory2 = this._buffer;
                    if (!advapi322.ReadEventLog(handle2, i2, 0, memory2, (int) memory2.size(), intByReference, intByReference2)) {
                        throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                    }
                } else {
                    close();
                    if (iGetLastError == 38) {
                        return false;
                    }
                    throw new Win32Exception(iGetLastError);
                }
            }
            this._dwRead = intByReference.getValue();
            this._pevlr = this._buffer;
            return true;
        }

        public void close() {
            this._done = true;
            if (this._h != null) {
                if (!Advapi32.INSTANCE.CloseEventLog(this._h)) {
                    throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                }
                this._h = null;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            read();
            return !this._done;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public EventLogRecord next() {
            read();
            EventLogRecord eventLogRecord = new EventLogRecord(this._pevlr);
            this._dwRead -= eventLogRecord.getLength();
            this._pevlr = this._pevlr.share(eventLogRecord.getLength());
            return eventLogRecord;
        }
    }

    public static WinNT.ACE_HEADER[] getFileSecurity(String str, boolean z) {
        Memory memory;
        boolean z2;
        int i = 1024;
        do {
            memory = new Memory(i);
            IntByReference intByReference = new IntByReference();
            if (!Advapi32.INSTANCE.GetFileSecurity(str, 4, memory, i, intByReference)) {
                int iGetLastError = Kernel32.INSTANCE.GetLastError();
                memory.clear();
                if (122 != iGetLastError) {
                    throw new Win32Exception(iGetLastError);
                }
            }
            int value = intByReference.getValue();
            if (i < value) {
                memory.clear();
                i = value;
                z2 = true;
            } else {
                z2 = false;
            }
        } while (z2);
        WinNT.ACE_HEADER[] aCEs = new WinNT.SECURITY_DESCRIPTOR_RELATIVE(memory).getDiscretionaryACL().getACEs();
        if (!z) {
            return aCEs;
        }
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        for (WinNT.ACE_HEADER ace_header : aCEs) {
            if (ace_header instanceof WinNT.ACCESS_ACEStructure) {
                WinNT.ACCESS_ACEStructure aCCESS_ACEStructure = (WinNT.ACCESS_ACEStructure) ace_header;
                String str2 = aCCESS_ACEStructure.getSidString() + "/" + ((ace_header.AceFlags & 31) != 0) + "/" + ace_header.getClass().getName();
                WinNT.ACCESS_ACEStructure aCCESS_ACEStructure2 = (WinNT.ACCESS_ACEStructure) map.get(str2);
                if (aCCESS_ACEStructure2 != null) {
                    aCCESS_ACEStructure2.Mask |= aCCESS_ACEStructure.Mask;
                } else {
                    map.put(str2, aCCESS_ACEStructure);
                    arrayList.add(aCCESS_ACEStructure2);
                }
            } else {
                arrayList.add(ace_header);
            }
        }
        return (WinNT.ACE_HEADER[]) arrayList.toArray(new WinNT.ACE_HEADER[0]);
    }

    public enum AccessCheckPermission {
        READ(Integer.MIN_VALUE),
        WRITE(1073741824),
        EXECUTE(536870912);

        final int code;

        AccessCheckPermission(int i) {
            this.code = i;
        }

        public int getCode() {
            return this.code;
        }
    }

    private static Memory getSecurityDescriptorForFile(String str) {
        int iGetLastError;
        IntByReference intByReference = new IntByReference();
        if (!Advapi32.INSTANCE.GetFileSecurity(str, 7, null, 0, intByReference) && 122 != (iGetLastError = Kernel32.INSTANCE.GetLastError())) {
            throw new Win32Exception(iGetLastError);
        }
        int value = intByReference.getValue();
        Memory memory = new Memory(value);
        if (Advapi32.INSTANCE.GetFileSecurity(str, 7, memory, value, intByReference)) {
            return memory;
        }
        memory.clear();
        throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
    }

    public static Memory getSecurityDescriptorForObject(String str, int i, boolean z) {
        int i2 = (z ? 8 : 0) | 7;
        PointerByReference pointerByReference = new PointerByReference();
        int iGetNamedSecurityInfo = Advapi32.INSTANCE.GetNamedSecurityInfo(str, i, i2, null, null, null, null, pointerByReference);
        if (iGetNamedSecurityInfo != 0) {
            throw new Win32Exception(iGetNamedSecurityInfo);
        }
        int iGetSecurityDescriptorLength = Advapi32.INSTANCE.GetSecurityDescriptorLength(pointerByReference.getValue());
        Memory memory = new Memory(iGetSecurityDescriptorLength);
        Pointer value = pointerByReference.getValue();
        try {
            memory.write(0L, value.getByteArray(0L, iGetSecurityDescriptorLength), 0, iGetSecurityDescriptorLength);
            return memory;
        } finally {
            Kernel32Util.freeLocalMemory(value);
        }
    }

    public static void setSecurityDescriptorForObject(String str, int i, WinNT.SECURITY_DESCRIPTOR_RELATIVE security_descriptor_relative, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        int i2;
        int i3;
        int i4;
        WinNT.PSID owner = security_descriptor_relative.getOwner();
        WinNT.PSID group = security_descriptor_relative.getGroup();
        WinNT.ACL discretionaryACL = security_descriptor_relative.getDiscretionaryACL();
        WinNT.ACL systemACL = security_descriptor_relative.getSystemACL();
        if (!z) {
            i2 = 0;
        } else {
            if (owner == null) {
                throw new IllegalArgumentException("SECURITY_DESCRIPTOR_RELATIVE does not contain owner");
            }
            if (!Advapi32.INSTANCE.IsValidSid(owner)) {
                throw new IllegalArgumentException("Owner PSID is invalid");
            }
            i2 = 1;
        }
        if (z2) {
            if (group == null) {
                throw new IllegalArgumentException("SECURITY_DESCRIPTOR_RELATIVE does not contain group");
            }
            if (!Advapi32.INSTANCE.IsValidSid(group)) {
                throw new IllegalArgumentException("Group PSID is invalid");
            }
            i2 |= 2;
        }
        if (z3) {
            if (discretionaryACL == null) {
                throw new IllegalArgumentException("SECURITY_DESCRIPTOR_RELATIVE does not contain DACL");
            }
            if (!Advapi32.INSTANCE.IsValidAcl(discretionaryACL.getPointer())) {
                throw new IllegalArgumentException("DACL is invalid");
            }
            i2 |= 4;
        }
        if (z4) {
            if (systemACL == null) {
                throw new IllegalArgumentException("SECURITY_DESCRIPTOR_RELATIVE does not contain SACL");
            }
            if (!Advapi32.INSTANCE.IsValidAcl(systemACL.getPointer())) {
                throw new IllegalArgumentException("SACL is invalid");
            }
            i2 |= 8;
        }
        if (z5) {
            if ((security_descriptor_relative.Control & 4096) == 0) {
                i4 = (security_descriptor_relative.Control & 4096) == 0 ? 536870912 : Integer.MIN_VALUE;
            }
            i2 |= i4;
        }
        if (z6) {
            if ((security_descriptor_relative.Control & 8192) == 0) {
                i3 = (security_descriptor_relative.Control & 8192) == 0 ? 268435456 : 1073741824;
            }
            i2 |= i3;
        }
        int iSetNamedSecurityInfo = Advapi32.INSTANCE.SetNamedSecurityInfo(str, i, i2, z ? owner.getPointer() : null, z2 ? group.getPointer() : null, z3 ? discretionaryACL.getPointer() : null, z4 ? systemACL.getPointer() : null);
        if (iSetNamedSecurityInfo != 0) {
            throw new Win32Exception(iSetNamedSecurityInfo);
        }
    }

    public static boolean accessCheck(File file, AccessCheckPermission accessCheckPermission) {
        Memory securityDescriptorForFile = getSecurityDescriptorForFile(file.getAbsolutePath().replace('/', AbstractJsonLexerKt.STRING_ESC));
        WinNT.HANDLEByReference hANDLEByReference = new WinNT.HANDLEByReference();
        WinNT.HANDLEByReference hANDLEByReference2 = new WinNT.HANDLEByReference();
        Win32Exception win32Exception = null;
        try {
            try {
                if (!Advapi32.INSTANCE.OpenProcessToken(Kernel32.INSTANCE.GetCurrentProcess(), 131086, hANDLEByReference)) {
                    throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                }
                if (!Advapi32.INSTANCE.DuplicateToken(hANDLEByReference.getValue(), 2, hANDLEByReference2)) {
                    throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                }
                WinNT.GENERIC_MAPPING generic_mapping = new WinNT.GENERIC_MAPPING();
                generic_mapping.genericRead = new WinDef.DWORD(1179785L);
                generic_mapping.genericWrite = new WinDef.DWORD(1179926L);
                generic_mapping.genericExecute = new WinDef.DWORD(1179808L);
                generic_mapping.genericAll = new WinDef.DWORD(2032127L);
                WinDef.DWORDByReference dWORDByReference = new WinDef.DWORDByReference(new WinDef.DWORD(accessCheckPermission.getCode()));
                Advapi32.INSTANCE.MapGenericMask(dWORDByReference, generic_mapping);
                WinNT.PRIVILEGE_SET privilege_set = new WinNT.PRIVILEGE_SET(1);
                privilege_set.PrivilegeCount = new WinDef.DWORD(0L);
                WinDef.DWORDByReference dWORDByReference2 = new WinDef.DWORDByReference(new WinDef.DWORD(privilege_set.size()));
                WinDef.DWORDByReference dWORDByReference3 = new WinDef.DWORDByReference();
                WinDef.BOOLByReference bOOLByReference = new WinDef.BOOLByReference();
                if (!Advapi32.INSTANCE.AccessCheck(securityDescriptorForFile, hANDLEByReference2.getValue(), dWORDByReference.getValue(), generic_mapping, privilege_set, dWORDByReference2, dWORDByReference3, bOOLByReference)) {
                    throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                }
                boolean zBooleanValue = bOOLByReference.getValue().booleanValue();
                try {
                    Kernel32Util.closeHandleRefs(hANDLEByReference, hANDLEByReference2);
                } catch (Win32Exception e) {
                    win32Exception = e;
                }
                if (securityDescriptorForFile != null) {
                    securityDescriptorForFile.clear();
                }
                if (win32Exception == null) {
                    return zBooleanValue;
                }
                throw win32Exception;
            } catch (Win32Exception e2) {
                throw e2;
            }
        } catch (Throwable th) {
            Win32Exception win32Exception2 = null;
            try {
                Kernel32Util.closeHandleRefs(hANDLEByReference, hANDLEByReference2);
            } catch (Win32Exception e3) {
                if (0 == 0) {
                    win32Exception2 = e3;
                } else {
                    win32Exception2.addSuppressedReflected(e3);
                }
            }
            if (securityDescriptorForFile != null) {
                securityDescriptorForFile.clear();
            }
            if (win32Exception2 != null) {
                throw win32Exception2;
            }
            throw th;
        }
    }

    public static WinNT.SECURITY_DESCRIPTOR_RELATIVE getFileSecurityDescriptor(File file, boolean z) {
        return new WinNT.SECURITY_DESCRIPTOR_RELATIVE(getSecurityDescriptorForObject(file.getAbsolutePath().replaceAll("/", "\\"), 1, z));
    }

    public static void setFileSecurityDescriptor(File file, WinNT.SECURITY_DESCRIPTOR_RELATIVE security_descriptor_relative, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        setSecurityDescriptorForObject(file.getAbsolutePath().replaceAll("/", "\\"), 1, security_descriptor_relative, z, z2, z3, z4, z5, z6);
    }

    public static void encryptFile(File file) {
        if (!Advapi32.INSTANCE.EncryptFile(file.getAbsolutePath())) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
    }

    public static void decryptFile(File file) {
        if (!Advapi32.INSTANCE.DecryptFile(file.getAbsolutePath(), new WinDef.DWORD(0L))) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
    }

    public static int fileEncryptionStatus(File file) {
        WinDef.DWORDByReference dWORDByReference = new WinDef.DWORDByReference();
        if (!Advapi32.INSTANCE.FileEncryptionStatus(file.getAbsolutePath(), dWORDByReference)) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        return dWORDByReference.getValue().intValue();
    }

    public static void disableEncryption(File file, boolean z) {
        if (!Advapi32.INSTANCE.EncryptionDisable(file.getAbsolutePath(), z)) {
            throw new Win32Exception(Native.getLastError());
        }
    }

    public static void backupEncryptedFile(File file, File file2) throws IOException {
        if (!file2.isDirectory()) {
            throw new IllegalArgumentException("destDir must be a directory.");
        }
        WinDef.ULONG ulong = new WinDef.ULONG(0L);
        WinDef.ULONG ulong2 = new WinDef.ULONG(1L);
        if (file.isDirectory()) {
            ulong2.setValue(3L);
        }
        String absolutePath = file.getAbsolutePath();
        PointerByReference pointerByReference = new PointerByReference();
        if (Advapi32.INSTANCE.OpenEncryptedFileRaw(absolutePath, ulong, pointerByReference) != 0) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (Advapi32.INSTANCE.ReadEncryptedFileRaw(new WinBase.FE_EXPORT_FUNC() { // from class: com.sun.jna.platform.win32.Advapi32Util.1
            @Override // com.sun.jna.platform.win32.WinBase.FE_EXPORT_FUNC
            public WinDef.DWORD callback(Pointer pointer, Pointer pointer2, WinDef.ULONG ulong3) {
                try {
                    byteArrayOutputStream.write(pointer.getByteArray(0L, ulong3.intValue()));
                    return new WinDef.DWORD(0L);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }, null, pointerByReference.getValue()) != 0) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        try {
            byteArrayOutputStream.close();
            Advapi32.INSTANCE.CloseEncryptedFileRaw(pointerByReference.getValue());
            String str = file2.getAbsolutePath() + File.separator + file.getName();
            PointerByReference pointerByReference2 = new PointerByReference();
            if (Advapi32.INSTANCE.OpenEncryptedFileRaw(str, ulong2, pointerByReference2) != 0) {
                throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
            }
            final IntByReference intByReference = new IntByReference(0);
            if (Advapi32.INSTANCE.WriteEncryptedFileRaw(new WinBase.FE_IMPORT_FUNC() { // from class: com.sun.jna.platform.win32.Advapi32Util.2
                @Override // com.sun.jna.platform.win32.WinBase.FE_IMPORT_FUNC
                public WinDef.DWORD callback(Pointer pointer, Pointer pointer2, WinDef.ULONGByReference uLONGByReference) {
                    int value = intByReference.getValue();
                    int iMin = Math.min(byteArrayOutputStream.size() - value, uLONGByReference.getValue().intValue());
                    pointer.write(0L, byteArrayOutputStream.toByteArray(), value, iMin);
                    intByReference.setValue(value + iMin);
                    uLONGByReference.setValue(new WinDef.ULONG(iMin));
                    return new WinDef.DWORD(0L);
                }
            }, null, pointerByReference2.getValue()) != 0) {
                throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
            }
            Advapi32.INSTANCE.CloseEncryptedFileRaw(pointerByReference2.getValue());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static class Privilege implements Closeable {
        private final WinNT.LUID[] pLuids;
        private boolean currentlyImpersonating = false;
        private boolean privilegesEnabled = false;

        public Privilege(String... strArr) throws Win32Exception, IllegalArgumentException {
            this.pLuids = new WinNT.LUID[strArr.length];
            int i = 0;
            for (String str : strArr) {
                this.pLuids[i] = new WinNT.LUID();
                if (!Advapi32.INSTANCE.LookupPrivilegeValue(null, str, this.pLuids[i])) {
                    throw new IllegalArgumentException("Failed to find privilege \"" + strArr[i] + "\" - " + Kernel32.INSTANCE.GetLastError());
                }
                i++;
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws Win32Exception {
            disable();
        }

        public Privilege enable() throws Win32Exception {
            if (this.privilegesEnabled) {
                return this;
            }
            WinNT.HANDLEByReference hANDLEByReference = new WinNT.HANDLEByReference();
            try {
                try {
                    hANDLEByReference.setValue(getThreadToken());
                    WinNT.TOKEN_PRIVILEGES token_privileges = new WinNT.TOKEN_PRIVILEGES(this.pLuids.length);
                    for (int i = 0; i < this.pLuids.length; i++) {
                        token_privileges.Privileges[i] = new WinNT.LUID_AND_ATTRIBUTES(this.pLuids[i], new WinDef.DWORD(2L));
                    }
                    if (!Advapi32.INSTANCE.AdjustTokenPrivileges(hANDLEByReference.getValue(), false, token_privileges, 0, null, null)) {
                        throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                    }
                    this.privilegesEnabled = true;
                    return this;
                } catch (Win32Exception e) {
                    if (this.currentlyImpersonating) {
                        Advapi32.INSTANCE.SetThreadToken(null, null);
                        this.currentlyImpersonating = false;
                    } else if (this.privilegesEnabled) {
                        WinNT.TOKEN_PRIVILEGES token_privileges2 = new WinNT.TOKEN_PRIVILEGES(this.pLuids.length);
                        for (int i2 = 0; i2 < this.pLuids.length; i2++) {
                            token_privileges2.Privileges[i2] = new WinNT.LUID_AND_ATTRIBUTES(this.pLuids[i2], new WinDef.DWORD(0L));
                        }
                        Advapi32.INSTANCE.AdjustTokenPrivileges(hANDLEByReference.getValue(), false, token_privileges2, 0, null, null);
                        this.privilegesEnabled = false;
                    }
                    throw e;
                }
            } finally {
                if (hANDLEByReference.getValue() != WinBase.INVALID_HANDLE_VALUE && hANDLEByReference.getValue() != null) {
                    Kernel32.INSTANCE.CloseHandle(hANDLEByReference.getValue());
                    hANDLEByReference.setValue(null);
                }
            }
        }

        public void disable() throws Win32Exception {
            WinNT.HANDLEByReference hANDLEByReference = new WinNT.HANDLEByReference();
            try {
                hANDLEByReference.setValue(getThreadToken());
                if (this.currentlyImpersonating) {
                    Advapi32.INSTANCE.SetThreadToken(null, null);
                } else if (this.privilegesEnabled) {
                    WinNT.TOKEN_PRIVILEGES token_privileges = new WinNT.TOKEN_PRIVILEGES(this.pLuids.length);
                    for (int i = 0; i < this.pLuids.length; i++) {
                        token_privileges.Privileges[i] = new WinNT.LUID_AND_ATTRIBUTES(this.pLuids[i], new WinDef.DWORD(0L));
                    }
                    Advapi32.INSTANCE.AdjustTokenPrivileges(hANDLEByReference.getValue(), false, token_privileges, 0, null, null);
                    this.privilegesEnabled = false;
                }
            } finally {
                if (hANDLEByReference.getValue() != WinBase.INVALID_HANDLE_VALUE && hANDLEByReference.getValue() != null) {
                    Kernel32.INSTANCE.CloseHandle(hANDLEByReference.getValue());
                    hANDLEByReference.setValue(null);
                }
            }
        }

        private WinNT.HANDLE getThreadToken() throws Win32Exception {
            WinNT.HANDLEByReference hANDLEByReference = new WinNT.HANDLEByReference();
            WinNT.HANDLEByReference hANDLEByReference2 = new WinNT.HANDLEByReference();
            try {
                try {
                    if (!Advapi32.INSTANCE.OpenThreadToken(Kernel32.INSTANCE.GetCurrentThread(), 32, false, hANDLEByReference)) {
                        int iGetLastError = Kernel32.INSTANCE.GetLastError();
                        if (1008 != iGetLastError) {
                            throw new Win32Exception(iGetLastError);
                        }
                        if (!Advapi32.INSTANCE.OpenProcessToken(Kernel32.INSTANCE.GetCurrentProcess(), 2, hANDLEByReference2)) {
                            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                        }
                        if (!Advapi32.INSTANCE.DuplicateTokenEx(hANDLEByReference2.getValue(), 36, null, 2, 2, hANDLEByReference)) {
                            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                        }
                        if (!Advapi32.INSTANCE.SetThreadToken(null, hANDLEByReference.getValue())) {
                            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                        }
                        this.currentlyImpersonating = true;
                    }
                    if (hANDLEByReference2.getValue() != WinBase.INVALID_HANDLE_VALUE && hANDLEByReference2.getValue() != null) {
                        Kernel32.INSTANCE.CloseHandle(hANDLEByReference2.getValue());
                        hANDLEByReference2.setValue(null);
                    }
                    return hANDLEByReference.getValue();
                } catch (Win32Exception e) {
                    if (hANDLEByReference.getValue() != WinBase.INVALID_HANDLE_VALUE && hANDLEByReference.getValue() != null) {
                        Kernel32.INSTANCE.CloseHandle(hANDLEByReference.getValue());
                        hANDLEByReference.setValue(null);
                    }
                    throw e;
                }
            } catch (Throwable th) {
                if (hANDLEByReference2.getValue() != WinBase.INVALID_HANDLE_VALUE && hANDLEByReference2.getValue() != null) {
                    Kernel32.INSTANCE.CloseHandle(hANDLEByReference2.getValue());
                    hANDLEByReference2.setValue(null);
                }
                throw th;
            }
        }
    }
}
