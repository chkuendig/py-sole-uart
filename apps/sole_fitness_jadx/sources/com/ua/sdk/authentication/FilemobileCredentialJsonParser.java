package com.ua.sdk.authentication;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.ua.sdk.UaException;
import com.ua.sdk.internal.AbstractGsonParser;
import com.ua.sdk.net.json.GsonFactory;

/* loaded from: classes2.dex */
public class FilemobileCredentialJsonParser extends AbstractGsonParser<FilemobileCredential> {
    public FilemobileCredentialJsonParser() {
        super(GsonFactory.newFilemobileCredentialInstance());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ua.sdk.internal.AbstractGsonParser
    public FilemobileCredential read(Gson gson, JsonReader jsonReader) throws UaException {
        return (FilemobileCredential) gson.fromJson(jsonReader, FilemobileCredential.class);
    }
}
