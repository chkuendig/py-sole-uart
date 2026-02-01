package com.ua.sdk.gear;

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
import com.ua.sdk.gear.brand.GearBrand;
import com.ua.sdk.gear.brand.GearBrandManager;
import com.ua.sdk.gear.user.UserGear;
import com.ua.sdk.gear.user.UserGearManager;
import com.ua.sdk.internal.AbstractManager;
import com.ua.sdk.internal.EntityService;
import com.ua.sdk.internal.Precondition;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public class GearManagerImpl extends AbstractManager<Gear> implements GearManager {
    private final GearBrandManager gearBrandManager;
    private final UserGearManager userGearManager;

    public GearManagerImpl(CacheSettings cacheSettings, Cache cache, DiskCache<Gear> diskCache, EntityService<Gear> entityService, ExecutorService executorService, GearBrandManager gearBrandManager, UserGearManager userGearManager) {
        super(cacheSettings, cache, diskCache, entityService, executorService);
        this.gearBrandManager = (GearBrandManager) Precondition.isNotNull(gearBrandManager);
        this.userGearManager = (UserGearManager) Precondition.isNotNull(userGearManager);
    }

    @Override // com.ua.sdk.gear.GearManager
    public EntityList<Gear> fetchGearFromBrand(EntityListRef<Gear> entityListRef) throws UaException {
        return fetchPage(entityListRef);
    }

    @Override // com.ua.sdk.gear.GearManager
    public Request fetchGearFromBrand(EntityListRef<Gear> entityListRef, FetchCallback<EntityList<Gear>> fetchCallback) {
        return fetchPage(entityListRef, fetchCallback);
    }

    @Override // com.ua.sdk.gear.GearManager
    public EntityList<GearBrand> fetchGearBrandList(EntityListRef<GearBrand> entityListRef) throws UaException {
        return this.gearBrandManager.fetchGearBrandList(entityListRef);
    }

    @Override // com.ua.sdk.gear.GearManager
    public Request fetchGearBrandList(EntityListRef<GearBrand> entityListRef, FetchCallback<EntityList<GearBrand>> fetchCallback) {
        return this.gearBrandManager.fetchGearBrand(entityListRef, fetchCallback);
    }

    @Override // com.ua.sdk.gear.GearManager
    public UserGear createEmptyUserGearObject() {
        return this.userGearManager.createEmptyUserGearObject();
    }

    @Override // com.ua.sdk.gear.GearManager
    public EntityList<UserGear> fetchUserGear(EntityListRef<UserGear> entityListRef) throws UaException {
        return this.userGearManager.fetchUserGear(entityListRef);
    }

    @Override // com.ua.sdk.gear.GearManager
    public Request fetchUserGear(EntityListRef<UserGear> entityListRef, FetchCallback<EntityList<UserGear>> fetchCallback) {
        return this.userGearManager.fetchUserGear(entityListRef, fetchCallback);
    }

    @Override // com.ua.sdk.gear.GearManager
    public UserGear updateUserGear(EntityRef<UserGear> entityRef, UserGear userGear) throws UaException {
        return this.userGearManager.updateUserGear(entityRef, userGear);
    }

    @Override // com.ua.sdk.gear.GearManager
    public Request updateUserGear(EntityRef<UserGear> entityRef, UserGear userGear, CreateCallback<UserGear> createCallback) {
        return this.userGearManager.updateUserGear(entityRef, userGear, createCallback);
    }

    @Override // com.ua.sdk.gear.GearManager
    public UserGear createUserGear(UserGear userGear) throws UaException {
        return this.userGearManager.createUserGear(userGear);
    }

    @Override // com.ua.sdk.gear.GearManager
    public Request createUserGear(UserGear userGear, CreateCallback<UserGear> createCallback) {
        return this.userGearManager.createUserGear(userGear, createCallback);
    }

    @Override // com.ua.sdk.gear.GearManager
    public void deleteUserGear(EntityRef<UserGear> entityRef) throws Exception {
        this.userGearManager.deleteUserGear(entityRef);
    }

    @Override // com.ua.sdk.gear.GearManager
    public Request deleteUserGear(EntityRef<UserGear> entityRef, DeleteCallback deleteCallback) {
        return this.userGearManager.deleteUserGear(entityRef, deleteCallback);
    }
}
