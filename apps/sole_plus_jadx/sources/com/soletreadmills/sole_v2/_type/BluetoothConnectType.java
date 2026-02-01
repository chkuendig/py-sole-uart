package com.soletreadmills.sole_v2._type;

import androidx.health.connect.client.records.metadata.DeviceTypes;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: BluetoothConnectType.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/soletreadmills/sole_v2/_type/BluetoothConnectType;", "", "(Ljava/lang/String;I)V", "MACHINE", DeviceTypes.WATCH, "TREADMILL", "BIKE", "ELLIPTICAL", "STEPPER", "ROWER", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BluetoothConnectType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BluetoothConnectType[] $VALUES;
    public static final BluetoothConnectType MACHINE = new BluetoothConnectType("MACHINE", 0);
    public static final BluetoothConnectType WATCH = new BluetoothConnectType(DeviceTypes.WATCH, 1);
    public static final BluetoothConnectType TREADMILL = new BluetoothConnectType("TREADMILL", 2);
    public static final BluetoothConnectType BIKE = new BluetoothConnectType("BIKE", 3);
    public static final BluetoothConnectType ELLIPTICAL = new BluetoothConnectType("ELLIPTICAL", 4);
    public static final BluetoothConnectType STEPPER = new BluetoothConnectType("STEPPER", 5);
    public static final BluetoothConnectType ROWER = new BluetoothConnectType("ROWER", 6);

    private static final /* synthetic */ BluetoothConnectType[] $values() {
        return new BluetoothConnectType[]{MACHINE, WATCH, TREADMILL, BIKE, ELLIPTICAL, STEPPER, ROWER};
    }

    public static EnumEntries<BluetoothConnectType> getEntries() {
        return $ENTRIES;
    }

    public static BluetoothConnectType valueOf(String str) {
        return (BluetoothConnectType) Enum.valueOf(BluetoothConnectType.class, str);
    }

    public static BluetoothConnectType[] values() {
        return (BluetoothConnectType[]) $VALUES.clone();
    }

    private BluetoothConnectType(String str, int i) {
    }

    static {
        BluetoothConnectType[] bluetoothConnectTypeArr$values = $values();
        $VALUES = bluetoothConnectTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(bluetoothConnectTypeArr$values);
    }
}
