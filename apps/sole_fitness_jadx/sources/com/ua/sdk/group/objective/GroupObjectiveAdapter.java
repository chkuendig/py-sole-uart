package com.ua.sdk.group.objective;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public class GroupObjectiveAdapter implements JsonDeserializer<GroupObjective>, JsonSerializer<GroupObjective> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public GroupObjective deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return (GroupObjective) jsonDeserializationContext.deserialize(jsonElement, GroupObjectiveImpl.class);
    }

    @Override // com.google.gson.JsonSerializer
    public JsonElement serialize(GroupObjective groupObjective, Type type, JsonSerializationContext jsonSerializationContext) {
        return jsonSerializationContext.serialize(groupObjective, groupObjective.getClass());
    }
}
