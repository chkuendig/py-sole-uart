package com.soletreadmills.sole_v2._type;

import androidx.exifinterface.media.ExifInterface;
import com.android.SdkConstants;
import com.facebook.internal.AnalyticsEvents;
import com.soletreadmills.sole_v2.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ClassType.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\u0081\u0002\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\r\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bj\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a¨\u0006\u001c"}, d2 = {"Lcom/soletreadmills/sole_v2/_type/ClassType;", "", "rawValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "classCategory", "", "getClassCategory", "()I", "color", "getColor", "()Ljava/lang/String;", "iconStr", "getIconStr", "getRawValue", "Running", "Cycling", "Elliptical", "Rowing", "Srvo", "FullSweet", "Boxing", "Sculpt", "Stretching", "Yoga", "Meditation", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClassType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ClassType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final String rawValue;
    public static final ClassType Running = new ClassType("Running", 0, ExifInterface.GPS_DIRECTION_TRUE);
    public static final ClassType Cycling = new ClassType("Cycling", 1, "CY");
    public static final ClassType Elliptical = new ClassType("Elliptical", 2, "ELP");
    public static final ClassType Rowing = new ClassType("Rowing", 3, "RW");
    public static final ClassType Srvo = new ClassType("Srvo", 4, "SV");
    public static final ClassType FullSweet = new ClassType("FullSweet", 5, "FS");
    public static final ClassType Boxing = new ClassType("Boxing", 6, "BX");
    public static final ClassType Sculpt = new ClassType("Sculpt", 7, ExifInterface.LATITUDE_SOUTH);
    public static final ClassType Stretching = new ClassType("Stretching", 8, "ST");
    public static final ClassType Yoga = new ClassType("Yoga", 9, "YO");
    public static final ClassType Meditation = new ClassType("Meditation", 10, "M");
    public static final ClassType Unknown = new ClassType(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, 11, "un");

    /* compiled from: ClassType.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ClassType.values().length];
            try {
                iArr[ClassType.Running.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ClassType.Cycling.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ClassType.Elliptical.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ClassType.Rowing.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ClassType.FullSweet.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ClassType.Boxing.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ClassType.Sculpt.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[ClassType.Stretching.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[ClassType.Yoga.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[ClassType.Meditation.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[ClassType.Srvo.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[ClassType.Unknown.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ ClassType[] $values() {
        return new ClassType[]{Running, Cycling, Elliptical, Rowing, Srvo, FullSweet, Boxing, Sculpt, Stretching, Yoga, Meditation, Unknown};
    }

    public static EnumEntries<ClassType> getEntries() {
        return $ENTRIES;
    }

    public static ClassType valueOf(String str) {
        return (ClassType) Enum.valueOf(ClassType.class, str);
    }

    public static ClassType[] values() {
        return (ClassType[]) $VALUES.clone();
    }

    private ClassType(String str, int i, String str2) {
        this.rawValue = str2;
    }

    public final String getRawValue() {
        return this.rawValue;
    }

    static {
        ClassType[] classTypeArr$values = $values();
        $VALUES = classTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(classTypeArr$values);
        INSTANCE = new Companion(null);
    }

    /* compiled from: ClassType.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/soletreadmills/sole_v2/_type/ClassType$Companion;", "", "()V", "fromRaw", "Lcom/soletreadmills/sole_v2/_type/ClassType;", SdkConstants.FD_RES_RAW, "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ClassType fromRaw(String raw) {
            ClassType classType;
            ClassType[] classTypeArrValues = ClassType.values();
            int length = classTypeArrValues.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    classType = null;
                    break;
                }
                classType = classTypeArrValues[i];
                if (Intrinsics.areEqual(classType.getRawValue(), raw)) {
                    break;
                }
                i++;
            }
            return classType == null ? ClassType.Unknown : classType;
        }
    }

    public final int getClassCategory() {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
                return R.string.treadmill;
            case 2:
                return R.string.cycling;
            case 3:
                return R.string.elliptical;
            case 4:
                return R.string.rowing;
            case 5:
                return R.string.full_sweat;
            case 6:
                return R.string.boxing;
            case 7:
                return R.string.sculpt;
            case 8:
                return R.string.stretching;
            case 9:
                return R.string.yoga;
            case 10:
                return R.string.meditation;
            case 11:
                return R.string.srvo;
            case 12:
                return R.string.other;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final int getIconStr() {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
                return R.drawable.ic_machine_treadmill;
            case 2:
                return R.drawable.ic_machine_bike;
            case 3:
                return R.drawable.ic_machine_elliptical;
            case 4:
                return R.drawable.ic_machine_rower;
            case 5:
                return R.drawable.ic_activity_fullsweat;
            case 6:
                return R.drawable.ic_activity_boxing;
            case 7:
                return R.drawable.ic_activity_sculpt;
            case 8:
                return R.drawable.ic_activity_stretching;
            case 9:
                return R.drawable.ic_activity_yoga;
            case 10:
                return R.drawable.ic_activity_meditation;
            case 11:
                return R.drawable.ic_activity_srvo_activity;
            case 12:
                return 0;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final String getColor() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i != 11) {
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    return "#FFA500";
                case 6:
                case 7:
                    break;
                default:
                    return "#008000";
            }
        }
        return "#FFC0CB";
    }
}
