package com.facebook.stetho.inspector.protocol.module;

import android.content.Context;
import com.digifly.dbapi.DbManager;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcException;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcResult;
import com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcError;
import com.facebook.stetho.inspector.network.AsyncPrettyPrinterInitializer;
import com.facebook.stetho.inspector.network.NetworkPeerManager;
import com.facebook.stetho.inspector.network.ResponseBodyData;
import com.facebook.stetho.inspector.network.ResponseBodyFileManager;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsMethod;
import com.facebook.stetho.inspector.protocol.module.Console;
import com.facebook.stetho.inspector.protocol.module.Page;
import com.facebook.stetho.json.annotation.JsonProperty;
import com.facebook.stetho.json.annotation.JsonValue;
import java.io.IOException;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class Network implements ChromeDevtoolsDomain {
    private final NetworkPeerManager mNetworkPeerManager;
    private final ResponseBodyFileManager mResponseBodyFileManager;

    public static class DataReceivedParams {

        @JsonProperty(required = DbManager.ENCRYPTED)
        public int dataLength;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public int encodedDataLength;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public String requestId;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public double timestamp;
    }

    public static class Initiator {

        @JsonProperty
        public List<Console.CallFrame> stackTrace;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public InitiatorType type;
    }

    public static class LoadingFailedParams {

        @JsonProperty(required = DbManager.ENCRYPTED)
        public String errorText;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public String requestId;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public double timestamp;

        @JsonProperty
        public Page.ResourceType type;
    }

    public static class LoadingFinishedParams {

        @JsonProperty(required = DbManager.ENCRYPTED)
        public String requestId;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public double timestamp;
    }

    public static class Request {

        @JsonProperty(required = DbManager.ENCRYPTED)
        public JSONObject headers;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public String method;

        @JsonProperty
        public String postData;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public String url;
    }

    public static class RequestWillBeSentParams {

        @JsonProperty(required = DbManager.ENCRYPTED)
        public String documentURL;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public String frameId;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public Initiator initiator;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public String loaderId;

        @JsonProperty
        public Response redirectResponse;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public Request request;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public String requestId;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public double timestamp;

        @JsonProperty
        public Page.ResourceType type;
    }

    public static class ResourceTiming {

        @JsonProperty(required = DbManager.ENCRYPTED)
        public double connectionEnd;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public double connectionStart;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public double dnsEnd;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public double dnsStart;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public double proxyEnd;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public double proxyStart;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public double receivedHeadersEnd;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public double requestTime;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public double sendEnd;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public double sendStart;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public double sslEnd;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public double sslStart;
    }

    public static class Response {

        @JsonProperty(required = DbManager.ENCRYPTED)
        public int connectionId;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public boolean connectionReused;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public Boolean fromDiskCache;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public JSONObject headers;

        @JsonProperty
        public String headersText;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public String mimeType;

        @JsonProperty
        public JSONObject requestHeaders;

        @JsonProperty
        public String requestHeadersTest;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public int status;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public String statusText;

        @JsonProperty
        public ResourceTiming timing;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public String url;
    }

    public static class ResponseReceivedParams {

        @JsonProperty(required = DbManager.ENCRYPTED)
        public String frameId;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public String loaderId;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public String requestId;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public Response response;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public double timestamp;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public Page.ResourceType type;
    }

    public static class WebSocketClosedParams {

        @JsonProperty(required = DbManager.ENCRYPTED)
        public String requestId;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public double timestamp;
    }

    public static class WebSocketCreatedParams {

        @JsonProperty(required = DbManager.ENCRYPTED)
        public String requestId;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public String url;
    }

    public static class WebSocketFrame {

        @JsonProperty(required = DbManager.ENCRYPTED)
        public boolean mask;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public int opcode;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public String payloadData;
    }

    public static class WebSocketFrameErrorParams {

        @JsonProperty(required = DbManager.ENCRYPTED)
        public String errorMessage;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public String requestId;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public double timestamp;
    }

    public static class WebSocketFrameReceivedParams {

        @JsonProperty(required = DbManager.ENCRYPTED)
        public String requestId;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public WebSocketFrame response;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public double timestamp;
    }

    public static class WebSocketFrameSentParams {

        @JsonProperty(required = DbManager.ENCRYPTED)
        public String requestId;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public WebSocketFrame response;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public double timestamp;
    }

    public static class WebSocketHandshakeResponseReceivedParams {

        @JsonProperty(required = DbManager.ENCRYPTED)
        public String requestId;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public WebSocketResponse response;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public double timestamp;
    }

    public static class WebSocketRequest {

        @JsonProperty(required = DbManager.ENCRYPTED)
        public JSONObject headers;
    }

    public static class WebSocketResponse {

        @JsonProperty(required = DbManager.ENCRYPTED)
        public JSONObject headers;

        @JsonProperty
        public String headersText;

        @JsonProperty
        public JSONObject requestHeaders;

        @JsonProperty
        public String requestHeadersText;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public int status;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public String statusText;
    }

    public static class WebSocketWillSendHandshakeRequestParams {

        @JsonProperty(required = DbManager.ENCRYPTED)
        public WebSocketRequest request;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public String requestId;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public double timestamp;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public double wallTime;
    }

    @ChromeDevtoolsMethod
    public void setUserAgentOverride(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
    }

    public Network(Context context) {
        NetworkPeerManager orCreateInstance = NetworkPeerManager.getOrCreateInstance(context);
        this.mNetworkPeerManager = orCreateInstance;
        this.mResponseBodyFileManager = orCreateInstance.getResponseBodyFileManager();
    }

    @ChromeDevtoolsMethod
    public void enable(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        this.mNetworkPeerManager.addPeer(jsonRpcPeer);
    }

    @ChromeDevtoolsMethod
    public void disable(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        this.mNetworkPeerManager.removePeer(jsonRpcPeer);
    }

    @ChromeDevtoolsMethod
    public JsonRpcResult getResponseBody(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) throws JsonRpcException {
        try {
            return readResponseBody(jSONObject.getString("requestId"));
        } catch (IOException e) {
            throw new JsonRpcException(new JsonRpcError(JsonRpcError.ErrorCode.INTERNAL_ERROR, e.toString(), null));
        } catch (JSONException e2) {
            throw new JsonRpcException(new JsonRpcError(JsonRpcError.ErrorCode.INTERNAL_ERROR, e2.toString(), null));
        }
    }

    private GetResponseBodyResponse readResponseBody(String str) throws JsonRpcException, IOException {
        GetResponseBodyResponse getResponseBodyResponse = new GetResponseBodyResponse();
        try {
            ResponseBodyData file = this.mResponseBodyFileManager.readFile(str);
            getResponseBodyResponse.body = file.data;
            getResponseBodyResponse.base64Encoded = file.base64Encoded;
            return getResponseBodyResponse;
        } catch (OutOfMemoryError e) {
            throw new JsonRpcException(new JsonRpcError(JsonRpcError.ErrorCode.INTERNAL_ERROR, e.toString(), null));
        }
    }

    public void setPrettyPrinterInitializer(AsyncPrettyPrinterInitializer asyncPrettyPrinterInitializer) {
        Util.throwIfNull(asyncPrettyPrinterInitializer);
        this.mNetworkPeerManager.setPrettyPrinterInitializer(asyncPrettyPrinterInitializer);
    }

    private static class GetResponseBodyResponse implements JsonRpcResult {

        @JsonProperty(required = DbManager.ENCRYPTED)
        public boolean base64Encoded;

        @JsonProperty(required = DbManager.ENCRYPTED)
        public String body;

        private GetResponseBodyResponse() {
        }
    }

    public enum InitiatorType {
        PARSER("parser"),
        SCRIPT("script"),
        OTHER("other");

        private final String mProtocolValue;

        InitiatorType(String str) {
            this.mProtocolValue = str;
        }

        @JsonValue
        public String getProtocolValue() {
            return this.mProtocolValue;
        }
    }
}
