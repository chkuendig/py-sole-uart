package com.ua.sdk.activitystory;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public class ActivityStoryGroupLeaderboardAdapter implements JsonDeserializer<ActivityStoryGroupLeaderboard>, JsonSerializer<ActivityStoryGroupLeaderboard> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public ActivityStoryGroupLeaderboard deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return (ActivityStoryGroupLeaderboard) jsonDeserializationContext.deserialize(jsonElement, ActivityStoryGroupLeaderboardImpl.class);
    }

    @Override // com.google.gson.JsonSerializer
    public JsonElement serialize(ActivityStoryGroupLeaderboard activityStoryGroupLeaderboard, Type type, JsonSerializationContext jsonSerializationContext) {
        return jsonSerializationContext.serialize(activityStoryGroupLeaderboard, activityStoryGroupLeaderboard.getClass());
    }
}
