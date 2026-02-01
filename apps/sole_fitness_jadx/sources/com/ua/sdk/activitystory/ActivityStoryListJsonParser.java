package com.ua.sdk.activitystory;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.ua.sdk.UaException;
import com.ua.sdk.internal.AbstractGsonParser;
import com.ua.sdk.net.json.GsonFactory;

/* loaded from: classes2.dex */
public class ActivityStoryListJsonParser extends AbstractGsonParser<ActivityStoryList> {
    public ActivityStoryListJsonParser() {
        super(GsonFactory.newActivityStoryInstance());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ua.sdk.internal.AbstractGsonParser
    public ActivityStoryList read(Gson gson, JsonReader jsonReader) throws UaException {
        return (ActivityStoryList) gson.fromJson(jsonReader, new TypeToken<ActivityStoryList>() { // from class: com.ua.sdk.activitystory.ActivityStoryListJsonParser.1
        }.getType());
    }
}
