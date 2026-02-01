package com.ua.sdk.group.purpose;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public class GroupPurposeAdapter implements JsonDeserializer<GroupPurpose>, JsonSerializer<GroupPurpose> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public GroupPurpose deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return (GroupPurpose) jsonDeserializationContext.deserialize(jsonElement, GroupPurposeImpl.class);
    }

    @Override // com.google.gson.JsonSerializer
    public JsonElement serialize(GroupPurpose groupPurpose, Type type, JsonSerializationContext jsonSerializationContext) {
        return jsonSerializationContext.serialize(groupPurpose, groupPurpose.getClass());
    }
}
