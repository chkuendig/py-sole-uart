package no.nordicsemi.android.ble.common.profile.cgm;

import android.bluetooth.BluetoothDevice;
import java.util.Calendar;
import no.nordicsemi.android.ble.data.Data;

/* loaded from: classes6.dex */
public interface CGMSessionStartTimeCallback {
    void onContinuousGlucoseMonitorSessionStartTimeReceived(BluetoothDevice bluetoothDevice, Calendar calendar, boolean z);

    default void onContinuousGlucoseMonitorSessionStartTimeReceivedWithCrcError(BluetoothDevice bluetoothDevice, Data data) {
    }
}
