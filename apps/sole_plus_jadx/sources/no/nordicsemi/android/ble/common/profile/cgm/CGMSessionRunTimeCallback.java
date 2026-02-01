package no.nordicsemi.android.ble.common.profile.cgm;

import android.bluetooth.BluetoothDevice;
import no.nordicsemi.android.ble.data.Data;

/* loaded from: classes6.dex */
public interface CGMSessionRunTimeCallback {
    void onContinuousGlucoseMonitorSessionRunTimeReceived(BluetoothDevice bluetoothDevice, int i, boolean z);

    default void onContinuousGlucoseMonitorSessionRunTimeReceivedWithCrcError(BluetoothDevice bluetoothDevice, Data data) {
    }
}
