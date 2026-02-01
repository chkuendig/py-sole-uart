package no.nordicsemi.android.ble.callback;

import android.bluetooth.BluetoothDevice;

@FunctionalInterface
/* loaded from: classes6.dex */
public interface RssiCallback {
    void onRssiRead(BluetoothDevice bluetoothDevice, int i);
}
