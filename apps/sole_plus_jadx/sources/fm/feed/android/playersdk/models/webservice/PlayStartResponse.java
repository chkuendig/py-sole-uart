package fm.feed.android.playersdk.models.webservice;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* compiled from: PlayStartResponse.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u00020\u00048\u0002X\u0083D¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lfm/feed/android/playersdk/models/webservice/PlayStartResponse;", "Lfm/feed/android/playersdk/models/webservice/FeedFMResponse;", "()V", "canSkip", "", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class PlayStartResponse extends FeedFMResponse {

    @SerializedName("can_skip")
    private final boolean canSkip;

    /* renamed from: canSkip, reason: from getter */
    public final boolean getCanSkip() {
        return this.canSkip;
    }
}
