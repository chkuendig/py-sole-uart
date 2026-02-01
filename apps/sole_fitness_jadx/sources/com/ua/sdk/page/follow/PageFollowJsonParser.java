package com.ua.sdk.page.follow;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.stream.JsonReader;
import com.ua.sdk.UaException;
import com.ua.sdk.internal.AbstractGsonParser;
import java.io.InputStream;
import java.io.InputStreamReader;

/* loaded from: classes2.dex */
public class PageFollowJsonParser extends AbstractGsonParser<PageFollow> {
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ua.sdk.internal.AbstractGsonParser
    public PageFollow read(Gson gson, JsonReader jsonReader) throws UaException {
        return null;
    }

    public PageFollowJsonParser(Gson gson) {
        super(gson);
    }

    @Override // com.ua.sdk.internal.AbstractGsonParser, com.ua.sdk.internal.JsonParser
    public PageFollow parse(InputStream inputStream) throws UaException {
        try {
            return PageFollowTransferObject.toPageFollowImpl((PageFollowTransferObject) this.mGson.fromJson(new JsonReader(new InputStreamReader(inputStream)), PageFollowTransferObject.class));
        } catch (JsonParseException e) {
            throw new UaException(e);
        }
    }
}
