package com.ideabus.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.facebook.appevents.integrity.IntegrityManager;
import com.ideabus.library.CustomVariable;

/* loaded from: classes2.dex */
public class BluetoothLEHandler extends Handler {
    private static final String TAG = "BluetoothLEHandler";
    private BluetoothLEUtils bluetooth;
    private boolean isRun = false;
    private BluetoothAdapter mBluetoothAdapter;

    public BluetoothLEHandler(BluetoothLEUtils bluetoothLEUtils, BluetoothAdapter bluetoothAdapter) {
        this.bluetooth = bluetoothLEUtils;
        this.mBluetoothAdapter = bluetoothAdapter;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            if (BluetoothLEClass.mOnIMBluetoothLEListener != null) {
                BluetoothLEClass.mOnIMBluetoothLEListener.connectionStatus(this.bluetooth.mCurrentStatus);
            }
            if (this.bluetooth.mCurrentStatus == 17 && !this.isRun) {
                this.isRun = true;
                this.bluetooth.onWriteThreadStart(this);
                return;
            } else {
                this.isRun = false;
                return;
            }
        }
        if (i == 2) {
            if (BluetoothLEClass.mOnIMBluetoothLEListener != null) {
                BluetoothLEClass.mOnIMBluetoothLEListener.dataResult((String) message.obj);
                return;
            }
            return;
        }
        if (i == 3) {
            if (BluetoothLEClass.mOnIMBluetoothLEListener != null) {
                Bundle data = message.getData();
                BluetoothLEClass.mOnIMBluetoothLEListener.scanResult(data.getString(IntegrityManager.INTEGRITY_TYPE_ADDRESS), data.getString("name"), data.getInt("rssi"), data.getByteArray("scanRecord"));
                return;
            }
            return;
        }
        if (i == 4) {
            this.bluetooth.isScanning = false;
            BluetoothAdapter bluetoothAdapter = this.mBluetoothAdapter;
            if (bluetoothAdapter != null) {
                bluetoothAdapter.stopLeScan(this.bluetooth.setLeScanCallback());
            }
            if (BluetoothLEClass.mOnIMBluetoothLEListener != null) {
                BluetoothLEClass.mOnIMBluetoothLEListener.connectionStatus(message.what);
                return;
            }
            return;
        }
        if (i == 6) {
            if (this.bluetooth.isScanning) {
                this.bluetooth.startLEScan(message.arg1, true);
                if (BluetoothLEClass.mOnIMBluetoothLEListener != null) {
                    BluetoothLEClass.mOnIMBluetoothLEListener.connectionStatus(4);
                    return;
                }
                return;
            }
            return;
        }
        if (i == 20) {
            if (this.bluetooth.mCurrentStatus != 17) {
                Log.e(TAG, "連線超時");
                this.bluetooth.disconnect(18);
                return;
            }
            return;
        }
        if (i != 21) {
            return;
        }
        if (CustomVariable.isPrintLog) {
            Log.d(TAG, "正在創建 第 " + message.arg1 + " 顆藍牙連線");
        }
        this.bluetooth.mCurrentStatus = 21;
        this.bluetooth.addBluetoothGatt(((BluetoothDevice) message.obj).connectGatt(this.bluetooth.getContext(), false, this.bluetooth.setLeGattCallback()));
    }
}
