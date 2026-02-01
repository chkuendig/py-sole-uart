package com.ua.sdk.activitytimeseries;

import com.ua.sdk.CreateCallback;
import com.ua.sdk.Request;
import com.ua.sdk.UaException;
import com.ua.sdk.cache.Cache;
import com.ua.sdk.cache.CacheSettings;
import com.ua.sdk.cache.DiskCache;
import com.ua.sdk.internal.AbstractManager;
import com.ua.sdk.internal.EntityService;
import com.ua.sdk.internal.Precondition;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public class ActivityTimeSeriesManagerImpl extends AbstractManager<ActivityTimeSeries> implements ActivityTimeSeriesManager {
    public ActivityTimeSeriesManagerImpl(CacheSettings cacheSettings, Cache cache, DiskCache<ActivityTimeSeries> diskCache, EntityService<ActivityTimeSeries> entityService, ExecutorService executorService) {
        super(cacheSettings, cache, diskCache, entityService, executorService);
    }

    @Override // com.ua.sdk.activitytimeseries.ActivityTimeSeriesManager
    public ActivityTimeSeriesBuilder getActivityTimeSeriesBuilder() {
        return new ActivityTimeSeriesBuilderImpl();
    }

    @Override // com.ua.sdk.activitytimeseries.ActivityTimeSeriesManager
    public ActivityTimeSeries createTimeSeries(ActivityTimeSeries activityTimeSeries) throws UaException, NullPointerException {
        checkNull(activityTimeSeries);
        return create(activityTimeSeries);
    }

    @Override // com.ua.sdk.activitytimeseries.ActivityTimeSeriesManager
    public Request createTimeSeries(ActivityTimeSeries activityTimeSeries, CreateCallback<ActivityTimeSeries> createCallback) throws NullPointerException {
        checkNull(activityTimeSeries);
        return create(activityTimeSeries, createCallback);
    }

    private void checkNull(ActivityTimeSeries activityTimeSeries) throws NullPointerException {
        Precondition.isNotNull(activityTimeSeries.getRecorderTypeKey());
        Precondition.isNotNull(activityTimeSeries.getRecorderIdentifier());
    }
}
