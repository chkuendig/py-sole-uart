package com.soletreadmills.sole_v2.ui.displayMode;

import android.view.View;
import com.google.gson.Gson;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._extension.CustomDialogKt;
import com.soletreadmills.sole_v2.ble.code.FitnessMachineControlPointOpCode;
import com.soletreadmills.sole_v2.ble.code.FitnessMachineControlPointResultCode;
import com.soletreadmills.sole_v2.ble.data.FitnessMachineControlPointResponseData;
import com.soletreadmills.sole_v2.ble.data.FtmsBaseData;
import com.soletreadmills.sole_v2.ble.manager.BleDataManager;
import com.soletreadmills.sole_v2.ble.type.FitnessMachineStatusType;
import com.soletreadmills.sole_v2.ble.type.TrainingStatusType;
import com.soletreadmills.sole_v2.databinding.FragmentDisplayDashboardBinding;
import com.soletreadmills.sole_v2.listener.BluetoothCallbackListener;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import java.lang.reflect.Type;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import no.nordicsemi.android.support.v18.scanner.ScanResult;
import timber.log.Timber;

/* compiled from: DisplayDashboardFragment.kt */
@Metadata(d1 = {"\u0000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001c\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0003H\u0016J\u0018\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006!"}, d2 = {"com/soletreadmills/sole_v2/ui/displayMode/DisplayDashboardFragment$bluetoothCallbackListener$1", "Lcom/soletreadmills/sole_v2/listener/BluetoothCallbackListener;", "onConnected", "", "deviceType", "Lcom/soletreadmills/sole_v2/listener/BluetoothCallbackListener$DeviceType;", "macAddress", "", "onConnecting", "onDisconnected", "onReceiveFitnessMachineControlPoint", "fitnessMachineControlPointResponseData", "Lcom/soletreadmills/sole_v2/ble/data/FitnessMachineControlPointResponseData;", "onReceiveFitnessMachineStatus", "fitnessMachineStatusType", "Lcom/soletreadmills/sole_v2/ble/type/FitnessMachineStatusType;", "onReceiveFtmsData", "ftmsDataJsonStr", "className", "onReceiveHrData", "hrDataJsonStr", "onReceiveSrvoData", "srvoData", "onReceiveTrainingStatus", "trainingStatusType", "Lcom/soletreadmills/sole_v2/ble/type/TrainingStatusType;", "onScan", "onScanResult", "callbackType", "", "scanResult", "Lno/nordicsemi/android/support/v18/scanner/ScanResult;", "onSrvoDeviceReady", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DisplayDashboardFragment$bluetoothCallbackListener$1 implements BluetoothCallbackListener {
    final /* synthetic */ DisplayDashboardFragment this$0;

    @Override // com.soletreadmills.sole_v2.listener.BluetoothCallbackListener
    public void onReceiveHrData(String hrDataJsonStr) {
    }

    @Override // com.soletreadmills.sole_v2.listener.BluetoothCallbackListener
    public void onReceiveSrvoData(String srvoData, String className) {
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

    DisplayDashboardFragment$bluetoothCallbackListener$1(DisplayDashboardFragment displayDashboardFragment) {
        this.this$0 = displayDashboardFragment;
    }

    @Override // com.soletreadmills.sole_v2.listener.BluetoothCallbackListener
    public void onConnected(BluetoothCallbackListener.DeviceType deviceType, String macAddress) {
        View root;
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Intrinsics.checkNotNullParameter(macAddress, "macAddress");
        FragmentDisplayDashboardBinding binding = this.this$0.getBinding();
        if (binding == null || (root = binding.getRoot()) == null) {
            return;
        }
        final DisplayDashboardFragment displayDashboardFragment = this.this$0;
        root.post(new Runnable() { // from class: com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardFragment$bluetoothCallbackListener$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                DisplayDashboardFragment$bluetoothCallbackListener$1.onConnected$lambda$0(displayDashboardFragment);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onConnected$lambda$0(DisplayDashboardFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setBlueToothConnectStatus();
        this$0.setControlPanel();
        this$0.setFinishBackBtn();
    }

    @Override // com.soletreadmills.sole_v2.listener.BluetoothCallbackListener
    public void onDisconnected(final BluetoothCallbackListener.DeviceType deviceType, String macAddress) {
        View root;
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Intrinsics.checkNotNullParameter(macAddress, "macAddress");
        Timber.INSTANCE.d("aaa-onDisconnected1" + deviceType, new Object[0]);
        Timber.INSTANCE.d("aaa-onDisconnected2" + (deviceType == BluetoothCallbackListener.DeviceType.FTMS), new Object[0]);
        FragmentDisplayDashboardBinding binding = this.this$0.getBinding();
        if (binding == null || (root = binding.getRoot()) == null) {
            return;
        }
        final DisplayDashboardFragment displayDashboardFragment = this.this$0;
        root.post(new Runnable() { // from class: com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardFragment$bluetoothCallbackListener$1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                DisplayDashboardFragment$bluetoothCallbackListener$1.onDisconnected$lambda$1(displayDashboardFragment, deviceType);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onDisconnected$lambda$1(final DisplayDashboardFragment this$0, BluetoothCallbackListener.DeviceType deviceType) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(deviceType, "$deviceType");
        this$0.setBlueToothConnectStatus();
        this$0.setControlPanel();
        this$0.setFinishBackBtn();
        if (deviceType == BluetoothCallbackListener.DeviceType.FTMS) {
            this$0.getViewModel().clearAllStat();
            CustomDialogKt.showCustomDialog$default(this$0, null, this$0.getString(R.string.bluetooth_disconnected), this$0.getString(R.string.got_it), null, new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardFragment$bluetoothCallbackListener$1$onDisconnected$1$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    BaseFragment.safeNavigateAndClearStack$default(this$0, R.id.homeMainFragment, null, 2, null);
                }
            }, null, false, 41, null);
        }
    }

    @Override // com.soletreadmills.sole_v2.listener.BluetoothCallbackListener
    public void onConnecting(BluetoothCallbackListener.DeviceType deviceType, String macAddress) {
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Intrinsics.checkNotNullParameter(macAddress, "macAddress");
        Timber.INSTANCE.d("aaa-onConnecting" + deviceType, new Object[0]);
    }

    @Override // com.soletreadmills.sole_v2.listener.BluetoothCallbackListener
    public void onReceiveFtmsData(String ftmsDataJsonStr, String className) throws ClassNotFoundException {
        Class<?> cls;
        if (className == null || ftmsDataJsonStr == null || this.this$0.getBinding() == null) {
            Timber.INSTANCE.d("onReceiveFtmsData className/ftmsDataJsonStr/binding null", new Object[0]);
            return;
        }
        if (this.this$0.getIsFinish()) {
            Timber.INSTANCE.d("isFinish", new Object[0]);
            return;
        }
        FtmsBaseData ftmsBaseData = null;
        try {
            cls = Class.forName(className);
        } catch (Exception e) {
            e.printStackTrace();
            cls = null;
        }
        try {
            ftmsBaseData = (FtmsBaseData) new Gson().fromJson(ftmsDataJsonStr, (Type) cls);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.this$0.setOldFtmsData(ftmsBaseData);
        if (ftmsBaseData != null) {
            ArrayList<FtmsBaseData> nowFtmsDataArrayList = BleDataManager.getInstance().getNowFtmsDataArrayList();
            Intrinsics.checkNotNullExpressionValue(nowFtmsDataArrayList, "getNowFtmsDataArrayList(...)");
            FtmsBaseData ftmsBaseData2 = (FtmsBaseData) CollectionsKt.lastOrNull(CollectionsKt.toList(nowFtmsDataArrayList));
            if (ftmsBaseData2 != null) {
                this.this$0.getViewModel().setFtmsData(this.this$0.getMachineType(), ftmsBaseData2);
            } else {
                Timber.INSTANCE.d("latestData null", new Object[0]);
            }
        }
    }

    @Override // com.soletreadmills.sole_v2.listener.BluetoothCallbackListener
    public void onReceiveTrainingStatus(TrainingStatusType trainingStatusType) {
        if (this.this$0.getIsOnStart()) {
            this.this$0.showStart(trainingStatusType);
        }
    }

    @Override // com.soletreadmills.sole_v2.listener.BluetoothCallbackListener
    public void onReceiveFitnessMachineStatus(FitnessMachineStatusType fitnessMachineStatusType) {
        FitnessMachineStatusType nowFMSTypeOnlyFourType;
        if (fitnessMachineStatusType == null || (nowFMSTypeOnlyFourType = BleDataManager.getInstance().getNowFMSTypeOnlyFourType()) == null) {
            return;
        }
        if (this.this$0.getIsOnStart()) {
            Timber.INSTANCE.d("onReceiveFitnessMachineStatus-isOnStart", new Object[0]);
            this.this$0.showStart(BleDataManager.getInstance().getNowTrainingStatusType());
            this.this$0.showPaused(nowFMSTypeOnlyFourType);
            this.this$0.showIdle(BleDataManager.getInstance().getNowTrainingStatusType());
            if (nowFMSTypeOnlyFourType == FitnessMachineStatusType.FITNESS_MACHINE_STOPPED_BY_THE_USER) {
                Timber.INSTANCE.d("onReceiveFitnessMachineStatus-isOnStart_FITNESS_MACHINE_STOPPED_BY_THE_USER", new Object[0]);
                BleDataManager.getInstance().uploadSummaryData();
                this.this$0.getViewModel().resetFtmsData();
                this.this$0.safeNavigateUp();
                return;
            }
            return;
        }
        if (nowFMSTypeOnlyFourType == FitnessMachineStatusType.FITNESS_MACHINE_STOPPED_BY_THE_USER || nowFMSTypeOnlyFourType == FitnessMachineStatusType.FITNESS_MACHINE_PAUSED_BY_THE_USER) {
            return;
        }
        Timber.INSTANCE.d("onReceiveFitnessMachineStatus-isOnStart else", new Object[0]);
        this.this$0.setControlPanel();
    }

    @Override // com.soletreadmills.sole_v2.listener.BluetoothCallbackListener
    public void onReceiveFitnessMachineControlPoint(FitnessMachineControlPointResponseData fitnessMachineControlPointResponseData) {
        if ((fitnessMachineControlPointResponseData != null ? fitnessMachineControlPointResponseData.getOpCodeType() : null) == FitnessMachineControlPointOpCode.Type.START_OR_RESUME && fitnessMachineControlPointResponseData.getResultCodeType() == FitnessMachineControlPointResultCode.Type.SUCCESS) {
            Timber.INSTANCE.d("onReceiveFitnessMachineControlPoint2", new Object[0]);
            this.this$0.setControlPanel();
        }
    }
}
