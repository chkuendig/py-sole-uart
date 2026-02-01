package com.android.ddmlib.internal;

import com.android.ddmlib.AdbCommandRejectedException;
import com.android.ddmlib.AdbHelper;
import com.android.ddmlib.AndroidDebugBridge;
import com.android.ddmlib.ClientData;
import com.android.ddmlib.DdmPreferences;
import com.android.ddmlib.Log;
import com.android.ddmlib.TimeoutException;
import com.android.ddmlib.internal.DeviceClientMonitorTask;
import com.android.server.adb.protos.AppProcessesProto;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.Uninterruptibles;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;

/* loaded from: classes3.dex */
class DeviceClientMonitorTask implements Runnable {
    private volatile boolean mQuit;
    private final ConcurrentHashMap<SocketChannel, TrackServiceProcessor> mChannelsToRegister = new ConcurrentHashMap<>();
    private final Set<ClientImpl> mClientsToReopen = new HashSet();
    private final Selector mSelector = Selector.open();

    void free(ClientImpl client) {
    }

    DeviceClientMonitorTask() throws IOException {
    }

    boolean register(DeviceImpl device) {
        TrackServiceProcessor trackJdwpProcessor;
        try {
            SocketChannel socketChannelOpenConnection = AndroidDebugBridge.openConnection();
            if (socketChannelOpenConnection != null) {
                try {
                    try {
                        if (isDeviceVersionAtLeastS(device)) {
                            trackJdwpProcessor = new TrackAppProcessor(device);
                        } else {
                            trackJdwpProcessor = new TrackJdwpProcessor(device);
                        }
                        if (sendDeviceMonitoringRequest(socketChannelOpenConnection, trackJdwpProcessor)) {
                            device.setClientMonitoringSocket(socketChannelOpenConnection);
                            socketChannelOpenConnection.configureBlocking(false);
                            this.mChannelsToRegister.put(socketChannelOpenConnection, trackJdwpProcessor);
                            this.mSelector.wakeup();
                            return true;
                        }
                    } catch (IOException unused) {
                        Log.d("DeviceClientMonitorTask", "Connection Failure when starting to monitor device '" + device + "' : timeout");
                        return false;
                    }
                } catch (AdbCommandRejectedException e) {
                    try {
                        socketChannelOpenConnection.close();
                    } catch (IOException unused2) {
                    }
                    Log.d("DeviceClientMonitorTask", "Adb refused to start monitoring device '" + device + "' : " + e.getMessage());
                } catch (TimeoutException unused3) {
                    socketChannelOpenConnection.close();
                    Log.d("DeviceClientMonitorTask", "Connection Failure when starting to monitor device '" + device + "' : timeout");
                } catch (IOException e2) {
                    try {
                        socketChannelOpenConnection.close();
                    } catch (IOException unused4) {
                    }
                    Log.d("DeviceClientMonitorTask", "Connection Failure when starting to monitor device '" + device + "' : " + e2.getMessage());
                }
            }
            return false;
        } catch (IOException e3) {
            Log.e("DeviceClientMonitorTask", "Unable to open connection to ADB server: " + e3);
            return false;
        }
    }

    void registerClientToDropAndReopen(ClientImpl client) {
        synchronized (this.mClientsToReopen) {
            Log.d("DeviceClientMonitorTask", "Adding " + client + " to list of client to reopen (" + client.getDebuggerListenPort() + ").");
            this.mClientsToReopen.add(client);
        }
        this.mSelector.wakeup();
    }

    private void processDropAndReopenClients() {
        synchronized (this.mClientsToReopen) {
            MonitorThread monitorThread = MonitorThread.getInstance();
            for (ClientImpl clientImpl : this.mClientsToReopen) {
                DeviceImpl deviceImpl = (DeviceImpl) clientImpl.getDevice();
                int pid = clientImpl.getClientData().getPid();
                monitorThread.dropClient(clientImpl, false);
                Uninterruptibles.sleepUninterruptibly(1L, TimeUnit.SECONDS);
                Log.d("DeviceClientMonitorTask", "Reopening " + clientImpl);
                openClient(deviceImpl, pid, monitorThread);
                deviceImpl.update(2);
            }
            this.mClientsToReopen.clear();
        }
    }

