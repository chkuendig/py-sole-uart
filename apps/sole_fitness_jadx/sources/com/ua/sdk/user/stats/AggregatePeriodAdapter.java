package com.ua.sdk.user.stats;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public class AggregatePeriodAdapter implements JsonDeserializer<AggregatePeriod>, JsonSerializer<AggregatePeriod> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public AggregatePeriod deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return (AggregatePeriod) jsonDeserializationContext.deserialize(jsonElement, AggregatePeriodImpl.class);
    }

    @Override // com.google.gson.JsonSerializer
    public JsonElement serialize(AggregatePeriod aggregatePeriod, Type type, JsonSerializationContext jsonSerializationContext) {
        return jsonSerializationContext.serialize(aggregatePeriod, aggregatePeriod.getClass());
    }
}
