package com.ua.sdk.activitytype;

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
public class ActivityTypeService extends AbstractResourceService<ActivityType> {
    public ActivityTypeService(ConnectionFactory connectionFactory, AuthenticationManager authenticationManager, UrlBuilder urlBuilder, JsonParser<ActivityType> jsonParser, JsonWriter<ActivityType> jsonWriter, JsonParser<ActivityTypeList> jsonParser2) {
        super(connectionFactory, authenticationManager, urlBuilder, jsonParser, jsonWriter, jsonParser2);
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getCreateUrl() {
        throw new UnsupportedOperationException("Activity types may not be created.");
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getFetchUrl(Reference reference) {
        return this.urlBuilder.buildGetActivityTypeUrl(reference);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ua.sdk.internal.AbstractResourceService
    public URL getSaveUrl(ActivityType activityType) {
        throw new UnsupportedOperationException("Activity types may not be saved.");
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getDeleteUrl(Reference reference) {
        throw new UnsupportedOperationException("Activity types may not be deleted.");
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getPatchUrl(Reference reference) {
        throw new UnsupportedOperationException("Activity types may not be patched.");
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getFetchPageUrl(EntityListRef<ActivityType> entityListRef) {
        return this.urlBuilder.buildGetActivityTypeListUrl(entityListRef);
    }
}
