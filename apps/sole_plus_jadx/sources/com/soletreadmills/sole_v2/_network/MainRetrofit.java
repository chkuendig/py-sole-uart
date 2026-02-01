package com.soletreadmills.sole_v2._network;

import com.localebro.okhttpprofiler.OkHttpProfilerInterceptor;
import com.soletreadmills.sole_v2.AppConfig;
import com.soletreadmills.sole_v2._network.Interceptor.HeaderInterceptor;
import com.soletreadmills.sole_v2._network.Interceptor.HttpStatusInterceptor;
import com.soletreadmills.sole_v2._network.Interceptor.TokenAutoRefreshInterceptor;
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

/* compiled from: MainRetrofit.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020 J\u0010\u0010!\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u001f\u001a\u00020 H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000bR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001b\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\r\u001a\u0004\b\u001c\u0010\u0013¨\u0006%"}, d2 = {"Lcom/soletreadmills/sole_v2/_network/MainRetrofit;", "", "()V", "CONNECT_TIMEOUT", "", "READ_TIMEOUT", "WRITE_TIMEOUT", "_apiService2", "Lcom/soletreadmills/sole_v2/_network/DyacoApiService;", "apiService", "getApiService", "()Lcom/soletreadmills/sole_v2/_network/DyacoApiService;", "apiService$delegate", "Lkotlin/Lazy;", "apiService2", "getApiService2", "baseOkHttpClient", "Lokhttp3/OkHttpClient;", "getBaseOkHttpClient", "()Lokhttp3/OkHttpClient;", "baseOkHttpClient$delegate", "dispatcher", "Lokhttp3/Dispatcher;", "getDispatcher", "()Lokhttp3/Dispatcher;", "logging", "Lokhttp3/logging/HttpLoggingInterceptor;", "okHttpClient", "getOkHttpClient", "okHttpClient$delegate", "createApiService2", "baseUrl", "", "createRetrofit", "Lretrofit2/Retrofit;", "logApiCallInfo", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MainRetrofit {
    public static final int $stable;
    private static final long CONNECT_TIMEOUT = 10;
    public static final MainRetrofit INSTANCE = new MainRetrofit();
    private static final long READ_TIMEOUT = 10;
    private static final long WRITE_TIMEOUT = 10;
    private static volatile DyacoApiService _apiService2;

    /* renamed from: apiService$delegate, reason: from kotlin metadata */
    private static final Lazy apiService;

    /* renamed from: baseOkHttpClient$delegate, reason: from kotlin metadata */
    private static final Lazy baseOkHttpClient;
    private static final Dispatcher dispatcher;
    private static final HttpLoggingInterceptor logging;

    /* renamed from: okHttpClient$delegate, reason: from kotlin metadata */
    private static final Lazy okHttpClient;

    private final void logApiCallInfo(String baseUrl) {
    }

    private MainRetrofit() {
    }

    static {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() { // from class: com.soletreadmills.sole_v2._network.MainRetrofit$$ExternalSyntheticLambda0
            @Override // okhttp3.logging.HttpLoggingInterceptor.Logger
            public final void log(String str) {
                MainRetrofit.logging$lambda$0(str);
            }
        });
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
        logging = httpLoggingInterceptor;
        Dispatcher dispatcher2 = new Dispatcher();
        dispatcher2.setMaxRequests(64);
        dispatcher2.setMaxRequestsPerHost(20);
        dispatcher = dispatcher2;
        baseOkHttpClient = LazyKt.lazy(new Function0<OkHttpClient>() { // from class: com.soletreadmills.sole_v2._network.MainRetrofit$baseOkHttpClient$2
            @Override // kotlin.jvm.functions.Function0
            public final OkHttpClient invoke() {
                return new OkHttpClient.Builder().dispatcher(MainRetrofit.INSTANCE.getDispatcher()).callTimeout(60L, TimeUnit.SECONDS).connectTimeout(10L, TimeUnit.SECONDS).readTimeout(10L, TimeUnit.SECONDS).writeTimeout(10L, TimeUnit.SECONDS).addInterceptor(new TokenAutoRefreshInterceptor()).addInterceptor(new HeaderInterceptor()).addInterceptor(new HttpStatusInterceptor()).addInterceptor(new OkHttpProfilerInterceptor()).build();
            }
        });
        okHttpClient = LazyKt.lazy(new Function0<OkHttpClient>() { // from class: com.soletreadmills.sole_v2._network.MainRetrofit$okHttpClient$2
            @Override // kotlin.jvm.functions.Function0
            public final OkHttpClient invoke() {
                return MainRetrofit.INSTANCE.getBaseOkHttpClient();
            }
        });
        apiService = LazyKt.lazy(new Function0<DyacoApiService>() { // from class: com.soletreadmills.sole_v2._network.MainRetrofit$apiService$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DyacoApiService invoke() {
                return (DyacoApiService) MainRetrofit.INSTANCE.createRetrofit(AppConfig.INSTANCE.getGLOBAL_BASE_URL()).create(DyacoApiService.class);
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

    public final DyacoApiService getApiService() {
        Object value = apiService.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (DyacoApiService) value;
    }

    public final DyacoApiService getApiService2() {
        DyacoApiService dyacoApiServiceCreateApiService2 = _apiService2;
        if (dyacoApiServiceCreateApiService2 == null) {
            synchronized (this) {
                dyacoApiServiceCreateApiService2 = _apiService2;
                if (dyacoApiServiceCreateApiService2 == null) {
                    dyacoApiServiceCreateApiService2 = INSTANCE.createApiService2(AppConfig.INSTANCE.getBASE_URL_WHEN_NULL());
                    _apiService2 = dyacoApiServiceCreateApiService2;
                }
            }
        }
        return dyacoApiServiceCreateApiService2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Retrofit createRetrofit(String baseUrl) {
        logApiCallInfo(baseUrl);
        Retrofit retrofitBuild = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).client(getOkHttpClient()).build();
        Intrinsics.checkNotNullExpressionValue(retrofitBuild, "build(...)");
        return retrofitBuild;
    }

    public final DyacoApiService createApiService2(String baseUrl) {
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        DyacoApiService dyacoApiService = (DyacoApiService) createRetrofit(baseUrl).create(DyacoApiService.class);
        _apiService2 = dyacoApiService;
        Intrinsics.checkNotNull(dyacoApiService);
        return dyacoApiService;
    }
}
