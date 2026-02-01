package com.soletreadmills.sole_v2.ble.type;

import com.soletreadmills.sole_v2._type.BluetoothConnectType;
import timber.log.Timber;

/* loaded from: classes5.dex */
public enum BleFtmsMachineType {
    TREADMILL,
    BIKE,
    ELLIPTICAL,
    STEPPER,
    ROWER;

    /* renamed from: com.soletreadmills.sole_v2.ble.type.BleFtmsMachineType$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$soletreadmills$sole_v2$ble$type$BleFtmsMachineType;

        static {
            int[] iArr = new int[BleFtmsMachineType.values().length];
            $SwitchMap$com$soletreadmills$sole_v2$ble$type$BleFtmsMachineType = iArr;
            try {
                iArr[BleFtmsMachineType.TREADMILL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$soletreadmills$sole_v2$ble$type$BleFtmsMachineType[BleFtmsMachineType.BIKE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$soletreadmills$sole_v2$ble$type$BleFtmsMachineType[BleFtmsMachineType.ELLIPTICAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$soletreadmills$sole_v2$ble$type$BleFtmsMachineType[BleFtmsMachineType.STEPPER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$soletreadmills$sole_v2$ble$type$BleFtmsMachineType[BleFtmsMachineType.ROWER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public String toBluetoothConnectType() {
        int i = AnonymousClass1.$SwitchMap$com$soletreadmills$sole_v2$ble$type$BleFtmsMachineType[ordinal()];
        if (i == 1) {
            return BluetoothConnectType.TREADMILL.name();
        }
        if (i == 2) {
            return BluetoothConnectType.BIKE.name();
        }
        if (i == 3) {
            return BluetoothConnectType.ELLIPTICAL.name();
        }
        if (i == 4) {
            return BluetoothConnectType.STEPPER.name();
        }
        if (i == 5) {
            return BluetoothConnectType.ROWER.name();
        }
        Timber.e("Unknown machine type: " + this + ", using TREADMILL as default", new Object[0]);
        return BluetoothConnectType.TREADMILL.name();
    }
}
