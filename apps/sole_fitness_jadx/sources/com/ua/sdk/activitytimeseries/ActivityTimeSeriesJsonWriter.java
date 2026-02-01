package com.ua.sdk.activitytimeseries;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.ua.sdk.UaException;
import com.ua.sdk.internal.AbstractGsonWriter;
import com.ua.sdk.net.json.GsonFactory;
import java.io.OutputStreamWriter;

/* loaded from: classes2.dex */
public class ActivityTimeSeriesJsonWriter extends AbstractGsonWriter<ActivityTimeSeries> {
    public ActivityTimeSeriesJsonWriter() {
        super(GsonFactory.newActivityTimeSeriesInstance());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ua.sdk.internal.AbstractGsonWriter
    public void write(ActivityTimeSeries activityTimeSeries, Gson gson, OutputStreamWriter outputStreamWriter) throws JsonIOException, UaException {
        gson.toJson(activityTimeSeries, activityTimeSeries.getClass(), outputStreamWriter);
    }
}
