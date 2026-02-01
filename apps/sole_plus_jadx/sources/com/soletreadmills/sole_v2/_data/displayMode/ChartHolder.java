package com.soletreadmills.sole_v2._data.displayMode;

import com.soletreadmills.sole_v2._helper.customChart.CustomChartHelper;
import com.soletreadmills.sole_v2._type.DisplayStatsType;
import com.soletreadmills.sole_v2.databinding.CustomDashboardChartBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChartHolder.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\tHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/soletreadmills/sole_v2/_data/displayMode/ChartHolder;", "", "binding", "Lcom/soletreadmills/sole_v2/databinding/CustomDashboardChartBinding;", "config", "Lcom/soletreadmills/sole_v2/_helper/customChart/CustomChartHelper$Config;", "statsType", "Lcom/soletreadmills/sole_v2/_type/DisplayStatsType;", "lastDataSize", "", "(Lcom/soletreadmills/sole_v2/databinding/CustomDashboardChartBinding;Lcom/soletreadmills/sole_v2/_helper/customChart/CustomChartHelper$Config;Lcom/soletreadmills/sole_v2/_type/DisplayStatsType;I)V", "getBinding", "()Lcom/soletreadmills/sole_v2/databinding/CustomDashboardChartBinding;", "getConfig", "()Lcom/soletreadmills/sole_v2/_helper/customChart/CustomChartHelper$Config;", "getLastDataSize", "()I", "setLastDataSize", "(I)V", "getStatsType", "()Lcom/soletreadmills/sole_v2/_type/DisplayStatsType;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ChartHolder {
    public static final int $stable = 8;
    private final CustomDashboardChartBinding binding;
    private final CustomChartHelper.Config config;
    private int lastDataSize;
    private final DisplayStatsType statsType;

    public static /* synthetic */ ChartHolder copy$default(ChartHolder chartHolder, CustomDashboardChartBinding customDashboardChartBinding, CustomChartHelper.Config config, DisplayStatsType displayStatsType, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            customDashboardChartBinding = chartHolder.binding;
        }
        if ((i2 & 2) != 0) {
            config = chartHolder.config;
        }
        if ((i2 & 4) != 0) {
            displayStatsType = chartHolder.statsType;
        }
        if ((i2 & 8) != 0) {
            i = chartHolder.lastDataSize;
        }
        return chartHolder.copy(customDashboardChartBinding, config, displayStatsType, i);
    }

    /* renamed from: component1, reason: from getter */
    public final CustomDashboardChartBinding getBinding() {
        return this.binding;
    }

    /* renamed from: component2, reason: from getter */
    public final CustomChartHelper.Config getConfig() {
        return this.config;
    }

    /* renamed from: component3, reason: from getter */
    public final DisplayStatsType getStatsType() {
        return this.statsType;
    }

    /* renamed from: component4, reason: from getter */
    public final int getLastDataSize() {
        return this.lastDataSize;
    }

    public final ChartHolder copy(CustomDashboardChartBinding binding, CustomChartHelper.Config config, DisplayStatsType statsType, int lastDataSize) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(statsType, "statsType");
        return new ChartHolder(binding, config, statsType, lastDataSize);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChartHolder)) {
            return false;
        }
        ChartHolder chartHolder = (ChartHolder) other;
        return Intrinsics.areEqual(this.binding, chartHolder.binding) && Intrinsics.areEqual(this.config, chartHolder.config) && this.statsType == chartHolder.statsType && this.lastDataSize == chartHolder.lastDataSize;
    }

    public int hashCode() {
        return (((((this.binding.hashCode() * 31) + this.config.hashCode()) * 31) + this.statsType.hashCode()) * 31) + Integer.hashCode(this.lastDataSize);
    }

    public String toString() {
        return "ChartHolder(binding=" + this.binding + ", config=" + this.config + ", statsType=" + this.statsType + ", lastDataSize=" + this.lastDataSize + ')';
    }

    public ChartHolder(CustomDashboardChartBinding binding, CustomChartHelper.Config config, DisplayStatsType statsType, int i) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(statsType, "statsType");
        this.binding = binding;
        this.config = config;
        this.statsType = statsType;
        this.lastDataSize = i;
    }

    public /* synthetic */ ChartHolder(CustomDashboardChartBinding customDashboardChartBinding, CustomChartHelper.Config config, DisplayStatsType displayStatsType, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(customDashboardChartBinding, config, displayStatsType, (i2 & 8) != 0 ? 0 : i);
    }

    public final CustomDashboardChartBinding getBinding() {
        return this.binding;
    }

    public final CustomChartHelper.Config getConfig() {
        return this.config;
    }

    public final DisplayStatsType getStatsType() {
        return this.statsType;
    }

    public final int getLastDataSize() {
        return this.lastDataSize;
    }

    public final void setLastDataSize(int i) {
        this.lastDataSize = i;
    }
}
