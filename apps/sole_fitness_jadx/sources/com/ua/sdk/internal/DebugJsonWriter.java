package com.ua.sdk.internal;

import com.ua.sdk.UaException;
import com.ua.sdk.UaLog;
import com.ua.sdk.util.Streams;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public class DebugJsonWriter<T> implements JsonWriter<T> {
    private final JsonWriter<T> writer;

    public DebugJsonWriter(JsonWriter<T> jsonWriter) throws NullPointerException {
        Precondition.isNotNull(jsonWriter);
        this.writer = jsonWriter;
    }

    @Override // com.ua.sdk.internal.JsonWriter
    public void write(T t, OutputStream outputStream) throws Throwable {
        String str;
        String str2 = null;
        try {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                this.writer.write(t, byteArrayOutputStream);
                str = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
            } catch (IOException e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            Streams.writeFully(str, outputStream);
            UaLog.debug("request=%s", str);
        } catch (IOException e2) {
            e = e2;
            str2 = str;
            throw new UaException(e);
        } catch (Throwable th2) {
            th = th2;
            str2 = str;
            UaLog.debug("request=%s", str2);
            throw th;
        }
    }
}
