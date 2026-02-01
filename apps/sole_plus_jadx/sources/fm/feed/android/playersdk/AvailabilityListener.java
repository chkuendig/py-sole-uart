package fm.feed.android.playersdk;

import kotlin.Metadata;

/* compiled from: Listeners.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0014\u0010\u0006\u001a\u00020\u00032\n\u0010\u0007\u001a\u00060\bj\u0002`\tH&¨\u0006\n"}, d2 = {"Lfm/feed/android/playersdk/AvailabilityListener;", "", "onPlayerAvailable", "", "player", "Lfm/feed/android/playersdk/FeedAudioPlayer;", "onPlayerUnavailable", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public interface AvailabilityListener {
    void onPlayerAvailable(FeedAudioPlayer player);

    void onPlayerUnavailable(Exception e);
}
