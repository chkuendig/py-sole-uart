package uk.co.senab.bitmapcache;

import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes3.dex */
class IoUtils {
    IoUtils() {
    }

    static void closeStream(InputStream inputStream) throws IOException {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                Log.i(Constants.LOG_TAG, "Failed to close InputStream", e);
            }
        }
    }

    static void closeStream(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                Log.i(Constants.LOG_TAG, "Failed to close OutputStream", e);
            }
        }
    }

    static long copy(File file, OutputStream outputStream) throws IOException {
        return copy(new FileInputStream(file), outputStream);
    }

    static long copy(InputStream inputStream, File file) throws IOException {
        return copy(inputStream, new FileOutputStream(file));
    }

    private static long copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        try {
            byte[] bArr = new byte[4096];
            long j = 0;
            while (true) {
                int i = inputStream.read(bArr);
                if (-1 != i) {
                    outputStream.write(bArr, 0, i);
                    j += i;
                } else {
                    outputStream.flush();
                    return j;
                }
            }
        } finally {
            closeStream(inputStream);
            closeStream(outputStream);
        }
    }
}
