package com.soletreadmills.sole_v2._type;

import com.soletreadmills.sole_v2._data.classes.DurationData;
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
/* compiled from: DurationType.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/soletreadmills/sole_v2/_type/DurationType;", "", "rawValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getRawValue", "()Ljava/lang/String;", "MIN_5", "MIN_10", "MIN_15", "MIN_20", "MIN_30", "MIN_45", "MIN_60", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DurationType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DurationType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final String rawValue;
    public static final DurationType MIN_5 = new DurationType("MIN_5", 0, "00:05:00");
    public static final DurationType MIN_10 = new DurationType("MIN_10", 1, "00:10:00");
    public static final DurationType MIN_15 = new DurationType("MIN_15", 2, "00:15:00");
    public static final DurationType MIN_20 = new DurationType("MIN_20", 3, "00:20:00");
    public static final DurationType MIN_30 = new DurationType("MIN_30", 4, "00:30:00");
    public static final DurationType MIN_45 = new DurationType("MIN_45", 5, "00:45:00");
    public static final DurationType MIN_60 = new DurationType("MIN_60", 6, "01:00:00");

    private static final /* synthetic */ DurationType[] $values() {
        return new DurationType[]{MIN_5, MIN_10, MIN_15, MIN_20, MIN_30, MIN_45, MIN_60};
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

    /* compiled from: DurationType.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/_type/DurationType$Companion;", "", "()V", "getAllDurationData", "", "Lcom/soletreadmills/sole_v2/_data/classes/DurationData;", "getAllRawValues", "", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<DurationData> getAllDurationData() {
            DurationType[] durationTypeArrValues = DurationType.values();
            ArrayList arrayList = new ArrayList(durationTypeArrValues.length);
            for (DurationType durationType : durationTypeArrValues) {
                arrayList.add(new DurationData(durationType, false, 2, null));
            }
            return CollectionsKt.toMutableList((Collection) arrayList);
        }

        public final List<String> getAllRawValues() {
            DurationType[] durationTypeArrValues = DurationType.values();
            ArrayList arrayList = new ArrayList(durationTypeArrValues.length);
            for (DurationType durationType : durationTypeArrValues) {
                arrayList.add(durationType.getRawValue());
            }
            return arrayList;
        }
    }
}
