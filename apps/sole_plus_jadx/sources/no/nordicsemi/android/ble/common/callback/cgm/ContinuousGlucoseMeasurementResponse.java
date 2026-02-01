package no.nordicsemi.android.ble.common.callback.cgm;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import no.nordicsemi.android.ble.common.profile.cgm.CGMTypes;
import no.nordicsemi.android.ble.data.Data;

/* loaded from: classes6.dex */
public final class ContinuousGlucoseMeasurementResponse extends ContinuousGlucoseMeasurementDataCallback implements CRCSecuredResponse, Parcelable {
    public static final Parcelable.Creator<ContinuousGlucoseMeasurementResponse> CREATOR = new Parcelable.Creator<ContinuousGlucoseMeasurementResponse>() { // from class: no.nordicsemi.android.ble.common.callback.cgm.ContinuousGlucoseMeasurementResponse.1
        @Override // android.os.Parcelable.Creator
        public ContinuousGlucoseMeasurementResponse createFromParcel(Parcel parcel) {
            return new ContinuousGlucoseMeasurementResponse(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ContinuousGlucoseMeasurementResponse[] newArray(int i) {
            return new ContinuousGlucoseMeasurementResponse[i];
        }
    };
    private boolean crcValid;
    private final ArrayList<ContinuousGlucoseMeasurementResponseItem> items;
    private boolean secured;

    public ContinuousGlucoseMeasurementResponse() {
        this.items = new ArrayList<>();
    }

    @Override // no.nordicsemi.android.ble.common.profile.cgm.ContinuousGlucoseMeasurementCallback
    public void onContinuousGlucoseMeasurementReceived(BluetoothDevice bluetoothDevice, float f, Float f2, Float f3, CGMTypes.CGMStatus cGMStatus, int i, boolean z) {
        this.items.add(new ContinuousGlucoseMeasurementResponseItem(f, f2, f3, cGMStatus, i));
        this.secured = z;
    }

    @Override // no.nordicsemi.android.ble.common.profile.cgm.ContinuousGlucoseMeasurementCallback
    public void onContinuousGlucoseMeasurementReceivedWithCrcError(BluetoothDevice bluetoothDevice, Data data) {
        onInvalidDataReceived(bluetoothDevice, data);
        this.secured = true;
        this.crcValid = false;
    }

    private ContinuousGlucoseMeasurementResponse(Parcel parcel) {
        super(parcel);
        ArrayList<ContinuousGlucoseMeasurementResponseItem> arrayList = new ArrayList<>();
        this.items = arrayList;
        parcel.readList(arrayList, ContinuousGlucoseMeasurementResponseItem.class.getClassLoader());
        this.secured = parcel.readByte() != 0;
        this.crcValid = parcel.readByte() != 0;
    }

    @Override // no.nordicsemi.android.ble.callback.profile.ProfileReadResponse, no.nordicsemi.android.ble.response.ReadResponse, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeList(this.items);
        parcel.writeByte(this.secured ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.crcValid ? (byte) 1 : (byte) 0);
    }

    public ArrayList<ContinuousGlucoseMeasurementResponseItem> getItems() {
        return this.items;
    }

    @Override // no.nordicsemi.android.ble.common.callback.cgm.CRCSecuredResponse
    public boolean isSecured() {
        return this.secured;
    }

    @Override // no.nordicsemi.android.ble.common.callback.cgm.CRCSecuredResponse
    public boolean isCrcValid() {
        return this.crcValid;
    }
}
