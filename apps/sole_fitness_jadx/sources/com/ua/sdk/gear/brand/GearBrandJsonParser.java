package com.ua.sdk.gear.brand;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.ua.sdk.UaException;
import com.ua.sdk.internal.AbstractGsonParser;
import com.ua.sdk.net.json.GsonFactory;

/* loaded from: classes2.dex */
public class GearBrandJsonParser extends AbstractGsonParser<GearBrand> {
    public GearBrandJsonParser() {
        super(GsonFactory.newGearInstance());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ua.sdk.internal.AbstractGsonParser
    public GearBrand read(Gson gson, JsonReader jsonReader) throws UaException {
        return (GearBrand) gson.fromJson(jsonReader, new TypeToken<GearBrand>() { // from class: com.ua.sdk.gear.brand.GearBrandJsonParser.1
        }.getType());
    }
}
