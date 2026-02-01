package com.android.ddmlib;

import com.android.SdkConstants;
import com.android.ddmlib.Log;
import com.android.ddmlib.internal.ClientImpl;
import com.android.ddmlib.internal.DeviceMonitor;
import com.android.ddmlib.internal.MonitorThread;
import com.android.ddmlib.internal.jdwp.chunkhandler.HandleAppName;
import com.android.ddmlib.internal.jdwp.chunkhandler.HandleHeap;
import com.android.ddmlib.internal.jdwp.chunkhandler.HandleHello;
import com.android.ddmlib.internal.jdwp.chunkhandler.HandleNativeHeap;
import com.android.ddmlib.internal.jdwp.chunkhandler.HandleProfiling;
import com.android.ddmlib.internal.jdwp.chunkhandler.HandleTest;
import com.android.ddmlib.internal.jdwp.chunkhandler.HandleThread;
import com.android.ddmlib.internal.jdwp.chunkhandler.HandleViewDebug;
import com.android.ddmlib.internal.jdwp.chunkhandler.HandleWait;
import com.android.prefs.AndroidLocation;
import com.facebook.internal.ServerProtocol;
import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import com.google.common.io.Closeables;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.SettableFuture;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Thread;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

/* loaded from: classes3.dex */
public class AndroidDebugBridge {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String ADB = "adb";
    private static final String DDMS = "ddms";
    static final int DEFAULT_ADB_PORT = 5037;
    public static final int DEFAULT_START_ADB_TIMEOUT_MILLIS = 20000;
    private static final String SERVER_PORT_ENV_VAR = "ANDROID_ADB_SERVER_PORT";
    private static final int STATUS_DLL_NOT_FOUND = -1073741515;
    private static Map<String, String> sAdbEnvVars;
    private static boolean sClientSupport;
    private static InetSocketAddress sLastKnownGoodAddress;
    private static AndroidDebugBridge sThis;
    private static boolean sUnitTestMode;
    private String mAdbOsLocation;
    private AdbVersion mAdbVersion;
    private DeviceMonitor mDeviceMonitor;
    private boolean mStarted;
    private boolean mVersionCheck;
    public static final AdbVersion MIN_ADB_VERSION = AdbVersion.parseFrom("1.0.20");
    private static int sAdbServerPort = 0;
    private static boolean sUserManagedAdbMode = false;
    private static final Object sLastKnownGoodAddressLock = new Object();
    private static boolean sInitialized = false;
    private static final Object sLock = new Object();
    private static final Set<IDebugBridgeChangeListener> sBridgeListeners = Sets.newCopyOnWriteArraySet();
    private static final Set<IDeviceChangeListener> sDeviceListeners = Sets.newCopyOnWriteArraySet();
    private static final Set<IClientChangeListener> sClientListeners = Sets.newCopyOnWriteArraySet();

    interface AdbOutputProcessor<T> {
        T process(Process process, BufferedReader r) throws IOException;
    }

    public interface IClientChangeListener {
        void clientChanged(Client client, int changeMask);
    }

    public interface IDebugBridgeChangeListener {
        void bridgeChanged(AndroidDebugBridge bridge);

        default void initializationError(Exception exception) {
        }

        default void restartCompleted(boolean isSuccessful) {
        }

        default void restartInitiated() {
        }
    }

    public interface IDeviceChangeListener {
        void deviceChanged(IDevice device, int changeMask);

        void deviceConnected(IDevice device);

        void deviceDisconnected(IDevice device);
    }

    @Deprecated
    public static synchronized void initIfNeeded(boolean clientSupport) {
        if (sInitialized) {
            return;
        }
        init(clientSupport);
    }

    public static synchronized void init(boolean clientSupport) {
        init(clientSupport, false, ImmutableMap.of());
    }

    public static synchronized void init(boolean clientSupport, boolean useLibusb, Map<String, String> env) {
        init(AdbInitOptions.builder().withEnv(env).setClientSupportEnabled(clientSupport).withEnv("ADB_LIBUSB", useLibusb ? "1" : "0").build());
    }

