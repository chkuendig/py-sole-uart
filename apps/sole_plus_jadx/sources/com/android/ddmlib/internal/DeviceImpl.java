package com.android.ddmlib.internal;

import com.android.ddmlib.AdbCommandRejectedException;
import com.android.ddmlib.AdbHelper;
import com.android.ddmlib.AndroidDebugBridge;
import com.android.ddmlib.AvdData;
import com.android.ddmlib.ClientData;
import com.android.ddmlib.ClientTracker;
import com.android.ddmlib.CollectingOutputReceiver;
import com.android.ddmlib.DdmPreferences;
import com.android.ddmlib.FileListingService;
import com.android.ddmlib.IDevice;
import com.android.ddmlib.IShellOutputReceiver;
import com.android.ddmlib.InstallException;
import com.android.ddmlib.InstallMetrics;
import com.android.ddmlib.InstallReceiver;
import com.android.ddmlib.Log;
import com.android.ddmlib.MultiLineReceiver;
import com.android.ddmlib.NullOutputReceiver;
import com.android.ddmlib.PropertyFetcher;
import com.android.ddmlib.RawImage;
import com.android.ddmlib.RemoteSplitApkInstaller;
import com.android.ddmlib.ScreenRecorderOptions;
import com.android.ddmlib.ShellCommandUnresponsiveException;
import com.android.ddmlib.SplitApkInstaller;
import com.android.ddmlib.SyncException;
import com.android.ddmlib.SyncService;
import com.android.ddmlib.log.LogReceiver;
import com.android.sdklib.AndroidVersion;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Atomics;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.ToIntFunction;

/* loaded from: classes3.dex */
public final class DeviceImpl implements IDevice {
    private static final long GET_PROP_TIMEOUT_MS = 1000;
    private static final long INITIAL_GET_PROP_TIMEOUT_MS = 5000;
    private static final long INSTALL_TIMEOUT_MINUTES;
    private static final String LOG_TAG = "Device";
    private static final long LS_TIMEOUT_SEC = 2;
    private static final int QUERY_IS_ROOT_TIMEOUT_MS = 1000;
    private static final String SCREEN_RECORDER_DEVICE_PATH = "/system/bin/screenrecord";
    private static final char SEPARATOR = '-';
    private InstallMetrics lastInstallMetrics;
    private Set<String> mAdbFeatures;
    private final ClientTracker mClientTracer;
    private Set<String> mHardwareCharacteristics;
    private Boolean mHasScreenRecorder;
    private boolean mIsRoot;
    private String mName;
    private final String mSerialNumber;
    private SocketChannel mSocketChannel;
    private IDevice.DeviceState mState;
    private AndroidVersion mVersion;
    private final SettableFuture<AvdData> mAvdData = SettableFuture.create();
    private final PropertyFetcher mPropFetcher = new PropertyFetcher(this);
    private final Map<String, String> mMountPoints = new HashMap();
    private final BatteryFetcher mBatteryFetcher = new BatteryFetcher(this);
    private final List<ClientImpl> mClients = new ArrayList();
    private final Map<Integer, String> mClientInfo = new ConcurrentHashMap();
    private final List<ProfileableClientImpl> mProfileableClients = new ArrayList();

    static {
        long j;
        String str = System.getenv("ADB_INSTALL_TIMEOUT");
        if (str != null) {
            try {
                j = Long.parseLong(str);
            } catch (NumberFormatException unused) {
            }
        } else {
            j = 4;
        }
        INSTALL_TIMEOUT_MINUTES = j;
    }

    @Override // com.android.ddmlib.IDevice
    public String getSerialNumber() {
        return this.mSerialNumber;
    }

    @Override // com.android.ddmlib.IDevice
    public String getAvdName() {
        AvdData currentAvdData = getCurrentAvdData();
        if (currentAvdData != null) {
            return currentAvdData.getName();
        }
        return null;
    }

    @Override // com.android.ddmlib.IDevice
    public String getAvdPath() {
        AvdData currentAvdData = getCurrentAvdData();
        if (currentAvdData != null) {
            return currentAvdData.getPath();
        }
        return null;
    }

