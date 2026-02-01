package com.soletreadmills.sole_v2._network.Interceptor;

import android.util.Log;
import com.soletreadmills.sole_v2._data.api.ErrorCode;
import com.soletreadmills.sole_v2._sharedPreferences.MySharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;
import timber.log.Timber;

/* compiled from: TokenAutoRefreshInterceptor.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/soletreadmills/sole_v2/_network/Interceptor/TokenAutoRefreshInterceptor;", "Lokhttp3/Interceptor;", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TokenAutoRefreshInterceptor implements Interceptor {
    public static final int $stable = 0;

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws Exception {
        boolean zBooleanValue;
        String strOptString;
        Intrinsics.checkNotNullParameter(chain, "chain");
        Log.d("TokenInterceptor", "Init");
        String sharedLoginToken = MySharedPreferences.INSTANCE.getInstance().getSharedLoginToken();
        Request request = chain.request();
        if (StringsKt.contains((CharSequence) request.url().encodedPath(), (CharSequence) "/api/LoginByToken", true)) {
            Timber.INSTANCE.d("TokenAutoRefresh: refresh endpoint", new Object[0]);
            return chain.proceed(request);
        }
        boolean zAreEqual = Intrinsics.areEqual(request.tag(), (Object) true);
        try {
            Response responseProceed = chain.proceed(request);
            ResponseBody responseBodyBody = responseProceed.body();
            if (responseBodyBody == null) {
                return responseProceed;
            }
            MediaType mediaType = responseBodyBody.get$contentType();
            try {
                String strString = responseBodyBody.string();
                try {
                    strOptString = new JSONObject(strString).optString("errorCode", "");
                    Timber.INSTANCE.d("errorCode: " + strOptString, new Object[0]);
                } catch (Exception e) {
                    Timber.INSTANCE.e(e, "解析失敗: " + e.getMessage(), new Object[0]);
                }
                boolean z = Intrinsics.areEqual(strOptString, ErrorCode.LOGIN_REQUIRED_113.getId()) && !zAreEqual;
                Timber.INSTANCE.d("shouldRetry:" + z, new Object[0]);
                Response responseBuild = responseProceed.newBuilder().body(ResponseBody.INSTANCE.create(strString, mediaType)).build();
                if (!z) {
                    return responseBuild;
                }
                Timber.INSTANCE.e("Login required (113), retrying...", new Object[0]);
                responseProceed.close();
                try {
                    zBooleanValue = ((Boolean) BuildersKt__BuildersKt.runBlocking$default(null, new TokenAutoRefreshInterceptor$intercept$refreshSuccess$1(sharedLoginToken, null), 1, null)).booleanValue();
                } catch (Exception e2) {
                    Timber.INSTANCE.e(e2, "❌ Token refresh exception", new Object[0]);
                    zBooleanValue = false;
                }
                if (!zBooleanValue) {
                    Timber.INSTANCE.e("❌ Token refresh failed, return original response", new Object[0]);
                    return responseBuild;
                }
                try {
                    return chain.proceed(request.newBuilder().tag(true).build());
                } catch (Exception e3) {
                    Timber.INSTANCE.e(e3, "Retry request failed", new Object[0]);
                    responseBuild.close();
                    throw e3;
                }
            } catch (Exception e4) {
                Timber.INSTANCE.e(e4, "Failed to read response body", new Object[0]);
                responseProceed.close();
                throw e4;
            }
        } catch (Exception e5) {
            Timber.INSTANCE.e(e5, "Network error: " + e5.getMessage(), new Object[0]);
            throw e5;
        }
    }
}
