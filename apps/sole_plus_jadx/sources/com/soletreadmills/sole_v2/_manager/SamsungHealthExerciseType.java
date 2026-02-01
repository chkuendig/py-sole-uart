package com.soletreadmills.sole_v2._manager;

import com.sun.jna.platform.win32.WinError;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: SamsungHealthManager.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/soletreadmills/sole_v2/_manager/SamsungHealthExerciseType;", "", "id", "", "(Ljava/lang/String;II)V", "getId", "()I", "STEPPER", "BIKE", "ROWER", "TREADMILL", "ELLIPTICAL", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SamsungHealthExerciseType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SamsungHealthExerciseType[] $VALUES;
    private final int id;
    public static final SamsungHealthExerciseType STEPPER = new SamsungHealthExerciseType("STEPPER", 0, WinError.ERROR_EVT_INVALID_QUERY);
    public static final SamsungHealthExerciseType BIKE = new SamsungHealthExerciseType("BIKE", 1, WinError.ERROR_EVT_EVENT_TEMPLATE_NOT_FOUND);
    public static final SamsungHealthExerciseType ROWER = new SamsungHealthExerciseType("ROWER", 2, WinError.ERROR_EVT_INVALID_PUBLISHER_NAME);
    public static final SamsungHealthExerciseType TREADMILL = new SamsungHealthExerciseType("TREADMILL", 3, WinError.ERROR_EVT_INVALID_EVENT_DATA);
    public static final SamsungHealthExerciseType ELLIPTICAL = new SamsungHealthExerciseType("ELLIPTICAL", 4, 15006);

    private static final /* synthetic */ SamsungHealthExerciseType[] $values() {
        return new SamsungHealthExerciseType[]{STEPPER, BIKE, ROWER, TREADMILL, ELLIPTICAL};
    }

    public static EnumEntries<SamsungHealthExerciseType> getEntries() {
        return $ENTRIES;
    }

    public static SamsungHealthExerciseType valueOf(String str) {
        return (SamsungHealthExerciseType) Enum.valueOf(SamsungHealthExerciseType.class, str);
    }

    public static SamsungHealthExerciseType[] values() {
        return (SamsungHealthExerciseType[]) $VALUES.clone();
    }

    private SamsungHealthExerciseType(String str, int i, int i2) {
        this.id = i2;
    }

    public final int getId() {
        return this.id;
    }

    static {
        SamsungHealthExerciseType[] samsungHealthExerciseTypeArr$values = $values();
        $VALUES = samsungHealthExerciseTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(samsungHealthExerciseTypeArr$values);
    }
}
