package com.android.utils;

import java.io.File;

/* loaded from: classes3.dex */
public class NdkUtils {
    private static String removeFileExtension(String output) {
        int iLastIndexOf = output.lastIndexOf(46);
        return iLastIndexOf == -1 ? output : output.substring(0, iLastIndexOf);
    }

    public static String getTargetNameFromBuildOutputFile(File output) {
        return getTargetNameFromBuildOutputFileName(output.getName());
    }

    public static String getTargetNameFromBuildOutputFileName(String basename) {
        String strRemoveFileExtension = removeFileExtension(basename);
        return strRemoveFileExtension.startsWith("lib") ? strRemoveFileExtension.substring(3) : strRemoveFileExtension;
    }
}
