package com.android.utils;

import com.android.SdkConstants;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: BuildScriptUtil.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u000e\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0001\u001a\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0001\u001a\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0001¨\u0006\t"}, d2 = {"findGradleBuildFile", "Ljava/io/File;", "dirPath", "findGradleSettingsFile", "isDefaultGradleBuildFile", "", "filePath", "isGradleScript", "isGradleSettingsFile", "common"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class BuildScriptUtil {
    public static final File findGradleBuildFile(File dirPath) {
        Intrinsics.checkNotNullParameter(dirPath, "dirPath");
        File file = new File(dirPath, SdkConstants.FN_BUILD_GRADLE);
        if (file.isFile()) {
            return file;
        }
        File file2 = new File(dirPath, SdkConstants.FN_BUILD_GRADLE_KTS);
        return file2.isFile() ? file2 : file;
    }

    public static final File findGradleSettingsFile(File dirPath) {
        Intrinsics.checkNotNullParameter(dirPath, "dirPath");
        File file = new File(dirPath, SdkConstants.FN_SETTINGS_GRADLE);
        if (file.isFile()) {
            return file;
        }
        File file2 = new File(dirPath, SdkConstants.FN_SETTINGS_GRADLE_KTS);
        return file2.isFile() ? file2 : file;
    }

    public static final boolean isGradleScript(File filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        if (!filePath.isFile()) {
            return false;
        }
        String path = filePath.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "filePath.path");
        if (!StringsKt.endsWith$default(path, "gradle", false, 2, (Object) null)) {
            String path2 = filePath.getPath();
            Intrinsics.checkNotNullExpressionValue(path2, "filePath.path");
            if (!StringsKt.endsWith$default(path2, SdkConstants.EXT_GRADLE_KTS, false, 2, (Object) null)) {
                return false;
            }
        }
        return true;
    }

    public static final boolean isDefaultGradleBuildFile(File filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        if (!filePath.isFile()) {
            return false;
        }
        String path = filePath.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "filePath.path");
        if (!StringsKt.endsWith$default(path, SdkConstants.FN_BUILD_GRADLE, false, 2, (Object) null) || !Intrinsics.areEqual(filePath.getName(), SdkConstants.FN_BUILD_GRADLE)) {
            String path2 = filePath.getPath();
            Intrinsics.checkNotNullExpressionValue(path2, "filePath.path");
            if (!StringsKt.endsWith$default(path2, SdkConstants.FN_BUILD_GRADLE_KTS, false, 2, (Object) null) || !Intrinsics.areEqual(filePath.getName(), SdkConstants.FN_BUILD_GRADLE_KTS)) {
                return false;
            }
        }
        return true;
    }

    public static final boolean isGradleSettingsFile(File filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        if (!filePath.isFile()) {
            return false;
        }
        String path = filePath.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "filePath.path");
        if (!StringsKt.endsWith$default(path, SdkConstants.FN_SETTINGS_GRADLE, false, 2, (Object) null) || !Intrinsics.areEqual(filePath.getName(), SdkConstants.FN_SETTINGS_GRADLE)) {
            String path2 = filePath.getPath();
            Intrinsics.checkNotNullExpressionValue(path2, "filePath.path");
            if (!StringsKt.endsWith$default(path2, SdkConstants.FN_SETTINGS_GRADLE_KTS, false, 2, (Object) null) || !Intrinsics.areEqual(filePath.getName(), SdkConstants.FN_SETTINGS_GRADLE_KTS)) {
                return false;
            }
        }
        return true;
    }
}
