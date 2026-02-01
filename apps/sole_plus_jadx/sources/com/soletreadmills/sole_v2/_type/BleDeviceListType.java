package com.soletreadmills.sole_v2._type;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: BleDeviceListType.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/soletreadmills/sole_v2/_type/BleDeviceListType;", "", "(Ljava/lang/String;I)V", "MY_DEVICES", "OTHER_DEVICES", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BleDeviceListType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BleDeviceListType[] $VALUES;
    public static final BleDeviceListType MY_DEVICES = new BleDeviceListType("MY_DEVICES", 0);
    public static final BleDeviceListType OTHER_DEVICES = new BleDeviceListType("OTHER_DEVICES", 1);

    private static final /* synthetic */ BleDeviceListType[] $values() {
        return new BleDeviceListType[]{MY_DEVICES, OTHER_DEVICES};
    }

    public static EnumEntries<BleDeviceListType> getEntries() {
        return $ENTRIES;
    }

    public static BleDeviceListType valueOf(String str) {
        return (BleDeviceListType) Enum.valueOf(BleDeviceListType.class, str);
    }

    public static BleDeviceListType[] values() {
        return (BleDeviceListType[]) $VALUES.clone();
    }

    private BleDeviceListType(String str, int i) {
    }

    static {
        BleDeviceListType[] bleDeviceListTypeArr$values = $values();
        $VALUES = bleDeviceListTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(bleDeviceListTypeArr$values);
    }
}
