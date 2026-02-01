package com.ua.sdk.user.role;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.ua.sdk.UaException;
import com.ua.sdk.internal.AbstractGsonParser;

/* loaded from: classes2.dex */
public class UserRoleJsonParser extends AbstractGsonParser<UserRole> {
    public UserRoleJsonParser(Gson gson) {
        super(gson);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ua.sdk.internal.AbstractGsonParser
    public UserRole read(Gson gson, JsonReader jsonReader) throws UaException {
        return UserRoleTO.fromTransferObject((UserRoleTO) gson.fromJson(jsonReader, UserRoleTO.class));
    }
}
