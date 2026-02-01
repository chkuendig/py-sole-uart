package com.cocoahero.android.geojson.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* loaded from: classes.dex */
public class StreamUtils {
    public static String toString(InputStream inputStream) throws IOException {
        return toString(inputStream, "UTF-8");
    }

    public static String toString(InputStream inputStream, String str) throws IOException {
        char[] cArr = new char[1024];
        StringBuilder sb = new StringBuilder();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, str);
        while (true) {
            int i = inputStreamReader.read(cArr);
            if (i >= 0) {
                sb.append(cArr, 0, i);
            } else {
                inputStreamReader.close();
                return sb.toString();
            }
        }
    }
}
