package com.ua.sdk.util;

import android.content.Context;
import com.ua.sdk.UaLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/* loaded from: classes2.dex */
public class FileUtil {
    public static File getFile(Context context, String str, String str2) throws FileNotFoundException {
        return new File(getFullPathToFile(context.getFilesDir().toString(), str, str2));
    }

    public static FileOutputStream openFileOutput(Context context, String str, String str2) throws FileNotFoundException {
        File file = getFile(context, str, str2);
        try {
            return new FileOutputStream(file, false);
        } catch (FileNotFoundException unused) {
            UaLog.info("Could not open file " + str2 + " for writing, creating parent dir");
            File parentFile = file.getParentFile();
            parentFile.mkdirs();
            parentFile.setWritable(true);
            return new FileOutputStream(file, false);
        }
    }

    public static FileInputStream openFileInput(Context context, String str, String str2) throws FileNotFoundException {
        return new FileInputStream(new File(getFullPathToFile(context.getFilesDir().toString(), str, str2)));
    }

    private static String getFullPathToFile(String str, String str2, String str3) {
        UaLog.debug("Asked for full path to %s in %s", str3, str2);
        return str + File.separator + str2 + File.separator + str3;
    }
}
