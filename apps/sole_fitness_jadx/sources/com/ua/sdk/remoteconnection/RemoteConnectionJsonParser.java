package com.ua.sdk.remoteconnection;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.ua.sdk.UaException;
import com.ua.sdk.internal.JsonParser;
import java.io.InputStream;
import java.io.InputStreamReader;

/* loaded from: classes2.dex */
public class RemoteConnectionJsonParser implements JsonParser<RemoteConnection> {
    private Gson gson;

    public RemoteConnectionJsonParser(Gson gson) {
        this.gson = gson;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ua.sdk.internal.JsonParser
    public RemoteConnection parse(InputStream inputStream) throws UaException {
        return RemoteConnectionTransferObject.toRemoteConnectionImpl((RemoteConnectionTransferObject) this.gson.fromJson(new JsonReader(new InputStreamReader(inputStream)), RemoteConnectionTransferObject.class));
    }
}
