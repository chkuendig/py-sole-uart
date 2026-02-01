package com.ua.sdk.heartrate;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public class HeartRateZonesGsonAdapter implements JsonDeserializer<HeartRateZones>, JsonSerializer<HeartRateZones> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public HeartRateZones deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return (HeartRateZones) jsonDeserializationContext.deserialize(jsonElement, HeartRateZonesImpl.class);
    }

    @Override // com.google.gson.JsonSerializer
    public JsonElement serialize(HeartRateZones heartRateZones, Type type, JsonSerializationContext jsonSerializationContext) {
        return jsonSerializationContext.serialize(heartRateZones, heartRateZones.getClass());
    }
}
