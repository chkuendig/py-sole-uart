package com.ua.sdk.user;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public enum Gender {
    FEMALE,
    MALE;

    public static class GenderAdapter implements JsonSerializer<Gender>, JsonDeserializer<Gender> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.JsonDeserializer
        public Gender deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            String asString = jsonElement.getAsString();
            if (asString.equals("M") || asString.equals("m")) {
                return Gender.MALE;
            }
            if (asString.equals("F") || asString.equals("f")) {
                return Gender.FEMALE;
            }
            return null;
        }

        @Override // com.google.gson.JsonSerializer
        public JsonElement serialize(Gender gender, Type type, JsonSerializationContext jsonSerializationContext) {
            int i = AnonymousClass1.$SwitchMap$com$ua$sdk$user$Gender[gender.ordinal()];
            if (i == 1) {
                return new JsonPrimitive("F");
            }
            if (i != 2) {
                return null;
            }
            return new JsonPrimitive("M");
        }
    }

    /* renamed from: com.ua.sdk.user.Gender$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ua$sdk$user$Gender;

        static {
            int[] iArr = new int[Gender.values().length];
            $SwitchMap$com$ua$sdk$user$Gender = iArr;
            try {
                iArr[Gender.FEMALE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ua$sdk$user$Gender[Gender.MALE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
