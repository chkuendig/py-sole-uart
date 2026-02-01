package com.ua.sdk.user.stats;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public class UserStatsAdapter implements JsonDeserializer<UserStats>, JsonSerializer<UserStats> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public UserStats deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return (UserStats) jsonDeserializationContext.deserialize(jsonElement, UserStatsImpl.class);
    }

    @Override // com.google.gson.JsonSerializer
    public JsonElement serialize(UserStats userStats, Type type, JsonSerializationContext jsonSerializationContext) {
        return jsonSerializationContext.serialize(userStats, userStats.getClass());
    }
}
