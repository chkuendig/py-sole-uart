package com.ua.sdk;

import com.ua.sdk.UaException;
import com.ua.sdk.util.Streams;
import java.net.HttpURLConnection;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes2.dex */
public class NetworkError extends UaException {
    String message;
    final int responseCode;

    public NetworkError(int i, HttpURLConnection httpURLConnection) {
        super(getErrorCode(i));
        this.message = "";
        this.responseCode = i;
        try {
            this.message = Streams.readFully(httpURLConnection.getErrorStream());
        } catch (Throwable unused) {
            this.message = "";
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NetworkError(int i) {
        this(i, (Throwable) null);
    }

    public NetworkError(int i, Throwable th) {
        super(getErrorCode(i), th);
        this.message = "";
        this.responseCode = i;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "Response Code " + this.responseCode + StringUtils.SPACE + this.message;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    public String getHttpResponse() {
        return this.message;
    }

    public static final UaException.Code getErrorCode(int i) {
        return UaException.Code.NETWORK;
    }
}