    private AvdData getCurrentAvdData() {
        try {
            if (this.mAvdData.isDone()) {
                return this.mAvdData.get();
            }
            return null;
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }

    @Override // com.android.ddmlib.IDevice
    public ListenableFuture<AvdData> getAvdData() {
        return this.mAvdData;
    }

    void setAvdData(AvdData data) {
        this.mAvdData.set(data);
    }

    @Override // com.android.ddmlib.IShellEnabledDevice
    public String getName() {
        String str = this.mName;
        if (str != null) {
            return str;
        }
        if (isOnline()) {
            String strConstructName = constructName();
            this.mName = strConstructName;
            return strConstructName;
        }
        return constructName();
    }

    private String constructName() {
        String strCleanupStringForDisplay;
        if (isEmulator()) {
            String avdName = getAvdName();
            if (avdName != null) {
                return String.format("%s [%s]", avdName, getSerialNumber());
            }
            return getSerialNumber();
        }
        String strCleanupStringForDisplay2 = null;
        try {
            strCleanupStringForDisplay = cleanupStringForDisplay(getProperty(IDevice.PROP_DEVICE_MANUFACTURER));
            try {
                strCleanupStringForDisplay2 = cleanupStringForDisplay(getProperty(IDevice.PROP_DEVICE_MODEL));
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            strCleanupStringForDisplay = null;
        }
        StringBuilder sb = new StringBuilder(20);
        if (strCleanupStringForDisplay != null) {
            sb.append(strCleanupStringForDisplay);
            sb.append('-');
        }
        if (strCleanupStringForDisplay2 != null) {
            sb.append(strCleanupStringForDisplay2);
            sb.append('-');
        }
        sb.append(getSerialNumber());
        return sb.toString();
    }

    private static String cleanupStringForDisplay(String s) {
        if (s == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); i++) {
            char cCharAt = s.charAt(i);
            if (Character.isLetterOrDigit(cCharAt)) {
                sb.append(Character.toLowerCase(cCharAt));
            } else {
                sb.append('_');
            }
        }
        return sb.toString();
    }

    @Override // com.android.ddmlib.IDevice
    public IDevice.DeviceState getState() {
        return this.mState;
    }

    void setState(IDevice.DeviceState state) {
        this.mState = state;
    }

    @Override // com.android.ddmlib.IDevice
    public Map<String, String> getProperties() {
        return Collections.unmodifiableMap(this.mPropFetcher.getProperties());
    }

    @Override // com.android.ddmlib.IDevice
    public int getPropertyCount() {
        return this.mPropFetcher.getProperties().size();
    }

    @Override // com.android.ddmlib.IDevice
    public String getProperty(String name) {
        try {
            return this.mPropFetcher.getProperty(name).get(this.mPropFetcher.getProperties().isEmpty() ? 5000L : 1000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException unused) {
            return null;
        }
    }

    @Override // com.android.ddmlib.IDevice
    public boolean arePropertiesSet() {
        return this.mPropFetcher.arePropertiesSet();
    }

    @Override // com.android.ddmlib.IDevice
    public String getPropertyCacheOrSync(String name) {
        try {
            return this.mPropFetcher.getProperty(name).get();
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }

    @Override // com.android.ddmlib.IDevice
    public String getPropertySync(String name) {
        try {
            return this.mPropFetcher.getProperty(name).get();
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }

    @Override // com.android.ddmlib.IShellEnabledDevice
    public ListenableFuture<String> getSystemProperty(String name) {
        return this.mPropFetcher.getProperty(name);
    }

    /* renamed from: com.android.ddmlib.internal.DeviceImpl$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$android$ddmlib$IDevice$Feature;

        static {
            int[] iArr = new int[IDevice.Feature.values().length];
            $SwitchMap$com$android$ddmlib$IDevice$Feature = iArr;
            try {
                iArr[IDevice.Feature.SCREEN_RECORD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$android$ddmlib$IDevice$Feature[IDevice.Feature.PROCSTATS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$android$ddmlib$IDevice$Feature[IDevice.Feature.ABB_EXEC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$android$ddmlib$IDevice$Feature[IDevice.Feature.REAL_PKG_NAME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$android$ddmlib$IDevice$Feature[IDevice.Feature.SKIP_VERIFICATION.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$android$ddmlib$IDevice$Feature[IDevice.Feature.SHELL_V2.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    @Override // com.android.ddmlib.IDevice
    public boolean supportsFeature(IDevice.Feature feature) {
        String property;
        switch (AnonymousClass2.$SwitchMap$com$android$ddmlib$IDevice$Feature[feature.ordinal()]) {
            case 1:
                if ((supportsFeature(IDevice.HardwareFeature.WATCH) && !getVersion().isGreaterOrEqualThan(30)) || !getVersion().isGreaterOrEqualThan(19)) {
                    return false;
                }
                if (this.mHasScreenRecorder == null) {
                    this.mHasScreenRecorder = Boolean.valueOf(hasBinary(SCREEN_RECORDER_DEVICE_PATH));
                }
                return this.mHasScreenRecorder.booleanValue();
            case 2:
                return getVersion().isGreaterOrEqualThan(19);
            case 3:
                return getAdbFeatures().contains("abb_exec");
            case 4:
                return getVersion().compareTo(29, "R") >= 0;
            case 5:
                if (getVersion().compareTo(30, null) >= 0) {
                    return true;
                }
                if (getVersion().compareTo(29, "R") >= 0 && (property = getProperty("ro.build.version.preview_sdk")) != null) {
                    try {
                        return Integer.parseInt(property) > 1;
                    } catch (NumberFormatException unused) {
                    }
                }
                return false;
            case 6:
                return getAdbFeatures().contains("shell_v2");
            default:
                return false;
        }
    }

    Set<String> getAdbFeatures() {
        Set<String> set = this.mAdbFeatures;
        if (set != null) {
            return set;
        }
        try {
            this.mAdbFeatures = new HashSet(Arrays.asList(AdbHelper.getFeatures(this).split(",")));
            this.mAdbFeatures.retainAll(Arrays.asList(AdbHelper.getHostFeatures().split(",")));
            return this.mAdbFeatures;
        } catch (AdbCommandRejectedException | com.android.ddmlib.TimeoutException | IOException e) {
            Log.e(LOG_TAG, "Error obtaining features: " + e);
            return new HashSet();
        }
    }

    @Override // com.android.ddmlib.IDevice
    public boolean supportsFeature(IDevice.HardwareFeature feature) {
        try {
            return getHardwareCharacteristics().contains(feature.getCharacteristic());
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.android.ddmlib.IDevice
    public AndroidVersion getVersion() {
        AndroidVersion androidVersion = this.mVersion;
        if (androidVersion != null) {
            return androidVersion;
        }
        try {
            String property = getProperty("ro.build.version.sdk");
            if (property == null) {
                return AndroidVersion.DEFAULT;
            }
            AndroidVersion androidVersion2 = new AndroidVersion(Integer.parseInt(property), getProperty(IDevice.PROP_BUILD_CODENAME));
            this.mVersion = androidVersion2;
            return androidVersion2;
        } catch (Exception unused) {
            return AndroidVersion.DEFAULT;
        }
    }

    private boolean hasBinary(String path) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        try {
            executeShellCommand("ls " + path, new CollectingOutputReceiver(countDownLatch), 2L, TimeUnit.SECONDS);
            countDownLatch.await(2L, TimeUnit.SECONDS);
            return !r9.getOutput().trim().endsWith("No such file or directory");
        } catch (InterruptedException | Exception unused) {
            return false;
        }
    }

    @Override // com.android.ddmlib.IDevice
    public String getMountPoint(String name) {
        String strQueryMountPoint = this.mMountPoints.get(name);
        if (strQueryMountPoint != null) {
            return strQueryMountPoint;
        }
        try {
            strQueryMountPoint = queryMountPoint(name);
            this.mMountPoints.put(name, strQueryMountPoint);
            return strQueryMountPoint;
        } catch (AdbCommandRejectedException | ShellCommandUnresponsiveException | com.android.ddmlib.TimeoutException | IOException unused) {
            return strQueryMountPoint;
        }
    }

    private String queryMountPoint(final String name) throws Throwable {
        final AtomicReference atomicReferenceNewReference = Atomics.newReference();
        executeShellCommand("echo $" + name, new MultiLineReceiver() { // from class: com.android.ddmlib.internal.DeviceImpl.1
            @Override // com.android.ddmlib.IShellOutputReceiver
            public boolean isCancelled() {
                return false;
            }

            @Override // com.android.ddmlib.MultiLineReceiver
            public void processNewLines(String[] lines) {
                for (String str : lines) {
                    if (!str.isEmpty()) {
                        atomicReferenceNewReference.set(str);
                    }
                }
            }
        });
        return (String) atomicReferenceNewReference.get();
    }

    public String toString() {
        return this.mSerialNumber;
    }

    @Override // com.android.ddmlib.IDevice
    public boolean isOnline() {
        return this.mState == IDevice.DeviceState.ONLINE;
    }

    @Override // com.android.ddmlib.IDevice
    public boolean isEmulator() {
        return this.mSerialNumber.matches(IDevice.RE_EMULATOR_SN);
    }

    @Override // com.android.ddmlib.IDevice
    public boolean isOffline() {
        return this.mState == IDevice.DeviceState.OFFLINE;
    }

    @Override // com.android.ddmlib.IDevice
    public boolean isBootLoader() {
        return this.mState == IDevice.DeviceState.BOOTLOADER;
    }

    @Override // com.android.ddmlib.IDevice
    public SyncService getSyncService() throws IOException, com.android.ddmlib.TimeoutException, AdbCommandRejectedException {
        SyncService syncService = new SyncService(AndroidDebugBridge.getSocketAddress(), this);
        if (syncService.openSync()) {
            return syncService;
        }
        return null;
    }

    @Override // com.android.ddmlib.IDevice
    public FileListingService getFileListingService() {
        return new FileListingService(this);
    }

    @Override // com.android.ddmlib.IDevice
    public RawImage getScreenshot() throws IOException, com.android.ddmlib.TimeoutException, AdbCommandRejectedException {
        return getScreenshot(0L, TimeUnit.MILLISECONDS);
    }

    @Override // com.android.ddmlib.IDevice
    public RawImage getScreenshot(long timeout, TimeUnit unit) throws IOException, com.android.ddmlib.TimeoutException, AdbCommandRejectedException {
        return AdbHelper.getFrameBuffer(AndroidDebugBridge.getSocketAddress(), this, timeout, unit);
    }

    @Override // com.android.ddmlib.IDevice
    public void startScreenRecorder(String remoteFilePath, ScreenRecorderOptions options, IShellOutputReceiver receiver) throws Throwable {
        executeShellCommand(getScreenRecorderCommand(remoteFilePath, options), receiver, 0L, null);
    }

    public static String getScreenRecorderCommand(String remoteFilePath, ScreenRecorderOptions options) {
        StringBuilder sb = new StringBuilder("screenrecord ");
        if (options.width > 0 && options.height > 0) {
            sb.append("--size ");
            sb.append(options.width);
            sb.append('x');
            sb.append(options.height);
            sb.append(' ');
        }
        if (options.bitrateMbps > 0) {
            sb.append("--bit-rate ");
            sb.append(options.bitrateMbps * 1000000);
            sb.append(' ');
        }
        if (options.timeLimit > 0) {
            sb.append("--time-limit ");
            long jConvert = TimeUnit.SECONDS.convert(options.timeLimit, options.timeLimitUnits);
            if (jConvert > 180) {
                jConvert = 180;
            }
            sb.append(jConvert);
            sb.append(' ');
        }
        sb.append(remoteFilePath);
        return sb.toString();
    }

    @Override // com.android.ddmlib.IDevice
    public void executeShellCommand(String command, IShellOutputReceiver receiver) throws Throwable {
        AdbHelper.executeRemoteCommand(AndroidDebugBridge.getSocketAddress(), command, this, receiver, DdmPreferences.getTimeOut(), TimeUnit.MILLISECONDS);
    }

    @Override // com.android.ddmlib.IDevice
    public void executeShellCommand(String command, IShellOutputReceiver receiver, long maxTimeToOutputResponse, TimeUnit maxTimeUnits, InputStream is) throws Throwable {
        AdbHelper.executeRemoteCommand(AndroidDebugBridge.getSocketAddress(), AdbHelper.AdbService.EXEC, command, this, receiver, 0L, maxTimeToOutputResponse, maxTimeUnits, is);
    }

    @Override // com.android.ddmlib.IDevice
    public void executeBinderCommand(String[] parameters, IShellOutputReceiver receiver, long maxTimeToOutputResponse, TimeUnit maxTimeUnits, InputStream is) throws Throwable {
        if (supportsFeature(IDevice.Feature.ABB_EXEC)) {
            AdbHelper.executeRemoteCommand(AndroidDebugBridge.getSocketAddress(), AdbHelper.AdbService.ABB_EXEC, String.join("\u0000", parameters), this, receiver, 0L, maxTimeToOutputResponse, maxTimeUnits, is);
        } else {
            executeShellCommand("cmd " + String.join(" ", parameters), receiver, maxTimeToOutputResponse, maxTimeUnits, is);
        }
    }

    @Override // com.android.ddmlib.IDevice
    public void executeShellCommand(String command, IShellOutputReceiver receiver, int maxTimeToOutputResponse) throws Throwable {
        AdbHelper.executeRemoteCommand(AndroidDebugBridge.getSocketAddress(), command, this, receiver, maxTimeToOutputResponse, TimeUnit.MILLISECONDS);
    }

    @Override // com.android.ddmlib.IShellEnabledDevice
    public void executeShellCommand(String command, IShellOutputReceiver receiver, long maxTimeToOutputResponse, TimeUnit maxTimeUnits) throws Throwable {
        AdbHelper.executeRemoteCommand(AndroidDebugBridge.getSocketAddress(), command, this, receiver, 0L, maxTimeToOutputResponse, maxTimeUnits);
    }

    @Override // com.android.ddmlib.IShellEnabledDevice
    public void executeShellCommand(String command, IShellOutputReceiver receiver, long maxTimeout, long maxTimeToOutputResponse, TimeUnit maxTimeUnits) throws Throwable {
        AdbHelper.executeRemoteCommand(AndroidDebugBridge.getSocketAddress(), command, this, receiver, maxTimeout, maxTimeToOutputResponse, maxTimeUnits);
    }

    @Override // com.android.ddmlib.IDevice
    public SocketChannel rawExec(String executable, String[] parameters) throws IOException, com.android.ddmlib.TimeoutException, AdbCommandRejectedException {
        return AdbHelper.rawExec(AndroidDebugBridge.getSocketAddress(), this, executable, parameters);
    }

    @Override // com.android.ddmlib.IDevice
    public SocketChannel rawBinder(String service, String[] parameters) throws IOException, com.android.ddmlib.TimeoutException, AdbCommandRejectedException {
        String[] strArr = new String[parameters.length + 1];
        strArr[0] = service;
        System.arraycopy(parameters, 0, strArr, 1, parameters.length);
        if (supportsFeature(IDevice.Feature.ABB_EXEC)) {
            return AdbHelper.rawAdbService(AndroidDebugBridge.getSocketAddress(), this, String.join("\u0000", strArr), AdbHelper.AdbService.ABB_EXEC);
        }
        return AdbHelper.rawExec(AndroidDebugBridge.getSocketAddress(), this, "cmd", strArr);
    }

    @Override // com.android.ddmlib.IDevice
    public void runEventLogService(LogReceiver receiver) throws Throwable {
        AdbHelper.runEventLogService(AndroidDebugBridge.getSocketAddress(), this, receiver);
    }

    @Override // com.android.ddmlib.IDevice
    public void runLogService(String logname, LogReceiver receiver) throws Throwable {
        AdbHelper.runLogService(AndroidDebugBridge.getSocketAddress(), this, logname, receiver);
    }

    @Override // com.android.ddmlib.IDevice
    public void createForward(int localPort, int remotePort) throws Throwable {
        AdbHelper.createForward(AndroidDebugBridge.getSocketAddress(), this, String.format("tcp:%d", Integer.valueOf(localPort)), String.format("tcp:%d", Integer.valueOf(remotePort)));
    }

    @Override // com.android.ddmlib.IDevice
    public void createForward(int localPort, String remoteSocketName, IDevice.DeviceUnixSocketNamespace namespace) throws Throwable {
        AdbHelper.createForward(AndroidDebugBridge.getSocketAddress(), this, String.format("tcp:%d", Integer.valueOf(localPort)), String.format("%s:%s", namespace.getType(), remoteSocketName));
    }

    @Override // com.android.ddmlib.IDevice
    public void removeForward(int localPort) throws Throwable {
        AdbHelper.removeForward(AndroidDebugBridge.getSocketAddress(), this, String.format("tcp:%d", Integer.valueOf(localPort)));
    }

    @Override // com.android.ddmlib.IDevice
    public void createReverse(int remotePort, int localPort) throws Throwable {
        AdbHelper.createReverse(AndroidDebugBridge.getSocketAddress(), this, String.format(Locale.US, "tcp:%d", Integer.valueOf(localPort)), String.format(Locale.US, "tcp:%d", Integer.valueOf(remotePort)));
    }

    @Override // com.android.ddmlib.IDevice
    public void removeReverse(int remotePort) throws Throwable {
        AdbHelper.removeReverse(AndroidDebugBridge.getSocketAddress(), this, String.format(Locale.US, "tcp:%d", Integer.valueOf(remotePort)));
    }

    public DeviceImpl(ClientTracker clientTracer, String serialNumber, IDevice.DeviceState deviceState) {
        this.mClientTracer = clientTracer;
        this.mSerialNumber = serialNumber;
        this.mState = deviceState;
    }

    public ClientTracker getClientTracker() {
        return this.mClientTracer;
    }

    @Override // com.android.ddmlib.IDevice
    public boolean hasClients() {
        boolean z;
        synchronized (this.mClients) {
            z = !this.mClients.isEmpty();
        }
        return z;
    }

    @Override // com.android.ddmlib.IDevice
    public ClientImpl[] getClients() {
        ClientImpl[] clientImplArr;
        synchronized (this.mClients) {
            clientImplArr = (ClientImpl[]) this.mClients.toArray(new ClientImpl[0]);
        }
        return clientImplArr;
    }

    @Override // com.android.ddmlib.IDevice
    public ClientImpl getClient(String applicationName) {
        synchronized (this.mClients) {
            for (ClientImpl clientImpl : this.mClients) {
                if (applicationName.equals(clientImpl.getClientData().getClientDescription())) {
                    return clientImpl;
                }
            }
            return null;
        }
    }

    @Override // com.android.ddmlib.IDevice
    public ProfileableClientImpl[] getProfileableClients() {
        ProfileableClientImpl[] profileableClientImplArr;
        synchronized (this.mProfileableClients) {
            profileableClientImplArr = (ProfileableClientImpl[]) this.mProfileableClients.toArray(new ProfileableClientImpl[0]);
        }
        return profileableClientImplArr;
    }

    @Override // com.android.ddmlib.IDevice
    public void forceStop(String applicationName) {
        try {
            executeShellCommand("am force-stop " + applicationName, new NullOutputReceiver());
        } catch (AdbCommandRejectedException | ShellCommandUnresponsiveException | com.android.ddmlib.TimeoutException | IOException unused) {
        }
    }

    @Override // com.android.ddmlib.IDevice
    public void kill(String applicationName) {
        try {
            executeShellCommand("am kill " + applicationName, new NullOutputReceiver());
        } catch (AdbCommandRejectedException | ShellCommandUnresponsiveException | com.android.ddmlib.TimeoutException | IOException unused) {
        }
    }

    void addClient(ClientImpl client) {
        synchronized (this.mClients) {
            this.mClients.add(client);
        }
        addClientInfo(client);
    }

    List<ClientImpl> getClientList() {
        List<ClientImpl> list;
        synchronized (this.mClients) {
            list = this.mClients;
        }
        return list;
    }

    void clearClientList() {
        synchronized (this.mClients) {
            this.mClients.clear();
        }
        clearClientInfo();
    }

    void removeClient(ClientImpl client, boolean notify) {
        this.mClientTracer.trackDisconnectedClient(client);
        synchronized (this.mClients) {
            this.mClients.remove(client);
        }
        if (notify) {
            AndroidDebugBridge.deviceChanged(this, 2);
        }
        removeClientInfo(client);
    }

    void updateProfileableClientList(List<ProfileableClientImpl> newClientList) {
        synchronized (this.mProfileableClients) {
            this.mProfileableClients.clear();
            this.mProfileableClients.addAll(newClientList);
            Collections.sort(this.mProfileableClients, Comparator.comparingInt(new ToIntFunction() { // from class: com.android.ddmlib.internal.DeviceImpl$$ExternalSyntheticLambda0
                @Override // java.util.function.ToIntFunction
                public final int applyAsInt(Object obj) {
                    return ((ProfileableClientImpl) obj).getProfileableClientData().getPid();
                }
            }));
        }
    }

    void updateProfileableClientName(int pid, String name) {
        synchronized (this.mProfileableClients) {
            Iterator<ProfileableClientImpl> it = this.mProfileableClients.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ProfileableClientImpl next = it.next();
                if (next.getProfileableClientData().getPid() == pid) {
                    next.getProfileableClientData().setProcessName(name);
                    break;
                }
            }
        }
    }

    void clearProfileableClientList() {
        synchronized (this.mProfileableClients) {
            this.mProfileableClients.clear();
        }
    }

    void setClientMonitoringSocket(SocketChannel socketChannel) {
        this.mSocketChannel = socketChannel;
    }

    SocketChannel getClientMonitoringSocket() {
        return this.mSocketChannel;
    }

    void update(int changeMask) {
        AndroidDebugBridge.deviceChanged(this, changeMask);
    }

    void update(ClientImpl client, int changeMask) {
        AndroidDebugBridge.clientChanged(client, changeMask);
        updateClientInfo(client, changeMask);
    }

    void setMountingPoint(String name, String value) {
        this.mMountPoints.put(name, value);
    }

    private void addClientInfo(ClientImpl client) {
        ClientData clientData = client.getClientData();
        setClientInfo(clientData.getPid(), clientData.getPackageName());
    }

    private void updateClientInfo(ClientImpl client, int changeMask) {
        if ((changeMask & 1) == 1) {
            addClientInfo(client);
        }
    }

    private void removeClientInfo(ClientImpl client) {
        this.mClientInfo.remove(Integer.valueOf(client.getClientData().getPid()));
    }

    private void clearClientInfo() {
        this.mClientInfo.clear();
    }

    private void setClientInfo(int pid, String pkgName) {
        if (pkgName == null) {
            pkgName = "";
        }
        this.mClientInfo.put(Integer.valueOf(pid), pkgName);
    }

    @Override // com.android.ddmlib.IDevice
    public String getClientName(int pid) {
        return this.mClientInfo.getOrDefault(Integer.valueOf(pid), "");
    }

    @Override // com.android.ddmlib.IDevice
    public void push(String[] local, String remote) throws Exception {
        Log.d(String.join(", ", local), String.format("Uploading %1$s onto device '%2$s'", remote, getSerialNumber()));
        try {
            SyncService syncService = getSyncService();
            try {
                if (syncService == null) {
                    throw new IOException("Unable to open sync connection");
                }
                Log.d(LOG_TAG, String.format("Uploading file onto device '%1$s'", getSerialNumber()));
                syncService.push(local, remote, SyncService.getNullProgressMonitor());
                if (syncService != null) {
                    syncService.close();
                }
            } catch (Throwable th) {
                if (syncService != null) {
                    try {
                        syncService.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (SyncException e) {
            e = e;
            Log.e(LOG_TAG, String.format("Error during Sync: %1$s", e.getMessage()));
            throw e;
        } catch (com.android.ddmlib.TimeoutException e2) {
            Log.e(LOG_TAG, "Error during Sync: timeout.");
            throw e2;
        } catch (IOException e3) {
            e = e3;
            Log.e(LOG_TAG, String.format("Error during Sync: %1$s", e.getMessage()));
            throw e;
        }
    }

    @Override // com.android.ddmlib.IDevice
    public void pushFile(String local, String remote) throws Exception {
        String fileName = getFileName(local);
        Log.d(fileName, String.format("Uploading %1$s onto device '%2$s'", fileName, getSerialNumber()));
        try {
            SyncService syncService = getSyncService();
            try {
                if (syncService == null) {
                    throw new IOException("Unable to open sync connection");
                }
                Log.d(LOG_TAG, String.format("Uploading file onto device '%1$s'", getSerialNumber()));
                syncService.pushFile(local, remote, SyncService.getNullProgressMonitor());
                if (syncService != null) {
                    syncService.close();
                }
            } catch (Throwable th) {
                if (syncService != null) {
                    try {
                        syncService.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (SyncException e) {
            e = e;
            Log.e(LOG_TAG, String.format("Error during Sync: %1$s", e.getMessage()));
            throw e;
        } catch (com.android.ddmlib.TimeoutException e2) {
            Log.e(LOG_TAG, "Error during Sync: timeout.");
            throw e2;
        } catch (IOException e3) {
            e = e3;
            Log.e(LOG_TAG, String.format("Error during Sync: %1$s", e.getMessage()));
            throw e;
        }
    }

    @Override // com.android.ddmlib.IDevice
    public void pullFile(String remote, String local) throws SyncException, IOException, com.android.ddmlib.TimeoutException, AdbCommandRejectedException {
        AutoCloseable autoCloseable = null;
        try {
            try {
                String fileName = getFileName(remote);
                Log.d(fileName, String.format("Downloading %1$s from device '%2$s'", fileName, getSerialNumber()));
                SyncService syncService = getSyncService();
                if (syncService != null) {
                    Log.d(LOG_TAG, String.format("Downloading file from device '%1$s'", getSerialNumber()));
                    syncService.pullFile(remote, local, SyncService.getNullProgressMonitor());
                    if (syncService != null) {
                        syncService.close();
                        return;
                    }
                    return;
                }
                throw new IOException("Unable to open sync connection!");
            } catch (SyncException e) {
                e = e;
                Log.e(LOG_TAG, String.format("Error during Sync: %1$s", e.getMessage()));
                throw e;
            } catch (com.android.ddmlib.TimeoutException e2) {
                Log.e(LOG_TAG, "Error during Sync: timeout.");
                throw e2;
            } catch (IOException e3) {
                e = e3;
                Log.e(LOG_TAG, String.format("Error during Sync: %1$s", e.getMessage()));
                throw e;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                autoCloseable.close();
            }
            throw th;
        }
    }

    @Override // com.android.ddmlib.IDevice
    public void installPackage(String packageFilePath, boolean reinstall, String... extraArgs) throws InstallException {
        installPackage(packageFilePath, reinstall, new InstallReceiver(), extraArgs);
    }

    @Override // com.android.ddmlib.IDevice
    public void installPackage(String packageFilePath, boolean reinstall, InstallReceiver receiver, String... extraArgs) throws InstallException {
        installPackage(packageFilePath, reinstall, receiver, 0L, INSTALL_TIMEOUT_MINUTES, TimeUnit.MINUTES, extraArgs);
    }

    @Override // com.android.ddmlib.IDevice
    public void installPackage(String packageFilePath, boolean reinstall, InstallReceiver receiver, long maxTimeout, long maxTimeToOutputResponse, TimeUnit maxTimeUnits, String... extraArgs) throws InstallException {
        try {
            long jNanoTime = System.nanoTime();
            String strSyncPackageToDevice = syncPackageToDevice(packageFilePath);
            long jNanoTime2 = System.nanoTime();
            installRemotePackage(strSyncPackageToDevice, reinstall, receiver, maxTimeout, maxTimeToOutputResponse, maxTimeUnits, extraArgs);
            long jNanoTime3 = System.nanoTime();
            removeRemotePackage(strSyncPackageToDevice);
            this.lastInstallMetrics = new InstallMetrics(jNanoTime, jNanoTime2, jNanoTime2, jNanoTime3);
        } catch (AdbCommandRejectedException | SyncException | com.android.ddmlib.TimeoutException | IOException e) {
            throw new InstallException(e);
        }
    }

    @Override // com.android.ddmlib.IDevice
    public void installPackages(List<File> apks, boolean reinstall, List<String> installOptions, long timeout, TimeUnit timeoutUnit) throws InstallException {
        try {
            this.lastInstallMetrics = SplitApkInstaller.create(this, apks, reinstall, installOptions).install(timeout, timeoutUnit);
        } catch (InstallException e) {
            throw e;
        } catch (Exception e2) {
            throw new InstallException(e2);
        }
    }

    @Override // com.android.ddmlib.IDevice
    public void installPackages(List<File> apks, boolean reinstall, List<String> installOptions) throws InstallException {
        installPackages(apks, reinstall, installOptions, INSTALL_TIMEOUT_MINUTES, TimeUnit.MINUTES);
    }

    @Override // com.android.ddmlib.IDevice
    public InstallMetrics getLastInstallMetrics() {
        return this.lastInstallMetrics;
    }

    @Override // com.android.ddmlib.IDevice
    public void installRemotePackages(List<String> remoteApks, boolean reinstall, List<String> installOptions) throws InstallException {
        installRemotePackages(remoteApks, reinstall, installOptions, INSTALL_TIMEOUT_MINUTES, TimeUnit.MINUTES);
    }

    @Override // com.android.ddmlib.IDevice
    public void installRemotePackages(List<String> remoteApks, boolean reinstall, List<String> installOptions, long timeout, TimeUnit timeoutUnit) throws InstallException {
        try {
            RemoteSplitApkInstaller.create(this, remoteApks, reinstall, installOptions).install(timeout, timeoutUnit);
        } catch (InstallException e) {
            throw e;
        } catch (Exception e2) {
            throw new InstallException(e2);
        }
    }

    @Override // com.android.ddmlib.IDevice
    public String syncPackageToDevice(String localFilePath) throws SyncException, IOException, com.android.ddmlib.TimeoutException, AdbCommandRejectedException {
        AutoCloseable autoCloseable = null;
        try {
            try {
                String fileName = getFileName(localFilePath);
                String str = String.format("/data/local/tmp/%1$s", fileName);
                Log.d(fileName, String.format("Uploading %1$s onto device '%2$s'", fileName, getSerialNumber()));
                SyncService syncService = getSyncService();
                if (syncService != null) {
                    Log.d(LOG_TAG, String.format("Uploading file onto device '%1$s'", getSerialNumber()));
                    syncService.pushFile(localFilePath, str, SyncService.getNullProgressMonitor());
                    if (syncService != null) {
                        syncService.close();
                    }
                    return str;
                }
                throw new IOException("Unable to open sync connection!");
            } catch (SyncException e) {
                e = e;
                Log.e(LOG_TAG, String.format("Error during Sync: %1$s", e.getMessage()));
                throw e;
            } catch (com.android.ddmlib.TimeoutException e2) {
                Log.e(LOG_TAG, "Error during Sync: timeout.");
                throw e2;
            } catch (IOException e3) {
                e = e3;
                Log.e(LOG_TAG, String.format("Error during Sync: %1$s", e.getMessage()));
                throw e;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                autoCloseable.close();
            }
            throw th;
        }
    }

    private static String getFileName(String filePath) {
        return new File(filePath).getName();
    }

    @Override // com.android.ddmlib.IDevice
    public void installRemotePackage(String remoteFilePath, boolean reinstall, String... extraArgs) throws InstallException {
        installRemotePackage(remoteFilePath, reinstall, new InstallReceiver(), extraArgs);
    }

    @Override // com.android.ddmlib.IDevice
    public void installRemotePackage(String remoteFilePath, boolean reinstall, InstallReceiver receiver, String... extraArgs) throws InstallException {
        installRemotePackage(remoteFilePath, reinstall, receiver, 0L, INSTALL_TIMEOUT_MINUTES, TimeUnit.MINUTES, extraArgs);
    }

    @Override // com.android.ddmlib.IDevice
    public void installRemotePackage(String remoteFilePath, boolean reinstall, InstallReceiver receiver, long maxTimeout, long maxTimeToOutputResponse, TimeUnit maxTimeUnits, String... extraArgs) throws InstallException {
        try {
            StringBuilder sb = new StringBuilder();
            if (reinstall) {
                sb.append("-r ");
            }
            if (extraArgs != null) {
                sb.append(Joiner.on(' ').join(extraArgs));
            }
            executeShellCommand(String.format("pm install %1$s \"%2$s\"", sb.toString(), remoteFilePath), receiver, maxTimeout, maxTimeToOutputResponse, maxTimeUnits);
            String errorMessage = receiver.getErrorMessage();
            if (errorMessage == null) {
            } else {
                throw new InstallException(errorMessage, receiver.getErrorCode());
            }
        } catch (AdbCommandRejectedException | ShellCommandUnresponsiveException | com.android.ddmlib.TimeoutException | IOException e) {
            throw new InstallException(e);
        }
    }

    @Override // com.android.ddmlib.IDevice
    public void removeRemotePackage(String remoteFilePath) throws InstallException {
        try {
            executeShellCommand(String.format("rm \"%1$s\"", remoteFilePath), new NullOutputReceiver(), INSTALL_TIMEOUT_MINUTES, TimeUnit.MINUTES);
        } catch (AdbCommandRejectedException | ShellCommandUnresponsiveException | com.android.ddmlib.TimeoutException | IOException e) {
            throw new InstallException(e);
        }
    }

    @Override // com.android.ddmlib.IDevice
    public String uninstallPackage(String packageName) throws InstallException {
        return uninstallApp(packageName, new String[0]);
    }

    @Override // com.android.ddmlib.IDevice
    public String uninstallApp(String applicationID, String... extraArgs) throws InstallException {
        try {
            StringBuilder sb = new StringBuilder("pm uninstall");
            if (extraArgs != null) {
                sb.append(" ");
                Joiner.on(' ').appendTo(sb, (Object[]) extraArgs);
            }
            sb.append(" ").append(applicationID);
            InstallReceiver installReceiver = new InstallReceiver();
            executeShellCommand(sb.toString(), installReceiver, INSTALL_TIMEOUT_MINUTES, TimeUnit.MINUTES);
            return installReceiver.getErrorMessage();
        } catch (AdbCommandRejectedException | ShellCommandUnresponsiveException | com.android.ddmlib.TimeoutException | IOException e) {
            throw new InstallException(e);
        }
    }

    @Override // com.android.ddmlib.IDevice
    public void reboot(String into) throws Throwable {
        AdbHelper.reboot(into, AndroidDebugBridge.getSocketAddress(), this);
    }

    @Override // com.android.ddmlib.IDevice
    public boolean root() throws Throwable {
        if (!this.mIsRoot) {
            AdbHelper.root(AndroidDebugBridge.getSocketAddress(), this);
        }
        return isRoot();
    }

    @Override // com.android.ddmlib.IDevice
    public boolean isRoot() throws Throwable {
        if (this.mIsRoot) {
            return true;
        }
        CollectingOutputReceiver collectingOutputReceiver = new CollectingOutputReceiver();
        executeShellCommand("echo $USER_ID", collectingOutputReceiver, 1000L, TimeUnit.MILLISECONDS);
        boolean zEquals = collectingOutputReceiver.getOutput().trim().equals("0");
        this.mIsRoot = zEquals;
        return zEquals;
    }

    @Override // com.android.ddmlib.IDevice
    public Integer getBatteryLevel() {
        return getBatteryLevel(300000L);
    }

    @Override // com.android.ddmlib.IDevice
    public Integer getBatteryLevel(long freshnessMs) {
        try {
            return getBattery(freshnessMs, TimeUnit.MILLISECONDS).get();
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }

    @Override // com.android.ddmlib.IDevice
    public Future<Integer> getBattery() {
        return getBattery(5L, TimeUnit.MINUTES);
    }

    @Override // com.android.ddmlib.IDevice
    public Future<Integer> getBattery(long freshnessTime, TimeUnit timeUnit) {
        return this.mBatteryFetcher.getBattery(freshnessTime, timeUnit);
    }

    @Override // com.android.ddmlib.IDevice
    public List<String> getAbis() {
        String property = getProperty(IDevice.PROP_DEVICE_CPU_ABI_LIST);
        if (property != null) {
            return Lists.newArrayList(property.split(","));
        }
        ArrayList arrayListNewArrayListWithExpectedSize = Lists.newArrayListWithExpectedSize(2);
        String property2 = getProperty(IDevice.PROP_DEVICE_CPU_ABI);
        if (property2 != null) {
            arrayListNewArrayListWithExpectedSize.add(property2);
        }
        String property3 = getProperty(IDevice.PROP_DEVICE_CPU_ABI2);
        if (property3 != null) {
            arrayListNewArrayListWithExpectedSize.add(property3);
        }
        return arrayListNewArrayListWithExpectedSize;
    }

    @Override // com.android.ddmlib.IDevice
    public int getDensity() {
        String property = getProperty(IDevice.PROP_DEVICE_DENSITY);
        if (property == null) {
            property = getProperty(IDevice.PROP_DEVICE_EMULATOR_DENSITY);
        }
        if (property != null) {
            try {
                return Integer.parseInt(property);
            } catch (NumberFormatException unused) {
            }
        }
        return -1;
    }

    @Override // com.android.ddmlib.IDevice
    public String getLanguage() {
        return getProperties().get(IDevice.PROP_DEVICE_LANGUAGE);
    }

    @Override // com.android.ddmlib.IDevice
    public String getRegion() {
        return getProperty(IDevice.PROP_DEVICE_REGION);
    }
}
