package com.ua.sdk.user.stats;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public class StatsAdapter implements JsonDeserializer<Stats>, JsonSerializer<Stats> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public Stats deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return (Stats) jsonDeserializationContext.deserialize(jsonElement, StatsImpl.class);
    }

    @Override // com.google.gson.JsonSerializer
    public JsonElement serialize(Stats stats, Type type, JsonSerializationContext jsonSerializationContext) {
        return jsonSerializationContext.serialize(stats, stats.getClass());
    }
}
