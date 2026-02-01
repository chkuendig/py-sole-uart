package com.ua.sdk.recorder.datasource.sensor.bluetooth.services;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import com.dyaco.sole.R2;
import com.ua.sdk.LocalDate;
import com.ua.sdk.UaLog;
import com.ua.sdk.heartrate.HeartRateZones;
import com.ua.sdk.recorder.datasource.sensor.bluetooth.BaseGattCallback;
import com.ua.sdk.recorder.datasource.sensor.bluetooth.BluetoothAction;
import com.ua.sdk.recorder.datasource.sensor.bluetooth.BluetoothActionQueue;
import com.ua.sdk.recorder.datasource.sensor.bluetooth.BluetoothClient;
import com.ua.sdk.recorder.datasource.sensor.bluetooth.GattAttributes;
import com.ua.sdk.user.Gender;
import com.ua.sdk.user.User;
import java.util.Calendar;
import java.util.UUID;

/* loaded from: classes2.dex */
public class BluetoothArmour39Service implements BaseGattCallback.GattCallbackListener {
    private BluetoothActionQueue actionQueue;
    private Integer age;
    private boolean isReconnect;
    private boolean isStarted;
    private BluetoothClient.BluetoothClientListener listener;
    private BluetoothGattCharacteristic sensorConnectStateCharacteristic;
    private BluetoothGattCharacteristic sensorStateCharacteristic;
    private BluetoothGattCharacteristic userDataCharacteristic;
    private Integer weight;
    private BluetoothGattCharacteristic workoutDataCharacteristic;
    private Integer gender = 0;
    private Integer maxHR = Integer.valueOf(R2.attr.com_facebook_object_id);

