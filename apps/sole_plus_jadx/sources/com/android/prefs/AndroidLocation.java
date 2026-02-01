package com.android.prefs;

import com.android.SdkConstants;
import com.android.utils.EnvironmentProvider;
import com.android.utils.FileUtils;
import com.android.utils.ILogger;
import com.android.utils.StdLogger;
import java.io.File;
import java.util.Objects;
import java.util.function.Function;

@Deprecated
/* loaded from: classes3.dex */
public final class AndroidLocation {
    public static final String ANDROID_PREFS_ROOT = "ANDROID_PREFS_ROOT";
    public static final String FOLDER_AVD = "avd";
    public static final String FOLDER_DOT_ANDROID = ".android";
    private static String sAvdLocation;
    static String sPrefsLocation;

    public static final class AndroidLocationException extends Exception {
        private static final long serialVersionUID = 1;

        public AndroidLocationException(String string) {
            super(string);
        }
    }

    private enum Global {
        ANDROID_AVD_HOME("ANDROID_AVD_HOME", true, true),
        ANDROID_PREFS_ROOT(AndroidLocation.ANDROID_PREFS_ROOT, true, true),
        TEST_TMPDIR("TEST_TMPDIR", false, true),
        USER_HOME("user.home", true, false),
        HOME("HOME", false, true);

        final boolean mIsEnvVar;
        final boolean mIsSysProp;
        final String mName;

        Global(String name, boolean isSysProp, boolean isEnvVar) {
            this.mName = name;
            this.mIsSysProp = isSysProp;
            this.mIsEnvVar = isEnvVar;
        }

