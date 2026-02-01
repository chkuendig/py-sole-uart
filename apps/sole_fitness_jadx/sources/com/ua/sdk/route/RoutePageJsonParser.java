package com.ua.sdk.route;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.stream.JsonReader;
import com.ua.sdk.EntityList;
import com.ua.sdk.UaException;
import com.ua.sdk.internal.JsonParser;
import java.io.InputStream;
import java.io.InputStreamReader;

/* loaded from: classes2.dex */
public class RoutePageJsonParser implements JsonParser<EntityList<Route>> {
    private Gson gson;

    public RoutePageJsonParser(Gson gson) {
        this.gson = gson;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ua.sdk.internal.JsonParser
    public EntityList<Route> parse(InputStream inputStream) throws UaException {
        try {
            return RoutePageTO.fromTransferObject((RoutePageTO) this.gson.fromJson(new JsonReader(new InputStreamReader(inputStream)), RoutePageTO.class));
        } catch (JsonParseException e) {
            throw new UaException(e);
        }
    }
}
