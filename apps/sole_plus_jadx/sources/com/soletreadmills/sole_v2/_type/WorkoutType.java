package com.soletreadmills.sole_v2._type;

import com.facebook.share.internal.ShareConstants;
import com.soletreadmills.sole_v2.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: WorkoutType.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\u0081\u0002\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0018B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0019"}, d2 = {"Lcom/soletreadmills/sole_v2/_type/WorkoutType;", "", "code", "", "stringKey", "icon", "(Ljava/lang/String;IIII)V", "getCode", "()I", "getIcon", "getStringKey", "WALKING", DebugCoroutineInfoImplKt.RUNNING, "TREADMILL_RUNNING", "CYCLING", "BIKING", "ELLIPTICAL", "STEPPING", "STAIR_CLIMBING", "ROWING", "INDOOR_ROWING", "SRVO", ShareConstants.VIDEO_URL, "UNDEFINED", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WorkoutType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ WorkoutType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final int code;
    private final int icon;
    private final int stringKey;
    public static final WorkoutType WALKING = new WorkoutType("WALKING", 0, 51, R.string.treadmill, R.drawable.ic_machine_treadmill);
    public static final WorkoutType RUNNING = new WorkoutType(DebugCoroutineInfoImplKt.RUNNING, 1, 0, R.string.treadmill, R.drawable.ic_machine_treadmill);
    public static final WorkoutType TREADMILL_RUNNING = new WorkoutType("TREADMILL_RUNNING", 2, 10, R.string.treadmill, R.drawable.ic_machine_treadmill);
    public static final WorkoutType CYCLING = new WorkoutType("CYCLING", 3, 1, R.string.cycling, R.drawable.ic_machine_bike);
    public static final WorkoutType BIKING = new WorkoutType("BIKING", 4, 11, R.string.cycling, R.drawable.ic_machine_bike);
    public static final WorkoutType ELLIPTICAL = new WorkoutType("ELLIPTICAL", 5, 2, R.string.elliptical, R.drawable.ic_machine_elliptical);
    public static final WorkoutType STEPPING = new WorkoutType("STEPPING", 6, 3, R.string.steps, R.drawable.ic_machine_stepper);
    public static final WorkoutType STAIR_CLIMBING = new WorkoutType("STAIR_CLIMBING", 7, 13, R.string.steps, R.drawable.ic_machine_stepper);
    public static final WorkoutType ROWING = new WorkoutType("ROWING", 8, 4, R.string.rowing, R.drawable.ic_machine_rower);
    public static final WorkoutType INDOOR_ROWING = new WorkoutType("INDOOR_ROWING", 9, 14, R.string.rowing, R.drawable.ic_machine_rower);
    public static final WorkoutType SRVO = new WorkoutType("SRVO", 10, 15, R.string.srvo, R.drawable.ic_machine_srvo_machine);
    public static final WorkoutType VIDEO = new WorkoutType(ShareConstants.VIDEO_URL, 11, 16, R.string.treadmill, R.drawable.ic_machine_treadmill);
    public static final WorkoutType UNDEFINED = new WorkoutType("UNDEFINED", 12, -1, R.string.outdoor_workout, R.drawable.icon_shape);

    private static final /* synthetic */ WorkoutType[] $values() {
        return new WorkoutType[]{WALKING, RUNNING, TREADMILL_RUNNING, CYCLING, BIKING, ELLIPTICAL, STEPPING, STAIR_CLIMBING, ROWING, INDOOR_ROWING, SRVO, VIDEO, UNDEFINED};
    }

    public static EnumEntries<WorkoutType> getEntries() {
        return $ENTRIES;
    }

    public static WorkoutType valueOf(String str) {
        return (WorkoutType) Enum.valueOf(WorkoutType.class, str);
    }

    public static WorkoutType[] values() {
        return (WorkoutType[]) $VALUES.clone();
    }

    private WorkoutType(String str, int i, int i2, int i3, int i4) {
        this.code = i2;
        this.stringKey = i3;
        this.icon = i4;
    }

    public final int getCode() {
        return this.code;
    }

    public final int getIcon() {
        return this.icon;
    }

    public final int getStringKey() {
        return this.stringKey;
    }

    static {
        WorkoutType[] workoutTypeArr$values = $values();
        $VALUES = workoutTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(workoutTypeArr$values);
        INSTANCE = new Companion(null);
    }

    /* compiled from: WorkoutType.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/soletreadmills/sole_v2/_type/WorkoutType$Companion;", "", "()V", "fromCode", "Lcom/soletreadmills/sole_v2/_type/WorkoutType;", "code", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final WorkoutType fromCode(int code) {
            WorkoutType workoutType;
            WorkoutType[] workoutTypeArrValues = WorkoutType.values();
            int length = workoutTypeArrValues.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    workoutType = null;
                    break;
                }
                workoutType = workoutTypeArrValues[i];
                if (workoutType.getCode() == code) {
                    break;
                }
                i++;
            }
            return workoutType == null ? WorkoutType.UNDEFINED : workoutType;
        }
    }
}
