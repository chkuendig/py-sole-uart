package com.ua.sdk.user;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.stream.JsonReader;
import com.ua.sdk.EntityList;
import com.ua.sdk.UaException;
import com.ua.sdk.internal.JsonParser;
import java.io.InputStream;
import java.io.InputStreamReader;

/* loaded from: classes2.dex */
public class UserPageParser implements JsonParser<EntityList<User>> {
    private Gson gson;

    public UserPageParser(Gson gson) {
        this.gson = gson;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ua.sdk.internal.JsonParser
    public EntityList<User> parse(InputStream inputStream) throws UaException {
        try {
            return UserPageTransferObject.toPage((UserPageTransferObject) this.gson.fromJson(new JsonReader(new InputStreamReader(inputStream)), UserPageTransferObject.class));
        } catch (JsonParseException e) {
            throw new UaException(e);
        }
    }
}
