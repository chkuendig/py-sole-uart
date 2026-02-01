package fm.feed.android.playersdk;

import com.google.common.net.HttpHeaders;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fm.feed.android.playersdk.SimulcastApi;
import fm.feed.android.playersdk.models.webservice.PlayResponse;
import fm.feed.android.playersdk.models.webservice.SimulcastConnectResponse;
import fm.feed.android.playersdk.models.webservice.SimulcastPlayResponse;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/* compiled from: SimulcastApi.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b`\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010J&\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0006H'J&\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0006H'J7\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0006H'¢\u0006\u0002\u0010\u000f¨\u0006\u0011"}, d2 = {"Lfm/feed/android/playersdk/SimulcastApi;", "", "simulcastGetInStudioPlay", "Lretrofit2/Call;", "Lfm/feed/android/playersdk/models/webservice/SimulcastPlayResponse;", "clientId", "", "token", "simulcastGetPlay", "Lfm/feed/android/playersdk/models/webservice/PlayResponse;", "id", "simulcastGetStream", "Lfm/feed/android/playersdk/models/webservice/SimulcastConnectResponse;", "force", "", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lretrofit2/Call;", "Companion", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public interface SimulcastApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Headers({"User-Agent:FeedMediaSDK/Android/v6.2.0"})
    @POST("simulcast/{token}/listen")
    Call<SimulcastPlayResponse> simulcastGetInStudioPlay(@Header(HttpHeaders.COOKIE) String clientId, @Path("token") String token);

    @Headers({"User-Agent:FeedMediaSDK/Android/v6.2.0"})
    @GET("{id}/play")
    Call<PlayResponse> simulcastGetPlay(@Header(HttpHeaders.COOKIE) String clientId, @Path("id") String id2);

    @FormUrlEncoded
    @Headers({"User-Agent:FeedMediaSDK/Android/v6.2.0"})
    @POST("simulcast/{token}")
    Call<SimulcastConnectResponse> simulcastGetStream(@Header(HttpHeaders.COOKIE) String clientId, @Field("force200") Integer force, @Path("token") String token);

    /* compiled from: SimulcastApi.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0016\u001a\n \u0005*\u0004\u0018\u00010\u00170\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019¨\u0006\u001c"}, d2 = {"Lfm/feed/android/playersdk/SimulcastApi$Companion;", "", "()V", "gson", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "getGson", "()Lcom/google/gson/Gson;", "setGson", "(Lcom/google/gson/Gson;)V", "httpLog", "Lokhttp3/logging/HttpLoggingInterceptor;", "getHttpLog", "()Lokhttp3/logging/HttpLoggingInterceptor;", "setHttpLog", "(Lokhttp3/logging/HttpLoggingInterceptor;)V", "log", "Lfm/feed/android/playersdk/FMLog;", "okHttpClient", "Lokhttp3/OkHttpClient;", "getOkHttpClient", "()Lokhttp3/OkHttpClient;", "retrofit", "Lretrofit2/Retrofit;", "getRetrofit", "()Lretrofit2/Retrofit;", "retrofitInStudio", "getRetrofitInStudio", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private static final OkHttpClient okHttpClient;
        private static final Retrofit retrofit;
        private static final Retrofit retrofitInStudio;
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final FMLog log = new FMLog("fm.feed.Retrofit");
        private static Gson gson = new GsonBuilder().setLenient().create();
        private static HttpLoggingInterceptor httpLog = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() { // from class: fm.feed.android.playersdk.SimulcastApi$Companion$$ExternalSyntheticLambda0
            @Override // okhttp3.logging.HttpLoggingInterceptor.Logger
            public final void log(String str) {
                SimulcastApi.Companion.m8782httpLog$lambda0(str);
            }
        });

        private Companion() {
        }

        static {
            OkHttpClient okHttpClientBuild = new OkHttpClient.Builder().connectTimeout(10L, TimeUnit.SECONDS).writeTimeout(10L, TimeUnit.SECONDS).readTimeout(10L, TimeUnit.SECONDS).addInterceptor(httpLog).retryOnConnectionFailure(true).build();
            okHttpClient = okHttpClientBuild;
            retrofit = new Retrofit.Builder().client(okHttpClientBuild).baseUrl("https://cast.feed.fm/").addConverterFactory(GsonConverterFactory.create(gson)).build();
            Retrofit retrofitBuild = new Retrofit.Builder().client(okHttpClientBuild).baseUrl("https://feed.fm/api/v2/").addConverterFactory(GsonConverterFactory.create(gson)).build();
            Intrinsics.checkNotNullExpressionValue(retrofitBuild, "Builder()\n              …\n                .build()");
            retrofitInStudio = retrofitBuild;
        }

        public final Gson getGson() {
            return gson;
        }

        public final void setGson(Gson gson2) {
            gson = gson2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: httpLog$lambda-0, reason: not valid java name */
        public static final void m8782httpLog$lambda0(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            FMLog.d$default(log, message, null, 2, null);
        }

        public final HttpLoggingInterceptor getHttpLog() {
            return httpLog;
        }

        public final void setHttpLog(HttpLoggingInterceptor httpLoggingInterceptor) {
            Intrinsics.checkNotNullParameter(httpLoggingInterceptor, "<set-?>");
            httpLog = httpLoggingInterceptor;
        }

        public final OkHttpClient getOkHttpClient() {
            return okHttpClient;
        }

        public final Retrofit getRetrofit() {
            return retrofit;
        }

        public final Retrofit getRetrofitInStudio() {
            return retrofitInStudio;
        }
    }
}
