package com.android.ddmlib;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class SplitApkInstaller extends SplitApkInstallerBase {
    private static final String LOG_TAG = "SplitApkInstaller";
    private final List<File> mApks;

    private SplitApkInstaller(IDevice device, List<File> apks, String options) {
        super(device, options);
        this.mApks = apks;
    }

    public InstallMetrics install(long timeout, TimeUnit unit) throws Throwable {
        try {
            Iterator<File> it = this.mApks.iterator();
            long length = 0;
            while (it.hasNext()) {
                length += it.next().length();
            }
            String str = String.format("-S %d", Long.valueOf(length));
            if (getOptions() != null) {
                str = getOptions() + " " + str;
            }
            String strCreateMultiInstallSession = createMultiInstallSession(str, timeout, unit);
            long jNanoTime = System.nanoTime();
            boolean zUploadApk = true;
            for (int i = 0; zUploadApk && i < this.mApks.size(); i++) {
                zUploadApk = uploadApk(strCreateMultiInstallSession, this.mApks.get(i), i, timeout, unit);
            }
            long jNanoTime2 = System.nanoTime();
            if (!zUploadApk) {
                installAbandon(strCreateMultiInstallSession, timeout, unit);
                throw new InstallException("Failed to install-write all apks");
            }
            installCommit(strCreateMultiInstallSession, timeout, unit);
            Log.d(LOG_TAG, "Successfully install apks: " + this.mApks.toString());
            return new InstallMetrics(jNanoTime, jNanoTime2, jNanoTime2, System.nanoTime());
        } catch (InstallException e) {
            throw e;
        } catch (Exception e2) {
            throw new InstallException(e2);
        }
    }

    protected boolean uploadApk(String sessionId, File fileToUpload, int uniqueId, long timeout, TimeUnit unit) throws Throwable {
        String name;
        Throwable th;
        BufferedInputStream bufferedInputStream;
        Log.i(LOG_TAG, String.format("Uploading APK %s to session %s", fileToUpload.getPath(), sessionId));
        if (!fileToUpload.exists()) {
            Log.e(LOG_TAG, String.format("File not found: %1$s", fileToUpload.getPath()));
            return false;
        }
        if (fileToUpload.isDirectory()) {
            Log.e(LOG_TAG, String.format("Directory upload not supported: %s", fileToUpload.getAbsolutePath()));
            return false;
        }
        if (fileToUpload.getName().lastIndexOf(46) != -1) {
            name = fileToUpload.getName().substring(0, fileToUpload.getName().lastIndexOf(46));
        } else {
            name = fileToUpload.getName();
        }
        String str = String.format(getPrefix() + " install-write -S %d %s %d_%s -", Long.valueOf(fileToUpload.length()), sessionId, Integer.valueOf(uniqueId), UNSAFE_PM_INSTALL_SESSION_SPLIT_NAME_CHARS.replaceFrom((CharSequence) name, '_'));
        Log.d(LOG_TAG, String.format("Executing : %1$s", str));
        BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(fileToUpload));
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            InstallReceiver installReceiver = new InstallReceiver();
            AdbHelper.executeRemoteCommand(AndroidDebugBridge.getSocketAddress(), getServiceWrite(), str, getDevice(), installReceiver, timeout, unit, bufferedInputStream);
            if (installReceiver.isSuccessfullyCompleted()) {
                Log.d(LOG_TAG, String.format("Successfully uploaded %1$s", fileToUpload.getName()));
            } else {
                Log.e(LOG_TAG, String.format("Error while uploading %1$s : %2$s", fileToUpload.getName(), installReceiver.getErrorMessage()));
            }
            boolean zIsSuccessfullyCompleted = installReceiver.isSuccessfullyCompleted();
            try {
                bufferedInputStream.close();
            } catch (IOException e2) {
                Log.e(sessionId, e2);
            }
            return zIsSuccessfullyCompleted;
        } catch (Exception e3) {
            e = e3;
            bufferedInputStream2 = bufferedInputStream;
            Log.e(sessionId, e);
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                } catch (IOException e4) {
                    Log.e(sessionId, e4);
                }
            }
            return false;
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream2 = bufferedInputStream;
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                    throw th;
                } catch (IOException e5) {
                    Log.e(sessionId, e5);
                    throw th;
                }
            }
            throw th;
        }
    }

    private static void validateArguments(IDevice device, List<File> apks) {
        validateApiLevel(device);
        if (apks.isEmpty()) {
            throw new IllegalArgumentException("List of APKs is empty: the main APK must be specified.");
        }
        for (File file : apks) {
            if (!file.isFile()) {
                throw new IllegalArgumentException("Invalid File: " + file.getPath());
            }
        }
    }

    public static SplitApkInstaller create(IDevice device, List<File> apks, boolean reInstall, List<String> installOptions) {
        validateArguments(device, apks);
        return new SplitApkInstaller(device, apks, getOptions(reInstall, installOptions));
    }

    public static SplitApkInstaller create(IDevice device, String applicationId, List<File> apks, boolean reInstall, List<String> installOptions) {
        validateArguments(device, apks);
        return new SplitApkInstaller(device, apks, getOptions(reInstall, true, applicationId, installOptions));
    }
}
