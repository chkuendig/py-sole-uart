package com.ua.sdk.friendship;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.ua.sdk.UaException;
import com.ua.sdk.UaLog;
import com.ua.sdk.internal.JsonWriter;
import com.ua.sdk.net.json.GsonFactory;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/* loaded from: classes2.dex */
public class FriendshipPageJsonWriter implements JsonWriter<FriendshipListImpl> {
    @Override // com.ua.sdk.internal.JsonWriter
    public void write(FriendshipListImpl friendshipListImpl, OutputStream outputStream) throws JsonIOException, IOException, UaException {
        Gson gsonNewInstance = GsonFactory.newInstance();
        FriendshipPageTransferObject transferObject = FriendshipPageTransferObject.toTransferObject(friendshipListImpl);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        gsonNewInstance.toJson(transferObject, outputStreamWriter);
        try {
            outputStreamWriter.flush();
        } catch (InterruptedIOException unused) {
            throw new UaException(UaException.Code.CANCELED);
        } catch (IOException e) {
            UaLog.error("Unable to flush UserJsonWriter during write.");
            throw new UaException(e);
        }
    }
}
