package com.soletreadmills.sole_v2._data.classes;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: GetClassQuickPicksApiData.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/classes/ClassesFilterTagViewType;", "", "(Ljava/lang/String;I)V", "Activity", "Duration", "Instructors", "Level", "Focus", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClassesFilterTagViewType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ClassesFilterTagViewType[] $VALUES;
    public static final ClassesFilterTagViewType Activity = new ClassesFilterTagViewType("Activity", 0);
    public static final ClassesFilterTagViewType Duration = new ClassesFilterTagViewType("Duration", 1);
    public static final ClassesFilterTagViewType Instructors = new ClassesFilterTagViewType("Instructors", 2);
    public static final ClassesFilterTagViewType Level = new ClassesFilterTagViewType("Level", 3);
    public static final ClassesFilterTagViewType Focus = new ClassesFilterTagViewType("Focus", 4);

    private static final /* synthetic */ ClassesFilterTagViewType[] $values() {
        return new ClassesFilterTagViewType[]{Activity, Duration, Instructors, Level, Focus};
    }

    public static EnumEntries<ClassesFilterTagViewType> getEntries() {
        return $ENTRIES;
    }

    public static ClassesFilterTagViewType valueOf(String str) {
        return (ClassesFilterTagViewType) Enum.valueOf(ClassesFilterTagViewType.class, str);
    }

    public static ClassesFilterTagViewType[] values() {
        return (ClassesFilterTagViewType[]) $VALUES.clone();
    }

    private ClassesFilterTagViewType(String str, int i) {
    }

    static {
        ClassesFilterTagViewType[] classesFilterTagViewTypeArr$values = $values();
        $VALUES = classesFilterTagViewTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(classesFilterTagViewTypeArr$values);
    }
}
