package com.sun.jna.platform.win32;

import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.ptr.IntByReference;

/* loaded from: classes4.dex */
public abstract class Cfgmgr32Util {

    public static class Cfgmgr32Exception extends RuntimeException {
        private final int errorCode;

        public Cfgmgr32Exception(int i) {
            this.errorCode = i;
        }

        public int getErrorCode() {
            return this.errorCode;
        }
    }

    public static String CM_Get_Device_ID(int i) throws Cfgmgr32Exception {
        int i2 = Boolean.getBoolean("w32.ascii") ? 1 : Native.WCHAR_SIZE;
        IntByReference intByReference = new IntByReference();
        int iCM_Get_Device_ID_Size = Cfgmgr32.INSTANCE.CM_Get_Device_ID_Size(intByReference, i, 0);
        if (iCM_Get_Device_ID_Size != 0) {
            throw new Cfgmgr32Exception(iCM_Get_Device_ID_Size);
        }
        Memory memory = new Memory((intByReference.getValue() + 1) * i2);
        memory.clear();
        int iCM_Get_Device_ID = Cfgmgr32.INSTANCE.CM_Get_Device_ID(i, memory, intByReference.getValue(), 0);
        if (iCM_Get_Device_ID == 26) {
            int iCM_Get_Device_ID_Size2 = Cfgmgr32.INSTANCE.CM_Get_Device_ID_Size(intByReference, i, 0);
            if (iCM_Get_Device_ID_Size2 != 0) {
                throw new Cfgmgr32Exception(iCM_Get_Device_ID_Size2);
            }
            memory = new Memory((intByReference.getValue() + 1) * i2);
            memory.clear();
            iCM_Get_Device_ID = Cfgmgr32.INSTANCE.CM_Get_Device_ID(i, memory, intByReference.getValue(), 0);
        }
        if (iCM_Get_Device_ID != 0) {
            throw new Cfgmgr32Exception(iCM_Get_Device_ID);
        }
        if (i2 == 1) {
            return memory.getString(0L);
        }
        return memory.getWideString(0L);
    }
}
