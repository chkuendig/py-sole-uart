package com.ua.sdk.bodymass;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.ua.sdk.UaException;
import com.ua.sdk.internal.AbstractGsonWriter;
import com.ua.sdk.net.json.GsonFactory;
import java.io.OutputStreamWriter;

/* loaded from: classes2.dex */
public class BodyMassJsonWriter extends AbstractGsonWriter<BodyMass> {
    public BodyMassJsonWriter() {
        super(GsonFactory.newBodyMassInstance());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ua.sdk.internal.AbstractGsonWriter
    public void write(BodyMass bodyMass, Gson gson, OutputStreamWriter outputStreamWriter) throws JsonIOException, UaException {
        gson.toJson(bodyMass, outputStreamWriter);
    }
}
