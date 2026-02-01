package com.soletreadmills.sole_v2._networkJwtNotification;

import com.localebro.okhttpprofiler.OkHttpProfilerInterceptor;
import com.soletreadmills.sole_v2.AppConfig;
import com.soletreadmills.sole_v2._network.Interceptor.JwtHeaderInterceptor;
import com.soletreadmills.sole_v2._network.Interceptor.JwtHttpStatusInterceptor;
import com.soletreadmills.sole_v2._network.Interceptor.JwtTokenAutoRefreshInterceptor;
import com.soletreadmills.sole_v2._network.JwtNotificationDyacoApiService;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

/* compiled from: JwtNotificationRetrofit.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\f\u001a\u0004\b\u0019\u0010\u0010¨\u0006!"}, d2 = {"Lcom/soletreadmills/sole_v2/_networkJwtNotification/JwtNotificationRetrofit;", "", "()V", "CONNECT_TIMEOUT", "", "READ_TIMEOUT", "WRITE_TIMEOUT", "apiServiceJwtNotification", "Lcom/soletreadmills/sole_v2/_network/JwtNotificationDyacoApiService;", "getApiServiceJwtNotification", "()Lcom/soletreadmills/sole_v2/_network/JwtNotificationDyacoApiService;", "apiServiceJwtNotification$delegate", "Lkotlin/Lazy;", "baseOkHttpClient", "Lokhttp3/OkHttpClient;", "getBaseOkHttpClient", "()Lokhttp3/OkHttpClient;", "baseOkHttpClient$delegate", "dispatcher", "Lokhttp3/Dispatcher;", "getDispatcher", "()Lokhttp3/Dispatcher;", "logging", "Lokhttp3/logging/HttpLoggingInterceptor;", "okHttpClient", "getOkHttpClient", "okHttpClient$delegate", "createRetrofit", "Lretrofit2/Retrofit;", "baseUrl", "", "logApiCallInfo", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class JwtNotificationRetrofit {
    public static final int $stable;
    private static final long CONNECT_TIMEOUT = 10;
    public static final JwtNotificationRetrofit INSTANCE = new JwtNotificationRetrofit();
    private static final long READ_TIMEOUT = 10;
    private static final long WRITE_TIMEOUT = 10;

    /* renamed from: apiServiceJwtNotification$delegate, reason: from kotlin metadata */
    private static final Lazy apiServiceJwtNotification;

    /* renamed from: baseOkHttpClient$delegate, reason: from kotlin metadata */
    private static final Lazy baseOkHttpClient;
    private static final Dispatcher dispatcher;
    private static final HttpLoggingInterceptor logging;

    /* renamed from: okHttpClient$delegate, reason: from kotlin metadata */
    private static final Lazy okHttpClient;

    private final void logApiCallInfo(String baseUrl) {
    }

    private JwtNotificationRetrofit() {
    }

    static {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() { // from class: com.soletreadmills.sole_v2._networkJwtNotification.JwtNotificationRetrofit$$ExternalSyntheticLambda0
            @Override // okhttp3.logging.HttpLoggingInterceptor.Logger
            public final void log(String str) {
                JwtNotificationRetrofit.logging$lambda$0(str);
            }
        });
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
        logging = httpLoggingInterceptor;
        Dispatcher dispatcher2 = new Dispatcher();
        dispatcher2.setMaxRequests(64);
        dispatcher2.setMaxRequestsPerHost(20);
        dispatcher = dispatcher2;
        baseOkHttpClient = LazyKt.lazy(new Function0<OkHttpClient>() { // from class: com.soletreadmills.sole_v2._networkJwtNotification.JwtNotificationRetrofit$baseOkHttpClient$2
            @Override // kotlin.jvm.functions.Function0
            public final OkHttpClient invoke() {
                return new OkHttpClient.Builder().dispatcher(JwtNotificationRetrofit.INSTANCE.getDispatcher()).callTimeout(60L, TimeUnit.SECONDS).connectTimeout(10L, TimeUnit.SECONDS).readTimeout(10L, TimeUnit.SECONDS).writeTimeout(10L, TimeUnit.SECONDS).addInterceptor(new JwtTokenAutoRefreshInterceptor()).addInterceptor(new JwtHeaderInterceptor()).addInterceptor(new JwtHttpStatusInterceptor()).addInterceptor(new OkHttpProfilerInterceptor()).build();
            }
        });
        okHttpClient = LazyKt.lazy(new Function0<OkHttpClient>() { // from class: com.soletreadmills.sole_v2._networkJwtNotification.JwtNotificationRetrofit$okHttpClient$2
            @Override // kotlin.jvm.functions.Function0
            public final OkHttpClient invoke() {
                return JwtNotificationRetrofit.INSTANCE.getBaseOkHttpClient();
            }
        });
        apiServiceJwtNotification = LazyKt.lazy(new Function0<JwtNotificationDyacoApiService>() { // from class: com.soletreadmills.sole_v2._networkJwtNotification.JwtNotificationRetrofit$apiServiceJwtNotification$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final JwtNotificationDyacoApiService invoke() {
                return (JwtNotificationDyacoApiService) JwtNotificationRetrofit.INSTANCE.createRetrofit(AppConfig.INSTANCE.getJWT_NOTIFICATION_BASE_URL()).create(JwtNotificationDyacoApiService.class);
            }
        });
        $stable = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void logging$lambda$0(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        Timber.INSTANCE.tag("interceptor msg").d(message, new Object[0]);
    }

    public final Dispatcher getDispatcher() {
        return dispatcher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OkHttpClient getBaseOkHttpClient() {
        return (OkHttpClient) baseOkHttpClient.getValue();
    }

    private final OkHttpClient getOkHttpClient() {
        return (OkHttpClient) okHttpClient.getValue();
    }

    public final JwtNotificationDyacoApiService getApiServiceJwtNotification() {
        Object value = apiServiceJwtNotification.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (JwtNotificationDyacoApiService) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Retrofit createRetrofit(String baseUrl) {
        logApiCallInfo(baseUrl);
        Retrofit retrofitBuild = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).client(getOkHttpClient()).build();
        Intrinsics.checkNotNullExpressionValue(retrofitBuild, "build(...)");
        return retrofitBuild;
    }
}
