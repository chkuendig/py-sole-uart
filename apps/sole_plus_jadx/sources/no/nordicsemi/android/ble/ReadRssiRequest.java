package no.nordicsemi.android.ble;

import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import android.util.Log;
import no.nordicsemi.android.ble.Request;
import no.nordicsemi.android.ble.callback.AfterCallback;
import no.nordicsemi.android.ble.callback.BeforeCallback;
import no.nordicsemi.android.ble.callback.FailCallback;
import no.nordicsemi.android.ble.callback.InvalidRequestCallback;
import no.nordicsemi.android.ble.callback.RssiCallback;
import no.nordicsemi.android.ble.callback.SuccessCallback;

/* loaded from: classes6.dex */
public final class ReadRssiRequest extends SimpleValueRequest<RssiCallback> implements Operation {
    ReadRssiRequest(Request.Type type) {
        super(type);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // no.nordicsemi.android.ble.Request
    public ReadRssiRequest setRequestHandler(RequestHandler requestHandler) {
        super.setRequestHandler(requestHandler);
        return this;
    }

    @Override // no.nordicsemi.android.ble.Request
    public ReadRssiRequest setHandler(Handler handler) {
        super.setHandler(handler);
        return this;
    }

    @Override // no.nordicsemi.android.ble.Request
    public ReadRssiRequest done(SuccessCallback successCallback) {
        super.done(successCallback);
        return this;
    }

    @Override // no.nordicsemi.android.ble.Request
    public ReadRssiRequest fail(FailCallback failCallback) {
        super.fail(failCallback);
        return this;
    }

    @Override // no.nordicsemi.android.ble.Request
    public ReadRssiRequest invalid(InvalidRequestCallback invalidRequestCallback) {
        super.invalid(invalidRequestCallback);
        return this;
    }

    @Override // no.nordicsemi.android.ble.Request
    public ReadRssiRequest before(BeforeCallback beforeCallback) {
        super.before(beforeCallback);
        return this;
    }

    @Override // no.nordicsemi.android.ble.Request
    public ReadRssiRequest then(AfterCallback afterCallback) {
        super.then(afterCallback);
        return this;
    }

    @Override // no.nordicsemi.android.ble.SimpleValueRequest
    public ReadRssiRequest with(RssiCallback rssiCallback) {
        super.with((ReadRssiRequest) rssiCallback);
        return this;
    }

    void notifyRssiRead(final BluetoothDevice bluetoothDevice, final int i) {
        this.handler.post(new Runnable() { // from class: no.nordicsemi.android.ble.ReadRssiRequest$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$notifyRssiRead$0(bluetoothDevice, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyRssiRead$0(BluetoothDevice bluetoothDevice, int i) {
        if (this.valueCallback != 0) {
            try {
                ((RssiCallback) this.valueCallback).onRssiRead(bluetoothDevice, i);
            } catch (Throwable th) {
                Log.e(TAG, "Exception in Value callback", th);
            }
        }
    }
}
