package no.nordicsemi.android.ble;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.os.Handler;
import android.util.Log;
import java.util.concurrent.CancellationException;
import no.nordicsemi.android.ble.Request;
import no.nordicsemi.android.ble.callback.AfterCallback;
import no.nordicsemi.android.ble.callback.BeforeCallback;
import no.nordicsemi.android.ble.callback.DataReceivedCallback;
import no.nordicsemi.android.ble.callback.FailCallback;
import no.nordicsemi.android.ble.callback.InvalidRequestCallback;
import no.nordicsemi.android.ble.callback.ReadProgressCallback;
import no.nordicsemi.android.ble.callback.SuccessCallback;
import no.nordicsemi.android.ble.callback.profile.ProfileReadResponse;
import no.nordicsemi.android.ble.data.Data;
import no.nordicsemi.android.ble.data.DataFilter;
import no.nordicsemi.android.ble.data.DataMerger;
import no.nordicsemi.android.ble.data.DataStream;
import no.nordicsemi.android.ble.data.PacketFilter;
import no.nordicsemi.android.ble.exception.BluetoothDisabledException;
import no.nordicsemi.android.ble.exception.DeviceDisconnectedException;
import no.nordicsemi.android.ble.exception.InvalidDataException;
import no.nordicsemi.android.ble.exception.InvalidRequestException;
import no.nordicsemi.android.ble.exception.RequestFailedException;

/* loaded from: classes6.dex */
public final class WaitForValueChangedRequest extends AwaitingRequest<DataReceivedCallback> implements Operation {
    private boolean bluetoothDisabled;
    private DataStream buffer;
    private boolean complete;
    private int count;
    private DataMerger dataMerger;
    private boolean deviceDisconnected;
    private DataFilter filter;
    private PacketFilter packetFilter;
    private ReadProgressCallback progressCallback;

    WaitForValueChangedRequest(Request.Type type, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(type, bluetoothGattCharacteristic);
        this.count = 0;
        this.complete = false;
    }

