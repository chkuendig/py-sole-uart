package com.ua.sdk.page.follow;

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
public class PageFollowJsonWriter implements JsonWriter<PageFollow> {
    private Gson gson;

    public PageFollowJsonWriter(Gson gson) {
        this.gson = gson;
    }

    @Override // com.ua.sdk.internal.JsonWriter
    public void write(PageFollow pageFollow, OutputStream outputStream) throws JsonIOException, IOException, UaException {
        PageFollowTransferObject pageFollowTransferObjectFromPageFollow = PageFollowTransferObject.fromPageFollow(pageFollow);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        this.gson.toJson(pageFollowTransferObjectFromPageFollow, outputStreamWriter);
        try {
            outputStreamWriter.flush();
        } catch (InterruptedIOException unused) {
            throw new UaException(UaException.Code.CANCELED);
        } catch (IOException e) {
            UaLog.error("Unable to flush PageFollowJsonWriter during write.");
            throw new UaException(e);
        }
    }
}
