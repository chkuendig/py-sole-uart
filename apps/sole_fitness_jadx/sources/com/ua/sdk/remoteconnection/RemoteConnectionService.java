package com.ua.sdk.remoteconnection;

import com.ua.sdk.EntityList;
import com.ua.sdk.EntityListRef;
import com.ua.sdk.Reference;
import com.ua.sdk.UaException;
import com.ua.sdk.authentication.AuthenticationManager;
import com.ua.sdk.internal.AbstractResourceService;
import com.ua.sdk.internal.ConnectionFactory;
import com.ua.sdk.internal.JsonParser;
import com.ua.sdk.internal.LinkListRef;
import com.ua.sdk.internal.net.UrlBuilder;
import java.net.URL;

/* loaded from: classes2.dex */
public class RemoteConnectionService extends AbstractResourceService<RemoteConnection> {
    public EntityListRef<RemoteConnection> PAGE_REF;

    public RemoteConnectionService(ConnectionFactory connectionFactory, AuthenticationManager authenticationManager, UrlBuilder urlBuilder, JsonParser<RemoteConnection> jsonParser, JsonParser<EntityList<RemoteConnection>> jsonParser2) {
        super(connectionFactory, authenticationManager, urlBuilder, jsonParser, null, jsonParser2);
        this.PAGE_REF = new LinkListRef((String) null);
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getCreateUrl() {
        throw new UnsupportedOperationException("Create RemoteConnection is unsupported.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ua.sdk.internal.AbstractResourceService
    public URL getSaveUrl(RemoteConnection remoteConnection) {
        throw new UnsupportedOperationException("Save RemoteConnection is unsupported.");
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getDeleteUrl(Reference reference) {
        return this.urlBuilder.buildDeleteRemoteConnectionUrl(reference);
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getFetchUrl(Reference reference) {
        return this.urlBuilder.buildGetRemoteConnectionUrl(reference);
    }

    @Override // com.ua.sdk.internal.AbstractResourceService, com.ua.sdk.internal.EntityService
    public EntityList<RemoteConnection> fetchPage(EntityListRef<RemoteConnection> entityListRef) throws UaException {
        if (entityListRef == null) {
            entityListRef = this.PAGE_REF;
        }
        return super.fetchPage(entityListRef);
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getFetchPageUrl(EntityListRef<RemoteConnection> entityListRef) {
        return this.urlBuilder.buildGetRemoteConnectionUrl(entityListRef);
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getPatchUrl(Reference reference) {
        throw new UnsupportedOperationException("Patch RemoteConnection is unsupported.");
    }
}
