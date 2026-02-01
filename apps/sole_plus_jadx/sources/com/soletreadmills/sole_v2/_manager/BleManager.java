package com.soletreadmills.sole_v2._manager;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.camera.video.AudioStats;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.google.gson.Gson;
import com.soletreadmills.sole_v2.Global;
import com.soletreadmills.sole_v2.MyApplication;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.ble.BleDeviceInfoData;
import com.soletreadmills.sole_v2._roomDataBase.bleDevice.BleDeviceInfoDatabase;
import com.soletreadmills.sole_v2._roomDataBase.bleDevice.BleDeviceInfoEntity;
import com.soletreadmills.sole_v2._roomDataBase.summaryTempData.SummaryTempDataDatabase;
import com.soletreadmills.sole_v2._roomDataBase.summaryTempData.SummaryTempDataEntity;
import com.soletreadmills.sole_v2._sharedPreferences.MySharedPreferences;
import com.soletreadmills.sole_v2._type.BleDeviceListType;
import com.soletreadmills.sole_v2._type.BluetoothConnectType;
import com.soletreadmills.sole_v2._type.MachineType;
import com.soletreadmills.sole_v2.ble.BleService;
import com.soletreadmills.sole_v2.ble.cmd.FitnessMachineControlPointCmd;
import com.soletreadmills.sole_v2.ble.data.CrossTrainerData;
import com.soletreadmills.sole_v2.ble.data.CrossTrainerListData;
import com.soletreadmills.sole_v2.ble.data.FitnessMachineControlPointResponseData;
import com.soletreadmills.sole_v2.ble.data.FtmsBaseData;
import com.soletreadmills.sole_v2.ble.data.IndoorBikeData;
import com.soletreadmills.sole_v2.ble.data.IndoorBikeListData;
import com.soletreadmills.sole_v2.ble.data.RowerData;
import com.soletreadmills.sole_v2.ble.data.RowerListData;
import com.soletreadmills.sole_v2.ble.data.StepClimberData;
import com.soletreadmills.sole_v2.ble.data.StepClimberListData;
import com.soletreadmills.sole_v2.ble.data.TreadmillData;
import com.soletreadmills.sole_v2.ble.data.TreadmillListData;
import com.soletreadmills.sole_v2.ble.listener.UploadSummaryDataListener;
import com.soletreadmills.sole_v2.ble.manager.BleDataManager;
import com.soletreadmills.sole_v2.ble.manager.FtmsDeviceManager;
import com.soletreadmills.sole_v2.ble.manager.HrDeviceManager;
import com.soletreadmills.sole_v2.ble.type.BleFtmsActionType;
import com.soletreadmills.sole_v2.ble.type.BleFtmsMachineType;
import com.soletreadmills.sole_v2.ble.type.BleHrActionType;
import com.soletreadmills.sole_v2.ble.type.FitnessMachineStatusType;
import com.soletreadmills.sole_v2.ble.type.TrainingStatusType;
import com.soletreadmills.sole_v2.listener.BluetoothCallbackListener;
import com.soletreadmills.sole_v2.listener.EnabledBluetoothListener;
import com.soletreadmills.sole_v2.ui.MainActivity;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import no.nordicsemi.android.ble.callback.FailCallback;
import no.nordicsemi.android.ble.callback.InvalidRequestCallback;
import no.nordicsemi.android.ble.callback.SuccessCallback;
import no.nordicsemi.android.ble.data.Data;
import timber.log.Timber;

