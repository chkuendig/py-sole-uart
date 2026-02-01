package com.ua.sdk.privacy;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public class PrivacyAdapter implements JsonSerializer<Privacy>, JsonDeserializer<Privacy> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public Privacy deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        if (jsonElement.isJsonPrimitive()) {
            return PrivacyHelper.getPrivacyFromId(jsonElement.getAsJsonPrimitive().getAsNumber().intValue());
        }
        return null;
    }

    @Override // com.google.gson.JsonSerializer
    public JsonElement serialize(Privacy privacy, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(Integer.valueOf(privacy.getLevel().id));
    }
}
