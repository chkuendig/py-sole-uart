package com.ideabus.bluetooth;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import com.facebook.appevents.integrity.IntegrityManager;
import com.ideabus.library.CustomVariable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class BluetoothLEUtils extends BluetoothLEClass {
    private static final String TAG = "BluetoothLEUtils";
    private static boolean isRegisterBtReceiver = false;
    private Context context;
    private boolean isRestartingBT;
    private BluetoothAdapter mBluetoothAdapter;
    private ConnectionThread mConnectionThread;
    public BluetoothLEHandler mHandler;
    private BluetoothGattCallback mLeGattCallback;
    private BluetoothAdapter.LeScanCallback mLeOldScanCallback;
    private List<String> mScanList;
    public boolean isScanning = false;
    private BroadcastReceiver mReceiver = new BroadcastReceiver() { // from class: com.ideabus.bluetooth.BluetoothLEUtils.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(intent.getAction())) {
                try {
                    int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
                    Log.d(BluetoothLEUtils.TAG, "BluetoothLEUtils mReceiver--------------" + intExtra);
                    if (intExtra == 10) {
                        Log.d(BluetoothLEUtils.TAG, "Bluetooth disable!");
                        BluetoothLEUtils.mOnIMBluetoothLEListener.onBtStateChanged(false);
                        BluetoothLEUtils.this.unregisterBtReceiver();
                    } else if (intExtra == 12) {
                        Log.d(BluetoothLEUtils.TAG, "Bluetooth enable!");
                        BluetoothLEUtils.mOnIMBluetoothLEListener.onBtStateChanged(true);
                        BluetoothLEUtils.this.unregisterBtReceiver();
                    }
                } catch (Exception unused) {
                }
            }
        }
    };

    public abstract String onChanged(BluetoothGattCharacteristic bluetoothGattCharacteristic);

    public abstract String onRead(BluetoothGattCharacteristic bluetoothGattCharacteristic);

    public abstract void onWriteThreadStart(BluetoothLEHandler bluetoothLEHandler);

    public abstract void searchGattServices(int i, List<BluetoothGattService> list);

    public abstract boolean writeToBLE(String str, boolean z);

    public BluetoothLEUtils(Context context, boolean z) {
        this.context = context;
        CustomVariable.isPrintLog = z;
        if (context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
            BluetoothManager bluetoothManager = (BluetoothManager) this.context.getSystemService("bluetooth");
            if (bluetoothManager != null) {
                this.mBluetoothAdapter = bluetoothManager.getAdapter();
            }
            initCommArray();
        }
        this.mScanList = new ArrayList();
        this.mHandler = new BluetoothLEHandler(this, this.mBluetoothAdapter);
    }

    public Context getContext() {
        return this.context;
    }

    public boolean isBTEnabled() {
        BluetoothAdapter bluetoothAdapter = this.mBluetoothAdapter;
        if (bluetoothAdapter == null) {
            return false;
        }
        return bluetoothAdapter.isEnabled();
    }

    private void restartBT() {
        if (this.mBluetoothAdapter != null) {
            stopLEScan();
            if (isBTEnabled()) {
                this.mBluetoothAdapter.disable();
            } else {
                this.mBluetoothAdapter.enable();
            }
        }
    }

    public boolean isScanning() {
        return this.isScanning;
    }

    public boolean isEnabled() {
        BluetoothAdapter bluetoothAdapter = this.mBluetoothAdapter;
        if (bluetoothAdapter == null) {
            return false;
        }
        return bluetoothAdapter.isEnabled();
    }

    public boolean isConnected() {
        return this.mCurrentStatus == 17;
    }

    public boolean isSupportBluetooth(Activity activity) {
        if (!this.context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
            return false;
        }
        if (this.mBluetoothAdapter.isEnabled()) {
            return true;
        }
        registerBtReceiver();
        activity.startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 100);
        return true;
    }

    public void registerBtReceiver() {
        if (isRegisterBtReceiver) {
            return;
        }
        isRegisterBtReceiver = true;
        try {
            CustomVariable.printLog("d", TAG, "registerBtReceiver~~");
            this.context.registerReceiver(this.mReceiver, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
        } catch (Exception unused) {
        }
    }

    public void unregisterBtReceiver() {
        try {
            isRegisterBtReceiver = false;
            CustomVariable.printLog("d", TAG, "unregisterReceiver~~");
            this.context.unregisterReceiver(this.mReceiver);
        } catch (IllegalArgumentException unused) {
        }
    }

    public void startLEScan(int i, boolean z) {
        if (CustomVariable.isPrintLog) {
            Log.d(TAG, "Method  startScan");
        }
        BluetoothAdapter bluetoothAdapter = this.mBluetoothAdapter;
        if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled()) {
            if (CustomVariable.isPrintLog) {
                Log.e(TAG, "Method  未開啟藍牙或不支援BLE");
                return;
            }
            return;
        }
        if (this.isScanning) {
            if (CustomVariable.isPrintLog) {
                Log.d(TAG, "Method  已在掃描中,停止掃描...");
            }
            stopLEScan();
        }
        try {
            this.mScanList.clear();
            if (z) {
                this.mHandler.removeMessages(6);
                Message message = new Message();
                message.what = 6;
                message.arg1 = i;
                this.mHandler.sendMessageDelayed(message, i * 1000);
            } else {
                this.mHandler.removeMessages(4);
                this.mHandler.sendEmptyMessageDelayed(4, i * 1000);
            }
            BluetoothAdapter bluetoothAdapter2 = this.mBluetoothAdapter;
            if (bluetoothAdapter2 != null) {
                this.isScanning = true;
                bluetoothAdapter2.startLeScan(setLeScanCallback());
            }
        } catch (NoClassDefFoundError e) {
            e.printStackTrace();
        }
    }

    public void stopLEScan() {
        if (CustomVariable.isPrintLog) {
            Log.d(TAG, "Method  stopScan");
        }
        this.mHandler.removeMessages(4);
        this.isScanning = false;
        BluetoothAdapter bluetoothAdapter = this.mBluetoothAdapter;
        if (bluetoothAdapter != null) {
            bluetoothAdapter.stopLeScan(setLeScanCallback());
        }
    }

    public BluetoothAdapter.LeScanCallback setLeScanCallback() {
        if (this.mLeOldScanCallback == null) {
            this.mLeOldScanCallback = new BluetoothAdapter.LeScanCallback() { // from class: com.ideabus.bluetooth.BluetoothLEUtils.2
                @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
                public void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
                    if (!BluetoothLEUtils.this.isScanning) {
                        BluetoothLEUtils.this.stopLEScan();
                    } else {
                        if (bluetoothDevice == null || bluetoothDevice.getAddress() == null || bluetoothDevice.getAddress().length() <= 0) {
                            return;
                        }
                        BluetoothLEUtils.this.checkIsExist(bluetoothDevice, i, bArr);
                    }
                }
            };
        }
        return this.mLeOldScanCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void checkIsExist(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        Iterator<String> it = this.mScanList.iterator();
        while (it.hasNext()) {
            if (bluetoothDevice.getAddress().equals(it.next())) {
                return;
            }
        }
        this.mScanList.add(bluetoothDevice.getAddress());
        Message message = new Message();
        message.what = 3;
        String name = (bluetoothDevice.getName() == null || bluetoothDevice.getName().length() <= 0) ? "n/a" : bluetoothDevice.getName();
        Bundle bundle = new Bundle();
        bundle.putString("name", name);
        bundle.putString(IntegrityManager.INTEGRITY_TYPE_ADDRESS, bluetoothDevice.getAddress());
        bundle.putInt("rssi", i);
        bundle.putByteArray("scanRecord", bArr);
        message.setData(bundle);
        this.mHandler.sendMessage(message);
    }

    public void connect(List<String> list) {
        if (CustomVariable.isPrintLog) {
            Log.d(TAG, "Method:開始連線  MAC = " + list);
        }
        this.mHandler.removeMessages(4);
        if (isScanning()) {
            stopLEScan();
        }
        if (this.mBluetoothAdapter == null || list == null || list.size() == 0) {
            Log.e(TAG, "mBluetoothAdapter == null || 無效地址");
            this.mCurrentStatus = 19;
            this.mHandler.sendEmptyMessage(1);
        } else {
            this.mCurrentStatus = 16;
            initBluetoothGattsArray();
            initParams();
            this.charWriteList = new ArrayList();
            this.connGattCount = list.size();
            connectBLEs(list);
        }
    }

    private void connectBLEs(List<String> list) {
        ConnectionThread connectionThread = new ConnectionThread(this, this.mBluetoothAdapter, this.mHandler, list);
        this.mConnectionThread = connectionThread;
        connectionThread.start();
    }

    public boolean writeMessage(String str, boolean z) {
        return writeToBLE(str, z);
    }

    public void readRSSI() {
        if (getBluetoothGatt(0) != null) {
            boolean remoteRssi = getBluetoothGatt(0).readRemoteRssi();
            if (CustomVariable.isPrintLog) {
                Log.e(TAG, "成功讀取RSSI = " + remoteRssi);
            }
        }
    }

    protected void sendTest(String str) {
        if (getBluetoothGatt(0) != null) {
            this.charWriteList.get(0).setValue(CustomVariable.hexToBytes(str));
            boolean zWriteCharacteristic = getBluetoothGatt(0).writeCharacteristic(this.charWriteList.get(0));
            if (CustomVariable.isPrintLog) {
                Log.e(TAG, "成功寫出 = " + zWriteCharacteristic);
            }
        }
    }

    public BluetoothGattCallback setLeGattCallback() {
        if (this.mLeGattCallback == null) {
            this.mLeGattCallback = new BluetoothGattCallback() { // from class: com.ideabus.bluetooth.BluetoothLEUtils.3
                @Override // android.bluetooth.BluetoothGattCallback
                public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) throws InterruptedException {
                    if (i2 != 2) {
                        if (i2 == 0) {
                            Log.e(BluetoothLEUtils.TAG, "Device 斷線 from GATT server. status = " + i);
                            BluetoothLEUtils.this.disconnect(18);
                            return;
                        }
                        return;
                    }
                    if (CustomVariable.isPrintLog) {
                        Log.d(BluetoothLEUtils.TAG, "成功連線到 BLE GATT 設備.");
                    }
                    try {
                        Thread.sleep(600L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for (int i3 = 0; i3 < BluetoothLEUtils.this.connGattCount; i3++) {
                        if (bluetoothGatt.equals(BluetoothLEUtils.this.getBluetoothGatt(i3))) {
                            if (CustomVariable.isPrintLog) {
                                Log.d(BluetoothLEUtils.TAG, "正在搜尋 第" + i3 + " 顆藍牙 Service   NAME = " + BluetoothLEUtils.this.getBluetoothGatt(i3).getDevice().getName());
                            }
                            BluetoothLEUtils.this.getBluetoothGatt(i3).discoverServices();
                            return;
                        }
                    }
                }

                @Override // android.bluetooth.BluetoothGattCallback
                public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
                    if (i != 0) {
                        Log.e(BluetoothLEUtils.TAG, "斷線  onServicesDiscovered received: " + i);
                        BluetoothLEUtils.this.disconnect(18);
                        return;
                    }
                    if (CustomVariable.isPrintLog) {
                        Log.d(BluetoothLEUtils.TAG, "Method:onServicesDiscovered  搜尋藍牙 Service成功 statis = " + i);
                    }
                    for (int i2 = 0; i2 < BluetoothLEUtils.this.connGattCount; i2++) {
                        if (bluetoothGatt.equals(BluetoothLEUtils.this.getBluetoothGatt(i2))) {
                            if (CustomVariable.isPrintLog) {
                                Log.e(BluetoothLEUtils.TAG, "搜尋到 第" + i2 + " 顆藍牙 Service   NAME = " + BluetoothLEUtils.this.getBluetoothGatt(i2).getDevice().getName());
                            }
                            BluetoothLEUtils bluetoothLEUtils = BluetoothLEUtils.this;
                            bluetoothLEUtils.displayGattServices(i2, bluetoothLEUtils.getSupportedGattServices(i2));
                            return;
                        }
                    }
                }

                @Override // android.bluetooth.BluetoothGattCallback
                public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
                    if (CustomVariable.isPrintLog) {
                        Log.d(BluetoothLEUtils.TAG, "Method:成功發送至設備    getDevice.getName = " + bluetoothGatt.getDevice().getName() + " , status = " + i);
                    }
                }

                @Override // android.bluetooth.BluetoothGattCallback
                public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
                    if (CustomVariable.isPrintLog) {
                        Log.d(BluetoothLEUtils.TAG, "Method:成功讀取設備訊息   getDevice.getName = " + bluetoothGatt.getDevice().getName() + " , status = " + i);
                    }
                    Message message = new Message();
                    message.what = 2;
                    message.obj = BluetoothLEUtils.this.onRead(bluetoothGattCharacteristic);
                    BluetoothLEUtils.this.mHandler.sendMessage(message);
                }

                @Override // android.bluetooth.BluetoothGattCallback
                public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
                    String strTrim = bluetoothGatt.getDevice().getName().trim();
                    if (CustomVariable.isPrintLog) {
                        Log.e(BluetoothLEUtils.TAG, "接收資料 deviceName = " + strTrim);
                    }
                    Message message = new Message();
                    message.what = 2;
                    message.obj = String.valueOf(strTrim) + "==" + BluetoothLEUtils.this.onChanged(bluetoothGattCharacteristic);
                    BluetoothLEUtils.this.mHandler.sendMessage(message);
                }
            };
        }
        return this.mLeGattCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<BluetoothGattService> getSupportedGattServices(int i) {
        if (getBluetoothGatt(i) != null) {
            return getBluetoothGatt(i).getServices();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void displayGattServices(int i, List<BluetoothGattService> list) {
        searchGattServices(i, list);
        if (this.charWriteList.size() == this.connGattCount && this.charNotifyCount == this.connGattCount) {
            if (i != 0 && i == this.connGattCount - 1) {
                connectSuccess();
            } else if (i == 0 && i + 1 == this.connGattCount) {
                connectSuccess();
            }
        }
        ConnectionThread connectionThread = this.mConnectionThread;
        if (connectionThread == null) {
            return;
        }
        synchronized (connectionThread) {
            this.mConnectionThread.notify();
        }
    }

    private void connectSuccess() {
        Log.e(TAG, "connectSuccess CONNECTED------");
        this.mCurrentStatus = 17;
        this.mHandler.sendEmptyMessage(1);
        ConnectionThread connectionThread = this.mConnectionThread;
        if (connectionThread != null && !connectionThread.isInterrupted()) {
            this.mConnectionThread.interrupt();
            this.mConnectionThread = null;
        }
        this.charNotifyCount = 0;
    }

    private void initParams() {
        ConnectionThread connectionThread = this.mConnectionThread;
        if (connectionThread != null && !connectionThread.isInterrupted()) {
            this.mConnectionThread.interrupt();
            this.mConnectionThread = null;
        }
        this.mHandler.removeMessages(4);
        this.mHandler.removeMessages(20);
        this.charNotifyCount = 0;
        this.isWriteRunning = false;
        removeAllComm();
    }

    public synchronized void disconnect(int i) {
        if (CustomVariable.isPrintLog) {
            Log.d(TAG, "Method:disconnect code : " + i);
        }
        stopLEScan();
        initParams();
        this.mCurrentStatus = i;
        unregisterBtReceiver();
        if (getBluetoothGatts() != null && getBluetoothGatts().size() > 0) {
            for (int i2 = 0; i2 < getBluetoothGatts().size(); i2++) {
                try {
                    if (getBluetoothGatt(i2) != null) {
                        getBluetoothGatt(i2).disconnect();
                        getBluetoothGatt(i2).close();
                        if (CustomVariable.isPrintLog) {
                            Log.e(TAG, "disconnect : " + i2);
                        }
                    }
                    this.mHandler.sendEmptyMessage(1);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
        initBluetoothGattsArray();
    }

    public boolean refreshDeviceCache(BluetoothGatt bluetoothGatt) throws NoSuchMethodException, SecurityException {
        try {
            Method method = bluetoothGatt.getClass().getMethod("refresh", new Class[0]);
            if (method != null) {
                return ((Boolean) method.invoke(bluetoothGatt, new Object[0])).booleanValue();
            }
        } catch (Exception unused) {
            Log.e(TAG, "An exception occured while refreshing device");
        }
        return false;
    }
}
