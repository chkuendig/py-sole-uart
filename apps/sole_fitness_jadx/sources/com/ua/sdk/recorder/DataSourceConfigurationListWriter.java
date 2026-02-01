package com.ua.sdk.recorder;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.ua.sdk.UaException;
import com.ua.sdk.internal.AbstractGsonWriter;
import com.ua.sdk.net.json.GsonFactory;
import java.io.OutputStreamWriter;

/* loaded from: classes2.dex */
public class DataSourceConfigurationListWriter extends AbstractGsonWriter {
    public DataSourceConfigurationListWriter() {
        super(GsonFactory.newRecorderConfigurationInstance());
    }

    @Override // com.ua.sdk.internal.AbstractGsonWriter
    protected void write(Object obj, Gson gson, OutputStreamWriter outputStreamWriter) throws JsonIOException, UaException {
        gson.toJson(obj, outputStreamWriter);
    }
}
