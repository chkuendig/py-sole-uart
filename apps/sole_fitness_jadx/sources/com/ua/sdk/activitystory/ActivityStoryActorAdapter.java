package com.ua.sdk.activitystory;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.ua.sdk.activitystory.actor.ActivityStoryBrandActorImpl;
import com.ua.sdk.activitystory.actor.ActivityStoryGroupActorImpl;
import com.ua.sdk.activitystory.actor.ActivityStoryPageActorImpl;
import com.ua.sdk.activitystory.actor.ActivityStorySiteActorImpl;
import com.ua.sdk.activitystory.actor.ActivityStoryUnknownActorImpl;
import com.ua.sdk.activitystory.actor.ActivityStoryUserActorImpl;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public class ActivityStoryActorAdapter implements JsonSerializer<ActivityStoryActor>, JsonDeserializer<ActivityStoryActor> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public ActivityStoryActor deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonElement jsonElement2 = jsonElement.getAsJsonObject().get("type");
        if (jsonElement2 != null) {
            String asString = jsonElement2.getAsString();
            if ("user".equals(asString)) {
                return (ActivityStoryActor) jsonDeserializationContext.deserialize(jsonElement, ActivityStoryUserActorImpl.class);
            }
            if ("brand".equals(asString)) {
                return (ActivityStoryActor) jsonDeserializationContext.deserialize(jsonElement, ActivityStoryBrandActorImpl.class);
            }
            if ("site".equals(asString)) {
                return (ActivityStoryActor) jsonDeserializationContext.deserialize(jsonElement, ActivityStorySiteActorImpl.class);
            }
            if ("page".equals(asString)) {
                return (ActivityStoryActor) jsonDeserializationContext.deserialize(jsonElement, ActivityStoryPageActorImpl.class);
            }
            if ("group".equals(asString)) {
                return (ActivityStoryActor) jsonDeserializationContext.deserialize(jsonElement, ActivityStoryGroupActorImpl.class);
            }
        }
        return (ActivityStoryActor) jsonDeserializationContext.deserialize(jsonElement, ActivityStoryUnknownActorImpl.class);
    }

    @Override // com.google.gson.JsonSerializer
    public JsonElement serialize(ActivityStoryActor activityStoryActor, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonElement jsonElementSerialize = jsonSerializationContext.serialize(activityStoryActor, activityStoryActor.getClass());
        jsonElementSerialize.getAsJsonObject().addProperty("type", activityStoryActor.getType().toString().toLowerCase());
        return jsonElementSerialize;
    }
}
