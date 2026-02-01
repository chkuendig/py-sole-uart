package com.soletreadmills.sole_v2._type;

import androidx.exifinterface.media.ExifInterface;
import com.soletreadmills.sole_v2._data.classes.FocusData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: FocusType.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/soletreadmills/sole_v2/_type/FocusType;", "", "rawValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getRawValue", "()Ljava/lang/String;", "ENDURANCE", "INTERVALS", "HILLS", "SPRINTS", "WALKS", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FocusType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ FocusType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final String rawValue;
    public static final FocusType ENDURANCE = new FocusType("ENDURANCE", 0, ExifInterface.LONGITUDE_EAST);
    public static final FocusType INTERVALS = new FocusType("INTERVALS", 1, "I");
    public static final FocusType HILLS = new FocusType("HILLS", 2, "H");
    public static final FocusType SPRINTS = new FocusType("SPRINTS", 3, ExifInterface.LATITUDE_SOUTH);
    public static final FocusType WALKS = new FocusType("WALKS", 4, ExifInterface.LONGITUDE_WEST);

    private static final /* synthetic */ FocusType[] $values() {
        return new FocusType[]{ENDURANCE, INTERVALS, HILLS, SPRINTS, WALKS};
    }

    public static EnumEntries<FocusType> getEntries() {
        return $ENTRIES;
    }

    public static FocusType valueOf(String str) {
        return (FocusType) Enum.valueOf(FocusType.class, str);
    }

    public static FocusType[] values() {
        return (FocusType[]) $VALUES.clone();
    }

    private FocusType(String str, int i, String str2) {
        this.rawValue = str2;
    }

    public final String getRawValue() {
        return this.rawValue;
    }

    static {
        FocusType[] focusTypeArr$values = $values();
        $VALUES = focusTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(focusTypeArr$values);
        INSTANCE = new Companion(null);
    }

    /* compiled from: FocusType.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/_type/FocusType$Companion;", "", "()V", "getAllFocusData", "", "Lcom/soletreadmills/sole_v2/_data/classes/FocusData;", "getAllRawValues", "", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<FocusData> getAllFocusData() {
            FocusType[] focusTypeArrValues = FocusType.values();
            ArrayList arrayList = new ArrayList(focusTypeArrValues.length);
            for (FocusType focusType : focusTypeArrValues) {
                arrayList.add(new FocusData(focusType, false, 2, null));
            }
            return CollectionsKt.toMutableList((Collection) arrayList);
        }

        public final List<String> getAllRawValues() {
            FocusType[] focusTypeArrValues = FocusType.values();
            ArrayList arrayList = new ArrayList(focusTypeArrValues.length);
            for (FocusType focusType : focusTypeArrValues) {
                arrayList.add(focusType.getRawValue());
            }
            return arrayList;
        }
    }
}
