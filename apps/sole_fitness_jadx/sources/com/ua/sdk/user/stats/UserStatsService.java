package com.ua.sdk.user.stats;

import com.ua.sdk.EntityListRef;
import com.ua.sdk.Reference;
import com.ua.sdk.authentication.AuthenticationManager;
import com.ua.sdk.internal.AbstractResourceService;
import com.ua.sdk.internal.ConnectionFactory;
import com.ua.sdk.internal.JsonParser;
import com.ua.sdk.internal.net.UrlBuilder;
import java.net.URL;

/* loaded from: classes2.dex */
public class UserStatsService extends AbstractResourceService<UserStats> {
    public UserStatsService(ConnectionFactory connectionFactory, AuthenticationManager authenticationManager, UrlBuilder urlBuilder, JsonParser<UserStats> jsonParser) {
        super(connectionFactory, authenticationManager, urlBuilder, jsonParser, null, null);
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getCreateUrl() {
        throw new UnsupportedOperationException("Create UserStats not supported.");
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getFetchUrl(Reference reference) {
        return this.urlBuilder.buildGetUserStatsUrl(reference);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ua.sdk.internal.AbstractResourceService
    public URL getSaveUrl(UserStats userStats) {
        throw new UnsupportedOperationException("Save UserStats not supported.");
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getDeleteUrl(Reference reference) {
        throw new UnsupportedOperationException("Delete UserStats not supported.");
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getPatchUrl(Reference reference) {
        throw new UnsupportedOperationException("Patch UserStats not supported.");
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getFetchPageUrl(EntityListRef<UserStats> entityListRef) {
        throw new UnsupportedOperationException("Fetch UserStats page not supported.");
    }
}
