package com.soletreadmills.sole_v2._type;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: WearStatusType.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/soletreadmills/sole_v2/_type/WearStatusType;", "", "id", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "CLOSE_APP", "CALL_WEAR_OPEN", "APP_IS_OPEN", "DEVICE_LINKED", "DEVICE_UNLINKED", "MACHINE_IS_START", "MACHINE_IS_STOP", "WEAR_IS_START", "WEAR_IS_STOP", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WearStatusType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ WearStatusType[] $VALUES;
    private String id;
    public static final WearStatusType CLOSE_APP = new WearStatusType("CLOSE_APP", 0, "0");
    public static final WearStatusType CALL_WEAR_OPEN = new WearStatusType("CALL_WEAR_OPEN", 1, "1");
    public static final WearStatusType APP_IS_OPEN = new WearStatusType("APP_IS_OPEN", 2, "2");
    public static final WearStatusType DEVICE_LINKED = new WearStatusType("DEVICE_LINKED", 3, "10");
    public static final WearStatusType DEVICE_UNLINKED = new WearStatusType("DEVICE_UNLINKED", 4, "11");
    public static final WearStatusType MACHINE_IS_START = new WearStatusType("MACHINE_IS_START", 5, "20");
    public static final WearStatusType MACHINE_IS_STOP = new WearStatusType("MACHINE_IS_STOP", 6, "21");
    public static final WearStatusType WEAR_IS_START = new WearStatusType("WEAR_IS_START", 7, "30");
    public static final WearStatusType WEAR_IS_STOP = new WearStatusType("WEAR_IS_STOP", 8, "31");

    private static final /* synthetic */ WearStatusType[] $values() {
        return new WearStatusType[]{CLOSE_APP, CALL_WEAR_OPEN, APP_IS_OPEN, DEVICE_LINKED, DEVICE_UNLINKED, MACHINE_IS_START, MACHINE_IS_STOP, WEAR_IS_START, WEAR_IS_STOP};
    }

    public static EnumEntries<WearStatusType> getEntries() {
        return $ENTRIES;
    }

    public static WearStatusType valueOf(String str) {
        return (WearStatusType) Enum.valueOf(WearStatusType.class, str);
    }

    public static WearStatusType[] values() {
        return (WearStatusType[]) $VALUES.clone();
    }

    private WearStatusType(String str, int i, String str2) {
        this.id = str2;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    static {
        WearStatusType[] wearStatusTypeArr$values = $values();
        $VALUES = wearStatusTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(wearStatusTypeArr$values);
    }
}
