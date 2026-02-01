package com.soletreadmills.sole_v2._data;

import com.soletreadmills.sole_v2._type.CategoryType;
import com.soletreadmills.sole_v2._type.WorkoutDataSourceType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WorkoutSrchOptionsVoData.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004¢\u0006\u0002\u0010\nJ\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0004HÆ\u0003JC\u0010\u001b\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0002\u0010\t\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0004HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000e¨\u0006\""}, d2 = {"Lcom/soletreadmills/sole_v2/_data/WorkoutSrchOptionsVoData;", "", "years", "", "", "machineCategoryTypes", "Lcom/soletreadmills/sole_v2/_type/CategoryType;", "externalWorkoutDataSources", "Lcom/soletreadmills/sole_v2/_type/WorkoutDataSourceType;", "maxTotalTimeSeconds", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;I)V", "getExternalWorkoutDataSources", "()Ljava/util/List;", "setExternalWorkoutDataSources", "(Ljava/util/List;)V", "getMachineCategoryTypes", "setMachineCategoryTypes", "getMaxTotalTimeSeconds", "()I", "setMaxTotalTimeSeconds", "(I)V", "getYears", "setYears", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class WorkoutSrchOptionsVoData {
    public static final int $stable = 8;
    private List<WorkoutDataSourceType> externalWorkoutDataSources;
    private List<CategoryType> machineCategoryTypes;
    private int maxTotalTimeSeconds;
    private List<Integer> years;

    public WorkoutSrchOptionsVoData() {
        this(null, null, null, 0, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WorkoutSrchOptionsVoData copy$default(WorkoutSrchOptionsVoData workoutSrchOptionsVoData, List list, List list2, List list3, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = workoutSrchOptionsVoData.years;
        }
        if ((i2 & 2) != 0) {
            list2 = workoutSrchOptionsVoData.machineCategoryTypes;
        }
        if ((i2 & 4) != 0) {
            list3 = workoutSrchOptionsVoData.externalWorkoutDataSources;
        }
        if ((i2 & 8) != 0) {
            i = workoutSrchOptionsVoData.maxTotalTimeSeconds;
        }
        return workoutSrchOptionsVoData.copy(list, list2, list3, i);
    }

    public final List<Integer> component1() {
        return this.years;
    }

    public final List<CategoryType> component2() {
        return this.machineCategoryTypes;
    }

    public final List<WorkoutDataSourceType> component3() {
        return this.externalWorkoutDataSources;
    }

    /* renamed from: component4, reason: from getter */
    public final int getMaxTotalTimeSeconds() {
        return this.maxTotalTimeSeconds;
    }

    public final WorkoutSrchOptionsVoData copy(List<Integer> years, List<CategoryType> machineCategoryTypes, List<WorkoutDataSourceType> externalWorkoutDataSources, int maxTotalTimeSeconds) {
        Intrinsics.checkNotNullParameter(years, "years");
        Intrinsics.checkNotNullParameter(machineCategoryTypes, "machineCategoryTypes");
        Intrinsics.checkNotNullParameter(externalWorkoutDataSources, "externalWorkoutDataSources");
        return new WorkoutSrchOptionsVoData(years, machineCategoryTypes, externalWorkoutDataSources, maxTotalTimeSeconds);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WorkoutSrchOptionsVoData)) {
            return false;
        }
        WorkoutSrchOptionsVoData workoutSrchOptionsVoData = (WorkoutSrchOptionsVoData) other;
        return Intrinsics.areEqual(this.years, workoutSrchOptionsVoData.years) && Intrinsics.areEqual(this.machineCategoryTypes, workoutSrchOptionsVoData.machineCategoryTypes) && Intrinsics.areEqual(this.externalWorkoutDataSources, workoutSrchOptionsVoData.externalWorkoutDataSources) && this.maxTotalTimeSeconds == workoutSrchOptionsVoData.maxTotalTimeSeconds;
    }

    public int hashCode() {
        return (((((this.years.hashCode() * 31) + this.machineCategoryTypes.hashCode()) * 31) + this.externalWorkoutDataSources.hashCode()) * 31) + Integer.hashCode(this.maxTotalTimeSeconds);
    }

    public String toString() {
        return "WorkoutSrchOptionsVoData(years=" + this.years + ", machineCategoryTypes=" + this.machineCategoryTypes + ", externalWorkoutDataSources=" + this.externalWorkoutDataSources + ", maxTotalTimeSeconds=" + this.maxTotalTimeSeconds + ')';
    }

    public WorkoutSrchOptionsVoData(List<Integer> years, List<CategoryType> machineCategoryTypes, List<WorkoutDataSourceType> externalWorkoutDataSources, int i) {
        Intrinsics.checkNotNullParameter(years, "years");
        Intrinsics.checkNotNullParameter(machineCategoryTypes, "machineCategoryTypes");
        Intrinsics.checkNotNullParameter(externalWorkoutDataSources, "externalWorkoutDataSources");
        this.years = years;
        this.machineCategoryTypes = machineCategoryTypes;
        this.externalWorkoutDataSources = externalWorkoutDataSources;
        this.maxTotalTimeSeconds = i;
    }

    public /* synthetic */ WorkoutSrchOptionsVoData(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? new ArrayList() : arrayList, (i2 & 2) != 0 ? new ArrayList() : arrayList2, (i2 & 4) != 0 ? new ArrayList() : arrayList3, (i2 & 8) != 0 ? 0 : i);
    }

    public final List<Integer> getYears() {
        return this.years;
    }

    public final void setYears(List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.years = list;
    }

    public final List<CategoryType> getMachineCategoryTypes() {
        return this.machineCategoryTypes;
    }

    public final void setMachineCategoryTypes(List<CategoryType> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.machineCategoryTypes = list;
    }

    public final List<WorkoutDataSourceType> getExternalWorkoutDataSources() {
        return this.externalWorkoutDataSources;
    }

    public final void setExternalWorkoutDataSources(List<WorkoutDataSourceType> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.externalWorkoutDataSources = list;
    }

    public final int getMaxTotalTimeSeconds() {
        return this.maxTotalTimeSeconds;
    }

    public final void setMaxTotalTimeSeconds(int i) {
        this.maxTotalTimeSeconds = i;
    }
}
