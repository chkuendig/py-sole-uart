package androidx.health.connect.client.records;

import androidx.health.connect.client.units.Pressure;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: BloodPressureRecord.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class BloodPressureRecord$Companion$SYSTOLIC_MIN$1 extends FunctionReferenceImpl implements Function1<Double, Pressure> {
    BloodPressureRecord$Companion$SYSTOLIC_MIN$1(Object obj) {
        super(1, obj, Pressure.Companion.class, "millimetersOfMercury", "millimetersOfMercury(D)Landroidx/health/connect/client/units/Pressure;", 0);
    }

    public final Pressure invoke(double d) {
        return ((Pressure.Companion) this.receiver).millimetersOfMercury(d);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Pressure invoke(Double d) {
        return invoke(d.doubleValue());
    }
}
