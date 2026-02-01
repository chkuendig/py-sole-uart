package com.ua.sdk.recorder.datasource.sensor.bluetooth;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import com.ua.sdk.UaLog;
import com.ua.sdk.recorder.RecorderContext;
import com.ua.sdk.recorder.SensorStatus;
import com.ua.sdk.recorder.datasource.sensor.bluetooth.BluetoothClient;
import com.ua.sdk.recorder.datasource.sensor.bluetooth.services.BluetoothArmour39Service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class BaseGattCallback extends BluetoothGattCallback {
    private BluetoothActionQueue bluetoothActionQueue;
    private BluetoothClient.BluetoothClientListener clientListener;
    private ConnectionLostListener connectionLostListener;
    private List<GattCallbackListener> gattCallbackListeners = new ArrayList();
    private boolean isClientDisconnect;

    public interface ConnectionLostListener {
        void onScheduleReconnect(long j);
    }

    public interface GattCallbackListener {
        void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic);

        void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i);

        void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i);

        void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i);

        void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i);

        void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i);

        void onUnexpectedDisconnect();

        void setBluetoothActionQueue(BluetoothActionQueue bluetoothActionQueue);

        void setClientListener(BluetoothClient.BluetoothClientListener bluetoothClientListener);
    }

    public void setClientListener(BluetoothClient.BluetoothClientListener bluetoothClientListener) {
        this.clientListener = bluetoothClientListener;
    }

    public void addGattCallbackListener(GattCallbackListener gattCallbackListener) {
        this.gattCallbackListeners.add(gattCallbackListener);
    }

    public void configure(RecorderContext recorderContext) {
        for (GattCallbackListener gattCallbackListener : this.gattCallbackListeners) {
            if (gattCallbackListener instanceof BluetoothArmour39Service) {
                ((BluetoothArmour39Service) gattCallbackListener).configureUser(recorderContext.getUser(), recorderContext.getHeartRateZones());
            }
        }
    }

    public void disconnect() {
        this.isClientDisconnect = true;
        if (this.bluetoothActionQueue != null) {
            for (GattCallbackListener gattCallbackListener : this.gattCallbackListeners) {
                if (gattCallbackListener instanceof BluetoothArmour39Service) {
                    BluetoothArmour39Service bluetoothArmour39Service = (BluetoothArmour39Service) gattCallbackListener;
                    bluetoothArmour39Service.stopWorkout();
                    bluetoothArmour39Service.disconnect();
                }
            }
            while (!this.bluetoothActionQueue.isEmpty()) {
                this.bluetoothActionQueue.poll();
            }
        }
    }

    public void startSegment() {
        for (GattCallbackListener gattCallbackListener : this.gattCallbackListeners) {
            if (gattCallbackListener instanceof BluetoothArmour39Service) {
                ((BluetoothArmour39Service) gattCallbackListener).startWorkout();
            }
        }
    }

    public void setConnectionLostListener(ConnectionLostListener connectionLostListener) {
        this.connectionLostListener = connectionLostListener;
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
        if (i == 0 && i2 == 2) {
            this.bluetoothActionQueue = new BluetoothActionQueue(bluetoothGatt);
            for (GattCallbackListener gattCallbackListener : this.gattCallbackListeners) {
                gattCallbackListener.setBluetoothActionQueue(this.bluetoothActionQueue);
                gattCallbackListener.setClientListener(this.clientListener);
            }
            BluetoothClient.BluetoothClientListener bluetoothClientListener = this.clientListener;
            if (bluetoothClientListener != null) {
                bluetoothClientListener.onConnectionStatusChanged(SensorStatus.CONNECTED);
            }
            bluetoothGatt.discoverServices();
            return;
        }
        if (this.isClientDisconnect) {
            return;
        }
        UaLog.error("Bluetooth Connection has been lost unexpectedly for " + bluetoothGatt.getDevice().getAddress());
        BluetoothClient.BluetoothClientListener bluetoothClientListener2 = this.clientListener;
        if (bluetoothClientListener2 != null) {
            bluetoothClientListener2.onConnectionStatusChanged(SensorStatus.DISCONNECTED);
        }
        ConnectionLostListener connectionLostListener = this.connectionLostListener;
        if (connectionLostListener != null) {
            connectionLostListener.onScheduleReconnect(5000L);
        }
        Iterator<GattCallbackListener> it = this.gattCallbackListeners.iterator();
        while (it.hasNext()) {
            it.next().onUnexpectedDisconnect();
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
        Iterator<GattCallbackListener> it = this.gattCallbackListeners.iterator();
        while (it.hasNext()) {
            it.next().onServicesDiscovered(bluetoothGatt, i);
        }
        this.bluetoothActionQueue.poll();
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        Iterator<GattCallbackListener> it = this.gattCallbackListeners.iterator();
        while (it.hasNext()) {
            it.next().onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i);
        }
        this.bluetoothActionQueue.poll();
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        Iterator<GattCallbackListener> it = this.gattCallbackListeners.iterator();
        while (it.hasNext()) {
            it.next().onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i);
        }
        this.bluetoothActionQueue.poll();
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        Iterator<GattCallbackListener> it = this.gattCallbackListeners.iterator();
        while (it.hasNext()) {
            it.next().onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
        }
        this.bluetoothActionQueue.poll();
        bluetoothGatt.readRemoteRssi();
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        Iterator<GattCallbackListener> it = this.gattCallbackListeners.iterator();
        while (it.hasNext()) {
            it.next().onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, i);
        }
        this.bluetoothActionQueue.poll();
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        Iterator<GattCallbackListener> it = this.gattCallbackListeners.iterator();
        while (it.hasNext()) {
            it.next().onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i);
        }
        this.bluetoothActionQueue.poll();
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i, int i2) {
        this.clientListener.onRssiMeasurement(i);
    }
}
