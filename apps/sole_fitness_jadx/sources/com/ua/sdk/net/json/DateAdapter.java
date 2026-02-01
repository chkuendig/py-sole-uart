package com.ua.sdk.net.json;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.ua.oss.org.codehaus.jackson.map.util.Iso8601DateFormat;
import java.lang.reflect.Type;
import java.util.Date;

/* loaded from: classes2.dex */
public class DateAdapter implements JsonSerializer<Date>, JsonDeserializer<Date> {
    @Override // com.google.gson.JsonSerializer
    public JsonElement serialize(Date date, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(Iso8601DateFormat.format(date, true));
    }

    @Override // com.google.gson.JsonDeserializer
    public Date deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return Iso8601DateFormat.parse(jsonElement.getAsString());
    }
}
