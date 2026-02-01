package fm.feed.android.playersdk.models.webservice;

import com.google.gson.annotations.SerializedName;
import fm.feed.android.playersdk.models.Placement;
import fm.feed.android.playersdk.models.Session;
import fm.feed.android.playersdk.models.Station;
import java.util.List;
import kotlin.Metadata;

/* compiled from: SessionResponse.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006\u0014"}, d2 = {"Lfm/feed/android/playersdk/models/webservice/SessionResponse;", "Lfm/feed/android/playersdk/models/webservice/FeedFMResponse;", "()V", "offlinePlacement", "Lfm/feed/android/playersdk/models/Placement;", "getOfflinePlacement", "()Lfm/feed/android/playersdk/models/Placement;", "placement", "getPlacement", "remoteOfflineStations", "", "Lfm/feed/android/playersdk/models/Station;", "getRemoteOfflineStations", "()Ljava/util/List;", "session", "Lfm/feed/android/playersdk/models/Session;", "getSession", "()Lfm/feed/android/playersdk/models/Session;", "stations", "getStations", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class SessionResponse extends FeedFMResponse {

    @SerializedName("offline_placement")
    private final Placement offlinePlacement;

    @SerializedName("placement")
    private final Placement placement;

    @SerializedName("offline_stations")
    private final List<Station> remoteOfflineStations;

    @SerializedName("session")
    private final Session session;

    @SerializedName("stations")
    private final List<Station> stations;

    public final Session getSession() {
        return this.session;
    }

    public final Placement getPlacement() {
        return this.placement;
    }

    public final List<Station> getStations() {
        return this.stations;
    }

    public final Placement getOfflinePlacement() {
        return this.offlinePlacement;
    }

    public final List<Station> getRemoteOfflineStations() {
        return this.remoteOfflineStations;
    }
}
