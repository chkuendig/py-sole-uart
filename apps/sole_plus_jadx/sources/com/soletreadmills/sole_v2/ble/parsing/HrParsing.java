package com.soletreadmills.sole_v2.ble.parsing;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.core.app.ActivityCompat;
import com.soletreadmills.sole_v2.ble.BleUuid;
import com.soletreadmills.sole_v2.ble.data.HrData;
import no.nordicsemi.android.ble.data.Data;

/* loaded from: classes5.dex */
public class HrParsing {
    private static final String TAG = "HrParsing";

    public static HrData parsingData(Context context, final BluetoothDevice bluetoothDevice, final Data data, final BluetoothGattCharacteristic heartRateMeasurementCharacteristic) {
        int i;
        String str = TAG;
        Log.d(str, "parsingData data=" + data.toString());
        HrData hrData = null;
        if (heartRateMeasurementCharacteristic != null && heartRateMeasurementCharacteristic.getUuid() != null) {
            if (heartRateMeasurementCharacteristic.getUuid().equals(BleUuid.UUID_HEART_RATE_MEASUREMENT)) {
                Log.d(str, "parsingData -> characteristic=HEART_RATE_MEASUREMENT Data");
                if ((heartRateMeasurementCharacteristic.getProperties() & 1) != 0) {
                    Log.d(str, "Heart rate format UINT16.");
                    i = 18;
                } else {
                    Log.d(str, "Heart rate format UINT8.");
                    i = 17;
                }
                int iIntValue = data.getIntValue(i, 1).intValue();
                if (iIntValue > 0 && iIntValue <= 300) {
                    hrData = new HrData();
                    hrData.setHr(Integer.valueOf(iIntValue));
                }
            }
            if (hrData != null) {
                hrData.setMacAddress(bluetoothDevice.getAddress());
                if ((Build.VERSION.SDK_INT < 31 || ActivityCompat.checkSelfPermission(context, "android.permission.BLUETOOTH_CONNECT") == 0) && bluetoothDevice.getName() != null) {
                    hrData.setModelCode(bluetoothDevice.getName());
                }
            }
            if (hrData != null) {
                Log.d(str, "parsingData hrData=" + hrData.toString());
            }
        }
        return hrData;
    }
}
