package com.ua.sdk.recorder.datasource.sensor.bluetooth.services;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import com.ua.sdk.recorder.datasource.sensor.bluetooth.BaseGattCallback;
import com.ua.sdk.recorder.datasource.sensor.bluetooth.BluetoothAction;
import com.ua.sdk.recorder.datasource.sensor.bluetooth.BluetoothActionQueue;
import com.ua.sdk.recorder.datasource.sensor.bluetooth.BluetoothClient;
import com.ua.sdk.recorder.datasource.sensor.bluetooth.GattAttributes;
import java.util.UUID;

/* loaded from: classes2.dex */
public class BluetoothBatteryService implements BaseGattCallback.GattCallbackListener {
    private BluetoothActionQueue actionQueue;
    private BluetoothClient.BluetoothClientListener listener;

    @Override // com.ua.sdk.recorder.datasource.sensor.bluetooth.BaseGattCallback.GattCallbackListener
    public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
    }

    @Override // com.ua.sdk.recorder.datasource.sensor.bluetooth.BaseGattCallback.GattCallbackListener
    public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
    }

    @Override // com.ua.sdk.recorder.datasource.sensor.bluetooth.BaseGattCallback.GattCallbackListener
    public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
    }

    @Override // com.ua.sdk.recorder.datasource.sensor.bluetooth.BaseGattCallback.GattCallbackListener
    public void onUnexpectedDisconnect() {
    }

    @Override // com.ua.sdk.recorder.datasource.sensor.bluetooth.BaseGattCallback.GattCallbackListener
    public void setClientListener(BluetoothClient.BluetoothClientListener bluetoothClientListener) {
        this.listener = bluetoothClientListener;
    }

    @Override // com.ua.sdk.recorder.datasource.sensor.bluetooth.BaseGattCallback.GattCallbackListener
    public void setBluetoothActionQueue(BluetoothActionQueue bluetoothActionQueue) {
        this.actionQueue = bluetoothActionQueue;
    }

    @Override // com.ua.sdk.recorder.datasource.sensor.bluetooth.BaseGattCallback.GattCallbackListener
    public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
        if (i != 0 || bluetoothGatt.getService(UUID.fromString(GattAttributes.BATTERY_SERVICE)) == null) {
            return;
        }
        BluetoothGattCharacteristic characteristic = bluetoothGatt.getService(UUID.fromString(GattAttributes.BATTERY_SERVICE)).getCharacteristic(UUID.fromString(GattAttributes.BATTERY_LEVEL_CHARACTERISTIC));
        this.actionQueue.addAction(new BluetoothAction(BluetoothAction.Action.NOTIFY, characteristic, BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE));
        this.actionQueue.addAction(new BluetoothAction(BluetoothAction.Action.READ, characteristic));
    }

    @Override // com.ua.sdk.recorder.datasource.sensor.bluetooth.BaseGattCallback.GattCallbackListener
    public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        if (i == 0) {
            parseCharacteristic(bluetoothGattCharacteristic);
        }
    }

    @Override // com.ua.sdk.recorder.datasource.sensor.bluetooth.BaseGattCallback.GattCallbackListener
    public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        parseCharacteristic(bluetoothGattCharacteristic);
    }

    private void parseCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (bluetoothGattCharacteristic.getUuid().equals(UUID.fromString(GattAttributes.BATTERY_LEVEL_CHARACTERISTIC))) {
            this.listener.onBatteryLevelMeasurement(bluetoothGattCharacteristic.getIntValue(17, 0).intValue());
        }
    }
}
