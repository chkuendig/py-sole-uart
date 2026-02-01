package no.nordicsemi.android.ble;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import java.util.concurrent.CancellationException;
import no.nordicsemi.android.ble.Request;
import no.nordicsemi.android.ble.callback.BeforeCallback;
import no.nordicsemi.android.ble.callback.FailCallback;
import no.nordicsemi.android.ble.callback.SuccessCallback;
import no.nordicsemi.android.ble.exception.BluetoothDisabledException;
import no.nordicsemi.android.ble.exception.DeviceDisconnectedException;
import no.nordicsemi.android.ble.exception.InvalidRequestException;
import no.nordicsemi.android.ble.exception.RequestFailedException;

/* loaded from: classes6.dex */
public abstract class AwaitingRequest<T> extends TimeoutableValueRequest<T> {
    private static final int NOT_STARTED = -123456;
    private static final int STARTED = -123455;
    private Request trigger;
    private int triggerStatus;

    AwaitingRequest(Request.Type type) {
        super(type);
        this.triggerStatus = 0;
    }

    AwaitingRequest(Request.Type type, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(type, bluetoothGattCharacteristic);
        this.triggerStatus = 0;
    }

    AwaitingRequest(Request.Type type, BluetoothGattDescriptor bluetoothGattDescriptor) {
        super(type, bluetoothGattDescriptor);
        this.triggerStatus = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AwaitingRequest<T> trigger(Operation operation) {
        if (operation instanceof Request) {
            Request request = (Request) operation;
            this.trigger = request;
            this.triggerStatus = NOT_STARTED;
            request.internalBefore(new BeforeCallback() { // from class: no.nordicsemi.android.ble.AwaitingRequest$$ExternalSyntheticLambda0
                @Override // no.nordicsemi.android.ble.callback.BeforeCallback
                public final void onRequestStarted(BluetoothDevice bluetoothDevice) {
                    this.f$0.lambda$trigger$0(bluetoothDevice);
                }
            });
            this.trigger.internalSuccess(new SuccessCallback() { // from class: no.nordicsemi.android.ble.AwaitingRequest$$ExternalSyntheticLambda1
                @Override // no.nordicsemi.android.ble.callback.SuccessCallback
                public final void onRequestCompleted(BluetoothDevice bluetoothDevice) {
                    this.f$0.lambda$trigger$1(bluetoothDevice);
                }
            });
            this.trigger.internalFail(new FailCallback() { // from class: no.nordicsemi.android.ble.AwaitingRequest$$ExternalSyntheticLambda2
                @Override // no.nordicsemi.android.ble.callback.FailCallback
                public final void onRequestFailed(BluetoothDevice bluetoothDevice, int i) {
                    this.f$0.lambda$trigger$2(bluetoothDevice, i);
                }
            });
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$trigger$0(BluetoothDevice bluetoothDevice) {
        this.triggerStatus = STARTED;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$trigger$1(BluetoothDevice bluetoothDevice) {
        this.triggerStatus = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$trigger$2(BluetoothDevice bluetoothDevice, int i) {
        this.triggerStatus = i;
        this.syncLock.open();
        notifyFail(bluetoothDevice, i);
    }

    @Override // no.nordicsemi.android.ble.TimeoutableValueRequest
    public <E extends T> E await(E e) throws InterruptedException, CancellationException, DeviceDisconnectedException, RequestFailedException, InvalidRequestException, BluetoothDisabledException {
        assertNotMainThread();
        try {
            Request request = this.trigger;
            if (request != null && request.enqueued) {
                throw new IllegalStateException("Trigger request already enqueued");
            }
            super.await((AwaitingRequest<T>) e);
            return e;
        } catch (RequestFailedException e2) {
            if (this.triggerStatus != 0) {
                throw new RequestFailedException(this.trigger, this.triggerStatus);
            }
            throw e2;
        }
    }

    Request getTrigger() {
        return this.trigger;
    }

    boolean isTriggerPending() {
        return this.triggerStatus == NOT_STARTED;
    }

    boolean isTriggerCompleteOrNull() {
        return this.triggerStatus != STARTED;
    }
}
