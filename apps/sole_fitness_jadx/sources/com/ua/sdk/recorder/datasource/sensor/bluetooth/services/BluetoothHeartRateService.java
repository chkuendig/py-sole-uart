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
public class BluetoothHeartRateService implements BaseGattCallback.GattCallbackListener {
    private BluetoothActionQueue actionQueue;
    private BluetoothGattCharacteristic characteristic;
    private boolean isReconnect;
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
    public void setClientListener(BluetoothClient.BluetoothClientListener bluetoothClientListener) {
        this.listener = bluetoothClientListener;
    }

    @Override // com.ua.sdk.recorder.datasource.sensor.bluetooth.BaseGattCallback.GattCallbackListener
    public void setBluetoothActionQueue(BluetoothActionQueue bluetoothActionQueue) {
        this.actionQueue = bluetoothActionQueue;
    }

    @Override // com.ua.sdk.recorder.datasource.sensor.bluetooth.BaseGattCallback.GattCallbackListener
    public void onUnexpectedDisconnect() {
        this.isReconnect = true;
    }

    public void startWorkout() {
        this.actionQueue.addAction(new BluetoothAction(BluetoothAction.Action.READ, this.characteristic, null));
    }

    @Override // com.ua.sdk.recorder.datasource.sensor.bluetooth.BaseGattCallback.GattCallbackListener
    public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
        if (i != 0 || bluetoothGatt.getService(UUID.fromString(GattAttributes.HEART_RATE_SERVICE)) == null) {
            return;
        }
        this.characteristic = bluetoothGatt.getService(UUID.fromString(GattAttributes.HEART_RATE_SERVICE)).getCharacteristic(UUID.fromString(GattAttributes.HEART_RATE_CHARACTERISTIC));
        this.actionQueue.addAction(new BluetoothAction(BluetoothAction.Action.NOTIFY, this.characteristic, BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE));
        startWorkout();
    }

    @Override // com.ua.sdk.recorder.datasource.sensor.bluetooth.BaseGattCallback.GattCallbackListener
    public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        BluetoothGattCharacteristic characteristic;
        if (i != 0 || bluetoothGatt.getService(UUID.fromString(GattAttributes.HEART_RATE_SERVICE)) == null || !bluetoothGattCharacteristic.getUuid().equals(UUID.fromString(GattAttributes.HEART_RATE_CHARACTERISTIC)) || (bluetoothGattCharacteristic.getIntValue(17, 0).intValue() & 8) == 0 || this.isReconnect || (characteristic = bluetoothGatt.getService(UUID.fromString(GattAttributes.HEART_RATE_SERVICE)).getCharacteristic(UUID.fromString(GattAttributes.HEART_RATE_CONTROL_POINT_CHARACTERISTIC))) == null) {
            return;
        }
        this.actionQueue.addAction(new BluetoothAction(BluetoothAction.Action.WRITE, characteristic, new byte[]{0}));
    }

    @Override // com.ua.sdk.recorder.datasource.sensor.bluetooth.BaseGattCallback.GattCallbackListener
    public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (bluetoothGatt.getService(UUID.fromString(GattAttributes.HEART_RATE_SERVICE)) != null) {
            parseCharacteristic(bluetoothGattCharacteristic);
        }
    }

    private void parseCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        int i;
        if (UUID.fromString(GattAttributes.HEART_RATE_CHARACTERISTIC).equals(bluetoothGattCharacteristic.getUuid())) {
            int i2 = 17;
            int iIntValue = bluetoothGattCharacteristic.getIntValue(17, 0).intValue();
            if ((iIntValue & 1) != 0) {
                i = 3;
                i2 = 18;
            } else {
                i = 2;
            }
            this.listener.onHeartRateMeasurement(bluetoothGattCharacteristic.getIntValue(i2, 1).longValue(), (iIntValue & 8) != 0 ? bluetoothGattCharacteristic.getIntValue(18, i).intValue() / 1000 : -1L);
        }
    }
}
