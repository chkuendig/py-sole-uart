package androidx.health.connect.client.records;

import androidx.health.connect.client.units.Mass;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: NutritionRecord.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class NutritionRecord$Companion$MAGNESIUM_TOTAL$1 extends FunctionReferenceImpl implements Function1<Double, Mass> {
    NutritionRecord$Companion$MAGNESIUM_TOTAL$1(Object obj) {
        super(1, obj, Mass.Companion.class, "grams", "grams(D)Landroidx/health/connect/client/units/Mass;", 0);
    }

    public final Mass invoke(double d) {
        return ((Mass.Companion) this.receiver).grams(d);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Mass invoke(Double d) {
        return invoke(d.doubleValue());
    }
}
