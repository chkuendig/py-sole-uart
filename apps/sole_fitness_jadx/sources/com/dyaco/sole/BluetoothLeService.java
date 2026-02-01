package com.dyaco.sole;

import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.Intent;
import android.os.Binder;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import com.ua.sdk.recorder.datasource.sensor.bluetooth.GattAttributes;
import java.util.List;
import java.util.UUID;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes.dex */
public class BluetoothLeService extends Service {
    public static final String ACTION_DATA_AVAILABLE = "com.example.bluetooth.le.ACTION_DATA_AVAILABLE";
    public static final String ACTION_GATT_CONNECTED = "com.example.bluetooth.le.ACTION_GATT_CONNECTED";
    public static final String ACTION_GATT_DISCONNECTED = "com.example.bluetooth.le.ACTION_GATT_DISCONNECTED";
    public static final String ACTION_GATT_SERVICES_DISCOVERED = "com.example.bluetooth.le.ACTION_GATT_SERVICES_DISCOVERED";
    public static final String EXTRA_DATA = "com.example.bluetooth.le.EXTRA_DATA";
    private static final int STATE_CONNECTED = 2;
    private static final int STATE_CONNECTING = 1;
    private static final int STATE_DISCONNECTED = 0;
    private static final String TAG = "BluetoothLeService";
    private BluetoothAdapter mBluetoothAdapter;
    private String mBluetoothDeviceAddress;
    private BluetoothGatt mBluetoothGatt;
    private BluetoothManager mBluetoothManager;
    private OnHRConnectListener onHRConnectListener;
    public static final UUID UUID_HEART_RATE_MEASUREMENT = UUID.fromString(GattAttributes.HEART_RATE_CHARACTERISTIC);
    public static final UUID UUID_HEART_RATE = UUID.fromString(GattAttributes.HEART_RATE_SERVICE);
    private int mConnectionState = 0;
    boolean isUserDisconnect = false;
    private final BluetoothGattCallback mGattCallback = new BluetoothGattCallback() { // from class: com.dyaco.sole.BluetoothLeService.1
        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            Log.d(BluetoothLeService.TAG, "onConnectionStateChange name=" + bluetoothGatt.getDevice().getName() + " | Address" + bluetoothGatt.getDevice().getAddress() + " | status=" + i + " | newState=" + i2);
            if (i2 == 2) {
                BluetoothLeService.this.isUserDisconnect = false;
                BluetoothLeService.this.mConnectionState = 2;
                BluetoothLeService.this.broadcastUpdate(BluetoothLeService.ACTION_GATT_CONNECTED);
                Log.i(BluetoothLeService.TAG, "Connected to GATT server.");
                Log.i(BluetoothLeService.TAG, "Attempting to start service discovery:" + BluetoothLeService.this.mBluetoothGatt.discoverServices());
                if (BluetoothLeService.this.onHRConnectListener != null) {
                    BluetoothLeService.this.onHRConnectListener.isConnect();
                    return;
                }
                return;
            }
            if (i2 == 0) {
                BluetoothLeService.this.mConnectionState = 0;
                Log.i(BluetoothLeService.TAG, "Disconnected from GATT server.");
                BluetoothLeService.this.broadcastUpdate(BluetoothLeService.ACTION_GATT_DISCONNECTED);
                if (BluetoothLeService.this.onHRConnectListener != null) {
                    BluetoothLeService.this.onHRConnectListener.isDisconnect();
                    BluetoothLeService.this.onHRConnectListener.setHR(0);
                }
                BluetoothLeService.this.close();
                if (BluetoothLeService.this.isUserDisconnect || BluetoothLeService.this.mBluetoothAdapter == null) {
                    return;
                }
                if (!BluetoothLeService.this.mBluetoothAdapter.isEnabled()) {
                    BluetoothLeService.this.mBluetoothAdapter.enable();
                }
                if (BluetoothLeService.this.mBluetoothAdapter.isEnabled()) {
                    BluetoothLeService.this.mBluetoothAdapter.stopLeScan(BluetoothLeService.this.autoReConnectLeScanCallback);
                    BluetoothLeService.this.mBluetoothAdapter.startLeScan(new UUID[]{BluetoothLeService.UUID_HEART_RATE}, BluetoothLeService.this.autoReConnectLeScanCallback);
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            if (i == 0) {
                BluetoothLeService.this.broadcastUpdate(BluetoothLeService.ACTION_GATT_SERVICES_DISCOVERED);
                BluetoothGattService service = BluetoothLeService.this.mBluetoothGatt.getService(UUID.fromString(SampleGattAttributes.SERVICE_UUID));
                if (service != null) {
                    BluetoothGattCharacteristic characteristic = service.getCharacteristic(BluetoothLeService.UUID_HEART_RATE_MEASUREMENT);
                    BluetoothLeService.this.setCharacteristicNotification(characteristic, true);
                    BluetoothLeService.this.readCharacteristic(characteristic);
                    return;
                }
                return;
            }
            Log.w(BluetoothLeService.TAG, "onServicesDiscovered received: " + i);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            if (i == 0) {
                BluetoothLeService.this.broadcastUpdate(BluetoothLeService.ACTION_DATA_AVAILABLE, bluetoothGattCharacteristic);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            BluetoothLeService.this.broadcastUpdate(BluetoothLeService.ACTION_DATA_AVAILABLE, bluetoothGattCharacteristic);
        }
    };
    private final CountDownTimer noHrDataCountDownTimer = new CountDownTimer(5000, 100) { // from class: com.dyaco.sole.BluetoothLeService.2
        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            Log.d(BluetoothLeService.TAG, "noHrDataCountDownTimer millisUntilFinished=" + j);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            BluetoothLeService.this.disconnect(false);
        }
    };
    private final IBinder mBinder = new LocalBinder();
    private final BluetoothAdapter.LeScanCallback autoReConnectLeScanCallback = new BluetoothAdapter.LeScanCallback() { // from class: com.dyaco.sole.BluetoothLeService.3
        @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
        public void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
            if (TextUtils.isEmpty(BluetoothLeService.this.mBluetoothDeviceAddress) || !TextUtils.equals(bluetoothDevice.getAddress(), BluetoothLeService.this.mBluetoothDeviceAddress)) {
                return;
            }
            BluetoothLeService.this.connect(bluetoothDevice.getAddress());
            if (BluetoothLeService.this.mBluetoothAdapter != null) {
                BluetoothLeService.this.mBluetoothAdapter.stopLeScan(BluetoothLeService.this.autoReConnectLeScanCallback);
            }
        }
    };

