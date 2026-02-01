package com.ua.sdk.suggestedfriends;

import com.ua.sdk.EntityList;
import com.ua.sdk.EntityListRef;
import com.ua.sdk.FetchCallback;
import com.ua.sdk.Reference;
import com.ua.sdk.Request;
import com.ua.sdk.UaException;
import com.ua.sdk.cache.Cache;
import com.ua.sdk.cache.CacheSettings;
import com.ua.sdk.cache.DiskCache;
import com.ua.sdk.internal.AbstractManager;
import com.ua.sdk.internal.EntityService;
import com.ua.sdk.internal.Link;
import com.ua.sdk.internal.LinkEntityRef;
import com.ua.sdk.user.profilephoto.UserProfilePhotoImpl;
import com.ua.sdk.user.profilephoto.UserProfilePhotoManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public class SuggestedFriendsManagerImpl extends AbstractManager<SuggestedFriends> implements SuggestedFriendsManager {
    private UserProfilePhotoManager userProfilePhotoManager;

    public SuggestedFriendsManagerImpl(CacheSettings cacheSettings, Cache cache, DiskCache<SuggestedFriends> diskCache, EntityService<SuggestedFriends> entityService, ExecutorService executorService, UserProfilePhotoManager userProfilePhotoManager) {
        super(cacheSettings, cache, diskCache, entityService, executorService);
        this.userProfilePhotoManager = userProfilePhotoManager;
    }

    private void fetchUserProfilePhoto(SuggestedFriendsImpl suggestedFriendsImpl) throws UaException {
        ArrayList<Link> links = suggestedFriendsImpl.getLinks(SuggestedFriendsImpl.REF_PROFILE_PIC);
        if (links != null) {
            suggestedFriendsImpl.setSuggestedFriendsProfilePicture(((UserProfilePhotoImpl) this.userProfilePhotoManager.fetchCurrentProfilePhoto(new LinkEntityRef(links.get(0).getId(), links.get(0).getHref()))).toImageUrl());
        }
    }

    @Override // com.ua.sdk.suggestedfriends.SuggestedFriendsManager
    public EntityList<SuggestedFriends> fetchSuggestedFriendList(EntityListRef<SuggestedFriends> entityListRef) throws UaException {
        return fetchPage(entityListRef);
    }

    @Override // com.ua.sdk.suggestedfriends.SuggestedFriendsManager
    public Request fetchSuggestedFriendList(EntityListRef<SuggestedFriends> entityListRef, FetchCallback<EntityList<SuggestedFriends>> fetchCallback) {
        return fetchPage(entityListRef, fetchCallback);
    }

    @Override // com.ua.sdk.internal.AbstractManager
    protected EntityList<SuggestedFriends> onPostServiceFetchPage(Reference reference, EntityList<SuggestedFriends> entityList) throws UaException {
        Iterator<SuggestedFriends> it = ((SuggestedFriendsListImpl) entityList).getElements().iterator();
        while (it.hasNext()) {
            fetchUserProfilePhoto((SuggestedFriendsImpl) it.next());
        }
        return entityList;
    }
}