    WaitForValueChangedRequest(Request.Type type, BluetoothGattDescriptor bluetoothGattDescriptor) {
        super(type, bluetoothGattDescriptor);
        this.count = 0;
        this.complete = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // no.nordicsemi.android.ble.TimeoutableRequest, no.nordicsemi.android.ble.Request
    public WaitForValueChangedRequest setRequestHandler(RequestHandler requestHandler) {
        super.setRequestHandler(requestHandler);
        return this;
    }

    @Override // no.nordicsemi.android.ble.TimeoutableRequest, no.nordicsemi.android.ble.Request
    public WaitForValueChangedRequest setHandler(Handler handler) {
        super.setHandler(handler);
        return this;
    }

    @Override // no.nordicsemi.android.ble.TimeoutableValueRequest, no.nordicsemi.android.ble.TimeoutableRequest
    public WaitForValueChangedRequest timeout(long j) {
        super.timeout(j);
        return this;
    }

    @Override // no.nordicsemi.android.ble.Request
    public WaitForValueChangedRequest done(SuccessCallback successCallback) {
        super.done(successCallback);
        return this;
    }

    @Override // no.nordicsemi.android.ble.Request
    public WaitForValueChangedRequest fail(FailCallback failCallback) {
        super.fail(failCallback);
        return this;
    }

    @Override // no.nordicsemi.android.ble.Request
    public WaitForValueChangedRequest invalid(InvalidRequestCallback invalidRequestCallback) {
        super.invalid(invalidRequestCallback);
        return this;
    }

    @Override // no.nordicsemi.android.ble.Request
    public WaitForValueChangedRequest before(BeforeCallback beforeCallback) {
        super.before(beforeCallback);
        return this;
    }

    @Override // no.nordicsemi.android.ble.Request
    public WaitForValueChangedRequest then(AfterCallback afterCallback) {
        super.then(afterCallback);
        return this;
    }

    @Override // no.nordicsemi.android.ble.TimeoutableValueRequest
    public WaitForValueChangedRequest with(DataReceivedCallback dataReceivedCallback) {
        super.with((WaitForValueChangedRequest) dataReceivedCallback);
        return this;
    }

    @Override // no.nordicsemi.android.ble.AwaitingRequest
    public AwaitingRequest<DataReceivedCallback> trigger(Operation operation) {
        super.trigger(operation);
        return this;
    }

    public WaitForValueChangedRequest filter(DataFilter dataFilter) {
        this.filter = dataFilter;
        return this;
    }

    public WaitForValueChangedRequest filterPacket(PacketFilter packetFilter) {
        this.packetFilter = packetFilter;
        return this;
    }

    public WaitForValueChangedRequest merge(DataMerger dataMerger) {
        this.dataMerger = dataMerger;
        this.progressCallback = null;
        return this;
    }

    public WaitForValueChangedRequest merge(DataMerger dataMerger, ReadProgressCallback readProgressCallback) {
        this.dataMerger = dataMerger;
        this.progressCallback = readProgressCallback;
        return this;
    }

    public <E extends ProfileReadResponse> E awaitValid(E e) throws InterruptedException, CancellationException, InvalidDataException, DeviceDisconnectedException, RequestFailedException, InvalidRequestException, BluetoothDisabledException {
        E e2 = (E) await((WaitForValueChangedRequest) e);
        if (e2 == null || e2.isValid()) {
            return e2;
        }
        throw new InvalidDataException(e2);
    }

    public <E extends ProfileReadResponse> E awaitValid(Class<E> cls) throws InterruptedException, CancellationException, InvalidDataException, DeviceDisconnectedException, RequestFailedException, InvalidRequestException, BluetoothDisabledException {
        E e = (E) await((Class) cls);
        if (e == null || e.isValid()) {
            return e;
        }
        throw new InvalidDataException(e);
    }

    @Deprecated
    public <E extends ProfileReadResponse> E awaitValid(Class<E> cls, long j) throws InterruptedException, CancellationException, InvalidDataException, DeviceDisconnectedException, RequestFailedException, InvalidRequestException, BluetoothDisabledException {
        return (E) timeout(j).awaitValid(cls);
    }

    @Deprecated
    public <E extends ProfileReadResponse> E awaitValid(E e, long j) throws InterruptedException, CancellationException, InvalidDataException, DeviceDisconnectedException, RequestFailedException, InvalidRequestException, BluetoothDisabledException {
        return (E) timeout(j).awaitValid((WaitForValueChangedRequest) e);
    }

    boolean matches(byte[] bArr) {
        DataFilter dataFilter = this.filter;
        return dataFilter == null || dataFilter.filter(bArr);
    }

    void notifyValueChanged(final BluetoothDevice bluetoothDevice, final byte[] bArr) {
        PacketFilter packetFilter;
        final DataReceivedCallback dataReceivedCallback = (DataReceivedCallback) this.valueCallback;
        if (dataReceivedCallback == null) {
            PacketFilter packetFilter2 = this.packetFilter;
            if (packetFilter2 == null || packetFilter2.filter(bArr)) {
                this.complete = true;
                return;
            }
            return;
        }
        if (this.dataMerger == null && ((packetFilter = this.packetFilter) == null || packetFilter.filter(bArr))) {
            this.complete = true;
            final Data data = new Data(bArr);
            this.handler.post(new Runnable() { // from class: no.nordicsemi.android.ble.WaitForValueChangedRequest$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    WaitForValueChangedRequest.lambda$notifyValueChanged$0(dataReceivedCallback, bluetoothDevice, data);
                }
            });
            return;
        }
        final int i = this.count;
        this.handler.post(new Runnable() { // from class: no.nordicsemi.android.ble.WaitForValueChangedRequest$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$notifyValueChanged$1(bluetoothDevice, bArr, i);
            }
        });
        if (this.buffer == null) {
            this.buffer = new DataStream();
        }
        DataMerger dataMerger = this.dataMerger;
        DataStream dataStream = this.buffer;
        int i2 = this.count;
        this.count = i2 + 1;
        if (dataMerger.merge(dataStream, bArr, i2)) {
            byte[] byteArray = this.buffer.toByteArray();
            PacketFilter packetFilter3 = this.packetFilter;
            if (packetFilter3 == null || packetFilter3.filter(byteArray)) {
                this.complete = true;
                final Data data2 = new Data(byteArray);
                this.handler.post(new Runnable() { // from class: no.nordicsemi.android.ble.WaitForValueChangedRequest$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        WaitForValueChangedRequest.lambda$notifyValueChanged$2(dataReceivedCallback, bluetoothDevice, data2);
                    }
                });
            }
            this.buffer = null;
            this.count = 0;
        }
    }

    static /* synthetic */ void lambda$notifyValueChanged$0(DataReceivedCallback dataReceivedCallback, BluetoothDevice bluetoothDevice, Data data) {
        try {
            dataReceivedCallback.onDataReceived(bluetoothDevice, data);
        } catch (Throwable th) {
            Log.e(TAG, "Exception in Value callback", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyValueChanged$1(BluetoothDevice bluetoothDevice, byte[] bArr, int i) {
        ReadProgressCallback readProgressCallback = this.progressCallback;
        if (readProgressCallback != null) {
            try {
                readProgressCallback.onPacketReceived(bluetoothDevice, bArr, i);
            } catch (Throwable th) {
                Log.e(TAG, "Exception in Progress callback", th);
            }
        }
    }

    static /* synthetic */ void lambda$notifyValueChanged$2(DataReceivedCallback dataReceivedCallback, BluetoothDevice bluetoothDevice, Data data) {
        try {
            dataReceivedCallback.onDataReceived(bluetoothDevice, data);
        } catch (Throwable th) {
            Log.e(TAG, "Exception in Value callback", th);
        }
    }

    boolean isComplete() {
        return this.complete;
    }
}
