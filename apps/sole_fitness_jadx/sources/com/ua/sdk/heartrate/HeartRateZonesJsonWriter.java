package com.ua.sdk.heartrate;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.ua.sdk.UaException;
import com.ua.sdk.internal.AbstractGsonWriter;
import com.ua.sdk.net.json.GsonFactory;
import java.io.OutputStreamWriter;

/* loaded from: classes2.dex */
public class HeartRateZonesJsonWriter extends AbstractGsonWriter<HeartRateZones> {
    public HeartRateZonesJsonWriter() {
        super(GsonFactory.newHeartRateInstance());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ua.sdk.internal.AbstractGsonWriter
    public void write(HeartRateZones heartRateZones, Gson gson, OutputStreamWriter outputStreamWriter) throws JsonIOException, UaException {
        gson.toJson(heartRateZones, outputStreamWriter);
    }
}
