package com.soletreadmills.sole_v2._network.Interceptor;

import com.soletreadmills.sole_v2.AppConfig;
import com.soletreadmills.sole_v2.AppConfigKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Response;

/* compiled from: HeaderInterceptor.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/soletreadmills/sole_v2/_network/Interceptor/HeaderInterceptor;", "Lokhttp3/Interceptor;", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HeaderInterceptor implements Interceptor {
    public static final int $stable = 0;

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        return chain.proceed(chain.request().newBuilder().header("Content-Type", "application/json").header("app", AppConfig.HEADER_DEVICE_TYPE_TITLE).header("appVersion", "4.11").header("now", AppConfigKt.getTime()).header("nowMillis", AppConfigKt.getTimeStamp()).header("timeZone", AppConfig.INSTANCE.getHEADER_NOW_TIMEZONE()).header("lang", AppConfig.INSTANCE.getHEADER_LOCAL_LANGUAGE()).header("deviceInfo", AppConfig.INSTANCE.getHEADER_DEVICE_NAME()).header("clientDeviceId", AppConfig.INSTANCE.getHEADER_ANDROID_ID()).header("brandCode", "sole").header("countryCode", AppConfig.INSTANCE.getHEADER_COUNTRY_CODE()).header("sessionId", AppConfigKt.getSessionId()).build());
    }
}
