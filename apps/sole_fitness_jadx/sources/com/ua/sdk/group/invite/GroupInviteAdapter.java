package com.ua.sdk.group.invite;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public class GroupInviteAdapter implements JsonDeserializer<GroupInvite>, JsonSerializer<GroupInvite> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public GroupInvite deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return (GroupInvite) jsonDeserializationContext.deserialize(jsonElement, GroupInviteImpl.class);
    }

    @Override // com.google.gson.JsonSerializer
    public JsonElement serialize(GroupInvite groupInvite, Type type, JsonSerializationContext jsonSerializationContext) {
        return jsonSerializationContext.serialize(groupInvite, groupInvite.getClass());
    }
}
