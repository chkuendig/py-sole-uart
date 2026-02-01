package com.facebook.stetho.inspector.protocol.module;

import com.digifly.dbapi.DbManager;
import com.facebook.stetho.inspector.console.ConsolePeerManager;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsMethod;
import com.facebook.stetho.json.annotation.JsonProperty;
import com.facebook.stetho.json.annotation.JsonValue;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class Console implements ChromeDevtoolsDomain {

    public static class ConsoleMessage {

        @JsonProperty(required = DbManager.ENCRYPTED)
        public MessageLevel level;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public MessageSource source;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public String text;
    }

    public static class MessageAddedRequest {

        @JsonProperty(required = DbManager.ENCRYPTED)
        public ConsoleMessage message;
    }

    @ChromeDevtoolsMethod
    public void enable(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        ConsolePeerManager.getOrCreateInstance().addPeer(jsonRpcPeer);
    }

    @ChromeDevtoolsMethod
    public void disable(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        ConsolePeerManager.getOrCreateInstance().removePeer(jsonRpcPeer);
    }

    public enum MessageSource {
        XML("xml"),
        JAVASCRIPT("javascript"),
        NETWORK("network"),
        CONSOLE_API("console-api"),
        STORAGE("storage"),
        APPCACHE("appcache"),
        RENDERING("rendering"),
        CSS("css"),
        SECURITY("security"),
        OTHER("other");

        private final String mProtocolValue;

        MessageSource(String str) {
            this.mProtocolValue = str;
        }

        @JsonValue
        public String getProtocolValue() {
            return this.mProtocolValue;
        }
    }

    public enum MessageLevel {
        LOG("log"),
        WARNING("warning"),
        ERROR("error"),
        DEBUG("debug");

        private final String mProtocolValue;

        MessageLevel(String str) {
            this.mProtocolValue = str;
        }

        @JsonValue
        public String getProtocolValue() {
            return this.mProtocolValue;
        }
    }

    public static class CallFrame {

        @JsonProperty(required = DbManager.ENCRYPTED)
        public int columnNumber;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public String functionName;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public int lineNumber;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public String url;

        public CallFrame() {
        }

        public CallFrame(String str, String str2, int i, int i2) {
            this.functionName = str;
            this.url = str2;
            this.lineNumber = i;
            this.columnNumber = i2;
        }
    }
}
