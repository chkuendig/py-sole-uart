package com.dyaco.ideabussdk_sole.bluetooth;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import com.dyaco.ideabussdk_sole.bluetooth.MyWriteThread;
import com.dyaco.ideabussdk_sole.library.MyVariable;
import com.facebook.appevents.AppEventsConstants;
import com.ideabus.bluetooth.BluetoothLEHandler;
import com.ideabus.bluetooth.BluetoothLEUtils;
import com.ideabus.library.CustomVariable;
import com.ua.sdk.recorder.datasource.sensor.bluetooth.GattAttributes;
import java.util.List;
import java.util.UUID;

/* loaded from: classes.dex */
public class MyBluetoothLE extends BluetoothLEUtils implements MyWriteThread.OnWriteStateListener {
    private static final int COMMAND_COUNT = 15;
    public static final int DATA_LENGTH = -1;
    public static final String END = "5D";
    public static final int MESSAGE_LENGTH = -1;
    public static final String START = "5B";
    private static final String TAG = "MyBluetoothLE";
    private static MyBluetoothLE myBluetooth;
    public boolean isNewType;
    public OnWriteStateListener mOnWriteStateListener;
    public int sendCount;
    protected static final UUID MY_UUID_SERVICE = UUID.fromString("49535343-FE7D-4AE5-8FA9-9FAFD205E455");
    protected static final UUID MY_UUID_WRITE = UUID.fromString("49535343-8841-43F4-A8D4-ECBE34729BB3");
    protected static final UUID MY_UUID_NOTIFY = UUID.fromString("49535343-1E4D-4BD9-BA61-23C647249616");
    protected static final UUID SECOND_SERVICE = UUID.fromString("0000fff0-0000-1000-8000-00805f9b34fb");
    protected static final UUID SECOND_WRITE = UUID.fromString("0000fff2-0000-1000-8000-00805f9b34fb");
    protected static final UUID SECOND_NOTIFY = UUID.fromString("0000fff1-0000-1000-8000-00805f9b34fb");
    static final UUID MY_UUID_UPDATE_NOTIFICATION_DESCRIPTOR_UUID = UUID.fromString(GattAttributes.CLIENT_CHARACTERISTIC_CONFIG_DESCRIPTOR);

    public interface OnWriteStateListener {
        void onWriteMessage(boolean z, String str);
    }

    public static String calcCheckSum(String str, String str2) {
        return "";
    }

    @Override // com.ideabus.bluetooth.BluetoothLEUtils
    public String onRead(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        return "";
    }

    public void setOnWriteStateListener(OnWriteStateListener onWriteStateListener) {
        this.mOnWriteStateListener = onWriteStateListener;
    }

    public static MyBluetoothLE getInstance(Context context, boolean z) {
        if (myBluetooth == null) {
            myBluetooth = new MyBluetoothLE(context, z);
        }
        return myBluetooth;
    }

    public MyBluetoothLE(Context context, boolean z) {
        super(context, z);
        this.sendCount = 0;
        this.isNewType = false;
    }

    @Override // com.ideabus.bluetooth.BluetoothLEUtils
    public void onWriteThreadStart(BluetoothLEHandler bluetoothLEHandler) {
        CustomVariable.printLog("d", TAG, "onWriteThreadStart-----");
        MyWriteThread myWriteThread = new MyWriteThread(myBluetooth, bluetoothLEHandler);
        myWriteThread.setOnWriteStateListener(this);
        myWriteThread.start();
    }

    @Override // com.ideabus.bluetooth.BluetoothLEUtils
    public synchronized boolean writeToBLE(String str, boolean z) {
        String str2 = TAG;
        CustomVariable.printLog("d", str2, "writeToBLE =============== " + str);
        if (str != null && str.startsWith(START) && str.endsWith(END)) {
            if (z || getCommArraySize() > 15) {
                removeOtherComm();
            }
            addCommArray(str);
            CustomVariable.printLog("d", str2, "writeMessage  getCommArraySize   = " + getCommArraySize());
            return true;
        }
        return false;
    }

    public boolean writeTest(String str) {
        CustomVariable.printLog("d", TAG, "writeToBLE =============== " + str);
        if (str == null || !str.startsWith(START) || !str.endsWith(END)) {
            return false;
        }
        addCommArray(str);
        return true;
    }

    public boolean writeTest1(String str) {
        CustomVariable.printLog("d", TAG, "writeToBLE1 =============== " + str);
        addCommArray(str);
        return true;
    }

