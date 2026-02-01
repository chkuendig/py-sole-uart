package com.soletreadmills.sole_v2._data.history;

import com.soletreadmills.sole_v2._data.WorkoutRawData4WorkoutDetailDisplay;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChartData.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u001e\u0010\u0006\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\b0\u0007¢\u0006\u0002\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J!\u0010\u0015\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\b0\u0007HÆ\u0003JI\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032 \b\u0002\u0010\u0006\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\b0\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR)\u0010\u0006\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/history/ChartData;", "", "titleRes", "", "unitRes", "colorRes", "extractor", "Lkotlin/Function1;", "", "Lcom/soletreadmills/sole_v2/_data/WorkoutRawData4WorkoutDetailDisplay;", "", "(IIILkotlin/jvm/functions/Function1;)V", "getColorRes", "()I", "getExtractor", "()Lkotlin/jvm/functions/Function1;", "getTitleRes", "getUnitRes", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ChartData {
    public static final int $stable = 0;
    private final int colorRes;
    private final Function1<List<WorkoutRawData4WorkoutDetailDisplay>, List<Float>> extractor;
    private final int titleRes;
    private final int unitRes;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChartData copy$default(ChartData chartData, int i, int i2, int i3, Function1 function1, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = chartData.titleRes;
        }
        if ((i4 & 2) != 0) {
            i2 = chartData.unitRes;
        }
        if ((i4 & 4) != 0) {
            i3 = chartData.colorRes;
        }
        if ((i4 & 8) != 0) {
            function1 = chartData.extractor;
        }
        return chartData.copy(i, i2, i3, function1);
    }

    /* renamed from: component1, reason: from getter */
    public final int getTitleRes() {
        return this.titleRes;
    }

    /* renamed from: component2, reason: from getter */
    public final int getUnitRes() {
        return this.unitRes;
    }

    /* renamed from: component3, reason: from getter */
    public final int getColorRes() {
        return this.colorRes;
    }

    public final Function1<List<WorkoutRawData4WorkoutDetailDisplay>, List<Float>> component4() {
        return this.extractor;
    }

    public final ChartData copy(int titleRes, int unitRes, int colorRes, Function1<? super List<WorkoutRawData4WorkoutDetailDisplay>, ? extends List<Float>> extractor) {
        Intrinsics.checkNotNullParameter(extractor, "extractor");
        return new ChartData(titleRes, unitRes, colorRes, extractor);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChartData)) {
            return false;
        }
        ChartData chartData = (ChartData) other;
        return this.titleRes == chartData.titleRes && this.unitRes == chartData.unitRes && this.colorRes == chartData.colorRes && Intrinsics.areEqual(this.extractor, chartData.extractor);
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.titleRes) * 31) + Integer.hashCode(this.unitRes)) * 31) + Integer.hashCode(this.colorRes)) * 31) + this.extractor.hashCode();
    }

    public String toString() {
        return "ChartData(titleRes=" + this.titleRes + ", unitRes=" + this.unitRes + ", colorRes=" + this.colorRes + ", extractor=" + this.extractor + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChartData(int i, int i2, int i3, Function1<? super List<WorkoutRawData4WorkoutDetailDisplay>, ? extends List<Float>> extractor) {
        Intrinsics.checkNotNullParameter(extractor, "extractor");
        this.titleRes = i;
        this.unitRes = i2;
        this.colorRes = i3;
        this.extractor = extractor;
    }

    public final int getTitleRes() {
        return this.titleRes;
    }

    public final int getUnitRes() {
        return this.unitRes;
    }

    public final int getColorRes() {
        return this.colorRes;
    }

    public final Function1<List<WorkoutRawData4WorkoutDetailDisplay>, List<Float>> getExtractor() {
        return this.extractor;
    }
}
