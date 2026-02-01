package com.facebook.stetho.inspector.jsonrpc.protocol;

import com.digifly.dbapi.DbManager;
import com.facebook.stetho.json.annotation.JsonProperty;
import javax.annotation.Nullable;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class JsonRpcEvent {

    @JsonProperty(required = DbManager.ENCRYPTED)
    public String method;

    @JsonProperty
    public JSONObject params;

    public JsonRpcEvent() {
    }

    public JsonRpcEvent(String str, @Nullable JSONObject jSONObject) {
        this.method = str;
        this.params = jSONObject;
    }
}
