package com.mapbox.mapboxsdk.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.mapbox.mapboxsdk.constants.MapboxConstants;
import com.squareup.okhttp.HttpResponseCache;
import com.squareup.okhttp.OkHttpClient;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ResponseCache;
import java.net.URL;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes2.dex */
public class NetworkUtils {
    public static boolean isNetworkAvailable(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static HttpURLConnection getHttpURLConnection(URL url) {
        return getHttpURLConnection(url, null, null);
    }

    public static HttpURLConnection getHttpURLConnection(URL url, ResponseCache responseCache) {
        return getHttpURLConnection(url, responseCache, null);
    }

    public static HttpURLConnection getHttpURLConnection(URL url, ResponseCache responseCache, SSLSocketFactory sSLSocketFactory) {
        OkHttpClient okHttpClient = new OkHttpClient();
        if (responseCache != null) {
            okHttpClient.setResponseCache(responseCache);
        }
        if (sSLSocketFactory != null) {
            okHttpClient.setSslSocketFactory(sSLSocketFactory);
        }
        HttpURLConnection httpURLConnectionOpen = okHttpClient.open(url);
        httpURLConnectionOpen.setRequestProperty("User-Agent", MapboxConstants.USER_AGENT);
        return httpURLConnectionOpen;
    }

    public static ResponseCache getResponseCache(File file, int i) throws IOException {
        return new HttpResponseCache(file, i);
    }
}
