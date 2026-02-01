package com.ua.sdk.moderation;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public class ModerationActionAdapter implements JsonDeserializer<ModerationAction>, JsonSerializer<ModerationAction> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public ModerationAction deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return (ModerationAction) jsonDeserializationContext.deserialize(jsonElement, ModerationActionImpl.class);
    }

    @Override // com.google.gson.JsonSerializer
    public JsonElement serialize(ModerationAction moderationAction, Type type, JsonSerializationContext jsonSerializationContext) {
        return jsonSerializationContext.serialize(moderationAction, moderationAction.getClass());
    }
}
