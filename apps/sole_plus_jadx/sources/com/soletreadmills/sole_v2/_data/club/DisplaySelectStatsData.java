package com.soletreadmills.sole_v2._data.club;

import com.soletreadmills.sole_v2._type.DisplayStatsType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DisplaySelectStatsData.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/club/DisplaySelectStatsData;", "", "type", "Lcom/soletreadmills/sole_v2/_type/DisplayStatsType;", "isSelect", "", "nowSelect", "(Lcom/soletreadmills/sole_v2/_type/DisplayStatsType;ZZ)V", "()Z", "setSelect", "(Z)V", "getNowSelect", "setNowSelect", "getType", "()Lcom/soletreadmills/sole_v2/_type/DisplayStatsType;", "setType", "(Lcom/soletreadmills/sole_v2/_type/DisplayStatsType;)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class DisplaySelectStatsData {
    public static final int $stable = 8;
    private boolean isSelect;
    private boolean nowSelect;
    private DisplayStatsType type;

    public static /* synthetic */ DisplaySelectStatsData copy$default(DisplaySelectStatsData displaySelectStatsData, DisplayStatsType displayStatsType, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            displayStatsType = displaySelectStatsData.type;
        }
        if ((i & 2) != 0) {
            z = displaySelectStatsData.isSelect;
        }
        if ((i & 4) != 0) {
            z2 = displaySelectStatsData.nowSelect;
        }
        return displaySelectStatsData.copy(displayStatsType, z, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final DisplayStatsType getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsSelect() {
        return this.isSelect;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getNowSelect() {
        return this.nowSelect;
    }

    public final DisplaySelectStatsData copy(DisplayStatsType type, boolean isSelect, boolean nowSelect) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new DisplaySelectStatsData(type, isSelect, nowSelect);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DisplaySelectStatsData)) {
            return false;
        }
        DisplaySelectStatsData displaySelectStatsData = (DisplaySelectStatsData) other;
        return this.type == displaySelectStatsData.type && this.isSelect == displaySelectStatsData.isSelect && this.nowSelect == displaySelectStatsData.nowSelect;
    }

    public int hashCode() {
        return (((this.type.hashCode() * 31) + Boolean.hashCode(this.isSelect)) * 31) + Boolean.hashCode(this.nowSelect);
    }

    public String toString() {
        return "DisplaySelectStatsData(type=" + this.type + ", isSelect=" + this.isSelect + ", nowSelect=" + this.nowSelect + ')';
    }

    public DisplaySelectStatsData(DisplayStatsType type, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.isSelect = z;
        this.nowSelect = z2;
    }

    public /* synthetic */ DisplaySelectStatsData(DisplayStatsType displayStatsType, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(displayStatsType, (i & 2) != 0 ? false : z, (i & 4) != 0 ? false : z2);
    }

    public final DisplayStatsType getType() {
        return this.type;
    }

    public final void setType(DisplayStatsType displayStatsType) {
        Intrinsics.checkNotNullParameter(displayStatsType, "<set-?>");
        this.type = displayStatsType;
    }

    public final boolean isSelect() {
        return this.isSelect;
    }

    public final void setSelect(boolean z) {
        this.isSelect = z;
    }

    public final boolean getNowSelect() {
        return this.nowSelect;
    }

    public final void setNowSelect(boolean z) {
        this.nowSelect = z;
    }
}
