package com.android.ddmlib.internal;

import com.android.ddmlib.AndroidDebugBridge;
import com.android.ddmlib.AvdData;
import com.android.ddmlib.Client;
import com.android.ddmlib.ClientTracker;
import com.android.ddmlib.CommandFailedException;
import com.android.ddmlib.DdmPreferences;
import com.android.ddmlib.EmulatorConsole;
import com.android.ddmlib.IDevice;
import com.android.ddmlib.Log;
import com.android.ddmlib.internal.DeviceListMonitorTask;
import com.android.ddmlib.internal.commands.DisconnectCommand;
import com.android.ddmlib.internal.jdwp.JdwpProxyServer;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import java.io.IOException;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class DeviceMonitor implements ClientTracker {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long STOP_TIMEOUT_MILLIS = TimeUnit.SECONDS.toMillis(5);
    private CommandService mDdmlibCommandService;
    private Thread mDeviceClientMonitorThread;
    private DeviceListMonitorTask mDeviceListMonitorTask;
    private Thread mDeviceListMonitorThread;
    private JdwpProxyServer mJdwpProxy;
    private final MonitorErrorHandler mMonitorErrorHandler;
    private final AndroidDebugBridge mServer;
    private DeviceClientMonitorTask myDeviceClientMonitorTask;
    private final Object mDevicesGuard = new Object();
    private ImmutableList<DeviceImpl> mDevices = ImmutableList.of();

    public interface MonitorErrorHandler {
        void initializationError(Exception e);
    }

    public DeviceMonitor(AndroidDebugBridge server, MonitorErrorHandler monitorErrorHandler) {
        this.mServer = server;
        this.mMonitorErrorHandler = monitorErrorHandler;
    }

    public void start() {
        try {
            if (DdmPreferences.isJdwpProxyEnabled()) {
                JdwpProxyServer jdwpProxyServer = new JdwpProxyServer(DdmPreferences.getJdwpProxyPort(), new JdwpProxyServer.ConnectionState() { // from class: com.android.ddmlib.internal.DeviceMonitor$$ExternalSyntheticLambda0
                    @Override // com.android.ddmlib.internal.jdwp.JdwpProxyServer.ConnectionState
                    public final void changed() {
                        this.f$0.jdwpProxyChangedState();
                    }
                });
                this.mJdwpProxy = jdwpProxyServer;
                jdwpProxyServer.start();
            }
            if (DdmPreferences.isDdmlibCommandServiceEnabled()) {
                CommandService commandService = new CommandService(DdmPreferences.getDdmCommandPort());
                this.mDdmlibCommandService = commandService;
                commandService.addCommand(DisconnectCommand.COMMAND, new DisconnectCommand(this));
                this.mDdmlibCommandService.start();
            }
            this.mDeviceListMonitorTask = new DeviceListMonitorTask(this.mServer, new DeviceListUpdateListener());
            if (AndroidDebugBridge.getClientSupport()) {
                this.myDeviceClientMonitorTask = new DeviceClientMonitorTask();
                Thread thread = new Thread(this.myDeviceClientMonitorTask, "Device Client Monitor");
                this.mDeviceClientMonitorThread = thread;
                thread.start();
            }
            Thread thread2 = new Thread(this.mDeviceListMonitorTask, "Device List Monitor");
            this.mDeviceListMonitorThread = thread2;
            thread2.start();
        } catch (IOException e) {
            Log.e("DeviceMonitor", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jdwpProxyChangedState() {
        int i;
        DeviceImpl[] deviceImplArr;
        synchronized (this.mDevicesGuard) {
            deviceImplArr = (DeviceImpl[]) this.mDevices.toArray(new DeviceImpl[0]);
        }
        for (DeviceImpl deviceImpl : deviceImplArr) {
            trackDeviceToDropAndReopen(deviceImpl);
        }
    }

    public void stop() {
        JdwpProxyServer jdwpProxyServer = this.mJdwpProxy;
        if (jdwpProxyServer != null) {
            jdwpProxyServer.stop();
        }
        DeviceListMonitorTask deviceListMonitorTask = this.mDeviceListMonitorTask;
        if (deviceListMonitorTask != null) {
            deviceListMonitorTask.stop();
            try {
                Thread thread = this.mDeviceListMonitorThread;
                if (thread != null) {
                    thread.join(STOP_TIMEOUT_MILLIS);
                    this.mDeviceListMonitorThread = null;
                }
            } catch (InterruptedException e) {
                Log.e("DeviceMonitor.stop", e);
            }
        }
        DeviceClientMonitorTask deviceClientMonitorTask = this.myDeviceClientMonitorTask;
        if (deviceClientMonitorTask != null) {
            deviceClientMonitorTask.stop();
            try {
                Thread thread2 = this.mDeviceClientMonitorThread;
                if (thread2 != null) {
                    thread2.join(STOP_TIMEOUT_MILLIS);
                    this.mDeviceClientMonitorThread = null;
                }
            } catch (InterruptedException e2) {
                Log.e("DeviceMonitor.stop", e2);
            }
        }
        CommandService commandService = this.mDdmlibCommandService;
        if (commandService != null) {
            commandService.stop();
        }
    }

    public boolean isMonitoring() {
        DeviceListMonitorTask deviceListMonitorTask = this.mDeviceListMonitorTask;
        return deviceListMonitorTask != null && deviceListMonitorTask.isMonitoring();
    }

    public int getConnectionAttemptCount() {
        DeviceListMonitorTask deviceListMonitorTask = this.mDeviceListMonitorTask;
        if (deviceListMonitorTask == null) {
            return 0;
        }
        return deviceListMonitorTask.getConnectionAttemptCount();
    }

    public int getRestartAttemptCount() {
        DeviceListMonitorTask deviceListMonitorTask = this.mDeviceListMonitorTask;
        if (deviceListMonitorTask == null) {
            return 0;
        }
        return deviceListMonitorTask.getRestartAttemptCount();
    }

    public boolean hasInitialDeviceList() {
        DeviceListMonitorTask deviceListMonitorTask = this.mDeviceListMonitorTask;
        return deviceListMonitorTask != null && deviceListMonitorTask.hasInitialDeviceList();
    }

    public IDevice[] getDevices() {
        ImmutableList<DeviceImpl> immutableList;
        synchronized (this.mDevicesGuard) {
            immutableList = this.mDevices;
        }
        return (IDevice[]) immutableList.toArray(new IDevice[0]);
    }

    public void disconnectClient(IDevice device, int pid) {
        if (isMonitoring()) {
            for (Client client : device.getClients()) {
                if (client.getClientData().getPid() == pid) {
                    this.myDeviceClientMonitorTask.disconnectClient((ClientImpl) client);
                    return;
                }
            }
            return;
        }
        Log.w("ddms", "Client disconnect ignored, not currently monitoring");
    }

    AndroidDebugBridge getServer() {
        return this.mServer;
    }

    @Override // com.android.ddmlib.ClientTracker
    public void trackClientToDropAndReopen(ClientImpl client) {
        this.myDeviceClientMonitorTask.registerClientToDropAndReopen(client);
    }

    @Override // com.android.ddmlib.ClientTracker
    public void trackDisconnectedClient(ClientImpl client) {
        this.myDeviceClientMonitorTask.free(client);
    }

    @Override // com.android.ddmlib.ClientTracker
    public void trackDeviceToDropAndReopen(DeviceImpl device) {
        boolean zContains;
        synchronized (this.mDevicesGuard) {
            zContains = this.mDevices.contains(device);
        }
        if (zContains && AndroidDebugBridge.getClientSupport() && this.myDeviceClientMonitorTask != null) {
            Log.d("DeviceMonitor", "Restarting monitoring service for " + device);
            if (this.myDeviceClientMonitorTask.register(device)) {
                return;
            }
            Log.e("DeviceMonitor", "Failed to start monitoring " + device.getSerialNumber());
        }
    }

    private static ImmutableList<DeviceImpl> addRemove(Collection<DeviceImpl> original, Collection<IDevice> toAdd, Collection<IDevice> toRemove) {
        HashSet hashSetNewHashSet = Sets.newHashSet(toRemove);
        ImmutableList.Builder builder = ImmutableList.builder();
        for (DeviceImpl deviceImpl : original) {
            if (!hashSetNewHashSet.contains(deviceImpl)) {
                builder.add((ImmutableList.Builder) deviceImpl);
            }
        }
        for (IDevice iDevice : toAdd) {
            if (iDevice instanceof DeviceImpl) {
                builder.add((ImmutableList.Builder) iDevice);
            }
        }
        return builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDevices(List<DeviceImpl> newList) {
        ImmutableList<DeviceImpl> immutableList;
        synchronized (this.mDevicesGuard) {
            immutableList = this.mDevices;
        }
        DeviceListComparisonResult deviceListComparisonResultCompare = DeviceListComparisonResult.compare(immutableList, newList);
        ImmutableList<DeviceImpl> immutableListAddRemove = addRemove(immutableList, deviceListComparisonResultCompare.added, deviceListComparisonResultCompare.removed);
        synchronized (this.mDevicesGuard) {
            this.mDevices = immutableListAddRemove;
        }
        for (IDevice iDevice : deviceListComparisonResultCompare.removed) {
            removeDevice((DeviceImpl) iDevice);
            AndroidDebugBridge.deviceDisconnected(iDevice);
        }
        ArrayList<DeviceImpl> arrayListNewArrayListWithExpectedSize = Lists.newArrayListWithExpectedSize(immutableListAddRemove.size());
        for (Map.Entry<IDevice, IDevice.DeviceState> entry : deviceListComparisonResultCompare.updated.entrySet()) {
            DeviceImpl deviceImpl = (DeviceImpl) entry.getKey();
            deviceImpl.setState(entry.getValue());
            deviceImpl.update(1);
            if (deviceImpl.isOnline()) {
                arrayListNewArrayListWithExpectedSize.add(deviceImpl);
            }
        }
        for (IDevice iDevice2 : deviceListComparisonResultCompare.added) {
            AndroidDebugBridge.deviceConnected(iDevice2);
            if (iDevice2.isOnline()) {
                arrayListNewArrayListWithExpectedSize.add((DeviceImpl) iDevice2);
            }
        }
        if (AndroidDebugBridge.getClientSupport()) {
            for (DeviceImpl deviceImpl2 : arrayListNewArrayListWithExpectedSize) {
                if (!this.myDeviceClientMonitorTask.register(deviceImpl2)) {
                    Log.e("DeviceMonitor", "Failed to start monitoring " + deviceImpl2.getSerialNumber());
                }
            }
        }
        for (DeviceImpl deviceImpl3 : arrayListNewArrayListWithExpectedSize) {
            setProperties(deviceImpl3);
            deviceImpl3.getSystemProperty("ro.build.version.sdk");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeDevice(DeviceImpl device) {
        device.setState(IDevice.DeviceState.DISCONNECTED);
        device.clearClientList();
        SocketChannel clientMonitoringSocket = device.getClientMonitoringSocket();
        if (clientMonitoringSocket != null) {
            try {
                clientMonitoringSocket.close();
            } catch (IOException unused) {
            }
        }
    }

    private static void setProperties(DeviceImpl device) {
        String avdPath;
        try {
            if (!device.isEmulator()) {
                device.setAvdData(null);
                return;
            }
            EmulatorConsole console = EmulatorConsole.getConsole(device);
            if (console == null) {
                device.setAvdData(null);
                return;
            }
            String avdName = console.getAvdName();
            try {
                avdPath = console.getAvdPath();
            } catch (CommandFailedException e) {
                Log.e("DeviceMonitor", e);
                avdPath = null;
            }
            console.close();
            device.setAvdData(new AvdData(avdName, avdPath));
        } finally {
            device.setAvdData(null);
        }
    }

    private class DeviceListUpdateListener implements DeviceListMonitorTask.UpdateListener {
        private DeviceListUpdateListener() {
        }

        @Override // com.android.ddmlib.internal.DeviceListMonitorTask.UpdateListener
        public void initializationError(Exception e) {
            DeviceMonitor.this.mMonitorErrorHandler.initializationError(e);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.android.ddmlib.internal.DeviceListMonitorTask.UpdateListener
        public void listFetchError(Exception e) {
            ImmutableList immutableList;
            synchronized (DeviceMonitor.this.mDevicesGuard) {
                immutableList = DeviceMonitor.this.mDevices;
                DeviceMonitor.this.mDevices = ImmutableList.of();
            }
            UnmodifiableIterator it = immutableList.iterator();
            while (it.hasNext()) {
                DeviceImpl deviceImpl = (DeviceImpl) it.next();
                DeviceMonitor.this.removeDevice(deviceImpl);
                AndroidDebugBridge.deviceDisconnected(deviceImpl);
            }
        }

        @Override // com.android.ddmlib.internal.DeviceListMonitorTask.UpdateListener
        public void deviceListUpdate(Map<String, IDevice.DeviceState> devices) {
            ArrayList arrayListNewArrayListWithExpectedSize = Lists.newArrayListWithExpectedSize(devices.size());
            for (Map.Entry<String, IDevice.DeviceState> entry : devices.entrySet()) {
                arrayListNewArrayListWithExpectedSize.add(new DeviceImpl(DeviceMonitor.this, entry.getKey(), entry.getValue()));
            }
            DeviceMonitor.this.updateDevices(arrayListNewArrayListWithExpectedSize);
        }
    }

    public static class DeviceListComparisonResult {
        public final List<IDevice> added;
        public final List<IDevice> removed;
        public final Map<IDevice, IDevice.DeviceState> updated;

        private DeviceListComparisonResult(Map<IDevice, IDevice.DeviceState> updated, List<IDevice> added, List<IDevice> removed) {
            this.updated = updated;
            this.added = added;
            this.removed = removed;
        }

        public static DeviceListComparisonResult compare(List<? extends IDevice> previous, List<? extends IDevice> current) {
            ArrayList arrayListNewArrayList = Lists.newArrayList(current);
            HashMap mapNewHashMapWithExpectedSize = Maps.newHashMapWithExpectedSize(arrayListNewArrayList.size());
            ArrayList arrayListNewArrayListWithExpectedSize = Lists.newArrayListWithExpectedSize(1);
            ArrayList arrayListNewArrayListWithExpectedSize2 = Lists.newArrayListWithExpectedSize(1);
            for (IDevice iDevice : previous) {
                IDevice iDeviceFind = find(arrayListNewArrayList, iDevice);
                if (iDeviceFind != null) {
                    if (iDeviceFind.getState() != iDevice.getState()) {
                        mapNewHashMapWithExpectedSize.put(iDevice, iDeviceFind.getState());
                    }
                    arrayListNewArrayList.remove(iDeviceFind);
                } else {
                    arrayListNewArrayListWithExpectedSize2.add(iDevice);
                }
            }
            arrayListNewArrayListWithExpectedSize.addAll(arrayListNewArrayList);
            return new DeviceListComparisonResult(mapNewHashMapWithExpectedSize, arrayListNewArrayListWithExpectedSize, arrayListNewArrayListWithExpectedSize2);
        }

        private static IDevice find(List<? extends IDevice> devices, IDevice device) {
            for (IDevice iDevice : devices) {
                if (iDevice.getSerialNumber().equals(device.getSerialNumber())) {
                    return iDevice;
                }
            }
            return null;
        }
    }
}
