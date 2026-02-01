package com.ua.sdk.recorder.datasource.sensor.bluetooth;

import android.bluetooth.BluetoothGattCharacteristic;

/* loaded from: classes2.dex */
public class BluetoothAction {
    protected Action actionType;
    protected BluetoothGattCharacteristic characteristic;
    protected byte[] value;

    public enum Action {
        READ,
        NOTIFY,
        WRITE
    }

    public BluetoothAction(Action action, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        this.actionType = action;
        this.characteristic = bluetoothGattCharacteristic;
        this.value = bArr;
    }

    public BluetoothAction(Action action, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this(action, bluetoothGattCharacteristic, null);
    }
}
