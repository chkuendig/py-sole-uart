package com.ua.sdk.authentication;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public class FilemobileCredentialAdapter implements JsonSerializer<FilemobileCredential>, JsonDeserializer<FilemobileCredential> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public FilemobileCredential deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return (FilemobileCredential) jsonDeserializationContext.deserialize(jsonElement, FilemobileCredentialImpl.class);
    }

    @Override // com.google.gson.JsonSerializer
    public JsonElement serialize(FilemobileCredential filemobileCredential, Type type, JsonSerializationContext jsonSerializationContext) {
        return jsonSerializationContext.serialize(filemobileCredential, filemobileCredential.getClass());
    }
}
