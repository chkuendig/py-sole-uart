package com.soletreadmills.sole_v2._type;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: GoalTargetNameType.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/soletreadmills/sole_v2/_type/GoalTargetNameType;", "", "(Ljava/lang/String;I)V", "KILOMETERS", "ACTIVE_HOURS", "WORKOUT", "CALORIES", "STEP", "STROKE", "REPS", "SETS", "POUNDS", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GoalTargetNameType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ GoalTargetNameType[] $VALUES;
    public static final GoalTargetNameType KILOMETERS = new GoalTargetNameType("KILOMETERS", 0);
    public static final GoalTargetNameType ACTIVE_HOURS = new GoalTargetNameType("ACTIVE_HOURS", 1);
    public static final GoalTargetNameType WORKOUT = new GoalTargetNameType("WORKOUT", 2);
    public static final GoalTargetNameType CALORIES = new GoalTargetNameType("CALORIES", 3);
    public static final GoalTargetNameType STEP = new GoalTargetNameType("STEP", 4);
    public static final GoalTargetNameType STROKE = new GoalTargetNameType("STROKE", 5);
    public static final GoalTargetNameType REPS = new GoalTargetNameType("REPS", 6);
    public static final GoalTargetNameType SETS = new GoalTargetNameType("SETS", 7);
    public static final GoalTargetNameType POUNDS = new GoalTargetNameType("POUNDS", 8);

    private static final /* synthetic */ GoalTargetNameType[] $values() {
        return new GoalTargetNameType[]{KILOMETERS, ACTIVE_HOURS, WORKOUT, CALORIES, STEP, STROKE, REPS, SETS, POUNDS};
    }

    public static EnumEntries<GoalTargetNameType> getEntries() {
        return $ENTRIES;
    }

    public static GoalTargetNameType valueOf(String str) {
        return (GoalTargetNameType) Enum.valueOf(GoalTargetNameType.class, str);
    }

    public static GoalTargetNameType[] values() {
        return (GoalTargetNameType[]) $VALUES.clone();
    }

    private GoalTargetNameType(String str, int i) {
    }

    static {
        GoalTargetNameType[] goalTargetNameTypeArr$values = $values();
        $VALUES = goalTargetNameTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(goalTargetNameTypeArr$values);
    }
}
