package com.ua.sdk.authentication;

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
public class InternalTokenCredentialWriter implements JsonWriter<InternalTokenCredential> {
    private Gson gson;

    public InternalTokenCredentialWriter(Gson gson) {
        this.gson = gson;
    }

    @Override // com.ua.sdk.internal.JsonWriter
    public void write(InternalTokenCredential internalTokenCredential, OutputStream outputStream) throws JsonIOException, IOException, UaException {
        InternalTokenCredentialTO transferObject = InternalTokenCredentialTO.toTransferObject(internalTokenCredential);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        this.gson.toJson(transferObject, outputStreamWriter);
        try {
            outputStreamWriter.flush();
        } catch (InterruptedIOException unused) {
            throw new UaException(UaException.Code.CANCELED);
        } catch (IOException e) {
            UaLog.error("Unable to flush InternalTokenCredentialWriter during write.");
            throw new UaException(e);
        }
    }
}
