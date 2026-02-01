package com.ua.sdk.recorder.datasource.sensor.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import com.ua.sdk.UaLog;
import com.ua.sdk.recorder.RecorderContext;
import com.ua.sdk.recorder.SensorStatus;
import com.ua.sdk.recorder.datasource.sensor.bluetooth.BaseGattCallback;
import com.ua.sdk.recorder.datasource.sensor.bluetooth.BluetoothClient;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes2.dex */
public class BluetoothConnection implements BluetoothClient {
    private static final int SCAN_RETRY_COUNT_MAX = 3;
    private BaseGattCallback baseGattCallback;
    private BluetoothAdapter bluetoothAdapter;
    private BluetoothGatt bluetoothGatt;
    private BluetoothManager bluetoothManager;
    private Context context;
    private String deviceAddress;
    protected BluetoothClient.BluetoothClientListener listener;
    private MyBluetoothStateReceiver myBluetoothStateReceiver;
    private MyLeScanCallbacks myLeScanCallbacks;
    private Timer timer;
    private MyStopScanRunnable myStopScanRunnable = new MyStopScanRunnable();
    private int retryCount = 0;
    private Handler handler = new Handler();

    @Override // com.ua.sdk.recorder.datasource.sensor.bluetooth.BluetoothClient
    public void stopSegment() {
    }

    static /* synthetic */ int access$308(BluetoothConnection bluetoothConnection) {
        int i = bluetoothConnection.retryCount;
        bluetoothConnection.retryCount = i + 1;
        return i;
    }

    public BluetoothConnection(BaseGattCallback baseGattCallback) {
        this.myLeScanCallbacks = new MyLeScanCallbacks();
        this.myBluetoothStateReceiver = new MyBluetoothStateReceiver();
        this.baseGattCallback = baseGattCallback;
    }

