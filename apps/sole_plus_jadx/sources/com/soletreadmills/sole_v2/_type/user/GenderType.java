package com.soletreadmills.sole_v2._type.user;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: GenderType.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/_type/user/GenderType;", "", "id", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getId", "()Ljava/lang/String;", "Female", "Male", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GenderType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ GenderType[] $VALUES;
    public static final GenderType Female = new GenderType("Female", 0, "0");
    public static final GenderType Male = new GenderType("Male", 1, "1");
    private final String id;

    private static final /* synthetic */ GenderType[] $values() {
        return new GenderType[]{Female, Male};
    }

    public static EnumEntries<GenderType> getEntries() {
        return $ENTRIES;
    }

    public static GenderType valueOf(String str) {
        return (GenderType) Enum.valueOf(GenderType.class, str);
    }

    public static GenderType[] values() {
        return (GenderType[]) $VALUES.clone();
    }

    private GenderType(String str, int i, String str2) {
        this.id = str2;
    }

    public final String getId() {
        return this.id;
    }

    static {
        GenderType[] genderTypeArr$values = $values();
        $VALUES = genderTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(genderTypeArr$values);
    }
}
