package com.ua.sdk.activitystory;

import com.facebook.internal.AnalyticsEvents;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public class AttachmentAdapter implements JsonSerializer<Attachment>, JsonDeserializer<Attachment> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public Attachment deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonElement jsonElement2;
        JsonElement jsonElement3 = jsonElement.getAsJsonObject().get("object");
        if (jsonElement3 == null || (jsonElement2 = jsonElement3.getAsJsonObject().get("type")) == null) {
            return null;
        }
        String asString = jsonElement2.getAsString();
        if (AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO.equals(asString)) {
            return (Attachment) jsonDeserializationContext.deserialize(jsonElement, PhotoAttachmentImpl.class);
        }
        if ("video".equals(asString)) {
            return (Attachment) jsonDeserializationContext.deserialize(jsonElement, VideoAttachmentImpl.class);
        }
        return null;
    }

    @Override // com.google.gson.JsonSerializer
    public JsonElement serialize(Attachment attachment, Type type, JsonSerializationContext jsonSerializationContext) {
        return jsonSerializationContext.serialize(attachment, attachment.getClass());
    }
}
