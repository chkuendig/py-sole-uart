package com.ua.sdk.activitystory;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public class ActivityStoryVerbAdapter implements JsonSerializer<ActivityStoryVerb>, JsonDeserializer<ActivityStoryVerb> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public ActivityStoryVerb deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        String asString = jsonElement.getAsString();
        if (asString == null) {
            return null;
        }
        try {
            return ActivityStoryVerb.valueOf(asString.toUpperCase());
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    @Override // com.google.gson.JsonSerializer
    public JsonElement serialize(ActivityStoryVerb activityStoryVerb, Type type, JsonSerializationContext jsonSerializationContext) {
        return jsonSerializationContext.serialize(activityStoryVerb.toString().toLowerCase(), String.class);
    }
}
