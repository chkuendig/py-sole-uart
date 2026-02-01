package com.android.prefs;

import com.android.SdkConstants;
import com.android.io.CancellableFileIo;
import com.android.utils.EnvironmentProvider;
import com.android.utils.ILogger;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: AbstractAndroidLocations.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0014J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH\u0002J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\bH\u0002J\u0014\u0010\u0010\u001a\u00020\r*\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/android/prefs/AndroidPathLocator;", "Lcom/android/prefs/PathLocator;", "environmentProvider", "Lcom/android/utils/EnvironmentProvider;", "logger", "Lcom/android/utils/ILogger;", "(Lcom/android/utils/EnvironmentProvider;Lcom/android/utils/ILogger;)V", "handlePath", "Ljava/nio/file/Path;", "globalVar", "Lcom/android/prefs/Global;", "path", "isSdkRootWithoutDotAndroid", "", "folder", "validateAndroidSdkHomeValue", "hasSubFolder", "subFolder", "", "common"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
final class AndroidPathLocator extends PathLocator {
    private final ILogger logger;

    public /* synthetic */ AndroidPathLocator(EnvironmentProvider environmentProvider, ILogger iLogger, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(environmentProvider, (i & 2) != 0 ? null : iLogger);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidPathLocator(EnvironmentProvider environmentProvider, ILogger iLogger) {
        super(environmentProvider);
        Intrinsics.checkNotNullParameter(environmentProvider, "environmentProvider");
        this.logger = iLogger;
    }

    @Override // com.android.prefs.PathLocator
    protected Path handlePath(Global globalVar, Path path) {
        Intrinsics.checkNotNullParameter(globalVar, "globalVar");
        Intrinsics.checkNotNullParameter(path, "path");
        if (super.handlePath(globalVar, path) == null) {
            return null;
        }
        if (globalVar != Global.ANDROID_SDK_HOME || validateAndroidSdkHomeValue(path)) {
            return globalVar.getAndroidLeaf() != null ? path.resolve(globalVar.getAndroidLeaf()) : path;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean validateAndroidSdkHomeValue(Path path) throws AndroidLocationsException {
        if (!CancellableFileIo.isDirectory(path, new LinkOption[0])) {
            return false;
        }
        if (!isSdkRootWithoutDotAndroid(path)) {
            return true;
        }
        String strTrimIndent = StringsKt.trimIndent("\n                        ANDROID_SDK_HOME is set to the root of your SDK: " + path + "\n                        ANDROID_SDK_HOME was meant to be the parent path of the preference folder expected by the Android tools.\n                        It is now deprecated.\n\n                        To set a custom preference folder location, use ANDROID_USER_HOME.\n\n                        It should NOT be set to the same directory as the root of your SDK.\n                        To set a custom SDK location, use ANDROID_HOME.\n                        ");
        ILogger iLogger = this.logger;
        if (iLogger != null) {
            iLogger.warning(strTrimIndent, new Object[0]);
            return true;
        }
        throw new AndroidLocationsException(strTrimIndent, null, 2, 0 == true ? 1 : 0);
    }

    private final boolean isSdkRootWithoutDotAndroid(Path folder) {
        return hasSubFolder(folder, SdkConstants.FD_PLATFORMS) && hasSubFolder(folder, SdkConstants.FD_PLATFORM_TOOLS) && !hasSubFolder(folder, AbstractAndroidLocations.FOLDER_DOT_ANDROID);
    }

    private final boolean hasSubFolder(Path path, String str) {
        return CancellableFileIo.isDirectory(path.resolve(str), new LinkOption[0]);
    }
}
