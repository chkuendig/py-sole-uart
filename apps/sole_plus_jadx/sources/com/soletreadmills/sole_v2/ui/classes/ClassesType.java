package com.soletreadmills.sole_v2.ui.classes;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ClassesSearchViewModel.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/classes/ClassesType;", "", "hint", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getHint", "()Ljava/lang/String;", "SESSION", "COLLECTION", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClassesType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ClassesType[] $VALUES;
    private final String hint;
    public static final ClassesType SESSION = new ClassesType("SESSION", 0, "classes_name");
    public static final ClassesType COLLECTION = new ClassesType("COLLECTION", 1, "collections_name");

    private static final /* synthetic */ ClassesType[] $values() {
        return new ClassesType[]{SESSION, COLLECTION};
    }

    public static EnumEntries<ClassesType> getEntries() {
        return $ENTRIES;
    }

    public static ClassesType valueOf(String str) {
        return (ClassesType) Enum.valueOf(ClassesType.class, str);
    }

    public static ClassesType[] values() {
        return (ClassesType[]) $VALUES.clone();
    }

    private ClassesType(String str, int i, String str2) {
        this.hint = str2;
    }

    public final String getHint() {
        return this.hint;
    }

    static {
        ClassesType[] classesTypeArr$values = $values();
        $VALUES = classesTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(classesTypeArr$values);
    }
}
