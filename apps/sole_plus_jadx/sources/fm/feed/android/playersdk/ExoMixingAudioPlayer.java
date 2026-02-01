package fm.feed.android.playersdk;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.camera.video.AudioStats;
import com.android.SdkConstants;
import com.facebook.internal.ServerProtocol;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.upstream.cache.SimpleCache;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import fm.feed.android.playersdk.MixingAudioPlayer;
import fm.feed.android.playersdk.PlayerProxy;
import fm.feed.android.playersdk.models.AudioFile;
import fm.feed.android.playersdk.models.Play;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;

/* compiled from: ExoMixingAudioPlayer.kt */
@Metadata(d1 = {"\u0000Ë\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f*\u0003=BF\b\u0000\u0018\u0000 \u0093\u00012\u00020\u0001:\u0006\u0093\u0001\u0094\u0001\u0095\u0001B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020\u001cH\u0016J \u0010\\\u001a\u00020Z2\u0006\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u0002032\u0006\u0010\u0004\u001a\u00020`H\u0016J\u0012\u0010a\u001a\u00020Z2\b\u0010[\u001a\u0004\u0018\u00010\u001cH\u0002J\u0010\u0010b\u001a\u00020c2\u0006\u0010]\u001a\u00020^H\u0002J\u0010\u0010d\u001a\u00020e2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\b\u0010f\u001a\u00020ZH\u0016J\u0010\u0010g\u001a\u00020\r2\u0006\u0010h\u001a\u00020iH\u0002J\b\u0010j\u001a\u00020ZH\u0016J\u0010\u0010k\u001a\u00020Z2\u0006\u0010l\u001a\u00020\rH\u0016J\u0010\u0010m\u001a\u00020^2\u0006\u0010]\u001a\u00020^H\u0002J\u0012\u0010n\u001a\u00020o2\b\u0010[\u001a\u0004\u0018\u00010\u001cH\u0002J\b\u0010p\u001a\u00020\rH\u0002J\b\u0010q\u001a\u00020\rH\u0002J\b\u0010r\u001a\u00020\u000bH\u0016J\b\u0010s\u001a\u00020ZH\u0016J\b\u0010[\u001a\u00020ZH\u0016J\u0010\u0010t\u001a\u00020\r2\u0006\u0010u\u001a\u00020\rH\u0002J\u0010\u0010v\u001a\u00020Z2\u0006\u0010w\u001a\u00020\u001cH\u0016J\b\u0010x\u001a\u00020ZH\u0002J\b\u0010y\u001a\u00020ZH\u0002J\b\u0010z\u001a\u00020ZH\u0002J\b\u0010{\u001a\u00020ZH\u0002J\u0010\u0010|\u001a\u00020Z2\u0006\u0010}\u001a\u00020\u000bH\u0016J\u0010\u0010~\u001a\u00020Z2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u000f\u0010\u007f\u001a\u00020Z2\u0007\u0010\u0080\u0001\u001a\u00020\rJ\t\u0010\u0081\u0001\u001a\u00020ZH\u0016J0\u0010\u0082\u0001\u001a\u00020Z2\u0007\u0010\u0083\u0001\u001a\u00020\u001c2\u0007\u0010\u0084\u0001\u001a\u0002032\u0013\b\u0002\u0010\u0085\u0001\u001a\f\u0018\u00010\u0086\u0001j\u0005\u0018\u0001`\u0087\u0001H\u0002J\t\u0010\u0088\u0001\u001a\u00020ZH\u0016J\t\u0010\u0089\u0001\u001a\u00020ZH\u0002J\t\u0010\u008a\u0001\u001a\u00020ZH\u0002J\u001d\u0010\u008b\u0001\u001a\u00020Z2\u0007\u0010\u0083\u0001\u001a\u00020\u001c2\t\b\u0002\u0010\u008c\u0001\u001a\u000203H\u0002J\u0012\u0010\u008d\u0001\u001a\u00020Z2\u0007\u0010\u0083\u0001\u001a\u00020\u001cH\u0002J\t\u0010\u008e\u0001\u001a\u00020ZH\u0002J\t\u0010\u008f\u0001\u001a\u00020ZH\u0002J\t\u0010\u0090\u0001\u001a\u00020^H\u0016J\u0012\u0010\u0091\u0001\u001a\u00020\r2\u0007\u0010\u0092\u0001\u001a\u00020LH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\rX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010!R$\u0010%\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b&\u0010!\"\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010+\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u000e\u00100\u001a\u000201X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00104\u001a\u000605R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00106\u001a\u000605R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00107\u001a\b\u0012\u0004\u0012\u00020\u001c08X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u00109\u001a\u000605R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010:\u001a\u00060;R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u00020=X\u0082\u0004¢\u0006\u0004\n\u0002\u0010>R\u000e\u0010?\u001a\u00020@X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u00020BX\u0082\u0004¢\u0006\u0004\n\u0002\u0010CR\u000e\u0010D\u001a\u00020@X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u00020FX\u0082\u0004¢\u0006\u0004\n\u0002\u0010GR\u000e\u0010H\u001a\u00020@X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010I\u001a\u0004\u0018\u00010JX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010K\u001a\u00020LX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u0018\u0010Q\u001a\f\u0012\b\u0012\u00060;R\u00020\u00000RX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010T\u001a\u00020\u000b2\u0006\u0010S\u001a\u00020\u000b@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010!\"\u0004\bV\u0010(R\u000e\u0010W\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0096\u0001"}, d2 = {"Lfm/feed/android/playersdk/ExoMixingAudioPlayer;", "Lfm/feed/android/playersdk/MixingAudioPlayer;", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lfm/feed/android/playersdk/MixingAudioPlayer$EventListener;", "looper", "Landroid/os/Looper;", "(Landroid/content/Context;Lfm/feed/android/playersdk/MixingAudioPlayer$EventListener;Landroid/os/Looper;)V", "(Landroid/content/Context;Landroid/os/Looper;)V", "_fadeDuration", "", "bIsFadingOut", "", "bPaused", "bTimeFlag", "bTrimmingEnabled", "getBTrimmingEnabled", "()Z", "setBTrimmingEnabled", "(Z)V", "bisPlaying", "getContext", "()Landroid/content/Context;", "crossFadeInEnabled", "getCrossFadeInEnabled", "setCrossFadeInEnabled", "currentPlay", "Lfm/feed/android/playersdk/models/Play;", "getCurrentPlay", "()Lfm/feed/android/playersdk/models/Play;", "currentPlayDuration", "getCurrentPlayDuration", "()F", "currentPlayTime", "getCurrentPlayTime", "value", "fadeDuration", "getFadeDuration", "setFadeDuration", "(F)V", "log", "Lfm/feed/android/playersdk/FMLog;", "mEventListener", "getMEventListener", "()Lfm/feed/android/playersdk/MixingAudioPlayer$EventListener;", "setMEventListener", "(Lfm/feed/android/playersdk/MixingAudioPlayer$EventListener;)V", "mMainHandler", "Landroid/os/Handler;", "mMinimumDurationForCrossFade", "", "mPreparingPlayer", "Lfm/feed/android/playersdk/ExoMixingAudioPlayer$PlayAndPlayer;", "mPrimaryPlayer", "mQueuedAudioAssets", "Ljava/util/LinkedList;", "mSecondaryPlayer", "mTimeTracker", "Lfm/feed/android/playersdk/ExoMixingAudioPlayer$TimeTracker;", "preparingEventListener", "fm/feed/android/playersdk/ExoMixingAudioPlayer$preparingEventListener$1", "Lfm/feed/android/playersdk/ExoMixingAudioPlayer$preparingEventListener$1;", "preparingPlayerProxy", "Lfm/feed/android/playersdk/PlayerProxy;", "primaryEventListener", "fm/feed/android/playersdk/ExoMixingAudioPlayer$primaryEventListener$1", "Lfm/feed/android/playersdk/ExoMixingAudioPlayer$primaryEventListener$1;", "primaryPlayerProxy", "secondaryEventListener", "fm/feed/android/playersdk/ExoMixingAudioPlayer$secondaryEventListener$1", "Lfm/feed/android/playersdk/ExoMixingAudioPlayer$secondaryEventListener$1;", "secondaryPlayerProxy", "simpleCache", "Lcom/google/android/exoplayer2/upstream/cache/SimpleCache;", ServerProtocol.DIALOG_PARAM_STATE, "Lfm/feed/android/playersdk/State;", "getState", "()Lfm/feed/android/playersdk/State;", "setState", "(Lfm/feed/android/playersdk/State;)V", "tracker", "Ljava/util/ArrayList;", "newVolume", "volume", "getVolume", "setVolume", "volumeMax", "volumeMin", "addAudioAsset", "", "play", "cacheMedia", "url", "", "maxCache", "Lfm/feed/android/playersdk/CacheMediaListener;", "calculateFinalTime", "createMediaSource", "Lcom/google/android/exoplayer2/source/MediaSource;", "createSimpleExoPlayer", "Lcom/google/android/exoplayer2/ExoPlayer;", "destroy", "enThread", SdkConstants.FD_RES_CLASS, "Ljava/lang/Runnable;", "flush", "flushAndIncludeCurrent", "bTrue", "getKey", "getTrackFinalTime", "", "loadPrimaryPlayer", "loadSecondaryPlayer", "maxSeekableLengthInSeconds", "pause", "preparePlayer", "playWhenReady", "prepareTrack", "file", "primaryPlayerCompleted", "processUpdate", "scheduleFadeOutAndFadeIn", "scheduleFadeOutNoFadeIn", "seekTo", "seconds", "setMixingAudioPlayerEventListener", "setTrimmingEnabled", "enabled", SdkConstants.TAG_SKIP, "skipCurrent", "previousPlay", "reason", "error", "Ljava/lang/Exception;", "Lkotlin/Exception;", "skipWithCrossFade", "startFadeIn", "startFadeOut", "startFadeOutAndFadeIn", "completionReason", "startFadeOutNoFadeIn", "switchPlayerReferences", "switchPreparingReferences", "toString", "updateToState", "newState", "Companion", "PlayAndPlayer", "TimeTracker", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class ExoMixingAudioPlayer implements MixingAudioPlayer {
    private static final int CANCEL_MESSAGE = 2;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int FADE_INTERVAL = 100;
    private static final int UPDATE_INTERVAL = 500;
    private static final int UPDATE_MESSAGE = 1;
    private float _fadeDuration;
    private boolean bIsFadingOut;
    private boolean bPaused;
    private boolean bTimeFlag;
    private boolean bTrimmingEnabled;
    private boolean bisPlaying;
    private final Context context;
    private boolean crossFadeInEnabled;
    private final FMLog log;
    private MixingAudioPlayer.EventListener mEventListener;
    private Handler mMainHandler;
    private int mMinimumDurationForCrossFade;
    private PlayAndPlayer mPreparingPlayer;
    private PlayAndPlayer mPrimaryPlayer;
    private final LinkedList<Play> mQueuedAudioAssets;
    private PlayAndPlayer mSecondaryPlayer;
    private final TimeTracker mTimeTracker;
    private final ExoMixingAudioPlayer$preparingEventListener$1 preparingEventListener;
    private final PlayerProxy preparingPlayerProxy;
    private final ExoMixingAudioPlayer$primaryEventListener$1 primaryEventListener;
    private final PlayerProxy primaryPlayerProxy;
    private final ExoMixingAudioPlayer$secondaryEventListener$1 secondaryEventListener;
    private final PlayerProxy secondaryPlayerProxy;
    private SimpleCache simpleCache;
    private State state;
    private final ArrayList<TimeTracker> tracker;
    private float volume;
    private float volumeMax;
    private float volumeMin;

    /* JADX WARN: Type inference failed for: r1v11, types: [fm.feed.android.playersdk.ExoMixingAudioPlayer$primaryEventListener$1] */
    /* JADX WARN: Type inference failed for: r2v1, types: [fm.feed.android.playersdk.ExoMixingAudioPlayer$secondaryEventListener$1] */
    /* JADX WARN: Type inference failed for: r3v0, types: [fm.feed.android.playersdk.ExoMixingAudioPlayer$preparingEventListener$1] */
    public ExoMixingAudioPlayer(Context context, Looper looper) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(looper, "looper");
        this.context = context;
        FMLog fMLog = new FMLog("fm.feed.ExoMP");
        this.log = fMLog;
        this.mMinimumDurationForCrossFade = 1000;
        this.volume = 1.0f;
        this.bTimeFlag = true;
        this.bTrimmingEnabled = true;
        this.crossFadeInEnabled = true;
        this.mPrimaryPlayer = new PlayAndPlayer(this);
        this.mSecondaryPlayer = new PlayAndPlayer(this);
        this.mPreparingPlayer = new PlayAndPlayer(this);
        this.state = State.UNINITIALIZED;
        this.mQueuedAudioAssets = new LinkedList<>();
        this.mTimeTracker = new TimeTracker(this, "0");
        this.tracker = new ArrayList<>();
        ?? r1 = new PlayerProxy.ExoEventListener() { // from class: fm.feed.android.playersdk.ExoMixingAudioPlayer$primaryEventListener$1
            @Override // fm.feed.android.playersdk.PlayerProxy.ExoEventListener
            public void onSeekProcessed() {
            }

            @Override // fm.feed.android.playersdk.PlayerProxy.ExoEventListener
            public void onLoadingChanged(boolean isLoading) {
                FMLog.v$default(this.this$0.log, "primary player is " + (isLoading ? "still" : "done") + " loading", null, 2, null);
            }

            @Override // fm.feed.android.playersdk.PlayerProxy.ExoEventListener
            public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
                boolean z;
                MixingAudioPlayer.EventListener mEventListener;
                long bufferingEndTime;
                FMLog.d$default(this.this$0.log, "Primary player state changed to " + ExoMixingAudioPlayer.INSTANCE.exoplayerStateToString(playbackState) + " (exoplayer.playWhenReady = " + playWhenReady + ')', null, 2, null);
                if (playbackState != 3 || !playWhenReady) {
                    if (playbackState == 3) {
                        if (this.this$0.bPaused) {
                            this.this$0.updateToState(State.PAUSED);
                            return;
                        }
                        this.this$0.updateToState(State.READY_TO_PLAY);
                        Play play = this.this$0.mPrimaryPlayer.getPlay();
                        if (play != null) {
                            this.this$0.calculateFinalTime(play);
                            MixingAudioPlayer.EventListener mEventListener2 = this.this$0.getMEventListener();
                            if (mEventListener2 == null) {
                                return;
                            }
                            mEventListener2.onPlayItemReadyForPlayback(play);
                            return;
                        }
                        return;
                    }
                    if (playbackState == 2) {
                        this.this$0.updateToState(State.STALLED);
                        return;
                    }
                    if (playbackState != 1) {
                        if (playbackState == 4) {
                            this.this$0.primaryPlayerCompleted();
                            return;
                        }
                        return;
                    } else {
                        if (this.this$0.bPaused) {
                            this.this$0.updateToState(State.PAUSED);
                            return;
                        }
                        if (this.this$0.mPrimaryPlayer.getPlay() == null && this.this$0.mSecondaryPlayer.getPlay() == null) {
                            this.this$0.mPrimaryPlayer.setBStartHasBeenReported(false);
                            this.this$0.mSecondaryPlayer.setBStartHasBeenReported(false);
                            this.this$0.mPrimaryPlayer.setBEndHasBeenReported(false);
                            this.this$0.mPrimaryPlayer.setBEndHasBeenReported(false);
                            this.this$0.mPrimaryPlayer.setBReadyForPlayback(false);
                            this.this$0.mSecondaryPlayer.setBReadyForPlayback(false);
                            this.this$0.updateToState(State.WAITING_FOR_ITEM);
                            return;
                        }
                        return;
                    }
                }
                Handler handler = this.this$0.mMainHandler;
                if (handler == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMainHandler");
                    handler = null;
                }
                handler.sendEmptyMessageDelayed(1, 500L);
                if (this.this$0.getState() != State.PLAYING) {
                    FMLog.d$default(this.this$0.log, "Changing state " + ExoMixingAudioPlayer.INSTANCE.stateToString(this.this$0.getState()) + " -> " + ExoMixingAudioPlayer.INSTANCE.stateToString(State.PLAYING), null, 2, null);
                    this.this$0.setState(State.PLAYING);
                    z = true;
                } else {
                    z = false;
                }
                Play play2 = this.this$0.mPrimaryPlayer.getPlay();
                if (this.this$0.getMEventListener() != null && play2 != null) {
                    if (this.this$0.mPrimaryPlayer.getPlayer().getCurrentPosition() <= (play2.getAudioFile().getStartTrim() * 1000) + 50 && !this.this$0.mPrimaryPlayer.getBReadyForPlayback()) {
                        ExoMixingAudioPlayer exoMixingAudioPlayer = this.this$0;
                        exoMixingAudioPlayer.calculateFinalTime(exoMixingAudioPlayer.mPrimaryPlayer.getPlay());
                        MixingAudioPlayer.EventListener mEventListener3 = this.this$0.getMEventListener();
                        if (mEventListener3 != null) {
                            mEventListener3.onPlayItemReadyForPlayback(play2);
                        }
                        this.this$0.mPrimaryPlayer.setBReadyForPlayback(true);
                    }
                    if (!this.this$0.mPrimaryPlayer.getBStartHasBeenReported()) {
                        this.this$0.mPrimaryPlayer.setBStartHasBeenReported(true);
                        this.this$0.mPrimaryPlayer.setBEndHasBeenReported(false);
                        if (play2.getStation() != null) {
                            this.this$0.mPrimaryPlayer.setPlayingVolume((float) Math.max(Math.min(this.this$0.getVolume() * 0.5d * Math.pow(10.0d, (r3.getPreGain() + play2.getAudioFile().getReplayGain()) / 20), 1.0d), AudioStats.AUDIO_AMPLITUDE_NONE));
                        } else {
                            this.this$0.mPrimaryPlayer.setPlayingVolume((float) Math.max(Math.min(this.this$0.getVolume() * 0.5d * Math.pow(10.0d, play2.getAudioFile().getReplayGain() / 20), 1.0d), AudioStats.AUDIO_AMPLITUDE_NONE));
                        }
                        PlayerProxy.INSTANCE.setVolume(this.this$0.mPrimaryPlayer.getPlayer(), this.this$0.mPrimaryPlayer.getPlayingVolume());
                        if (this.this$0.bTimeFlag) {
                            this.this$0.mTimeTracker.setBufferingEndTime(System.currentTimeMillis());
                            this.this$0.bTimeFlag = false;
                            bufferingEndTime = this.this$0.mTimeTracker.getBufferingEndTime() - this.this$0.mTimeTracker.getBufferingStartTime();
                        } else {
                            bufferingEndTime = -1;
                        }
                        MixingAudioPlayer.EventListener mEventListener4 = this.this$0.getMEventListener();
                        if (mEventListener4 != null) {
                            mEventListener4.onPlayItemBeganPlayback((int) bufferingEndTime, play2, this.this$0.getTrackFinalTime(play2));
                        }
                        this.this$0.mTimeTracker.setBufferingEndTime(0L);
                        this.this$0.mTimeTracker.setBufferingStartTime(0L);
                    }
                }
                if (!z || (mEventListener = this.this$0.getMEventListener()) == null) {
                    return;
                }
                mEventListener.onPlayerStateChanged(this.this$0.getState());
            }

            @Override // fm.feed.android.playersdk.PlayerProxy.ExoEventListener
            public void onPlayerError(ExoPlaybackException error) {
                long bufferingEndTime;
                this.this$0.log.e("primary player error \n", error);
                Play play = this.this$0.mPrimaryPlayer.getPlay();
                if (play == null) {
                    return;
                }
                ExoPlaybackException exc = error == null ? new Exception("Exoplayer failed to play this track") : error;
                if (!this.this$0.mPrimaryPlayer.getBStartHasBeenReported()) {
                    this.this$0.mPrimaryPlayer.setBStartHasBeenReported(true);
                    if (this.this$0.bTimeFlag) {
                        this.this$0.mTimeTracker.setBufferingEndTime(System.currentTimeMillis());
                        this.this$0.bTimeFlag = false;
                        bufferingEndTime = this.this$0.mTimeTracker.getBufferingEndTime() - this.this$0.mTimeTracker.getBufferingStartTime();
                    } else {
                        bufferingEndTime = -1;
                    }
                    MixingAudioPlayer.EventListener mEventListener = this.this$0.getMEventListener();
                    if (mEventListener != null) {
                        mEventListener.onPlayItemBeganPlayback((int) bufferingEndTime, play, this.this$0.getTrackFinalTime(play));
                    }
                }
                this.this$0.skipCurrent(play, 3, exc);
            }
        };
        this.primaryEventListener = r1;
        ?? r2 = new PlayerProxy.ExoEventListener() { // from class: fm.feed.android.playersdk.ExoMixingAudioPlayer$secondaryEventListener$1
            @Override // fm.feed.android.playersdk.PlayerProxy.ExoEventListener
            public void onLoadingChanged(boolean isLoading) {
            }

            @Override // fm.feed.android.playersdk.PlayerProxy.ExoEventListener
            public void onSeekProcessed() {
            }

            @Override // fm.feed.android.playersdk.PlayerProxy.ExoEventListener
            public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
                FMLog.d$default(this.this$0.log, Intrinsics.stringPlus("Secondary player state changed to ", ExoMixingAudioPlayer.INSTANCE.exoplayerStateToString(playbackState)), null, 2, null);
                if (playbackState == 3 && playWhenReady) {
                    FMLog.e$default(this.this$0.log, "secondary player became ready and tried to begin playback!!", null, 2, null);
                    return;
                }
                if (playbackState == 2) {
                    FMLog.d$default(this.this$0.log, "secondary player is now buffering", null, 2, null);
                    return;
                }
                if (playbackState != 3) {
                    if (playbackState == 4) {
                        FMLog.d$default(this.this$0.log, "secondary player is now ended", null, 2, null);
                        return;
                    } else {
                        if (playbackState == 1) {
                            FMLog.d$default(this.this$0.log, "secondary player is now idle", null, 2, null);
                            return;
                        }
                        return;
                    }
                }
                FMLog.d$default(this.this$0.log, "secondary player is now ready", null, 2, null);
                Play play = this.this$0.mSecondaryPlayer.getPlay();
                if (play != null) {
                    this.this$0.calculateFinalTime(play);
                    MixingAudioPlayer.EventListener mEventListener = this.this$0.getMEventListener();
                    if (mEventListener != null) {
                        mEventListener.onPlayItemReadyForPlayback(play);
                    }
                    this.this$0.mSecondaryPlayer.setBReadyForPlayback(true);
                }
            }

            @Override // fm.feed.android.playersdk.PlayerProxy.ExoEventListener
            public void onPlayerError(ExoPlaybackException error) {
                MixingAudioPlayer.EventListener mEventListener;
                ExoPlaybackException exc = error;
                FMLog.e$default(this.this$0.log, Intrinsics.stringPlus("secondary player error \n", exc == null ? null : exc.getStackTrace()), null, 2, null);
                if (exc == null) {
                    exc = new Exception("Exoplayer failed to play this track");
                }
                FMLog.e$default(this.this$0.log, "secondary failed to prepare", null, 2, null);
                Play play = this.this$0.mSecondaryPlayer.getPlay();
                if (play != null && (mEventListener = this.this$0.getMEventListener()) != null) {
                    mEventListener.onPlayFailedToPrepare(play, exc);
                }
                this.this$0.mSecondaryPlayer.setPlay(null);
                this.this$0.mSecondaryPlayer.setBReadyForPlayback(false);
                this.this$0.mSecondaryPlayer.setBStartHasBeenReported(false);
                this.this$0.loadSecondaryPlayer();
            }
        };
        this.secondaryEventListener = r2;
        ?? r3 = new PlayerProxy.ExoEventListener() { // from class: fm.feed.android.playersdk.ExoMixingAudioPlayer$preparingEventListener$1
            @Override // fm.feed.android.playersdk.PlayerProxy.ExoEventListener
            public void onLoadingChanged(boolean isLoading) {
            }

            @Override // fm.feed.android.playersdk.PlayerProxy.ExoEventListener
            public void onPlayerError(ExoPlaybackException error) {
            }

            @Override // fm.feed.android.playersdk.PlayerProxy.ExoEventListener
            public void onSeekProcessed() {
            }

            @Override // fm.feed.android.playersdk.PlayerProxy.ExoEventListener
            public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
                FMLog.d$default(this.this$0.log, Intrinsics.stringPlus("preparing player state changed to ", ExoMixingAudioPlayer.INSTANCE.exoplayerStateToString(playbackState)), null, 2, null);
                if (playbackState == 3 && playWhenReady) {
                    FMLog.e$default(this.this$0.log, "preparing player became ready and tried to begin playback!!", null, 2, null);
                    return;
                }
                if (playbackState == 2) {
                    FMLog.d$default(this.this$0.log, "preparing player is now buffering", null, 2, null);
                    return;
                }
                if (playbackState != 3) {
                    if (playbackState == 4) {
                        FMLog.d$default(this.this$0.log, "preparing player is now ended", null, 2, null);
                        return;
                    } else {
                        if (playbackState == 1) {
                            FMLog.d$default(this.this$0.log, "preparing player is now idle", null, 2, null);
                            return;
                        }
                        return;
                    }
                }
                FMLog.d$default(this.this$0.log, "preparing player is now ready", null, 2, null);
                Play play = this.this$0.mPreparingPlayer.getPlay();
                if (play != null) {
                    this.this$0.calculateFinalTime(play);
                    MixingAudioPlayer.EventListener mEventListener = this.this$0.getMEventListener();
                    if (mEventListener != null) {
                        mEventListener.onPlayItemReadyForPlayback(play);
                    }
                    this.this$0.mPreparingPlayer.setBReadyForPlayback(true);
                }
            }
        };
        this.preparingEventListener = r3;
        FMLog.i$default(fMLog, "Exoplayer is Starting up", null, 2, null);
        this.mPrimaryPlayer.setPlayer(createSimpleExoPlayer(looper));
        this.primaryPlayerProxy = new PlayerProxy((PlayerProxy.ExoEventListener) r1);
        this.mSecondaryPlayer.setPlayer(createSimpleExoPlayer(looper));
        this.secondaryPlayerProxy = new PlayerProxy((PlayerProxy.ExoEventListener) r2);
        this.mPreparingPlayer.setPlayer(createSimpleExoPlayer(looper));
        this.preparingPlayerProxy = new PlayerProxy((PlayerProxy.ExoEventListener) r3);
        PlayerProxy.INSTANCE.setSimpleCache$PlayerSdk_exoDefaultRelease(context);
        this.simpleCache = PlayerProxy.INSTANCE.getSimpleCache();
        this.mMainHandler = new Handler(looper) { // from class: fm.feed.android.playersdk.ExoMixingAudioPlayer.1
            final /* synthetic */ Looper $looper;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(looper);
                this.$looper = looper;
            }

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
                    ExoMixingAudioPlayer.this.processUpdate();
                    removeMessages(1);
                    sendEmptyMessageDelayed(1, 500L);
                }
            }
        };
        Runnable runnable = new Runnable() { // from class: fm.feed.android.playersdk.ExoMixingAudioPlayer$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                ExoMixingAudioPlayer.m8755_init_$lambda2(this.f$0);
            }
        };
        Handler handler = this.mMainHandler;
        if (handler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMainHandler");
            handler = null;
        }
        handler.post(runnable);
        setState(State.READY_TO_PLAY);
        FMLog.i$default(fMLog, "MixingPlayer is up", null, 2, null);
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // fm.feed.android.playersdk.MixingAudioPlayer
    public float getVolume() {
        return this.volume;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: _set_volume_$lambda-0, reason: not valid java name */
    public static final void m8756_set_volume_$lambda0(ExoMixingAudioPlayer this$0, float f) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setVolume(f);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0012 A[PHI: r0
      0x0012: PHI (r0v13 float) = (r0v2 float), (r0v3 float) binds: [B:6:0x0010, B:9:0x0017] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // fm.feed.android.playersdk.MixingAudioPlayer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setVolume(final float r9) {
        /*
            r8 = this;
            fm.feed.android.playersdk.ExoMixingAudioPlayer$$ExternalSyntheticLambda12 r0 = new fm.feed.android.playersdk.ExoMixingAudioPlayer$$ExternalSyntheticLambda12
            r0.<init>()
            boolean r0 = r8.enThread(r0)
            if (r0 == 0) goto Lc
            return
        Lc:
            r0 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r1 <= 0) goto L14
        L12:
            r9 = r0
            goto L1a
        L14:
            r0 = 0
            int r1 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r1 >= 0) goto L1a
            goto L12
        L1a:
            r8.volume = r9
            fm.feed.android.playersdk.ExoMixingAudioPlayer$PlayAndPlayer r9 = r8.mPrimaryPlayer
            fm.feed.android.playersdk.models.Play r9 = r9.getPlay()
            r0 = 0
            if (r9 != 0) goto L27
        L25:
            r9 = r0
            goto L36
        L27:
            fm.feed.android.playersdk.models.Station r9 = r9.getStation()
            if (r9 != 0) goto L2e
            goto L25
        L2e:
            float r9 = r9.getPreGain()
            java.lang.Float r9 = java.lang.Float.valueOf(r9)
        L36:
            fm.feed.android.playersdk.ExoMixingAudioPlayer$PlayAndPlayer r1 = r8.mPrimaryPlayer
            fm.feed.android.playersdk.models.Play r1 = r1.getPlay()
            if (r1 != 0) goto L3f
            goto L4e
        L3f:
            fm.feed.android.playersdk.models.AudioFile r1 = r1.getAudioFile()
            if (r1 != 0) goto L46
            goto L4e
        L46:
            float r0 = r1.getReplayGain()
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
        L4e:
            if (r9 == 0) goto L7f
            if (r0 == 0) goto L7f
            fm.feed.android.playersdk.ExoMixingAudioPlayer$PlayAndPlayer r1 = r8.mPrimaryPlayer
            float r2 = r8.volume
            double r2 = (double) r2
            r4 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            double r2 = r2 * r4
            float r9 = r9.floatValue()
            float r0 = r0.floatValue()
            float r9 = r9 + r0
            r0 = 20
            float r0 = (float) r0
            float r9 = r9 / r0
            double r4 = (double) r9
            r6 = 4621819117588971520(0x4024000000000000, double:10.0)
            double r4 = java.lang.Math.pow(r6, r4)
            double r2 = r2 * r4
            r4 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r2 = java.lang.Math.min(r2, r4)
            r4 = 0
            double r2 = java.lang.Math.max(r2, r4)
            float r9 = (float) r2
            r1.setPlayingVolume(r9)
        L7f:
            fm.feed.android.playersdk.PlayerProxy$Companion r9 = fm.feed.android.playersdk.PlayerProxy.INSTANCE
            fm.feed.android.playersdk.ExoMixingAudioPlayer$PlayAndPlayer r0 = r8.mPrimaryPlayer
            com.google.android.exoplayer2.ExoPlayer r0 = r0.getPlayer()
            fm.feed.android.playersdk.ExoMixingAudioPlayer$PlayAndPlayer r1 = r8.mPrimaryPlayer
            float r1 = r1.getPlayingVolume()
            r9.setVolume(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fm.feed.android.playersdk.ExoMixingAudioPlayer.setVolume(float):void");
    }

    @Override // fm.feed.android.playersdk.MixingAudioPlayer
    public float getFadeDuration() {
        return this._fadeDuration / 1000;
    }

    @Override // fm.feed.android.playersdk.MixingAudioPlayer
    public void setFadeDuration(float f) {
        float f2 = 1000;
        float f3 = f * f2;
        this._fadeDuration = f3;
        this.mMinimumDurationForCrossFade = (int) (f3 + f2);
    }

    @Override // fm.feed.android.playersdk.MixingAudioPlayer
    public boolean getBTrimmingEnabled() {
        return this.bTrimmingEnabled;
    }

    @Override // fm.feed.android.playersdk.MixingAudioPlayer
    public void setBTrimmingEnabled(boolean z) {
        this.bTrimmingEnabled = z;
    }

    public final boolean getCrossFadeInEnabled() {
        return this.crossFadeInEnabled;
    }

    public final void setCrossFadeInEnabled(boolean z) {
        this.crossFadeInEnabled = z;
    }

    @Override // fm.feed.android.playersdk.MixingAudioPlayer
    public State getState() {
        return this.state;
    }

    @Override // fm.feed.android.playersdk.MixingAudioPlayer
    public void setState(State state) {
        Intrinsics.checkNotNullParameter(state, "<set-?>");
        this.state = state;
    }

    @Override // fm.feed.android.playersdk.MixingAudioPlayer
    public MixingAudioPlayer.EventListener getMEventListener() {
        return this.mEventListener;
    }

    @Override // fm.feed.android.playersdk.MixingAudioPlayer
    public void setMEventListener(MixingAudioPlayer.EventListener eventListener) {
        this.mEventListener = eventListener;
    }

    @Override // fm.feed.android.playersdk.MixingAudioPlayer
    public Play getCurrentPlay() {
        return this.mPrimaryPlayer.getPlay();
    }

    @Override // fm.feed.android.playersdk.MixingAudioPlayer
    public float getCurrentPlayTime() {
        if (this.mPrimaryPlayer.getPlay() == null) {
            return 0.0f;
        }
        return this.mPrimaryPlayer.getPlayer().getCurrentPosition() / 1000.0f;
    }

    @Override // fm.feed.android.playersdk.MixingAudioPlayer
    public float getCurrentPlayDuration() {
        if (this.mPrimaryPlayer.getPlay() == null) {
            return 0.0f;
        }
        return this.mPrimaryPlayer.getPlayer().getDuration() / 1000.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: destroy$lambda-1, reason: not valid java name */
    public static final void m8759destroy$lambda1(ExoMixingAudioPlayer this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.destroy();
    }

    @Override // fm.feed.android.playersdk.MixingAudioPlayer
    public void destroy() {
        if (enThread(new Runnable() { // from class: fm.feed.android.playersdk.ExoMixingAudioPlayer$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                ExoMixingAudioPlayer.m8759destroy$lambda1(this.f$0);
            }
        })) {
            return;
        }
        flush();
        this.mPrimaryPlayer.getPlayer().release();
        this.mSecondaryPlayer.getPlayer().release();
    }

    /* compiled from: ExoMixingAudioPlayer.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lfm/feed/android/playersdk/ExoMixingAudioPlayer$TimeTracker;", "", "id", "", "(Lfm/feed/android/playersdk/ExoMixingAudioPlayer;Ljava/lang/String;)V", "bufferingEndTime", "", "getBufferingEndTime", "()J", "setBufferingEndTime", "(J)V", "bufferingStartTime", "getBufferingStartTime", "setBufferingStartTime", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class TimeTracker {
        private long bufferingEndTime;
        private long bufferingStartTime;
        private String id;
        final /* synthetic */ ExoMixingAudioPlayer this$0;

        public TimeTracker(ExoMixingAudioPlayer this$0, String id2) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(id2, "id");
            this.this$0 = this$0;
            this.id = id2;
        }

        public final String getId() {
            return this.id;
        }

        public final void setId(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.id = str;
        }

        public final long getBufferingStartTime() {
            return this.bufferingStartTime;
        }

        public final void setBufferingStartTime(long j) {
            this.bufferingStartTime = j;
        }

        public final long getBufferingEndTime() {
            return this.bufferingEndTime;
        }

        public final void setBufferingEndTime(long j) {
            this.bufferingEndTime = j;
        }
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
    /* renamed from: _init_$lambda-2, reason: not valid java name */
    public static final void m8755_init_$lambda2(ExoMixingAudioPlayer this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mPrimaryPlayer.getPlayer().addListener(this$0.primaryPlayerProxy.getExoListener());
        this$0.mSecondaryPlayer.getPlayer().addListener(this$0.secondaryPlayerProxy.getExoListener());
        this$0.mPreparingPlayer.getPlayer().addListener(this$0.preparingPlayerProxy.getExoListener());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExoMixingAudioPlayer(Context context, MixingAudioPlayer.EventListener listener, Looper looper) {
        this(context, looper);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(looper, "looper");
        setMEventListener(listener);
    }

    public final void setMixingAudioPlayerEventListener(MixingAudioPlayer.EventListener listener) {
        setMEventListener(listener);
    }

    public final void setTrimmingEnabled(boolean enabled) {
        setBTrimmingEnabled(enabled);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean updateToState(State newState) {
        if (newState != getState()) {
            FMLog fMLog = this.log;
            StringBuilder sb = new StringBuilder("Changing state ");
            Companion companion = INSTANCE;
            FMLog.d$default(fMLog, sb.append(companion.stateToString(getState())).append(" -> ").append(companion.stateToString(newState)).toString(), null, 2, null);
            setState(newState);
            MixingAudioPlayer.EventListener mEventListener = getMEventListener();
            if (mEventListener == null) {
                return true;
            }
            mEventListener.onPlayerStateChanged(newState);
            return true;
        }
        FMLog.v$default(this.log, "ignoring transition to the same state (" + INSTANCE.stateToString(newState) + ')', null, 2, null);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void calculateFinalTime(Play play) {
        if (play != null) {
            Iterator<TimeTracker> it = this.tracker.iterator();
            while (it.hasNext()) {
                TimeTracker next = it.next();
                if (Intrinsics.areEqual(next.getId(), play.getAudioFile().getUrl()) && next.getBufferingEndTime() == 0) {
                    next.setBufferingEndTime(System.currentTimeMillis());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long getTrackFinalTime(Play play) {
        TimeTracker timeTracker = null;
        if (play != null) {
            Iterator<TimeTracker> it = this.tracker.iterator();
            while (it.hasNext()) {
                TimeTracker next = it.next();
                if (Intrinsics.areEqual(next.getId(), play.getAudioFile().getUrl())) {
                    timeTracker = next;
                }
            }
        }
        ArrayList<TimeTracker> arrayList = this.tracker;
        if (arrayList == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        }
        TypeIntrinsics.asMutableCollection(arrayList).remove(timeTracker);
        long bufferingEndTime = timeTracker != null ? timeTracker.getBufferingEndTime() - timeTracker.getBufferingStartTime() : 0L;
        if (bufferingEndTime < 0) {
            return 0L;
        }
        return bufferingEndTime;
    }

    private final String getKey(String url) {
        String str = url;
        if (!StringsKt.contains$default((CharSequence) str, (CharSequence) SdkConstants.PREFIX_THEME_REF, false, 2, (Object) null)) {
            return url;
        }
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str, SdkConstants.PREFIX_THEME_REF, 0, false, 6, (Object) null);
        if (url == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = url.substring(0, iIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    private final ExoPlayer createSimpleExoPlayer(Looper looper) {
        return PlayerProxy.INSTANCE.createSimpleExoplayer(this.context, looper);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: prepareTrack$lambda-3, reason: not valid java name */
    public static final void m8764prepareTrack$lambda3(ExoMixingAudioPlayer this$0, Play file) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(file, "$file");
        this$0.prepareTrack(file);
    }

    @Override // fm.feed.android.playersdk.MixingAudioPlayer
    public void prepareTrack(final Play file) {
        Intrinsics.checkNotNullParameter(file, "file");
        if (enThread(new Runnable() { // from class: fm.feed.android.playersdk.ExoMixingAudioPlayer$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                ExoMixingAudioPlayer.m8764prepareTrack$lambda3(this.f$0, file);
            }
        })) {
            return;
        }
        FMLog.d$default(this.log, "prepareTrack", null, 2, null);
        this.mPreparingPlayer.setPlay(file);
        PlayerProxy.INSTANCE.prepare(this.mPreparingPlayer.getPlayer(), createMediaSource(file.getAudioFile().getUrl()));
        if (getBTrimmingEnabled() && file.getAudioFile().getStartTrim() > 0.0f && file.getAudioFile().getStartTrim() < file.getAudioFile().getDurationInSeconds()) {
            this.mPreparingPlayer.getPlayer().seekTo((long) (file.getAudioFile().getStartTrim() * 1000));
        }
        this.mPreparingPlayer.getPlayer().setPlayWhenReady(false);
    }

    @Override // fm.feed.android.playersdk.MixingAudioPlayer
    public void cacheMedia(String url, int maxCache, final CacheMediaListener listener) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(listener, "listener");
        FMLog.d$default(this.log, Intrinsics.stringPlus("Start caching ", url), null, 2, null);
        SimpleCache simpleCache = this.simpleCache;
        if (Intrinsics.areEqual((Object) (simpleCache == null ? null : Boolean.valueOf(simpleCache.isCached(getKey(url), 0L, maxCache))), (Object) true)) {
            listener.onCacheTransferEnded();
            return;
        }
        final DataSource.Factory factoryDataSourceFactoryCreator$PlayerSdk_exoDefaultRelease = PlayerProxy.INSTANCE.dataSourceFactoryCreator$PlayerSdk_exoDefaultRelease(this.context, listener);
        final DataSpec dataSpecCreateDataSpec$PlayerSdk_exoDefaultRelease = PlayerProxy.INSTANCE.createDataSpec$PlayerSdk_exoDefaultRelease(url, maxCache, getKey(url));
        FMLog.d$default(this.log, Intrinsics.stringPlus("Start caching ", url), null, 2, null);
        new Thread(new Runnable() { // from class: fm.feed.android.playersdk.ExoMixingAudioPlayer$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                ExoMixingAudioPlayer.m8758cacheMedia$lambda4(factoryDataSourceFactoryCreator$PlayerSdk_exoDefaultRelease, dataSpecCreateDataSpec$PlayerSdk_exoDefaultRelease, this, listener);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cacheMedia$lambda-4, reason: not valid java name */
    public static final void m8758cacheMedia$lambda4(DataSource.Factory dataSourceFactory, DataSpec dataSpec, ExoMixingAudioPlayer this$0, CacheMediaListener listener) {
        Intrinsics.checkNotNullParameter(dataSourceFactory, "$dataSourceFactory");
        Intrinsics.checkNotNullParameter(dataSpec, "$dataSpec");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        try {
            PlayerProxy.Companion companion = PlayerProxy.INSTANCE;
            SimpleCache simpleCache = this$0.simpleCache;
            Intrinsics.checkNotNull(simpleCache);
            companion.cache$PlayerSdk_exoDefaultRelease(dataSourceFactory, dataSpec, simpleCache, new byte[131072], false, new AtomicBoolean(false), listener);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final MediaSource createMediaSource(String url) {
        TimeTracker timeTracker = new TimeTracker(this, url);
        timeTracker.setBufferingStartTime(System.currentTimeMillis());
        timeTracker.setBufferingEndTime(0L);
        this.tracker.add(timeTracker);
        DataSource.Factory factoryDataSourceFactoryCreator$PlayerSdk_exoDefaultRelease = PlayerProxy.INSTANCE.dataSourceFactoryCreator$PlayerSdk_exoDefaultRelease(this.context, null);
        Uri uri = Uri.parse(url);
        PlayerProxy.Companion companion = PlayerProxy.INSTANCE;
        SimpleCache simpleCache = this.simpleCache;
        Intrinsics.checkNotNull(simpleCache);
        CacheDataSource.Factory factoryCreateDateSourceFactory = companion.createDateSourceFactory(simpleCache, factoryDataSourceFactoryCreator$PlayerSdk_exoDefaultRelease);
        PlayerProxy.Companion companion2 = PlayerProxy.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(uri, "uri");
        return companion2.getExtractorMediaSource(factoryCreateDateSourceFactory, uri, getKey(url));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: seekTo$lambda-5, reason: not valid java name */
    public static final void m8765seekTo$lambda5(ExoMixingAudioPlayer this$0, float f) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.seekTo(f);
    }

    @Override // fm.feed.android.playersdk.MixingAudioPlayer
    public void seekTo(final float seconds) {
        if (!enThread(new Runnable() { // from class: fm.feed.android.playersdk.ExoMixingAudioPlayer$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                ExoMixingAudioPlayer.m8765seekTo$lambda5(this.f$0, seconds);
            }
        }) && seconds >= getCurrentPlayTime()) {
            if (seconds > maxSeekableLengthInSeconds()) {
                seconds = maxSeekableLengthInSeconds();
            }
            float f = seconds * 1000.0f;
            if (this.mPrimaryPlayer.getPlayer().getDuration() > f) {
                this.mPrimaryPlayer.getPlayer().seekTo(((long) f) + ((long) getCurrentPlayTime()));
                return;
            }
            long duration = ((long) f) - (this.mPrimaryPlayer.getPlayer().getDuration() - this.mPrimaryPlayer.getPlayer().getCurrentPosition());
            if (duration < this.mSecondaryPlayer.getPlayer().getDuration()) {
                this.mSecondaryPlayer.getPlayer().seekTo(duration);
                Play play = this.mPrimaryPlayer.getPlay();
                if (play != null) {
                    skipCurrent$default(this, play, 1, null, 4, null);
                }
            }
        }
    }

    @Override // fm.feed.android.playersdk.MixingAudioPlayer
    public float maxSeekableLengthInSeconds() {
        long duration = this.mPrimaryPlayer.getPlayer().getDuration() - this.mPrimaryPlayer.getPlayer().getCurrentPosition();
        if (this.mSecondaryPlayer.getBReadyForPlayback() && !this.mSecondaryPlayer.getBStartHasBeenReported()) {
            duration += this.mSecondaryPlayer.getPlayer().getDuration() - 5000;
        }
        return duration / 1000.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: addAudioAsset$lambda-6, reason: not valid java name */
    public static final void m8757addAudioAsset$lambda6(ExoMixingAudioPlayer this$0, Play play) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(play, "$play");
        this$0.addAudioAsset(play);
    }

    @Override // fm.feed.android.playersdk.MixingAudioPlayer
    public void addAudioAsset(final Play play) {
        Intrinsics.checkNotNullParameter(play, "play");
        if (enThread(new Runnable() { // from class: fm.feed.android.playersdk.ExoMixingAudioPlayer$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() {
                ExoMixingAudioPlayer.m8757addAudioAsset$lambda6(this.f$0, play);
            }
        })) {
            return;
        }
        FMLog.d$default(this.log, Intrinsics.stringPlus("adding new audio asset ", play), null, 2, null);
        FMLog.v$default(this.log, Intrinsics.stringPlus("state: ", this), null, 2, null);
        this.mQueuedAudioAssets.add(play);
        preparePlayer(this.bisPlaying);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean preparePlayer(boolean playWhenReady) {
        FMLog.i$default(this.log, "preparePlayer", null, 2, null);
        if (this.bIsFadingOut) {
            return false;
        }
        Play play = this.mPreparingPlayer.getPlay();
        Play playPeek = this.mQueuedAudioAssets.peek();
        if (play != null && playPeek != null && Intrinsics.areEqual(playPeek.getId(), play.getId())) {
            if (playWhenReady) {
                this.mQueuedAudioAssets.remove(playPeek);
                switchPreparingReferences();
                this.mPrimaryPlayer.getPlayer().setPlayWhenReady(true);
            }
            return true;
        }
        if (playWhenReady && this.mPrimaryPlayer.getPlay() == null) {
            return loadPrimaryPlayer();
        }
        if (this.mPrimaryPlayer.getPlay() == null && this.mSecondaryPlayer.getPlay() == null && !this.bIsFadingOut) {
            return loadSecondaryPlayer();
        }
        return false;
    }

    private final boolean loadPrimaryPlayer() {
        FMLog.i$default(this.log, "trying to load primary player", null, 2, null);
        if (this.mQueuedAudioAssets.size() > 0 && !this.bIsFadingOut) {
            Play playPoll = this.mQueuedAudioAssets.poll();
            if (playPoll != null) {
                MediaSource mediaSourceCreateMediaSource = createMediaSource(playPoll.getAudioFile().getUrl());
                this.mPrimaryPlayer.setBStartHasBeenReported(false);
                this.mPrimaryPlayer.setBEndHasBeenReported(false);
                this.mPrimaryPlayer.setBReadyForPlayback(false);
                this.mPrimaryPlayer.setPlay(playPoll);
                PlayerProxy.INSTANCE.prepare(this.mPrimaryPlayer.getPlayer(), mediaSourceCreateMediaSource);
                if (getBTrimmingEnabled() && playPoll.getAudioFile().getStartTrim() > 0.0f && playPoll.getAudioFile().getStartTrim() < playPoll.getAudioFile().getDurationInSeconds()) {
                    this.mPrimaryPlayer.getPlayer().seekTo((long) (playPoll.getAudioFile().getStartTrim() * 1000));
                }
                this.mPrimaryPlayer.getPlayer().setPlayWhenReady(true);
                FMLog.d$default(this.log, "Loaded a song into player, and playing when ready", null, 2, null);
                return true;
            }
        } else {
            FMLog.d$default(this.log, "Nothing to load into primary player", null, 2, null);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean loadSecondaryPlayer() {
        FMLog.i$default(this.log, "trying to load secondary player", null, 2, null);
        if (this.mQueuedAudioAssets.size() <= 0 || this.bIsFadingOut) {
            return false;
        }
        Play playPoll = this.mQueuedAudioAssets.poll();
        if ((playPoll == null ? null : playPoll.getAudioFile()) == null) {
            return false;
        }
        FMLog.d$default(this.log, Intrinsics.stringPlus("Loading secondary player with play ", playPoll), null, 2, null);
        this.mSecondaryPlayer.setBStartHasBeenReported(false);
        this.mSecondaryPlayer.setBEndHasBeenReported(false);
        this.mSecondaryPlayer.setBReadyForPlayback(false);
        this.mSecondaryPlayer.setPlay(playPoll);
        PlayerProxy.INSTANCE.prepare(this.mSecondaryPlayer.getPlayer(), createMediaSource(playPoll.getAudioFile().getUrl()));
        if (getBTrimmingEnabled() && playPoll.getAudioFile().getStartTrim() > 0.0f && playPoll.getAudioFile().getStartTrim() < playPoll.getAudioFile().getDurationInSeconds()) {
            this.mSecondaryPlayer.getPlayer().seekTo((long) (playPoll.getAudioFile().getStartTrim() * 1000));
        }
        this.mSecondaryPlayer.getPlayer().setPlayWhenReady(false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: play$lambda-7, reason: not valid java name */
    public static final void m8763play$lambda7(ExoMixingAudioPlayer this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.play();
    }

    @Override // fm.feed.android.playersdk.MixingAudioPlayer
    public void play() {
        if (enThread(new Runnable() { // from class: fm.feed.android.playersdk.ExoMixingAudioPlayer$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                ExoMixingAudioPlayer.m8763play$lambda7(this.f$0);
            }
        })) {
            return;
        }
        FMLog.i$default(this.log, "Play", null, 2, null);
        if (!this.bPaused) {
            this.bTimeFlag = true;
            this.mTimeTracker.setBufferingStartTime(System.currentTimeMillis());
        }
        this.bPaused = false;
        this.bisPlaying = true;
        if (this.mPrimaryPlayer.getPlay() == null && this.mSecondaryPlayer.getPlay() != null) {
            switchPlayerReferences();
        }
        if (this.mPrimaryPlayer.getPlay() != null) {
            this.mPrimaryPlayer.getPlayer().setPlayWhenReady(true);
        } else {
            if (preparePlayer(true)) {
                return;
            }
            updateToState(State.WAITING_FOR_ITEM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: pause$lambda-8, reason: not valid java name */
    public static final void m8762pause$lambda8(ExoMixingAudioPlayer this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.pause();
    }

    @Override // fm.feed.android.playersdk.MixingAudioPlayer
    public void pause() {
        if (enThread(new Runnable() { // from class: fm.feed.android.playersdk.ExoMixingAudioPlayer$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ExoMixingAudioPlayer.m8762pause$lambda8(this.f$0);
            }
        })) {
            return;
        }
        Handler handler = null;
        FMLog.i$default(this.log, "Pause", null, 2, null);
        if (getState() == State.READY_TO_PLAY || getState() == State.PAUSED) {
            return;
        }
        this.bPaused = true;
        this.bisPlaying = false;
        Handler handler2 = this.mMainHandler;
        if (handler2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMainHandler");
        } else {
            handler = handler2;
        }
        handler.sendEmptyMessage(2);
        this.mPrimaryPlayer.getPlayer().setPlayWhenReady(false);
        this.mSecondaryPlayer.getPlayer().setPlayWhenReady(false);
        updateToState(State.PAUSED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: skip$lambda-9, reason: not valid java name */
    public static final void m8766skip$lambda9(ExoMixingAudioPlayer this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.skip();
    }

    @Override // fm.feed.android.playersdk.MixingAudioPlayer
    public void skip() {
        Play play;
        if (enThread(new Runnable() { // from class: fm.feed.android.playersdk.ExoMixingAudioPlayer$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                ExoMixingAudioPlayer.m8766skip$lambda9(this.f$0);
            }
        })) {
            return;
        }
        this.bPaused = false;
        Handler handler = this.mMainHandler;
        if (handler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMainHandler");
            handler = null;
        }
        handler.sendEmptyMessageDelayed(1, 500L);
        if (this.mPrimaryPlayer.getPlay() == null || this.bIsFadingOut || (play = this.mPrimaryPlayer.getPlay()) == null) {
            return;
        }
        skipCurrent$default(this, play, 1, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: skipWithCrossFade$lambda-10, reason: not valid java name */
    public static final void m8767skipWithCrossFade$lambda10(ExoMixingAudioPlayer this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.skipWithCrossFade();
    }

    @Override // fm.feed.android.playersdk.MixingAudioPlayer
    public void skipWithCrossFade() {
        if (enThread(new Runnable() { // from class: fm.feed.android.playersdk.ExoMixingAudioPlayer$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                ExoMixingAudioPlayer.m8767skipWithCrossFade$lambda10(this.f$0);
            }
        }) || this.mPrimaryPlayer.getPlay() == null || this.bIsFadingOut) {
            return;
        }
        final Play play = this.mPrimaryPlayer.getPlay();
        final Runnable runnable = new Runnable() { // from class: fm.feed.android.playersdk.ExoMixingAudioPlayer$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                ExoMixingAudioPlayer.m8768skipWithCrossFade$lambda11(this.f$0, play);
            }
        };
        new Timer().schedule(new TimerTask() { // from class: fm.feed.android.playersdk.ExoMixingAudioPlayer.skipWithCrossFade.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (ExoMixingAudioPlayer.this.mSecondaryPlayer.getBReadyForPlayback()) {
                    cancel();
                    Handler handler = ExoMixingAudioPlayer.this.mMainHandler;
                    if (handler == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mMainHandler");
                        handler = null;
                    }
                    handler.post(runnable);
                }
            }
        }, 0L, 250L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: skipWithCrossFade$lambda-11, reason: not valid java name */
    public static final void m8768skipWithCrossFade$lambda11(ExoMixingAudioPlayer this$0, Play play) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Play play2 = this$0.mPrimaryPlayer.getPlay();
        if (!Intrinsics.areEqual(play, play2)) {
            FMLog.w$default(this$0.log, "skip timer expired, but primary play changed!", null, 2, null);
            return;
        }
        if (play2 == null) {
            FMLog.w$default(this$0.log, "skip timer expired, but primary play became null!", null, 2, null);
            return;
        }
        if (this$0.mSecondaryPlayer.getBReadyForPlayback()) {
            float durationInSeconds = (play2.getAudioFile().getDurationInSeconds() - this$0.getCurrentPlayTime()) - play2.getAudioFile().getEndTrim();
            Play play3 = this$0.mSecondaryPlayer.getPlay();
            float durationInSeconds2 = play3 != null ? (play3.getAudioFile().getDurationInSeconds() * 1000) - play2.getAudioFile().getEndTrim() : 0.0f;
            if (this$0._fadeDuration > 0.0f) {
                float f = 1000 * durationInSeconds;
                int i = this$0.mMinimumDurationForCrossFade;
                if (f > i && durationInSeconds2 > i) {
                    FMLog.v$default(this$0.log, "CrossFading to next Station, songDurationLeft =" + durationInSeconds + " durationNextSong=" + durationInSeconds2, null, 2, null);
                    this$0.startFadeOutAndFadeIn(play2, 1);
                    return;
                }
            }
            this$0.skip();
            FMLog.v$default(this$0.log, "Cannot skip with crossFade, Skipping songDurationLeft =" + durationInSeconds + " durationNextSong=" + durationInSeconds2, null, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void processUpdate() {
        MixingAudioPlayer.EventListener mEventListener;
        MixingAudioPlayer.EventListener mEventListener2;
        if (getState() == State.WAITING_FOR_ITEM) {
            FMLog.d$default(this.log, "waiting for item, so cancelling update loop", null, 2, null);
            Handler handler = this.mMainHandler;
            if (handler == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMainHandler");
                handler = null;
            }
            handler.sendEmptyMessage(2);
        }
        long currentPosition = this.mPrimaryPlayer.getPlayer().getCurrentPosition();
        long duration = this.mPrimaryPlayer.getPlayer().getDuration();
        if (getState() == State.PLAYING && !this.bIsFadingOut && this.mPrimaryPlayer.getPlayer().getBufferedPercentage() > 10 && this.mSecondaryPlayer.getPlay() == null && loadSecondaryPlayer()) {
            FMLog.d$default(this.log, "Kicked off secondary load since primary has played past 10%", null, 2, null);
        }
        if ((currentPosition / duration) * 100 > 10.0d && !this.mPrimaryPlayer.getBStartHasBeenReported()) {
            this.mPrimaryPlayer.setBStartHasBeenReported(true);
            Play play = this.mPrimaryPlayer.getPlay();
            if (play != null && (mEventListener2 = getMEventListener()) != null) {
                mEventListener2.onPlayItemBeganPlayback(-1, play, -1L);
            }
        }
        Play play2 = this.mPrimaryPlayer.getPlay();
        if (getMEventListener() != null && currentPosition < duration && play2 != null && getState() == State.PLAYING && this.mPrimaryPlayer.getPlayer().getPlayWhenReady() && !this.mPrimaryPlayer.getBEndHasBeenReported() && (mEventListener = getMEventListener()) != null) {
            mEventListener.onProgressUpdate(play2, currentPosition / 1000.0f, duration / 1000.0f);
        }
        if (play2 != null) {
            AudioFile audioFile = play2.getAudioFile();
            long jFloor = getBTrimmingEnabled() ? (duration - ((long) Math.floor(audioFile.getStartTrim() * 1000.0f))) - ((long) Math.floor(audioFile.getEndTrim() * 1000.0f)) : duration;
            float f = this._fadeDuration;
            if (f <= 0.0f || jFloor <= this.mMinimumDurationForCrossFade) {
                if (!getBTrimmingEnabled() || play2.getAudioFile().getEndTrim() <= 0.0f || (duration - currentPosition) - ((long) Math.floor(play2.getAudioFile().getEndTrim() * 1000.0f)) > 0) {
                    return;
                }
                primaryPlayerCompleted();
                return;
            }
            if (duration <= 0 || currentPosition >= duration) {
                return;
            }
            long endTrim = (duration - currentPosition) - ((long) f);
            if (getBTrimmingEnabled()) {
                endTrim -= (long) (play2.getAudioFile().getEndTrim() * 1000);
            }
            if (endTrim < 500) {
                FMLog.v$default(this.log, Intrinsics.stringPlus(" Before fade out. state: ", this), null, 2, null);
                if (this.mSecondaryPlayer.getPlay() != null && this.mSecondaryPlayer.getPlayer().getPlaybackState() == 3) {
                    if (this.crossFadeInEnabled) {
                        scheduleFadeOutAndFadeIn();
                        return;
                    } else {
                        scheduleFadeOutNoFadeIn();
                        return;
                    }
                }
                scheduleFadeOutNoFadeIn();
            }
        }
    }

    private final void scheduleFadeOutAndFadeIn() {
        Play play = this.mPrimaryPlayer.getPlay();
        if (play == null) {
            return;
        }
        long currentPosition = this.mPrimaryPlayer.getPlayer().getCurrentPosition();
        long duration = this.mPrimaryPlayer.getPlayer().getDuration();
        long endTrim = (duration - currentPosition) - ((long) this._fadeDuration);
        if (getBTrimmingEnabled()) {
            endTrim -= (long) (play.getAudioFile().getEndTrim() * 1000.0f);
        }
        if (endTrim < 0) {
            FMLog.d$default(this.log, "scheduling fadeout/fadein in negative seconds! position = " + currentPosition + ", duration = " + duration, null, 2, null);
        }
        this.mPrimaryPlayer.setPlay(null);
        startFadeOutAndFadeIn$default(this, play, 0, 2, null);
    }

    private final void scheduleFadeOutNoFadeIn() {
        Play play = this.mPrimaryPlayer.getPlay();
        if (play == null) {
            return;
        }
        long currentPosition = this.mPrimaryPlayer.getPlayer().getCurrentPosition();
        long duration = this.mPrimaryPlayer.getPlayer().getDuration();
        long endTrim = (duration - currentPosition) - ((long) this._fadeDuration);
        if (getBTrimmingEnabled()) {
            endTrim -= (long) (play.getAudioFile().getEndTrim() * 1000.0f);
        }
        if (endTrim < 0) {
            FMLog.e$default(this.log, "scheduling fadeout/no fade in in negative seconds! position = " + currentPosition + ", duration = " + duration, null, 2, null);
        }
        this.mPrimaryPlayer.setPlay(null);
        startFadeOutNoFadeIn(play);
    }

    private final void startFadeOutNoFadeIn(Play previousPlay) {
        FMLog.i$default(this.log, "Fading out only", null, 2, null);
        if (this.mSecondaryPlayer.getPlay() != null) {
            switchPlayerReferences();
            if (getMEventListener() != null) {
                this.mPrimaryPlayer.setBEndHasBeenReported(true);
                MixingAudioPlayer.EventListener mEventListener = getMEventListener();
                if (mEventListener != null) {
                    mEventListener.onPlayItemFinishedPlayback(previousPlay, 0, getCurrentPlayTime(), null);
                }
            }
            this.mSecondaryPlayer.setPlay(null);
            this.mPrimaryPlayer.getPlayer().setPlayWhenReady(true);
            this.mSecondaryPlayer.getPlayer().setPlayWhenReady(true);
            startFadeOut();
            return;
        }
        if (loadSecondaryPlayer()) {
            switchPlayerReferences();
            if (getMEventListener() != null) {
                this.mPrimaryPlayer.setBEndHasBeenReported(true);
                MixingAudioPlayer.EventListener mEventListener2 = getMEventListener();
                if (mEventListener2 != null) {
                    mEventListener2.onPlayItemFinishedPlayback(previousPlay, 0, getCurrentPlayTime(), null);
                }
            }
            startFadeOut();
            this.mPrimaryPlayer.getPlayer().setPlayWhenReady(true);
            return;
        }
        switchPlayerReferences();
        updateToState(State.WAITING_FOR_ITEM);
        if (getMEventListener() != null) {
            this.mPrimaryPlayer.setBEndHasBeenReported(true);
            MixingAudioPlayer.EventListener mEventListener3 = getMEventListener();
            if (mEventListener3 != null) {
                mEventListener3.onPlayItemFinishedPlayback(previousPlay, 0, getCurrentPlayTime(), null);
            }
        }
        startFadeOut();
        FMLog.d$default(this.log, "Nothing to fade out to", null, 2, null);
    }

    static /* synthetic */ void startFadeOutAndFadeIn$default(ExoMixingAudioPlayer exoMixingAudioPlayer, Play play, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        exoMixingAudioPlayer.startFadeOutAndFadeIn(play, i);
    }

    private final void startFadeOutAndFadeIn(Play previousPlay, int completionReason) {
        FMLog.i$default(this.log, "Volume check primaryPlayer at " + PlayerProxy.INSTANCE.getVolume(this.mPrimaryPlayer.getPlayer()) + " and secondary " + PlayerProxy.INSTANCE.getVolume(this.mSecondaryPlayer.getPlayer()) + " fading in", null, 2, null);
        FMLog.i$default(this.log, "Fading out and fading in", null, 2, null);
        if (this.mSecondaryPlayer.getPlayer().getPlaybackState() == 3) {
            switchPlayerReferences();
            if (getMEventListener() != null) {
                this.mPrimaryPlayer.setBEndHasBeenReported(true);
                MixingAudioPlayer.EventListener mEventListener = getMEventListener();
                if (mEventListener != null) {
                    mEventListener.onPlayItemFinishedPlayback(previousPlay, completionReason, this.mSecondaryPlayer.getPlayer().getCurrentPosition() / 1000.0f, null);
                }
            }
            startFadeOut();
            startFadeIn();
            return;
        }
        if (loadSecondaryPlayer()) {
            switchPlayerReferences();
            this.mPrimaryPlayer.getPlayer().setPlayWhenReady(true);
            if (getMEventListener() != null) {
                this.mPrimaryPlayer.setBEndHasBeenReported(true);
                MixingAudioPlayer.EventListener mEventListener2 = getMEventListener();
                if (mEventListener2 != null) {
                    mEventListener2.onPlayItemFinishedPlayback(previousPlay, completionReason, this.mSecondaryPlayer.getPlayer().getCurrentPosition() / 1000.0f, null);
                }
            }
            startFadeOut();
            return;
        }
        switchPlayerReferences();
        updateToState(State.WAITING_FOR_ITEM);
        if (getMEventListener() != null) {
            this.mPrimaryPlayer.setBEndHasBeenReported(true);
            MixingAudioPlayer.EventListener mEventListener3 = getMEventListener();
            if (mEventListener3 != null) {
                mEventListener3.onPlayItemFinishedPlayback(previousPlay, completionReason, this.mSecondaryPlayer.getPlayer().getCurrentPosition(), null);
            }
        }
        startFadeOut();
        FMLog.d$default(this.log, "Nothing to fade out to", null, 2, null);
    }

    private final void startFadeIn() {
        FMLog.d$default(this.log, "Starting primary player fade in", null, 2, null);
        this.volumeMin = 0.0f;
        float playingVolume = this.mPrimaryPlayer.getPlayingVolume() / ((int) (this._fadeDuration / 100.0f));
        PlayerProxy.INSTANCE.setVolume(this.mPrimaryPlayer.getPlayer(), this.volumeMin);
        this.mPrimaryPlayer.getPlayer().setPlayWhenReady(true);
        Timer timer = new Timer(true);
        timer.schedule(new ExoMixingAudioPlayer$startFadeIn$timerTask$1(this, playingVolume, timer), 100L, 100L);
    }

    private final void startFadeOut() {
        if (this.bIsFadingOut) {
            return;
        }
        this.bIsFadingOut = true;
        FMLog.v$default(this.log, "Starting secondary player fade out", null, 2, null);
        this.volumeMax = this.mSecondaryPlayer.getPlayingVolume();
        float playingVolume = this.mSecondaryPlayer.getPlayingVolume() / ((int) (this._fadeDuration / 100.0f));
        Timer timer = new Timer(true);
        timer.schedule(new ExoMixingAudioPlayer$startFadeOut$timerTask$1(this, playingVolume, timer, this.mSecondaryPlayer.getPlay()), 100L, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void primaryPlayerCompleted() {
        FMLog.d$default(this.log, "primary player completed playback", null, 2, null);
        this.mPrimaryPlayer.setBStartHasBeenReported(false);
        this.mPrimaryPlayer.setBReadyForPlayback(false);
        this.mPrimaryPlayer.setBEndHasBeenReported(false);
        Play play = this.mPrimaryPlayer.getPlay();
        if (play != null) {
            skipCurrent$default(this, play, 0, null, 4, null);
        }
    }

    private final void switchPreparingReferences() {
        FMLog.d$default(this.log, "about to swap players. primary is now " + this.mPrimaryPlayer + ", and preparing is " + this.mPreparingPlayer, null, 2, null);
        this.mPreparingPlayer.getPlayer().removeListener(this.preparingPlayerProxy.getExoListener());
        this.mPrimaryPlayer.getPlayer().removeListener(this.primaryPlayerProxy.getExoListener());
        PlayAndPlayer playAndPlayer = this.mPrimaryPlayer;
        PlayAndPlayer playAndPlayer2 = this.mPreparingPlayer;
        this.mPrimaryPlayer = playAndPlayer2;
        this.mPreparingPlayer = playAndPlayer;
        playAndPlayer2.setBStartHasBeenReported(false);
        this.mPrimaryPlayer.setBEndHasBeenReported(false);
        this.mPreparingPlayer.setBStartHasBeenReported(false);
        this.mPreparingPlayer.setBReadyForPlayback(false);
        this.mPreparingPlayer.setBEndHasBeenReported(false);
        this.mPrimaryPlayer.getPlayer().addListener(this.primaryPlayerProxy.getExoListener());
        this.mPreparingPlayer.getPlayer().addListener(this.preparingPlayerProxy.getExoListener());
        FMLog.d$default(this.log, "players have been swapped. primary is now " + this.mPrimaryPlayer + ", and preparing is " + this.mPreparingPlayer, null, 2, null);
    }

    private final void switchPlayerReferences() {
        FMLog.d$default(this.log, "about to swap players. primary is now " + this.mPrimaryPlayer + ", and secondary is " + this.mSecondaryPlayer, null, 2, null);
        if (this.mSecondaryPlayer.getPlayer().getPlaybackState() == 4) {
            FMLog.e$default(this.log, "Secondary player had state ended but is being swapped to primary, This could cause problems!!!", null, 2, null);
        }
        this.mPrimaryPlayer.getPlayer().removeListener(this.primaryPlayerProxy.getExoListener());
        this.mSecondaryPlayer.getPlayer().removeListener(this.secondaryPlayerProxy.getExoListener());
        PlayAndPlayer playAndPlayer = this.mPrimaryPlayer;
        PlayAndPlayer playAndPlayer2 = this.mSecondaryPlayer;
        this.mPrimaryPlayer = playAndPlayer2;
        this.mSecondaryPlayer = playAndPlayer;
        playAndPlayer2.setBStartHasBeenReported(false);
        this.mPrimaryPlayer.setBEndHasBeenReported(false);
        this.mSecondaryPlayer.setBStartHasBeenReported(false);
        this.mSecondaryPlayer.setBReadyForPlayback(false);
        this.mSecondaryPlayer.setBEndHasBeenReported(false);
        this.mPrimaryPlayer.getPlayer().addListener(this.primaryPlayerProxy.getExoListener());
        this.mSecondaryPlayer.getPlayer().addListener(this.secondaryPlayerProxy.getExoListener());
        FMLog.d$default(this.log, "players have been swapped. primary is now " + this.mPrimaryPlayer + ", and secondary is " + this.mSecondaryPlayer, null, 2, null);
    }

    static /* synthetic */ void skipCurrent$default(ExoMixingAudioPlayer exoMixingAudioPlayer, Play play, int i, Exception exc, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            exc = null;
        }
        exoMixingAudioPlayer.skipCurrent(play, i, exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void skipCurrent(Play previousPlay, int reason, Exception error) {
        FMLog.d$default(this.log, "Skip current", null, 2, null);
        FMLog.v$default(this.log, "state: " + this + "@ExoMixingAudioPlayer", null, 2, null);
        if (!this.mPrimaryPlayer.getBStartHasBeenReported() && this.mPrimaryPlayer.getPlayer().getPlaybackState() == 2 && reason != 3) {
            FMLog.d$default(this.log, "New song is still being loaded into primary player no need to skip", null, 2, null);
            return;
        }
        if (this.mSecondaryPlayer.getPlay() != null || loadSecondaryPlayer()) {
            if (getMEventListener() != null && !this.mPrimaryPlayer.getBEndHasBeenReported()) {
                this.mPrimaryPlayer.setBEndHasBeenReported(true);
                MixingAudioPlayer.EventListener mEventListener = getMEventListener();
                if (mEventListener != null) {
                    mEventListener.onPlayItemFinishedPlayback(previousPlay, reason, getCurrentPlayTime(), error);
                }
            }
            switchPlayerReferences();
            this.mSecondaryPlayer.setPlay(null);
            this.mSecondaryPlayer.getPlayer().setPlayWhenReady(false);
            this.mPrimaryPlayer.getPlayer().setPlayWhenReady(true);
        } else {
            if (getMEventListener() != null && !this.mPrimaryPlayer.getBEndHasBeenReported()) {
                this.mPrimaryPlayer.setBEndHasBeenReported(true);
                MixingAudioPlayer.EventListener mEventListener2 = getMEventListener();
                if (mEventListener2 != null) {
                    mEventListener2.onPlayItemFinishedPlayback(previousPlay, reason, getCurrentPlayTime(), error);
                }
            }
            FMLog.d$default(this.log, "Finished playback of all songs", null, 2, null);
            this.mPrimaryPlayer.setPlay(null);
            this.mPrimaryPlayer.setBReadyForPlayback(false);
            this.mPrimaryPlayer.setBStartHasBeenReported(false);
            this.mPrimaryPlayer.setBEndHasBeenReported(false);
            updateToState(State.WAITING_FOR_ITEM);
        }
        FMLog.v$default(this.log, "state: " + this + "@ExoMixingAudioPlayer", null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: flush$lambda-13, reason: not valid java name */
    public static final void m8760flush$lambda13(ExoMixingAudioPlayer this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.flush();
    }

    @Override // fm.feed.android.playersdk.MixingAudioPlayer
    public void flush() {
        if (enThread(new Runnable() { // from class: fm.feed.android.playersdk.ExoMixingAudioPlayer$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                ExoMixingAudioPlayer.m8760flush$lambda13(this.f$0);
            }
        })) {
            return;
        }
        Handler handler = null;
        FMLog.e$default(this.log, "FLUSHED", null, 2, null);
        this.mQueuedAudioAssets.clear();
        this.mSecondaryPlayer.getPlayer().stop();
        this.mPrimaryPlayer.getPlayer().stop();
        if (getState() == State.PLAYING || getState() == State.STALLED) {
            updateToState(State.WAITING_FOR_ITEM);
        } else if (getState() != State.PAUSED) {
            updateToState(State.READY_TO_PLAY);
        }
        Play play = this.mPrimaryPlayer.getPlay();
        if (getMEventListener() != null && play != null) {
            this.mPrimaryPlayer.setBEndHasBeenReported(true);
            MixingAudioPlayer.EventListener mEventListener = getMEventListener();
            if (mEventListener != null) {
                mEventListener.onPlayItemFinishedPlayback(play, 2, getCurrentPlayTime(), null);
            }
        }
        this.mPrimaryPlayer.setPlay(null);
        this.mPrimaryPlayer.setBReadyForPlayback(false);
        this.mPrimaryPlayer.setBStartHasBeenReported(false);
        this.mPrimaryPlayer.setBEndHasBeenReported(false);
        this.mSecondaryPlayer.setPlay(null);
        this.mSecondaryPlayer.setBReadyForPlayback(false);
        this.mSecondaryPlayer.setBStartHasBeenReported(false);
        this.mSecondaryPlayer.setBEndHasBeenReported(false);
        Handler handler2 = this.mMainHandler;
        if (handler2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMainHandler");
        } else {
            handler = handler2;
        }
        handler.sendEmptyMessage(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: flushAndIncludeCurrent$lambda-14, reason: not valid java name */
    public static final void m8761flushAndIncludeCurrent$lambda14(ExoMixingAudioPlayer this$0, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.flushAndIncludeCurrent(z);
    }

    @Override // fm.feed.android.playersdk.MixingAudioPlayer
    public void flushAndIncludeCurrent(final boolean bTrue) {
        if (enThread(new Runnable() { // from class: fm.feed.android.playersdk.ExoMixingAudioPlayer$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                ExoMixingAudioPlayer.m8761flushAndIncludeCurrent$lambda14(this.f$0, bTrue);
            }
        })) {
            return;
        }
        FMLog.v$default(this.log, Intrinsics.stringPlus("flushing player", bTrue ? " along with current play" : ""), null, 2, null);
        if (bTrue) {
            flush();
            return;
        }
        this.mQueuedAudioAssets.clear();
        this.mSecondaryPlayer.getPlayer().stop();
        this.mSecondaryPlayer.setPlay(null);
    }

    public String toString() {
        return "{  state: " + getState() + ", primaryPlayer: " + this.mPrimaryPlayer + ", secondaryPlayer: " + this.mSecondaryPlayer + ", preparingPlayer: " + this.mPreparingPlayer + ", timeFlag: " + this.bTimeFlag + ", isPaused: " + this.bPaused + ", isPlaying: " + this.bisPlaying + ", queuedAudioAssets: " + this.mQueuedAudioAssets.size() + ", isFadingOut: " + this.bIsFadingOut + " }";
    }

    /* compiled from: ExoMixingAudioPlayer.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010!\u001a\u00020\"H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lfm/feed/android/playersdk/ExoMixingAudioPlayer$PlayAndPlayer;", "", "(Lfm/feed/android/playersdk/ExoMixingAudioPlayer;)V", "bEndHasBeenReported", "", "getBEndHasBeenReported", "()Z", "setBEndHasBeenReported", "(Z)V", "bReadyForPlayback", "getBReadyForPlayback", "setBReadyForPlayback", "bStartHasBeenReported", "getBStartHasBeenReported", "setBStartHasBeenReported", "play", "Lfm/feed/android/playersdk/models/Play;", "getPlay", "()Lfm/feed/android/playersdk/models/Play;", "setPlay", "(Lfm/feed/android/playersdk/models/Play;)V", "player", "Lcom/google/android/exoplayer2/ExoPlayer;", "getPlayer", "()Lcom/google/android/exoplayer2/ExoPlayer;", "setPlayer", "(Lcom/google/android/exoplayer2/ExoPlayer;)V", "playingVolume", "", "getPlayingVolume", "()F", "setPlayingVolume", "(F)V", "toString", "", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class PlayAndPlayer {
        private boolean bEndHasBeenReported;
        private boolean bReadyForPlayback;
        private boolean bStartHasBeenReported;
        private Play play;
        public ExoPlayer player;
        private float playingVolume;
        final /* synthetic */ ExoMixingAudioPlayer this$0;

        public PlayAndPlayer(ExoMixingAudioPlayer this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this.this$0 = this$0;
            this.playingVolume = 1.0f;
        }

        public final ExoPlayer getPlayer() {
            ExoPlayer exoPlayer = this.player;
            if (exoPlayer != null) {
                return exoPlayer;
            }
            Intrinsics.throwUninitializedPropertyAccessException("player");
            return null;
        }

        public final void setPlayer(ExoPlayer exoPlayer) {
            Intrinsics.checkNotNullParameter(exoPlayer, "<set-?>");
            this.player = exoPlayer;
        }

        public final Play getPlay() {
            return this.play;
        }

        public final void setPlay(Play play) {
            this.play = play;
        }

        public final boolean getBReadyForPlayback() {
            return this.bReadyForPlayback;
        }

        public final void setBReadyForPlayback(boolean z) {
            this.bReadyForPlayback = z;
        }

        public final boolean getBStartHasBeenReported() {
            return this.bStartHasBeenReported;
        }

        public final void setBStartHasBeenReported(boolean z) {
            this.bStartHasBeenReported = z;
        }

        public final boolean getBEndHasBeenReported() {
            return this.bEndHasBeenReported;
        }

        public final void setBEndHasBeenReported(boolean z) {
            this.bEndHasBeenReported = z;
        }

        public final float getPlayingVolume() {
            return this.playingVolume;
        }

        public final void setPlayingVolume(float f) {
            this.playingVolume = f;
        }

        public String toString() {
            return "{ play: " + this.play + ", player: " + ("{ state: \"" + ExoMixingAudioPlayer.INSTANCE.exoplayerStateToString(getPlayer().getPlaybackState()) + ", buffPercentage: " + getPlayer().getBufferedPercentage() + ", buffPosition: " + getPlayer().getBufferedPosition() + ", currentPosition: " + getPlayer().getCurrentPosition() + ", duration: " + getPlayer().getDuration() + ", playWhenReady: " + getPlayer().getPlayWhenReady() + " }") + ", readyForPlayback: " + this.bReadyForPlayback + ", startHasBeenReported: " + this.bStartHasBeenReported + ", playingVolume: " + this.playingVolume + " }";
        }
    }

    /* compiled from: ExoMixingAudioPlayer.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lfm/feed/android/playersdk/ExoMixingAudioPlayer$Companion;", "", "()V", "CANCEL_MESSAGE", "", "FADE_INTERVAL", "UPDATE_INTERVAL", "UPDATE_MESSAGE", "exoplayerStateToString", "", ServerProtocol.DIALOG_PARAM_STATE, "stateToString", "Lfm/feed/android/playersdk/State;", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {

        /* compiled from: ExoMixingAudioPlayer.kt */
        @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[State.values().length];
                iArr[State.PAUSED.ordinal()] = 1;
                iArr[State.PLAYING.ordinal()] = 2;
                iArr[State.READY_TO_PLAY.ordinal()] = 3;
                iArr[State.STALLED.ordinal()] = 4;
                iArr[State.WAITING_FOR_ITEM.ordinal()] = 5;
                iArr[State.AVAILABLE_OFFLINE_ONLY.ordinal()] = 6;
                iArr[State.UNAVAILABLE.ordinal()] = 7;
                iArr[State.UNINITIALIZED.ordinal()] = 8;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String stateToString(State state) {
            switch (WhenMappings.$EnumSwitchMapping$0[state.ordinal()]) {
                case 1:
                    return "STATE_PAUSED";
                case 2:
                    return "STATE_PLAYING";
                case 3:
                    return "STATE_READY_TO_PLAY";
                case 4:
                    return "STATE_STALLED";
                case 5:
                    return "STATE_WAITING_FOR_ITEM";
                case 6:
                    return "AVAILABLE_OFFLINE_ONLY";
                case 7:
                    return "UNAVAILABLE";
                case 8:
                    return "UNINITIALIZED";
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String exoplayerStateToString(int state) {
            if (state == 1) {
                return "IDLE";
            }
            if (state == 2) {
                return "BUFFERING";
            }
            if (state == 3) {
                return "READY";
            }
            if (state == 4) {
                return "ENDED";
            }
            return "** unknown state **";
        }
    }
}
