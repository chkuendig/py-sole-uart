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
public class RemoteConnectionTypePageJsonParser implements JsonParser<EntityList<RemoteConnectionType>> {
    private final Gson gson;

    public RemoteConnectionTypePageJsonParser(Gson gson) {
        this.gson = gson;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ua.sdk.internal.JsonParser
    public EntityList<RemoteConnectionType> parse(InputStream inputStream) throws UaException {
        try {
            return RemoteConnectionTypePageTO.fromTransferObject((RemoteConnectionTypePageTO) this.gson.fromJson(new JsonReader(new InputStreamReader(inputStream)), RemoteConnectionTypePageTO.class));
        } catch (JsonParseException e) {
            throw new UaException(e);
        }
    }
}
