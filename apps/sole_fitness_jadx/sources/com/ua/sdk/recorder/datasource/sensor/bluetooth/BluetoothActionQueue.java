package com.ua.sdk.recorder.datasource.sensor.bluetooth;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattDescriptor;
import com.ua.sdk.recorder.datasource.sensor.bluetooth.BluetoothAction;
import java.util.ArrayDeque;
import java.util.UUID;

/* loaded from: classes2.dex */
public class BluetoothActionQueue {
    private final ArrayDeque<BluetoothAction> actions = new ArrayDeque<>(32);
    private BluetoothGatt gatt;

    public BluetoothActionQueue(BluetoothGatt bluetoothGatt) {
        this.gatt = bluetoothGatt;
    }

    public void addAction(BluetoothAction bluetoothAction) {
        this.actions.add(bluetoothAction);
    }

    protected boolean isEmpty() {
        return this.actions.isEmpty();
    }

    protected void poll() {
        synchronized (this.actions) {
            if (this.actions.peek() != null) {
                BluetoothAction bluetoothActionPoll = this.actions.poll();
                int i = AnonymousClass1.$SwitchMap$com$ua$sdk$recorder$datasource$sensor$bluetooth$BluetoothAction$Action[bluetoothActionPoll.actionType.ordinal()];
                if (i == 1) {
                    bluetoothActionPoll.characteristic.setValue(bluetoothActionPoll.value);
                    this.gatt.writeCharacteristic(bluetoothActionPoll.characteristic);
                } else if (i == 2) {
                    this.gatt.setCharacteristicNotification(bluetoothActionPoll.characteristic, true);
                    BluetoothGattDescriptor descriptor = bluetoothActionPoll.characteristic.getDescriptor(UUID.fromString(GattAttributes.CLIENT_CHARACTERISTIC_CONFIG_DESCRIPTOR));
                    descriptor.setValue(bluetoothActionPoll.value);
                    this.gatt.writeDescriptor(descriptor);
                } else if (i == 3) {
                    this.gatt.readCharacteristic(bluetoothActionPoll.characteristic);
                }
            }
        }
    }

    /* renamed from: com.ua.sdk.recorder.datasource.sensor.bluetooth.BluetoothActionQueue$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ua$sdk$recorder$datasource$sensor$bluetooth$BluetoothAction$Action;

        static {
            int[] iArr = new int[BluetoothAction.Action.values().length];
            $SwitchMap$com$ua$sdk$recorder$datasource$sensor$bluetooth$BluetoothAction$Action = iArr;
            try {
                iArr[BluetoothAction.Action.WRITE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ua$sdk$recorder$datasource$sensor$bluetooth$BluetoothAction$Action[BluetoothAction.Action.NOTIFY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ua$sdk$recorder$datasource$sensor$bluetooth$BluetoothAction$Action[BluetoothAction.Action.READ.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
