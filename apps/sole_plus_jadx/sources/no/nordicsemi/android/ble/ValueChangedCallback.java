package no.nordicsemi.android.ble;

import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import android.util.Log;
import no.nordicsemi.android.ble.callback.ClosedCallback;
import no.nordicsemi.android.ble.callback.DataReceivedCallback;
import no.nordicsemi.android.ble.callback.ReadProgressCallback;
import no.nordicsemi.android.ble.data.Data;
import no.nordicsemi.android.ble.data.DataFilter;
import no.nordicsemi.android.ble.data.DataMerger;
import no.nordicsemi.android.ble.data.DataStream;
import no.nordicsemi.android.ble.data.PacketFilter;

/* loaded from: classes6.dex */
public class ValueChangedCallback {
    private static final String TAG = "ValueChangedCallback";
    private DataStream buffer;
    private ClosedCallback closedCallback;
    private int count = 0;
    private DataMerger dataMerger;
    private DataFilter filter;
    private CallbackHandler handler;
    private PacketFilter packetFilter;
    private ReadProgressCallback progressCallback;
    private DataReceivedCallback valueCallback;

    ValueChangedCallback(CallbackHandler callbackHandler) {
        this.handler = callbackHandler;
    }

    public ValueChangedCallback setHandler(final Handler handler) {
        this.handler = new CallbackHandler() { // from class: no.nordicsemi.android.ble.ValueChangedCallback.1
            @Override // no.nordicsemi.android.ble.CallbackHandler
            public void postDelayed(Runnable runnable, long j) {
            }

            @Override // no.nordicsemi.android.ble.CallbackHandler
            public void removeCallbacks(Runnable runnable) {
            }

            @Override // no.nordicsemi.android.ble.CallbackHandler
            public void post(Runnable runnable) {
                Handler handler2 = handler;
                if (handler2 != null) {
                    handler2.post(runnable);
                } else {
                    runnable.run();
                }
            }
        };
        return this;
    }

    public ValueChangedCallback with(DataReceivedCallback dataReceivedCallback) {
        this.valueCallback = dataReceivedCallback;
        return this;
    }

    public ValueChangedCallback filter(DataFilter dataFilter) {
        this.filter = dataFilter;
        return this;
    }

    public ValueChangedCallback filterPacket(PacketFilter packetFilter) {
        this.packetFilter = packetFilter;
        return this;
    }

    public ValueChangedCallback merge(DataMerger dataMerger) {
        this.dataMerger = dataMerger;
        this.progressCallback = null;
        return this;
    }

    public ValueChangedCallback merge(DataMerger dataMerger, ReadProgressCallback readProgressCallback) {
        this.dataMerger = dataMerger;
        this.progressCallback = readProgressCallback;
        return this;
    }

    public ValueChangedCallback then(ClosedCallback closedCallback) {
        this.closedCallback = closedCallback;
        return this;
    }

    boolean matches(byte[] bArr) {
        DataFilter dataFilter = this.filter;
        return dataFilter == null || dataFilter.filter(bArr);
    }

    void notifyValueChanged(final BluetoothDevice bluetoothDevice, final byte[] bArr) {
        PacketFilter packetFilter;
        final DataReceivedCallback dataReceivedCallback = this.valueCallback;
        if (dataReceivedCallback == null) {
            return;
        }
        if (this.dataMerger == null && ((packetFilter = this.packetFilter) == null || packetFilter.filter(bArr))) {
            final Data data = new Data(bArr);
            this.handler.post(new Runnable() { // from class: no.nordicsemi.android.ble.ValueChangedCallback$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ValueChangedCallback.lambda$notifyValueChanged$0(dataReceivedCallback, bluetoothDevice, data);
                }
            });
            return;
        }
        final int i = this.count;
        this.handler.post(new Runnable() { // from class: no.nordicsemi.android.ble.ValueChangedCallback$$ExternalSyntheticLambda1
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
                final Data data2 = new Data(byteArray);
                this.handler.post(new Runnable() { // from class: no.nordicsemi.android.ble.ValueChangedCallback$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        ValueChangedCallback.lambda$notifyValueChanged$2(dataReceivedCallback, bluetoothDevice, data2);
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

    void notifyClosed() {
        ClosedCallback closedCallback = this.closedCallback;
        if (closedCallback != null) {
            try {
                closedCallback.onClosed();
            } catch (Throwable th) {
                Log.e(TAG, "Exception in Closed callback", th);
            }
        }
        free();
    }

    private void free() {
        this.closedCallback = null;
        this.valueCallback = null;
        this.dataMerger = null;
        this.progressCallback = null;
        this.filter = null;
        this.packetFilter = null;
        this.buffer = null;
        this.count = 0;
    }
}
