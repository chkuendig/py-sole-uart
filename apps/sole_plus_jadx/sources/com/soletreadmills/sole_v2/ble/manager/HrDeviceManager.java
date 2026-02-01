package com.soletreadmills.sole_v2.ble.manager;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.google.gson.Gson;
import com.soletreadmills.sole_v2.ble.BleUuid;
import com.soletreadmills.sole_v2.ble.data.HrData;
import com.soletreadmills.sole_v2.ble.parsing.HrParsing;
import com.soletreadmills.sole_v2.ble.type.BleHrActionType;
import no.nordicsemi.android.ble.BleManager;
import no.nordicsemi.android.ble.callback.DataReceivedCallback;
import no.nordicsemi.android.ble.data.Data;
import no.nordicsemi.android.ble.observer.ConnectionObserver;

/* loaded from: classes5.dex */
public class HrDeviceManager extends BleManager {
    private final String TAG;
    private BleManager.BleManagerGattCallback bleManagerGattCallback;
    private String bluetoothDeviceName;
    private final ConnectionObserver connectionObserver;
    private Handler dataReceivedCallbackHandler;
    private HandlerThread dataReceivedCallbackHandlerThread;
    private int disconnectedReason;
    private BluetoothGattCharacteristic heartRateMeasurementCharacteristic;
    private final DataReceivedCallback heartRateMeasurementDataReceivedCallback;

