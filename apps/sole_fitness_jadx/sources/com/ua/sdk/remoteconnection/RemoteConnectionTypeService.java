package com.ua.sdk.remoteconnection;

import com.ua.sdk.EntityList;
import com.ua.sdk.EntityListRef;
import com.ua.sdk.Reference;
import com.ua.sdk.UaException;
import com.ua.sdk.authentication.AuthenticationManager;
import com.ua.sdk.internal.AbstractResourceService;
import com.ua.sdk.internal.ConnectionFactory;
import com.ua.sdk.internal.JsonParser;
import com.ua.sdk.internal.LinkEntityRef;
import com.ua.sdk.internal.LinkListRef;
import com.ua.sdk.internal.net.UrlBuilder;
import java.net.URL;

/* loaded from: classes2.dex */
public class RemoteConnectionTypeService extends AbstractResourceService<RemoteConnectionType> {
    public EntityListRef<RemoteConnectionType> PAGE_REF;
    public Reference REF;

    public RemoteConnectionTypeService(ConnectionFactory connectionFactory, UrlBuilder urlBuilder, AuthenticationManager authenticationManager, JsonParser<RemoteConnectionType> jsonParser, JsonParser<EntityList<RemoteConnectionType>> jsonParser2) {
        super(connectionFactory, authenticationManager, urlBuilder, jsonParser, null, jsonParser2);
        this.REF = new LinkEntityRef(null, null);
        this.PAGE_REF = new LinkListRef((String) null);
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getCreateUrl() {
        throw new UnsupportedOperationException("Create RemooteConnectionType is not supported.");
    }

    @Override // com.ua.sdk.internal.AbstractResourceService, com.ua.sdk.internal.EntityService
    public RemoteConnectionType fetch(Reference reference) throws UaException {
        if (reference == null) {
            reference = this.REF;
        }
        return (RemoteConnectionType) super.fetch(reference);
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getFetchUrl(Reference reference) {
        return this.urlBuilder.buildGetRemoteConnectionTypeUrl(reference);
    }

    @Override // com.ua.sdk.internal.AbstractResourceService, com.ua.sdk.internal.EntityService
    public EntityList<RemoteConnectionType> fetchPage(EntityListRef<RemoteConnectionType> entityListRef) throws UaException {
        if (entityListRef == null) {
            entityListRef = this.PAGE_REF;
        }
        return super.fetchPage(entityListRef);
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getFetchPageUrl(EntityListRef<RemoteConnectionType> entityListRef) {
        return this.urlBuilder.buildGetRemoteConnectionTypeUrl(entityListRef);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ua.sdk.internal.AbstractResourceService
    public URL getSaveUrl(RemoteConnectionType remoteConnectionType) {
        throw new UnsupportedOperationException("Save RemooteConnectionType is not supported.");
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getDeleteUrl(Reference reference) {
        throw new UnsupportedOperationException("Delete RemooteConnectionType is not supported.");
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getPatchUrl(Reference reference) {
        throw new UnsupportedOperationException("Patch RemooteConnectionType is not supported.");
    }
}
