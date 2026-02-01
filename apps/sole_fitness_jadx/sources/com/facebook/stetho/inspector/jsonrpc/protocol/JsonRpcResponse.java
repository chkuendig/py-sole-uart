package com.facebook.stetho.inspector.jsonrpc.protocol;

import com.digifly.dbapi.DbManager;
import com.facebook.stetho.json.annotation.JsonProperty;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class JsonRpcResponse {

    @JsonProperty
    public JSONObject error;

    @JsonProperty(required = DbManager.ENCRYPTED)
    public long id;

    @JsonProperty
    public JSONObject result;
}
