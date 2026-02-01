package com.ua.sdk.activitytimeseries;

import com.ua.sdk.CreateCallback;
import com.ua.sdk.Request;
import com.ua.sdk.UaException;

/* loaded from: classes2.dex */
public interface ActivityTimeSeriesManager {
    Request createTimeSeries(ActivityTimeSeries activityTimeSeries, CreateCallback<ActivityTimeSeries> createCallback);

    ActivityTimeSeries createTimeSeries(ActivityTimeSeries activityTimeSeries) throws UaException;

    ActivityTimeSeriesBuilder getActivityTimeSeriesBuilder();
}