/* loaded from: classes5.dex */
public class BleManager {
    private static BleManager manager;
    private BleService bleService;
    private Handler handlerBackground;
    private HandlerThread handlerThread;
    private MyApplication myApplication;
    private final String TAG = "BleManager";
    public boolean isServiceConnection = false;
    final ArrayList<BleDeviceInfoData> bleDeviceInfoDataList = new ArrayList<>();
    private boolean isUserConnectHr = false;
    private final int retryFtmsConnect = 2;
    private final int retryHrConnect = 2;
    private int retryFtmsConnectCount = 0;
    private int retryHrConnectCount = 0;
    private BleDeviceInfoData connectFtmsBleDeviceInfoData = null;
    private BleDeviceInfoData connectHrBleDeviceInfoData = null;
    private boolean isScanning = false;
    private boolean isScanningForAutoReconnect = false;
    private BleDeviceInfoData autoReconnectFtmsBleDeviceInfoData = null;
    private BleDeviceInfoData autoReconnectHrBleDeviceInfoData = null;
    private Thread enabledBluetoothThread = null;
    private boolean isRegisterGattUpdateReceiver = false;
    private boolean isRegisterBluetoothBondStateChangedBroadcastReceiver = false;
    private final ArrayList<BluetoothCallbackListener> bluetoothCallbackListenerArrayList = new ArrayList<>();
    private BleDeviceInfoDatabase bleDeviceInfoDatabase = null;
    private SummaryTempDataDatabase summaryTempDataDatabase = null;
    private boolean isShowAppCalculationMessage = false;
    private LocalDateTime bleStartScanLocalDateTime = null;
    private LocalDateTime bleStartScanLocalDateTimeWithView = null;
    BluetoothConnectType bluetoothConnectType = null;
    private final ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.soletreadmills.sole_v2._manager.BleManager.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder service) {
            Timber.d("serviceConnection -> onServiceConnected componentName=" + componentName.toString(), new Object[0]);
            BleManager.this.bleService = ((BleService.LocalBinder) service).getService();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Timber.d("serviceConnection -> onServiceDisconnected componentName=" + componentName.toString(), new Object[0]);
            BleManager.this.bleService = null;
        }
    };
    private final Runnable scanBleDeviceTimeOutRunnable = new Runnable() { // from class: com.soletreadmills.sole_v2._manager.BleManager.7
        @Override // java.lang.Runnable
        public void run() {
            Handler handler = BleManager.this.handlerBackground;
            if (handler != null) {
                handler.removeCallbacks(this);
            }
            BleManager.this.stopScanBleDevice();
        }
    };
    private final Runnable waitToStartScanBleDeviceRunnable = new Runnable() { // from class: com.soletreadmills.sole_v2._manager.BleManager.8
        @Override // java.lang.Runnable
        public void run() {
            Timber.d("startScanBleDevice bleStartScanLocalDateTime diffSec < 10 Runnable Start", new Object[0]);
            final MainActivity mainActivity = BleManager.this.getMyApplication().getMainActivity();
            if (mainActivity == null || mainActivity.isFinishing() || mainActivity.isDestroyed()) {
                Timber.d("startScanBleDevice bleStartScanLocalDateTime diffSec < 10 Runnable End 01", new Object[0]);
            } else {
                mainActivity.runOnUiThread(new Runnable() { // from class: com.soletreadmills.sole_v2._manager.BleManager.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (mainActivity.isFinishing() || mainActivity.isDestroyed()) {
                            Timber.d("startScanBleDevice bleStartScanLocalDateTime diffSec < 10 Runnable End 02", new Object[0]);
                        }
                    }
                });
            }
        }
    };
    private final ScanCallback scanCallback = new ScanCallback() { // from class: com.soletreadmills.sole_v2._manager.BleManager.11
        /* JADX WARN: Removed duplicated region for block: B:22:0x0051  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x00f6 A[Catch: Exception -> 0x0225, TryCatch #1 {Exception -> 0x0225, blocks: (B:5:0x0008, B:8:0x0026, B:11:0x002d, B:23:0x0052, B:26:0x005a, B:30:0x0062, B:34:0x006b, B:36:0x007d, B:37:0x0088, B:39:0x008e, B:41:0x0096, B:43:0x009c, B:45:0x00a8, B:46:0x00ae, B:48:0x00ba, B:51:0x00c5, B:53:0x00c8, B:55:0x00cc, B:57:0x00d4, B:70:0x00ed, B:71:0x00f0, B:72:0x00f3, B:73:0x00f6, B:74:0x00f9, B:80:0x0103, B:82:0x0109, B:93:0x0124, B:100:0x016e, B:102:0x0174, B:147:0x020b, B:149:0x0213, B:106:0x0183, B:108:0x0189, B:112:0x0198, B:114:0x019e, B:116:0x01aa, B:119:0x01af, B:121:0x01b5, B:123:0x01c1, B:126:0x01c6, B:128:0x01cc, B:130:0x01d8, B:133:0x01dd, B:135:0x01e3, B:137:0x01ef, B:140:0x01f4, B:142:0x01fa, B:144:0x0206, B:83:0x010c, B:85:0x0112, B:86:0x0115, B:88:0x011b, B:21:0x004e, B:14:0x0034, B:16:0x003a, B:18:0x0048), top: B:157:0x0008, inners: #0 }] */
        /* JADX WARN: Removed duplicated region for block: B:89:0x011e  */
        @Override // android.bluetooth.le.ScanCallback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onScanResult(int r14, final android.bluetooth.le.ScanResult r15) {
            /*
                Method dump skipped, instructions count: 554
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2._manager.BleManager.AnonymousClass11.onScanResult(int, android.bluetooth.le.ScanResult):void");
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanFailed(int errorCode) {
            super.onScanFailed(errorCode);
            Timber.e("scanCallback -> onScanFailed errorCode=%s", Integer.valueOf(errorCode));
            BleManager.this.stopScanBleDevice();
            final MainActivity mainActivity = BleManager.this.getMyApplication().getMainActivity();
            if (mainActivity != null) {
                mainActivity.runOnUiThread(new Runnable() { // from class: com.soletreadmills.sole_v2._manager.BleManager.11.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(mainActivity, R.string.ble_busy_now_msg, 0).show();
                    }
                });
            }
            BleManager.this.stopScanBleDeviceForAutoReconnect(true);
        }
    };
    private final Runnable scanBleDeviceTimeOutForAutoReconnectRunnable = new Runnable() { // from class: com.soletreadmills.sole_v2._manager.BleManager.13
        @Override // java.lang.Runnable
        public void run() {
            Timber.d("scanBleDeviceTimeOutForAutoReconnectRunnable", new Object[0]);
            Handler handler = BleManager.this.handlerBackground;
            if (handler != null) {
                handler.removeCallbacks(this);
            }
            BleManager.this.stopScanBleDeviceForAutoReconnect(false);
        }
    };
    private final Runnable scanBleDeviceDelayStartForAutoReconnect = new Runnable() { // from class: com.soletreadmills.sole_v2._manager.BleManager.14
        @Override // java.lang.Runnable
        public void run() {
            Timber.d("scanBleDeviceDelayStartForAutoReconnect", new Object[0]);
            Handler handler = BleManager.this.handlerBackground;
            if (handler != null) {
                handler.removeCallbacks(this);
            }
            if (BleManager.this.retryFtmsConnectCount > 2) {
                synchronized (BleManager.this.bluetoothCallbackListenerArrayList) {
                    if (BleManager.this.autoReconnectFtmsBleDeviceInfoData != null) {
                        String address = BleManager.this.autoReconnectFtmsBleDeviceInfoData.getAddress();
                        Iterator it = BleManager.this.bluetoothCallbackListenerArrayList.iterator();
                        while (it.hasNext()) {
                            BluetoothCallbackListener bluetoothCallbackListener = (BluetoothCallbackListener) it.next();
                            if (address != null) {
                                bluetoothCallbackListener.onDisconnected(BluetoothCallbackListener.DeviceType.FTMS, address);
                            } else {
                                bluetoothCallbackListener.onDisconnected(BluetoothCallbackListener.DeviceType.FTMS, "");
                            }
                        }
                    }
                }
                return;
            }
            BleManager.this.startScanBleDeviceForAutoReconnect();
        }
    };
    private final ScanCallback scanCallbackForAutoReconnect = new ScanCallback() { // from class: com.soletreadmills.sole_v2._manager.BleManager.15
        @Override // android.bluetooth.le.ScanCallback
        public void onScanResult(int callbackType, ScanResult result) {
            super.onScanResult(callbackType, result);
            Timber.d("scanCallbackForAutoReconnect -> callbackType=" + callbackType + " | result=" + result.toString(), new Object[0]);
            try {
                BleDeviceInfoData autoReconnectHrBleDeviceInfoData = BleManager.this.getAutoReconnectHrBleDeviceInfoData();
                if (autoReconnectHrBleDeviceInfoData != null && result != null && result.getDevice() != null && result.getScanRecord() != null && TextUtils.equals(autoReconnectHrBleDeviceInfoData.getAddress(), result.getDevice().getAddress()) && TextUtils.equals(autoReconnectHrBleDeviceInfoData.getName(), result.getScanRecord().getDeviceName())) {
                    autoReconnectHrBleDeviceInfoData.setScanResult(result);
                    BleManager bleManager = BleManager.this;
                    bleManager.bleHrConnect(autoReconnectHrBleDeviceInfoData, bleManager.isUserConnectHr, true);
                    BleManager.this.setAutoReconnectHrBleDeviceInfoData(null);
                }
                BleDeviceInfoData autoReconnectFtmsBleDeviceInfoData = BleManager.this.getAutoReconnectFtmsBleDeviceInfoData();
                if (autoReconnectFtmsBleDeviceInfoData != null && result != null && result.getDevice() != null && result.getScanRecord() != null && TextUtils.equals(autoReconnectFtmsBleDeviceInfoData.getName(), result.getScanRecord().getDeviceName())) {
                    autoReconnectFtmsBleDeviceInfoData.setScanResult(result);
                    autoReconnectFtmsBleDeviceInfoData.setAddress(result.getDevice().getAddress());
                    BleManager.this.bleFtmsConnect(autoReconnectFtmsBleDeviceInfoData, true);
                    BleManager.this.setAutoReconnectFtmsBleDeviceInfoData(null);
                }
                if (BleManager.this.getAutoReconnectHrBleDeviceInfoData() == null && BleManager.this.getAutoReconnectFtmsBleDeviceInfoData() == null) {
                    BleManager.this.stopScanBleDeviceForAutoReconnect(false);
                }
            } catch (Exception e) {
                Timber.e(e);
            }
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanFailed(int errorCode) {
            super.onScanFailed(errorCode);
            Timber.e("scanCallbackForAutoReconnect -> onScanFailed errorCode=%s", Integer.valueOf(errorCode));
        }
    };
    private final BroadcastReceiver gattUpdateReceiver = new BroadcastReceiver() { // from class: com.soletreadmills.sole_v2._manager.BleManager.16
        boolean isFtmsFirstDataAvailable = true;

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            FitnessMachineControlPointResponseData fitnessMachineControlPointResponseData = null;
            if (BleFtmsActionType.FTMS_ACTION_GATT_CONNECTED.name().equals(action)) {
                BleManager.this.setAutoReconnectFtmsBleDeviceInfoData(null);
                final String stringExtra = intent.getStringExtra(BleFtmsActionType.FTMS_EXTRA_GATT_ADDRESS.name());
                this.isFtmsFirstDataAvailable = true;
                if (BleManager.this.handlerBackground != null) {
                    BleManager.this.handlerBackground.post(new Runnable() { // from class: com.soletreadmills.sole_v2._manager.BleManager.16.1
                        /* JADX WARN: Code restructure failed: missing block: B:16:0x007b, code lost:
                        
                            r4.setConnectionState(2);
                         */
                        /* JADX WARN: Removed duplicated region for block: B:40:0x0151 A[Catch: all -> 0x0153, DONT_GENERATE, TryCatch #2 {, blocks: (B:4:0x0005, B:6:0x0018, B:8:0x002c, B:9:0x0044, B:11:0x0052, B:12:0x0065, B:14:0x006b, B:16:0x007b, B:20:0x0083, B:23:0x0093, B:25:0x00b1, B:26:0x00fb, B:28:0x0101, B:30:0x010f, B:32:0x0121, B:33:0x0130, B:36:0x0141, B:39:0x014a, B:40:0x0151, B:19:0x0080), top: B:49:0x0005, inners: #1, #3 }] */
                        @Override // java.lang.Runnable
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public void run() {
                            /*
                                Method dump skipped, instructions count: 342
                                To view this dump add '--comments-level debug' option
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2._manager.BleManager.AnonymousClass16.AnonymousClass1.run():void");
                        }
                    });
                }
                synchronized (BleManager.this.bluetoothCallbackListenerArrayList) {
                    Iterator it = BleManager.this.bluetoothCallbackListenerArrayList.iterator();
                    while (it.hasNext()) {
                        ((BluetoothCallbackListener) it.next()).onConnected(BluetoothCallbackListener.DeviceType.FTMS, stringExtra);
                    }
                }
                return;
            }
            if (BleFtmsActionType.FTMS_ACTION_GATT_CONNECTING.name().equals(action)) {
                final String stringExtra2 = intent.getStringExtra(BleFtmsActionType.FTMS_EXTRA_GATT_ADDRESS.name());
                if (BleManager.this.handlerBackground != null) {
                    BleManager.this.handlerBackground.post(new Runnable() { // from class: com.soletreadmills.sole_v2._manager.BleManager.16.2
                        @Override // java.lang.Runnable
                        public void run() {
                            synchronized (BleManager.this) {
                                if (BleManager.this.connectFtmsBleDeviceInfoData != null && TextUtils.equals(BleManager.this.connectFtmsBleDeviceInfoData.getAddress(), stringExtra2)) {
                                    BleManager.this.connectFtmsBleDeviceInfoData.setConnectionState(1);
                                }
                                Iterator<BleDeviceInfoData> it2 = BleManager.this.bleDeviceInfoDataList.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        break;
                                    }
                                    BleDeviceInfoData next = it2.next();
                                    if (TextUtils.equals(next.getAddress(), stringExtra2)) {
                                        next.setConnectionState(1);
                                        break;
                                    }
                                }
                            }
                        }
                    });
                }
                synchronized (BleManager.this.bluetoothCallbackListenerArrayList) {
                    Iterator it2 = BleManager.this.bluetoothCallbackListenerArrayList.iterator();
                    while (it2.hasNext()) {
                        ((BluetoothCallbackListener) it2.next()).onConnecting(BluetoothCallbackListener.DeviceType.FTMS, stringExtra2);
                    }
                }
                return;
            }
            if (BleFtmsActionType.FTMS_ACTION_GATT_DISCONNECTED.name().equals(action)) {
                final String stringExtra3 = intent.getStringExtra(BleFtmsActionType.FTMS_EXTRA_GATT_ADDRESS.name());
                synchronized (BleManager.this) {
                    Timber.d("FTMS_ACTION_GATT_DISCONNECTED -> retryConnectCount=%s", Integer.valueOf(BleManager.this.retryFtmsConnectCount));
                    BleService bleService = BleManager.this.bleService;
                    String connectBleName = MySharedPreferences.INSTANCE.getInstance().getConnectBleName();
                    if (BleManager.this.retryFtmsConnectCount <= 2 && BleManager.this.connectFtmsBleDeviceInfoData != null && bleService != null && bleService.bluetoothAdapter != null && bleService.bluetoothAdapter.isEnabled() && connectBleName != null && !connectBleName.isEmpty()) {
                        Timber.d("FTMS_ACTION_GATT_DISCONNECTED -> retryConnect", new Object[0]);
                        Timber.d("FTMS_ACTION_GATT_DISCONNECTED -> connectBleName:%s", connectBleName);
                        if (BleManager.this.handlerBackground != null) {
                            BleManager.this.handlerBackground.post(new Runnable() { // from class: com.soletreadmills.sole_v2._manager.BleManager.16.3
                                @Override // java.lang.Runnable
                                public void run() {
                                }
                            });
                            BleManager.this.handlerBackground.postDelayed(new Runnable() { // from class: com.soletreadmills.sole_v2._manager.BleManager.16.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (BleManager.this.connectFtmsBleDeviceInfoData != null) {
                                        BleManager.this.connectFtmsBleDeviceInfoData.setScanResult(null);
                                        BleManager.this.setAutoReconnectFtmsBleDeviceInfoData(BleManager.this.connectFtmsBleDeviceInfoData);
                                        BleManager.this.startScanBleDeviceForAutoReconnect();
                                    }
                                }
                            }, 3000L);
                        }
                    } else {
                        Timber.d("FTMS_ACTION_GATT_DISCONNECTED -> DISCONNECTED", new Object[0]);
                        BleManager.this.setAutoReconnectFtmsBleDeviceInfoData(null);
                        BleManager.this.setShowAppCalculationMessage(false);
                        synchronized (BleManager.this) {
                            if (BleManager.this.connectFtmsBleDeviceInfoData != null && TextUtils.equals(BleManager.this.connectFtmsBleDeviceInfoData.getAddress(), stringExtra3)) {
                                BleManager.this.connectFtmsBleDeviceInfoData.setConnectionState(0);
                            }
                        }
                        if (BleManager.this.handlerBackground != null) {
                            BleManager.this.handlerBackground.post(new Runnable() { // from class: com.soletreadmills.sole_v2._manager.BleManager.16.5
                                @Override // java.lang.Runnable
                                public void run() {
                                    synchronized (BleManager.this.bleDeviceInfoDataList) {
                                        Iterator<BleDeviceInfoData> it3 = BleManager.this.bleDeviceInfoDataList.iterator();
                                        while (true) {
                                            if (!it3.hasNext()) {
                                                break;
                                            }
                                            BleDeviceInfoData next = it3.next();
                                            if (TextUtils.equals(next.getAddress(), stringExtra3)) {
                                                next.setConnectionState(0);
                                                break;
                                            }
                                        }
                                    }
                                }
                            });
                        }
                        BleManager.this.connectFtmsBleDeviceInfoData = null;
                        BleManager.this.dataReceeived10SecCountDownTimer.cancel02();
                        BleManager.this.noDataReceeivedCountDownTimer.cancel02();
                        BleDataManager.getInstance().uploadSummaryData();
                        synchronized (BleManager.this.bluetoothCallbackListenerArrayList) {
                            Iterator it3 = BleManager.this.bluetoothCallbackListenerArrayList.iterator();
                            while (it3.hasNext()) {
                                BluetoothCallbackListener bluetoothCallbackListener = (BluetoothCallbackListener) it3.next();
                                if (stringExtra3 != null) {
                                    bluetoothCallbackListener.onDisconnected(BluetoothCallbackListener.DeviceType.FTMS, stringExtra3);
                                } else {
                                    bluetoothCallbackListener.onDisconnected(BluetoothCallbackListener.DeviceType.FTMS, "");
                                }
                            }
                        }
                    }
                }
                return;
            }
            if (BleFtmsActionType.FTMS_ACTION_GATT_SERVICES_DISCOVERED.name().equals(action)) {
                BleManager.this.noDataReceeivedCountDownTimer.cancel02();
                BleManager.this.dataReceeived10SecCountDownTimer.cancel02();
                BleManager.this.dataReceeived10SecCountDownTimer.start02();
                this.isFtmsFirstDataAvailable = true;
                return;
            }
            if (BleFtmsActionType.FTMS_ACTION_DATA_AVAILABLE.name().equals(action)) {
                String stringExtra4 = intent.getStringExtra(BleFtmsActionType.FTMS_EXTRA_DATA.name());
                String stringExtra5 = intent.getStringExtra(BleFtmsActionType.FTMS_EXTRA_DATA_TYPE.name());
                this.isFtmsFirstDataAvailable = false;
                BleManager.this.noDataReceeivedCountDownTimer.cancel02();
                BleManager.this.dataReceeived10SecCountDownTimer.cancel02();
                BleManager.this.dataReceeived10SecCountDownTimer.start02();
                if (BleManager.this.connectFtmsBleDeviceInfoData != null && stringExtra5 != null) {
                    Handler handler = BleManager.this.handlerBackground;
                    final BleDeviceInfoDatabase bleDeviceInfoDatabase = BleManager.this.getBleDeviceInfoDatabase();
                    if (handler != null && bleDeviceInfoDatabase != null) {
                        handler.post(new Runnable() { // from class: com.soletreadmills.sole_v2._manager.BleManager.16.6
                            @Override // java.lang.Runnable
                            public void run() {
                                synchronized (BleManager.this) {
                                    String loginUuid = Global.getLoginUuid();
                                    BleDeviceInfoDatabase bleDeviceInfoDatabase2 = bleDeviceInfoDatabase;
                                    if (bleDeviceInfoDatabase2 != null && loginUuid != null) {
                                        try {
                                            bleDeviceInfoDatabase2.bleDeviceInfoDao().findByBleName(BleManager.this.connectFtmsBleDeviceInfoData.getName(), loginUuid);
                                        } catch (Exception e) {
                                            Timber.e(e);
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
                synchronized (BleManager.this.bluetoothCallbackListenerArrayList) {
                    Iterator it4 = BleManager.this.bluetoothCallbackListenerArrayList.iterator();
                    while (it4.hasNext()) {
                        ((BluetoothCallbackListener) it4.next()).onReceiveFtmsData(stringExtra4, stringExtra5);
                    }
                }
                return;
            }
            if (BleFtmsActionType.FTMS_ACTION_TRAINING_STATUS_DATA_AVAILABLE.name().equals(action)) {
                TrainingStatusType nowTrainingStatusType = BleDataManager.getInstance().getNowTrainingStatusType();
                TrainingStatusType oldTrainingStatusType = BleDataManager.getInstance().getOldTrainingStatusType();
                if (oldTrainingStatusType != null && oldTrainingStatusType != TrainingStatusType.IDLE && nowTrainingStatusType == TrainingStatusType.IDLE) {
                    Timber.d("summaryDataUpload oldTrainingStatusType != null && oldTrainingStatusType != TrainingStatusType.IDLE && nowTrainingStatusType == TrainingStatusType.IDLE", new Object[0]);
                    BleDataManager.getInstance().uploadSummaryData();
                }
                synchronized (BleManager.this.bluetoothCallbackListenerArrayList) {
                    Iterator it5 = BleManager.this.bluetoothCallbackListenerArrayList.iterator();
                    while (it5.hasNext()) {
                        ((BluetoothCallbackListener) it5.next()).onReceiveTrainingStatus(nowTrainingStatusType);
                    }
                }
                return;
            }
            if (BleFtmsActionType.FTMS_ACTION_FITNESS_MACHINE_STATUS_DATA_AVAILABLE.name().equals(action)) {
                FitnessMachineStatusType nowFitnessMachineStatusType = BleDataManager.getInstance().getNowFitnessMachineStatusType();
                if (nowFitnessMachineStatusType != FitnessMachineStatusType.FITNESS_MACHINE_STOPPED_BY_THE_USER && nowFitnessMachineStatusType != FitnessMachineStatusType.FITNESS_MACHINE_PAUSED_BY_THE_USER) {
                    BleManager.this.sendCmdFtms(FitnessMachineControlPointCmd.getCurrentProgram());
                }
                synchronized (BleManager.this.bluetoothCallbackListenerArrayList) {
                    Iterator it6 = BleManager.this.bluetoothCallbackListenerArrayList.iterator();
                    while (it6.hasNext()) {
                        ((BluetoothCallbackListener) it6.next()).onReceiveFitnessMachineStatus(nowFitnessMachineStatusType);
                    }
                }
                return;
            }
            if (BleFtmsActionType.FTMS_ACTION_FITNESS_MACHINE_CONTROL_POINT_DATA_AVAILABLE.name().equals(action)) {
                try {
                    fitnessMachineControlPointResponseData = (FitnessMachineControlPointResponseData) new Gson().fromJson(intent.getStringExtra(BleFtmsActionType.FTMS_EXTRA_DATA.name()), FitnessMachineControlPointResponseData.class);
                } catch (Exception e) {
                    Timber.e(e.fillInStackTrace());
                }
                synchronized (BleManager.this.bluetoothCallbackListenerArrayList) {
                    Iterator it7 = BleManager.this.bluetoothCallbackListenerArrayList.iterator();
                    while (it7.hasNext()) {
                        ((BluetoothCallbackListener) it7.next()).onReceiveFitnessMachineControlPoint(fitnessMachineControlPointResponseData);
                    }
                }
                return;
            }
            if (BleHrActionType.HR_ACTION_GATT_CONNECTED.name().equals(action)) {
                BleManager.this.setAutoReconnectHrBleDeviceInfoData(null);
                final String stringExtra6 = intent.getStringExtra(BleHrActionType.HR_EXTRA_GATT_ADDRESS.name());
                if (BleManager.this.handlerBackground != null) {
                    BleManager.this.handlerBackground.post(new Runnable() { // from class: com.soletreadmills.sole_v2._manager.BleManager.16.7
                        @Override // java.lang.Runnable
                        public void run() {
                            synchronized (BleManager.this) {
                                BleManager.this.retryHrConnectCount = 0;
                                if (BleManager.this.connectHrBleDeviceInfoData != null && TextUtils.equals(BleManager.this.connectHrBleDeviceInfoData.getAddress(), stringExtra6)) {
                                    BleManager.this.connectHrBleDeviceInfoData.setConnectionState(2);
                                    BleManager.this.connectHrBleDeviceInfoData.setBleDeviceListType(BleDeviceListType.MY_DEVICES);
                                }
                                Iterator<BleDeviceInfoData> it8 = BleManager.this.bleDeviceInfoDataList.iterator();
                                while (true) {
                                    if (!it8.hasNext()) {
                                        break;
                                    }
                                    BleDeviceInfoData next = it8.next();
                                    if (TextUtils.equals(next.getAddress(), stringExtra6)) {
                                        next.setConnectionState(2);
                                        break;
                                    }
                                }
                            }
                        }
                    });
                }
                synchronized (BleManager.this.bluetoothCallbackListenerArrayList) {
                    Iterator it8 = BleManager.this.bluetoothCallbackListenerArrayList.iterator();
                    while (it8.hasNext()) {
                        ((BluetoothCallbackListener) it8.next()).onConnected(BluetoothCallbackListener.DeviceType.HR, stringExtra6);
                    }
                }
                return;
            }
            if (BleHrActionType.HR_ACTION_GATT_CONNECTING.name().equals(action)) {
                final String stringExtra7 = intent.getStringExtra(BleHrActionType.HR_EXTRA_GATT_ADDRESS.name());
                if (BleManager.this.handlerBackground != null) {
                    BleManager.this.handlerBackground.post(new Runnable() { // from class: com.soletreadmills.sole_v2._manager.BleManager.16.8
                        @Override // java.lang.Runnable
                        public void run() {
                            synchronized (BleManager.this) {
                                if (BleManager.this.connectHrBleDeviceInfoData != null) {
                                    BleManager.this.connectHrBleDeviceInfoData.setConnectionState(1);
                                }
                                synchronized (BleManager.this.bleDeviceInfoDataList) {
                                    Iterator<BleDeviceInfoData> it9 = BleManager.this.bleDeviceInfoDataList.iterator();
                                    while (it9.hasNext()) {
                                        BleDeviceInfoData next = it9.next();
                                        if (TextUtils.equals(next.getAddress(), stringExtra7)) {
                                            next.setConnectionState(1);
                                        } else {
                                            next.setConnectionState(0);
                                        }
                                    }
                                }
                            }
                        }
                    });
                }
                synchronized (BleManager.this.bluetoothCallbackListenerArrayList) {
                    Iterator it9 = BleManager.this.bluetoothCallbackListenerArrayList.iterator();
                    while (it9.hasNext()) {
                        ((BluetoothCallbackListener) it9.next()).onConnecting(BluetoothCallbackListener.DeviceType.HR, stringExtra7);
                    }
                }
                return;
            }
            if (BleHrActionType.HR_ACTION_GATT_DISCONNECTED.name().equals(action)) {
                String stringExtra8 = intent.getStringExtra(BleHrActionType.HR_EXTRA_GATT_ADDRESS.name());
                synchronized (BleManager.this) {
                    Timber.d("HR_ACTION_GATT_DISCONNECTED -> retryHrConnectCount=%s", Integer.valueOf(BleManager.this.retryHrConnectCount));
                    BleService bleService2 = BleManager.this.bleService;
                    if (BleManager.this.isUserConnectHr && BleManager.this.retryHrConnectCount <= 2 && BleManager.this.connectHrBleDeviceInfoData != null && bleService2 != null && bleService2.bluetoothAdapter != null && bleService2.bluetoothAdapter.isEnabled()) {
                        Timber.d("HR_ACTION_GATT_DISCONNECTED -> retryConnect", new Object[0]);
                        BleManager.access$2508(BleManager.this);
                        if (BleManager.this.handlerBackground != null) {
                            BleManager.this.handlerBackground.postDelayed(new Runnable() { // from class: com.soletreadmills.sole_v2._manager.BleManager.16.9
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (BleManager.this.connectHrBleDeviceInfoData != null) {
                                        BleManager.this.connectHrBleDeviceInfoData.setScanResult(null);
                                        BleManager.this.setAutoReconnectHrBleDeviceInfoData(BleManager.this.connectHrBleDeviceInfoData);
                                        BleManager.this.startScanBleDeviceForAutoReconnect();
                                    }
                                }
                            }, 3000L);
                        }
                    } else {
                        Timber.d("HR_ACTION_GATT_DISCONNECTED -> DISCONNECTED", new Object[0]);
                        BleManager.this.setAutoReconnectHrBleDeviceInfoData(null);
                        synchronized (BleManager.this) {
                            if (BleManager.this.connectHrBleDeviceInfoData != null) {
                                BleManager.this.connectHrBleDeviceInfoData.setConnectionState(0);
                            }
                        }
                        if (BleManager.this.handlerBackground != null) {
                            BleManager.this.handlerBackground.post(new Runnable() { // from class: com.soletreadmills.sole_v2._manager.BleManager.16.10
                                @Override // java.lang.Runnable
                                public void run() {
                                    synchronized (BleManager.this.bleDeviceInfoDataList) {
                                        Iterator<BleDeviceInfoData> it10 = BleManager.this.bleDeviceInfoDataList.iterator();
                                        while (it10.hasNext()) {
                                            it10.next().setConnectionState(0);
                                        }
                                    }
                                }
                            });
                        }
                        BleManager.this.connectHrBleDeviceInfoData = null;
                    }
                    synchronized (BleManager.this.bluetoothCallbackListenerArrayList) {
                        Iterator it10 = BleManager.this.bluetoothCallbackListenerArrayList.iterator();
                        while (it10.hasNext()) {
                            BluetoothCallbackListener bluetoothCallbackListener2 = (BluetoothCallbackListener) it10.next();
                            if (stringExtra8 != null) {
                                bluetoothCallbackListener2.onDisconnected(BluetoothCallbackListener.DeviceType.HR, stringExtra8);
                            } else {
                                bluetoothCallbackListener2.onDisconnected(BluetoothCallbackListener.DeviceType.HR, "");
                            }
                        }
                    }
                }
                return;
            }
            if (!BleHrActionType.HR_ACTION_GATT_SERVICES_DISCOVERED.name().equals(action) && BleHrActionType.HR_ACTION_DATA_AVAILABLE.name().equals(action)) {
                String stringExtra9 = intent.getStringExtra(BleHrActionType.HR_EXTRA_DATA.name());
                synchronized (BleManager.this.bluetoothCallbackListenerArrayList) {
                    Iterator it11 = BleManager.this.bluetoothCallbackListenerArrayList.iterator();
                    while (it11.hasNext()) {
                        BluetoothCallbackListener bluetoothCallbackListener3 = (BluetoothCallbackListener) it11.next();
                        if (BleDataManager.nowWearHrData.checkTimeInRangeAndGetValue() == -1) {
                            Timber.tag("HRRR").d("onReceiveHrData..." + stringExtra9, new Object[0]);
                            bluetoothCallbackListener3.onReceiveHrData(stringExtra9);
                        } else {
                            Timber.tag("HRRR").d("onReceiveHrData...use wear val", new Object[0]);
                        }
                    }
                }
            }
        }
    };
    private final Runnable connectFtmsBleRunnable = new Runnable() { // from class: com.soletreadmills.sole_v2._manager.BleManager.17
        @Override // java.lang.Runnable
        public void run() throws NumberFormatException {
            double d;
            BleService bleService = BleManager.this.bleService;
            if (BleManager.this.connectFtmsBleDeviceInfoData == null || bleService == null) {
                return;
            }
            if (Global.userData == null || Global.userData.getWeight() == null) {
                d = 0.0d;
            } else {
                try {
                    d = Double.parseDouble(Global.userData.getWeight());
                } catch (Exception e) {
                    Timber.e(e.fillInStackTrace());
                }
            }
            double d2 = d < AudioStats.AUDIO_AMPLITUDE_NONE ? 0.0d : d;
            boolean z = (Global.userData == null || Global.userData.getGender() == null || !Global.userData.getGender().equals("F")) ? false : true;
            try {
                if (BleManager.this.connectFtmsBleDeviceInfoData.getMachineType() != null) {
                    BleFtmsMachineType ftmsType = BleManager.this.connectFtmsBleDeviceInfoData.getMachineType().getFtmsType();
                    if (ftmsType == null) {
                        Timber.w("connectFtmsBleRunnable: ftmsType is null", new Object[0]);
                        return;
                    } else {
                        bleService.connectFtms(BleManager.this.connectFtmsBleDeviceInfoData.getAddress(), BleManager.this.connectFtmsBleDeviceInfoData.getName(), ftmsType, BleManager.this.connectFtmsBleDeviceInfoData.getIsHasAdv0x16(), d2, z, new InvalidRequestCallback() { // from class: com.soletreadmills.sole_v2._manager.BleManager.17.1
                            @Override // no.nordicsemi.android.ble.callback.InvalidRequestCallback
                            public void onInvalidRequest() {
                                Timber.e("connectFtmsBleRunnable onInvalidRequest", new Object[0]);
                            }
                        }, new FailCallback() { // from class: com.soletreadmills.sole_v2._manager.BleManager.17.2
                            @Override // no.nordicsemi.android.ble.callback.FailCallback
                            public void onRequestFailed(BluetoothDevice device, int status) {
                                Timber.e("onRequestFailed device=" + device + " | status=" + status, new Object[0]);
                            }
                        });
                        BleManager.this.bondDiscovery();
                        return;
                    }
                }
                Timber.w("connectFtmsBleRunnable: machineType is null", new Object[0]);
            } catch (Exception e2) {
                Timber.e(e2, "connectFtmsBleRunnable failed", new Object[0]);
            }
        }
    };
    private final Runnable connectFtmsTimeoutRunnable = new Runnable() { // from class: com.soletreadmills.sole_v2._manager.BleManager.18
        @Override // java.lang.Runnable
        public void run() {
            BleManager.this.bleFtmsDisconnect();
            MainActivity mainActivity = BleManager.this.getMyApplication().getMainActivity();
            if (mainActivity != null) {
                mainActivity.showBaseDialog(mainActivity.getString(R.string.connection_timeout), mainActivity.getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.soletreadmills.sole_v2._manager.BleManager.18.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        BleManager.this.startScanBleDevice();
                    }
                }, (String) null, (DialogInterface.OnClickListener) null);
            }
        }
    };
    private final Runnable connectHrBleRunnable = new Runnable() { // from class: com.soletreadmills.sole_v2._manager.BleManager.19
        @Override // java.lang.Runnable
        public void run() {
            BleDeviceInfoData connectHrBleDeviceInfoData = BleManager.this.getConnectHrBleDeviceInfoData();
            BleService bleService = BleManager.this.getBleService();
            if (connectHrBleDeviceInfoData == null || bleService == null) {
                return;
            }
            bleService.connectHr(connectHrBleDeviceInfoData.getAddress(), connectHrBleDeviceInfoData.getName(), new InvalidRequestCallback() { // from class: com.soletreadmills.sole_v2._manager.BleManager.19.1
                @Override // no.nordicsemi.android.ble.callback.InvalidRequestCallback
                public void onInvalidRequest() {
                    Timber.e("connectHrBleRunnable -> onInvalidRequest ", new Object[0]);
                }
            }, new FailCallback() { // from class: com.soletreadmills.sole_v2._manager.BleManager.19.2
                @Override // no.nordicsemi.android.ble.callback.FailCallback
                public void onRequestFailed(BluetoothDevice device, int status) {
                    Timber.e("connectHrBleRunnable -> onRequestFailed device=" + device + " | status=" + status, new Object[0]);
                }
            });
        }
    };
    private final Runnable connectHrTimeoutRunnable = new Runnable() { // from class: com.soletreadmills.sole_v2._manager.BleManager.20
        @Override // java.lang.Runnable
        public void run() {
            BleManager.this.bleHrDisconnect();
            MainActivity mainActivity = BleManager.this.getMyApplication().getMainActivity();
            if (mainActivity != null) {
                mainActivity.showBaseDialog(mainActivity.getString(R.string.connection_timeout), mainActivity.getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.soletreadmills.sole_v2._manager.BleManager.20.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        BleManager.this.startScanBleDevice();
                    }
                }, (String) null, (DialogInterface.OnClickListener) null);
            }
        }
    };
    private final UploadSummaryDataListener uploadSummaryDataListener = new UploadSummaryDataListener() { // from class: com.soletreadmills.sole_v2._manager.BleManager.22
        /* JADX WARN: Can't wrap try/catch for region: R(9:49|(2:105|50)|(1:52)(2:54|(1:56)(2:57|(1:59)(2:60|(1:62)(7:63|(1:65)|69|103|70|74|(1:76)(7:77|(2:79|(2:81|(2:83|(2:85|(1:87)(1:88))(1:89))(1:90))(1:91))(1:92)|93|(2:96|94)|112|97|98)))))|53|69|103|70|74|(0)(0)) */
        /* JADX WARN: Code restructure failed: missing block: B:72:0x01b8, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:73:0x01b9, code lost:
        
            timber.log.Timber.e(r0);
            r0 = 0;
         */
        /* JADX WARN: Removed duplicated region for block: B:76:0x01c3 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:77:0x01c4  */
        @Override // com.soletreadmills.sole_v2.ble.listener.UploadSummaryDataListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onNoticeUpload(final java.util.ArrayList<com.soletreadmills.sole_v2.ble.data.FtmsBaseData> r67, final boolean r68, final java.lang.Integer r69, java.lang.String r70) throws java.lang.NumberFormatException {
            /*
                Method dump skipped, instructions count: 879
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2._manager.BleManager.AnonymousClass22.onNoticeUpload(java.util.ArrayList, boolean, java.lang.Integer, java.lang.String):void");
        }
    };
    private final MyCountDownTimer dataReceeived10SecCountDownTimer = new MyCountDownTimer(10000, 1000) { // from class: com.soletreadmills.sole_v2._manager.BleManager.23
        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            Timber.d("dataReceeived10SecCountDownTimer Finish=" + (millisUntilFinished / 1000), new Object[0]);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            final MainActivity mainActivity = BleManager.this.getMyApplication().getMainActivity();
            if (mainActivity != null) {
                mainActivity.runOnUiThread(new Runnable() { // from class: com.soletreadmills.sole_v2._manager.BleManager.23.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(mainActivity, R.string.no_data_receeived, 0).show();
                    }
                });
            }
            if (BleManager.this.retryFtmsConnectCount > 2) {
                return;
            }
            BleManager.this.noDataReceeivedCountDownTimer.start02();
        }
    };
    private final MyCountDownTimer noDataReceeivedCountDownTimer = new MyCountDownTimer(60000, 1000) { // from class: com.soletreadmills.sole_v2._manager.BleManager.24
        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            Timber.d("noDataReceeivedCountDownTimer Finish=" + (millisUntilFinished / 1000), new Object[0]);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            final MainActivity mainActivity = BleManager.this.getMyApplication().getMainActivity();
            if (mainActivity != null) {
                mainActivity.runOnUiThread(new Runnable() { // from class: com.soletreadmills.sole_v2._manager.BleManager.24.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(mainActivity, R.string.no_data_receeived, 0).show();
                    }
                });
            }
            if (BleManager.this.retryFtmsConnectCount > 2) {
                return;
            }
            BleManager.this.noDataReceeivedCountDownTimer.start02();
        }
    };
    private final BroadcastReceiver bluetoothBondStateChangedBroadcastReceiver = new BroadcastReceiver() { // from class: com.soletreadmills.sole_v2._manager.BleManager.25
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            final BluetoothDevice bluetoothDevice;
            if ((Build.VERSION.SDK_INT < 31 || ActivityCompat.checkSelfPermission(BleManager.this.myApplication, "android.permission.BLUETOOTH_CONNECT") == 0) && TextUtils.equals(intent.getAction(), "android.bluetooth.device.action.BOND_STATE_CHANGED") && (bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE")) != null) {
                switch (bluetoothDevice.getBondState()) {
                    case 10:
                        Timber.d("bluetoothBondStateChangedBroadcastReceiver -> 已解除配对", new Object[0]);
                        break;
                    case 11:
                        Timber.d("bluetoothBondStateChangedBroadcastReceiver -> 正在配对...", new Object[0]);
                        BleManager.this.handlerBackground.post(new Runnable() { // from class: com.soletreadmills.sole_v2._manager.BleManager.25.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BleDeviceInfoData next;
                                BleDeviceInfoEntity bleDeviceInfoEntityFindByBleName;
                                synchronized (BleManager.this) {
                                    Iterator<BleDeviceInfoData> it = BleManager.this.bleDeviceInfoDataList.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            next = null;
                                            break;
                                        } else {
                                            next = it.next();
                                            if (bluetoothDevice.getAddress().equals(next.getAddress())) {
                                                break;
                                            }
                                        }
                                    }
                                    if (next == null) {
                                        return;
                                    }
                                    if (BleManager.this.bleService != null && next.getMachineType() != MachineType.HR && BleManager.this.isConnectedFtms() && BleManager.this.connectFtmsBleDeviceInfoData != null && next.getAddress().equals(BleManager.this.connectFtmsBleDeviceInfoData.getAddress())) {
                                        try {
                                            String loginUuid = Global.getLoginUuid();
                                            if (BleManager.this.bleDeviceInfoDatabase != null && loginUuid != null && (bleDeviceInfoEntityFindByBleName = BleManager.this.bleDeviceInfoDatabase.bleDeviceInfoDao().findByBleName(next.getName(), loginUuid)) != null) {
                                                BleManager.this.bleDeviceInfoDatabase.bleDeviceInfoDao().delete(bleDeviceInfoEntityFindByBleName);
                                            }
                                        } catch (Exception e) {
                                            Timber.e(e.fillInStackTrace());
                                        }
                                    }
                                    next.setBleDeviceListType(BleDeviceListType.OTHER_DEVICES);
                                }
                            }
                        });
                        break;
                    case 12:
                        Timber.d("bluetoothBondStateChangedBroadcastReceiver -> 已配对", new Object[0]);
                        BleManager.this.handlerBackground.post(new Runnable() { // from class: com.soletreadmills.sole_v2._manager.BleManager.25.2
                            @Override // java.lang.Runnable
                            public void run() {
                                BleDeviceInfoData next;
                                synchronized (BleManager.this) {
                                    Iterator<BleDeviceInfoData> it = BleManager.this.bleDeviceInfoDataList.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            next = null;
                                            break;
                                        } else {
                                            next = it.next();
                                            if (bluetoothDevice.getAddress().equals(next.getAddress())) {
                                                break;
                                            }
                                        }
                                    }
                                    if (next == null) {
                                        return;
                                    }
                                    if (BleManager.this.bleService != null && next.getMachineType() != MachineType.HR && BleManager.this.isConnectedFtms() && BleManager.this.connectFtmsBleDeviceInfoData != null && next.getAddress().equals(BleManager.this.connectFtmsBleDeviceInfoData.getAddress())) {
                                        try {
                                            String loginUuid = Global.getLoginUuid();
                                            if (BleManager.this.bleDeviceInfoDatabase != null && loginUuid != null && BleManager.this.bleDeviceInfoDatabase.bleDeviceInfoDao().findByBleName(next.getName(), loginUuid) == null) {
                                                BleDeviceInfoEntity bleDeviceInfoEntity = new BleDeviceInfoEntity(next.getAddress(), next.getName(), loginUuid, null, next.getIsHasAdv0x16());
                                                bleDeviceInfoEntity.setMachineType(next.getMachineType());
                                                BleManager.this.bleDeviceInfoDatabase.bleDeviceInfoDao().insert(bleDeviceInfoEntity);
                                            }
                                        } catch (Exception e) {
                                            Timber.e(e.fillInStackTrace());
                                        }
                                    }
                                    next.setBleDeviceListType(BleDeviceListType.MY_DEVICES);
                                }
                            }
                        });
                        break;
                }
            }
        }
    };

    static /* synthetic */ int access$1808(BleManager bleManager) {
        int i = bleManager.retryFtmsConnectCount;
        bleManager.retryFtmsConnectCount = i + 1;
        return i;
    }

    static /* synthetic */ int access$2508(BleManager bleManager) {
        int i = bleManager.retryHrConnectCount;
        bleManager.retryHrConnectCount = i + 1;
        return i;
    }

    public static BleManager getInstance() {
        synchronized (BleManager.class) {
            if (manager == null) {
                manager = new BleManager();
            }
        }
        return manager;
    }

    public MyApplication getMyApplication() {
        return this.myApplication;
    }

    public void setMyApplication(MyApplication myApplication) {
        this.myApplication = myApplication;
    }

    public synchronized void init() {
        synchronized (this) {
            Timber.d("init run", new Object[0]);
            destroy();
            if (this.handlerThread == null) {
                HandlerThread handlerThread = new HandlerThread(this.TAG + HandlerThread.class.getSimpleName(), 10);
                this.handlerThread = handlerThread;
                handlerThread.start();
                this.handlerBackground = new Handler(this.handlerThread.getLooper());
            }
            buildDatabase();
            bindService();
            BleDataManager.getInstance().setUploadSummaryDataListener(this.uploadSummaryDataListener);
            registerReceiver();
            registerBluetoothBondStateChangedBroadcastReceiver();
            Timber.d("init stop", new Object[0]);
        }
    }

    public void bindService() {
        MainActivity mainActivity;
        Timber.d("bindService start", new Object[0]);
        try {
            mainActivity = getMyApplication().getMainActivity();
        } catch (Exception e) {
            Timber.e(e);
        }
        if (mainActivity == null) {
            Timber.d("bindService mainActivity == null", new Object[0]);
            return;
        }
        if (Build.VERSION.SDK_INT >= 34) {
            if (ContextCompat.checkSelfPermission(mainActivity, "android.permission.BLUETOOTH_CONNECT") != 0) {
                Timber.d("bindService BLUETOOTH_CONNECT PERMISSION_DENIED", new Object[0]);
                return;
            } else if (ContextCompat.checkSelfPermission(mainActivity, "android.permission.BLUETOOTH_SCAN") != 0) {
                Timber.d("bindService BLUETOOTH_SCAN PERMISSION_DENIED", new Object[0]);
                return;
            }
        }
        ContextCompat.startForegroundService(mainActivity, new Intent(mainActivity, (Class<?>) BleService.class));
        Timber.d("bindService isServiceConnection=" + this.isServiceConnection, new Object[0]);
        if (!this.isServiceConnection) {
            mainActivity.bindService(new Intent(mainActivity, (Class<?>) BleService.class), this.serviceConnection, 1);
            this.isServiceConnection = true;
        }
        Timber.d("bindService end", new Object[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0068 A[Catch: all -> 0x007b, TryCatch #1 {, blocks: (B:4:0x0002, B:6:0x0032, B:7:0x003f, B:9:0x0045, B:10:0x0048, B:12:0x0054, B:14:0x0058, B:17:0x0061, B:18:0x0064, B:20:0x0068, B:21:0x006b, B:22:0x0078), top: B:33:0x0002, outer: #2, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void destroy() {
        /*
            r4 = this;
            monitor-enter(r4)
            monitor-enter(r4)     // Catch: java.lang.Throwable -> L7e
            java.lang.String r0 = "destroy run"
            r1 = 0
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L7b
            timber.log.Timber.d(r0, r2)     // Catch: java.lang.Throwable -> L7b
            com.soletreadmills.sole_v2.ble.manager.BleDataManager r0 = com.soletreadmills.sole_v2.ble.manager.BleDataManager.getInstance()     // Catch: java.lang.Throwable -> L7b
            r2 = 0
            r0.setUploadSummaryDataListener(r2)     // Catch: java.lang.Throwable -> L7b
            com.soletreadmills.sole_v2._manager.BleManager$MyCountDownTimer r0 = r4.dataReceeived10SecCountDownTimer     // Catch: java.lang.Throwable -> L7b
            r0.cancel02()     // Catch: java.lang.Throwable -> L7b
            com.soletreadmills.sole_v2._manager.BleManager$MyCountDownTimer r0 = r4.noDataReceeivedCountDownTimer     // Catch: java.lang.Throwable -> L7b
            r0.cancel02()     // Catch: java.lang.Throwable -> L7b
            r4.stopScanBleDevice()     // Catch: java.lang.Throwable -> L7b
            r4.stopScanBleDeviceForAutoReconnect(r1)     // Catch: java.lang.Throwable -> L7b
            r4.bleFtmsDisconnect()     // Catch: java.lang.Throwable -> L7b
            r4.bleHrDisconnect()     // Catch: java.lang.Throwable -> L7b
            r4.unRegisterService()     // Catch: java.lang.Throwable -> L7b
            r4.unregisterBluetoothBondStateChangedBroadcastReceiver()     // Catch: java.lang.Throwable -> L7b
            android.os.Handler r0 = r4.handlerBackground     // Catch: java.lang.Throwable -> L7b
            if (r0 == 0) goto L3f
            java.lang.Runnable r3 = r4.connectFtmsBleRunnable     // Catch: java.lang.Throwable -> L7b
            r0.removeCallbacks(r3)     // Catch: java.lang.Throwable -> L7b
            java.lang.Runnable r3 = r4.connectHrBleRunnable     // Catch: java.lang.Throwable -> L7b
            r0.removeCallbacks(r3)     // Catch: java.lang.Throwable -> L7b
            r0.removeCallbacksAndMessages(r2)     // Catch: java.lang.Throwable -> L7b
        L3f:
            r4.handlerBackground = r2     // Catch: java.lang.Throwable -> L7b
            android.os.HandlerThread r0 = r4.handlerThread     // Catch: java.lang.Throwable -> L7b
            if (r0 == 0) goto L48
            r0.quit()     // Catch: java.lang.Throwable -> L7b
        L48:
            r4.handlerThread = r2     // Catch: java.lang.Throwable -> L7b
            com.soletreadmills.sole_v2.MyApplication r0 = r4.getMyApplication()     // Catch: java.lang.Throwable -> L7b
            com.soletreadmills.sole_v2.ui.MainActivity r0 = r0.getMainActivity()     // Catch: java.lang.Throwable -> L7b
            if (r0 == 0) goto L64
            boolean r3 = r4.isServiceConnection     // Catch: java.lang.Throwable -> L7b
            if (r3 == 0) goto L64
            android.content.ServiceConnection r3 = r4.serviceConnection     // Catch: java.lang.Exception -> L60 java.lang.Throwable -> L7b
            r0.unbindService(r3)     // Catch: java.lang.Exception -> L60 java.lang.Throwable -> L7b
            r4.isServiceConnection = r1     // Catch: java.lang.Exception -> L60 java.lang.Throwable -> L7b
            goto L64
        L60:
            r0 = move-exception
            timber.log.Timber.e(r0)     // Catch: java.lang.Throwable -> L7b
        L64:
            com.soletreadmills.sole_v2.ble.BleService r0 = r4.bleService     // Catch: java.lang.Throwable -> L7b
            if (r0 == 0) goto L6b
            r0.stopSelf()     // Catch: java.lang.Throwable -> L7b
        L6b:
            r4.bleService = r2     // Catch: java.lang.Throwable -> L7b
            java.lang.String r0 = r4.TAG     // Catch: java.lang.Throwable -> L7b
            java.lang.String r1 = "destroy stop"
            java.lang.Object[] r1 = new java.lang.Object[]{r1}     // Catch: java.lang.Throwable -> L7b
            timber.log.Timber.d(r0, r1)     // Catch: java.lang.Throwable -> L7b
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L7b
            monitor-exit(r4)
            return
        L7b:
            r0 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L7b
            throw r0     // Catch: java.lang.Throwable -> L7e
        L7e:
            r0 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L7e
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2._manager.BleManager.destroy():void");
    }

    public void checkBleEnabled(final EnabledBluetoothListener enabledBluetoothListener) {
        if (Build.VERSION.SDK_INT >= 31 && ActivityCompat.checkSelfPermission(this.myApplication, "android.permission.BLUETOOTH_CONNECT") != 0) {
            Timber.w("缺少 BLUETOOTH_CONNECT 權限", new Object[0]);
        } else {
            if (this.enabledBluetoothThread != null) {
                Timber.w("enabledBluetoothThread is running, skip", new Object[0]);
                return;
            }
            Thread thread = new Thread(new Runnable() { // from class: com.soletreadmills.sole_v2._manager.BleManager$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m8613x5bdc5f32(enabledBluetoothListener);
                }
            }, "enabledBluetoothThread");
            this.enabledBluetoothThread = thread;
            thread.start();
        }
    }

    /* renamed from: lambda$checkBleEnabled$0$com-soletreadmills-sole_v2-_manager-BleManager, reason: not valid java name */
    /* synthetic */ void m8613x5bdc5f32(final EnabledBluetoothListener enabledBluetoothListener) {
        Timber.d("enabledBluetoothThread run", new Object[0]);
        BleService bleService = this.bleService;
        if (bleService == null || bleService.bluetoothAdapter == null) {
            Timber.w("BleService 或 BluetoothAdapter 為 null", new Object[0]);
            enabledBluetoothListener.OnDisable();
            this.enabledBluetoothThread = null;
        } else {
            if (bleService.bluetoothAdapter.isEnabled()) {
                Timber.d("Bluetooth 已開啟，callback OnEnabled()", new Object[0]);
                enabledBluetoothListener.OnEnabled();
                this.enabledBluetoothThread = null;
                Timber.d("enabledBluetoothThread stop", new Object[0]);
                return;
            }
            Timber.w("藍牙未開啟，提示使用者", new Object[0]);
            MainActivity mainActivity = getMyApplication().getMainActivity();
            if (mainActivity != null) {
                mainActivity.showBaseDialog(mainActivity.getString(R.string.please_enable_bluetooth), mainActivity.getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.soletreadmills.sole_v2._manager.BleManager.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        enabledBluetoothListener.OnDisable();
                    }
                }, (String) null, (DialogInterface.OnClickListener) null);
            }
            this.enabledBluetoothThread = null;
        }
    }

    private void buildDatabase() {
        Handler handler = this.handlerBackground;
        if (this.bleDeviceInfoDatabase == null && handler != null) {
            handler.post(new Runnable() { // from class: com.soletreadmills.sole_v2._manager.BleManager.3
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (BleManager.this) {
                        try {
                            BleManager.this.bleDeviceInfoDatabase = BleDeviceInfoDatabase.INSTANCE.getDatabase(BleManager.this.getMyApplication());
                        } catch (Exception e) {
                            Timber.e(e);
                        }
                    }
                }
            });
        }
        if (this.summaryTempDataDatabase != null || handler == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.soletreadmills.sole_v2._manager.BleManager.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (BleManager.this) {
                    try {
                        BleManager.this.summaryTempDataDatabase = SummaryTempDataDatabase.INSTANCE.getDatabase(BleManager.this.getMyApplication());
                    } catch (Exception e) {
                        Timber.e(e);
                    }
                    if (BleManager.this.summaryTempDataDatabase == null) {
                        return;
                    }
                    BleManager.this.checkSummaryTempData();
                }
            }
        });
    }

    public synchronized void resetBleDeviceInfoList() {
        Handler handler = this.handlerBackground;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.soletreadmills.sole_v2._manager.BleManager.5
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (BleManager.this) {
                        BleManager.this.bleDeviceInfoDataList.clear();
                        if (!BleManager.this.isConnectedFtms()) {
                            BleManager.this.connectFtmsBleDeviceInfoData = null;
                        }
                        FtmsDeviceManager ftmsDeviceManager = BleManager.this.getFtmsDeviceManager();
                        BluetoothDevice connectedBluetoothDeviceFtms = BleManager.this.getConnectedBluetoothDeviceFtms();
                        if (ftmsDeviceManager != null && ftmsDeviceManager.isConnected() && ftmsDeviceManager.getBluetoothDeviceName() != null && connectedBluetoothDeviceFtms != null && connectedBluetoothDeviceFtms.getAddress() != null && BleManager.this.isConnectedFtms()) {
                            BleDeviceInfoData bleDeviceInfoData = BleManager.this.connectFtmsBleDeviceInfoData;
                            if (bleDeviceInfoData == null) {
                                BleManager.this.connectFtmsBleDeviceInfoData = new BleDeviceInfoData(ftmsDeviceManager.getBluetoothDeviceName(), connectedBluetoothDeviceFtms.getAddress(), null);
                            } else if (!bleDeviceInfoData.getAddress().equals(connectedBluetoothDeviceFtms.getAddress())) {
                                BleManager.this.connectFtmsBleDeviceInfoData = new BleDeviceInfoData(ftmsDeviceManager.getBluetoothDeviceName(), connectedBluetoothDeviceFtms.getAddress(), null);
                            }
                        }
                        BleDeviceInfoData bleDeviceInfoData2 = BleManager.this.connectFtmsBleDeviceInfoData;
                        BleService bleService = BleManager.this.bleService;
                        boolean z = true;
                        if (bleDeviceInfoData2 != null && bleService != null) {
                            boolean z2 = true;
                            for (int i = 0; i < BleManager.this.bleDeviceInfoDataList.size(); i++) {
                                if (BleManager.this.bleDeviceInfoDataList.get(i).getAddress().equals(bleDeviceInfoData2.getAddress())) {
                                    bleDeviceInfoData2.setBleDeviceListType(BleDeviceListType.MY_DEVICES);
                                    BleManager.this.bleDeviceInfoDataList.set(i, bleDeviceInfoData2);
                                    z2 = false;
                                }
                            }
                            if (z2) {
                                BleManager.this.bleDeviceInfoDataList.add(bleDeviceInfoData2);
                            }
                        }
                        if (!BleManager.this.isConnectedHr()) {
                            BleManager.this.connectHrBleDeviceInfoData = null;
                        }
                        HrDeviceManager hrDeviceManager = BleManager.this.getHrDeviceManager();
                        BluetoothDevice connectedBluetoothDeviceHr = BleManager.this.getConnectedBluetoothDeviceHr();
                        if (connectedBluetoothDeviceHr != null && hrDeviceManager != null && hrDeviceManager.getBluetoothDeviceName() != null && connectedBluetoothDeviceHr.getAddress() != null && BleManager.this.isConnectedHr()) {
                            if (BleManager.this.connectHrBleDeviceInfoData != null && BleManager.this.connectHrBleDeviceInfoData.getAddress().equals(connectedBluetoothDeviceHr.getAddress())) {
                                BleManager.this.connectHrBleDeviceInfoData.setMachineType(MachineType.HR);
                            } else {
                                BleDeviceInfoData bleDeviceInfoData3 = new BleDeviceInfoData(hrDeviceManager.getBluetoothDeviceName(), connectedBluetoothDeviceHr.getAddress(), null);
                                bleDeviceInfoData3.setMachineType(MachineType.HR);
                                BleManager.this.connectHrBleDeviceInfoData = bleDeviceInfoData3;
                            }
                        }
                        if (BleManager.this.connectHrBleDeviceInfoData != null && bleService != null) {
                            for (int i2 = 0; i2 < BleManager.this.bleDeviceInfoDataList.size(); i2++) {
                                if (BleManager.this.bleDeviceInfoDataList.get(i2).getAddress().equals(BleManager.this.connectHrBleDeviceInfoData.getAddress())) {
                                    BleManager.this.connectHrBleDeviceInfoData.setBleDeviceListType(BleDeviceListType.MY_DEVICES);
                                    BleManager.this.bleDeviceInfoDataList.set(i2, BleManager.this.connectHrBleDeviceInfoData);
                                    z = false;
                                }
                            }
                            if (z) {
                                BleManager.this.bleDeviceInfoDataList.add(BleManager.this.connectHrBleDeviceInfoData);
                            }
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean addBleDeviceInfoList(BleDeviceInfoData bleDeviceInfoData) {
        boolean z;
        synchronized (this) {
            BleService bleService = this.bleService;
            BleDeviceInfoData bleDeviceInfoData2 = this.connectFtmsBleDeviceInfoData;
            if (bleDeviceInfoData2 != null && bleService != null && bleDeviceInfoData2.getAddress().equals(bleDeviceInfoData.getAddress())) {
                if (this.connectFtmsBleDeviceInfoData.getMachineType() != null) {
                    bleDeviceInfoData.setMachineType(this.connectFtmsBleDeviceInfoData.getMachineType());
                }
                this.connectFtmsBleDeviceInfoData = bleDeviceInfoData;
            }
            BleDeviceInfoData bleDeviceInfoData3 = this.connectHrBleDeviceInfoData;
            if (bleDeviceInfoData3 != null && bleService != null && bleDeviceInfoData3.getAddress().equals(bleDeviceInfoData.getAddress())) {
                if (this.connectHrBleDeviceInfoData.getMachineType() != null) {
                    bleDeviceInfoData.setMachineType(this.connectHrBleDeviceInfoData.getMachineType());
                }
                this.connectHrBleDeviceInfoData = bleDeviceInfoData;
            }
            z = true;
            for (int i = 0; i < this.bleDeviceInfoDataList.size(); i++) {
                BleDeviceInfoData bleDeviceInfoData4 = this.bleDeviceInfoDataList.get(i);
                if (bleDeviceInfoData4.getAddress().equals(bleDeviceInfoData.getAddress())) {
                    if (bleDeviceInfoData4.getMachineType() != null) {
                        bleDeviceInfoData.setMachineType(bleDeviceInfoData4.getMachineType());
                    }
                    this.bleDeviceInfoDataList.set(i, bleDeviceInfoData);
                    z = false;
                }
            }
            if (z) {
                this.bleDeviceInfoDataList.add(bleDeviceInfoData);
            }
        }
        return z;
    }

    private void removeBleDeviceInfoList(BleDeviceInfoData bleDeviceInfoData) {
        synchronized (this) {
            this.bleDeviceInfoDataList.remove(bleDeviceInfoData);
        }
    }

    public synchronized void startScanBleDevice() {
        if (isScanning()) {
            Timber.e("startScanBleDevice 1", new Object[0]);
            return;
        }
        resetBleDeviceInfoList();
        Handler handler = this.handlerBackground;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.soletreadmills.sole_v2._manager.BleManager.6
                @Override // java.lang.Runnable
                public void run() {
                    Handler handler2 = BleManager.this.handlerBackground;
                    if (handler2 != null) {
                        handler2.removeCallbacks(BleManager.this.scanBleDeviceTimeOutRunnable);
                        handler2.removeCallbacks(BleManager.this.waitToStartScanBleDeviceRunnable);
                    }
                    BleService bleService = BleManager.this.bleService;
                    BluetoothAdapter bluetoothAdapter = bleService != null ? bleService.bluetoothAdapter : null;
                    BluetoothLeScanner bluetoothLeScanner = bluetoothAdapter != null ? bluetoothAdapter.getBluetoothLeScanner() : null;
                    if (bluetoothLeScanner != null) {
                        if (Build.VERSION.SDK_INT >= 31 && ActivityCompat.checkSelfPermission(BleManager.this.myApplication, "android.permission.BLUETOOTH_SCAN") != 0) {
                            return;
                        }
                        if (handler2 != null) {
                            handler2.postDelayed(BleManager.this.scanBleDeviceTimeOutRunnable, 10000L);
                        }
                        bluetoothLeScanner.startScan(BleManager.this.scanCallback);
                        BleManager.this.bleStartScanLocalDateTimeWithView = LocalDateTime.now();
                        BleManager.this.bleStartScanLocalDateTime = LocalDateTime.now();
                        BleManager.this.isScanning = true;
                    }
                    synchronized (BleManager.this.bluetoothCallbackListenerArrayList) {
                        Iterator it = BleManager.this.bluetoothCallbackListenerArrayList.iterator();
                        while (it.hasNext()) {
                            ((BluetoothCallbackListener) it.next()).onScan();
                        }
                    }
                }
            });
        }
    }

    public synchronized void stopScanBleDevice() {
        Handler handler = this.handlerBackground;
        if (handler != null) {
            handler.removeCallbacks(this.scanBleDeviceTimeOutRunnable);
        }
        BleService bleService = this.bleService;
        BluetoothAdapter bluetoothAdapter = bleService != null ? bleService.bluetoothAdapter : null;
        BluetoothLeScanner bluetoothLeScanner = bluetoothAdapter != null ? bluetoothAdapter.getBluetoothLeScanner() : null;
        if (bluetoothLeScanner != null) {
            if (Build.VERSION.SDK_INT >= 31 && ActivityCompat.checkSelfPermission(this.myApplication, "android.permission.BLUETOOTH_SCAN") != 0) {
                return;
            }
            bluetoothLeScanner.stopScan(this.scanCallback);
            this.isScanning = false;
        }
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.soletreadmills.sole_v2._manager.BleManager.9
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (BleManager.this.bluetoothCallbackListenerArrayList) {
                        Iterator it = BleManager.this.bluetoothCallbackListenerArrayList.iterator();
                        while (it.hasNext()) {
                            ((BluetoothCallbackListener) it.next()).onScan();
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bondDiscovery() {
        Handler handler;
        BleService bleService = this.bleService;
        if (bleService != null && bleService.bluetoothAdapter != null && (handler = this.handlerBackground) != null) {
            handler.post(new Runnable() { // from class: com.soletreadmills.sole_v2._manager.BleManager.10
                @Override // java.lang.Runnable
                public void run() throws InterruptedException {
                    try {
                        BleService bleService2 = BleManager.this.bleService;
                        if (bleService2 == null || bleService2.bluetoothAdapter == null) {
                            return;
                        }
                        if (Build.VERSION.SDK_INT < 31 || ActivityCompat.checkSelfPermission(BleManager.this.myApplication, "android.permission.BLUETOOTH_SCAN") == 0) {
                            if (!bleService2.bluetoothAdapter.isDiscovering()) {
                                bleService2.bluetoothAdapter.startDiscovery();
                            }
                            try {
                                Thread.sleep(1000L);
                            } catch (Exception e) {
                                Timber.e(e);
                            }
                            while (!bleService2.bluetoothAdapter.isDiscovering()) {
                                bleService2.bluetoothAdapter.cancelDiscovery();
                            }
                        }
                    } catch (Exception e2) {
                        Timber.e(e2);
                    }
                }
            });
        }
    }

    public boolean isScanning() {
        return this.isScanning;
    }

    public synchronized void startScanBleDeviceForAutoReconnect() {
        Timber.d("startScanBleDeviceForAutoReconnect", new Object[0]);
        if (isScanningForAutoReconnect()) {
            Timber.d("startScanBleDeviceForAutoReconnect isScanningForAutoReconnect=true", new Object[0]);
            return;
        }
        stopScanBleDeviceForAutoReconnect(false);
        Handler handler = this.handlerBackground;
        if (handler != null) {
            handler.removeCallbacks(this.scanBleDeviceDelayStartForAutoReconnect);
        }
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.soletreadmills.sole_v2._manager.BleManager.12
                @Override // java.lang.Runnable
                public void run() {
                    Handler handler2 = BleManager.this.handlerBackground;
                    if (handler2 != null) {
                        handler2.removeCallbacks(BleManager.this.scanBleDeviceTimeOutForAutoReconnectRunnable);
                    }
                    BleService bleService = BleManager.this.bleService;
                    BluetoothAdapter bluetoothAdapter = bleService != null ? bleService.bluetoothAdapter : null;
                    BluetoothLeScanner bluetoothLeScanner = bluetoothAdapter != null ? bluetoothAdapter.getBluetoothLeScanner() : null;
                    if (bluetoothLeScanner != null) {
                        if (Build.VERSION.SDK_INT < 31 || ActivityCompat.checkSelfPermission(BleManager.this.myApplication, "android.permission.BLUETOOTH_SCAN") == 0) {
                            LocalDateTime localDateTimeNow = LocalDateTime.now();
                            LocalDateTime localDateTime = BleManager.this.bleStartScanLocalDateTime;
                            if (localDateTime != null) {
                                long jAbs = Math.abs(ChronoUnit.SECONDS.between(localDateTime, localDateTimeNow));
                                Timber.d("startScanBleDeviceForAutoReconnect bleStartScanLocalDateTime diffSec=" + jAbs, new Object[0]);
                                if (jAbs < 10) {
                                    Timber.d("startScanBleDeviceForAutoReconnect bleStartScanLocalDateTime diffSec < 10", new Object[0]);
                                    if (handler2 != null) {
                                        handler2.removeCallbacks(BleManager.this.scanBleDeviceDelayStartForAutoReconnect);
                                        handler2.postDelayed(BleManager.this.scanBleDeviceDelayStartForAutoReconnect, (10 - jAbs) * 1000);
                                        return;
                                    }
                                    return;
                                }
                            }
                            if (handler2 != null) {
                                handler2.postDelayed(BleManager.this.scanBleDeviceTimeOutForAutoReconnectRunnable, 10000L);
                            }
                            BleManager.access$1808(BleManager.this);
                            bluetoothLeScanner.startScan(BleManager.this.scanCallbackForAutoReconnect);
                            BleManager.this.bleStartScanLocalDateTime = LocalDateTime.now();
                            BleManager.this.isScanningForAutoReconnect = true;
                        }
                    }
                }
            });
        }
    }

    public synchronized void stopScanBleDeviceForAutoReconnect(boolean isScanFailed) {
        Timber.d("stopScanBleDeviceForAutoReconnect", new Object[0]);
        Handler handler = this.handlerBackground;
        if (handler != null) {
            handler.removeCallbacks(this.scanBleDeviceTimeOutForAutoReconnectRunnable);
            handler.removeCallbacks(this.scanBleDeviceDelayStartForAutoReconnect);
        }
        BleService bleService = this.bleService;
        BluetoothAdapter bluetoothAdapter = bleService != null ? bleService.bluetoothAdapter : null;
        BluetoothLeScanner bluetoothLeScanner = bluetoothAdapter != null ? bluetoothAdapter.getBluetoothLeScanner() : null;
        if (bluetoothLeScanner != null) {
            if (Build.VERSION.SDK_INT >= 31 && ActivityCompat.checkSelfPermission(this.myApplication, "android.permission.BLUETOOTH_SCAN") != 0) {
                return;
            }
            bluetoothLeScanner.stopScan(this.scanCallbackForAutoReconnect);
            this.isScanningForAutoReconnect = false;
        }
        if (handler != null) {
            handler.removeCallbacks(this.scanBleDeviceDelayStartForAutoReconnect);
        }
        if (!isScanFailed && ((getAutoReconnectHrBleDeviceInfoData() != null || getAutoReconnectFtmsBleDeviceInfoData() != null) && handler != null)) {
            handler.postDelayed(this.scanBleDeviceDelayStartForAutoReconnect, 5000L);
        }
    }

    public boolean isScanningForAutoReconnect() {
        return this.isScanningForAutoReconnect;
    }

    public BleDeviceInfoData getAutoReconnectFtmsBleDeviceInfoData() {
        BleDeviceInfoData bleDeviceInfoData;
        synchronized (this) {
            bleDeviceInfoData = this.autoReconnectFtmsBleDeviceInfoData;
        }
        return bleDeviceInfoData;
    }

    public void setAutoReconnectFtmsBleDeviceInfoData(BleDeviceInfoData autoReconnectFtmsBleDeviceInfoData) {
        synchronized (this) {
            this.autoReconnectFtmsBleDeviceInfoData = autoReconnectFtmsBleDeviceInfoData;
        }
    }

    public BleDeviceInfoData getAutoReconnectHrBleDeviceInfoData() {
        BleDeviceInfoData bleDeviceInfoData;
        synchronized (this) {
            bleDeviceInfoData = this.autoReconnectHrBleDeviceInfoData;
        }
        return bleDeviceInfoData;
    }

    public void setAutoReconnectHrBleDeviceInfoData(BleDeviceInfoData autoReconnectHrBleDeviceInfoData) {
        synchronized (this) {
            this.autoReconnectHrBleDeviceInfoData = autoReconnectHrBleDeviceInfoData;
        }
    }

    private void registerReceiver() {
        MainActivity mainActivity;
        if (this.isRegisterGattUpdateReceiver || (mainActivity = getMyApplication().getMainActivity()) == null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BleFtmsActionType.FTMS_ACTION_GATT_CONNECTED.name());
        intentFilter.addAction(BleFtmsActionType.FTMS_ACTION_GATT_CONNECTING.name());
        intentFilter.addAction(BleFtmsActionType.FTMS_ACTION_GATT_DISCONNECTED.name());
        intentFilter.addAction(BleFtmsActionType.FTMS_ACTION_GATT_SERVICES_DISCOVERED.name());
        intentFilter.addAction(BleFtmsActionType.FTMS_ACTION_DATA_AVAILABLE.name());
        intentFilter.addAction(BleFtmsActionType.FTMS_ACTION_TRAINING_STATUS_DATA_AVAILABLE.name());
        intentFilter.addAction(BleFtmsActionType.FTMS_ACTION_FITNESS_MACHINE_STATUS_DATA_AVAILABLE.name());
        intentFilter.addAction(BleFtmsActionType.FTMS_ACTION_FITNESS_MACHINE_CONTROL_POINT_DATA_AVAILABLE.name());
        intentFilter.addAction(BleHrActionType.HR_ACTION_GATT_CONNECTED.name());
        intentFilter.addAction(BleHrActionType.HR_ACTION_GATT_CONNECTING.name());
        intentFilter.addAction(BleHrActionType.HR_ACTION_GATT_DISCONNECTED.name());
        intentFilter.addAction(BleHrActionType.HR_ACTION_GATT_SERVICES_DISCOVERED.name());
        intentFilter.addAction(BleHrActionType.HR_ACTION_DATA_AVAILABLE.name());
        ContextCompat.registerReceiver(mainActivity, this.gattUpdateReceiver, intentFilter, 1);
        this.isRegisterGattUpdateReceiver = true;
    }

    private void unRegisterService() {
        MainActivity mainActivity;
        if (this.isRegisterGattUpdateReceiver && (mainActivity = getMyApplication().getMainActivity()) != null) {
            try {
                mainActivity.unregisterReceiver(this.gattUpdateReceiver);
            } catch (Exception e) {
                Timber.e(e);
            }
            this.isRegisterGattUpdateReceiver = false;
        }
    }

    public void addBluetoothCallbackListener(BluetoothCallbackListener bluetoothCallbackListener) {
        synchronized (this.bluetoothCallbackListenerArrayList) {
            this.bluetoothCallbackListenerArrayList.add(bluetoothCallbackListener);
        }
    }

    public void removeBluetoothCallbackListener(BluetoothCallbackListener bluetoothCallbackListener) {
        synchronized (this.bluetoothCallbackListenerArrayList) {
            this.bluetoothCallbackListenerArrayList.remove(bluetoothCallbackListener);
        }
    }

    public void bleFtmsConnect(BleDeviceInfoData data, boolean isRetryConnect) {
        if (this.handlerBackground == null) {
            return;
        }
        synchronized (this) {
            this.connectFtmsBleDeviceInfoData = data;
            if (!isRetryConnect) {
                this.retryFtmsConnectCount = 0;
            }
            this.handlerBackground.removeCallbacks(this.connectFtmsBleRunnable);
            this.handlerBackground.post(this.connectFtmsBleRunnable);
        }
    }

    public void bleFtmsDisconnect() {
        BleService bleService = this.bleService;
        if (bleService != null) {
            bleService.disconnectFtms();
        }
        this.connectFtmsBleDeviceInfoData = null;
        setAutoReconnectHrBleDeviceInfoData(null);
        Handler handler = this.handlerBackground;
        if (handler != null) {
            handler.removeCallbacks(this.connectFtmsBleRunnable);
            this.handlerBackground.removeCallbacks(this.connectFtmsTimeoutRunnable);
        }
    }

    public boolean isConnectedFtms() {
        BleService bleService = this.bleService;
        if (bleService != null) {
            return bleService.isConnectedFtms();
        }
        return false;
    }

    public synchronized boolean isConnectingFtms() {
        BleService bleService = this.bleService;
        if (bleService == null) {
            return false;
        }
        return bleService.isConnectingFtms();
    }

    public int connectionStateFtms() {
        BleService bleService = this.bleService;
        if (bleService != null) {
            return bleService.connectionStateFtms();
        }
        return 0;
    }

    public synchronized BluetoothDevice getConnectedBluetoothDeviceFtms() {
        BleService bleService = this.bleService;
        if (bleService == null) {
            return null;
        }
        return bleService.getConnectedBluetoothDeviceFtms();
    }

    public synchronized FtmsDeviceManager getFtmsDeviceManager() {
        BleService bleService = this.bleService;
        if (bleService == null) {
            return null;
        }
        return bleService.getFtmsDeviceManager();
    }

    public synchronized boolean isHasAdv0x16() {
        BleService bleService = this.bleService;
        if (bleService == null) {
            return false;
        }
        return bleService.isHasAdv0x16();
    }

    public synchronized void sendCmdFtms(Data cmd) {
        if (cmd == null) {
            return;
        }
        BleService bleService = this.bleService;
        if (bleService != null) {
            bleService.sendCmdFtms(cmd, null, null, null);
        }
    }

    public synchronized void sendCmdFtms(Data cmd, final SuccessCallback successCallback, final InvalidRequestCallback invalidRequestCallback, final FailCallback failCallback) {
        if (cmd == null) {
            return;
        }
        BleService bleService = this.bleService;
        if (bleService != null) {
            bleService.sendCmdFtms(cmd, successCallback, invalidRequestCallback, failCallback);
        }
    }

    public boolean isFitnessMachineControlPoint() {
        BleService bleService = this.bleService;
        if (bleService != null) {
            return bleService.isFitnessMachineControlPoint();
        }
        return false;
    }

    public void bleHrConnect(BleDeviceInfoData data, boolean isUserConnect, boolean isRetryConnect) {
        if (this.handlerBackground == null) {
            return;
        }
        synchronized (this) {
            this.connectHrBleDeviceInfoData = data;
            this.isUserConnectHr = isUserConnect;
            if (!isRetryConnect) {
                this.retryHrConnectCount = 0;
            }
            this.handlerBackground.removeCallbacks(this.connectHrBleRunnable);
            this.handlerBackground.post(this.connectHrBleRunnable);
        }
    }

    public void bleHrDisconnect() {
        this.isUserConnectHr = false;
        BleService bleService = this.bleService;
        if (bleService != null) {
            bleService.disconnectHr();
        }
        this.connectHrBleDeviceInfoData = null;
        setAutoReconnectHrBleDeviceInfoData(null);
        Handler handler = this.handlerBackground;
        if (handler != null) {
            handler.removeCallbacks(this.connectHrBleRunnable);
            this.handlerBackground.removeCallbacks(this.connectHrTimeoutRunnable);
        }
    }

    public synchronized boolean isConnectedHr() {
        BleService bleService = this.bleService;
        if (bleService == null) {
            return false;
        }
        return bleService.isConnectedHr();
    }

    public synchronized boolean isConnectingHr() {
        BleService bleService = this.bleService;
        if (bleService == null) {
            return false;
        }
        return bleService.isConnectingHr();
    }

    public int connectionStateHr() {
        BleService bleService = this.bleService;
        if (bleService != null) {
            return bleService.connectionStateHr();
        }
        return 0;
    }

    public synchronized BluetoothDevice getConnectedBluetoothDeviceHr() {
        BleService bleService = this.bleService;
        if (bleService == null) {
            return null;
        }
        return bleService.getConnectedBluetoothDeviceHr();
    }

    public synchronized HrDeviceManager getHrDeviceManager() {
        BleService bleService = this.bleService;
        if (bleService == null) {
            return null;
        }
        return bleService.getHrDeviceManager();
    }

    public synchronized BleDeviceInfoData getConnectFtmsBleDeviceInfoData() {
        BleDeviceInfoData bleDeviceInfoData;
        synchronized (this) {
            bleDeviceInfoData = this.connectFtmsBleDeviceInfoData;
        }
        return bleDeviceInfoData;
        return bleDeviceInfoData;
    }

    public synchronized BleDeviceInfoData getConnectHrBleDeviceInfoData() {
        BleDeviceInfoData bleDeviceInfoData;
        synchronized (this) {
            bleDeviceInfoData = this.connectHrBleDeviceInfoData;
        }
        return bleDeviceInfoData;
        return bleDeviceInfoData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkSummaryTempData() {
        synchronized (this) {
            Handler handler = this.handlerBackground;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.soletreadmills.sole_v2._manager.BleManager.21
                    @Override // java.lang.Runnable
                    public void run() {
                        List<SummaryTempDataEntity> all;
                        TreadmillListData treadmillListDataObjectFromData;
                        IndoorBikeListData indoorBikeListDataObjectFromData;
                        CrossTrainerListData crossTrainerListDataObjectFromData;
                        StepClimberListData stepClimberListDataObjectFromData;
                        RowerListData rowerListDataObjectFromData;
                        if (BleManager.this.summaryTempDataDatabase == null) {
                            return;
                        }
                        try {
                            all = BleManager.this.summaryTempDataDatabase.summaryTempDataDao().getAll();
                        } catch (Exception e) {
                            Timber.e(e.fillInStackTrace());
                            all = null;
                        }
                        if (all == null || all.size() <= 0) {
                            return;
                        }
                        for (final SummaryTempDataEntity summaryTempDataEntity : all) {
                            if (!summaryTempDataEntity.getClassName().isEmpty() && !summaryTempDataEntity.getJsonData().isEmpty()) {
                                if (summaryTempDataEntity.getClassName().contains(TreadmillData.class.getName()) || summaryTempDataEntity.getClassName().contains(TreadmillListData.class.getName())) {
                                    try {
                                        treadmillListDataObjectFromData = TreadmillListData.objectFromData(summaryTempDataEntity.getJsonData());
                                    } catch (Exception e2) {
                                        Timber.e(e2.fillInStackTrace());
                                        treadmillListDataObjectFromData = null;
                                    }
                                    if (treadmillListDataObjectFromData != null && treadmillListDataObjectFromData.getTreadmillDataArrayList() != null && treadmillListDataObjectFromData.getTreadmillDataArrayList().size() > 0) {
                                        final ArrayList arrayList = new ArrayList(treadmillListDataObjectFromData.getTreadmillDataArrayList());
                                        final String clubTicket = treadmillListDataObjectFromData.getClubTicket();
                                        if (BleManager.this.handlerBackground != null) {
                                            BleManager.this.handlerBackground.post(new Runnable() { // from class: com.soletreadmills.sole_v2._manager.BleManager.21.1
                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    try {
                                                        BleManager.this.uploadSummaryDataListener.onNoticeUpload(arrayList, true, Integer.valueOf(summaryTempDataEntity.getId()), clubTicket);
                                                    } catch (Exception e3) {
                                                        Timber.e(e3);
                                                    }
                                                }
                                            });
                                        }
                                    }
                                } else if (summaryTempDataEntity.getClassName().contains(IndoorBikeData.class.getName()) || summaryTempDataEntity.getClassName().contains(IndoorBikeListData.class.getName())) {
                                    try {
                                        indoorBikeListDataObjectFromData = IndoorBikeListData.objectFromData(summaryTempDataEntity.getJsonData());
                                    } catch (Exception e3) {
                                        Timber.e(e3.fillInStackTrace());
                                        indoorBikeListDataObjectFromData = null;
                                    }
                                    if (indoorBikeListDataObjectFromData != null && indoorBikeListDataObjectFromData.getIndoorBikeDataArrayList() != null && indoorBikeListDataObjectFromData.getIndoorBikeDataArrayList().size() > 0) {
                                        final ArrayList arrayList2 = new ArrayList(indoorBikeListDataObjectFromData.getIndoorBikeDataArrayList());
                                        final String clubTicket2 = indoorBikeListDataObjectFromData.getClubTicket();
                                        if (BleManager.this.handlerBackground != null) {
                                            BleManager.this.handlerBackground.post(new Runnable() { // from class: com.soletreadmills.sole_v2._manager.BleManager.21.2
                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    try {
                                                        BleManager.this.uploadSummaryDataListener.onNoticeUpload(arrayList2, true, Integer.valueOf(summaryTempDataEntity.getId()), clubTicket2);
                                                    } catch (Exception e4) {
                                                        Timber.e(e4);
                                                    }
                                                }
                                            });
                                        }
                                    }
                                } else if (summaryTempDataEntity.getClassName().contains(CrossTrainerData.class.getName()) || summaryTempDataEntity.getClassName().contains(CrossTrainerListData.class.getName())) {
                                    try {
                                        crossTrainerListDataObjectFromData = CrossTrainerListData.objectFromData(summaryTempDataEntity.getJsonData());
                                    } catch (Exception e4) {
                                        Timber.e(e4.fillInStackTrace());
                                        crossTrainerListDataObjectFromData = null;
                                    }
                                    if (crossTrainerListDataObjectFromData != null && crossTrainerListDataObjectFromData.getCrossTrainerDataArrayList() != null && crossTrainerListDataObjectFromData.getCrossTrainerDataArrayList().size() > 0) {
                                        final ArrayList arrayList3 = new ArrayList(crossTrainerListDataObjectFromData.getCrossTrainerDataArrayList());
                                        final String clubTicket3 = crossTrainerListDataObjectFromData.getClubTicket();
                                        if (BleManager.this.handlerBackground != null) {
                                            BleManager.this.handlerBackground.post(new Runnable() { // from class: com.soletreadmills.sole_v2._manager.BleManager.21.3
                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    try {
                                                        BleManager.this.uploadSummaryDataListener.onNoticeUpload(arrayList3, true, Integer.valueOf(summaryTempDataEntity.getId()), clubTicket3);
                                                    } catch (Exception e5) {
                                                        Timber.e(e5);
                                                    }
                                                }
                                            });
                                        }
                                    }
                                } else if (summaryTempDataEntity.getClassName().contains(StepClimberData.class.getName()) || summaryTempDataEntity.getClassName().contains(StepClimberListData.class.getName())) {
                                    try {
                                        stepClimberListDataObjectFromData = StepClimberListData.objectFromData(summaryTempDataEntity.getJsonData());
                                    } catch (Exception e5) {
                                        Timber.e(e5.fillInStackTrace());
                                        stepClimberListDataObjectFromData = null;
                                    }
                                    if (stepClimberListDataObjectFromData != null && stepClimberListDataObjectFromData.getStepClimberDataArrayList() != null && stepClimberListDataObjectFromData.getStepClimberDataArrayList().size() > 0) {
                                        final ArrayList arrayList4 = new ArrayList(stepClimberListDataObjectFromData.getStepClimberDataArrayList());
                                        final String clubTicket4 = stepClimberListDataObjectFromData.getClubTicket();
                                        if (BleManager.this.handlerBackground != null) {
                                            BleManager.this.handlerBackground.post(new Runnable() { // from class: com.soletreadmills.sole_v2._manager.BleManager.21.4
                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    try {
                                                        BleManager.this.uploadSummaryDataListener.onNoticeUpload(arrayList4, true, Integer.valueOf(summaryTempDataEntity.getId()), clubTicket4);
                                                    } catch (Exception e6) {
                                                        Timber.e(e6);
                                                    }
                                                }
                                            });
                                        }
                                    }
                                } else if (summaryTempDataEntity.getClassName().contains(RowerData.class.getName()) || summaryTempDataEntity.getClassName().contains(RowerListData.class.getName())) {
                                    try {
                                        rowerListDataObjectFromData = RowerListData.objectFromData(summaryTempDataEntity.getJsonData());
                                    } catch (Exception e6) {
                                        Timber.e(e6.fillInStackTrace());
                                        rowerListDataObjectFromData = null;
                                    }
                                    if (rowerListDataObjectFromData != null && rowerListDataObjectFromData.getRowerDataArrayList() != null && rowerListDataObjectFromData.getRowerDataArrayList().size() > 0) {
                                        final ArrayList arrayList5 = new ArrayList(rowerListDataObjectFromData.getRowerDataArrayList());
                                        final String clubTicket5 = rowerListDataObjectFromData.getClubTicket();
                                        if (BleManager.this.handlerBackground != null) {
                                            BleManager.this.handlerBackground.post(new Runnable() { // from class: com.soletreadmills.sole_v2._manager.BleManager.21.5
                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    try {
                                                        BleManager.this.uploadSummaryDataListener.onNoticeUpload(arrayList5, true, Integer.valueOf(summaryTempDataEntity.getId()), clubTicket5);
                                                    } catch (Exception e7) {
                                                        Timber.e(e7);
                                                    }
                                                }
                                            });
                                        }
                                    }
                                }
                            }
                        }
                    }
                });
            }
        }
    }

    /* renamed from: com.soletreadmills.sole_v2._manager.BleManager$27, reason: invalid class name */
    static /* synthetic */ class AnonymousClass27 {
        static final /* synthetic */ int[] $SwitchMap$com$soletreadmills$sole_v2$_type$MachineType;

        static {
            int[] iArr = new int[MachineType.values().length];
            $SwitchMap$com$soletreadmills$sole_v2$_type$MachineType = iArr;
            try {
                iArr[MachineType.TREADMILL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$soletreadmills$sole_v2$_type$MachineType[MachineType.BIKE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$soletreadmills$sole_v2$_type$MachineType[MachineType.ELLIPTICAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$soletreadmills$sole_v2$_type$MachineType[MachineType.STEPPER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$soletreadmills$sole_v2$_type$MachineType[MachineType.ROWER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onUploadSuccess(boolean isFromSqlite, Integer entityId) {
        final MainActivity mainActivity = getMyApplication().getMainActivity();
        if (mainActivity != null) {
            mainActivity.runOnUiThread(new Runnable() { // from class: com.soletreadmills.sole_v2._manager.BleManager$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    Toast.makeText(mainActivity, R.string.saved_one_workout_record, 0).show();
                }
            });
        }
        if (isFromSqlite && entityId != null) {
            try {
                SummaryTempDataEntity summaryTempDataEntityFindById = this.summaryTempDataDatabase.summaryTempDataDao().findById(entityId.intValue());
                if (summaryTempDataEntityFindById != null) {
                    this.summaryTempDataDatabase.summaryTempDataDao().delete(summaryTempDataEntityFindById);
                }
            } catch (Exception e) {
                Timber.e(e.fillInStackTrace());
            }
        }
        Global.clubRaceTicket = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveSummaryTempDataIfUploadFail(List<FtmsBaseData> summaryDataList, boolean isFromSqlite, Integer entityId) {
        String name;
        if (isFromSqlite || entityId != null || summaryDataList == null || summaryDataList.isEmpty()) {
            return;
        }
        FtmsBaseData ftmsBaseData = summaryDataList.get(0);
        String json = null;
        if (ftmsBaseData instanceof TreadmillData) {
            name = TreadmillData.class.getName();
            ArrayList<TreadmillData> arrayList = new ArrayList<>();
            for (FtmsBaseData ftmsBaseData2 : summaryDataList) {
                if (ftmsBaseData2 instanceof TreadmillData) {
                    arrayList.add((TreadmillData) ftmsBaseData2);
                }
            }
            if (!arrayList.isEmpty()) {
                TreadmillListData treadmillListData = new TreadmillListData();
                treadmillListData.setTreadmillDataArrayList(arrayList);
                treadmillListData.setClubTicket(Global.clubRaceTicket);
                json = new Gson().toJson(treadmillListData);
            }
        } else if (ftmsBaseData instanceof IndoorBikeData) {
            name = IndoorBikeData.class.getName();
            ArrayList<IndoorBikeData> arrayList2 = new ArrayList<>();
            for (FtmsBaseData ftmsBaseData3 : summaryDataList) {
                if (ftmsBaseData3 instanceof IndoorBikeData) {
                    arrayList2.add((IndoorBikeData) ftmsBaseData3);
                }
            }
            if (!arrayList2.isEmpty()) {
                IndoorBikeListData indoorBikeListData = new IndoorBikeListData();
                indoorBikeListData.setIndoorBikeDataArrayList(arrayList2);
                indoorBikeListData.setClubTicket(Global.clubRaceTicket);
                json = new Gson().toJson(indoorBikeListData);
            }
        } else if (ftmsBaseData instanceof CrossTrainerData) {
            name = CrossTrainerData.class.getName();
            ArrayList<CrossTrainerData> arrayList3 = new ArrayList<>();
            for (FtmsBaseData ftmsBaseData4 : summaryDataList) {
                if (ftmsBaseData4 instanceof CrossTrainerData) {
                    arrayList3.add((CrossTrainerData) ftmsBaseData4);
                }
            }
            if (!arrayList3.isEmpty()) {
                CrossTrainerListData crossTrainerListData = new CrossTrainerListData();
                crossTrainerListData.setCrossTrainerDataArrayList(arrayList3);
                crossTrainerListData.setClubTicket(Global.clubRaceTicket);
                json = new Gson().toJson(crossTrainerListData);
            }
        } else if (ftmsBaseData instanceof StepClimberData) {
            name = StepClimberData.class.getName();
            ArrayList<StepClimberData> arrayList4 = new ArrayList<>();
            for (FtmsBaseData ftmsBaseData5 : summaryDataList) {
                if (ftmsBaseData5 instanceof StepClimberData) {
                    arrayList4.add((StepClimberData) ftmsBaseData5);
                }
            }
            if (!arrayList4.isEmpty()) {
                StepClimberListData stepClimberListData = new StepClimberListData();
                stepClimberListData.setStepClimberDataArrayList(arrayList4);
                stepClimberListData.setClubTicket(Global.clubRaceTicket);
                json = new Gson().toJson(stepClimberListData);
            }
        } else if (ftmsBaseData instanceof RowerData) {
            name = RowerData.class.getName();
            ArrayList<RowerData> arrayList5 = new ArrayList<>();
            for (FtmsBaseData ftmsBaseData6 : summaryDataList) {
                if (ftmsBaseData6 instanceof RowerData) {
                    arrayList5.add((RowerData) ftmsBaseData6);
                }
            }
            if (!arrayList5.isEmpty()) {
                RowerListData rowerListData = new RowerListData();
                rowerListData.setRowerDataArrayList(arrayList5);
                rowerListData.setClubTicket(Global.clubRaceTicket);
                json = new Gson().toJson(rowerListData);
            }
        } else {
            name = null;
        }
        if (json != null && name != null && !json.isEmpty() && !name.isEmpty()) {
            SummaryTempDataEntity summaryTempDataEntity = new SummaryTempDataEntity(json, name);
            try {
                SummaryTempDataDatabase summaryTempDataDatabase = this.summaryTempDataDatabase;
                if (summaryTempDataDatabase != null) {
                    summaryTempDataDatabase.summaryTempDataDao().insert(summaryTempDataEntity);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Global.clubRaceTicket = "";
    }

    private abstract class MyCountDownTimer extends CountDownTimer {
        private boolean isRun;

        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
            this.isRun = false;
        }

        public synchronized MyCountDownTimer start02() {
            this.isRun = true;
            start();
            return this;
        }

        public synchronized void cancel02() {
            this.isRun = false;
            cancel();
        }

        public synchronized boolean isRun() {
            return this.isRun;
        }

        public synchronized void setRun(boolean run) {
            this.isRun = run;
        }
    }

    private void registerBluetoothBondStateChangedBroadcastReceiver() {
        MainActivity mainActivity;
        if (this.isRegisterBluetoothBondStateChangedBroadcastReceiver || (mainActivity = getMyApplication().getMainActivity()) == null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.device.action.BOND_STATE_CHANGED");
        ContextCompat.registerReceiver(mainActivity, this.bluetoothBondStateChangedBroadcastReceiver, intentFilter, 1);
        this.isRegisterBluetoothBondStateChangedBroadcastReceiver = true;
    }

    private void unregisterBluetoothBondStateChangedBroadcastReceiver() {
        MainActivity mainActivity;
        if (this.isRegisterBluetoothBondStateChangedBroadcastReceiver && (mainActivity = getMyApplication().getMainActivity()) != null) {
            try {
                mainActivity.unregisterReceiver(this.bluetoothBondStateChangedBroadcastReceiver);
            } catch (Exception e) {
                Timber.e(e);
            }
            this.isRegisterBluetoothBondStateChangedBroadcastReceiver = false;
        }
    }

    private void removeBond(final String macAddress) {
        Handler handler;
        BleService bleService = this.bleService;
        if (bleService == null || bleService.bluetoothAdapter == null || (handler = this.handlerBackground) == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.soletreadmills.sole_v2._manager.BleManager.26
            @Override // java.lang.Runnable
            public void run() {
                Set<BluetoothDevice> bondedDevices;
                BluetoothDevice next;
                BleService bleService2 = BleManager.this.bleService;
                if (bleService2 == null || bleService2.bluetoothAdapter == null) {
                    return;
                }
                if ((Build.VERSION.SDK_INT >= 31 && ActivityCompat.checkSelfPermission(BleManager.this.myApplication, "android.permission.BLUETOOTH_CONNECT") != 0) || (bondedDevices = bleService2.bluetoothAdapter.getBondedDevices()) == null || bondedDevices.isEmpty()) {
                    return;
                }
                Iterator<BluetoothDevice> it = bondedDevices.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (next != null && !TextUtils.isEmpty(next.getAddress()) && next.getAddress().equals(macAddress)) {
                        break;
                    }
                }
                if (next == null) {
                    return;
                }
                try {
                } catch (Exception e) {
                    Timber.e(e.fillInStackTrace());
                }
                BleManager.this.stopScanBleDevice();
                BleManager.this.startScanBleDevice();
            }
        });
    }

    public boolean isShowAppCalculationMessage() {
        boolean z;
        synchronized (this) {
            z = this.isShowAppCalculationMessage;
        }
        return z;
    }

    public void setShowAppCalculationMessage(boolean showAppCalculationMessage) {
        synchronized (this) {
            this.isShowAppCalculationMessage = showAppCalculationMessage;
        }
    }

    public BleDeviceInfoDatabase getBleDeviceInfoDatabase() {
        return this.bleDeviceInfoDatabase;
    }

    public BleService getBleService() {
        return this.bleService;
    }

    public BluetoothConnectType getBluetoothConnectType() {
        return this.bluetoothConnectType;
    }

    public void setBluetoothConnectType(BluetoothConnectType bluetoothConnectType) {
        this.bluetoothConnectType = bluetoothConnectType;
    }

    public ArrayList<BleDeviceInfoData> getBleDeviceInfoDataList() {
        return this.bleDeviceInfoDataList;
    }
}
