package com.ua.sdk.group.objective;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.ua.sdk.UaException;
import com.ua.sdk.internal.AbstractGsonWriter;
import com.ua.sdk.net.json.GsonFactory;
import java.io.OutputStreamWriter;

/* loaded from: classes2.dex */
public class GroupObjectiveJsonWriter extends AbstractGsonWriter<GroupObjective> {
    public GroupObjectiveJsonWriter() {
        super(GsonFactory.newGroupInstance());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ua.sdk.internal.AbstractGsonWriter
    public void write(GroupObjective groupObjective, Gson gson, OutputStreamWriter outputStreamWriter) throws JsonIOException, UaException {
        gson.toJson(groupObjective, outputStreamWriter);
    }
}
