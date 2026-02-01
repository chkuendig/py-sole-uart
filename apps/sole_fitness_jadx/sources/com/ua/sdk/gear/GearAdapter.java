package com.ua.sdk.gear;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public class GearAdapter implements JsonDeserializer<Gear>, JsonSerializer<Gear> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public Gear deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return (Gear) jsonDeserializationContext.deserialize(jsonElement, GearImpl.class);
    }

    @Override // com.google.gson.JsonSerializer
    public JsonElement serialize(Gear gear, Type type, JsonSerializationContext jsonSerializationContext) {
        return jsonSerializationContext.serialize(gear, gear.getClass());
    }
}
