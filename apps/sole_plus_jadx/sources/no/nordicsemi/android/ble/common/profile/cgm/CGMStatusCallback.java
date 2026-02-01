package no.nordicsemi.android.ble.common.profile.cgm;

import android.bluetooth.BluetoothDevice;
import no.nordicsemi.android.ble.common.profile.cgm.CGMTypes;
import no.nordicsemi.android.ble.data.Data;

/* loaded from: classes6.dex */
public interface CGMStatusCallback extends CGMTypes {
    void onContinuousGlucoseMonitorStatusChanged(BluetoothDevice bluetoothDevice, CGMTypes.CGMStatus cGMStatus, int i, boolean z);

    default void onContinuousGlucoseMonitorStatusReceivedWithCrcError(BluetoothDevice bluetoothDevice, Data data) {
    }
}
