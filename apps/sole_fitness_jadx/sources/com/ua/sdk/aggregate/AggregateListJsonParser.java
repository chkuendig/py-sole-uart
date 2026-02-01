package com.ua.sdk.aggregate;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.ua.sdk.UaException;
import com.ua.sdk.internal.AbstractGsonParser;
import com.ua.sdk.net.json.GsonFactory;

/* loaded from: classes2.dex */
public class AggregateListJsonParser extends AbstractGsonParser<AggregateList> {
    public AggregateListJsonParser() {
        super(GsonFactory.newAggregateInstance());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ua.sdk.internal.AbstractGsonParser
    public AggregateList read(Gson gson, JsonReader jsonReader) throws UaException {
        return (AggregateList) gson.fromJson(jsonReader, new TypeToken<AggregateList>() { // from class: com.ua.sdk.aggregate.AggregateListJsonParser.1
        }.getType());
    }
}
