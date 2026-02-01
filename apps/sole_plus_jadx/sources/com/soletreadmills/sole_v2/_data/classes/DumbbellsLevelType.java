package com.soletreadmills.sole_v2._data.classes;

import com.android.SdkConstants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ClassesData.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/classes/DumbbellsLevelType;", "", "rawValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getRawValue", "()Ljava/lang/String;", "title", "getTitle", "L", "M", "H", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DumbbellsLevelType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DumbbellsLevelType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final String rawValue;
    public static final DumbbellsLevelType L = new DumbbellsLevelType("L", 0, "L");
    public static final DumbbellsLevelType M = new DumbbellsLevelType("M", 1, "M");
    public static final DumbbellsLevelType H = new DumbbellsLevelType("H", 2, "H");

    /* compiled from: ClassesData.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DumbbellsLevelType.values().length];
            try {
                iArr[DumbbellsLevelType.L.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DumbbellsLevelType.M.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DumbbellsLevelType.H.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ DumbbellsLevelType[] $values() {
        return new DumbbellsLevelType[]{L, M, H};
    }

    public static EnumEntries<DumbbellsLevelType> getEntries() {
        return $ENTRIES;
    }

    public static DumbbellsLevelType valueOf(String str) {
        return (DumbbellsLevelType) Enum.valueOf(DumbbellsLevelType.class, str);
    }

    public static DumbbellsLevelType[] values() {
        return (DumbbellsLevelType[]) $VALUES.clone();
    }

    private DumbbellsLevelType(String str, int i, String str2) {
        this.rawValue = str2;
    }

    public final String getRawValue() {
        return this.rawValue;
    }

    static {
        DumbbellsLevelType[] dumbbellsLevelTypeArr$values = $values();
        $VALUES = dumbbellsLevelTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(dumbbellsLevelTypeArr$values);
        INSTANCE = new Companion(null);
    }

    /* compiled from: ClassesData.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/classes/DumbbellsLevelType$Companion;", "", "()V", "fromRaw", "Lcom/soletreadmills/sole_v2/_data/classes/DumbbellsLevelType;", SdkConstants.FD_RES_RAW, "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DumbbellsLevelType fromRaw(String raw) {
            for (DumbbellsLevelType dumbbellsLevelType : DumbbellsLevelType.values()) {
                if (Intrinsics.areEqual(dumbbellsLevelType.getRawValue(), raw)) {
                    return dumbbellsLevelType;
                }
            }
            return null;
        }
    }

    public final String getTitle() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return "Light";
        }
        if (i == 2) {
            return "Medium";
        }
        if (i == 3) {
            return "Heavy";
        }
        throw new NoWhenBranchMatchedException();
    }
}
