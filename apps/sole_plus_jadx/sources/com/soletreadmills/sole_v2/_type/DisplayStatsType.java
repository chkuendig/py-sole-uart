package com.soletreadmills.sole_v2._type;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DisplayStatsType.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0017\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0018"}, d2 = {"Lcom/soletreadmills/sole_v2/_type/DisplayStatsType;", "", "(Ljava/lang/String;I)V", "TIME", "REMAINING_TIME", "DISTANCE", "SPEED", "PACE", "AVG_PACE", "HEART_RATE", "INCLINE", "CALORIES", "METS", "ASCENT", "OUTPUT", "RESISTANCE", "CADENCE", "STRIDES", "AVG_SPEED", "AVG_CADENCE", "STROKES", "FLOORS", "STEPS", "CALORIES_PER_MIN", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DisplayStatsType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DisplayStatsType[] $VALUES;
    public static final DisplayStatsType TIME = new DisplayStatsType("TIME", 0);
    public static final DisplayStatsType REMAINING_TIME = new DisplayStatsType("REMAINING_TIME", 1);
    public static final DisplayStatsType DISTANCE = new DisplayStatsType("DISTANCE", 2);
    public static final DisplayStatsType SPEED = new DisplayStatsType("SPEED", 3);
    public static final DisplayStatsType PACE = new DisplayStatsType("PACE", 4);
    public static final DisplayStatsType AVG_PACE = new DisplayStatsType("AVG_PACE", 5);
    public static final DisplayStatsType HEART_RATE = new DisplayStatsType("HEART_RATE", 6);
    public static final DisplayStatsType INCLINE = new DisplayStatsType("INCLINE", 7);
    public static final DisplayStatsType CALORIES = new DisplayStatsType("CALORIES", 8);
    public static final DisplayStatsType METS = new DisplayStatsType("METS", 9);
    public static final DisplayStatsType ASCENT = new DisplayStatsType("ASCENT", 10);
    public static final DisplayStatsType OUTPUT = new DisplayStatsType("OUTPUT", 11);
    public static final DisplayStatsType RESISTANCE = new DisplayStatsType("RESISTANCE", 12);
    public static final DisplayStatsType CADENCE = new DisplayStatsType("CADENCE", 13);
    public static final DisplayStatsType STRIDES = new DisplayStatsType("STRIDES", 14);
    public static final DisplayStatsType AVG_SPEED = new DisplayStatsType("AVG_SPEED", 15);
    public static final DisplayStatsType AVG_CADENCE = new DisplayStatsType("AVG_CADENCE", 16);
    public static final DisplayStatsType STROKES = new DisplayStatsType("STROKES", 17);
    public static final DisplayStatsType FLOORS = new DisplayStatsType("FLOORS", 18);
    public static final DisplayStatsType STEPS = new DisplayStatsType("STEPS", 19);
    public static final DisplayStatsType CALORIES_PER_MIN = new DisplayStatsType("CALORIES_PER_MIN", 20);

    private static final /* synthetic */ DisplayStatsType[] $values() {
        return new DisplayStatsType[]{TIME, REMAINING_TIME, DISTANCE, SPEED, PACE, AVG_PACE, HEART_RATE, INCLINE, CALORIES, METS, ASCENT, OUTPUT, RESISTANCE, CADENCE, STRIDES, AVG_SPEED, AVG_CADENCE, STROKES, FLOORS, STEPS, CALORIES_PER_MIN};
    }

    public static EnumEntries<DisplayStatsType> getEntries() {
        return $ENTRIES;
    }

    public static DisplayStatsType valueOf(String str) {
        return (DisplayStatsType) Enum.valueOf(DisplayStatsType.class, str);
    }

    public static DisplayStatsType[] values() {
        return (DisplayStatsType[]) $VALUES.clone();
    }

    private DisplayStatsType(String str, int i) {
    }

    static {
        DisplayStatsType[] displayStatsTypeArr$values = $values();
        $VALUES = displayStatsTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(displayStatsTypeArr$values);
    }
}
