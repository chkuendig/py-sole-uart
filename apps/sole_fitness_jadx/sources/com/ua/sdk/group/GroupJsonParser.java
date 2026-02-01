package com.ua.sdk.group;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.ua.sdk.UaException;
import com.ua.sdk.internal.AbstractGsonParser;
import com.ua.sdk.net.json.GsonFactory;

/* loaded from: classes2.dex */
public class GroupJsonParser extends AbstractGsonParser<Group> {
    public GroupJsonParser() {
        super(GsonFactory.newGroupInstance());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ua.sdk.internal.AbstractGsonParser
    public Group read(Gson gson, JsonReader jsonReader) throws UaException {
        return (Group) gson.fromJson(jsonReader, new TypeToken<Group>() { // from class: com.ua.sdk.group.GroupJsonParser.1
        }.getType());
    }
}
