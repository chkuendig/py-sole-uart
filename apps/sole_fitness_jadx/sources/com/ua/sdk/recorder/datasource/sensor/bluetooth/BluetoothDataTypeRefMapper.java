package com.ua.sdk.recorder.datasource.sensor.bluetooth;

import com.ua.sdk.datapoint.BaseDataTypes;
import com.ua.sdk.datapoint.DataTypeRef;
import com.ua.sdk.recorder.data.BluetoothServiceType;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class BluetoothDataTypeRefMapper {
    public static List<DataTypeRef> getDataTypeRefFromService(BluetoothServiceType bluetoothServiceType) {
        ArrayList arrayList = new ArrayList();
        int i = AnonymousClass1.$SwitchMap$com$ua$sdk$recorder$data$BluetoothServiceType[bluetoothServiceType.ordinal()];
        if (i == 1) {
            arrayList.add(BaseDataTypes.TYPE_HEART_RATE.getRef());
            arrayList.add(BaseDataTypes.TYPE_ENERGY_EXPENDED.getRef());
        } else if (i == 2) {
            arrayList.add(BaseDataTypes.TYPE_SPEED.getRef());
            arrayList.add(BaseDataTypes.TYPE_RUN_CADENCE.getRef());
            arrayList.add(BaseDataTypes.TYPE_STRIDE_LENGTH.getRef());
            arrayList.add(BaseDataTypes.TYPE_DISTANCE.getRef());
        } else if (i == 3) {
            arrayList.add(BaseDataTypes.TYPE_CYCLING_POWER.getRef());
            arrayList.add(BaseDataTypes.TYPE_CYCLING_POWER_BALANCE.getRef());
            arrayList.add(BaseDataTypes.TYPE_ACCUMULATED_TORQUE.getRef());
            arrayList.add(BaseDataTypes.TYPE_WHEEL_REVOLUTIONS.getRef());
            arrayList.add(BaseDataTypes.TYPE_CRANK_REVOLUTIONS.getRef());
            arrayList.add(BaseDataTypes.TYPE_EXTREME_FORCES.getRef());
            arrayList.add(BaseDataTypes.TYPE_EXTREME_TORQUE.getRef());
            arrayList.add(BaseDataTypes.TYPE_EXTREME_ANGLES.getRef());
            arrayList.add(BaseDataTypes.TYPE_TOP_DEAD_SPOT_ANGLE.getRef());
            arrayList.add(BaseDataTypes.TYPE_BOTTOM_DEAD_SPOT_ANGLE.getRef());
            arrayList.add(BaseDataTypes.TYPE_ENERGY_EXPENDED.getRef());
        } else if (i == 4) {
            arrayList.add(BaseDataTypes.TYPE_WHEEL_REVOLUTIONS.getRef());
            arrayList.add(BaseDataTypes.TYPE_CRANK_REVOLUTIONS.getRef());
        } else if (i == 5) {
            arrayList.add(BaseDataTypes.TYPE_STEPS.getRef());
            arrayList.add(BaseDataTypes.TYPE_ENERGY_EXPENDED.getRef());
            arrayList.add(BaseDataTypes.TYPE_WILLPOWER.getRef());
            arrayList.add(BaseDataTypes.TYPE_POSTURE.getRef());
            arrayList.add(BaseDataTypes.TYPE_RUN_CADENCE.getRef());
        }
        return arrayList;
    }

    /* renamed from: com.ua.sdk.recorder.datasource.sensor.bluetooth.BluetoothDataTypeRefMapper$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ua$sdk$recorder$data$BluetoothServiceType;

        static {
            int[] iArr = new int[BluetoothServiceType.values().length];
            $SwitchMap$com$ua$sdk$recorder$data$BluetoothServiceType = iArr;
            try {
                iArr[BluetoothServiceType.HEART_RATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ua$sdk$recorder$data$BluetoothServiceType[BluetoothServiceType.RUN_SPEED_CADENCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ua$sdk$recorder$data$BluetoothServiceType[BluetoothServiceType.BIKE_POWER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ua$sdk$recorder$data$BluetoothServiceType[BluetoothServiceType.BIKE_SPEED_CADENCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ua$sdk$recorder$data$BluetoothServiceType[BluetoothServiceType.ARMOUR_39.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }
}
