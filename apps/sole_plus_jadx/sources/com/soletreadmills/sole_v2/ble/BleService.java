package com.soletreadmills.sole_v2.ble;

import android.app.Notification;
import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.app.NotificationChannelCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2.ble.manager.BleDataManager;
import com.soletreadmills.sole_v2.ble.manager.FtmsDeviceManager;
import com.soletreadmills.sole_v2.ble.manager.HrDeviceManager;
import com.soletreadmills.sole_v2.ble.type.BleFtmsMachineType;
import no.nordicsemi.android.ble.callback.FailCallback;
import no.nordicsemi.android.ble.callback.InvalidRequestCallback;
import no.nordicsemi.android.ble.callback.SuccessCallback;
import no.nordicsemi.android.ble.data.Data;
import timber.log.Timber;

/* loaded from: classes5.dex */
public class BleService extends Service {
    private static final String TAG = "BleService";
    public BluetoothAdapter bluetoothAdapter;
    public BluetoothManager bluetoothManager;
    private final IBinder binder = new LocalBinder();
    private FtmsDeviceManager ftmsDeviceManager = null;
    private HrDeviceManager hrDeviceManager = null;
    private Handler mainHandler = null;
    private HandlerThread workHandlerThread = null;
    private Handler workHandler = null;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        synchronized (this) {
            Timber.d("onCreate", new Object[0]);
            if (Build.VERSION.SDK_INT >= 34) {
                if (ContextCompat.checkSelfPermission(this, "android.permission.BLUETOOTH_CONNECT") == 0 || ContextCompat.checkSelfPermission(this, "android.permission.BLUETOOTH_SCAN") == 0) {
                    startForeground(1, createForegroundNotification(), 16);
                }
            } else if (Build.VERSION.SDK_INT >= 29) {
                startForeground(1, createForegroundNotification(), 16);
            } else {
                startForeground(1, createForegroundNotification());
            }
            BleDataManager.getInstance().onCreate();
            this.mainHandler = new Handler(Looper.getMainLooper());
            HandlerThread handlerThread = new HandlerThread(TAG + "WorkHandlerThread");
            this.workHandlerThread = handlerThread;
            handlerThread.start();
            this.workHandler = new Handler(this.workHandlerThread.getLooper());
            if (initialize()) {
                setHrDeviceManager(new HrDeviceManager(getApplication(), this.workHandler));
                setFtmsDeviceManager(new FtmsDeviceManager(getApplication(), this.workHandler));
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        Timber.d("onBind", new Object[0]);
        return this.binder;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        Timber.d("onStartCommand", new Object[0]);
        return 2;
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        super.onRebind(intent);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        Timber.d("onUnbind", new Object[0]);
        disconnectFtms();
        disconnectHr();
        return super.onUnbind(intent);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        synchronized (this) {
            Timber.d("onDestroy", new Object[0]);
            Handler handler = this.mainHandler;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.mainHandler = null;
            BleDataManager.getInstance().onDestroy();
            disconnectFtms();
            disconnectHr();
            Handler handler2 = this.workHandler;
            if (handler2 != null) {
                handler2.removeCallbacksAndMessages(null);
            }
            this.workHandler = null;
        }
    }

    private boolean initialize() {
        synchronized (this) {
            if (this.bluetoothManager == null) {
                BluetoothManager bluetoothManager = (BluetoothManager) getSystemService("bluetooth");
                this.bluetoothManager = bluetoothManager;
                if (bluetoothManager == null) {
                    Timber.e("Unable to initialize BluetoothManager.", new Object[0]);
                    return false;
                }
            }
            BluetoothAdapter adapter = this.bluetoothManager.getAdapter();
            this.bluetoothAdapter = adapter;
            if (adapter != null) {
                return true;
            }
            Timber.e("Unable to obtain a BluetoothAdapter.", new Object[0]);
            return false;
        }
    }

    public synchronized void connectFtms(final String macAdd, String name, final BleFtmsMachineType bleFtmsMachineType, final boolean isHasAdv0x16, final double userWeightKg, final boolean isFemale, final InvalidRequestCallback invalidRequestCallback, final FailCallback failCallback) {
        BluetoothAdapter bluetoothAdapter = this.bluetoothAdapter;
        if (bluetoothAdapter != null) {
            try {
                BluetoothDevice remoteDevice = bluetoothAdapter.getRemoteDevice(macAdd);
                if (remoteDevice != null) {
                    connectFtms(remoteDevice, name, bleFtmsMachineType, isHasAdv0x16, userWeightKg, isFemale, invalidRequestCallback, failCallback);
                }
            } catch (Exception e) {
                Timber.e(e);
            }
        }
    }

    public synchronized void connectFtms(final BluetoothDevice bluetoothDevice, String name, BleFtmsMachineType bleFtmsMachineType, final boolean isHasAdv0x16, final double userWeightKg, final boolean isFemale, final InvalidRequestCallback invalidRequestCallback, final FailCallback failCallback) {
        BluetoothDevice bluetoothDevice2;
        synchronized (this) {
            FtmsDeviceManager ftmsDeviceManager = getFtmsDeviceManager();
            if (ftmsDeviceManager != null && (ftmsDeviceManager.getConnectionState() == 1 || ftmsDeviceManager.getConnectionState() == 3)) {
                invalidRequestCallback.onInvalidRequest();
                return;
            }
            Timber.d("connectFtms 01", new Object[0]);
            if (bluetoothDevice.getAddress() != null && bluetoothDevice.getAddress().length() > 0) {
                Timber.d("connectFtms 02", new Object[0]);
                if (ftmsDeviceManager != null && ftmsDeviceManager.isConnected() && (bluetoothDevice2 = ftmsDeviceManager.getBluetoothDevice()) != null && TextUtils.equals(bluetoothDevice2.getAddress(), bluetoothDevice.getAddress())) {
                    invalidRequestCallback.onInvalidRequest();
                    return;
                }
                Timber.d("connectFtms 03", new Object[0]);
                Handler handler = this.workHandler;
                if (handler == null) {
                    invalidRequestCallback.onInvalidRequest();
                    return;
                }
                Timber.d("connectFtms 04", new Object[0]);
                disconnectFtms();
                FtmsDeviceManager ftmsDeviceManager2 = new FtmsDeviceManager(getApplication(), handler);
                setFtmsDeviceManager(ftmsDeviceManager2);
                ftmsDeviceManager2.setBleFtmsMachineType(bleFtmsMachineType);
                ftmsDeviceManager2.setHasAdv0x16(isHasAdv0x16);
                ftmsDeviceManager2.setUserWeightKg(userWeightKg);
                ftmsDeviceManager2.setFemale(isFemale);
                if (!TextUtils.isEmpty(name)) {
                    ftmsDeviceManager2.setBluetoothDeviceName(name);
                }
                ftmsDeviceManager2.connect(bluetoothDevice).retry(10, 1000).timeout(10000L).useAutoConnect(false).invalid(invalidRequestCallback).fail(failCallback).enqueue();
                return;
            }
            invalidRequestCallback.onInvalidRequest();
        }
    }

    public synchronized void disconnectFtms() {
        synchronized (this) {
            FtmsDeviceManager ftmsDeviceManager = getFtmsDeviceManager();
            if (ftmsDeviceManager != null && (ftmsDeviceManager.getConnectionState() == 1 || ftmsDeviceManager.getConnectionState() == 2)) {
                ftmsDeviceManager.disconnect().enqueue();
            }
        }
    }

    public synchronized BluetoothDevice getConnectedBluetoothDeviceFtms() {
        synchronized (this) {
            FtmsDeviceManager ftmsDeviceManager = getFtmsDeviceManager();
            if (ftmsDeviceManager == null) {
                return null;
            }
            return ftmsDeviceManager.getBluetoothDevice();
        }
    }

    public boolean isConnectedFtms() {
        synchronized (this) {
            FtmsDeviceManager ftmsDeviceManager = getFtmsDeviceManager();
            if (ftmsDeviceManager == null) {
                return false;
            }
            return ftmsDeviceManager.isConnected();
        }
    }

    public synchronized boolean isConnectingFtms() {
        boolean z;
        synchronized (this) {
            z = true;
            if (connectionStateFtms() != 1) {
                z = false;
            }
        }
        return z;
        return z;
    }

    public int connectionStateFtms() {
        synchronized (this) {
            FtmsDeviceManager ftmsDeviceManager = getFtmsDeviceManager();
            if (ftmsDeviceManager == null) {
                return 0;
            }
            return ftmsDeviceManager.getConnectionState();
        }
    }

    public synchronized int getDisconnectedReasonFtms() {
        synchronized (this) {
            FtmsDeviceManager ftmsDeviceManager = getFtmsDeviceManager();
            if (ftmsDeviceManager == null) {
                return -1;
            }
            return ftmsDeviceManager.getDisconnectedReason();
        }
    }

    public boolean isFitnessMachineControlPoint() {
        synchronized (this) {
            FtmsDeviceManager ftmsDeviceManager = getFtmsDeviceManager();
            if (ftmsDeviceManager == null) {
                return false;
            }
            return ftmsDeviceManager.isFitnessMachineControlPoint();
        }
    }

    public void sendCmdFtms(final Data cmd, final SuccessCallback successCallback, final InvalidRequestCallback invalidRequestCallback, final FailCallback failCallback) {
        synchronized (this) {
            FtmsDeviceManager ftmsDeviceManager = getFtmsDeviceManager();
            if (ftmsDeviceManager != null) {
                ftmsDeviceManager.sendCmd(cmd, successCallback, null, invalidRequestCallback, failCallback);
            }
        }
    }

    public boolean isHasAdv0x16() {
        synchronized (this) {
            FtmsDeviceManager ftmsDeviceManager = getFtmsDeviceManager();
            if (ftmsDeviceManager == null) {
                return false;
            }
            return ftmsDeviceManager.isHasAdv0x16();
        }
    }

    public class LocalBinder extends Binder {
        public LocalBinder() {
        }

        public BleService getService() {
            return BleService.this;
        }
    }

    public synchronized void connectHr(final String macAdd, final String name, final InvalidRequestCallback invalidRequestCallback, final FailCallback failCallback) {
        BluetoothAdapter bluetoothAdapter = this.bluetoothAdapter;
        if (bluetoothAdapter != null) {
            try {
                BluetoothDevice remoteDevice = bluetoothAdapter.getRemoteDevice(macAdd);
                if (remoteDevice != null) {
                    connectHr(remoteDevice, name, invalidRequestCallback, failCallback);
                }
            } catch (Exception e) {
                Timber.e(e);
            }
        }
    }

    public synchronized void connectHr(final BluetoothDevice bluetoothDevice, final String name, final InvalidRequestCallback invalidRequestCallback, final FailCallback failCallback) {
        BluetoothDevice bluetoothDevice2;
        synchronized (this) {
            HrDeviceManager hrDeviceManager = getHrDeviceManager();
            if (hrDeviceManager != null && (hrDeviceManager.getConnectionState() == 1 || hrDeviceManager.getConnectionState() == 3)) {
                invalidRequestCallback.onInvalidRequest();
                return;
            }
            if (bluetoothDevice.getAddress() != null && bluetoothDevice.getAddress().length() > 0) {
                if (hrDeviceManager != null && hrDeviceManager.isConnected() && (bluetoothDevice2 = hrDeviceManager.getBluetoothDevice()) != null && TextUtils.equals(bluetoothDevice2.getAddress(), bluetoothDevice.getAddress())) {
                    invalidRequestCallback.onInvalidRequest();
                    return;
                }
                Handler handler = this.workHandler;
                if (handler == null) {
                    invalidRequestCallback.onInvalidRequest();
                    return;
                }
                disconnectHr();
                HrDeviceManager hrDeviceManager2 = new HrDeviceManager(getApplication(), handler);
                setHrDeviceManager(hrDeviceManager2);
                hrDeviceManager2.setBluetoothDeviceName(name);
                hrDeviceManager2.connect(bluetoothDevice).retry(10, 1000).timeout(10000L).useAutoConnect(false).invalid(invalidRequestCallback).fail(failCallback).enqueue();
                return;
            }
            invalidRequestCallback.onInvalidRequest();
        }
    }

    public synchronized void disconnectHr() {
        synchronized (this) {
            HrDeviceManager hrDeviceManager = getHrDeviceManager();
            if (hrDeviceManager != null && (hrDeviceManager.getConnectionState() == 1 || hrDeviceManager.getConnectionState() == 2)) {
                hrDeviceManager.disconnect().enqueue();
            }
        }
    }

    public synchronized boolean isConnectedHr() {
        synchronized (this) {
            HrDeviceManager hrDeviceManager = getHrDeviceManager();
            if (hrDeviceManager == null) {
                return false;
            }
            return hrDeviceManager.isConnected();
        }
    }

    public synchronized boolean isConnectingHr() {
        boolean z;
        synchronized (this) {
            z = true;
            if (connectionStateHr() != 1) {
                z = false;
            }
        }
        return z;
        return z;
    }

    public int connectionStateHr() {
        synchronized (this) {
            HrDeviceManager hrDeviceManager = getHrDeviceManager();
            if (hrDeviceManager == null) {
                return 0;
            }
            return hrDeviceManager.getConnectionState();
        }
    }

    public synchronized BluetoothDevice getConnectedBluetoothDeviceHr() {
        synchronized (this) {
            HrDeviceManager hrDeviceManager = getHrDeviceManager();
            if (hrDeviceManager == null) {
                return null;
            }
            return hrDeviceManager.getBluetoothDevice();
        }
    }

    public synchronized int getDisconnectedReasonHr() {
        synchronized (this) {
            HrDeviceManager hrDeviceManager = getHrDeviceManager();
            if (hrDeviceManager == null) {
                return -1;
            }
            return hrDeviceManager.getDisconnectedReason();
        }
    }

    private Notification createForegroundNotification() {
        NotificationManagerCompat notificationManagerCompatFrom = NotificationManagerCompat.from(this);
        String str = getPackageName() + "ble_service_notification_channel_id";
        notificationManagerCompatFrom.createNotificationChannel(new NotificationChannelCompat.Builder(str, 2).setName("BleService").build());
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, str);
        builder.setSmallIcon(R.drawable.sole);
        builder.setColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPalette_red));
        builder.setContentTitle(getString(R.string.sole_ble_notify));
        builder.setContentText("Bluetooth foreground services");
        builder.setWhen(System.currentTimeMillis());
        builder.setVisibility(0);
        builder.setOngoing(true);
        return builder.build();
    }

    public void setFtmsDeviceManager(FtmsDeviceManager ftmsDeviceManager) {
        synchronized (this) {
            disconnectFtms();
            this.ftmsDeviceManager = ftmsDeviceManager;
        }
    }

    public FtmsDeviceManager getFtmsDeviceManager() {
        FtmsDeviceManager ftmsDeviceManager;
        synchronized (this) {
            ftmsDeviceManager = this.ftmsDeviceManager;
        }
        return ftmsDeviceManager;
    }

    public HrDeviceManager getHrDeviceManager() {
        HrDeviceManager hrDeviceManager;
        synchronized (this) {
            hrDeviceManager = this.hrDeviceManager;
        }
        return hrDeviceManager;
    }

    public void setHrDeviceManager(HrDeviceManager hrDeviceManager) {
        synchronized (this) {
            disconnectHr();
            this.hrDeviceManager = hrDeviceManager;
        }
    }
}
