package com.soletreadmills.sole_v2._type;

import com.soletreadmills.sole_v2.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ConnectProgramType.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/_type/ConnectProgramType;", "", "displayName", "", "(Ljava/lang/String;II)V", "getDisplayName", "()I", "Preset", "Targets", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ConnectProgramType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ConnectProgramType[] $VALUES;
    public static final ConnectProgramType Preset = new ConnectProgramType("Preset", 0, R.string.presets);
    public static final ConnectProgramType Targets = new ConnectProgramType("Targets", 1, R.string.targets);
    private final int displayName;

    private static final /* synthetic */ ConnectProgramType[] $values() {
        return new ConnectProgramType[]{Preset, Targets};
    }

    public static EnumEntries<ConnectProgramType> getEntries() {
        return $ENTRIES;
    }

    public static ConnectProgramType valueOf(String str) {
        return (ConnectProgramType) Enum.valueOf(ConnectProgramType.class, str);
    }

    public static ConnectProgramType[] values() {
        return (ConnectProgramType[]) $VALUES.clone();
    }

    private ConnectProgramType(String str, int i, int i2) {
        this.displayName = i2;
    }

    public final int getDisplayName() {
        return this.displayName;
    }

    static {
        ConnectProgramType[] connectProgramTypeArr$values = $values();
        $VALUES = connectProgramTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(connectProgramTypeArr$values);
    }
}
