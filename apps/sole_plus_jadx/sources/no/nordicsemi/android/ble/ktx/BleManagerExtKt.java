package no.nordicsemi.android.ble.ktx;

import android.bluetooth.BluetoothDevice;
import com.facebook.internal.ServerProtocol;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import no.nordicsemi.android.ble.BleManager;
import no.nordicsemi.android.ble.ktx.state.BondState;
import no.nordicsemi.android.ble.ktx.state.ConnectionState;
import no.nordicsemi.android.ble.observer.BondingObserver;
import no.nordicsemi.android.ble.observer.ConnectionObserver;

/* compiled from: BleManagerExt.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n*\u00020\u0002\u001a\u0010\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\n*\u00020\u0002\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"bondingState", "Lno/nordicsemi/android/ble/ktx/state/BondState;", "Lno/nordicsemi/android/ble/BleManager;", "getBondingState", "(Lno/nordicsemi/android/ble/BleManager;)Lno/nordicsemi/android/ble/ktx/state/BondState;", ServerProtocol.DIALOG_PARAM_STATE, "Lno/nordicsemi/android/ble/ktx/state/ConnectionState;", "getState", "(Lno/nordicsemi/android/ble/BleManager;)Lno/nordicsemi/android/ble/ktx/state/ConnectionState;", "bondingStateAsFlow", "Lkotlinx/coroutines/flow/Flow;", "stateAsFlow", "ble-ktx_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BleManagerExtKt {
    public static final ConnectionState getState(BleManager bleManager) {
        Intrinsics.checkNotNullParameter(bleManager, "<this>");
        return ConnectionState.INSTANCE.of$ble_ktx_release(bleManager);
    }

    public static final BondState getBondingState(BleManager bleManager) {
        Intrinsics.checkNotNullParameter(bleManager, "<this>");
        BluetoothDevice bluetoothDevice = bleManager.getBluetoothDevice();
        Integer numValueOf = bluetoothDevice != null ? Integer.valueOf(bluetoothDevice.getBondState()) : null;
        return (numValueOf != null && numValueOf.intValue() == 12) ? BondState.Bonded.INSTANCE : (numValueOf != null && numValueOf.intValue() == 11) ? BondState.Bonding.INSTANCE : BondState.NotBonded.INSTANCE;
    }

    public static final Flow<ConnectionState> stateAsFlow(BleManager bleManager) {
        MutableSharedFlow<ConnectionState> flow;
        Intrinsics.checkNotNullParameter(bleManager, "<this>");
        ConnectionObserver connectionObserver = bleManager.getConnectionObserver();
        if (connectionObserver == null) {
            ConnectionObserverFlow connectionObserverFlow = new ConnectionObserverFlow(getState(bleManager));
            bleManager.setConnectionObserver(connectionObserverFlow);
            flow = connectionObserverFlow.getFlow();
        } else {
            if (!(connectionObserver instanceof ConnectionObserverFlow)) {
                throw new IllegalStateException("Observer already set");
            }
            flow = ((ConnectionObserverFlow) connectionObserver).getFlow();
        }
        return flow;
    }

    public static final Flow<BondState> bondingStateAsFlow(BleManager bleManager) {
        MutableSharedFlow<BondState> flow;
        Intrinsics.checkNotNullParameter(bleManager, "<this>");
        BondingObserver bondingObserver = bleManager.getBondingObserver();
        if (bondingObserver == null) {
            BondStateObserverFlow bondStateObserverFlow = new BondStateObserverFlow(getBondingState(bleManager));
            bleManager.setBondingObserver(bondStateObserverFlow);
            flow = bondStateObserverFlow.getFlow();
        } else {
            if (!(bondingObserver instanceof BondStateObserverFlow)) {
                throw new IllegalStateException("Observer already set");
            }
            flow = ((BondStateObserverFlow) bondingObserver).getFlow();
        }
        return flow;
    }
}
