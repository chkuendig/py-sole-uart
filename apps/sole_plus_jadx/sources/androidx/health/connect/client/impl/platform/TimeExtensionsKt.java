package androidx.health.connect.client.impl.platform;

import androidx.camera.video.AudioStats;
import androidx.health.connect.client.records.IntervalRecord;
import androidx.health.connect.client.time.TimeRangeFilter;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TimeExtensions.kt */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0080\u0002\u001a\u0015\u0010\b\u001a\u00020\u0001*\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0080\u0002\u001a\u0016\u0010\u000b\u001a\u00020\t*\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0000\u001a\f\u0010\u000f\u001a\u00020\u0010*\u00020\u0011H\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0012"}, d2 = {"duration", "Ljava/time/Duration;", "Landroidx/health/connect/client/records/IntervalRecord;", "getDuration", "(Landroidx/health/connect/client/records/IntervalRecord;)Ljava/time/Duration;", "div", "", "divisor", "minus", "Ljava/time/Instant;", "other", "toInstantWithDefaultZoneFallback", "Ljava/time/LocalDateTime;", "zoneOffset", "Ljava/time/ZoneOffset;", "useLocalTime", "", "Landroidx/health/connect/client/time/TimeRangeFilter;", "connect-client_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TimeExtensionsKt {
    public static final double div(Duration duration, Duration divisor) {
        Intrinsics.checkNotNullParameter(duration, "<this>");
        Intrinsics.checkNotNullParameter(divisor, "divisor");
        return divisor.isZero() ? AudioStats.AUDIO_AMPLITUDE_NONE : duration.toMillis() / divisor.toMillis();
    }

    public static final Duration minus(Instant instant, Instant other) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Duration durationBetween = Duration.between(other, instant);
        Intrinsics.checkNotNullExpressionValue(durationBetween, "between(other, this)");
        return durationBetween;
    }

    public static final boolean useLocalTime(TimeRangeFilter timeRangeFilter) {
        Intrinsics.checkNotNullParameter(timeRangeFilter, "<this>");
        return (timeRangeFilter.getLocalStartTime() == null && timeRangeFilter.getLocalEndTime() == null) ? false : true;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.time.ZonedDateTime] */
    public static final Instant toInstantWithDefaultZoneFallback(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        Intrinsics.checkNotNullParameter(localDateTime, "<this>");
        Instant instant = localDateTime.atZone(zoneOffset != null ? zoneOffset : ZoneId.systemDefault()).toInstant();
        Intrinsics.checkNotNullExpressionValue(instant, "atZone(zoneOffset ?: Zon…temDefault()).toInstant()");
        return instant;
    }

    public static final Duration getDuration(IntervalRecord intervalRecord) {
        Intrinsics.checkNotNullParameter(intervalRecord, "<this>");
        return minus(intervalRecord.getEndTime(), intervalRecord.getStartTime());
    }
}
