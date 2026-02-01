package no.nordicsemi.android.ble.ktx;

import android.bluetooth.BluetoothDevice;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import no.nordicsemi.android.ble.ktx.state.BondState;
import no.nordicsemi.android.ble.observer.BondingObserver;

/* compiled from: BleManagerExt.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lno/nordicsemi/android/ble/ktx/BondStateObserverFlow;", "Lno/nordicsemi/android/ble/observer/BondingObserver;", "value", "Lno/nordicsemi/android/ble/ktx/state/BondState;", "(Lno/nordicsemi/android/ble/ktx/state/BondState;)V", "flow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "getFlow", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "onBonded", "", DeviceRequestsHelper.DEVICE_INFO_DEVICE, "Landroid/bluetooth/BluetoothDevice;", "onBondingFailed", "onBondingRequired", "ble-ktx_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
final class BondStateObserverFlow implements BondingObserver {
    private final MutableSharedFlow<BondState> flow;

    public BondStateObserverFlow(BondState value) {
        Intrinsics.checkNotNullParameter(value, "value");
        MutableSharedFlow<BondState> MutableSharedFlow = SharedFlowKt.MutableSharedFlow(1, 2, BufferOverflow.DROP_OLDEST);
        MutableSharedFlow.tryEmit(value);
        this.flow = MutableSharedFlow;
    }

    public final MutableSharedFlow<BondState> getFlow() {
        return this.flow;
    }

    @Override // no.nordicsemi.android.ble.observer.BondingObserver
    public void onBondingRequired(BluetoothDevice device) {
        Intrinsics.checkNotNullParameter(device, "device");
        this.flow.tryEmit(BondState.Bonding.INSTANCE);
    }

    @Override // no.nordicsemi.android.ble.observer.BondingObserver
    public void onBonded(BluetoothDevice device) {
        Intrinsics.checkNotNullParameter(device, "device");
        this.flow.tryEmit(BondState.Bonded.INSTANCE);
    }

    @Override // no.nordicsemi.android.ble.observer.BondingObserver
    public void onBondingFailed(BluetoothDevice device) {
        Intrinsics.checkNotNullParameter(device, "device");
        this.flow.tryEmit(BondState.Bonding.INSTANCE);
    }
}
