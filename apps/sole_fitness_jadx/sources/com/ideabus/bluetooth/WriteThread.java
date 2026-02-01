package com.ideabus.bluetooth;

/* loaded from: classes2.dex */
public abstract class WriteThread extends Thread {
    private static final String TAG = "WriteThread";
    private BluetoothLEUtils myBluetooth;

    public abstract void write();

    public WriteThread(BluetoothLEUtils bluetoothLEUtils, BluetoothLEHandler bluetoothLEHandler) {
        this.myBluetooth = bluetoothLEUtils;
        bluetoothLEUtils.isWriteRunning = true;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (this.myBluetooth.isWriteRunning) {
            if (this.myBluetooth.getCommArraySize() > 0) {
                if (this.myBluetooth.mCurrentStatus != 17) {
                    return;
                } else {
                    write();
                }
            }
        }
    }
}
