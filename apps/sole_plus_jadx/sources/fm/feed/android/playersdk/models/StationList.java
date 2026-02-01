package fm.feed.android.playersdk.models;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StationList.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u001a\u0010\t\u001a\u00020\u00002\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u000bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\u0006J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u000b¨\u0006\u0011"}, d2 = {"Lfm/feed/android/playersdk/models/StationList;", "Ljava/util/LinkedList;", "Lfm/feed/android/playersdk/models/Station;", "()V", "getAllStationsWithOption", "key", "", "value", "", "getAllStationsWithOptions", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "", "getStationWithName", "name", "getStationWithOption", "getStationWithOptions", "Companion", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public class StationList extends LinkedList<Station> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public /* bridge */ boolean contains(Station station) {
        return super.contains((Object) station);
    }

    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Station) {
            return contains((Station) obj);
        }
        return false;
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ int indexOf(Station station) {
        return super.indexOf((Object) station);
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Station) {
            return indexOf((Station) obj);
        }
        return -1;
    }

    public /* bridge */ int lastIndexOf(Station station) {
        return super.lastIndexOf((Object) station);
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Station) {
            return lastIndexOf((Station) obj);
        }
        return -1;
    }

    @Override // java.util.LinkedList, java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public final /* bridge */ Station remove(int i) {
        return removeAt(i);
    }

    public /* bridge */ boolean remove(Station station) {
        return super.remove((Object) station);
    }

    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof Station) {
            return remove((Station) obj);
        }
        return false;
    }

    public /* bridge */ Station removeAt(int i) {
        return (Station) super.remove(i);
    }

    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
    public final /* bridge */ int size() {
        return getSize();
    }

    public final Station getStationWithOption(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Iterator it = iterator();
        while (it.hasNext()) {
            Station station = (Station) it.next();
            Companion companion = INSTANCE;
            Intrinsics.checkNotNullExpressionValue(station, "station");
            if (companion.stationMatches(station, key, value)) {
                return station;
            }
        }
        return null;
    }

    public final Station getStationWithOption(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Iterator it = iterator();
        while (it.hasNext()) {
            Station station = (Station) it.next();
            if (station.containsOption(key)) {
                return station;
            }
        }
        return null;
    }

    public final Station getStationWithOptions(Map<String, ? extends Object> options) {
        Intrinsics.checkNotNullParameter(options, "options");
        Iterator it = iterator();
        while (it.hasNext()) {
            Station station = (Station) it.next();
            Companion companion = INSTANCE;
            Intrinsics.checkNotNullExpressionValue(station, "station");
            if (companion.stationMatches(station, options)) {
                return station;
            }
        }
        return null;
    }

    public final Station getStationWithName(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Iterator it = iterator();
        while (it.hasNext()) {
            Station station = (Station) it.next();
            if (Intrinsics.areEqual(station.getName(), name)) {
                return station;
            }
        }
        return null;
    }

    public final StationList getAllStationsWithOption(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        StationList stationList = new StationList();
        Iterator it = iterator();
        while (it.hasNext()) {
            Station station = (Station) it.next();
            Companion companion = INSTANCE;
            Intrinsics.checkNotNullExpressionValue(station, "station");
            if (companion.stationMatches(station, key, value)) {
                stationList.add(station);
            }
        }
        return stationList;
    }

    public final StationList getAllStationsWithOption(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        StationList stationList = new StationList();
        Iterator it = iterator();
        while (it.hasNext()) {
            Station station = (Station) it.next();
            if (station.containsOption(key)) {
                stationList.add(station);
            }
        }
        return stationList;
    }

    public final StationList getAllStationsWithOptions(Map<String, ? extends Object> options) {
        Intrinsics.checkNotNullParameter(options, "options");
        StationList stationList = new StationList();
        Iterator it = iterator();
        while (it.hasNext()) {
            Station station = (Station) it.next();
            Companion companion = INSTANCE;
            Intrinsics.checkNotNullExpressionValue(station, "station");
            if (companion.stationMatches(station, options)) {
                stationList.add(station);
            }
        }
        return stationList;
    }

    /* compiled from: StationList.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0001J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u000b¨\u0006\f"}, d2 = {"Lfm/feed/android/playersdk/models/StationList$Companion;", "", "()V", "stationMatches", "", "station", "Lfm/feed/android/playersdk/models/Station;", "key", "", "value", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean stationMatches(Station station, Map<String, ? extends Object> options) {
            Intrinsics.checkNotNullParameter(station, "station");
            Intrinsics.checkNotNullParameter(options, "options");
            for (String str : options.keySet()) {
                if (!stationMatches(station, str, options.get(str))) {
                    return false;
                }
            }
            return true;
        }

        public final boolean stationMatches(Station station, String key, Object value) {
            Intrinsics.checkNotNullParameter(station, "station");
            Intrinsics.checkNotNullParameter(key, "key");
            Object option = station.getOption(key);
            if (option == null) {
                return false;
            }
            if (Intrinsics.areEqual(option, value)) {
                return true;
            }
            if (!Intrinsics.areEqual(option.getClass(), ArrayList.class)) {
                return false;
            }
            Iterator it = ((ArrayList) option).iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(it.next(), value)) {
                    return true;
                }
            }
            return false;
        }
    }
}
