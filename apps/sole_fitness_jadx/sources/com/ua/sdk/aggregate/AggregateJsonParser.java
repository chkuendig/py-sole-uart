package com.ua.sdk.aggregate;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.ua.sdk.UaException;
import com.ua.sdk.internal.AbstractGsonParser;
import com.ua.sdk.net.json.GsonFactory;

/* loaded from: classes2.dex */
public class AggregateJsonParser extends AbstractGsonParser<Aggregate> {
    public AggregateJsonParser() {
        super(GsonFactory.newAggregateInstance());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ua.sdk.internal.AbstractGsonParser
    public Aggregate read(Gson gson, JsonReader jsonReader) throws UaException {
        return (Aggregate) gson.fromJson(jsonReader, Aggregate.class);
    }
}
