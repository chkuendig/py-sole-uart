package com.ua.sdk.group.leaderboard;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public class GroupLeaderboardAdapter implements JsonDeserializer<GroupLeaderboard>, JsonSerializer<GroupLeaderboard> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public GroupLeaderboard deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return (GroupLeaderboard) jsonDeserializationContext.deserialize(jsonElement, GroupLeaderboardImpl.class);
    }

    @Override // com.google.gson.JsonSerializer
    public JsonElement serialize(GroupLeaderboard groupLeaderboard, Type type, JsonSerializationContext jsonSerializationContext) {
        return jsonSerializationContext.serialize(groupLeaderboard, groupLeaderboard.getClass());
    }
}
