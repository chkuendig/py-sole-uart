package com.ua.sdk.page.association;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.ua.sdk.UaException;
import com.ua.sdk.internal.AbstractGsonWriter;
import com.ua.sdk.net.json.GsonFactory;
import java.io.OutputStreamWriter;

/* loaded from: classes2.dex */
public class PageAssociationRequestJsonWriter extends AbstractGsonWriter<PageAssociation> {
    public PageAssociationRequestJsonWriter() {
        super(GsonFactory.newInstance());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ua.sdk.internal.AbstractGsonWriter
    public void write(PageAssociation pageAssociation, Gson gson, OutputStreamWriter outputStreamWriter) throws JsonIOException, UaException {
        gson.toJson(PageAssociationRequestTransferObject.fromPageAssociation(pageAssociation), outputStreamWriter);
    }
}
