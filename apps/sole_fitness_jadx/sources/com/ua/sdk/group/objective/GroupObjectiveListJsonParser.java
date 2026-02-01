package com.ua.sdk.group.objective;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.ua.sdk.UaException;
import com.ua.sdk.internal.AbstractGsonParser;
import com.ua.sdk.net.json.GsonFactory;

/* loaded from: classes2.dex */
public class GroupObjectiveListJsonParser extends AbstractGsonParser<GroupObjectiveList> {
    public GroupObjectiveListJsonParser() {
        super(GsonFactory.newGroupInstance());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ua.sdk.internal.AbstractGsonParser
    public GroupObjectiveList read(Gson gson, JsonReader jsonReader) throws UaException {
        return (GroupObjectiveList) gson.fromJson(jsonReader, new TypeToken<GroupObjectiveList>() { // from class: com.ua.sdk.group.objective.GroupObjectiveListJsonParser.1
        }.getType());
    }
}
