package com.soletreadmills.sole_v2._type;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: WearMsgDataType.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/soletreadmills/sole_v2/_type/WearMsgDataType;", "", "(Ljava/lang/String;I)V", "HR", "CMD", "ASK_CONNECT", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WearMsgDataType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ WearMsgDataType[] $VALUES;
    public static final WearMsgDataType HR = new WearMsgDataType("HR", 0);
    public static final WearMsgDataType CMD = new WearMsgDataType("CMD", 1);
    public static final WearMsgDataType ASK_CONNECT = new WearMsgDataType("ASK_CONNECT", 2);

    private static final /* synthetic */ WearMsgDataType[] $values() {
        return new WearMsgDataType[]{HR, CMD, ASK_CONNECT};
    }

    public static EnumEntries<WearMsgDataType> getEntries() {
        return $ENTRIES;
    }

    public static WearMsgDataType valueOf(String str) {
        return (WearMsgDataType) Enum.valueOf(WearMsgDataType.class, str);
    }

    public static WearMsgDataType[] values() {
        return (WearMsgDataType[]) $VALUES.clone();
    }

    private WearMsgDataType(String str, int i) {
    }

    static {
        WearMsgDataType[] wearMsgDataTypeArr$values = $values();
        $VALUES = wearMsgDataTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(wearMsgDataTypeArr$values);
    }
}
