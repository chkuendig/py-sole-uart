package com.ua.sdk.moderation;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.AppEventsConstants;
import com.ua.sdk.CreateCallback;
import com.ua.sdk.EntityRef;
import com.ua.sdk.Request;
import com.ua.sdk.UaException;
import com.ua.sdk.cache.Cache;
import com.ua.sdk.cache.CacheSettings;
import com.ua.sdk.cache.DiskCache;
import com.ua.sdk.internal.AbstractManager;
import com.ua.sdk.internal.EntityService;
import com.ua.sdk.internal.net.v7.UrlBuilderImpl;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public class ModerationActionManager extends AbstractManager<ModerationAction> {
    public ModerationActionManager(CacheSettings cacheSettings, Cache cache, DiskCache<ModerationAction> diskCache, EntityService<ModerationAction> entityService, ExecutorService executorService) {
        super(cacheSettings, cache, diskCache, entityService, executorService);
    }

    public ModerationAction flagEntity(EntityRef entityRef) throws UaException {
        ModerationActionImpl moderationActionImpl = new ModerationActionImpl();
        moderationActionImpl.setAction(String.format(UrlBuilderImpl.GET_MODERATION_ACTION_TYPE, AppEventsConstants.EVENT_PARAM_VALUE_YES));
        moderationActionImpl.setResource(entityRef.getHref());
        return create(moderationActionImpl);
    }

    public Request flagEntity(EntityRef entityRef, CreateCallback<ModerationAction> createCallback) {
        ModerationActionImpl moderationActionImpl = new ModerationActionImpl();
        moderationActionImpl.setAction(String.format(UrlBuilderImpl.GET_MODERATION_ACTION_TYPE, AppEventsConstants.EVENT_PARAM_VALUE_YES));
        moderationActionImpl.setResource(entityRef.getHref());
        return create(moderationActionImpl, createCallback);
    }

    public ModerationAction unflagEntity(EntityRef entityRef) throws UaException {
        ModerationActionImpl moderationActionImpl = new ModerationActionImpl();
        moderationActionImpl.setAction(String.format(UrlBuilderImpl.GET_MODERATION_ACTION_TYPE, ExifInterface.GPS_MEASUREMENT_2D));
        moderationActionImpl.setResource(entityRef.getHref());
        return create(moderationActionImpl);
    }

    public Request unflagEntity(EntityRef entityRef, CreateCallback<ModerationAction> createCallback) {
        ModerationActionImpl moderationActionImpl = new ModerationActionImpl();
        moderationActionImpl.setAction(String.format(UrlBuilderImpl.GET_MODERATION_ACTION_TYPE, ExifInterface.GPS_MEASUREMENT_2D));
        moderationActionImpl.setResource(entityRef.getHref());
        return create(moderationActionImpl, createCallback);
    }
}
