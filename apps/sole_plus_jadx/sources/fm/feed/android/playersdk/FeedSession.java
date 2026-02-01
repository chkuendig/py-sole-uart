package fm.feed.android.playersdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.android.SdkConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.gson.Gson;
import com.sun.jna.Callback;
import fm.feed.android.playersdk.FeedSession;
import fm.feed.android.playersdk.RestApi;
import fm.feed.android.playersdk.models.AudioFile;
import fm.feed.android.playersdk.models.CacheInfo;
import fm.feed.android.playersdk.models.Placement;
import fm.feed.android.playersdk.models.Play;
import fm.feed.android.playersdk.models.Session;
import fm.feed.android.playersdk.models.Station;
import fm.feed.android.playersdk.models.webservice.ClientResponse;
import fm.feed.android.playersdk.models.webservice.FeedFMError;
import fm.feed.android.playersdk.models.webservice.FeedFMResponse;
import fm.feed.android.playersdk.models.webservice.PlayResponse;
import fm.feed.android.playersdk.models.webservice.PlayStartResponse;
import fm.feed.android.playersdk.models.webservice.PrepareCacheResponse;
import fm.feed.android.playersdk.models.webservice.SessionResponse;
import fm.feed.android.playersdk.models.webservice.SyncResponse;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* compiled from: FeedSession.kt */
@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u0000 \u0091\u00012\u00020\u0001:\u000e\u008f\u0001\u0090\u0001\u0091\u0001\u0092\u0001\u0093\u0001\u0094\u0001\u0095\u0001B?\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fB\r\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eJ\u000e\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020\bJ\u0006\u0010L\u001a\u00020\u0016J\u0006\u0010M\u001a\u00020\u0016J\b\u0010N\u001a\u00020JH\u0002J,\u0010O\u001a\u00020J2\u0006\u0010P\u001a\u00020D2\u0006\u0010Q\u001a\u00020.2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00050C2\u0006\u0010S\u001a\u00020TJ\u0010\u0010U\u001a\u00020J2\b\u0010\u0007\u001a\u0004\u0018\u00010VJ\u0018\u0010W\u001a\u0004\u0018\u00010\u00052\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00050CH\u0002J\u001b\u0010Y\u001a\u0004\u0018\u00010Z2\u0006\u0010P\u001a\u00020DH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010[J\u000e\u0010\\\u001a\u00020J2\u0006\u0010]\u001a\u00020\u0005J\u0016\u0010\\\u001a\u00020J2\u0006\u0010]\u001a\u00020\u00052\u0006\u0010^\u001a\u00020\u0001J\u0016\u0010_\u001a\u00020J2\u0006\u0010`\u001a\u00020Z2\u0006\u0010a\u001a\u00020=J3\u0010b\u001a\u00020\u00162\b\u0010P\u001a\u0004\u0018\u00010D2\u0006\u0010`\u001a\u00020Z2\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020.H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010fJ\u0006\u0010g\u001a\u00020JJ\u0014\u0010h\u001a\u00020J2\f\u0010i\u001a\b\u0012\u0004\u0012\u00020D0CJ!\u0010j\u001a\u00020\u00162\u0006\u0010`\u001a\u00020Z2\u0006\u0010k\u001a\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010lJ=\u0010m\u001a\u0004\u0018\u00010Z2\b\u0010P\u001a\u0004\u0018\u00010D2\b\u0010n\u001a\u0004\u0018\u00010o2\n\b\u0002\u0010p\u001a\u0004\u0018\u00010=2\b\u0010q\u001a\u0004\u0018\u00010=H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010rJ\u000e\u0010s\u001a\u00020J2\u0006\u0010n\u001a\u00020oJ\u0016\u0010s\u001a\u00020J2\u0006\u0010t\u001a\u00020\u00052\u0006\u0010u\u001a\u00020\u0005J\u000e\u0010v\u001a\u00020J2\u0006\u0010`\u001a\u00020ZJ\u000e\u0010w\u001a\u00020J2\u0006\u0010n\u001a\u00020oJ\u000e\u0010w\u001a\u00020J2\u0006\u0010`\u001a\u00020ZJ\u0018\u0010w\u001a\u00020J2\u0006\u0010t\u001a\u00020\u00052\u0006\u0010u\u001a\u00020\u0005H\u0002J\u0011\u0010x\u001a\u00020\u0016H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010yJ\u001e\u0010z\u001a\u00020J2\u0006\u0010`\u001a\u00020Z2\u0006\u0010{\u001a\u00020=2\u0006\u0010|\u001a\u00020}J\u000e\u0010~\u001a\u00020J2\u0006\u0010n\u001a\u00020oJ\u000e\u0010~\u001a\u00020J2\u0006\u0010`\u001a\u00020ZJ\u0016\u0010~\u001a\u00020J2\u0006\u0010t\u001a\u00020\u00052\u0006\u0010u\u001a\u00020\u0005J\u0006\u0010\u007f\u001a\u00020JJ\u0007\u0010\u0080\u0001\u001a\u00020JJ\u001c\u0010\u0081\u0001\u001a\u00020J2\b\u0010\u0082\u0001\u001a\u00030\u0083\u00012\t\u0010\u0007\u001a\u0005\u0018\u00010\u0084\u0001J:\u0010\u0085\u0001\u001a\u00020J\"\n\b\u0000\u0010\u0086\u0001*\u00030\u0087\u00012\u000e\u0010\u0088\u0001\u001a\t\u0012\u0005\u0012\u0003H\u0086\u0001082\u0013\u0010\u0089\u0001\u001a\u000e\u0012\u0005\u0012\u0003H\u0086\u00010\u008a\u0001R\u00020\u0000H\u0002JC\u0010\u0085\u0001\u001a\u00020J\"\n\b\u0000\u0010\u0086\u0001*\u00030\u0087\u00012\u000e\u0010\u0088\u0001\u001a\t\u0012\u0005\u0012\u0003H\u0086\u0001082\u0007\u0010\u008b\u0001\u001a\u00020\u00162\u0013\u0010\u0089\u0001\u001a\u000e\u0012\u0005\u0012\u0003H\u0086\u00010\u008a\u0001R\u00020\u0000H\u0002J\u0017\u0010\u008c\u0001\u001a\u00020J2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u001f\u0010\u008d\u0001\u001a\u00020J2\u0006\u0010`\u001a\u00020Z2\b\u0010{\u001a\u0004\u0018\u00010=¢\u0006\u0003\u0010\u008e\u0001R(\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0010R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u00168F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR!\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u00050#j\b\u0012\u0004\u0012\u00020\u0005`$¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\b0#j\b\u0012\u0004\u0012\u00020\b`$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0004\n\u0002\u0010/R\u0012\u00100\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0004\n\u0002\u0010/R\u001a\u00101\u001a\u00020.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0018\u00106\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030807X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00109\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u001c\"\u0004\b;\u0010\u001eR\u001a\u0010<\u001a\u00020=X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR*\u0010E\u001a\b\u0012\u0004\u0012\u00020D0C2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020D0C@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u0010\u0010H\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0096\u0001"}, d2 = {"Lfm/feed/android/playersdk/FeedSession;", "", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "token", "", "secret", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lfm/feed/android/playersdk/FeedSession$EventListener;", "clientId", "location", "Lfm/feed/android/playersdk/MockLocations;", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lfm/feed/android/playersdk/FeedSession$EventListener;Ljava/lang/String;Lfm/feed/android/playersdk/MockLocations;)V", "mContext", "(Landroid/content/Context;)V", "getClientId", "()Ljava/lang/String;", "setClientId", "(Ljava/lang/String;)V", "clientIdCookie", "getClientIdCookie", "isAvailable", "", "()Ljava/lang/Boolean;", "log", "Lfm/feed/android/playersdk/FMLog;", "logEverything", "getLogEverything", "()Z", "setLogEverything", "(Z)V", "loggingEnabled", "getLoggingEnabled", "setLoggingEnabled", "mAudioFormat", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getMAudioFormat", "()Ljava/util/ArrayList;", "mCanSkipCurrent", "mCurrentSession", "Lfm/feed/android/playersdk/models/Session;", "mEncodedAuthorization", "mEventListeners", "mNextPlayInProgress", "mOfflinePlacement", "", "Ljava/lang/Integer;", "mPlacementId", "maxBitrate", "getMaxBitrate", "()I", "setMaxBitrate", "(I)V", "pendingRequests", "", "Lretrofit2/Call;", "remoteCrossfadeEnabled", "getRemoteCrossfadeEnabled", "setRemoteCrossfadeEnabled", "remoteCrossfadeTime", "", "getRemoteCrossfadeTime", "()F", "setRemoteCrossfadeTime", "(F)V", "<set-?>", "", "Lfm/feed/android/playersdk/models/Station;", "stationList", "getStationList", "()Ljava/util/List;", "testLocation", "addEventListener", "", "eventListener", "canRequestPlays", "canSkip", "cancelOutstandingRequests", "downloadAndSync", "station", "targetMins", "audioFileIds", "downloadListener", "Lfm/feed/android/playersdk/StationDownloadListener;", "generateClientId", "Lfm/feed/android/playersdk/FeedSession$ClientIdListener;", "getFormatString", "stringList", "getNextPlayForStation", "Lfm/feed/android/playersdk/models/Play;", "(Lfm/feed/android/playersdk/models/Station;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logEvent", NotificationCompat.CATEGORY_EVENT, "parameters", "playCompleted", "play", "timePlayed", "playStarted", "bufferingTime", "", "waitingTime", "(Lfm/feed/android/playersdk/models/Station;Lfm/feed/android/playersdk/models/Play;JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prepareCache", "prepareStationCache", "stations", "rejectPlay", "reason", "(Lfm/feed/android/playersdk/models/Play;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestAudioFile", "audioFile", "Lfm/feed/android/playersdk/models/AudioFile;", "advanceBy", "crossfade", "(Lfm/feed/android/playersdk/models/Station;Lfm/feed/android/playersdk/models/AudioFile;Ljava/lang/Float;Ljava/lang/Float;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestDislike", "type", "id", "requestDislikeForItem", "requestLike", "requestSession", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestSkip", "elapsedTime", "skipRequestListener", "Lfm/feed/android/playersdk/FeedSession$SkipRequestListener;", "requestUnlike", "reset", "resetSessionToNull", "sendOfflineLogs", SdkConstants.FD_LOGS, "Lorg/json/JSONArray;", "Lfm/feed/android/playersdk/FeedSession$OfflineLogsListener;", "sendRequest", ExifInterface.GPS_DIRECTION_TRUE, "Lfm/feed/android/playersdk/models/webservice/FeedFMResponse;", NotificationCompat.CATEGORY_CALL, Callback.METHOD_NAME, "Lfm/feed/android/playersdk/FeedSession$WrappedCallback;", "cancellable", "setClientTokenAndSecret", "updatePlayTime", "(Lfm/feed/android/playersdk/models/Play;Ljava/lang/Float;)V", "CancelledRequest", "ClientIdListener", "Companion", "EventListener", "OfflineLogsListener", "SkipRequestListener", "WrappedCallback", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class FeedSession {
    private static final String AUDIO_FORMAT_AAC = "aac";
    private static final String AUDIO_FORMAT_M4A = "m4a";
    private static final String AUDIO_FORMAT_MP3 = "mp3";
    private static final String CLIENT_ID = "Client_id";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int FORCE_CODE = 1;
    private static RestApi mRestApi;
    private final FMLog log;
    private boolean logEverything;
    private boolean loggingEnabled;
    private final ArrayList<String> mAudioFormat;
    private boolean mCanSkipCurrent;
    private final Context mContext;
    private Session mCurrentSession;
    private String mEncodedAuthorization;
    private ArrayList<EventListener> mEventListeners;
    private boolean mNextPlayInProgress;
    private Integer mOfflinePlacement;
    private Integer mPlacementId;
    private int maxBitrate;
    private List<Call<?>> pendingRequests;
    private boolean remoteCrossfadeEnabled;
    private float remoteCrossfadeTime;
    private List<Station> stationList;
    private String testLocation;

    /* compiled from: FeedSession.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lfm/feed/android/playersdk/FeedSession$CancelledRequest;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "()V", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class CancelledRequest extends Exception {
    }

    /* compiled from: FeedSession.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lfm/feed/android/playersdk/FeedSession$ClientIdListener;", "", "onError", "", "t", "", "onSuccess", "clientId", "", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface ClientIdListener {
        void onError(Throwable t);

        void onSuccess(String clientId);
    }

    /* compiled from: FeedSession.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u0016\u0010\b\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&J\b\u0010\f\u001a\u00020\u0003H&J\u0014\u0010\r\u001a\u00020\u00032\n\u0010\u000e\u001a\u00060\u000fj\u0002`\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017H&J\u0016\u0010\u0018\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&J\u0014\u0010\u0019\u001a\u00020\u00032\n\u0010\u001a\u001a\u00060\u000fj\u0002`\u0010H&¨\u0006\u001b"}, d2 = {"Lfm/feed/android/playersdk/FeedSession$EventListener;", "", "cacheFilesAvailable", "", "cacheInfoList", "", "Lfm/feed/android/playersdk/models/CacheInfo;", "noMoreMusic", "remoteOfflineStationListAvailable", "stations", "", "Lfm/feed/android/playersdk/models/Station;", "sessionAvailable", "sessionNotAvailable", "ex", "Ljava/lang/Exception;", "Lkotlin/Exception;", "skipStatusDidChange", "canSkip", "", "stationInfoAvailable", "station", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lfm/feed/android/playersdk/StationDownloadListener;", "stationListAvailable", "unexpectedError", "e", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface EventListener {
        void cacheFilesAvailable(List<CacheInfo> cacheInfoList);

        void noMoreMusic();

        void remoteOfflineStationListAvailable(List<Station> stations);

        void sessionAvailable();

        void sessionNotAvailable(Exception ex);

        void skipStatusDidChange(boolean canSkip);

        void stationInfoAvailable(Station station, StationDownloadListener listener);

        void stationListAvailable(List<Station> stations);

        void unexpectedError(Exception e);
    }

    /* compiled from: FeedSession.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lfm/feed/android/playersdk/FeedSession$OfflineLogsListener;", "", "offlineLogSaveFailed", "", SdkConstants.FD_LOGS, "Lorg/json/JSONArray;", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface OfflineLogsListener {
        void offlineLogSaveFailed(JSONArray logs);
    }

    /* compiled from: FeedSession.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, d2 = {"Lfm/feed/android/playersdk/FeedSession$SkipRequestListener;", "", "onFailure", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface SkipRequestListener {
        void onFailure(Exception e);

        void onSuccess();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FeedSession(Context context, String token, String secret, EventListener listener) {
        this(context, token, secret, listener, null, null, 48, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(secret, "secret");
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FeedSession(Context context, String token, String secret, EventListener listener, String str) {
        this(context, token, secret, listener, str, null, 32, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(secret, "secret");
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    public FeedSession(Context mContext) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mContext = mContext;
        this.log = new FMLog("fm.feed.FeedSession");
        this.maxBitrate = 128;
        this.stationList = CollectionsKt.emptyList();
        this.pendingRequests = new ArrayList();
        ArrayList<String> arrayList = new ArrayList<>();
        this.mAudioFormat = arrayList;
        this.mEventListeners = new ArrayList<>();
        RestApi.INSTANCE.getHttpLog().level(HttpLoggingInterceptor.Level.BODY);
        arrayList.add(AUDIO_FORMAT_AAC);
        arrayList.add(AUDIO_FORMAT_MP3);
        arrayList.add(AUDIO_FORMAT_M4A);
        this.mNextPlayInProgress = false;
        this.mCanSkipCurrent = true;
    }

    public final int getMaxBitrate() {
        return this.maxBitrate;
    }

    public final void setMaxBitrate(int i) {
        this.maxBitrate = i;
    }

    public final List<Station> getStationList() {
        return this.stationList;
    }

    public final float getRemoteCrossfadeTime() {
        return this.remoteCrossfadeTime;
    }

    public final void setRemoteCrossfadeTime(float f) {
        this.remoteCrossfadeTime = f;
    }

    public final boolean getRemoteCrossfadeEnabled() {
        return this.remoteCrossfadeEnabled;
    }

    public final void setRemoteCrossfadeEnabled(boolean z) {
        this.remoteCrossfadeEnabled = z;
    }

    public final boolean getLoggingEnabled() {
        return this.loggingEnabled;
    }

    public final void setLoggingEnabled(boolean z) {
        this.loggingEnabled = z;
    }

    public final boolean getLogEverything() {
        return this.logEverything;
    }

    public final void setLogEverything(boolean z) {
        this.logEverything = z;
    }

    public final ArrayList<String> getMAudioFormat() {
        return this.mAudioFormat;
    }

    public final Boolean isAvailable() {
        Session session = this.mCurrentSession;
        if (session == null) {
            return null;
        }
        return Boolean.valueOf(session.getIsAvailable());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FeedSession(Context context, String token, String secret, EventListener listener, String str, MockLocations mockLocations) {
        this(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(secret, "secret");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (mockLocations != null) {
            String strName = mockLocations.name();
            if (strName == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = strName.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
            this.testLocation = lowerCase;
        }
        if (str != null) {
            setClientId(str);
        }
        setClientTokenAndSecret(token, secret);
        this.mEventListeners.add(listener);
    }

    public /* synthetic */ FeedSession(Context context, String str, String str2, EventListener eventListener, String str3, MockLocations mockLocations, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, str2, eventListener, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : mockLocations);
    }

    public final String getClientId() {
        return INSTANCE.retrieveClientId(this.mContext);
    }

    public final void setClientId(String str) {
        if (str == null && this.mCurrentSession != null) {
            throw new Error("cannot reset client id after session is created");
        }
        INSTANCE.persistClientId(this.mContext, str);
        Session session = this.mCurrentSession;
        if (session == null) {
            return;
        }
        session.setClientId(str);
    }

    private final String getClientIdCookie() {
        String clientId = getClientId();
        if (clientId == null) {
            return null;
        }
        return Intrinsics.stringPlus("cid=", clientId);
    }

    public final void generateClientId(ClientIdListener listener) {
        sendRequest(mRestApi.createClient(this.mEncodedAuthorization, 1, this.testLocation), new WrappedCallback<ClientResponse>(this) { // from class: fm.feed.android.playersdk.FeedSession.generateClientId.1
            final /* synthetic */ FeedSession this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(this);
                this.this$0 = this;
            }

            @Override // fm.feed.android.playersdk.FeedSession.WrappedCallback
            public void onSuccess(ClientResponse response) {
                ClientIdListener clientIdListener;
                Intrinsics.checkNotNullParameter(response, "response");
                String clientId = response.getClientId();
                if (clientId == null || (clientIdListener = this.$listener) == null) {
                    return;
                }
                clientIdListener.onSuccess(clientId);
            }

            @Override // fm.feed.android.playersdk.FeedSession.WrappedCallback
            public void onError(Throwable t) {
                Intrinsics.checkNotNullParameter(t, "t");
                ClientIdListener clientIdListener = this.$listener;
                if (clientIdListener == null) {
                    return;
                }
                clientIdListener.onError(t);
            }
        });
    }

    private final <T extends FeedFMResponse> void sendRequest(Call<T> call, WrappedCallback<T> callback) {
        sendRequest(call, true, callback);
    }

    private final <T extends FeedFMResponse> void sendRequest(Call<T> call, final boolean cancellable, final WrappedCallback<T> callback) {
        if (cancellable) {
            this.pendingRequests.add(call);
        }
        FMLog.d$default(this.log, call.request().method() + ' ' + call.request().url() + " with call " + call, null, 2, null);
        call.enqueue((retrofit2.Callback) new retrofit2.Callback<T>() { // from class: fm.feed.android.playersdk.FeedSession.sendRequest.1
            @Override // retrofit2.Callback
            public void onResponse(Call<T> call2, Response<T> response) {
                String strString;
                Intrinsics.checkNotNullParameter(call2, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (!cancellable || this.pendingRequests.contains(call2)) {
                    this.pendingRequests.remove(call2);
                    if (!response.isSuccessful()) {
                        FMLog.d$default(this.log, "call " + call2 + " returned non 2xx response", null, 2, null);
                        try {
                            ResponseBody responseBodyErrorBody = response.errorBody();
                            Intrinsics.checkNotNull(responseBodyErrorBody);
                            strString = responseBodyErrorBody.string();
                        } catch (Exception e) {
                            e.printStackTrace();
                            strString = "";
                        }
                        if (strString.length() == 0) {
                            strString = "response was non-2xx response";
                        }
                        callback.onError(new Error(strString));
                        return;
                    }
                    FeedFMResponse feedFMResponse = (FeedFMResponse) response.body();
                    if (feedFMResponse == null) {
                        FMLog.d$default(this.log, "call " + call2 + " returned null body in response", null, 2, null);
                        callback.onError(new Error("Null body in response"));
                        return;
                    } else if (feedFMResponse.getIsSuccess()) {
                        FMLog.d$default(this.log, "call " + call2 + " succeeded! " + feedFMResponse, null, 2, null);
                        callback.onSuccess(feedFMResponse);
                        return;
                    } else {
                        FMLog.e$default(this.log, "call " + call2 + " returned error " + feedFMResponse, null, 2, null);
                        callback.onError(new Throwable(feedFMResponse.getError()));
                        return;
                    }
                }
                FMLog.d$default(this.log, "call " + call2 + " was cancelled", null, 2, null);
                callback.onError(new CancelledRequest());
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<T> call2, Throwable t) {
                Intrinsics.checkNotNullParameter(call2, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                if (!cancellable || this.pendingRequests.contains(call2)) {
                    this.pendingRequests.remove(call2);
                    callback.onError(t);
                } else {
                    FMLog.d$default(this.log, "call returned failure, but was cancelled", null, 2, null);
                    callback.onError(new CancelledRequest());
                }
            }
        });
    }

    private final void cancelOutstandingRequests() {
        FMLog.d$default(this.log, "cancelling all outstanding requests", null, 2, null);
        List<Call<?>> list = this.pendingRequests;
        this.pendingRequests = new ArrayList();
        Iterator<Call<?>> it = list.iterator();
        while (it.hasNext()) {
            it.next().cancel();
        }
        list.clear();
        this.mNextPlayInProgress = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FeedSession.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\b¢\u0004\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lfm/feed/android/playersdk/FeedSession$WrappedCallback;", ExifInterface.GPS_DIRECTION_TRUE, "Lfm/feed/android/playersdk/models/webservice/FeedFMResponse;", "", "(Lfm/feed/android/playersdk/FeedSession;)V", "onError", "", "t", "", "onSuccess", "response", "(Lfm/feed/android/playersdk/models/webservice/FeedFMResponse;)V", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
    abstract class WrappedCallback<T extends FeedFMResponse> {
        final /* synthetic */ FeedSession this$0;

        public abstract void onSuccess(T response);

        public WrappedCallback(FeedSession this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this.this$0 = this$0;
        }

        public void onError(Throwable t) {
            Intrinsics.checkNotNullParameter(t, "t");
            if (t instanceof CancelledRequest) {
                return;
            }
            Exception exc = new Exception(t);
            Iterator it = this.this$0.mEventListeners.iterator();
            while (it.hasNext()) {
                ((EventListener) it.next()).unexpectedError(exc);
            }
        }
    }

    public final void prepareStationCache(List<Station> stations) {
        Intrinsics.checkNotNullParameter(stations, "stations");
        ArrayList arrayList = new ArrayList();
        Iterator<Station> it = stations.iterator();
        while (it.hasNext()) {
            Integer id2 = it.next().getId();
            Intrinsics.checkNotNull(id2);
            arrayList.add(String.valueOf(id2.intValue()));
        }
        sendRequest(mRestApi.prepare(this.mEncodedAuthorization, getFormatString(arrayList), this.mPlacementId, getClientIdCookie(), getFormatString(this.mAudioFormat), Integer.valueOf(this.maxBitrate), this.testLocation), new WrappedCallback<PrepareCacheResponse>() { // from class: fm.feed.android.playersdk.FeedSession.prepareStationCache.1
            {
                super(FeedSession.this);
            }

            @Override // fm.feed.android.playersdk.FeedSession.WrappedCallback
            public void onSuccess(PrepareCacheResponse response) {
                Intrinsics.checkNotNullParameter(response, "response");
                if (response.getCacheInfoList() != null) {
                    Iterator it2 = FeedSession.this.mEventListeners.iterator();
                    while (it2.hasNext()) {
                        ((EventListener) it2.next()).cacheFilesAvailable(CollectionsKt.toMutableList((Collection) response.getCacheInfoList()));
                    }
                }
            }
        });
    }

    public final void prepareCache() {
        sendRequest(mRestApi.prepare(this.mEncodedAuthorization, null, this.mPlacementId, getClientIdCookie(), getFormatString(this.mAudioFormat), Integer.valueOf(this.maxBitrate), this.testLocation), new WrappedCallback<PrepareCacheResponse>() { // from class: fm.feed.android.playersdk.FeedSession.prepareCache.1
            {
                super(FeedSession.this);
            }

            @Override // fm.feed.android.playersdk.FeedSession.WrappedCallback
            public void onSuccess(PrepareCacheResponse response) {
                Intrinsics.checkNotNullParameter(response, "response");
                if (response.getCacheInfoList() != null) {
                    Iterator it = FeedSession.this.mEventListeners.iterator();
                    while (it.hasNext()) {
                        ((EventListener) it.next()).cacheFilesAvailable(CollectionsKt.toMutableList((Collection) response.getCacheInfoList()));
                    }
                }
            }
        });
    }

    public final void downloadAndSync(Station station, int targetMins, List<String> audioFileIds, StationDownloadListener downloadListener) {
        Intrinsics.checkNotNullParameter(station, "station");
        Intrinsics.checkNotNullParameter(audioFileIds, "audioFileIds");
        Intrinsics.checkNotNullParameter(downloadListener, "downloadListener");
        Integer numValueOf = targetMins != -1 ? Integer.valueOf(targetMins) : null;
        RestApi restApi = mRestApi;
        String str = this.mEncodedAuthorization;
        Integer id2 = station.getId();
        Intrinsics.checkNotNull(id2);
        sendRequest(restApi.downloadAndSync(str, String.valueOf(id2.intValue()), this.mOfflinePlacement, getClientIdCookie(), getFormatString(this.mAudioFormat), Integer.valueOf(this.maxBitrate), numValueOf, getFormatString(audioFileIds), this.testLocation), new WrappedCallback<SyncResponse>(this, downloadListener) { // from class: fm.feed.android.playersdk.FeedSession.downloadAndSync.1
            final /* synthetic */ StationDownloadListener $downloadListener;
            final /* synthetic */ FeedSession this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(this);
                this.this$0 = this;
                this.$downloadListener = downloadListener;
            }

            @Override // fm.feed.android.playersdk.FeedSession.WrappedCallback
            public void onSuccess(SyncResponse response) {
                Intrinsics.checkNotNullParameter(response, "response");
                if (response.getAudioFileList() != null) {
                    this.$station.setAudioFiles(response.getAudioFileList());
                    Iterator it = this.this$0.mEventListeners.iterator();
                    while (it.hasNext()) {
                        ((EventListener) it.next()).stationInfoAvailable(this.$station, this.$downloadListener);
                    }
                }
            }
        });
    }

    public final Object requestSession(Continuation<? super Boolean> continuation) throws Throwable {
        Call<SessionResponse> callCreateSession = mRestApi.createSession(this.mEncodedAuthorization, getClientIdCookie(), Boxing.boxInt(1), this.testLocation);
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        sendRequest(callCreateSession, new WrappedCallback<SessionResponse>() { // from class: fm.feed.android.playersdk.FeedSession$requestSession$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(this.this$0);
            }

            @Override // fm.feed.android.playersdk.FeedSession.WrappedCallback
            public void onSuccess(SessionResponse response) {
                Intrinsics.checkNotNullParameter(response, "response");
                Session session = response.getSession();
                List<Station> remoteOfflineStations = response.getRemoteOfflineStations();
                if (remoteOfflineStations != null) {
                    Iterator<Station> it = remoteOfflineStations.iterator();
                    while (it.hasNext()) {
                        it.next().setOfflineType(true);
                    }
                    FeedSession feedSession = this.this$0;
                    Placement offlinePlacement = response.getOfflinePlacement();
                    feedSession.mOfflinePlacement = offlinePlacement == null ? null : offlinePlacement.getId();
                    Iterator it2 = this.this$0.mEventListeners.iterator();
                    while (it2.hasNext()) {
                        ((FeedSession.EventListener) it2.next()).remoteOfflineStationListAvailable(remoteOfflineStations);
                    }
                }
                if (session == null || !session.getIsAvailable()) {
                    Iterator it3 = this.this$0.mEventListeners.iterator();
                    while (it3.hasNext()) {
                        ((FeedSession.EventListener) it3.next()).sessionNotAvailable(new Exception(session == null ? null : session.getMessage()));
                    }
                    Continuation<Boolean> continuation2 = safeContinuation2;
                    Result.Companion companion = Result.INSTANCE;
                    continuation2.resumeWith(Result.m9087constructorimpl(true));
                    return;
                }
                this.this$0.setLoggingEnabled(session.getLoggingEnabled());
                this.this$0.setLogEverything(session.getLogEverything());
                this.this$0.setClientId(session.getClientId());
                FeedSession feedSession2 = this.this$0;
                List<Station> stations = response.getStations();
                Intrinsics.checkNotNull(stations);
                feedSession2.stationList = stations;
                FeedSession feedSession3 = this.this$0;
                Placement placement = response.getPlacement();
                feedSession3.mPlacementId = placement == null ? null : placement.getId();
                Placement placement2 = response.getPlacement();
                if (placement2 != null && placement2.containsOption("crossfade_seconds")) {
                    this.this$0.setRemoteCrossfadeEnabled(true);
                    if (response.getPlacement().getOption("crossfade_seconds") instanceof Double) {
                        try {
                            FeedSession feedSession4 = this.this$0;
                            Object option = response.getPlacement().getOption("crossfade_seconds");
                            if (option != null) {
                                feedSession4.setRemoteCrossfadeTime((float) ((Double) option).doubleValue());
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
                            }
                        } catch (Exception e) {
                            FMLog.e$default(this.this$0.log, "Failed to parse remoteCrossfadeTime", null, 2, null);
                            e.printStackTrace();
                        }
                    } else if (response.getPlacement().getOption("crossfade_seconds") instanceof String) {
                        try {
                            FeedSession feedSession5 = this.this$0;
                            Object option2 = response.getPlacement().getOption("crossfade_seconds");
                            if (option2 != null) {
                                feedSession5.setRemoteCrossfadeTime(Float.parseFloat((String) option2));
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                        } catch (Exception e2) {
                            FMLog.e$default(this.this$0.log, "Failed to parse remoteCrossfadeTime", null, 2, null);
                            e2.printStackTrace();
                        }
                    } else if (response.getPlacement().getOption("crossfade_seconds") instanceof Integer) {
                        try {
                            FeedSession feedSession6 = this.this$0;
                            if (response.getPlacement().getOption("crossfade_seconds") != null) {
                                feedSession6.setRemoteCrossfadeTime(((Integer) r9).intValue());
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                            }
                        } catch (Exception e3) {
                            FMLog.e$default(this.this$0.log, "Failed to parse remoteCrossfadeTime", null, 2, null);
                            e3.printStackTrace();
                        }
                    }
                }
                this.this$0.mCurrentSession = session;
                if (this.this$0.getStationList().isEmpty()) {
                    FMLog.e$default(this.this$0.log, "no stations returned with station", null, 2, null);
                }
                Iterator it4 = this.this$0.mEventListeners.iterator();
                while (it4.hasNext()) {
                    FeedSession.EventListener eventListener = (FeedSession.EventListener) it4.next();
                    eventListener.stationListAvailable(this.this$0.getStationList());
                    eventListener.sessionAvailable();
                }
                Continuation<Boolean> continuation3 = safeContinuation2;
                Result.Companion companion2 = Result.INSTANCE;
                continuation3.resumeWith(Result.m9087constructorimpl(true));
            }

            @Override // fm.feed.android.playersdk.FeedSession.WrappedCallback
            public void onError(Throwable t) {
                Intrinsics.checkNotNullParameter(t, "t");
                Iterator it = this.this$0.mEventListeners.iterator();
                while (it.hasNext()) {
                    ((FeedSession.EventListener) it.next()).sessionNotAvailable(new Exception(t));
                }
                Continuation<Boolean> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m9087constructorimpl(false));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final void sendOfflineLogs(final JSONArray logs, final OfflineLogsListener listener) throws JSONException {
        Intrinsics.checkNotNullParameter(logs, "logs");
        try {
            JSONObject jSONObjectPut = new JSONObject().put("events", logs);
            Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "JSONObject().put(\"events\", logs)");
            RequestBody.Companion companion = RequestBody.INSTANCE;
            String string = jSONObjectPut.toString();
            Intrinsics.checkNotNullExpressionValue(string, "`object`.toString()");
            sendRequest(mRestApi.sendLogs(this.mEncodedAuthorization, getClientIdCookie(), companion.create(string, MediaType.INSTANCE.parse("application/json; charset=utf-8"))), false, new WrappedCallback<FeedFMResponse>() { // from class: fm.feed.android.playersdk.FeedSession.sendOfflineLogs.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(FeedSession.this);
                }

                @Override // fm.feed.android.playersdk.FeedSession.WrappedCallback
                public void onSuccess(FeedFMResponse response) {
                    Intrinsics.checkNotNullParameter(response, "response");
                    FMLog.i$default(FeedSession.this.log, response.toString(), null, 2, null);
                }

                @Override // fm.feed.android.playersdk.FeedSession.WrappedCallback
                public void onError(Throwable t) {
                    Intrinsics.checkNotNullParameter(t, "t");
                    FMLog.w$default(FeedSession.this.log, "Log storage failed", null, 2, null);
                    OfflineLogsListener offlineLogsListener = listener;
                    if (offlineLogsListener == null) {
                        return;
                    }
                    offlineLogsListener.offlineLogSaveFailed(logs);
                }
            });
        } catch (JSONException e) {
            FMLog.e$default(this.log, Intrinsics.stringPlus("Problem parsing offline logs ", e.getMessage()), null, 2, null);
        }
    }

    public final void addEventListener(EventListener eventListener) {
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        this.mEventListeners.add(eventListener);
    }

    public final boolean canRequestPlays() {
        if (this.mCurrentSession != null) {
            String str = this.mEncodedAuthorization;
            Intrinsics.checkNotNull(str);
            if (str.length() != 0) {
                return true;
            }
        }
        return false;
    }

    public final Object getNextPlayForStation(Station station, Continuation<? super Play> continuation) throws Throwable {
        if (this.mCurrentSession == null) {
            FMLog.e$default(this.log, "cannot request next item with no current session", null, 2, null);
            return null;
        }
        Call<PlayResponse> playWithID = mRestApi.getPlayWithID(this.mEncodedAuthorization, getClientIdCookie(), this.mPlacementId, null, station.getId(), getFormatString(getMAudioFormat()), Boxing.boxInt(getMaxBitrate()), null, null, Boxing.boxInt(1), this.testLocation);
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        sendRequest(playWithID, new WrappedCallback<PlayResponse>() { // from class: fm.feed.android.playersdk.FeedSession$getNextPlayForStation$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(this.this$0);
            }

            @Override // fm.feed.android.playersdk.FeedSession.WrappedCallback
            public void onSuccess(PlayResponse response) {
                Intrinsics.checkNotNullParameter(response, "response");
                if (response.getError() != null) {
                    if (response.getError().getCode() == ApiErrorEnum.END_OF_PLAYLIST.getCode()) {
                        FMLog.d$default(this.this$0.log, "end of playlist for a new station", null, 2, null);
                        Iterator it = this.this$0.mEventListeners.iterator();
                        while (it.hasNext()) {
                            ((FeedSession.EventListener) it.next()).noMoreMusic();
                        }
                        Continuation<Play> continuation2 = safeContinuation2;
                        Result.Companion companion = Result.INSTANCE;
                        continuation2.resumeWith(Result.m9087constructorimpl(null));
                        return;
                    }
                    FMLog.e$default(this.this$0.log, Intrinsics.stringPlus("unexpected error ", response.getError().getMessage()), null, 2, null);
                    Iterator it2 = this.this$0.mEventListeners.iterator();
                    while (it2.hasNext()) {
                        ((FeedSession.EventListener) it2.next()).unexpectedError(response.getError());
                    }
                    Continuation<Play> continuation3 = safeContinuation2;
                    Result.Companion companion2 = Result.INSTANCE;
                    continuation3.resumeWith(Result.m9087constructorimpl(null));
                    return;
                }
                Play play = response.getPlay();
                if (play == null) {
                    FMLog.e$default(this.this$0.log, "returned play was null!", null, 2, null);
                    Exception exc = new Exception("Next play was null");
                    Iterator it3 = this.this$0.mEventListeners.iterator();
                    while (it3.hasNext()) {
                        ((FeedSession.EventListener) it3.next()).unexpectedError(exc);
                    }
                    Continuation<Play> continuation4 = safeContinuation2;
                    Result.Companion companion3 = Result.INSTANCE;
                    continuation4.resumeWith(Result.m9087constructorimpl(null));
                    return;
                }
                FMLog.d$default(this.this$0.log, Intrinsics.stringPlus("Got new play", response.getPlay()), null, 2, null);
                Continuation<Play> continuation5 = safeContinuation2;
                Result.Companion companion4 = Result.INSTANCE;
                continuation5.resumeWith(Result.m9087constructorimpl(play));
            }

            @Override // fm.feed.android.playersdk.FeedSession.WrappedCallback
            public void onError(Throwable t) {
                Intrinsics.checkNotNullParameter(t, "t");
                String message = t.getMessage();
                if (message != null) {
                    FeedSession feedSession = this.this$0;
                    String str = message;
                    if (StringsKt.contains((CharSequence) str, (CharSequence) "This station may not be played more than once", true) || StringsKt.contains((CharSequence) str, (CharSequence) "End of available music", true) || StringsKt.contains((CharSequence) str, (CharSequence) "Either no songs match requested format/bitrate", true)) {
                        FMLog.d$default(feedSession.log, "end of playlist for a station", null, 2, null);
                        Iterator it = feedSession.mEventListeners.iterator();
                        while (it.hasNext()) {
                            ((FeedSession.EventListener) it.next()).noMoreMusic();
                        }
                    } else {
                        FMLog.e$default(feedSession.log, Intrinsics.stringPlus("unexpected error ", message), null, 2, null);
                        Iterator it2 = feedSession.mEventListeners.iterator();
                        while (it2.hasNext()) {
                            ((FeedSession.EventListener) it2.next()).unexpectedError(new Exception(t));
                        }
                    }
                }
                Continuation<Play> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m9087constructorimpl(null));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public static /* synthetic */ Object requestAudioFile$default(FeedSession feedSession, Station station, AudioFile audioFile, Float f, Float f2, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            f = null;
        }
        return feedSession.requestAudioFile(station, audioFile, f, f2, continuation);
    }

    public final Object requestAudioFile(Station station, AudioFile audioFile, Float f, Float f2, Continuation<? super Play> continuation) throws Throwable {
        if (this.mCurrentSession == null) {
            FMLog.e$default(this.log, "cannot request next item with no current session", null, 2, null);
            return null;
        }
        if (this.mNextPlayInProgress) {
            FMLog.d$default(this.log, "next item request already in progress", null, 2, null);
            return null;
        }
        this.mNextPlayInProgress = true;
        Call<PlayResponse> playWithID = mRestApi.getPlayWithID(this.mEncodedAuthorization, getClientIdCookie(), this.mPlacementId, audioFile == null ? null : audioFile.getId(), station != null ? station.getId() : null, getFormatString(getMAudioFormat()), Boxing.boxInt(getMaxBitrate()), f, f2, Boxing.boxInt(1), this.testLocation);
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        sendRequest(playWithID, new WrappedCallback<PlayResponse>() { // from class: fm.feed.android.playersdk.FeedSession$requestAudioFile$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(this.this$0);
            }

            @Override // fm.feed.android.playersdk.FeedSession.WrappedCallback
            public void onSuccess(PlayResponse response) {
                Float start;
                Intrinsics.checkNotNullParameter(response, "response");
                this.this$0.mNextPlayInProgress = false;
                Play play = response.getPlay();
                if (play != null && (start = play.getStart()) != null) {
                    float fFloatValue = start.floatValue();
                    Map<String, Object> metadata = response.getPlay().getAudioFile().getMetadata();
                    if (metadata != null) {
                        metadata.put("trim_start", Float.valueOf(fFloatValue));
                    }
                }
                FMLog.e$default(this.this$0.log, String.valueOf(response.getPlay()), null, 2, null);
                Continuation<Play> continuation2 = safeContinuation2;
                Play play2 = response.getPlay();
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m9087constructorimpl(play2));
            }

            @Override // fm.feed.android.playersdk.FeedSession.WrappedCallback
            public void onError(Throwable t) {
                Intrinsics.checkNotNullParameter(t, "t");
                if (t instanceof FeedSession.CancelledRequest) {
                    FMLog.d$default(this.this$0.log, "audio file request cancelled", null, 2, null);
                    return;
                }
                this.this$0.mNextPlayInProgress = false;
                if (!(t instanceof FeedFMError) || ((FeedFMError) t).getCode() != ApiErrorEnum.END_OF_PLAYLIST.getCode()) {
                    FMLog.e$default(this.this$0.log, Intrinsics.stringPlus("error while retrieving next play: ", t), null, 2, null);
                } else {
                    FMLog.d$default(this.this$0.log, "end of playlist", null, 2, null);
                    Iterator it = this.this$0.mEventListeners.iterator();
                    while (it.hasNext()) {
                        ((FeedSession.EventListener) it.next()).noMoreMusic();
                    }
                }
                Continuation<Play> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m9087constructorimpl(null));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    private final String getFormatString(List<String> stringList) {
        StringBuilder sb = new StringBuilder();
        int size = stringList.size() - 1;
        if (size >= 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                sb.append(stringList.get(i));
                sb.append(",");
                if (i2 > size) {
                    break;
                }
                i = i2;
            }
        }
        int iLastIndexOf = sb.lastIndexOf(",");
        if (iLastIndexOf == -1) {
            return null;
        }
        sb.deleteCharAt(iLastIndexOf);
        return sb.toString();
    }

    public final Object playStarted(Station station, Play play, long j, int i, Continuation<? super Boolean> continuation) throws Throwable {
        FMLog.d$default(this.log, Intrinsics.stringPlus("Play ID Started = ", play), null, 2, null);
        if (station != null) {
            station.setLastPlayStart(new Date());
        }
        for (Station station2 : getStationList()) {
            if (Intrinsics.areEqual(station2, station)) {
                station2.setLastPlayStart(new Date());
            }
        }
        Integer numBoxInt = i >= 0 ? Boxing.boxInt(i) : null;
        Call<PlayStartResponse> callPlayStarted = mRestApi.playStarted(this.mEncodedAuthorization, getClientIdCookie(), play.getId(), j >= 0 ? Boxing.boxInt((int) j) : null, numBoxInt, Boxing.boxInt(1), this.testLocation);
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        sendRequest(callPlayStarted, new WrappedCallback<PlayStartResponse>() { // from class: fm.feed.android.playersdk.FeedSession$playStarted$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(this.this$0);
            }

            @Override // fm.feed.android.playersdk.FeedSession.WrappedCallback
            public void onSuccess(PlayStartResponse response) {
                Intrinsics.checkNotNullParameter(response, "response");
                if (response.getIsSuccess()) {
                    if (response.getError() != null) {
                        Iterator it = this.this$0.mEventListeners.iterator();
                        while (it.hasNext()) {
                            ((FeedSession.EventListener) it.next()).unexpectedError(response.getError());
                        }
                    }
                    if (response.getCanSkip() != this.this$0.mCanSkipCurrent) {
                        this.this$0.mCanSkipCurrent = response.getCanSkip();
                        Iterator it2 = this.this$0.mEventListeners.iterator();
                        while (it2.hasNext()) {
                            ((FeedSession.EventListener) it2.next()).skipStatusDidChange(this.this$0.mCanSkipCurrent);
                        }
                    }
                    Continuation<Boolean> continuation2 = safeContinuation2;
                    Result.Companion companion = Result.INSTANCE;
                    continuation2.resumeWith(Result.m9087constructorimpl(true));
                    return;
                }
                Continuation<Boolean> continuation3 = safeContinuation2;
                Result.Companion companion2 = Result.INSTANCE;
                continuation3.resumeWith(Result.m9087constructorimpl(false));
            }

            @Override // fm.feed.android.playersdk.FeedSession.WrappedCallback
            public void onError(Throwable t) {
                Intrinsics.checkNotNullParameter(t, "t");
                super.onError(t);
                Continuation<Boolean> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m9087constructorimpl(false));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final void updatePlayTime(Play play, Float elapsedTime) {
        Intrinsics.checkNotNullParameter(play, "play");
        sendRequest(mRestApi.elapsed(this.mEncodedAuthorization, play.getId(), elapsedTime, getClientIdCookie(), Float.valueOf(play.getAudioFile().getDurationInSeconds()), 1, this.testLocation), false, new WrappedCallback<FeedFMResponse>() { // from class: fm.feed.android.playersdk.FeedSession.updatePlayTime.1
            @Override // fm.feed.android.playersdk.FeedSession.WrappedCallback
            public void onError(Throwable t) {
                Intrinsics.checkNotNullParameter(t, "t");
            }

            @Override // fm.feed.android.playersdk.FeedSession.WrappedCallback
            public void onSuccess(FeedFMResponse response) {
                Intrinsics.checkNotNullParameter(response, "response");
            }

            {
                super(FeedSession.this);
            }
        });
    }

    public final void playCompleted(Play play, float timePlayed) {
        Intrinsics.checkNotNullParameter(play, "play");
        String id2 = play.getId();
        FMLog.d$default(this.log, Intrinsics.stringPlus("Play ID completed = ", play), null, 2, null);
        sendRequest(mRestApi.playCompleted(this.mEncodedAuthorization, getClientIdCookie(), id2, Float.valueOf(timePlayed), 1, this.testLocation), false, new WrappedCallback<FeedFMResponse>() { // from class: fm.feed.android.playersdk.FeedSession.playCompleted.1
            @Override // fm.feed.android.playersdk.FeedSession.WrappedCallback
            public void onError(Throwable t) {
                Intrinsics.checkNotNullParameter(t, "t");
            }

            @Override // fm.feed.android.playersdk.FeedSession.WrappedCallback
            public void onSuccess(FeedFMResponse response) {
                Intrinsics.checkNotNullParameter(response, "response");
            }

            {
                super(FeedSession.this);
            }
        });
    }

    public final void requestSkip(Play play, float elapsedTime, SkipRequestListener skipRequestListener) {
        Intrinsics.checkNotNullParameter(play, "play");
        Intrinsics.checkNotNullParameter(skipRequestListener, "skipRequestListener");
        sendRequest(mRestApi.skip(this.mEncodedAuthorization, play.getId(), Float.valueOf(elapsedTime), getClientIdCookie(), 1, 0, this.testLocation), new WrappedCallback<FeedFMResponse>(this) { // from class: fm.feed.android.playersdk.FeedSession.requestSkip.1
            final /* synthetic */ FeedSession this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(this);
                this.this$0 = this;
            }

            @Override // fm.feed.android.playersdk.FeedSession.WrappedCallback
            public void onSuccess(FeedFMResponse response) {
                Intrinsics.checkNotNullParameter(response, "response");
                this.$skipRequestListener.onSuccess();
            }

            @Override // fm.feed.android.playersdk.FeedSession.WrappedCallback
            public void onError(Throwable t) {
                Intrinsics.checkNotNullParameter(t, "t");
                if ((t instanceof FeedFMError) && ((FeedFMError) t).getCode() == ApiErrorEnum.SKIP_LIMIT_REACHED.getCode()) {
                    this.this$0.mCanSkipCurrent = false;
                }
                this.$skipRequestListener.onFailure(new Exception(t.getMessage()));
            }
        });
    }

    public final Object rejectPlay(Play play, String str, Continuation<? super Boolean> continuation) throws Throwable {
        Call<FeedFMResponse> callInvalidate = mRestApi.invalidate(this.mEncodedAuthorization, play.getId(), getClientIdCookie(), str, Boxing.boxInt(1), this.testLocation);
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        sendRequest(callInvalidate, new WrappedCallback<FeedFMResponse>(safeContinuation2, this) { // from class: fm.feed.android.playersdk.FeedSession$rejectPlay$2$1
            final /* synthetic */ Continuation<Boolean> $continuation;
            final /* synthetic */ FeedSession this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(this);
                this.this$0 = this;
            }

            @Override // fm.feed.android.playersdk.FeedSession.WrappedCallback
            public void onSuccess(FeedFMResponse response) {
                Intrinsics.checkNotNullParameter(response, "response");
                if (response.getIsSuccess()) {
                    Continuation<Boolean> continuation2 = this.$continuation;
                    Result.Companion companion = Result.INSTANCE;
                    continuation2.resumeWith(Result.m9087constructorimpl(true));
                } else {
                    Continuation<Boolean> continuation3 = this.$continuation;
                    Result.Companion companion2 = Result.INSTANCE;
                    continuation3.resumeWith(Result.m9087constructorimpl(false));
                }
            }

            @Override // fm.feed.android.playersdk.FeedSession.WrappedCallback
            public void onError(Throwable t) {
                Intrinsics.checkNotNullParameter(t, "t");
                super.onError(t);
                Continuation<Boolean> continuation2 = this.$continuation;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m9087constructorimpl(false));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final void requestLike(Play play) {
        Intrinsics.checkNotNullParameter(play, "play");
        requestLike("play", play.getId());
    }

    public final void requestLike(AudioFile audioFile) {
        Intrinsics.checkNotNullParameter(audioFile, "audioFile");
        requestLike("audio_file", audioFile.getId());
    }

    private final void requestLike(String type, String id2) {
        sendRequest(mRestApi.like(this.mEncodedAuthorization, getClientIdCookie(), type, id2, 1), false, new WrappedCallback<FeedFMResponse>() { // from class: fm.feed.android.playersdk.FeedSession.requestLike.1
            @Override // fm.feed.android.playersdk.FeedSession.WrappedCallback
            public void onError(Throwable t) {
                Intrinsics.checkNotNullParameter(t, "t");
            }

            @Override // fm.feed.android.playersdk.FeedSession.WrappedCallback
            public void onSuccess(FeedFMResponse response) {
                Intrinsics.checkNotNullParameter(response, "response");
            }

            {
                super(FeedSession.this);
            }
        });
    }

    public final void requestUnlike(Play play) {
        Intrinsics.checkNotNullParameter(play, "play");
        requestUnlike("play", play.getId());
    }

    public final void requestUnlike(AudioFile audioFile) {
        Intrinsics.checkNotNullParameter(audioFile, "audioFile");
        requestUnlike("audio_file", audioFile.getId());
    }

    public final void requestUnlike(String type, String id2) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(id2, "id");
        sendRequest(mRestApi.unlike(this.mEncodedAuthorization, getClientIdCookie(), type, id2, 1), false, new WrappedCallback<FeedFMResponse>() { // from class: fm.feed.android.playersdk.FeedSession.requestUnlike.1
            @Override // fm.feed.android.playersdk.FeedSession.WrappedCallback
            public void onError(Throwable t) {
                Intrinsics.checkNotNullParameter(t, "t");
            }

            @Override // fm.feed.android.playersdk.FeedSession.WrappedCallback
            public void onSuccess(FeedFMResponse response) {
                Intrinsics.checkNotNullParameter(response, "response");
            }

            {
                super(FeedSession.this);
            }
        });
    }

    public final void requestDislikeForItem(Play play) {
        Intrinsics.checkNotNullParameter(play, "play");
        requestDislike("play", play.getId());
    }

    public final void requestDislike(AudioFile audioFile) {
        Intrinsics.checkNotNullParameter(audioFile, "audioFile");
        requestDislike("audio_file", audioFile.getId());
    }

    public final void requestDislike(String type, String id2) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(id2, "id");
        sendRequest(mRestApi.dislike(this.mEncodedAuthorization, getClientIdCookie(), type, id2, 1), false, new WrappedCallback<FeedFMResponse>() { // from class: fm.feed.android.playersdk.FeedSession.requestDislike.1
            @Override // fm.feed.android.playersdk.FeedSession.WrappedCallback
            public void onError(Throwable t) {
                Intrinsics.checkNotNullParameter(t, "t");
            }

            @Override // fm.feed.android.playersdk.FeedSession.WrappedCallback
            public void onSuccess(FeedFMResponse response) {
                Intrinsics.checkNotNullParameter(response, "response");
            }

            {
                super(FeedSession.this);
            }
        });
    }

    /* renamed from: canSkip, reason: from getter */
    public final boolean getMCanSkipCurrent() {
        return this.mCanSkipCurrent;
    }

    public final void setClientTokenAndSecret(String token, String secret) {
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(secret, "secret");
        String str = token + ':' + secret;
        Charset charset = Charsets.UTF_8;
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = str.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        String strEncodeToString = Base64.encodeToString(bytes, 2);
        this.mEncodedAuthorization = strEncodeToString;
        Intrinsics.checkNotNull(strEncodeToString);
        this.mEncodedAuthorization = Intrinsics.stringPlus("Basic ", strEncodeToString);
    }

    public final void logEvent(String event, Object parameters) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        sendRequest(mRestApi.logEvent(this.mEncodedAuthorization, getClientIdCookie(), event, new Gson().toJson(parameters), 1, this.testLocation), false, new WrappedCallback<FeedFMResponse>() { // from class: fm.feed.android.playersdk.FeedSession.logEvent.1
            {
                super(FeedSession.this);
            }

            @Override // fm.feed.android.playersdk.FeedSession.WrappedCallback
            public void onSuccess(FeedFMResponse response) {
                Intrinsics.checkNotNullParameter(response, "response");
                FMLog.v$default(FeedSession.this.log, response.toString(), null, 2, null);
            }

            @Override // fm.feed.android.playersdk.FeedSession.WrappedCallback
            public void onError(Throwable t) {
                Intrinsics.checkNotNullParameter(t, "t");
                FMLog.v$default(FeedSession.this.log, t.toString(), null, 2, null);
            }
        });
    }

    public final void logEvent(String event) {
        Intrinsics.checkNotNullParameter(event, "event");
        sendRequest(mRestApi.logEvent(this.mEncodedAuthorization, getClientIdCookie(), event, 1, this.testLocation), false, new WrappedCallback<FeedFMResponse>() { // from class: fm.feed.android.playersdk.FeedSession.logEvent.2
            @Override // fm.feed.android.playersdk.FeedSession.WrappedCallback
            public void onError(Throwable t) {
                Intrinsics.checkNotNullParameter(t, "t");
            }

            @Override // fm.feed.android.playersdk.FeedSession.WrappedCallback
            public void onSuccess(FeedFMResponse response) {
                Intrinsics.checkNotNullParameter(response, "response");
            }

            {
                super(FeedSession.this);
            }
        });
    }

    public final void reset() {
        cancelOutstandingRequests();
    }

    public final void resetSessionToNull() {
        reset();
        this.mCurrentSession = null;
    }

    /* compiled from: FeedSession.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004J\u0018\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lfm/feed/android/playersdk/FeedSession$Companion;", "", "()V", "AUDIO_FORMAT_AAC", "", "AUDIO_FORMAT_M4A", "AUDIO_FORMAT_MP3", "CLIENT_ID", "FORCE_CODE", "", "mRestApi", "Lfm/feed/android/playersdk/RestApi;", "changeBaseURL", "", "url", "persistClientId", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "clientId", "resetClientId", "retrieveClientId", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void changeBaseURL(String url) throws SecurityException {
            Intrinsics.checkNotNullParameter(url, "url");
            RestApi.Companion companion = RestApi.INSTANCE;
            Retrofit retrofitBuild = new Retrofit.Builder().client(RestApi.INSTANCE.getOkHttpClient()).baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
            Intrinsics.checkNotNullExpressionValue(retrofitBuild, "Builder()\n              …                 .build()");
            companion.setRetrofit(retrofitBuild);
            Object objCreate = RestApi.INSTANCE.getRetrofit().create(RestApi.class);
            Intrinsics.checkNotNullExpressionValue(objCreate, "RestApi.retrofit.create(RestApi::class.java)");
            FeedSession.mRestApi = (RestApi) objCreate;
        }

        public final String retrieveClientId(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return context.getSharedPreferences("FeedSession", 0).getString(FeedSession.CLIENT_ID, null);
        }

        public final void persistClientId(Context context, String clientId) {
            Intrinsics.checkNotNullParameter(context, "context");
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("FeedSession", 0).edit();
            if (clientId == null) {
                editorEdit.remove(FeedSession.CLIENT_ID);
            } else {
                editorEdit.putString(FeedSession.CLIENT_ID, clientId);
            }
            editorEdit.apply();
        }

        public final void resetClientId(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            persistClientId(context, null);
        }
    }

    static {
        Object objCreate = RestApi.INSTANCE.getRetrofit().create(RestApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "RestApi.retrofit.create(RestApi::class.java)");
        mRestApi = (RestApi) objCreate;
    }
}
