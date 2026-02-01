package com.ua.sdk.recorder.datasource.sensor.location;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.ua.sdk.recorder.LocationSensorDataSourceConfiguration;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public class LocationSensorDataSourceAdapter implements JsonSerializer<LocationSensorDataSourceConfiguration>, JsonDeserializer<LocationSensorDataSourceConfiguration> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public LocationSensorDataSourceConfiguration deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return (LocationSensorDataSourceConfiguration) jsonDeserializationContext.deserialize(jsonElement, LocationSensorSensorDataSourceConfigurationImpl.class);
    }

    @Override // com.google.gson.JsonSerializer
    public JsonElement serialize(LocationSensorDataSourceConfiguration locationSensorDataSourceConfiguration, Type type, JsonSerializationContext jsonSerializationContext) {
        return jsonSerializationContext.serialize(locationSensorDataSourceConfiguration, locationSensorDataSourceConfiguration.getClass());
    }
}
