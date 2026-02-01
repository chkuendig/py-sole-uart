package no.nordicsemi.android.ble.livedata;

import android.bluetooth.BluetoothDevice;
import androidx.lifecycle.LiveData;
import no.nordicsemi.android.ble.livedata.state.BondState;
import no.nordicsemi.android.ble.observer.BondingObserver;

/* loaded from: classes6.dex */
class BondingStateLiveData extends LiveData<BondState> implements BondingObserver {
    BondingStateLiveData() {
        setValue(BondState.NotBonded.INSTANCE);
    }

    @Override // no.nordicsemi.android.ble.observer.BondingObserver
    public void onBondingRequired(BluetoothDevice bluetoothDevice) {
        setValue(BondState.Bonding.INSTANCE);
    }

    @Override // no.nordicsemi.android.ble.observer.BondingObserver
    public void onBonded(BluetoothDevice bluetoothDevice) {
        setValue(BondState.Bonded.INSTANCE);
    }

    @Override // no.nordicsemi.android.ble.observer.BondingObserver
    public void onBondingFailed(BluetoothDevice bluetoothDevice) {
        setValue(BondState.NotBonded.INSTANCE);
    }
}
