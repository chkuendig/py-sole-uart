package com.ua.sdk.gear.user;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.ua.sdk.EntityList;
import com.ua.sdk.UaException;
import com.ua.sdk.internal.AbstractGsonParser;
import com.ua.sdk.net.json.GsonFactory;

/* loaded from: classes2.dex */
public class UserGearListJsonParser extends AbstractGsonParser<EntityList<UserGear>> {
    public UserGearListJsonParser() {
        super(GsonFactory.newGearInstance());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ua.sdk.internal.AbstractGsonParser
    public EntityList<UserGear> read(Gson gson, JsonReader jsonReader) throws UaException {
        return (EntityList) gson.fromJson(jsonReader, new TypeToken<UserGearList>() { // from class: com.ua.sdk.gear.user.UserGearListJsonParser.1
        }.getType());
    }
}
