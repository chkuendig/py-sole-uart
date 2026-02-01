package com.ua.sdk.group.leaderboard;

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
public class GroupLeaderboardService extends AbstractResourceService<GroupLeaderboard> {
    public GroupLeaderboardService(ConnectionFactory connectionFactory, AuthenticationManager authenticationManager, UrlBuilder urlBuilder, JsonParser<GroupLeaderboard> jsonParser, JsonWriter<GroupLeaderboard> jsonWriter, JsonParser<? extends EntityList<GroupLeaderboard>> jsonParser2) {
        super(connectionFactory, authenticationManager, urlBuilder, jsonParser, jsonWriter, jsonParser2);
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getCreateUrl() {
        throw new UnsupportedOperationException();
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getFetchUrl(Reference reference) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ua.sdk.internal.AbstractResourceService
    public URL getSaveUrl(GroupLeaderboard groupLeaderboard) {
        throw new UnsupportedOperationException();
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getDeleteUrl(Reference reference) {
        throw new UnsupportedOperationException();
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getPatchUrl(Reference reference) {
        throw new UnsupportedOperationException();
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getFetchPageUrl(EntityListRef<GroupLeaderboard> entityListRef) {
        return this.urlBuilder.buildFetchGroupLeaderboardListUrl(entityListRef);
    }
}
