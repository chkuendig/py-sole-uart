package com.ua.sdk.role;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.ua.sdk.UaException;
import com.ua.sdk.internal.AbstractGsonParser;

/* loaded from: classes2.dex */
public class RoleJsonParser extends AbstractGsonParser<Role> {
    public RoleJsonParser(Gson gson) {
        super(gson);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ua.sdk.internal.AbstractGsonParser
    public Role read(Gson gson, JsonReader jsonReader) throws UaException {
        return RoleTO.fromTransferObject((RoleTO) gson.fromJson(jsonReader, RoleTO.class));
    }
}
