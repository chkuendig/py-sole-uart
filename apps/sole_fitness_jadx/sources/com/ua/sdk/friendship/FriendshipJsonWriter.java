package com.ua.sdk.friendship;

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
public class FriendshipJsonWriter implements JsonWriter<Friendship> {
    private Gson gson;

    public FriendshipJsonWriter(Gson gson) {
        this.gson = gson;
    }

    @Override // com.ua.sdk.internal.JsonWriter
    public void write(Friendship friendship, OutputStream outputStream) throws JsonIOException, IOException, UaException, NullPointerException {
        FriendshipTransferObject friendshipTransferObjectFromFriendship = FriendshipTransferObject.fromFriendship(friendship);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        this.gson.toJson(friendshipTransferObjectFromFriendship, outputStreamWriter);
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
