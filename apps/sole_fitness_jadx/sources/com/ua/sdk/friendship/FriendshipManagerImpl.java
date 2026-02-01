package com.ua.sdk.friendship;

import com.ua.sdk.CreateCallback;
import com.ua.sdk.DeleteCallback;
import com.ua.sdk.EntityList;
import com.ua.sdk.EntityListRef;
import com.ua.sdk.EntityRef;
import com.ua.sdk.FetchCallback;
import com.ua.sdk.Reference;
import com.ua.sdk.Request;
import com.ua.sdk.SaveCallback;
import com.ua.sdk.UaException;
import com.ua.sdk.cache.Cache;
import com.ua.sdk.cache.CacheSettings;
import com.ua.sdk.cache.DiskCache;
import com.ua.sdk.concurrent.CreateRequest;
import com.ua.sdk.internal.AbstractManager;
import com.ua.sdk.internal.EntityService;
import com.ua.sdk.internal.Link;
import com.ua.sdk.internal.Precondition;
import com.ua.sdk.suggestedfriends.SuggestedFriends;
import com.ua.sdk.suggestedfriends.SuggestedFriendsManager;
import com.ua.sdk.user.User;
import com.ua.sdk.user.UserManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public class FriendshipManagerImpl extends AbstractManager<Friendship> implements FriendshipManager {
    private SuggestedFriendsManager suggestedFriendsManager;
    private UserManager userManager;

    public FriendshipManagerImpl(UserManager userManager, SuggestedFriendsManager suggestedFriendsManager, CacheSettings cacheSettings, Cache cache, DiskCache<Friendship> diskCache, EntityService<Friendship> entityService, ExecutorService executorService) {
        super(cacheSettings, cache, diskCache, entityService, executorService);
        this.userManager = (UserManager) Precondition.isNotNull(userManager, "userManager");
        this.suggestedFriendsManager = (SuggestedFriendsManager) Precondition.isNotNull(suggestedFriendsManager, "suggestedFriendsManager");
    }

    @Override // com.ua.sdk.friendship.FriendshipManager
    public EntityList<Friendship> fetchFriendList(EntityListRef<Friendship> entityListRef) throws UaException {
        return fetchPage(entityListRef);
    }

    @Override // com.ua.sdk.friendship.FriendshipManager
    public Request fetchFriendList(EntityListRef<Friendship> entityListRef, FetchCallback<EntityList<Friendship>> fetchCallback) {
        return fetchPage(entityListRef, fetchCallback);
    }

    @Override // com.ua.sdk.friendship.FriendshipManager
    public Friendship approvePendingFriendRequest(Friendship friendship) throws UaException {
        ((FriendshipImpl) friendship).setFriendshipStatus(FriendshipStatus.ACTIVE);
        return update(friendship);
    }

    @Override // com.ua.sdk.friendship.FriendshipManager
    public Request approvePendingFriendRequest(Friendship friendship, SaveCallback<Friendship> saveCallback) {
        ((FriendshipImpl) friendship).setFriendshipStatus(FriendshipStatus.ACTIVE);
        return update(friendship, saveCallback);
    }

    @Override // com.ua.sdk.friendship.FriendshipManager
    public Friendship approvePendingFriendRequest(FriendshipRef friendshipRef) throws UaException {
        FriendshipImpl friendshipImpl = new FriendshipImpl(friendshipRef);
        friendshipImpl.setFriendshipStatus(FriendshipStatus.ACTIVE);
        return update(friendshipImpl);
    }

    @Override // com.ua.sdk.friendship.FriendshipManager
    public Request approvePendingFriendRequest(FriendshipRef friendshipRef, SaveCallback<Friendship> saveCallback) {
        FriendshipImpl friendshipImpl = new FriendshipImpl(friendshipRef);
        friendshipImpl.setFriendshipStatus(FriendshipStatus.ACTIVE);
        return update(friendshipImpl, saveCallback);
    }

    @Override // com.ua.sdk.friendship.FriendshipManager
    public void deleteOrDenyFriendship(EntityRef<Friendship> entityRef) throws UaException {
        delete(entityRef);
    }

    @Override // com.ua.sdk.friendship.FriendshipManager
    public Request deleteOrDenyFriendship(EntityRef<Friendship> entityRef, DeleteCallback<Reference> deleteCallback) {
        return delete(entityRef, deleteCallback);
    }

    @Override // com.ua.sdk.friendship.FriendshipManager
    public Friendship createNewFriendRequest(EntityRef<User> entityRef, String str) throws UaException {
        return create(getFriendshipBody(entityRef, str));
    }

    @Override // com.ua.sdk.friendship.FriendshipManager
    public Request createNewFriendRequest(EntityRef<User> entityRef, String str, CreateCallback<Friendship> createCallback) {
        return create(getFriendshipBody(entityRef, str), createCallback);
    }

    @Override // com.ua.sdk.friendship.FriendshipManager
    public EntityList<Friendship> createNewFriendRequests(List<EntityRef<User>> list, String str) throws UaException {
        return ((FriendshipService) this.service).patch(getFriendships(list, str));
    }

    @Override // com.ua.sdk.friendship.FriendshipManager
    public Request createNewFriendRequests(final List<EntityRef<User>> list, final String str, CreateCallback<EntityList<Friendship>> createCallback) {
        final CreateRequest createRequest = new CreateRequest(createCallback);
        createRequest.setFuture(this.executor.submit(new Runnable() { // from class: com.ua.sdk.friendship.FriendshipManagerImpl.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    createRequest.done(FriendshipManagerImpl.this.createNewFriendRequests(list, str), null);
                } catch (UaException e) {
                    createRequest.done(null, e);
                }
            }
        }));
        return createRequest;
    }

    private FriendshipImpl getFriendships(List<EntityRef<User>> list, String str) {
        FriendshipImpl friendshipImpl = new FriendshipImpl();
        Iterator<EntityRef<User>> it = list.iterator();
        while (it.hasNext()) {
            friendshipImpl.addFriendship(getFriendshipBody(it.next(), str));
        }
        return friendshipImpl;
    }

    @Override // com.ua.sdk.friendship.FriendshipManager
    public EntityList<SuggestedFriends> fetchSuggestedFriendList(EntityListRef<SuggestedFriends> entityListRef) throws UaException {
        return this.suggestedFriendsManager.fetchSuggestedFriendList(entityListRef);
    }

    @Override // com.ua.sdk.friendship.FriendshipManager
    public Request fetchSuggestedFriendList(EntityListRef<SuggestedFriends> entityListRef, FetchCallback<EntityList<SuggestedFriends>> fetchCallback) {
        return this.suggestedFriendsManager.fetchSuggestedFriendList(entityListRef, fetchCallback);
    }

    @Override // com.ua.sdk.friendship.FriendshipManager
    public EntityList<User> fetchMutualFriendList(EntityListRef<User> entityListRef) throws UaException {
        return this.userManager.fetchUserList(entityListRef);
    }

    @Override // com.ua.sdk.friendship.FriendshipManager
    public Request fetchMutualFriendList(EntityListRef<User> entityListRef, FetchCallback<EntityList<User>> fetchCallback) {
        return this.userManager.fetchUserList(entityListRef, fetchCallback);
    }

    private FriendshipImpl getFriendshipBody(EntityRef<User> entityRef, String str) {
        FriendshipImpl friendshipImpl = new FriendshipImpl();
        EntityRef entityRef2 = (EntityRef) Precondition.isNotNull(this.userManager.getCurrentUserRef());
        EntityRef entityRef3 = (EntityRef) Precondition.isNotNull(entityRef);
        ArrayList<Link> arrayList = new ArrayList<>();
        arrayList.add(new Link(entityRef3.getHref(), entityRef3.getId()));
        friendshipImpl.setLinksForRelation(FriendshipImpl.ARG_TO_USER, arrayList);
        ArrayList<Link> arrayList2 = new ArrayList<>();
        arrayList2.add(new Link(entityRef2.getHref(), entityRef2.getId()));
        friendshipImpl.setLinksForRelation(FriendshipImpl.ARG_FROM_USER, arrayList2);
        friendshipImpl.setMessage(str);
        return friendshipImpl;
    }
}
