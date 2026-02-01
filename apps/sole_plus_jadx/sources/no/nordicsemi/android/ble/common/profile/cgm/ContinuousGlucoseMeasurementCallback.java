package no.nordicsemi.android.ble.common.profile.cgm;

import android.bluetooth.BluetoothDevice;
import no.nordicsemi.android.ble.common.profile.cgm.CGMTypes;
import no.nordicsemi.android.ble.data.Data;

/* loaded from: classes6.dex */
public interface ContinuousGlucoseMeasurementCallback extends CGMTypes {
    static float toMgPerDecilitre(float f) {
        return f * 18.2f;
    }

    void onContinuousGlucoseMeasurementReceived(BluetoothDevice bluetoothDevice, float f, Float f2, Float f3, CGMTypes.CGMStatus cGMStatus, int i, boolean z);

    default void onContinuousGlucoseMeasurementReceivedWithCrcError(BluetoothDevice bluetoothDevice, Data data) {
    }
}
