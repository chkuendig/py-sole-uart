package com.google.android.gms.internal.wearable;

import android.os.ParcelFileDescriptor;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzj {
    public static File zza(ParcelFileDescriptor parcelFileDescriptor, File file) throws IOException {
        FileOutputStream fileOutputStream;
        IOException e;
        ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor);
        try {
            file.mkdirs();
            File fileCreateTempFile = File.createTempFile("asset", ".tmp", file);
            FileOutputStream fileOutputStream2 = null;
            try {
                fileOutputStream = new FileOutputStream(fileCreateTempFile);
                try {
                    try {
                        byte[] bArr = new byte[10240];
                        while (true) {
                            int i = autoCloseInputStream.read(bArr);
                            if (i < 0) {
                                zzb(autoCloseInputStream);
                                zzb(fileOutputStream);
                                return fileCreateTempFile;
                            }
                            fileOutputStream.write(bArr, 0, i);
                        }
                    } catch (IOException e2) {
                        e = e2;
                        throw new RuntimeException(e);
                    }
                } catch (Throwable th) {
                    FileOutputStream fileOutputStream3 = fileOutputStream;
                    th = th;
                    fileOutputStream2 = fileOutputStream3;
                    zzb(autoCloseInputStream);
                    zzb(fileOutputStream2);
                    fileCreateTempFile.delete();
                    throw th;
                }
            } catch (IOException e3) {
                fileOutputStream = null;
                e = e3;
            } catch (Throwable th2) {
                th = th2;
                zzb(autoCloseInputStream);
                zzb(fileOutputStream2);
                fileCreateTempFile.delete();
                throw th;
            }
        } finally {
            zzb(autoCloseInputStream);
        }
    }

    private static void zzb(@Nullable Closeable closeable) throws IOException {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }
}
