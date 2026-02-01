package com.ua.sdk.activitystory;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.ua.sdk.activitystory.object.ActivityStoryHighlightImpl;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public class ActivityStoryHighlightAdapter implements JsonSerializer<ActivityStoryHighlight>, JsonDeserializer<ActivityStoryHighlight> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public ActivityStoryHighlight deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return (ActivityStoryHighlight) jsonDeserializationContext.deserialize(jsonElement, ActivityStoryHighlightImpl.class);
    }

    @Override // com.google.gson.JsonSerializer
    public JsonElement serialize(ActivityStoryHighlight activityStoryHighlight, Type type, JsonSerializationContext jsonSerializationContext) {
        return jsonSerializationContext.serialize(activityStoryHighlight, activityStoryHighlight.getClass());
    }
}
