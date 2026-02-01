package com.dyaco.sole.custom;

import android.app.Activity;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import com.digifly.cloudapi.CloudApi;
import com.digifly.cloudapi.data.DLUploadErrorCodeData;
import com.digifly.cloudapi.data.ResponseMessage;
import com.digifly.cloudapi.listener.DLUploadErrorCodeListener;
import com.dyaco.ideabussdk_sole.library.MyVariable;
import com.dyaco.ideabussdk_sole.protocol.EndWorkoutData;
import com.dyaco.ideabussdk_sole.protocol.SoleProtocol;
import com.dyaco.ideabussdk_sole.protocol.WorkoutData;
import com.dyaco.sole.ErrorLog.ErrorLogSave;
import com.dyaco.sole.MyApp;
import com.dyaco.sole.activity.ConnectionDialog;
import com.dyaco.sole.activity.MainActivity;
import com.facebook.appevents.AppEventsConstants;
import com.orhanobut.logger.Logger;
import com.soletreadmills.sole.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.joda.time.DateTime;

/* loaded from: classes.dex */
public class ProtocolHandler implements SoleProtocol.OnConnectStateListener, SoleProtocol.OnErrorHappened {
    public static final int BLE = 1;
    public static final int CLASSIC = 0;
    public static final boolean DEBUG_MODE = false;
    public static final int DEFAULT_AGE = 35;
    public static final int DEFAULT_GENDER = 1;
    public static final int DEFAULT_HEIGHT = 67;
    public static final int DEFAULT_WEIGHT = 155;
    public static final int INTERNATIONAL = 0;
    private static final boolean PRINT_LOG = true;
    public static final String TAG = "SOLE-ProtocolHandler";
    public static final int US = 1;
    public static final int autoConnectedCountMax = 10;
    public static int btType;
    public static ProtocolHandler protocol;
    private MainActivity activity;
    private String autoConnectedMacAddress;
    private ArrayList<OnBluetoothStateListener> bluetoothStateListeners;
    public String connectedMacAddress;
    private ArrayList<OnConnectionStateListener> connectionStateListeners;
    private SoleProtocol currentProtocol;
    private ArrayList<OnDataResultListener> dataResultListeners;
    public int deviceModel;
    public int deviceType;
    public boolean hasMaxIncline;
    private int lastErrorCode;
    public OnWorkoutResultListener mOnWorkoutResultListener;
    public OnBleScanResultListener onBleScanResultListener;
    public OnClassicScanResultListener onClassicScanResultListener;
    private OnErrorHappened onErrorHappened;
    public int setIntervalTime;
    public int setMaxLevel;
    public int setMaxTargetHR;
    public int setProgramMode;
    public int setRecoverTime;
    public int setTargetCalories;
    public ArrayList<Integer> setUserProfiles;
    public int setWorkoutTime;
    public int showInclineMode;
    private SoleProtocol soleBleProtocol;
    private SoleProtocol soleClassicProtocol;
    private UpdateAutoConnectedListener updateAutoConnectedListener;
    private boolean isSimulationConnected = false;
    public int salesVersion = 1;
    public int deviceUnit = 1;
    public int deviceBrand = 0;
    public String deviceName = "";
    public int maxIncline = 0;
    public int maxLevel = 0;
    public float maxSpeed = 0.0f;
    public float minSpeed = 0.0f;
    public int maxIntervalTime = 10;
    public int maxRecoverTime = 10;
    public int setGender = 1;
    public int setAge = 35;
    public int setWeight = 155;
    public int setHeight = 67;
    private boolean isAutoConnectedEnable = false;
    private int autoConnectedCount = 0;
    private boolean isShowAlertWorkoutIdleDialog = false;
    private boolean isAutoConnecting = false;

    public interface OnBleScanResultListener {
        void onBleScanResult(String str, String str2, int i);
    }

    public interface OnBluetoothStateListener {
        void onBluetoothState(boolean z);
    }

    public interface OnClassicScanResultListener {
        void onClassicScanResult(BluetoothDevice bluetoothDevice, int i);
    }

    public interface OnConnectionStateListener {
        void onConnectState(SoleProtocol.ConnectState connectState);
    }

    public interface OnDataResultListener {
        void onDataResult(int i, boolean z, List<Number> list);
    }

    public interface OnErrorHappened {
        void onError(String str);
    }

    public interface OnWorkoutResultListener {
        void onEndWorkoutResult(EndWorkoutData endWorkoutData);

        void onWorkoutResult(WorkoutData workoutData);
    }

    public interface UpdateAutoConnectedListener {
        void updateAutoConnectedShowScanView(boolean z);
    }

    public void setOnErrorHappened(OnErrorHappened onErrorHappened) {
        this.onErrorHappened = onErrorHappened;
    }

    @Override // com.dyaco.ideabussdk_sole.protocol.SoleProtocol.OnErrorHappened
    public void onError(String str) {
        this.onErrorHappened.onError(str);
    }

    public void addOnBluetoothStateListener(OnBluetoothStateListener onBluetoothStateListener) {
        if (this.bluetoothStateListeners == null) {
            this.bluetoothStateListeners = new ArrayList<>();
        }
        if (this.bluetoothStateListeners.contains(onBluetoothStateListener)) {
            this.bluetoothStateListeners.remove(onBluetoothStateListener);
        }
        this.bluetoothStateListeners.add(onBluetoothStateListener);
    }

