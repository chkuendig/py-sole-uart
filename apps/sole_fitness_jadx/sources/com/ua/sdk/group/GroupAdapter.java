package com.ua.sdk.group;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public class GroupAdapter implements JsonDeserializer<Group>, JsonSerializer<Group> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public Group deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return (Group) jsonDeserializationContext.deserialize(jsonElement, GroupImpl.class);
    }

    @Override // com.google.gson.JsonSerializer
    public JsonElement serialize(Group group, Type type, JsonSerializationContext jsonSerializationContext) {
        return jsonSerializationContext.serialize(group, group.getClass());
    }
}
