package no.nordicsemi.android.ble;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.os.Handler;
import android.util.Log;
import java.util.Arrays;
import no.nordicsemi.android.ble.Request;
import no.nordicsemi.android.ble.callback.AfterCallback;
import no.nordicsemi.android.ble.callback.BeforeCallback;
import no.nordicsemi.android.ble.callback.DataSentCallback;
import no.nordicsemi.android.ble.callback.FailCallback;
import no.nordicsemi.android.ble.callback.InvalidRequestCallback;
import no.nordicsemi.android.ble.callback.SuccessCallback;
import no.nordicsemi.android.ble.callback.WriteProgressCallback;
import no.nordicsemi.android.ble.data.Data;
import no.nordicsemi.android.ble.data.DataSplitter;
import no.nordicsemi.android.ble.data.DefaultMtuSplitter;

/* loaded from: classes6.dex */
public final class WriteRequest extends SimpleValueRequest<DataSentCallback> implements Operation {
    private static final DataSplitter MTU_SPLITTER = new DefaultMtuSplitter();
    private boolean complete;
    private int count;
    private byte[] currentChunk;
    private final byte[] data;
    private DataSplitter dataSplitter;
    private byte[] nextChunk;
    private WriteProgressCallback progressCallback;
    private final int writeType;

    WriteRequest(Request.Type type) {
        this(type, null);
    }

    WriteRequest(Request.Type type, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(type, bluetoothGattCharacteristic);
        this.count = 0;
        this.data = null;
        this.writeType = 0;
        this.complete = true;
    }

    WriteRequest(Request.Type type, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, int i, int i2, int i3) {
        super(type, bluetoothGattCharacteristic);
        this.count = 0;
        this.complete = false;
        this.data = Bytes.copy(bArr, i, i2);
        this.writeType = i3;
    }

    WriteRequest(Request.Type type, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, int i, int i2) {
        super(type, bluetoothGattCharacteristic);
        this.count = 0;
        this.complete = false;
        this.data = Bytes.copy(bArr, i, i2);
        this.writeType = 0;
    }

    WriteRequest(Request.Type type, BluetoothGattDescriptor bluetoothGattDescriptor, byte[] bArr, int i, int i2) {
        super(type, bluetoothGattDescriptor);
        this.count = 0;
        this.complete = false;
        this.data = Bytes.copy(bArr, i, i2);
        this.writeType = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // no.nordicsemi.android.ble.Request
    public WriteRequest setRequestHandler(RequestHandler requestHandler) {
        super.setRequestHandler(requestHandler);
        return this;
    }

    @Override // no.nordicsemi.android.ble.Request
    public WriteRequest setHandler(Handler handler) {
        super.setHandler(handler);
        return this;
    }

    @Override // no.nordicsemi.android.ble.Request
    public WriteRequest done(SuccessCallback successCallback) {
        super.done(successCallback);
        return this;
    }

    @Override // no.nordicsemi.android.ble.Request
    public WriteRequest fail(FailCallback failCallback) {
        super.fail(failCallback);
        return this;
    }

    @Override // no.nordicsemi.android.ble.Request
    public WriteRequest invalid(InvalidRequestCallback invalidRequestCallback) {
        super.invalid(invalidRequestCallback);
        return this;
    }

    @Override // no.nordicsemi.android.ble.Request
    public WriteRequest before(BeforeCallback beforeCallback) {
        super.before(beforeCallback);
        return this;
    }

    @Override // no.nordicsemi.android.ble.Request
    public WriteRequest then(AfterCallback afterCallback) {
        super.then(afterCallback);
        return this;
    }

    @Override // no.nordicsemi.android.ble.SimpleValueRequest
    public WriteRequest with(DataSentCallback dataSentCallback) {
        super.with((WriteRequest) dataSentCallback);
        return this;
    }

    public WriteRequest split(DataSplitter dataSplitter) {
        this.dataSplitter = dataSplitter;
        this.progressCallback = null;
        return this;
    }

    public WriteRequest split(DataSplitter dataSplitter, WriteProgressCallback writeProgressCallback) {
        this.dataSplitter = dataSplitter;
        this.progressCallback = writeProgressCallback;
        return this;
    }

    public WriteRequest split() {
        this.dataSplitter = MTU_SPLITTER;
        this.progressCallback = null;
        return this;
    }

    public WriteRequest split(WriteProgressCallback writeProgressCallback) {
        this.dataSplitter = MTU_SPLITTER;
        this.progressCallback = writeProgressCallback;
        return this;
    }

    void forceSplit() {
        if (this.dataSplitter == null) {
            split();
        }
    }

    byte[] getData(int i) {
        byte[] bArr;
        DataSplitter dataSplitter = this.dataSplitter;
        if (dataSplitter == null || (bArr = this.data) == null) {
            this.complete = true;
            byte[] bArr2 = this.data;
            this.currentChunk = bArr2;
            return bArr2 != null ? bArr2 : new byte[0];
        }
        int i2 = this.writeType != 4 ? i - 3 : i - 12;
        byte[] bArrChunk = this.nextChunk;
        if (bArrChunk == null) {
            bArrChunk = dataSplitter.chunk(bArr, this.count, i2);
        }
        if (bArrChunk != null) {
            this.nextChunk = this.dataSplitter.chunk(this.data, this.count + 1, i2);
        }
        if (this.nextChunk == null) {
            this.complete = true;
        }
        this.currentChunk = bArrChunk;
        return bArrChunk != null ? bArrChunk : new byte[0];
    }

    boolean notifyPacketSent(final BluetoothDevice bluetoothDevice, byte[] bArr) {
        final int i = this.count;
        final byte[] bArr2 = this.currentChunk;
        this.handler.post(new Runnable() { // from class: no.nordicsemi.android.ble.WriteRequest$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$notifyPacketSent$0(bluetoothDevice, bArr2, i);
            }
        });
        this.count++;
        if (this.complete) {
            this.handler.post(new Runnable() { // from class: no.nordicsemi.android.ble.WriteRequest$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$notifyPacketSent$1(bluetoothDevice);
                }
            });
        }
        if (this.writeType == 2) {
            return Arrays.equals(bArr, bArr2);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyPacketSent$0(BluetoothDevice bluetoothDevice, byte[] bArr, int i) {
        WriteProgressCallback writeProgressCallback = this.progressCallback;
        if (writeProgressCallback != null) {
            try {
                writeProgressCallback.onPacketSent(bluetoothDevice, bArr, i);
            } catch (Throwable th) {
                Log.e(TAG, "Exception in Progress callback", th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyPacketSent$1(BluetoothDevice bluetoothDevice) {
        if (this.valueCallback != 0) {
            try {
                ((DataSentCallback) this.valueCallback).onDataSent(bluetoothDevice, new Data(this.data));
            } catch (Throwable th) {
                Log.e(TAG, "Exception in Value callback", th);
            }
        }
    }

    boolean hasMore() {
        return !this.complete;
    }

    int getWriteType() {
        return this.writeType;
    }
}
