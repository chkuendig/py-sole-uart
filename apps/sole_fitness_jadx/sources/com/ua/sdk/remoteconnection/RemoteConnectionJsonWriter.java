package com.ua.sdk.remoteconnection;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.ua.sdk.UaException;
import com.ua.sdk.UaLog;
import com.ua.sdk.internal.JsonWriter;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/* loaded from: classes2.dex */
public class RemoteConnectionJsonWriter implements JsonWriter<RemoteConnection> {
    private Gson gson;

    public RemoteConnectionJsonWriter(Gson gson) {
        this.gson = gson;
    }

    @Override // com.ua.sdk.internal.JsonWriter
    public void write(RemoteConnection remoteConnection, OutputStream outputStream) throws JsonIOException, IOException, UaException {
        RemoteConnectionTransferObject remoteConnectionTransferObjectFromRemoteConnection = RemoteConnectionTransferObject.fromRemoteConnection(remoteConnection);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        this.gson.toJson(remoteConnectionTransferObjectFromRemoteConnection, outputStreamWriter);
        try {
            outputStreamWriter.flush();
        } catch (InterruptedIOException unused) {
            throw new UaException(UaException.Code.CANCELED);
        } catch (IOException e) {
            UaLog.error("Unable to flush RemoteConnectionJsonWriter during write.");
            throw new UaException(e);
        }
    }
}
