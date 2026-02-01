package com.sun.jna.platform.win32;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.platform.win32.Winsvc;
import com.sun.jna.ptr.IntByReference;
import java.io.Closeable;

/* loaded from: classes4.dex */
public class W32ServiceManager implements Closeable {
    String _databaseName;
    Winsvc.SC_HANDLE _handle;
    String _machineName;

    public W32ServiceManager() {
        this._handle = null;
        this._machineName = null;
        this._databaseName = null;
    }

    public W32ServiceManager(int i) {
        this._handle = null;
        this._machineName = null;
        this._databaseName = null;
        open(i);
    }

    public W32ServiceManager(String str, String str2) {
        this._handle = null;
        this._machineName = str;
        this._databaseName = str2;
    }

    public W32ServiceManager(String str, String str2, int i) {
        this._handle = null;
        this._machineName = str;
        this._databaseName = str2;
        open(i);
    }

    public void open(int i) {
        close();
        Winsvc.SC_HANDLE sc_handleOpenSCManager = Advapi32.INSTANCE.OpenSCManager(this._machineName, this._databaseName, i);
        this._handle = sc_handleOpenSCManager;
        if (sc_handleOpenSCManager == null) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this._handle != null) {
            if (!Advapi32.INSTANCE.CloseServiceHandle(this._handle)) {
                throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
            }
            this._handle = null;
        }
    }

    public W32Service openService(String str, int i) {
        Winsvc.SC_HANDLE sc_handleOpenService = Advapi32.INSTANCE.OpenService(this._handle, str, i);
        if (sc_handleOpenService == null) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        return new W32Service(sc_handleOpenService);
    }

    public Winsvc.SC_HANDLE getHandle() {
        return this._handle;
    }

    public Winsvc.ENUM_SERVICE_STATUS_PROCESS[] enumServicesStatusExProcess(int i, int i2, String str) {
        IntByReference intByReference = new IntByReference(0);
        IntByReference intByReference2 = new IntByReference(0);
        IntByReference intByReference3 = new IntByReference(0);
        Advapi32.INSTANCE.EnumServicesStatusEx(this._handle, 0, i, i2, Pointer.NULL, 0, intByReference, intByReference2, intByReference3, str);
        int iGetLastError = Kernel32.INSTANCE.GetLastError();
        if (iGetLastError != 234) {
            throw new Win32Exception(iGetLastError);
        }
        Memory memory = new Memory(intByReference.getValue());
        if (!Advapi32.INSTANCE.EnumServicesStatusEx(this._handle, 0, i, i2, memory, (int) memory.size(), intByReference, intByReference2, intByReference3, str)) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        if (intByReference2.getValue() == 0) {
            return new Winsvc.ENUM_SERVICE_STATUS_PROCESS[0];
        }
        Winsvc.ENUM_SERVICE_STATUS_PROCESS enum_service_status_process = (Winsvc.ENUM_SERVICE_STATUS_PROCESS) Structure.newInstance(Winsvc.ENUM_SERVICE_STATUS_PROCESS.class, memory);
        enum_service_status_process.read();
        return (Winsvc.ENUM_SERVICE_STATUS_PROCESS[]) enum_service_status_process.toArray(intByReference2.getValue());
    }
}
