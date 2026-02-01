package com.ua.sdk.user;

import android.content.SharedPreferences;
import com.ua.sdk.EntityList;
import com.ua.sdk.EntityListRef;
import com.ua.sdk.EntityRef;
import com.ua.sdk.FetchCallback;
import com.ua.sdk.NetworkError;
import com.ua.sdk.Reference;
import com.ua.sdk.Request;
import com.ua.sdk.SaveCallback;
import com.ua.sdk.UaException;
import com.ua.sdk.UaLog;
import com.ua.sdk.authentication.AuthenticationManager;
import com.ua.sdk.cache.Cache;
import com.ua.sdk.cache.CachePolicy;
import com.ua.sdk.cache.CacheSettings;
import com.ua.sdk.cache.DiskCache;
import com.ua.sdk.internal.AbstractManager;
import com.ua.sdk.internal.EntityService;
import com.ua.sdk.internal.LinkEntityRef;
import com.ua.sdk.internal.Precondition;
import com.ua.sdk.user.profilephoto.UserProfilePhotoImpl;
import com.ua.sdk.user.profilephoto.UserProfilePhotoManager;
import com.ua.sdk.user.profilephoto.UserProfilePhotoRef;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public class UserManagerImpl extends AbstractManager<User> implements UserManager {
    protected static final String PREF_CURRENT_USER_HREF = "mmdk_user_href";
    protected static final String PREF_CURRENT_USER_ID = "mmdk_user_id";
    protected static final long THREAD_WAIT_DELAY = 1000;
    protected AuthenticationManager mAuthManager;
    protected User mCurrentUser;
    protected EntityRef<User> mCurrentUserRef;
    protected final SharedPreferences mSharedPrefs;
    protected UserProfilePhotoManager mUserProfilePhotoManager;
    protected UserService mUserService;

    public UserManagerImpl(CacheSettings cacheSettings, Cache cache, DiskCache<User> diskCache, EntityService<User> entityService, ExecutorService executorService, AuthenticationManager authenticationManager, UserProfilePhotoManager userProfilePhotoManager, SharedPreferences sharedPreferences) {
        super(cacheSettings, cache, diskCache, entityService, executorService);
        this.mSharedPrefs = (SharedPreferences) Precondition.isNotNull(sharedPreferences);
        this.mAuthManager = (AuthenticationManager) Precondition.isNotNull(authenticationManager);
        this.mUserProfilePhotoManager = (UserProfilePhotoManager) Precondition.isNotNull(userProfilePhotoManager);
        this.mUserService = (UserService) entityService;
        if (getCurrentUserRef() != null) {
            try {
                this.mCurrentUser = fetch(getCurrentUserRef(), CachePolicy.CACHE_ONLY_IGNORE_MAX_AGE);
            } catch (UaException e) {
                UaLog.error("Failed to get current user from cache.", (Throwable) e);
            }
        }
    }

    @Override // com.ua.sdk.user.UserManager
    public EntityRef<User> getCurrentUserRef() {
        EntityRef<User> entityRef = this.mCurrentUserRef;
        if (entityRef != null) {
            return entityRef;
        }
        String string = this.mSharedPrefs.getString(PREF_CURRENT_USER_ID, null);
        String string2 = this.mSharedPrefs.getString(PREF_CURRENT_USER_HREF, null);
        if (string != null) {
            this.mCurrentUserRef = new LinkEntityRef(string, string2);
        }
        return this.mCurrentUserRef;
    }

    private void setCurrentUser(User user) {
        if (user != null) {
            this.mCurrentUser = user;
            EntityRef<User> ref = user.getRef();
            this.mCurrentUserRef = ref;
            String id = ref.getId();
            String href = this.mCurrentUserRef.getHref();
            if (id == null || href == null) {
                onLogout();
                return;
            } else {
                this.mSharedPrefs.edit().putString(PREF_CURRENT_USER_ID, id).putString(PREF_CURRENT_USER_HREF, href).commit();
                return;
            }
        }
        onLogout();
    }

    @Override // com.ua.sdk.user.UserManager
    public User getCurrentUser() {
        return this.mCurrentUser;
    }

    @Override // com.ua.sdk.user.UserManager
    public User updateUser(User user) throws UaException {
        return update(user);
    }

    @Override // com.ua.sdk.user.UserManager
    public Request updateUser(User user, SaveCallback<User> saveCallback) {
        return update(user, saveCallback);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ua.sdk.internal.AbstractManager
    public User onPostServiceSave(User user) throws UaException {
        UserImpl userImpl = (UserImpl) user;
        fetchUserProfilePhoto(userImpl);
        if (isCurrentUserRef(user.getRef())) {
            setCurrentUser(userImpl);
        }
        return userImpl;
    }

    @Override // com.ua.sdk.user.UserManager
    public User fetchUser(EntityRef<User> entityRef) throws UaException {
        return fetch(entityRef);
    }

    @Override // com.ua.sdk.user.UserManager
    public Request fetchUser(EntityRef<User> entityRef, FetchCallback<User> fetchCallback) {
        return fetch(entityRef, fetchCallback);
    }

    @Override // com.ua.sdk.user.UserManager
    public Request fetchUser(EntityRef<User> entityRef, CachePolicy cachePolicy, FetchCallback<User> fetchCallback) {
        return fetch(entityRef, cachePolicy, fetchCallback);
    }

    private boolean isCurrentUserRef(Reference reference) {
        if (reference != null && reference.getId() != null) {
            if ((reference instanceof CurrentUserRef) || reference.getId().equalsIgnoreCase("self")) {
                return true;
            }
            EntityRef<User> currentUserRef = getCurrentUserRef();
            if (currentUserRef != null && reference.getId().equals(currentUserRef.getId())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ua.sdk.internal.AbstractManager
    public User onPostServiceFetch(Reference reference, User user) throws UaException {
        if (isCurrentUserRef(reference)) {
            setCurrentUser(user);
        }
        fetchUserProfilePhoto((UserImpl) user);
        return user;
    }

    private void fetchUserProfilePhoto(UserImpl userImpl) throws UaException {
        if (userImpl.getLinks("image") != null) {
            userImpl.setUserProfilePhoto(((UserProfilePhotoImpl) this.mUserProfilePhotoManager.fetchCurrentProfilePhoto(UserProfilePhotoRef.getBuilder().setId(userImpl.getId()).build())).toImageUrl());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ua.sdk.internal.AbstractManager
    public User onPostServiceCreate(User user) throws UaException {
        UserImpl userImpl = (UserImpl) user;
        this.mAuthManager.setOAuth2Credentials(userImpl.getOauth2Credentials());
        setCurrentUser(userImpl);
        fetchUserProfilePhoto(userImpl);
        return userImpl;
    }

    @Override // com.ua.sdk.user.UserManager
    public EntityList<User> fetchUserList(EntityListRef<User> entityListRef) throws UaException {
        return fetchPage(entityListRef);
    }

    @Override // com.ua.sdk.user.UserManager
    public Request fetchUserList(EntityListRef<User> entityListRef, FetchCallback<EntityList<User>> fetchCallback) {
        return fetchPage(entityListRef, fetchCallback);
    }

    @Override // com.ua.sdk.user.UserManager
    public Request fetchUserList(EntityListRef<User> entityListRef, CachePolicy cachePolicy, FetchCallback<EntityList<User>> fetchCallback) {
        return fetchPage(entityListRef, cachePolicy, fetchCallback);
    }

    @Override // com.ua.sdk.internal.AbstractManager
    protected EntityList<User> onPostServiceFetchPage(Reference reference, EntityList<User> entityList) throws UaException {
        Iterator<User> it = ((UserListImpl) entityList).getElements().iterator();
        while (it.hasNext()) {
            fetchUserProfilePhoto((UserImpl) it.next());
        }
        return entityList;
    }

    @Override // com.ua.sdk.user.UserManager
    public User newUser() {
        return new UserImpl();
    }

    @Override // com.ua.sdk.user.UserManager
    public void onLogout() {
        this.mCurrentUser = null;
        this.mCurrentUserRef = null;
        this.mSharedPrefs.edit().remove(PREF_CURRENT_USER_ID).remove(PREF_CURRENT_USER_HREF).commit();
    }

    @Override // com.ua.sdk.internal.AbstractManager
    protected EntityList<User> fetchPage(EntityListRef<User> entityListRef, CachePolicy cachePolicy, boolean z) throws UaException {
        return fetchPage(entityListRef, cachePolicy, z, 0);
    }

    protected EntityList<User> fetchPage(EntityListRef<User> entityListRef, CachePolicy cachePolicy, boolean z, int i) throws InterruptedException, UaException {
        try {
            return super.fetchPage(entityListRef, cachePolicy, z);
        } catch (NetworkError e) {
            if (e.getResponseCode() == 202 && i < 5) {
                try {
                    Thread.sleep(1000L);
                    return fetchPage(entityListRef, cachePolicy, false, i + 1);
                } catch (InterruptedException e2) {
                    throw new UaException(e2);
                }
            }
            if (cachePolicy.checkCache()) {
                return fetchPage(entityListRef, CachePolicy.CACHE_ONLY, z);
            }
            throw e;
        }
    }
}
