package fm.feed.android.playersdk;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.android.SdkConstants;
import com.facebook.internal.ServerProtocol;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import fm.feed.android.playersdk.PlayerProxy;
import fm.feed.android.playersdk.models.Play;
import fm.feed.android.playersdk.models.webservice.PlayResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* compiled from: ExoSimulcastAudioPlayer.kt */
@Metadata(d1 = {"\u0000\u0089\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b*\u00014\b\u0000\u0018\u0000 J2\u00020\u0001:\u0001JB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010=\u001a\u00020>H\u0002J\u0010\u0010?\u001a\u00020@2\u0006\u00108\u001a\u00020\u0007H\u0002J\u0010\u0010A\u001a\u00020&2\u0006\u0010B\u001a\u00020CH\u0002J\b\u0010\r\u001a\u00020>H\u0002J\u0006\u0010\n\u001a\u00020>J\b\u0010D\u001a\u00020>H\u0002J\u0010\u0010E\u001a\u00020>2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u000e\u0010F\u001a\u00020>2\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010G\u001a\u00020>J\u0010\u0010H\u001a\u00020>2\u0006\u0010I\u001a\u00020.H\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010'\u001a\u00020(X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0010\u00103\u001a\u000204X\u0082\u0004¢\u0006\u0004\n\u0002\u00105R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u000e\u00108\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R$\u00109\u001a\u00020\u00122\u0006\u00109\u001a\u00020\u0012@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0015\"\u0004\b;\u0010<¨\u0006K"}, d2 = {"Lfm/feed/android/playersdk/ExoSimulcastAudioPlayer;", "", "mContext", "Landroid/content/Context;", "looper", "Landroid/os/Looper;", "token", "", "(Landroid/content/Context;Landroid/os/Looper;Ljava/lang/String;)V", "clientId", "play", "Lfm/feed/android/playersdk/models/Play;", "currentPlay", "getCurrentPlay", "()Lfm/feed/android/playersdk/models/Play;", "setCurrentPlay", "(Lfm/feed/android/playersdk/models/Play;)V", "<set-?>", "", "currentTime", "getCurrentTime", "()F", "errorCount", "", "eventListener", "Lfm/feed/android/playersdk/SimulcastEventListener;", "fetchTimeInMs", "", "lastConfirmedTrackPlayTimeByServerInSeconds", "log", "Lfm/feed/android/playersdk/FMLog;", "getLooper", "()Landroid/os/Looper;", "mMainHandler", "Landroid/os/Handler;", "mSimulcastApi", "Lfm/feed/android/playersdk/SimulcastApi;", "playFetchFlag", "", "player", "Lcom/google/android/exoplayer2/ExoPlayer;", "getPlayer$PlayerSdk_exoDefaultRelease", "()Lcom/google/android/exoplayer2/ExoPlayer;", "setPlayer$PlayerSdk_exoDefaultRelease", "(Lcom/google/android/exoplayer2/ExoPlayer;)V", "playerState", "Lfm/feed/android/playersdk/SimulcastPlaybackState;", "getPlayerState", "()Lfm/feed/android/playersdk/SimulcastPlaybackState;", "setPlayerState", "(Lfm/feed/android/playersdk/SimulcastPlaybackState;)V", "primaryEventListener", "fm/feed/android/playersdk/ExoSimulcastAudioPlayer$primaryEventListener$1", "Lfm/feed/android/playersdk/ExoSimulcastAudioPlayer$primaryEventListener$1;", "getToken", "()Ljava/lang/String;", "url", "volume", "getVolume", "setVolume", "(F)V", "checkUpdateNeeded", "", "createMediaSource", "Lcom/google/android/exoplayer2/source/MediaSource;", "enThread", SdkConstants.FD_RES_CLASS, "Ljava/lang/Runnable;", "processUpdate", "setCurrentTime", "setEventListener", "stop", "updateToState", ServerProtocol.DIALOG_PARAM_STATE, "Companion", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class ExoSimulcastAudioPlayer {
    private String clientId;
    private Play currentPlay;
    private float currentTime;
    private int errorCount;
    private SimulcastEventListener eventListener;
    private long fetchTimeInMs;
    private float lastConfirmedTrackPlayTimeByServerInSeconds;
    private final FMLog log;
    private final Looper looper;
    private final Context mContext;
    private Handler mMainHandler;
    private final SimulcastApi mSimulcastApi;
    private boolean playFetchFlag;
    private ExoPlayer player;
    private SimulcastPlaybackState playerState;
    private final ExoSimulcastAudioPlayer$primaryEventListener$1 primaryEventListener;
    private final String token;
    private final String url;
    private float volume;
    private static final int UPDATE_MESSAGE = 1;
    private static final int CANCEL_MESSAGE = 2;
    private static final int UPDATE_INTERVAL = 500;

    /* JADX WARN: Type inference failed for: r3v7, types: [fm.feed.android.playersdk.ExoSimulcastAudioPlayer$primaryEventListener$1] */
    public ExoSimulcastAudioPlayer(Context mContext, Looper looper, String token) throws SecurityException {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(looper, "looper");
        Intrinsics.checkNotNullParameter(token, "token");
        this.mContext = mContext;
        this.looper = looper;
        this.token = token;
        this.player = PlayerProxy.INSTANCE.createSimpleExoplayer(mContext, looper);
        this.playerState = SimulcastPlaybackState.Idle;
        this.log = new FMLog("fm.feed.ExoSimulcastAudioPlayer");
        Object objCreate = SimulcastApi.INSTANCE.getRetrofit().create(SimulcastApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "SimulcastApi.retrofit.cr…SimulcastApi::class.java)");
        this.mSimulcastApi = (SimulcastApi) objCreate;
        this.clientId = FeedSession.INSTANCE.retrieveClientId(mContext);
        this.url = SimulcastApi.INSTANCE.getRetrofit().baseUrl() + token;
        this.volume = 1.0f;
        this.primaryEventListener = new PlayerProxy.ExoEventListener() { // from class: fm.feed.android.playersdk.ExoSimulcastAudioPlayer$primaryEventListener$1
            @Override // fm.feed.android.playersdk.PlayerProxy.ExoEventListener
            public void onLoadingChanged(boolean isLoading) {
            }

            @Override // fm.feed.android.playersdk.PlayerProxy.ExoEventListener
            public void onSeekProcessed() {
            }

            @Override // fm.feed.android.playersdk.PlayerProxy.ExoEventListener
            public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
                if (playWhenReady && playbackState == 3) {
                    Handler handler = this.this$0.mMainHandler;
                    if (handler == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mMainHandler");
                        handler = null;
                    }
                    handler.sendEmptyMessageDelayed(ExoSimulcastAudioPlayer.UPDATE_MESSAGE, ExoSimulcastAudioPlayer.UPDATE_INTERVAL);
                    this.this$0.updateToState(SimulcastPlaybackState.Playing);
                    this.this$0.errorCount = 0;
                    return;
                }
                if (playbackState == 3) {
                    return;
                }
                if (playbackState == 2) {
                    this.this$0.updateToState(SimulcastPlaybackState.Stalled);
                } else if (playbackState == 1) {
                    this.this$0.updateToState(SimulcastPlaybackState.Stopped);
                } else if (playbackState == 4) {
                    this.this$0.updateToState(SimulcastPlaybackState.Idle);
                }
            }

            @Override // fm.feed.android.playersdk.PlayerProxy.ExoEventListener
            public void onPlayerError(ExoPlaybackException error) {
                SimulcastEventListener simulcastEventListener;
                if (error == null || this.this$0.errorCount >= 3) {
                    if (error == null || (simulcastEventListener = this.this$0.eventListener) == null) {
                        return;
                    }
                    simulcastEventListener.onPlayerError(error);
                    return;
                }
                FMLog fMLog = this.this$0.log;
                error.printStackTrace();
                FMLog.e$default(fMLog, Unit.INSTANCE, null, 2, null);
                this.this$0.play();
                this.this$0.errorCount++;
            }
        };
        updateToState(SimulcastPlaybackState.Idle);
        this.mMainHandler = new Handler(looper) { // from class: fm.feed.android.playersdk.ExoSimulcastAudioPlayer.1
            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                Intrinsics.checkNotNullParameter(msg, "msg");
                int i = msg.what;
                if (i == ExoSimulcastAudioPlayer.UPDATE_MESSAGE) {
                    ExoSimulcastAudioPlayer.this.processUpdate();
                    removeMessages(ExoSimulcastAudioPlayer.UPDATE_MESSAGE);
                    sendEmptyMessageDelayed(ExoSimulcastAudioPlayer.UPDATE_MESSAGE, ExoSimulcastAudioPlayer.UPDATE_INTERVAL);
                } else if (i == ExoSimulcastAudioPlayer.CANCEL_MESSAGE) {
                    removeMessages(ExoSimulcastAudioPlayer.UPDATE_MESSAGE);
                }
            }
        };
    }

    public final Looper getLooper() {
        return this.looper;
    }

    public final String getToken() {
        return this.token;
    }

    /* renamed from: getPlayer$PlayerSdk_exoDefaultRelease, reason: from getter */
    public final ExoPlayer getPlayer() {
        return this.player;
    }

    public final void setPlayer$PlayerSdk_exoDefaultRelease(ExoPlayer exoPlayer) {
        Intrinsics.checkNotNullParameter(exoPlayer, "<set-?>");
        this.player = exoPlayer;
    }

    public final SimulcastPlaybackState getPlayerState() {
        return this.playerState;
    }

    public final void setPlayerState(SimulcastPlaybackState simulcastPlaybackState) {
        Intrinsics.checkNotNullParameter(simulcastPlaybackState, "<set-?>");
        this.playerState = simulcastPlaybackState;
    }

    public final float getCurrentTime() {
        return this.currentTime;
    }

    public final float getVolume() {
        return this.volume;
    }

    public final void setVolume(float f) {
        this.volume = f;
        PlayerProxy.INSTANCE.setVolume(this.player, f);
    }

    public final Play getCurrentPlay() {
        return this.currentPlay;
    }

    public final void setCurrentPlay(Play play) {
        FMLog.d$default(this.log, "Setting new play", null, 2, null);
        this.playFetchFlag = false;
        if (play == null) {
            return;
        }
        if (getCurrentPlay() != null) {
            Play currentPlay = getCurrentPlay();
            if (Intrinsics.areEqual(currentPlay == null ? null : currentPlay.getAudioFile(), play.getAudioFile())) {
                this.currentPlay = play;
                this.fetchTimeInMs = System.currentTimeMillis();
                setCurrentTime(play.getElapsedSeconds());
                return;
            }
        }
        this.fetchTimeInMs = System.currentTimeMillis();
        this.currentPlay = play;
        setCurrentTime(play.getElapsedSeconds());
        FMLog.d$default(this.log, Intrinsics.stringPlus("Set new play ", play), null, 2, null);
        SimulcastEventListener simulcastEventListener = this.eventListener;
        if (simulcastEventListener == null) {
            return;
        }
        simulcastEventListener.onPlayItemBeganPlayback(play);
    }

    public final void setEventListener(SimulcastEventListener eventListener) {
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        this.eventListener = eventListener;
    }

    private final void setCurrentTime(float currentTime) {
        this.lastConfirmedTrackPlayTimeByServerInSeconds = currentTime;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void processUpdate() {
        FMLog.d$default(this.log, "Processing update", null, 2, null);
        checkUpdateNeeded();
        this.currentTime = this.lastConfirmedTrackPlayTimeByServerInSeconds + (((int) (System.currentTimeMillis() - this.fetchTimeInMs)) / 1000);
        Play play = this.currentPlay;
        if (play == null) {
            return;
        }
        FMLog.d$default(this.log, "Calling progress", null, 2, null);
        SimulcastEventListener simulcastEventListener = this.eventListener;
        if (simulcastEventListener == null) {
            return;
        }
        simulcastEventListener.onProgressUpdate(play, getCurrentTime(), play.getAudioFile().getDurationInSeconds());
    }

    private final void checkUpdateNeeded() {
        if (this.currentPlay != null && getCurrentTime() - this.lastConfirmedTrackPlayTimeByServerInSeconds > 10.0f && !this.playFetchFlag) {
            getCurrentPlay();
            this.playFetchFlag = true;
        }
        if (this.currentPlay == null) {
            getCurrentPlay();
        }
        if (this.currentPlay == null) {
            getCurrentPlay();
            this.playFetchFlag = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateToState(SimulcastPlaybackState state) {
        if (this.playerState != state) {
            this.playerState = state;
            SimulcastEventListener simulcastEventListener = this.eventListener;
            if (simulcastEventListener == null) {
                return;
            }
            simulcastEventListener.onPlayerStateChanged(state);
        }
    }

    private final MediaSource createMediaSource(String url) {
        Context context = this.mContext;
        ProgressiveMediaSource progressiveMediaSourceCreateMediaSource = new ProgressiveMediaSource.Factory(new DefaultDataSourceFactory(context, Util.getUserAgent(context, "FeedAndroidSdk")), new DefaultExtractorsFactory()).createMediaSource(Uri.parse(url));
        Intrinsics.checkNotNullExpressionValue(progressiveMediaSourceCreateMediaSource, "extractorsMSFactory.crea…diaSource(Uri.parse(url))");
        return progressiveMediaSourceCreateMediaSource;
    }

    private final boolean enThread(Runnable r) {
        Handler handler = this.mMainHandler;
        if (handler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMainHandler");
            handler = null;
        }
        if (Intrinsics.areEqual(handler.getLooper(), Looper.myLooper())) {
            return false;
        }
        Handler handler2 = this.mMainHandler;
        if (handler2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMainHandler");
            handler2 = null;
        }
        handler2.post(r);
        FMLog.v$default(this.log, "Switching thread to main for this call", null, 2, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: play$lambda-3, reason: not valid java name */
    public static final void m8772play$lambda3(ExoSimulcastAudioPlayer this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.play();
    }

    public final void play() {
        if (enThread(new Runnable() { // from class: fm.feed.android.playersdk.ExoSimulcastAudioPlayer$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                ExoSimulcastAudioPlayer.m8772play$lambda3(this.f$0);
            }
        })) {
            return;
        }
        getCurrentPlay();
        this.player.prepare(createMediaSource(this.url));
        this.player.setPlayWhenReady(true);
        this.player.addListener(new PlayerProxy(this.primaryEventListener).getExoListener());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: stop$lambda-4, reason: not valid java name */
    public static final void m8773stop$lambda4(ExoSimulcastAudioPlayer this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.stop();
    }

    public final void stop() {
        if (enThread(new Runnable() { // from class: fm.feed.android.playersdk.ExoSimulcastAudioPlayer$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ExoSimulcastAudioPlayer.m8773stop$lambda4(this.f$0);
            }
        })) {
            return;
        }
        Handler handler = this.mMainHandler;
        if (handler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMainHandler");
            handler = null;
        }
        handler.sendEmptyMessageDelayed(CANCEL_MESSAGE, UPDATE_INTERVAL);
        this.player.stop();
        updateToState(SimulcastPlaybackState.Idle);
    }

    private final void getCurrentPlay() {
        this.mSimulcastApi.simulcastGetPlay(Intrinsics.stringPlus("cid=", this.clientId), this.token).enqueue(new Callback<PlayResponse>() { // from class: fm.feed.android.playersdk.ExoSimulcastAudioPlayer.getCurrentPlay.1
            @Override // retrofit2.Callback
            public void onResponse(Call<PlayResponse> call, Response<PlayResponse> response) {
                String strString;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (response.isSuccessful()) {
                    PlayResponse playResponseBody = response.body();
                    if (playResponseBody == null) {
                        return;
                    }
                    ExoSimulcastAudioPlayer exoSimulcastAudioPlayer = ExoSimulcastAudioPlayer.this;
                    if (!playResponseBody.getIsSuccess()) {
                        FMLog.e$default(exoSimulcastAudioPlayer.log, "Server returned an error", null, 2, null);
                        FMLog.e$default(exoSimulcastAudioPlayer.log, String.valueOf(playResponseBody.getError()), null, 2, null);
                        return;
                    } else if (playResponseBody.getPlay() == null) {
                        FMLog.e$default(exoSimulcastAudioPlayer.log, "Server did not return a play object", null, 2, null);
                        return;
                    } else {
                        exoSimulcastAudioPlayer.setCurrentPlay(playResponseBody.getPlay());
                        FMLog.d$default(exoSimulcastAudioPlayer.log, Intrinsics.stringPlus("Got play ", exoSimulcastAudioPlayer.getCurrentPlay()), null, 2, null);
                        return;
                    }
                }
                ResponseBody responseBodyErrorBody = response.errorBody();
                if (responseBodyErrorBody == null || (strString = responseBodyErrorBody.string()) == null) {
                    return;
                }
                FMLog.e$default(ExoSimulcastAudioPlayer.this.log, strString, null, 2, null);
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<PlayResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                FMLog fMLog = ExoSimulcastAudioPlayer.this.log;
                t.printStackTrace();
                FMLog.e$default(fMLog, Unit.INSTANCE, null, 2, null);
            }
        });
    }
}
