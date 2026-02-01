package com.ua.sdk.activitytype;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.ua.sdk.internal.JsonParser;
import java.io.InputStream;
import java.io.InputStreamReader;

/* loaded from: classes2.dex */
public class ActivityTypeParser implements JsonParser<ActivityType> {
    private Gson gson;

    public ActivityTypeParser(Gson gson) {
        this.gson = gson;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ua.sdk.internal.JsonParser
    public ActivityType parse(InputStream inputStream) {
        return ActivityTypeTransferObject.toImpl((ActivityTypeTransferObject) this.gson.fromJson(new JsonReader(new InputStreamReader(inputStream)), ActivityTypeTransferObject.class));
    }
}
