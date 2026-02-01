package com.dyaco.ideabussdk_sole.protocol;

import android.app.Activity;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.dyaco.ideabussdk_sole.bluetooth.MyBluetoothClassic;
import com.dyaco.ideabussdk_sole.bluetooth.MyBluetoothLE;
import com.dyaco.ideabussdk_sole.library.MyVariable;
import com.dyaco.sole.BuildConfig;
import com.dyaco.sole.R2;
import com.facebook.appevents.AppEventsConstants;
import com.ideabus.bluetooth.BluetoothLEClass;
import com.ideabus.library.CustomVariable;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes.dex */
public class SoleProtocol implements BluetoothLEClass.OnIMBluetoothLEListener, MyBluetoothLE.OnWriteStateListener, MyBluetoothClassic.OnConnectStateListener {
    private static final int BIKE_SPEED = 100;
    public static final int BLE = 1;
    public static final int CLASSIC = 0;
    private static final int RECEIVED_ERROR_COUNT = 10;
    private static final String TAG = "SoleProtocol";
    private static final int TREADMILL_SPEED = 10;
    private static SoleProtocol bleSoleProtocol = null;
    private static SoleProtocol classicSoleProtocol = null;
    public static boolean notRunning = true;
    private StringBuilder allReceivedCommand;
    private int btType;
    private int calcCalCount;
    private int calcDisCount;
    private int deviceBrand;
    private int deviceModel;
    private String deviceName;
    private int deviceType;
    private int deviceUnit;
    private boolean hasMaxIncline;
    private boolean isCalcCal;
    private boolean isCalcDis;
    private boolean isResetCal;
    private boolean isResetDis;
    private boolean isSimulationMode;
    private boolean isSimulationReciprocal;
    private boolean isStopMode;
    private boolean isTransformCal;
    private boolean isTransformDis;
    private int lastSecond;
    public ConnectState mConnectState;
    private Handler mHandler;
    public OnConnectStateListener mOnConnectStateListener;
    public OnNotifyStateListener mOnNotifyStateListener;
    public OnWriteStateListener mOnWriteStateListener;
    private int maxIncline;
    private int maxLevel;
    private int maxSpeed;
    private int minSpeed;
    private MyBluetoothClassic myBluetoothClassic;
    private MyBluetoothLE myBluetoothLE;
    private int nowIncline;
    private int nowLevel;
    private int nowSpeed;
    private OnErrorHappened onErrorHappened;
    public int position;
    private int profileRowIndex;
    private int profileRowSeconds;
    private int receiveErrorCount;
    private int repeat32;
    private int resetCalCount;
    private int resetDisCount;
    private int salesVersion;
    private int showInclineMode;
    private int simulationCalories;
    private int simulationDistance;
    private String simulationMode;
    private Timer simulationTimer;
    private int simulationWorkoutMode;
    private int simulationWorkoutTime;
    private float totalCalories;
    private float totalDistance;
    private float totalSteps;
    private int userSegment;
    private int weight;
    private float weightTrans;
    private int workoutMode;

    public enum ConnectState {
        ScanFinish,
        Connected,
        Disconnect,
        ConnectTimeout
    }

    public interface OnConnectStateListener {
        void onBtStateChanged(boolean z);

        void onConnectionState(ConnectState connectState);

        void onDataResult(int i, boolean z, ArrayList<Number> arrayList);

        void onEndWorkoutResult(EndWorkoutData endWorkoutData);

        void onScanResult(BluetoothDevice bluetoothDevice, int i);

        void onScanResult(String str, String str2, int i);

        void onWorkoutResult(WorkoutData workoutData);
    }

    public interface OnErrorHappened {
        void onError(String str);
    }

    public interface OnNotifyStateListener {
        void onNotifyMessage(String str);
    }

    public interface OnWriteStateListener {
        void onWriteMessage(boolean z, String str);
    }

    static /* synthetic */ int access$1612(SoleProtocol soleProtocol, int i) {
        int i2 = soleProtocol.repeat32 + i;
        soleProtocol.repeat32 = i2;
        return i2;
    }

    static /* synthetic */ int access$208(SoleProtocol soleProtocol) {
        int i = soleProtocol.simulationWorkoutTime;
        soleProtocol.simulationWorkoutTime = i + 1;
        return i;
    }

    static /* synthetic */ int access$210(SoleProtocol soleProtocol) {
        int i = soleProtocol.simulationWorkoutTime;
        soleProtocol.simulationWorkoutTime = i - 1;
        return i;
    }

    static /* synthetic */ int access$412(SoleProtocol soleProtocol, int i) {
        int i2 = soleProtocol.simulationDistance + i;
        soleProtocol.simulationDistance = i2;
        return i2;
    }

    static /* synthetic */ int access$512(SoleProtocol soleProtocol, int i) {
        int i2 = soleProtocol.simulationCalories + i;
        soleProtocol.simulationCalories = i2;
        return i2;
    }

    static /* synthetic */ int access$708(SoleProtocol soleProtocol) {
        int i = soleProtocol.profileRowIndex;
        soleProtocol.profileRowIndex = i + 1;
        return i;
    }

    public void setOnWriteStateListener(OnWriteStateListener onWriteStateListener) {
        this.mOnWriteStateListener = onWriteStateListener;
    }

    public void setOnNotifyStateListener(OnNotifyStateListener onNotifyStateListener) {
        this.mOnNotifyStateListener = onNotifyStateListener;
    }

    public void setOnErrorHappened(OnErrorHappened onErrorHappened) {
        this.onErrorHappened = onErrorHappened;
    }

    public void setOnConnectStateListener(OnConnectStateListener onConnectStateListener) {
        this.mOnConnectStateListener = onConnectStateListener;
    }

    public static SoleProtocol getBleInstance(Context context, int i, boolean z, boolean z2) {
        if (bleSoleProtocol == null) {
            bleSoleProtocol = new SoleProtocol(context, i, z, z2);
        }
        return bleSoleProtocol;
    }

    public static SoleProtocol getClassicInstance(Context context, int i, boolean z, boolean z2) {
        if (classicSoleProtocol == null) {
            classicSoleProtocol = new SoleProtocol(context, i, z, z2);
        }
        return classicSoleProtocol;
    }

    private SoleProtocol() {
        this.repeat32 = 0;
        this.receiveErrorCount = 0;
        this.deviceModel = -1;
        this.weight = 60;
        this.workoutMode = 0;
        this.isStopMode = false;
        this.nowIncline = 5;
        this.nowLevel = 5;
        this.nowSpeed = 5;
        this.simulationMode = "16";
        this.isSimulationMode = false;
        this.position = 0;
        this.mHandler = new Handler() { // from class: com.dyaco.ideabussdk_sole.protocol.SoleProtocol.1
            @Override // android.os.Handler
            public void handleMessage(Message message) throws IOException, NumberFormatException {
                int i = message.what;
                if (i == 0) {
                    if (message.arg1 != 0) {
                        SoleProtocol.this.simulationWorkoutMode = message.arg1;
                    }
                    SoleProtocol.this.dataResult((String) message.obj);
                    return;
                }
                if (i != 1) {
                    if (i == 1000) {
                        if (SoleProtocol.this.mOnWriteStateListener != null) {
                            SoleProtocol.this.mOnWriteStateListener.onWriteMessage(message.arg1 == 1, (String) message.obj);
                            return;
                        }
                        return;
                    }
                    if (i != 1001) {
                        switch (i) {
                            case 100:
                                SoleProtocol.this.position++;
                                if (SoleProtocol.this.mOnConnectStateListener != null) {
                                    int i2 = SoleProtocol.this.btType;
                                    if (i2 == 0) {
                                        SoleProtocol.this.mOnConnectStateListener.onScanResult(null, 0);
                                    } else if (i2 == 1) {
                                        SoleProtocol.this.mOnConnectStateListener.onScanResult("abcde12345678" + SoleProtocol.this.position, "Sole_" + SoleProtocol.this.position, SoleProtocol.this.position - 40);
                                    }
                                }
                                if (SoleProtocol.this.position >= 20) {
                                    SoleProtocol.this.cancelSimulationTimer();
                                    break;
                                }
                                break;
                            case 101:
                                SoleProtocol.this.connectionStatus(17);
                                break;
                            case 102:
                                SoleProtocol.this.connectionStatus(18);
                                break;
                        }
                        return;
                    }
                    if (SoleProtocol.this.mOnNotifyStateListener != null) {
                        SoleProtocol.this.mOnNotifyStateListener.onNotifyMessage((String) message.obj);
                        return;
                    }
                    return;
                }
                if (SoleProtocol.this.isSimulationReciprocal) {
                    SoleProtocol.access$208(SoleProtocol.this);
                } else {
                    SoleProtocol.access$210(SoleProtocol.this);
                    if (SoleProtocol.this.simulationWorkoutTime < 0) {
                        SoleProtocol.this.dataResult("5b0203015d");
                        SoleProtocol.this.cancelSimulationTimer();
                        return;
                    }
                }
                int i3 = SoleProtocol.this.simulationWorkoutTime / 60;
                int i4 = SoleProtocol.this.simulationWorkoutTime % 60;
                SoleProtocol.access$412(SoleProtocol.this, 1);
                SoleProtocol.access$512(SoleProtocol.this, 1);
                String strValueOf = String.valueOf(SoleProtocol.this.simulationDistance);
                while (strValueOf.length() < 4) {
                    strValueOf = AppEventsConstants.EVENT_PARAM_VALUE_NO + strValueOf;
                }
                String strValueOf2 = String.valueOf(SoleProtocol.this.simulationCalories);
                while (strValueOf2.length() < 4) {
                    strValueOf2 = AppEventsConstants.EVENT_PARAM_VALUE_NO + strValueOf2;
                }
                if (SoleProtocol.this.simulationWorkoutTime % SoleProtocol.this.profileRowSeconds == 0) {
                    SoleProtocol.access$708(SoleProtocol.this);
                }
                if (SoleProtocol.this.deviceType != 0) {
                    if (SoleProtocol.this.deviceModel == 31 || SoleProtocol.this.deviceModel == 10 || (SoleProtocol.this.deviceModel == 30 && SoleProtocol.this.salesVersion == 0)) {
                        SoleProtocol soleProtocol = SoleProtocol.this;
                        StringBuilder sb = new StringBuilder();
                        sb.append("5b1c06");
                        sb.append(SoleProtocol.this.getIntToHexString(i3, 2));
                        sb.append(SoleProtocol.this.getIntToHexString(i4, 2));
                        sb.append(strValueOf);
                        sb.append(strValueOf2);
                        sb.append(SoleProtocol.this.getIntToHexString((i4 % 20) * 5, 2));
                        sb.append(SoleProtocol.this.getIntToHexString((i4 % 10) * 10, 2));
                        sb.append(SoleProtocol.this.getIntToHexString(i4 * 100, 4));
                        sb.append("010f00000333");
                        sb.append(SoleProtocol.this.getIntToHexString(i4 * 1, 8));
                        sb.append("0000000000");
                        SoleProtocol soleProtocol2 = SoleProtocol.this;
                        sb.append(soleProtocol2.getIntToHexString(soleProtocol2.profileRowIndex, 2));
                        sb.append(SoleProtocol.this.getIntToHexString(3, 2));
                        sb.append("5d");
                        soleProtocol.dataResult(sb.toString());
                        return;
                    }
                    SoleProtocol soleProtocol3 = SoleProtocol.this;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("5b1306");
                    sb2.append(SoleProtocol.this.getIntToHexString(i3, 2));
                    sb2.append(SoleProtocol.this.getIntToHexString(i4, 2));
                    sb2.append(strValueOf);
                    sb2.append(strValueOf2);
                    sb2.append(SoleProtocol.this.getIntToHexString((i4 % 20) * 5, 2));
                    sb2.append(SoleProtocol.this.getIntToHexString((i4 % 10) * 10, 2));
                    sb2.append(SoleProtocol.this.getIntToHexString(i4 * 100, 4));
                    sb2.append("010f0333010000");
                    SoleProtocol soleProtocol4 = SoleProtocol.this;
                    sb2.append(soleProtocol4.getIntToHexString(soleProtocol4.profileRowIndex, 2));
                    sb2.append("5d");
                    soleProtocol3.dataResult(sb2.toString());
                    return;
                }
                SoleProtocol soleProtocol5 = SoleProtocol.this;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("5b0F06");
                sb3.append(SoleProtocol.this.getIntToHexString(i3, 2));
                sb3.append(SoleProtocol.this.getIntToHexString(i4, 2));
                sb3.append(strValueOf);
                sb3.append(strValueOf2);
                sb3.append(SoleProtocol.this.getIntToHexString((i4 % 20) * 5, 2));
                SoleProtocol soleProtocol6 = SoleProtocol.this;
                sb3.append(soleProtocol6.getIntToHexString(soleProtocol6.nowSpeed, 2));
                SoleProtocol soleProtocol7 = SoleProtocol.this;
                sb3.append(soleProtocol7.getIntToHexString(soleProtocol7.nowIncline, 2));
                sb3.append("010000");
                SoleProtocol soleProtocol8 = SoleProtocol.this;
                sb3.append(soleProtocol8.getIntToHexString(soleProtocol8.profileRowIndex, 2));
                sb3.append(SoleProtocol.this.getIntToHexString(3, 2));
                sb3.append("5d");
                soleProtocol5.dataResult(sb3.toString());
            }
        };
    }

