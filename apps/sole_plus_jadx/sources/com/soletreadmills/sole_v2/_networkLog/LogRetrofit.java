package com.soletreadmills.sole_v2._networkLog;

import com.localebro.okhttpprofiler.OkHttpProfilerInterceptor;
import com.soletreadmills.sole_v2.AppConfig;
import com.soletreadmills.sole_v2._network.Interceptor.HeaderInterceptor;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

/* compiled from: LogRetrofit.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0015\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/soletreadmills/sole_v2/_networkLog/LogRetrofit;", "", "()V", "CONNECT_TIMEOUT", "", "READ_TIMEOUT", "WRITE_TIMEOUT", "_apiServiceLog", "Lcom/soletreadmills/sole_v2/_networkLog/DyacoLogService;", "apiServiceLog", "getApiServiceLog", "()Lcom/soletreadmills/sole_v2/_networkLog/DyacoLogService;", "baseOkHttpClient", "Lokhttp3/OkHttpClient;", "getBaseOkHttpClient", "()Lokhttp3/OkHttpClient;", "baseOkHttpClient$delegate", "Lkotlin/Lazy;", "logging", "Lokhttp3/logging/HttpLoggingInterceptor;", "okHttpClient", "getOkHttpClient", "okHttpClient$delegate", "createApiServiceLog", "baseUrl", "", "createRetrofit", "Lretrofit2/Retrofit;", "logApiCallInfo", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LogRetrofit {
    public static final int $stable;
    private static final long CONNECT_TIMEOUT = 10;
    public static final LogRetrofit INSTANCE = new LogRetrofit();
    private static final long READ_TIMEOUT = 10;
    private static final long WRITE_TIMEOUT = 10;
    private static volatile DyacoLogService _apiServiceLog;

    /* renamed from: baseOkHttpClient$delegate, reason: from kotlin metadata */
    private static final Lazy baseOkHttpClient;
    private static final HttpLoggingInterceptor logging;

    /* renamed from: okHttpClient$delegate, reason: from kotlin metadata */
    private static final Lazy okHttpClient;

    private final void logApiCallInfo(String baseUrl) {
    }

    private LogRetrofit() {
    }

    static {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() { // from class: com.soletreadmills.sole_v2._networkLog.LogRetrofit$$ExternalSyntheticLambda0
            @Override // okhttp3.logging.HttpLoggingInterceptor.Logger
            public final void log(String str) {
                LogRetrofit.logging$lambda$0(str);
            }
        });
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
        logging = httpLoggingInterceptor;
        baseOkHttpClient = LazyKt.lazy(new Function0<OkHttpClient>() { // from class: com.soletreadmills.sole_v2._networkLog.LogRetrofit$baseOkHttpClient$2
            @Override // kotlin.jvm.functions.Function0
            public final OkHttpClient invoke() {
                return new OkHttpClient.Builder().connectTimeout(10L, TimeUnit.SECONDS).readTimeout(10L, TimeUnit.SECONDS).writeTimeout(10L, TimeUnit.SECONDS).addInterceptor(new HeaderInterceptor()).addInterceptor(new OkHttpProfilerInterceptor()).build();
            }
        });
        okHttpClient = LazyKt.lazy(new Function0<OkHttpClient>() { // from class: com.soletreadmills.sole_v2._networkLog.LogRetrofit$okHttpClient$2
            @Override // kotlin.jvm.functions.Function0
            public final OkHttpClient invoke() {
                return LogRetrofit.INSTANCE.getBaseOkHttpClient();
            }
        });
        $stable = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void logging$lambda$0(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        Timber.INSTANCE.tag("interceptor msg").d(message, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OkHttpClient getBaseOkHttpClient() {
        return (OkHttpClient) baseOkHttpClient.getValue();
    }

    private final OkHttpClient getOkHttpClient() {
        return (OkHttpClient) okHttpClient.getValue();
    }

    public final DyacoLogService getApiServiceLog() {
        DyacoLogService dyacoLogServiceCreateApiServiceLog = _apiServiceLog;
        if (dyacoLogServiceCreateApiServiceLog == null) {
            synchronized (this) {
                dyacoLogServiceCreateApiServiceLog = _apiServiceLog;
                if (dyacoLogServiceCreateApiServiceLog == null) {
                    dyacoLogServiceCreateApiServiceLog = INSTANCE.createApiServiceLog(AppConfig.LOG_BASE_URL);
                    _apiServiceLog = dyacoLogServiceCreateApiServiceLog;
                }
            }
        }
        return dyacoLogServiceCreateApiServiceLog;
    }

    private final Retrofit createRetrofit(String baseUrl) {
        logApiCallInfo(baseUrl);
        Retrofit retrofitBuild = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).client(getOkHttpClient()).build();
        Intrinsics.checkNotNullExpressionValue(retrofitBuild, "build(...)");
        return retrofitBuild;
    }

    public final DyacoLogService createApiServiceLog(String baseUrl) {
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        DyacoLogService dyacoLogService = (DyacoLogService) createRetrofit(baseUrl).create(DyacoLogService.class);
        _apiServiceLog = dyacoLogService;
        Intrinsics.checkNotNull(dyacoLogService);
        return dyacoLogService;
    }
}
