package no.nordicsemi.android.ble.common.profile.csc;

import android.bluetooth.BluetoothDevice;

/* loaded from: classes6.dex */
public interface CyclingSpeedAndCadenceCallback {
    public static final float WHEEL_CIRCUMFERENCE_DEFAULT = 2340.0f;

    default float getWheelCircumference() {
        return 2340.0f;
    }

    void onCrankDataChanged(BluetoothDevice bluetoothDevice, float f, float f2);

    void onDistanceChanged(BluetoothDevice bluetoothDevice, float f, float f2, float f3);
}
