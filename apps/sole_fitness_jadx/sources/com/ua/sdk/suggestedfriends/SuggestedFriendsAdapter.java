package com.ua.sdk.suggestedfriends;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public class SuggestedFriendsAdapter implements JsonSerializer<SuggestedFriends>, JsonDeserializer<SuggestedFriends> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public SuggestedFriends deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return (SuggestedFriends) jsonDeserializationContext.deserialize(jsonElement, SuggestedFriendsImpl.class);
    }

    @Override // com.google.gson.JsonSerializer
    public JsonElement serialize(SuggestedFriends suggestedFriends, Type type, JsonSerializationContext jsonSerializationContext) {
        return jsonSerializationContext.serialize(suggestedFriends, suggestedFriends.getClass());
    }
}
