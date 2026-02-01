package no.nordicsemi.android.ble.common.callback.cgm;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import no.nordicsemi.android.ble.callback.profile.ProfileReadResponse;
import no.nordicsemi.android.ble.common.profile.cgm.CGMSpecificOpsControlPointCallback;
import no.nordicsemi.android.ble.common.profile.cgm.CGMTypes;
import no.nordicsemi.android.ble.common.util.CRC16;
import no.nordicsemi.android.ble.data.Data;

/* loaded from: classes6.dex */
public abstract class CGMSpecificOpsControlPointDataCallback extends ProfileReadResponse implements CGMSpecificOpsControlPointCallback {
    private static final int CGM_RESPONSE_SUCCESS = 1;
    private static final int OP_CODE_CALIBRATION_VALUE_RESPONSE = 6;
    private static final int OP_CODE_COMMUNICATION_INTERVAL_RESPONSE = 3;
    private static final int OP_CODE_HYPER_ALERT_LEVEL_RESPONSE = 18;
    private static final int OP_CODE_HYPO_ALERT_LEVEL_RESPONSE = 15;
    private static final int OP_CODE_PATIENT_HIGH_ALERT_LEVEL_RESPONSE = 9;
    private static final int OP_CODE_PATIENT_LOW_ALERT_LEVEL_RESPONSE = 12;
    private static final int OP_CODE_RATE_OF_DECREASE_ALERT_LEVEL_RESPONSE = 21;
    private static final int OP_CODE_RATE_OF_INCREASE_ALERT_LEVEL_RESPONSE = 24;
    private static final int OP_CODE_RESPONSE_CODE = 28;

    public CGMSpecificOpsControlPointDataCallback() {
    }

    protected CGMSpecificOpsControlPointDataCallback(Parcel parcel) {
        super(parcel);
    }

    @Override // no.nordicsemi.android.ble.response.ReadResponse, no.nordicsemi.android.ble.callback.DataReceivedCallback
    public void onDataReceived(BluetoothDevice bluetoothDevice, Data data) {
        int i;
        super.onDataReceived(bluetoothDevice, data);
        if (data.size() < 2) {
            onInvalidDataReceived(bluetoothDevice, data);
            return;
        }
        int iIntValue = data.getIntValue(17, 0).intValue();
        if (iIntValue == 3) {
            i = 1;
        } else if (iIntValue == 6) {
            i = 10;
        } else {
            if (iIntValue != 9 && iIntValue != 12 && iIntValue != 15 && iIntValue != 18 && iIntValue != 21 && iIntValue != 24 && iIntValue != 28) {
                onInvalidDataReceived(bluetoothDevice, data);
                return;
            }
            i = 2;
        }
        int i2 = i + 1;
        if (data.size() != i2 && data.size() != i + 3) {
            onInvalidDataReceived(bluetoothDevice, data);
            return;
        }
        boolean z = data.size() == i + 3;
        if (z && data.getIntValue(18, i2).intValue() != CRC16.MCRF4XX(data.getValue(), 0, i2)) {
            onCGMSpecificOpsResponseReceivedWithCrcError(bluetoothDevice, data);
            return;
        }
        if (iIntValue == 3) {
            onContinuousGlucoseCommunicationIntervalReceived(bluetoothDevice, data.getIntValue(17, 1).intValue(), z);
            return;
        }
        if (iIntValue == 6) {
            float fFloatValue = data.getFloatValue(50, 1).floatValue();
            int iIntValue2 = data.getIntValue(18, 3).intValue();
            int iIntValue3 = data.getIntValue(17, 5).intValue();
            onContinuousGlucoseCalibrationValueReceived(bluetoothDevice, fFloatValue, iIntValue2, data.getIntValue(18, 6).intValue(), iIntValue3 & 15, iIntValue3 >> 4, data.getIntValue(18, 8).intValue(), new CGMTypes.CGMCalibrationStatus(data.getIntValue(17, 10).intValue()), z);
            return;
        }
        if (iIntValue == 28) {
            int iIntValue4 = data.getIntValue(17, 1).intValue();
            int iIntValue5 = data.getIntValue(17, 2).intValue();
            if (iIntValue5 == 1) {
                onCGMSpecificOpsOperationCompleted(bluetoothDevice, iIntValue4, z);
                return;
            } else {
                onCGMSpecificOpsOperationError(bluetoothDevice, iIntValue4, iIntValue5, z);
                return;
            }
        }
        float fFloatValue2 = data.getFloatValue(50, 1).floatValue();
        if (iIntValue == 9) {
            onContinuousGlucosePatientHighAlertReceived(bluetoothDevice, fFloatValue2, z);
            return;
        }
        if (iIntValue == 12) {
            onContinuousGlucosePatientLowAlertReceived(bluetoothDevice, fFloatValue2, z);
            return;
        }
        if (iIntValue == 15) {
            onContinuousGlucoseHypoAlertReceived(bluetoothDevice, fFloatValue2, z);
            return;
        }
        if (iIntValue == 18) {
            onContinuousGlucoseHyperAlertReceived(bluetoothDevice, fFloatValue2, z);
        } else if (iIntValue == 21) {
            onContinuousGlucoseRateOfDecreaseAlertReceived(bluetoothDevice, fFloatValue2, z);
        } else {
            if (iIntValue != 24) {
                return;
            }
            onContinuousGlucoseRateOfIncreaseAlertReceived(bluetoothDevice, fFloatValue2, z);
        }
    }
}
