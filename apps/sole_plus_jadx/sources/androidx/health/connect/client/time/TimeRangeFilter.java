package androidx.health.connect.client.time;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.time.Instant;
import java.time.LocalDateTime;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TimeRangeFilter.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B7\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\r\u0010\u0014\u001a\u00020\u0010H\u0000¢\u0006\u0002\b\u0015R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0017"}, d2 = {"Landroidx/health/connect/client/time/TimeRangeFilter;", "", "startTime", "Ljava/time/Instant;", SDKConstants.PARAM_END_TIME, "localStartTime", "Ljava/time/LocalDateTime;", "localEndTime", "(Ljava/time/Instant;Ljava/time/Instant;Ljava/time/LocalDateTime;Ljava/time/LocalDateTime;)V", "getEndTime", "()Ljava/time/Instant;", "getLocalEndTime", "()Ljava/time/LocalDateTime;", "getLocalStartTime", "getStartTime", "equals", "", "other", "hashCode", "", "isOpenEnded", "isOpenEnded$connect_client_release", "Companion", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TimeRangeFilter {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Instant endTime;
    private final LocalDateTime localEndTime;
    private final LocalDateTime localStartTime;
    private final Instant startTime;

    public TimeRangeFilter() {
        this(null, null, null, null, 15, null);
    }

    @JvmStatic
    public static final TimeRangeFilter after(Instant instant) {
        return INSTANCE.after(instant);
    }

    @JvmStatic
    public static final TimeRangeFilter after(LocalDateTime localDateTime) {
        return INSTANCE.after(localDateTime);
    }

    @JvmStatic
    public static final TimeRangeFilter before(Instant instant) {
        return INSTANCE.before(instant);
    }

    @JvmStatic
    public static final TimeRangeFilter before(LocalDateTime localDateTime) {
        return INSTANCE.before(localDateTime);
    }

    @JvmStatic
    public static final TimeRangeFilter between(Instant instant, Instant instant2) {
        return INSTANCE.between(instant, instant2);
    }

    @JvmStatic
    public static final TimeRangeFilter between(LocalDateTime localDateTime, LocalDateTime localDateTime2) {
        return INSTANCE.between(localDateTime, localDateTime2);
    }

    public TimeRangeFilter(Instant instant, Instant instant2, LocalDateTime localDateTime, LocalDateTime localDateTime2) {
        this.startTime = instant;
        this.endTime = instant2;
        this.localStartTime = localDateTime;
        this.localEndTime = localDateTime2;
    }

    public /* synthetic */ TimeRangeFilter(Instant instant, Instant instant2, LocalDateTime localDateTime, LocalDateTime localDateTime2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : instant, (i & 2) != 0 ? null : instant2, (i & 4) != 0 ? null : localDateTime, (i & 8) != 0 ? null : localDateTime2);
    }

    public final Instant getStartTime() {
        return this.startTime;
    }

    public final Instant getEndTime() {
        return this.endTime;
    }

    public final LocalDateTime getLocalStartTime() {
        return this.localStartTime;
    }

    public final LocalDateTime getLocalEndTime() {
        return this.localEndTime;
    }

    /* compiled from: TimeRangeFilter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006H\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0007H\u0007J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0007J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0007J\r\u0010\u000b\u001a\u00020\u0004H\u0001¢\u0006\u0002\b\f¨\u0006\r"}, d2 = {"Landroidx/health/connect/client/time/TimeRangeFilter$Companion;", "", "()V", "after", "Landroidx/health/connect/client/time/TimeRangeFilter;", "startTime", "Ljava/time/Instant;", "Ljava/time/LocalDateTime;", "before", SDKConstants.PARAM_END_TIME, "between", "none", "none$connect_client_release", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final TimeRangeFilter between(Instant startTime, Instant endTime) {
            Intrinsics.checkNotNullParameter(startTime, "startTime");
            Intrinsics.checkNotNullParameter(endTime, "endTime");
            if (!startTime.isBefore(endTime)) {
                throw new IllegalArgumentException("end time needs be after start time".toString());
            }
            return new TimeRangeFilter(startTime, endTime, null, null, 12, null);
        }

        @JvmStatic
        public final TimeRangeFilter between(LocalDateTime startTime, LocalDateTime endTime) {
            Intrinsics.checkNotNullParameter(startTime, "startTime");
            Intrinsics.checkNotNullParameter(endTime, "endTime");
            if (!startTime.isBefore(endTime)) {
                throw new IllegalArgumentException("end time needs be after start time".toString());
            }
            return new TimeRangeFilter(null, null, startTime, endTime);
        }

        @JvmStatic
        public final TimeRangeFilter before(Instant endTime) {
            Intrinsics.checkNotNullParameter(endTime, "endTime");
            return new TimeRangeFilter(null, endTime, null, null, 12, null);
        }

        @JvmStatic
        public final TimeRangeFilter before(LocalDateTime endTime) {
            Intrinsics.checkNotNullParameter(endTime, "endTime");
            return new TimeRangeFilter(null, null, null, endTime);
        }

        @JvmStatic
        public final TimeRangeFilter after(Instant startTime) {
            Intrinsics.checkNotNullParameter(startTime, "startTime");
            return new TimeRangeFilter(startTime, null, null, null, 14, null);
        }

        @JvmStatic
        public final TimeRangeFilter after(LocalDateTime startTime) {
            Intrinsics.checkNotNullParameter(startTime, "startTime");
            return new TimeRangeFilter(null, null, startTime, null, 8, null);
        }

        @JvmStatic
        public final TimeRangeFilter none$connect_client_release() {
            return new TimeRangeFilter(null, null, null, null, 15, null);
        }
    }

    public final boolean isOpenEnded$connect_client_release() {
        return (this.localStartTime == null || this.localEndTime == null) && (this.startTime == null || this.endTime == null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TimeRangeFilter)) {
            return false;
        }
        TimeRangeFilter timeRangeFilter = (TimeRangeFilter) other;
        return Intrinsics.areEqual(this.startTime, timeRangeFilter.startTime) && Intrinsics.areEqual(this.endTime, timeRangeFilter.endTime) && Intrinsics.areEqual(this.localStartTime, timeRangeFilter.localStartTime) && Intrinsics.areEqual(this.localEndTime, timeRangeFilter.localEndTime);
    }

    public int hashCode() {
        Instant instant = this.startTime;
        int iHashCode = (instant != null ? instant.hashCode() : 0) * 31;
        Instant instant2 = this.endTime;
        int iHashCode2 = (iHashCode + (instant2 != null ? instant2.hashCode() : 0)) * 31;
        LocalDateTime localDateTime = this.localStartTime;
        int iHashCode3 = (iHashCode2 + (localDateTime != null ? localDateTime.hashCode() : 0)) * 31;
        LocalDateTime localDateTime2 = this.localEndTime;
        return iHashCode3 + (localDateTime2 != null ? localDateTime2.hashCode() : 0);
    }
}
