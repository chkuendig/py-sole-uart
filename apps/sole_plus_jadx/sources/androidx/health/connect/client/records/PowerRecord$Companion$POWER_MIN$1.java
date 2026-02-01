package androidx.health.connect.client.records;

import androidx.health.connect.client.units.Power;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: PowerRecord.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class PowerRecord$Companion$POWER_MIN$1 extends FunctionReferenceImpl implements Function1<Double, Power> {
    PowerRecord$Companion$POWER_MIN$1(Object obj) {
        super(1, obj, Power.Companion.class, "watts", "watts(D)Landroidx/health/connect/client/units/Power;", 0);
    }

    public final Power invoke(double d) {
        return ((Power.Companion) this.receiver).watts(d);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Power invoke(Double d) {
        return invoke(d.doubleValue());
    }
}