    private SoleProtocol(Context context, int i, boolean z, boolean z2) {
        this.repeat32 = 0;
        this.receiveErrorCount = 0;
        this.deviceModel = -1;
        this.weight = 60;
        this.workoutMode = 0;
        this.isStopMode = false;
        this.nowIncline = 5;
        this.nowLevel = 5;
        this.nowSpeed = 5;
        this.simulationMode = "16";
        this.isSimulationMode = false;
        this.position = 0;
        this.mHandler = new Handler() { // from class: com.dyaco.ideabussdk_sole.protocol.SoleProtocol.1
            @Override // android.os.Handler
            public void handleMessage(Message message) throws IOException, NumberFormatException {
                int i2 = message.what;
                if (i2 == 0) {
                    if (message.arg1 != 0) {
                        SoleProtocol.this.simulationWorkoutMode = message.arg1;
                    }
                    SoleProtocol.this.dataResult((String) message.obj);
                    return;
                }
                if (i2 != 1) {
                    if (i2 == 1000) {
                        if (SoleProtocol.this.mOnWriteStateListener != null) {
                            SoleProtocol.this.mOnWriteStateListener.onWriteMessage(message.arg1 == 1, (String) message.obj);
                            return;
                        }
                        return;
                    }
                    if (i2 != 1001) {
                        switch (i2) {
                            case 100:
                                SoleProtocol.this.position++;
                                if (SoleProtocol.this.mOnConnectStateListener != null) {
                                    int i22 = SoleProtocol.this.btType;
                                    if (i22 == 0) {
                                        SoleProtocol.this.mOnConnectStateListener.onScanResult(null, 0);
                                    } else if (i22 == 1) {
                                        SoleProtocol.this.mOnConnectStateListener.onScanResult("abcde12345678" + SoleProtocol.this.position, "Sole_" + SoleProtocol.this.position, SoleProtocol.this.position - 40);
                                    }
                                }
                                if (SoleProtocol.this.position >= 20) {
                                    SoleProtocol.this.cancelSimulationTimer();
                                    break;
                                }
                                break;
                            case 101:
                                SoleProtocol.this.connectionStatus(17);
                                break;
                            case 102:
                                SoleProtocol.this.connectionStatus(18);
                                break;
                        }
                        return;
                    }
                    if (SoleProtocol.this.mOnNotifyStateListener != null) {
                        SoleProtocol.this.mOnNotifyStateListener.onNotifyMessage((String) message.obj);
                        return;
                    }
                    return;
                }
                if (SoleProtocol.this.isSimulationReciprocal) {
                    SoleProtocol.access$208(SoleProtocol.this);
                } else {
                    SoleProtocol.access$210(SoleProtocol.this);
                    if (SoleProtocol.this.simulationWorkoutTime < 0) {
                        SoleProtocol.this.dataResult("5b0203015d");
                        SoleProtocol.this.cancelSimulationTimer();
                        return;
                    }
                }
                int i3 = SoleProtocol.this.simulationWorkoutTime / 60;
                int i4 = SoleProtocol.this.simulationWorkoutTime % 60;
                SoleProtocol.access$412(SoleProtocol.this, 1);
                SoleProtocol.access$512(SoleProtocol.this, 1);
                String strValueOf = String.valueOf(SoleProtocol.this.simulationDistance);
                while (strValueOf.length() < 4) {
                    strValueOf = AppEventsConstants.EVENT_PARAM_VALUE_NO + strValueOf;
                }
                String strValueOf2 = String.valueOf(SoleProtocol.this.simulationCalories);
                while (strValueOf2.length() < 4) {
                    strValueOf2 = AppEventsConstants.EVENT_PARAM_VALUE_NO + strValueOf2;
                }
                if (SoleProtocol.this.simulationWorkoutTime % SoleProtocol.this.profileRowSeconds == 0) {
                    SoleProtocol.access$708(SoleProtocol.this);
                }
                if (SoleProtocol.this.deviceType != 0) {
                    if (SoleProtocol.this.deviceModel == 31 || SoleProtocol.this.deviceModel == 10 || (SoleProtocol.this.deviceModel == 30 && SoleProtocol.this.salesVersion == 0)) {
                        SoleProtocol soleProtocol = SoleProtocol.this;
                        StringBuilder sb = new StringBuilder();
                        sb.append("5b1c06");
                        sb.append(SoleProtocol.this.getIntToHexString(i3, 2));
                        sb.append(SoleProtocol.this.getIntToHexString(i4, 2));
                        sb.append(strValueOf);
                        sb.append(strValueOf2);
                        sb.append(SoleProtocol.this.getIntToHexString((i4 % 20) * 5, 2));
                        sb.append(SoleProtocol.this.getIntToHexString((i4 % 10) * 10, 2));
                        sb.append(SoleProtocol.this.getIntToHexString(i4 * 100, 4));
                        sb.append("010f00000333");
                        sb.append(SoleProtocol.this.getIntToHexString(i4 * 1, 8));
                        sb.append("0000000000");
                        SoleProtocol soleProtocol2 = SoleProtocol.this;
                        sb.append(soleProtocol2.getIntToHexString(soleProtocol2.profileRowIndex, 2));
                        sb.append(SoleProtocol.this.getIntToHexString(3, 2));
                        sb.append("5d");
                        soleProtocol.dataResult(sb.toString());
                        return;
                    }
                    SoleProtocol soleProtocol3 = SoleProtocol.this;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("5b1306");
                    sb2.append(SoleProtocol.this.getIntToHexString(i3, 2));
                    sb2.append(SoleProtocol.this.getIntToHexString(i4, 2));
                    sb2.append(strValueOf);
                    sb2.append(strValueOf2);
                    sb2.append(SoleProtocol.this.getIntToHexString((i4 % 20) * 5, 2));
                    sb2.append(SoleProtocol.this.getIntToHexString((i4 % 10) * 10, 2));
                    sb2.append(SoleProtocol.this.getIntToHexString(i4 * 100, 4));
                    sb2.append("010f0333010000");
                    SoleProtocol soleProtocol4 = SoleProtocol.this;
                    sb2.append(soleProtocol4.getIntToHexString(soleProtocol4.profileRowIndex, 2));
                    sb2.append("5d");
                    soleProtocol3.dataResult(sb2.toString());
                    return;
                }
                SoleProtocol soleProtocol5 = SoleProtocol.this;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("5b0F06");
                sb3.append(SoleProtocol.this.getIntToHexString(i3, 2));
                sb3.append(SoleProtocol.this.getIntToHexString(i4, 2));
                sb3.append(strValueOf);
                sb3.append(strValueOf2);
                sb3.append(SoleProtocol.this.getIntToHexString((i4 % 20) * 5, 2));
                SoleProtocol soleProtocol6 = SoleProtocol.this;
                sb3.append(soleProtocol6.getIntToHexString(soleProtocol6.nowSpeed, 2));
                SoleProtocol soleProtocol7 = SoleProtocol.this;
                sb3.append(soleProtocol7.getIntToHexString(soleProtocol7.nowIncline, 2));
                sb3.append("010000");
                SoleProtocol soleProtocol8 = SoleProtocol.this;
                sb3.append(soleProtocol8.getIntToHexString(soleProtocol8.profileRowIndex, 2));
                sb3.append(SoleProtocol.this.getIntToHexString(3, 2));
                sb3.append("5d");
                soleProtocol5.dataResult(sb3.toString());
            }
        };
        this.isSimulationMode = z;
        if (z) {
            return;
        }
        this.allReceivedCommand = new StringBuilder();
        this.btType = i;
        if (i == 0) {
            MyBluetoothClassic myBluetoothClassic = MyBluetoothClassic.getInstance(context);
            this.myBluetoothClassic = myBluetoothClassic;
            myBluetoothClassic.setOnConnectStateListener(this);
        } else {
            if (i != 1) {
                return;
            }
            MyBluetoothLE myBluetoothLE = MyBluetoothLE.getInstance(context, z2);
            this.myBluetoothLE = myBluetoothLE;
            myBluetoothLE.setOnIMBluetoothLEListener(this);
            this.myBluetoothLE.setOnWriteStateListener(this);
        }
    }

    public void readRSSI() {
        if (this.isSimulationMode) {
            cancelSimulationTimer();
        } else {
            if (this.btType != 1) {
                return;
            }
            this.myBluetoothLE.readRSSI();
        }
    }

    public boolean enableBluetooth(Activity activity) {
        return isSupportBluetooth(activity);
    }

    @Deprecated
    public boolean isSupportBluetooth(Activity activity) {
        if (this.isSimulationMode) {
            return true;
        }
        int i = this.btType;
        if (i == 0) {
            return this.myBluetoothClassic.enableBluetooth();
        }
        if (i != 1) {
            return false;
        }
        return this.myBluetoothLE.isSupportBluetooth(activity);
    }

    public boolean isScanning() {
        if (this.isSimulationMode) {
            return true;
        }
        int i = this.btType;
        if (i == 0) {
            return this.myBluetoothClassic.isScanning();
        }
        if (i != 1) {
            return false;
        }
        return this.myBluetoothLE.isScanning();
    }

    public boolean isConnected() {
        boolean zIsConnected;
        if (this.isSimulationMode) {
            return true;
        }
        int i = this.btType;
        if (i == 0) {
            zIsConnected = this.myBluetoothClassic.isConnected();
        } else {
            zIsConnected = i != 1 ? false : this.myBluetoothLE.isConnected();
        }
        return this.isSimulationMode || zIsConnected;
    }

    public void startScan(int i) {
        if (this.isSimulationMode) {
            startSimulationTimer();
            return;
        }
        int i2 = this.btType;
        if (i2 == 0) {
            this.myBluetoothClassic.startScan();
        } else {
            if (i2 != 1) {
                return;
            }
            this.myBluetoothLE.startLEScan(i, false);
        }
    }

    public void stopScan() {
        if (this.isSimulationMode) {
            cancelSimulationTimer();
            return;
        }
        int i = this.btType;
        if (i == 0) {
            this.myBluetoothClassic.stopScan();
        } else {
            if (i != 1) {
                return;
            }
            this.myBluetoothLE.stopLEScan();
        }
    }

