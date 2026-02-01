package com.ua.sdk.user.stats;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public class HeartRateTimesAggregatesAdapter implements JsonDeserializer<HeartRateTimesAggregate>, JsonSerializer<HeartRateTimesAggregate> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public HeartRateTimesAggregate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return (HeartRateTimesAggregate) jsonDeserializationContext.deserialize(jsonElement, HeartRateTimesAggregateImpl.class);
    }

    @Override // com.google.gson.JsonSerializer
    public JsonElement serialize(HeartRateTimesAggregate heartRateTimesAggregate, Type type, JsonSerializationContext jsonSerializationContext) {
        return jsonSerializationContext.serialize(heartRateTimesAggregate, heartRateTimesAggregate.getClass());
    }
}
