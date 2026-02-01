package androidx.health.connect.client.aggregate;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.time.LocalDateTime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AggregationResultGroupedByPeriod.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Landroidx/health/connect/client/aggregate/AggregationResultGroupedByPeriod;", "", "result", "Landroidx/health/connect/client/aggregate/AggregationResult;", "startTime", "Ljava/time/LocalDateTime;", SDKConstants.PARAM_END_TIME, "(Landroidx/health/connect/client/aggregate/AggregationResult;Ljava/time/LocalDateTime;Ljava/time/LocalDateTime;)V", "getEndTime", "()Ljava/time/LocalDateTime;", "getResult", "()Landroidx/health/connect/client/aggregate/AggregationResult;", "getStartTime", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AggregationResultGroupedByPeriod {
    private final LocalDateTime endTime;
    private final AggregationResult result;
    private final LocalDateTime startTime;

    public AggregationResultGroupedByPeriod(AggregationResult result, LocalDateTime startTime, LocalDateTime endTime) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        this.result = result;
        this.startTime = startTime;
        this.endTime = endTime;
        if (!startTime.isBefore(endTime)) {
            throw new IllegalArgumentException("start time must be before end time".toString());
        }
    }

    public final AggregationResult getResult() {
        return this.result;
    }

    public final LocalDateTime getStartTime() {
        return this.startTime;
    }

    public final LocalDateTime getEndTime() {
        return this.endTime;
    }
}
