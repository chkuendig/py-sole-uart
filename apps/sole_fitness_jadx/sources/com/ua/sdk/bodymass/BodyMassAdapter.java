package com.ua.sdk.bodymass;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public class BodyMassAdapter implements JsonDeserializer<BodyMass>, JsonSerializer<BodyMass> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public BodyMass deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return (BodyMass) jsonDeserializationContext.deserialize(jsonElement, BodyMassImpl.class);
    }

    @Override // com.google.gson.JsonSerializer
    public JsonElement serialize(BodyMass bodyMass, Type type, JsonSerializationContext jsonSerializationContext) {
        return jsonSerializationContext.serialize(bodyMass, bodyMass.getClass());
    }
}
