package com.soletreadmills.sole_v2._type;

import com.soletreadmills.sole_v2.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ConnectCategoryType.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/soletreadmills/sole_v2/_type/ConnectCategoryType;", "", "displayName", "", "(Ljava/lang/String;II)V", "getDisplayName", "()I", "FAVORITE", "Preset", "Targets", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ConnectCategoryType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ConnectCategoryType[] $VALUES;
    public static final ConnectCategoryType FAVORITE = new ConnectCategoryType("FAVORITE", 0, R.string.favorites);
    public static final ConnectCategoryType Preset = new ConnectCategoryType("Preset", 1, R.string.presets);
    public static final ConnectCategoryType Targets = new ConnectCategoryType("Targets", 2, R.string.targets);
    private final int displayName;

    private static final /* synthetic */ ConnectCategoryType[] $values() {
        return new ConnectCategoryType[]{FAVORITE, Preset, Targets};
    }

    public static EnumEntries<ConnectCategoryType> getEntries() {
        return $ENTRIES;
    }

    public static ConnectCategoryType valueOf(String str) {
        return (ConnectCategoryType) Enum.valueOf(ConnectCategoryType.class, str);
    }

    public static ConnectCategoryType[] values() {
        return (ConnectCategoryType[]) $VALUES.clone();
    }

    private ConnectCategoryType(String str, int i, int i2) {
        this.displayName = i2;
    }

    public final int getDisplayName() {
        return this.displayName;
    }

    static {
        ConnectCategoryType[] connectCategoryTypeArr$values = $values();
        $VALUES = connectCategoryTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(connectCategoryTypeArr$values);
    }
}