        public String validatePath(final EnvironmentProvider environmentProvider, ILogger logger, boolean silent) throws AndroidLocationException {
            if (this.mIsSysProp) {
                Objects.requireNonNull(environmentProvider);
                String strCheckPath = checkPath(environmentProvider, new Function() { // from class: com.android.prefs.AndroidLocation$Global$$ExternalSyntheticLambda0
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return environmentProvider.getSystemProperty((String) obj);
                    }
                }, logger, silent);
                if (strCheckPath != null) {
                    return strCheckPath;
                }
            }
            if (!this.mIsEnvVar) {
                return null;
            }
            Objects.requireNonNull(environmentProvider);
            String strCheckPath2 = checkPath(environmentProvider, new Function() { // from class: com.android.prefs.AndroidLocation$Global$$ExternalSyntheticLambda1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return environmentProvider.getEnvVariable((String) obj);
                }
            }, logger, silent);
            if (strCheckPath2 != null) {
                return strCheckPath2;
            }
            return null;
        }

        private String checkPath(EnvironmentProvider environmentProvider, Function<String, String> queryFunction, ILogger logger, boolean silent) throws AndroidLocationException {
            String strApply = queryFunction.apply(this.mName);
            if (this == ANDROID_PREFS_ROOT) {
                String strApply2 = queryFunction.apply("ANDROID_SDK_HOME");
                if (strApply == null) {
                    if (strApply2 == null) {
                        return null;
                    }
                    strApply = validateAndroidSdkHomeValue(environmentProvider, strApply2, logger, silent);
                } else if (strApply2 != null && !strApply.equals(strApply2)) {
                    throw new AndroidLocationException("Both ANDROID_PREFS_ROOT and ANDROID_SDK_HOME are set to different values\nSupport for ANDROID_SDK_HOME is deprecated. Use ANDROID_PREFS_ROOT only.\nCurrent values:\nANDROID_PREFS_ROOT: " + strApply + "\nANDROID_SDK_HOME: " + strApply2);
                }
            }
            if (strApply != null && new File(strApply).isDirectory()) {
                return strApply;
            }
            return null;
        }

        private static String validateAndroidSdkHomeValue(EnvironmentProvider environmentProvider, String path, ILogger logger, boolean silent) throws AndroidLocationException {
            File file = new File(path);
            if (!file.isDirectory()) {
                return null;
            }
            if (isSdkRootWithoutDotAndroid(file)) {
                String str = String.format("ANDROID_SDK_HOME is set to the root of your SDK: %1$s\nANDROID_SDK_HOME is meant to be the path of the preference folder expected by the Android tools.\nIt should NOT be set to the same as the root of your SDK.\nTo set a custom SDK Location, use ANDROID_SDK_ROOT.\nIf this is not set we default to: %2$s", path, AndroidLocation.findValidPath(environmentProvider, logger, TEST_TMPDIR, USER_HOME, HOME));
                if (silent) {
                    logger.warning(str, new Object[0]);
                } else {
                    throw new AndroidLocationException(str);
                }
            }
            return path;
        }

        private static boolean isSdkRootWithoutDotAndroid(File folder) {
            return subFolderExist(folder, SdkConstants.FD_PLATFORMS) && subFolderExist(folder, SdkConstants.FD_PLATFORM_TOOLS) && !subFolderExist(folder, AndroidLocation.FOLDER_DOT_ANDROID);
        }

        private static boolean subFolderExist(File folder, String subFolder) {
            return new File(folder, subFolder).isDirectory();
        }
    }

    public static String getFolder() throws AndroidLocationException {
        return getFolder(EnvironmentProvider.DIRECT, new StdLogger(StdLogger.Level.VERBOSE));
    }

    public static String getFolder(EnvironmentProvider environmentProvider, ILogger logger) throws AndroidLocationException {
        if (sPrefsLocation == null) {
            sPrefsLocation = findHomeFolder(environmentProvider, logger);
        }
        File file = new File(sPrefsLocation);
        if (!file.exists()) {
            try {
                FileUtils.mkdirs(file);
            } catch (SecurityException e) {
                AndroidLocationException androidLocationException = new AndroidLocationException(String.format("Unable to create folder '%1$s'. This is the path of preference folder expected by the Android tools.", sPrefsLocation));
                androidLocationException.initCause(e);
                throw androidLocationException;
            }
        } else if (file.isFile()) {
            throw new AndroidLocationException(String.format("%1$s is not a directory!\nThis is the path of preference folder expected by the Android tools.", sPrefsLocation));
        }
        return sPrefsLocation;
    }

    public static String getFolderWithoutWrites() {
        if (sPrefsLocation == null) {
            try {
                sPrefsLocation = findHomeFolder(EnvironmentProvider.DIRECT, new StdLogger(StdLogger.Level.VERBOSE));
            } catch (AndroidLocationException unused) {
                return null;
            }
        }
        return sPrefsLocation;
    }

    public static String getAvdFolder() throws AndroidLocationException {
        if (sAvdLocation == null) {
            String strFindValidPath = findValidPath(EnvironmentProvider.DIRECT, new StdLogger(StdLogger.Level.VERBOSE), Global.ANDROID_AVD_HOME);
            if (strFindValidPath == null) {
                strFindValidPath = getFolder() + FOLDER_AVD;
            }
            sAvdLocation = strFindValidPath;
            if (!strFindValidPath.endsWith(File.separator)) {
                sAvdLocation += File.separator;
            }
        }
        return sAvdLocation;
    }

    public static String getUserHomeFolder() throws AndroidLocationException {
        return findValidPath(EnvironmentProvider.DIRECT, new StdLogger(StdLogger.Level.VERBOSE), Global.TEST_TMPDIR, Global.USER_HOME, Global.HOME);
    }

    private static String findHomeFolder(EnvironmentProvider environmentProvider, ILogger logger) throws AndroidLocationException {
        String strFindValidPath = findValidPath(environmentProvider, logger, Global.ANDROID_PREFS_ROOT, Global.TEST_TMPDIR, Global.USER_HOME, Global.HOME);
        if (strFindValidPath == null) {
            throw new AndroidLocationException("prop: " + environmentProvider.getSystemProperty(ANDROID_PREFS_ROOT));
        }
        if (!strFindValidPath.endsWith(File.separator)) {
            strFindValidPath = strFindValidPath + File.separator;
        }
        return strFindValidPath + FOLDER_DOT_ANDROID + File.separator;
    }

    public static void resetFolder() {
        sPrefsLocation = null;
        sAvdLocation = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String findValidPath(EnvironmentProvider environmentProvider, ILogger logger, Global... vars) throws AndroidLocationException {
        for (Global global : vars) {
            String strValidatePath = global.validatePath(environmentProvider, logger, true);
            if (strValidatePath != null) {
                return strValidatePath;
            }
        }
        return null;
    }
}
