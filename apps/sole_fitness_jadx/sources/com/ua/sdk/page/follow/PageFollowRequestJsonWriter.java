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
public class PageFollowRequestJsonWriter implements JsonWriter<PageFollow> {
    private Gson gson;

    public PageFollowRequestJsonWriter(Gson gson) {
        this.gson = gson;
    }

    @Override // com.ua.sdk.internal.JsonWriter
    public void write(PageFollow pageFollow, OutputStream outputStream) throws JsonIOException, IOException, UaException {
        PageFollowRequestTransferObject pageFollowRequestTransferObjectFromPageFollow = PageFollowRequestTransferObject.fromPageFollow(pageFollow);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        this.gson.toJson(pageFollowRequestTransferObjectFromPageFollow, outputStreamWriter);
        try {
            outputStreamWriter.flush();
        } catch (InterruptedIOException unused) {
            throw new UaException(UaException.Code.CANCELED);
        } catch (IOException e) {
            UaLog.error("Unable to flush PageFollowRequestJsonWriter during write.");
            throw new UaException(e);
        }
    }
}