    public static synchronized void init(AdbInitOptions options) {
        Preconditions.checkState(!sInitialized, "AndroidDebugBridge.init() has already been called.");
        sInitialized = true;
        sClientSupport = options.clientSupport;
        sAdbEnvVars = options.adbEnvVars;
        sUserManagedAdbMode = options.userManagedAdbMode;
        sLastKnownGoodAddress = null;
        DdmPreferences.enableJdwpProxyService(options.useJdwpProxyService);
        DdmPreferences.enableDdmlibCommandService(options.useDdmlibCommandService);
        DdmPreferences.setsJdwpMaxPacketSize(options.maxJdwpPacketSize);
        initAdbPort(options.userManagedAdbPort);
        MonitorThread monitorThreadCreateInstance = MonitorThread.createInstance();
        monitorThreadCreateInstance.start();
        HandleHello.register(monitorThreadCreateInstance);
        HandleAppName.register(monitorThreadCreateInstance);
        HandleTest.register(monitorThreadCreateInstance);
        HandleThread.register(monitorThreadCreateInstance);
        HandleHeap.register(monitorThreadCreateInstance);
        HandleWait.register(monitorThreadCreateInstance);
        HandleProfiling.register(monitorThreadCreateInstance);
        HandleNativeHeap.register(monitorThreadCreateInstance);
        HandleViewDebug.register(monitorThreadCreateInstance);
    }

    public static synchronized boolean optionsChanged(AdbInitOptions options, String osLocation, boolean forceNewBridge, long terminateTimeout, long initTimeout, TimeUnit unit) {
        if (!sInitialized) {
            return true;
        }
        boolean z = getBridge() != null;
        if (z && !disconnectBridge(terminateTimeout, unit)) {
            Log.e(DDMS, "Could not disconnect bridge prior to restart when options changed.");
            return false;
        }
        terminate();
        init(options);
        if (!z || createBridge(osLocation, forceNewBridge, initTimeout, unit) != null) {
            return true;
        }
        Log.e(DDMS, "Could not recreate the bridge after options changed.");
        return false;
    }

    public static void enableFakeAdbServerMode(int port) {
        Preconditions.checkState(!sInitialized, "AndroidDebugBridge.init() has already been called or terminate() has not been called yet.");
        sUnitTestMode = true;
        sAdbServerPort = port;
    }

    public static void disableFakeAdbServerMode() {
        Preconditions.checkState(!sInitialized, "AndroidDebugBridge.init() has already been called or terminate() has not been called yet.");
        sUnitTestMode = false;
        sAdbServerPort = 0;
    }

    public static synchronized void terminate() {
        DeviceMonitor deviceMonitor;
        AndroidDebugBridge androidDebugBridge = sThis;
        if (androidDebugBridge != null && (deviceMonitor = androidDebugBridge.mDeviceMonitor) != null) {
            deviceMonitor.stop();
            sThis.mDeviceMonitor = null;
        }
        MonitorThread monitorThread = MonitorThread.getInstance();
        if (monitorThread != null) {
            monitorThread.quit();
        }
        sInitialized = false;
        sThis = null;
        sLastKnownGoodAddress = null;
    }

    public static boolean getClientSupport() {
        return sClientSupport;
    }

