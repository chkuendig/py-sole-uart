package fm.feed.android.playersdk;

import fm.feed.android.playersdk.models.Play;
import kotlin.Metadata;

/* compiled from: Listeners.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\r"}, d2 = {"Lfm/feed/android/playersdk/PlayListener;", "", "onPlayStarted", "", "play", "Lfm/feed/android/playersdk/models/Play;", "onProgressUpdate", "elapsedTime", "", "duration", "onSkipStatusChanged", "status", "", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public interface PlayListener {
    void onPlayStarted(Play play);

    void onProgressUpdate(Play play, float elapsedTime, float duration);

    void onSkipStatusChanged(boolean status);
}
