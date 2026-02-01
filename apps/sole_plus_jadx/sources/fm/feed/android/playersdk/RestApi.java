package fm.feed.android.playersdk;

import androidx.core.app.NotificationCompat;
import com.android.SdkConstants;
import com.google.common.net.HttpHeaders;
import fm.feed.android.playersdk.RestApi;
import fm.feed.android.playersdk.models.webservice.ClientResponse;
import fm.feed.android.playersdk.models.webservice.FeedFMResponse;
import fm.feed.android.playersdk.models.webservice.PlayResponse;
import fm.feed.android.playersdk.models.webservice.PlayStartResponse;
import fm.feed.android.playersdk.models.webservice.PrepareCacheResponse;
import fm.feed.android.playersdk.models.webservice.SessionResponse;
import fm.feed.android.playersdk.models.webservice.SyncResponse;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.TlsVersion;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/* compiled from: RestApi.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b`\u0018\u0000 C2\u00020\u0001:\u0001CJ7\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0006H'¢\u0006\u0002\u0010\nJC\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0006H'¢\u0006\u0002\u0010\u000eJO\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\bH'¢\u0006\u0002\u0010\u0013J\u007f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\b2\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\b2\n\b\u0001\u0010\u001b\u001a\u0004\u0018\u00010\b2\n\b\u0001\u0010\u001c\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0006H'¢\u0006\u0002\u0010\u001dJg\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010 \u001a\u0004\u0018\u00010\u001f2\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0006H'¢\u0006\u0002\u0010!J\u0097\u0001\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\b2\n\b\u0001\u0010$\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\b2\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\b2\n\b\u0001\u0010%\u001a\u0004\u0018\u00010\u001f2\n\b\u0001\u0010&\u001a\u0004\u0018\u00010\u001f2\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0006H'¢\u0006\u0002\u0010'J[\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010)\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0006H'¢\u0006\u0002\u0010*JO\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\bH'¢\u0006\u0002\u0010\u0013JO\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010-\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0006H'¢\u0006\u0002\u0010.J[\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010-\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010/\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0006H'¢\u0006\u0002\u0010*J[\u00100\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u00101\u001a\u0004\u0018\u00010\u001f2\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0006H'¢\u0006\u0002\u00102Jg\u00103\u001a\b\u0012\u0004\u0012\u0002040\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u00105\u001a\u0004\u0018\u00010\b2\n\b\u0001\u00106\u001a\u0004\u0018\u00010\b2\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0006H'¢\u0006\u0002\u00107Jg\u00108\u001a\b\u0012\u0004\u0012\u0002090\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010:\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\b2\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\b2\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0006H'¢\u0006\u0002\u0010;J2\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010=\u001a\u0004\u0018\u00010>H'Jg\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0001\u0010@\u001a\u0004\u0018\u00010\b2\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0006H'¢\u0006\u0002\u0010AJO\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\bH'¢\u0006\u0002\u0010\u0013¨\u0006D"}, d2 = {"Lfm/feed/android/playersdk/RestApi;", "", "createClient", "Lretrofit2/Call;", "Lfm/feed/android/playersdk/models/webservice/ClientResponse;", "authorization", "", "force", "", "region", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lretrofit2/Call;", "createSession", "Lfm/feed/android/playersdk/models/webservice/SessionResponse;", "clientId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lretrofit2/Call;", "dislike", "Lfm/feed/android/playersdk/models/webservice/FeedFMResponse;", "playOrAudioFile", "playId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lretrofit2/Call;", "downloadAndSync", "Lfm/feed/android/playersdk/models/webservice/SyncResponse;", "stationId", "placementId", "clientID", "formats", "maxBitrate", "targetMins", "id", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lretrofit2/Call;", "elapsed", "", "total", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/String;)Lretrofit2/Call;", "getPlayWithID", "Lfm/feed/android/playersdk/models/webservice/PlayResponse;", "audioFileId", "advanceBy", "crossfade", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/String;)Lretrofit2/Call;", "invalidate", "reason", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lretrofit2/Call;", "like", "logEvent", NotificationCompat.CATEGORY_EVENT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lretrofit2/Call;", "parameters", "playCompleted", "timePlayed", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/String;)Lretrofit2/Call;", "playStarted", "Lfm/feed/android/playersdk/models/webservice/PlayStartResponse;", "bufferingTime", "waitingTime", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lretrofit2/Call;", "prepare", "Lfm/feed/android/playersdk/models/webservice/PrepareCacheResponse;", "ids", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lretrofit2/Call;", "sendLogs", SdkConstants.FD_LOGS, "Lokhttp3/RequestBody;", SdkConstants.TAG_SKIP, "forceS", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lretrofit2/Call;", "unlike", "Companion", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public interface RestApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @FormUrlEncoded
    @Headers({"User-Agent:FeedMediaSDK/Android/v6.2.0"})
    @POST("client")
    Call<ClientResponse> createClient(@Header("Authorization") String authorization, @Field("force200") Integer force, @Header("x-feed-location") String region);

    @FormUrlEncoded
    @Headers({"User-Agent:FeedMediaSDK/Android/v6.2.0"})
    @POST("session")
    Call<SessionResponse> createSession(@Header("Authorization") String authorization, @Header(HttpHeaders.COOKIE) String clientId, @Field("force200") Integer force, @Header("x-feed-location") String region);

    @FormUrlEncoded
    @Headers({"User-Agent:FeedMediaSDK/Android/v6.2.0"})
    @POST("{playOrAudioFile}/{id}/dislike")
    Call<FeedFMResponse> dislike(@Header("Authorization") String authorization, @Header(HttpHeaders.COOKIE) String clientId, @Path("playOrAudioFile") String playOrAudioFile, @Path("id") String playId, @Field("force200") Integer force);

    @FormUrlEncoded
    @Headers({"User-Agent:FeedMediaSDK/Android/v6.2.0"})
    @POST("station/synchronize")
    Call<SyncResponse> downloadAndSync(@Header("Authorization") String authorization, @Field("station_id") String stationId, @Field("placement_id") Integer placementId, @Header(HttpHeaders.COOKIE) String clientID, @Field("formats") String formats, @Field("max_bitrate") Integer maxBitrate, @Field("target_minutes") Integer targetMins, @Field("audio_file_id") String id2, @Header("x-feed-location") String region);

    @FormUrlEncoded
    @Headers({"User-Agent:FeedMediaSDK/Android/v6.2.0"})
    @POST("play/{id}/elapse")
    Call<FeedFMResponse> elapsed(@Header("Authorization") String authorization, @Path("id") String playId, @Field("seconds") Float elapsed, @Header(HttpHeaders.COOKIE) String clientId, @Field("total") Float total, @Field("force200") Integer force, @Header("x-feed-location") String region);

    @FormUrlEncoded
    @Headers({"User-Agent:FeedMediaSDK/Android/v6.2.0"})
    @POST("play")
    Call<PlayResponse> getPlayWithID(@Header("Authorization") String authorization, @Header(HttpHeaders.COOKIE) String clientId, @Field("placement_id") Integer placementId, @Field("audio_file_id") String audioFileId, @Field("station_id") Integer stationId, @Field("formats") String formats, @Field("max_bitrate") Integer maxBitrate, @Field("at") Float advanceBy, @Field("crossfade") Float crossfade, @Field("force200") Integer force, @Header("x-feed-location") String region);

    @FormUrlEncoded
    @Headers({"User-Agent:FeedMediaSDK/Android/v6.2.0"})
    @POST("play/{id}/invalidate")
    Call<FeedFMResponse> invalidate(@Header("Authorization") String authorization, @Path("id") String playId, @Header(HttpHeaders.COOKIE) String clientId, @Field("reason") String reason, @Field("force200") Integer force, @Header("x-feed-location") String region);

    @FormUrlEncoded
    @Headers({"User-Agent:FeedMediaSDK/Android/v6.2.0"})
    @POST("{playOrAudioFile}/{id}/like")
    Call<FeedFMResponse> like(@Header("Authorization") String authorization, @Header(HttpHeaders.COOKIE) String clientId, @Path("playOrAudioFile") String playOrAudioFile, @Path("id") String playId, @Field("force200") Integer force);

    @FormUrlEncoded
    @Headers({"User-Agent:FeedMediaSDK/Android/v6.2.0"})
    @POST("session/event")
    Call<FeedFMResponse> logEvent(@Header("Authorization") String authorization, @Header(HttpHeaders.COOKIE) String clientId, @Field(NotificationCompat.CATEGORY_EVENT) String event, @Field("force200") Integer force, @Header("x-feed-location") String region);

    @FormUrlEncoded
    @Headers({"User-Agent:FeedMediaSDK/Android/v6.2.0"})
    @POST("session/event")
    Call<FeedFMResponse> logEvent(@Header("Authorization") String authorization, @Header(HttpHeaders.COOKIE) String clientId, @Field(NotificationCompat.CATEGORY_EVENT) String event, @Field("parameters") String parameters, @Field("force200") Integer force, @Header("x-feed-location") String region);

    @FormUrlEncoded
    @Headers({"User-Agent:FeedMediaSDK/Android/v6.2.0"})
    @POST("play/{id}/complete")
    Call<FeedFMResponse> playCompleted(@Header("Authorization") String authorization, @Header(HttpHeaders.COOKIE) String clientId, @Path("id") String playId, @Field("seconds") Float timePlayed, @Field("force200") Integer force, @Header("x-feed-location") String region);

    @FormUrlEncoded
    @Headers({"User-Agent:FeedMediaSDK/Android/v6.2.0"})
    @POST("play/{id}/start")
    Call<PlayStartResponse> playStarted(@Header("Authorization") String authorization, @Header(HttpHeaders.COOKIE) String clientId, @Path("id") String playId, @Field("buffering_time") Integer bufferingTime, @Field("waiting_time") Integer waitingTime, @Field("force200") Integer force, @Header("x-feed-location") String region);

    @FormUrlEncoded
    @Headers({"User-Agent:FeedMediaSDK/Android/v6.2.0"})
    @POST("prepare")
    Call<PrepareCacheResponse> prepare(@Header("Authorization") String authorization, @Field("station") String ids, @Field("placement_id") Integer placementId, @Header(HttpHeaders.COOKIE) String clientID, @Field("formats") String formats, @Field("max_bitrate") Integer maxBitrate, @Header("x-feed-location") String region);

    @Headers({"User-Agent:FeedMediaSDK/Android/v6.2.0"})
    @POST("session/offline")
    Call<FeedFMResponse> sendLogs(@Header("Authorization") String authorization, @Header(HttpHeaders.COOKIE) String clientId, @Body RequestBody logs);

    @FormUrlEncoded
    @Headers({"User-Agent:FeedMediaSDK/Android/v6.2.0"})
    @POST("play/{id}/skip")
    Call<FeedFMResponse> skip(@Header("Authorization") String authorization, @Path("id") String playId, @Field("seconds") Float elapsed, @Header(HttpHeaders.COOKIE) String clientId, @Field("force200") Integer force, @Field("force") Integer forceS, @Header("x-feed-location") String region);

    @DELETE("{playOrAudioFile}/{id}/like")
    @Headers({"User-Agent:FeedMediaSDK/Android/v6.2.0"})
    Call<FeedFMResponse> unlike(@Header("Authorization") String authorization, @Header(HttpHeaders.COOKIE) String clientId, @Path("playOrAudioFile") String playOrAudioFile, @Path("id") String playId, @Query("force200") Integer force);

    /* compiled from: RestApi.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lfm/feed/android/playersdk/RestApi$Companion;", "", "()V", "httpLog", "Lokhttp3/logging/HttpLoggingInterceptor;", "getHttpLog", "()Lokhttp3/logging/HttpLoggingInterceptor;", "setHttpLog", "(Lokhttp3/logging/HttpLoggingInterceptor;)V", "log", "Lfm/feed/android/playersdk/FMLog;", "okHttpClient", "Lokhttp3/OkHttpClient;", "getOkHttpClient", "()Lokhttp3/OkHttpClient;", "retrofit", "Lretrofit2/Retrofit;", "getRetrofit", "()Lretrofit2/Retrofit;", "setRetrofit", "(Lretrofit2/Retrofit;)V", "spec", "Lokhttp3/ConnectionSpec;", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private static final OkHttpClient okHttpClient;
        private static Retrofit retrofit;
        private static final ConnectionSpec spec;
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final FMLog log = new FMLog("fm.feed.Retrofit");
        private static HttpLoggingInterceptor httpLog = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() { // from class: fm.feed.android.playersdk.RestApi$Companion$httpLog$1
            @Override // okhttp3.logging.HttpLoggingInterceptor.Logger
            public void log(String message) {
                Intrinsics.checkNotNullParameter(message, "message");
                FMLog.d$default(RestApi.Companion.log, message, null, 2, null);
            }
        });

        private Companion() {
        }

        static {
            ConnectionSpec connectionSpecBuild = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).tlsVersions(TlsVersion.TLS_1_2).build();
            spec = connectionSpecBuild;
            OkHttpClient okHttpClientBuild = new OkHttpClient.Builder().connectTimeout(10L, TimeUnit.SECONDS).writeTimeout(10L, TimeUnit.SECONDS).readTimeout(10L, TimeUnit.SECONDS).retryOnConnectionFailure(true).addInterceptor(httpLog).connectionSpecs(CollectionsKt.listOf(connectionSpecBuild)).build();
            okHttpClient = okHttpClientBuild;
            Retrofit retrofitBuild = new Retrofit.Builder().client(okHttpClientBuild).baseUrl("https://feed.fm/api/v2/").addConverterFactory(GsonConverterFactory.create()).build();
            Intrinsics.checkNotNullExpressionValue(retrofitBuild, "Builder()\n              …\n                .build()");
            retrofit = retrofitBuild;
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

        public final void setRetrofit(Retrofit retrofit3) {
            Intrinsics.checkNotNullParameter(retrofit3, "<set-?>");
            retrofit = retrofit3;
        }
    }
}
