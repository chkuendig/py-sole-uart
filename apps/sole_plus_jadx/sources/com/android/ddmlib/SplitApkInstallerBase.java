package com.android.ddmlib;

import com.android.ddmlib.AdbHelper;
import com.android.ddmlib.IDevice;
import com.android.sdklib.AndroidVersion;
import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import io.ktor.util.date.GMTDateParser;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public abstract class SplitApkInstallerBase {
    private static final String LOG_TAG = "SplitApkInstallerBase";
    protected static final CharMatcher UNSAFE_PM_INSTALL_SESSION_SPLIT_NAME_CHARS = CharMatcher.inRange('a', GMTDateParser.ZONE).or(CharMatcher.inRange('A', 'Z')).or(CharMatcher.anyOf("_-")).negate();
    private static boolean abbExecAllowed = true;
    protected final IDevice mDevice;
    private final String mOptions;
    private final String mPrefix;
    private final AdbHelper.AdbService mService;
    private final AdbHelper.AdbService mServiceWrite;

    protected SplitApkInstallerBase(IDevice device, String options) {
        this.mDevice = device;
        this.mOptions = options;
        if (device.supportsFeature(IDevice.Feature.ABB_EXEC) && abbExecAllowed) {
            this.mPrefix = "package";
            this.mService = AdbHelper.AdbService.ABB_EXEC;
            this.mServiceWrite = AdbHelper.AdbService.ABB_EXEC;
        } else if (supportsCmd(device)) {
            this.mPrefix = "cmd package";
            this.mService = AdbHelper.AdbService.SHELL;
            this.mServiceWrite = AdbHelper.AdbService.EXEC;
        } else {
            this.mPrefix = "pm";
            this.mService = AdbHelper.AdbService.SHELL;
            this.mServiceWrite = AdbHelper.AdbService.EXEC;
        }
        Log.i(LOG_TAG, String.format("Install-Write Strategy '%s' over '%s'", this.mPrefix, this.mServiceWrite.name()));
    }

    private static boolean supportsCmd(IDevice device) {
        return device.getVersion().isGreaterOrEqualThan(AndroidVersion.BINDER_CMD_AVAILABLE.getApiLevel());
    }

    static void setAbbExecAllowed(boolean allowed) {
        abbExecAllowed = allowed;
    }

    protected String createMultiInstallSession(String options, long timeout, TimeUnit unit) throws Throwable {
        String str;
        InstallCreateReceiver installCreateReceiver = new InstallCreateReceiver();
        String str2 = this.mPrefix + " install-create";
        if (!options.trim().isEmpty()) {
            str2 = str2 + " " + options;
        }
        String str3 = str2;
        AdbHelper.executeRemoteCommand(AndroidDebugBridge.getSocketAddress(), this.mService, str3, this.mDevice, installCreateReceiver, 0L, timeout, unit, null);
        String sessionId = installCreateReceiver.getSessionId();
        if (sessionId == null) {
            String str4 = String.format("'%s'", str3);
            if (installCreateReceiver.getErrorMessage() != null) {
                str = String.format("%s returns error '%s'", str4, installCreateReceiver.getErrorMessage());
            } else if (installCreateReceiver.getSuccessMessage() != null) {
                str = String.format("%s returns '%s' without session ID", str4, installCreateReceiver.getSuccessMessage());
            } else {
                str = String.format("Failed to create install session with %s", str4);
            }
            Log.e(LOG_TAG, str);
            throw new InstallException(str);
        }
        Log.i(LOG_TAG, String.format("Created install session %s with options %s", sessionId, options));
        return sessionId;
    }

    protected void installCommit(String sessionId, long timeout, TimeUnit unit) throws Throwable {
        String str = this.mPrefix + " install-commit " + sessionId;
        InstallReceiver installReceiver = new InstallReceiver();
        AdbHelper.executeRemoteCommand(AndroidDebugBridge.getSocketAddress(), this.mService, str, this.mDevice, installReceiver, 0L, timeout, unit, null);
        if (installReceiver.isSuccessfullyCompleted()) {
            return;
        }
        String str2 = String.format("Failed to commit install session %s with command %s.", sessionId, str);
        if (installReceiver.getErrorMessage() != null) {
            str2 = str2 + String.format(" Error: %s", installReceiver.getErrorMessage());
        }
        Log.e(LOG_TAG, str2);
        throw new InstallException(str2, installReceiver.getErrorCode());
    }

    protected void installAbandon(String sessionId, long timeout, TimeUnit unit) throws Throwable {
        String str = this.mPrefix + " install-abandon " + sessionId;
        InstallReceiver installReceiver = new InstallReceiver();
        AdbHelper.executeRemoteCommand(AndroidDebugBridge.getSocketAddress(), this.mService, str, this.mDevice, installReceiver, 0L, timeout, unit, null);
        if (installReceiver.isSuccessfullyCompleted()) {
            return;
        }
        Log.e(LOG_TAG, String.format("Failed to abandon install session %s", sessionId));
    }

    protected IDevice getDevice() {
        return this.mDevice;
    }

    protected String getPrefix() {
        return this.mPrefix;
    }

    protected String getOptions() {
        return this.mOptions;
    }

    protected AdbHelper.AdbService getService() {
        return this.mService;
    }

    protected AdbHelper.AdbService getServiceWrite() {
        return this.mServiceWrite;
    }

    protected static String getOptions(boolean reInstall, List<String> installOptions) {
        return getOptions(reInstall, false, null, installOptions);
    }

    protected static String getOptions(boolean reInstall, boolean partialInstall, String applicationId, List<String> installOptions) {
        StringBuilder sb = new StringBuilder();
        if (reInstall) {
            sb.append("-r");
        }
        if (partialInstall) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            if (applicationId == null) {
                throw new IllegalArgumentException("Cannot do a partial install without knowing the application id");
            }
            sb.append("-p ");
            sb.append(applicationId);
        }
        if (!installOptions.isEmpty()) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(Joiner.on(" ").join(installOptions));
        }
        return sb.toString();
    }

    protected static void validateApiLevel(IDevice device) {
        int apiLevel = AndroidVersion.ALLOW_SPLIT_APK_INSTALLATION.getApiLevel();
        if (!device.getVersion().isGreaterOrEqualThan(apiLevel)) {
            throw new IllegalArgumentException(String.format("Device %s API level=%d. Cannot install split APKs with API level < %d", device.getSerialNumber(), Integer.valueOf(device.getVersion().getApiLevel()), Integer.valueOf(apiLevel)));
        }
    }
}
