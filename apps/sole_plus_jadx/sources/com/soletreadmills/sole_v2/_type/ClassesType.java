package com.soletreadmills.sole_v2._type;

import androidx.exifinterface.media.ExifInterface;
import com.soletreadmills.sole_v2.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ClassesType.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\b\u0086\u0081\u0002\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001cB1\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rj\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001b¨\u0006\u001d"}, d2 = {"Lcom/soletreadmills/sole_v2/_type/ClassesType;", "", "stringKey", "", "apiValue", "", "color", "colorBackground", "icon", "(Ljava/lang/String;IILjava/lang/String;III)V", "getApiValue", "()Ljava/lang/String;", "getColor", "()I", "getColorBackground", "getIcon", "getStringKey", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "ELP", "FS", "RW", "CY", "BX", "YO", "M", "ST", "SV", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClassesType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ClassesType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final String apiValue;
    private final int color;
    private final int colorBackground;
    private final int icon;
    private final int stringKey;
    public static final ClassesType S = new ClassesType(ExifInterface.LATITUDE_SOUTH, 0, R.string.classes_type_s, ExifInterface.LATITUDE_SOUTH, R.color.colorClass_classStrength, R.color.colorClass_classStrength_overly25, R.drawable.ic_activity_sculpt);
    public static final ClassesType T = new ClassesType(ExifInterface.GPS_DIRECTION_TRUE, 1, R.string.classes_type_t, ExifInterface.GPS_DIRECTION_TRUE, R.color.colorClass_classCardio, R.color.colorClass_classCardio_overly25, R.drawable.ic_machine_treadmill);
    public static final ClassesType ELP = new ClassesType("ELP", 2, R.string.classes_type_elp, "ELP", R.color.colorClass_classCardio, R.color.colorClass_classCardio_overly25, R.drawable.ic_machine_elliptical);
    public static final ClassesType FS = new ClassesType("FS", 3, R.string.classes_type_fs, "FS", R.color.colorClass_classCardio, R.color.colorClass_classCardio_overly25, R.drawable.ic_activity_fullsweat);
    public static final ClassesType RW = new ClassesType("RW", 4, R.string.classes_type_rw, "RW", R.color.colorClass_classCardio, R.color.colorClass_classCardio_overly25, R.drawable.ic_machine_rower);
    public static final ClassesType CY = new ClassesType("CY", 5, R.string.classes_type_cy, "CY", R.color.colorClass_classCardio, R.color.colorClass_classCardio_overly25, R.drawable.ic_machine_bike);
    public static final ClassesType BX = new ClassesType("BX", 6, R.string.classes_type_bx, "BX", R.color.colorClass_classStrength, R.color.colorClass_classStrength_overly25, R.drawable.ic_activity_boxing);
    public static final ClassesType YO = new ClassesType("YO", 7, R.string.classes_type_yo, "YO", R.color.colorClass_classRecovery, R.color.colorClass_classRecovery_overly25, R.drawable.ic_activity_yoga);
    public static final ClassesType M = new ClassesType("M", 8, R.string.classes_type_m, "M", R.color.colorClass_classRecovery, R.color.colorClass_classRecovery_overly25, R.drawable.ic_activity_meditation);
    public static final ClassesType ST = new ClassesType("ST", 9, R.string.classes_type_st, "ST", R.color.colorClass_classRecovery, R.color.colorClass_classRecovery_overly25, R.drawable.ic_activity_stretching);
    public static final ClassesType SV = new ClassesType("SV", 10, R.string.srvo, "SV", R.color.colorClass_classStrength, R.color.colorClass_classStrength_overly25, R.drawable.ic_activity_srvo_activity);

    private static final /* synthetic */ ClassesType[] $values() {
        return new ClassesType[]{S, T, ELP, FS, RW, CY, BX, YO, M, ST, SV};
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

    private ClassesType(String str, int i, int i2, String str2, int i3, int i4, int i5) {
        this.stringKey = i2;
        this.apiValue = str2;
        this.color = i3;
        this.colorBackground = i4;
        this.icon = i5;
    }

    public final int getStringKey() {
        return this.stringKey;
    }

    public final String getApiValue() {
        return this.apiValue;
    }

    public final int getColor() {
        return this.color;
    }

    public final int getColorBackground() {
        return this.colorBackground;
    }

    public final int getIcon() {
        return this.icon;
    }

    static {
        ClassesType[] classesTypeArr$values = $values();
        $VALUES = classesTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(classesTypeArr$values);
        INSTANCE = new Companion(null);
    }

    /* compiled from: ClassesType.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/soletreadmills/sole_v2/_type/ClassesType$Companion;", "", "()V", "fromApiValue", "Lcom/soletreadmills/sole_v2/_type/ClassesType;", "value", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ClassesType fromApiValue(String value) {
            for (ClassesType classesType : ClassesType.values()) {
                if (StringsKt.equals(classesType.getApiValue(), value, true)) {
                    return classesType;
                }
            }
            return null;
        }
    }
}
