package com.android.ddmlib;

import com.android.ddmlib.log.LogReceiver;
import com.android.sdklib.AndroidVersion;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.common.base.Splitter;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.SocketChannel;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes3.dex */
public interface IDevice extends IShellEnabledDevice {
    public static final int CHANGE_BUILD_INFO = 4;
    public static final int CHANGE_CLIENT_LIST = 2;
    public static final int CHANGE_PROFILEABLE_CLIENT_LIST = 8;
    public static final int CHANGE_STATE = 1;
    public static final String FIRST_EMULATOR_SN = "emulator-5554";
    public static final String MNT_DATA = "ANDROID_DATA";
    public static final String MNT_EXTERNAL_STORAGE = "EXTERNAL_STORAGE";
    public static final String MNT_ROOT = "ANDROID_ROOT";
    public static final String PROP_BUILD_API_LEVEL = "ro.build.version.sdk";
    public static final String PROP_BUILD_CHARACTERISTICS = "ro.build.characteristics";
    public static final String PROP_BUILD_CODENAME = "ro.build.version.codename";
    public static final String PROP_BUILD_TAGS = "ro.build.tags";
    public static final String PROP_BUILD_TYPE = "ro.build.type";
    public static final String PROP_BUILD_VERSION = "ro.build.version.release";

    @Deprecated
    public static final String PROP_BUILD_VERSION_NUMBER = "ro.build.version.sdk";
    public static final String PROP_DEBUGGABLE = "ro.debuggable";
    public static final String PROP_DEVICE_CPU_ABI = "ro.product.cpu.abi";
    public static final String PROP_DEVICE_CPU_ABI2 = "ro.product.cpu.abi2";
    public static final String PROP_DEVICE_CPU_ABI_LIST = "ro.product.cpu.abilist";
    public static final String PROP_DEVICE_DENSITY = "ro.sf.lcd_density";
    public static final String PROP_DEVICE_EMULATOR_DENSITY = "qemu.sf.lcd_density";
    public static final String PROP_DEVICE_LANGUAGE = "persist.sys.language";
    public static final String PROP_DEVICE_MANUFACTURER = "ro.product.manufacturer";
    public static final String PROP_DEVICE_MODEL = "ro.product.model";
    public static final String PROP_DEVICE_REGION = "persist.sys.country";
    public static final String RE_EMULATOR_SN = "emulator-(\\d+)";
    public static final String UNKNOWN_PACKAGE = "";

    public enum Feature {
        SCREEN_RECORD,
        PROCSTATS,
        ABB_EXEC,
        REAL_PKG_NAME,
        SKIP_VERIFICATION,
        SHELL_V2
    }

    boolean arePropertiesSet();

    void createForward(int localPort, int remotePort) throws IOException, TimeoutException, AdbCommandRejectedException;

    void createForward(int localPort, String remoteSocketName, DeviceUnixSocketNamespace namespace) throws IOException, TimeoutException, AdbCommandRejectedException;

    void executeShellCommand(String command, IShellOutputReceiver receiver) throws IOException, TimeoutException, AdbCommandRejectedException, ShellCommandUnresponsiveException;

    @Deprecated
    void executeShellCommand(String command, IShellOutputReceiver receiver, int maxTimeToOutputResponse) throws IOException, TimeoutException, AdbCommandRejectedException, ShellCommandUnresponsiveException;

    default void forceStop(String applicationName) {
    }

    List<String> getAbis();

    @Deprecated
    String getAvdName();

    @Deprecated
    String getAvdPath();

    Future<Integer> getBattery();

    Future<Integer> getBattery(long freshnessTime, TimeUnit timeUnit);

    @Deprecated
    Integer getBatteryLevel() throws IOException, TimeoutException, AdbCommandRejectedException, ShellCommandUnresponsiveException;

    @Deprecated
    Integer getBatteryLevel(long freshnessMs) throws IOException, TimeoutException, AdbCommandRejectedException, ShellCommandUnresponsiveException;

    Client getClient(String applicationName);

    String getClientName(int pid);

    Client[] getClients();

    int getDensity();

