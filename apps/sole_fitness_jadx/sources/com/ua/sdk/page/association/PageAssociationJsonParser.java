package com.ua.sdk.page.association;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.ua.sdk.UaException;
import com.ua.sdk.internal.AbstractGsonParser;
import com.ua.sdk.net.json.GsonFactory;

/* loaded from: classes2.dex */
public class PageAssociationJsonParser extends AbstractGsonParser<PageAssociation> {
    public PageAssociationJsonParser() {
        super(GsonFactory.newPageAssociationInstance());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ua.sdk.internal.AbstractGsonParser
    public PageAssociation read(Gson gson, JsonReader jsonReader) throws UaException {
        return (PageAssociation) gson.fromJson(jsonReader, PageAssociationImpl.class);
    }
}
