package fm.feed.android.playersdk.models;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Placement.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\nJ\u0013\u0010\u001b\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001a\u001a\u00020\nJ\b\u0010\u001e\u001a\u00020\u0003H\u0016R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\b\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00108\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001f"}, d2 = {"Lfm/feed/android/playersdk/models/Placement;", "", "id", "", "(Ljava/lang/Integer;)V", "getId", "()Ljava/lang/Integer;", "setId", "Ljava/lang/Integer;", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "", "stationList", "", "Lfm/feed/android/playersdk/models/Station;", "getStationList", "()Ljava/util/List;", "setStationList", "(Ljava/util/List;)V", "containsOption", "", "key", "equals", "other", "getOption", "hashCode", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class Placement {

    @SerializedName("id")
    private Integer id;

    @SerializedName("name")
    private String name;

    @SerializedName(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS)
    private final Map<String, Object> options;
    private transient List<Station> stationList;

    public Placement(Integer num) {
        this.id = num;
    }

    public final Integer getId() {
        return this.id;
    }

    public final void setId(Integer num) {
        this.id = num;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final List<Station> getStationList() {
        return this.stationList;
    }

    public final void setStationList(List<Station> list) {
        this.stationList = list;
    }

    public final boolean containsOption(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Map<String, Object> map = this.options;
        if (map == null) {
            return false;
        }
        return map.containsKey(key);
    }

    public final Object getOption(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Map<String, Object> map = this.options;
        if (map == null) {
            return null;
        }
        return map.get(key);
    }

    public int hashCode() {
        Integer num = this.id;
        if (num == null) {
            return 0;
        }
        Intrinsics.checkNotNull(num);
        return Integer.hashCode(num.intValue());
    }

    public boolean equals(Object other) {
        return other != null && (other instanceof Placement) && Intrinsics.areEqual(((Placement) other).id, this.id);
    }
}
