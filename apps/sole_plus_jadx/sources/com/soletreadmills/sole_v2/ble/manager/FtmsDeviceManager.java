package com.soletreadmills.sole_v2.ble.manager;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.camera.video.AudioStats;
import com.google.gson.Gson;
import com.soletreadmills.sole_v2.ble.BleUuid;
import com.soletreadmills.sole_v2.ble.SimpleFtmsDeviceName;
import com.soletreadmills.sole_v2.ble.cmd.FitnessMachineControlPointCmd;
import com.soletreadmills.sole_v2.ble.code.FitnessMachineControlPointOpCode;
import com.soletreadmills.sole_v2.ble.code.FitnessMachineControlPointResultCode;
import com.soletreadmills.sole_v2.ble.data.CrossTrainerData;
import com.soletreadmills.sole_v2.ble.data.FitnessMachineControlPointResponseData;
import com.soletreadmills.sole_v2.ble.data.FtmsBaseData;
import com.soletreadmills.sole_v2.ble.data.IndoorBikeData;
import com.soletreadmills.sole_v2.ble.data.RowerData;
import com.soletreadmills.sole_v2.ble.data.StepClimberData;
import com.soletreadmills.sole_v2.ble.data.TreadmillData;
import com.soletreadmills.sole_v2.ble.parsing.FtmsParsing;
import com.soletreadmills.sole_v2.ble.tool.CheckSimpleFtmsDataTool;
import com.soletreadmills.sole_v2.ble.tool.CheckSimpleFtmsDeviceTool;
import com.soletreadmills.sole_v2.ble.type.BleFtmsActionType;
import com.soletreadmills.sole_v2.ble.type.BleFtmsMachineType;
import com.soletreadmills.sole_v2.ble.type.FitnessMachineStatusType;
import no.nordicsemi.android.ble.BleManager;
import no.nordicsemi.android.ble.WriteRequest;
import no.nordicsemi.android.ble.callback.DataReceivedCallback;
import no.nordicsemi.android.ble.callback.DataSentCallback;
import no.nordicsemi.android.ble.callback.FailCallback;
import no.nordicsemi.android.ble.callback.InvalidRequestCallback;
import no.nordicsemi.android.ble.callback.SuccessCallback;
import no.nordicsemi.android.ble.data.Data;
import no.nordicsemi.android.ble.observer.ConnectionObserver;
import timber.log.Timber;

/* loaded from: classes5.dex */
public class FtmsDeviceManager extends BleManager {
    private final String TAG;
    private BleFtmsMachineType bleFtmsMachineType;
    private BleManager.BleManagerGattCallback bleManagerGattCallback;
    private String bluetoothDeviceName;
    private final ConnectionObserver connectionObserver;
    private BluetoothGattCharacteristic crossTrainerDataCharacteristic;
    private CrossTrainerData crossTrainerDataMultiple;
    private final DataReceivedCallback crossTrainerDataReceivedCallback;
    private Handler dataReceivedCallbackHandler;
    private HandlerThread dataReceivedCallbackHandlerThread;
    private int disconnectedReason;
    private BluetoothGattCharacteristic fitnessMachineControlPoint;
    private final DataReceivedCallback fitnessMachineControlPointDataReceivedCallback;
    private BluetoothGattCharacteristic fitnessMachineFeature;
    private final DataReceivedCallback fitnessMachineFeatureReceivedCallback;
    private BluetoothGattCharacteristic fitnessMachineStatus;
    private final DataReceivedCallback fitnessMachineStatusReceivedCallback;
    private FtmsBaseData ftmsBaseDataOld;
    private BluetoothGattCharacteristic indoorBikeDataCharacteristic;
    private IndoorBikeData indoorBikeDataMultiple;
    private final DataReceivedCallback indoorBikeDataReceivedCallback;
    private boolean isFemale;
    private boolean isHasAdv0x16;
    private boolean isMachineControl;
    boolean isRaceFinish;
    private boolean isSupportProgram;
    private FitnessMachineStatusType nowFitnessMachineStatusType;
    private BluetoothGattCharacteristic rowerDataCharacteristic;
    private RowerData rowerDataMultiple;
    private final DataReceivedCallback rowerDataReceivedCallback;
    private final SimpleFftmsManager simpleFftmsManager;
    private BluetoothGattCharacteristic stepClimberDataCharacteristic;
    private StepClimberData stepClimberDataMultiple;
    private final DataReceivedCallback stepClimberDataReceivedCallback;
    private BluetoothGattCharacteristic trainingStatus;
    private final DataReceivedCallback trainingStatusReceivedCallback;
    private BluetoothGattCharacteristic treadmillDataCharacteristic;
    private TreadmillData treadmillDataMultiple;
    private final DataReceivedCallback treadmillDataReceivedCallback;
    private double userWeightKg;

