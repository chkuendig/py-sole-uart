package com.sun.jna.platform.win32;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.win32.W32APIOptions;

/* loaded from: classes4.dex */
public interface Cfgmgr32 extends Library {
    public static final int CM_LOCATE_DEVNODE_BITS = 7;
    public static final int CM_LOCATE_DEVNODE_CANCELREMOVE = 2;
    public static final int CM_LOCATE_DEVNODE_NORMAL = 0;
    public static final int CM_LOCATE_DEVNODE_NOVALIDATION = 4;
    public static final int CM_LOCATE_DEVNODE_PHANTOM = 1;
    public static final int CR_BUFFER_SMALL = 26;
    public static final int CR_SUCCESS = 0;
    public static final Cfgmgr32 INSTANCE = (Cfgmgr32) Native.load("Cfgmgr32", Cfgmgr32.class, W32APIOptions.DEFAULT_OPTIONS);

    int CM_Get_Child(IntByReference intByReference, int i, int i2);

    int CM_Get_Device_ID(int i, Pointer pointer, int i2, int i3);

    int CM_Get_Device_ID_Size(IntByReference intByReference, int i, int i2);

    int CM_Get_Parent(IntByReference intByReference, int i, int i2);

    int CM_Get_Sibling(IntByReference intByReference, int i, int i2);

    int CM_Locate_DevNode(IntByReference intByReference, String str, int i);
}
