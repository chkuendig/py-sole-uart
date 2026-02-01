package com.dyaco.ideabussdk_sole.bluetooth;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.facebook.appevents.AppEventsConstants;
import com.mapbox.mapboxsdk.util.constants.UtilConstants;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

/* loaded from: classes.dex */
public class MyBluetoothClassic {
    private static final UUID MY_UUID_SECURE = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    private static final String TAG = "MyBluetoothClassic";
    private static MyBluetoothClassic myBluetoothClassic;
    private Context context;
    private Handler hd;
    private boolean isReceiveStatus;
    private boolean isRunning;
    private boolean isScanning;
    private BluetoothAdapter mBluetoothAdapter;
    public int mConnectState;
    private ConnectThread mConnectThread;
    private ConnectedThread mConnectedThread;
    public OnConnectStateListener mOnConnectStateListener;
    private BroadcastReceiver mReceiver;

    public interface OnConnectStateListener {
        void connectionStatus(int i);

        void dataResult(String str);

        void onBtStateChanged(boolean z);

        void scanResult(BluetoothDevice bluetoothDevice, int i);
    }

    public void setOnConnectStateListener(OnConnectStateListener onConnectStateListener) {
        this.mOnConnectStateListener = onConnectStateListener;
    }

    public static MyBluetoothClassic getInstance(Context context) {
        if (myBluetoothClassic == null) {
            myBluetoothClassic = new MyBluetoothClassic(context);
        }
        return myBluetoothClassic;
    }

