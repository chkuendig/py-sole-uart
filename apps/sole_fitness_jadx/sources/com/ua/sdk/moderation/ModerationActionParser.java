package com.ua.sdk.moderation;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.ua.sdk.UaException;
import com.ua.sdk.internal.AbstractGsonParser;
import com.ua.sdk.net.json.GsonFactory;

/* loaded from: classes2.dex */
public class ModerationActionParser extends AbstractGsonParser<ModerationAction> {
    public ModerationActionParser() {
        super(GsonFactory.newModerationInstance());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ua.sdk.internal.AbstractGsonParser
    public ModerationAction read(Gson gson, JsonReader jsonReader) throws UaException {
        return (ModerationAction) gson.fromJson(jsonReader, new TypeToken<ModerationAction>() { // from class: com.ua.sdk.moderation.ModerationActionParser.1
        }.getType());
    }
}
