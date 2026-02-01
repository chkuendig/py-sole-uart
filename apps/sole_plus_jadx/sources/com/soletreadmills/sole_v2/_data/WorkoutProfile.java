package com.soletreadmills.sole_v2._data;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WorkoutProfile.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJD\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u0010\u0010\n\"\u0004\b\u0011\u0010\fR\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/WorkoutProfile;", "", "maxValue", "", "minValue", "valueList", "", "avgValue", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/util/List;Ljava/lang/Double;)V", "getAvgValue", "()Ljava/lang/Double;", "setAvgValue", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getMaxValue", "setMaxValue", "getMinValue", "setMinValue", "getValueList", "()Ljava/util/List;", "setValueList", "(Ljava/util/List;)V", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/util/List;Ljava/lang/Double;)Lcom/soletreadmills/sole_v2/_data/WorkoutProfile;", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class WorkoutProfile {
    public static final int $stable = 8;
    private Double avgValue;
    private Double maxValue;
    private Double minValue;
    private List<Double> valueList;

    public WorkoutProfile() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WorkoutProfile copy$default(WorkoutProfile workoutProfile, Double d, Double d2, List list, Double d3, int i, Object obj) {
        if ((i & 1) != 0) {
            d = workoutProfile.maxValue;
        }
        if ((i & 2) != 0) {
            d2 = workoutProfile.minValue;
        }
        if ((i & 4) != 0) {
            list = workoutProfile.valueList;
        }
        if ((i & 8) != 0) {
            d3 = workoutProfile.avgValue;
        }
        return workoutProfile.copy(d, d2, list, d3);
    }

    /* renamed from: component1, reason: from getter */
    public final Double getMaxValue() {
        return this.maxValue;
    }

    /* renamed from: component2, reason: from getter */
    public final Double getMinValue() {
        return this.minValue;
    }

    public final List<Double> component3() {
        return this.valueList;
    }

    /* renamed from: component4, reason: from getter */
    public final Double getAvgValue() {
        return this.avgValue;
    }

    public final WorkoutProfile copy(Double maxValue, Double minValue, List<Double> valueList, Double avgValue) {
        return new WorkoutProfile(maxValue, minValue, valueList, avgValue);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WorkoutProfile)) {
            return false;
        }
        WorkoutProfile workoutProfile = (WorkoutProfile) other;
        return Intrinsics.areEqual((Object) this.maxValue, (Object) workoutProfile.maxValue) && Intrinsics.areEqual((Object) this.minValue, (Object) workoutProfile.minValue) && Intrinsics.areEqual(this.valueList, workoutProfile.valueList) && Intrinsics.areEqual((Object) this.avgValue, (Object) workoutProfile.avgValue);
    }

    public int hashCode() {
        Double d = this.maxValue;
        int iHashCode = (d == null ? 0 : d.hashCode()) * 31;
        Double d2 = this.minValue;
        int iHashCode2 = (iHashCode + (d2 == null ? 0 : d2.hashCode())) * 31;
        List<Double> list = this.valueList;
        int iHashCode3 = (iHashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        Double d3 = this.avgValue;
        return iHashCode3 + (d3 != null ? d3.hashCode() : 0);
    }

    public String toString() {
        return "WorkoutProfile(maxValue=" + this.maxValue + ", minValue=" + this.minValue + ", valueList=" + this.valueList + ", avgValue=" + this.avgValue + ')';
    }

    public WorkoutProfile(Double d, Double d2, List<Double> list, Double d3) {
        this.maxValue = d;
        this.minValue = d2;
        this.valueList = list;
        this.avgValue = d3;
    }

    public /* synthetic */ WorkoutProfile(Double d, Double d2, List list, Double d3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : d, (i & 2) != 0 ? null : d2, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : d3);
    }

    public final Double getMaxValue() {
        return this.maxValue;
    }

    public final void setMaxValue(Double d) {
        this.maxValue = d;
    }

    public final Double getMinValue() {
        return this.minValue;
    }

    public final void setMinValue(Double d) {
        this.minValue = d;
    }

    public final List<Double> getValueList() {
        return this.valueList;
    }

    public final void setValueList(List<Double> list) {
        this.valueList = list;
    }

    public final Double getAvgValue() {
        return this.avgValue;
    }

    public final void setAvgValue(Double d) {
        this.avgValue = d;
    }
}
