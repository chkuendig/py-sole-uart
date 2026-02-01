package no.nordicsemi.android.ble.common.profile.cgm;

import android.bluetooth.BluetoothDevice;
import no.nordicsemi.android.ble.common.profile.cgm.CGMTypes;
import no.nordicsemi.android.ble.data.Data;

/* loaded from: classes6.dex */
public interface CGMFeatureCallback extends CGMTypes {
    void onContinuousGlucoseMonitorFeaturesReceived(BluetoothDevice bluetoothDevice, CGMTypes.CGMFeatures cGMFeatures, int i, int i2, boolean z);

    default void onContinuousGlucoseMonitorFeaturesReceivedWithCrcError(BluetoothDevice bluetoothDevice, Data data) {
    }
}
