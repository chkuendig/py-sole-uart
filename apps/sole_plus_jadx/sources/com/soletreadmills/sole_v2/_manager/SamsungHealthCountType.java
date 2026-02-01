package com.soletreadmills.sole_v2._manager;

import com.samsung.android.sdk.healthdata.HealthConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: SamsungHealthManager.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/_manager/SamsungHealthCountType;", "", "id", "", "(Ljava/lang/String;II)V", "getId", "()I", "COUNT_TYPE_STRIDE", "COUNT_TYPE_STROKE", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SamsungHealthCountType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SamsungHealthCountType[] $VALUES;
    public static final SamsungHealthCountType COUNT_TYPE_STRIDE = new SamsungHealthCountType("COUNT_TYPE_STRIDE", 0, HealthConstants.Exercise.COUNT_TYPE_STROKE);
    public static final SamsungHealthCountType COUNT_TYPE_STROKE = new SamsungHealthCountType("COUNT_TYPE_STROKE", 1, HealthConstants.Exercise.COUNT_TYPE_SWING);
    private final int id;

    private static final /* synthetic */ SamsungHealthCountType[] $values() {
        return new SamsungHealthCountType[]{COUNT_TYPE_STRIDE, COUNT_TYPE_STROKE};
    }

    public static EnumEntries<SamsungHealthCountType> getEntries() {
        return $ENTRIES;
    }

    public static SamsungHealthCountType valueOf(String str) {
        return (SamsungHealthCountType) Enum.valueOf(SamsungHealthCountType.class, str);
    }

    public static SamsungHealthCountType[] values() {
        return (SamsungHealthCountType[]) $VALUES.clone();
    }

    private SamsungHealthCountType(String str, int i, int i2) {
        this.id = i2;
    }

    public final int getId() {
        return this.id;
    }

    static {
        SamsungHealthCountType[] samsungHealthCountTypeArr$values = $values();
        $VALUES = samsungHealthCountTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(samsungHealthCountTypeArr$values);
    }
}
