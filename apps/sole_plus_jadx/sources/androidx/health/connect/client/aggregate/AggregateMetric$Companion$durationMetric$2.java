package androidx.health.connect.client.aggregate;

import androidx.health.connect.client.aggregate.AggregateMetric;
import java.time.Duration;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AggregateMetric.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class AggregateMetric$Companion$durationMetric$2 implements AggregateMetric.Converter.FromLong, FunctionAdapter {
    public static final AggregateMetric$Companion$durationMetric$2 INSTANCE = new AggregateMetric$Companion$durationMetric$2();

    AggregateMetric$Companion$durationMetric$2() {
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof AggregateMetric.Converter.FromLong) && (obj instanceof FunctionAdapter)) {
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.FunctionAdapter
    public final Function<?> getFunctionDelegate() {
        return new FunctionReferenceImpl(1, Duration.class, "ofMillis", "ofMillis(J)Ljava/time/Duration;", 0);
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).longValue());
    }

    public final Duration invoke(long j) {
        return Duration.ofMillis(j);
    }
}
