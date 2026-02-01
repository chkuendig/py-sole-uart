package com.ua.sdk.activitystory;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.ua.sdk.Source;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public class SourceAdapter implements JsonSerializer<Source>, JsonDeserializer<Source> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public Source deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return (Source) jsonDeserializationContext.deserialize(jsonElement, SourceImpl.class);
    }

    @Override // com.google.gson.JsonSerializer
    public JsonElement serialize(Source source, Type type, JsonSerializationContext jsonSerializationContext) {
        return jsonSerializationContext.serialize(source, source.getClass());
    }
}
