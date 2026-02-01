package com.ua.sdk.actigraphysettings;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.ua.sdk.UaException;
import com.ua.sdk.internal.AbstractGsonWriter;
import com.ua.sdk.net.json.GsonFactory;
import java.io.OutputStreamWriter;

/* loaded from: classes2.dex */
public class ActigraphySettingsRequestWriter extends AbstractGsonWriter<ActigraphySettings> {
    public ActigraphySettingsRequestWriter() {
        super(GsonFactory.newInstance());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ua.sdk.internal.AbstractGsonWriter
    public void write(ActigraphySettings actigraphySettings, Gson gson, OutputStreamWriter outputStreamWriter) throws JsonIOException, UaException {
        gson.toJson(ActigraphySettingsRequestTO.toTransferObject(actigraphySettings), outputStreamWriter);
    }
}