    @Deprecated
    public static InetSocketAddress getSocketAddress() {
        if (!sUnitTestMode) {
            synchronized (sLastKnownGoodAddressLock) {
                InetSocketAddress inetSocketAddress = sLastKnownGoodAddress;
                if (inetSocketAddress != null) {
                    return inetSocketAddress;
                }
                try {
                    SocketChannel socketChannelOpenConnection = openConnection();
                    try {
                        InetSocketAddress inetSocketAddress2 = (InetSocketAddress) socketChannelOpenConnection.getRemoteAddress();
                        sLastKnownGoodAddress = inetSocketAddress2;
                        if (socketChannelOpenConnection != null) {
                            socketChannelOpenConnection.close();
                        }
                        return inetSocketAddress2;
                    } catch (Throwable th) {
                        if (socketChannelOpenConnection != null) {
                            try {
                                socketChannelOpenConnection.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                } catch (IOException unused) {
                }
            }
        }
        return new InetSocketAddress(InetAddress.getLoopbackAddress(), sAdbServerPort);
    }

    public static SocketChannel openConnection() throws IOException {
        SocketChannel socketChannelOpen;
        try {
            socketChannelOpen = SocketChannel.open(new InetSocketAddress(DdmPreferences.DEFAULT_ADBHOST_VALUE, sAdbServerPort));
        } catch (IOException e) {
            try {
                socketChannelOpen = SocketChannel.open(new InetSocketAddress("::1", sAdbServerPort));
            } catch (IOException e2) {
                IOException iOException = new IOException("Can't find adb server on port " + sAdbServerPort + ", IPv4 attempt: " + e.getMessage() + ", IPv6 attempt: " + e2.getMessage(), e);
                iOException.addSuppressed(e2);
                throw iOException;
            }
        }
        socketChannelOpen.socket().setTcpNoDelay(true);
        return socketChannelOpen;
    }

    @Deprecated
    public static AndroidDebugBridge createBridge() {
        return createBridge(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
    }

    public static AndroidDebugBridge createBridge(long timeout, TimeUnit unit) {
        synchronized (sLock) {
            AndroidDebugBridge androidDebugBridge = sThis;
            if (androidDebugBridge != null) {
                return androidDebugBridge;
            }
            try {
                AndroidDebugBridge androidDebugBridge2 = new AndroidDebugBridge();
                if (!androidDebugBridge2.start(timeout, unit)) {
                    return null;
                }
                sThis = androidDebugBridge2;
                Iterator<IDebugBridgeChangeListener> it = sBridgeListeners.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().bridgeChanged(androidDebugBridge2);
                    } catch (Throwable th) {
                        Log.e(DDMS, th);
                    }
                }
                return androidDebugBridge2;
            } catch (InvalidParameterException unused) {
                return null;
            }
        }
    }

    @Deprecated
    public static AndroidDebugBridge createBridge(String osLocation, boolean forceNewBridge) {
        return createBridge(osLocation, forceNewBridge, Long.MAX_VALUE, TimeUnit.MILLISECONDS);
    }

    public static AndroidDebugBridge createBridge(String osLocation, boolean forceNewBridge, long timeout, TimeUnit unit) {
        AndroidDebugBridge androidDebugBridge;
        synchronized (sLock) {
            TimeoutRemainder timeoutRemainder = new TimeoutRemainder(timeout, unit);
            AndroidDebugBridge androidDebugBridge2 = null;
            if (!sUnitTestMode && (androidDebugBridge = sThis) != null) {
                String str = androidDebugBridge.mAdbOsLocation;
                if (str != null && str.equals(osLocation) && !forceNewBridge) {
                    return sThis;
                }
                if (!sThis.stop(timeoutRemainder.getRemainingNanos(), TimeUnit.NANOSECONDS)) {
                    return null;
                }
                sThis = null;
            }
            try {
                AndroidDebugBridge androidDebugBridge3 = new AndroidDebugBridge(osLocation);
                if (androidDebugBridge3.start(timeoutRemainder.getRemainingNanos(), TimeUnit.NANOSECONDS)) {
                    androidDebugBridge2 = androidDebugBridge3;
                }
            } catch (InvalidParameterException unused) {
            }
            sThis = androidDebugBridge2;
            Iterator<IDebugBridgeChangeListener> it = sBridgeListeners.iterator();
            while (it.hasNext()) {
                try {
                    it.next().bridgeChanged(androidDebugBridge2);
                } catch (Throwable th) {
                    Log.e(DDMS, th);
                }
            }
            return androidDebugBridge2;
        }
    }

    public static AndroidDebugBridge getBridge() {
        return sThis;
    }

    @Deprecated
    public static void disconnectBridge() {
        disconnectBridge(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
    }

    public static boolean disconnectBridge(long timeout, TimeUnit unit) {
        synchronized (sLock) {
            AndroidDebugBridge androidDebugBridge = sThis;
            if (androidDebugBridge != null) {
                if (!androidDebugBridge.stop(timeout, unit)) {
                    return false;
                }
                sThis = null;
            }
            Iterator<IDebugBridgeChangeListener> it = sBridgeListeners.iterator();
            while (it.hasNext()) {
                try {
                    it.next().bridgeChanged(null);
                } catch (Throwable th) {
                    Log.e(DDMS, th);
                }
            }
            return true;
        }
    }

    public static void addDebugBridgeChangeListener(IDebugBridgeChangeListener listener) {
        AndroidDebugBridge androidDebugBridge;
        sBridgeListeners.add(listener);
        synchronized (sLock) {
            androidDebugBridge = sThis;
        }
        if (androidDebugBridge != null) {
            try {
                listener.bridgeChanged(androidDebugBridge);
            } catch (Throwable th) {
                Log.e(DDMS, th);
            }
        }
    }

    public static void removeDebugBridgeChangeListener(IDebugBridgeChangeListener listener) {
        sBridgeListeners.remove(listener);
    }

    public static int getDebugBridgeChangeListenerCount() {
        return sBridgeListeners.size();
    }

    public static void addDeviceChangeListener(IDeviceChangeListener listener) {
        sDeviceListeners.add(listener);
    }

    public static void removeDeviceChangeListener(IDeviceChangeListener listener) {
        sDeviceListeners.remove(listener);
    }

    public static int getDeviceChangeListenerCount() {
        return sDeviceListeners.size();
    }

    public static void addClientChangeListener(IClientChangeListener listener) {
        sClientListeners.add(listener);
    }

    public static void removeClientChangeListener(IClientChangeListener listener) {
        sClientListeners.remove(listener);
    }

    public AdbVersion getCurrentAdbVersion() {
        return this.mAdbVersion;
    }

    public IDevice[] getDevices() {
        synchronized (sLock) {
            DeviceMonitor deviceMonitor = this.mDeviceMonitor;
            if (deviceMonitor != null) {
                return deviceMonitor.getDevices();
            }
            return new IDevice[0];
        }
    }

    public boolean hasInitialDeviceList() {
        DeviceMonitor deviceMonitor = this.mDeviceMonitor;
        if (deviceMonitor != null) {
            return deviceMonitor.hasInitialDeviceList();
        }
        return false;
    }

    public boolean isConnected() {
        MonitorThread monitorThread = MonitorThread.getInstance();
        DeviceMonitor deviceMonitor = this.mDeviceMonitor;
        return (deviceMonitor == null || monitorThread == null || !deviceMonitor.isMonitoring() || monitorThread.getState() == Thread.State.TERMINATED) ? false : true;
    }

    public int getConnectionAttemptCount() {
        DeviceMonitor deviceMonitor = this.mDeviceMonitor;
        if (deviceMonitor != null) {
            return deviceMonitor.getConnectionAttemptCount();
        }
        return -1;
    }

    public int getRestartAttemptCount() {
        DeviceMonitor deviceMonitor = this.mDeviceMonitor;
        if (deviceMonitor != null) {
            return deviceMonitor.getRestartAttemptCount();
        }
        return -1;
    }

    private AndroidDebugBridge(String osLocation) throws Throwable {
        this.mAdbOsLocation = null;
        this.mStarted = false;
        if (osLocation == null || osLocation.isEmpty()) {
            throw new InvalidParameterException();
        }
        this.mAdbOsLocation = osLocation;
        try {
            AdbVersion adbVersionFetchAdbVersion = fetchAdbVersion();
            this.mAdbVersion = adbVersionFetchAdbVersion;
            this.mVersionCheck = checkAdbVersion(adbVersionFetchAdbVersion);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private AndroidDebugBridge() {
        this.mAdbOsLocation = null;
        this.mStarted = false;
    }

    private AdbVersion fetchAdbVersion() throws Throwable {
        if (this.mAdbOsLocation == null) {
            return null;
        }
        try {
            return getAdbVersion(new File(this.mAdbOsLocation)).get(20000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            return null;
        } catch (ExecutionException e) {
            Log.logAndDisplay(Log.LogLevel.ERROR, ADB, e.getCause().getMessage());
            Throwables.propagateIfInstanceOf(e.getCause(), IOException.class);
            return null;
        } catch (java.util.concurrent.TimeoutException unused2) {
            Log.logAndDisplay(Log.LogLevel.ERROR, ADB, "Unable to obtain result of 'adb version'");
            return null;
        }
    }

    private static boolean checkAdbVersion(AdbVersion adbVersion) {
        if (adbVersion == null) {
            Log.logAndDisplay(Log.LogLevel.ERROR, ADB, "Could not determine adb version.");
        } else {
            AdbVersion adbVersion2 = MIN_ADB_VERSION;
            if (adbVersion.compareTo(adbVersion2) > 0) {
                return true;
            }
            Log.logAndDisplay(Log.LogLevel.ERROR, ADB, String.format("Required minimum version of adb: %1$s.Current version is %2$s", adbVersion2, adbVersion));
        }
        return false;
    }

    @Deprecated
    private static <T> ListenableFuture<T> runAdb(final File adb, final AdbOutputProcessor<T> resultParser, final String... command) {
        final SettableFuture settableFutureCreate = SettableFuture.create();
        new Thread(new Runnable() { // from class: com.android.ddmlib.AndroidDebugBridge$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                AndroidDebugBridge.lambda$runAdb$0(adb, command, settableFutureCreate, resultParser);
            }
        }, "Running adb").start();
        return settableFutureCreate;
    }

    static /* synthetic */ void lambda$runAdb$0(File file, String[] strArr, SettableFuture settableFuture, AdbOutputProcessor adbOutputProcessor) throws IOException {
        ArrayList arrayList = new ArrayList();
        arrayList.add(file.getPath());
        arrayList.addAll(Arrays.asList(strArr));
        ProcessBuilder processBuilder = new ProcessBuilder(arrayList);
        processBuilder.redirectErrorStream(true);
        try {
            Process processStart = processBuilder.start();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(processStart.getInputStream()));
                try {
                    settableFuture.set(adbOutputProcessor.process(processStart, bufferedReader));
                    bufferedReader.close();
                } catch (Throwable th) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException e) {
                settableFuture.setException(e);
            } catch (RuntimeException e2) {
                settableFuture.setException(e2);
            }
        } catch (IOException e3) {
            settableFuture.setException(e3);
        }
    }

    public static ListenableFuture<AdbVersion> getAdbVersion(final File adb) {
        return runAdb(adb, new AdbOutputProcessor() { // from class: com.android.ddmlib.AndroidDebugBridge$$ExternalSyntheticLambda1
            @Override // com.android.ddmlib.AndroidDebugBridge.AdbOutputProcessor
            public final Object process(Process process, BufferedReader bufferedReader) {
                return AndroidDebugBridge.lambda$getAdbVersion$1(process, bufferedReader);
            }
        }, ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION);
    }

    static /* synthetic */ AdbVersion lambda$getAdbVersion$1(Process process, BufferedReader bufferedReader) throws IOException {
        String str;
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (line != null) {
                AdbVersion from = AdbVersion.parseFrom(line);
                if (from != AdbVersion.UNKNOWN) {
                    return from;
                }
                sb.append(line);
                sb.append('\n');
            } else {
                int iExitValue = process.exitValue();
                if (iExitValue == 0) {
                    str = "Unable to detect adb version";
                } else {
                    str = "Unable to detect adb version, exit value: 0x" + Integer.toHexString(iExitValue);
                    if (iExitValue == STATUS_DLL_NOT_FOUND && SdkConstants.currentPlatform() == 2) {
                        throw new RuntimeException(str + ". ADB depends on the Windows Universal C Runtime, which is usually installed by default via Windows Update. You may need to manually fetch and install the runtime package here: https://support.microsoft.com/en-ca/help/2999226/update-for-universal-c-runtime-in-windows");
                    }
                }
                if (sb.length() > 0) {
                    str = str + ", adb output: " + sb.toString();
                }
                throw new RuntimeException(str);
            }
        }
    }

    private static ListenableFuture<List<AdbDevice>> getRawDeviceList(final File adb) {
        return runAdb(adb, new AdbOutputProcessor() { // from class: com.android.ddmlib.AndroidDebugBridge$$ExternalSyntheticLambda0
            @Override // com.android.ddmlib.AndroidDebugBridge.AdbOutputProcessor
            public final Object process(Process process, BufferedReader bufferedReader) {
                return AndroidDebugBridge.lambda$getRawDeviceList$2(process, bufferedReader);
            }
        }, "devices", "-l");
    }

    static /* synthetic */ List lambda$getRawDeviceList$2(Process process, BufferedReader bufferedReader) throws IOException {
        bufferedReader.readLine();
        ArrayList arrayList = new ArrayList();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return arrayList;
            }
            AdbDevice adbLine = AdbDevice.parseAdbLine(line);
            if (adbLine != null) {
                arrayList.add(adbLine);
            }
        }
    }

