package com.ua.sdk.page;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.stream.JsonReader;
import com.ua.sdk.EntityList;
import com.ua.sdk.UaException;
import com.ua.sdk.internal.JsonParser;
import java.io.InputStream;
import java.io.InputStreamReader;

/* loaded from: classes2.dex */
public class PageListJsonParser implements JsonParser<EntityList<Page>> {
    private Gson gson;

    public PageListJsonParser(Gson gson) {
        this.gson = gson;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ua.sdk.internal.JsonParser
    public EntityList<Page> parse(InputStream inputStream) throws UaException {
        try {
            return PagePageTO.toPage((PagePageTO) this.gson.fromJson(new JsonReader(new InputStreamReader(inputStream)), PagePageTO.class));
        } catch (JsonParseException e) {
            throw new UaException(e);
        }
    }
}
