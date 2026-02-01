package no.nordicsemi.android.ble.livedata;

import android.bluetooth.BluetoothDevice;
import androidx.lifecycle.LiveData;
import no.nordicsemi.android.ble.livedata.state.ConnectionState;
import no.nordicsemi.android.ble.observer.ConnectionObserver;

/* loaded from: classes6.dex */
class ConnectionStateLiveData extends LiveData<ConnectionState> implements ConnectionObserver {
    ConnectionStateLiveData() {
        setValue(new ConnectionState.Disconnected(-1));
    }

    @Override // no.nordicsemi.android.ble.observer.ConnectionObserver
    public void onDeviceConnecting(BluetoothDevice bluetoothDevice) {
        setValue(ConnectionState.Connecting.INSTANCE);
    }

    @Override // no.nordicsemi.android.ble.observer.ConnectionObserver
    public void onDeviceConnected(BluetoothDevice bluetoothDevice) {
        setValue(ConnectionState.Initializing.INSTANCE);
    }

    @Override // no.nordicsemi.android.ble.observer.ConnectionObserver
    public void onDeviceFailedToConnect(BluetoothDevice bluetoothDevice, int i) {
        setValue(new ConnectionState.Disconnected(i));
    }

    @Override // no.nordicsemi.android.ble.observer.ConnectionObserver
    public void onDeviceReady(BluetoothDevice bluetoothDevice) {
        setValue(ConnectionState.Ready.INSTANCE);
    }

    @Override // no.nordicsemi.android.ble.observer.ConnectionObserver
    public void onDeviceDisconnecting(BluetoothDevice bluetoothDevice) {
        setValue(ConnectionState.Disconnecting.INSTANCE);
    }

    @Override // no.nordicsemi.android.ble.observer.ConnectionObserver
    public void onDeviceDisconnected(BluetoothDevice bluetoothDevice, int i) {
        setValue(new ConnectionState.Disconnected(i));
    }
}
