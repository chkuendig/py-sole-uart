package com.sun.jna.platform.win32;

import com.sun.jna.platform.FileUtils;
import com.sun.jna.platform.win32.ShellAPI;
import java.io.File;
import java.io.IOException;

/* loaded from: classes4.dex */
public class W32FileUtils extends FileUtils {
    @Override // com.sun.jna.platform.FileUtils
    public boolean hasTrash() {
        return true;
    }

    @Override // com.sun.jna.platform.FileUtils
    public void moveToTrash(File... fileArr) throws IOException {
        Shell32 shell32 = Shell32.INSTANCE;
        ShellAPI.SHFILEOPSTRUCT shfileopstruct = new ShellAPI.SHFILEOPSTRUCT();
        shfileopstruct.wFunc = 3;
        int length = fileArr.length;
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = fileArr[i].getAbsolutePath();
        }
        shfileopstruct.pFrom = shfileopstruct.encodePaths(strArr);
        shfileopstruct.fFlags = (short) 1620;
        int iSHFileOperation = shell32.SHFileOperation(shfileopstruct);
        if (iSHFileOperation != 0) {
            throw new IOException("Move to trash failed: " + shfileopstruct.pFrom + ": " + Kernel32Util.formatMessageFromLastErrorCode(iSHFileOperation));
        }
        if (shfileopstruct.fAnyOperationsAborted) {
            throw new IOException("Move to trash aborted");
        }
    }
}
