package com.android.prefs;

import androidx.core.app.NotificationCompat;
import com.android.io.CancellableFileIo;
import com.android.utils.EnvironmentProvider;
import com.android.utils.ILogger;
import com.google.common.annotations.VisibleForTesting;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.Collection;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AbstractAndroidLocations.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB!\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0017\u001a\u00020\nH\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0007R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/android/prefs/AbstractAndroidLocations;", "Lcom/android/prefs/AndroidLocationsProvider;", "environmentProvider", "Lcom/android/utils/EnvironmentProvider;", "logger", "Lcom/android/utils/ILogger;", NotificationCompat.GROUP_KEY_SILENT, "", "(Lcom/android/utils/EnvironmentProvider;Lcom/android/utils/ILogger;Z)V", "avdLocation", "Ljava/nio/file/Path;", "getAvdLocation", "()Ljava/nio/file/Path;", "gradleAvdLocation", "getGradleAvdLocation", "internalAvdLocation", "internalGradleAvdLocation", "internalPrefsLocation", "internalUserHomeLocation", "prefsLocation", "getPrefsLocation", "userHomeLocation", "getUserHomeLocation", "computeAndroidFolder", "resetPathsForTest", "", "Companion", "common"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public abstract class AbstractAndroidLocations implements AndroidLocationsProvider {
    private final EnvironmentProvider environmentProvider;
    private Path internalAvdLocation;
    private Path internalGradleAvdLocation;
    private Path internalPrefsLocation;
    private Path internalUserHomeLocation;
    private final ILogger logger;
    private final boolean silent;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String FOLDER_DOT_ANDROID = AndroidLocation.FOLDER_DOT_ANDROID;
    public static final String FOLDER_AVD = AndroidLocation.FOLDER_AVD;
    public static final String FOLDER_GRADLE_AVD = "gradle-managed";
    public static final String ANDROID_PREFS_ROOT = AndroidLocation.ANDROID_PREFS_ROOT;
    private static final String ANDROID_USER_HOME = "ANDROID_USER_HOME";

    public static final String getANDROID_USER_HOME() {
        return INSTANCE.getANDROID_USER_HOME();
    }

    protected AbstractAndroidLocations(EnvironmentProvider environmentProvider, ILogger logger, boolean z) {
        Intrinsics.checkNotNullParameter(environmentProvider, "environmentProvider");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.environmentProvider = environmentProvider;
        this.logger = logger;
        this.silent = z;
    }

    public /* synthetic */ AbstractAndroidLocations(EnvironmentProvider environmentProvider, ILogger iLogger, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(environmentProvider, iLogger, (i & 4) != 0 ? true : z);
    }

    /* compiled from: AbstractAndroidLocations.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002R\u001c\u0010\u0006\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/android/prefs/AbstractAndroidLocations$Companion;", "", "()V", AndroidLocation.ANDROID_PREFS_ROOT, "", "getANDROID_PREFS_ROOT$annotations", "ANDROID_USER_HOME", "getANDROID_USER_HOME$annotations", "getANDROID_USER_HOME", "()Ljava/lang/String;", "FOLDER_AVD", "FOLDER_DOT_ANDROID", "FOLDER_GRADLE_AVD", "common"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Deprecated(message = "Use ANDROID_USER_HOME")
        public static /* synthetic */ void getANDROID_PREFS_ROOT$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getANDROID_USER_HOME$annotations() {
        }

        private Companion() {
        }

        public final String getANDROID_USER_HOME() {
            return AbstractAndroidLocations.ANDROID_USER_HOME;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.android.prefs.AndroidLocationsProvider
    public Path getPrefsLocation() throws AndroidLocationsException, IOException {
        Path pathComputeAndroidFolder = this.internalPrefsLocation;
        if (pathComputeAndroidFolder == null) {
            pathComputeAndroidFolder = computeAndroidFolder();
            this.internalPrefsLocation = pathComputeAndroidFolder;
            if (CancellableFileIo.notExists(pathComputeAndroidFolder, new LinkOption[0])) {
                try {
                    Files.createDirectories(pathComputeAndroidFolder, new FileAttribute[0]);
                } catch (SecurityException e) {
                    throw new AndroidLocationsException("Unable to create folder '" + pathComputeAndroidFolder + "'.\n|This is the path of preference folder expected by the Android tools.", e);
                }
            } else if (CancellableFileIo.isRegularFile(pathComputeAndroidFolder, new LinkOption[0])) {
                throw new AndroidLocationsException(pathComputeAndroidFolder + " is not a directory!\nThis is the path of preference folder expected by the Android tools.", null, 2, 0 == true ? 1 : 0);
            }
        }
        return pathComputeAndroidFolder;
    }

    @Override // com.android.prefs.AndroidLocationsProvider
    public Path getAvdLocation() throws AndroidLocationsException {
        Path pathSinglePathOf = this.internalAvdLocation;
        if (pathSinglePathOf == null) {
            pathSinglePathOf = new PathLocator(this.environmentProvider).singlePathOf(Global.ANDROID_AVD_HOME);
            if (pathSinglePathOf == null) {
                pathSinglePathOf = getPrefsLocation().resolve(FOLDER_AVD);
            }
            this.internalAvdLocation = pathSinglePathOf;
            Intrinsics.checkNotNullExpressionValue(pathSinglePathOf, "PathLocator(environmentP…nternalAvdLocation = it }");
        }
        return pathSinglePathOf;
    }

    @Override // com.android.prefs.AndroidLocationsProvider
    public Path getGradleAvdLocation() throws AndroidLocationsException {
        Path path = this.internalGradleAvdLocation;
        if (path != null) {
            return path;
        }
        Path pathResolve = getAvdLocation().resolve(FOLDER_GRADLE_AVD);
        this.internalGradleAvdLocation = pathResolve;
        Intrinsics.checkNotNullExpressionValue(pathResolve, "avdLocation\n            …lGradleAvdLocation = it }");
        return pathResolve;
    }

    @Override // com.android.prefs.AndroidLocationsProvider
    public Path getUserHomeLocation() throws AndroidLocationsException {
        Path path = this.internalUserHomeLocation;
        if (path != null) {
            return path;
        }
        PathLocator pathLocator = new PathLocator(this.environmentProvider);
        Path pathFirstPathOf = pathLocator.firstPathOf(Global.TEST_TMPDIR, Global.XGD_CONFIG_HOME, Global.USER_HOME, Global.HOME);
        if (pathFirstPathOf == null) {
            pathFirstPathOf = null;
        } else {
            this.internalUserHomeLocation = pathFirstPathOf;
        }
        if (pathFirstPathOf != null) {
            return pathFirstPathOf;
        }
        throw AndroidLocationsException.INSTANCE.createForHomeLocation$common(pathLocator.getVisitedVariables());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Path computeAndroidFolder() throws AndroidLocationsException {
        Throwable th = null;
        Object[] objArr = 0;
        AndroidPathLocator androidPathLocator = new AndroidPathLocator(this.environmentProvider, !this.silent ? this.logger : null);
        int i = 2;
        Path pathSinglePathOf = androidPathLocator.singlePathOf(Global.ANDROID_USER_HOME, Global.ANDROID_PREFS_ROOT, Global.ANDROID_SDK_HOME);
        if (pathSinglePathOf != null) {
            if (androidPathLocator.getVisitedVariables().size() > 1 && !this.silent) {
                this.logger.warning(AbstractAndroidLocationsKt.combineLocationValuesIntoMessage$default(androidPathLocator.getVisitedVariables(), "More than one location points to the Android preference location\nbut only one is valid", null, new Function1<QueryResult, String>() { // from class: com.android.prefs.AbstractAndroidLocations$computeAndroidFolder$message$1
                    @Override // kotlin.jvm.functions.Function1
                    public final String invoke(QueryResult value) {
                        Intrinsics.checkNotNullParameter(value, "value");
                        if (!value.getGlobal().getMustExist() || CancellableFileIo.isDirectory(value.getPath(), new LinkOption[0])) {
                            return null;
                        }
                        return "does not exist";
                    }
                }, 4, null), new Object[0]);
            }
            return pathSinglePathOf;
        }
        PathLocator pathLocator = new PathLocator(this.environmentProvider);
        Path pathFirstPathOf = pathLocator.firstPathOf(Global.TEST_TMPDIR, Global.XGD_CONFIG_HOME, Global.USER_HOME, Global.HOME);
        Path pathResolve = pathFirstPathOf == null ? null : pathFirstPathOf.resolve(FOLDER_DOT_ANDROID);
        if (pathResolve != null) {
            return pathResolve;
        }
        throw new AndroidLocationsException(AbstractAndroidLocationsKt.combineLocationValuesIntoMessage$default(CollectionsKt.plus((Collection) androidPathLocator.getVisitedVariables(), (Iterable) pathLocator.getVisitedVariables()), "Unable to find the location for the android preferences.\nThe following locations have been checked, but they do not exist:", null, null, 12, null), th, i, objArr == true ? 1 : 0);
    }

    @VisibleForTesting
    public final void resetPathsForTest() {
        this.internalPrefsLocation = null;
        this.internalAvdLocation = null;
        this.internalGradleAvdLocation = null;
        this.internalUserHomeLocation = null;
    }
}
