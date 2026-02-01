package com.sun.jna.platform.win32;

import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.platform.win32.Winevt;
import com.sun.jna.ptr.IntByReference;

/* loaded from: classes4.dex */
public abstract class WevtapiUtil {
    public static String EvtGetExtendedStatus() {
        IntByReference intByReference = new IntByReference();
        int iEvtGetExtendedStatus = Wevtapi.INSTANCE.EvtGetExtendedStatus(0, null, intByReference);
        if (iEvtGetExtendedStatus != 0 && iEvtGetExtendedStatus != 122) {
            throw new Win32Exception(iEvtGetExtendedStatus);
        }
        if (intByReference.getValue() == 0) {
            return "";
        }
        int value = intByReference.getValue();
        char[] cArr = new char[value];
        int iEvtGetExtendedStatus2 = Wevtapi.INSTANCE.EvtGetExtendedStatus(value, cArr, intByReference);
        if (iEvtGetExtendedStatus2 != 0) {
            throw new Win32Exception(iEvtGetExtendedStatus2);
        }
        return Native.toString(cArr);
    }

    public static Memory EvtRender(Winevt.EVT_HANDLE evt_handle, Winevt.EVT_HANDLE evt_handle2, int i, IntByReference intByReference) {
        IntByReference intByReference2 = new IntByReference();
        boolean zEvtRender = Wevtapi.INSTANCE.EvtRender(evt_handle, evt_handle2, i, 0, null, intByReference2, intByReference);
        int iGetLastError = Kernel32.INSTANCE.GetLastError();
        if (!zEvtRender && iGetLastError != 122) {
            throw new Win32Exception(iGetLastError);
        }
        Memory memory = new Memory(intByReference2.getValue());
        if (Wevtapi.INSTANCE.EvtRender(evt_handle, evt_handle2, i, (int) memory.size(), memory, intByReference2, intByReference)) {
            return memory;
        }
        throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
    }

    public static String EvtFormatMessage(Winevt.EVT_HANDLE evt_handle, Winevt.EVT_HANDLE evt_handle2, int i, int i2, Winevt.EVT_VARIANT[] evt_variantArr, int i3) {
        IntByReference intByReference = new IntByReference();
        boolean zEvtFormatMessage = Wevtapi.INSTANCE.EvtFormatMessage(evt_handle, evt_handle2, i, i2, evt_variantArr, i3, 0, null, intByReference);
        int iGetLastError = Kernel32.INSTANCE.GetLastError();
        if (!zEvtFormatMessage && iGetLastError != 122) {
            throw new Win32Exception(iGetLastError);
        }
        int value = intByReference.getValue();
        char[] cArr = new char[value];
        if (!Wevtapi.INSTANCE.EvtFormatMessage(evt_handle, evt_handle2, i, i2, evt_variantArr, i3, value, cArr, intByReference)) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        return Native.toString(cArr);
    }

    public static Winevt.EVT_VARIANT EvtGetChannelConfigProperty(Winevt.EVT_HANDLE evt_handle, int i) {
        IntByReference intByReference = new IntByReference();
        boolean zEvtGetChannelConfigProperty = Wevtapi.INSTANCE.EvtGetChannelConfigProperty(evt_handle, i, 0, 0, null, intByReference);
        int iGetLastError = Kernel32.INSTANCE.GetLastError();
        if (!zEvtGetChannelConfigProperty && iGetLastError != 122) {
            throw new Win32Exception(iGetLastError);
        }
        Memory memory = new Memory(intByReference.getValue());
        if (!Wevtapi.INSTANCE.EvtGetChannelConfigProperty(evt_handle, i, 0, (int) memory.size(), memory, intByReference)) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        Winevt.EVT_VARIANT evt_variant = new Winevt.EVT_VARIANT(memory);
        evt_variant.read();
        return evt_variant;
    }

    public static String EvtNextPublisherId(Winevt.EVT_HANDLE evt_handle) {
        IntByReference intByReference = new IntByReference();
        boolean zEvtNextPublisherId = Wevtapi.INSTANCE.EvtNextPublisherId(evt_handle, 0, null, intByReference);
        int iGetLastError = Kernel32.INSTANCE.GetLastError();
        if (!zEvtNextPublisherId && iGetLastError != 122) {
            throw new Win32Exception(iGetLastError);
        }
        int value = intByReference.getValue();
        char[] cArr = new char[value];
        if (!Wevtapi.INSTANCE.EvtNextPublisherId(evt_handle, value, cArr, intByReference)) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        return Native.toString(cArr);
    }

    public static Memory EvtGetPublisherMetadataProperty(Winevt.EVT_HANDLE evt_handle, int i, int i2) {
        IntByReference intByReference = new IntByReference();
        boolean zEvtGetPublisherMetadataProperty = Wevtapi.INSTANCE.EvtGetPublisherMetadataProperty(evt_handle, i, i2, 0, null, intByReference);
        int iGetLastError = Kernel32.INSTANCE.GetLastError();
        if (!zEvtGetPublisherMetadataProperty && iGetLastError != 122) {
            throw new Win32Exception(iGetLastError);
        }
        Memory memory = new Memory(intByReference.getValue());
        if (Wevtapi.INSTANCE.EvtGetPublisherMetadataProperty(evt_handle, i, i2, (int) memory.size(), memory, intByReference)) {
            return memory;
        }
        throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
    }
}
