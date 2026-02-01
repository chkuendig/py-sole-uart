package fm.feed.android.playersdk;

import fm.feed.android.playersdk.models.Play;
import kotlin.Metadata;

/* compiled from: SimulcastAudioPlayer.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J \u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH&¨\u0006\u0010"}, d2 = {"Lfm/feed/android/playersdk/SimulcastEventListener;", "", "onPlayItemBeganPlayback", "", "play", "Lfm/feed/android/playersdk/models/Play;", "onPlayerError", "error", "Ljava/lang/Exception;", "onPlayerStateChanged", "playerState", "Lfm/feed/android/playersdk/SimulcastPlaybackState;", "onProgressUpdate", "elapsedTime", "", "duration", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public interface SimulcastEventListener {
    void onPlayItemBeganPlayback(Play play);

    void onPlayerError(Exception error);

    void onPlayerStateChanged(SimulcastPlaybackState playerState);

    void onProgressUpdate(Play play, float elapsedTime, float duration);
}
