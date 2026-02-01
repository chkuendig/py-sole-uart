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
import kotlin.UByte;

/* loaded from: classes2.dex */
public class BluetoothCyclingPowerService implements BaseGattCallback.GattCallbackListener {
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
        if (i != 0 || bluetoothGatt.getService(UUID.fromString(GattAttributes.CYCLING_POWER_CHARACTERISTIC)) == null) {
            return;
        }
        this.actionQueue.addAction(new BluetoothAction(BluetoothAction.Action.NOTIFY, bluetoothGatt.getService(UUID.fromString(GattAttributes.CYCLING_POWER_SERVICE)).getCharacteristic(UUID.fromString(GattAttributes.CYCLING_POWER_CHARACTERISTIC)), BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE));
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
        double dIntValue;
        double d;
        long jIntValue;
        long j;
        long j2;
        long j3;
        double d2;
        double d3;
        long j4;
        long j5;
        int i;
        long j6;
        long j7;
        if (UUID.fromString(GattAttributes.CYCLING_POWER_CHARACTERISTIC).equals(bluetoothGattCharacteristic.getUuid())) {
            int iIntValue = bluetoothGattCharacteristic.getIntValue(18, 0).intValue();
            int iIntValue2 = bluetoothGattCharacteristic.getIntValue(34, 2).intValue();
            int i2 = 4;
            if ((iIntValue & 1) != 0) {
                dIntValue = bluetoothGattCharacteristic.getIntValue(17, 4).intValue() / 2.0d;
                i2 = 5;
            } else {
                dIntValue = -1.0d;
            }
            if ((iIntValue & 4) != 0) {
                double dIntValue2 = bluetoothGattCharacteristic.getIntValue(18, i2).intValue() / 32.0d;
                i2 += 2;
                d = dIntValue2;
            } else {
                d = -1.0d;
            }
            if ((iIntValue & 16) != 0) {
                jIntValue = bluetoothGattCharacteristic.getIntValue(20, i2).intValue();
                i2 += 4;
            } else {
                jIntValue = -1;
            }
            if ((iIntValue & 32) != 0) {
                long jIntValue2 = bluetoothGattCharacteristic.getIntValue(18, i2).intValue();
                i2 += 2;
                j = jIntValue2;
            } else {
                j = -1;
            }
            if ((iIntValue & 64) != 0) {
                long jIntValue3 = bluetoothGattCharacteristic.getIntValue(34, i2).intValue();
                int i3 = i2 + 2;
                long jIntValue4 = bluetoothGattCharacteristic.getIntValue(34, i3).intValue();
                i2 = i3 + 2;
                j3 = jIntValue4;
                j2 = jIntValue3;
            } else {
                j2 = -1;
                j3 = -1;
            }
            if ((iIntValue & 128) != 0) {
                double dIntValue3 = bluetoothGattCharacteristic.getIntValue(34, i2).intValue() / 32.0d;
                double dIntValue4 = bluetoothGattCharacteristic.getIntValue(34, r7).intValue() / 32.0d;
                i2 = i2 + 2 + 2;
                d3 = dIntValue4;
                d2 = dIntValue3;
            } else {
                d2 = -1.0d;
                d3 = -1.0d;
            }
            if ((iIntValue & 256) != 0) {
                byte[] value = bluetoothGattCharacteristic.getValue();
                byte b = value[i2];
                byte b2 = value[i2 + 1];
                byte b3 = value[i2 + 2];
                long j8 = b + (b2 & UByte.MAX_VALUE);
                i2 += 3;
                j5 = b3 + (b2 & UByte.MIN_VALUE);
                j4 = j8;
            } else {
                j4 = -1;
                j5 = -1;
            }
            if ((iIntValue & 512) != 0) {
                i = 18;
                long jIntValue5 = bluetoothGattCharacteristic.getIntValue(18, i2).intValue();
                i2 += 2;
                j6 = jIntValue5;
            } else {
                i = 18;
                j6 = -1;
            }
            if ((iIntValue & 1024) != 0) {
                long jIntValue6 = bluetoothGattCharacteristic.getIntValue(i, i2).intValue();
                i2 += 2;
                j7 = jIntValue6;
            } else {
                j7 = -1;
            }
            this.listener.onCyclingPowerMeasurement(iIntValue2, dIntValue, d, jIntValue, j, j2, j3, d2, d3, j4, j5, j6, j7, (iIntValue & 2048) != 0 ? bluetoothGattCharacteristic.getIntValue(i, i2).intValue() / 1000 : -1L);
        }
    }
}
