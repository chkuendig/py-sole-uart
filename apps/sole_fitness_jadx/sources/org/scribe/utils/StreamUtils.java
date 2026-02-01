package org.scribe.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* loaded from: classes2.dex */
public class StreamUtils {
    private StreamUtils() {
    }

    public static String getStreamContents(InputStream inputStream) throws IOException {
        int i;
        Preconditions.checkNotNull(inputStream, "Cannot get String from a null object");
        try {
            char[] cArr = new char[65536];
            StringBuilder sb = new StringBuilder();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            do {
                i = inputStreamReader.read(cArr, 0, 65536);
                if (i > 0) {
                    sb.append(cArr, 0, i);
                }
            } while (i >= 0);
            inputStreamReader.close();
            return sb.toString();
        } catch (IOException e) {
            throw new IllegalStateException("Error while reading response body", e);
        }
    }
}
