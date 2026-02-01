package androidx.health.connect.client.records;

import androidx.core.location.LocationCompat;
import androidx.health.connect.client.records.ExerciseRoute;
import androidx.health.connect.client.units.Length;
import java.time.Instant;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExerciseRoute.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Landroidx/health/connect/client/records/ExerciseRoute;", "", "route", "", "Landroidx/health/connect/client/records/ExerciseRoute$Location;", "(Ljava/util/List;)V", "getRoute", "()Ljava/util/List;", "equals", "", "other", "hashCode", "", "toString", "", "Location", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ExerciseRoute {
    private final List<Location> route;

    public ExerciseRoute(List<Location> route) {
        Intrinsics.checkNotNullParameter(route, "route");
        this.route = route;
        List listSortedWith = CollectionsKt.sortedWith(route, new Comparator() { // from class: androidx.health.connect.client.records.ExerciseRoute$special$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((ExerciseRoute.Location) t).getTime(), ((ExerciseRoute.Location) t2).getTime());
            }
        });
        int lastIndex = CollectionsKt.getLastIndex(listSortedWith);
        int i = 0;
        while (i < lastIndex) {
            Instant time = ((Location) listSortedWith.get(i)).getTime();
            i++;
            if (!time.isBefore(((Location) listSortedWith.get(i)).getTime())) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        }
    }

    public final List<Location> getRoute() {
        return this.route;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ExerciseRoute) {
            return Intrinsics.areEqual(this.route, ((ExerciseRoute) other).route);
        }
        return false;
    }

    public int hashCode() {
        return this.route.hashCode();
    }

    public String toString() {
        return "ExerciseRoute(route=" + this.route + ')';
    }

    /* compiled from: ExerciseRoute.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cBA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u000bJ\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006\u001d"}, d2 = {"Landroidx/health/connect/client/records/ExerciseRoute$Location;", "", "time", "Ljava/time/Instant;", "latitude", "", "longitude", "horizontalAccuracy", "Landroidx/health/connect/client/units/Length;", LocationCompat.EXTRA_VERTICAL_ACCURACY, "altitude", "(Ljava/time/Instant;DDLandroidx/health/connect/client/units/Length;Landroidx/health/connect/client/units/Length;Landroidx/health/connect/client/units/Length;)V", "getAltitude", "()Landroidx/health/connect/client/units/Length;", "getHorizontalAccuracy", "getLatitude", "()D", "getLongitude", "getTime", "()Ljava/time/Instant;", "getVerticalAccuracy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Location {
        private static final double MAX_LATITUDE = 90.0d;
        private static final double MAX_LONGITUDE = 180.0d;
        private static final double MIN_LATITUDE = -90.0d;
        private static final double MIN_LONGITUDE = -180.0d;
        private final Length altitude;
        private final Length horizontalAccuracy;
        private final double latitude;
        private final double longitude;
        private final Instant time;
        private final Length verticalAccuracy;

        public Location(Instant time, double d, double d2, Length length, Length length2, Length length3) {
            Intrinsics.checkNotNullParameter(time, "time");
            this.time = time;
            this.latitude = d;
            this.longitude = d2;
            this.horizontalAccuracy = length;
            this.verticalAccuracy = length2;
            this.altitude = length3;
            UtilsKt.requireNotLess(Double.valueOf(d), Double.valueOf(MIN_LATITUDE), "latitude");
            UtilsKt.requireNotMore(Double.valueOf(d), Double.valueOf(MAX_LATITUDE), "latitude");
            UtilsKt.requireNotLess(Double.valueOf(d2), Double.valueOf(MIN_LONGITUDE), "longitude");
            UtilsKt.requireNotMore(Double.valueOf(d2), Double.valueOf(MAX_LONGITUDE), "longitude");
            if (length != null) {
                UtilsKt.requireNotLess(length, length.zero$connect_client_release(), "horizontalAccuracy");
            }
            if (length2 != null) {
                UtilsKt.requireNotLess(length2, length2.zero$connect_client_release(), LocationCompat.EXTRA_VERTICAL_ACCURACY);
            }
        }

        public /* synthetic */ Location(Instant instant, double d, double d2, Length length, Length length2, Length length3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(instant, d, d2, (i & 8) != 0 ? null : length, (i & 16) != 0 ? null : length2, (i & 32) != 0 ? null : length3);
        }

        public final Instant getTime() {
            return this.time;
        }

        public final double getLatitude() {
            return this.latitude;
        }

        public final double getLongitude() {
            return this.longitude;
        }

        public final Length getHorizontalAccuracy() {
            return this.horizontalAccuracy;
        }

        public final Length getVerticalAccuracy() {
            return this.verticalAccuracy;
        }

        public final Length getAltitude() {
            return this.altitude;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Location)) {
                return false;
            }
            Location location = (Location) other;
            return Intrinsics.areEqual(this.time, location.time) && this.latitude == location.latitude && this.longitude == location.longitude && Intrinsics.areEqual(this.horizontalAccuracy, location.horizontalAccuracy) && Intrinsics.areEqual(this.verticalAccuracy, location.verticalAccuracy) && Intrinsics.areEqual(this.altitude, location.altitude);
        }

        public int hashCode() {
            int iHashCode = ((((this.time.hashCode() * 31) + Double.hashCode(this.latitude)) * 31) + Double.hashCode(this.longitude)) * 31;
            Length length = this.horizontalAccuracy;
            int iHashCode2 = (iHashCode + (length != null ? length.hashCode() : 0)) * 31;
            Length length2 = this.verticalAccuracy;
            int iHashCode3 = (iHashCode2 + (length2 != null ? length2.hashCode() : 0)) * 31;
            Length length3 = this.altitude;
            return iHashCode3 + (length3 != null ? length3.hashCode() : 0);
        }

        public String toString() {
            return "Location(time=" + this.time + ", latitude=" + this.latitude + ", longitude=" + this.longitude + ", horizontalAccuracy=" + this.horizontalAccuracy + ", verticalAccuracy=" + this.verticalAccuracy + ", altitude=" + this.altitude + ')';
        }
    }
}
