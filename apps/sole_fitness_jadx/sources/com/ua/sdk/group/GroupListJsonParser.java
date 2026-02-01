package com.ua.sdk.group;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.ua.sdk.EntityList;
import com.ua.sdk.UaException;
import com.ua.sdk.internal.AbstractGsonParser;
import com.ua.sdk.net.json.GsonFactory;

/* loaded from: classes2.dex */
public class GroupListJsonParser extends AbstractGsonParser<EntityList<Group>> {
    public GroupListJsonParser() {
        super(GsonFactory.newGroupInstance());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ua.sdk.internal.AbstractGsonParser
    public EntityList<Group> read(Gson gson, JsonReader jsonReader) throws UaException {
        return (EntityList) gson.fromJson(jsonReader, new TypeToken<GroupList>() { // from class: com.ua.sdk.group.GroupListJsonParser.1
        }.getType());
    }
}