    FileListingService getFileListingService();

    String getLanguage();

    String getMountPoint(String name);

    @Deprecated
    Map<String, String> getProperties();

    String getProperty(String name);

    @Deprecated
    String getPropertyCacheOrSync(String name) throws IOException, TimeoutException, AdbCommandRejectedException, ShellCommandUnresponsiveException;

    @Deprecated
    int getPropertyCount();

    @Deprecated
    String getPropertySync(String name) throws IOException, TimeoutException, AdbCommandRejectedException, ShellCommandUnresponsiveException;

    String getRegion();

    RawImage getScreenshot() throws IOException, TimeoutException, AdbCommandRejectedException;

    RawImage getScreenshot(long timeout, TimeUnit unit) throws IOException, TimeoutException, AdbCommandRejectedException;

    String getSerialNumber();

    DeviceState getState();

    SyncService getSyncService() throws IOException, TimeoutException, AdbCommandRejectedException;

    AndroidVersion getVersion();

    boolean hasClients();

    void installPackage(String packageFilePath, boolean reinstall, InstallReceiver receiver, long maxTimeout, long maxTimeToOutputResponse, TimeUnit maxTimeUnits, String... extraArgs) throws InstallException;

    void installPackage(String packageFilePath, boolean reinstall, InstallReceiver receiver, String... extraArgs) throws InstallException;

    void installPackage(String packageFilePath, boolean reinstall, String... extraArgs) throws InstallException;

    void installPackages(List<File> apks, boolean reinstall, List<String> installOptions, long timeout, TimeUnit timeoutUnit) throws InstallException;

    void installRemotePackage(String remoteFilePath, boolean reinstall, InstallReceiver receiver, long maxTimeout, long maxTimeToOutputResponse, TimeUnit maxTimeUnits, String... extraArgs) throws InstallException;

    void installRemotePackage(String remoteFilePath, boolean reinstall, InstallReceiver receiver, String... extraArgs) throws InstallException;

    void installRemotePackage(String remoteFilePath, boolean reinstall, String... extraArgs) throws InstallException;

    boolean isBootLoader();

    boolean isEmulator();

    boolean isOffline();

    boolean isOnline();

    boolean isRoot() throws IOException, TimeoutException, AdbCommandRejectedException, ShellCommandUnresponsiveException;

    default void kill(String applicationName) {
    }

    void pullFile(String remote, String local) throws SyncException, IOException, TimeoutException, AdbCommandRejectedException;

    void pushFile(String local, String remote) throws SyncException, IOException, TimeoutException, AdbCommandRejectedException;

    void reboot(String into) throws IOException, TimeoutException, AdbCommandRejectedException;

    void removeRemotePackage(String remoteFilePath) throws InstallException;

    boolean root() throws IOException, TimeoutException, AdbCommandRejectedException, ShellCommandUnresponsiveException;

    void runEventLogService(LogReceiver receiver) throws IOException, TimeoutException, AdbCommandRejectedException;

    void runLogService(String logname, LogReceiver receiver) throws IOException, TimeoutException, AdbCommandRejectedException;

    void startScreenRecorder(String remoteFilePath, ScreenRecorderOptions options, IShellOutputReceiver receiver) throws IOException, TimeoutException, AdbCommandRejectedException, ShellCommandUnresponsiveException;

    boolean supportsFeature(Feature feature);

    boolean supportsFeature(HardwareFeature feature);

    String syncPackageToDevice(String localFilePath) throws SyncException, IOException, TimeoutException, AdbCommandRejectedException;

    String uninstallApp(String applicationID, String... extraArgs) throws InstallException;

    String uninstallPackage(String packageName) throws InstallException;

    public enum HardwareFeature {
        WATCH("watch"),
        EMBEDDED("embedded"),
        TV("tv"),
        AUTOMOTIVE("automotive");

        private final String mCharacteristic;

        HardwareFeature(String characteristic) {
            this.mCharacteristic = characteristic;
        }

        public String getCharacteristic() {
            return this.mCharacteristic;
        }
    }

