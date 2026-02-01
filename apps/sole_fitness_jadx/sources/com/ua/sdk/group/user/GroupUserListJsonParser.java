package com.ua.sdk.group.user;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.ua.sdk.UaException;
import com.ua.sdk.internal.AbstractGsonParser;
import com.ua.sdk.net.json.GsonFactory;

/* loaded from: classes2.dex */
public class GroupUserListJsonParser extends AbstractGsonParser<GroupUserList> {
    public GroupUserListJsonParser() {
        super(GsonFactory.newGroupInstance());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ua.sdk.internal.AbstractGsonParser
    public GroupUserList read(Gson gson, JsonReader jsonReader) throws UaException {
        return (GroupUserList) gson.fromJson(jsonReader, new TypeToken<GroupUserList>() { // from class: com.ua.sdk.group.user.GroupUserListJsonParser.1
        }.getType());
    }
}
