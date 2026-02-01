package com.ua.sdk.user.profilephoto;

import com.ua.sdk.EntityListRef;
import com.ua.sdk.Reference;
import com.ua.sdk.authentication.AuthenticationManager;
import com.ua.sdk.internal.AbstractResourceService;
import com.ua.sdk.internal.ConnectionFactory;
import com.ua.sdk.internal.JsonParser;
import com.ua.sdk.internal.net.UrlBuilder;
import java.net.URL;

/* loaded from: classes2.dex */
public class UserProfilePhotoService extends AbstractResourceService<UserProfilePhoto> {
    public UserProfilePhotoService(ConnectionFactory connectionFactory, AuthenticationManager authenticationManager, UrlBuilder urlBuilder, JsonParser<UserProfilePhoto> jsonParser) {
        super(connectionFactory, authenticationManager, urlBuilder, jsonParser, null, null);
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getCreateUrl() {
        throw new UnsupportedOperationException("Create UserProfilePhotos not supported.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ua.sdk.internal.AbstractResourceService
    public URL getSaveUrl(UserProfilePhoto userProfilePhoto) {
        throw new UnsupportedOperationException("Save UserProfilePhotos not supported.");
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getDeleteUrl(Reference reference) {
        throw new UnsupportedOperationException("Delete UserProfilePhotos not supported.");
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getFetchUrl(Reference reference) {
        return this.urlBuilder.buildGetUserProfilePhotoUrl(reference);
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getFetchPageUrl(EntityListRef<UserProfilePhoto> entityListRef) {
        throw new UnsupportedOperationException("Fetch UserProfilePhotos page not supported.");
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getPatchUrl(Reference reference) {
        throw new UnsupportedOperationException("Patch UserProfilePhotos not supported.");
    }
}
