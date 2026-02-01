package com.soletreadmills.sole_v2._data;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SrvoRefDataVo.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0011J>\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/SrvoRefDataVo;", "", "srvoName", "", "srvoTotalSets", "", "srvoTotalReps", "srvoTotalWeight", "", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;)V", "getSrvoName", "()Ljava/lang/String;", "getSrvoTotalReps", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSrvoTotalSets", "getSrvoTotalWeight", "()Ljava/lang/Double;", "Ljava/lang/Double;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;)Lcom/soletreadmills/sole_v2/_data/SrvoRefDataVo;", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SrvoRefDataVo {
    public static final int $stable = 0;

    @SerializedName("srvo_name")
    private final String srvoName;

    @SerializedName("srvo_total_reps")
    private final Integer srvoTotalReps;

    @SerializedName("srvo_total_sets")
    private final Integer srvoTotalSets;

    @SerializedName("srvo_total_weight")
    private final Double srvoTotalWeight;

    public SrvoRefDataVo() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ SrvoRefDataVo copy$default(SrvoRefDataVo srvoRefDataVo, String str, Integer num, Integer num2, Double d, int i, Object obj) {
        if ((i & 1) != 0) {
            str = srvoRefDataVo.srvoName;
        }
        if ((i & 2) != 0) {
            num = srvoRefDataVo.srvoTotalSets;
        }
        if ((i & 4) != 0) {
            num2 = srvoRefDataVo.srvoTotalReps;
        }
        if ((i & 8) != 0) {
            d = srvoRefDataVo.srvoTotalWeight;
        }
        return srvoRefDataVo.copy(str, num, num2, d);
    }

    /* renamed from: component1, reason: from getter */
    public final String getSrvoName() {
        return this.srvoName;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getSrvoTotalSets() {
        return this.srvoTotalSets;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getSrvoTotalReps() {
        return this.srvoTotalReps;
    }

    /* renamed from: component4, reason: from getter */
    public final Double getSrvoTotalWeight() {
        return this.srvoTotalWeight;
    }

    public final SrvoRefDataVo copy(String srvoName, Integer srvoTotalSets, Integer srvoTotalReps, Double srvoTotalWeight) {
        return new SrvoRefDataVo(srvoName, srvoTotalSets, srvoTotalReps, srvoTotalWeight);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SrvoRefDataVo)) {
            return false;
        }
        SrvoRefDataVo srvoRefDataVo = (SrvoRefDataVo) other;
        return Intrinsics.areEqual(this.srvoName, srvoRefDataVo.srvoName) && Intrinsics.areEqual(this.srvoTotalSets, srvoRefDataVo.srvoTotalSets) && Intrinsics.areEqual(this.srvoTotalReps, srvoRefDataVo.srvoTotalReps) && Intrinsics.areEqual((Object) this.srvoTotalWeight, (Object) srvoRefDataVo.srvoTotalWeight);
    }

    public int hashCode() {
        String str = this.srvoName;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.srvoTotalSets;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.srvoTotalReps;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Double d = this.srvoTotalWeight;
        return iHashCode3 + (d != null ? d.hashCode() : 0);
    }

    public String toString() {
        return "SrvoRefDataVo(srvoName=" + this.srvoName + ", srvoTotalSets=" + this.srvoTotalSets + ", srvoTotalReps=" + this.srvoTotalReps + ", srvoTotalWeight=" + this.srvoTotalWeight + ')';
    }

    public SrvoRefDataVo(String str, Integer num, Integer num2, Double d) {
        this.srvoName = str;
        this.srvoTotalSets = num;
        this.srvoTotalReps = num2;
        this.srvoTotalWeight = d;
    }

    public /* synthetic */ SrvoRefDataVo(String str, Integer num, Integer num2, Double d, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : d);
    }

    public final String getSrvoName() {
        return this.srvoName;
    }

    public final Integer getSrvoTotalSets() {
        return this.srvoTotalSets;
    }

    public final Integer getSrvoTotalReps() {
        return this.srvoTotalReps;
    }

    public final Double getSrvoTotalWeight() {
        return this.srvoTotalWeight;
    }
}
