package com.ua.sdk.gear.user;

import com.ua.sdk.CreateCallback;
import com.ua.sdk.DeleteCallback;
import com.ua.sdk.EntityList;
import com.ua.sdk.EntityListRef;
import com.ua.sdk.EntityRef;
import com.ua.sdk.FetchCallback;
import com.ua.sdk.Request;
import com.ua.sdk.UaException;
import com.ua.sdk.cache.Cache;
import com.ua.sdk.cache.CacheSettings;
import com.ua.sdk.cache.DiskCache;
import com.ua.sdk.internal.AbstractManager;
import com.ua.sdk.internal.EntityService;
import com.ua.sdk.internal.LinkEntityRef;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public class UserGearManagerImpl extends AbstractManager<UserGear> implements UserGearManager {
    public UserGearManagerImpl(CacheSettings cacheSettings, Cache cache, DiskCache<UserGear> diskCache, EntityService<UserGear> entityService, ExecutorService executorService) {
        super(cacheSettings, cache, diskCache, entityService, executorService);
    }

    @Override // com.ua.sdk.gear.user.UserGearManager
    public UserGear createEmptyUserGearObject() {
        return new UserGearImpl();
    }

    @Override // com.ua.sdk.gear.user.UserGearManager
    public EntityList<UserGear> fetchUserGear(EntityListRef<UserGear> entityListRef) throws UaException {
        return fetchPage(entityListRef);
    }

    @Override // com.ua.sdk.gear.user.UserGearManager
    public Request fetchUserGear(EntityListRef<UserGear> entityListRef, FetchCallback<EntityList<UserGear>> fetchCallback) {
        return fetchPage(entityListRef, fetchCallback);
    }

    @Override // com.ua.sdk.gear.user.UserGearManager
    public UserGear updateUserGear(EntityRef<UserGear> entityRef, UserGear userGear) throws UaException {
        return patch(userGear, entityRef);
    }

    @Override // com.ua.sdk.gear.user.UserGearManager
    public Request updateUserGear(EntityRef<UserGear> entityRef, UserGear userGear, CreateCallback<UserGear> createCallback) {
        return patch(userGear, entityRef, createCallback);
    }

    private UserGear setDefaultActivities(UserGear userGear) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new LinkEntityRef("9", "/v7.0/activity_type/9/"));
        arrayList.add(new LinkEntityRef("16", "/v7.0/activity_type/16/"));
        arrayList.add(new LinkEntityRef("22", "/v7.0/activity_type/22/"));
        arrayList.add(new LinkEntityRef("24", "/v7.0/activity_type/24/"));
        arrayList.add(new LinkEntityRef("25", "/v7.0/activity_type/25/"));
        userGear.setDefaultActivities(arrayList);
        return userGear;
    }

    @Override // com.ua.sdk.gear.user.UserGearManager
    public UserGear createUserGear(UserGear userGear) throws UaException {
        return create(setDefaultActivities(userGear));
    }

    @Override // com.ua.sdk.gear.user.UserGearManager
    public Request createUserGear(UserGear userGear, CreateCallback<UserGear> createCallback) {
        return create(setDefaultActivities(userGear), createCallback);
    }

    @Override // com.ua.sdk.gear.user.UserGearManager
    public void deleteUserGear(EntityRef<UserGear> entityRef) throws Exception {
        delete(entityRef);
    }

    @Override // com.ua.sdk.gear.user.UserGearManager
    public Request deleteUserGear(EntityRef<UserGear> entityRef, DeleteCallback deleteCallback) {
        return delete(entityRef, deleteCallback);
    }
}
