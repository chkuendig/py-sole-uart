package com.ua.sdk.friendship;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public class FriendshipStatusAdapter implements JsonSerializer<FriendshipStatus>, JsonDeserializer<FriendshipStatus> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public FriendshipStatus deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return FriendshipStatus.getStatusFromString(jsonElement.getAsString());
    }

    @Override // com.google.gson.JsonSerializer
    public JsonElement serialize(FriendshipStatus friendshipStatus, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(friendshipStatus.getValue());
    }
}
