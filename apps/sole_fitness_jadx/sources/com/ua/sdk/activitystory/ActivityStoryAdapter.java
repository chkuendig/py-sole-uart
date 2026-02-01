package com.ua.sdk.activitystory;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.ua.sdk.UaLog;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public class ActivityStoryAdapter implements JsonSerializer<ActivityStory>, JsonDeserializer<ActivityStory> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public ActivityStory deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        try {
            ActivityStory activityStory = (ActivityStory) jsonDeserializationContext.deserialize(jsonElement, ActivityStoryImpl.class);
            ActivityStoryTemplateImpl activityStoryTemplateImpl = (ActivityStoryTemplateImpl) activityStory.getTemplate();
            if (activityStoryTemplateImpl != null) {
                activityStoryTemplateImpl.fillTemplateArgs(jsonElement.getAsJsonObject());
            }
            return activityStory;
        } catch (JsonParseException e) {
            UaLog.error("Unable to parse ActivityStory=" + jsonElement, (Throwable) e);
            return new ActivityStoryImpl();
        }
    }

    @Override // com.google.gson.JsonSerializer
    public JsonElement serialize(ActivityStory activityStory, Type type, JsonSerializationContext jsonSerializationContext) {
        return jsonSerializationContext.serialize(activityStory, activityStory.getClass());
    }
}
