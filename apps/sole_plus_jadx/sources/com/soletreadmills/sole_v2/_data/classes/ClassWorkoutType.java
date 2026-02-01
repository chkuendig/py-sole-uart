package com.soletreadmills.sole_v2._data.classes;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.exifinterface.media.ExifInterface;
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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/classes/ClassWorkoutType;", "", "rawValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getRawValue", "()Ljava/lang/String;", "title", "getTitle", "(Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "Endurance", "Intervals", "Hills", "Sprints", "Walks", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClassWorkoutType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ClassWorkoutType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final String rawValue;
    public static final ClassWorkoutType Endurance = new ClassWorkoutType("Endurance", 0, ExifInterface.LONGITUDE_EAST);
    public static final ClassWorkoutType Intervals = new ClassWorkoutType("Intervals", 1, "I");
    public static final ClassWorkoutType Hills = new ClassWorkoutType("Hills", 2, "H");
    public static final ClassWorkoutType Sprints = new ClassWorkoutType("Sprints", 3, ExifInterface.LATITUDE_SOUTH);
    public static final ClassWorkoutType Walks = new ClassWorkoutType("Walks", 4, ExifInterface.LONGITUDE_WEST);

    /* compiled from: ClassesData.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ClassWorkoutType.values().length];
            try {
                iArr[ClassWorkoutType.Endurance.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ClassWorkoutType.Intervals.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ClassWorkoutType.Hills.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ClassWorkoutType.Sprints.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ClassWorkoutType.Walks.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ ClassWorkoutType[] $values() {
        return new ClassWorkoutType[]{Endurance, Intervals, Hills, Sprints, Walks};
    }

    public static EnumEntries<ClassWorkoutType> getEntries() {
        return $ENTRIES;
    }

    public static ClassWorkoutType valueOf(String str) {
        return (ClassWorkoutType) Enum.valueOf(ClassWorkoutType.class, str);
    }

    public static ClassWorkoutType[] values() {
        return (ClassWorkoutType[]) $VALUES.clone();
    }

    private ClassWorkoutType(String str, int i, String str2) {
        this.rawValue = str2;
    }

    public final String getRawValue() {
        return this.rawValue;
    }

    static {
        ClassWorkoutType[] classWorkoutTypeArr$values = $values();
        $VALUES = classWorkoutTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(classWorkoutTypeArr$values);
        INSTANCE = new Companion(null);
    }

    /* compiled from: ClassesData.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/classes/ClassWorkoutType$Companion;", "", "()V", "fromRaw", "Lcom/soletreadmills/sole_v2/_data/classes/ClassWorkoutType;", SdkConstants.FD_RES_RAW, "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ClassWorkoutType fromRaw(String raw) {
            for (ClassWorkoutType classWorkoutType : ClassWorkoutType.values()) {
                if (Intrinsics.areEqual(classWorkoutType.getRawValue(), raw)) {
                    return classWorkoutType;
                }
            }
            return null;
        }
    }

    public final String getTitle(Composer composer, int i) {
        String str;
        composer.startReplaceGroup(-1212164353);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1212164353, i, -1, "com.soletreadmills.sole_v2._data.classes.ClassWorkoutType.<get-title> (ClassesData.kt:84)");
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i2 == 1) {
            str = "Endurance";
        } else if (i2 == 2) {
            str = "Intervals";
        } else if (i2 == 3) {
            str = "Hills";
        } else if (i2 == 4) {
            str = "Sprints";
        } else {
            if (i2 != 5) {
                throw new NoWhenBranchMatchedException();
            }
            str = "Walks";
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return str;
    }
}