    public FtmsDeviceManager(Context context) {
        super(context);
        this.TAG = "FtmsDeviceManager";
        this.bluetoothDeviceName = null;
        this.bleManagerGattCallback = null;
        this.disconnectedReason = -1;
        this.dataReceivedCallbackHandlerThread = null;
        this.dataReceivedCallbackHandler = null;
        this.bleFtmsMachineType = null;
        this.fitnessMachineControlPoint = null;
        this.isMachineControl = false;
        this.isSupportProgram = false;
        this.fitnessMachineFeature = null;
        this.trainingStatus = null;
        this.fitnessMachineStatus = null;
        this.treadmillDataCharacteristic = null;
        this.indoorBikeDataCharacteristic = null;
        this.crossTrainerDataCharacteristic = null;
        this.stepClimberDataCharacteristic = null;
        this.rowerDataCharacteristic = null;
        this.ftmsBaseDataOld = null;
        this.isHasAdv0x16 = false;
        this.simpleFftmsManager = new SimpleFftmsManager();
        this.userWeightKg = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.isRaceFinish = false;
        ConnectionObserver connectionObserver = new ConnectionObserver() { // from class: com.soletreadmills.sole_v2.ble.manager.FtmsDeviceManager.1
            @Override // no.nordicsemi.android.ble.observer.ConnectionObserver
            public void onDeviceConnecting(BluetoothDevice device) {
                Timber.d("connectionObserver -> onDeviceConnecting", new Object[0]);
                FtmsDeviceManager.this.broadcastUpdate(BleFtmsActionType.FTMS_ACTION_GATT_CONNECTING, device.getAddress());
            }

            @Override // no.nordicsemi.android.ble.observer.ConnectionObserver
            public void onDeviceConnected(BluetoothDevice device) {
                Timber.d("connectionObserver -> onDeviceConnected", new Object[0]);
                FtmsDeviceManager.this.startDataReceivedCallbackHandlerThread();
                FtmsDeviceManager.this.isMachineControl = false;
                FtmsDeviceManager.this.isSupportProgram = false;
                BleDataManager.getInstance().setFitnessMachineFeatureList(null);
                BleDataManager.getInstance().setNowTrainingStatusType(null);
                BleDataManager.getInstance().setOldTrainingStatusType(null);
                FtmsDeviceManager.this.disconnectedReason = -1;
                FtmsDeviceManager.this.broadcastUpdate(BleFtmsActionType.FTMS_ACTION_GATT_CONNECTED, device.getAddress());
                FtmsDeviceManager.this.simpleFftmsManager.onDeviceConnected(device, FtmsDeviceManager.this.getBluetoothDeviceName(), FtmsDeviceManager.this.getUserWeightKg(), FtmsDeviceManager.this.isFemale());
            }

            @Override // no.nordicsemi.android.ble.observer.ConnectionObserver
            public void onDeviceFailedToConnect(BluetoothDevice device, int reason) {
                Timber.d("connectionObserver -> onDeviceFailedToConnect", new Object[0]);
                FtmsDeviceManager.this.onDeviceDisconnected(device);
            }

            @Override // no.nordicsemi.android.ble.observer.ConnectionObserver
            public void onDeviceReady(BluetoothDevice device) {
                Timber.d("connectionObserver -> onDeviceReady", new Object[0]);
            }

            @Override // no.nordicsemi.android.ble.observer.ConnectionObserver
            public void onDeviceDisconnecting(BluetoothDevice device) {
                Timber.d("connectionObserver -> onDeviceDisconnecting", new Object[0]);
            }

            @Override // no.nordicsemi.android.ble.observer.ConnectionObserver
            public void onDeviceDisconnected(BluetoothDevice device, int reason) {
                synchronized (FtmsDeviceManager.this) {
                    FtmsDeviceManager.this.disconnectedReason = reason;
                    Timber.d("connectionObserver -> onDeviceDisconnected disconnectedReason=" + FtmsDeviceManager.this.disconnectedReason, new Object[0]);
                    FtmsDeviceManager.this.onDeviceDisconnected(device);
                }
            }
        };
        this.connectionObserver = connectionObserver;
        this.fitnessMachineFeatureReceivedCallback = new DataReceivedCallback() { // from class: com.soletreadmills.sole_v2.ble.manager.FtmsDeviceManager.3
            @Override // no.nordicsemi.android.ble.callback.DataReceivedCallback
            public void onDataReceived(BluetoothDevice device, final Data data) {
                if (FtmsDeviceManager.this.dataReceivedCallbackHandler != null) {
                    FtmsDeviceManager.this.dataReceivedCallbackHandler.post(new Runnable() { // from class: com.soletreadmills.sole_v2.ble.manager.FtmsDeviceManager.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BleDataManager.getInstance().setFitnessMachineFeatureList(FtmsParsing.parsingFitnessMachineFeature(data));
                        }
                    });
                }
            }
        };
        this.trainingStatusReceivedCallback = new DataReceivedCallback() { // from class: com.soletreadmills.sole_v2.ble.manager.FtmsDeviceManager.4
            @Override // no.nordicsemi.android.ble.callback.DataReceivedCallback
            public void onDataReceived(BluetoothDevice device, Data data) {
                BleDataManager.getInstance().setOldTrainingStatusType(BleDataManager.getInstance().getNowTrainingStatusType());
                BleDataManager.getInstance().setNowTrainingStatusType(FtmsParsing.parsingTrainingStatus(data));
                FtmsDeviceManager.this.broadcastUpdate(BleFtmsActionType.FTMS_ACTION_TRAINING_STATUS_DATA_AVAILABLE);
            }
        };
        this.fitnessMachineStatusReceivedCallback = new DataReceivedCallback() { // from class: com.soletreadmills.sole_v2.ble.manager.FtmsDeviceManager.5
            @Override // no.nordicsemi.android.ble.callback.DataReceivedCallback
            public void onDataReceived(BluetoothDevice device, Data data) {
                BleDataManager.getInstance().setNowFitnessMachineStatusType(FtmsParsing.parsingFitnessMachineStatus(data));
                BleDataManager.getInstance().setNowFMSTypeOnlyFourType(FtmsParsing.parsingFitnessMachineStatus(data));
                FtmsDeviceManager.this.broadcastUpdate(BleFtmsActionType.FTMS_ACTION_FITNESS_MACHINE_STATUS_DATA_AVAILABLE);
            }
        };
        this.treadmillDataMultiple = null;
        this.treadmillDataReceivedCallback = new DataReceivedCallback() { // from class: com.soletreadmills.sole_v2.ble.manager.FtmsDeviceManager.6
            @Override // no.nordicsemi.android.ble.callback.DataReceivedCallback
            public void onDataReceived(final BluetoothDevice device, final Data data) {
                if (FtmsDeviceManager.this.dataReceivedCallbackHandler != null) {
                    FtmsDeviceManager.this.dataReceivedCallbackHandler.post(new Runnable() { // from class: com.soletreadmills.sole_v2.ble.manager.FtmsDeviceManager.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            FtmsBaseData ftmsBaseDataProcessData;
                            if (data.getValue() == null || data.getValue().length <= 0 || FtmsDeviceManager.this.isRaceFinish) {
                                return;
                            }
                            try {
                                ftmsBaseDataProcessData = FtmsParsing.parsingFtmsData(device, FtmsDeviceManager.this, FtmsDeviceManager.this.treadmillDataCharacteristic, data);
                            } catch (Exception e) {
                                Timber.e(e);
                                ftmsBaseDataProcessData = null;
                            }
                            boolean zIsSimpleTreadmillData = CheckSimpleFtmsDataTool.isSimpleTreadmillData(ftmsBaseDataProcessData, data);
                            Timber.d("Treadmill isSimpleFTMS=%s", Boolean.valueOf(zIsSimpleTreadmillData));
                            if (zIsSimpleTreadmillData) {
                                FtmsDeviceManager.this.simpleFftmsManager.checkStartTimer();
                                ftmsBaseDataProcessData = FtmsDeviceManager.this.simpleFftmsManager.processData(ftmsBaseDataProcessData);
                            } else if (ftmsBaseDataProcessData instanceof TreadmillData) {
                                TreadmillData treadmillData = (TreadmillData) ftmsBaseDataProcessData;
                                if (treadmillData.getElapsedTime() == null) {
                                    FtmsDeviceManager.this.treadmillDataMultiple = treadmillData;
                                    return;
                                }
                                if (treadmillData.getElapsedTime() != null && FtmsDeviceManager.this.treadmillDataMultiple != null) {
                                    if (treadmillData.getInstantaneousSpeed() == null) {
                                        treadmillData.setInstantaneousSpeed(FtmsDeviceManager.this.treadmillDataMultiple.getInstantaneousSpeed());
                                    }
                                    if (treadmillData.getAverageSpeed() == null) {
                                        treadmillData.setAverageSpeed(FtmsDeviceManager.this.treadmillDataMultiple.getAverageSpeed());
                                    }
                                    if (treadmillData.getTotalDistance() == null) {
                                        treadmillData.setTotalDistance(FtmsDeviceManager.this.treadmillDataMultiple.getTotalDistance());
                                    }
                                    if (treadmillData.getInclination() == null) {
                                        treadmillData.setInclination(FtmsDeviceManager.this.treadmillDataMultiple.getInclination());
                                    }
                                    if (treadmillData.getRampAngleSetting() == null) {
                                        treadmillData.setRampAngleSetting(FtmsDeviceManager.this.treadmillDataMultiple.getRampAngleSetting());
                                    }
                                    if (treadmillData.getPositiveElevationGain() == null) {
                                        treadmillData.setPositiveElevationGain(FtmsDeviceManager.this.treadmillDataMultiple.getPositiveElevationGain());
                                    }
                                    if (treadmillData.getNegativeElevationGain() == null) {
                                        treadmillData.setNegativeElevationGain(FtmsDeviceManager.this.treadmillDataMultiple.getNegativeElevationGain());
                                    }
                                    if (treadmillData.getInstantaneousPace() == null) {
                                        treadmillData.setInstantaneousPace(FtmsDeviceManager.this.treadmillDataMultiple.getInstantaneousPace());
                                    }
                                    if (treadmillData.getAveragePace() == null) {
                                        treadmillData.setAveragePace(FtmsDeviceManager.this.treadmillDataMultiple.getAveragePace());
                                    }
                                    if (treadmillData.getTotalEnergy() == null) {
                                        treadmillData.setTotalEnergy(FtmsDeviceManager.this.treadmillDataMultiple.getTotalEnergy());
                                    }
                                    if (treadmillData.getEnergyPerHour() == null) {
                                        treadmillData.setEnergyPerHour(FtmsDeviceManager.this.treadmillDataMultiple.getEnergyPerHour());
                                    }
                                    if (treadmillData.getEnergyPerMinute() == null) {
                                        treadmillData.setEnergyPerMinute(FtmsDeviceManager.this.treadmillDataMultiple.getEnergyPerMinute());
                                    }
                                    if (treadmillData.getHeartRate() == null) {
                                        treadmillData.setHeartRate(FtmsDeviceManager.this.treadmillDataMultiple.getHeartRate());
                                    }
                                    if (treadmillData.getMetabolicEquivalent() == null) {
                                        treadmillData.setMetabolicEquivalent(FtmsDeviceManager.this.treadmillDataMultiple.getMetabolicEquivalent());
                                    }
                                    if (treadmillData.getElapsedTime() == null) {
                                        treadmillData.setElapsedTime(FtmsDeviceManager.this.treadmillDataMultiple.getElapsedTime());
                                    }
                                    if (treadmillData.getRemainingTime() == null) {
                                        treadmillData.setRemainingTime(FtmsDeviceManager.this.treadmillDataMultiple.getRemainingTime());
                                    }
                                    if (treadmillData.getForceOnBelt() == null) {
                                        treadmillData.setForceOnBelt(FtmsDeviceManager.this.treadmillDataMultiple.getForceOnBelt());
                                    }
                                    if (treadmillData.getPowerOutput() == null) {
                                        treadmillData.setPowerOutput(FtmsDeviceManager.this.treadmillDataMultiple.getPowerOutput());
                                    }
                                }
                            }
                            if (ftmsBaseDataProcessData != null) {
                                BleDataManager.getInstance().virtualRaceFix(ftmsBaseDataProcessData);
                                BleDataManager.getInstance().addFtmsData(ftmsBaseDataProcessData);
                                if (BleDataManager.nowWearHrData != null && BleDataManager.nowWearHrData.checkTimeInRangeAndGetValue() >= 0) {
                                    ftmsBaseDataProcessData.setHeartRate(Integer.valueOf(BleDataManager.nowWearHrData.checkTimeInRangeAndGetValue()));
                                }
                                if (FtmsDeviceManager.this.nowFitnessMachineStatusType != null) {
                                    ftmsBaseDataProcessData.setFitnessMachineStatusType(FtmsDeviceManager.this.nowFitnessMachineStatusType);
                                }
                                String json = new Gson().toJson(ftmsBaseDataProcessData);
                                if (ftmsBaseDataProcessData instanceof TreadmillData) {
                                    FtmsDeviceManager.this.broadcastUpdateExtraDataFtms(json, TreadmillData.class.getName());
                                }
                                FtmsDeviceManager.this.setFtmsBaseDataOld(ftmsBaseDataProcessData);
                            }
                        }
                    });
                }
            }
        };
        this.indoorBikeDataMultiple = null;
        this.indoorBikeDataReceivedCallback = new DataReceivedCallback() { // from class: com.soletreadmills.sole_v2.ble.manager.FtmsDeviceManager.7
            @Override // no.nordicsemi.android.ble.callback.DataReceivedCallback
            public void onDataReceived(final BluetoothDevice device, final Data data) {
                if (FtmsDeviceManager.this.dataReceivedCallbackHandler != null) {
                    FtmsDeviceManager.this.dataReceivedCallbackHandler.post(new Runnable() { // from class: com.soletreadmills.sole_v2.ble.manager.FtmsDeviceManager.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            FtmsBaseData ftmsBaseDataProcessData;
                            if (data.getValue() == null || data.getValue().length <= 0) {
                                return;
                            }
                            try {
                                ftmsBaseDataProcessData = FtmsParsing.parsingFtmsData(device, FtmsDeviceManager.this, FtmsDeviceManager.this.indoorBikeDataCharacteristic, data);
                            } catch (Exception e) {
                                Timber.e(e);
                                ftmsBaseDataProcessData = null;
                            }
                            boolean z = true;
                            if (!CheckSimpleFtmsDataTool.isSimpleBikeEjekData(ftmsBaseDataProcessData, data) && (CheckSimpleFtmsDataTool.isSimpleBikeCorestarData(ftmsBaseDataProcessData, data) || (!CheckSimpleFtmsDataTool.isSimpleBikeDirectionData(ftmsBaseDataProcessData, data) && !CheckSimpleFtmsDataTool.isSimpleEllipticalEjekData(ftmsBaseDataProcessData, data)))) {
                                z = false;
                            }
                            Timber.d("IndoorBike isSimpleFTMS=%s", Boolean.valueOf(z));
                            if (z) {
                                FtmsDeviceManager.this.simpleFftmsManager.checkStartTimer();
                                ftmsBaseDataProcessData = FtmsDeviceManager.this.simpleFftmsManager.processData(ftmsBaseDataProcessData);
                            } else if (ftmsBaseDataProcessData instanceof IndoorBikeData) {
                                IndoorBikeData indoorBikeData = (IndoorBikeData) ftmsBaseDataProcessData;
                                if (indoorBikeData.getElapsedTime() == null) {
                                    FtmsDeviceManager.this.indoorBikeDataMultiple = indoorBikeData;
                                    return;
                                }
                                if (ftmsBaseDataProcessData.getElapsedTime() != null && FtmsDeviceManager.this.indoorBikeDataMultiple != null) {
                                    if (indoorBikeData.getInstantaneousSpeed() == null) {
                                        indoorBikeData.setInstantaneousSpeed(FtmsDeviceManager.this.indoorBikeDataMultiple.getInstantaneousSpeed());
                                    }
                                    if (indoorBikeData.getAverageSpeed() == null) {
                                        indoorBikeData.setAverageSpeed(FtmsDeviceManager.this.indoorBikeDataMultiple.getAverageSpeed());
                                    }
                                    if (indoorBikeData.getInstantaneousCadence() == null) {
                                        indoorBikeData.setInstantaneousCadence(FtmsDeviceManager.this.indoorBikeDataMultiple.getInstantaneousCadence());
                                    }
                                    if (indoorBikeData.getAverageCadence() == null) {
                                        indoorBikeData.setAverageCadence(FtmsDeviceManager.this.indoorBikeDataMultiple.getAverageCadence());
                                    }
                                    if (indoorBikeData.getTotalDistance() == null) {
                                        indoorBikeData.setTotalDistance(FtmsDeviceManager.this.indoorBikeDataMultiple.getTotalDistance());
                                    }
                                    if (indoorBikeData.getResistanceLevel() == null) {
                                        indoorBikeData.setResistanceLevel(FtmsDeviceManager.this.indoorBikeDataMultiple.getResistanceLevel());
                                    }
                                    if (indoorBikeData.getInstantaneousPower() == null) {
                                        indoorBikeData.setInstantaneousPower(FtmsDeviceManager.this.indoorBikeDataMultiple.getInstantaneousPower());
                                    }
                                    if (indoorBikeData.getAveragePower() == null) {
                                        indoorBikeData.setAveragePower(FtmsDeviceManager.this.indoorBikeDataMultiple.getAveragePower());
                                    }
                                    if (indoorBikeData.getTotalEnergy() == null) {
                                        indoorBikeData.setTotalEnergy(FtmsDeviceManager.this.indoorBikeDataMultiple.getTotalEnergy());
                                    }
                                    if (indoorBikeData.getEnergyPerHour() == null) {
                                        indoorBikeData.setEnergyPerHour(FtmsDeviceManager.this.indoorBikeDataMultiple.getEnergyPerHour());
                                    }
                                    if (indoorBikeData.getEnergyPerMinute() == null) {
                                        indoorBikeData.setEnergyPerMinute(FtmsDeviceManager.this.indoorBikeDataMultiple.getEnergyPerMinute());
                                    }
                                    if (indoorBikeData.getHeartRate() == null) {
                                        indoorBikeData.setHeartRate(FtmsDeviceManager.this.indoorBikeDataMultiple.getHeartRate());
                                    }
                                    if (indoorBikeData.getMetabolicEquivalent() == null) {
                                        indoorBikeData.setMetabolicEquivalent(FtmsDeviceManager.this.indoorBikeDataMultiple.getMetabolicEquivalent());
                                    }
                                    if (indoorBikeData.getElapsedTime() == null) {
                                        indoorBikeData.setElapsedTime(FtmsDeviceManager.this.indoorBikeDataMultiple.getElapsedTime());
                                    }
                                    if (indoorBikeData.getRemainingTime() == null) {
                                        indoorBikeData.setRemainingTime(FtmsDeviceManager.this.indoorBikeDataMultiple.getRemainingTime());
                                    }
                                    if (indoorBikeData.getInclination() == null) {
                                        indoorBikeData.setInclination(FtmsDeviceManager.this.indoorBikeDataMultiple.getInclination());
                                    }
                                }
                            }
                            if (ftmsBaseDataProcessData != null) {
                                BleDataManager.getInstance().virtualRaceFix(ftmsBaseDataProcessData);
                                BleDataManager.getInstance().addFtmsData(ftmsBaseDataProcessData);
                                if (BleDataManager.nowWearHrData != null && BleDataManager.nowWearHrData.checkTimeInRangeAndGetValue() >= 0) {
                                    ftmsBaseDataProcessData.setHeartRate(Integer.valueOf(BleDataManager.nowWearHrData.checkTimeInRangeAndGetValue()));
                                }
                                if (FtmsDeviceManager.this.nowFitnessMachineStatusType != null) {
                                    ftmsBaseDataProcessData.setFitnessMachineStatusType(FtmsDeviceManager.this.nowFitnessMachineStatusType);
                                }
                                String json = new Gson().toJson(ftmsBaseDataProcessData);
                                if (ftmsBaseDataProcessData instanceof IndoorBikeData) {
                                    FtmsDeviceManager.this.broadcastUpdateExtraDataFtms(json, IndoorBikeData.class.getName());
                                } else if (ftmsBaseDataProcessData instanceof CrossTrainerData) {
                                    FtmsDeviceManager.this.broadcastUpdateExtraDataFtms(json, CrossTrainerData.class.getName());
                                }
                            }
                            FtmsDeviceManager.this.setFtmsBaseDataOld(ftmsBaseDataProcessData);
                        }
                    });
                }
            }
        };
        this.crossTrainerDataMultiple = null;
        this.crossTrainerDataReceivedCallback = new DataReceivedCallback() { // from class: com.soletreadmills.sole_v2.ble.manager.FtmsDeviceManager.8
            @Override // no.nordicsemi.android.ble.callback.DataReceivedCallback
            public void onDataReceived(final BluetoothDevice device, final Data data) {
                if (FtmsDeviceManager.this.dataReceivedCallbackHandler != null) {
                    FtmsDeviceManager.this.dataReceivedCallbackHandler.post(new Runnable() { // from class: com.soletreadmills.sole_v2.ble.manager.FtmsDeviceManager.8.1
                        @Override // java.lang.Runnable
                        public void run() {
                            FtmsBaseData ftmsBaseDataProcessData;
                            boolean z;
                            if (data.getValue() == null || data.getValue().length <= 0) {
                                return;
                            }
                            try {
                                ftmsBaseDataProcessData = FtmsParsing.parsingFtmsData(device, FtmsDeviceManager.this, FtmsDeviceManager.this.crossTrainerDataCharacteristic, data);
                            } catch (Exception e) {
                                Timber.e(e);
                                ftmsBaseDataProcessData = null;
                            }
                            if (CheckSimpleFtmsDataTool.isSimpleEllipticalEjekData(ftmsBaseDataProcessData, data)) {
                                z = true;
                            } else {
                                CheckSimpleFtmsDataTool.isSimpleEllipticalCorestarData(ftmsBaseDataProcessData, data);
                                z = false;
                            }
                            Timber.d("crossTrainer isSimpleFTMS=%s", Boolean.valueOf(z));
                            if (!z && FtmsDeviceManager.this.indoorBikeDataCharacteristic != null) {
                                FtmsDeviceManager.this.removeNotificationCallback(FtmsDeviceManager.this.indoorBikeDataCharacteristic);
                                FtmsDeviceManager.this.disableNotifications(FtmsDeviceManager.this.indoorBikeDataCharacteristic).enqueue();
                                FtmsDeviceManager.this.indoorBikeDataCharacteristic = null;
                            }
                            if (z) {
                                FtmsDeviceManager.this.simpleFftmsManager.checkStartTimer();
                                ftmsBaseDataProcessData = FtmsDeviceManager.this.simpleFftmsManager.processData(ftmsBaseDataProcessData);
                            } else if (ftmsBaseDataProcessData instanceof CrossTrainerData) {
                                CrossTrainerData crossTrainerData = (CrossTrainerData) ftmsBaseDataProcessData;
                                if (crossTrainerData.getElapsedTime() == null) {
                                    FtmsDeviceManager.this.crossTrainerDataMultiple = crossTrainerData;
                                    return;
                                }
                                if (crossTrainerData.getElapsedTime() != null && FtmsDeviceManager.this.crossTrainerDataMultiple != null) {
                                    if (crossTrainerData.getInstantaneousSpeed() == null) {
                                        crossTrainerData.setInstantaneousSpeed(FtmsDeviceManager.this.crossTrainerDataMultiple.getInstantaneousSpeed());
                                    }
                                    if (crossTrainerData.getAverageSpeed() == null) {
                                        crossTrainerData.setAverageSpeed(FtmsDeviceManager.this.crossTrainerDataMultiple.getAverageSpeed());
                                    }
                                    if (crossTrainerData.getTotalDistance() == null) {
                                        crossTrainerData.setTotalDistance(FtmsDeviceManager.this.crossTrainerDataMultiple.getTotalDistance());
                                    }
                                    if (crossTrainerData.getStepPerMinute() == null) {
                                        crossTrainerData.setStepPerMinute(FtmsDeviceManager.this.crossTrainerDataMultiple.getStepPerMinute());
                                    }
                                    if (crossTrainerData.getAverageStepRate() == null) {
                                        crossTrainerData.setAverageStepRate(FtmsDeviceManager.this.crossTrainerDataMultiple.getAverageStepRate());
                                    }
                                    if (crossTrainerData.getStrideCount() == null) {
                                        crossTrainerData.setStrideCount(FtmsDeviceManager.this.crossTrainerDataMultiple.getStrideCount());
                                    }
                                    if (crossTrainerData.getPositiveElevationGain() == null) {
                                        crossTrainerData.setPositiveElevationGain(FtmsDeviceManager.this.crossTrainerDataMultiple.getPositiveElevationGain());
                                    }
                                    if (crossTrainerData.getNegativeElevationGain() == null) {
                                        crossTrainerData.setNegativeElevationGain(FtmsDeviceManager.this.crossTrainerDataMultiple.getNegativeElevationGain());
                                    }
                                    if (crossTrainerData.getInclination() == null) {
                                        crossTrainerData.setInclination(FtmsDeviceManager.this.crossTrainerDataMultiple.getInclination());
                                    }
                                    if (crossTrainerData.getRampAngleSetting() == null) {
                                        crossTrainerData.setRampAngleSetting(FtmsDeviceManager.this.crossTrainerDataMultiple.getRampAngleSetting());
                                    }
                                    if (crossTrainerData.getResistanceLevel() == null) {
                                        crossTrainerData.setResistanceLevel(FtmsDeviceManager.this.crossTrainerDataMultiple.getResistanceLevel());
                                    }
                                    if (crossTrainerData.getInstantaneousPower() == null) {
                                        crossTrainerData.setInstantaneousPower(FtmsDeviceManager.this.crossTrainerDataMultiple.getInstantaneousPower());
                                    }
                                    if (crossTrainerData.getAveragePower() == null) {
                                        crossTrainerData.setAveragePower(FtmsDeviceManager.this.crossTrainerDataMultiple.getAveragePower());
                                    }
                                    if (crossTrainerData.getTotalEnergy() == null) {
                                        crossTrainerData.setTotalEnergy(FtmsDeviceManager.this.crossTrainerDataMultiple.getTotalEnergy());
                                    }
                                    if (crossTrainerData.getEnergyPerHour() == null) {
                                        crossTrainerData.setEnergyPerHour(FtmsDeviceManager.this.crossTrainerDataMultiple.getEnergyPerHour());
                                    }
                                    if (crossTrainerData.getEnergyPerMinute() == null) {
                                        crossTrainerData.setEnergyPerMinute(FtmsDeviceManager.this.crossTrainerDataMultiple.getEnergyPerMinute());
                                    }
                                    if (crossTrainerData.getHeartRate() == null) {
                                        crossTrainerData.setHeartRate(FtmsDeviceManager.this.crossTrainerDataMultiple.getHeartRate());
                                    }
                                    if (crossTrainerData.getMetabolicEquivalent() == null) {
                                        crossTrainerData.setMetabolicEquivalent(FtmsDeviceManager.this.crossTrainerDataMultiple.getMetabolicEquivalent());
                                    }
                                    if (crossTrainerData.getElapsedTime() == null) {
                                        crossTrainerData.setElapsedTime(FtmsDeviceManager.this.crossTrainerDataMultiple.getElapsedTime());
                                    }
                                    if (crossTrainerData.getRemainingTime() == null) {
                                        crossTrainerData.setRemainingTime(FtmsDeviceManager.this.crossTrainerDataMultiple.getRemainingTime());
                                    }
                                    if (crossTrainerData.getMovementDirection() == null) {
                                        crossTrainerData.setMovementDirection(FtmsDeviceManager.this.crossTrainerDataMultiple.getMovementDirection());
                                    }
                                }
                                if (CheckSimpleFtmsDataTool.isSimpleEllipticalCorestarData(crossTrainerData, data) && !FtmsDeviceManager.this.isHasAdv0x16()) {
                                    if (crossTrainerData.getBleName().toUpperCase().contains(SimpleFtmsDeviceName.ELLIPTICAL_SPIRIT_CORESTAR_XE395) ? false : crossTrainerData.getInclination() != null) {
                                        crossTrainerData.setInclination(Double.valueOf(crossTrainerData.getInclination().doubleValue() * 10.0d));
                                    }
                                }
                            }
                            if (ftmsBaseDataProcessData != null) {
                                BleDataManager.getInstance().virtualRaceFix(ftmsBaseDataProcessData);
                                BleDataManager.getInstance().addFtmsData(ftmsBaseDataProcessData);
                                if (BleDataManager.nowWearHrData != null && BleDataManager.nowWearHrData.checkTimeInRangeAndGetValue() >= 0) {
                                    ftmsBaseDataProcessData.setHeartRate(Integer.valueOf(BleDataManager.nowWearHrData.checkTimeInRangeAndGetValue()));
                                }
                                if (FtmsDeviceManager.this.nowFitnessMachineStatusType != null) {
                                    ftmsBaseDataProcessData.setFitnessMachineStatusType(FtmsDeviceManager.this.nowFitnessMachineStatusType);
                                }
                                FtmsDeviceManager.this.broadcastUpdateExtraDataFtms(new Gson().toJson(ftmsBaseDataProcessData), CrossTrainerData.class.getName());
                            }
                            FtmsDeviceManager.this.setFtmsBaseDataOld(ftmsBaseDataProcessData);
                        }
                    });
                }
            }
        };
        this.stepClimberDataMultiple = null;
        this.stepClimberDataReceivedCallback = new DataReceivedCallback() { // from class: com.soletreadmills.sole_v2.ble.manager.FtmsDeviceManager.9
            @Override // no.nordicsemi.android.ble.callback.DataReceivedCallback
            public void onDataReceived(final BluetoothDevice device, final Data data) {
                if (FtmsDeviceManager.this.dataReceivedCallbackHandler != null) {
                    FtmsDeviceManager.this.dataReceivedCallbackHandler.post(new Runnable() { // from class: com.soletreadmills.sole_v2.ble.manager.FtmsDeviceManager.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            StepClimberData stepClimberData;
                            if (data.getValue() == null || data.getValue().length <= 0) {
                                return;
                            }
                            try {
                                stepClimberData = (StepClimberData) FtmsParsing.parsingFtmsData(device, FtmsDeviceManager.this, FtmsDeviceManager.this.stepClimberDataCharacteristic, data);
                            } catch (Exception e) {
                                Timber.e(e);
                                stepClimberData = null;
                            }
                            Timber.d("stepClimber isSimpleFTMS=%s", false);
                            if (stepClimberData != null && stepClimberData.getElapsedTime() == null) {
                                FtmsDeviceManager.this.stepClimberDataMultiple = stepClimberData;
                                return;
                            }
                            if (stepClimberData != null && stepClimberData.getElapsedTime() != null && FtmsDeviceManager.this.stepClimberDataMultiple != null) {
                                if (stepClimberData.getFloors() == null) {
                                    stepClimberData.setFloors(FtmsDeviceManager.this.stepClimberDataMultiple.getFloors());
                                }
                                if (stepClimberData.getStepCount() == null) {
                                    stepClimberData.setStepCount(FtmsDeviceManager.this.stepClimberDataMultiple.getStepCount());
                                }
                                if (stepClimberData.getStepPerMinute() == null) {
                                    stepClimberData.setStepPerMinute(FtmsDeviceManager.this.stepClimberDataMultiple.getStepPerMinute());
                                }
                                if (stepClimberData.getAverageStepRate() == null) {
                                    stepClimberData.setAverageStepRate(FtmsDeviceManager.this.stepClimberDataMultiple.getAverageStepRate());
                                }
                                if (stepClimberData.getPositiveElevationGain() == null) {
                                    stepClimberData.setPositiveElevationGain(FtmsDeviceManager.this.stepClimberDataMultiple.getPositiveElevationGain());
                                }
                                if (stepClimberData.getResistanceLevel() == null) {
                                    stepClimberData.setResistanceLevel(FtmsDeviceManager.this.stepClimberDataMultiple.getResistanceLevel());
                                }
                                if (stepClimberData.getTotalEnergy() == null) {
                                    stepClimberData.setTotalEnergy(FtmsDeviceManager.this.stepClimberDataMultiple.getTotalEnergy());
                                }
                                if (stepClimberData.getEnergyPerHour() == null) {
                                    stepClimberData.setEnergyPerHour(FtmsDeviceManager.this.stepClimberDataMultiple.getEnergyPerHour());
                                }
                                if (stepClimberData.getEnergyPerMinute() == null) {
                                    stepClimberData.setEnergyPerMinute(FtmsDeviceManager.this.stepClimberDataMultiple.getEnergyPerMinute());
                                }
                                if (stepClimberData.getHeartRate() == null) {
                                    stepClimberData.setHeartRate(FtmsDeviceManager.this.stepClimberDataMultiple.getHeartRate());
                                }
                                if (stepClimberData.getMetabolicEquivalent() == null) {
                                    stepClimberData.setMetabolicEquivalent(FtmsDeviceManager.this.stepClimberDataMultiple.getMetabolicEquivalent());
                                }
                                if (stepClimberData.getElapsedTime() == null) {
                                    stepClimberData.setElapsedTime(FtmsDeviceManager.this.stepClimberDataMultiple.getElapsedTime());
                                }
                                if (stepClimberData.getRemainingTime() == null) {
                                    stepClimberData.setRemainingTime(FtmsDeviceManager.this.stepClimberDataMultiple.getRemainingTime());
                                }
                            }
                            if (stepClimberData != null) {
                                BleDataManager.getInstance().virtualRaceFix(stepClimberData);
                                BleDataManager.getInstance().addFtmsData(stepClimberData);
                                if (BleDataManager.nowWearHrData != null && BleDataManager.nowWearHrData.checkTimeInRangeAndGetValue() >= 0) {
                                    stepClimberData.setHeartRate(Integer.valueOf(BleDataManager.nowWearHrData.checkTimeInRangeAndGetValue()));
                                }
                                if (FtmsDeviceManager.this.nowFitnessMachineStatusType != null) {
                                    stepClimberData.setFitnessMachineStatusType(FtmsDeviceManager.this.nowFitnessMachineStatusType);
                                }
                                FtmsDeviceManager.this.broadcastUpdateExtraDataFtms(new Gson().toJson(stepClimberData), StepClimberData.class.getName());
                            }
                            FtmsDeviceManager.this.setFtmsBaseDataOld(stepClimberData);
                        }
                    });
                }
            }
        };
        this.rowerDataMultiple = null;
        this.rowerDataReceivedCallback = new DataReceivedCallback() { // from class: com.soletreadmills.sole_v2.ble.manager.FtmsDeviceManager.10
            @Override // no.nordicsemi.android.ble.callback.DataReceivedCallback
            public void onDataReceived(final BluetoothDevice device, final Data data) {
                if (FtmsDeviceManager.this.dataReceivedCallbackHandler != null) {
                    FtmsDeviceManager.this.dataReceivedCallbackHandler.post(new Runnable() { // from class: com.soletreadmills.sole_v2.ble.manager.FtmsDeviceManager.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            RowerData rowerData;
                            if (data.getValue() == null || data.getValue().length <= 0) {
                                return;
                            }
                            try {
                                rowerData = (RowerData) FtmsParsing.parsingFtmsData(device, FtmsDeviceManager.this, FtmsDeviceManager.this.rowerDataCharacteristic, data);
                            } catch (Exception e) {
                                Timber.e(e);
                                rowerData = null;
                            }
                            Timber.d("stepClimber isSimpleFTMS=%s", false);
                            if (rowerData != null && rowerData.getElapsedTime() == null) {
                                FtmsDeviceManager.this.rowerDataMultiple = rowerData;
                                return;
                            }
                            if (rowerData != null && rowerData.getElapsedTime() != null && FtmsDeviceManager.this.rowerDataMultiple != null) {
                                if (rowerData.getStrokeRate() == null) {
                                    rowerData.setStrokeRate(FtmsDeviceManager.this.rowerDataMultiple.getStrokeRate());
                                }
                                if (rowerData.getStrokeCount() == null) {
                                    rowerData.setStrokeCount(FtmsDeviceManager.this.rowerDataMultiple.getStrokeCount());
                                }
                                if (rowerData.getAverageStrokeRate() == null) {
                                    rowerData.setAverageStrokeRate(FtmsDeviceManager.this.rowerDataMultiple.getAverageStrokeRate());
                                }
                                if (rowerData.getTotalDistance() == null) {
                                    rowerData.setTotalDistance(FtmsDeviceManager.this.rowerDataMultiple.getTotalDistance());
                                }
                                if (rowerData.getInstantaneousPace() == null) {
                                    rowerData.setInstantaneousPace(FtmsDeviceManager.this.rowerDataMultiple.getInstantaneousPace());
                                }
                                if (rowerData.getAveragePace() == null) {
                                    rowerData.setAveragePace(FtmsDeviceManager.this.rowerDataMultiple.getAveragePace());
                                }
                                if (rowerData.getInstantaneousPower() == null) {
                                    rowerData.setInstantaneousPower(FtmsDeviceManager.this.rowerDataMultiple.getInstantaneousPower());
                                }
                                if (rowerData.getAveragePower() == null) {
                                    rowerData.setAveragePower(FtmsDeviceManager.this.rowerDataMultiple.getAveragePower());
                                }
                                if (rowerData.getResistanceLevel() == null) {
                                    rowerData.setResistanceLevel(FtmsDeviceManager.this.rowerDataMultiple.getResistanceLevel());
                                }
                                if (rowerData.getTotalEnergy() == null) {
                                    rowerData.setTotalEnergy(FtmsDeviceManager.this.rowerDataMultiple.getTotalEnergy());
                                }
                                if (rowerData.getEnergyPerHour() == null) {
                                    rowerData.setEnergyPerHour(FtmsDeviceManager.this.rowerDataMultiple.getEnergyPerHour());
                                }
                                if (rowerData.getEnergyPerMinute() == null) {
                                    rowerData.setEnergyPerMinute(FtmsDeviceManager.this.rowerDataMultiple.getEnergyPerMinute());
                                }
                                if (rowerData.getHeartRate() == null) {
                                    rowerData.setHeartRate(FtmsDeviceManager.this.rowerDataMultiple.getHeartRate());
                                }
                                if (rowerData.getMetabolicEquivalent() == null) {
                                    rowerData.setMetabolicEquivalent(FtmsDeviceManager.this.rowerDataMultiple.getMetabolicEquivalent());
                                }
                                if (rowerData.getElapsedTime() == null) {
                                    rowerData.setElapsedTime(FtmsDeviceManager.this.rowerDataMultiple.getElapsedTime());
                                }
                                if (rowerData.getRemainingTime() == null) {
                                    rowerData.setRemainingTime(FtmsDeviceManager.this.rowerDataMultiple.getRemainingTime());
                                }
                            }
                            if (rowerData != null) {
                                BleDataManager.getInstance().virtualRaceFix(rowerData);
                                BleDataManager.getInstance().addFtmsData(rowerData);
                                if (BleDataManager.nowWearHrData != null && BleDataManager.nowWearHrData.checkTimeInRangeAndGetValue() >= 0) {
                                    rowerData.setHeartRate(Integer.valueOf(BleDataManager.nowWearHrData.checkTimeInRangeAndGetValue()));
                                }
                                if (FtmsDeviceManager.this.nowFitnessMachineStatusType != null) {
                                    rowerData.setFitnessMachineStatusType(FtmsDeviceManager.this.nowFitnessMachineStatusType);
                                }
                                FtmsDeviceManager.this.broadcastUpdateExtraDataFtms(new Gson().toJson(rowerData), RowerData.class.getName());
                            }
                            FtmsDeviceManager.this.setFtmsBaseDataOld(rowerData);
                        }
                    });
                }
            }
        };
        this.fitnessMachineControlPointDataReceivedCallback = new DataReceivedCallback() { // from class: com.soletreadmills.sole_v2.ble.manager.FtmsDeviceManager.11
            @Override // no.nordicsemi.android.ble.callback.DataReceivedCallback
            public void onDataReceived(final BluetoothDevice device, final Data data) {
                if (FtmsDeviceManager.this.dataReceivedCallbackHandler != null) {
                    FtmsDeviceManager.this.dataReceivedCallbackHandler.post(new Runnable() { // from class: com.soletreadmills.sole_v2.ble.manager.FtmsDeviceManager.11.1
                        @Override // java.lang.Runnable
                        public void run() {
                            FitnessMachineControlPointResponseData fitnessMachineControlPointResponseDataParsingFitnessMachineControlPointResponse = FtmsParsing.parsingFitnessMachineControlPointResponse(data);
                            Timber.d("fitnessMachineControlPointDataReceivedCallback FitnessMachineControlPointResponseData=%s", fitnessMachineControlPointResponseDataParsingFitnessMachineControlPointResponse.toString());
                            if (fitnessMachineControlPointResponseDataParsingFitnessMachineControlPointResponse.getOpCodeType() == FitnessMachineControlPointOpCode.Type.REQUEST_CONTROL && fitnessMachineControlPointResponseDataParsingFitnessMachineControlPointResponse.getResultCodeType() == FitnessMachineControlPointResultCode.Type.SUCCESS) {
                                synchronized (FtmsDeviceManager.this) {
                                    FtmsDeviceManager.this.isMachineControl = true;
                                }
                            }
                            if (fitnessMachineControlPointResponseDataParsingFitnessMachineControlPointResponse.getOpCodeType() == FitnessMachineControlPointOpCode.Type.SUPPORT_PROGRAM && fitnessMachineControlPointResponseDataParsingFitnessMachineControlPointResponse.getResultCodeType() == FitnessMachineControlPointResultCode.Type.SUCCESS) {
                                synchronized (FtmsDeviceManager.this) {
                                    FtmsDeviceManager.this.isSupportProgram = true;
                                }
                            }
                            if (fitnessMachineControlPointResponseDataParsingFitnessMachineControlPointResponse.getOpCodeType() == FitnessMachineControlPointOpCode.Type.CURRENT_PROGRAM && fitnessMachineControlPointResponseDataParsingFitnessMachineControlPointResponse.getResultCodeType() == FitnessMachineControlPointResultCode.Type.SUCCESS) {
                                synchronized (FtmsDeviceManager.this) {
                                    FtmsDeviceManager.this.nowFitnessMachineStatusType = fitnessMachineControlPointResponseDataParsingFitnessMachineControlPointResponse.getFitnessMachineStatusType();
                                }
                            }
                            FtmsDeviceManager.this.broadcastUpdateFitnessMachineControlPointExtraData(fitnessMachineControlPointResponseDataParsingFitnessMachineControlPointResponse);
                        }
                    });
                }
            }
        };
        setConnectionObserver(connectionObserver);
    }

    public FtmsDeviceManager(Context context, Handler handler) {
        super(context, handler);
        this.TAG = "FtmsDeviceManager";
        this.bluetoothDeviceName = null;
        this.bleManagerGattCallback = null;
        this.disconnectedReason = -1;
        this.dataReceivedCallbackHandlerThread = null;
        this.dataReceivedCallbackHandler = null;
        this.bleFtmsMachineType = null;
        this.fitnessMachineControlPoint = null;
        this.isMachineControl = false;
        this.isSupportProgram = false;
        this.fitnessMachineFeature = null;
        this.trainingStatus = null;
        this.fitnessMachineStatus = null;
        this.treadmillDataCharacteristic = null;
        this.indoorBikeDataCharacteristic = null;
        this.crossTrainerDataCharacteristic = null;
        this.stepClimberDataCharacteristic = null;
        this.rowerDataCharacteristic = null;
        this.ftmsBaseDataOld = null;
        this.isHasAdv0x16 = false;
        this.simpleFftmsManager = new SimpleFftmsManager();
        this.userWeightKg = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.isRaceFinish = false;
        ConnectionObserver connectionObserver = new ConnectionObserver() { // from class: com.soletreadmills.sole_v2.ble.manager.FtmsDeviceManager.1
            @Override // no.nordicsemi.android.ble.observer.ConnectionObserver
            public void onDeviceConnecting(BluetoothDevice device) {
                Timber.d("connectionObserver -> onDeviceConnecting", new Object[0]);
                FtmsDeviceManager.this.broadcastUpdate(BleFtmsActionType.FTMS_ACTION_GATT_CONNECTING, device.getAddress());
            }

            @Override // no.nordicsemi.android.ble.observer.ConnectionObserver
            public void onDeviceConnected(BluetoothDevice device) {
                Timber.d("connectionObserver -> onDeviceConnected", new Object[0]);
                FtmsDeviceManager.this.startDataReceivedCallbackHandlerThread();
                FtmsDeviceManager.this.isMachineControl = false;
                FtmsDeviceManager.this.isSupportProgram = false;
                BleDataManager.getInstance().setFitnessMachineFeatureList(null);
                BleDataManager.getInstance().setNowTrainingStatusType(null);
                BleDataManager.getInstance().setOldTrainingStatusType(null);
                FtmsDeviceManager.this.disconnectedReason = -1;
                FtmsDeviceManager.this.broadcastUpdate(BleFtmsActionType.FTMS_ACTION_GATT_CONNECTED, device.getAddress());
                FtmsDeviceManager.this.simpleFftmsManager.onDeviceConnected(device, FtmsDeviceManager.this.getBluetoothDeviceName(), FtmsDeviceManager.this.getUserWeightKg(), FtmsDeviceManager.this.isFemale());
            }

            @Override // no.nordicsemi.android.ble.observer.ConnectionObserver
            public void onDeviceFailedToConnect(BluetoothDevice device, int reason) {
                Timber.d("connectionObserver -> onDeviceFailedToConnect", new Object[0]);
                FtmsDeviceManager.this.onDeviceDisconnected(device);
            }

            @Override // no.nordicsemi.android.ble.observer.ConnectionObserver
            public void onDeviceReady(BluetoothDevice device) {
                Timber.d("connectionObserver -> onDeviceReady", new Object[0]);
            }

            @Override // no.nordicsemi.android.ble.observer.ConnectionObserver
            public void onDeviceDisconnecting(BluetoothDevice device) {
                Timber.d("connectionObserver -> onDeviceDisconnecting", new Object[0]);
            }

            @Override // no.nordicsemi.android.ble.observer.ConnectionObserver
            public void onDeviceDisconnected(BluetoothDevice device, int reason) {
                synchronized (FtmsDeviceManager.this) {
                    FtmsDeviceManager.this.disconnectedReason = reason;
                    Timber.d("connectionObserver -> onDeviceDisconnected disconnectedReason=" + FtmsDeviceManager.this.disconnectedReason, new Object[0]);
                    FtmsDeviceManager.this.onDeviceDisconnected(device);
                }
            }
        };
        this.connectionObserver = connectionObserver;
        this.fitnessMachineFeatureReceivedCallback = new DataReceivedCallback() { // from class: com.soletreadmills.sole_v2.ble.manager.FtmsDeviceManager.3
            @Override // no.nordicsemi.android.ble.callback.DataReceivedCallback
            public void onDataReceived(BluetoothDevice device, final Data data) {
                if (FtmsDeviceManager.this.dataReceivedCallbackHandler != null) {
                    FtmsDeviceManager.this.dataReceivedCallbackHandler.post(new Runnable() { // from class: com.soletreadmills.sole_v2.ble.manager.FtmsDeviceManager.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BleDataManager.getInstance().setFitnessMachineFeatureList(FtmsParsing.parsingFitnessMachineFeature(data));
                        }
                    });
                }
            }
        };
        this.trainingStatusReceivedCallback = new DataReceivedCallback() { // from class: com.soletreadmills.sole_v2.ble.manager.FtmsDeviceManager.4
            @Override // no.nordicsemi.android.ble.callback.DataReceivedCallback
            public void onDataReceived(BluetoothDevice device, Data data) {
                BleDataManager.getInstance().setOldTrainingStatusType(BleDataManager.getInstance().getNowTrainingStatusType());
                BleDataManager.getInstance().setNowTrainingStatusType(FtmsParsing.parsingTrainingStatus(data));
                FtmsDeviceManager.this.broadcastUpdate(BleFtmsActionType.FTMS_ACTION_TRAINING_STATUS_DATA_AVAILABLE);
            }
        };
        this.fitnessMachineStatusReceivedCallback = new DataReceivedCallback() { // from class: com.soletreadmills.sole_v2.ble.manager.FtmsDeviceManager.5
            @Override // no.nordicsemi.android.ble.callback.DataReceivedCallback
            public void onDataReceived(BluetoothDevice device, Data data) {
                BleDataManager.getInstance().setNowFitnessMachineStatusType(FtmsParsing.parsingFitnessMachineStatus(data));
                BleDataManager.getInstance().setNowFMSTypeOnlyFourType(FtmsParsing.parsingFitnessMachineStatus(data));
                FtmsDeviceManager.this.broadcastUpdate(BleFtmsActionType.FTMS_ACTION_FITNESS_MACHINE_STATUS_DATA_AVAILABLE);
            }
        };
        this.treadmillDataMultiple = null;
        this.treadmillDataReceivedCallback = new DataReceivedCallback() { // from class: com.soletreadmills.sole_v2.ble.manager.FtmsDeviceManager.6
            @Override // no.nordicsemi.android.ble.callback.DataReceivedCallback
            public void onDataReceived(final BluetoothDevice device, final Data data) {
                if (FtmsDeviceManager.this.dataReceivedCallbackHandler != null) {
                    FtmsDeviceManager.this.dataReceivedCallbackHandler.post(new Runnable() { // from class: com.soletreadmills.sole_v2.ble.manager.FtmsDeviceManager.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            FtmsBaseData ftmsBaseDataProcessData;
                            if (data.getValue() == null || data.getValue().length <= 0 || FtmsDeviceManager.this.isRaceFinish) {
                                return;
                            }
                            try {
                                ftmsBaseDataProcessData = FtmsParsing.parsingFtmsData(device, FtmsDeviceManager.this, FtmsDeviceManager.this.treadmillDataCharacteristic, data);
                            } catch (Exception e) {
                                Timber.e(e);
                                ftmsBaseDataProcessData = null;
                            }
                            boolean zIsSimpleTreadmillData = CheckSimpleFtmsDataTool.isSimpleTreadmillData(ftmsBaseDataProcessData, data);
                            Timber.d("Treadmill isSimpleFTMS=%s", Boolean.valueOf(zIsSimpleTreadmillData));
                            if (zIsSimpleTreadmillData) {
                                FtmsDeviceManager.this.simpleFftmsManager.checkStartTimer();
                                ftmsBaseDataProcessData = FtmsDeviceManager.this.simpleFftmsManager.processData(ftmsBaseDataProcessData);
                            } else if (ftmsBaseDataProcessData instanceof TreadmillData) {
                                TreadmillData treadmillData = (TreadmillData) ftmsBaseDataProcessData;
                                if (treadmillData.getElapsedTime() == null) {
                                    FtmsDeviceManager.this.treadmillDataMultiple = treadmillData;
                                    return;
                                }
                                if (treadmillData.getElapsedTime() != null && FtmsDeviceManager.this.treadmillDataMultiple != null) {
                                    if (treadmillData.getInstantaneousSpeed() == null) {
                                        treadmillData.setInstantaneousSpeed(FtmsDeviceManager.this.treadmillDataMultiple.getInstantaneousSpeed());
                                    }
                                    if (treadmillData.getAverageSpeed() == null) {
                                        treadmillData.setAverageSpeed(FtmsDeviceManager.this.treadmillDataMultiple.getAverageSpeed());
                                    }
                                    if (treadmillData.getTotalDistance() == null) {
                                        treadmillData.setTotalDistance(FtmsDeviceManager.this.treadmillDataMultiple.getTotalDistance());
                                    }
                                    if (treadmillData.getInclination() == null) {
                                        treadmillData.setInclination(FtmsDeviceManager.this.treadmillDataMultiple.getInclination());
                                    }
                                    if (treadmillData.getRampAngleSetting() == null) {
                                        treadmillData.setRampAngleSetting(FtmsDeviceManager.this.treadmillDataMultiple.getRampAngleSetting());
                                    }
                                    if (treadmillData.getPositiveElevationGain() == null) {
                                        treadmillData.setPositiveElevationGain(FtmsDeviceManager.this.treadmillDataMultiple.getPositiveElevationGain());
                                    }
                                    if (treadmillData.getNegativeElevationGain() == null) {
                                        treadmillData.setNegativeElevationGain(FtmsDeviceManager.this.treadmillDataMultiple.getNegativeElevationGain());
                                    }
                                    if (treadmillData.getInstantaneousPace() == null) {
                                        treadmillData.setInstantaneousPace(FtmsDeviceManager.this.treadmillDataMultiple.getInstantaneousPace());
                                    }
                                    if (treadmillData.getAveragePace() == null) {
                                        treadmillData.setAveragePace(FtmsDeviceManager.this.treadmillDataMultiple.getAveragePace());
                                    }
                                    if (treadmillData.getTotalEnergy() == null) {
                                        treadmillData.setTotalEnergy(FtmsDeviceManager.this.treadmillDataMultiple.getTotalEnergy());
                                    }
                                    if (treadmillData.getEnergyPerHour() == null) {
                                        treadmillData.setEnergyPerHour(FtmsDeviceManager.this.treadmillDataMultiple.getEnergyPerHour());
                                    }
                                    if (treadmillData.getEnergyPerMinute() == null) {
                                        treadmillData.setEnergyPerMinute(FtmsDeviceManager.this.treadmillDataMultiple.getEnergyPerMinute());
                                    }
                                    if (treadmillData.getHeartRate() == null) {
                                        treadmillData.setHeartRate(FtmsDeviceManager.this.treadmillDataMultiple.getHeartRate());
                                    }
                                    if (treadmillData.getMetabolicEquivalent() == null) {
                                        treadmillData.setMetabolicEquivalent(FtmsDeviceManager.this.treadmillDataMultiple.getMetabolicEquivalent());
                                    }
                                    if (treadmillData.getElapsedTime() == null) {
                                        treadmillData.setElapsedTime(FtmsDeviceManager.this.treadmillDataMultiple.getElapsedTime());
                                    }
                                    if (treadmillData.getRemainingTime() == null) {
                                        treadmillData.setRemainingTime(FtmsDeviceManager.this.treadmillDataMultiple.getRemainingTime());
                                    }
                                    if (treadmillData.getForceOnBelt() == null) {
                                        treadmillData.setForceOnBelt(FtmsDeviceManager.this.treadmillDataMultiple.getForceOnBelt());
                                    }
                                    if (treadmillData.getPowerOutput() == null) {
                                        treadmillData.setPowerOutput(FtmsDeviceManager.this.treadmillDataMultiple.getPowerOutput());
                                    }
                                }
                            }
                            if (ftmsBaseDataProcessData != null) {
                                BleDataManager.getInstance().virtualRaceFix(ftmsBaseDataProcessData);
                                BleDataManager.getInstance().addFtmsData(ftmsBaseDataProcessData);
                                if (BleDataManager.nowWearHrData != null && BleDataManager.nowWearHrData.checkTimeInRangeAndGetValue() >= 0) {
                                    ftmsBaseDataProcessData.setHeartRate(Integer.valueOf(BleDataManager.nowWearHrData.checkTimeInRangeAndGetValue()));
                                }
                                if (FtmsDeviceManager.this.nowFitnessMachineStatusType != null) {
                                    ftmsBaseDataProcessData.setFitnessMachineStatusType(FtmsDeviceManager.this.nowFitnessMachineStatusType);
                                }
                                String json = new Gson().toJson(ftmsBaseDataProcessData);
                                if (ftmsBaseDataProcessData instanceof TreadmillData) {
                                    FtmsDeviceManager.this.broadcastUpdateExtraDataFtms(json, TreadmillData.class.getName());
                                }
                                FtmsDeviceManager.this.setFtmsBaseDataOld(ftmsBaseDataProcessData);
                            }
                        }
                    });
                }
            }
        };
        this.indoorBikeDataMultiple = null;
        this.indoorBikeDataReceivedCallback = new DataReceivedCallback() { // from class: com.soletreadmills.sole_v2.ble.manager.FtmsDeviceManager.7
            @Override // no.nordicsemi.android.ble.callback.DataReceivedCallback
            public void onDataReceived(final BluetoothDevice device, final Data data) {
                if (FtmsDeviceManager.this.dataReceivedCallbackHandler != null) {
                    FtmsDeviceManager.this.dataReceivedCallbackHandler.post(new Runnable() { // from class: com.soletreadmills.sole_v2.ble.manager.FtmsDeviceManager.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            FtmsBaseData ftmsBaseDataProcessData;
                            if (data.getValue() == null || data.getValue().length <= 0) {
                                return;
                            }
                            try {
                                ftmsBaseDataProcessData = FtmsParsing.parsingFtmsData(device, FtmsDeviceManager.this, FtmsDeviceManager.this.indoorBikeDataCharacteristic, data);
                            } catch (Exception e) {
                                Timber.e(e);
                                ftmsBaseDataProcessData = null;
                            }
                            boolean z = true;
                            if (!CheckSimpleFtmsDataTool.isSimpleBikeEjekData(ftmsBaseDataProcessData, data) && (CheckSimpleFtmsDataTool.isSimpleBikeCorestarData(ftmsBaseDataProcessData, data) || (!CheckSimpleFtmsDataTool.isSimpleBikeDirectionData(ftmsBaseDataProcessData, data) && !CheckSimpleFtmsDataTool.isSimpleEllipticalEjekData(ftmsBaseDataProcessData, data)))) {
                                z = false;
                            }
                            Timber.d("IndoorBike isSimpleFTMS=%s", Boolean.valueOf(z));
                            if (z) {
                                FtmsDeviceManager.this.simpleFftmsManager.checkStartTimer();
                                ftmsBaseDataProcessData = FtmsDeviceManager.this.simpleFftmsManager.processData(ftmsBaseDataProcessData);
                            } else if (ftmsBaseDataProcessData instanceof IndoorBikeData) {
                                IndoorBikeData indoorBikeData = (IndoorBikeData) ftmsBaseDataProcessData;
                                if (indoorBikeData.getElapsedTime() == null) {
                                    FtmsDeviceManager.this.indoorBikeDataMultiple = indoorBikeData;
                                    return;
                                }
                                if (ftmsBaseDataProcessData.getElapsedTime() != null && FtmsDeviceManager.this.indoorBikeDataMultiple != null) {
                                    if (indoorBikeData.getInstantaneousSpeed() == null) {
                                        indoorBikeData.setInstantaneousSpeed(FtmsDeviceManager.this.indoorBikeDataMultiple.getInstantaneousSpeed());
                                    }
                                    if (indoorBikeData.getAverageSpeed() == null) {
                                        indoorBikeData.setAverageSpeed(FtmsDeviceManager.this.indoorBikeDataMultiple.getAverageSpeed());
                                    }
                                    if (indoorBikeData.getInstantaneousCadence() == null) {
                                        indoorBikeData.setInstantaneousCadence(FtmsDeviceManager.this.indoorBikeDataMultiple.getInstantaneousCadence());
                                    }
                                    if (indoorBikeData.getAverageCadence() == null) {
                                        indoorBikeData.setAverageCadence(FtmsDeviceManager.this.indoorBikeDataMultiple.getAverageCadence());
                                    }
                                    if (indoorBikeData.getTotalDistance() == null) {
                                        indoorBikeData.setTotalDistance(FtmsDeviceManager.this.indoorBikeDataMultiple.getTotalDistance());
                                    }
                                    if (indoorBikeData.getResistanceLevel() == null) {
                                        indoorBikeData.setResistanceLevel(FtmsDeviceManager.this.indoorBikeDataMultiple.getResistanceLevel());
                                    }
                                    if (indoorBikeData.getInstantaneousPower() == null) {
                                        indoorBikeData.setInstantaneousPower(FtmsDeviceManager.this.indoorBikeDataMultiple.getInstantaneousPower());
                                    }
                                    if (indoorBikeData.getAveragePower() == null) {
                                        indoorBikeData.setAveragePower(FtmsDeviceManager.this.indoorBikeDataMultiple.getAveragePower());
                                    }
                                    if (indoorBikeData.getTotalEnergy() == null) {
                                        indoorBikeData.setTotalEnergy(FtmsDeviceManager.this.indoorBikeDataMultiple.getTotalEnergy());
                                    }
                                    if (indoorBikeData.getEnergyPerHour() == null) {
                                        indoorBikeData.setEnergyPerHour(FtmsDeviceManager.this.indoorBikeDataMultiple.getEnergyPerHour());
                                    }
                                    if (indoorBikeData.getEnergyPerMinute() == null) {
                                        indoorBikeData.setEnergyPerMinute(FtmsDeviceManager.this.indoorBikeDataMultiple.getEnergyPerMinute());
                                    }
                                    if (indoorBikeData.getHeartRate() == null) {
                                        indoorBikeData.setHeartRate(FtmsDeviceManager.this.indoorBikeDataMultiple.getHeartRate());
                                    }
                                    if (indoorBikeData.getMetabolicEquivalent() == null) {
                                        indoorBikeData.setMetabolicEquivalent(FtmsDeviceManager.this.indoorBikeDataMultiple.getMetabolicEquivalent());
                                    }
                                    if (indoorBikeData.getElapsedTime() == null) {
                                        indoorBikeData.setElapsedTime(FtmsDeviceManager.this.indoorBikeDataMultiple.getElapsedTime());
                                    }
                                    if (indoorBikeData.getRemainingTime() == null) {
                                        indoorBikeData.setRemainingTime(FtmsDeviceManager.this.indoorBikeDataMultiple.getRemainingTime());
                                    }
                                    if (indoorBikeData.getInclination() == null) {
                                        indoorBikeData.setInclination(FtmsDeviceManager.this.indoorBikeDataMultiple.getInclination());
                                    }
                                }
                            }
                            if (ftmsBaseDataProcessData != null) {
                                BleDataManager.getInstance().virtualRaceFix(ftmsBaseDataProcessData);
                                BleDataManager.getInstance().addFtmsData(ftmsBaseDataProcessData);
                                if (BleDataManager.nowWearHrData != null && BleDataManager.nowWearHrData.checkTimeInRangeAndGetValue() >= 0) {
                                    ftmsBaseDataProcessData.setHeartRate(Integer.valueOf(BleDataManager.nowWearHrData.checkTimeInRangeAndGetValue()));
                                }
                                if (FtmsDeviceManager.this.nowFitnessMachineStatusType != null) {
                                    ftmsBaseDataProcessData.setFitnessMachineStatusType(FtmsDeviceManager.this.nowFitnessMachineStatusType);
                                }
                                String json = new Gson().toJson(ftmsBaseDataProcessData);
                                if (ftmsBaseDataProcessData instanceof IndoorBikeData) {
                                    FtmsDeviceManager.this.broadcastUpdateExtraDataFtms(json, IndoorBikeData.class.getName());
                                } else if (ftmsBaseDataProcessData instanceof CrossTrainerData) {
                                    FtmsDeviceManager.this.broadcastUpdateExtraDataFtms(json, CrossTrainerData.class.getName());
                                }
                            }
                            FtmsDeviceManager.this.setFtmsBaseDataOld(ftmsBaseDataProcessData);
                        }
                    });
                }
            }
        };
        this.crossTrainerDataMultiple = null;
        this.crossTrainerDataReceivedCallback = new DataReceivedCallback() { // from class: com.soletreadmills.sole_v2.ble.manager.FtmsDeviceManager.8
            @Override // no.nordicsemi.android.ble.callback.DataReceivedCallback
            public void onDataReceived(final BluetoothDevice device, final Data data) {
                if (FtmsDeviceManager.this.dataReceivedCallbackHandler != null) {
                    FtmsDeviceManager.this.dataReceivedCallbackHandler.post(new Runnable() { // from class: com.soletreadmills.sole_v2.ble.manager.FtmsDeviceManager.8.1
                        @Override // java.lang.Runnable
                        public void run() {
                            FtmsBaseData ftmsBaseDataProcessData;
                            boolean z;
                            if (data.getValue() == null || data.getValue().length <= 0) {
                                return;
                            }
                            try {
                                ftmsBaseDataProcessData = FtmsParsing.parsingFtmsData(device, FtmsDeviceManager.this, FtmsDeviceManager.this.crossTrainerDataCharacteristic, data);
                            } catch (Exception e) {
                                Timber.e(e);
                                ftmsBaseDataProcessData = null;
                            }
                            if (CheckSimpleFtmsDataTool.isSimpleEllipticalEjekData(ftmsBaseDataProcessData, data)) {
                                z = true;
                            } else {
                                CheckSimpleFtmsDataTool.isSimpleEllipticalCorestarData(ftmsBaseDataProcessData, data);
                                z = false;
                            }
                            Timber.d("crossTrainer isSimpleFTMS=%s", Boolean.valueOf(z));
                            if (!z && FtmsDeviceManager.this.indoorBikeDataCharacteristic != null) {
                                FtmsDeviceManager.this.removeNotificationCallback(FtmsDeviceManager.this.indoorBikeDataCharacteristic);
                                FtmsDeviceManager.this.disableNotifications(FtmsDeviceManager.this.indoorBikeDataCharacteristic).enqueue();
                                FtmsDeviceManager.this.indoorBikeDataCharacteristic = null;
                            }
                            if (z) {
                                FtmsDeviceManager.this.simpleFftmsManager.checkStartTimer();
                                ftmsBaseDataProcessData = FtmsDeviceManager.this.simpleFftmsManager.processData(ftmsBaseDataProcessData);
                            } else if (ftmsBaseDataProcessData instanceof CrossTrainerData) {
                                CrossTrainerData crossTrainerData = (CrossTrainerData) ftmsBaseDataProcessData;
                                if (crossTrainerData.getElapsedTime() == null) {
                                    FtmsDeviceManager.this.crossTrainerDataMultiple = crossTrainerData;
                                    return;
                                }
                                if (crossTrainerData.getElapsedTime() != null && FtmsDeviceManager.this.crossTrainerDataMultiple != null) {
                                    if (crossTrainerData.getInstantaneousSpeed() == null) {
                                        crossTrainerData.setInstantaneousSpeed(FtmsDeviceManager.this.crossTrainerDataMultiple.getInstantaneousSpeed());
                                    }
                                    if (crossTrainerData.getAverageSpeed() == null) {
                                        crossTrainerData.setAverageSpeed(FtmsDeviceManager.this.crossTrainerDataMultiple.getAverageSpeed());
                                    }
                                    if (crossTrainerData.getTotalDistance() == null) {
                                        crossTrainerData.setTotalDistance(FtmsDeviceManager.this.crossTrainerDataMultiple.getTotalDistance());
                                    }
                                    if (crossTrainerData.getStepPerMinute() == null) {
                                        crossTrainerData.setStepPerMinute(FtmsDeviceManager.this.crossTrainerDataMultiple.getStepPerMinute());
                                    }
                                    if (crossTrainerData.getAverageStepRate() == null) {
                                        crossTrainerData.setAverageStepRate(FtmsDeviceManager.this.crossTrainerDataMultiple.getAverageStepRate());
                                    }
                                    if (crossTrainerData.getStrideCount() == null) {
                                        crossTrainerData.setStrideCount(FtmsDeviceManager.this.crossTrainerDataMultiple.getStrideCount());
                                    }
                                    if (crossTrainerData.getPositiveElevationGain() == null) {
                                        crossTrainerData.setPositiveElevationGain(FtmsDeviceManager.this.crossTrainerDataMultiple.getPositiveElevationGain());
                                    }
                                    if (crossTrainerData.getNegativeElevationGain() == null) {
                                        crossTrainerData.setNegativeElevationGain(FtmsDeviceManager.this.crossTrainerDataMultiple.getNegativeElevationGain());
                                    }
                                    if (crossTrainerData.getInclination() == null) {
                                        crossTrainerData.setInclination(FtmsDeviceManager.this.crossTrainerDataMultiple.getInclination());
                                    }
                                    if (crossTrainerData.getRampAngleSetting() == null) {
                                        crossTrainerData.setRampAngleSetting(FtmsDeviceManager.this.crossTrainerDataMultiple.getRampAngleSetting());
                                    }
                                    if (crossTrainerData.getResistanceLevel() == null) {
                                        crossTrainerData.setResistanceLevel(FtmsDeviceManager.this.crossTrainerDataMultiple.getResistanceLevel());
                                    }
                                    if (crossTrainerData.getInstantaneousPower() == null) {
                                        crossTrainerData.setInstantaneousPower(FtmsDeviceManager.this.crossTrainerDataMultiple.getInstantaneousPower());
                                    }
                                    if (crossTrainerData.getAveragePower() == null) {
                                        crossTrainerData.setAveragePower(FtmsDeviceManager.this.crossTrainerDataMultiple.getAveragePower());
                                    }
                                    if (crossTrainerData.getTotalEnergy() == null) {
                                        crossTrainerData.setTotalEnergy(FtmsDeviceManager.this.crossTrainerDataMultiple.getTotalEnergy());
                                    }
                                    if (crossTrainerData.getEnergyPerHour() == null) {
                                        crossTrainerData.setEnergyPerHour(FtmsDeviceManager.this.crossTrainerDataMultiple.getEnergyPerHour());
                                    }
                                    if (crossTrainerData.getEnergyPerMinute() == null) {
                                        crossTrainerData.setEnergyPerMinute(FtmsDeviceManager.this.crossTrainerDataMultiple.getEnergyPerMinute());
                                    }
                                    if (crossTrainerData.getHeartRate() == null) {
                                        crossTrainerData.setHeartRate(FtmsDeviceManager.this.crossTrainerDataMultiple.getHeartRate());
                                    }
                                    if (crossTrainerData.getMetabolicEquivalent() == null) {
                                        crossTrainerData.setMetabolicEquivalent(FtmsDeviceManager.this.crossTrainerDataMultiple.getMetabolicEquivalent());
                                    }
                                    if (crossTrainerData.getElapsedTime() == null) {
                                        crossTrainerData.setElapsedTime(FtmsDeviceManager.this.crossTrainerDataMultiple.getElapsedTime());
                                    }
                                    if (crossTrainerData.getRemainingTime() == null) {
                                        crossTrainerData.setRemainingTime(FtmsDeviceManager.this.crossTrainerDataMultiple.getRemainingTime());
                                    }
                                    if (crossTrainerData.getMovementDirection() == null) {
                                        crossTrainerData.setMovementDirection(FtmsDeviceManager.this.crossTrainerDataMultiple.getMovementDirection());
                                    }
                                }
                                if (CheckSimpleFtmsDataTool.isSimpleEllipticalCorestarData(crossTrainerData, data) && !FtmsDeviceManager.this.isHasAdv0x16()) {
                                    if (crossTrainerData.getBleName().toUpperCase().contains(SimpleFtmsDeviceName.ELLIPTICAL_SPIRIT_CORESTAR_XE395) ? false : crossTrainerData.getInclination() != null) {
                                        crossTrainerData.setInclination(Double.valueOf(crossTrainerData.getInclination().doubleValue() * 10.0d));
                                    }
                                }
                            }
                            if (ftmsBaseDataProcessData != null) {
                                BleDataManager.getInstance().virtualRaceFix(ftmsBaseDataProcessData);
                                BleDataManager.getInstance().addFtmsData(ftmsBaseDataProcessData);
                                if (BleDataManager.nowWearHrData != null && BleDataManager.nowWearHrData.checkTimeInRangeAndGetValue() >= 0) {
                                    ftmsBaseDataProcessData.setHeartRate(Integer.valueOf(BleDataManager.nowWearHrData.checkTimeInRangeAndGetValue()));
                                }
                                if (FtmsDeviceManager.this.nowFitnessMachineStatusType != null) {
                                    ftmsBaseDataProcessData.setFitnessMachineStatusType(FtmsDeviceManager.this.nowFitnessMachineStatusType);
                                }
                                FtmsDeviceManager.this.broadcastUpdateExtraDataFtms(new Gson().toJson(ftmsBaseDataProcessData), CrossTrainerData.class.getName());
                            }
                            FtmsDeviceManager.this.setFtmsBaseDataOld(ftmsBaseDataProcessData);
                        }
                    });
                }
            }
        };
        this.stepClimberDataMultiple = null;
        this.stepClimberDataReceivedCallback = new DataReceivedCallback() { // from class: com.soletreadmills.sole_v2.ble.manager.FtmsDeviceManager.9
            @Override // no.nordicsemi.android.ble.callback.DataReceivedCallback
            public void onDataReceived(final BluetoothDevice device, final Data data) {
                if (FtmsDeviceManager.this.dataReceivedCallbackHandler != null) {
                    FtmsDeviceManager.this.dataReceivedCallbackHandler.post(new Runnable() { // from class: com.soletreadmills.sole_v2.ble.manager.FtmsDeviceManager.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            StepClimberData stepClimberData;
                            if (data.getValue() == null || data.getValue().length <= 0) {
                                return;
                            }
                            try {
                                stepClimberData = (StepClimberData) FtmsParsing.parsingFtmsData(device, FtmsDeviceManager.this, FtmsDeviceManager.this.stepClimberDataCharacteristic, data);
                            } catch (Exception e) {
                                Timber.e(e);
                                stepClimberData = null;
                            }
                            Timber.d("stepClimber isSimpleFTMS=%s", false);
                            if (stepClimberData != null && stepClimberData.getElapsedTime() == null) {
                                FtmsDeviceManager.this.stepClimberDataMultiple = stepClimberData;
                                return;
                            }
                            if (stepClimberData != null && stepClimberData.getElapsedTime() != null && FtmsDeviceManager.this.stepClimberDataMultiple != null) {
                                if (stepClimberData.getFloors() == null) {
                                    stepClimberData.setFloors(FtmsDeviceManager.this.stepClimberDataMultiple.getFloors());
                                }
                                if (stepClimberData.getStepCount() == null) {
                                    stepClimberData.setStepCount(FtmsDeviceManager.this.stepClimberDataMultiple.getStepCount());
                                }
                                if (stepClimberData.getStepPerMinute() == null) {
                                    stepClimberData.setStepPerMinute(FtmsDeviceManager.this.stepClimberDataMultiple.getStepPerMinute());
                                }
                                if (stepClimberData.getAverageStepRate() == null) {
                                    stepClimberData.setAverageStepRate(FtmsDeviceManager.this.stepClimberDataMultiple.getAverageStepRate());
                                }
                                if (stepClimberData.getPositiveElevationGain() == null) {
                                    stepClimberData.setPositiveElevationGain(FtmsDeviceManager.this.stepClimberDataMultiple.getPositiveElevationGain());
                                }
                                if (stepClimberData.getResistanceLevel() == null) {
                                    stepClimberData.setResistanceLevel(FtmsDeviceManager.this.stepClimberDataMultiple.getResistanceLevel());
                                }
                                if (stepClimberData.getTotalEnergy() == null) {
                                    stepClimberData.setTotalEnergy(FtmsDeviceManager.this.stepClimberDataMultiple.getTotalEnergy());
                                }
                                if (stepClimberData.getEnergyPerHour() == null) {
                                    stepClimberData.setEnergyPerHour(FtmsDeviceManager.this.stepClimberDataMultiple.getEnergyPerHour());
                                }
                                if (stepClimberData.getEnergyPerMinute() == null) {
                                    stepClimberData.setEnergyPerMinute(FtmsDeviceManager.this.stepClimberDataMultiple.getEnergyPerMinute());
                                }
                                if (stepClimberData.getHeartRate() == null) {
                                    stepClimberData.setHeartRate(FtmsDeviceManager.this.stepClimberDataMultiple.getHeartRate());
                                }
                                if (stepClimberData.getMetabolicEquivalent() == null) {
                                    stepClimberData.setMetabolicEquivalent(FtmsDeviceManager.this.stepClimberDataMultiple.getMetabolicEquivalent());
                                }
                                if (stepClimberData.getElapsedTime() == null) {
                                    stepClimberData.setElapsedTime(FtmsDeviceManager.this.stepClimberDataMultiple.getElapsedTime());
                                }
                                if (stepClimberData.getRemainingTime() == null) {
                                    stepClimberData.setRemainingTime(FtmsDeviceManager.this.stepClimberDataMultiple.getRemainingTime());
                                }
                            }
                            if (stepClimberData != null) {
                                BleDataManager.getInstance().virtualRaceFix(stepClimberData);
                                BleDataManager.getInstance().addFtmsData(stepClimberData);
                                if (BleDataManager.nowWearHrData != null && BleDataManager.nowWearHrData.checkTimeInRangeAndGetValue() >= 0) {
                                    stepClimberData.setHeartRate(Integer.valueOf(BleDataManager.nowWearHrData.checkTimeInRangeAndGetValue()));
                                }
                                if (FtmsDeviceManager.this.nowFitnessMachineStatusType != null) {
                                    stepClimberData.setFitnessMachineStatusType(FtmsDeviceManager.this.nowFitnessMachineStatusType);
                                }
                                FtmsDeviceManager.this.broadcastUpdateExtraDataFtms(new Gson().toJson(stepClimberData), StepClimberData.class.getName());
                            }
                            FtmsDeviceManager.this.setFtmsBaseDataOld(stepClimberData);
                        }
                    });
                }
            }
        };
        this.rowerDataMultiple = null;
        this.rowerDataReceivedCallback = new DataReceivedCallback() { // from class: com.soletreadmills.sole_v2.ble.manager.FtmsDeviceManager.10
            @Override // no.nordicsemi.android.ble.callback.DataReceivedCallback
            public void onDataReceived(final BluetoothDevice device, final Data data) {
                if (FtmsDeviceManager.this.dataReceivedCallbackHandler != null) {
                    FtmsDeviceManager.this.dataReceivedCallbackHandler.post(new Runnable() { // from class: com.soletreadmills.sole_v2.ble.manager.FtmsDeviceManager.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            RowerData rowerData;
                            if (data.getValue() == null || data.getValue().length <= 0) {
                                return;
                            }
                            try {
                                rowerData = (RowerData) FtmsParsing.parsingFtmsData(device, FtmsDeviceManager.this, FtmsDeviceManager.this.rowerDataCharacteristic, data);
                            } catch (Exception e) {
                                Timber.e(e);
                                rowerData = null;
                            }
                            Timber.d("stepClimber isSimpleFTMS=%s", false);
                            if (rowerData != null && rowerData.getElapsedTime() == null) {
                                FtmsDeviceManager.this.rowerDataMultiple = rowerData;
                                return;
                            }
                            if (rowerData != null && rowerData.getElapsedTime() != null && FtmsDeviceManager.this.rowerDataMultiple != null) {
                                if (rowerData.getStrokeRate() == null) {
                                    rowerData.setStrokeRate(FtmsDeviceManager.this.rowerDataMultiple.getStrokeRate());
                                }
                                if (rowerData.getStrokeCount() == null) {
                                    rowerData.setStrokeCount(FtmsDeviceManager.this.rowerDataMultiple.getStrokeCount());
                                }
                                if (rowerData.getAverageStrokeRate() == null) {
                                    rowerData.setAverageStrokeRate(FtmsDeviceManager.this.rowerDataMultiple.getAverageStrokeRate());
                                }
                                if (rowerData.getTotalDistance() == null) {
                                    rowerData.setTotalDistance(FtmsDeviceManager.this.rowerDataMultiple.getTotalDistance());
                                }
                                if (rowerData.getInstantaneousPace() == null) {
                                    rowerData.setInstantaneousPace(FtmsDeviceManager.this.rowerDataMultiple.getInstantaneousPace());
                                }
                                if (rowerData.getAveragePace() == null) {
                                    rowerData.setAveragePace(FtmsDeviceManager.this.rowerDataMultiple.getAveragePace());
                                }
                                if (rowerData.getInstantaneousPower() == null) {
                                    rowerData.setInstantaneousPower(FtmsDeviceManager.this.rowerDataMultiple.getInstantaneousPower());
                                }
                                if (rowerData.getAveragePower() == null) {
                                    rowerData.setAveragePower(FtmsDeviceManager.this.rowerDataMultiple.getAveragePower());
                                }
                                if (rowerData.getResistanceLevel() == null) {
                                    rowerData.setResistanceLevel(FtmsDeviceManager.this.rowerDataMultiple.getResistanceLevel());
                                }
                                if (rowerData.getTotalEnergy() == null) {
                                    rowerData.setTotalEnergy(FtmsDeviceManager.this.rowerDataMultiple.getTotalEnergy());
                                }
                                if (rowerData.getEnergyPerHour() == null) {
                                    rowerData.setEnergyPerHour(FtmsDeviceManager.this.rowerDataMultiple.getEnergyPerHour());
                                }
                                if (rowerData.getEnergyPerMinute() == null) {
                                    rowerData.setEnergyPerMinute(FtmsDeviceManager.this.rowerDataMultiple.getEnergyPerMinute());
                                }
                                if (rowerData.getHeartRate() == null) {
                                    rowerData.setHeartRate(FtmsDeviceManager.this.rowerDataMultiple.getHeartRate());
                                }
                                if (rowerData.getMetabolicEquivalent() == null) {
                                    rowerData.setMetabolicEquivalent(FtmsDeviceManager.this.rowerDataMultiple.getMetabolicEquivalent());
                                }
                                if (rowerData.getElapsedTime() == null) {
                                    rowerData.setElapsedTime(FtmsDeviceManager.this.rowerDataMultiple.getElapsedTime());
                                }
                                if (rowerData.getRemainingTime() == null) {
                                    rowerData.setRemainingTime(FtmsDeviceManager.this.rowerDataMultiple.getRemainingTime());
                                }
                            }
                            if (rowerData != null) {
                                BleDataManager.getInstance().virtualRaceFix(rowerData);
                                BleDataManager.getInstance().addFtmsData(rowerData);
                                if (BleDataManager.nowWearHrData != null && BleDataManager.nowWearHrData.checkTimeInRangeAndGetValue() >= 0) {
                                    rowerData.setHeartRate(Integer.valueOf(BleDataManager.nowWearHrData.checkTimeInRangeAndGetValue()));
                                }
                                if (FtmsDeviceManager.this.nowFitnessMachineStatusType != null) {
                                    rowerData.setFitnessMachineStatusType(FtmsDeviceManager.this.nowFitnessMachineStatusType);
                                }
                                FtmsDeviceManager.this.broadcastUpdateExtraDataFtms(new Gson().toJson(rowerData), RowerData.class.getName());
                            }
                            FtmsDeviceManager.this.setFtmsBaseDataOld(rowerData);
                        }
                    });
                }
            }
        };
        this.fitnessMachineControlPointDataReceivedCallback = new DataReceivedCallback() { // from class: com.soletreadmills.sole_v2.ble.manager.FtmsDeviceManager.11
            @Override // no.nordicsemi.android.ble.callback.DataReceivedCallback
            public void onDataReceived(final BluetoothDevice device, final Data data) {
                if (FtmsDeviceManager.this.dataReceivedCallbackHandler != null) {
                    FtmsDeviceManager.this.dataReceivedCallbackHandler.post(new Runnable() { // from class: com.soletreadmills.sole_v2.ble.manager.FtmsDeviceManager.11.1
                        @Override // java.lang.Runnable
                        public void run() {
                            FitnessMachineControlPointResponseData fitnessMachineControlPointResponseDataParsingFitnessMachineControlPointResponse = FtmsParsing.parsingFitnessMachineControlPointResponse(data);
                            Timber.d("fitnessMachineControlPointDataReceivedCallback FitnessMachineControlPointResponseData=%s", fitnessMachineControlPointResponseDataParsingFitnessMachineControlPointResponse.toString());
                            if (fitnessMachineControlPointResponseDataParsingFitnessMachineControlPointResponse.getOpCodeType() == FitnessMachineControlPointOpCode.Type.REQUEST_CONTROL && fitnessMachineControlPointResponseDataParsingFitnessMachineControlPointResponse.getResultCodeType() == FitnessMachineControlPointResultCode.Type.SUCCESS) {
                                synchronized (FtmsDeviceManager.this) {
                                    FtmsDeviceManager.this.isMachineControl = true;
                                }
                            }
                            if (fitnessMachineControlPointResponseDataParsingFitnessMachineControlPointResponse.getOpCodeType() == FitnessMachineControlPointOpCode.Type.SUPPORT_PROGRAM && fitnessMachineControlPointResponseDataParsingFitnessMachineControlPointResponse.getResultCodeType() == FitnessMachineControlPointResultCode.Type.SUCCESS) {
                                synchronized (FtmsDeviceManager.this) {
                                    FtmsDeviceManager.this.isSupportProgram = true;
                                }
                            }
                            if (fitnessMachineControlPointResponseDataParsingFitnessMachineControlPointResponse.getOpCodeType() == FitnessMachineControlPointOpCode.Type.CURRENT_PROGRAM && fitnessMachineControlPointResponseDataParsingFitnessMachineControlPointResponse.getResultCodeType() == FitnessMachineControlPointResultCode.Type.SUCCESS) {
                                synchronized (FtmsDeviceManager.this) {
                                    FtmsDeviceManager.this.nowFitnessMachineStatusType = fitnessMachineControlPointResponseDataParsingFitnessMachineControlPointResponse.getFitnessMachineStatusType();
                                }
                            }
                            FtmsDeviceManager.this.broadcastUpdateFitnessMachineControlPointExtraData(fitnessMachineControlPointResponseDataParsingFitnessMachineControlPointResponse);
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
                this.bleManagerGattCallback = new BleManager.BleManagerGattCallback() { // from class: com.soletreadmills.sole_v2.ble.manager.FtmsDeviceManager.2
                    @Override // no.nordicsemi.android.ble.BleManagerHandler
                    protected void onServicesInvalidated() {
                    }

                    @Override // no.nordicsemi.android.ble.BleManagerHandler
                    protected void initialize() {
                        synchronized (FtmsDeviceManager.this) {
                            if (FtmsDeviceManager.this.fitnessMachineControlPoint != null) {
                                FtmsDeviceManager ftmsDeviceManager = FtmsDeviceManager.this;
                                ftmsDeviceManager.setIndicationCallback(ftmsDeviceManager.fitnessMachineControlPoint).with(FtmsDeviceManager.this.fitnessMachineControlPointDataReceivedCallback);
                                FtmsDeviceManager ftmsDeviceManager2 = FtmsDeviceManager.this;
                                ftmsDeviceManager2.enableIndications(ftmsDeviceManager2.fitnessMachineControlPoint).enqueue();
                                FtmsDeviceManager.this.sendCmd(FitnessMachineControlPointCmd.requestControl(), null, null, null, null);
                                FtmsDeviceManager.this.sendCmd(FitnessMachineControlPointCmd.getSupportProgram(), null, null, null, null);
                            }
                            if (FtmsDeviceManager.this.fitnessMachineFeature != null) {
                                FtmsDeviceManager ftmsDeviceManager3 = FtmsDeviceManager.this;
                                ftmsDeviceManager3.readCharacteristic(ftmsDeviceManager3.fitnessMachineFeature).with(FtmsDeviceManager.this.fitnessMachineFeatureReceivedCallback).enqueue();
                            }
                            if (FtmsDeviceManager.this.trainingStatus != null) {
                                FtmsDeviceManager ftmsDeviceManager4 = FtmsDeviceManager.this;
                                ftmsDeviceManager4.setNotificationCallback(ftmsDeviceManager4.trainingStatus).with(FtmsDeviceManager.this.trainingStatusReceivedCallback);
                                FtmsDeviceManager ftmsDeviceManager5 = FtmsDeviceManager.this;
                                ftmsDeviceManager5.readCharacteristic(ftmsDeviceManager5.trainingStatus).with(FtmsDeviceManager.this.trainingStatusReceivedCallback).enqueue();
                                FtmsDeviceManager ftmsDeviceManager6 = FtmsDeviceManager.this;
                                ftmsDeviceManager6.enableNotifications(ftmsDeviceManager6.trainingStatus).enqueue();
                            }
                            if (FtmsDeviceManager.this.fitnessMachineStatus != null) {
                                FtmsDeviceManager ftmsDeviceManager7 = FtmsDeviceManager.this;
                                ftmsDeviceManager7.setNotificationCallback(ftmsDeviceManager7.fitnessMachineStatus).with(FtmsDeviceManager.this.fitnessMachineStatusReceivedCallback);
                                FtmsDeviceManager ftmsDeviceManager8 = FtmsDeviceManager.this;
                                ftmsDeviceManager8.enableNotifications(ftmsDeviceManager8.fitnessMachineStatus).enqueue();
                            }
                            if (FtmsDeviceManager.this.treadmillDataCharacteristic != null) {
                                FtmsDeviceManager ftmsDeviceManager9 = FtmsDeviceManager.this;
                                ftmsDeviceManager9.setNotificationCallback(ftmsDeviceManager9.treadmillDataCharacteristic).with(FtmsDeviceManager.this.treadmillDataReceivedCallback);
                                FtmsDeviceManager ftmsDeviceManager10 = FtmsDeviceManager.this;
                                ftmsDeviceManager10.enableNotifications(ftmsDeviceManager10.treadmillDataCharacteristic).enqueue();
                            }
                            if (FtmsDeviceManager.this.indoorBikeDataCharacteristic != null) {
                                FtmsDeviceManager ftmsDeviceManager11 = FtmsDeviceManager.this;
                                ftmsDeviceManager11.setNotificationCallback(ftmsDeviceManager11.indoorBikeDataCharacteristic).with(FtmsDeviceManager.this.indoorBikeDataReceivedCallback);
                                FtmsDeviceManager ftmsDeviceManager12 = FtmsDeviceManager.this;
                                ftmsDeviceManager12.enableNotifications(ftmsDeviceManager12.indoorBikeDataCharacteristic).enqueue();
                            }
                            if (FtmsDeviceManager.this.crossTrainerDataCharacteristic != null) {
                                FtmsDeviceManager ftmsDeviceManager13 = FtmsDeviceManager.this;
                                ftmsDeviceManager13.setNotificationCallback(ftmsDeviceManager13.crossTrainerDataCharacteristic).with(FtmsDeviceManager.this.crossTrainerDataReceivedCallback);
                                FtmsDeviceManager ftmsDeviceManager14 = FtmsDeviceManager.this;
                                ftmsDeviceManager14.enableNotifications(ftmsDeviceManager14.crossTrainerDataCharacteristic).enqueue();
                            }
                            if (FtmsDeviceManager.this.stepClimberDataCharacteristic != null) {
                                FtmsDeviceManager ftmsDeviceManager15 = FtmsDeviceManager.this;
                                ftmsDeviceManager15.setNotificationCallback(ftmsDeviceManager15.stepClimberDataCharacteristic).with(FtmsDeviceManager.this.stepClimberDataReceivedCallback);
                                FtmsDeviceManager ftmsDeviceManager16 = FtmsDeviceManager.this;
                                ftmsDeviceManager16.enableNotifications(ftmsDeviceManager16.stepClimberDataCharacteristic).enqueue();
                            }
                            if (FtmsDeviceManager.this.rowerDataCharacteristic != null) {
                                FtmsDeviceManager ftmsDeviceManager17 = FtmsDeviceManager.this;
                                ftmsDeviceManager17.setNotificationCallback(ftmsDeviceManager17.rowerDataCharacteristic).with(FtmsDeviceManager.this.rowerDataReceivedCallback);
                                FtmsDeviceManager ftmsDeviceManager18 = FtmsDeviceManager.this;
                                ftmsDeviceManager18.enableNotifications(ftmsDeviceManager18.rowerDataCharacteristic).enqueue();
                            }
                        }
                    }

                    @Override // no.nordicsemi.android.ble.BleManagerHandler
                    protected boolean isRequiredServiceSupported(BluetoothGatt gatt) {
                        boolean z;
                        synchronized (FtmsDeviceManager.this) {
                            FtmsDeviceManager.this.broadcastUpdate(BleFtmsActionType.FTMS_ACTION_GATT_SERVICES_DISCOVERED);
                            BluetoothGattService service = gatt.getService(BleUuid.UUID_FITNESS_MACHINE);
                            FtmsDeviceManager.this.fitnessMachineFeature = null;
                            FtmsDeviceManager.this.trainingStatus = null;
                            FtmsDeviceManager.this.fitnessMachineStatus = null;
                            FtmsDeviceManager.this.fitnessMachineControlPoint = null;
                            FtmsDeviceManager.this.treadmillDataCharacteristic = null;
                            FtmsDeviceManager.this.indoorBikeDataCharacteristic = null;
                            FtmsDeviceManager.this.crossTrainerDataCharacteristic = null;
                            FtmsDeviceManager.this.stepClimberDataCharacteristic = null;
                            FtmsDeviceManager.this.rowerDataCharacteristic = null;
                            z = true;
                            if (service != null) {
                                FtmsDeviceManager.this.fitnessMachineFeature = service.getCharacteristic(BleUuid.UUID_FITNESS_MACHINE_FEATURE);
                                FtmsDeviceManager.this.trainingStatus = service.getCharacteristic(BleUuid.UUID_TRAINING_STATUS);
                                FtmsDeviceManager.this.fitnessMachineStatus = service.getCharacteristic(BleUuid.UUID_FITNESS_MACHINE_STATUS);
                                FtmsDeviceManager.this.fitnessMachineControlPoint = service.getCharacteristic(BleUuid.UUID_FITNESS_MACHINE_CONTROL_POINT);
                                if (FtmsDeviceManager.this.bleFtmsMachineType != null) {
                                    int i = AnonymousClass12.$SwitchMap$com$soletreadmills$sole_v2$ble$type$BleFtmsMachineType[FtmsDeviceManager.this.bleFtmsMachineType.ordinal()];
                                    if (i == 1) {
                                        FtmsDeviceManager.this.treadmillDataCharacteristic = service.getCharacteristic(BleUuid.UUID_TREADMILL_DATA);
                                    } else if (i == 2) {
                                        FtmsDeviceManager.this.indoorBikeDataCharacteristic = service.getCharacteristic(BleUuid.UUID_INDOOR_BIKE_DATA);
                                    } else if (i == 3) {
                                        FtmsDeviceManager.this.crossTrainerDataCharacteristic = service.getCharacteristic(BleUuid.UUID_CROSS_TRAINER_DATA);
                                        if (FtmsDeviceManager.this.getBluetoothDeviceName() != null && (CheckSimpleFtmsDeviceTool.isEllipticalSoleEjek(FtmsDeviceManager.this.getBluetoothDeviceName()) || CheckSimpleFtmsDeviceTool.isEllipticalSpiritEjek(FtmsDeviceManager.this.getBluetoothDeviceName()))) {
                                            FtmsDeviceManager.this.indoorBikeDataCharacteristic = service.getCharacteristic(BleUuid.UUID_INDOOR_BIKE_DATA);
                                        }
                                    } else if (i == 4) {
                                        FtmsDeviceManager.this.stepClimberDataCharacteristic = service.getCharacteristic(BleUuid.UUID_STEP_CLIMBER_DATA);
                                    } else if (i == 5) {
                                        FtmsDeviceManager.this.rowerDataCharacteristic = service.getCharacteristic(BleUuid.UUID_ROWER_DATA);
                                    }
                                }
                            }
                            if (FtmsDeviceManager.this.treadmillDataCharacteristic == null && FtmsDeviceManager.this.indoorBikeDataCharacteristic == null && FtmsDeviceManager.this.crossTrainerDataCharacteristic == null && FtmsDeviceManager.this.stepClimberDataCharacteristic == null && FtmsDeviceManager.this.rowerDataCharacteristic == null) {
                                z = false;
                            }
                        }
                        return z;
                    }

                    @Override // no.nordicsemi.android.ble.BleManagerHandler
                    protected void onDeviceDisconnected() {
                        synchronized (FtmsDeviceManager.this) {
                            Timber.d("getGattCallback -> onDeviceDisconnected", new Object[0]);
                        }
                    }
                };
            }
            bleManagerGattCallback = this.bleManagerGattCallback;
        }
        return bleManagerGattCallback;
    }

    /* renamed from: com.soletreadmills.sole_v2.ble.manager.FtmsDeviceManager$12, reason: invalid class name */
    static /* synthetic */ class AnonymousClass12 {
        static final /* synthetic */ int[] $SwitchMap$com$soletreadmills$sole_v2$ble$type$BleFtmsMachineType;

        static {
            int[] iArr = new int[BleFtmsMachineType.values().length];
            $SwitchMap$com$soletreadmills$sole_v2$ble$type$BleFtmsMachineType = iArr;
            try {
                iArr[BleFtmsMachineType.TREADMILL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$soletreadmills$sole_v2$ble$type$BleFtmsMachineType[BleFtmsMachineType.BIKE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$soletreadmills$sole_v2$ble$type$BleFtmsMachineType[BleFtmsMachineType.ELLIPTICAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$soletreadmills$sole_v2$ble$type$BleFtmsMachineType[BleFtmsMachineType.STEPPER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$soletreadmills$sole_v2$ble$type$BleFtmsMachineType[BleFtmsMachineType.ROWER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    @Override // no.nordicsemi.android.ble.BleManager, no.nordicsemi.android.ble.utils.ILogger
    public void log(final int priority, final String message) {
        Timber.log(priority, message, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDeviceDisconnected(final BluetoothDevice device) {
        Timber.d("onDeviceDisconnected device=%s", device);
        setBluetoothDeviceName(null);
        this.fitnessMachineFeature = null;
        this.trainingStatus = null;
        this.bleFtmsMachineType = null;
        this.treadmillDataCharacteristic = null;
        this.indoorBikeDataCharacteristic = null;
        this.crossTrainerDataCharacteristic = null;
        this.stepClimberDataCharacteristic = null;
        this.rowerDataCharacteristic = null;
        this.fitnessMachineControlPoint = null;
        this.isMachineControl = false;
        this.isSupportProgram = false;
        BleDataManager.getInstance().setFitnessMachineFeatureList(null);
        BleDataManager.getInstance().setNowTrainingStatusType(null);
        BleDataManager.getInstance().setOldTrainingStatusType(null);
        BleDataManager.getInstance().setNowFitnessMachineStatusType(null);
        BleDataManager.getInstance().setNowFMSTypeOnlyFourType(null);
        BleDataManager.getInstance().setOldFitnessMachineStatusType(null);
        stopDataReceivedCallbackHandlerThread();
        this.treadmillDataMultiple = null;
        this.indoorBikeDataMultiple = null;
        this.crossTrainerDataMultiple = null;
        this.stepClimberDataMultiple = null;
        this.rowerDataMultiple = null;
        setFtmsBaseDataOld(null);
        setHasAdv0x16(false);
        setUserWeightKg(AudioStats.AUDIO_AMPLITUDE_NONE);
        setFemale(false);
        this.simpleFftmsManager.onDeviceDisconnected();
        broadcastUpdate(BleFtmsActionType.FTMS_ACTION_GATT_DISCONNECTED, device.getAddress());
    }

    public void setBleFtmsMachineType(BleFtmsMachineType bleFtmsMachineType) {
        this.bleFtmsMachineType = bleFtmsMachineType;
    }

    public BleFtmsMachineType getBleFtmsMachineType() {
        return this.bleFtmsMachineType;
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

    public synchronized void sendCmd(final Data data, final SuccessCallback successCallback, final DataSentCallback dataSentCallback, final InvalidRequestCallback invalidRequestCallback, final FailCallback failCallback) {
        if (data == null) {
            if (invalidRequestCallback != null) {
                invalidRequestCallback.onInvalidRequest();
            }
            return;
        }
        Timber.e("sendCmd:%s", data);
        synchronized (this) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = this.fitnessMachineControlPoint;
            if (bluetoothGattCharacteristic != null) {
                WriteRequest writeRequestWriteCharacteristic = writeCharacteristic(bluetoothGattCharacteristic, data);
                if (dataSentCallback != null) {
                    writeRequestWriteCharacteristic.with(dataSentCallback);
                }
                if (successCallback != null) {
                    writeRequestWriteCharacteristic.done(successCallback);
                }
                if (invalidRequestCallback != null) {
                    writeRequestWriteCharacteristic.invalid(invalidRequestCallback);
                }
                if (failCallback != null) {
                    writeRequestWriteCharacteristic.fail(failCallback);
                }
                writeRequestWriteCharacteristic.enqueue();
            } else if (invalidRequestCallback != null) {
                invalidRequestCallback.onInvalidRequest();
            }
        }
    }

    public synchronized boolean isFitnessMachineControlPoint() {
        boolean z;
        synchronized (this) {
            z = this.fitnessMachineControlPoint != null && this.isMachineControl;
        }
        return z;
        return z;
    }

    public synchronized boolean getSupportProgram() {
        boolean z;
        synchronized (this) {
            z = this.isSupportProgram;
        }
        return z;
        return z;
    }

    public FitnessMachineStatusType getNowFitnessMachineStatusType() {
        return this.nowFitnessMachineStatusType;
    }

    public void setNowFitnessMachineStatusType(FitnessMachineStatusType nowFitnessMachineStatusType) {
        this.nowFitnessMachineStatusType = nowFitnessMachineStatusType;
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
    public synchronized void broadcastUpdate(final BleFtmsActionType actionType) {
        getContext().sendBroadcast(new Intent(actionType.name()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void broadcastUpdate(final BleFtmsActionType actionType, final String bleMacAddress) {
        Intent intent = new Intent(actionType.name());
        intent.putExtra(BleFtmsActionType.FTMS_EXTRA_GATT_ADDRESS.name(), bleMacAddress);
        getContext().sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void broadcastUpdateExtraDataFtms(final String ftmsDataJsonStr, String className) {
        Intent intent = new Intent(BleFtmsActionType.FTMS_ACTION_DATA_AVAILABLE.name());
        intent.putExtra(BleFtmsActionType.FTMS_EXTRA_DATA.name(), ftmsDataJsonStr);
        intent.putExtra(BleFtmsActionType.FTMS_EXTRA_DATA_TYPE.name(), className);
        getContext().sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void broadcastUpdateFitnessMachineControlPointExtraData(final FitnessMachineControlPointResponseData fitnessMachineControlPointResponseData) {
        String json;
        try {
            json = new Gson().toJson(fitnessMachineControlPointResponseData);
        } catch (Exception e) {
            e.printStackTrace();
            json = null;
        }
        if (json == null) {
            return;
        }
        Intent intent = new Intent(BleFtmsActionType.FTMS_ACTION_FITNESS_MACHINE_CONTROL_POINT_DATA_AVAILABLE.name());
        intent.putExtra(BleFtmsActionType.FTMS_EXTRA_DATA.name(), json);
        getContext().sendBroadcast(intent);
    }

    public FtmsBaseData getFtmsBaseDataOld() {
        FtmsBaseData ftmsBaseData;
        synchronized (this) {
            ftmsBaseData = this.ftmsBaseDataOld;
        }
        return ftmsBaseData;
    }

    public void setFtmsBaseDataOld(FtmsBaseData ftmsBaseDataOld) {
        synchronized (this) {
            this.ftmsBaseDataOld = ftmsBaseDataOld;
        }
    }

    public boolean isHasAdv0x16() {
        boolean z;
        synchronized (this) {
            z = this.isHasAdv0x16;
        }
        return z;
    }

    public void setHasAdv0x16(boolean hasAdv0x16) {
        synchronized (this) {
            this.isHasAdv0x16 = hasAdv0x16;
        }
    }

    public double getUserWeightKg() {
        double d;
        synchronized (this) {
            d = this.userWeightKg;
        }
        return d;
    }

    public void setUserWeightKg(double userWeightKg) {
        synchronized (this) {
            this.userWeightKg = userWeightKg;
        }
    }

    public boolean isFemale() {
        boolean z;
        synchronized (this) {
            z = this.isFemale;
        }
        return z;
    }

    public void setFemale(boolean female) {
        synchronized (this) {
            this.isFemale = female;
        }
    }

    public boolean isRaceFinish() {
        return this.isRaceFinish;
    }

    public void setRaceFinish(boolean raceFinish) {
        this.isRaceFinish = raceFinish;
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
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ble.manager.FtmsDeviceManager.getBluetoothDeviceName():java.lang.String");
    }

    public void setBluetoothDeviceName(String bluetoothDeviceName) {
        synchronized (this) {
            this.bluetoothDeviceName = bluetoothDeviceName;
        }
    }
}
