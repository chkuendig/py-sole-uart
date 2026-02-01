package com.soletreadmills.sole_v2._data.goal;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UserGoalCreateForm.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ:\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/goal/UserGoalCreateForm;", "", "timeFrame", "", "machineCategoryType", "statsType", "goalValue", "(ILjava/lang/Integer;ILjava/lang/Integer;)V", "getGoalValue", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMachineCategoryType", "getStatsType", "()I", "getTimeFrame", "component1", "component2", "component3", "component4", "copy", "(ILjava/lang/Integer;ILjava/lang/Integer;)Lcom/soletreadmills/sole_v2/_data/goal/UserGoalCreateForm;", "equals", "", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class UserGoalCreateForm {
    public static final int $stable = 0;
    private final Integer goalValue;
    private final Integer machineCategoryType;
    private final int statsType;
    private final int timeFrame;

    public static /* synthetic */ UserGoalCreateForm copy$default(UserGoalCreateForm userGoalCreateForm, int i, Integer num, int i2, Integer num2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = userGoalCreateForm.timeFrame;
        }
        if ((i3 & 2) != 0) {
            num = userGoalCreateForm.machineCategoryType;
        }
        if ((i3 & 4) != 0) {
            i2 = userGoalCreateForm.statsType;
        }
        if ((i3 & 8) != 0) {
            num2 = userGoalCreateForm.goalValue;
        }
        return userGoalCreateForm.copy(i, num, i2, num2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getTimeFrame() {
        return this.timeFrame;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getMachineCategoryType() {
        return this.machineCategoryType;
    }

    /* renamed from: component3, reason: from getter */
    public final int getStatsType() {
        return this.statsType;
    }

    /* renamed from: component4, reason: from getter */
    public final Integer getGoalValue() {
        return this.goalValue;
    }

    public final UserGoalCreateForm copy(int timeFrame, Integer machineCategoryType, int statsType, Integer goalValue) {
        return new UserGoalCreateForm(timeFrame, machineCategoryType, statsType, goalValue);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserGoalCreateForm)) {
            return false;
        }
        UserGoalCreateForm userGoalCreateForm = (UserGoalCreateForm) other;
        return this.timeFrame == userGoalCreateForm.timeFrame && Intrinsics.areEqual(this.machineCategoryType, userGoalCreateForm.machineCategoryType) && this.statsType == userGoalCreateForm.statsType && Intrinsics.areEqual(this.goalValue, userGoalCreateForm.goalValue);
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.timeFrame) * 31;
        Integer num = this.machineCategoryType;
        int iHashCode2 = (((iHashCode + (num == null ? 0 : num.hashCode())) * 31) + Integer.hashCode(this.statsType)) * 31;
        Integer num2 = this.goalValue;
        return iHashCode2 + (num2 != null ? num2.hashCode() : 0);
    }

    public String toString() {
        return "UserGoalCreateForm(timeFrame=" + this.timeFrame + ", machineCategoryType=" + this.machineCategoryType + ", statsType=" + this.statsType + ", goalValue=" + this.goalValue + ')';
    }

    public UserGoalCreateForm(int i, Integer num, int i2, Integer num2) {
        this.timeFrame = i;
        this.machineCategoryType = num;
        this.statsType = i2;
        this.goalValue = num2;
    }

    public /* synthetic */ UserGoalCreateForm(int i, Integer num, int i2, Integer num2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, num, i2, (i3 & 8) != 0 ? null : num2);
    }

    public final int getTimeFrame() {
        return this.timeFrame;
    }

    public final Integer getMachineCategoryType() {
        return this.machineCategoryType;
    }

    public final int getStatsType() {
        return this.statsType;
    }

    public final Integer getGoalValue() {
        return this.goalValue;
    }
}
