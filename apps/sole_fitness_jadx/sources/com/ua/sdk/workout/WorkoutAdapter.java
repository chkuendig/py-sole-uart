package com.ua.sdk.workout;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public class WorkoutAdapter implements JsonDeserializer<Workout>, JsonSerializer<Workout> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public Workout deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return (Workout) jsonDeserializationContext.deserialize(jsonElement, WorkoutImpl.class);
    }

    @Override // com.google.gson.JsonSerializer
    public JsonElement serialize(Workout workout, Type type, JsonSerializationContext jsonSerializationContext) {
        return jsonSerializationContext.serialize(workout, workout.getClass());
    }
}
