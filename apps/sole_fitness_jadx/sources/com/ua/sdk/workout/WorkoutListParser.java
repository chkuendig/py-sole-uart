package com.ua.sdk.workout;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.ua.sdk.UaException;
import com.ua.sdk.internal.AbstractGsonParser;
import com.ua.sdk.net.json.GsonFactory;

/* loaded from: classes2.dex */
public class WorkoutListParser extends AbstractGsonParser<WorkoutList> {
    public WorkoutListParser() {
        super(GsonFactory.newWorkoutInstance());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ua.sdk.internal.AbstractGsonParser
    public WorkoutList read(Gson gson, JsonReader jsonReader) throws UaException {
        return (WorkoutList) gson.fromJson(jsonReader, WorkoutListImpl.class);
    }
}
