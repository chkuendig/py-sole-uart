package com.ua.sdk.remoteconnection;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.stream.JsonReader;
import com.ua.sdk.EntityList;
import com.ua.sdk.UaException;
import com.ua.sdk.internal.JsonParser;
import java.io.InputStream;
import java.io.InputStreamReader;

/* loaded from: classes2.dex */
public class RemoteConnectionPageJsonParser implements JsonParser<EntityList<RemoteConnection>> {
    private final Gson gson;

    public RemoteConnectionPageJsonParser(Gson gson) {
        this.gson = gson;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ua.sdk.internal.JsonParser
    public EntityList<RemoteConnection> parse(InputStream inputStream) throws UaException {
        try {
            return RemoteConnectionPageTO.toPage((RemoteConnectionPageTO) this.gson.fromJson(new JsonReader(new InputStreamReader(inputStream)), RemoteConnectionPageTO.class));
        } catch (JsonParseException e) {
            throw new UaException(e);
        }
    }
}
