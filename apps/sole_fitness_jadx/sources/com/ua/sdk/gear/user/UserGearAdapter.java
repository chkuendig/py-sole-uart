package com.ua.sdk.gear.user;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.ua.sdk.EntityRef;
import com.ua.sdk.activitytype.ActivityType;
import com.ua.sdk.cache.EntityDatabase;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class UserGearAdapter implements JsonDeserializer<UserGear>, JsonSerializer<UserGear> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public UserGear deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        JsonObject asJsonObject2 = asJsonObject.getAsJsonObject("_embedded");
        if (asJsonObject2 != null) {
            JsonObject asJsonObject3 = asJsonObject2.getAsJsonObject("gear");
            asJsonObject3.add(EntityDatabase.LINKS.TABLE_SUFFIX, asJsonObject2.getAsJsonObject(EntityDatabase.LINKS.TABLE_SUFFIX));
            asJsonObject.add("gear", asJsonObject3);
        }
        return (UserGear) jsonDeserializationContext.deserialize(asJsonObject, UserGearImpl.class);
    }

    @Override // com.google.gson.JsonSerializer
    public JsonElement serialize(UserGear userGear, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject asJsonObject = jsonSerializationContext.serialize(userGear, userGear.getClass()).getAsJsonObject();
        if (userGear.getGear() != null && userGear.getGear().getRef() != null) {
            asJsonObject.add("gear", jsonSerializationContext.serialize(userGear.getGear().getRef().getHref()));
        }
        if (userGear.getDefaultActivities() != null) {
            asJsonObject.remove(EntityDatabase.LINKS.TABLE_SUFFIX);
            List<EntityRef<ActivityType>> defaultActivities = userGear.getDefaultActivities();
            JsonArray jsonArray = new JsonArray();
            Iterator<EntityRef<ActivityType>> it = defaultActivities.iterator();
            while (it.hasNext()) {
                jsonArray.add(jsonSerializationContext.serialize(it.next().getHref()));
            }
            asJsonObject.add("default_activities", jsonArray);
        }
        return asJsonObject;
    }
}
