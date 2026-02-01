package com.ua.sdk.sleep;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public class SleepMetricAdapter implements JsonDeserializer<SleepMetric>, JsonSerializer<SleepMetric> {
    @Override // com.google.gson.JsonDeserializer
    public SleepMetric deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return (SleepMetricImpl) jsonDeserializationContext.deserialize(jsonElement, SleepMetricImpl.class);
    }

    @Override // com.google.gson.JsonSerializer
    public JsonElement serialize(SleepMetric sleepMetric, Type type, JsonSerializationContext jsonSerializationContext) {
        return jsonSerializationContext.serialize(sleepMetric, sleepMetric.getClass());
    }
}
