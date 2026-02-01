package com.ua.sdk.workout;

import android.net.Uri;
import com.ua.sdk.CreateCallback;
import com.ua.sdk.DeleteCallback;
import com.ua.sdk.EntityList;
import com.ua.sdk.FetchCallback;
import com.ua.sdk.MultipleCreateCallback;
import com.ua.sdk.Request;
import com.ua.sdk.SaveCallback;
import com.ua.sdk.UaException;
import com.ua.sdk.UploadCallback;
import com.ua.sdk.activitystory.AttachmentDest;
import com.ua.sdk.cache.Cache;
import com.ua.sdk.cache.CacheSettings;
import com.ua.sdk.concurrent.MultipleCreateRequest;
import com.ua.sdk.concurrent.UploadRequest;
import com.ua.sdk.internal.AbstractManager;
import com.ua.sdk.internal.EntityService;
import com.ua.sdk.internal.MediaService;
import com.ua.sdk.internal.Precondition;
import com.ua.sdk.user.UserManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public class WorkoutManagerImpl extends AbstractManager<Workout> implements WorkoutManager {
    private final MediaService<Workout> mediaService;
    private final UserManager userManager;
    private WorkoutDatabase workoutDatabase;

    public WorkoutManagerImpl(UserManager userManager, CacheSettings cacheSettings, Cache cache, WorkoutDatabase workoutDatabase, EntityService<Workout> entityService, ExecutorService executorService, MediaService<Workout> mediaService) {
        super(cacheSettings, cache, workoutDatabase, entityService, executorService);
        this.userManager = (UserManager) Precondition.isNotNull(userManager, "userManager");
        this.mediaService = (MediaService) Precondition.isNotNull(mediaService, "imageService");
        this.workoutDatabase = workoutDatabase;
    }

    @Override // com.ua.sdk.workout.WorkoutManager
    public WorkoutBuilder getWorkoutBuilderCreate() {
        return new WorkoutBuilderImpl();
    }

    @Override // com.ua.sdk.workout.WorkoutManager
    public WorkoutBuilder getWorkoutBuilderUpdate(Workout workout, boolean z) {
        return new WorkoutBuilderImpl(workout, z);
    }

    @Override // com.ua.sdk.workout.WorkoutManager
    public WorkoutNameGenerator getWorkoutNameGenerator() {
        return new WorkoutNameGeneratorImpl();
    }

    @Override // com.ua.sdk.workout.WorkoutManager
    public Workout createWorkout(Workout workout) throws UaException {
        return create(workout);
    }

    @Override // com.ua.sdk.workout.WorkoutManager
    public Request createWorkout(Workout workout, CreateCallback<Workout> createCallback) {
        return create(workout, createCallback);
    }

    @Override // com.ua.sdk.workout.WorkoutManager
    public Request uploadImage(final Workout workout, final Uri uri, final UploadCallback<Workout> uploadCallback) {
        final UploadRequest uploadRequest = new UploadRequest(uploadCallback);
        uploadRequest.setFuture(this.executor.submit(new Runnable() { // from class: com.ua.sdk.workout.WorkoutManagerImpl.1
            @Override // java.lang.Runnable
            public void run() throws NullPointerException {
                try {
                    WorkoutManagerImpl.this.mediaService.uploadImage(uri, new AttachmentDest(workout.getRef().getHref(), "attachments", 0), uploadCallback);
                    uploadRequest.done(workout, null);
                } catch (UaException e) {
                    uploadRequest.done(workout, e);
                }
            }
        }));
        return uploadRequest;
    }

    @Override // com.ua.sdk.workout.WorkoutManager
    public Request uploadVideo(final Workout workout, final Uri uri, final UploadCallback<Workout> uploadCallback) {
        final UploadRequest uploadRequest = new UploadRequest(uploadCallback);
        uploadRequest.setFuture(this.executor.submit(new Runnable() { // from class: com.ua.sdk.workout.WorkoutManagerImpl.2
            @Override // java.lang.Runnable
            public void run() throws NullPointerException {
                try {
                    WorkoutManagerImpl.this.mediaService.uploadVideo(uri, new AttachmentDest(workout.getRef().getHref(), "attachments", 0, WorkoutManagerImpl.this.userManager.getCurrentUserRef().getId()), uploadCallback);
                    uploadRequest.done(workout, null);
                } catch (UaException e) {
                    uploadRequest.done(workout, e);
                }
            }
        }));
        return uploadRequest;
    }

    @Override // com.ua.sdk.workout.WorkoutManager
    public Request deleteWorkout(WorkoutRef workoutRef, DeleteCallback<WorkoutRef> deleteCallback) {
        return delete(workoutRef, deleteCallback);
    }

    @Override // com.ua.sdk.workout.WorkoutManager
    public void deleteWorkout(WorkoutRef workoutRef) throws UaException {
        delete(workoutRef);
    }

    @Override // com.ua.sdk.workout.WorkoutManager
    public Workout fetchWorkout(WorkoutRef workoutRef, boolean z) throws UaException {
        if (z) {
            return fetch(WorkoutRef.getFieldBuilder(workoutRef).setTimeSeriesField(true).build());
        }
        return fetch(workoutRef);
    }

    @Override // com.ua.sdk.workout.WorkoutManager
    public Request fetchWorkout(WorkoutRef workoutRef, boolean z, FetchCallback<Workout> fetchCallback) {
        if (z) {
            return fetch(WorkoutRef.getFieldBuilder(workoutRef).setTimeSeriesField(true).build(), fetchCallback);
        }
        return fetch(workoutRef, fetchCallback);
    }

    @Override // com.ua.sdk.workout.WorkoutManager
    public EntityList<Workout> fetchWorkoutList(WorkoutListRef workoutListRef) throws UaException {
        return fetchPage(workoutListRef);
    }

    @Override // com.ua.sdk.workout.WorkoutManager
    public Request fetchWorkoutList(WorkoutListRef workoutListRef, FetchCallback<EntityList<Workout>> fetchCallback) {
        return fetchPage(workoutListRef, fetchCallback);
    }

    @Override // com.ua.sdk.workout.WorkoutManager
    public Workout updateWorkout(Workout workout) throws UaException {
        return update(workout);
    }

    @Override // com.ua.sdk.workout.WorkoutManager
    public Request updateWorkout(Workout workout, SaveCallback<Workout> saveCallback) {
        return update(workout, saveCallback);
    }

    @Override // com.ua.sdk.workout.WorkoutManager
    public void cancelUpload() throws IOException {
        this.mediaService.close();
    }

    @Override // com.ua.sdk.workout.WorkoutManager
    public List<Workout> fetchUnsyncedCreatedWorkouts() {
        return this.workoutDatabase.fetchUnsyncedCreatedWorkouts();
    }

    @Override // com.ua.sdk.workout.WorkoutManager
    public Request syncAllUnsyncedWorkouts(MultipleCreateCallback<Workout> multipleCreateCallback) throws UaException {
        final MultipleCreateRequest multipleCreateRequest = new MultipleCreateRequest(multipleCreateCallback);
        final ArrayList arrayList = new ArrayList();
        multipleCreateRequest.setFuture(this.executor.submit(new Runnable() { // from class: com.ua.sdk.workout.WorkoutManagerImpl.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    for (Workout workout : WorkoutManagerImpl.this.fetchUnsyncedCreatedWorkouts()) {
                        WorkoutManagerImpl.this.createWorkout(workout);
                        arrayList.add(workout);
                    }
                    multipleCreateRequest.done(arrayList, null);
                } catch (UaException e) {
                    multipleCreateRequest.done(arrayList, e);
                }
            }
        }));
        return multipleCreateRequest;
    }
}
