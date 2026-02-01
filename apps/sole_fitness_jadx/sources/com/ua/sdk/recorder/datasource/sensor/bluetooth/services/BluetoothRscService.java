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
public class BluetoothRscService implements BaseGattCallback.GattCallbackListener {
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
        if (i != 0 || bluetoothGatt.getService(UUID.fromString(GattAttributes.RSC_SERVICE)) == null) {
            return;
        }
        BluetoothGattCharacteristic characteristic = bluetoothGatt.getService(UUID.fromString(GattAttributes.RSC_SERVICE)).getCharacteristic(UUID.fromString(GattAttributes.RSC_MEASUREMENT_CHARACTERISTIC));
        this.actionQueue.addAction(new BluetoothAction(BluetoothAction.Action.NOTIFY, characteristic, BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE));
        this.actionQueue.addAction(new BluetoothAction(BluetoothAction.Action.READ, characteristic, null));
    }

    @Override // com.ua.sdk.recorder.datasource.sensor.bluetooth.BaseGattCallback.GattCallbackListener
    public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        BluetoothGattCharacteristic characteristic;
        if (i != 0 || !bluetoothGattCharacteristic.getUuid().equals(UUID.fromString(GattAttributes.RSC_MEASUREMENT_CHARACTERISTIC)) || (bluetoothGattCharacteristic.getIntValue(17, 0).intValue() & 2) == 0 || (characteristic = bluetoothGatt.getService(UUID.fromString(GattAttributes.RSC_SERVICE)).getCharacteristic(UUID.fromString(GattAttributes.CONTROL_POINT_CHARACTERISTIC))) == null) {
            return;
        }
        this.actionQueue.addAction(new BluetoothAction(BluetoothAction.Action.NOTIFY, characteristic, BluetoothGattDescriptor.ENABLE_INDICATION_VALUE));
    }

    @Override // com.ua.sdk.recorder.datasource.sensor.bluetooth.BaseGattCallback.GattCallbackListener
    public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        parseCharacteristic(bluetoothGattCharacteristic);
    }

    private void parseCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        double dIntValue;
        int i;
        BluetoothRscService bluetoothRscService;
        double dIntValue2;
        if (UUID.fromString(GattAttributes.RSC_MEASUREMENT_CHARACTERISTIC).equals(bluetoothGattCharacteristic.getUuid())) {
            int iIntValue = bluetoothGattCharacteristic.getIntValue(17, 0).intValue();
            double dIntValue3 = bluetoothGattCharacteristic.getIntValue(18, 1).intValue() / 256.0d;
            long jIntValue = bluetoothGattCharacteristic.getIntValue(17, 3).intValue();
            if ((iIntValue & 1) != 0) {
                i = 6;
                dIntValue = bluetoothGattCharacteristic.getIntValue(18, 4).intValue() / 100.0d;
            } else {
                dIntValue = -1.0d;
                i = 4;
            }
            if ((iIntValue & 2) != 0) {
                dIntValue2 = bluetoothGattCharacteristic.getIntValue(20, i).intValue() / 10.0d;
                bluetoothRscService = this;
            } else {
                bluetoothRscService = this;
                dIntValue2 = -1.0d;
            }
            bluetoothRscService.listener.onRscMeasurement(dIntValue3, jIntValue, dIntValue, dIntValue2, (iIntValue & 4) != 0);
        }
    }
}
