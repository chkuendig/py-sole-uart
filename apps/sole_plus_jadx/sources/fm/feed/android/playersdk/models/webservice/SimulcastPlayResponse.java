package fm.feed.android.playersdk.models.webservice;

import com.facebook.internal.ServerProtocol;
import com.google.gson.annotations.SerializedName;
import fm.feed.android.playersdk.models.Play;
import kotlin.Metadata;

/* compiled from: SimulcastPlayResponse.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lfm/feed/android/playersdk/models/webservice/SimulcastPlayResponse;", "Lfm/feed/android/playersdk/models/webservice/FeedFMResponse;", "()V", "elapsedSeconds", "", "getElapsedSeconds", "()F", "play", "Lfm/feed/android/playersdk/models/Play;", "getPlay", "()Lfm/feed/android/playersdk/models/Play;", ServerProtocol.DIALOG_PARAM_STATE, "", "getState", "()Ljava/lang/String;", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class SimulcastPlayResponse extends FeedFMResponse {

    @SerializedName("seconds_since_start")
    private final float elapsedSeconds;

    @SerializedName("play")
    private final Play play;

    @SerializedName(ServerProtocol.DIALOG_PARAM_STATE)
    private final String state;

    public final String getState() {
        return this.state;
    }

    public final Play getPlay() {
        return this.play;
    }

    public final float getElapsedSeconds() {
        return this.elapsedSeconds;
    }
}
