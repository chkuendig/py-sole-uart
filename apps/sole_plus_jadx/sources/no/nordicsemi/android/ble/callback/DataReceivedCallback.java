package no.nordicsemi.android.ble.callback;

import android.bluetooth.BluetoothDevice;
import no.nordicsemi.android.ble.data.Data;

@FunctionalInterface
/* loaded from: classes6.dex */
public interface DataReceivedCallback {
    void onDataReceived(BluetoothDevice bluetoothDevice, Data data);
}
