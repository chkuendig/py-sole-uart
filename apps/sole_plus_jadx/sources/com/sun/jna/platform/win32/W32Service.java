package com.sun.jna.platform.win32;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.platform.win32.Winsvc;
import com.sun.jna.ptr.IntByReference;
import java.io.Closeable;
import java.util.List;

/* loaded from: classes4.dex */
public class W32Service implements Closeable {
    Winsvc.SC_HANDLE _handle;

    private boolean isPendingState(int i) {
        return i == 2 || i == 3 || i == 5 || i == 6;
    }

    public W32Service(Winsvc.SC_HANDLE sc_handle) {
        this._handle = sc_handle;
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

    private void addShutdownPrivilegeToProcess() {
        WinNT.HANDLEByReference hANDLEByReference = new WinNT.HANDLEByReference();
        WinNT.LUID luid = new WinNT.LUID();
        Advapi32.INSTANCE.OpenProcessToken(Kernel32.INSTANCE.GetCurrentProcess(), 32, hANDLEByReference);
        Advapi32.INSTANCE.LookupPrivilegeValue("", WinNT.SE_SHUTDOWN_NAME, luid);
        WinNT.TOKEN_PRIVILEGES token_privileges = new WinNT.TOKEN_PRIVILEGES(1);
        token_privileges.Privileges[0] = new WinNT.LUID_AND_ATTRIBUTES(luid, new WinDef.DWORD(2L));
        Advapi32.INSTANCE.AdjustTokenPrivileges(hANDLEByReference.getValue(), false, token_privileges, token_privileges.size(), null, new IntByReference());
    }

    public void setFailureActions(List<Winsvc.SC_ACTION> list, int i, String str, String str2) {
        Winsvc.SERVICE_FAILURE_ACTIONS.ByReference byReference = new Winsvc.SERVICE_FAILURE_ACTIONS.ByReference();
        byReference.dwResetPeriod = i;
        byReference.lpRebootMsg = str;
        byReference.lpCommand = str2;
        byReference.cActions = list.size();
        byReference.lpsaActions = new Winsvc.SC_ACTION.ByReference();
        Winsvc.SC_ACTION[] sc_actionArr = (Winsvc.SC_ACTION[]) byReference.lpsaActions.toArray(list.size());
        boolean z = false;
        int i2 = 0;
        for (Winsvc.SC_ACTION sc_action : list) {
            if (!z && sc_action.type == 2) {
                addShutdownPrivilegeToProcess();
                z = true;
            }
            sc_actionArr[i2].type = sc_action.type;
            sc_actionArr[i2].delay = sc_action.delay;
            i2++;
        }
        if (!Advapi32.INSTANCE.ChangeServiceConfig2(this._handle, 2, byReference)) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
    }

    private Pointer queryServiceConfig2(int i) {
        IntByReference intByReference = new IntByReference();
        Advapi32.INSTANCE.QueryServiceConfig2(this._handle, i, Pointer.NULL, 0, intByReference);
        Memory memory = new Memory(intByReference.getValue());
        if (Advapi32.INSTANCE.QueryServiceConfig2(this._handle, i, memory, intByReference.getValue(), new IntByReference())) {
            return memory;
        }
        throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
    }

    public Winsvc.SERVICE_FAILURE_ACTIONS getFailureActions() {
        return new Winsvc.SERVICE_FAILURE_ACTIONS(queryServiceConfig2(2));
    }

    public void setFailureActionsFlag(boolean z) {
        Winsvc.SERVICE_FAILURE_ACTIONS_FLAG service_failure_actions_flag = new Winsvc.SERVICE_FAILURE_ACTIONS_FLAG();
        service_failure_actions_flag.fFailureActionsOnNonCrashFailures = z ? 1 : 0;
        if (!Advapi32.INSTANCE.ChangeServiceConfig2(this._handle, 4, service_failure_actions_flag)) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
    }

    public boolean getFailureActionsFlag() {
        return new Winsvc.SERVICE_FAILURE_ACTIONS_FLAG(queryServiceConfig2(4)).fFailureActionsOnNonCrashFailures != 0;
    }

    public Winsvc.SERVICE_STATUS_PROCESS queryStatus() {
        IntByReference intByReference = new IntByReference();
        Advapi32.INSTANCE.QueryServiceStatusEx(this._handle, 0, null, 0, intByReference);
        Winsvc.SERVICE_STATUS_PROCESS service_status_process = new Winsvc.SERVICE_STATUS_PROCESS(intByReference.getValue());
        if (Advapi32.INSTANCE.QueryServiceStatusEx(this._handle, 0, service_status_process, service_status_process.size(), intByReference)) {
            return service_status_process;
        }
        throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
    }

    public void startService() throws InterruptedException {
        waitForNonPendingState();
        if (queryStatus().dwCurrentState == 4) {
            return;
        }
        if (!Advapi32.INSTANCE.StartService(this._handle, 0, null)) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        waitForNonPendingState();
        if (queryStatus().dwCurrentState != 4) {
            throw new RuntimeException("Unable to start the service");
        }
    }

    public void stopService() throws InterruptedException {
        stopService(30000L);
    }

    public void stopService(long j) throws InterruptedException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        waitForNonPendingState();
        if (queryStatus().dwCurrentState == 1) {
            return;
        }
        Winsvc.SERVICE_STATUS service_status = new Winsvc.SERVICE_STATUS();
        if (!Advapi32.INSTANCE.ControlService(this._handle, 1, service_status)) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        while (service_status.dwCurrentState != 1) {
            long jCurrentTimeMillis2 = j - (System.currentTimeMillis() - jCurrentTimeMillis);
            if (jCurrentTimeMillis2 < 0) {
                throw new RuntimeException(String.format("Service stop exceeded timeout time of %d ms", Long.valueOf(j)));
            }
            try {
                Thread.sleep(Math.min(sanitizeWaitTime(service_status.dwWaitHint), jCurrentTimeMillis2));
                if (!Advapi32.INSTANCE.QueryServiceStatus(this._handle, service_status)) {
                    throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void continueService() throws InterruptedException {
        waitForNonPendingState();
        if (queryStatus().dwCurrentState == 4) {
            return;
        }
        if (!Advapi32.INSTANCE.ControlService(this._handle, 3, new Winsvc.SERVICE_STATUS())) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        waitForNonPendingState();
        if (queryStatus().dwCurrentState != 4) {
            throw new RuntimeException("Unable to continue the service");
        }
    }

    public void pauseService() throws InterruptedException {
        waitForNonPendingState();
        if (queryStatus().dwCurrentState == 7) {
            return;
        }
        if (!Advapi32.INSTANCE.ControlService(this._handle, 2, new Winsvc.SERVICE_STATUS())) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        waitForNonPendingState();
        if (queryStatus().dwCurrentState != 7) {
            throw new RuntimeException("Unable to pause the service");
        }
    }

    int sanitizeWaitTime(int i) {
        int i2 = i / 10;
        int i3 = 1000;
        if (i2 >= 1000) {
            i3 = 10000;
            if (i2 <= 10000) {
                return i2;
            }
        }
        return i3;
    }

    public void waitForNonPendingState() throws InterruptedException {
        Winsvc.SERVICE_STATUS_PROCESS service_status_processQueryStatus = queryStatus();
        int i = service_status_processQueryStatus.dwCheckPoint;
        int iGetTickCount = Kernel32.INSTANCE.GetTickCount();
        while (isPendingState(service_status_processQueryStatus.dwCurrentState)) {
            if (service_status_processQueryStatus.dwCheckPoint != i) {
                i = service_status_processQueryStatus.dwCheckPoint;
                iGetTickCount = Kernel32.INSTANCE.GetTickCount();
            }
            if (Kernel32.INSTANCE.GetTickCount() - iGetTickCount > service_status_processQueryStatus.dwWaitHint) {
                throw new RuntimeException("Timeout waiting for service to change to a non-pending state.");
            }
            try {
                Thread.sleep(sanitizeWaitTime(service_status_processQueryStatus.dwWaitHint));
                service_status_processQueryStatus = queryStatus();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Winsvc.SC_HANDLE getHandle() {
        return this._handle;
    }

    public Winsvc.ENUM_SERVICE_STATUS[] enumDependentServices(int i) {
        IntByReference intByReference = new IntByReference(0);
        IntByReference intByReference2 = new IntByReference(0);
        Advapi32.INSTANCE.EnumDependentServices(this._handle, i, Pointer.NULL, 0, intByReference, intByReference2);
        int iGetLastError = Kernel32.INSTANCE.GetLastError();
        if (iGetLastError != 234) {
            throw new Win32Exception(iGetLastError);
        }
        Memory memory = new Memory(intByReference.getValue());
        if (!Advapi32.INSTANCE.EnumDependentServices(this._handle, i, memory, (int) memory.size(), intByReference, intByReference2)) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        if (intByReference2.getValue() == 0) {
            return new Winsvc.ENUM_SERVICE_STATUS[0];
        }
        Winsvc.ENUM_SERVICE_STATUS enum_service_status = (Winsvc.ENUM_SERVICE_STATUS) Structure.newInstance(Winsvc.ENUM_SERVICE_STATUS.class, memory);
        enum_service_status.read();
        return (Winsvc.ENUM_SERVICE_STATUS[]) enum_service_status.toArray(intByReference2.getValue());
    }
}