    private MyBluetoothClassic() {
        this.isReceiveStatus = false;
        this.hd = new Handler() { // from class: com.dyaco.ideabussdk_sole.bluetooth.MyBluetoothClassic.1
            @Override // android.os.Handler
            public void handleMessage(Message message) throws IOException {
                int i = message.what;
                if (i == 1) {
                    Log.e(MyBluetoothClassic.TAG, "連接 Timeout~~~~~~");
                    MyBluetoothClassic.this.mConnectState = 20;
                    MyBluetoothClassic.this.mOnConnectStateListener.connectionStatus(MyBluetoothClassic.this.mConnectState);
                    if (MyBluetoothClassic.this.mConnectThread != null) {
                        MyBluetoothClassic.this.mConnectThread.reset();
                    }
                    return;
                }
                if (i == 2) {
                    MyBluetoothClassic.this.stopScan();
                    return;
                }
                switch (i) {
                    case 10:
                        MyBluetoothClassic.this.mConnectState = 18;
                        MyBluetoothClassic.this.mOnConnectStateListener.connectionStatus(MyBluetoothClassic.this.mConnectState);
                        break;
                    case 11:
                        MyBluetoothClassic.this.mConnectState = 17;
                        MyBluetoothClassic.this.mOnConnectStateListener.connectionStatus(MyBluetoothClassic.this.mConnectState);
                        break;
                    case 12:
                        MyBluetoothClassic.this.mOnConnectStateListener.dataResult((String) message.obj);
                        break;
                }
            }
        };
        this.mReceiver = new BroadcastReceiver() { // from class: com.dyaco.ideabussdk_sole.bluetooth.MyBluetoothClassic.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                Log.e(MyBluetoothClassic.TAG, "action = " + action);
                if (action.equals("android.bluetooth.device.action.FOUND")) {
                    BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                    String name = bluetoothDevice.getName();
                    String address = bluetoothDevice.getAddress();
                    Log.d(MyBluetoothClassic.TAG, "BT:搜索 -> deviceName = " + name + " , deviceAddress = " + address);
                    if (name != null) {
                        name.equals("");
                    }
                    if (address == null || address.equals("")) {
                        return;
                    }
                    MyBluetoothClassic.this.mOnConnectStateListener.scanResult(bluetoothDevice, intent.getExtras().getShort("android.bluetooth.device.extra.RSSI"));
                    return;
                }
                if (action.equals("android.bluetooth.adapter.action.DISCOVERY_FINISHED")) {
                    Log.d(MyBluetoothClassic.TAG, "BT:搜索完成");
                    MyBluetoothClassic.this.isScanning = false;
                    MyBluetoothClassic.this.mConnectState = 4;
                    MyBluetoothClassic.this.mOnConnectStateListener.connectionStatus(MyBluetoothClassic.this.mConnectState);
                    return;
                }
                if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(action)) {
                    MyBluetoothClassic.this.mOnConnectStateListener.onBtStateChanged(intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1) == 12);
                }
            }
        };
    }

    private MyBluetoothClassic(Context context) {
        this.isReceiveStatus = false;
        this.hd = new Handler() { // from class: com.dyaco.ideabussdk_sole.bluetooth.MyBluetoothClassic.1
            @Override // android.os.Handler
            public void handleMessage(Message message) throws IOException {
                int i = message.what;
                if (i == 1) {
                    Log.e(MyBluetoothClassic.TAG, "連接 Timeout~~~~~~");
                    MyBluetoothClassic.this.mConnectState = 20;
                    MyBluetoothClassic.this.mOnConnectStateListener.connectionStatus(MyBluetoothClassic.this.mConnectState);
                    if (MyBluetoothClassic.this.mConnectThread != null) {
                        MyBluetoothClassic.this.mConnectThread.reset();
                    }
                    return;
                }
                if (i == 2) {
                    MyBluetoothClassic.this.stopScan();
                    return;
                }
                switch (i) {
                    case 10:
                        MyBluetoothClassic.this.mConnectState = 18;
                        MyBluetoothClassic.this.mOnConnectStateListener.connectionStatus(MyBluetoothClassic.this.mConnectState);
                        break;
                    case 11:
                        MyBluetoothClassic.this.mConnectState = 17;
                        MyBluetoothClassic.this.mOnConnectStateListener.connectionStatus(MyBluetoothClassic.this.mConnectState);
                        break;
                    case 12:
                        MyBluetoothClassic.this.mOnConnectStateListener.dataResult((String) message.obj);
                        break;
                }
            }
        };
        this.mReceiver = new BroadcastReceiver() { // from class: com.dyaco.ideabussdk_sole.bluetooth.MyBluetoothClassic.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                String action = intent.getAction();
                Log.e(MyBluetoothClassic.TAG, "action = " + action);
                if (action.equals("android.bluetooth.device.action.FOUND")) {
                    BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                    String name = bluetoothDevice.getName();
                    String address = bluetoothDevice.getAddress();
                    Log.d(MyBluetoothClassic.TAG, "BT:搜索 -> deviceName = " + name + " , deviceAddress = " + address);
                    if (name != null) {
                        name.equals("");
                    }
                    if (address == null || address.equals("")) {
                        return;
                    }
                    MyBluetoothClassic.this.mOnConnectStateListener.scanResult(bluetoothDevice, intent.getExtras().getShort("android.bluetooth.device.extra.RSSI"));
                    return;
                }
                if (action.equals("android.bluetooth.adapter.action.DISCOVERY_FINISHED")) {
                    Log.d(MyBluetoothClassic.TAG, "BT:搜索完成");
                    MyBluetoothClassic.this.isScanning = false;
                    MyBluetoothClassic.this.mConnectState = 4;
                    MyBluetoothClassic.this.mOnConnectStateListener.connectionStatus(MyBluetoothClassic.this.mConnectState);
                    return;
                }
                if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(action)) {
                    MyBluetoothClassic.this.mOnConnectStateListener.onBtStateChanged(intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1) == 12);
                }
            }
        };
        this.context = context;
        this.mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        this.isRunning = true;
    }

    public boolean isScanning() {
        return this.isScanning;
    }

    public boolean isConnected() {
        return this.mConnectState == 17;
    }

    public void unregisterReceiver() {
        Log.d(TAG, "Method:unregisterReceiver");
        Handler handler = this.hd;
        if (handler != null) {
            handler.removeMessages(0);
            this.hd.removeMessages(1);
        }
        if (this.isReceiveStatus) {
            try {
                this.context.unregisterReceiver(this.mReceiver);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
            this.isReceiveStatus = false;
        }
    }

    public boolean enableBluetooth() {
        if (this.mBluetoothAdapter == null) {
            return false;
        }
        Log.d(TAG, "openHardware() isEnabled() = " + this.mBluetoothAdapter.isEnabled());
        if (!this.mBluetoothAdapter.isEnabled()) {
            ((Activity) this.context).startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 1);
        }
        return true;
    }

    public void startScan() {
        String str = TAG;
        Log.d(str, "Method:startScan");
        stopScan();
        if (!this.isReceiveStatus) {
            IntentFilter intentFilter = new IntentFilter("android.bluetooth.device.action.FOUND");
            intentFilter.addAction("android.bluetooth.adapter.action.SCAN_MODE_CHANGED");
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
            this.context.registerReceiver(this.mReceiver, intentFilter);
            this.isReceiveStatus = true;
            Log.d(str, "Method:registerReceiver = ACTION_FOUND");
        }
        this.isScanning = true;
        this.hd.sendEmptyMessageDelayed(2, 8000L);
        this.isScanning = true;
        this.mBluetoothAdapter.startDiscovery();
    }

    public void stopScan() {
        unregisterReceiver();
        if (this.isScanning) {
            this.isScanning = false;
            BluetoothAdapter bluetoothAdapter = this.mBluetoothAdapter;
            if (bluetoothAdapter == null || !bluetoothAdapter.isDiscovering()) {
                return;
            }
            this.mBluetoothAdapter.cancelDiscovery();
        }
    }

    public void connect(BluetoothDevice bluetoothDevice) throws IOException {
        stopScan();
        startConnect(bluetoothDevice);
    }

    public void disconnect() throws IOException {
        Log.d(TAG, "disconnect----");
        Handler handler = this.hd;
        if (handler != null) {
            handler.removeMessages(0);
            this.hd.removeMessages(1);
        }
        BluetoothAdapter bluetoothAdapter = this.mBluetoothAdapter;
        if (bluetoothAdapter != null && bluetoothAdapter.isDiscovering()) {
            this.mBluetoothAdapter.cancelDiscovery();
        }
        ConnectThread connectThread = this.mConnectThread;
        if (connectThread != null) {
            connectThread.cancel();
            this.mConnectThread = null;
        }
        ConnectedThread connectedThread = this.mConnectedThread;
        if (connectedThread != null) {
            this.isRunning = false;
            connectedThread.cancel();
            this.mConnectedThread = null;
        }
    }

    public void writeMessage(final String str) throws IOException {
        Log.d(TAG, "App:" + str);
        int length = str.length();
        byte[] bArr = new byte[length];
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i + 2;
            bArr[i2] = (byte) Integer.parseInt(str.substring(i, i3), 16);
            i2++;
            i = i3;
        }
        Log.d(TAG, "writeMessage:" + this.mConnectedThread);
        ConnectedThread connectedThread = this.mConnectedThread;
        if (connectedThread == null) {
            new Timer().schedule(new TimerTask() { // from class: com.dyaco.ideabussdk_sole.bluetooth.MyBluetoothClassic.3
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() throws IOException {
                    MyBluetoothClassic.this.writeMessage(str);
                }
            }, 500L);
        } else {
            connectedThread.write(bArr);
        }
    }

    public void receive(String str) {
        Log.d(TAG, "MCU:" + str);
        Message message = new Message();
        message.what = 12;
        message.obj = str;
        this.hd.sendMessage(message);
    }

    public void startConnect(BluetoothDevice bluetoothDevice) throws IOException {
        Log.d(TAG, "startConnect----");
        BluetoothAdapter bluetoothAdapter = this.mBluetoothAdapter;
        if (bluetoothAdapter != null && bluetoothAdapter.isDiscovering()) {
            this.mBluetoothAdapter.cancelDiscovery();
        }
        this.isRunning = true;
        ConnectThread connectThread = this.mConnectThread;
        if (connectThread != null) {
            connectThread.cancel();
            this.mConnectThread = null;
        }
        ConnectedThread connectedThread = this.mConnectedThread;
        if (connectedThread != null) {
            connectedThread.cancel();
            this.mConnectedThread = null;
        }
        if (bluetoothDevice == null) {
            return;
        }
        ConnectThread connectThread2 = new ConnectThread(bluetoothDevice);
        this.mConnectThread = connectThread2;
        connectThread2.start();
    }

    private class ConnectThread extends Thread {
        private BluetoothSocket cwjSocket;
        private BluetoothDevice device;

        public ConnectThread(BluetoothDevice bluetoothDevice) {
            this.device = bluetoothDevice;
        }

        public void reset() throws IOException {
            try {
                BluetoothSocket bluetoothSocket = this.cwjSocket;
                if (bluetoothSocket != null) {
                    bluetoothSocket.close();
                    this.cwjSocket = null;
                }
                MyBluetoothClassic.this.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x003a  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x00a3  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00e4  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x003e A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() throws InterruptedException, IOException {
            BluetoothSocket bluetoothSocketCreateRfcommSocketToServiceRecord;
            BluetoothSocket bluetoothSocket;
            Exception e;
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            MyBluetoothClassic.this.hd.sendEmptyMessageDelayed(1, UtilConstants.GPS_WAIT_TIME);
            try {
                bluetoothSocketCreateRfcommSocketToServiceRecord = this.device.createRfcommSocketToServiceRecord(MyBluetoothClassic.MY_UUID_SECURE);
            } catch (IOException e3) {
                e = e3;
                bluetoothSocketCreateRfcommSocketToServiceRecord = null;
            }
            try {
                Log.d(MyBluetoothClassic.TAG, "客戶端創建-用一般方法");
            } catch (IOException e4) {
                e = e4;
                e.printStackTrace();
                this.cwjSocket = bluetoothSocketCreateRfcommSocketToServiceRecord;
                if (bluetoothSocketCreateRfcommSocketToServiceRecord != null) {
                }
            }
            this.cwjSocket = bluetoothSocketCreateRfcommSocketToServiceRecord;
            if (bluetoothSocketCreateRfcommSocketToServiceRecord != null) {
                connectFailed();
                return;
            }
            try {
                bluetoothSocketCreateRfcommSocketToServiceRecord.connect();
                Log.d(MyBluetoothClassic.TAG, "客戶端連線");
            } catch (IOException e5) {
                e5.printStackTrace();
                if (MyBluetoothClassic.this.mConnectThread != null) {
                    try {
                        Log.d(MyBluetoothClassic.TAG, "客戶端創建-用反射機制");
                        bluetoothSocket = (BluetoothSocket) this.device.getClass().getMethod("createRfcommSocket", Integer.TYPE).invoke(this.device, 1);
                    } catch (Exception e6) {
                        bluetoothSocket = bluetoothSocketCreateRfcommSocketToServiceRecord;
                        e = e6;
                    }
                    try {
                        try {
                            bluetoothSocket.connect();
                        } catch (Exception e7) {
                            e = e7;
                            e.printStackTrace();
                            this.cwjSocket = bluetoothSocket;
                            bluetoothSocket.connect();
                            Log.d(MyBluetoothClassic.TAG, "客戶端連線");
                            if (this.cwjSocket == null) {
                            }
                        }
                        bluetoothSocket.connect();
                        Log.d(MyBluetoothClassic.TAG, "客戶端連線");
                    } catch (IOException e8) {
                        e8.printStackTrace();
                        try {
                            BluetoothSocket bluetoothSocket2 = this.cwjSocket;
                            if (bluetoothSocket2 != null) {
                                bluetoothSocket2.close();
                                this.cwjSocket = null;
                            }
                            Log.d(MyBluetoothClassic.TAG, "客戶端關閉");
                        } catch (IOException e9) {
                            e9.printStackTrace();
                        }
                        connectFailed();
                        e8.printStackTrace();
                        return;
                    }
                    this.cwjSocket = bluetoothSocket;
                } else {
                    connectFailed();
                    return;
                }
            }
            if (this.cwjSocket == null) {
                Log.d(MyBluetoothClassic.TAG, "連線成功");
                MyBluetoothClassic.this.hd.removeMessages(1);
                MyBluetoothClassic.this.hd.removeMessages(10);
                MyBluetoothClassic.this.hd.sendEmptyMessage(11);
                MyBluetoothClassic.this.mConnectedThread = MyBluetoothClassic.this.new ConnectedThread(this.cwjSocket);
                MyBluetoothClassic.this.mConnectedThread.start();
                return;
            }
            connectFailed();
        }

        public void cancel() throws IOException {
            try {
                BluetoothSocket bluetoothSocket = this.cwjSocket;
                if (bluetoothSocket != null) {
                    bluetoothSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void connectFailed() {
            MyBluetoothClassic.this.hd.removeMessages(1);
            MyBluetoothClassic.this.hd.sendEmptyMessage(10);
        }
    }

    private class ConnectedThread extends Thread {
        private final InputStream cwjInStream;
        private final OutputStream cwjOutStream;
        private final BluetoothSocket cwjSocket;

        public ConnectedThread(BluetoothSocket bluetoothSocket) throws IOException {
            InputStream inputStream;
            this.cwjSocket = bluetoothSocket;
            OutputStream outputStream = null;
            try {
                inputStream = bluetoothSocket.getInputStream();
            } catch (IOException e) {
                e = e;
                inputStream = null;
            }
            try {
                outputStream = bluetoothSocket.getOutputStream();
            } catch (IOException e2) {
                e = e2;
                e.printStackTrace();
                this.cwjInStream = inputStream;
                this.cwjOutStream = outputStream;
            }
            this.cwjInStream = inputStream;
            this.cwjOutStream = outputStream;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws IOException {
            byte[] bArr = new byte[1024];
            Log.d(MyBluetoothClassic.TAG, "read run() = " + MyBluetoothClassic.this.isRunning);
            while (MyBluetoothClassic.this.isRunning) {
                try {
                    int i = this.cwjInStream.read(bArr);
                    Log.d(MyBluetoothClassic.TAG, "read OK" + i);
                    String str = "";
                    for (int i2 = 0; i2 < i; i2++) {
                        str = str + MyBluetoothClassic.byteToHex(bArr[i2]);
                    }
                    MyBluetoothClassic.this.receive(str);
                } catch (IOException e) {
                    MyBluetoothClassic.this.hd.sendEmptyMessage(10);
                    MyBluetoothClassic.this.disconnect();
                    e.printStackTrace();
                    return;
                }
            }
        }

        public void write(byte[] bArr) throws IOException {
            Log.d(MyBluetoothClassic.TAG, "write:" + bArr);
            try {
                this.cwjOutStream.write(bArr);
                Log.d(MyBluetoothClassic.TAG, "write OK");
            } catch (IOException e) {
                Log.d(MyBluetoothClassic.TAG, "write Error = " + e.toString());
                e.printStackTrace();
            }
        }

        public void cancel() throws IOException {
            try {
                this.cwjSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getStringToHex(String str) throws UnsupportedEncodingException {
        try {
            byte[] bytes = str.getBytes("ISO8859-1");
            String str2 = "";
            for (int i = 0; i < bytes.length; i++) {
                int i2 = bytes[i];
                if (i2 < 0) {
                    i2 += 256;
                }
                str2 = i2 < 16 ? str2 + AppEventsConstants.EVENT_PARAM_VALUE_NO + Integer.toHexString(i2).toUpperCase() : str2 + Integer.toHexString(i2).toUpperCase();
            }
            return str2;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getHexToString(String str) throws NumberFormatException {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            try {
                String strSubstring = str.substring(0, 2);
                str = str.substring(2);
                int i2 = Integer.parseInt(strSubstring, 16);
                if (i2 > 128) {
                    i2 += InputDeviceCompat.SOURCE_ANY;
                }
                bArr[i] = (byte) i2;
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
        return new String(bArr, "ISO8859-1");
    }

    public static String byteToHex(byte b) {
        return "" + "0123456789ABCDEF".charAt((b >> 4) & 15) + "0123456789ABCDEF".charAt(b & 15);
    }

    public static String HexToAscii(String str) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < str.length()) {
            int i2 = i + 2;
            sb.append((char) Integer.parseInt(str.substring(i, i2), 16));
            i = i2;
        }
        return sb.toString();
    }

    public static byte[] AsciiToHex(String str) {
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) charArray[i];
        }
        return bArr;
    }
}
