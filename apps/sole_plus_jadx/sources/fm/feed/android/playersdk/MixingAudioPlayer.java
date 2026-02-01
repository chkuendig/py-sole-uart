package fm.feed.android.playersdk;

import com.android.SdkConstants;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import fm.feed.android.playersdk.models.Play;
import kotlin.Metadata;

/* compiled from: MixingAudioPlayer.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\bf\u0018\u0000 ;2\u00020\u0001:\u0002;<J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\tH&J \u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H&J\b\u0010/\u001a\u00020&H&J\b\u00100\u001a\u00020&H&J\u0010\u00101\u001a\u00020&2\u0006\u00102\u001a\u00020\u0003H&J\b\u00103\u001a\u00020\rH&J\b\u00104\u001a\u00020&H&J\b\u0010'\u001a\u00020&H&J\u0010\u00105\u001a\u00020&2\u0006\u00106\u001a\u00020\tH&J\u0010\u00107\u001a\u00020&2\u0006\u00108\u001a\u00020\rH&J\b\u00109\u001a\u00020&H&J\b\u0010:\u001a\u00020&H&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0018\u0010\u0012\u001a\u00020\rX¦\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u0017X¦\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001c\u001a\u00020\u001dX¦\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0018\u0010\"\u001a\u00020\rX¦\u000e¢\u0006\f\u001a\u0004\b#\u0010\u000f\"\u0004\b$\u0010\u0015¨\u0006="}, d2 = {"Lfm/feed/android/playersdk/MixingAudioPlayer;", "", "bTrimmingEnabled", "", "getBTrimmingEnabled", "()Z", "setBTrimmingEnabled", "(Z)V", "currentPlay", "Lfm/feed/android/playersdk/models/Play;", "getCurrentPlay", "()Lfm/feed/android/playersdk/models/Play;", "currentPlayDuration", "", "getCurrentPlayDuration", "()F", "currentPlayTime", "getCurrentPlayTime", "fadeDuration", "getFadeDuration", "setFadeDuration", "(F)V", "mEventListener", "Lfm/feed/android/playersdk/MixingAudioPlayer$EventListener;", "getMEventListener", "()Lfm/feed/android/playersdk/MixingAudioPlayer$EventListener;", "setMEventListener", "(Lfm/feed/android/playersdk/MixingAudioPlayer$EventListener;)V", ServerProtocol.DIALOG_PARAM_STATE, "Lfm/feed/android/playersdk/State;", "getState", "()Lfm/feed/android/playersdk/State;", "setState", "(Lfm/feed/android/playersdk/State;)V", "volume", "getVolume", "setVolume", "addAudioAsset", "", "play", "cacheMedia", "url", "", "maxCache", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lfm/feed/android/playersdk/CacheMediaListener;", "destroy", "flush", "flushAndIncludeCurrent", "bTrue", "maxSeekableLengthInSeconds", "pause", "prepareTrack", "file", "seekTo", "seconds", SdkConstants.TAG_SKIP, "skipWithCrossFade", "Companion", "EventListener", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public interface MixingAudioPlayer {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int PLAY_COMPLETION_ERROR = 3;
    public static final int PLAY_COMPLETION_FLUSHED = 2;
    public static final int PLAY_COMPLETION_REACHED_END = 0;
    public static final int PLAY_COMPLETION_SKIPPED = 1;

    /* compiled from: MixingAudioPlayer.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u00060\u0007j\u0002`\bH&J \u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH&J0\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u000e\u0010\u0006\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\bH&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H&J \u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0011H&¨\u0006\u0019"}, d2 = {"Lfm/feed/android/playersdk/MixingAudioPlayer$EventListener;", "", "onPlayFailedToPrepare", "", "play", "Lfm/feed/android/playersdk/models/Play;", "error", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onPlayItemBeganPlayback", "waitingTime", "", "bufferingTime", "", "onPlayItemFinishedPlayback", "reason", "timePlayed", "", "onPlayItemReadyForPlayback", "onPlayerStateChanged", "playerState", "Lfm/feed/android/playersdk/State;", "onProgressUpdate", "elapsedTime", "duration", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface EventListener {
        void onPlayFailedToPrepare(Play play, Exception error);

        void onPlayItemBeganPlayback(int waitingTime, Play play, long bufferingTime);

        void onPlayItemFinishedPlayback(Play play, int reason, float timePlayed, Exception error);

        void onPlayItemReadyForPlayback(Play play);

        void onPlayerStateChanged(State playerState);

        void onProgressUpdate(Play play, float elapsedTime, float duration);
    }

    void addAudioAsset(Play play);

    void cacheMedia(String url, int maxCache, CacheMediaListener listener);

    void destroy();

    void flush();

    void flushAndIncludeCurrent(boolean bTrue);

    boolean getBTrimmingEnabled();

    Play getCurrentPlay();

    float getCurrentPlayDuration();

    float getCurrentPlayTime();

    float getFadeDuration();

    EventListener getMEventListener();

    State getState();

    float getVolume();

    float maxSeekableLengthInSeconds();

    void pause();

    void play();

    void prepareTrack(Play file);

    void seekTo(float seconds);

    void setBTrimmingEnabled(boolean z);

    void setFadeDuration(float f);

    void setMEventListener(EventListener eventListener);

    void setState(State state);

    void setVolume(float f);

    void skip();

    void skipWithCrossFade();

    /* compiled from: MixingAudioPlayer.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lfm/feed/android/playersdk/MixingAudioPlayer$Companion;", "", "()V", "PLAY_COMPLETION_ERROR", "", "PLAY_COMPLETION_FLUSHED", "PLAY_COMPLETION_REACHED_END", "PLAY_COMPLETION_SKIPPED", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int PLAY_COMPLETION_ERROR = 3;
        public static final int PLAY_COMPLETION_FLUSHED = 2;
        public static final int PLAY_COMPLETION_REACHED_END = 0;
        public static final int PLAY_COMPLETION_SKIPPED = 1;

        private Companion() {
        }
    }
}
