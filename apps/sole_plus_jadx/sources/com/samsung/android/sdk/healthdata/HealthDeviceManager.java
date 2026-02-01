package com.samsung.android.sdk.healthdata;

import android.os.RemoteException;
import com.samsung.android.sdk.internal.healthdata.ErrorUtil;
import com.samsung.android.sdk.internal.healthdata.RemoteConnectionException;
import java.util.List;

/* loaded from: classes5.dex */
public class HealthDeviceManager {
    private final HealthDataStore a;

    public HealthDeviceManager(HealthDataStore healthDataStore) {
        this.a = healthDataStore;
    }

    private void a(String str) {
        if (str == null) {
            throw new IllegalArgumentException(ErrorUtil.getNullArgumentMessage());
        }
    }

    private IDeviceManager b() {
        try {
            IDeviceManager iDeviceManager = HealthDataStore.getInterface(this.a).getIDeviceManager();
            if (iDeviceManager != null) {
                return iDeviceManager;
            }
            throw new IllegalStateException("IDeviceManager is null");
        } catch (RemoteException e) {
            throw new RemoteConnectionException(ErrorUtil.getRemoteExceptionMessage(e));
        }
    }

    public boolean changeCustomName(String str, String str2) {
        a(str);
        a(str2);
        a();
        try {
            return b().changeDeviceName(str, str2);
        } catch (RemoteException e) {
            throw new RemoteConnectionException(ErrorUtil.getRemoteExceptionMessage(e));
        }
    }

    public List<HealthDevice> getAllDevices() {
        a();
        try {
            return b().getAllRegisteredDevices();
        } catch (RemoteException e) {
            throw new RemoteConnectionException(ErrorUtil.getRemoteExceptionMessage(e));
        }
    }

    public HealthDevice getDeviceBySeed(String str) {
        a(str);
        a();
        try {
            return b().getRegisteredDevice(str);
        } catch (RemoteException e) {
            throw new RemoteConnectionException(ErrorUtil.getRemoteExceptionMessage(e));
        }
    }

    public HealthDevice getDeviceByUuid(String str) {
        a(str);
        a();
        try {
            return b().getRegisteredDeviceByUuid(str);
        } catch (RemoteException e) {
            throw new RemoteConnectionException(ErrorUtil.getRemoteExceptionMessage(e));
        }
    }

    public List<String> getDeviceUuidsByCustomName(String str) {
        a(str);
        a();
        try {
            return b().getDeviceUuidsBy(str, 1);
        } catch (RemoteException e) {
            throw new RemoteConnectionException(ErrorUtil.getRemoteExceptionMessage(e));
        }
    }

    public List<String> getDeviceUuidsByGroup(int i) {
        a();
        try {
            return b().getDeviceUuidsBy(Integer.toString(i), 0);
        } catch (RemoteException e) {
            throw new RemoteConnectionException(ErrorUtil.getRemoteExceptionMessage(e));
        }
    }

    public List<String> getDeviceUuidsByManufacturer(String str) {
        a(str);
        a();
        try {
            return b().getDeviceUuidsBy(str, 3);
        } catch (RemoteException e) {
            throw new RemoteConnectionException(ErrorUtil.getRemoteExceptionMessage(e));
        }
    }

    public List<String> getDeviceUuidsByModel(String str) {
        a(str);
        a();
        try {
            return b().getDeviceUuidsBy(str, 2);
        } catch (RemoteException e) {
            throw new RemoteConnectionException(ErrorUtil.getRemoteExceptionMessage(e));
        }
    }

    public HealthDevice getLocalDevice() {
        a();
        try {
            return b().getLocalDevice();
        } catch (RemoteException e) {
            throw new RemoteConnectionException(ErrorUtil.getRemoteExceptionMessage(e));
        }
    }

    public String registerDevice(HealthDevice healthDevice) {
        if (healthDevice == null) {
            throw new IllegalArgumentException(ErrorUtil.getNullArgumentMessage());
        }
        IDeviceManager iDeviceManagerB = b();
        a();
        try {
            return iDeviceManagerB.registerDevice(healthDevice);
        } catch (RemoteException e) {
            throw new RemoteConnectionException(ErrorUtil.getRemoteExceptionMessage(e));
        }
    }

    private void a() {
        if (b() == null) {
            throw new IllegalStateException("Illegal store connection state");
        }
    }
}
