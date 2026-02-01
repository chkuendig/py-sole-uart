package org.scribe.model;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import org.scribe.exceptions.OAuthException;
import org.scribe.utils.StreamUtils;

/* loaded from: classes2.dex */
public class Response {
    private static final String EMPTY = "";
    private String body;
    private int code;
    private Map<String, String> headers;
    private String message;
    private InputStream stream;

    Response(HttpURLConnection httpURLConnection) throws IOException {
        try {
            httpURLConnection.connect();
            this.code = httpURLConnection.getResponseCode();
            this.message = httpURLConnection.getResponseMessage();
            this.headers = parseHeaders(httpURLConnection);
            this.stream = isSuccessful() ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream();
        } catch (UnknownHostException e) {
            throw new OAuthException("The IP address of a host could not be determined.", e);
        }
    }

    private String parseBodyContents() throws IOException {
        String streamContents = StreamUtils.getStreamContents(getStream());
        this.body = streamContents;
        return streamContents;
    }

    private Map<String, String> parseHeaders(HttpURLConnection httpURLConnection) {
        HashMap map = new HashMap();
        for (String str : httpURLConnection.getHeaderFields().keySet()) {
            map.put(str, httpURLConnection.getHeaderFields().get(str).get(0));
        }
        return map;
    }

    public boolean isSuccessful() {
        return getCode() >= 200 && getCode() < 400;
    }

    public String getBody() {
        String str = this.body;
        return str != null ? str : parseBodyContents();
    }

    public InputStream getStream() {
        return this.stream;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public String getHeader(String str) {
        return this.headers.get(str);
    }
}
