package com.dyaco.ideabussdk_sole.bluetooth;

import com.ideabus.bluetooth.BluetoothLEHandler;
import com.ideabus.bluetooth.WriteThread;
import com.ideabus.library.CustomVariable;

/* loaded from: classes.dex */
public class MyWriteThread extends WriteThread {
    private static final String TAG = "MyWriteThread";
    private BluetoothLEHandler mHandler;
    public OnWriteStateListener mOnWriteStateListener;
    private MyBluetoothLE myBluetoothLE;

    public interface OnWriteStateListener {
        void onWriteMessage(boolean z, String str);
    }

    public void setOnWriteStateListener(OnWriteStateListener onWriteStateListener) {
        this.mOnWriteStateListener = onWriteStateListener;
    }

    public MyWriteThread(MyBluetoothLE myBluetoothLE, BluetoothLEHandler bluetoothLEHandler) {
        super(myBluetoothLE, bluetoothLEHandler);
        this.myBluetoothLE = myBluetoothLE;
        this.mHandler = bluetoothLEHandler;
    }

    @Override // com.ideabus.bluetooth.WriteThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
    }

    @Override // com.ideabus.bluetooth.WriteThread
    public void write() throws InterruptedException {
        String comm = this.myBluetoothLE.getComm(0);
        CustomVariable.printLog("d", TAG, "write  = " + comm);
        if (comm == null) {
            this.myBluetoothLE.removeComm(0);
            return;
        }
        if (comm.length() <= 40) {
            writeData(comm);
        } else {
            while (comm.length() != 0) {
                int length = comm.length() > 40 ? 40 : comm.length();
                CustomVariable.printLog("d", TAG, "分段傳送 - write  = " + comm.substring(0, length));
                writeData(comm.substring(0, length));
                comm = comm.substring(length);
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        this.myBluetoothLE.sendCount++;
        String str = TAG;
        CustomVariable.printLog("d", str, "發送次數 = " + this.myBluetoothLE.sendCount);
        if (this.myBluetoothLE.sendCount >= 10) {
            this.myBluetoothLE.removeComm(0);
            CustomVariable.printLog("e", str, "回覆超時 自動斷線!");
            this.myBluetoothLE.sendCount = 0;
            return;
        }
        if (comm.startsWith("5B0203") || comm.startsWith("5B0400") || comm.startsWith("5B02F1")) {
            this.myBluetoothLE.sendCount = 0;
            this.myBluetoothLE.removeComm(0);
            if (comm.startsWith("5B02F1")) {
                try {
                    Thread.sleep(300L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                writeData("5B0400104F4B5D");
            }
        }
        try {
            Thread.sleep(300L);
        } catch (InterruptedException e3) {
            e3.printStackTrace();
        }
    }

    private void writeData(String str) {
        for (int i = 0; i < this.myBluetoothLE.connGattCount; i++) {
            if (this.myBluetoothLE.getBluetoothGatt(i) != null) {
                this.myBluetoothLE.charWriteList.get(i).setValue(CustomVariable.hexToBytes(str));
                boolean zWriteCharacteristic = this.myBluetoothLE.getBluetoothGatt(i).writeCharacteristic(this.myBluetoothLE.charWriteList.get(i));
                OnWriteStateListener onWriteStateListener = this.mOnWriteStateListener;
                if (onWriteStateListener != null) {
                    onWriteStateListener.onWriteMessage(zWriteCharacteristic, str);
                }
                CustomVariable.printLog("d", TAG, "writeCharacteristic 成功寫出第 " + i + " 組 " + zWriteCharacteristic + ", message = " + str);
            }
        }
    }
}
