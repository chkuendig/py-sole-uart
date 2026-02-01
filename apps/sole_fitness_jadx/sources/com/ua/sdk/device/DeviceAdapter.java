package com.ua.sdk.device;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public class DeviceAdapter implements JsonSerializer<Device>, JsonDeserializer<Device> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public Device deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return (Device) jsonDeserializationContext.deserialize(jsonElement, DeviceImpl.class);
    }

    @Override // com.google.gson.JsonSerializer
    public JsonElement serialize(Device device, Type type, JsonSerializationContext jsonSerializationContext) {
        return jsonSerializationContext.serialize(device, device.getClass());
    }
}
