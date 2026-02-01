package com.ua.sdk.internal;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.ua.sdk.UaException;
import com.ua.sdk.UaLog;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/* loaded from: classes2.dex */
public abstract class AbstractGsonWriter<T> implements JsonWriter<T> {
    private Gson mGson;

    protected abstract void write(T t, Gson gson, OutputStreamWriter outputStreamWriter) throws UaException;

    public AbstractGsonWriter(Gson gson) throws NullPointerException {
        Precondition.isNotNull(gson);
        this.mGson = gson;
    }

    @Override // com.ua.sdk.internal.JsonWriter
    public final void write(T t, OutputStream outputStream) throws IOException, UaException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        try {
            write(t, this.mGson, outputStreamWriter);
            try {
                outputStreamWriter.flush();
            } catch (InterruptedIOException unused) {
                throw new UaException(UaException.Code.CANCELED);
            } catch (IOException e) {
                UaLog.error("Unable to flush json writer during write.", (Throwable) e);
                throw new UaException(e);
            }
        } catch (JsonIOException e2) {
            UaLog.error("Unable to write json.", (Throwable) e2);
            throw new UaException(e2);
        }
    }
}
