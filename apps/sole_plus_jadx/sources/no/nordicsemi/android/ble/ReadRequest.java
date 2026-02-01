package no.nordicsemi.android.ble;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.os.Handler;
import android.util.Log;
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
public final class ReadRequest extends SimpleValueRequest<DataReceivedCallback> implements Operation {
    private DataStream buffer;
    private boolean complete;
    private int count;
    private DataMerger dataMerger;
    private DataFilter filter;
    private PacketFilter packetFilter;
    private ReadProgressCallback progressCallback;

    ReadRequest(Request.Type type) {
        super(type);
        this.count = 0;
        this.complete = false;
    }

    ReadRequest(Request.Type type, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(type, bluetoothGattCharacteristic);
        this.count = 0;
        this.complete = false;
    }

    ReadRequest(Request.Type type, BluetoothGattDescriptor bluetoothGattDescriptor) {
        super(type, bluetoothGattDescriptor);
        this.count = 0;
        this.complete = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // no.nordicsemi.android.ble.Request
    public ReadRequest setRequestHandler(RequestHandler requestHandler) {
        super.setRequestHandler(requestHandler);
        return this;
    }

    @Override // no.nordicsemi.android.ble.Request
    public ReadRequest setHandler(Handler handler) {
        super.setHandler(handler);
        return this;
    }

    @Override // no.nordicsemi.android.ble.Request
    public ReadRequest done(SuccessCallback successCallback) {
        super.done(successCallback);
        return this;
    }

    @Override // no.nordicsemi.android.ble.Request
    public ReadRequest fail(FailCallback failCallback) {
        super.fail(failCallback);
        return this;
    }

    @Override // no.nordicsemi.android.ble.Request
    public ReadRequest invalid(InvalidRequestCallback invalidRequestCallback) {
        super.invalid(invalidRequestCallback);
        return this;
    }

    @Override // no.nordicsemi.android.ble.Request
    public ReadRequest before(BeforeCallback beforeCallback) {
        super.before(beforeCallback);
        return this;
    }

    @Override // no.nordicsemi.android.ble.Request
    public ReadRequest then(AfterCallback afterCallback) {
        super.then(afterCallback);
        return this;
    }

    @Override // no.nordicsemi.android.ble.SimpleValueRequest
    public ReadRequest with(DataReceivedCallback dataReceivedCallback) {
        super.with((ReadRequest) dataReceivedCallback);
        return this;
    }

    public ReadRequest filter(DataFilter dataFilter) {
        this.filter = dataFilter;
        return this;
    }

    public ReadRequest filterPacket(PacketFilter packetFilter) {
        this.packetFilter = packetFilter;
        return this;
    }

    public ReadRequest merge(DataMerger dataMerger) {
        this.dataMerger = dataMerger;
        this.progressCallback = null;
        return this;
    }

    public ReadRequest merge(DataMerger dataMerger, ReadProgressCallback readProgressCallback) {
        this.dataMerger = dataMerger;
        this.progressCallback = readProgressCallback;
        return this;
    }

    public <E extends ProfileReadResponse> E awaitValid(Class<E> cls) throws InvalidDataException, DeviceDisconnectedException, RequestFailedException, InvalidRequestException, BluetoothDisabledException {
        E e = (E) await((Class) cls);
        if (e.isValid()) {
            return e;
        }
        throw new InvalidDataException(e);
    }

    public <E extends ProfileReadResponse> E awaitValid(E e) throws InvalidDataException, DeviceDisconnectedException, RequestFailedException, InvalidRequestException, BluetoothDisabledException {
        await((ReadRequest) e);
        if (e.isValid()) {
            return e;
        }
        throw new InvalidDataException(e);
    }

    boolean matches(byte[] bArr) {
        DataFilter dataFilter = this.filter;
        return dataFilter == null || dataFilter.filter(bArr);
    }

    void notifyValueChanged(final BluetoothDevice bluetoothDevice, final byte[] bArr) {
        final DataReceivedCallback dataReceivedCallback = (DataReceivedCallback) this.valueCallback;
        if (dataReceivedCallback == null) {
            PacketFilter packetFilter = this.packetFilter;
            if (packetFilter == null || packetFilter.filter(bArr)) {
                this.complete = true;
                return;
            }
            return;
        }
        if (this.dataMerger == null) {
            this.complete = true;
            final Data data = new Data(bArr);
            this.handler.post(new Runnable() { // from class: no.nordicsemi.android.ble.ReadRequest$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ReadRequest.lambda$notifyValueChanged$0(dataReceivedCallback, bluetoothDevice, data);
                }
            });
            return;
        }
        final int i = this.count;
        this.handler.post(new Runnable() { // from class: no.nordicsemi.android.ble.ReadRequest$$ExternalSyntheticLambda1
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
            PacketFilter packetFilter2 = this.packetFilter;
            if (packetFilter2 == null || packetFilter2.filter(byteArray)) {
                this.complete = true;
                final Data data2 = new Data(byteArray);
                this.handler.post(new Runnable() { // from class: no.nordicsemi.android.ble.ReadRequest$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        ReadRequest.lambda$notifyValueChanged$2(dataReceivedCallback, bluetoothDevice, data2);
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

    boolean hasMore() {
        return !this.complete;
    }
}
