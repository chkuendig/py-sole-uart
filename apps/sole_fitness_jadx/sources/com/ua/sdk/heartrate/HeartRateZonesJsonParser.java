package com.ua.sdk.heartrate;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.ua.sdk.UaException;
import com.ua.sdk.internal.AbstractGsonParser;
import com.ua.sdk.net.json.GsonFactory;

/* loaded from: classes2.dex */
public class HeartRateZonesJsonParser extends AbstractGsonParser<HeartRateZones> {
    public HeartRateZonesJsonParser() {
        super(GsonFactory.newHeartRateInstance());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ua.sdk.internal.AbstractGsonParser
    public HeartRateZones read(Gson gson, JsonReader jsonReader) throws UaException {
        return (HeartRateZones) gson.fromJson(jsonReader, HeartRateZones.class);
    }
}
