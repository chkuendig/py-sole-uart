package com.android.ddmlib;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class RemoteSplitApkInstaller extends SplitApkInstallerBase {
    private static final String LOG_TAG = "RemoteSplitApkInstaller";
    private final List<String> mRemoteApkPaths;

    private RemoteSplitApkInstaller(IDevice device, List<String> remoteApks, String options) {
        super(device, options);
        this.mRemoteApkPaths = remoteApks;
    }

    public void install(long timeout, TimeUnit unit) throws InstallException {
        try {
            String strCreateMultiInstallSession = createMultiInstallSession(getOptions(), timeout, unit);
            Iterator<String> it = this.mRemoteApkPaths.iterator();
            boolean zWriteRemoteApk = true;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                Log.d(LOG_TAG, String.format("Add apk %s to install session %s", next, strCreateMultiInstallSession));
                zWriteRemoteApk = writeRemoteApk(strCreateMultiInstallSession, next, timeout, unit);
                if (!zWriteRemoteApk) {
                    Log.e(LOG_TAG, String.format("Failed to write install session %s with %s", strCreateMultiInstallSession, next));
                    break;
                }
            }
            if (!zWriteRemoteApk) {
                installAbandon(strCreateMultiInstallSession, timeout, unit);
                throw new InstallException("Failed to install-write all apks");
            }
            installCommit(strCreateMultiInstallSession, timeout, unit);
            Log.d(LOG_TAG, "Successfully install apks: " + this.mRemoteApkPaths.toString());
        } catch (InstallException e) {
            throw e;
        } catch (Exception e2) {
            throw new InstallException(e2);
        }
    }

    protected boolean writeRemoteApk(String sessionId, String filePath, long timeout, TimeUnit unit) throws Throwable {
        String str = String.format(getPrefix() + " install-write %s %s %s", sessionId, UNSAFE_PM_INSTALL_SESSION_SPLIT_NAME_CHARS.replaceFrom((CharSequence) (filePath.lastIndexOf(47) != -1 ? filePath.substring(filePath.lastIndexOf(47), filePath.length()) : filePath), '_'), filePath);
        Log.d(LOG_TAG, String.format("Executing : %s", str));
        try {
            InstallReceiver installReceiver = new InstallReceiver();
            AdbHelper.executeRemoteCommand(AndroidDebugBridge.getSocketAddress(), getServiceWrite(), str, this.mDevice, installReceiver, 0L, timeout, unit, null);
            if (installReceiver.isSuccessfullyCompleted()) {
                Log.d(LOG_TAG, String.format("Successfully add %s to install session %s", filePath, sessionId));
            } else if (installReceiver.getErrorMessage() != null) {
                Log.e(LOG_TAG, String.format("Error install-write %s to session %s by command %s: %s", filePath, sessionId, str, installReceiver.getErrorMessage()));
            } else {
                Log.e(LOG_TAG, String.format("Failed to install-write session %s with %s by command %s", sessionId, filePath, str));
            }
            return installReceiver.isSuccessfullyCompleted();
        } catch (Exception e) {
            Log.e(LOG_TAG, String.format("%s failed with error %s", str, e));
            return false;
        }
    }

    private static void validateArguments(IDevice device, List<String> apks) {
        validateApiLevel(device);
        if (apks.isEmpty()) {
            throw new IllegalArgumentException("List of APKs is empty: the main APK must be specified.");
        }
    }

    public static RemoteSplitApkInstaller create(IDevice device, List<String> remoteApks, boolean reInstall, List<String> installOptions) {
        validateArguments(device, remoteApks);
        return new RemoteSplitApkInstaller(device, remoteApks, getOptions(reInstall, installOptions));
    }

    public static RemoteSplitApkInstaller create(IDevice device, String applicationId, List<String> remoteApks, boolean reInstall, List<String> installOptions) {
        validateArguments(device, remoteApks);
        return new RemoteSplitApkInstaller(device, remoteApks, getOptions(reInstall, true, applicationId, installOptions));
    }
}
