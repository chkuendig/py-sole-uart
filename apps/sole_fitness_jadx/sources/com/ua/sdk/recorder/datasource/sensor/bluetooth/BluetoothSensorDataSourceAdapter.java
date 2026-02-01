package com.ua.sdk.recorder.datasource.sensor.bluetooth;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.ua.sdk.recorder.BluetoothSensorDataSourceConfiguration;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public class BluetoothSensorDataSourceAdapter implements JsonSerializer<BluetoothSensorDataSourceConfiguration>, JsonDeserializer<BluetoothSensorDataSourceConfiguration> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public BluetoothSensorDataSourceConfiguration deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return (BluetoothSensorDataSourceConfiguration) jsonDeserializationContext.deserialize(jsonElement, BluetoothSensorDataSourceConfigurationImpl.class);
    }

    @Override // com.google.gson.JsonSerializer
    public JsonElement serialize(BluetoothSensorDataSourceConfiguration bluetoothSensorDataSourceConfiguration, Type type, JsonSerializationContext jsonSerializationContext) {
        return jsonSerializationContext.serialize(bluetoothSensorDataSourceConfiguration, bluetoothSensorDataSourceConfiguration.getClass());
    }
}
