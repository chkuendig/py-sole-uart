package com.ua.sdk.sleep;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.ua.sdk.UaException;
import com.ua.sdk.internal.AbstractGsonWriter;
import com.ua.sdk.net.json.GsonFactory;
import java.io.OutputStreamWriter;

/* loaded from: classes2.dex */
public class SleepMetricJsonWriter extends AbstractGsonWriter<SleepMetric> {
    public SleepMetricJsonWriter() {
        super(GsonFactory.newSleepInstance());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ua.sdk.internal.AbstractGsonWriter
    public void write(SleepMetric sleepMetric, Gson gson, OutputStreamWriter outputStreamWriter) throws JsonIOException, UaException {
        gson.toJson(sleepMetric, outputStreamWriter);
    }
}
