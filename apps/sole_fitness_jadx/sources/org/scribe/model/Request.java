package org.scribe.model;

import com.facebook.internal.ServerProtocol;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.scribe.exceptions.OAuthConnectionException;
import org.scribe.exceptions.OAuthException;

/* loaded from: classes2.dex */
public class Request {
    private static final String CONTENT_LENGTH = "Content-Length";
    private static final String CONTENT_TYPE = "Content-Type";
    public static final String DEFAULT_CONTENT_TYPE = "application/x-www-form-urlencoded";
    private static RequestTuner NOOP = new RequestTuner() { // from class: org.scribe.model.Request.1
        @Override // org.scribe.model.RequestTuner
        public void tune(Request request) {
        }
    };
    private String charset;
    private HttpURLConnection connection;
    private String url;
    private Verb verb;
    private String payload = null;
    private byte[] bytePayload = null;
    private boolean connectionKeepAlive = false;
    private boolean followRedirects = true;
    private Long connectTimeout = null;
    private Long readTimeout = null;
    private ParameterList querystringParams = new ParameterList();
    private ParameterList bodyParams = new ParameterList();
    private Map<String, String> headers = new HashMap();

    public Request(Verb verb, String str) {
        this.verb = verb;
        this.url = str;
    }

    public Response send(RequestTuner requestTuner) {
        try {
            createConnection();
            return doSend(requestTuner);
        } catch (Exception e) {
            throw new OAuthConnectionException(e);
        }
    }

    public Response send() {
        return send(NOOP);
    }

    private void createConnection() throws IOException {
        String completeUrl = getCompleteUrl();
        if (this.connection == null) {
            System.setProperty("http.keepAlive", this.connectionKeepAlive ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false");
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(completeUrl).openConnection();
            this.connection = httpURLConnection;
            httpURLConnection.setInstanceFollowRedirects(this.followRedirects);
        }
    }

    public String getCompleteUrl() {
        return this.querystringParams.appendTo(this.url);
    }

    Response doSend(RequestTuner requestTuner) throws IOException {
        this.connection.setRequestMethod(this.verb.name());
        Long l = this.connectTimeout;
        if (l != null) {
            this.connection.setConnectTimeout(l.intValue());
        }
        Long l2 = this.readTimeout;
        if (l2 != null) {
            this.connection.setReadTimeout(l2.intValue());
        }
        addHeaders(this.connection);
        if (this.verb.equals(Verb.PUT) || this.verb.equals(Verb.POST)) {
            addBody(this.connection, getByteBodyContents());
        }
        requestTuner.tune(this);
        return new Response(this.connection);
    }

    void addHeaders(HttpURLConnection httpURLConnection) {
        for (String str : this.headers.keySet()) {
            httpURLConnection.setRequestProperty(str, this.headers.get(str));
        }
    }

    void addBody(HttpURLConnection httpURLConnection, byte[] bArr) throws IOException {
        httpURLConnection.setRequestProperty("Content-Length", String.valueOf(bArr.length));
        if (httpURLConnection.getRequestProperty("Content-Type") == null) {
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        }
        httpURLConnection.setDoOutput(true);
        httpURLConnection.getOutputStream().write(bArr);
    }

    public void addHeader(String str, String str2) {
        this.headers.put(str, str2);
    }

    public void addBodyParameter(String str, String str2) {
        this.bodyParams.add(str, str2);
    }

    public void addQuerystringParameter(String str, String str2) {
        this.querystringParams.add(str, str2);
    }

    public void addPayload(String str) {
        this.payload = str;
    }

    public void addPayload(byte[] bArr) {
        this.bytePayload = (byte[]) bArr.clone();
    }

    public ParameterList getQueryStringParams() {
        try {
            ParameterList parameterList = new ParameterList();
            parameterList.addQuerystring(new URL(this.url).getQuery());
            parameterList.addAll(this.querystringParams);
            return parameterList;
        } catch (MalformedURLException e) {
            throw new OAuthException("Malformed URL", e);
        }
    }

    public ParameterList getBodyParams() {
        return this.bodyParams;
    }

    public String getUrl() {
        return this.url;
    }

    public String getSanitizedUrl() {
        return this.url.replaceAll("\\?.*", "").replace("\\:\\d{4}", "");
    }

    public String getBodyContents() {
        try {
            return new String(getByteBodyContents(), getCharset());
        } catch (UnsupportedEncodingException e) {
            throw new OAuthException("Unsupported Charset: " + this.charset, e);
        }
    }

    byte[] getByteBodyContents() {
        byte[] bArr = this.bytePayload;
        if (bArr != null) {
            return bArr;
        }
        String strAsFormUrlEncodedString = this.payload;
        if (strAsFormUrlEncodedString == null) {
            strAsFormUrlEncodedString = this.bodyParams.asFormUrlEncodedString();
        }
        try {
            return strAsFormUrlEncodedString.getBytes(getCharset());
        } catch (UnsupportedEncodingException e) {
            throw new OAuthException("Unsupported Charset: " + getCharset(), e);
        }
    }

    public Verb getVerb() {
        return this.verb;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public String getCharset() {
        String str = this.charset;
        return str == null ? Charset.defaultCharset().name() : str;
    }

    public void setConnectTimeout(int i, TimeUnit timeUnit) {
        this.connectTimeout = Long.valueOf(timeUnit.toMillis(i));
    }

    public void setReadTimeout(int i, TimeUnit timeUnit) {
        this.readTimeout = Long.valueOf(timeUnit.toMillis(i));
    }

    public void setCharset(String str) {
        this.charset = str;
    }

    public void setConnectionKeepAlive(boolean z) {
        this.connectionKeepAlive = z;
    }

    public void setFollowRedirects(boolean z) {
        this.followRedirects = z;
    }

    void setConnection(HttpURLConnection httpURLConnection) {
        this.connection = httpURLConnection;
    }

    public String toString() {
        return String.format("@Request(%s %s)", getVerb(), getUrl());
    }
}
