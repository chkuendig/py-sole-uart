package com.ua.sdk.moderation;

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
public class ModerationActionService extends AbstractResourceService<ModerationAction> {
    public ModerationActionService(ConnectionFactory connectionFactory, AuthenticationManager authenticationManager, UrlBuilder urlBuilder, JsonParser<ModerationAction> jsonParser, JsonWriter<ModerationAction> jsonWriter) {
        super(connectionFactory, authenticationManager, urlBuilder, jsonParser, jsonWriter, null);
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getCreateUrl() {
        return this.urlBuilder.buildCreateModerationActionUrl();
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getFetchUrl(Reference reference) {
        throw new UnsupportedOperationException("Fetch ModerationAction is not supported");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ua.sdk.internal.AbstractResourceService
    public URL getSaveUrl(ModerationAction moderationAction) {
        throw new UnsupportedOperationException("Save ModerationAction is not supported");
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getDeleteUrl(Reference reference) {
        throw new UnsupportedOperationException("Delete ModerationAction is not supported");
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getPatchUrl(Reference reference) {
        throw new UnsupportedOperationException("Patch ModerationAction is not supported");
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getFetchPageUrl(EntityListRef<ModerationAction> entityListRef) {
        throw new UnsupportedOperationException("Fetch ModerationActions is not supported");
    }
}
