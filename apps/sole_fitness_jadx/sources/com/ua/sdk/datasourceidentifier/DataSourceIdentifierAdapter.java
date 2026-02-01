package com.ua.sdk.datasourceidentifier;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public class DataSourceIdentifierAdapter implements JsonSerializer<DataSourceIdentifier>, JsonDeserializer<DataSourceIdentifier> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public DataSourceIdentifier deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return (DataSourceIdentifier) jsonDeserializationContext.deserialize(jsonElement, DataSourceIdentifierImpl.class);
    }

    @Override // com.google.gson.JsonSerializer
    public JsonElement serialize(DataSourceIdentifier dataSourceIdentifier, Type type, JsonSerializationContext jsonSerializationContext) {
        return jsonSerializationContext.serialize(dataSourceIdentifier, dataSourceIdentifier.getClass());
    }
}
