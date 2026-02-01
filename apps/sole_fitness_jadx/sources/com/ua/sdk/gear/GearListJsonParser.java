package com.ua.sdk.gear;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.ua.sdk.EntityList;
import com.ua.sdk.UaException;
import com.ua.sdk.internal.AbstractGsonParser;
import com.ua.sdk.net.json.GsonFactory;

/* loaded from: classes2.dex */
public class GearListJsonParser extends AbstractGsonParser<EntityList<Gear>> {
    public GearListJsonParser() {
        super(GsonFactory.newGearInstance());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ua.sdk.internal.AbstractGsonParser
    public EntityList<Gear> read(Gson gson, JsonReader jsonReader) throws UaException {
        return (EntityList) gson.fromJson(jsonReader, new TypeToken<GearList>() { // from class: com.ua.sdk.gear.GearListJsonParser.1
        }.getType());
    }
}
