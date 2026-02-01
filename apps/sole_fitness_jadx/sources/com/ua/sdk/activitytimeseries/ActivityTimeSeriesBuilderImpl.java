package com.ua.sdk.activitytimeseries;

import com.ua.sdk.util.DoubleList;
import com.ua.sdk.util.IntList;
import com.ua.sdk.util.LongList;
import java.util.UUID;

/* loaded from: classes2.dex */
public class ActivityTimeSeriesBuilderImpl implements ActivityTimeSeriesBuilder {
    public static final int MAX_EVENT_COUNT = 10800;
    public static final int MAX_INTERVAL_SECONDS = 604800;
    String recorderTypeKey = null;
    String recorderIdentifier = null;
    LongList stepEpochs = null;
    IntList stepValues = null;
    LongList calorieEpochs = null;
    DoubleList calorieValues = null;
    LongList distanceEpochs = null;
    DoubleList distanceValues = null;

    @Override // com.ua.sdk.activitytimeseries.ActivityTimeSeriesBuilder
    public ActivityTimeSeriesBuilderImpl setRecorderTypeKey(String str) {
        this.recorderTypeKey = str;
        return this;
    }

    @Override // com.ua.sdk.activitytimeseries.ActivityTimeSeriesBuilder
    public ActivityTimeSeriesBuilderImpl setRecorderIdentifier(String str) {
        this.recorderIdentifier = str;
        return this;
    }

    @Override // com.ua.sdk.activitytimeseries.ActivityTimeSeriesBuilder
    public ActivityTimeSeriesBuilderImpl addSteps(long j, int i) {
        if (this.stepEpochs == null) {
            this.stepEpochs = new LongList();
            this.stepValues = new IntList();
        }
        this.stepEpochs.add(j);
        this.stepValues.add(i);
        return this;
    }

    @Override // com.ua.sdk.activitytimeseries.ActivityTimeSeriesBuilder
    public ActivityTimeSeriesBuilderImpl addCalories(long j, double d) {
        if (this.calorieEpochs == null) {
            this.calorieEpochs = new LongList();
            this.calorieValues = new DoubleList();
        }
        this.calorieEpochs.add(j);
        this.calorieValues.add(d);
        return this;
    }

    @Override // com.ua.sdk.activitytimeseries.ActivityTimeSeriesBuilder
    public ActivityTimeSeriesBuilderImpl addDistance(long j, double d) {
        if (this.distanceEpochs == null) {
            this.distanceEpochs = new LongList();
            this.distanceValues = new DoubleList();
        }
        this.distanceEpochs.add(j);
        this.distanceValues.add(d);
        return this;
    }

    @Override // com.ua.sdk.activitytimeseries.ActivityTimeSeriesBuilder
    public ActivityTimeSeriesImpl build() {
        if (this.recorderTypeKey == null) {
            throw new IllegalArgumentException("recorderTypeKey must be set.");
        }
        if (this.recorderIdentifier == null) {
            this.recorderIdentifier = UUID.randomUUID().toString();
        }
        return new ActivityTimeSeriesImpl(this);
    }
}
