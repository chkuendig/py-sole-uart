package com.soletreadmills.sole_v2._data.goal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UserGoalCreateForm.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J8\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/goal/UserGoalCreateFormToUpload;", "", "timeFrame", "", "machineCategoryType", "statsType", "goalValue", "", "(ILjava/lang/Integer;ID)V", "getGoalValue", "()D", "getMachineCategoryType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getStatsType", "()I", "getTimeFrame", "component1", "component2", "component3", "component4", "copy", "(ILjava/lang/Integer;ID)Lcom/soletreadmills/sole_v2/_data/goal/UserGoalCreateFormToUpload;", "equals", "", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class UserGoalCreateFormToUpload {
    public static final int $stable = 0;
    private final double goalValue;
    private final Integer machineCategoryType;
    private final int statsType;
    private final int timeFrame;

    public static /* synthetic */ UserGoalCreateFormToUpload copy$default(UserGoalCreateFormToUpload userGoalCreateFormToUpload, int i, Integer num, int i2, double d, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = userGoalCreateFormToUpload.timeFrame;
        }
        if ((i3 & 2) != 0) {
            num = userGoalCreateFormToUpload.machineCategoryType;
        }
        Integer num2 = num;
        if ((i3 & 4) != 0) {
            i2 = userGoalCreateFormToUpload.statsType;
        }
        int i4 = i2;
        if ((i3 & 8) != 0) {
            d = userGoalCreateFormToUpload.goalValue;
        }
        return userGoalCreateFormToUpload.copy(i, num2, i4, d);
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
    public final double getGoalValue() {
        return this.goalValue;
    }

    public final UserGoalCreateFormToUpload copy(int timeFrame, Integer machineCategoryType, int statsType, double goalValue) {
        return new UserGoalCreateFormToUpload(timeFrame, machineCategoryType, statsType, goalValue);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserGoalCreateFormToUpload)) {
            return false;
        }
        UserGoalCreateFormToUpload userGoalCreateFormToUpload = (UserGoalCreateFormToUpload) other;
        return this.timeFrame == userGoalCreateFormToUpload.timeFrame && Intrinsics.areEqual(this.machineCategoryType, userGoalCreateFormToUpload.machineCategoryType) && this.statsType == userGoalCreateFormToUpload.statsType && Double.compare(this.goalValue, userGoalCreateFormToUpload.goalValue) == 0;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.timeFrame) * 31;
        Integer num = this.machineCategoryType;
        return ((((iHashCode + (num == null ? 0 : num.hashCode())) * 31) + Integer.hashCode(this.statsType)) * 31) + Double.hashCode(this.goalValue);
    }

    public String toString() {
        return "UserGoalCreateFormToUpload(timeFrame=" + this.timeFrame + ", machineCategoryType=" + this.machineCategoryType + ", statsType=" + this.statsType + ", goalValue=" + this.goalValue + ')';
    }

    public UserGoalCreateFormToUpload(int i, Integer num, int i2, double d) {
        this.timeFrame = i;
        this.machineCategoryType = num;
        this.statsType = i2;
        this.goalValue = d;
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

    public final double getGoalValue() {
        return this.goalValue;
    }
}