    public void removeOnBluetoothStateListener(OnBluetoothStateListener onBluetoothStateListener) {
        ArrayList<OnBluetoothStateListener> arrayList = this.bluetoothStateListeners;
        if (arrayList != null) {
            arrayList.remove(onBluetoothStateListener);
        }
    }

    public void setOnClassicScanResultListener(OnClassicScanResultListener onClassicScanResultListener) {
        this.onClassicScanResultListener = onClassicScanResultListener;
    }

    public void setOnBleScanResultListener(OnBleScanResultListener onBleScanResultListener) {
        this.onBleScanResultListener = onBleScanResultListener;
    }

    public void addOnConnectionStateListener(OnConnectionStateListener onConnectionStateListener) {
        if (this.connectionStateListeners == null) {
            this.connectionStateListeners = new ArrayList<>();
        }
        if (this.connectionStateListeners.contains(onConnectionStateListener)) {
            this.connectionStateListeners.remove(onConnectionStateListener);
        }
        this.connectionStateListeners.add(onConnectionStateListener);
    }

    public void removeOnConnectionStateListener(OnConnectionStateListener onConnectionStateListener) {
        ArrayList<OnConnectionStateListener> arrayList = this.connectionStateListeners;
        if (arrayList != null) {
            arrayList.remove(onConnectionStateListener);
        }
    }

    public void setOnWorkoutResultListener(OnWorkoutResultListener onWorkoutResultListener) {
        this.mOnWorkoutResultListener = onWorkoutResultListener;
    }

    public void addOnDataResultListener(OnDataResultListener onDataResultListener) {
        if (this.dataResultListeners == null) {
            this.dataResultListeners = new ArrayList<>();
        }
        if (this.dataResultListeners.contains(onDataResultListener)) {
            this.dataResultListeners.remove(onDataResultListener);
        }
        this.dataResultListeners.add(onDataResultListener);
    }

    public void removeOnDataResultListener(OnDataResultListener onDataResultListener) {
        ArrayList<OnDataResultListener> arrayList = this.dataResultListeners;
        if (arrayList != null) {
            arrayList.remove(onDataResultListener);
        }
    }

    public static void init(Context context) {
        if (protocol == null) {
            protocol = new ProtocolHandler(context);
        }
    }

    private ProtocolHandler(Context context) {
        SoleProtocol classicInstance = SoleProtocol.getClassicInstance(context, 0, false, true);
        this.soleClassicProtocol = classicInstance;
        classicInstance.setOnConnectStateListener(this);
        this.soleClassicProtocol.setOnErrorHappened(this);
        SoleProtocol bleInstance = SoleProtocol.getBleInstance(context, 1, false, true);
        this.soleBleProtocol = bleInstance;
        bleInstance.setOnConnectStateListener(this);
        this.soleBleProtocol.setOnErrorHappened(this);
        setAutoConnectedEnable(false);
        setAutoConnectedCount(0);
        setAutoConnectedMacAddress(null);
        setShowAlertWorkoutIdleDialog(false);
        setAutoConnecting(false);
    }

    public void setHandler(MainActivity mainActivity) {
        this.activity = mainActivity;
    }

    public static void release() {
        protocol = null;
    }

    public boolean enableBluetoothClassic(Activity activity) {
        return this.soleClassicProtocol.enableBluetooth(activity);
    }

    public boolean enableBluetoothLE(Activity activity) {
        return this.soleBleProtocol.enableBluetooth(activity);
    }

    public boolean isConnected() {
        return this.soleClassicProtocol.isConnected() || this.soleBleProtocol.isConnected();
    }

    public void startClassicScan() {
        this.soleClassicProtocol.startScan(10);
        UpdateAutoConnectedListener updateAutoConnectedListener = this.updateAutoConnectedListener;
        if (updateAutoConnectedListener != null) {
            updateAutoConnectedListener.updateAutoConnectedShowScanView(true);
        }
    }

    public void startBleScan() {
        this.soleBleProtocol.startScan(10);
        UpdateAutoConnectedListener updateAutoConnectedListener = this.updateAutoConnectedListener;
        if (updateAutoConnectedListener != null) {
            updateAutoConnectedListener.updateAutoConnectedShowScanView(true);
        }
    }

    public void stopClassicScan() {
        this.soleClassicProtocol.stopScan();
    }

    public void stopBleScan() {
        this.soleBleProtocol.stopScan();
    }

    public boolean isClassicScan() {
        return this.soleClassicProtocol.isScanning();
    }

    public boolean isBleScan() {
        return this.soleBleProtocol.isScanning();
    }

    public void connectClassic(BluetoothDevice bluetoothDevice) throws IOException {
        if (this.soleClassicProtocol.isScanning()) {
            this.soleClassicProtocol.stopScan();
        }
        this.soleClassicProtocol.connect(bluetoothDevice);
        this.currentProtocol = this.soleClassicProtocol;
    }

