package com.ua.sdk.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/* loaded from: classes2.dex */
public class Streams {
    public static void writeFully(CharSequence charSequence, OutputStream outputStream) throws IOException {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            bufferedWriter.write(charSequence.toString());
            bufferedWriter.flush();
            bufferedWriter.close();
        } finally {
            outputStream.close();
        }
    }

    public static String readFully(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            char[] cArr = new char[1024];
            for (int i = bufferedReader.read(cArr); i > 0; i = bufferedReader.read(cArr)) {
                stringBuffer.append(cArr, 0, i);
            }
            return stringBuffer.toString();
        } finally {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }
}