    public interface OnHRConnectListener {
        void isConnect();

        void isDisconnect();

        void setHR(int i);
    }

    public void setOnHRConnectListener(OnHRConnectListener onHRConnectListener) {
        this.onHRConnectListener = onHRConnectListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void broadcastUpdate(String str) {
        sendBroadcast(new Intent(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void broadcastUpdate(String str, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        int i;
        Intent intent = new Intent(str);
        String str2 = TAG;
        Log.e(str2, str + "");
        if (UUID_HEART_RATE_MEASUREMENT.equals(bluetoothGattCharacteristic.getUuid())) {
            if ((bluetoothGattCharacteristic.getProperties() & 1) != 0) {
                i = 18;
                Log.d(str2, "Heart rate format UINT16.");
            } else {
                i = 17;
                Log.d(str2, "Heart rate format UINT8.");
            }
            int iIntValue = bluetoothGattCharacteristic.getIntValue(i, 1).intValue();
            Log.d(str2, String.format("Received heart rate: %d", Integer.valueOf(iIntValue)));
            this.noHrDataCountDownTimer.cancel();
            this.noHrDataCountDownTimer.start();
            this.onHRConnectListener.setHR(iIntValue);
            intent.putExtra(EXTRA_DATA, String.valueOf(iIntValue));
        } else {
            byte[] value = bluetoothGattCharacteristic.getValue();
            if (value != null && value.length > 0) {
                StringBuilder sb = new StringBuilder(value.length);
                for (byte b : value) {
                    sb.append(String.format("%02X ", Byte.valueOf(b)));
                }
                intent.putExtra(EXTRA_DATA, new String(value) + StringUtils.LF + sb.toString());
            }
        }
        sendBroadcast(intent);
    }

    public class LocalBinder extends Binder {
        public LocalBinder() {
        }

        public BluetoothLeService getService() {
            return BluetoothLeService.this;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        stopAutoReConnectLeScan();
        close();
        this.noHrDataCountDownTimer.cancel();
        return super.onUnbind(intent);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        stopAutoReConnectLeScan();
        close();
        this.noHrDataCountDownTimer.cancel();
    }

    public boolean initialize() {
        if (this.mBluetoothManager == null) {
            BluetoothManager bluetoothManager = (BluetoothManager) getSystemService("bluetooth");
            this.mBluetoothManager = bluetoothManager;
            if (bluetoothManager == null) {
                Log.e(TAG, "Unable to initialize BluetoothManager.");
                return false;
            }
        }
        BluetoothAdapter adapter = this.mBluetoothManager.getAdapter();
        this.mBluetoothAdapter = adapter;
        if (adapter != null) {
            return true;
        }
        Log.e(TAG, "Unable to obtain a BluetoothAdapter.");
        return false;
    }

    public boolean connect(String str) {
        if (this.mBluetoothAdapter == null || str == null) {
            Log.w(TAG, "BluetoothAdapter not initialized or unspecified address.");
            return false;
        }
        BluetoothGatt bluetoothGatt = this.mBluetoothGatt;
        if (bluetoothGatt != null) {
            bluetoothGatt.disconnect();
            close();
        }
        this.isUserDisconnect = false;
        String str2 = this.mBluetoothDeviceAddress;
        if (str2 != null && str.equals(str2) && this.mBluetoothGatt != null) {
            Log.d(TAG, "Trying to use an existing mBluetoothGatt for connection.");
            if (!this.mBluetoothGatt.connect()) {
                return false;
            }
            this.mConnectionState = 1;
            return true;
        }
        BluetoothDevice remoteDevice = this.mBluetoothAdapter.getRemoteDevice(str);
        if (remoteDevice == null) {
            Log.w(TAG, "Device not found.  Unable to connect.");
            return false;
        }
        this.mBluetoothGatt = remoteDevice.connectGatt(this, false, this.mGattCallback);
        Log.d(TAG, "Trying to create a new connection.");
        this.mBluetoothDeviceAddress = str;
        this.mConnectionState = 1;
        return true;
    }

    public void disconnect(boolean z) {
        BluetoothGatt bluetoothGatt;
        OnHRConnectListener onHRConnectListener = this.onHRConnectListener;
        if (onHRConnectListener != null) {
            onHRConnectListener.isDisconnect();
        }
        this.isUserDisconnect = z;
        if (this.mBluetoothAdapter == null || (bluetoothGatt = this.mBluetoothGatt) == null) {
            Log.w(TAG, "BluetoothAdapter not initialized");
        } else {
            bluetoothGatt.disconnect();
        }
    }

    public void close() {
        OnHRConnectListener onHRConnectListener = this.onHRConnectListener;
        if (onHRConnectListener != null) {
            onHRConnectListener.isDisconnect();
        }
        BluetoothGatt bluetoothGatt = this.mBluetoothGatt;
        if (bluetoothGatt == null) {
            return;
        }
        bluetoothGatt.close();
        this.mBluetoothGatt = null;
    }

    public void readCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        BluetoothGatt bluetoothGatt;
        if (this.mBluetoothAdapter == null || (bluetoothGatt = this.mBluetoothGatt) == null) {
            Log.w(TAG, "BluetoothAdapter not initialized");
        } else {
            bluetoothGatt.readCharacteristic(bluetoothGattCharacteristic);
        }
    }

    public void setCharacteristicNotification(BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z) {
        BluetoothGatt bluetoothGatt;
        if (this.mBluetoothAdapter == null || (bluetoothGatt = this.mBluetoothGatt) == null) {
            Log.w(TAG, "BluetoothAdapter not initialized");
            return;
        }
        bluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, z);
        if (UUID_HEART_RATE_MEASUREMENT.equals(bluetoothGattCharacteristic.getUuid())) {
            BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(UUID.fromString(SampleGattAttributes.CLIENT_CHARACTERISTIC_CONFIG));
            descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
            this.mBluetoothGatt.writeDescriptor(descriptor);
        }
    }

    public List<BluetoothGattService> getSupportedGattServices() {
        BluetoothGatt bluetoothGatt = this.mBluetoothGatt;
        if (bluetoothGatt == null) {
            return null;
        }
        return bluetoothGatt.getServices();
    }

    public BluetoothGatt getmBluetoothGatt() {
        return this.mBluetoothGatt;
    }

    public boolean isConnected() {
        BluetoothManager bluetoothManager;
        BluetoothGatt bluetoothGatt = this.mBluetoothGatt;
        return (bluetoothGatt == null || (bluetoothManager = this.mBluetoothManager) == null || bluetoothManager.getConnectionState(bluetoothGatt.getDevice(), 7) != 2) ? false : true;
    }

    public void stopAutoReConnectLeScan() {
        BluetoothAdapter bluetoothAdapter = this.mBluetoothAdapter;
        if (bluetoothAdapter != null) {
            bluetoothAdapter.stopLeScan(this.autoReConnectLeScanCallback);
        }
    }
}
