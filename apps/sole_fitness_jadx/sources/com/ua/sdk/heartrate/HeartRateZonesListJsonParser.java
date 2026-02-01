package com.ua.sdk.heartrate;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.ua.sdk.UaException;
import com.ua.sdk.internal.AbstractGsonParser;
import com.ua.sdk.net.json.GsonFactory;

/* loaded from: classes2.dex */
public class HeartRateZonesListJsonParser extends AbstractGsonParser<HeartRateZonesList> {
    public HeartRateZonesListJsonParser() {
        super(GsonFactory.newHeartRateInstance());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ua.sdk.internal.AbstractGsonParser
    public HeartRateZonesList read(Gson gson, JsonReader jsonReader) throws UaException {
        return (HeartRateZonesList) gson.fromJson(jsonReader, new TypeToken<HeartRateZonesList>() { // from class: com.ua.sdk.heartrate.HeartRateZonesListJsonParser.1
        }.getType());
    }
}
