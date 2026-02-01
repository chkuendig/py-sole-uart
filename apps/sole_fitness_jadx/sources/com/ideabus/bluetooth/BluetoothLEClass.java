package com.ideabus.bluetooth;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class BluetoothLEClass {
    public static final int ACTION_REQUEST_ENABLE = 100;
    public static final int CALLBACK_RESULT = 2;
    public static final int CALLBACK_STATE = 1;
    public static final int CONNECTED = 17;
    public static final int CONNECTING = 21;
    public static final int CONNECT_PERIOD = 15000;
    public static final int CONNECT_TIMEOUT = 20;
    public static final int DISCONNECTED = 18;
    public static final int ERROR133_RESTART_BT = 23;
    public static final int NONE = 16;
    public static final int SCAN_FINISH = 4;
    public static final int SCAN_LOOP = 6;
    public static final int SCAN_RESULT = 3;
    public static final int SCAN_STOP = 5;

    @Deprecated
    public static final int UNSPECIFIED_ADDRESS = 19;
    public static OnIMBluetoothLEListener mOnIMBluetoothLEListener;
    public List<BluetoothGattCharacteristic> charWriteList;
    private List<String> commArray;
    private List<BluetoothGatt> mBluetoothGatts;
    public int charNotifyCount = 0;
    public int connGattCount = 0;
    public boolean isWriteRunning = false;
    public int mCurrentStatus = 16;

    public interface OnIMBluetoothLEListener {
        void connectionStatus(int i);

        void dataResult(String str);

        void onBtStateChanged(boolean z);

        void scanResult(String str, String str2, int i, byte[] bArr);
    }

    public void initBluetoothGattsArray() {
        this.mBluetoothGatts = new ArrayList();
    }

    public void addBluetoothGatt(BluetoothGatt bluetoothGatt) {
        List<BluetoothGatt> list = this.mBluetoothGatts;
        if (list != null) {
            list.add(bluetoothGatt);
        }
    }

    public BluetoothGatt getBluetoothGatt(int i) {
        List<BluetoothGatt> list = this.mBluetoothGatts;
        if (list == null || list.size() <= i) {
            return null;
        }
        return this.mBluetoothGatts.get(i);
    }

    public List<BluetoothGatt> getBluetoothGatts() {
        return this.mBluetoothGatts;
    }

    public void removeBluetoothGatt() {
        List<BluetoothGatt> list = this.mBluetoothGatts;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.mBluetoothGatts.remove(0);
    }

    public void initCommArray() {
        this.commArray = new ArrayList();
    }

    public void addCommArray(String str) {
        List<String> list = this.commArray;
        if (list != null) {
            list.add(str);
        }
    }

    public String getComm(int i) {
        List<String> list = this.commArray;
        if (list == null || list.size() <= i) {
            return null;
        }
        return this.commArray.get(i);
    }

    public int getCommArraySize() {
        List<String> list = this.commArray;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void removeComm(int i) {
        List<String> list = this.commArray;
        if (list == null || list.size() <= i) {
            return;
        }
        this.commArray.remove(i);
    }

    public void removeSameComm(String str) {
        if (this.commArray == null) {
            return;
        }
        for (int i = 0; i < this.commArray.size(); i++) {
            if (this.commArray.get(i).equals(str)) {
                this.commArray.remove(i);
            }
        }
    }

    public void removeOtherComm() {
        List<String> list = this.commArray;
        if (list == null || list.size() <= 1) {
            return;
        }
        String str = this.commArray.get(0);
        this.commArray.clear();
        this.commArray.add(str);
    }

    public void removeAllComm() {
        List<String> list = this.commArray;
        if (list != null) {
            list.clear();
        }
    }

    public void setOnIMBluetoothLEListener(OnIMBluetoothLEListener onIMBluetoothLEListener) {
        mOnIMBluetoothLEListener = onIMBluetoothLEListener;
    }
}
