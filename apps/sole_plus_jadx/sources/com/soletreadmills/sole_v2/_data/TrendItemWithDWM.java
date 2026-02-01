package com.soletreadmills.sole_v2._data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UserWorkout12WeeklyStatsVoData.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B;\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00018\u0000\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\u0014J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003JJ\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00018\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0004HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0005\u001a\u0004\u0018\u00018\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\f\"\u0004\b\u0019\u0010\u000eR\u001a\u0010\t\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\f\"\u0004\b\u001b\u0010\u000e¨\u0006)"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/TrendItemWithDWM;", "Double", "", "itemName", "", "itemValue", "dailyStats", "Lcom/soletreadmills/sole_v2/_data/DWMTrendStats;", "monthlyStats", "weeklyStats", "(Ljava/lang/String;Ljava/lang/Object;Lcom/soletreadmills/sole_v2/_data/DWMTrendStats;Lcom/soletreadmills/sole_v2/_data/DWMTrendStats;Lcom/soletreadmills/sole_v2/_data/DWMTrendStats;)V", "getDailyStats", "()Lcom/soletreadmills/sole_v2/_data/DWMTrendStats;", "setDailyStats", "(Lcom/soletreadmills/sole_v2/_data/DWMTrendStats;)V", "getItemName", "()Ljava/lang/String;", "setItemName", "(Ljava/lang/String;)V", "getItemValue", "()Ljava/lang/Object;", "setItemValue", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "getMonthlyStats", "setMonthlyStats", "getWeeklyStats", "setWeeklyStats", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Object;Lcom/soletreadmills/sole_v2/_data/DWMTrendStats;Lcom/soletreadmills/sole_v2/_data/DWMTrendStats;Lcom/soletreadmills/sole_v2/_data/DWMTrendStats;)Lcom/soletreadmills/sole_v2/_data/TrendItemWithDWM;", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class TrendItemWithDWM<Double> {
    public static final int $stable = 8;
    private DWMTrendStats dailyStats;
    private String itemName;
    private Double itemValue;
    private DWMTrendStats monthlyStats;
    private DWMTrendStats weeklyStats;

    public TrendItemWithDWM() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TrendItemWithDWM copy$default(TrendItemWithDWM trendItemWithDWM, String str, Object obj, DWMTrendStats dWMTrendStats, DWMTrendStats dWMTrendStats2, DWMTrendStats dWMTrendStats3, int i, Object obj2) {
        if ((i & 1) != 0) {
            str = trendItemWithDWM.itemName;
        }
        Double r5 = obj;
        if ((i & 2) != 0) {
            r5 = trendItemWithDWM.itemValue;
        }
        Double r10 = r5;
        if ((i & 4) != 0) {
            dWMTrendStats = trendItemWithDWM.dailyStats;
        }
        DWMTrendStats dWMTrendStats4 = dWMTrendStats;
        if ((i & 8) != 0) {
            dWMTrendStats2 = trendItemWithDWM.monthlyStats;
        }
        DWMTrendStats dWMTrendStats5 = dWMTrendStats2;
        if ((i & 16) != 0) {
            dWMTrendStats3 = trendItemWithDWM.weeklyStats;
        }
        return trendItemWithDWM.copy(str, r10, dWMTrendStats4, dWMTrendStats5, dWMTrendStats3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getItemName() {
        return this.itemName;
    }

    public final Double component2() {
        return this.itemValue;
    }

    /* renamed from: component3, reason: from getter */
    public final DWMTrendStats getDailyStats() {
        return this.dailyStats;
    }

    /* renamed from: component4, reason: from getter */
    public final DWMTrendStats getMonthlyStats() {
        return this.monthlyStats;
    }

    /* renamed from: component5, reason: from getter */
    public final DWMTrendStats getWeeklyStats() {
        return this.weeklyStats;
    }

    public final TrendItemWithDWM<Double> copy(String itemName, Double itemValue, DWMTrendStats dailyStats, DWMTrendStats monthlyStats, DWMTrendStats weeklyStats) {
        Intrinsics.checkNotNullParameter(dailyStats, "dailyStats");
        Intrinsics.checkNotNullParameter(monthlyStats, "monthlyStats");
        Intrinsics.checkNotNullParameter(weeklyStats, "weeklyStats");
        return new TrendItemWithDWM<>(itemName, itemValue, dailyStats, monthlyStats, weeklyStats);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrendItemWithDWM)) {
            return false;
        }
        TrendItemWithDWM trendItemWithDWM = (TrendItemWithDWM) other;
        return Intrinsics.areEqual(this.itemName, trendItemWithDWM.itemName) && Intrinsics.areEqual(this.itemValue, trendItemWithDWM.itemValue) && Intrinsics.areEqual(this.dailyStats, trendItemWithDWM.dailyStats) && Intrinsics.areEqual(this.monthlyStats, trendItemWithDWM.monthlyStats) && Intrinsics.areEqual(this.weeklyStats, trendItemWithDWM.weeklyStats);
    }

    public int hashCode() {
        String str = this.itemName;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Double r2 = this.itemValue;
        return ((((((iHashCode + (r2 != null ? r2.hashCode() : 0)) * 31) + this.dailyStats.hashCode()) * 31) + this.monthlyStats.hashCode()) * 31) + this.weeklyStats.hashCode();
    }

    public String toString() {
        return "TrendItemWithDWM(itemName=" + this.itemName + ", itemValue=" + this.itemValue + ", dailyStats=" + this.dailyStats + ", monthlyStats=" + this.monthlyStats + ", weeklyStats=" + this.weeklyStats + ')';
    }

    public TrendItemWithDWM(String str, Double r3, DWMTrendStats dailyStats, DWMTrendStats monthlyStats, DWMTrendStats weeklyStats) {
        Intrinsics.checkNotNullParameter(dailyStats, "dailyStats");
        Intrinsics.checkNotNullParameter(monthlyStats, "monthlyStats");
        Intrinsics.checkNotNullParameter(weeklyStats, "weeklyStats");
        this.itemName = str;
        this.itemValue = r3;
        this.dailyStats = dailyStats;
        this.monthlyStats = monthlyStats;
        this.weeklyStats = weeklyStats;
    }

    public final String getItemName() {
        return this.itemName;
    }

    public final void setItemName(String str) {
        this.itemName = str;
    }

    public final Double getItemValue() {
        return this.itemValue;
    }

    public final void setItemValue(Double r1) {
        this.itemValue = r1;
    }

    public /* synthetic */ TrendItemWithDWM(String str, Object obj, DWMTrendStats dWMTrendStats, DWMTrendStats dWMTrendStats2, DWMTrendStats dWMTrendStats3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) == 0 ? obj : null, (i & 4) != 0 ? new DWMTrendStats(null, null, null, null, 15, null) : dWMTrendStats, (i & 8) != 0 ? new DWMTrendStats(null, null, null, null, 15, null) : dWMTrendStats2, (i & 16) != 0 ? new DWMTrendStats(null, null, null, null, 15, null) : dWMTrendStats3);
    }

    public final DWMTrendStats getDailyStats() {
        return this.dailyStats;
    }

    public final void setDailyStats(DWMTrendStats dWMTrendStats) {
        Intrinsics.checkNotNullParameter(dWMTrendStats, "<set-?>");
        this.dailyStats = dWMTrendStats;
    }

    public final DWMTrendStats getMonthlyStats() {
        return this.monthlyStats;
    }

    public final void setMonthlyStats(DWMTrendStats dWMTrendStats) {
        Intrinsics.checkNotNullParameter(dWMTrendStats, "<set-?>");
        this.monthlyStats = dWMTrendStats;
    }

    public final DWMTrendStats getWeeklyStats() {
        return this.weeklyStats;
    }

    public final void setWeeklyStats(DWMTrendStats dWMTrendStats) {
        Intrinsics.checkNotNullParameter(dWMTrendStats, "<set-?>");
        this.weeklyStats = dWMTrendStats;
    }
}
