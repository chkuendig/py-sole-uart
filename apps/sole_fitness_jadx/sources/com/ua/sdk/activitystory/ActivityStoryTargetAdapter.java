package com.ua.sdk.activitystory;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.ua.sdk.activitystory.target.ActivityStoryGroupTarget;
import com.ua.sdk.activitystory.target.ActivityStoryUnknownTarget;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public class ActivityStoryTargetAdapter implements JsonSerializer<ActivityStoryTarget>, JsonDeserializer<ActivityStoryTarget> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public ActivityStoryTarget deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonElement jsonElement2 = jsonElement.getAsJsonObject().get("type");
        if (jsonElement2 != null && "group".equals(jsonElement2.getAsString())) {
            return (ActivityStoryTarget) jsonDeserializationContext.deserialize(jsonElement, ActivityStoryGroupTarget.class);
        }
        return (ActivityStoryTarget) jsonDeserializationContext.deserialize(jsonElement, ActivityStoryUnknownTarget.class);
    }

    @Override // com.google.gson.JsonSerializer
    public JsonElement serialize(ActivityStoryTarget activityStoryTarget, Type type, JsonSerializationContext jsonSerializationContext) {
        return jsonSerializationContext.serialize(activityStoryTarget, activityStoryTarget.getClass());
    }
}
