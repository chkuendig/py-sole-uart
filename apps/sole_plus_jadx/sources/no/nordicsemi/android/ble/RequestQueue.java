package no.nordicsemi.android.ble;

import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import java.util.Deque;
import java.util.LinkedList;
import no.nordicsemi.android.ble.Request;
import no.nordicsemi.android.ble.callback.AfterCallback;
import no.nordicsemi.android.ble.callback.BeforeCallback;
import no.nordicsemi.android.ble.callback.FailCallback;
import no.nordicsemi.android.ble.callback.InvalidRequestCallback;
import no.nordicsemi.android.ble.callback.SuccessCallback;

/* loaded from: classes6.dex */
public class RequestQueue extends TimeoutableRequest {
    private final Deque<Request> requests;

    RequestQueue() {
        super(Request.Type.SET);
        this.requests = new LinkedList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // no.nordicsemi.android.ble.TimeoutableRequest, no.nordicsemi.android.ble.Request
    public RequestQueue setRequestHandler(RequestHandler requestHandler) {
        super.setRequestHandler(requestHandler);
        return this;
    }

    @Override // no.nordicsemi.android.ble.TimeoutableRequest, no.nordicsemi.android.ble.Request
    public RequestQueue setHandler(Handler handler) {
        super.setHandler(handler);
        return this;
    }

    @Override // no.nordicsemi.android.ble.Request
    public RequestQueue done(SuccessCallback successCallback) {
        super.done(successCallback);
        return this;
    }

    @Override // no.nordicsemi.android.ble.Request
    public RequestQueue fail(FailCallback failCallback) {
        super.fail(failCallback);
        return this;
    }

    @Override // no.nordicsemi.android.ble.Request
    public RequestQueue invalid(InvalidRequestCallback invalidRequestCallback) {
        super.invalid(invalidRequestCallback);
        return this;
    }

    @Override // no.nordicsemi.android.ble.Request
    public RequestQueue before(BeforeCallback beforeCallback) {
        super.before(beforeCallback);
        return this;
    }

    @Override // no.nordicsemi.android.ble.Request
    public RequestQueue then(AfterCallback afterCallback) {
        super.then(afterCallback);
        return this;
    }

    @Override // no.nordicsemi.android.ble.TimeoutableRequest
    public RequestQueue timeout(long j) {
        super.timeout(j);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RequestQueue add(Operation operation) {
        if (operation instanceof Request) {
            Request request = (Request) operation;
            if (request.enqueued) {
                throw new IllegalStateException("Request already enqueued");
            }
            request.internalFail(new FailCallback() { // from class: no.nordicsemi.android.ble.RequestQueue$$ExternalSyntheticLambda0
                @Override // no.nordicsemi.android.ble.callback.FailCallback
                public final void onRequestFailed(BluetoothDevice bluetoothDevice, int i) {
                    this.f$0.notifyFail(bluetoothDevice, i);
                }
            });
            this.requests.add(request);
            request.enqueued = true;
            return this;
        }
        throw new IllegalArgumentException("Operation does not extend Request");
    }

    void addFirst(Request request) {
        this.requests.addFirst(request);
    }

    public int size() {
        return this.requests.size();
    }

    public boolean isEmpty() {
        return this.requests.isEmpty();
    }

    @Override // no.nordicsemi.android.ble.TimeoutableRequest
    public void cancel() {
        cancelQueue();
        super.cancel();
    }

    Request getNext() {
        try {
            return this.requests.remove();
        } catch (Exception unused) {
            return null;
        }
    }

    boolean hasMore() {
        return (this.finished || this.requests.isEmpty()) ? false : true;
    }

    void cancelQueue() {
        this.requests.clear();
    }
}