    @Override // com.ideabus.bluetooth.BluetoothLEUtils
    public void searchGattServices(int i, List<BluetoothGattService> list) {
        CustomVariable.printLog("d", TAG, "Method:displayGattServices 開始解析 第 " + i + " 顆藍牙 Service");
        if (list == null) {
            return;
        }
        for (BluetoothGattService bluetoothGattService : list) {
            String str = TAG;
            CustomVariable.printLog("d", str, "-->搜尋到Service UUID = " + bluetoothGattService.getUuid());
            UUID uuid = bluetoothGattService.getUuid();
            UUID uuid2 = MY_UUID_SERVICE;
            if (uuid.equals(uuid2)) {
                CustomVariable.printLog("d", str, "-->搜尋到Service UUID = " + uuid2);
                for (BluetoothGattCharacteristic bluetoothGattCharacteristic : bluetoothGattService.getCharacteristics()) {
                    if (bluetoothGattCharacteristic.getUuid().equals(MY_UUID_WRITE)) {
                        bluetoothGattCharacteristic.setWriteType(1);
                        this.charWriteList.add(bluetoothGattCharacteristic);
                        CustomVariable.printLog("d", TAG, "-->搜尋到Write  NAME = " + getBluetoothGatt(i).getDevice().getName());
                    } else if (bluetoothGattCharacteristic.getUuid().equals(MY_UUID_NOTIFY)) {
                        getBluetoothGatt(i).setCharacteristicNotification(bluetoothGattCharacteristic, true);
                        BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(MY_UUID_UPDATE_NOTIFICATION_DESCRIPTOR_UUID);
                        if (descriptor != null) {
                            descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                            getBluetoothGatt(i).writeDescriptor(descriptor);
                        }
                        this.charNotifyCount++;
                        String str2 = TAG;
                        CustomVariable.printLog("e", str2, "-->Notify  charNotifyCount = " + this.charNotifyCount);
                        CustomVariable.printLog("e", str2, "-->搜尋到Notify  UUID = " + bluetoothGattCharacteristic.getUuid());
                    }
                }
            } else {
                UUID uuid3 = bluetoothGattService.getUuid();
                UUID uuid4 = SECOND_SERVICE;
                if (uuid3.equals(uuid4)) {
                    CustomVariable.printLog("d", str, "-->搜尋到Service UUID = " + uuid4);
                    this.isNewType = true;
                    for (BluetoothGattCharacteristic bluetoothGattCharacteristic2 : bluetoothGattService.getCharacteristics()) {
                        String str3 = TAG;
                        CustomVariable.printLog("d", str3, "-->搜尋到OTHER UUID = " + bluetoothGattCharacteristic2.getUuid());
                        if (bluetoothGattCharacteristic2.getUuid().equals(SECOND_WRITE)) {
                            bluetoothGattCharacteristic2.setWriteType(1);
                            this.charWriteList.add(bluetoothGattCharacteristic2);
                            CustomVariable.printLog("d", str3, "-->搜尋到Write  NAME = " + getBluetoothGatt(i).getDevice().getName());
                        } else if (bluetoothGattCharacteristic2.getUuid().equals(SECOND_NOTIFY)) {
                            getBluetoothGatt(i).setCharacteristicNotification(bluetoothGattCharacteristic2, true);
                            BluetoothGattDescriptor descriptor2 = bluetoothGattCharacteristic2.getDescriptor(MY_UUID_UPDATE_NOTIFICATION_DESCRIPTOR_UUID);
                            if (descriptor2 != null) {
                                descriptor2.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                                getBluetoothGatt(i).writeDescriptor(descriptor2);
                            }
                            this.charNotifyCount++;
                            CustomVariable.printLog("e", str3, "-->Notify  charNotifyCount = " + this.charNotifyCount);
                            CustomVariable.printLog("e", str3, "-->搜尋到Notify  UUID = " + bluetoothGattCharacteristic2.getUuid());
                        }
                    }
                }
            }
        }
    }

    @Override // com.ideabus.bluetooth.BluetoothLEUtils
    public String onChanged(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        String strBytesToHexString = MyVariable.bytesToHexString(bluetoothGattCharacteristic.getValue());
        CustomVariable.printLog("d", TAG, "Method  狀態改變  write or notify  接收訊息 = " + strBytesToHexString);
        return strBytesToHexString;
    }

    public static String calcCheckSumStr(String str, String str2) {
        CustomVariable.printLog("d", "calcCheckSum----", "calcCheckSum" + str + str2);
        try {
            String hexString = Integer.toHexString((Integer.parseInt(START, 16) + Integer.parseInt(str, 16)) & 255);
            if (hexString.length() == 1) {
                hexString = AppEventsConstants.EVENT_PARAM_VALUE_NO + hexString;
            }
            String str3 = START + str + str2 + hexString + END;
            CustomVariable.printLog("d", "calcCheckSum----", "字串解析傳送 = " + str3);
            return str3;
        } catch (Exception e) {
            CustomVariable.printLog("e", "calcCheckSum----", "checkSum 錯誤 = " + e.toString());
            return e.toString();
        }
    }

    public static String completeCommand(int i) {
        return completeCommand(i + "");
    }

    public static String completeCommand(String str) {
        CustomVariable.printLog("d", "completeCommand----", "message = " + str);
        try {
            String hexString = Integer.toHexString(str.length() / 2);
            if (hexString.length() == 1) {
                hexString = AppEventsConstants.EVENT_PARAM_VALUE_NO + hexString;
            }
            String str2 = START + hexString + str + END;
            CustomVariable.printLog("d", "completeCommand----", "字串解析傳送 = " + str2);
            return str2;
        } catch (Exception e) {
            CustomVariable.printLog("e", "completeCommand----", "checkSum 錯誤 = " + e.toString());
            return "";
        }
    }

    @Override // com.dyaco.ideabussdk_sole.bluetooth.MyWriteThread.OnWriteStateListener
    public void onWriteMessage(boolean z, String str) {
        OnWriteStateListener onWriteStateListener = this.mOnWriteStateListener;
        if (onWriteStateListener != null) {
            onWriteStateListener.onWriteMessage(z, str);
        }
    }
}