    @Override // com.ua.sdk.recorder.datasource.sensor.bluetooth.BaseGattCallback.GattCallbackListener
    public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
    }

    @Override // com.ua.sdk.recorder.datasource.sensor.bluetooth.BaseGattCallback.GattCallbackListener
    public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
    }

    @Override // com.ua.sdk.recorder.datasource.sensor.bluetooth.BaseGattCallback.GattCallbackListener
    public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
    }

    @Override // com.ua.sdk.recorder.datasource.sensor.bluetooth.BaseGattCallback.GattCallbackListener
    public void setClientListener(BluetoothClient.BluetoothClientListener bluetoothClientListener) {
        this.listener = bluetoothClientListener;
    }

    public void startWorkout() {
        if (!this.isStarted && this.sensorStateCharacteristic != null) {
            this.actionQueue.addAction(new BluetoothAction(BluetoothAction.Action.READ, this.sensorStateCharacteristic, null));
        }
        this.isStarted = true;
    }

    public void stopWorkout() {
        UaLog.debug("workout stopped. changing sensor state to stopped");
        if (this.isStarted && this.sensorStateCharacteristic != null) {
            this.actionQueue.addAction(new BluetoothAction(BluetoothAction.Action.WRITE, this.sensorStateCharacteristic, new byte[]{0}));
        }
        this.isStarted = false;
    }

    public void disconnect() {
        UaLog.debug("workout disconnected. Disconnecting from armour39");
        if (this.sensorConnectStateCharacteristic != null) {
            this.actionQueue.addAction(new BluetoothAction(BluetoothAction.Action.WRITE, this.sensorConnectStateCharacteristic, new byte[]{123}));
        }
    }

    /* renamed from: com.ua.sdk.recorder.datasource.sensor.bluetooth.services.BluetoothArmour39Service$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ua$sdk$user$Gender;

        static {
            int[] iArr = new int[Gender.values().length];
            $SwitchMap$com$ua$sdk$user$Gender = iArr;
            try {
                iArr[Gender.MALE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ua$sdk$user$Gender[Gender.FEMALE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public void configureUser(User user, HeartRateZones heartRateZones) {
        if (user != null) {
            int i = AnonymousClass1.$SwitchMap$com$ua$sdk$user$Gender[user.getGender().ordinal()];
            if (i == 1) {
                this.gender = 0;
            } else if (i == 2) {
                this.gender = 1;
            }
            if (user.getWeight() != null) {
                this.weight = Integer.valueOf(user.getWeight().intValue());
            }
            if (user.getBirthdate() != null) {
                LocalDate birthdate = user.getBirthdate();
                Calendar calendar = Calendar.getInstance();
                this.age = Integer.valueOf(calendar.get(1) - birthdate.getYear());
                if (calendar.get(2) < birthdate.getMonth()) {
                    this.age = Integer.valueOf(this.age.intValue() - 1);
                } else if (calendar.get(2) == birthdate.getMonth() && calendar.get(5) < birthdate.getDayOfMonth()) {
                    this.age = Integer.valueOf(this.age.intValue() - 1);
                }
            }
        }
        if (heartRateZones != null) {
            this.maxHR = Integer.valueOf(heartRateZones.getZone(heartRateZones.getZones().size() - 1).getEnd());
        }
    }

    private void parseCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (bluetoothGattCharacteristic.getUuid().equals(UUID.fromString(GattAttributes.WORKOUT_DATA_CHARACTERISTIC))) {
            this.listener.onArmour39Measurement(bluetoothGattCharacteristic.getIntValue(18, 0).intValue(), bluetoothGattCharacteristic.getIntValue(18, 2).intValue(), bluetoothGattCharacteristic.getIntValue(18, 4).doubleValue() / 1000.0d, bluetoothGattCharacteristic.getIntValue(17, 6).intValue(), bluetoothGattCharacteristic.getIntValue(17, 7).intValue());
            return;
        }
        if (bluetoothGattCharacteristic.getUuid().equals(UUID.fromString(GattAttributes.SENSOR_STATE_CHARACTERISTIC))) {
            byte[] value = bluetoothGattCharacteristic.getValue();
            if (value[0] == 0 && this.isStarted) {
                UaLog.debug("workout started. changing sensor state to started");
                this.actionQueue.addAction(new BluetoothAction(BluetoothAction.Action.WRITE, this.sensorStateCharacteristic, new byte[]{1}));
            } else {
                if (value[0] != 1 || this.isReconnect || this.isStarted) {
                    return;
                }
                UaLog.debug("Not a reconnect so zero out value");
                this.actionQueue.addAction(new BluetoothAction(BluetoothAction.Action.WRITE, this.sensorStateCharacteristic, new byte[]{0}));
                this.isReconnect = false;
            }
        }
    }

    @Override // com.ua.sdk.recorder.datasource.sensor.bluetooth.BaseGattCallback.GattCallbackListener
    public void setBluetoothActionQueue(BluetoothActionQueue bluetoothActionQueue) {
        this.actionQueue = bluetoothActionQueue;
    }

    @Override // com.ua.sdk.recorder.datasource.sensor.bluetooth.BaseGattCallback.GattCallbackListener
    public void onUnexpectedDisconnect() {
        this.isReconnect = true;
    }

    @Override // com.ua.sdk.recorder.datasource.sensor.bluetooth.BaseGattCallback.GattCallbackListener
    public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
        if (this.weight == null || this.age == null || i != 0 || bluetoothGatt.getService(UUID.fromString(GattAttributes.ARMOUR39_SERVICE)) == null) {
            return;
        }
        this.userDataCharacteristic = bluetoothGatt.getService(UUID.fromString(GattAttributes.ARMOUR39_SERVICE)).getCharacteristic(UUID.fromString(GattAttributes.USER_DATA_CHARACTERISTIC));
        this.sensorStateCharacteristic = bluetoothGatt.getService(UUID.fromString(GattAttributes.ARMOUR39_SERVICE)).getCharacteristic(UUID.fromString(GattAttributes.SENSOR_STATE_CHARACTERISTIC));
        this.sensorConnectStateCharacteristic = bluetoothGatt.getService(UUID.fromString(GattAttributes.ARMOUR39_SERVICE)).getCharacteristic(UUID.fromString(GattAttributes.SENSOR_CONNECT_STATE_CHARACTERISTIC));
        this.workoutDataCharacteristic = bluetoothGatt.getService(UUID.fromString(GattAttributes.ARMOUR39_SERVICE)).getCharacteristic(UUID.fromString(GattAttributes.WORKOUT_DATA_CHARACTERISTIC));
        this.actionQueue.addAction(new BluetoothAction(BluetoothAction.Action.WRITE, this.userDataCharacteristic, new byte[]{this.gender.byteValue(), this.weight.byteValue(), this.age.byteValue(), this.maxHR.byteValue()}));
        this.actionQueue.addAction(new BluetoothAction(BluetoothAction.Action.NOTIFY, this.workoutDataCharacteristic, BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE));
        this.actionQueue.addAction(new BluetoothAction(BluetoothAction.Action.READ, this.sensorStateCharacteristic, null));
    }

    @Override // com.ua.sdk.recorder.datasource.sensor.bluetooth.BaseGattCallback.GattCallbackListener
    public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        if (i != 0 || bluetoothGatt.getService(UUID.fromString(GattAttributes.ARMOUR39_SERVICE)) == null) {
            return;
        }
        parseCharacteristic(bluetoothGattCharacteristic);
    }

    @Override // com.ua.sdk.recorder.datasource.sensor.bluetooth.BaseGattCallback.GattCallbackListener
    public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (bluetoothGatt.getService(UUID.fromString(GattAttributes.ARMOUR39_SERVICE)) != null) {
            parseCharacteristic(bluetoothGattCharacteristic);
        }
    }
}