    public void connectBle(String str) {
        if (this.soleBleProtocol.isScanning()) {
            this.soleBleProtocol.stopScan();
        }
        this.soleBleProtocol.connect(str);
        this.currentProtocol = this.soleBleProtocol;
    }

    public void disconnect() {
        this.soleClassicProtocol.disconnect();
        this.soleBleProtocol.disconnect();
        MyApp.isWork = false;
    }

    public void readRSSI() {
        this.soleBleProtocol.readRSSI();
    }

    public int getVert() {
        return this.soleBleProtocol.getVert();
    }

    public void getHeartRateType() throws IOException {
        this.currentProtocol.getHeartRateType();
    }

    public void resetCalDis() {
        SoleProtocol soleProtocol = this.currentProtocol;
        if (soleProtocol != null) {
            soleProtocol.resetCalDis();
        }
    }

    private void setProgram() throws IOException {
        switch (DeviceModelList.programTitleTexts[this.setProgramMode]) {
            case R.string.calorie /* 2131689533 */:
                this.currentProtocol.setProgram(11);
                break;
            case R.string.cardio /* 2131689542 */:
                this.currentProtocol.setProgram(3);
                break;
            case R.string.custom /* 2131689593 */:
            case R.string.user /* 2131689999 */:
            case R.string.user1 /* 2131690000 */:
                this.currentProtocol.setProgram(8);
                break;
            case R.string.fat_burn /* 2131689682 */:
                this.currentProtocol.setProgram(2);
                break;
            case R.string.fitness_test /* 2131689688 */:
            case R.string.manual /* 2131689813 */:
                this.currentProtocol.setProgram(0);
                break;
            case R.string.fusion /* 2131689696 */:
                this.currentProtocol.setProgram(12);
                break;
            case R.string.hill /* 2131689742 */:
                this.currentProtocol.setProgram(1);
                break;
            case R.string.hr1 /* 2131689745 */:
                this.currentProtocol.setProgram(6);
                break;
            case R.string.hr2 /* 2131689747 */:
                this.currentProtocol.setProgram(7);
                break;
            case R.string.interval /* 2131689753 */:
                this.currentProtocol.setProgram(5);
                break;
            case R.string.strength /* 2131689953 */:
                this.currentProtocol.setProgram(4);
                break;
            case R.string.user2 /* 2131690001 */:
                this.currentProtocol.setProgram(9);
                break;
        }
    }

