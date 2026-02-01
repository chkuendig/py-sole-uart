package com.dyaco.sole;

import com.ua.sdk.recorder.datasource.sensor.bluetooth.GattAttributes;
import java.util.HashMap;

/* loaded from: classes.dex */
public class SampleGattAttributes {
    public static String CLIENT_CHARACTERISTIC_CONFIG;
    public static String HEART_RATE_MEASUREMENT;
    public static String SERVICE_UUID;
    private static HashMap<String, String> attributes;

    static {
        HashMap<String, String> map = new HashMap<>();
        attributes = map;
        HEART_RATE_MEASUREMENT = GattAttributes.HEART_RATE_CHARACTERISTIC;
        CLIENT_CHARACTERISTIC_CONFIG = GattAttributes.CLIENT_CHARACTERISTIC_CONFIG_DESCRIPTOR;
        SERVICE_UUID = GattAttributes.HEART_RATE_SERVICE;
        map.put(GattAttributes.HEART_RATE_SERVICE, "Heart Rate Service");
        attributes.put("0000180a-0000-1000-8000-00805f9b34fb", "Device Information Service");
        attributes.put(HEART_RATE_MEASUREMENT, "Heart Rate Measurement");
        attributes.put("00002a29-0000-1000-8000-00805f9b34fb", "Manufacturer Name String");
    }

    public static String lookup(String str, String str2) {
        String str3 = attributes.get(str);
        return str3 == null ? str2 : str3;
    }
}
