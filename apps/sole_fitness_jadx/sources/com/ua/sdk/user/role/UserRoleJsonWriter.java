package com.ua.sdk.user.role;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.ua.sdk.UaException;
import com.ua.sdk.UaLog;
import com.ua.sdk.internal.AbstractGsonWriter;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStreamWriter;

/* loaded from: classes2.dex */
public class UserRoleJsonWriter extends AbstractGsonWriter<UserRole> {
    public UserRoleJsonWriter(Gson gson) {
        super(gson);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ua.sdk.internal.AbstractGsonWriter
    public void write(UserRole userRole, Gson gson, OutputStreamWriter outputStreamWriter) throws JsonIOException, IOException, UaException {
        gson.toJson(UserRoleTO.toTransferObject(userRole), outputStreamWriter);
        try {
            outputStreamWriter.flush();
        } catch (InterruptedIOException unused) {
            throw new UaException(UaException.Code.CANCELED);
        } catch (IOException e) {
            UaLog.error("Unable to flush UserRoleJsonWriter during write.");
            throw new UaException(e);
        }
    }
}
