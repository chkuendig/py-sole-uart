package com.ua.sdk.activitystory;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.ua.sdk.internal.AbstractGsonWriter;
import com.ua.sdk.net.json.GsonFactory;
import java.io.OutputStreamWriter;

/* loaded from: classes2.dex */
public class ActivityStoryJsonWriter extends AbstractGsonWriter<ActivityStory> {
    public ActivityStoryJsonWriter() {
        super(GsonFactory.newActivityStoryInstance());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ua.sdk.internal.AbstractGsonWriter
    public void write(ActivityStory activityStory, Gson gson, OutputStreamWriter outputStreamWriter) throws JsonIOException {
        gson.toJson(activityStory, outputStreamWriter);
    }
}