    public void startWorkout() throws IOException {
        int i;
        int i2 = DeviceModelList.programTitleTexts[this.setProgramMode];
        this.currentProtocol.setUserProfile(this.setGender, this.setAge, this.setWeight, this.setHeight);
        setProgram();
        if (i2 != R.string.calorie && i2 != R.string.fusion) {
            this.currentProtocol.setWorkoutTime(this.setWorkoutTime);
        }
        int i3 = this.deviceType;
        if (i3 != 0) {
            if (i3 == 1 || i3 == 2) {
                Log.e("checkProfileT", "programTitleTextRid : " + i2);
                switch (i2) {
                    case R.string.custom /* 2131689593 */:
                    case R.string.user /* 2131689999 */:
                    case R.string.user1 /* 2131690000 */:
                    case R.string.user2 /* 2131690001 */:
                        int i4 = protocol.deviceModel;
                        if (i4 == 38 || i4 == 56) {
                            ArrayList<Integer> arrayList = new ArrayList<>();
                            Iterator<Integer> it = this.setUserProfiles.iterator();
                            while (it.hasNext()) {
                                arrayList.add(Integer.valueOf((int) Math.round((it.next().intValue() * 2.555d) + 1.0d)));
                            }
                            this.currentProtocol.setUserLevel(arrayList);
                        } else if (i4 == 39 || i4 == 55 || i4 == 57 || i4 == 40 || i4 == 100 || i4 == 101 || i4 == 102 || i4 == 103 || i4 == 104 || i4 == 105 || i4 == 106) {
                            ArrayList<Integer> arrayList2 = new ArrayList<>();
                            Iterator<Integer> it2 = this.setUserProfiles.iterator();
                            while (it2.hasNext()) {
                                Integer next = it2.next();
                                arrayList2.add(Integer.valueOf((int) Math.round(next.intValue() * 2.555d)));
                                Log.e("checkProEV", next + " | " + arrayList2.get(arrayList2.size() - 1));
                            }
                            this.currentProtocol.setUserLevel(arrayList2);
                        } else {
                            this.currentProtocol.setMaxLevel(5);
                            this.currentProtocol.setUserLevel(this.setUserProfiles);
                            for (int i5 = 0; i5 < this.setUserProfiles.size(); i5++) {
                                Log.e("setProfilelong", this.setUserProfiles.get(i5).toString());
                            }
                        }
                        if (this.deviceModel == 10) {
                            ArrayList<Integer> arrayList3 = new ArrayList<>();
                            arrayList3.addAll(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1));
                            this.currentProtocol.setUserIncline(arrayList3);
                            break;
                        }
                        break;
                    case R.string.hr1 /* 2131689745 */:
                    case R.string.hr2 /* 2131689747 */:
                        this.currentProtocol.setTargetHR(this.setMaxTargetHR);
                        break;
                    case R.string.manual /* 2131689813 */:
                        break;
                    default:
                        Log.e("checkProfileT", "default : ");
                        int i6 = this.setMaxLevel;
                        if (i6 != -1) {
                            if (i6 > this.currentProtocol.getMaxLevel()) {
                                this.setMaxLevel = this.currentProtocol.getMaxLevel();
                            }
                            this.currentProtocol.setMaxLevel(this.setMaxLevel);
                        }
                        Log.e("checkProfileT", "MODEL_FSX3500 : " + protocol.deviceModel);
                        int i7 = protocol.deviceModel;
                        if (i7 == 38 || i7 == 39 || i7 == 40 || i7 == 100 || i7 == 101 || i7 == 102 || i7 == 103 || i7 == 104 || i7 == 105 || i7 == 106 || i7 == 51 || i7 == 52 || i7 == 53 || i7 == 54 || i7 == 55 || i7 == 57 || i7 == 58 || i7 == 59 || i7 == 112 || i7 == 113 || i7 == 114 || i7 == 115 || i7 == 116 || i7 == 117 || i7 == 118 || i7 == 119) {
                            Log.e("checkProfileT", "MODEL_FSX3500 : ");
                            ArrayList<Integer> arrayList4 = new ArrayList<>();
                            if (i2 == R.string.hill) {
                                for (int i8 : DeviceModelList.HILL) {
                                    int iRound = (int) Math.round((this.setMaxLevel * i8) / 9.0d);
                                    Log.e("checkArraylist", i8 + " : " + iRound);
                                    if (iRound == 0) {
                                        iRound = 1;
                                    }
                                    arrayList4.add(Integer.valueOf(iRound));
                                }
                                Log.e("checkArraylist", arrayList4.toString());
                            } else if (i2 == R.string.fat_burn) {
                                int length = DeviceModelList.FAT_BURN.length;
                                for (int i9 = 0; i9 < length; i9++) {
                                    int iRound2 = (int) Math.round((this.setMaxLevel * r1[i9]) / 7.0d);
                                    if (iRound2 == 0) {
                                        iRound2 = 1;
                                    }
                                    arrayList4.add(Integer.valueOf(iRound2));
                                }
                            } else if (i2 == R.string.cardio) {
                                int length2 = DeviceModelList.CARDIO.length;
                                for (int i10 = 0; i10 < length2; i10++) {
                                    int iRound3 = (int) Math.round((this.setMaxLevel * r1[i10]) / 9.0d);
                                    if (iRound3 == 0) {
                                        iRound3 = 1;
                                    }
                                    arrayList4.add(Integer.valueOf(iRound3));
                                }
                            } else if (i2 == R.string.strength) {
                                int length3 = DeviceModelList.STRENGTH.length;
                                for (int i11 = 0; i11 < length3; i11++) {
                                    int iRound4 = (int) Math.round((this.setMaxLevel * r1[i11]) / 9.0d);
                                    if (iRound4 == 0) {
                                        iRound4 = 1;
                                    }
                                    arrayList4.add(Integer.valueOf(iRound4));
                                }
                            } else if (i2 == R.string.interval) {
                                int length4 = DeviceModelList.INTERVAL.length;
                                for (int i12 = 0; i12 < length4; i12++) {
                                    int iRound5 = (int) Math.round((this.setMaxLevel * r1[i12]) / 9.0d);
                                    if (iRound5 == 0) {
                                        iRound5 = 1;
                                    }
                                    arrayList4.add(Integer.valueOf(iRound5));
                                }
                            }
                            this.currentProtocol.setUserLevel(arrayList4);
                            break;
                        } else {
                            this.currentProtocol.setMaxLevel(5);
                            break;
                        }
                }
            }
        } else {
            switch (i2) {
                case R.string.calorie /* 2131689533 */:
                    this.currentProtocol.setTargetCalorie(this.setTargetCalories);
                    break;
                case R.string.custom /* 2131689593 */:
                case R.string.user /* 2131689999 */:
                case R.string.user1 /* 2131690000 */:
                case R.string.user2 /* 2131690001 */:
                    this.currentProtocol.setUserSpeed(this.setUserProfiles);
                    this.currentProtocol.setUserSpeed(this.setUserProfiles);
                    break;
                case R.string.fusion /* 2131689696 */:
                    this.currentProtocol.setFusionProgram(this.setIntervalTime, this.setRecoverTime);
                    break;
                case R.string.hr1 /* 2131689745 */:
                case R.string.hr2 /* 2131689747 */:
                    this.currentProtocol.setTargetHR(this.setMaxTargetHR);
                    break;
            }
        }
        if (this.deviceType == 0 && ((i = this.deviceBrand) == 0 || i == 1)) {
            this.currentProtocol.setMaxIncline(10);
        }
        this.currentProtocol.startWorkout();
    }

    public void pauseWorkout() throws NumberFormatException, IOException {
        this.currentProtocol.pauseWorkout();
    }

    public void restartWorkout() throws IOException {
        this.currentProtocol.restartWorkout();
    }

    public void stopWorkout() throws NumberFormatException, IOException {
        this.currentProtocol.stopWorkout();
    }

    public void setInclineUp() throws IOException {
        this.currentProtocol.setInclineUp();
    }

    public void setInclineDown() throws IOException {
        this.currentProtocol.setInclineDown();
    }

    public void setLevelUp() throws IOException {
        this.currentProtocol.setLevelUp();
    }

    public void setLevelDown() throws IOException {
        this.currentProtocol.setLevelDown();
    }

    @Override // com.dyaco.ideabussdk_sole.protocol.SoleProtocol.OnConnectStateListener
    public void onBtStateChanged(boolean z) {
        ArrayList<OnBluetoothStateListener> arrayList;
        if (protocol == null || (arrayList = this.bluetoothStateListeners) == null) {
            return;
        }
        Iterator<OnBluetoothStateListener> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().onBluetoothState(z);
        }
    }

    @Override // com.dyaco.ideabussdk_sole.protocol.SoleProtocol.OnConnectStateListener
    public void onScanResult(String str, String str2, int i) {
        if (protocol == null || this.onBleScanResultListener == null || str2 == null || str2.trim().length() <= 0 || str2.toLowerCase().equals("n/a")) {
            return;
        }
        this.onBleScanResultListener.onBleScanResult(str, str2, i);
    }

    @Override // com.dyaco.ideabussdk_sole.protocol.SoleProtocol.OnConnectStateListener
    public void onScanResult(final BluetoothDevice bluetoothDevice, int i) {
        if (protocol == null || this.onBleScanResultListener == null || bluetoothDevice == null || bluetoothDevice.getName() == null || bluetoothDevice.getName().trim().length() <= 0 || bluetoothDevice.getName().toLowerCase().equals("n/a")) {
            return;
        }
        if (isAutoConnectedEnable() && getAutoConnectedMacAddress() != null && this.currentProtocol != null) {
            if (!bluetoothDevice.getAddress().equals(getAutoConnectedMacAddress()) || isAutoConnecting()) {
                return;
            }
            setAutoConnecting(true);
            stopClassicScan();
            stopBleScan();
            new Handler().postDelayed(new Runnable() { // from class: com.dyaco.sole.custom.ProtocolHandler.1
                @Override // java.lang.Runnable
                public void run() throws IOException {
                    if (ProtocolHandler.this.currentProtocol.equals(ProtocolHandler.this.soleBleProtocol)) {
                        ProtocolHandler.this.connectBle(bluetoothDevice.getAddress());
                    }
                    if (ProtocolHandler.this.currentProtocol.equals(ProtocolHandler.this.soleClassicProtocol)) {
                        ProtocolHandler.this.connectClassic(bluetoothDevice);
                    }
                }
            }, 300L);
            return;
        }
        this.onClassicScanResultListener.onClassicScanResult(bluetoothDevice, i);
    }

    @Override // com.dyaco.ideabussdk_sole.protocol.SoleProtocol.OnConnectStateListener
    public void onConnectionState(SoleProtocol.ConnectState connectState) throws IOException {
        MainActivity mainActivity;
        Global.printLog("d", TAG, "onConnectionState - protocol = " + protocol);
        if (protocol == null) {
            return;
        }
        if (this.deviceModel == 135 && connectState == SoleProtocol.ConnectState.Disconnect && !SoleProtocol.notRunning && (mainActivity = this.activity) != null) {
            mainActivity.disconnectSaving();
        }
        if (connectState == SoleProtocol.ConnectState.Connected) {
            this.deviceModel = this.currentProtocol.getDeviceModel();
            this.deviceType = this.currentProtocol.getDeviceType();
            this.salesVersion = this.currentProtocol.getSalesVersion();
            this.deviceName = this.currentProtocol.getDeviceName();
            try {
                ErrorLogSave.addErrorString(this.activity, ErrorLogSave.CONNECT, ErrorLogSave.CONNECT, "deviceModel:" + this.deviceModel + "_deviceType:" + this.deviceType + "_deviceName:" + this.deviceName + "_salesVersion:" + this.salesVersion);
            } catch (Exception e) {
                e.printStackTrace();
            }
            int unit = this.currentProtocol.getUnit();
            this.deviceUnit = unit;
            Log.e("checkUnit", String.valueOf(unit));
            this.activity.getSharedPreferences("UnitWay", 0).edit().putInt("unit", this.deviceUnit).commit();
            this.deviceBrand = this.currentProtocol.getDeviceBrand();
            this.maxIncline = this.currentProtocol.getMaxIncline() - 1;
            this.maxSpeed = Global.divide(this.currentProtocol.getMaxSpeed(), 10.0f, 1);
            this.minSpeed = Global.divide(this.currentProtocol.getMinSpeed(), 10.0f, 1);
            this.maxLevel = this.currentProtocol.getMaxLevel();
            this.showInclineMode = this.currentProtocol.getShowInclineMode();
            this.hasMaxIncline = this.currentProtocol.getHasMaxIncline();
            int i = Global.BRAND;
            if (i == 1 || i == 2 || i == 3) {
                int i2 = this.deviceModel;
                if (i2 == 6) {
                    this.showInclineMode = 1;
                } else if (i2 == 7) {
                    this.showInclineMode = 2;
                }
            }
            String str = TAG;
            Global.printLog("e", str, "deviceModel = " + this.deviceModel);
            Global.printLog("e", str, "deviceType = " + this.deviceType);
            int i3 = Global.BRAND;
            if (i3 == 0) {
                Sole_DeviceModelList.handleDeviceModel();
            } else if (i3 == 1) {
                Spirit_DeviceModelList.handleDeviceModel();
            } else if (i3 == 2) {
                Xterra_DeviceModelList.handleDeviceModel();
            } else if (i3 == 3) {
                Fuel_DeviceModelList.handleDeviceModel();
            }
            if (!isAutoConnectedEnable()) {
                for (int i4 = 0; i4 < DeviceModelList.programNames.length; i4++) {
                    if (DeviceModelList.programNames[i4].equals(DeviceModelList.PGName_Manual)) {
                        Log.e("lookforprogram", DeviceModelList.PGName_Manual + " : " + i4);
                        protocol.setProgramMode = i4;
                    }
                }
            }
            int i5 = this.deviceModel;
            if (i5 == 12 || i5 == 13 || i5 == 96 || i5 == 97 || i5 == 98) {
                this.currentProtocol.setUserProfile(this.setGender, this.setAge, this.setWeight, this.setHeight);
                this.activity.setSave();
                this.currentProtocol.getEndWorkout();
            }
        }
        Global.printLog("d", TAG, "onConnectionState - activity = " + this.activity);
        if (this.activity == null) {
            return;
        }
        int i6 = AnonymousClass4.$SwitchMap$com$dyaco$ideabussdk_sole$protocol$SoleProtocol$ConnectState[connectState.ordinal()];
        if (i6 != 1) {
            if (i6 == 2) {
                this.isSimulationConnected = true;
                this.activity.cancelAlert();
                UpdateAutoConnectedListener updateAutoConnectedListener = this.updateAutoConnectedListener;
                if (updateAutoConnectedListener != null) {
                    updateAutoConnectedListener.updateAutoConnectedShowScanView(false);
                }
                setAutoConnectedCount(0);
                setAutoConnecting(false);
            } else if (i6 == 3 || i6 == 4) {
                this.isSimulationConnected = false;
                Global.isIdleMode = false;
                Global.isSafeKeyOn = true;
                if (Global.BRAND == 0) {
                    this.activity.hideControlView();
                }
                if ((!isAutoConnectedEnable() || getAutoConnectedCount() >= 10) && !isShowAlertWorkoutIdleDialog()) {
                    showDeviceDisconnectedDialog();
                }
                setAutoConnecting(false);
                if (isShowAlertWorkoutIdleDialog()) {
                    this.activity.showBaseAlert(Global.ALERT_TITLE_RID, R.string.confirm, false, R.string.display_alert_workout_idle, (DialogInterface.OnClickListener) null);
                }
                setShowAlertWorkoutIdleDialog(false);
            }
        } else if (isAutoConnectedEnable() && getAutoConnectedCount() >= 10) {
            setAutoConnectedEnable(false);
            onConnectionState(SoleProtocol.ConnectState.Disconnect);
        }
        ArrayList<OnConnectionStateListener> arrayList = this.connectionStateListeners;
        if (arrayList != null) {
            Iterator<OnConnectionStateListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onConnectState(connectState);
            }
        }
    }

    /* renamed from: com.dyaco.sole.custom.ProtocolHandler$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$dyaco$ideabussdk_sole$protocol$SoleProtocol$ConnectState;

        static {
            int[] iArr = new int[SoleProtocol.ConnectState.values().length];
            $SwitchMap$com$dyaco$ideabussdk_sole$protocol$SoleProtocol$ConnectState = iArr;
            try {
                iArr[SoleProtocol.ConnectState.ScanFinish.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dyaco$ideabussdk_sole$protocol$SoleProtocol$ConnectState[SoleProtocol.ConnectState.Connected.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dyaco$ideabussdk_sole$protocol$SoleProtocol$ConnectState[SoleProtocol.ConnectState.Disconnect.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dyaco$ideabussdk_sole$protocol$SoleProtocol$ConnectState[SoleProtocol.ConnectState.ConnectTimeout.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private void showDeviceDisconnectedDialog() {
        if (Global.nowActivityName.equals(ConnectionDialog.class.getName())) {
            return;
        }
        this.activity.showBaseAlert(Global.ALERT_TITLE_RID, R.string.confirm, false, R.string.device_disconnected, new DialogInterface.OnClickListener() { // from class: com.dyaco.sole.custom.ProtocolHandler.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                ProtocolHandler.this.activity.switchFragment(7);
            }
        });
    }

    @Override // com.dyaco.ideabussdk_sole.protocol.SoleProtocol.OnConnectStateListener
    public void onDataResult(int i, boolean z, ArrayList<Number> arrayList) {
        String str = TAG;
        Global.printLog("d", str, "onDataResult - protocol = " + protocol);
        if (protocol == null) {
            return;
        }
        if (i == 3) {
            int iIntValue = arrayList.get(0).intValue();
            if (iIntValue == 1) {
                Global.printLog("e", str, "切換到Idle Mode!");
                Global.isIdleMode = true;
            } else if (iIntValue == 128 || iIntValue == 8) {
                Global.printLog("e", str, "CS Running Mode!無法進入操作");
                Global.isIdleMode = false;
            }
        } else if (i != 9) {
            if (i == 16) {
                int iIntValue2 = arrayList.get(0).intValue();
                if (iIntValue2 != 0 && iIntValue2 != this.lastErrorCode) {
                    this.lastErrorCode = iIntValue2;
                    DLUploadErrorCodeData dlUploadErrorCodeData = getDlUploadErrorCodeData(iIntValue2);
                    CloudApi cloudApi = CloudApi.getInstance(this.activity);
                    cloudApi.setUploadErrorCodeListener(new DLUploadErrorCodeListener() { // from class: com.dyaco.sole.custom.ProtocolHandler.3
                        @Override // com.digifly.cloudapi.listener.DLUploadErrorCodeListener
                        public void onSuccess(ResponseMessage responseMessage) {
                            Logger.d("callUploadErrorCode  responseMessage = " + responseMessage);
                        }

                        @Override // com.digifly.cloudapi.listener.DLUploadErrorCodeListener
                        public void onFail(ResponseMessage responseMessage) {
                            Logger.d("callUploadErrorCode  responseMessage = " + responseMessage);
                        }

                        @Override // com.digifly.cloudapi.listener.DLUploadErrorCodeListener
                        public void onError(String str2) {
                            Logger.d("callUploadErrorCode  err = " + str2);
                        }
                    });
                    cloudApi.callUploadErrorCode(dlUploadErrorCodeData);
                }
            } else if (i == 64) {
                ArrayList arrayList2 = new ArrayList();
                Iterator<Number> it = arrayList.iterator();
                while (it.hasNext()) {
                    int iIntValue3 = it.next().intValue();
                    if (Global.BRAND == 0) {
                        if (iIntValue3 == 1) {
                            iIntValue3 = 0;
                        } else if (iIntValue3 == 3) {
                            iIntValue3 = 1;
                        } else if (iIntValue3 == 7) {
                            iIntValue3 = 2;
                        } else if (iIntValue3 == 15) {
                            iIntValue3 = 3;
                        } else if (iIntValue3 == 31) {
                            iIntValue3 = 4;
                        } else if (iIntValue3 == 63) {
                            iIntValue3 = 5;
                        } else if (iIntValue3 == 127) {
                            iIntValue3 = 6;
                        } else if (iIntValue3 == 255) {
                            iIntValue3 = 7;
                        }
                    }
                    arrayList2.add(Integer.valueOf(iIntValue3));
                    Log.e("chekcprofile", "" + iIntValue3);
                }
                protocol.setUserProfiles = (ArrayList) arrayList2.clone();
            }
        } else if (this.deviceType == 0) {
            Global.isSafeKeyOn = arrayList.get(0).intValue() != 2;
        }
        ArrayList<OnDataResultListener> arrayList3 = this.dataResultListeners;
        if (arrayList3 != null) {
            Iterator<OnDataResultListener> it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                it2.next().onDataResult(i, z, arrayList);
            }
        }
    }

    private DLUploadErrorCodeData getDlUploadErrorCodeData(int i) {
        DLUploadErrorCodeData dLUploadErrorCodeData = new DLUploadErrorCodeData();
        dLUploadErrorCodeData.setAccount(Global.memberData.getAccount());
        dLUploadErrorCodeData.setPassword(Global.memberData.getPassword());
        dLUploadErrorCodeData.setErr_time(new DateTime().toString(CalendarUtils.SQL_DATE_TIME_FORMAT));
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance(getLocale());
        calendar2.setTimeInMillis(calendar.getTimeInMillis());
        dLUploadErrorCodeData.setErr_timezone_hour(((calendar2.get(15) / 1000) / 60) / 60);
        dLUploadErrorCodeData.setErr_timezone_name(calendar2.getTimeZone().getID());
        String str = protocol.connectedMacAddress;
        if (str == null) {
            str = "00:00:00";
        }
        dLUploadErrorCodeData.setCon_macaddress(str);
        dLUploadErrorCodeData.setErr_code(String.valueOf(i));
        dLUploadErrorCodeData.setCon_brand(Global.CLOUD_BRAND_NAME);
        dLUploadErrorCodeData.setBrand_type(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        dLUploadErrorCodeData.setCon_categorycode(String.valueOf(this.deviceType));
        dLUploadErrorCodeData.setCon_modelcode(this.deviceName);
        dLUploadErrorCodeData.setCon_unit(String.valueOf(this.deviceUnit));
        dLUploadErrorCodeData.setCon_saleversion(String.valueOf(this.salesVersion));
        dLUploadErrorCodeData.setDevice_os("Android");
        dLUploadErrorCodeData.setDevice_os_version(Build.VERSION.RELEASE);
        dLUploadErrorCodeData.setDevice_model(Build.BRAND);
        dLUploadErrorCodeData.setDevice_sno(Build.SERIAL);
        dLUploadErrorCodeData.setDevice_gps_lat(Global.gpsLat);
        dLUploadErrorCodeData.setDevice_gps_lng(Global.gpsLon);
        return dLUploadErrorCodeData;
    }

    private Locale getLocale() {
        Resources resources = this.activity.getResources();
        resources.getDisplayMetrics();
        return resources.getConfiguration().locale;
    }

    @Override // com.dyaco.ideabussdk_sole.protocol.SoleProtocol.OnConnectStateListener
    public void onWorkoutResult(WorkoutData workoutData) {
        if (protocol == null || this.mOnWorkoutResultListener == null) {
            return;
        }
        WorkoutData workoutData2 = new WorkoutData();
        workoutData2.setMinute(workoutData.getMinute());
        workoutData2.setSeconds(workoutData.getSeconds());
        workoutData2.setDistance(workoutData.getDistance());
        workoutData2.setCalories(workoutData.getCalories());
        workoutData2.setHeartRate(workoutData.getHeartRate());
        workoutData2.setRpm(workoutData.getRpm());
        workoutData2.setSpeed(workoutData.getSpeed());
        workoutData2.setNowLevel(workoutData.getNowLevel());
        workoutData2.setNowIncline(workoutData.getNowIncline());
        workoutData2.setNowTargetHR(workoutData.getNowTargetHR());
        workoutData2.setWatt(workoutData.getWatt());
        workoutData2.setMets(workoutData.getMets());
        workoutData2.setFusionIntervalTime(workoutData.getFusionIntervalTime());
        workoutData2.setFusionRecoveryTime(workoutData.getFusionRecoveryTime());
        workoutData2.setProgramRow(workoutData.getProgramRow());
        workoutData2.setProgramHeight(workoutData.getProgramHeight());
        workoutData2.setLaps(workoutData.getLaps());
        workoutData2.setPaceMinute(workoutData.getPaceMinute());
        workoutData2.setPaceSeconds(workoutData.getPaceSeconds());
        workoutData2.setCalHour(workoutData.getCalHour());
        workoutData2.setCalSeconds(workoutData.getCalSeconds());
        workoutData2.setSpm(workoutData.getSpm());
        workoutData2.setTotalSteps(workoutData.getTotalSteps());
        workoutData2.setVert(workoutData.getVert());
        workoutData2.setAutoConnectedSimulationData(workoutData.isAutoConnectedSimulationData());
        Global.workoutDataListForProtocol.add(workoutData2);
        this.mOnWorkoutResultListener.onWorkoutResult(workoutData);
    }

    @Override // com.dyaco.ideabussdk_sole.protocol.SoleProtocol.OnConnectStateListener
    public void onEndWorkoutResult(EndWorkoutData endWorkoutData) {
        OnWorkoutResultListener onWorkoutResultListener;
        Log.e("getEndMessage", "get");
        if (protocol == null || (onWorkoutResultListener = this.mOnWorkoutResultListener) == null) {
            Log.e("getEndMessage", "null");
        } else {
            onWorkoutResultListener.onEndWorkoutResult(endWorkoutData);
        }
    }

    public int getConvertWeight(int i) {
        Log.d(TAG, "getConvertWeight weightLB : " + i);
        return this.deviceUnit == 0 ? (int) (i * 0.453d) : i;
    }

    public int getConvertHeight(int i) {
        return this.deviceUnit == 0 ? (int) (i * 2.54d) : i;
    }

    public float getConvertDistanceUnit(float f) {
        return getConvertDistanceUnit(this.deviceUnit, f);
    }

    public float getConvertDistanceUnit(int i, float f) {
        return i == 0 ? this.deviceUnit == 0 ? f : MyVariable.getScaleToFloat(f * 1.6093f, 2) : this.deviceUnit == 1 ? f : MyVariable.getScaleToFloat(f / 1.6093f, 2);
    }

    public float getConvertDistanceUnitFt(int i, float f) {
        return i == 0 ? this.deviceUnit == 0 ? f : MyVariable.getScaleToFloat(f * 0.3048f, 2) : this.deviceUnit == 1 ? f : MyVariable.getScaleToFloat(f / 0.3048f, 2);
    }

    public void setAutoConnectedEnable(boolean z) {
        this.isAutoConnectedEnable = z;
    }

    public boolean isAutoConnectedEnable() {
        return this.isAutoConnectedEnable;
    }

    public void setAutoConnectedMacAddress(String str) {
        this.autoConnectedMacAddress = str;
    }

    public String getAutoConnectedMacAddress() {
        return this.autoConnectedMacAddress;
    }

    public void setAutoConnectedCount(int i) {
        this.autoConnectedCount = i;
    }

    public int getAutoConnectedCount() {
        return this.autoConnectedCount;
    }

    public void setShowAlertWorkoutIdleDialog(boolean z) {
        this.isShowAlertWorkoutIdleDialog = z;
    }

    public boolean isShowAlertWorkoutIdleDialog() {
        return this.isShowAlertWorkoutIdleDialog;
    }

    public void setAutoConnecting(boolean z) {
        this.isAutoConnecting = z;
    }

    public boolean isAutoConnecting() {
        return this.isAutoConnecting;
    }

    public void setUpdateAutoConnectedListener(UpdateAutoConnectedListener updateAutoConnectedListener) {
        this.updateAutoConnectedListener = updateAutoConnectedListener;
    }
}
