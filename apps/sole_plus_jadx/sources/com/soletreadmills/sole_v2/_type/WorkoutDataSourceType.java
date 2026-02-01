package com.soletreadmills.sole_v2._type;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: WorkoutDataSourceType.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/soletreadmills/sole_v2/_type/WorkoutDataSourceType;", "", "code", "", "(Ljava/lang/String;II)V", "getCode", "()I", "GARMIN", "APPLE", "FITBIT", "HOME_APP", "MACHINE_CONSOLE", "SRVO", "UNDEFINED", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WorkoutDataSourceType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ WorkoutDataSourceType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final int code;
    public static final WorkoutDataSourceType GARMIN = new WorkoutDataSourceType("GARMIN", 0, 1);
    public static final WorkoutDataSourceType APPLE = new WorkoutDataSourceType("APPLE", 1, 2);
    public static final WorkoutDataSourceType FITBIT = new WorkoutDataSourceType("FITBIT", 2, 3);
    public static final WorkoutDataSourceType HOME_APP = new WorkoutDataSourceType("HOME_APP", 3, 4);
    public static final WorkoutDataSourceType MACHINE_CONSOLE = new WorkoutDataSourceType("MACHINE_CONSOLE", 4, 5);
    public static final WorkoutDataSourceType SRVO = new WorkoutDataSourceType("SRVO", 5, 6);
    public static final WorkoutDataSourceType UNDEFINED = new WorkoutDataSourceType("UNDEFINED", 6, -1);

    private static final /* synthetic */ WorkoutDataSourceType[] $values() {
        return new WorkoutDataSourceType[]{GARMIN, APPLE, FITBIT, HOME_APP, MACHINE_CONSOLE, SRVO, UNDEFINED};
    }

    public static EnumEntries<WorkoutDataSourceType> getEntries() {
        return $ENTRIES;
    }

    public static WorkoutDataSourceType valueOf(String str) {
        return (WorkoutDataSourceType) Enum.valueOf(WorkoutDataSourceType.class, str);
    }

    public static WorkoutDataSourceType[] values() {
        return (WorkoutDataSourceType[]) $VALUES.clone();
    }

    private WorkoutDataSourceType(String str, int i, int i2) {
        this.code = i2;
    }

    public final int getCode() {
        return this.code;
    }

    static {
        WorkoutDataSourceType[] workoutDataSourceTypeArr$values = $values();
        $VALUES = workoutDataSourceTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(workoutDataSourceTypeArr$values);
        INSTANCE = new Companion(null);
    }

    /* compiled from: WorkoutDataSourceType.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/soletreadmills/sole_v2/_type/WorkoutDataSourceType$Companion;", "", "()V", "fromCode", "Lcom/soletreadmills/sole_v2/_type/WorkoutDataSourceType;", "code", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final WorkoutDataSourceType fromCode(int code) {
            WorkoutDataSourceType workoutDataSourceType;
            WorkoutDataSourceType[] workoutDataSourceTypeArrValues = WorkoutDataSourceType.values();
            int length = workoutDataSourceTypeArrValues.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    workoutDataSourceType = null;
                    break;
                }
                workoutDataSourceType = workoutDataSourceTypeArrValues[i];
                if (workoutDataSourceType.getCode() == code) {
                    break;
                }
                i++;
            }
            return workoutDataSourceType == null ? WorkoutDataSourceType.UNDEFINED : workoutDataSourceType;
        }
    }
}
