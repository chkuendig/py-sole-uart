package com.ua.sdk.group.user;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public class GroupUserAdapter implements JsonDeserializer<GroupUser>, JsonSerializer<GroupUser> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public GroupUser deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return (GroupUser) jsonDeserializationContext.deserialize(jsonElement, GroupUserImpl.class);
    }

    @Override // com.google.gson.JsonSerializer
    public JsonElement serialize(GroupUser groupUser, Type type, JsonSerializationContext jsonSerializationContext) {
        return jsonSerializationContext.serialize(groupUser, groupUser.getClass());
    }
}
