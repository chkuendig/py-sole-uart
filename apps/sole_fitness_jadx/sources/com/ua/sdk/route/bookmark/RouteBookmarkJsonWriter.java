package com.ua.sdk.route.bookmark;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.ua.sdk.UaException;
import com.ua.sdk.UaLog;
import com.ua.sdk.internal.JsonWriter;
import com.ua.sdk.route.RouteBookmark;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/* loaded from: classes2.dex */
public class RouteBookmarkJsonWriter implements JsonWriter<RouteBookmark> {
    private Gson gson;

    public RouteBookmarkJsonWriter(Gson gson) {
        this.gson = gson;
    }

    @Override // com.ua.sdk.internal.JsonWriter
    public void write(RouteBookmark routeBookmark, OutputStream outputStream) throws JsonIOException, IOException, UaException {
        RouteBookmarkTO transferObject = RouteBookmarkTO.toTransferObject(routeBookmark);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        this.gson.toJson(transferObject, outputStreamWriter);
        try {
            outputStreamWriter.flush();
        } catch (InterruptedIOException unused) {
            throw new UaException(UaException.Code.CANCELED);
        } catch (IOException e) {
            UaLog.error("Unable to flush json writer during write.", (Throwable) e);
            throw new UaException(e);
        }
    }
}
