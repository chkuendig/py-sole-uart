package com.soletreadmills.sole_v2._type;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ClassesCategoryType.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/_type/ClassesCategoryType;", "", "(Ljava/lang/String;I)V", "FAVORITE", "ACTIVITY", "DURATION", "INSTRUCTORS", "LEVEL", "FOCUS", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClassesCategoryType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ClassesCategoryType[] $VALUES;
    public static final ClassesCategoryType FAVORITE = new ClassesCategoryType("FAVORITE", 0);
    public static final ClassesCategoryType ACTIVITY = new ClassesCategoryType("ACTIVITY", 1);
    public static final ClassesCategoryType DURATION = new ClassesCategoryType("DURATION", 2);
    public static final ClassesCategoryType INSTRUCTORS = new ClassesCategoryType("INSTRUCTORS", 3);
    public static final ClassesCategoryType LEVEL = new ClassesCategoryType("LEVEL", 4);
    public static final ClassesCategoryType FOCUS = new ClassesCategoryType("FOCUS", 5);

    private static final /* synthetic */ ClassesCategoryType[] $values() {
        return new ClassesCategoryType[]{FAVORITE, ACTIVITY, DURATION, INSTRUCTORS, LEVEL, FOCUS};
    }

    public static EnumEntries<ClassesCategoryType> getEntries() {
        return $ENTRIES;
    }

    public static ClassesCategoryType valueOf(String str) {
        return (ClassesCategoryType) Enum.valueOf(ClassesCategoryType.class, str);
    }

    public static ClassesCategoryType[] values() {
        return (ClassesCategoryType[]) $VALUES.clone();
    }

    private ClassesCategoryType(String str, int i) {
    }

    static {
        ClassesCategoryType[] classesCategoryTypeArr$values = $values();
        $VALUES = classesCategoryTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(classesCategoryTypeArr$values);
    }
}
