package no.nordicsemi.android.ble.livedata;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LiveData;
import no.nordicsemi.android.ble.BleManager;
import no.nordicsemi.android.ble.livedata.state.BondState;
import no.nordicsemi.android.ble.livedata.state.ConnectionState;

/* loaded from: classes6.dex */
public abstract class ObservableBleManager extends BleManager {
    public final LiveData<BondState> bondingState;
    public final LiveData<ConnectionState> state;

    public ObservableBleManager(Context context) {
        this(context, new Handler(Looper.getMainLooper()));
    }

    public ObservableBleManager(Context context, Handler handler) {
        super(context, handler);
        ConnectionStateLiveData connectionStateLiveData = new ConnectionStateLiveData();
        this.state = connectionStateLiveData;
        BondingStateLiveData bondingStateLiveData = new BondingStateLiveData();
        this.bondingState = bondingStateLiveData;
        setConnectionObserver(connectionStateLiveData);
        setBondingObserver(bondingStateLiveData);
    }
}
