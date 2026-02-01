package com.ua.sdk.gear.brand;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public class GearBrandAdapter implements JsonDeserializer<GearBrand>, JsonSerializer<GearBrand> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public GearBrand deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return (GearBrand) jsonDeserializationContext.deserialize(jsonElement, GearBrandImpl.class);
    }

    @Override // com.google.gson.JsonSerializer
    public JsonElement serialize(GearBrand gearBrand, Type type, JsonSerializationContext jsonSerializationContext) {
        return jsonSerializationContext.serialize(gearBrand, gearBrand.getClass());
    }
}
