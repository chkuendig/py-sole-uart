package com.ua.sdk.activitytype;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public class ActivityTypeAdapter implements JsonDeserializer<ActivityTypeImpl> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public ActivityTypeImpl deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        ActivityTypeTransferObject activityTypeTransferObject = (ActivityTypeTransferObject) jsonDeserializationContext.deserialize(jsonElement, ActivityTypeTransferObject.class);
        if (activityTypeTransferObject != null) {
            return ActivityTypeTransferObject.toImpl(activityTypeTransferObject);
        }
        return null;
    }
}
