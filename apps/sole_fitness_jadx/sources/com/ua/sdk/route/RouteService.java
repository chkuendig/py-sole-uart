package com.ua.sdk.route;

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
public class RouteService extends AbstractResourceService<Route> {
    public RouteService(ConnectionFactory connectionFactory, UrlBuilder urlBuilder, AuthenticationManager authenticationManager, JsonParser<Route> jsonParser, JsonWriter<Route> jsonWriter, JsonParser<EntityList<Route>> jsonParser2) {
        super(connectionFactory, authenticationManager, urlBuilder, jsonParser, jsonWriter, jsonParser2);
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getCreateUrl() {
        return this.urlBuilder.buildCreateRouteUrl();
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getFetchUrl(Reference reference) {
        return this.urlBuilder.buildGetRouteUrl(reference);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ua.sdk.internal.AbstractResourceService
    public URL getSaveUrl(Route route) {
        return this.urlBuilder.buildUpdateRouteUrl(route.getRef());
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getDeleteUrl(Reference reference) {
        return this.urlBuilder.buildDeleteRouteUrl(reference);
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getPatchUrl(Reference reference) {
        throw new UnsupportedOperationException("Patch Route is not supported.");
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getFetchPageUrl(EntityListRef<Route> entityListRef) {
        return this.urlBuilder.buildGetRouteUrl(entityListRef);
    }
}
