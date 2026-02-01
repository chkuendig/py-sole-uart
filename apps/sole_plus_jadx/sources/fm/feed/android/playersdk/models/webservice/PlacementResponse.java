package fm.feed.android.playersdk.models.webservice;

import com.google.gson.annotations.SerializedName;
import fm.feed.android.playersdk.models.Placement;
import fm.feed.android.playersdk.models.Station;
import java.util.List;
import kotlin.Metadata;

/* compiled from: PlacementResponse.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lfm/feed/android/playersdk/models/webservice/PlacementResponse;", "Lfm/feed/android/playersdk/models/webservice/FeedFMResponse;", "()V", "placement", "Lfm/feed/android/playersdk/models/Placement;", "getPlacement", "()Lfm/feed/android/playersdk/models/Placement;", "stations", "", "Lfm/feed/android/playersdk/models/Station;", "getStations", "()Ljava/util/List;", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class PlacementResponse extends FeedFMResponse {

    @SerializedName("placement")
    private final Placement placement;

    @SerializedName("stations")
    private final List<Station> stations;

    public final Placement getPlacement() {
        return this.placement;
    }

    public final List<Station> getStations() {
        return this.stations;
    }
}