    public void connect(String str) {
        if (this.isSimulationMode) {
            this.mHandler.removeMessages(0);
            cancelSimulationTimer();
            Timer timer = new Timer();
            this.simulationTimer = timer;
            timer.schedule(new TimerTask() { // from class: com.dyaco.ideabussdk_sole.protocol.SoleProtocol.2
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    SoleProtocol.this.mHandler.sendEmptyMessage(101);
                }
            }, 500L);
            return;
        }
        this.myBluetoothLE.sendCount = 0;
        this.receiveErrorCount = 0;
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        this.myBluetoothLE.connect(arrayList);
    }

    public void connect(BluetoothDevice bluetoothDevice) throws IOException {
        if (this.isSimulationMode) {
            this.mHandler.removeMessages(0);
            cancelSimulationTimer();
            Timer timer = new Timer();
            this.simulationTimer = timer;
            timer.schedule(new TimerTask() { // from class: com.dyaco.ideabussdk_sole.protocol.SoleProtocol.3
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    SoleProtocol.this.mHandler.sendEmptyMessage(101);
                }
            }, 500L);
            return;
        }
        this.myBluetoothClassic.connect(bluetoothDevice);
    }

    public void disconnect() throws IOException {
        if (this.isSimulationMode) {
            this.mHandler.sendEmptyMessage(102);
            return;
        }
        int i = this.btType;
        if (i == 0) {
            this.myBluetoothClassic.disconnect();
        } else {
            if (i != 1) {
                return;
            }
            this.myBluetoothLE.disconnect(18);
        }
    }

    public void setTestMode(String str) {
        this.simulationMode = str;
    }

    public void sssss() throws IOException {
        this.myBluetoothClassic.writeMessage("3C03A000A03E");
    }

    private void getDeviceInfo() throws IOException {
        if (this.isSimulationMode) {
            cancelSimulationTimer();
            Message message = new Message();
            message.what = 0;
            message.obj = "5b09f0" + this.simulationMode + "010014141200005d";
            this.mHandler.sendMessage(message);
            Message message2 = new Message();
            message2.what = 0;
            message2.obj = "5b0203015d";
            this.mHandler.sendMessageDelayed(message2, 1000L);
            return;
        }
        int i = this.btType;
        if (i == 0) {
            this.myBluetoothClassic.writeMessage(MyBluetoothLE.completeCommand("F0"));
        } else {
            if (i != 1) {
                return;
            }
            this.myBluetoothLE.writeMessage(MyBluetoothLE.completeCommand("F0"), false);
        }
    }

    public void getEndWorkout() throws IOException {
        int i = this.btType;
        if (i == 0) {
            this.myBluetoothClassic.writeMessage(MyBluetoothLE.completeCommand("32"));
        } else {
            if (i != 1) {
                return;
            }
            this.myBluetoothLE.writeMessage(MyBluetoothLE.completeCommand("32"), false);
        }
    }

    public int getDeviceModel() {
        return this.deviceModel;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public int getDeviceType() {
        return this.deviceType;
    }

    public int getDeviceBrand() {
        return this.deviceBrand;
    }

    public int getSalesVersion() {
        return this.salesVersion;
    }

    public int getUnit() {
        return this.deviceUnit;
    }

    public int getMaxIncline() {
        return this.maxIncline;
    }

    public int getMaxLevel() {
        return this.maxLevel;
    }

    public int getMaxSpeed() {
        return this.maxSpeed;
    }

    public int getMinSpeed() {
        return this.minSpeed;
    }

    public int getUserSegment() {
        return this.userSegment;
    }

    public int getShowInclineMode() {
        return this.showInclineMode;
    }

    public boolean getHasMaxIncline() {
        return this.hasMaxIncline;
    }

    public void setUserProfile(int i, int i2, int i3, int i4) throws IOException {
        if (this.deviceUnit == 1) {
            if (i3 < 40 || i3 > 400) {
                i3 = 155;
            }
            if (i4 < 40 || i4 > 100) {
                i4 = 89;
            }
        } else {
            if (i3 < 30 || i3 > 180) {
                i3 = 70;
            }
            if (i4 < 100 || i4 > 250) {
                i4 = R2.attr.colorControlActivated;
            }
        }
        this.weight = i3;
        if (this.isSimulationMode) {
            cancelSimulationTimer();
            Message message = new Message();
            message.what = 0;
            message.obj = "5b0400074f4b5d";
            this.mHandler.sendMessage(message);
            return;
        }
        int i5 = this.btType;
        if (i5 == 0) {
            this.myBluetoothClassic.writeMessage(MyBluetoothLE.completeCommand(getIntToHexString(7, 2) + getIntToHexString(i, 2) + getIntToHexString(i2, 2) + getIntToHexString(i3, 4) + getIntToHexString(i4, 2)));
            return;
        }
        if (i5 != 1) {
            return;
        }
        Log.e("setuserfile", getIntToHexString(7, 2) + getIntToHexString(i, 2) + getIntToHexString(i2, 2) + getIntToHexString(i3, 4) + getIntToHexString(i4, 2));
        int i6 = this.deviceModel;
        if (i6 == 12 || i6 == 13) {
            return;
        }
        this.myBluetoothLE.writeMessage(MyBluetoothLE.completeCommand(getIntToHexString(7, 2) + getIntToHexString(i, 2) + getIntToHexString(i2, 2) + getIntToHexString(i3, 4) + getIntToHexString(i4, 2)), false);
    }

    public void setProgram(int i) throws IOException {
        if (this.isSimulationMode) {
            cancelSimulationTimer();
            Message message = new Message();
            message.what = 0;
            message.obj = "5b0400084f4b5d";
            this.mHandler.sendMessage(message);
            return;
        }
        String str = "30";
        switch (i) {
            case 0:
                str = "10";
                i = 1;
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                i++;
                str = "20";
                break;
            case 6:
                i = 9;
                str = "40";
                break;
            case 7:
                i = 10;
                str = "40";
                break;
            case 8:
                i = 7;
                break;
            case 9:
                i = 8;
                break;
            case 10:
                i = -1;
                str = "70";
                break;
            case 11:
                i = 11;
                str = "50";
                break;
            case 12:
                i = 12;
                str = "60";
                break;
            default:
                str = "";
                break;
        }
        this.workoutMode = i;
        int i2 = this.btType;
        if (i2 == 0) {
            this.myBluetoothClassic.writeMessage(MyBluetoothLE.completeCommand(getIntToHexString(8, 2) + str + getIntToHexString(i, 2)));
            return;
        }
        if (i2 != 1) {
            return;
        }
        this.myBluetoothLE.writeMessage(MyBluetoothLE.completeCommand(getIntToHexString(8, 2) + str + getIntToHexString(i, 2)), false);
    }

    public void setWorkoutTime(int i) throws IOException {
        if (this.isSimulationMode) {
            cancelSimulationTimer();
            boolean z = i == 0;
            this.isSimulationReciprocal = z;
            int i2 = i * 60;
            this.simulationWorkoutTime = i2;
            this.simulationDistance = 0;
            this.simulationCalories = 0;
            this.profileRowIndex = 0;
            this.profileRowSeconds = z ? 60 : i2 / this.userSegment;
            Log.d(TAG, "setWorkoutTime  profileRowSeconds = " + this.profileRowSeconds);
            Message message = new Message();
            message.what = 0;
            message.obj = "5b0400044f4b5d";
            this.mHandler.sendMessage(message);
            return;
        }
        int i3 = this.btType;
        if (i3 == 0) {
            this.myBluetoothClassic.writeMessage(MyBluetoothLE.completeCommand(getIntToHexString(4, 2) + getIntToHexString(i, 2) + "000000"));
            return;
        }
        if (i3 != 1) {
            return;
        }
        this.myBluetoothLE.writeMessage(MyBluetoothLE.completeCommand(getIntToHexString(4, 2) + getIntToHexString(i, 2) + "000000"), false);
    }

    public void setMaxLevel(int i) throws IOException {
        Log.e("sendarray", "" + i + "/" + getMaxLevel());
        if (this.isSimulationMode) {
            cancelSimulationTimer();
            this.nowLevel = i;
            Message message = new Message();
            message.what = 0;
            message.obj = "5b0400234f4b5d";
            this.mHandler.sendMessage(message);
            return;
        }
        int i2 = this.btType;
        if (i2 == 0) {
            this.myBluetoothClassic.writeMessage(MyBluetoothLE.completeCommand(getIntToHexString(35, 2) + getIntToHexString(i - 1, 2)));
            return;
        }
        if (i2 != 1) {
            return;
        }
        this.myBluetoothLE.writeMessage(MyBluetoothLE.completeCommand(getIntToHexString(35, 2) + getIntToHexString(i - 1, 2)), false);
    }

    public void setMaxIncline(int i) throws IOException {
        if (this.isSimulationMode) {
            cancelSimulationTimer();
            this.nowIncline = i;
            Message message = new Message();
            message.what = 0;
            message.obj = "5b0400224f4b5d";
            this.mHandler.sendMessage(message);
            return;
        }
        int i2 = this.btType;
        if (i2 == 0) {
            this.myBluetoothClassic.writeMessage(MyBluetoothLE.completeCommand(getIntToHexString(34, 2) + getIntToHexString(i - 1, 2)));
            return;
        }
        if (i2 != 1) {
            return;
        }
        this.myBluetoothLE.writeMessage(MyBluetoothLE.completeCommand(getIntToHexString(34, 2) + getIntToHexString(i - 1, 2)), false);
    }

    public void setMaxSpeed(int i) throws IOException {
        if (this.isSimulationMode) {
            cancelSimulationTimer();
            this.nowSpeed = i;
            Message message = new Message();
            message.what = 0;
            message.obj = "5b0400214f4b5d";
            this.mHandler.sendMessage(message);
            return;
        }
        int i2 = this.btType;
        if (i2 == 0) {
            this.myBluetoothClassic.writeMessage(MyBluetoothLE.completeCommand(getIntToHexString(33, 2) + getIntToHexString(i - 1, 2)));
            return;
        }
        if (i2 != 1) {
            return;
        }
        this.myBluetoothLE.writeMessage(MyBluetoothLE.completeCommand(getIntToHexString(33, 2) + getIntToHexString(i - 1, 2)), false);
    }

    public void setTargetHR(int i) throws IOException {
        if (this.isSimulationMode) {
            cancelSimulationTimer();
            Message message = new Message();
            message.what = 0;
            message.obj = "5b0400204f4b5d";
            this.mHandler.sendMessage(message);
            return;
        }
        int i2 = this.btType;
        if (i2 == 0) {
            this.myBluetoothClassic.writeMessage(MyBluetoothLE.completeCommand(getIntToHexString(32, 2) + getIntToHexString(i, 2)));
            return;
        }
        if (i2 != 1) {
            return;
        }
        this.myBluetoothLE.writeMessage(MyBluetoothLE.completeCommand(getIntToHexString(32, 2) + getIntToHexString(i, 2)), false);
    }

    public void setTargetWatt(int i) throws IOException {
        if (this.isSimulationMode) {
            cancelSimulationTimer();
            Message message = new Message();
            message.what = 0;
            message.obj = "5b0400194f4b5d";
            this.mHandler.sendMessage(message);
            return;
        }
        int i2 = this.btType;
        if (i2 == 0) {
            this.myBluetoothClassic.writeMessage(MyBluetoothLE.completeCommand(getIntToHexString(25, 2) + getIntToHexString(i, 4)));
            return;
        }
        if (i2 != 1) {
            return;
        }
        this.myBluetoothLE.writeMessage(MyBluetoothLE.completeCommand(getIntToHexString(25, 2) + getIntToHexString(i, 4)), false);
    }

    public void setTargetCalorie(int i) throws IOException {
        Log.d(TAG, "setWorkoutTime  getIntToHexString(calories, 4) = " + getIntToHexString(i, 4));
        if (this.isSimulationMode) {
            return;
        }
        int i2 = this.btType;
        if (i2 == 0) {
            this.myBluetoothClassic.writeMessage(MyBluetoothLE.completeCommand(getIntToHexString(4, 2) + "0000" + getIntToHexString(i, 4)));
            return;
        }
        if (i2 != 1) {
            return;
        }
        this.myBluetoothLE.writeMessage(MyBluetoothLE.completeCommand(getIntToHexString(4, 2) + "0000" + getIntToHexString(i, 4)), false);
    }

    public void setFusionProgram(int i, int i2) throws IOException {
        int i3 = i * 60;
        int i4 = i2 * 60;
        String str = TAG;
        Log.d(str, "setFusionProgram  getIntToHexString(intervalTime, 4) = " + getIntToHexString(i3, 4));
        Log.d(str, "setFusionProgram  getIntToHexString(recoverTime, 4) = " + getIntToHexString(i4, 4));
        if (this.isSimulationMode) {
            return;
        }
        int i5 = this.btType;
        if (i5 == 0) {
            this.myBluetoothClassic.writeMessage(MyBluetoothLE.completeCommand(getIntToHexString(53, 2) + "0A" + getIntToHexString(i3, 4) + getIntToHexString(i4, 4)));
            return;
        }
        if (i5 != 1) {
            return;
        }
        this.myBluetoothLE.writeMessage(MyBluetoothLE.completeCommand(getIntToHexString(53, 2) + "0A" + getIntToHexString(i3, 4) + getIntToHexString(i4, 4)), false);
    }

    public void setUserIncline(ArrayList<Integer> arrayList) throws IOException {
        if (this.isSimulationMode) {
            cancelSimulationTimer();
            Message message = new Message();
            message.what = 0;
            message.obj = "5b0400264f4b5d";
            this.mHandler.sendMessage(message);
            return;
        }
        int iMax = Integer.MIN_VALUE;
        int iMin = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            int iIntValue = arrayList.get(i).intValue();
            iMax = Math.max(iIntValue, iMax);
            iMin = Math.min(iIntValue, iMin);
            sb.append(getIntToHexString(iIntValue, 2));
        }
        int i2 = this.btType;
        if (i2 == 0) {
            this.myBluetoothClassic.writeMessage(MyBluetoothLE.completeCommand(getIntToHexString(37, 2) + getIntToHexString(this.workoutMode, 2) + getIntToHexString(iMax, 2) + getIntToHexString(iMin, 2) + ((Object) sb)));
            return;
        }
        if (i2 != 1) {
            return;
        }
        this.myBluetoothLE.writeMessage(MyBluetoothLE.completeCommand(getIntToHexString(37, 2) + getIntToHexString(this.workoutMode, 2) + getIntToHexString(iMax, 2) + getIntToHexString(iMin, 2) + ((Object) sb)), false);
    }

    public void test(String str) {
        if (this.btType != 1) {
            return;
        }
        this.myBluetoothLE.writeTest(str);
    }

    public void test1(String str) {
        if (this.btType != 1) {
            return;
        }
        this.myBluetoothLE.writeTest1(str);
    }

    public void setUserLevel(ArrayList<Integer> arrayList) throws IOException {
        int i;
        int i2;
        if (this.isSimulationMode) {
            cancelSimulationTimer();
            Message message = new Message();
            message.what = 0;
            message.obj = "5b0400254f4b5d";
            this.mHandler.sendMessage(message);
            return;
        }
        int iMax = Integer.MIN_VALUE;
        int iMin = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            int iIntValue = arrayList.get(i3).intValue();
            Log.e("checkprofile", String.valueOf(iIntValue));
            int i4 = this.deviceBrand;
            if ((i4 == 3 && ((i2 = this.deviceModel) == 39 || i2 == 40)) || (i4 == 2 && ((i = this.deviceModel) == 55 || i == 57))) {
                iIntValue--;
            }
            iMax = Math.max(iIntValue, iMax);
            iMin = Math.min(iIntValue, iMin);
            sb.append(getIntToHexString(iIntValue, 2));
        }
        Log.e("setLevelMessage", getIntToHexString(38, 2) + getIntToHexString(this.workoutMode, 2) + getIntToHexString(iMax, 2) + getIntToHexString(iMin, 2) + ((Object) sb));
        int i5 = this.btType;
        if (i5 == 0) {
            this.myBluetoothClassic.writeMessage(MyBluetoothLE.completeCommand(getIntToHexString(38, 2) + getIntToHexString(this.workoutMode, 2) + getIntToHexString(iMax, 2) + getIntToHexString(iMin, 2) + ((Object) sb)));
            return;
        }
        if (i5 != 1) {
            return;
        }
        this.myBluetoothLE.writeMessage(MyBluetoothLE.completeCommand(getIntToHexString(38, 2) + getIntToHexString(this.workoutMode, 2) + getIntToHexString(iMax, 2) + getIntToHexString(iMin, 2) + ((Object) sb)), false);
    }

    public void setUserSpeed(ArrayList<Integer> arrayList) throws IOException {
        if (this.isSimulationMode) {
            cancelSimulationTimer();
            Message message = new Message();
            message.what = 0;
            message.obj = "5b0400244f4b5d";
            this.mHandler.sendMessage(message);
            return;
        }
        int iMax = Integer.MIN_VALUE;
        int iMin = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            int iIntValue = arrayList.get(i).intValue();
            iMax = Math.max(iIntValue, iMax);
            iMin = Math.min(iIntValue, iMin);
            sb.append(getIntToHexString(iIntValue, 2));
        }
        Log.e("gettypespeed", String.valueOf(this.btType) + " : " + ((Object) sb));
        int i2 = this.btType;
        if (i2 == 0) {
            this.myBluetoothClassic.writeMessage(MyBluetoothLE.completeCommand(getIntToHexString(36, 2) + getIntToHexString(this.workoutMode, 2) + getIntToHexString(iMax, 2) + getIntToHexString(iMin, 2) + ((Object) sb)));
            return;
        }
        if (i2 != 1) {
            return;
        }
        Log.e("gettypespeed", String.valueOf(this.btType) + " : " + getIntToHexString(36, 2) + getIntToHexString(this.workoutMode, 2) + getIntToHexString(iMax, 2) + getIntToHexString(iMin, 2) + ((Object) sb));
        MyBluetoothLE myBluetoothLE = this.myBluetoothLE;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getIntToHexString(36, 2));
        sb2.append(getIntToHexString(this.workoutMode, 2));
        sb2.append(getIntToHexString(iMax, 2));
        sb2.append(getIntToHexString(iMin, 2));
        sb2.append((Object) sb);
        myBluetoothLE.writeMessage(MyBluetoothLE.completeCommand(sb2.toString()), false);
    }

    public void getRPM() throws IOException {
        if (this.isSimulationMode) {
            cancelSimulationTimer();
            ArrayList<Number> arrayList = new ArrayList<>();
            arrayList.add(200);
            arrayList.add(1);
            this.mOnConnectStateListener.onDataResult(20, true, arrayList);
            return;
        }
        int i = this.btType;
        if (i == 0) {
            this.myBluetoothClassic.writeMessage(MyBluetoothLE.completeCommand(getIntToHexString(20, 2)));
        } else {
            if (i != 1) {
                return;
            }
            this.myBluetoothLE.writeMessage(MyBluetoothLE.completeCommand(getIntToHexString(20, 2)), false);
        }
    }

    public void getHeartRate() throws IOException {
        if (this.isSimulationMode) {
            cancelSimulationTimer();
            ArrayList<Number> arrayList = new ArrayList<>();
            arrayList.add(120);
            this.mOnConnectStateListener.onDataResult(21, true, arrayList);
            return;
        }
        int i = this.btType;
        if (i == 0) {
            this.myBluetoothClassic.writeMessage(MyBluetoothLE.completeCommand(getIntToHexString(21, 2)));
        } else {
            if (i != 1) {
                return;
            }
            this.myBluetoothLE.writeMessage(MyBluetoothLE.completeCommand(getIntToHexString(20, 2)), false);
        }
    }

    public void getHeartRateType() throws IOException {
        if (this.isSimulationMode) {
            cancelSimulationTimer();
            ArrayList<Number> arrayList = new ArrayList<>();
            arrayList.add(2);
            arrayList.add(2);
            this.mOnConnectStateListener.onDataResult(9, true, arrayList);
            return;
        }
        int i = this.btType;
        if (i == 0) {
            this.myBluetoothClassic.writeMessage(MyBluetoothLE.completeCommand(getIntToHexString(9, 2)));
        } else {
            if (i != 1) {
                return;
            }
            this.myBluetoothLE.writeMessage(MyBluetoothLE.completeCommand(getIntToHexString(9, 2)), false);
        }
    }

    public void startWorkout() throws IOException {
        resetCalDis();
        if (this.isSimulationMode) {
            cancelSimulationTimer();
            this.simulationWorkoutMode = 2;
            Message message = new Message();
            message.what = 0;
            message.obj = "5b0202025d";
            this.mHandler.sendMessage(message);
            Message message2 = new Message();
            message2.what = 0;
            message2.arg1 = 4;
            message2.obj = "5b0203045d";
            this.mHandler.sendMessageDelayed(message2, 500L);
            this.simulationWorkoutMode = 4;
            cancelSimulationTimer();
            Timer timer = new Timer();
            this.simulationTimer = timer;
            timer.schedule(new TimerTask() { // from class: com.dyaco.ideabussdk_sole.protocol.SoleProtocol.4
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    SoleProtocol.this.mHandler.sendEmptyMessage(1);
                }
            }, 2000L, 1000L);
            return;
        }
        Log.e("startworkout", String.valueOf(this.btType));
        int i = this.btType;
        if (i == 0) {
            this.myBluetoothClassic.writeMessage(MyBluetoothLE.completeCommand("0202"));
        } else {
            if (i != 1) {
                return;
            }
            this.myBluetoothLE.writeMessage(MyBluetoothLE.completeCommand("0202"), false);
        }
    }

    public void pauseWorkout() throws NumberFormatException, IOException {
        if (this.isSimulationMode) {
            this.mHandler.removeMessages(0);
            cancelSimulationTimer();
            int i = this.simulationWorkoutMode;
            if (i == 4) {
                dataResult("5b0203065d");
                this.simulationWorkoutMode = 6;
                return;
            }
            if (i != 6) {
                if (i != 7) {
                    return;
                }
                dataResult("5b0203015d");
                this.simulationWorkoutMode = 1;
                return;
            }
            dataResult("5b0203075d");
            this.simulationWorkoutMode = 7;
            if (this.deviceType == 0) {
                dataResult("5b0b32999901230011032189055d");
                return;
            } else {
                dataResult("5b1132999911110022333388030755666612345d");
                return;
            }
        }
        this.isStopMode = false;
        int i2 = this.btType;
        if (i2 == 0) {
            this.myBluetoothClassic.writeMessage(MyBluetoothLE.completeCommand("F106"));
        } else {
            if (i2 != 1) {
                return;
            }
            this.myBluetoothLE.writeMessage(MyBluetoothLE.completeCommand("F106"), false);
        }
    }

    public void restartWorkout() throws IOException {
        if (this.isSimulationMode) {
            cancelSimulationTimer();
            this.mHandler.removeMessages(0);
            Message message = new Message();
            message.what = 0;
            message.obj = "5b0203045d";
            this.mHandler.sendMessage(message);
            this.simulationWorkoutMode = 4;
            Timer timer = new Timer();
            this.simulationTimer = timer;
            timer.schedule(new TimerTask() { // from class: com.dyaco.ideabussdk_sole.protocol.SoleProtocol.5
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    SoleProtocol.this.mHandler.sendEmptyMessage(1);
                }
            }, 1000L, 1000L);
            return;
        }
        int i = this.btType;
        if (i == 0) {
            this.myBluetoothClassic.writeMessage(MyBluetoothLE.completeCommand("F101"));
        } else {
            if (i != 1) {
                return;
            }
            this.myBluetoothLE.writeMessage(MyBluetoothLE.completeCommand("F101"), false);
        }
    }

    public void stopWorkout() throws NumberFormatException, IOException {
        if (this.isSimulationMode) {
            cancelSimulationTimer();
            dataResult("5b0203075d");
            this.simulationWorkoutMode = 7;
            if (this.deviceType == 0) {
                dataResult("5b0B32099901230011032188055d");
            } else if (this.deviceModel == 31) {
                dataResult("5b1132099911110022033388030700550000005500000055006600345d");
            } else {
                dataResult("5b1132099911110022033388030755006600345d");
            }
            Message message = new Message();
            message.what = 0;
            message.arg1 = 1;
            message.obj = "5b0203015d";
            this.mHandler.sendMessageDelayed(message, 30000L);
            return;
        }
        this.isStopMode = true;
        int i = this.btType;
        if (i == 0) {
            this.myBluetoothClassic.writeMessage(MyBluetoothLE.completeCommand("F106"));
            this.myBluetoothClassic.writeMessage(MyBluetoothLE.completeCommand("F106"));
        } else {
            if (i != 1) {
                return;
            }
            this.myBluetoothLE.writeMessage(MyBluetoothLE.completeCommand("F106"), true);
            this.myBluetoothLE.writeMessage(MyBluetoothLE.completeCommand("F106"), false);
        }
    }

    public void setLevelUp() throws IOException {
        int i;
        if (this.isSimulationMode) {
            int i2 = this.deviceType;
            if (i2 == 0) {
                int i3 = this.nowSpeed;
                if (i3 >= this.maxSpeed) {
                    return;
                }
                i = i3 + 1;
                this.nowSpeed = i;
            } else {
                int i4 = this.nowLevel;
                if (i4 >= this.maxLevel) {
                    return;
                }
                i = i4 + 1;
                this.nowLevel = i;
            }
            if (i2 != 0) {
                ArrayList<Number> arrayList = new ArrayList<>();
                arrayList.add(Integer.valueOf(i));
                this.mOnConnectStateListener.onDataResult(19, true, arrayList);
                return;
            }
            return;
        }
        int i5 = this.btType;
        if (i5 == 0) {
            this.myBluetoothClassic.writeMessage(MyBluetoothLE.completeCommand("F102"));
        } else {
            if (i5 != 1) {
                return;
            }
            this.myBluetoothLE.writeMessage(MyBluetoothLE.completeCommand("F102"), false);
        }
    }

    public void setLevelDown() throws IOException {
        int i;
        if (this.isSimulationMode) {
            int i2 = this.deviceType;
            if (i2 == 0) {
                int i3 = this.nowSpeed;
                if (i3 <= this.minSpeed) {
                    return;
                }
                i = i3 - 1;
                this.nowSpeed = i;
            } else {
                int i4 = this.nowLevel;
                if (i4 <= 5) {
                    return;
                }
                i = i4 - 1;
                this.nowLevel = i;
            }
            if (i2 != 0) {
                ArrayList<Number> arrayList = new ArrayList<>();
                arrayList.add(Integer.valueOf(i));
                this.mOnConnectStateListener.onDataResult(19, true, arrayList);
                return;
            }
            return;
        }
        int i5 = this.btType;
        if (i5 == 0) {
            this.myBluetoothClassic.writeMessage(MyBluetoothLE.completeCommand("F103"));
        } else {
            if (i5 != 1) {
                return;
            }
            this.myBluetoothLE.writeMessage(MyBluetoothLE.completeCommand("F103"), false);
        }
    }

    public void setInclineUp() throws IOException {
        if (this.isSimulationMode) {
            int i = this.nowIncline;
            if (i >= this.maxIncline) {
                return;
            }
            this.nowIncline = i + 1;
            if (this.deviceType != 0) {
                ArrayList<Number> arrayList = new ArrayList<>();
                arrayList.add(Integer.valueOf(this.nowIncline));
                this.mOnConnectStateListener.onDataResult(18, true, arrayList);
                return;
            }
            return;
        }
        int i2 = this.btType;
        if (i2 == 0) {
            this.myBluetoothClassic.writeMessage(MyBluetoothLE.completeCommand("F104"));
        } else {
            if (i2 != 1) {
                return;
            }
            this.myBluetoothLE.writeMessage(MyBluetoothLE.completeCommand("F104"), false);
        }
    }

    public void setInclineDown() throws IOException {
        if (this.isSimulationMode) {
            int i = this.nowIncline;
            if (i <= 5) {
                return;
            }
            this.nowIncline = i - 1;
            if (this.deviceType != 0) {
                ArrayList<Number> arrayList = new ArrayList<>();
                arrayList.add(Integer.valueOf(this.nowIncline));
                this.mOnConnectStateListener.onDataResult(18, true, arrayList);
                return;
            }
            return;
        }
        int i2 = this.btType;
        if (i2 == 0) {
            this.myBluetoothClassic.writeMessage(MyBluetoothLE.completeCommand("F105"));
        } else {
            if (i2 != 1) {
                return;
            }
            this.myBluetoothLE.writeMessage(MyBluetoothLE.completeCommand("F105"), false);
        }
    }

    public void sendCommandOK(int i) throws IOException {
        if (this.isSimulationMode) {
            return;
        }
        int i2 = this.btType;
        if (i2 == 0) {
            this.myBluetoothClassic.writeMessage(MyBluetoothLE.completeCommand("00" + getIntToHexString(i, 2) + "4F4B"));
            return;
        }
        if (i2 != 1) {
            return;
        }
        this.myBluetoothLE.writeMessage(MyBluetoothLE.completeCommand("00" + getIntToHexString(i, 2) + "4F4B"), false);
    }

    public void sendModeReceived(int i) throws IOException {
        if (this.isSimulationMode) {
            return;
        }
        int i2 = this.btType;
        if (i2 == 0) {
            this.myBluetoothClassic.writeMessage(MyBluetoothLE.completeCommand("03" + getIntToHexString(i, 2)));
            return;
        }
        if (i2 != 1) {
            return;
        }
        this.myBluetoothLE.writeMessage(MyBluetoothLE.completeCommand("03" + getIntToHexString(i, 2)), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getIntToHexString(int i, int i2) {
        StringBuilder sb = new StringBuilder(Integer.toHexString(i));
        int length = sb.length();
        if (length > i2) {
            sb.delete(0, length - i2);
        } else {
            while (length < i2) {
                sb.insert(0, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                length = sb.length();
            }
        }
        return sb.toString().toUpperCase();
    }

    public void setDeviceType(int i) {
        this.deviceType = i;
    }

    public void setDeviceModel(int i) {
        this.deviceModel = i;
    }

    public void setSalesVersion(int i) {
        this.salesVersion = i;
    }

    @Override // com.dyaco.ideabussdk_sole.bluetooth.MyBluetoothLE.OnWriteStateListener
    public void onWriteMessage(boolean z, String str) {
        Message message = new Message();
        message.what = 1000;
        message.arg1 = z ? 1 : 0;
        message.obj = str;
        this.mHandler.sendMessage(message);
        CustomVariable.printLog("d", TAG, "onwritemessage  -> " + str);
    }

    @Override // com.ideabus.bluetooth.BluetoothLEClass.OnIMBluetoothLEListener, com.dyaco.ideabussdk_sole.bluetooth.MyBluetoothClassic.OnConnectStateListener
    public void onBtStateChanged(boolean z) {
        this.mOnConnectStateListener.onBtStateChanged(z);
    }

    @Override // com.dyaco.ideabussdk_sole.bluetooth.MyBluetoothClassic.OnConnectStateListener
    public void scanResult(BluetoothDevice bluetoothDevice, int i) {
        this.mOnConnectStateListener.onScanResult(bluetoothDevice, i);
    }

    @Override // com.ideabus.bluetooth.BluetoothLEClass.OnIMBluetoothLEListener
    public void scanResult(String str, String str2, int i, byte[] bArr) {
        this.mOnConnectStateListener.onScanResult(str, str2, i);
    }

    @Override // com.ideabus.bluetooth.BluetoothLEClass.OnIMBluetoothLEListener, com.dyaco.ideabussdk_sole.bluetooth.MyBluetoothClassic.OnConnectStateListener
    public void connectionStatus(int i) throws IOException {
        CustomVariable.printLog("d", "test", "SoleProtocol-------connectionStatus   = " + i);
        if (i == 4) {
            this.mConnectState = ConnectState.ScanFinish;
        } else if (i == 20) {
            this.mConnectState = ConnectState.ConnectTimeout;
        } else if (i == 17) {
            this.allReceivedCommand = new StringBuilder();
            getDeviceInfo();
            return;
        } else if (i == 18) {
            MyBluetoothLE myBluetoothLE = this.myBluetoothLE;
            if (myBluetoothLE != null) {
                myBluetoothLE.isNewType = false;
            }
            this.mConnectState = ConnectState.Disconnect;
        }
        this.mOnConnectStateListener.onConnectionState(this.mConnectState);
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x01e2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00c1 A[SYNTHETIC] */
    @Override // com.ideabus.bluetooth.BluetoothLEClass.OnIMBluetoothLEListener, com.dyaco.ideabussdk_sole.bluetooth.MyBluetoothClassic.OnConnectStateListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void dataResult(String str) throws NumberFormatException {
        String str2 = TAG;
        CustomVariable.printLog("d", str2, "dataResult  -> " + str);
        try {
            String upperCase = str.toUpperCase(Locale.US);
            if (upperCase.contains("==")) {
                this.deviceName = upperCase.split("==")[0];
                upperCase = upperCase.split("==")[1];
            }
            Message message = new Message();
            message.what = 1001;
            message.obj = upperCase;
            this.mHandler.sendMessage(message);
            if (!upperCase.startsWith("5B040006") && !upperCase.startsWith("5B040032") && !upperCase.equals("5B0202")) {
                if (this.allReceivedCommand.length() != 0 || upperCase.length() > 4) {
                    if (this.allReceivedCommand.length() == 0 && !upperCase.startsWith(MyBluetoothLE.START)) {
                        StringBuilder sb = this.allReceivedCommand;
                        sb.delete(0, sb.length());
                        return;
                    }
                    this.allReceivedCommand.append(upperCase);
                    String string = this.allReceivedCommand.toString();
                    if (string.startsWith(MyBluetoothLE.START) && string.endsWith(MyBluetoothLE.END)) {
                        this.receiveErrorCount = 0;
                        CustomVariable.printLog("d", str2, "dataResult 全部接收完 message  ------> " + this.allReceivedCommand.toString());
                        while (this.allReceivedCommand.length() != 0) {
                            String string2 = this.allReceivedCommand.toString();
                            int i = Integer.parseInt(string2.substring(2, 4), 16);
                            int i2 = Integer.parseInt(string2.substring(4, 6), 16);
                            if (i2 == 0) {
                                i2 = Integer.parseInt(string2.substring(6, 8), 16);
                            }
                            String str3 = TAG;
                            CustomVariable.printLog("d", str3, "dataResult  cmd = " + i2);
                            int i3 = (i + 3) * 2;
                            CustomVariable.printLog("d", str3, "dataResult  commLength = " + i3);
                            String strSubstring = this.allReceivedCommand.substring(0, i3);
                            if (this.btType == 1 && !this.isSimulationMode && this.myBluetoothLE.getCommArraySize() > 0) {
                                String comm = this.myBluetoothLE.getComm(0);
                                int i4 = Integer.parseInt(comm.substring(4, 6), 16);
                                if (i4 == 0) {
                                    i4 = Integer.parseInt(comm.substring(6, 8), 16);
                                }
                                CustomVariable.printLog("d", str3, "dataResult cmd = " + i2 + " , writeCMD = " + i4);
                                CustomVariable.printLog("d", str3, "dataResult  message.length() = " + strSubstring.length() + " , commLength = " + i3);
                                if (strSubstring.length() >= i3 && i2 == i4) {
                                    handleReceived(i2, strSubstring);
                                    this.myBluetoothLE.sendCount = 0;
                                    if (!comm.startsWith("5B02F1")) {
                                        CustomVariable.printLog("d", str3, "dataResult  removeSameComm = " + comm);
                                        this.myBluetoothLE.removeSameComm(comm);
                                    }
                                    this.allReceivedCommand.delete(0, i3);
                                } else {
                                    CustomVariable.printLog("d", str3, "dataResult allReceivedCommand = " + this.allReceivedCommand.toString());
                                    if (this.allReceivedCommand.length() == 0) {
                                        handleReceived(i2, strSubstring);
                                        this.allReceivedCommand.delete(0, i3);
                                    }
                                }
                            } else {
                                CustomVariable.printLog("d", str3, "dataResult allReceivedCommand = " + this.allReceivedCommand.toString());
                                if (this.allReceivedCommand.length() == 0) {
                                }
                            }
                        }
                        return;
                    }
                    CustomVariable.printLog("d", str2, "還沒接收完 message  -> " + string);
                    this.receiveErrorCount = this.receiveErrorCount + 1;
                    CustomVariable.printLog("e", str2, "dataResult  receiveErrorCount = " + this.receiveErrorCount);
                    if (this.receiveErrorCount > 10) {
                        receiveError(string);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            receiveError(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:333:0x0bc4 A[Catch: Exception -> 0x0e5e, TryCatch #0 {Exception -> 0x0e5e, blocks: (B:325:0x0b05, B:327:0x0b0a, B:329:0x0b1a, B:331:0x0bc0, B:339:0x0bd2, B:340:0x0bed, B:343:0x0bf5, B:348:0x0c1c, B:356:0x0c65, B:365:0x0cf9, B:357:0x0c98, B:359:0x0ca0, B:361:0x0ca6, B:363:0x0cdf, B:362:0x0cc3, B:396:0x0e4f, B:398:0x0e5a, B:366:0x0d08, B:372:0x0d33, B:375:0x0d3a, B:379:0x0d92, B:384:0x0d9d, B:386:0x0dcc, B:390:0x0de8, B:395:0x0e4c, B:389:0x0dda, B:385:0x0db4, B:378:0x0d8a, B:333:0x0bc4, B:336:0x0bcb, B:393:0x0e32), top: B:420:0x0b05, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:374:0x0d38  */
    /* JADX WARN: Removed duplicated region for block: B:378:0x0d8a A[Catch: Exception -> 0x0e5e, TryCatch #0 {Exception -> 0x0e5e, blocks: (B:325:0x0b05, B:327:0x0b0a, B:329:0x0b1a, B:331:0x0bc0, B:339:0x0bd2, B:340:0x0bed, B:343:0x0bf5, B:348:0x0c1c, B:356:0x0c65, B:365:0x0cf9, B:357:0x0c98, B:359:0x0ca0, B:361:0x0ca6, B:363:0x0cdf, B:362:0x0cc3, B:396:0x0e4f, B:398:0x0e5a, B:366:0x0d08, B:372:0x0d33, B:375:0x0d3a, B:379:0x0d92, B:384:0x0d9d, B:386:0x0dcc, B:390:0x0de8, B:395:0x0e4c, B:389:0x0dda, B:385:0x0db4, B:378:0x0d8a, B:333:0x0bc4, B:336:0x0bcb, B:393:0x0e32), top: B:420:0x0b05, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:385:0x0db4 A[Catch: Exception -> 0x0e5e, TryCatch #0 {Exception -> 0x0e5e, blocks: (B:325:0x0b05, B:327:0x0b0a, B:329:0x0b1a, B:331:0x0bc0, B:339:0x0bd2, B:340:0x0bed, B:343:0x0bf5, B:348:0x0c1c, B:356:0x0c65, B:365:0x0cf9, B:357:0x0c98, B:359:0x0ca0, B:361:0x0ca6, B:363:0x0cdf, B:362:0x0cc3, B:396:0x0e4f, B:398:0x0e5a, B:366:0x0d08, B:372:0x0d33, B:375:0x0d3a, B:379:0x0d92, B:384:0x0d9d, B:386:0x0dcc, B:390:0x0de8, B:395:0x0e4c, B:389:0x0dda, B:385:0x0db4, B:378:0x0d8a, B:333:0x0bc4, B:336:0x0bcb, B:393:0x0e32), top: B:420:0x0b05, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:388:0x0dd8  */
    /* JADX WARN: Removed duplicated region for block: B:389:0x0dda A[Catch: Exception -> 0x0e5e, TryCatch #0 {Exception -> 0x0e5e, blocks: (B:325:0x0b05, B:327:0x0b0a, B:329:0x0b1a, B:331:0x0bc0, B:339:0x0bd2, B:340:0x0bed, B:343:0x0bf5, B:348:0x0c1c, B:356:0x0c65, B:365:0x0cf9, B:357:0x0c98, B:359:0x0ca0, B:361:0x0ca6, B:363:0x0cdf, B:362:0x0cc3, B:396:0x0e4f, B:398:0x0e5a, B:366:0x0d08, B:372:0x0d33, B:375:0x0d3a, B:379:0x0d92, B:384:0x0d9d, B:386:0x0dcc, B:390:0x0de8, B:395:0x0e4c, B:389:0x0dda, B:385:0x0db4, B:378:0x0d8a, B:333:0x0bc4, B:336:0x0bcb, B:393:0x0e32), top: B:420:0x0b05, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:392:0x0e30  */
    /* JADX WARN: Removed duplicated region for block: B:406:0x0ead  */
    /* JADX WARN: Removed duplicated region for block: B:412:0x0ee9  */
    /* JADX WARN: Removed duplicated region for block: B:415:0x0eee  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0214  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleReceived(final int i, String str) throws IOException, NumberFormatException {
        ArrayList<Number> arrayList;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        float f;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        BigDecimal bigDecimalDivide;
        float f2;
        float f3;
        Log.e("checkNoWork", "cmd : " + i + " | message : " + str);
        if (!str.startsWith(MyBluetoothLE.START) || !str.endsWith(MyBluetoothLE.END)) {
            CustomVariable.printLog("d", TAG, "接收錯誤 丟棄 message  -> " + str);
            Log.e("checkNoWork", "接收錯誤 丟棄 message  -> : " + str);
            return;
        }
        String strSubstring = str.substring(2, str.length() - 2);
        String str2 = TAG;
        CustomVariable.printLog("d", str2, "handleReceived cmd = " + i);
        boolean z = true;
        if (i == 0) {
            arrayList = null;
            i2 = Integer.parseInt(strSubstring.substring(6, 8), 16);
            int i16 = Integer.parseInt(strSubstring.substring(8, 10), 16);
            if (i2 != 79 || i16 != 75) {
                z = false;
            }
        } else if (i == 25) {
            arrayList = new ArrayList<>(1);
            arrayList.add(Integer.valueOf(Integer.parseInt(strSubstring.substring(4, 6), 16)));
            int i17 = Integer.parseInt(strSubstring.substring(2, 4), 16);
            if (i17 != 0) {
                sendCommandOK(i17);
            } else {
                i2 = Integer.parseInt(strSubstring.substring(6, 8), 16);
                int i162 = Integer.parseInt(strSubstring.substring(8, 10), 16);
                if (i2 != 79) {
                    z = false;
                }
            }
        } else {
            if (i == 50) {
                Log.e("getEndMessage", "0x32");
                this.lastSecond = 0;
                this.totalSteps = 0.0f;
                sendCommandOK(i);
                final String str3 = MyBluetoothLE.START + strSubstring + MyBluetoothLE.END;
                Log.e("checkNoWork", "0x32 model : " + this.deviceModel + " | message : " + strSubstring);
                try {
                } catch (Exception e) {
                    if (this.onErrorHappened != null) {
                        Log.e("getError", BuildConfig.FLAVOR + e.toString() + Arrays.toString(e.getStackTrace()));
                        this.onErrorHappened.onError(e.toString() + Arrays.toString(e.getStackTrace()));
                    }
                }
                if (this.deviceModel == -1) {
                    new Handler().postDelayed(new Runnable() { // from class: com.dyaco.ideabussdk_sole.protocol.SoleProtocol.6
                        @Override // java.lang.Runnable
                        public void run() throws IOException, NumberFormatException {
                            SoleProtocol.access$1612(SoleProtocol.this, 1);
                            if (SoleProtocol.this.repeat32 > 30) {
                                return;
                            }
                            SoleProtocol.this.handleReceived(i, str3);
                        }
                    }, 50L);
                    return;
                }
                this.repeat32 = 0;
                float f4 = Integer.parseInt(strSubstring.substring(8, 12), 16);
                float f5 = Integer.parseInt(strSubstring.substring(12, 16), 16);
                Log.e("getCalories", "message : " + strSubstring.substring(12, 16));
                Log.e("getCalories", "endDistance : " + f4);
                Log.e("getCalories", "endCalories : " + f5);
                Log.e("checksoleerror", "endDistance : " + f4);
                Log.e("checksoleerror", "endCalories : " + f5);
                Log.e("checksoleerror", "type : " + this.deviceType);
                int i18 = this.deviceModel;
                if (i18 != 133) {
                    switch (i18) {
                        case 147:
                        case 148:
                        case 149:
                            float f6 = this.totalDistance;
                            if (f6 > 0.0f) {
                                f4 = f6;
                            }
                            float f7 = this.totalCalories;
                            if (f7 > 0.0f) {
                                f5 = f7;
                                break;
                            }
                            break;
                    }
                    this.weightTrans = getWeightTransMetric();
                    EndWorkoutData endWorkoutData = new EndWorkoutData();
                    endWorkoutData.setGetnum(strSubstring);
                    endWorkoutData.setSeconds(Integer.parseInt(strSubstring.substring(4, 8), 16));
                    switch (this.deviceModel) {
                        case 18:
                        case 19:
                        case 22:
                        case 23:
                        case 24:
                            i3 = 10;
                            break;
                        case 20:
                        case 21:
                        default:
                            i3 = 100;
                            break;
                    }
                    endWorkoutData.setDistance(new BigDecimal(f4).divide(new BigDecimal(String.valueOf(i3)), 2, RoundingMode.HALF_UP).floatValue());
                    int i19 = this.deviceType;
                    if (i19 == 1 || i19 == 2) {
                        endWorkoutData.setCalories(new BigDecimal(f5).divide(new BigDecimal("10"), 2, RoundingMode.HALF_UP).floatValue());
                        int i20 = this.deviceModel;
                        if (i20 == 20 || i20 == 21 || i20 == 29) {
                            i4 = 10;
                            endWorkoutData.setSpeed(new BigDecimal(Integer.parseInt(strSubstring.substring(16, 20), 16)).divide(new BigDecimal(i4), 1, RoundingMode.HALF_UP).floatValue());
                            endWorkoutData.setHeartRate(Integer.parseInt(strSubstring.substring(20, 22), 16));
                            endWorkoutData.setIncline(Integer.parseInt(strSubstring.substring(22, 24), 16));
                            endWorkoutData.setLevel(Integer.parseInt(strSubstring.substring(24, 26), 16));
                            i5 = this.deviceBrand;
                            if (i5 != 1 || i5 == 0) {
                                endWorkoutData.setLevel(endWorkoutData.getLevel() + 1);
                            }
                            i6 = this.deviceModel;
                            if (i6 != 30 || i6 == 31) {
                                i7 = Integer.parseInt(strSubstring.substring(26, 30), 16);
                                i8 = Integer.parseInt(strSubstring.substring(46, 50), 16);
                            } else {
                                i7 = Integer.parseInt(strSubstring.substring(26, 28), 16);
                                i8 = Integer.parseInt(strSubstring.substring(28, 32), 16);
                            }
                            endWorkoutData.setRpm(i7);
                            endWorkoutData.setWatt(i8);
                            float f8 = this.weightTrans;
                            f = f8 != 0.0f ? 0.0f : ((((i8 * 6) / f8) * 1.8f) + 7.0f) / 3.5f;
                            Log.e("mynumnow", "mets : " + f);
                            Log.e("mynumnow", "watt : " + i8);
                            Log.e("mynumnow", "weightTrans : " + this.weightTrans);
                            if (i7 == 0) {
                                f = 1.0f;
                            }
                            try {
                                endWorkoutData.setMets(new BigDecimal(f).divide(new BigDecimal(1), 2, RoundingMode.HALF_UP).floatValue());
                            } catch (Exception unused) {
                                endWorkoutData.setMets(0.0f);
                            }
                        } else {
                            switch (i20) {
                                case 25:
                                case 26:
                                case 27:
                                    break;
                                default:
                                    i4 = 100;
                                    break;
                            }
                            endWorkoutData.setSpeed(new BigDecimal(Integer.parseInt(strSubstring.substring(16, 20), 16)).divide(new BigDecimal(i4), 1, RoundingMode.HALF_UP).floatValue());
                            endWorkoutData.setHeartRate(Integer.parseInt(strSubstring.substring(20, 22), 16));
                            endWorkoutData.setIncline(Integer.parseInt(strSubstring.substring(22, 24), 16));
                            endWorkoutData.setLevel(Integer.parseInt(strSubstring.substring(24, 26), 16));
                            i5 = this.deviceBrand;
                            if (i5 != 1) {
                                endWorkoutData.setLevel(endWorkoutData.getLevel() + 1);
                                i6 = this.deviceModel;
                                if (i6 != 30) {
                                    i7 = Integer.parseInt(strSubstring.substring(26, 30), 16);
                                    i8 = Integer.parseInt(strSubstring.substring(46, 50), 16);
                                    endWorkoutData.setRpm(i7);
                                    endWorkoutData.setWatt(i8);
                                    float f82 = this.weightTrans;
                                    if (f82 != 0.0f) {
                                    }
                                    Log.e("mynumnow", "mets : " + f);
                                    Log.e("mynumnow", "watt : " + i8);
                                    Log.e("mynumnow", "weightTrans : " + this.weightTrans);
                                    if (i7 == 0) {
                                    }
                                    endWorkoutData.setMets(new BigDecimal(f).divide(new BigDecimal(1), 2, RoundingMode.HALF_UP).floatValue());
                                }
                            }
                        }
                    } else if (i19 == 0) {
                        endWorkoutData.setCalories(new BigDecimal(f5).divide(new BigDecimal(AppEventsConstants.EVENT_PARAM_VALUE_YES), 2, RoundingMode.HALF_UP).floatValue());
                        Log.e("checksoleerror", "endCalories : " + endWorkoutData.getCalories());
                        BigDecimal bigDecimalDivide2 = BigDecimal.ZERO;
                        int i21 = this.deviceModel;
                        if ((i21 >= 128 && i21 <= 132) || (i21 >= 144 && i21 <= 146)) {
                            bigDecimalDivide2 = new BigDecimal(Integer.parseInt(strSubstring.substring(16, 18), 16)).divide(new BigDecimal(10), 1, RoundingMode.HALF_UP);
                            i10 = Integer.parseInt(strSubstring.substring(18, 20), 16);
                            i9 = Integer.parseInt(strSubstring.substring(20, 22), 16);
                        } else if (strSubstring.length() >= 24) {
                            if (this.deviceModel == 135) {
                                bigDecimalDivide2 = new BigDecimal(Integer.parseInt(strSubstring.substring(16, 20), 16)).divide(new BigDecimal(10), 1, RoundingMode.HALF_UP);
                            } else {
                                bigDecimalDivide2 = new BigDecimal(Integer.parseInt(strSubstring.substring(16, 20), 16)).divide(new BigDecimal(100), 1, RoundingMode.FLOOR);
                            }
                            int i22 = Integer.parseInt(strSubstring.substring(20, 22), 16);
                            i9 = Integer.parseInt(strSubstring.substring(22, 24), 16);
                            i10 = i22;
                        } else {
                            i9 = 0;
                            i10 = 0;
                        }
                        endWorkoutData.setSpeed(bigDecimalDivide2.floatValue());
                        endWorkoutData.setHeartRate(i10);
                        endWorkoutData.setIncline(i9);
                    }
                    Log.e("getEndMessage", "soleProtocol");
                    OnConnectStateListener onConnectStateListener = this.mOnConnectStateListener;
                    if (onConnectStateListener != null) {
                        onConnectStateListener.onEndWorkoutResult(endWorkoutData);
                    }
                    resetCalDis();
                }
            } else if (i == 64) {
                sendCommandOK(i);
                int i23 = (Integer.parseInt(strSubstring.substring(0, 2), 16) - 1) * 2;
                ArrayList<Number> arrayList2 = new ArrayList<>();
                int i24 = 4;
                while (i24 < i23 + 4) {
                    int i25 = i24 + 2;
                    arrayList2.add(Integer.valueOf(Integer.parseInt(strSubstring.substring(i24, i25), 16)));
                    i24 = i25;
                }
                CustomVariable.printLog("e", TAG, "dataResult Program圖形 messages = " + arrayList2);
                arrayList = arrayList2;
            } else if (i == 2) {
                int i26 = Integer.parseInt(strSubstring.substring(4, 6), 16);
                arrayList = new ArrayList<>(1);
                arrayList.add(Integer.valueOf(i26));
                if (i26 == 2) {
                    resetBugParams();
                }
            } else if (i != 3) {
                if (i != 4 && i != 37 && i != 38) {
                    if (i == 240) {
                        this.deviceModel = Integer.parseInt(strSubstring.substring(4, 6), 16);
                        Log.e("checkNoWork", "0xF0 -------------------------model : " + this.deviceModel);
                        if ("E95s".equals(this.deviceName)) {
                            this.deviceModel = 27;
                        } else if ("LCR".equals(this.deviceName)) {
                            this.deviceModel = 21;
                        } else if ("S77".equals(this.deviceName)) {
                            this.deviceModel = 148;
                        } else if ("XT385".equals(this.deviceName)) {
                            this.deviceModel = 130;
                        } else if ("B94".equals(this.deviceName)) {
                            this.deviceModel = 18;
                        }
                        int i27 = this.deviceModel;
                        if ((i27 >= 0 && i27 < 3) || ((i27 >= 16 && i27 < 22) || ((i27 >= 37 && i27 < 39) || ((i27 >= 96 && i27 < 98) || i27 == 84 || i27 == 85 || i27 == 87 || i27 == 88 || i27 == 14)))) {
                            this.deviceType = 1;
                        } else if (i27 == 39 || ((i27 >= 3 && i27 < 16) || ((i27 >= 22 && i27 < 32) || ((i27 >= 48 && i27 < 64) || ((i27 >= 100 && i27 <= 106) || ((i27 >= 112 && i27 <= 118) || i27 == 119 || i27 == 83 || i27 == 86 || i27 == 99)))))) {
                            this.deviceType = 2;
                        } else if (i27 >= 128 && i27 < 192) {
                            this.deviceType = 0;
                        } else {
                            this.deviceType = 1;
                        }
                        Log.e("soleprotocol", String.valueOf(this.deviceType));
                        Log.e("getProtocloHandler", "model : " + String.valueOf(this.deviceModel));
                        int i28 = this.deviceModel;
                        if ((i28 >= 16 && i28 < 32) || (i28 >= 144 && i28 < 160)) {
                            this.deviceBrand = 0;
                        } else if ((i28 >= 0 && i28 < 16) || ((i28 >= 83 && i28 <= 88) || ((i28 >= 128 && i28 < 144) || (i28 >= 96 && i28 < 98)))) {
                            this.deviceBrand = 1;
                        } else if ((i28 >= 48 && i28 < 64) || ((i28 >= 160 && i28 < 176) || (i28 >= 112 && i28 <= 119))) {
                            this.deviceBrand = 2;
                        } else if ((i28 >= 32 && i28 < 48) || ((i28 >= 100 && i28 <= 106) || (i28 >= 176 && i28 < 192))) {
                            this.deviceBrand = 3;
                        } else {
                            this.deviceBrand = 0;
                        }
                        this.salesVersion = Integer.parseInt(strSubstring.substring(6, 8), 16);
                        this.deviceUnit = Integer.parseInt(strSubstring.substring(8, 10), 16);
                        CustomVariable.printLog("d", str2, "dataResult  機種 = " + this.deviceModel);
                        StringBuilder sb = new StringBuilder();
                        sb.append("dataResult  版本 = ");
                        sb.append(this.salesVersion == 0 ? "國際版" : "美國版");
                        CustomVariable.printLog("d", str2, sb.toString());
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("dataResult  版本 = ");
                        sb2.append(this.deviceUnit == 0 ? "公制" : "英制");
                        CustomVariable.printLog("d", str2, sb2.toString());
                        int i29 = this.deviceType;
                        if (i29 == 1 || i29 == 2) {
                            try {
                                this.maxIncline = Integer.parseInt(strSubstring.substring(10, 12), 16);
                                this.maxLevel = Integer.parseInt(strSubstring.substring(12, 14), 16);
                                this.userSegment = Integer.parseInt(strSubstring.substring(14, 16), 16);
                                this.showInclineMode = Integer.parseInt(strSubstring.substring(16, 18), 16);
                                if (Integer.parseInt(strSubstring.substring(18, 20), 16) != 1) {
                                    z = false;
                                }
                                this.hasMaxIncline = z;
                                CustomVariable.printLog("d", str2, "dataResult  Incline最大階 = " + this.maxIncline);
                                CustomVariable.printLog("d", str2, "dataResult  Level最大階 = " + this.maxLevel);
                                CustomVariable.printLog("d", str2, "dataResult  User Segment = " + this.userSegment);
                                CustomVariable.printLog("d", str2, "dataResult  Incline顯示方式 = " + this.showInclineMode);
                                CustomVariable.printLog("d", str2, "dataResult  Incline是否有MaxIncline功能 = " + this.hasMaxIncline);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                this.maxIncline = 0;
                                this.maxLevel = 0;
                                this.userSegment = 0;
                                this.showInclineMode = 0;
                                this.hasMaxIncline = false;
                            }
                        } else if (i29 == 0) {
                            try {
                                this.maxSpeed = Integer.parseInt(strSubstring.substring(10, 12), 16);
                                this.minSpeed = Integer.parseInt(strSubstring.substring(12, 14), 16);
                                this.maxIncline = Integer.parseInt(strSubstring.substring(14, 16), 16);
                                this.userSegment = Integer.parseInt(strSubstring.substring(16, 18), 16);
                                CustomVariable.printLog("d", str2, "dataResult  Speed最高速 = " + this.maxSpeed);
                                CustomVariable.printLog("d", str2, "dataResult  Speed最低速 = " + this.minSpeed);
                                CustomVariable.printLog("d", str2, "dataResult  Incline最大階 = " + this.maxIncline);
                                CustomVariable.printLog("d", str2, "dataResult  userSegment = " + this.userSegment);
                            } catch (NumberFormatException e3) {
                                e3.printStackTrace();
                                this.maxSpeed = 0;
                                this.minSpeed = 0;
                                this.maxIncline = 0;
                                this.userSegment = 0;
                            }
                        }
                        if (this.isSimulationMode) {
                            this.maxSpeed = 130;
                            this.minSpeed = 5;
                            this.maxIncline = 20;
                            this.maxLevel = 32;
                        }
                        if (this.mConnectState != ConnectState.Connected) {
                            ConnectState connectState = ConnectState.Connected;
                            this.mConnectState = connectState;
                            this.mOnConnectStateListener.onConnectionState(connectState);
                            return;
                        }
                        return;
                    }
                    if (i == 241) {
                        sendCommandOK(i);
                        int i30 = Integer.parseInt(strSubstring.substring(4, 6), 16);
                        arrayList = new ArrayList<>(1);
                        arrayList.add(Integer.valueOf(i30));
                    } else {
                        switch (i) {
                            case 6:
                                sendCommandOK(i);
                                if (this.deviceModel != -1) {
                                    Log.e("checksoleProtocol", i + "");
                                    this.weightTrans = getWeightTransMetric();
                                    WorkoutData workoutData = new WorkoutData();
                                    int i31 = Integer.parseInt(strSubstring.substring(4, 6), 16);
                                    int i32 = Integer.parseInt(strSubstring.substring(6, 8), 16);
                                    workoutData.setMinute(i31);
                                    workoutData.setSeconds(i32);
                                    float f9 = Integer.parseInt(strSubstring.substring(8, 12), 16);
                                    float f10 = Integer.parseInt(strSubstring.substring(12, 16), 16);
                                    Log.e("caloriesGet", "message : " + strSubstring.substring(12, 16));
                                    Log.e("caloriesGet", "calories : " + f10);
                                    int i33 = this.deviceModel;
                                    if (i33 != 133) {
                                        switch (i33) {
                                            case 147:
                                            case 148:
                                            case 149:
                                                if (!this.isCalcDis && f9 >= 255.0f) {
                                                    this.isCalcDis = true;
                                                    this.calcDisCount++;
                                                    this.isTransformDis = false;
                                                } else if (f9 == 0.0f) {
                                                    this.isCalcDis = false;
                                                    this.isTransformDis = true;
                                                    if (this.isResetDis) {
                                                        this.resetDisCount++;
                                                        this.calcDisCount = 0;
                                                    }
                                                    this.isResetDis = false;
                                                }
                                                if (this.isTransformDis) {
                                                    i11 = this.calcDisCount;
                                                } else {
                                                    i11 = this.calcDisCount;
                                                    if (i11 > 0) {
                                                        i11--;
                                                    }
                                                }
                                                f9 += i11 * 256;
                                                if (!this.isCalcCal && f10 >= 255.0f) {
                                                    this.isCalcCal = true;
                                                    this.calcCalCount++;
                                                    this.isTransformCal = false;
                                                } else if (f10 == 0.0f) {
                                                    this.isCalcCal = false;
                                                    this.isTransformCal = true;
                                                    if (this.isResetCal) {
                                                        this.resetCalCount++;
                                                        this.calcCalCount = 0;
                                                    }
                                                    this.isResetCal = false;
                                                }
                                                if (this.isTransformCal) {
                                                    i12 = this.calcCalCount;
                                                } else {
                                                    i12 = this.calcCalCount;
                                                    if (i12 > 0) {
                                                        i12--;
                                                    }
                                                }
                                                f10 += i12 * 256;
                                                this.totalDistance = f9;
                                                this.totalCalories = f10;
                                                if (f9 == 9999.0f) {
                                                    this.isResetDis = true;
                                                }
                                                if (f10 == 999.0f || f10 == 998.0f) {
                                                    this.isResetCal = true;
                                                    break;
                                                }
                                                break;
                                        }
                                        Log.e("checkDis", f9 + AppEventsConstants.EVENT_PARAM_VALUE_YES);
                                        float fFloatValue = new BigDecimal((double) f9).divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP).floatValue();
                                        Log.e("checkDis", fFloatValue + ExifInterface.GPS_MEASUREMENT_2D);
                                        workoutData.setDistance(fFloatValue);
                                        workoutData.setHeartRate(Integer.parseInt(strSubstring.substring(16, 18), 16));
                                        int i34 = this.deviceType;
                                        if (i34 == 1 || i34 == 2) {
                                            Log.e("checksoleProtocol", String.valueOf(i34));
                                            int i35 = this.deviceModel;
                                            if (i35 == 31 || i35 == 30 || i35 == 10) {
                                                workoutData.setCalories(new BigDecimal(f10).divide(new BigDecimal(AppEventsConstants.EVENT_PARAM_VALUE_YES), 1, RoundingMode.HALF_UP).floatValue());
                                                workoutData.setNowLevel(Integer.parseInt(strSubstring.substring(18, 20), 16) + 1);
                                                workoutData.setNowIncline(Integer.parseInt(strSubstring.substring(20, 24), 16));
                                                workoutData.setSpm(Integer.parseInt(strSubstring.substring(24, 28), 16));
                                                workoutData.setTotalSteps(Integer.parseInt(strSubstring.substring(28, 36), 16));
                                                workoutData.setVert(Integer.parseInt(strSubstring.substring(36, 44), 16));
                                                Log.e("checkvert", "" + strSubstring.substring(36, 44));
                                                int i36 = Integer.parseInt(strSubstring.substring(44, 48), 16);
                                                workoutData.setHrType(Integer.parseInt(strSubstring.substring(48, 50), 16));
                                                workoutData.setProgramRow(Integer.parseInt(strSubstring.substring(54, 56), 16));
                                                workoutData.setProgramHeight(Integer.parseInt(strSubstring.substring(56, 58), 16));
                                                i13 = i36;
                                                i14 = 0;
                                            } else {
                                                if (i35 == 39) {
                                                    Log.e("message soleProtocol", strSubstring);
                                                }
                                                workoutData.setCalories(new BigDecimal(f10).divide(new BigDecimal("10"), 1, RoundingMode.HALF_UP).floatValue());
                                                i14 = Integer.parseInt(strSubstring.substring(18, 20), 16);
                                                workoutData.setRpm(i14);
                                                workoutData.setSpeed(new BigDecimal(Integer.parseInt(strSubstring.substring(20, 24), 16)).divide(new BigDecimal(100), 1, RoundingMode.HALF_UP).floatValue());
                                                i13 = Integer.parseInt(strSubstring.substring(24, 28), 16);
                                                workoutData.setHrType(Integer.parseInt(strSubstring.substring(32, 34), 16));
                                                workoutData.setFusionIntervalTime(Integer.parseInt(strSubstring.substring(34, 36), 16));
                                                workoutData.setFusionRecoveryTime(Integer.parseInt(strSubstring.substring(36, 38), 16));
                                                workoutData.setProgramRow(Integer.parseInt(strSubstring.substring(38, 40), 16));
                                                Log.e("checkvert", "FusionRecoveryTime : " + strSubstring.substring(36, 38));
                                                Log.e("checkvert", "ProgramRow : " + strSubstring.substring(38, 40));
                                                int i37 = i14 * 2;
                                                float f11 = ((float) i37) / 60.0f;
                                                if (this.lastSecond != i32) {
                                                    this.lastSecond = i32;
                                                    this.totalSteps += MyVariable.getScaleToFloat(f11, 1);
                                                }
                                                workoutData.setSpm(i37);
                                                workoutData.setTotalSteps((int) this.totalSteps);
                                                workoutData.setVert(getVert());
                                            }
                                            workoutData.setWatt(i13);
                                            float f12 = ((((i13 * 6) / this.weightTrans) * 1.8f) + 7.0f) / 3.5f;
                                            if (i14 == 0) {
                                                f12 = 1.0f;
                                            }
                                            workoutData.setMets(new BigDecimal(f12).divide(new BigDecimal(1), 2, RoundingMode.HALF_UP).floatValue());
                                            float f13 = ((((f12 * 3.5f) * this.weightTrans) / 200.0f) / 60.0f) * 60.0f * 60.0f;
                                            workoutData.setCalHour(f13);
                                            workoutData.setCalSeconds(f13);
                                        } else if (i34 == 0) {
                                            workoutData.setCalories(new BigDecimal(f10).divide(new BigDecimal(AppEventsConstants.EVENT_PARAM_VALUE_YES), 1, RoundingMode.HALF_UP).floatValue());
                                            if (this.deviceModel == 135) {
                                                int i38 = Integer.parseInt(strSubstring.substring(18, 20), 16);
                                                if (i38 > 80) {
                                                    int i39 = i38 - 255;
                                                    Log.e("XT100TSpeed", "getSpeed : " + i38 + " - setSpeed : " + i39);
                                                    bigDecimalDivide = new BigDecimal(i39).divide(new BigDecimal(10), 1, RoundingMode.HALF_UP);
                                                } else {
                                                    bigDecimalDivide = new BigDecimal(i38).divide(new BigDecimal(10), 1, RoundingMode.HALF_UP);
                                                }
                                                i15 = 20;
                                            } else {
                                                i15 = 20;
                                                bigDecimalDivide = new BigDecimal(Integer.parseInt(strSubstring.substring(18, 20), 16)).divide(new BigDecimal(10), 1, RoundingMode.HALF_UP);
                                            }
                                            float fFloatValue2 = bigDecimalDivide.floatValue();
                                            workoutData.setSpeed(fFloatValue2);
                                            int i40 = Integer.parseInt(strSubstring.substring(i15, 22), 16);
                                            workoutData.setNowIncline(i40);
                                            workoutData.setHrType(Integer.parseInt(strSubstring.substring(22, 24), 16));
                                            workoutData.setFusionIntervalTime(Integer.parseInt(strSubstring.substring(24, 26), 16));
                                            workoutData.setFusionRecoveryTime(Integer.parseInt(strSubstring.substring(26, 28), 16));
                                            workoutData.setProgramRow(Integer.parseInt(strSubstring.substring(28, 30), 16));
                                            workoutData.setProgramHeight(Integer.parseInt(strSubstring.substring(30, 32), 16));
                                            float speedTransEnglish = getSpeedTransEnglish(fFloatValue2);
                                            float f14 = (i40 / this.maxIncline) * 100;
                                            float weightTransEnglish = getWeightTransEnglish();
                                            if (speedTransEnglish < 3.7f) {
                                                f2 = (0.768f * speedTransEnglish) + 1.0f;
                                                f3 = 0.137f;
                                            } else {
                                                f2 = (1.532f * speedTransEnglish) + 1.0f;
                                                f3 = 0.0685f;
                                            }
                                            float f15 = (((f2 + ((speedTransEnglish * f3) * f14)) * weightTransEnglish) / 2.2f) / 3600.0f;
                                            workoutData.setCalHour(f15 * 60.0f * 60.0f);
                                            workoutData.setCalSeconds(f15);
                                        }
                                        workoutData.setLaps((int) (fFloatValue / getCircleDistance()));
                                        float speed = workoutData.getSpeed();
                                        BigDecimal bigDecimalDivide3 = new BigDecimal(3600).divide(new BigDecimal(speed == 0.0f ? 1.0d : speed).divide(new BigDecimal(1), 1, RoundingMode.HALF_UP), 2, RoundingMode.HALF_UP);
                                        int iIntValue = new BigDecimal(bigDecimalDivide3.intValue()).divide(new BigDecimal(60), 2, RoundingMode.HALF_UP).intValue();
                                        int iIntValue2 = bigDecimalDivide3.intValue() - (iIntValue * 60);
                                        workoutData.setPaceMinute(String.valueOf(iIntValue));
                                        workoutData.setPaceSeconds(MyVariable.getFillString(iIntValue2, 2, AppEventsConstants.EVENT_PARAM_VALUE_NO));
                                        this.mOnConnectStateListener.onWorkoutResult(workoutData);
                                        break;
                                    }
                                }
                                break;
                            case 7:
                            case 8:
                                break;
                            case 9:
                                sendCommandOK(i);
                                arrayList = new ArrayList<>();
                                arrayList.add(Integer.valueOf(Integer.parseInt(strSubstring.substring(4, 6), 16)));
                                if (this.deviceType == 0) {
                                    arrayList.add(Integer.valueOf(Integer.parseInt(strSubstring.substring(6, 8), 16)));
                                    break;
                                }
                                break;
                            default:
                                switch (i) {
                                    case 16:
                                        sendCommandOK(i);
                                        int i41 = Integer.parseInt(strSubstring.substring(4, 6), 16);
                                        CustomVariable.printLog("e", str2, "dataResult Error Code = " + i41);
                                        arrayList = new ArrayList<>(1);
                                        arrayList.add(Integer.valueOf(i41));
                                        break;
                                    case 17:
                                        sendCommandOK(i);
                                        float scaleToFloat = MyVariable.getScaleToFloat(Integer.parseInt(strSubstring.substring(4, 6), 16) * 0.1f, 1);
                                        arrayList = new ArrayList<>(1);
                                        arrayList.add(Float.valueOf(scaleToFloat));
                                        break;
                                    case 18:
                                        sendCommandOK(i);
                                        arrayList = new ArrayList<>(1);
                                        arrayList.add(Integer.valueOf(Integer.parseInt(strSubstring.substring(4, 6), 16) + 1));
                                        break;
                                    case 19:
                                        sendCommandOK(i);
                                        arrayList = new ArrayList<>(1);
                                        arrayList.add(Integer.valueOf(Integer.parseInt(strSubstring.substring(4, 6), 16) + 1));
                                        break;
                                    case 20:
                                        sendCommandOK(i);
                                        arrayList = new ArrayList<>(2);
                                        arrayList.add(Integer.valueOf(Integer.parseInt(strSubstring.substring(4, 6), 16)));
                                        arrayList.add(Integer.valueOf(Integer.parseInt(strSubstring.substring(6, 8), 16)));
                                        break;
                                    case 21:
                                        sendCommandOK(i);
                                        arrayList = new ArrayList<>(1);
                                        arrayList.add(Integer.valueOf(Integer.parseInt(strSubstring.substring(4, 6), 16)));
                                        break;
                                    default:
                                        switch (i) {
                                            case 32:
                                            case 33:
                                            case 34:
                                            case 35:
                                                break;
                                            default:
                                                receiveError(strSubstring);
                                                break;
                                        }
                                }
                        }
                        return;
                    }
                }
                arrayList = null;
                i2 = Integer.parseInt(strSubstring.substring(6, 8), 16);
                int i1622 = Integer.parseInt(strSubstring.substring(8, 10), 16);
                if (i2 != 79) {
                }
            } else {
                int i42 = Integer.parseInt(strSubstring.substring(4, 6), 16);
                sendModeReceived(i42);
                if (this.isStopMode) {
                    this.isStopMode = false;
                    return;
                }
                arrayList = new ArrayList<>(1);
                arrayList.add(Integer.valueOf(i42));
                if (i42 == 7) {
                    resetBugParams();
                }
            }
            arrayList = null;
        }
        this.mOnConnectStateListener.onDataResult(i, z, arrayList);
        this.receiveErrorCount = 0;
    }

    public void resetCalDis() {
        this.totalCalories = 0.0f;
        this.totalDistance = 0.0f;
    }

    private void receiveError(String str) {
        String str2 = TAG;
        CustomVariable.printLog("e", str2, "接收錯誤 receiveError = " + str);
        this.receiveErrorCount = 0;
        int iIndexOf = this.allReceivedCommand.toString().toUpperCase(Locale.US).indexOf("5D5B");
        CustomVariable.printLog("e", str2, "接收錯誤 errorIndex(要+2) = " + iIndexOf);
        StringBuilder sb = this.allReceivedCommand;
        sb.delete(0, iIndexOf == -1 ? sb.length() : iIndexOf + 2);
        CustomVariable.printLog("e", str2, "接收錯誤 allReceivedCommand = " + this.allReceivedCommand.toString());
    }

    private void resetBugParams() {
        this.calcCalCount = 0;
        this.calcDisCount = 0;
        this.isCalcCal = false;
        this.isCalcDis = false;
        this.isTransformCal = true;
        this.isTransformDis = true;
        this.isResetCal = false;
        this.isResetDis = false;
        this.resetCalCount = 0;
        this.resetDisCount = 0;
    }

    private void startSimulationTimer() {
        cancelSimulationTimer();
        this.position = 0;
        Timer timer = new Timer();
        this.simulationTimer = timer;
        timer.schedule(new TimerTask() { // from class: com.dyaco.ideabussdk_sole.protocol.SoleProtocol.7
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                SoleProtocol.this.mHandler.sendEmptyMessage(100);
            }
        }, 1000L, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelSimulationTimer() {
        Timer timer = this.simulationTimer;
        if (timer != null) {
            timer.cancel();
            this.simulationTimer = null;
        }
    }

    public float getCircleDistance() {
        return this.deviceUnit == 0 ? 0.4f : 0.25f;
    }

    private float getWeightTransMetric() {
        return this.deviceUnit == 0 ? this.weight : this.weight / 2.2f;
    }

    private float getWeightTransEnglish() {
        return this.deviceUnit == 0 ? this.weight / 0.453f : this.weight;
    }

    private float getSpeedTransEnglish(float f) {
        return this.deviceUnit == 0 ? f / 1.6093f : f;
    }

    public int getVert() {
        int i = (int) ((this.totalSteps * 16.0f) / 12.0f);
        return this.deviceUnit == 0 ? (i * 4) / 13 : i;
    }
}
