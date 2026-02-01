package com.ua.sdk.location;

import com.facebook.appevents.UserDataStore;
import com.facebook.appevents.integrity.IntegrityManager;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public class LocationAdapter implements JsonSerializer<Location>, JsonDeserializer<Location> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public Location deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        if (!jsonElement.isJsonObject()) {
            return null;
        }
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        return new LocationImpl(getString(asJsonObject, UserDataStore.COUNTRY), getString(asJsonObject, "region"), getString(asJsonObject, "locality"), getString(asJsonObject, IntegrityManager.INTEGRITY_TYPE_ADDRESS));
    }

    @Override // com.google.gson.JsonSerializer
    public JsonElement serialize(Location location, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(UserDataStore.COUNTRY, location.getCountry());
        jsonObject.addProperty("region", location.getRegion());
        jsonObject.addProperty("locality", location.getLocality());
        jsonObject.addProperty(IntegrityManager.INTEGRITY_TYPE_ADDRESS, location.getAddress());
        return jsonObject;
    }

    private String getString(JsonObject jsonObject, String str) {
        JsonElement jsonElement = jsonObject.get(str);
        if (jsonElement != null) {
            return jsonElement.getAsString();
        }
        return null;
    }
}
