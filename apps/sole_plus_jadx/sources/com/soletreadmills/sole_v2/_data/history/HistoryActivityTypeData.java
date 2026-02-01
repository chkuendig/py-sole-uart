package com.soletreadmills.sole_v2._data.history;

import com.soletreadmills.sole_v2._type.HistoryActivityType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HistoryActivityTypeData.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/history/HistoryActivityTypeData;", "", "historyActivityType", "Lcom/soletreadmills/sole_v2/_type/HistoryActivityType;", "isSelect", "", "(Lcom/soletreadmills/sole_v2/_type/HistoryActivityType;Z)V", "getHistoryActivityType", "()Lcom/soletreadmills/sole_v2/_type/HistoryActivityType;", "()Z", "setSelect", "(Z)V", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class HistoryActivityTypeData {
    public static final int $stable = 8;
    private final HistoryActivityType historyActivityType;
    private boolean isSelect;

    public static /* synthetic */ HistoryActivityTypeData copy$default(HistoryActivityTypeData historyActivityTypeData, HistoryActivityType historyActivityType, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            historyActivityType = historyActivityTypeData.historyActivityType;
        }
        if ((i & 2) != 0) {
            z = historyActivityTypeData.isSelect;
        }
        return historyActivityTypeData.copy(historyActivityType, z);
    }

    /* renamed from: component1, reason: from getter */
    public final HistoryActivityType getHistoryActivityType() {
        return this.historyActivityType;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsSelect() {
        return this.isSelect;
    }

    public final HistoryActivityTypeData copy(HistoryActivityType historyActivityType, boolean isSelect) {
        Intrinsics.checkNotNullParameter(historyActivityType, "historyActivityType");
        return new HistoryActivityTypeData(historyActivityType, isSelect);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HistoryActivityTypeData)) {
            return false;
        }
        HistoryActivityTypeData historyActivityTypeData = (HistoryActivityTypeData) other;
        return this.historyActivityType == historyActivityTypeData.historyActivityType && this.isSelect == historyActivityTypeData.isSelect;
    }

    public int hashCode() {
        return (this.historyActivityType.hashCode() * 31) + Boolean.hashCode(this.isSelect);
    }

    public String toString() {
        return "HistoryActivityTypeData(historyActivityType=" + this.historyActivityType + ", isSelect=" + this.isSelect + ')';
    }

    public HistoryActivityTypeData(HistoryActivityType historyActivityType, boolean z) {
        Intrinsics.checkNotNullParameter(historyActivityType, "historyActivityType");
        this.historyActivityType = historyActivityType;
        this.isSelect = z;
    }

    public /* synthetic */ HistoryActivityTypeData(HistoryActivityType historyActivityType, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(historyActivityType, (i & 2) != 0 ? false : z);
    }

    public final HistoryActivityType getHistoryActivityType() {
        return this.historyActivityType;
    }

    public final boolean isSelect() {
        return this.isSelect;
    }

    public final void setSelect(boolean z) {
        this.isSelect = z;
    }
}
