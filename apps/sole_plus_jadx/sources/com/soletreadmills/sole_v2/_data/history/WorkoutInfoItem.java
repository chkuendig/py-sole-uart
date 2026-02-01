package com.soletreadmills.sole_v2._data.history;

import com.samsung.android.sdk.healthdata.HealthConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WorkoutInfoItem.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/history/WorkoutInfoItem;", "", "titleRes", "", "value", "", HealthConstants.FoodIntake.UNIT, "(ILjava/lang/String;Ljava/lang/String;)V", "getTitleRes", "()I", "getUnit", "()Ljava/lang/String;", "getValue", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class WorkoutInfoItem {
    public static final int $stable = 0;
    private final int titleRes;
    private final String unit;
    private final String value;

    public static /* synthetic */ WorkoutInfoItem copy$default(WorkoutInfoItem workoutInfoItem, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = workoutInfoItem.titleRes;
        }
        if ((i2 & 2) != 0) {
            str = workoutInfoItem.value;
        }
        if ((i2 & 4) != 0) {
            str2 = workoutInfoItem.unit;
        }
        return workoutInfoItem.copy(i, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getTitleRes() {
        return this.titleRes;
    }

    /* renamed from: component2, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    /* renamed from: component3, reason: from getter */
    public final String getUnit() {
        return this.unit;
    }

    public final WorkoutInfoItem copy(int titleRes, String value, String unit) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(unit, "unit");
        return new WorkoutInfoItem(titleRes, value, unit);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WorkoutInfoItem)) {
            return false;
        }
        WorkoutInfoItem workoutInfoItem = (WorkoutInfoItem) other;
        return this.titleRes == workoutInfoItem.titleRes && Intrinsics.areEqual(this.value, workoutInfoItem.value) && Intrinsics.areEqual(this.unit, workoutInfoItem.unit);
    }

    public int hashCode() {
        return (((Integer.hashCode(this.titleRes) * 31) + this.value.hashCode()) * 31) + this.unit.hashCode();
    }

    public String toString() {
        return "WorkoutInfoItem(titleRes=" + this.titleRes + ", value=" + this.value + ", unit=" + this.unit + ')';
    }

    public WorkoutInfoItem(int i, String value, String unit) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(unit, "unit");
        this.titleRes = i;
        this.value = value;
        this.unit = unit;
    }

    public final int getTitleRes() {
        return this.titleRes;
    }

    public final String getValue() {
        return this.value;
    }

    public final String getUnit() {
        return this.unit;
    }
}