    public static ListenableFuture<String> getVirtualDeviceId(ListeningExecutorService service, File adb, IDevice device) {
        return execute(service, Arrays.asList(adb.toString(), "-s", device.getSerialNumber(), "emu", AndroidLocation.FOLDER_AVD, "id"), new AdbOutputProcessor() { // from class: com.android.ddmlib.AndroidDebugBridge$$ExternalSyntheticLambda5
            @Override // com.android.ddmlib.AndroidDebugBridge.AdbOutputProcessor
            public final Object process(Process process, BufferedReader bufferedReader) {
                return AndroidDebugBridge.processVirtualDeviceIdCommandOutput(process, bufferedReader);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String processVirtualDeviceIdCommandOutput(Process process, BufferedReader reader) {
        List list = (List) reader.lines().collect(Collectors.toList());
        return (list.size() == 2 && ((String) list.get(1)).equals("OK")) ? (String) list.get(0) : "";
    }

    private static <T> ListenableFuture<T> execute(ListeningExecutorService service, final List<String> command, final AdbOutputProcessor<T> processor) {
        return service.submit((Callable) new Callable() { // from class: com.android.ddmlib.AndroidDebugBridge$$ExternalSyntheticLambda4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return AndroidDebugBridge.lambda$execute$3(command, processor);
            }
        });
    }

    static /* synthetic */ Object lambda$execute$3(List list, AdbOutputProcessor adbOutputProcessor) throws Exception {
        ProcessBuilder processBuilder = new ProcessBuilder((List<String>) list);
        processBuilder.redirectErrorStream(true);
        Process processStart = processBuilder.start();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(processStart.getInputStream(), StandardCharsets.UTF_8));
        try {
            Object objProcess = adbOutputProcessor.process(processStart, bufferedReader);
            bufferedReader.close();
            return objProcess;
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public ListenableFuture<List<AdbDevice>> getRawDeviceList() {
        if (this.mAdbOsLocation == null) {
            SettableFuture settableFutureCreate = SettableFuture.create();
            settableFutureCreate.set(Collections.emptyList());
            return settableFutureCreate;
        }
        return getRawDeviceList(new File(this.mAdbOsLocation));
    }

    boolean start(long timeout, TimeUnit unit) {
        if (!sUserManagedAdbMode && this.mAdbOsLocation != null && sAdbServerPort != 0 && (!this.mVersionCheck || !startAdb(timeout, unit))) {
            return false;
        }
        this.mStarted = true;
        DeviceMonitor deviceMonitor = new DeviceMonitor(this, new MonitorErrorHandler());
        this.mDeviceMonitor = deviceMonitor;
        deviceMonitor.start();
        return true;
    }

    boolean stop(long timeout, TimeUnit unit) {
        if (!this.mStarted) {
            return true;
        }
        TimeoutRemainder timeoutRemainder = new TimeoutRemainder(timeout, unit);
        DeviceMonitor deviceMonitor = this.mDeviceMonitor;
        if (deviceMonitor != null) {
            deviceMonitor.stop();
            this.mDeviceMonitor = null;
        }
        if (sUserManagedAdbMode) {
            Log.i(DDMS, "User managed ADB mode: Not stopping ADB server");
        } else if (!stopAdb(timeoutRemainder.getRemainingNanos(), TimeUnit.NANOSECONDS)) {
            return false;
        }
        this.mStarted = false;
        return true;
    }

    @Deprecated
    public boolean restart() {
        return restart(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
    }

    public boolean restart(long timeout, TimeUnit unit) {
        boolean zStopAdb;
        if (sUserManagedAdbMode) {
            Log.e(ADB, "Cannot restart adb when using user managed ADB server.");
            return false;
        }
        if (this.mAdbOsLocation == null) {
            Log.e(ADB, "Cannot restart adb when AndroidDebugBridge is created without the location of adb.");
            return false;
        }
        if (sAdbServerPort == 0) {
            Log.e(ADB, "ADB server port for restarting AndroidDebugBridge is not set.");
            return false;
        }
        if (!this.mVersionCheck) {
            Log.logAndDisplay(Log.LogLevel.ERROR, ADB, "Attempting to restart adb, but version check failed!");
            return false;
        }
        TimeoutRemainder timeoutRemainder = new TimeoutRemainder(timeout, unit);
        Iterator<IDebugBridgeChangeListener> it = sBridgeListeners.iterator();
        while (it.hasNext()) {
            try {
                it.next().restartInitiated();
            } catch (Throwable th) {
                Log.e(DDMS, th);
            }
        }
        synchronized (this) {
            zStopAdb = stopAdb(timeoutRemainder.getRemainingNanos(), TimeUnit.NANOSECONDS);
            if (!zStopAdb) {
                Log.w(ADB, "Error stopping ADB without specified timeout");
            }
            if (zStopAdb) {
                zStopAdb = startAdb(timeoutRemainder.getRemainingNanos(), TimeUnit.NANOSECONDS);
            }
            if (zStopAdb && this.mDeviceMonitor == null) {
                DeviceMonitor deviceMonitor = new DeviceMonitor(this, new MonitorErrorHandler());
                this.mDeviceMonitor = deviceMonitor;
                deviceMonitor.start();
            }
        }
        Iterator<IDebugBridgeChangeListener> it2 = sBridgeListeners.iterator();
        while (it2.hasNext()) {
            try {
                it2.next().restartCompleted(zStopAdb);
            } catch (Throwable th2) {
                Log.e(DDMS, th2);
            }
        }
        return zStopAdb;
    }

    public static void deviceConnected(IDevice device) {
        Iterator<IDeviceChangeListener> it = sDeviceListeners.iterator();
        while (it.hasNext()) {
            try {
                it.next().deviceConnected(device);
            } catch (Throwable th) {
                Log.e(DDMS, th);
            }
        }
    }

    public static void deviceDisconnected(IDevice device) {
        Iterator<IDeviceChangeListener> it = sDeviceListeners.iterator();
        while (it.hasNext()) {
            try {
                it.next().deviceDisconnected(device);
            } catch (Throwable th) {
                Log.e(DDMS, th);
            }
        }
    }

    public static void deviceChanged(IDevice device, int changeMask) {
        Iterator<IDeviceChangeListener> it = sDeviceListeners.iterator();
        while (it.hasNext()) {
            try {
                it.next().deviceChanged(device, changeMask);
            } catch (Throwable th) {
                Log.e(DDMS, th);
            }
        }
    }

    public static void clientChanged(ClientImpl client, int changeMask) {
        Iterator<IClientChangeListener> it = sClientListeners.iterator();
        while (it.hasNext()) {
            try {
                it.next().clientChanged(client, changeMask);
            } catch (Throwable th) {
                Log.e(DDMS, th);
            }
        }
    }

    public static boolean isUserManagedAdbMode() {
        return sUserManagedAdbMode;
    }

    public synchronized boolean startAdb(long timeout, TimeUnit unit) {
        int iGrabProcessOutput;
        String adbHostValue;
        if (sUserManagedAdbMode) {
            Log.e(ADB, "startADB should never be called when using user managed ADB server.");
            return false;
        }
        if (sUnitTestMode) {
            return true;
        }
        if (this.mAdbOsLocation == null) {
            Log.e(ADB, "Cannot start adb when AndroidDebugBridge is created without the location of adb.");
            return false;
        }
        if (sAdbServerPort == 0) {
            Log.w(ADB, "ADB server port for starting AndroidDebugBridge is not set.");
            return false;
        }
        String[] adbLaunchCommand = getAdbLaunchCommand("start-server");
        String strJoin = Joiner.on(' ').join(adbLaunchCommand);
        try {
            Log.d(DDMS, String.format("Launching '%1$s' to ensure ADB is running.", strJoin));
            ProcessBuilder processBuilder = new ProcessBuilder(adbLaunchCommand);
            final Map<String, String> mapEnvironment = processBuilder.environment();
            Map<String, String> map = sAdbEnvVars;
            Objects.requireNonNull(mapEnvironment);
            map.forEach(new BiConsumer() { // from class: com.android.ddmlib.AndroidDebugBridge$$ExternalSyntheticLambda2
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    mapEnvironment.put((String) obj, (String) obj2);
                }
            });
            if (DdmPreferences.getUseAdbHost() && (adbHostValue = DdmPreferences.getAdbHostValue()) != null && !adbHostValue.isEmpty()) {
                mapEnvironment.put("ADBHOST", adbHostValue);
            }
            iGrabProcessOutput = grabProcessOutput(processBuilder.start(), new ArrayList(), new ArrayList(), false, timeout, unit);
        } catch (IOException | InterruptedException e) {
            Log.e(DDMS, "Unable to run 'adb': " + e.getMessage());
            iGrabProcessOutput = -1;
        }
        if (iGrabProcessOutput != 0) {
            Log.e(DDMS, String.format("'%1$s' failed -- run manually if necessary", strJoin));
            return false;
        }
        Log.d(DDMS, String.format("'%1$s' succeeded", strJoin));
        return true;
    }

    private String[] getAdbLaunchCommand(String option) {
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(this.mAdbOsLocation);
        if (sAdbServerPort != 5037) {
            arrayList.add("-P");
            arrayList.add(Integer.toString(sAdbServerPort));
        }
        arrayList.add(option);
        return (String[]) arrayList.toArray(new String[0]);
    }

    private synchronized boolean stopAdb(long timeout, TimeUnit unit) {
        if (sUserManagedAdbMode) {
            Log.e(ADB, "stopADB should never be called when using user managed ADB server.");
            return false;
        }
        if (this.mAdbOsLocation == null) {
            Log.e(ADB, "Cannot stop adb when AndroidDebugBridge is created without the location of adb.");
            return false;
        }
        if (sAdbServerPort == 0) {
            Log.e(ADB, "ADB server port for restarting AndroidDebugBridge is not set");
            return false;
        }
        String[] adbLaunchCommand = getAdbLaunchCommand("kill-server");
        int iExitValue = -1;
        try {
            Process processExec = Runtime.getRuntime().exec(adbLaunchCommand);
            if (processExec.waitFor(timeout, unit)) {
                iExitValue = processExec.exitValue();
            } else {
                processExec.destroy();
            }
        } catch (IOException | InterruptedException unused) {
        }
        String strJoin = Joiner.on(' ').join(adbLaunchCommand);
        if (iExitValue != 0) {
            Log.w(DDMS, String.format("'%1$s' failed -- run manually if necessary", strJoin));
            return false;
        }
        Log.d(DDMS, String.format("'%1$s' succeeded", strJoin));
        return true;
    }

    private static int grabProcessOutput(final Process process, final ArrayList<String> errorOutput, final ArrayList<String> stdOutput, boolean waitForReaders, long timeout, TimeUnit unit) throws InterruptedException {
        TimeoutRemainder timeoutRemainder = new TimeoutRemainder(timeout, unit);
        Thread thread = new Thread("adb:stderr reader") { // from class: com.android.ddmlib.AndroidDebugBridge.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getErrorStream(), Charsets.UTF_8));
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        Log.e(AndroidDebugBridge.ADB, line);
                        errorOutput.add(line);
                    } catch (IOException unused) {
                    } catch (Throwable th) {
                        Closeables.closeQuietly(bufferedReader);
                        throw th;
                    }
                }
                Closeables.closeQuietly(bufferedReader);
            }
        };
        Thread thread2 = new Thread("adb:stdout reader") { // from class: com.android.ddmlib.AndroidDebugBridge.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream(), Charsets.UTF_8));
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        Log.d(AndroidDebugBridge.ADB, line);
                        stdOutput.add(line);
                    } catch (IOException unused) {
                    } catch (Throwable th) {
                        Closeables.closeQuietly(bufferedReader);
                        throw th;
                    }
                }
                Closeables.closeQuietly(bufferedReader);
            }
        };
        thread.start();
        thread2.start();
        if (waitForReaders) {
            try {
                long remainingUnits = timeoutRemainder.getRemainingUnits(TimeUnit.MILLISECONDS);
                if (remainingUnits > 0) {
                    thread.join(remainingUnits);
                }
            } catch (InterruptedException unused) {
            }
            long remainingUnits2 = timeoutRemainder.getRemainingUnits(TimeUnit.MILLISECONDS);
            if (remainingUnits2 > 0) {
                try {
                    thread2.join(remainingUnits2);
                } catch (InterruptedException unused2) {
                }
            }
        }
        if (process.waitFor(timeoutRemainder.getRemainingNanos(), TimeUnit.NANOSECONDS)) {
            return process.exitValue();
        }
        Log.w(ADB, "Process did not terminate within specified timeout, killing it");
        process.destroyForcibly();
        return -1;
    }

    private static void initAdbPort(int userManagedAdbPort) {
        if (sUnitTestMode) {
            return;
        }
        if (sUserManagedAdbMode) {
            sAdbServerPort = userManagedAdbPort;
        } else {
            sAdbServerPort = getAdbServerPort();
        }
    }

    private static int getAdbServerPort() {
        Integer integer = Integer.getInteger(SERVER_PORT_ENV_VAR);
        if (integer != null) {
            try {
                return validateAdbServerPort(integer.toString());
            } catch (IllegalArgumentException unused) {
                Log.w(DDMS, String.format("Invalid value (%1$s) for ANDROID_ADB_SERVER_PORT system property.", integer));
            }
        }
        try {
            String str = System.getenv(SERVER_PORT_ENV_VAR);
            if (str != null) {
                return validateAdbServerPort(str);
            }
            return 5037;
        } catch (IllegalArgumentException e) {
            Log.w(DDMS, String.format("Invalid value (%1$s) for ANDROID_ADB_SERVER_PORT environment variable (%2$s).", integer, e.getMessage()));
            return 5037;
        } catch (SecurityException unused2) {
            Log.w(DDMS, "No access to env variables allowed by current security manager. If you've set ANDROID_ADB_SERVER_PORT: it's being ignored.");
            return 5037;
        }
    }

    private static int validateAdbServerPort(String adbServerPort) throws IllegalArgumentException {
        try {
            int iIntValue = Integer.decode(adbServerPort).intValue();
            if (iIntValue <= 0 || iIntValue >= 65535) {
                throw new IllegalArgumentException("Should be > 0 and < 65535");
            }
            return iIntValue;
        } catch (NumberFormatException unused) {
            throw new IllegalArgumentException("Not a valid port number");
        }
    }

    private static class MonitorErrorHandler implements DeviceMonitor.MonitorErrorHandler {
        private MonitorErrorHandler() {
        }

        @Override // com.android.ddmlib.internal.DeviceMonitor.MonitorErrorHandler
        public void initializationError(Exception e) {
            Iterator it = AndroidDebugBridge.sBridgeListeners.iterator();
            while (it.hasNext()) {
                try {
                    ((IDebugBridgeChangeListener) it.next()).initializationError(e);
                } catch (Throwable th) {
                    Log.e(AndroidDebugBridge.DDMS, th);
                }
            }
        }
    }
}