    @Override // com.ua.sdk.recorder.datasource.sensor.bluetooth.BluetoothClient
    public void connect(BluetoothClient.BluetoothClientListener bluetoothClientListener, String str, Context context) {
        this.listener = bluetoothClientListener;
        this.deviceAddress = str;
        this.context = context;
        this.timer = new Timer("BluetoothClientTimer");
        this.baseGattCallback.setClientListener(bluetoothClientListener);
        context.registerReceiver(this.myBluetoothStateReceiver, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
        attemptConnect();
    }

    @Override // com.ua.sdk.recorder.datasource.sensor.bluetooth.BluetoothClient
    public void configure(RecorderContext recorderContext) {
        if (this.bluetoothManager == null) {
            this.bluetoothManager = (BluetoothManager) recorderContext.getApplicationContext().getSystemService("bluetooth");
        }
        this.baseGattCallback.configure(recorderContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void attemptConnect() {
        BluetoothClient.BluetoothClientListener bluetoothClientListener = this.listener;
        if (bluetoothClientListener != null) {
            bluetoothClientListener.onConnectionStatusChanged(SensorStatus.CONNECTING);
        }
        if (initializeAdapter()) {
            startScan();
        }
    }

    @Override // com.ua.sdk.recorder.datasource.sensor.bluetooth.BluetoothClient
    public void disconnect() {
        UaLog.debug("Client has disconnected from device");
        this.baseGattCallback.disconnect();
        if (this.timer != null) {
            this.handler.removeCallbacks(this.myStopScanRunnable);
            stopScan();
            this.timer.cancel();
        }
        this.context.unregisterReceiver(this.myBluetoothStateReceiver);
        BluetoothGatt bluetoothGatt = this.bluetoothGatt;
        if (bluetoothGatt != null) {
            bluetoothGatt.disconnect();
            this.bluetoothGatt.close();
            this.bluetoothGatt = null;
        }
        BluetoothClient.BluetoothClientListener bluetoothClientListener = this.listener;
        if (bluetoothClientListener != null) {
            bluetoothClientListener.onConnectionStatusChanged(SensorStatus.DISCONNECTED);
        }
    }

    @Override // com.ua.sdk.recorder.datasource.sensor.bluetooth.BluetoothClient
    public void startSegment() {
        this.baseGattCallback.startSegment();
    }

    private boolean initializeAdapter() {
        BluetoothAdapter adapter = this.bluetoothManager.getAdapter();
        this.bluetoothAdapter = adapter;
        if (adapter != null) {
            return true;
        }
        UaLog.error("Unable to get the bluetooth adapter.");
        this.listener.onConnectionStatusChanged(SensorStatus.DISCONNECTED);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startScan() {
        BluetoothAdapter bluetoothAdapter = this.bluetoothAdapter;
        if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled()) {
            return;
        }
        this.bluetoothAdapter.startLeScan(this.myLeScanCallbacks);
        this.handler.postDelayed(this.myStopScanRunnable, 10000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopScan() {
        BluetoothAdapter bluetoothAdapter = this.bluetoothAdapter;
        if (bluetoothAdapter != null) {
            bluetoothAdapter.stopLeScan(this.myLeScanCallbacks);
        }
    }

    private class MyLeScanCallbacks implements BluetoothAdapter.LeScanCallback {
        private MyLeScanCallbacks() {
        }

        @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
        public void onLeScan(final BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
            if (bluetoothDevice.getAddress().equals(BluetoothConnection.this.deviceAddress)) {
                UaLog.debug("Device found! Connecting to server the server now");
                BluetoothConnection.this.retryCount = 0;
                BluetoothConnection.this.handler.removeCallbacks(BluetoothConnection.this.myStopScanRunnable);
                BluetoothConnection.this.stopScan();
                if (BluetoothConnection.this.bluetoothGatt != null) {
                    BluetoothConnection.this.bluetoothGatt.disconnect();
                    BluetoothConnection.this.bluetoothGatt.close();
                    BluetoothConnection.this.bluetoothGatt = null;
                }
                BluetoothConnection.this.baseGattCallback.setConnectionLostListener(new MyConnectionLostListener());
                new Thread(new Runnable() { // from class: com.ua.sdk.recorder.datasource.sensor.bluetooth.BluetoothConnection.MyLeScanCallbacks.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BluetoothConnection.this.bluetoothGatt = bluetoothDevice.connectGatt(BluetoothConnection.this.context, false, BluetoothConnection.this.baseGattCallback);
                    }
                }).start();
            }
        }
    }

    protected class MyStopScanRunnable extends TimerTask {
        protected MyStopScanRunnable() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            BluetoothConnection.this.stopScan();
            UaLog.error("Unable to find device with address " + BluetoothConnection.this.deviceAddress);
            BluetoothConnection.access$308(BluetoothConnection.this);
            if (BluetoothConnection.this.retryCount > 3) {
                BluetoothConnection.this.retryCount = 0;
                UaLog.debug("we will attempt to reconnect in 60 seconds");
                BluetoothConnection.this.timer.schedule(BluetoothConnection.this.new MyReconnectTask(), 60000L);
            } else {
                UaLog.error("retry scan number " + BluetoothConnection.this.retryCount);
                BluetoothConnection.this.startScan();
            }
        }
    }

    protected class MyReconnectTask extends TimerTask {
        protected MyReconnectTask() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            BluetoothConnection.this.stopScan();
            BluetoothConnection.this.attemptConnect();
        }
    }

    private class MyConnectionLostListener implements BaseGattCallback.ConnectionLostListener {
        private MyConnectionLostListener() {
        }

        @Override // com.ua.sdk.recorder.datasource.sensor.bluetooth.BaseGattCallback.ConnectionLostListener
        public void onScheduleReconnect(long j) {
            BluetoothConnection.this.timer.schedule(BluetoothConnection.this.new MyReconnectTask(), j);
        }
    }

    private class MyBluetoothStateReceiver extends BroadcastReceiver {
        private MyBluetoothStateReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.bluetooth.adapter.action.STATE_CHANGED") && intent.getExtras().getInt("android.bluetooth.adapter.extra.STATE") == 12) {
                BluetoothConnection.this.startScan();
            }
        }
    }
}
