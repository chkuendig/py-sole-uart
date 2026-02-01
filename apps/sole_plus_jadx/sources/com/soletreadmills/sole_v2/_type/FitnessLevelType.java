package com.soletreadmills.sole_v2._type;

import androidx.exifinterface.media.ExifInterface;
import com.soletreadmills.sole_v2._data.classes.FitnessLevelData;
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
/* compiled from: FitnessLevelType.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/soletreadmills/sole_v2/_type/FitnessLevelType;", "", "rawValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getRawValue", "()Ljava/lang/String;", "NOVICE", "SKILLED", "EXPERT", "ANY_LEVEL", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FitnessLevelType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ FitnessLevelType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final String rawValue;
    public static final FitnessLevelType NOVICE = new FitnessLevelType("NOVICE", 0, "B");
    public static final FitnessLevelType SKILLED = new FitnessLevelType("SKILLED", 1, "I");
    public static final FitnessLevelType EXPERT = new FitnessLevelType("EXPERT", 2, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS);
    public static final FitnessLevelType ANY_LEVEL = new FitnessLevelType("ANY_LEVEL", 3, "U");

    private static final /* synthetic */ FitnessLevelType[] $values() {
        return new FitnessLevelType[]{NOVICE, SKILLED, EXPERT, ANY_LEVEL};
    }

    public static EnumEntries<FitnessLevelType> getEntries() {
        return $ENTRIES;
    }

    public static FitnessLevelType valueOf(String str) {
        return (FitnessLevelType) Enum.valueOf(FitnessLevelType.class, str);
    }

    public static FitnessLevelType[] values() {
        return (FitnessLevelType[]) $VALUES.clone();
    }

    private FitnessLevelType(String str, int i, String str2) {
        this.rawValue = str2;
    }

    public final String getRawValue() {
        return this.rawValue;
    }

    static {
        FitnessLevelType[] fitnessLevelTypeArr$values = $values();
        $VALUES = fitnessLevelTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(fitnessLevelTypeArr$values);
        INSTANCE = new Companion(null);
    }

    /* compiled from: FitnessLevelType.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/_type/FitnessLevelType$Companion;", "", "()V", "getAllFitnessLevelData", "", "Lcom/soletreadmills/sole_v2/_data/classes/FitnessLevelData;", "getAllRawValues", "", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<FitnessLevelData> getAllFitnessLevelData() {
            FitnessLevelType[] fitnessLevelTypeArrValues = FitnessLevelType.values();
            ArrayList arrayList = new ArrayList(fitnessLevelTypeArrValues.length);
            for (FitnessLevelType fitnessLevelType : fitnessLevelTypeArrValues) {
                arrayList.add(new FitnessLevelData(fitnessLevelType, false, 2, null));
            }
            return CollectionsKt.toMutableList((Collection) arrayList);
        }

        public final List<String> getAllRawValues() {
            FitnessLevelType[] fitnessLevelTypeArrValues = FitnessLevelType.values();
            ArrayList arrayList = new ArrayList(fitnessLevelTypeArrValues.length);
            for (FitnessLevelType fitnessLevelType : fitnessLevelTypeArrValues) {
                arrayList.add(fitnessLevelType.getRawValue());
            }
            return arrayList;
        }
    }
}
