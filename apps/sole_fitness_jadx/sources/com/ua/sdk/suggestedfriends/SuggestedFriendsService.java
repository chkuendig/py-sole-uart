package com.ua.sdk.suggestedfriends;

import com.ua.sdk.EntityList;
import com.ua.sdk.EntityListRef;
import com.ua.sdk.Reference;
import com.ua.sdk.authentication.AuthenticationManager;
import com.ua.sdk.internal.AbstractResourceService;
import com.ua.sdk.internal.ConnectionFactory;
import com.ua.sdk.internal.JsonParser;
import com.ua.sdk.internal.net.UrlBuilder;
import java.net.URL;

/* loaded from: classes2.dex */
public class SuggestedFriendsService extends AbstractResourceService<SuggestedFriends> {
    public SuggestedFriendsService(ConnectionFactory connectionFactory, AuthenticationManager authenticationManager, UrlBuilder urlBuilder, JsonParser<? extends EntityList<SuggestedFriends>> jsonParser, JsonParser<SuggestedFriends> jsonParser2) {
        super(connectionFactory, authenticationManager, urlBuilder, jsonParser2, null, jsonParser);
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getCreateUrl() {
        throw new UnsupportedOperationException("Create SuggestedFriends is unsupported.");
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getFetchUrl(Reference reference) {
        throw new UnsupportedOperationException("Fetch SuggestedFriends is unsupported.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ua.sdk.internal.AbstractResourceService
    public URL getSaveUrl(SuggestedFriends suggestedFriends) {
        throw new UnsupportedOperationException("Save SuggestedFriends is unsupported.");
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getDeleteUrl(Reference reference) {
        throw new UnsupportedOperationException("Save SuggestedFriends is unsupported.");
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getFetchPageUrl(EntityListRef<SuggestedFriends> entityListRef) {
        return this.urlBuilder.buildGetSuggestedFriendsUrl(entityListRef);
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getPatchUrl(Reference reference) {
        throw new UnsupportedOperationException("Patch SuggestedFriends is unsupported.");
    }
}
