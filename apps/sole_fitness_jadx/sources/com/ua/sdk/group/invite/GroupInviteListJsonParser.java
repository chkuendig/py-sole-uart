package com.ua.sdk.group.invite;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.ua.sdk.UaException;
import com.ua.sdk.internal.AbstractGsonParser;
import com.ua.sdk.net.json.GsonFactory;

/* loaded from: classes2.dex */
public class GroupInviteListJsonParser extends AbstractGsonParser<GroupInviteList> {
    public GroupInviteListJsonParser() {
        super(GsonFactory.newGroupInstance());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ua.sdk.internal.AbstractGsonParser
    public GroupInviteList read(Gson gson, JsonReader jsonReader) throws UaException {
        return (GroupInviteList) gson.fromJson(jsonReader, new TypeToken<GroupInviteList>() { // from class: com.ua.sdk.group.invite.GroupInviteListJsonParser.1
        }.getType());
    }
}
