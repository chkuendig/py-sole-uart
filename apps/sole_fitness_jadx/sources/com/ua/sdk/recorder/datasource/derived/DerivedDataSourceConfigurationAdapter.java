package com.ua.sdk.recorder.datasource.derived;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.ua.sdk.recorder.DerivedDataSourceConfiguration;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public class DerivedDataSourceConfigurationAdapter implements JsonSerializer<DerivedDataSourceConfiguration>, JsonDeserializer<DerivedDataSourceConfiguration> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public DerivedDataSourceConfiguration deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return (DerivedDataSourceConfiguration) jsonDeserializationContext.deserialize(jsonElement, DerivedDataSourceConfigurationImpl.class);
    }

    @Override // com.google.gson.JsonSerializer
    public JsonElement serialize(DerivedDataSourceConfiguration derivedDataSourceConfiguration, Type type, JsonSerializationContext jsonSerializationContext) {
        return jsonSerializationContext.serialize(derivedDataSourceConfiguration, derivedDataSourceConfiguration.getClass());
    }
}
