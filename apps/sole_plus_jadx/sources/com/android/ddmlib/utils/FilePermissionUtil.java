package com.android.ddmlib.utils;

import com.android.ddmlib.Log;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes3.dex */
public class FilePermissionUtil {

    /* renamed from: com.android.ddmlib.utils.FilePermissionUtil$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$nio$file$attribute$PosixFilePermission;

        static {
            int[] iArr = new int[PosixFilePermission.values().length];
            $SwitchMap$java$nio$file$attribute$PosixFilePermission = iArr;
            try {
                iArr[PosixFilePermission.OWNER_READ.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$java$nio$file$attribute$PosixFilePermission[PosixFilePermission.OWNER_WRITE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$java$nio$file$attribute$PosixFilePermission[PosixFilePermission.OWNER_EXECUTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$java$nio$file$attribute$PosixFilePermission[PosixFilePermission.GROUP_READ.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$java$nio$file$attribute$PosixFilePermission[PosixFilePermission.GROUP_WRITE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$java$nio$file$attribute$PosixFilePermission[PosixFilePermission.GROUP_EXECUTE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$java$nio$file$attribute$PosixFilePermission[PosixFilePermission.OTHERS_READ.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$java$nio$file$attribute$PosixFilePermission[PosixFilePermission.OTHERS_WRITE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$java$nio$file$attribute$PosixFilePermission[PosixFilePermission.OTHERS_EXECUTE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    private static int numericalPermission(PosixFilePermission p) {
        switch (AnonymousClass1.$SwitchMap$java$nio$file$attribute$PosixFilePermission[p.ordinal()]) {
            case 1:
                return 256;
            case 2:
                return 128;
            case 3:
                return 64;
            case 4:
                return 32;
            case 5:
                return 16;
            case 6:
                return 8;
            case 7:
                return 4;
            case 8:
                return 2;
            case 9:
                return 1;
            default:
                return 0;
        }
    }

    public static int getFilePosixPermission(File file) throws IOException {
        Set hashSet = new HashSet();
        int iNumericalPermission = 0;
        try {
            hashSet = Files.getPosixFilePermissions(file.toPath(), new LinkOption[0]);
        } catch (IOException e) {
            Log.e("ddms", "Error when reading file permission: " + e.getMessage());
            return 420;
        } catch (UnsupportedOperationException unused) {
            if (file.canRead()) {
                hashSet.add(PosixFilePermission.OWNER_READ);
            }
            if (file.canWrite()) {
                hashSet.add(PosixFilePermission.OWNER_WRITE);
            }
            if (file.canExecute()) {
                hashSet.add(PosixFilePermission.OWNER_EXECUTE);
            }
            if (hashSet.isEmpty()) {
                return 420;
            }
        }
        Log.d("ddms", String.format("Reading file permission of %s as: %s", file.getAbsoluteFile(), PosixFilePermissions.toString(hashSet)));
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            iNumericalPermission += numericalPermission((PosixFilePermission) it.next());
        }
        return iNumericalPermission;
    }
}
