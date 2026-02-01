package no.nordicsemi.android.ble.common.callback.cgm;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import no.nordicsemi.android.ble.callback.profile.ProfileReadResponse;
import no.nordicsemi.android.ble.common.profile.cgm.CGMTypes;
import no.nordicsemi.android.ble.common.profile.cgm.ContinuousGlucoseMeasurementCallback;
import no.nordicsemi.android.ble.common.util.CRC16;
import no.nordicsemi.android.ble.data.Data;

/* loaded from: classes6.dex */
public abstract class ContinuousGlucoseMeasurementDataCallback extends ProfileReadResponse implements ContinuousGlucoseMeasurementCallback {
    public ContinuousGlucoseMeasurementDataCallback() {
    }

    protected ContinuousGlucoseMeasurementDataCallback(Parcel parcel) {
        super(parcel);
    }

    @Override // no.nordicsemi.android.ble.response.ReadResponse, no.nordicsemi.android.ble.callback.DataReceivedCallback
    public void onDataReceived(BluetoothDevice bluetoothDevice, Data data) {
        int i;
        int iIntValue;
        int iIntValue2;
        Float f;
        Float f2;
        super.onDataReceived(bluetoothDevice, data);
        if (data.size() < 1) {
            onInvalidDataReceived(bluetoothDevice, data);
            return;
        }
        int i2 = 0;
        while (i2 < data.size()) {
            int iIntValue3 = data.getIntValue(17, i2).intValue();
            if (iIntValue3 < 6 || i2 + iIntValue3 > data.size()) {
                onInvalidDataReceived(bluetoothDevice, data);
                return;
            }
            int iIntValue4 = data.getIntValue(17, i2 + 1).intValue();
            boolean z = (iIntValue4 & 1) != 0;
            boolean z2 = (iIntValue4 & 2) != 0;
            int i3 = (iIntValue4 & 32) != 0 ? 1 : 0;
            int i4 = (iIntValue4 & 64) != 0 ? 1 : 0;
            int i5 = (iIntValue4 & 128) != 0 ? 1 : 0;
            int i6 = (z ? 2 : 0) + 6 + (z2 ? 2 : 0) + i3 + i4 + i5;
            if (iIntValue3 != i6 && iIntValue3 != i6 + 2) {
                onInvalidDataReceived(bluetoothDevice, data);
                return;
            }
            boolean z3 = iIntValue3 == i6 + 2;
            if (z3 && data.getIntValue(18, i2 + i6).intValue() != CRC16.MCRF4XX(data.getValue(), i2, i6)) {
                onContinuousGlucoseMeasurementReceivedWithCrcError(bluetoothDevice, data);
                return;
            }
            float fFloatValue = data.getFloatValue(50, i2 + 2).floatValue();
            int iIntValue5 = data.getIntValue(18, i2 + 4).intValue();
            int i7 = i2 + 6;
            if (i3 != 0) {
                int iIntValue6 = data.getIntValue(17, i7).intValue();
                i7 = i2 + 7;
                i = iIntValue6;
            } else {
                i = 0;
            }
            if (i4 != 0) {
                iIntValue = data.getIntValue(17, i7).intValue();
                i7++;
            } else {
                iIntValue = 0;
            }
            if (i5 != 0) {
                iIntValue2 = data.getIntValue(17, i7).intValue();
                i7++;
            } else {
                iIntValue2 = 0;
            }
            CGMTypes.CGMStatus cGMStatus = (i3 == 0 && i4 == 0 && i5 == 0) ? null : new CGMTypes.CGMStatus(i, iIntValue, iIntValue2);
            if (z) {
                Float floatValue = data.getFloatValue(50, i7);
                i7 += 2;
                f = floatValue;
            } else {
                f = null;
            }
            if (z2) {
                Float floatValue2 = data.getFloatValue(50, i7);
                i7 += 2;
                f2 = floatValue2;
            } else {
                f2 = null;
            }
            if (z3) {
                i7 += 2;
            }
            i2 = i7;
            onContinuousGlucoseMeasurementReceived(bluetoothDevice, fFloatValue, f, f2, cGMStatus, iIntValue5, z3);
        }
    }
}
