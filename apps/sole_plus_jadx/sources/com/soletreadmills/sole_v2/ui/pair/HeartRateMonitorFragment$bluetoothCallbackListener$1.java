package com.soletreadmills.sole_v2.ui.pair;

import android.view.View;
import com.soletreadmills.sole_v2._data.ble.BleDeviceInfoData;
import com.soletreadmills.sole_v2.ble.data.FitnessMachineControlPointResponseData;
import com.soletreadmills.sole_v2.ble.type.FitnessMachineStatusType;
import com.soletreadmills.sole_v2.ble.type.TrainingStatusType;
import com.soletreadmills.sole_v2.databinding.FragmentHeartRateMonitorBinding;
import com.soletreadmills.sole_v2.listener.BluetoothCallbackListener;
import com.soletreadmills.sole_v2.ui.MainActivity;
import com.soletreadmills.sole_v2.ui._base.BaseActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import no.nordicsemi.android.support.v18.scanner.ScanResult;

/* compiled from: HeartRateMonitorFragment.kt */
@Metadata(d1 = {"\u0000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001c\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0003H\u0016J\u0018\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006!"}, d2 = {"com/soletreadmills/sole_v2/ui/pair/HeartRateMonitorFragment$bluetoothCallbackListener$1", "Lcom/soletreadmills/sole_v2/listener/BluetoothCallbackListener;", "onConnected", "", "deviceType", "Lcom/soletreadmills/sole_v2/listener/BluetoothCallbackListener$DeviceType;", "macAddress", "", "onConnecting", "onDisconnected", "onReceiveFitnessMachineControlPoint", "fitnessMachineControlPointResponseData", "Lcom/soletreadmills/sole_v2/ble/data/FitnessMachineControlPointResponseData;", "onReceiveFitnessMachineStatus", "fitnessMachineStatusType", "Lcom/soletreadmills/sole_v2/ble/type/FitnessMachineStatusType;", "onReceiveFtmsData", "ftmsData", "className", "onReceiveHrData", "hrDataJsonStr", "onReceiveSrvoData", "srvoData", "onReceiveTrainingStatus", "trainingStatusType", "Lcom/soletreadmills/sole_v2/ble/type/TrainingStatusType;", "onScan", "onScanResult", "callbackType", "", "scanResult", "Lno/nordicsemi/android/support/v18/scanner/ScanResult;", "onSrvoDeviceReady", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HeartRateMonitorFragment$bluetoothCallbackListener$1 implements BluetoothCallbackListener {
    final /* synthetic */ HeartRateMonitorFragment this$0;

    @Override // com.soletreadmills.sole_v2.listener.BluetoothCallbackListener
    public void onConnecting(BluetoothCallbackListener.DeviceType deviceType, String macAddress) {
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Intrinsics.checkNotNullParameter(macAddress, "macAddress");
    }

    @Override // com.soletreadmills.sole_v2.listener.BluetoothCallbackListener
    public void onReceiveFitnessMachineControlPoint(FitnessMachineControlPointResponseData fitnessMachineControlPointResponseData) {
    }

    @Override // com.soletreadmills.sole_v2.listener.BluetoothCallbackListener
    public void onReceiveFitnessMachineStatus(FitnessMachineStatusType fitnessMachineStatusType) {
    }

    @Override // com.soletreadmills.sole_v2.listener.BluetoothCallbackListener
    public void onReceiveFtmsData(String ftmsData, String className) {
    }

    @Override // com.soletreadmills.sole_v2.listener.BluetoothCallbackListener
    public void onReceiveHrData(String hrDataJsonStr) {
    }

    @Override // com.soletreadmills.sole_v2.listener.BluetoothCallbackListener
    public void onReceiveSrvoData(String srvoData, String className) {
    }

    @Override // com.soletreadmills.sole_v2.listener.BluetoothCallbackListener
    public void onReceiveTrainingStatus(TrainingStatusType trainingStatusType) {
    }

    @Override // com.soletreadmills.sole_v2.listener.BluetoothCallbackListener
    public void onScan() {
    }

    @Override // com.soletreadmills.sole_v2.listener.BluetoothCallbackListener
    public void onScanResult(int callbackType, ScanResult scanResult) {
        Intrinsics.checkNotNullParameter(scanResult, "scanResult");
    }

    @Override // com.soletreadmills.sole_v2.listener.BluetoothCallbackListener
    public void onSrvoDeviceReady(String macAddress) {
        Intrinsics.checkNotNullParameter(macAddress, "macAddress");
    }

    HeartRateMonitorFragment$bluetoothCallbackListener$1(HeartRateMonitorFragment heartRateMonitorFragment) {
        this.this$0 = heartRateMonitorFragment;
    }

    @Override // com.soletreadmills.sole_v2.listener.BluetoothCallbackListener
    public void onConnected(BluetoothCallbackListener.DeviceType deviceType, String macAddress) {
        FragmentHeartRateMonitorBinding binding;
        View root;
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Intrinsics.checkNotNullParameter(macAddress, "macAddress");
        BleDeviceInfoData connectFtmsBleDeviceInfoData = this.this$0.getConnectFtmsBleDeviceInfoData();
        if (!Intrinsics.areEqual(connectFtmsBleDeviceInfoData != null ? connectFtmsBleDeviceInfoData.getAddress() : null, macAddress) || (binding = this.this$0.getBinding()) == null || (root = binding.getRoot()) == null) {
            return;
        }
        final HeartRateMonitorFragment heartRateMonitorFragment = this.this$0;
        root.post(new Runnable() { // from class: com.soletreadmills.sole_v2.ui.pair.HeartRateMonitorFragment$bluetoothCallbackListener$1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() throws CloneNotSupportedException {
                HeartRateMonitorFragment$bluetoothCallbackListener$1.onConnected$lambda$0(heartRateMonitorFragment);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onConnected$lambda$0(HeartRateMonitorFragment this$0) throws CloneNotSupportedException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainActivity mainActivity = this$0.getMainActivity();
        if (mainActivity != null) {
            MainActivity mainActivity2 = mainActivity;
            BleDeviceInfoData connectFtmsBleDeviceInfoData = this$0.getConnectFtmsBleDeviceInfoData();
            BaseActivity.showPairingDialog$default(mainActivity2, 1, connectFtmsBleDeviceInfoData != null ? connectFtmsBleDeviceInfoData.getName() : null, null, 4, null);
        }
        this$0.setRecyclerview();
    }

    @Override // com.soletreadmills.sole_v2.listener.BluetoothCallbackListener
    public void onDisconnected(BluetoothCallbackListener.DeviceType deviceType, String macAddress) {
        FragmentHeartRateMonitorBinding binding;
        View root;
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Intrinsics.checkNotNullParameter(macAddress, "macAddress");
        BleDeviceInfoData connectFtmsBleDeviceInfoData = this.this$0.getConnectFtmsBleDeviceInfoData();
        if (!Intrinsics.areEqual(connectFtmsBleDeviceInfoData != null ? connectFtmsBleDeviceInfoData.getAddress() : null, macAddress) || (binding = this.this$0.getBinding()) == null || (root = binding.getRoot()) == null) {
            return;
        }
        final HeartRateMonitorFragment heartRateMonitorFragment = this.this$0;
        root.postDelayed(new Runnable() { // from class: com.soletreadmills.sole_v2.ui.pair.HeartRateMonitorFragment$bluetoothCallbackListener$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() throws CloneNotSupportedException {
                HeartRateMonitorFragment$bluetoothCallbackListener$1.onDisconnected$lambda$1(heartRateMonitorFragment);
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onDisconnected$lambda$1(HeartRateMonitorFragment this$0) throws CloneNotSupportedException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setRecyclerview();
    }
}
