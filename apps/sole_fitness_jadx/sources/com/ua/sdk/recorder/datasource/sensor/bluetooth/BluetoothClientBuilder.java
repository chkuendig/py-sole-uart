package com.ua.sdk.recorder.datasource.sensor.bluetooth;

import com.ua.sdk.recorder.data.BluetoothServiceType;
import com.ua.sdk.recorder.datasource.sensor.bluetooth.services.BluetoothArmour39Service;
import com.ua.sdk.recorder.datasource.sensor.bluetooth.services.BluetoothBatteryService;
import com.ua.sdk.recorder.datasource.sensor.bluetooth.services.BluetoothCscService;
import com.ua.sdk.recorder.datasource.sensor.bluetooth.services.BluetoothCyclingPowerService;
import com.ua.sdk.recorder.datasource.sensor.bluetooth.services.BluetoothHeartRateService;
import com.ua.sdk.recorder.datasource.sensor.bluetooth.services.BluetoothRscService;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public class BluetoothClientBuilder {
    private Set<BluetoothServiceType> serviceTypes;

    public BluetoothClientBuilder(Set<BluetoothServiceType> set) {
        this.serviceTypes = set;
    }

    public BluetoothClient build() {
        try {
            return createClientCallable(this.serviceTypes).call();
        } catch (Exception e) {
            throw new IllegalStateException("Unable to create a new bluetooth client!", e);
        }
    }

    private Callable<BluetoothClient> createClientCallable(final Set<BluetoothServiceType> set) {
        return new Callable<BluetoothClient>() { // from class: com.ua.sdk.recorder.datasource.sensor.bluetooth.BluetoothClientBuilder.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public BluetoothClient call() throws Exception {
                BaseGattCallback baseGattCallback = new BaseGattCallback();
                baseGattCallback.addGattCallbackListener(new BluetoothBatteryService());
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    int i = AnonymousClass2.$SwitchMap$com$ua$sdk$recorder$data$BluetoothServiceType[((BluetoothServiceType) it.next()).ordinal()];
                    if (i == 1) {
                        baseGattCallback.addGattCallbackListener(new BluetoothHeartRateService());
                    } else if (i == 2) {
                        baseGattCallback.addGattCallbackListener(new BluetoothRscService());
                    } else if (i == 3) {
                        baseGattCallback.addGattCallbackListener(new BluetoothCscService());
                    } else if (i == 4) {
                        baseGattCallback.addGattCallbackListener(new BluetoothCyclingPowerService());
                    } else if (i == 5) {
                        baseGattCallback.addGattCallbackListener(new BluetoothArmour39Service());
                    }
                }
                return new BluetoothConnection(baseGattCallback);
            }
        };
    }

    /* renamed from: com.ua.sdk.recorder.datasource.sensor.bluetooth.BluetoothClientBuilder$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
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
                $SwitchMap$com$ua$sdk$recorder$data$BluetoothServiceType[BluetoothServiceType.BIKE_SPEED_CADENCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ua$sdk$recorder$data$BluetoothServiceType[BluetoothServiceType.BIKE_POWER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ua$sdk$recorder$data$BluetoothServiceType[BluetoothServiceType.ARMOUR_39.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }
}
