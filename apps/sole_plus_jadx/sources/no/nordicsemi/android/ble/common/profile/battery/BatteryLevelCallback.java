package no.nordicsemi.android.ble.common.profile.battery;

import android.bluetooth.BluetoothDevice;

/* loaded from: classes6.dex */
public interface BatteryLevelCallback {
    void onBatteryLevelChanged(BluetoothDevice bluetoothDevice, int i);
}
