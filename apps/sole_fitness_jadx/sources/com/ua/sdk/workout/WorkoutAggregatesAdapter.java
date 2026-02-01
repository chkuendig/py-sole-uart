package com.ua.sdk.workout;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public class WorkoutAggregatesAdapter implements JsonSerializer<WorkoutAggregates>, JsonDeserializer<WorkoutAggregates> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public WorkoutAggregates deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return (WorkoutAggregates) jsonDeserializationContext.deserialize(jsonElement, WorkoutAggregatesImpl.class);
    }

    @Override // com.google.gson.JsonSerializer
    public JsonElement serialize(WorkoutAggregates workoutAggregates, Type type, JsonSerializationContext jsonSerializationContext) {
        return jsonSerializationContext.serialize(workoutAggregates, workoutAggregates.getClass());
    }
}
