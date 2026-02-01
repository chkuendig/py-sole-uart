package com.ua.sdk;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public enum MeasurementSystem {
    METRIC,
    IMPERIAL,
    HYBRID;

    /* renamed from: com.ua.sdk.MeasurementSystem$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ua$sdk$MeasurementSystem;

        static {
            int[] iArr = new int[MeasurementSystem.values().length];
            $SwitchMap$com$ua$sdk$MeasurementSystem = iArr;
            try {
                iArr[MeasurementSystem.METRIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ua$sdk$MeasurementSystem[MeasurementSystem.IMPERIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ua$sdk$MeasurementSystem[MeasurementSystem.HYBRID.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String toJson(MeasurementSystem measurementSystem) {
        int i = AnonymousClass1.$SwitchMap$com$ua$sdk$MeasurementSystem[measurementSystem.ordinal()];
        if (i == 1) {
            return "metric";
        }
        if (i == 2) {
            return "imperial";
        }
        if (i != 3) {
            return null;
        }
        return "hybrid";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static MeasurementSystem fromJson(String str) {
        if ("metric".equals(str)) {
            return METRIC;
        }
        if ("imperial".equals(str)) {
            return IMPERIAL;
        }
        if ("hybrid".equals(str)) {
            return HYBRID;
        }
        return null;
    }

    public static class MeasurementSystemAdapter implements JsonSerializer<MeasurementSystem>, JsonDeserializer<MeasurementSystem> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.JsonDeserializer
        public MeasurementSystem deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            return MeasurementSystem.fromJson(jsonElement.getAsString());
        }

        @Override // com.google.gson.JsonSerializer
        public JsonElement serialize(MeasurementSystem measurementSystem, Type type, JsonSerializationContext jsonSerializationContext) {
            return new JsonPrimitive(MeasurementSystem.toJson(measurementSystem));
        }
    }
}
