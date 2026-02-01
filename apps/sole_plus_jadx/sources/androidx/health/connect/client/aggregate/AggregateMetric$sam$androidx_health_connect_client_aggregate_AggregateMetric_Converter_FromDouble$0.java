package androidx.health.connect.client.aggregate;

import androidx.health.connect.client.aggregate.AggregateMetric;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AggregateMetric.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
final class AggregateMetric$sam$androidx_health_connect_client_aggregate_AggregateMetric_Converter_FromDouble$0 implements AggregateMetric.Converter.FromDouble, FunctionAdapter {
    private final /* synthetic */ Function1 function;

    AggregateMetric$sam$androidx_health_connect_client_aggregate_AggregateMetric_Converter_FromDouble$0(Function1 function) {
        Intrinsics.checkNotNullParameter(function, "function");
        this.function = function;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof AggregateMetric.Converter.FromDouble) && (obj instanceof FunctionAdapter)) {
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.FunctionAdapter
    public final Function<?> getFunctionDelegate() {
        return this.function;
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    public final /* synthetic */ Object invoke(double d) {
        return this.function.invoke(Double.valueOf(d));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).doubleValue());
    }
}
