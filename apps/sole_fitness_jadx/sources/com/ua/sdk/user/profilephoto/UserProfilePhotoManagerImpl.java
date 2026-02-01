package com.ua.sdk.user.profilephoto;

import android.content.SharedPreferences;
import android.net.Uri;
import com.ua.sdk.EntityRef;
import com.ua.sdk.FetchCallback;
import com.ua.sdk.Request;
import com.ua.sdk.SaveCallback;
import com.ua.sdk.UaException;
import com.ua.sdk.UaLog;
import com.ua.sdk.cache.Cache;
import com.ua.sdk.cache.CacheSettings;
import com.ua.sdk.cache.DiskCache;
import com.ua.sdk.concurrent.SaveRequest;
import com.ua.sdk.internal.AbstractManager;
import com.ua.sdk.internal.EntityService;
import com.ua.sdk.internal.MediaService;
import com.ua.sdk.internal.Precondition;
import com.ua.sdk.internal.net.v7.UrlBuilderImpl;
import java.util.Locale;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public class UserProfilePhotoManagerImpl extends AbstractManager<UserProfilePhoto> implements UserProfilePhotoManager {
    protected static final String PREF_CURRENT_PICTURE_PROFILE_LAST_SAVED = "mmdk_user_last_saved";
    private final MediaService<UserProfilePhoto> mediaService;
    private final SharedPreferences sharedPreferences;

    public UserProfilePhotoManagerImpl(MediaService<UserProfilePhoto> mediaService, CacheSettings cacheSettings, Cache cache, DiskCache<UserProfilePhoto> diskCache, EntityService<UserProfilePhoto> entityService, ExecutorService executorService, SharedPreferences sharedPreferences) {
        super(cacheSettings, cache, diskCache, entityService, executorService);
        this.mediaService = (MediaService) Precondition.isNotNull(mediaService, "mediaService");
        this.sharedPreferences = (SharedPreferences) Precondition.isNotNull(sharedPreferences);
    }

    @Override // com.ua.sdk.user.profilephoto.UserProfilePhotoManager
    public UserProfilePhoto fetchCurrentProfilePhoto(EntityRef<UserProfilePhoto> entityRef) throws UaException {
        if (entityRef == null) {
            throw new UaException("ref can't be null");
        }
        String string = this.sharedPreferences.getString(PREF_CURRENT_PICTURE_PROFILE_LAST_SAVED, "");
        UserProfilePhotoImpl userProfilePhotoImpl = new UserProfilePhotoImpl();
        userProfilePhotoImpl.setRef(entityRef);
        userProfilePhotoImpl.setLargeImageURL(String.format(Locale.US, UrlBuilderImpl.GET_USER_PROFILE_PICTURE_DIRECT_URL, entityRef.getId(), "Large", string));
        userProfilePhotoImpl.setMediumImageURL(String.format(Locale.US, UrlBuilderImpl.GET_USER_PROFILE_PICTURE_DIRECT_URL, entityRef.getId(), "Medium", string));
        userProfilePhotoImpl.setSmallImageURL(String.format(Locale.US, UrlBuilderImpl.GET_USER_PROFILE_PICTURE_DIRECT_URL, entityRef.getId(), "Small", string));
        return userProfilePhotoImpl;
    }

    @Override // com.ua.sdk.user.profilephoto.UserProfilePhotoManager
    public Request fetchCurrentProfilePhoto(EntityRef<UserProfilePhoto> entityRef, FetchCallback<UserProfilePhoto> fetchCallback) {
        return fetch(entityRef, fetchCallback);
    }

    @Override // com.ua.sdk.user.profilephoto.UserProfilePhotoManager
    public UserProfilePhoto updateUserProfilePhoto(Uri uri, UserProfilePhoto userProfilePhoto) throws UaException {
        if (uri == null) {
            throw new UaException("Uri image cannot be NULL!");
        }
        if (userProfilePhoto == null) {
            throw new UaException("User profile picture entity cannot be NULL!");
        }
        return (UserProfilePhoto) this.mediaService.uploadUserProfileImage(uri, userProfilePhoto);
    }

    @Override // com.ua.sdk.user.profilephoto.UserProfilePhotoManager
    public Request updateUserProfilePhoto(final Uri uri, final UserProfilePhoto userProfilePhoto, SaveCallback<UserProfilePhoto> saveCallback) {
        final SaveRequest saveRequest = new SaveRequest(saveCallback);
        saveRequest.setFuture(this.executor.submit(new Runnable() { // from class: com.ua.sdk.user.profilephoto.UserProfilePhotoManagerImpl.1
            @Override // java.lang.Runnable
            public void run() throws UaException {
                UserProfilePhoto userProfilePhotoUpdateUserProfilePhoto = null;
                try {
                    e = null;
                    userProfilePhotoUpdateUserProfilePhoto = UserProfilePhotoManagerImpl.this.updateUserProfilePhoto(uri, userProfilePhoto);
                } catch (UaException e) {
                    e = e;
                    UaLog.error("Failed to save user profile picture!", (Throwable) e);
                }
                saveRequest.done(userProfilePhotoUpdateUserProfilePhoto, e);
            }
        }));
        return saveRequest;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ua.sdk.internal.AbstractManager
    public UserProfilePhoto onPostServiceSave(UserProfilePhoto userProfilePhoto) throws UaException {
        this.sharedPreferences.edit().putString(PREF_CURRENT_PICTURE_PROFILE_LAST_SAVED, String.valueOf(System.currentTimeMillis())).apply();
        return (UserProfilePhoto) super.onPostServiceSave((UserProfilePhotoManagerImpl) userProfilePhoto);
    }
}
