package com.ua.sdk.suggestedfriends;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.ua.sdk.UaException;
import com.ua.sdk.internal.AbstractGsonParser;

/* loaded from: classes2.dex */
public class SuggestedFriendsListJsonParser extends AbstractGsonParser<SuggestedFriendsListImpl> {
    public SuggestedFriendsListJsonParser(Gson gson) {
        super(gson);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ua.sdk.internal.AbstractGsonParser
    public SuggestedFriendsListImpl read(Gson gson, JsonReader jsonReader) throws UaException {
        return (SuggestedFriendsListImpl) gson.fromJson(jsonReader, new TypeToken<SuggestedFriendsListImpl>() { // from class: com.ua.sdk.suggestedfriends.SuggestedFriendsListJsonParser.1
        }.getType());
    }
}
