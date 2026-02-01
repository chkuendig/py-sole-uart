package com.soletreadmills.sole_v2._type;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: BluetoothComeClassType.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/_type/BluetoothComeClassType;", "", "(Ljava/lang/String;I)V", "ClassesContentFragment", "SubscriptionBluetoothFragment", "ClubRaceFragment", "Subscription", "DisplayDashboardFragment", "Rematch", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BluetoothComeClassType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BluetoothComeClassType[] $VALUES;
    public static final BluetoothComeClassType ClassesContentFragment = new BluetoothComeClassType("ClassesContentFragment", 0);
    public static final BluetoothComeClassType SubscriptionBluetoothFragment = new BluetoothComeClassType("SubscriptionBluetoothFragment", 1);
    public static final BluetoothComeClassType ClubRaceFragment = new BluetoothComeClassType("ClubRaceFragment", 2);
    public static final BluetoothComeClassType Subscription = new BluetoothComeClassType("Subscription", 3);
    public static final BluetoothComeClassType DisplayDashboardFragment = new BluetoothComeClassType("DisplayDashboardFragment", 4);
    public static final BluetoothComeClassType Rematch = new BluetoothComeClassType("Rematch", 5);

    private static final /* synthetic */ BluetoothComeClassType[] $values() {
        return new BluetoothComeClassType[]{ClassesContentFragment, SubscriptionBluetoothFragment, ClubRaceFragment, Subscription, DisplayDashboardFragment, Rematch};
    }

    public static EnumEntries<BluetoothComeClassType> getEntries() {
        return $ENTRIES;
    }

    public static BluetoothComeClassType valueOf(String str) {
        return (BluetoothComeClassType) Enum.valueOf(BluetoothComeClassType.class, str);
    }

    public static BluetoothComeClassType[] values() {
        return (BluetoothComeClassType[]) $VALUES.clone();
    }

    private BluetoothComeClassType(String str, int i) {
    }

    static {
        BluetoothComeClassType[] bluetoothComeClassTypeArr$values = $values();
        $VALUES = bluetoothComeClassTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(bluetoothComeClassTypeArr$values);
    }
}
