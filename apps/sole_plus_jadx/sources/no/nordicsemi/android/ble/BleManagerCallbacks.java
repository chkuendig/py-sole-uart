package no.nordicsemi.android.ble;

import android.bluetooth.BluetoothDevice;

@Deprecated
/* loaded from: classes6.dex */
public interface BleManagerCallbacks {
    @Deprecated
    default void onBatteryValueReceived(BluetoothDevice bluetoothDevice, int i) {
    }

    @Deprecated
    void onBonded(BluetoothDevice bluetoothDevice);

    @Deprecated
    void onBondingFailed(BluetoothDevice bluetoothDevice);

    @Deprecated
    void onBondingRequired(BluetoothDevice bluetoothDevice);

    @Deprecated
    void onDeviceConnected(BluetoothDevice bluetoothDevice);

    @Deprecated
    void onDeviceConnecting(BluetoothDevice bluetoothDevice);

    @Deprecated
    void onDeviceDisconnected(BluetoothDevice bluetoothDevice);

    @Deprecated
    void onDeviceDisconnecting(BluetoothDevice bluetoothDevice);

    @Deprecated
    void onDeviceNotSupported(BluetoothDevice bluetoothDevice);

    @Deprecated
    void onDeviceReady(BluetoothDevice bluetoothDevice);

    @Deprecated
    void onError(BluetoothDevice bluetoothDevice, String str, int i);

    @Deprecated
    void onLinkLossOccurred(BluetoothDevice bluetoothDevice);

    @Deprecated
    void onServicesDiscovered(BluetoothDevice bluetoothDevice, boolean z);

    @Deprecated
    default boolean shouldEnableBatteryLevelNotifications(BluetoothDevice bluetoothDevice) {
        return false;
    }
}
