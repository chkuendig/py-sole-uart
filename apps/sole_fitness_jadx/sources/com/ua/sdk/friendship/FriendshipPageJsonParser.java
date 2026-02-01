package com.ua.sdk.friendship;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.stream.JsonReader;
import com.ua.sdk.EntityList;
import com.ua.sdk.UaException;
import com.ua.sdk.internal.JsonParser;
import java.io.InputStream;
import java.io.InputStreamReader;

/* loaded from: classes2.dex */
public class FriendshipPageJsonParser implements JsonParser<EntityList<Friendship>> {
    private Gson gson;

    public FriendshipPageJsonParser(Gson gson) {
        this.gson = gson;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ua.sdk.internal.JsonParser
    public EntityList<Friendship> parse(InputStream inputStream) throws UaException {
        try {
            return FriendshipPageTransferObject.fromTransferObject((FriendshipPageTransferObject) this.gson.fromJson(new JsonReader(new InputStreamReader(inputStream)), FriendshipPageTransferObject.class));
        } catch (JsonParseException e) {
            throw new UaException(e);
        }
    }
}
