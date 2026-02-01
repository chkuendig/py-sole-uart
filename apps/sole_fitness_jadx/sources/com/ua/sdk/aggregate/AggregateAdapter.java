package com.ua.sdk.aggregate;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public class AggregateAdapter implements JsonDeserializer<Aggregate>, JsonSerializer<Aggregate> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public Aggregate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return (Aggregate) jsonDeserializationContext.deserialize(jsonElement, AggregateImpl.class);
    }

    @Override // com.google.gson.JsonSerializer
    public JsonElement serialize(Aggregate aggregate, Type type, JsonSerializationContext jsonSerializationContext) {
        return jsonSerializationContext.serialize(aggregate, aggregate.getClass());
    }
}
