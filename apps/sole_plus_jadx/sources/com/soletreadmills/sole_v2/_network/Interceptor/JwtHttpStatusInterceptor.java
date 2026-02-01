package com.soletreadmills.sole_v2._network.Interceptor;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import timber.log.Timber;

/* compiled from: JwtHttpStatusInterceptor.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/soletreadmills/sole_v2/_network/Interceptor/JwtHttpStatusInterceptor;", "Lokhttp3/Interceptor;", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class JwtHttpStatusInterceptor implements Interceptor {
    public static final int $stable = 0;

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        String str = "";
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        String strEncodedPath = request.url().encodedPath();
        String strMethod = request.method();
        Timber.INSTANCE.tag("JWT_HTTP").d("→ " + strMethod + ' ' + strEncodedPath, new Object[0]);
        try {
            Response responseProceed = chain.proceed(request);
            Timber.INSTANCE.tag("JWT_HTTP").d("← HTTP " + responseProceed.code() + ' ' + strMethod + ' ' + strEncodedPath, new Object[0]);
            if (responseProceed.code() == 401) {
                Timber.INSTANCE.tag("JWT_HTTP").d("HTTP " + responseProceed.code() + ": Silently passing to auto re-login interceptor", new Object[0]);
                return responseProceed;
            }
            if (!responseProceed.isSuccessful()) {
                int iCode = responseProceed.code();
                String strMessage = responseProceed.message();
                try {
                    ResponseBody responseBodyBody = responseProceed.body();
                    if (responseBodyBody != null) {
                        String strString = responseBodyBody.string();
                        if (strString != null) {
                            str = strString;
                        }
                    }
                } catch (IOException e) {
                    Timber.INSTANCE.tag("JWT_HTTP").e(e, "Failed to read error body", new Object[0]);
                }
                responseProceed.close();
                Timber.INSTANCE.tag("JWT_HTTP").e("HTTP_error: " + iCode + ' ' + strMessage + " (" + strMethod + ' ' + strEncodedPath + "), body: " + str, new Object[0]);
                throw new IOException("HTTP " + iCode + ": " + strMessage);
            }
            ResponseBody responseBodyBody2 = responseProceed.body();
            if (responseBodyBody2 != null) {
                MediaType mediaType = responseBodyBody2.get$contentType();
                try {
                    String strString2 = responseBodyBody2.string();
                    Timber.INSTANCE.tag("JWT_HTTP").d("Rebuild body for " + strMethod + ' ' + strEncodedPath + " (len=" + strString2.length() + ')', new Object[0]);
                    return responseProceed.newBuilder().body(ResponseBody.INSTANCE.create(strString2, mediaType)).build();
                } catch (IOException e2) {
                    Timber.INSTANCE.tag("JWT_HTTP").e(e2, "Failed to read response body: " + strMethod + ' ' + strEncodedPath, new Object[0]);
                    responseProceed.close();
                    throw e2;
                }
            }
            Timber.INSTANCE.tag("JWT_HTTP").w("No body for " + strMethod + ' ' + strEncodedPath + ", return response as is", new Object[0]);
            return responseProceed;
        } catch (SocketTimeoutException e3) {
            SocketTimeoutException socketTimeoutException = e3;
            Timber.INSTANCE.tag("JWT_HTTP").e(socketTimeoutException, "連線逾時: " + strMethod + ' ' + strEncodedPath, new Object[0]);
            throw new IOException("連線逾時，請稍後再試", socketTimeoutException);
        } catch (UnknownHostException e4) {
            UnknownHostException unknownHostException = e4;
            Timber.INSTANCE.tag("JWT_HTTP").e(unknownHostException, "無網路連線: " + strMethod + ' ' + strEncodedPath, new Object[0]);
            throw new IOException("無網路連線，請檢查網路設定", unknownHostException);
        } catch (IOException e5) {
            Timber.INSTANCE.tag("JWT_HTTP").e(e5, "Network error: " + strMethod + ' ' + strEncodedPath, new Object[0]);
            throw e5;
        }
    }
}
