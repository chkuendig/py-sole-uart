package com.soletreadmills.sole_v2._data.classes;

import androidx.exifinterface.media.ExifInterface;
import com.android.SdkConstants;
import com.soletreadmills.sole_v2.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ClassesData.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\f\u0010\bj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/classes/DifficultyType;", "", "rawValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "iconStr", "", "getIconStr", "()I", "getRawValue", "()Ljava/lang/String;", "title", "getTitle", "B", "I", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "U", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DifficultyType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DifficultyType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final String rawValue;
    public static final DifficultyType B = new DifficultyType("B", 0, "B");
    public static final DifficultyType I = new DifficultyType("I", 1, "I");
    public static final DifficultyType A = new DifficultyType(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, 2, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS);
    public static final DifficultyType U = new DifficultyType("U", 3, "U");

    /* compiled from: ClassesData.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DifficultyType.values().length];
            try {
                iArr[DifficultyType.B.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DifficultyType.I.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DifficultyType.A.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DifficultyType.U.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ DifficultyType[] $values() {
        return new DifficultyType[]{B, I, A, U};
    }

    public static EnumEntries<DifficultyType> getEntries() {
        return $ENTRIES;
    }

    public static DifficultyType valueOf(String str) {
        return (DifficultyType) Enum.valueOf(DifficultyType.class, str);
    }

    public static DifficultyType[] values() {
        return (DifficultyType[]) $VALUES.clone();
    }

    private DifficultyType(String str, int i, String str2) {
        this.rawValue = str2;
    }

    public final String getRawValue() {
        return this.rawValue;
    }

    static {
        DifficultyType[] difficultyTypeArr$values = $values();
        $VALUES = difficultyTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(difficultyTypeArr$values);
        INSTANCE = new Companion(null);
    }

    /* compiled from: ClassesData.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/classes/DifficultyType$Companion;", "", "()V", "fromRaw", "Lcom/soletreadmills/sole_v2/_data/classes/DifficultyType;", SdkConstants.FD_RES_RAW, "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DifficultyType fromRaw(String raw) {
            DifficultyType difficultyType;
            DifficultyType[] difficultyTypeArrValues = DifficultyType.values();
            int length = difficultyTypeArrValues.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    difficultyType = null;
                    break;
                }
                difficultyType = difficultyTypeArrValues[i];
                if (Intrinsics.areEqual(difficultyType.getRawValue(), raw)) {
                    break;
                }
                i++;
            }
            return difficultyType == null ? DifficultyType.U : difficultyType;
        }
    }

    public final int getTitle() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return R.string.novice;
        }
        if (i == 2) {
            return R.string.skilled;
        }
        if (i == 3) {
            return R.string.expert;
        }
        if (i == 4) {
            return R.string.any_level;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final int getIconStr() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return R.drawable.ic_level_novice;
        }
        if (i == 2) {
            return R.drawable.ic_level_skilled;
        }
        if (i == 3) {
            return R.drawable.ic_level_expert;
        }
        if (i == 4) {
            return R.drawable.ic_level_any;
        }
        throw new NoWhenBranchMatchedException();
    }
}
