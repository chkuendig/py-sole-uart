package com.ua.sdk.internal;

import android.content.Context;
import com.ua.sdk.UaException;
import com.ua.sdk.UaLog;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: classes2.dex */
public class ConnectionFactory {
    private final String clientId;
    private final Context context;

    public ConnectionFactory(Context context, String str) {
        this.context = (Context) Precondition.isNotNull(context, "context");
        this.clientId = (String) Precondition.isNotNull(str, "clientId");
    }

    public HttpsURLConnection getSslConnection(URL url) throws IOException, UaException {
        Precondition.isConnected(this.context);
        UaLog.debug("connect=%s", url.toString());
        return (HttpsURLConnection) addProperties((HttpsURLConnection) url.openConnection());
    }

    public HttpURLConnection getConnection(URL url) throws IOException, UaException {
        Precondition.isConnected(this.context);
        UaLog.debug("connect=%s", url.toString());
        return (HttpURLConnection) addProperties((HttpURLConnection) url.openConnection());
    }

    public <T extends URLConnection> T addProperties(T t) {
        t.setRequestProperty("Api-Key", this.clientId);
        return t;
    }
}
