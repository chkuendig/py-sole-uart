package com.ua.sdk.bodymass;

import com.ua.sdk.EntityList;
import com.ua.sdk.EntityListRef;
import com.ua.sdk.Reference;
import com.ua.sdk.authentication.AuthenticationManager;
import com.ua.sdk.internal.AbstractResourceService;
import com.ua.sdk.internal.ConnectionFactory;
import com.ua.sdk.internal.JsonParser;
import com.ua.sdk.internal.JsonWriter;
import com.ua.sdk.internal.net.UrlBuilder;
import java.net.URL;

/* loaded from: classes2.dex */
public class BodyMassService extends AbstractResourceService<BodyMass> {
    public BodyMassService(ConnectionFactory connectionFactory, AuthenticationManager authenticationManager, UrlBuilder urlBuilder, JsonParser<BodyMass> jsonParser, JsonWriter<BodyMass> jsonWriter, JsonParser<? extends EntityList<BodyMass>> jsonParser2) {
        super(connectionFactory, authenticationManager, urlBuilder, jsonParser, jsonWriter, jsonParser2);
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getCreateUrl() {
        throw new UnsupportedOperationException("Create BodyMass is not supported.");
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getFetchUrl(Reference reference) {
        return this.urlBuilder.buildFetchBodyMassUrl(reference);
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getDeleteUrl(Reference reference) {
        throw new UnsupportedOperationException("Delete BodyMass is not supported.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ua.sdk.internal.AbstractResourceService
    public URL getSaveUrl(BodyMass bodyMass) {
        return this.urlBuilder.buildSaveBodyMassUrl(bodyMass.getRef());
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getPatchUrl(Reference reference) {
        throw new UnsupportedOperationException("Patch BodyMass is not supported.");
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getFetchPageUrl(EntityListRef<BodyMass> entityListRef) {
        return this.urlBuilder.buildFetchBodyMassUrl(entityListRef);
    }
}
