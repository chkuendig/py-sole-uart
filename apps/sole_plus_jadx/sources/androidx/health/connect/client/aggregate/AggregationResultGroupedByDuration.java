package androidx.health.connect.client.aggregate;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.time.Instant;
import java.time.ZoneOffset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AggregationResultGroupedByDuration.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/health/connect/client/aggregate/AggregationResultGroupedByDuration;", "", "result", "Landroidx/health/connect/client/aggregate/AggregationResult;", "startTime", "Ljava/time/Instant;", SDKConstants.PARAM_END_TIME, "zoneOffset", "Ljava/time/ZoneOffset;", "(Landroidx/health/connect/client/aggregate/AggregationResult;Ljava/time/Instant;Ljava/time/Instant;Ljava/time/ZoneOffset;)V", "getEndTime", "()Ljava/time/Instant;", "getResult", "()Landroidx/health/connect/client/aggregate/AggregationResult;", "getStartTime", "getZoneOffset", "()Ljava/time/ZoneOffset;", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AggregationResultGroupedByDuration {
    private final Instant endTime;
    private final AggregationResult result;
    private final Instant startTime;
    private final ZoneOffset zoneOffset;

    public AggregationResultGroupedByDuration(AggregationResult result, Instant startTime, Instant endTime, ZoneOffset zoneOffset) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(zoneOffset, "zoneOffset");
        this.result = result;
        this.startTime = startTime;
        this.endTime = endTime;
        this.zoneOffset = zoneOffset;
        if (!startTime.isBefore(endTime)) {
            throw new IllegalArgumentException("start time must be before end time".toString());
        }
    }

    public final AggregationResult getResult() {
        return this.result;
    }

    public final Instant getStartTime() {
        return this.startTime;
    }

    public final Instant getEndTime() {
        return this.endTime;
    }

    public final ZoneOffset getZoneOffset() {
        return this.zoneOffset;
    }
}
