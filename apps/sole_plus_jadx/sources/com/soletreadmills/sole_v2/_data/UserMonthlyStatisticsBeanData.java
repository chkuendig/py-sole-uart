package com.soletreadmills.sole_v2._data;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UserMonthlyStatisticsBeanData.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003JP\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0015\u0010\u0010¨\u0006#"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/UserMonthlyStatisticsBeanData;", "", "year", "", "month", "activeHours", "", "totalCalories", "workoutList", "", "Lcom/soletreadmills/sole_v2/_data/WorkoutViewVo;", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;Ljava/util/List;)V", "getActiveHours", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getMonth", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTotalCalories", "getWorkoutList", "()Ljava/util/List;", "getYear", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;Ljava/util/List;)Lcom/soletreadmills/sole_v2/_data/UserMonthlyStatisticsBeanData;", "equals", "", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class UserMonthlyStatisticsBeanData {
    public static final int $stable = 8;

    @SerializedName("activeHours")
    private final Double activeHours;

    @SerializedName("month")
    private final Integer month;

    @SerializedName("totalCalories")
    private final Integer totalCalories;

    @SerializedName("workoutList")
    private final List<WorkoutViewVo> workoutList;

    @SerializedName("year")
    private final Integer year;

    public UserMonthlyStatisticsBeanData() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ UserMonthlyStatisticsBeanData copy$default(UserMonthlyStatisticsBeanData userMonthlyStatisticsBeanData, Integer num, Integer num2, Double d, Integer num3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            num = userMonthlyStatisticsBeanData.year;
        }
        if ((i & 2) != 0) {
            num2 = userMonthlyStatisticsBeanData.month;
        }
        Integer num4 = num2;
        if ((i & 4) != 0) {
            d = userMonthlyStatisticsBeanData.activeHours;
        }
        Double d2 = d;
        if ((i & 8) != 0) {
            num3 = userMonthlyStatisticsBeanData.totalCalories;
        }
        Integer num5 = num3;
        if ((i & 16) != 0) {
            list = userMonthlyStatisticsBeanData.workoutList;
        }
        return userMonthlyStatisticsBeanData.copy(num, num4, d2, num5, list);
    }

    /* renamed from: component1, reason: from getter */
    public final Integer getYear() {
        return this.year;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getMonth() {
        return this.month;
    }

    /* renamed from: component3, reason: from getter */
    public final Double getActiveHours() {
        return this.activeHours;
    }

    /* renamed from: component4, reason: from getter */
    public final Integer getTotalCalories() {
        return this.totalCalories;
    }

    public final List<WorkoutViewVo> component5() {
        return this.workoutList;
    }

    public final UserMonthlyStatisticsBeanData copy(Integer year, Integer month, Double activeHours, Integer totalCalories, List<WorkoutViewVo> workoutList) {
        return new UserMonthlyStatisticsBeanData(year, month, activeHours, totalCalories, workoutList);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserMonthlyStatisticsBeanData)) {
            return false;
        }
        UserMonthlyStatisticsBeanData userMonthlyStatisticsBeanData = (UserMonthlyStatisticsBeanData) other;
        return Intrinsics.areEqual(this.year, userMonthlyStatisticsBeanData.year) && Intrinsics.areEqual(this.month, userMonthlyStatisticsBeanData.month) && Intrinsics.areEqual((Object) this.activeHours, (Object) userMonthlyStatisticsBeanData.activeHours) && Intrinsics.areEqual(this.totalCalories, userMonthlyStatisticsBeanData.totalCalories) && Intrinsics.areEqual(this.workoutList, userMonthlyStatisticsBeanData.workoutList);
    }

    public int hashCode() {
        Integer num = this.year;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.month;
        int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Double d = this.activeHours;
        int iHashCode3 = (iHashCode2 + (d == null ? 0 : d.hashCode())) * 31;
        Integer num3 = this.totalCalories;
        int iHashCode4 = (iHashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        List<WorkoutViewVo> list = this.workoutList;
        return iHashCode4 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "UserMonthlyStatisticsBeanData(year=" + this.year + ", month=" + this.month + ", activeHours=" + this.activeHours + ", totalCalories=" + this.totalCalories + ", workoutList=" + this.workoutList + ')';
    }

    public UserMonthlyStatisticsBeanData(Integer num, Integer num2, Double d, Integer num3, List<WorkoutViewVo> list) {
        this.year = num;
        this.month = num2;
        this.activeHours = d;
        this.totalCalories = num3;
        this.workoutList = list;
    }

    public /* synthetic */ UserMonthlyStatisticsBeanData(Integer num, Integer num2, Double d, Integer num3, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : d, (i & 8) != 0 ? null : num3, (i & 16) != 0 ? null : list);
    }

    public final Integer getYear() {
        return this.year;
    }

    public final Integer getMonth() {
        return this.month;
    }

    public final Double getActiveHours() {
        return this.activeHours;
    }

    public final Integer getTotalCalories() {
        return this.totalCalories;
    }

    public final List<WorkoutViewVo> getWorkoutList() {
        return this.workoutList;
    }
}
