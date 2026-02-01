package com.ua.sdk.actigraphysettings;

import com.ua.sdk.EntityListRef;
import com.ua.sdk.Reference;
import com.ua.sdk.authentication.AuthenticationManager;
import com.ua.sdk.internal.AbstractResourceService;
import com.ua.sdk.internal.ConnectionFactory;
import com.ua.sdk.internal.net.UrlBuilder;
import java.net.URL;

/* loaded from: classes2.dex */
public class ActigraphySettingsService extends AbstractResourceService<ActigraphySettings> {
    public ActigraphySettingsService(ConnectionFactory connectionFactory, AuthenticationManager authenticationManager, UrlBuilder urlBuilder, ActigraphySettingsJsonParser actigraphySettingsJsonParser, ActigraphySettingsRequestWriter actigraphySettingsRequestWriter) {
        super(connectionFactory, authenticationManager, urlBuilder, actigraphySettingsJsonParser, actigraphySettingsRequestWriter, null);
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getFetchUrl(Reference reference) {
        return this.urlBuilder.buildGetActigraphySettingsUrl(reference);
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getCreateUrl() {
        return this.urlBuilder.buildGetActigraphyRecorderPriorityUrl();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ua.sdk.internal.AbstractResourceService
    public URL getSaveUrl(ActigraphySettings actigraphySettings) {
        throw new UnsupportedOperationException("Save ActigraphySettings is unsupported.");
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getDeleteUrl(Reference reference) {
        throw new UnsupportedOperationException("Delete ActigraphySettings is unsupported.");
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getFetchPageUrl(EntityListRef<ActigraphySettings> entityListRef) {
        throw new UnsupportedOperationException("Fetch ActigraphySettings page is unsupported.");
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getPatchUrl(Reference reference) {
        throw new UnsupportedOperationException("Patch ActigraphySettings is unsupported.");
    }
}
