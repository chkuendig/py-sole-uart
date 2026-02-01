package fm.feed.android.playersdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.android.SdkConstants;
import com.android.ddmlib.internal.commands.DisconnectCommand;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import fm.feed.android.playersdk.models.AudioFile;
import fm.feed.android.playersdk.models.Play;
import fm.feed.android.playersdk.models.webservice.SimulcastConnectResponse;
import fm.feed.android.playersdk.models.webservice.SimulcastPlayResponse;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* compiled from: FeedSimulcastStreamer.kt */
@Metadata(d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0007*\u0001\"\u0018\u0000 ?2\u00020\u0001:\u0001?B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u00108\u001a\u000209H\u0002J\b\u0010:\u001a\u000209H\u0002J\u0006\u0010;\u001a\u000209J\u0006\u0010<\u001a\u000209J\b\u0010=\u001a\u000209H\u0002J\b\u0010>\u001a\u000209H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR*\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u001bj\b\u0012\u0004\u0012\u00020\u0007`\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0004\n\u0002\u0010#R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010/\u001a\u00020.2\u0006\u0010-\u001a\u00020.8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R$\u00104\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\u0016@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0019\"\u0004\b6\u00107¨\u0006@"}, d2 = {"Lfm/feed/android/playersdk/FeedSimulcastStreamer;", "", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "token", "", "eventListener", "Lfm/feed/android/playersdk/SimulcastEventListener;", "(Landroid/content/Context;Ljava/lang/String;Lfm/feed/android/playersdk/SimulcastEventListener;)V", "bPlayFlag", "", "clientId", "getContext", "()Landroid/content/Context;", "play", "Lfm/feed/android/playersdk/models/Play;", "currentItem", "getCurrentItem", "()Lfm/feed/android/playersdk/models/Play;", "setCurrentItem", "(Lfm/feed/android/playersdk/models/Play;)V", "<set-?>", "", "currentTime", "getCurrentTime", "()F", "eventListeners", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "fetchTimeInMs", "", "isPlayer", "lastConfirmedTrackPlayTimeByServerInSeconds", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "fm/feed/android/playersdk/FeedSimulcastStreamer$listener$1", "Lfm/feed/android/playersdk/FeedSimulcastStreamer$listener$1;", "log", "Lfm/feed/android/playersdk/FMLog;", "mMainHandler", "Landroid/os/Handler;", "mSimulcastApi", "Lfm/feed/android/playersdk/SimulcastApi;", "playWhenReady", "player", "Lfm/feed/android/playersdk/ExoSimulcastAudioPlayer;", "value", "Lfm/feed/android/playersdk/SimulcastPlaybackState;", ServerProtocol.DIALOG_PARAM_STATE, "getState", "()Lfm/feed/android/playersdk/SimulcastPlaybackState;", "setState", "(Lfm/feed/android/playersdk/SimulcastPlaybackState;)V", "volume", "getVolume", "setVolume", "(F)V", "checkAvailability", "", "checkUpdateNeeded", "connect", DisconnectCommand.COMMAND, "getCurrentPlay", "processUpdate", "Companion", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class FeedSimulcastStreamer {
    private static final int CANCEL_MESSAGE = 2;
    private static int UPDATE_INTERVAL = 1000;
    private static final int UPDATE_MESSAGE = 1;
    private boolean bPlayFlag;
    private String clientId;
    private final Context context;
    private Play currentItem;
    private float currentTime;
    private final ArrayList<SimulcastEventListener> eventListeners;
    private long fetchTimeInMs;
    private boolean isPlayer;
    private float lastConfirmedTrackPlayTimeByServerInSeconds;
    private final FeedSimulcastStreamer$listener$1 listener;
    private final FMLog log;
    private Handler mMainHandler;
    private final SimulcastApi mSimulcastApi;
    private boolean playWhenReady;
    private ExoSimulcastAudioPlayer player;
    private SimulcastPlaybackState state;
    private final String token;
    private float volume;

    /* JADX WARN: Type inference failed for: r3v7, types: [fm.feed.android.playersdk.FeedSimulcastStreamer$listener$1] */
    public FeedSimulcastStreamer(Context context, String token, SimulcastEventListener eventListener) throws SecurityException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        this.context = context;
        this.token = token;
        this.log = new FMLog("fm.feed.FeedSimulcastStreamer");
        Object objCreate = SimulcastApi.INSTANCE.getRetrofitInStudio().create(SimulcastApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "SimulcastApi.retrofitInS…SimulcastApi::class.java)");
        this.mSimulcastApi = (SimulcastApi) objCreate;
        this.clientId = FeedSession.INSTANCE.retrieveClientId(context);
        this.volume = 1.0f;
        this.state = SimulcastPlaybackState.Unintialized;
        ArrayList<SimulcastEventListener> arrayList = new ArrayList<>();
        this.eventListeners = arrayList;
        this.listener = new SimulcastEventListener() { // from class: fm.feed.android.playersdk.FeedSimulcastStreamer$listener$1
            @Override // fm.feed.android.playersdk.SimulcastEventListener
            public void onPlayItemBeganPlayback(Play play) {
                Intrinsics.checkNotNullParameter(play, "play");
                this.this$0.setCurrentItem(play);
                Iterator it = this.this$0.eventListeners.iterator();
                while (it.hasNext()) {
                    ((SimulcastEventListener) it.next()).onPlayItemBeganPlayback(play);
                }
            }

            @Override // fm.feed.android.playersdk.SimulcastEventListener
            public void onPlayerStateChanged(SimulcastPlaybackState playerState) {
                Intrinsics.checkNotNullParameter(playerState, "playerState");
                Iterator it = this.this$0.eventListeners.iterator();
                while (it.hasNext()) {
                    ((SimulcastEventListener) it.next()).onPlayerStateChanged(playerState);
                }
            }

            @Override // fm.feed.android.playersdk.SimulcastEventListener
            public void onProgressUpdate(Play play, float elapsedTime, float duration) {
                Intrinsics.checkNotNullParameter(play, "play");
                Iterator it = this.this$0.eventListeners.iterator();
                while (it.hasNext()) {
                    ((SimulcastEventListener) it.next()).onProgressUpdate(play, elapsedTime, duration);
                }
            }

            @Override // fm.feed.android.playersdk.SimulcastEventListener
            public void onPlayerError(Exception error) {
                Intrinsics.checkNotNullParameter(error, "error");
                Iterator it = this.this$0.eventListeners.iterator();
                while (it.hasNext()) {
                    ((SimulcastEventListener) it.next()).onPlayerError(error);
                }
            }
        };
        arrayList.add(eventListener);
        this.mMainHandler = new Handler(Looper.getMainLooper()) { // from class: fm.feed.android.playersdk.FeedSimulcastStreamer.1
            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                Intrinsics.checkNotNullParameter(msg, "msg");
                int i = msg.what;
                if (i != 1) {
                    if (i != 2) {
                        return;
                    }
                    removeMessages(1);
                } else {
                    FeedSimulcastStreamer.this.processUpdate();
                    removeMessages(1);
                    sendEmptyMessageDelayed(1, FeedSimulcastStreamer.UPDATE_INTERVAL);
                }
            }
        };
        checkAvailability();
    }

    public final Context getContext() {
        return this.context;
    }

    public final float getCurrentTime() {
        return this.currentTime;
    }

    public final float getVolume() {
        return this.volume;
    }

    public final void setVolume(float f) {
        ExoSimulcastAudioPlayer exoSimulcastAudioPlayer = this.player;
        if (exoSimulcastAudioPlayer != null) {
            exoSimulcastAudioPlayer.setVolume(f);
        }
        this.volume = f;
    }

    public final Play getCurrentItem() {
        if (this.isPlayer) {
            ExoSimulcastAudioPlayer exoSimulcastAudioPlayer = this.player;
            if (exoSimulcastAudioPlayer == null) {
                return null;
            }
            return exoSimulcastAudioPlayer.getCurrentPlay();
        }
        return this.currentItem;
    }

    public final void setCurrentItem(Play play) {
        if (play == null) {
            return;
        }
        if (getCurrentItem() != null) {
            Play currentItem = getCurrentItem();
            if (Intrinsics.areEqual(currentItem == null ? null : currentItem.getAudioFile(), play.getAudioFile())) {
                this.fetchTimeInMs = System.currentTimeMillis();
                this.currentItem = play;
                this.lastConfirmedTrackPlayTimeByServerInSeconds = play.getElapsedSeconds();
                return;
            }
        }
        this.fetchTimeInMs = System.currentTimeMillis();
        this.currentItem = play;
        this.lastConfirmedTrackPlayTimeByServerInSeconds = play.getElapsedSeconds();
        Iterator<SimulcastEventListener> it = this.eventListeners.iterator();
        while (it.hasNext()) {
            it.next().onPlayItemBeganPlayback(play);
        }
    }

    public final SimulcastPlaybackState getState() {
        if (this.state == SimulcastPlaybackState.Unintialized) {
            return SimulcastPlaybackState.Unintialized;
        }
        if (this.isPlayer) {
            ExoSimulcastAudioPlayer exoSimulcastAudioPlayer = this.player;
            Intrinsics.checkNotNull(exoSimulcastAudioPlayer);
            return exoSimulcastAudioPlayer.getPlayerState();
        }
        return this.state;
    }

    public final void setState(SimulcastPlaybackState value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (this.state != value) {
            this.state = value;
            Iterator<SimulcastEventListener> it = this.eventListeners.iterator();
            while (it.hasNext()) {
                it.next().onPlayerStateChanged(value);
            }
        }
    }

    private final void checkAvailability() {
        this.mSimulcastApi.simulcastGetStream(this.clientId, 1, this.token).enqueue(new Callback<SimulcastConnectResponse>() { // from class: fm.feed.android.playersdk.FeedSimulcastStreamer.checkAvailability.1
            @Override // retrofit2.Callback
            public void onResponse(Call<SimulcastConnectResponse> call, Response<SimulcastConnectResponse> response) {
                ExoSimulcastAudioPlayer exoSimulcastAudioPlayer;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (!response.isSuccessful()) {
                    Iterator it = FeedSimulcastStreamer.this.eventListeners.iterator();
                    while (it.hasNext()) {
                        ((SimulcastEventListener) it.next()).onPlayerError(new Exception(response.message()));
                    }
                    return;
                }
                SimulcastConnectResponse simulcastConnectResponseBody = response.body();
                if (simulcastConnectResponseBody == null) {
                    return;
                }
                FeedSimulcastStreamer feedSimulcastStreamer = FeedSimulcastStreamer.this;
                FeedSession.INSTANCE.persistClientId(feedSimulcastStreamer.getContext(), simulcastConnectResponseBody.getClientId());
                feedSimulcastStreamer.clientId = simulcastConnectResponseBody.getClientId();
                if (simulcastConnectResponseBody.getStreamUrl() != null) {
                    feedSimulcastStreamer.isPlayer = true;
                    Context context = feedSimulcastStreamer.getContext();
                    Looper mainLooper = Looper.getMainLooper();
                    Intrinsics.checkNotNullExpressionValue(mainLooper, "getMainLooper()");
                    feedSimulcastStreamer.player = new ExoSimulcastAudioPlayer(context, mainLooper, feedSimulcastStreamer.token);
                    if (feedSimulcastStreamer.playWhenReady && (exoSimulcastAudioPlayer = feedSimulcastStreamer.player) != null) {
                        exoSimulcastAudioPlayer.play();
                    }
                    ExoSimulcastAudioPlayer exoSimulcastAudioPlayer2 = feedSimulcastStreamer.player;
                    if (exoSimulcastAudioPlayer2 != null) {
                        exoSimulcastAudioPlayer2.setEventListener(feedSimulcastStreamer.listener);
                    }
                } else {
                    feedSimulcastStreamer.isPlayer = false;
                    if (feedSimulcastStreamer.playWhenReady) {
                        feedSimulcastStreamer.mMainHandler.sendEmptyMessage(1);
                    }
                }
                if (simulcastConnectResponseBody.getError() == null) {
                    feedSimulcastStreamer.setState(SimulcastPlaybackState.Available);
                    return;
                }
                feedSimulcastStreamer.setState(SimulcastPlaybackState.Unavailable);
                Iterator it2 = feedSimulcastStreamer.eventListeners.iterator();
                while (it2.hasNext()) {
                    ((SimulcastEventListener) it2.next()).onPlayerError(simulcastConnectResponseBody.getError());
                }
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<SimulcastConnectResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                Iterator it = FeedSimulcastStreamer.this.eventListeners.iterator();
                while (it.hasNext()) {
                    ((SimulcastEventListener) it.next()).onPlayerError(new Exception(t));
                }
            }
        });
    }

    public final void connect() {
        if (getState() == SimulcastPlaybackState.Unintialized) {
            this.playWhenReady = true;
            return;
        }
        if (getState() == SimulcastPlaybackState.Unavailable) {
            Iterator<SimulcastEventListener> it = this.eventListeners.iterator();
            while (it.hasNext()) {
                it.next().onPlayerError(new Exception("Player is Unavailable"));
            }
        }
        if (this.isPlayer) {
            ExoSimulcastAudioPlayer exoSimulcastAudioPlayer = this.player;
            if (exoSimulcastAudioPlayer == null) {
                return;
            }
            exoSimulcastAudioPlayer.play();
            return;
        }
        this.mMainHandler.sendEmptyMessage(1);
    }

    public final void disconnect() {
        if (this.isPlayer) {
            ExoSimulcastAudioPlayer exoSimulcastAudioPlayer = this.player;
            if (exoSimulcastAudioPlayer == null) {
                return;
            }
            exoSimulcastAudioPlayer.stop();
            return;
        }
        this.mMainHandler.sendEmptyMessage(2);
    }

    private final void getCurrentPlay() {
        if (!this.bPlayFlag) {
            this.bPlayFlag = true;
            SimulcastApi.INSTANCE.getHttpLog().level(HttpLoggingInterceptor.Level.BODY);
            this.mSimulcastApi.simulcastGetInStudioPlay(Intrinsics.stringPlus("cid=", this.clientId), this.token).enqueue(new Callback<SimulcastPlayResponse>() { // from class: fm.feed.android.playersdk.FeedSimulcastStreamer.getCurrentPlay.1
                /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
                java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
                	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
                	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
                	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
                	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
                 */
                @Override // retrofit2.Callback
                public void onResponse(Call<SimulcastPlayResponse> call, Response<SimulcastPlayResponse> response) {
                    String strString;
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    FeedSimulcastStreamer.this.bPlayFlag = false;
                    if (!response.isSuccessful()) {
                        ResponseBody responseBodyErrorBody = response.errorBody();
                        if (responseBodyErrorBody == null || (strString = responseBodyErrorBody.string()) == null) {
                            return;
                        }
                        FeedSimulcastStreamer feedSimulcastStreamer = FeedSimulcastStreamer.this;
                        Iterator it = feedSimulcastStreamer.eventListeners.iterator();
                        while (it.hasNext()) {
                            ((SimulcastEventListener) it.next()).onPlayerError(new Exception(Intrinsics.stringPlus("Request to server unsuccessful ", strString)));
                        }
                        FMLog.e$default(feedSimulcastStreamer.log, strString, null, 2, null);
                    }
                    SimulcastPlayResponse simulcastPlayResponseBody = response.body();
                    if (simulcastPlayResponseBody == null) {
                        return;
                    }
                    FeedSimulcastStreamer feedSimulcastStreamer2 = FeedSimulcastStreamer.this;
                    if (!simulcastPlayResponseBody.getIsSuccess()) {
                        FMLog.e$default(feedSimulcastStreamer2.log, "Server returned an error", null, 2, null);
                        FMLog.e$default(feedSimulcastStreamer2.log, String.valueOf(simulcastPlayResponseBody.getError()), null, 2, null);
                        Iterator it2 = feedSimulcastStreamer2.eventListeners.iterator();
                        while (it2.hasNext()) {
                            ((SimulcastEventListener) it2.next()).onPlayerError(new Exception(Intrinsics.stringPlus("Server returned an error ", simulcastPlayResponseBody.getError())));
                        }
                        return;
                    }
                    if (simulcastPlayResponseBody.getState() == null) {
                        FMLog.e$default(feedSimulcastStreamer2.log, "Server did not return a state", null, 2, null);
                        Iterator it3 = feedSimulcastStreamer2.eventListeners.iterator();
                        while (it3.hasNext()) {
                            ((SimulcastEventListener) it3.next()).onPlayerError(new Exception("Server did not return a state"));
                        }
                        return;
                    }
                    if (simulcastPlayResponseBody.getPlay() != null) {
                        feedSimulcastStreamer2.setCurrentItem(simulcastPlayResponseBody.getPlay());
                        FMLog.d$default(feedSimulcastStreamer2.log, Intrinsics.stringPlus("Got new play ", feedSimulcastStreamer2.getCurrentItem()), null, 2, null);
                    }
                    feedSimulcastStreamer2.lastConfirmedTrackPlayTimeByServerInSeconds = simulcastPlayResponseBody.getElapsedSeconds();
                    String state = simulcastPlayResponseBody.getState();
                    if (state != null) {
                        switch (state.hashCode()) {
                            case -995321554:
                                if (state.equals("paused")) {
                                    feedSimulcastStreamer2.setState(SimulcastPlaybackState.Stopped);
                                    break;
                                }
                                break;
                            case -524171096:
                                if (state.equals("music-unavailable")) {
                                    feedSimulcastStreamer2.setState(SimulcastPlaybackState.Unavailable);
                                    break;
                                }
                                break;
                            case -493563858:
                                if (state.equals("playing")) {
                                    feedSimulcastStreamer2.setState(SimulcastPlaybackState.Playing);
                                    break;
                                }
                                break;
                            case 3227604:
                                if (state.equals("idle")) {
                                    feedSimulcastStreamer2.setState(SimulcastPlaybackState.Idle);
                                    break;
                                }
                                break;
                        }
                    }
                }

                @Override // retrofit2.Callback
                public void onFailure(Call<SimulcastPlayResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    FeedSimulcastStreamer.this.bPlayFlag = false;
                    Iterator it = FeedSimulcastStreamer.this.eventListeners.iterator();
                    while (it.hasNext()) {
                        ((SimulcastEventListener) it.next()).onPlayerError(new Exception(t));
                    }
                    FMLog fMLog = FeedSimulcastStreamer.this.log;
                    t.printStackTrace();
                    FMLog.e$default(fMLog, Unit.INSTANCE, null, 2, null);
                }
            });
            return;
        }
        FMLog.d$default(this.log, "Already fetching a play", null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void processUpdate() {
        FMLog.d$default(this.log, "Processing update", null, 2, null);
        checkUpdateNeeded();
        this.currentTime = this.lastConfirmedTrackPlayTimeByServerInSeconds + (((int) (System.currentTimeMillis() - this.fetchTimeInMs)) / 1000);
        Play currentItem = getCurrentItem();
        if (currentItem == null) {
            return;
        }
        Iterator<SimulcastEventListener> it = this.eventListeners.iterator();
        while (it.hasNext()) {
            it.next().onProgressUpdate(currentItem, getCurrentTime(), currentItem.getAudioFile().getDurationInSeconds());
        }
    }

    private final void checkUpdateNeeded() {
        AudioFile audioFile;
        Play currentItem = getCurrentItem();
        if (currentItem != null && (audioFile = currentItem.getAudioFile()) != null) {
            if (getCurrentTime() - audioFile.getDurationInSeconds() > 0.0f && !this.bPlayFlag) {
                getCurrentPlay();
            } else if (getCurrentTime() - this.lastConfirmedTrackPlayTimeByServerInSeconds > 10.0f && !this.bPlayFlag) {
                getCurrentPlay();
            }
        }
        if (getCurrentItem() == null) {
            if (getState() == SimulcastPlaybackState.Idle) {
                UPDATE_INTERVAL = 5000;
            } else {
                UPDATE_INTERVAL = 1000;
            }
            getCurrentPlay();
        }
    }
}
