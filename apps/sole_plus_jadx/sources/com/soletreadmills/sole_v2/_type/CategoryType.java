package com.soletreadmills.sole_v2._type;

import com.android.SdkConstants;
import com.facebook.share.internal.ShareConstants;
import com.soletreadmills.sole_v2.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: CategoryType.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\u0081\u0002\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001bB?\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0000\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fj\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a¨\u0006\u001c"}, d2 = {"Lcom/soletreadmills/sole_v2/_type/CategoryType;", "", "code", "", "icon", "title", SdkConstants.ATTR_PARENT, "nodeLevel", "isActive", "", "(Ljava/lang/String;IIIILcom/soletreadmills/sole_v2/_type/CategoryType;IZ)V", "getCode", "()I", "getIcon", "()Z", "getNodeLevel", "getParent", "()Lcom/soletreadmills/sole_v2/_type/CategoryType;", "getTitle", "TREADMILL", "BIKE", "ELLIPTICAL", "STEPPER", "ROWER", "SRVO", ShareConstants.VIDEO_URL, "UNDEFINED", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CategoryType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CategoryType[] $VALUES;
    public static final CategoryType BIKE;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final CategoryType ELLIPTICAL;
    public static final CategoryType ROWER;
    public static final CategoryType SRVO;
    public static final CategoryType STEPPER;
    public static final CategoryType TREADMILL = new CategoryType("TREADMILL", 0, 0, R.drawable.ic_machine_treadmill, R.string.treadmill, null, 0, false, 56, null);
    public static final CategoryType UNDEFINED;
    public static final CategoryType VIDEO;
    private final int code;
    private final int icon;
    private final boolean isActive;
    private final int nodeLevel;
    private final CategoryType parent;
    private final int title;

    private static final /* synthetic */ CategoryType[] $values() {
        return new CategoryType[]{TREADMILL, BIKE, ELLIPTICAL, STEPPER, ROWER, SRVO, VIDEO, UNDEFINED};
    }

    public static EnumEntries<CategoryType> getEntries() {
        return $ENTRIES;
    }

    public static CategoryType valueOf(String str) {
        return (CategoryType) Enum.valueOf(CategoryType.class, str);
    }

    public static CategoryType[] values() {
        return (CategoryType[]) $VALUES.clone();
    }

    private CategoryType(String str, int i, int i2, int i3, int i4, CategoryType categoryType, int i5, boolean z) {
        this.code = i2;
        this.icon = i3;
        this.title = i4;
        this.parent = categoryType;
        this.nodeLevel = i5;
        this.isActive = z;
    }

    /* synthetic */ CategoryType(String str, int i, int i2, int i3, int i4, CategoryType categoryType, int i5, boolean z, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, i2, i3, i4, (i6 & 8) != 0 ? null : categoryType, (i6 & 16) != 0 ? 0 : i5, (i6 & 32) != 0 ? true : z);
    }

    public final int getCode() {
        return this.code;
    }

    public final int getIcon() {
        return this.icon;
    }

    public final int getTitle() {
        return this.title;
    }

    public final CategoryType getParent() {
        return this.parent;
    }

    public final int getNodeLevel() {
        return this.nodeLevel;
    }

    /* renamed from: isActive, reason: from getter */
    public final boolean getIsActive() {
        return this.isActive;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        int i = 56;
        DefaultConstructorMarker defaultConstructorMarker = null;
        CategoryType categoryType = null;
        int i2 = 0;
        boolean z = false;
        BIKE = new CategoryType("BIKE", 1, 1, R.drawable.ic_machine_bike, R.string.bike, categoryType, i2, z, i, defaultConstructorMarker);
        int i3 = 56;
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        CategoryType categoryType2 = null;
        boolean z2 = false;
        ELLIPTICAL = new CategoryType("ELLIPTICAL", 2, 2, R.drawable.ic_machine_elliptical, R.string.elliptical, categoryType2, 0 == true ? 1 : 0, z2, i3, defaultConstructorMarker2);
        STEPPER = new CategoryType("STEPPER", 3, 3, R.drawable.ic_machine_stepper, R.string.stepper, categoryType, i2, z, i, defaultConstructorMarker);
        ROWER = new CategoryType("ROWER", 4, 4, R.drawable.ic_machine_rower, R.string.rower, categoryType2, 0 == true ? 1 : 0, z2, i3, defaultConstructorMarker2);
        SRVO = new CategoryType("SRVO", 5, 5, R.drawable.ic_machine_srvo_machine, R.string.srvo, categoryType, i2, z, i, defaultConstructorMarker);
        VIDEO = new CategoryType(ShareConstants.VIDEO_URL, 6, 6, R.drawable.ic_machine_treadmill, R.string.treadmill, categoryType2, 0 == true ? 1 : 0, z2, i3, defaultConstructorMarker2);
        UNDEFINED = new CategoryType("UNDEFINED", 7, -1, R.drawable.icon_shape, R.string.outdoor_workout, categoryType, i2, z, i, defaultConstructorMarker);
        CategoryType[] categoryTypeArr$values = $values();
        $VALUES = categoryTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(categoryTypeArr$values);
        INSTANCE = new Companion(null);
    }

    /* compiled from: CategoryType.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/soletreadmills/sole_v2/_type/CategoryType$Companion;", "", "()V", "fromCode", "Lcom/soletreadmills/sole_v2/_type/CategoryType;", "code", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CategoryType fromCode(int code) {
            CategoryType categoryType;
            CategoryType[] categoryTypeArrValues = CategoryType.values();
            int length = categoryTypeArrValues.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    categoryType = null;
                    break;
                }
                categoryType = categoryTypeArrValues[i];
                if (categoryType.getCode() == code) {
                    break;
                }
                i++;
            }
            return categoryType == null ? CategoryType.UNDEFINED : categoryType;
        }
    }
}