    void processChannelsToRegister() {
        for (SocketChannel socketChannel : Collections.list(this.mChannelsToRegister.keys())) {
            try {
                try {
                    socketChannel.register(this.mSelector, 1, this.mChannelsToRegister.get(socketChannel));
                } catch (ClosedChannelException unused) {
                    Log.w("DeviceClientMonitorTask", "Cannot register already-closed channel.");
                }
            } finally {
                this.mChannelsToRegister.keySet().remove(socketChannel);
            }
        }
    }

    void disconnectClient(ClientImpl client) {
        MonitorThread monitorThread = MonitorThread.getInstance();
        if (monitorThread != null) {
            monitorThread.dropClient(client, true);
        }
    }

    @Override // java.lang.Runnable
    public void run() throws IOException {
        Processor processor;
        SocketChannel socket;
        do {
            try {
                int iSelect = this.mSelector.select();
                if (this.mQuit) {
                    return;
                }
                processChannelsToRegister();
                processDropAndReopenClients();
                if (iSelect != 0) {
                    Iterator<SelectionKey> it = this.mSelector.selectedKeys().iterator();
                    while (it.hasNext()) {
                        SelectionKey next = it.next();
                        it.remove();
                        if (next.isValid() && next.isReadable()) {
                            Object objAttachment = next.attachment();
                            if ((objAttachment instanceof Processor) && (socket = (processor = (Processor) objAttachment).getSocket()) != null) {
                                try {
                                    processor.processIncomingData();
                                } catch (IOException e) {
                                    Log.d("DeviceClientMonitorTask", "Error reading incoming data: " + e.getMessage());
                                    try {
                                        socket.close();
                                    } catch (IOException unused) {
                                    }
                                    if (processor instanceof TrackServiceProcessor) {
                                        this.mChannelsToRegister.remove(socket);
                                        DeviceImpl device = processor.getDevice();
                                        device.getClientTracker().trackDeviceToDropAndReopen(device);
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (IOException e2) {
                Log.e("DeviceClientMonitorTask", "Connection error while monitoring clients.");
                Log.d("DeviceClientMonitorTask", e2);
                return;
            }
        } while (!this.mQuit);
    }

    public void stop() {
        this.mQuit = true;
        this.mSelector.wakeup();
    }

    private boolean sendDeviceMonitoringRequest(SocketChannel socket, TrackServiceProcessor processor) throws IOException, TimeoutException, AdbCommandRejectedException {
        try {
            AdbHelper.setDevice(socket, processor.getDevice());
            AdbHelper.write(socket, AdbHelper.formAdbRequest(processor.getCommand()));
            AdbHelper.AdbResponse adbResponse = AdbHelper.readAdbResponse(socket, false);
            if (!adbResponse.okay) {
                Log.e("DeviceClientMonitorTask", "adb refused request: " + adbResponse.message);
            }
            return adbResponse.okay;
        } catch (TimeoutException e) {
            Log.e("DeviceClientMonitorTask", "Sending jdwp tracking request timed out!");
            throw e;
        } catch (IOException e2) {
            Log.e("DeviceClientMonitorTask", "Sending jdwp tracking request failed!");
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateJdwpClients(DeviceImpl device, Set<Integer> newPids) {
        MonitorThread monitorThread = MonitorThread.getInstance();
        List<ClientImpl> clientList = device.getClientList();
        HashMap map = new HashMap();
        synchronized (clientList) {
            for (ClientImpl clientImpl : clientList) {
                map.put(Integer.valueOf(clientImpl.getClientData().getPid()), clientImpl);
            }
        }
        HashSet hashSet = new HashSet();
        for (Integer num : map.keySet()) {
            if (!newPids.contains(num)) {
                hashSet.add((ClientImpl) map.get(num));
            }
        }
        HashSet hashSet2 = new HashSet(newPids);
        hashSet2.removeAll(map.keySet());
        monitorThread.dropClients(hashSet, false);
        Iterator it = hashSet2.iterator();
        while (it.hasNext()) {
            openClient(device, ((Integer) it.next()).intValue(), monitorThread);
        }
        if (hashSet2.isEmpty() && hashSet.isEmpty()) {
            return;
        }
        AndroidDebugBridge.deviceChanged(device, 2);
    }

    private static void openClient(DeviceImpl device, int pid, MonitorThread monitorThread) {
        SocketChannel socketChannelCreatePassThroughConnection;
        try {
            if (DdmPreferences.isJdwpProxyEnabled()) {
                socketChannelCreatePassThroughConnection = AdbHelper.createPassThroughConnection(new InetSocketAddress("localhost", DdmPreferences.getJdwpProxyPort()), device.getSerialNumber(), pid);
            } else {
                socketChannelCreatePassThroughConnection = AdbHelper.createPassThroughConnection(AndroidDebugBridge.getSocketAddress(), device.getSerialNumber(), pid);
            }
            socketChannelCreatePassThroughConnection.configureBlocking(false);
            createClient(device, pid, socketChannelCreatePassThroughConnection, monitorThread);
        } catch (AdbCommandRejectedException e) {
            Log.d("DeviceClientMonitorTask", "Adb rejected connection to client '" + pid + "': " + e.getMessage());
        } catch (TimeoutException unused) {
            Log.w("DeviceClientMonitorTask", "Failed to connect to client '" + pid + "': timeout");
        } catch (UnknownHostException unused2) {
            Log.d("DeviceClientMonitorTask", "Unknown Jdwp pid: " + pid);
        } catch (IOException e2) {
            Log.w("DeviceClientMonitorTask", "Failed to connect to client '" + pid + "': " + e2.getMessage());
        }
    }

    private static void createClient(DeviceImpl device, int pid, SocketChannel socket, MonitorThread monitorThread) {
        ClientImpl clientImpl = new ClientImpl(device, socket, pid);
        if (clientImpl.sendHandshake()) {
            try {
                if (AndroidDebugBridge.getClientSupport()) {
                    clientImpl.listenForDebugger();
                    Log.d("ddms", String.format(Locale.US, "Opening a debugger listener at port %1$d for client with pid %2$d", Integer.valueOf(clientImpl.getDebuggerListenPort()), Integer.valueOf(pid)));
                }
            } catch (IOException unused) {
                clientImpl.getClientData().setDebuggerConnectionStatus(ClientData.DebuggerStatus.ERROR);
                Log.e("ddms", "Can't bind to local " + clientImpl.getDebuggerListenPort() + " for debugger");
            }
            clientImpl.requestAllocationStatus();
        } else {
            Log.e("ddms", "Handshake with " + clientImpl + " failed!");
        }
        if (clientImpl.isValid()) {
            device.addClient(clientImpl);
            monitorThread.addClient(clientImpl);
        }
    }

    private static boolean isDeviceVersionAtLeastS(DeviceImpl device) {
        return device.getVersion().getFeatureLevel() >= 31;
    }

    private abstract class Processor {
        final DeviceImpl mDevice;

        abstract SocketChannel getSocket();

        abstract void processIncomingData() throws IOException;

        Processor(DeviceImpl device) {
            this.mDevice = device;
        }

        DeviceImpl getDevice() {
            return this.mDevice;
        }
    }

    private abstract class TrackServiceProcessor extends Processor {
        abstract String getCommand();

        TrackServiceProcessor(DeviceImpl device) {
            super(device);
        }

        @Override // com.android.ddmlib.internal.DeviceClientMonitorTask.Processor
        SocketChannel getSocket() {
            return getDevice().getClientMonitoringSocket();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class TrackAppProcessor extends TrackServiceProcessor {
        TrackAppProcessor(DeviceImpl device) {
            super(device);
        }

        @Override // com.android.ddmlib.internal.DeviceClientMonitorTask.TrackServiceProcessor
        String getCommand() {
            return "track-app";
        }

        @Override // com.android.ddmlib.internal.DeviceClientMonitorTask.Processor
        void processIncomingData() throws IOException {
            if (getSocket() == null) {
                return;
            }
            int length = AdbSocketUtils.readLength(getSocket(), new byte[4]);
            if (length < 0) {
                return;
            }
            AppProcessesProto.AppProcesses from = AppProcessesProto.AppProcesses.parseFrom(AdbSocketUtils.read(getSocket(), length));
            HashSet hashSet = new HashSet();
            HashMap map = new HashMap();
            for (AppProcessesProto.ProcessEntry processEntry : from.getProcessList()) {
                if (processEntry.getDebuggable()) {
                    hashSet.add(Integer.valueOf((int) processEntry.getPid()));
                }
                if (processEntry.getProfileable() || processEntry.getDebuggable()) {
                    map.put(Integer.valueOf((int) processEntry.getPid()), new ProfileableClientImpl((int) processEntry.getPid(), "", processEntry.getArchitecture()));
                }
            }
            DeviceClientMonitorTask.this.updateJdwpClients(getDevice(), hashSet);
            updateProfileableClients(getDevice(), map);
        }

        void updateProfileableClients(DeviceImpl device, final Map<Integer, ProfileableClientImpl> currentProfileable) {
            HashMap map = new HashMap();
            for (ProfileableClientImpl profileableClientImpl : device.getProfileableClients()) {
                map.put(Integer.valueOf(profileableClientImpl.getProfileableClientData().getPid()), profileableClientImpl);
            }
            Sets.SetView setViewDifference = Sets.difference(currentProfileable.keySet(), map.keySet());
            Sets.SetView setViewDifference2 = Sets.difference(map.keySet(), currentProfileable.keySet());
            if (setViewDifference.isEmpty() && setViewDifference2.isEmpty()) {
                return;
            }
            final TreeSet treeSetNewTreeSet = Sets.newTreeSet(setViewDifference);
            map.forEach(new BiConsumer() { // from class: com.android.ddmlib.internal.DeviceClientMonitorTask$TrackAppProcessor$$ExternalSyntheticLambda0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    DeviceClientMonitorTask.TrackAppProcessor.lambda$updateProfileableClients$0(currentProfileable, treeSetNewTreeSet, (Integer) obj, (ProfileableClientImpl) obj2);
                }
            });
            findProcessJdwpNames(device, currentProfileable, treeSetNewTreeSet);
            device.updateProfileableClientList(Lists.newArrayList(currentProfileable.values()));
            AndroidDebugBridge.deviceChanged(device, 8);
            Iterator<Integer> it = treeSetNewTreeSet.iterator();
            while (it.hasNext()) {
                new CmdlineFileProcessor(DeviceClientMonitorTask.this, device, it.next().intValue()).connect();
            }
        }

        static /* synthetic */ void lambda$updateProfileableClients$0(Map map, Set set, Integer num, ProfileableClientImpl profileableClientImpl) {
            if (map.containsKey(num)) {
                String processName = profileableClientImpl.getProfileableClientData().getProcessName();
                if (processName != null && !processName.isEmpty()) {
                    ((ProfileableClientImpl) map.get(num)).getProfileableClientData().setProcessName(processName);
                } else {
                    set.add(num);
                }
            }
        }

        private void findProcessJdwpNames(DeviceImpl device, Map<Integer, ProfileableClientImpl> pidClientMap, Set<Integer> pidsWithoutNames) {
            HashMap map = new HashMap();
            for (ClientImpl clientImpl : device.getClients()) {
                ClientData clientData = clientImpl.getClientData();
                map.put(Integer.valueOf(clientData.getPid()), clientData.getPackageName());
            }
            Iterator it = Sets.newTreeSet(pidsWithoutNames).iterator();
            while (it.hasNext()) {
                Integer num = (Integer) it.next();
                String str = (String) map.get(num);
                if (str != null && !str.isEmpty()) {
                    pidClientMap.get(num).getProfileableClientData().setProcessName(str);
                    pidsWithoutNames.remove(num);
                }
            }
        }
    }

    private class TrackJdwpProcessor extends TrackServiceProcessor {
        TrackJdwpProcessor(DeviceImpl device) {
            super(device);
        }

        @Override // com.android.ddmlib.internal.DeviceClientMonitorTask.TrackServiceProcessor
        String getCommand() {
            return "track-jdwp";
        }

        @Override // com.android.ddmlib.internal.DeviceClientMonitorTask.Processor
        void processIncomingData() throws IOException {
            if (getSocket() == null) {
                return;
            }
            int length = AdbSocketUtils.readLength(getSocket(), new byte[4]);
            if (length >= 0) {
                HashSet hashSet = new HashSet();
                if (length > 0) {
                    for (String str : AdbSocketUtils.read(getSocket(), new byte[length]).split("\n")) {
                        try {
                            hashSet.add(Integer.valueOf(str));
                        } catch (NumberFormatException unused) {
                        }
                    }
                }
                DeviceClientMonitorTask.this.updateJdwpClients(getDevice(), hashSet);
            }
        }
    }

    private class CmdlineFileProcessor extends Processor {
        private final int mPid;
        private int mRetryCount;
        SocketChannel mSocket;

        CmdlineFileProcessor(final DeviceClientMonitorTask this$0, DeviceImpl device, int pid) {
            this(device, pid, 5);
        }

        CmdlineFileProcessor(DeviceImpl device, int pid, int retryCount) {
            super(device);
            this.mPid = pid;
            this.mRetryCount = retryCount;
        }

        void connect() {
            if (this.mRetryCount <= 0) {
                Log.w("DeviceClientMonitorTask", "Unexpected cmdline file for PID " + this.mPid);
                return;
            }
            try {
                this.mSocket = getDevice().rawExec("cat", new String[]{"/proc/" + this.mPid + "/cmdline"});
            } catch (AdbCommandRejectedException | TimeoutException | IOException unused) {
            }
            SocketChannel socketChannel = this.mSocket;
            if (socketChannel != null) {
                try {
                    socketChannel.register(DeviceClientMonitorTask.this.mSelector, 1, this);
                    return;
                } catch (ClosedChannelException unused2) {
                    Log.w("DeviceClientMonitorTask", "Cannot register already-closed channel to read the name for PID " + this.mPid);
                    return;
                }
            }
            Log.w("DeviceClientMonitorTask", "Cannot register null socket for PID " + this.mPid);
        }

        @Override // com.android.ddmlib.internal.DeviceClientMonitorTask.Processor
        SocketChannel getSocket() {
            return this.mSocket;
        }

        @Override // com.android.ddmlib.internal.DeviceClientMonitorTask.Processor
        void processIncomingData() throws IOException {
            SocketChannel socketChannel = this.mSocket;
            if (socketChannel == null) {
                return;
            }
            String nullTerminatedString = AdbSocketUtils.readNullTerminatedString(socketChannel);
            this.mSocket.close();
            if (nullTerminatedString.equals(ClientData.PRE_INITIALIZED)) {
                DeviceClientMonitorTask deviceClientMonitorTask = DeviceClientMonitorTask.this;
                DeviceImpl device = getDevice();
                int i = this.mPid;
                int i2 = this.mRetryCount - 1;
                this.mRetryCount = i2;
                deviceClientMonitorTask.new CmdlineFileProcessor(device, i, i2).connect();
                return;
            }
            if (nullTerminatedString.contains("No such file or directory")) {
                return;
            }
            getDevice().updateProfileableClientName(this.mPid, nullTerminatedString);
            AndroidDebugBridge.deviceChanged(getDevice(), 8);
        }
    }
}