    public enum DeviceState {
        BOOTLOADER("bootloader"),
        FASTBOOTD("fastbootd"),
        OFFLINE("offline"),
        ONLINE(DeviceRequestsHelper.DEVICE_INFO_DEVICE),
        RECOVERY("recovery"),
        SIDELOAD("sideload"),
        UNAUTHORIZED("unauthorized"),
        DISCONNECTED("disconnected");

        private String mState;

        DeviceState(String state) {
            this.mState = state;
        }

        public static DeviceState getState(String state) {
            for (DeviceState deviceState : values()) {
                if (deviceState.mState.equals(state)) {
                    return deviceState;
                }
            }
            return null;
        }

        public String getState() {
            return this.mState;
        }
    }

    public enum DeviceUnixSocketNamespace {
        ABSTRACT("localabstract"),
        FILESYSTEM("localfilesystem"),
        RESERVED("localreserved");

        private String mType;

        DeviceUnixSocketNamespace(String type) {
            this.mType = type;
        }

        public String getType() {
            return this.mType;
        }
    }

    default ListenableFuture<AvdData> getAvdData() {
        throw new UnsupportedOperationException();
    }

    default ProfileableClient[] getProfileableClients() {
        return new ProfileableClient[0];
    }

    default void executeShellCommand(String command, IShellOutputReceiver receiver, long maxTimeToOutputResponse, TimeUnit maxTimeUnits, InputStream is) throws IOException, TimeoutException, AdbCommandRejectedException, ShellCommandUnresponsiveException {
        throw new UnsupportedOperationException();
    }

    default void executeBinderCommand(String[] parameters, IShellOutputReceiver receiver, long maxTimeToOutputResponse, TimeUnit maxTimeUnits, InputStream is) throws IOException, TimeoutException, AdbCommandRejectedException, ShellCommandUnresponsiveException {
        throw new UnsupportedOperationException();
    }

    default void removeForward(int localPort) throws IOException, TimeoutException, AdbCommandRejectedException {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default void removeForward(int localPort, int remotePort) throws IOException, TimeoutException, AdbCommandRejectedException {
        removeForward(localPort);
    }

    @Deprecated
    default void removeForward(int localPort, String remoteSocketName, DeviceUnixSocketNamespace namespace) throws IOException, TimeoutException, AdbCommandRejectedException {
        removeForward(localPort);
    }

    default void createReverse(int remotePort, int localPort) throws IOException, TimeoutException, AdbCommandRejectedException {
        throw new UnsupportedOperationException();
    }

    default void removeReverse(int remotePort) throws IOException, TimeoutException, AdbCommandRejectedException {
        throw new UnsupportedOperationException();
    }

    default void push(String[] local, String remote) throws SyncException, IOException, TimeoutException, AdbCommandRejectedException {
        throw new UnsupportedOperationException();
    }

    default void installPackages(List<File> apks, boolean reinstall, List<String> installOptions) throws InstallException {
        throw new UnsupportedOperationException();
    }

    default InstallMetrics getLastInstallMetrics() {
        throw new UnsupportedOperationException();
    }

    default void installRemotePackages(List<String> remoteApks, boolean reinstall, List<String> installOptions, long timeout, TimeUnit timeoutUnit) throws InstallException {
        throw new UnsupportedOperationException();
    }

    default void installRemotePackages(List<String> remoteApks, boolean reinstall, List<String> installOptions) throws InstallException {
        throw new UnsupportedOperationException();
    }

    default SocketChannel rawExec(String executable, String[] parameters) throws IOException, TimeoutException, AdbCommandRejectedException {
        throw new UnsupportedOperationException();
    }

    default SocketChannel rawBinder(String service, String[] parameters) throws IOException, TimeoutException, AdbCommandRejectedException {
        throw new UnsupportedOperationException();
    }

    default Set<String> getHardwareCharacteristics() throws Exception {
        String property = getProperty(PROP_BUILD_CHARACTERISTICS);
        if (property == null) {
            return Collections.emptySet();
        }
        return Sets.newHashSet(Splitter.on(AbstractJsonLexerKt.COMMA).split(property));
    }
}
