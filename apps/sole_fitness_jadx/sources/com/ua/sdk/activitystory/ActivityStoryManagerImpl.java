package com.ua.sdk.activitystory;

import android.net.Uri;
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
import com.ua.sdk.UploadCallback;
import com.ua.sdk.activitystory.ActivityStoryActor;
import com.ua.sdk.activitystory.ActivityStoryObject;
import com.ua.sdk.activitystory.ActivityStoryRpcPostObject;
import com.ua.sdk.activitystory.Attachment;
import com.ua.sdk.activitystory.actor.ActivityStoryUserActorImpl;
import com.ua.sdk.activitystory.object.ActivityStoryCommentObjectImpl;
import com.ua.sdk.activitystory.object.ActivityStoryLikeObjectImpl;
import com.ua.sdk.activitystory.object.ActivityStoryPrivacyObjectImpl;
import com.ua.sdk.activitystory.object.ActivityStoryRepostObjectImpl;
import com.ua.sdk.activitystory.object.ActivityStoryRouteObjectImpl;
import com.ua.sdk.activitystory.object.ActivityStoryStatusObjectImpl;
import com.ua.sdk.activitystory.object.ActivityStoryWorkoutObjectImpl;
import com.ua.sdk.activitystory.target.ActivityStoryUnknownTarget;
import com.ua.sdk.cache.Cache;
import com.ua.sdk.cache.CacheSettings;
import com.ua.sdk.cache.DiskCache;
import com.ua.sdk.concurrent.CreateRequest;
import com.ua.sdk.concurrent.EntityEventHandler;
import com.ua.sdk.concurrent.SaveRequest;
import com.ua.sdk.concurrent.SynchronousRequest;
import com.ua.sdk.concurrent.UploadRequest;
import com.ua.sdk.internal.AbstractManager;
import com.ua.sdk.internal.EntityService;
import com.ua.sdk.internal.MediaService;
import com.ua.sdk.internal.Precondition;
import com.ua.sdk.internal.net.v7.UrlBuilderImpl;
import com.ua.sdk.privacy.Privacy;
import com.ua.sdk.privacy.PrivacyHelper;
import com.ua.sdk.user.User;
import com.ua.sdk.user.UserManager;
import com.ua.sdk.user.profilephoto.UserProfilePhotoImpl;
import com.ua.sdk.user.profilephoto.UserProfilePhotoManager;
import com.ua.sdk.user.profilephoto.UserProfilePhotoRef;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public class ActivityStoryManagerImpl extends AbstractManager<ActivityStory> implements ActivityStoryManager {
    private final UserManager mUserManager;
    private final UserProfilePhotoManager mUserProfilePhotoManager;
    private final MediaService<ActivityStory> mediaService;

    public ActivityStoryManagerImpl(UserManager userManager, UserProfilePhotoManager userProfilePhotoManager, MediaService mediaService, CacheSettings cacheSettings, Cache cache, DiskCache<ActivityStory> diskCache, EntityService<ActivityStory> entityService, ExecutorService executorService) {
        super(cacheSettings, cache, diskCache, entityService, executorService);
        this.mUserManager = (UserManager) Precondition.isNotNull(userManager, "userManager");
        this.mUserProfilePhotoManager = (UserProfilePhotoManager) Precondition.isNotNull(userProfilePhotoManager, "userProfilePhotoManager");
        this.mediaService = (MediaService) Precondition.isNotNull(mediaService, "mediaService");
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryManager
    public Request fetchActivityStoryList(EntityListRef<ActivityStory> entityListRef, FetchCallback<EntityList<ActivityStory>> fetchCallback) {
        return fetchPage(entityListRef, fetchCallback);
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryManager
    public EntityList<ActivityStory> fetchActivityStoryList(EntityListRef<ActivityStory> entityListRef) throws UaException {
        return fetchPage(entityListRef);
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryManager
    public Request fetchActivityStory(EntityRef<ActivityStory> entityRef, FetchCallback<ActivityStory> fetchCallback) {
        return fetch(entityRef, fetchCallback);
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryManager
    public ActivityStory fetchActivityStory(EntityRef<ActivityStory> entityRef) throws UaException {
        return fetch(entityRef);
    }

    private ActivityStoryImpl newPost(ActivityStoryObject activityStoryObject, EntityRef<User> entityRef, EntityRef<ActivityStory> entityRef2, ActivityStoryActor activityStoryActor) throws NullPointerException {
        Precondition.isNotNull(activityStoryObject, "object");
        Precondition.isNotNull(entityRef, "currentUserRef");
        ActivityStoryImpl activityStoryImpl = new ActivityStoryImpl();
        if (activityStoryActor == null) {
            activityStoryImpl.mActor = new ActivityStoryUserActorImpl();
            ((ActivityStoryUserActorImpl) activityStoryImpl.mActor).setUser(entityRef);
        } else {
            activityStoryImpl.mActor = activityStoryActor;
        }
        activityStoryImpl.mObject = activityStoryObject;
        if (entityRef2 != null) {
            ActivityStoryUnknownTarget activityStoryUnknownTarget = new ActivityStoryUnknownTarget();
            activityStoryUnknownTarget.setId(entityRef2.getId());
            activityStoryImpl.mTarget = activityStoryUnknownTarget;
        }
        int i = AnonymousClass11.$SwitchMap$com$ua$sdk$activitystory$ActivityStoryObject$Type[activityStoryObject.getType().ordinal()];
        if (i == 1) {
            activityStoryImpl.mVerb = ActivityStoryVerb.LIKE;
        } else if (i == 2) {
            activityStoryImpl.mVerb = ActivityStoryVerb.COMMENT;
        } else {
            if (i == 3) {
                activityStoryImpl.mVerb = ActivityStoryVerb.POST;
            }
            throw new IllegalArgumentException("story object needs to be like or comment.");
        }
        return activityStoryImpl;
    }

    /* renamed from: com.ua.sdk.activitystory.ActivityStoryManagerImpl$11, reason: invalid class name */
    static /* synthetic */ class AnonymousClass11 {
        static final /* synthetic */ int[] $SwitchMap$com$ua$sdk$activitystory$ActivityStoryObject$Type;

        static {
            int[] iArr = new int[ActivityStoryObject.Type.values().length];
            $SwitchMap$com$ua$sdk$activitystory$ActivityStoryObject$Type = iArr;
            try {
                iArr[ActivityStoryObject.Type.LIKE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ua$sdk$activitystory$ActivityStoryObject$Type[ActivityStoryObject.Type.COMMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ua$sdk$activitystory$ActivityStoryObject$Type[ActivityStoryObject.Type.STATUS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ua$sdk$activitystory$ActivityStoryObject$Type[ActivityStoryObject.Type.ROUTE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ua$sdk$activitystory$ActivityStoryObject$Type[ActivityStoryObject.Type.REPOST.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$ua$sdk$activitystory$ActivityStoryObject$Type[ActivityStoryObject.Type.WORKOUT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryManager
    public ActivityStory createLike(EntityRef<ActivityStory> entityRef, ActivityStoryActor activityStoryActor) throws UaException {
        return create(newPost(new ActivityStoryLikeObjectImpl(), this.mUserManager.getCurrentUser().getRef(), entityRef, activityStoryActor));
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryManager
    public Request createLike(final EntityRef<ActivityStory> entityRef, final ActivityStoryActor activityStoryActor, CreateCallback<ActivityStory> createCallback) {
        final CreateRequest createRequest = new CreateRequest(createCallback);
        createRequest.setFuture(this.executor.submit(new Runnable() { // from class: com.ua.sdk.activitystory.ActivityStoryManagerImpl.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    createRequest.done(ActivityStoryManagerImpl.this.createLike(entityRef, activityStoryActor), null);
                } catch (UaException e) {
                    createRequest.done(null, e);
                }
            }
        }));
        return createRequest;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryManager
    public ActivityStory createComment(String str, EntityRef<ActivityStory> entityRef, ActivityStoryActor activityStoryActor) throws UaException {
        return create(newPost(new ActivityStoryCommentObjectImpl(str), this.mUserManager.getCurrentUser().getRef(), entityRef, activityStoryActor));
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryManager
    public Request createComment(final String str, final EntityRef<ActivityStory> entityRef, final ActivityStoryActor activityStoryActor, CreateCallback<ActivityStory> createCallback) {
        final CreateRequest createRequest = new CreateRequest(createCallback);
        createRequest.setFuture(this.executor.submit(new Runnable() { // from class: com.ua.sdk.activitystory.ActivityStoryManagerImpl.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    createRequest.done(ActivityStoryManagerImpl.this.createComment(str, entityRef, activityStoryActor), null);
                } catch (UaException e) {
                    createRequest.done(null, e);
                }
            }
        }));
        return createRequest;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryManager
    public ActivityStory createStatus(String str, Privacy.Level level, SocialSettings socialSettings, ActivityStoryActor activityStoryActor) throws UaException {
        return createStatus(str, level, socialSettings, activityStoryActor, (ActivityStoryTarget) null);
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryManager
    public ActivityStory createStatus(String str, Privacy.Level level, SocialSettings socialSettings, ActivityStoryActor activityStoryActor, ActivityStoryTarget activityStoryTarget) throws UaException {
        ActivityStoryImpl activityStoryImplInitStatus = initStatus(str, level, socialSettings, activityStoryActor);
        if (activityStoryTarget != null) {
            activityStoryImplInitStatus.mTarget = activityStoryTarget;
        }
        return create(activityStoryImplInitStatus);
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryManager
    public ActivityStory createStatusWithImage(String str, Privacy.Level level, SocialSettings socialSettings, ActivityStoryActor activityStoryActor) throws UaException {
        return createStatusWithImage(str, level, socialSettings, activityStoryActor, (ActivityStoryTarget) null);
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryManager
    public ActivityStory createStatusWithImage(String str, Privacy.Level level, SocialSettings socialSettings, ActivityStoryActor activityStoryActor, ActivityStoryTarget activityStoryTarget) throws UaException {
        ActivityStoryImpl activityStoryImplInitStatus = initStatus(str, level, socialSettings, activityStoryActor);
        activityStoryImplInitStatus.mAttachments = new Attachments();
        activityStoryImplInitStatus.mAttachments.addAttachment(Attachment.Type.PHOTO);
        if (activityStoryTarget != null) {
            activityStoryImplInitStatus.mTarget = activityStoryTarget;
        }
        return create(activityStoryImplInitStatus);
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryManager
    public ActivityStory createStatusWithVideo(String str, Privacy.Level level, SocialSettings socialSettings, ActivityStoryActor activityStoryActor) throws UaException {
        return createStatusWithVideo(str, level, socialSettings, activityStoryActor, (ActivityStoryTarget) null);
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryManager
    public ActivityStory createStatusWithVideo(String str, Privacy.Level level, SocialSettings socialSettings, ActivityStoryActor activityStoryActor, ActivityStoryTarget activityStoryTarget) throws UaException {
        ActivityStoryImpl activityStoryImplInitStatus = initStatus(str, level, socialSettings, activityStoryActor);
        activityStoryImplInitStatus.mAttachments = new Attachments();
        activityStoryImplInitStatus.mAttachments.addAttachment(Attachment.Type.VIDEO);
        if (activityStoryTarget != null) {
            activityStoryImplInitStatus.mTarget = activityStoryTarget;
        }
        return create(activityStoryImplInitStatus);
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryManager
    public void cancelUpload() throws IOException {
        this.mediaService.close();
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryManager
    public Request createStatus(String str, Privacy.Level level, SocialSettings socialSettings, ActivityStoryActor activityStoryActor, CreateCallback<ActivityStory> createCallback) {
        return createStatus(str, level, socialSettings, activityStoryActor, null, createCallback);
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryManager
    public Request createStatus(final String str, final Privacy.Level level, final SocialSettings socialSettings, final ActivityStoryActor activityStoryActor, final ActivityStoryTarget activityStoryTarget, CreateCallback<ActivityStory> createCallback) {
        final CreateRequest createRequest = new CreateRequest(createCallback);
        createRequest.setFuture(this.executor.submit(new Runnable() { // from class: com.ua.sdk.activitystory.ActivityStoryManagerImpl.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    createRequest.done(ActivityStoryManagerImpl.this.createStatus(str, level, socialSettings, activityStoryActor, activityStoryTarget), null);
                } catch (UaException e) {
                    createRequest.done(null, e);
                }
            }
        }));
        return createRequest;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryManager
    public ActivityStory repostStatus(ActivityStory activityStory, String str, Privacy.Level level, SocialSettings socialSettings, ActivityStoryActor activityStoryActor) throws UaException {
        ActivityStoryImpl activityStoryImplInitStatus = initStatus(str, level, socialSettings, activityStoryActor);
        activityStoryImplInitStatus.mObject = new ActivityStoryRepostObjectImpl(activityStory.getId(), str, PrivacyHelper.getPrivacy(level));
        activityStoryImplInitStatus.mVerb = ActivityStoryVerb.REPOST;
        ActivityStory activityStoryCreate = create(activityStoryImplInitStatus);
        if (activityStoryCreate != null) {
            ((ActivityStoryRepostObjectImpl) activityStoryCreate.getObject()).setOriginalStory(activityStory);
        }
        return activityStoryCreate;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryManager
    public Request repostStatus(final ActivityStory activityStory, final String str, final Privacy.Level level, final SocialSettings socialSettings, final ActivityStoryActor activityStoryActor, CreateCallback<ActivityStory> createCallback) {
        final CreateRequest createRequest = new CreateRequest(createCallback);
        createRequest.setFuture(this.executor.submit(new Runnable() { // from class: com.ua.sdk.activitystory.ActivityStoryManagerImpl.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    createRequest.done(ActivityStoryManagerImpl.this.repostStatus(activityStory, str, level, socialSettings, activityStoryActor), null);
                } catch (UaException e) {
                    createRequest.done(null, e);
                }
            }
        }));
        return createRequest;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryManager
    public Request createStatusWithImage(String str, Privacy.Level level, SocialSettings socialSettings, ActivityStoryActor activityStoryActor, CreateCallback<ActivityStory> createCallback) {
        return createStatusWithImage(str, level, socialSettings, activityStoryActor, null, createCallback);
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryManager
    public Request createStatusWithImage(final String str, final Privacy.Level level, final SocialSettings socialSettings, final ActivityStoryActor activityStoryActor, final ActivityStoryTarget activityStoryTarget, CreateCallback<ActivityStory> createCallback) {
        final CreateRequest createRequest = new CreateRequest(createCallback);
        createRequest.setFuture(this.executor.submit(new Runnable() { // from class: com.ua.sdk.activitystory.ActivityStoryManagerImpl.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    createRequest.done(ActivityStoryManagerImpl.this.createStatusWithImage(str, level, socialSettings, activityStoryActor, activityStoryTarget), null);
                } catch (UaException e) {
                    createRequest.done(null, e);
                }
            }
        }));
        return createRequest;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryManager
    public Request createStatusWithVideo(String str, Privacy.Level level, SocialSettings socialSettings, ActivityStoryActor activityStoryActor, CreateCallback<ActivityStory> createCallback) {
        return createStatusWithVideo(str, level, socialSettings, activityStoryActor, null, createCallback);
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryManager
    public Request createStatusWithVideo(final String str, final Privacy.Level level, final SocialSettings socialSettings, final ActivityStoryActor activityStoryActor, final ActivityStoryTarget activityStoryTarget, CreateCallback<ActivityStory> createCallback) {
        final CreateRequest createRequest = new CreateRequest(createCallback);
        createRequest.setFuture(this.executor.submit(new Runnable() { // from class: com.ua.sdk.activitystory.ActivityStoryManagerImpl.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    createRequest.done(ActivityStoryManagerImpl.this.createStatusWithVideo(str, level, socialSettings, activityStoryActor, activityStoryTarget), null);
                } catch (UaException e) {
                    createRequest.done(null, e);
                }
            }
        }));
        return createRequest;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryManager
    public Request attachImageWithStatus(final ActivityStory activityStory, final Uri uri, final UploadCallback uploadCallback) {
        final UploadRequest uploadRequest = new UploadRequest(uploadCallback);
        uploadRequest.setFuture(this.executor.submit(new Runnable() { // from class: com.ua.sdk.activitystory.ActivityStoryManagerImpl.7
            @Override // java.lang.Runnable
            public void run() throws NullPointerException {
                try {
                    ActivityStoryManagerImpl.this.mediaService.uploadImage(uri, new AttachmentDest(activityStory.getRef().getHref(), "attachments", 0), uploadCallback);
                    uploadRequest.done(activityStory, null);
                } catch (UaException e) {
                    uploadRequest.done(activityStory, e);
                }
            }
        }));
        return uploadRequest;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryManager
    public Request attachVideoWithStatus(final ActivityStory activityStory, final Uri uri, final UploadCallback uploadCallback) {
        final UploadRequest uploadRequest = new UploadRequest(uploadCallback);
        uploadRequest.setFuture(this.executor.submit(new Runnable() { // from class: com.ua.sdk.activitystory.ActivityStoryManagerImpl.8
            @Override // java.lang.Runnable
            public void run() throws NullPointerException {
                try {
                    ActivityStoryManagerImpl.this.mediaService.uploadVideo(uri, new AttachmentDest(activityStory.getRef().getHref(), "attachments", 0, ActivityStoryManagerImpl.this.mUserManager.getCurrentUserRef().getId()), uploadCallback);
                    uploadRequest.done(activityStory, null);
                } catch (UaException e) {
                    uploadRequest.done(activityStory, e);
                }
            }
        }));
        return uploadRequest;
    }

    private ActivityStoryImpl initStatus(String str, Privacy.Level level, SocialSettings socialSettings, ActivityStoryActor activityStoryActor) throws UaException {
        EntityRef<User> ref = this.mUserManager.getCurrentUser().getRef();
        ActivityStoryImpl activityStoryImpl = new ActivityStoryImpl();
        if (activityStoryActor == null) {
            activityStoryActor = new ActivityStoryUserActorImpl(ref.getId());
        }
        activityStoryImpl.mActor = activityStoryActor;
        activityStoryImpl.mObject = new ActivityStoryStatusObjectImpl(str, PrivacyHelper.getPrivacy(level));
        activityStoryImpl.mVerb = ActivityStoryVerb.POST;
        if (socialSettings != null) {
            activityStoryImpl.mSharingSettngs = socialSettings;
        }
        return activityStoryImpl;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryManager
    public EntityRef<ActivityStory> deleteStory(EntityRef<ActivityStory> entityRef) throws UaException {
        return (EntityRef) delete(entityRef);
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryManager
    public Request deleteStory(EntityRef<ActivityStory> entityRef, DeleteCallback<EntityRef<ActivityStory>> deleteCallback) {
        return delete(entityRef, deleteCallback);
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryManager
    public Request deleteLike(ActivityStory activityStory, DeleteCallback<EntityRef<ActivityStory>> deleteCallback) {
        if (activityStory.isLikedByCurrentUser()) {
            return deleteStory(activityStory.getLikesSummary().getReplyRef(), deleteCallback);
        }
        EntityEventHandler.callOnDeleted(null, new UaException("Story is not liked by the current user."), deleteCallback);
        return SynchronousRequest.INSTANCE;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryManager
    public ActivityStory updateStoryPrivacy(ActivityStory activityStory, Privacy.Level level) throws UaException {
        ActivityStoryObject.Type type = activityStory.getObject().getType();
        int i = AnonymousClass11.$SwitchMap$com$ua$sdk$activitystory$ActivityStoryObject$Type[type.ordinal()];
        if (i != 3) {
            if (i == 4) {
                return update(new ActivityStoryRpcPostObject.Builder(PrivacyHelper.getPrivacy(level)).setLink(String.format(UrlBuilderImpl.PATCH_ROUTE, ((ActivityStoryRouteObjectImpl) activityStory.getObject()).getRouteId())).build());
            }
            if (i != 5 && i != 6) {
                throw new UaException("Attempted to update privacy on a privacy story type that is incompatible");
            }
        }
        ActivityStoryImpl activityStoryImpl = new ActivityStoryImpl();
        activityStoryImpl.mObject = new ActivityStoryPrivacyObjectImpl.Builder(type, level).build();
        return patch(activityStoryImpl, activityStory.getRef());
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryManager
    public Request updateStoryPrivacy(final ActivityStory activityStory, final Privacy.Level level, SaveCallback<ActivityStory> saveCallback) {
        final SaveRequest saveRequest = new SaveRequest(saveCallback);
        saveRequest.setFuture(this.executor.submit(new Runnable() { // from class: com.ua.sdk.activitystory.ActivityStoryManagerImpl.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    saveRequest.done(ActivityStoryManagerImpl.this.updateStoryPrivacy(activityStory, level), null);
                } catch (UaException e) {
                    saveRequest.done(null, e);
                }
            }
        }));
        return saveRequest;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryManager
    public ActivityStory updateStoryStatus(ActivityStory activityStory, String str) throws UaException {
        ActivityStoryObject.Type type = activityStory.getObject().getType();
        ActivityStoryImpl activityStoryImpl = new ActivityStoryImpl();
        int i = AnonymousClass11.$SwitchMap$com$ua$sdk$activitystory$ActivityStoryObject$Type[type.ordinal()];
        if (i == 3) {
            activityStoryImpl.mObject = new ActivityStoryStatusObjectImpl(str, null);
        } else if (i == 5) {
            activityStoryImpl.mObject = new ActivityStoryRepostObjectImpl(null, str, null);
        } else if (i == 6) {
            activityStoryImpl.mObject = new ActivityStoryWorkoutObjectImpl(str);
        } else {
            throw new UaException("Attempted to update status on a story type that is not compatible");
        }
        return patch(activityStoryImpl, activityStory.getRef());
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryManager
    public Request updateStoryStatus(final ActivityStory activityStory, final String str, SaveCallback<ActivityStory> saveCallback) {
        final SaveRequest saveRequest = new SaveRequest(saveCallback);
        saveRequest.setFuture(this.executor.submit(new Runnable() { // from class: com.ua.sdk.activitystory.ActivityStoryManagerImpl.10
            @Override // java.lang.Runnable
            public void run() {
                try {
                    saveRequest.done(ActivityStoryManagerImpl.this.updateStoryStatus(activityStory, str), null);
                } catch (UaException e) {
                    saveRequest.done(null, e);
                }
            }
        }));
        return saveRequest;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ua.sdk.internal.AbstractManager
    public ActivityStory onPostServiceFetch(Reference reference, ActivityStory activityStory) throws UaException {
        if (activityStory == null) {
            return null;
        }
        ActivityStoryImpl activityStoryImpl = (ActivityStoryImpl) activityStory;
        if (activityStoryImpl.getActor() != null && activityStoryImpl.getActor().getType() == ActivityStoryActor.Type.USER) {
            ((ActivityStoryUserActorImpl) activityStoryImpl.getActor()).setUserProfilePicture(((UserProfilePhotoImpl) this.mUserProfilePhotoManager.fetchCurrentProfilePhoto(UserProfilePhotoRef.getBuilder().setId(((ActivityStoryUserActorImpl) activityStoryImpl.getActor()).getId()).build())).toImageUrl());
        }
        return activityStoryImpl;
    }

    @Override // com.ua.sdk.internal.AbstractManager
    protected EntityList<ActivityStory> onPostServiceFetchPage(Reference reference, EntityList<ActivityStory> entityList) throws UaException {
        if (entityList == null) {
            return null;
        }
        Iterator<ActivityStory> it = entityList.getAll().iterator();
        while (it.hasNext()) {
            onPostServiceFetch(reference, it.next());
        }
        return entityList;
    }
}
