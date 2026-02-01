package com.soletreadmills.sole_v2._data.classes;

import com.android.SdkConstants;
import com.sun.jna.platform.win32.COM.tlb.imp.TlbConst;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ClassesData.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/classes/DurationType;", "", "rawValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getRawValue", "()Ljava/lang/String;", "title", "getTitle", "Min5", "Min10", "Min15", "Min20", "Min30", "Min45", "Min60", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DurationType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DurationType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final String rawValue;
    public static final DurationType Min5 = new DurationType("Min5", 0, "00:05:00");
    public static final DurationType Min10 = new DurationType("Min10", 1, "00:10:00");
    public static final DurationType Min15 = new DurationType("Min15", 2, "00:15:00");
    public static final DurationType Min20 = new DurationType("Min20", 3, "00:20:00");
    public static final DurationType Min30 = new DurationType("Min30", 4, "00:30:00");
    public static final DurationType Min45 = new DurationType("Min45", 5, "00:45:00");
    public static final DurationType Min60 = new DurationType("Min60", 6, "01:00:00");

    /* compiled from: ClassesData.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DurationType.values().length];
            try {
                iArr[DurationType.Min5.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DurationType.Min10.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DurationType.Min15.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DurationType.Min20.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[DurationType.Min30.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[DurationType.Min45.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[DurationType.Min60.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ DurationType[] $values() {
        return new DurationType[]{Min5, Min10, Min15, Min20, Min30, Min45, Min60};
    }

    public static EnumEntries<DurationType> getEntries() {
        return $ENTRIES;
    }

    public static DurationType valueOf(String str) {
        return (DurationType) Enum.valueOf(DurationType.class, str);
    }

    public static DurationType[] values() {
        return (DurationType[]) $VALUES.clone();
    }

    private DurationType(String str, int i, String str2) {
        this.rawValue = str2;
    }

    public final String getRawValue() {
        return this.rawValue;
    }

    static {
        DurationType[] durationTypeArr$values = $values();
        $VALUES = durationTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(durationTypeArr$values);
        INSTANCE = new Companion(null);
    }

    /* compiled from: ClassesData.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/classes/DurationType$Companion;", "", "()V", "fromRaw", "Lcom/soletreadmills/sole_v2/_data/classes/DurationType;", SdkConstants.FD_RES_RAW, "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DurationType fromRaw(String raw) {
            for (DurationType durationType : DurationType.values()) {
                if (Intrinsics.areEqual(durationType.getRawValue(), raw)) {
                    return durationType;
                }
            }
            return null;
        }
    }

    public final String getTitle() {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
                return TlbConst.TYPELIB_MINOR_VERSION_OFFICE;
            case 2:
                return "10";
            case 3:
                return "15";
            case 4:
                return "20";
            case 5:
                return "30";
            case 6:
                return "45";
            case 7:
                return "60";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
