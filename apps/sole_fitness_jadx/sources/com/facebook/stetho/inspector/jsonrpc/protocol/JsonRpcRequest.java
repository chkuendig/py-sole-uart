package com.facebook.stetho.inspector.jsonrpc.protocol;

import com.digifly.dbapi.DbManager;
import com.facebook.stetho.json.annotation.JsonProperty;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class JsonRpcRequest {

    @JsonProperty
    public Long id;

    @JsonProperty(required = DbManager.ENCRYPTED)
    public String method;

    @JsonProperty
    public JSONObject params;

    public JsonRpcRequest() {
    }

    public JsonRpcRequest(Long l, String str, JSONObject jSONObject) {
        this.id = l;
        this.method = str;
        this.params = jSONObject;
    }
}
