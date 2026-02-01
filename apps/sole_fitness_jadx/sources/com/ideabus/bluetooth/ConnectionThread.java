package com.ideabus.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.Message;
import android.util.Log;
import java.util.List;

/* loaded from: classes2.dex */
public class ConnectionThread extends Thread {
    private static final String TAG = "ConnectionThread";
    private List<String> address;
    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothLEHandler mHandler;
    private BluetoothLEUtils myBluetooth;

    public ConnectionThread(BluetoothLEUtils bluetoothLEUtils, BluetoothAdapter bluetoothAdapter, BluetoothLEHandler bluetoothLEHandler, List<String> list) {
        this.myBluetooth = bluetoothLEUtils;
        this.mBluetoothAdapter = bluetoothAdapter;
        this.mHandler = bluetoothLEHandler;
        this.address = list;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.mHandler.removeMessages(20);
        this.mHandler.sendEmptyMessageDelayed(20, 15000L);
        synchronized (this) {
            for (int i = 0; i < this.myBluetooth.connGattCount; i++) {
                try {
                    BluetoothDevice remoteDevice = this.mBluetoothAdapter.getRemoteDevice(this.address.get(i));
                    if (remoteDevice == null) {
                        Log.e(TAG, "第 " + i + " 顆藍牙未找到");
                        this.myBluetooth.disconnect(18);
                        return;
                    }
                    Message message = new Message();
                    message.what = 21;
                    message.arg1 = i;
                    message.obj = remoteDevice;
                    this.mHandler.sendMessage(message);
                    if (i < this.myBluetooth.connGattCount - 1) {
                        try {
                            wait();
                            Thread.sleep(600L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            this.myBluetooth.disconnect(18);
                            return;
                        }
                    }
                } catch (IllegalArgumentException e2) {
                    Log.e(TAG, "連接 第 " + i + " 顆藍牙出現錯誤  " + e2.toString());
                    this.myBluetooth.disconnect(18);
                    return;
                }
            }
        }
    }
}