    public HrDeviceManager(Context context) {
        super(context);
        this.TAG = "HrDeviceManager";
        this.bleManagerGattCallback = null;
        this.bluetoothDeviceName = null;
        this.disconnectedReason = -1;
        this.heartRateMeasurementCharacteristic = null;
        this.dataReceivedCallbackHandlerThread = null;
        this.dataReceivedCallbackHandler = null;
        ConnectionObserver connectionObserver = new ConnectionObserver() { // from class: com.soletreadmills.sole_v2.ble.manager.HrDeviceManager.1
            @Override // no.nordicsemi.android.ble.observer.ConnectionObserver
            public void onDeviceDisconnecting(BluetoothDevice device) {
            }

            @Override // no.nordicsemi.android.ble.observer.ConnectionObserver
            public void onDeviceReady(BluetoothDevice device) {
            }

            @Override // no.nordicsemi.android.ble.observer.ConnectionObserver
            public void onDeviceConnecting(BluetoothDevice device) {
                Log.d(HrDeviceManager.this.TAG, "connectionObserver -> onDeviceConnecting");
                HrDeviceManager.this.broadcastUpdate(BleHrActionType.HR_ACTION_GATT_CONNECTING, device.getAddress());
            }

            @Override // no.nordicsemi.android.ble.observer.ConnectionObserver
            public void onDeviceConnected(BluetoothDevice device) {
                Log.d(HrDeviceManager.this.TAG, "connectionObserver -> onDeviceConnected");
                HrDeviceManager.this.startDataReceivedCallbackHandlerThread();
                HrDeviceManager.this.disconnectedReason = -1;
                HrDeviceManager.this.broadcastUpdate(BleHrActionType.HR_ACTION_GATT_CONNECTED, device.getAddress());
            }

            @Override // no.nordicsemi.android.ble.observer.ConnectionObserver
            public void onDeviceFailedToConnect(BluetoothDevice device, int reason) {
                Log.d(HrDeviceManager.this.TAG, "connectionObserver -> onDeviceFailedToConnect");
                HrDeviceManager.this.onDeviceDisconnected(device);
            }

            @Override // no.nordicsemi.android.ble.observer.ConnectionObserver
            public void onDeviceDisconnected(BluetoothDevice device, int reason) {
                synchronized (HrDeviceManager.this) {
                    HrDeviceManager.this.disconnectedReason = reason;
                    Log.d(HrDeviceManager.this.TAG, "disconnectedReason=" + HrDeviceManager.this.disconnectedReason);
                    HrDeviceManager.this.onDeviceDisconnected(device);
                    BleDataManager.getInstance().clearHrData();
                }
            }
        };
        this.connectionObserver = connectionObserver;
        this.heartRateMeasurementDataReceivedCallback = new DataReceivedCallback() { // from class: com.soletreadmills.sole_v2.ble.manager.HrDeviceManager.3
            @Override // no.nordicsemi.android.ble.callback.DataReceivedCallback
            public void onDataReceived(final BluetoothDevice device, final Data data) {
                if (HrDeviceManager.this.dataReceivedCallbackHandler != null) {
                    HrDeviceManager.this.dataReceivedCallbackHandler.post(new Runnable() { // from class: com.soletreadmills.sole_v2.ble.manager.HrDeviceManager.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            HrData hrDataParsingData = HrParsing.parsingData(HrDeviceManager.this.getContext(), device, data, HrDeviceManager.this.heartRateMeasurementCharacteristic);
                            if (hrDataParsingData != null) {
                                BleDataManager.getInstance().addHrData(hrDataParsingData);
                                HrDeviceManager.this.broadcastUpdateExtraDataHr(new Gson().toJson(hrDataParsingData));
                            }
                        }
                    });
                }
            }
        };
        setConnectionObserver(connectionObserver);
    }

    public HrDeviceManager(Context context, Handler handler) {
        super(context, handler);
        this.TAG = "HrDeviceManager";
        this.bleManagerGattCallback = null;
        this.bluetoothDeviceName = null;
        this.disconnectedReason = -1;
        this.heartRateMeasurementCharacteristic = null;
        this.dataReceivedCallbackHandlerThread = null;
        this.dataReceivedCallbackHandler = null;
        ConnectionObserver connectionObserver = new ConnectionObserver() { // from class: com.soletreadmills.sole_v2.ble.manager.HrDeviceManager.1
            @Override // no.nordicsemi.android.ble.observer.ConnectionObserver
            public void onDeviceDisconnecting(BluetoothDevice device) {
            }

            @Override // no.nordicsemi.android.ble.observer.ConnectionObserver
            public void onDeviceReady(BluetoothDevice device) {
            }

            @Override // no.nordicsemi.android.ble.observer.ConnectionObserver
            public void onDeviceConnecting(BluetoothDevice device) {
                Log.d(HrDeviceManager.this.TAG, "connectionObserver -> onDeviceConnecting");
                HrDeviceManager.this.broadcastUpdate(BleHrActionType.HR_ACTION_GATT_CONNECTING, device.getAddress());
            }

            @Override // no.nordicsemi.android.ble.observer.ConnectionObserver
            public void onDeviceConnected(BluetoothDevice device) {
                Log.d(HrDeviceManager.this.TAG, "connectionObserver -> onDeviceConnected");
                HrDeviceManager.this.startDataReceivedCallbackHandlerThread();
                HrDeviceManager.this.disconnectedReason = -1;
                HrDeviceManager.this.broadcastUpdate(BleHrActionType.HR_ACTION_GATT_CONNECTED, device.getAddress());
            }

            @Override // no.nordicsemi.android.ble.observer.ConnectionObserver
            public void onDeviceFailedToConnect(BluetoothDevice device, int reason) {
                Log.d(HrDeviceManager.this.TAG, "connectionObserver -> onDeviceFailedToConnect");
                HrDeviceManager.this.onDeviceDisconnected(device);
            }

            @Override // no.nordicsemi.android.ble.observer.ConnectionObserver
            public void onDeviceDisconnected(BluetoothDevice device, int reason) {
                synchronized (HrDeviceManager.this) {
                    HrDeviceManager.this.disconnectedReason = reason;
                    Log.d(HrDeviceManager.this.TAG, "disconnectedReason=" + HrDeviceManager.this.disconnectedReason);
                    HrDeviceManager.this.onDeviceDisconnected(device);
                    BleDataManager.getInstance().clearHrData();
                }
            }
        };
        this.connectionObserver = connectionObserver;
        this.heartRateMeasurementDataReceivedCallback = new DataReceivedCallback() { // from class: com.soletreadmills.sole_v2.ble.manager.HrDeviceManager.3
            @Override // no.nordicsemi.android.ble.callback.DataReceivedCallback
            public void onDataReceived(final BluetoothDevice device, final Data data) {
                if (HrDeviceManager.this.dataReceivedCallbackHandler != null) {
                    HrDeviceManager.this.dataReceivedCallbackHandler.post(new Runnable() { // from class: com.soletreadmills.sole_v2.ble.manager.HrDeviceManager.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            HrData hrDataParsingData = HrParsing.parsingData(HrDeviceManager.this.getContext(), device, data, HrDeviceManager.this.heartRateMeasurementCharacteristic);
                            if (hrDataParsingData != null) {
                                BleDataManager.getInstance().addHrData(hrDataParsingData);
                                HrDeviceManager.this.broadcastUpdateExtraDataHr(new Gson().toJson(hrDataParsingData));
                            }
                        }
                    });
                }
            }
        };
        setConnectionObserver(connectionObserver);
    }

    @Override // no.nordicsemi.android.ble.BleManager
    protected BleManager.BleManagerGattCallback getGattCallback() {
        BleManager.BleManagerGattCallback bleManagerGattCallback;
        synchronized (this) {
            if (this.bleManagerGattCallback == null) {
                this.bleManagerGattCallback = new BleManager.BleManagerGattCallback() { // from class: com.soletreadmills.sole_v2.ble.manager.HrDeviceManager.2
                    @Override // no.nordicsemi.android.ble.BleManagerHandler
                    protected void onServicesInvalidated() {
                    }

                    @Override // no.nordicsemi.android.ble.BleManagerHandler
                    protected void initialize() {
                        synchronized (HrDeviceManager.this) {
                            if (HrDeviceManager.this.heartRateMeasurementCharacteristic != null) {
                                HrDeviceManager hrDeviceManager = HrDeviceManager.this;
                                hrDeviceManager.setNotificationCallback(hrDeviceManager.heartRateMeasurementCharacteristic).with(HrDeviceManager.this.heartRateMeasurementDataReceivedCallback);
                                HrDeviceManager hrDeviceManager2 = HrDeviceManager.this;
                                hrDeviceManager2.readCharacteristic(hrDeviceManager2.heartRateMeasurementCharacteristic).with(HrDeviceManager.this.heartRateMeasurementDataReceivedCallback).enqueue();
                                HrDeviceManager hrDeviceManager3 = HrDeviceManager.this;
                                hrDeviceManager3.enableNotifications(hrDeviceManager3.heartRateMeasurementCharacteristic).enqueue();
                            }
                        }
                    }

                    @Override // no.nordicsemi.android.ble.BleManagerHandler
                    protected boolean isRequiredServiceSupported(BluetoothGatt gatt) {
                        boolean z;
                        synchronized (HrDeviceManager.this) {
                            HrDeviceManager.this.broadcastUpdate(BleHrActionType.HR_ACTION_GATT_SERVICES_DISCOVERED);
                            BluetoothGattService service = gatt.getService(BleUuid.UUID_HEART_RATE);
                            if (service != null) {
                                HrDeviceManager.this.heartRateMeasurementCharacteristic = service.getCharacteristic(BleUuid.UUID_HEART_RATE_MEASUREMENT);
                            }
                            z = HrDeviceManager.this.heartRateMeasurementCharacteristic != null;
                        }
                        return z;
                    }

                    @Override // no.nordicsemi.android.ble.BleManagerHandler
                    protected void onDeviceDisconnected() {
                        synchronized (HrDeviceManager.this) {
                        }
                    }
                };
            }
            bleManagerGattCallback = this.bleManagerGattCallback;
        }
        return bleManagerGattCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDeviceDisconnected(final BluetoothDevice device) {
        this.heartRateMeasurementCharacteristic = null;
        setBluetoothDeviceName(null);
        stopDataReceivedCallbackHandlerThread();
        broadcastUpdate(BleHrActionType.HR_ACTION_GATT_DISCONNECTED, device.getAddress());
    }

    @Override // no.nordicsemi.android.ble.BleManager, no.nordicsemi.android.ble.utils.ILogger
    public void log(final int priority, final String message) {
        Log.println(priority, this.TAG, message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void startDataReceivedCallbackHandlerThread() {
        stopDataReceivedCallbackHandlerThread();
        HandlerThread handlerThread = new HandlerThread(this.TAG + " DataReceivedCallbackHandlerThread", 0);
        this.dataReceivedCallbackHandlerThread = handlerThread;
        handlerThread.start();
        this.dataReceivedCallbackHandler = new Handler(this.dataReceivedCallbackHandlerThread.getLooper());
    }

    private synchronized void stopDataReceivedCallbackHandlerThread() {
        Handler handler = this.dataReceivedCallbackHandler;
        this.dataReceivedCallbackHandler = null;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        HandlerThread handlerThread = this.dataReceivedCallbackHandlerThread;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        this.dataReceivedCallbackHandlerThread = null;
    }

    public synchronized int getDisconnectedReason() {
        int i;
        synchronized (this) {
            i = this.disconnectedReason;
        }
        return i;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void broadcastUpdate(final BleHrActionType actionType) {
        getContext().sendBroadcast(new Intent(actionType.name()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void broadcastUpdate(final BleHrActionType actionType, final String bleMacAddress) {
        Intent intent = new Intent(actionType.name());
        intent.putExtra(BleHrActionType.HR_EXTRA_GATT_ADDRESS.name(), bleMacAddress);
        getContext().sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void broadcastUpdateExtraDataHr(final String hrDataJsonStr) {
        Intent intent = new Intent(BleHrActionType.HR_ACTION_DATA_AVAILABLE.name());
        intent.putExtra(BleHrActionType.HR_EXTRA_DATA.name(), hrDataJsonStr);
        getContext().sendBroadcast(intent);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0023 A[Catch: all -> 0x002d, PHI: r1
      0x0023: PHI (r1v3 java.lang.String) = (r1v0 java.lang.String), (r1v0 java.lang.String), (r1v2 java.lang.String), (r1v0 java.lang.String) binds: [B:5:0x0006, B:13:0x0020, B:10:0x001a, B:9:0x0018] A[DONT_GENERATE, DONT_INLINE], TryCatch #1 {, blocks: (B:3:0x0001, B:6:0x0008, B:8:0x000e, B:10:0x001a, B:14:0x0023, B:16:0x0029, B:17:0x002b, B:13:0x0020), top: B:24:0x0001, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0029 A[Catch: all -> 0x002d, TryCatch #1 {, blocks: (B:3:0x0001, B:6:0x0008, B:8:0x000e, B:10:0x001a, B:14:0x0023, B:16:0x0029, B:17:0x002b, B:13:0x0020), top: B:24:0x0001, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String getBluetoothDeviceName() {
        /*
            r4 = this;
            monitor-enter(r4)
            android.bluetooth.BluetoothDevice r0 = r4.getBluetoothDevice()     // Catch: java.lang.Throwable -> L2d
            r1 = 0
            if (r0 == 0) goto L23
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L1f java.lang.Throwable -> L2d
            r3 = 31
            if (r2 < r3) goto L1a
            android.content.Context r2 = r4.getContext()     // Catch: java.lang.Exception -> L1f java.lang.Throwable -> L2d
            java.lang.String r3 = "android.permission.BLUETOOTH_CONNECT"
            int r2 = androidx.core.app.ActivityCompat.checkSelfPermission(r2, r3)     // Catch: java.lang.Exception -> L1f java.lang.Throwable -> L2d
            if (r2 != 0) goto L23
        L1a:
            java.lang.String r1 = r0.getName()     // Catch: java.lang.Exception -> L1f java.lang.Throwable -> L2d
            goto L23
        L1f:
            r0 = move-exception
            timber.log.Timber.e(r0)     // Catch: java.lang.Throwable -> L2d
        L23:
            boolean r0 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L2d
            if (r0 == 0) goto L2b
            java.lang.String r1 = r4.bluetoothDeviceName     // Catch: java.lang.Throwable -> L2d
        L2b:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L2d
            return r1
        L2d:
            r0 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L2d
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ble.manager.HrDeviceManager.getBluetoothDeviceName():java.lang.String");
    }

    public void setBluetoothDeviceName(String bluetoothDeviceName) {
        synchronized (this) {
            this.bluetoothDeviceName = bluetoothDeviceName;
        }
    }
}
