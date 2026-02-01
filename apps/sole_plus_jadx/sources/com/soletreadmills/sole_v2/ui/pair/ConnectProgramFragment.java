package com.soletreadmills.sole_v2.ui.pair;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.android.SdkConstants;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.samsung.android.sdk.healthdata.HealthConstants;
import com.soletreadmills.sole_v2.Global;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.ble.BleDeviceInfoData;
import com.soletreadmills.sole_v2._data.login.LoginUserData;
import com.soletreadmills.sole_v2._manager.BleManager;
import com.soletreadmills.sole_v2._type.ConnectProgramNameType;
import com.soletreadmills.sole_v2._type.ConnectProgramSettingsType;
import com.soletreadmills.sole_v2._type.ConnectProgramType;
import com.soletreadmills.sole_v2.ble.cmd.FitnessMachineControlPointCmd;
import com.soletreadmills.sole_v2.ble.code.FitnessMachineControlPointOpCode;
import com.soletreadmills.sole_v2.ble.code.FitnessMachineControlPointResultCode;
import com.soletreadmills.sole_v2.ble.data.FitnessMachineControlPointResponseData;
import com.soletreadmills.sole_v2.ble.manager.BleDataManager;
import com.soletreadmills.sole_v2.ble.type.BleFtmsMachineType;
import com.soletreadmills.sole_v2.ble.type.FitnessMachineStatusType;
import com.soletreadmills.sole_v2.ble.type.TrainingStatusType;
import com.soletreadmills.sole_v2.databinding.CustomProgramSliderviewBinding;
import com.soletreadmills.sole_v2.databinding.FragmentConnectProgramBinding;
import com.soletreadmills.sole_v2.listener.BluetoothCallbackListener;
import com.soletreadmills.sole_v2.ui.MainActivity;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import com.soletreadmills.sole_v2.ui.widget.MultiLayerBarChartView;
import com.sun.jna.platform.win32.WinError;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import no.nordicsemi.android.ble.data.Data;
import no.nordicsemi.android.support.v18.scanner.ScanResult;
import timber.log.Timber;

/* compiled from: ConnectProgramFragment.kt */
@Metadata(d1 = {"\u0000\u008b\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000*\u0001\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J>\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u0002072\u0006\u0010N\u001a\u0002072\u0006\u0010O\u001a\u0002052\u0006\u0010P\u001a\u0002052\u0006\u0010Q\u001a\u0002052\u0006\u0010R\u001a\u0002052\u0006\u0010S\u001a\u000204J\u0010\u0010T\u001a\u00020L2\u0006\u0010U\u001a\u000201H\u0002J\b\u0010V\u001a\u00020LH\u0002J\u0006\u0010W\u001a\u00020LJ\u0015\u0010X\u001a\u0004\u0018\u0001052\u0006\u0010E\u001a\u000204¢\u0006\u0002\u0010YJ\u001a\u0010Z\u001a\u00020\u00022\u0006\u0010[\u001a\u00020\\2\b\u0010]\u001a\u0004\u0018\u00010^H\u0016J\b\u0010_\u001a\u00020LH\u0016J\u0012\u0010`\u001a\u00020L2\b\u0010a\u001a\u0004\u0018\u00010bH\u0016J\b\u0010c\u001a\u00020LH\u0016J\b\u0010d\u001a\u00020LH\u0016J\u0006\u0010e\u001a\u00020LJ\b\u0010f\u001a\u00020LH\u0002J\u0006\u0010g\u001a\u00020LJ\b\u0010h\u001a\u00020LH\u0002J\u0018\u0010i\u001a\u00020L2\u0006\u0010j\u001a\u00020F2\u0006\u0010:\u001a\u00020;H\u0002J\u0010\u0010k\u001a\u00020L2\u0006\u0010j\u001a\u00020FH\u0002J\u0012\u0010l\u001a\u00020L2\b\u0010m\u001a\u0004\u0018\u00010nH\u0002R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001a\u0010\u0018\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R\u001a\u0010\u001b\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\u001a\u0010\u001e\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011R\u001a\u0010!\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u000f\"\u0004\b#\u0010\u0011R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001b\u0010*\u001a\u00020+8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b,\u0010-R\u000e\u00100\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00102\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020503X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u00106\u001a\u0002078F¢\u0006\u0006\u001a\u0004\b8\u00109R\u001c\u0010:\u001a\u0004\u0018\u00010;X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001a\u0010@\u001a\u000201X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001c\u0010E\u001a\u0004\u0018\u00010FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010J¨\u0006o"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/pair/ConnectProgramFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/databinding/FragmentConnectProgramBinding;", "Landroid/view/View$OnClickListener;", "()V", "bluetoothCallbackListener", "com/soletreadmills/sole_v2/ui/pair/ConnectProgramFragment$bluetoothCallbackListener$1", "Lcom/soletreadmills/sole_v2/ui/pair/ConnectProgramFragment$bluetoothCallbackListener$1;", "cancelLoadingRunnable", "Ljava/lang/Runnable;", "getCancelLoadingRunnable", "()Ljava/lang/Runnable;", "checkE1", "", "getCheckE1", "()Z", "setCheckE1", "(Z)V", "checkE2", "getCheckE2", "setCheckE2", "checkE3", "getCheckE3", "setCheckE3", "checkE4", "getCheckE4", "setCheckE4", "checkE5", "getCheckE5", "setCheckE5", "checkE6", "getCheckE6", "setCheckE6", "checkE7", "getCheckE7", "setCheckE7", "connectFtmsBleDeviceInfoData", "Lcom/soletreadmills/sole_v2/_data/ble/BleDeviceInfoData;", "getConnectFtmsBleDeviceInfoData", "()Lcom/soletreadmills/sole_v2/_data/ble/BleDeviceInfoData;", "setConnectFtmsBleDeviceInfoData", "(Lcom/soletreadmills/sole_v2/_data/ble/BleDeviceInfoData;)V", "connectProgramViewModel", "Lcom/soletreadmills/sole_v2/ui/pair/ConnectProgramViewModel;", "getConnectProgramViewModel$app_release", "()Lcom/soletreadmills/sole_v2/ui/pair/ConnectProgramViewModel;", "connectProgramViewModel$delegate", "Lkotlin/Lazy;", "currentCollapseMode", "", "currentTargetValues", "", "Lcom/soletreadmills/sole_v2/_type/ConnectProgramSettingsType;", "", "hr", "", "getHr", "()Ljava/lang/String;", "machineType", "Lcom/soletreadmills/sole_v2/ble/type/BleFtmsMachineType;", "getMachineType", "()Lcom/soletreadmills/sole_v2/ble/type/BleFtmsMachineType;", "setMachineType", "(Lcom/soletreadmills/sole_v2/ble/type/BleFtmsMachineType;)V", "selectMaxHR", "getSelectMaxHR", "()I", "setSelectMaxHR", "(I)V", "type", "Lcom/soletreadmills/sole_v2/_type/ConnectProgramNameType;", "getType", "()Lcom/soletreadmills/sole_v2/_type/ConnectProgramNameType;", "setType", "(Lcom/soletreadmills/sole_v2/_type/ConnectProgramNameType;)V", "addCustomTarget", "", "name", HealthConstants.FoodIntake.UNIT, "maxValue", "minValue", "step", "value", "connectProgramSettingsType", "changeCollapseMode", "collapseMode", "changeSelectMaxHRView", "checkAllStatus", "getTargetValue", "(Lcom/soletreadmills/sole_v2/_type/ConnectProgramSettingsType;)Ljava/lang/Double;", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", SdkConstants.ATTR_ON_CLICK, "v", "Landroid/view/View;", "onDestroyView", "onResume", "reSetBoolean", "sendCmdToMachine", "setBarChatCustom", "setView", "setupBarChart", "nameType", "setupHeartRateView", "showDisplayBoard", "trainingStatusType", "Lcom/soletreadmills/sole_v2/ble/type/TrainingStatusType;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ConnectProgramFragment extends BaseFragment<FragmentConnectProgramBinding> implements View.OnClickListener {
    public static final int $stable = 8;
    private boolean checkE1;
    private boolean checkE2;
    private boolean checkE3;
    private boolean checkE4;
    private boolean checkE5;
    private boolean checkE6;
    private boolean checkE7;
    private BleDeviceInfoData connectFtmsBleDeviceInfoData;

    /* renamed from: connectProgramViewModel$delegate, reason: from kotlin metadata */
    private final Lazy connectProgramViewModel;
    private BleFtmsMachineType machineType;
    private int selectMaxHR;
    private ConnectProgramNameType type;
    private int currentCollapseMode = 2;
    private final Map<ConnectProgramSettingsType, Double> currentTargetValues = new LinkedHashMap();
    private final ConnectProgramFragment$bluetoothCallbackListener$1 bluetoothCallbackListener = new BluetoothCallbackListener() { // from class: com.soletreadmills.sole_v2.ui.pair.ConnectProgramFragment$bluetoothCallbackListener$1

        /* compiled from: ConnectProgramFragment.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;
            public static final /* synthetic */ int[] $EnumSwitchMapping$1;

            static {
                int[] iArr = new int[BleFtmsMachineType.values().length];
                try {
                    iArr[BleFtmsMachineType.TREADMILL.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[BleFtmsMachineType.BIKE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[BleFtmsMachineType.ELLIPTICAL.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
                int[] iArr2 = new int[ConnectProgramNameType.values().length];
                try {
                    iArr2[ConnectProgramNameType.Manual.ordinal()] = 1;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr2[ConnectProgramNameType.HeartRate.ordinal()] = 2;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr2[ConnectProgramNameType.Hill.ordinal()] = 3;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr2[ConnectProgramNameType.Fatburn.ordinal()] = 4;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    iArr2[ConnectProgramNameType.Cardio.ordinal()] = 5;
                } catch (NoSuchFieldError unused8) {
                }
                try {
                    iArr2[ConnectProgramNameType.Strength.ordinal()] = 6;
                } catch (NoSuchFieldError unused9) {
                }
                try {
                    iArr2[ConnectProgramNameType.Interval.ordinal()] = 7;
                } catch (NoSuchFieldError unused10) {
                }
                try {
                    iArr2[ConnectProgramNameType.Custom.ordinal()] = 8;
                } catch (NoSuchFieldError unused11) {
                }
                $EnumSwitchMapping$1 = iArr2;
            }
        }

        @Override // com.soletreadmills.sole_v2.listener.BluetoothCallbackListener
        public void onConnected(BluetoothCallbackListener.DeviceType deviceType, String macAddress) {
            Intrinsics.checkNotNullParameter(deviceType, "deviceType");
            Intrinsics.checkNotNullParameter(macAddress, "macAddress");
        }

        @Override // com.soletreadmills.sole_v2.listener.BluetoothCallbackListener
        public void onConnecting(BluetoothCallbackListener.DeviceType deviceType, String macAddress) {
            Intrinsics.checkNotNullParameter(deviceType, "deviceType");
            Intrinsics.checkNotNullParameter(macAddress, "macAddress");
        }

        @Override // com.soletreadmills.sole_v2.listener.BluetoothCallbackListener
        public void onDisconnected(BluetoothCallbackListener.DeviceType deviceType, String macAddress) {
            Intrinsics.checkNotNullParameter(deviceType, "deviceType");
            Intrinsics.checkNotNullParameter(macAddress, "macAddress");
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
        public void onScan() {
        }

        @Override // com.soletreadmills.sole_v2.listener.BluetoothCallbackListener
        public void onSrvoDeviceReady(String macAddress) {
            Intrinsics.checkNotNullParameter(macAddress, "macAddress");
        }

        @Override // com.soletreadmills.sole_v2.listener.BluetoothCallbackListener
        public void onScanResult(int callbackType, ScanResult scanResult) {
            Intrinsics.checkNotNullParameter(scanResult, "scanResult");
            Timber.INSTANCE.e("scanResult:%s", scanResult);
        }

        @Override // com.soletreadmills.sole_v2.listener.BluetoothCallbackListener
        public void onReceiveTrainingStatus(TrainingStatusType trainingStatusType) {
            this.this$0.showDisplayBoard(trainingStatusType);
        }

        @Override // com.soletreadmills.sole_v2.listener.BluetoothCallbackListener
        public void onReceiveFitnessMachineStatus(FitnessMachineStatusType fitnessMachineStatusType) {
            Timber.INSTANCE.e("fitnessMachineStatusType:%s", fitnessMachineStatusType != null ? fitnessMachineStatusType.name() : null);
        }

        @Override // com.soletreadmills.sole_v2.listener.BluetoothCallbackListener
        public void onReceiveFitnessMachineControlPoint(FitnessMachineControlPointResponseData fitnessMachineControlPointResponseData) {
            FitnessMachineControlPointOpCode.Type opCodeType;
            String strName;
            FitnessMachineControlPointOpCode.Type opCodeType2;
            String strName2;
            FitnessMachineControlPointOpCode.Type opCodeType3;
            String strName3;
            FitnessMachineControlPointOpCode.Type opCodeType4;
            String strName4;
            FitnessMachineControlPointOpCode.Type opCodeType5;
            String strName5;
            FitnessMachineControlPointOpCode.Type opCodeType6;
            String strName6;
            FitnessMachineControlPointOpCode.Type opCodeType7;
            String strName7;
            FitnessMachineControlPointOpCode.Type opCodeType8;
            String strName8;
            FitnessMachineControlPointOpCode.Type opCodeType9;
            String strName9;
            FitnessMachineControlPointOpCode.Type opCodeType10;
            String strName10;
            FitnessMachineControlPointOpCode.Type opCodeType11;
            String strName11;
            Timber.INSTANCE.e("fitnessMachineControlPointResponseData test:%s", fitnessMachineControlPointResponseData != null ? fitnessMachineControlPointResponseData.toString() : null);
            if ((fitnessMachineControlPointResponseData != null ? fitnessMachineControlPointResponseData.getResultCodeType() : null) != FitnessMachineControlPointResultCode.Type.SUCCESS) {
                this.this$0.stopLoading();
            }
            ConnectProgramNameType type = this.this$0.getType();
            switch (type == null ? -1 : WhenMappings.$EnumSwitchMapping$1[type.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    if (fitnessMachineControlPointResponseData != null && (opCodeType = fitnessMachineControlPointResponseData.getOpCodeType()) != null && (strName = opCodeType.name()) != null && StringsKt.contains$default((CharSequence) strName, (CharSequence) "E1", false, 2, (Object) null)) {
                        this.this$0.stopLoading();
                        BaseFragment.safeNavigateWithPopUp$default(this.this$0, R.id.displayDashboardFragment, R.id.connectedPageFragment, false, null, 8, null);
                        break;
                    }
                    break;
                case 8:
                    BleFtmsMachineType machineType = this.this$0.getMachineType();
                    int i = machineType != null ? WhenMappings.$EnumSwitchMapping$0[machineType.ordinal()] : -1;
                    if (i == 1) {
                        if (fitnessMachineControlPointResponseData != null && (opCodeType6 = fitnessMachineControlPointResponseData.getOpCodeType()) != null && (strName6 = opCodeType6.name()) != null && StringsKt.contains$default((CharSequence) strName6, (CharSequence) "E1", false, 2, (Object) null)) {
                            this.this$0.setCheckE1(true);
                        }
                        if (fitnessMachineControlPointResponseData != null && (opCodeType5 = fitnessMachineControlPointResponseData.getOpCodeType()) != null && (strName5 = opCodeType5.name()) != null && StringsKt.contains$default((CharSequence) strName5, (CharSequence) "E2", false, 2, (Object) null)) {
                            this.this$0.setCheckE2(true);
                        }
                        if (fitnessMachineControlPointResponseData != null && (opCodeType4 = fitnessMachineControlPointResponseData.getOpCodeType()) != null && (strName4 = opCodeType4.name()) != null && StringsKt.contains$default((CharSequence) strName4, (CharSequence) "E3", false, 2, (Object) null)) {
                            this.this$0.setCheckE3(true);
                        }
                        if (fitnessMachineControlPointResponseData != null && (opCodeType3 = fitnessMachineControlPointResponseData.getOpCodeType()) != null && (strName3 = opCodeType3.name()) != null && StringsKt.contains$default((CharSequence) strName3, (CharSequence) "E4", false, 2, (Object) null)) {
                            this.this$0.setCheckE4(true);
                        }
                        if (fitnessMachineControlPointResponseData != null && (opCodeType2 = fitnessMachineControlPointResponseData.getOpCodeType()) != null && (strName2 = opCodeType2.name()) != null && StringsKt.contains$default((CharSequence) strName2, (CharSequence) "E5", false, 2, (Object) null)) {
                            this.this$0.setCheckE5(true);
                        }
                    } else if (i == 2 || i == 3) {
                        if (fitnessMachineControlPointResponseData != null && (opCodeType11 = fitnessMachineControlPointResponseData.getOpCodeType()) != null && (strName11 = opCodeType11.name()) != null && StringsKt.contains$default((CharSequence) strName11, (CharSequence) "E1", false, 2, (Object) null)) {
                            this.this$0.setCheckE1(true);
                        }
                        if (fitnessMachineControlPointResponseData != null && (opCodeType10 = fitnessMachineControlPointResponseData.getOpCodeType()) != null && (strName10 = opCodeType10.name()) != null && StringsKt.contains$default((CharSequence) strName10, (CharSequence) "E4", false, 2, (Object) null)) {
                            this.this$0.setCheckE4(true);
                        }
                        if (fitnessMachineControlPointResponseData != null && (opCodeType9 = fitnessMachineControlPointResponseData.getOpCodeType()) != null && (strName9 = opCodeType9.name()) != null && StringsKt.contains$default((CharSequence) strName9, (CharSequence) "E5", false, 2, (Object) null)) {
                            this.this$0.setCheckE5(true);
                        }
                        if (fitnessMachineControlPointResponseData != null && (opCodeType8 = fitnessMachineControlPointResponseData.getOpCodeType()) != null && (strName8 = opCodeType8.name()) != null && StringsKt.contains$default((CharSequence) strName8, (CharSequence) "E6", false, 2, (Object) null)) {
                            this.this$0.setCheckE6(true);
                        }
                        if (fitnessMachineControlPointResponseData != null && (opCodeType7 = fitnessMachineControlPointResponseData.getOpCodeType()) != null && (strName7 = opCodeType7.name()) != null && StringsKt.contains$default((CharSequence) strName7, (CharSequence) "E7", false, 2, (Object) null)) {
                            this.this$0.setCheckE7(true);
                        }
                    }
                    this.this$0.checkAllStatus();
                    break;
            }
        }
    };
    private final Runnable cancelLoadingRunnable = new Runnable() { // from class: com.soletreadmills.sole_v2.ui.pair.ConnectProgramFragment$$ExternalSyntheticLambda1
        @Override // java.lang.Runnable
        public final void run() {
            ConnectProgramFragment.cancelLoadingRunnable$lambda$1(this.f$0);
        }
    };

    /* compiled from: ConnectProgramFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[BleFtmsMachineType.values().length];
            try {
                iArr[BleFtmsMachineType.TREADMILL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BleFtmsMachineType.BIKE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BleFtmsMachineType.ELLIPTICAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[BleFtmsMachineType.ROWER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[BleFtmsMachineType.STEPPER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ConnectProgramNameType.values().length];
            try {
                iArr2[ConnectProgramNameType.Manual.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[ConnectProgramNameType.HeartRate.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[ConnectProgramNameType.Hill.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[ConnectProgramNameType.Fatburn.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[ConnectProgramNameType.Cardio.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[ConnectProgramNameType.Strength.ordinal()] = 6;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[ConnectProgramNameType.Interval.ordinal()] = 7;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr2[ConnectProgramNameType.Custom.ordinal()] = 8;
            } catch (NoSuchFieldError unused13) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.soletreadmills.sole_v2.ui.pair.ConnectProgramFragment$bluetoothCallbackListener$1] */
    public ConnectProgramFragment() {
        final ConnectProgramFragment connectProgramFragment = this;
        final Function0 function0 = null;
        this.connectProgramViewModel = FragmentViewModelLazyKt.createViewModelLazy(connectProgramFragment, Reflection.getOrCreateKotlinClass(ConnectProgramViewModel.class), new Function0<ViewModelStore>() { // from class: com.soletreadmills.sole_v2.ui.pair.ConnectProgramFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = connectProgramFragment.requireActivity().getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: com.soletreadmills.sole_v2.ui.pair.ConnectProgramFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                if (function02 != null && (creationExtras = (CreationExtras) function02.invoke()) != null) {
                    return creationExtras;
                }
                CreationExtras defaultViewModelCreationExtras = connectProgramFragment.requireActivity().getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.soletreadmills.sole_v2.ui.pair.ConnectProgramFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = connectProgramFragment.requireActivity().getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    public final ConnectProgramViewModel getConnectProgramViewModel$app_release() {
        return (ConnectProgramViewModel) this.connectProgramViewModel.getValue();
    }

    public final BleDeviceInfoData getConnectFtmsBleDeviceInfoData() {
        return this.connectFtmsBleDeviceInfoData;
    }

    public final void setConnectFtmsBleDeviceInfoData(BleDeviceInfoData bleDeviceInfoData) {
        this.connectFtmsBleDeviceInfoData = bleDeviceInfoData;
    }

    public final BleFtmsMachineType getMachineType() {
        return this.machineType;
    }

    public final void setMachineType(BleFtmsMachineType bleFtmsMachineType) {
        this.machineType = bleFtmsMachineType;
    }

    public final ConnectProgramNameType getType() {
        return this.type;
    }

    public final void setType(ConnectProgramNameType connectProgramNameType) {
        this.type = connectProgramNameType;
    }

    public final int getSelectMaxHR() {
        return this.selectMaxHR;
    }

    public final void setSelectMaxHR(int i) {
        this.selectMaxHR = i;
    }

    public final boolean getCheckE1() {
        return this.checkE1;
    }

    public final void setCheckE1(boolean z) {
        this.checkE1 = z;
    }

    public final boolean getCheckE2() {
        return this.checkE2;
    }

    public final void setCheckE2(boolean z) {
        this.checkE2 = z;
    }

    public final boolean getCheckE3() {
        return this.checkE3;
    }

    public final void setCheckE3(boolean z) {
        this.checkE3 = z;
    }

    public final boolean getCheckE4() {
        return this.checkE4;
    }

    public final void setCheckE4(boolean z) {
        this.checkE4 = z;
    }

    public final boolean getCheckE5() {
        return this.checkE5;
    }

    public final void setCheckE5(boolean z) {
        this.checkE5 = z;
    }

    public final boolean getCheckE6() {
        return this.checkE6;
    }

    public final void setCheckE6(boolean z) {
        this.checkE6 = z;
    }

    public final boolean getCheckE7() {
        return this.checkE7;
    }

    public final void setCheckE7(boolean z) {
        this.checkE7 = z;
    }

    public final String getHr() {
        int i = 220 - Integer.parseInt(Global.INSTANCE.calculateAge());
        if (this.selectMaxHR == 1) {
            return String.valueOf((i * 80) / 100);
        }
        return String.valueOf((i * 60) / 100);
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        BleManager.getInstance().removeBluetoothCallbackListener(this.bluetoothCallbackListener);
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        setBarChatCustom();
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public FragmentConnectProgramBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentConnectProgramBinding fragmentConnectProgramBindingInflate = FragmentConnectProgramBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentConnectProgramBindingInflate, "inflate(...)");
        return fragmentConnectProgramBindingInflate;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public void initViews() {
        TextView textView;
        TextView textView2;
        LinearLayout linearLayout;
        TextView textView3;
        ImageView imageView;
        AppBarLayout appBarLayout;
        BleManager.getInstance().removeBluetoothCallbackListener(this.bluetoothCallbackListener);
        BleManager.getInstance().addBluetoothCallbackListener(this.bluetoothCallbackListener);
        FragmentConnectProgramBinding binding = getBinding();
        if (binding != null && (appBarLayout = binding.appBarLayout) != null) {
            appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.soletreadmills.sole_v2.ui.pair.ConnectProgramFragment$$ExternalSyntheticLambda0
                @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
                public final void onOffsetChanged(AppBarLayout appBarLayout2, int i) {
                    ConnectProgramFragment.initViews$lambda$0(this.f$0, appBarLayout2, i);
                }
            });
        }
        this.connectFtmsBleDeviceInfoData = BleManager.getInstance().getConnectFtmsBleDeviceInfoData();
        ConnectProgramNameType type = getConnectProgramViewModel$app_release().getType();
        if (type == null) {
            return;
        }
        this.type = type;
        BleFtmsMachineType machineType = getConnectProgramViewModel$app_release().getMachineType();
        if (machineType == null) {
            return;
        }
        this.machineType = machineType;
        FragmentConnectProgramBinding binding2 = getBinding();
        if (binding2 != null && (imageView = binding2.back) != null) {
            imageView.setOnClickListener(this);
        }
        FragmentConnectProgramBinding binding3 = getBinding();
        if (binding3 != null && (textView3 = binding3.edit) != null) {
            textView3.setOnClickListener(this);
        }
        FragmentConnectProgramBinding binding4 = getBinding();
        if (binding4 != null && (linearLayout = binding4.start) != null) {
            linearLayout.setOnClickListener(this);
        }
        FragmentConnectProgramBinding binding5 = getBinding();
        if (binding5 != null && (textView2 = binding5.tvMax60) != null) {
            textView2.setOnClickListener(this);
        }
        FragmentConnectProgramBinding binding6 = getBinding();
        if (binding6 != null && (textView = binding6.tvMax80) != null) {
            textView.setOnClickListener(this);
        }
        setView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$0(ConnectProgramFragment this$0, AppBarLayout appBarLayout, int i) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i2 = ((float) Math.abs(i)) / ((float) appBarLayout.getTotalScrollRange()) >= 0.85f ? 1 : 2;
        if (this$0.currentCollapseMode != i2) {
            this$0.changeCollapseMode(i2);
            this$0.currentCollapseMode = i2;
            if (i2 == 1) {
                FragmentConnectProgramBinding binding = this$0.getBinding();
                textView = binding != null ? binding.title : null;
                if (textView == null) {
                    return;
                }
                textView.setVisibility(0);
                return;
            }
            if (i2 != 2) {
                return;
            }
            FragmentConnectProgramBinding binding2 = this$0.getBinding();
            textView = binding2 != null ? binding2.title : null;
            if (textView == null) {
                return;
            }
            textView.setVisibility(4);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) throws NumberFormatException {
        Integer numValueOf = v != null ? Integer.valueOf(v.getId()) : null;
        int i = R.id.back;
        if (numValueOf != null && numValueOf.intValue() == i) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.onBackPressed();
                return;
            }
            return;
        }
        int i2 = R.id.edit;
        if (numValueOf != null && numValueOf.intValue() == i2) {
            BaseFragment.safeNavigate$default(this, R.id.connectEditProgramFragment, null, 2, null);
            return;
        }
        int i3 = R.id.start;
        if (numValueOf != null && numValueOf.intValue() == i3) {
            if (BleDataManager.getInstance().getNowTrainingStatusType() == TrainingStatusType.IDLE) {
                sendCmdToMachine();
                return;
            } else {
                if (BleDataManager.getInstance().getNowFitnessMachineStatusType() != FitnessMachineStatusType.FITNESS_MACHINE_STOPPED_BY_THE_USER) {
                    BaseFragment.safeNavigate$default(this, R.id.displayDashboardFragment, null, 2, null);
                    return;
                }
                return;
            }
        }
        int i4 = R.id.tv_max60;
        if (numValueOf != null && numValueOf.intValue() == i4) {
            this.selectMaxHR = 0;
            changeSelectMaxHRView();
            return;
        }
        int i5 = R.id.tv_max80;
        if (numValueOf != null && numValueOf.intValue() == i5) {
            this.selectMaxHR = 1;
            changeSelectMaxHRView();
        }
    }

    private final void changeCollapseMode(int collapseMode) {
        Toolbar toolbar;
        FragmentConnectProgramBinding binding = getBinding();
        ViewGroup.LayoutParams layoutParams = (binding == null || (toolbar = binding.collapsingToolbar) == null) ? null : toolbar.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.google.android.material.appbar.CollapsingToolbarLayout.LayoutParams");
        CollapsingToolbarLayout.LayoutParams layoutParams2 = (CollapsingToolbarLayout.LayoutParams) layoutParams;
        layoutParams2.setCollapseMode(collapseMode);
        FragmentConnectProgramBinding binding2 = getBinding();
        Toolbar toolbar2 = binding2 != null ? binding2.collapsingToolbar : null;
        if (toolbar2 == null) {
            return;
        }
        toolbar2.setLayoutParams(layoutParams2);
    }

    private final void setView() {
        BleFtmsMachineType bleFtmsMachineType;
        List<ConnectProgramSettingsType> list;
        Context context;
        LinearLayout linearLayout;
        ConnectProgramNameType connectProgramNameType = this.type;
        if (connectProgramNameType == null || (bleFtmsMachineType = this.machineType) == null || (list = connectProgramNameType.getEquipmentSettingsMap().get(bleFtmsMachineType)) == null || (context = getContext()) == null) {
            return;
        }
        FragmentConnectProgramBinding binding = getBinding();
        TextView textView = binding != null ? binding.tvProgramName : null;
        if (textView != null) {
            textView.setText(connectProgramNameType.getTitle(context));
        }
        FragmentConnectProgramBinding binding2 = getBinding();
        TextView textView2 = binding2 != null ? binding2.title : null;
        if (textView2 != null) {
            textView2.setText(connectProgramNameType.getTitle(context));
        }
        FragmentConnectProgramBinding binding3 = getBinding();
        TextView textView3 = binding3 != null ? binding3.tvMachineName : null;
        if (textView3 != null) {
            BleDeviceInfoData bleDeviceInfoData = this.connectFtmsBleDeviceInfoData;
            textView3.setText(bleDeviceInfoData != null ? bleDeviceInfoData.getName() : null);
        }
        setupBarChart(connectProgramNameType, bleFtmsMachineType);
        setupHeartRateView(connectProgramNameType);
        FragmentConnectProgramBinding binding4 = getBinding();
        if (binding4 != null && (linearLayout = binding4.LLTargetView) != null) {
            linearLayout.removeAllViews();
        }
        for (ConnectProgramSettingsType connectProgramSettingsType : list) {
            String string = context.getString(connectProgramSettingsType.getDisplayName());
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            addCustomTarget(string, connectProgramSettingsType.getUnit(), connectProgramSettingsType.getMaxValue(), connectProgramSettingsType.getMinValue(), connectProgramSettingsType.getStep(), connectProgramSettingsType.getDefaultValue(), connectProgramSettingsType);
        }
    }

    private final void setupBarChart(ConnectProgramNameType nameType, BleFtmsMachineType machineType) {
        ImageView imageView;
        MultiLayerBarChartView multiLayerBarChartView;
        MultiLayerBarChartView multiLayerBarChartView2;
        MultiLayerBarChartView multiLayerBarChartView3;
        MultiLayerBarChartView multiLayerBarChartView4;
        if (nameType.getType() == ConnectProgramType.Targets || nameType == ConnectProgramNameType.Manual) {
            FragmentConnectProgramBinding binding = getBinding();
            LinearLayout linearLayout = binding != null ? binding.LLBarchat : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            FragmentConnectProgramBinding binding2 = getBinding();
            LinearLayout linearLayout2 = binding2 != null ? binding2.LLTargetImg : null;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(0);
            }
            FragmentConnectProgramBinding binding3 = getBinding();
            if (binding3 == null || (imageView = binding3.img) == null) {
                return;
            }
            imageView.setImageResource(nameType.getDefaultIcon());
            return;
        }
        FragmentConnectProgramBinding binding4 = getBinding();
        LinearLayout linearLayout3 = binding4 != null ? binding4.LLBarchat : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(0);
        }
        FragmentConnectProgramBinding binding5 = getBinding();
        LinearLayout linearLayout4 = binding5 != null ? binding5.LLTargetImg : null;
        if (linearLayout4 != null) {
            linearLayout4.setVisibility(8);
        }
        if (nameType != ConnectProgramNameType.Custom) {
            FragmentConnectProgramBinding binding6 = getBinding();
            TextView textView = binding6 != null ? binding6.edit : null;
            if (textView != null) {
                textView.setVisibility(8);
            }
        }
        List<Integer> speedList = nameType.getSpeedList(machineType);
        List<Integer> resistList = nameType.getResistList(machineType);
        List<Integer> inclineList = nameType.getInclineList(machineType);
        int i = WhenMappings.$EnumSwitchMapping$0[machineType.ordinal()];
        if (i == 1) {
            FragmentConnectProgramBinding binding7 = getBinding();
            MultiLayerBarChartView multiLayerBarChartView5 = binding7 != null ? binding7.barChart : null;
            if (multiLayerBarChartView5 != null) {
                multiLayerBarChartView5.setMaxValueLayer2(100);
            }
            FragmentConnectProgramBinding binding8 = getBinding();
            MultiLayerBarChartView multiLayerBarChartView6 = binding8 != null ? binding8.barChart : null;
            if (multiLayerBarChartView6 != null) {
                multiLayerBarChartView6.setMaxValueLayer3(15);
            }
            FragmentConnectProgramBinding binding9 = getBinding();
            if (binding9 == null || (multiLayerBarChartView = binding9.barChart) == null) {
                return;
            }
            multiLayerBarChartView.setData(speedList, inclineList);
            return;
        }
        if (i == 2) {
            FragmentConnectProgramBinding binding10 = getBinding();
            MultiLayerBarChartView multiLayerBarChartView7 = binding10 != null ? binding10.barChart : null;
            if (multiLayerBarChartView7 != null) {
                multiLayerBarChartView7.setMaxValueLayer2(20);
            }
            FragmentConnectProgramBinding binding11 = getBinding();
            if (binding11 == null || (multiLayerBarChartView2 = binding11.barChart) == null) {
                return;
            }
            MultiLayerBarChartView.setData$default(multiLayerBarChartView2, resistList, null, 2, null);
            return;
        }
        if (i != 3) {
            if (i != 4) {
                return;
            }
            FragmentConnectProgramBinding binding12 = getBinding();
            MultiLayerBarChartView multiLayerBarChartView8 = binding12 != null ? binding12.barChart : null;
            if (multiLayerBarChartView8 != null) {
                multiLayerBarChartView8.setMaxValueLayer2(20);
            }
            FragmentConnectProgramBinding binding13 = getBinding();
            if (binding13 == null || (multiLayerBarChartView4 = binding13.barChart) == null) {
                return;
            }
            MultiLayerBarChartView.setData$default(multiLayerBarChartView4, resistList, null, 2, null);
            return;
        }
        FragmentConnectProgramBinding binding14 = getBinding();
        MultiLayerBarChartView multiLayerBarChartView9 = binding14 != null ? binding14.barChart : null;
        if (multiLayerBarChartView9 != null) {
            multiLayerBarChartView9.setMaxValueLayer2(20);
        }
        FragmentConnectProgramBinding binding15 = getBinding();
        MultiLayerBarChartView multiLayerBarChartView10 = binding15 != null ? binding15.barChart : null;
        if (multiLayerBarChartView10 != null) {
            multiLayerBarChartView10.setMaxValueLayer3(15);
        }
        FragmentConnectProgramBinding binding16 = getBinding();
        if (binding16 == null || (multiLayerBarChartView3 = binding16.barChart) == null) {
            return;
        }
        multiLayerBarChartView3.setData(resistList, inclineList);
    }

    private final void setupHeartRateView(ConnectProgramNameType nameType) {
        FragmentConnectProgramBinding binding = getBinding();
        ConstraintLayout constraintLayout = binding != null ? binding.CLTargetHeartRate : null;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(nameType == ConnectProgramNameType.HeartRate ? 0 : 8);
        }
        FragmentConnectProgramBinding binding2 = getBinding();
        TextView textView = binding2 != null ? binding2.value : null;
        if (textView == null) {
            return;
        }
        textView.setText(getHr());
    }

    private final void changeSelectMaxHRView() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        Context context = getContext();
        if (context == null) {
            return;
        }
        int i = this.selectMaxHR;
        if (i == 0) {
            FragmentConnectProgramBinding binding = getBinding();
            TextView textView5 = binding != null ? binding.tvMax60 : null;
            if (textView5 != null) {
                textView5.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_corner32_white));
            }
            FragmentConnectProgramBinding binding2 = getBinding();
            TextView textView6 = binding2 != null ? binding2.tvMax80 : null;
            if (textView6 != null) {
                textView6.setBackground(null);
            }
            FragmentConnectProgramBinding binding3 = getBinding();
            if (binding3 != null && (textView2 = binding3.tvMax60) != null) {
                textView2.setTextColor(ContextCompat.getColor(context, R.color.colorPalette_red));
            }
            FragmentConnectProgramBinding binding4 = getBinding();
            if (binding4 != null && (textView = binding4.tvMax80) != null) {
                textView.setTextColor(ContextCompat.getColor(context, R.color.colorLabel_label3));
            }
        } else if (i == 1) {
            FragmentConnectProgramBinding binding5 = getBinding();
            TextView textView7 = binding5 != null ? binding5.tvMax60 : null;
            if (textView7 != null) {
                textView7.setBackground(null);
            }
            FragmentConnectProgramBinding binding6 = getBinding();
            TextView textView8 = binding6 != null ? binding6.tvMax80 : null;
            if (textView8 != null) {
                textView8.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_corner32_white));
            }
            FragmentConnectProgramBinding binding7 = getBinding();
            if (binding7 != null && (textView4 = binding7.tvMax60) != null) {
                textView4.setTextColor(ContextCompat.getColor(context, R.color.colorLabel_label3));
            }
            FragmentConnectProgramBinding binding8 = getBinding();
            if (binding8 != null && (textView3 = binding8.tvMax80) != null) {
                textView3.setTextColor(ContextCompat.getColor(context, R.color.colorPalette_red));
            }
        }
        FragmentConnectProgramBinding binding9 = getBinding();
        TextView textView9 = binding9 != null ? binding9.value : null;
        if (textView9 == null) {
            return;
        }
        textView9.setText(getHr());
    }

    public final void addCustomTarget(String name, String unit, double maxValue, double minValue, double step, double value, final ConnectProgramSettingsType connectProgramSettingsType) {
        LinearLayout linearLayout;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(connectProgramSettingsType, "connectProgramSettingsType");
        try {
            LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
            FragmentConnectProgramBinding binding = getBinding();
            final CustomProgramSliderviewBinding customProgramSliderviewBindingInflate = CustomProgramSliderviewBinding.inflate(layoutInflaterFrom, binding != null ? binding.LLTargetView : null, false);
            Intrinsics.checkNotNullExpressionValue(customProgramSliderviewBindingInflate, "inflate(...)");
            customProgramSliderviewBindingInflate.name.setText(name);
            customProgramSliderviewBindingInflate.unit.setText(unit);
            customProgramSliderviewBindingInflate.value.setText(connectProgramSettingsType.displayValue(value));
            customProgramSliderviewBindingInflate.customSlider.setMinValue((float) minValue);
            customProgramSliderviewBindingInflate.customSlider.setMaxValue((float) maxValue);
            customProgramSliderviewBindingInflate.customSlider.setStep((float) step);
            customProgramSliderviewBindingInflate.customSlider.setCurrentValue((float) value);
            this.currentTargetValues.put(connectProgramSettingsType, Double.valueOf(value));
            customProgramSliderviewBindingInflate.customSlider.setOnValueChanged(new Function1<Float, Unit>() { // from class: com.soletreadmills.sole_v2.ui.pair.ConnectProgramFragment.addCustomTarget.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Float f) {
                    invoke(f.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(float f) {
                    double d = f;
                    customProgramSliderviewBindingInflate.value.setText(connectProgramSettingsType.displayValue(d));
                    this.currentTargetValues.put(connectProgramSettingsType, Double.valueOf(d));
                }
            });
            FragmentConnectProgramBinding binding2 = getBinding();
            if (binding2 == null || (linearLayout = binding2.LLTargetView) == null) {
                return;
            }
            linearLayout.addView(customProgramSliderviewBindingInflate.getRoot());
        } catch (Exception e) {
            Timber.INSTANCE.e(e);
        }
    }

    public final Double getTargetValue(ConnectProgramSettingsType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return this.currentTargetValues.get(type);
    }

    public final void setBarChatCustom() {
        BleFtmsMachineType machineType;
        MultiLayerBarChartView multiLayerBarChartView;
        FragmentConnectProgramBinding binding;
        MultiLayerBarChartView multiLayerBarChartView2;
        ConnectProgramNameType type = getConnectProgramViewModel$app_release().getType();
        if (type == null || (machineType = getConnectProgramViewModel$app_release().getMachineType()) == null || type != ConnectProgramNameType.Custom) {
            return;
        }
        List<Integer> speedOrLevelListGlobal = getConnectProgramViewModel$app_release().getSpeedOrLevelListGlobal();
        List<Integer> inclineProFileListGlobal = getConnectProgramViewModel$app_release().getInclineProFileListGlobal();
        int i = WhenMappings.$EnumSwitchMapping$0[machineType.ordinal()];
        if (i == 1) {
            FragmentConnectProgramBinding binding2 = getBinding();
            MultiLayerBarChartView multiLayerBarChartView3 = binding2 != null ? binding2.barChart : null;
            if (multiLayerBarChartView3 != null) {
                multiLayerBarChartView3.setMaxValueLayer2(100);
            }
            FragmentConnectProgramBinding binding3 = getBinding();
            multiLayerBarChartView = binding3 != null ? binding3.barChart : null;
            if (multiLayerBarChartView != null) {
                multiLayerBarChartView.setMaxValueLayer3(15);
            }
        } else if (i == 2) {
            FragmentConnectProgramBinding binding4 = getBinding();
            multiLayerBarChartView = binding4 != null ? binding4.barChart : null;
            if (multiLayerBarChartView != null) {
                multiLayerBarChartView.setMaxValueLayer2(20);
            }
        } else if (i == 3) {
            FragmentConnectProgramBinding binding5 = getBinding();
            MultiLayerBarChartView multiLayerBarChartView4 = binding5 != null ? binding5.barChart : null;
            if (multiLayerBarChartView4 != null) {
                multiLayerBarChartView4.setMaxValueLayer2(20);
            }
            FragmentConnectProgramBinding binding6 = getBinding();
            multiLayerBarChartView = binding6 != null ? binding6.barChart : null;
            if (multiLayerBarChartView != null) {
                multiLayerBarChartView.setMaxValueLayer3(15);
            }
        } else if (i == 4) {
            FragmentConnectProgramBinding binding7 = getBinding();
            multiLayerBarChartView = binding7 != null ? binding7.barChart : null;
            if (multiLayerBarChartView != null) {
                multiLayerBarChartView.setMaxValueLayer2(20);
            }
        }
        if (speedOrLevelListGlobal.size() <= 0 || inclineProFileListGlobal.size() <= 0 || (binding = getBinding()) == null || (multiLayerBarChartView2 = binding.barChart) == null) {
            return;
        }
        multiLayerBarChartView2.setData(speedOrLevelListGlobal, inclineProFileListGlobal);
    }

    private final void sendCmdToMachine() throws NumberFormatException {
        BleFtmsMachineType bleFtmsMachineType;
        String weight;
        View root;
        View root2;
        View root3;
        View root4;
        ConnectProgramNameType connectProgramNameType = this.type;
        if (connectProgramNameType == null || (bleFtmsMachineType = this.machineType) == null) {
            return;
        }
        int i = Integer.parseInt(Global.INSTANCE.calculateAge());
        LoginUserData loginUserData = Global.userData;
        if (loginUserData == null || (weight = loginUserData.getWeight()) == null) {
            weight = "60";
        }
        int i2 = (int) Float.parseFloat(weight);
        Double targetValue = getTargetValue(ConnectProgramSettingsType.TargetTime);
        int iDoubleValue = targetValue != null ? (int) targetValue.doubleValue() : 20;
        Double targetValue2 = getTargetValue(ConnectProgramSettingsType.MaxSpeed);
        float fDoubleValue = targetValue2 != null ? (float) targetValue2.doubleValue() : 5.0f;
        Double targetValue3 = getTargetValue(ConnectProgramSettingsType.MaxResistance);
        int iDoubleValue2 = targetValue3 != null ? (int) targetValue3.doubleValue() : 1;
        int i3 = WhenMappings.$EnumSwitchMapping$0[bleFtmsMachineType.ordinal()];
        if (i3 == 1) {
            switch (WhenMappings.$EnumSwitchMapping$1[connectProgramNameType.ordinal()]) {
                case 1:
                    BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new C09931(FitnessMachineControlPointCmd.setE1ProgramCmd(Integer.valueOf(i), Integer.valueOf(i2), connectProgramNameType, Integer.valueOf(iDoubleValue), null, null, null, null, null, null), null), 2, null);
                    break;
                case 2:
                    BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new AnonymousClass2(FitnessMachineControlPointCmd.setE1ProgramCmd(Integer.valueOf(i), Integer.valueOf(i2), connectProgramNameType, Integer.valueOf(iDoubleValue), null, null, null, null, null, Integer.valueOf(Integer.parseInt(getHr()))), null), 2, null);
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new AnonymousClass3(FitnessMachineControlPointCmd.setE1ProgramCmd(Integer.valueOf(i), Integer.valueOf(i2), connectProgramNameType, Integer.valueOf(iDoubleValue), Float.valueOf(fDoubleValue), null, null, null, null, null), null), 2, null);
                    break;
                case 8:
                    showLoading();
                    FragmentConnectProgramBinding binding = getBinding();
                    if (binding != null && (root2 = binding.getRoot()) != null) {
                        root2.removeCallbacks(this.cancelLoadingRunnable);
                    }
                    FragmentConnectProgramBinding binding2 = getBinding();
                    if (binding2 != null && (root = binding2.getRoot()) != null) {
                        root.postDelayed(this.cancelLoadingRunnable, 5000L);
                    }
                    reSetBoolean();
                    BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new AnonymousClass4(FitnessMachineControlPointCmd.setE1ProgramCmd(Integer.valueOf(i), Integer.valueOf(i2), connectProgramNameType, Integer.valueOf(iDoubleValue), Float.valueOf(fDoubleValue), null, CollectionsKt.toList(getConnectProgramViewModel$app_release().getSpeedOrLevelListGlobal()), CollectionsKt.toList(getConnectProgramViewModel$app_release().getInclineProFileListGlobal()), null, null), null), 2, null);
                    break;
            }
        }
        if (i3 == 2 || i3 == 3) {
            switch (WhenMappings.$EnumSwitchMapping$1[connectProgramNameType.ordinal()]) {
                case 1:
                    BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new AnonymousClass5(FitnessMachineControlPointCmd.setE1ProgramCmd(Integer.valueOf(i), Integer.valueOf(i2), connectProgramNameType, Integer.valueOf(iDoubleValue), null, null, null, null, null, null), null), 2, null);
                    break;
                case 2:
                    BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new AnonymousClass6(FitnessMachineControlPointCmd.setE1ProgramCmd(Integer.valueOf(i), Integer.valueOf(i2), connectProgramNameType, Integer.valueOf(iDoubleValue), null, null, null, null, null, Integer.valueOf(Integer.parseInt(getHr()))), null), 2, null);
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new AnonymousClass7(FitnessMachineControlPointCmd.setE1ProgramCmd(Integer.valueOf(i), Integer.valueOf(i2), connectProgramNameType, Integer.valueOf(iDoubleValue), null, Integer.valueOf(iDoubleValue2), null, null, null, null), null), 2, null);
                    break;
                case 8:
                    showLoading();
                    FragmentConnectProgramBinding binding3 = getBinding();
                    if (binding3 != null && (root4 = binding3.getRoot()) != null) {
                        root4.removeCallbacks(this.cancelLoadingRunnable);
                    }
                    FragmentConnectProgramBinding binding4 = getBinding();
                    if (binding4 != null && (root3 = binding4.getRoot()) != null) {
                        root3.postDelayed(this.cancelLoadingRunnable, 5000L);
                    }
                    reSetBoolean();
                    BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new AnonymousClass8(FitnessMachineControlPointCmd.setE1ProgramCmd(Integer.valueOf(i), Integer.valueOf(i2), connectProgramNameType, Integer.valueOf(iDoubleValue), Float.valueOf(fDoubleValue), null, null, CollectionsKt.toList(getConnectProgramViewModel$app_release().getInclineProFileListGlobal()), CollectionsKt.toList(getConnectProgramViewModel$app_release().getSpeedOrLevelListGlobal()), null), null), 2, null);
                    break;
            }
        }
    }

    /* compiled from: ConnectProgramFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.pair.ConnectProgramFragment$sendCmdToMachine$1", f = "ConnectProgramFragment.kt", i = {0}, l = {429}, m = "invokeSuspend", n = {"cmd"}, s = {"L$1"})
    /* renamed from: com.soletreadmills.sole_v2.ui.pair.ConnectProgramFragment$sendCmdToMachine$1, reason: invalid class name and case insensitive filesystem */
    static final class C09931 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ArrayList<Data> $dataList;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09931(ArrayList<Data> arrayList, Continuation<? super C09931> continuation) {
            super(2, continuation);
            this.$dataList = arrayList;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C09931(this.$dataList, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09931) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0050  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0045 -> B:14:0x0048). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r6.label
                r2 = 1
                if (r1 == 0) goto L1f
                if (r1 != r2) goto L17
                java.lang.Object r1 = r6.L$1
                no.nordicsemi.android.ble.data.Data r1 = (no.nordicsemi.android.ble.data.Data) r1
                java.lang.Object r3 = r6.L$0
                java.util.Iterator r3 = (java.util.Iterator) r3
                kotlin.ResultKt.throwOnFailure(r7)
                goto L48
            L17:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1f:
                kotlin.ResultKt.throwOnFailure(r7)
                java.util.ArrayList<no.nordicsemi.android.ble.data.Data> r7 = r6.$dataList
                java.util.Iterator r7 = r7.iterator()
                r3 = r7
            L29:
                boolean r7 = r3.hasNext()
                if (r7 == 0) goto L50
                java.lang.Object r7 = r3.next()
                r1 = r7
                no.nordicsemi.android.ble.data.Data r1 = (no.nordicsemi.android.ble.data.Data) r1
                r7 = r6
                kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
                r6.L$0 = r3
                r6.L$1 = r1
                r6.label = r2
                r4 = 200(0xc8, double:9.9E-322)
                java.lang.Object r7 = kotlinx.coroutines.DelayKt.delay(r4, r7)
                if (r7 != r0) goto L48
                return r0
            L48:
                com.soletreadmills.sole_v2._manager.BleManager r7 = com.soletreadmills.sole_v2._manager.BleManager.getInstance()
                r7.sendCmdFtms(r1)
                goto L29
            L50:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.pair.ConnectProgramFragment.C09931.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: ConnectProgramFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.pair.ConnectProgramFragment$sendCmdToMachine$2", f = "ConnectProgramFragment.kt", i = {0}, l = {453}, m = "invokeSuspend", n = {"cmd"}, s = {"L$1"})
    /* renamed from: com.soletreadmills.sole_v2.ui.pair.ConnectProgramFragment$sendCmdToMachine$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ArrayList<Data> $dataList;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ArrayList<Data> arrayList, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$dataList = arrayList;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$dataList, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0050  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0045 -> B:14:0x0048). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r6.label
                r2 = 1
                if (r1 == 0) goto L1f
                if (r1 != r2) goto L17
                java.lang.Object r1 = r6.L$1
                no.nordicsemi.android.ble.data.Data r1 = (no.nordicsemi.android.ble.data.Data) r1
                java.lang.Object r3 = r6.L$0
                java.util.Iterator r3 = (java.util.Iterator) r3
                kotlin.ResultKt.throwOnFailure(r7)
                goto L48
            L17:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1f:
                kotlin.ResultKt.throwOnFailure(r7)
                java.util.ArrayList<no.nordicsemi.android.ble.data.Data> r7 = r6.$dataList
                java.util.Iterator r7 = r7.iterator()
                r3 = r7
            L29:
                boolean r7 = r3.hasNext()
                if (r7 == 0) goto L50
                java.lang.Object r7 = r3.next()
                r1 = r7
                no.nordicsemi.android.ble.data.Data r1 = (no.nordicsemi.android.ble.data.Data) r1
                r7 = r6
                kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
                r6.L$0 = r3
                r6.L$1 = r1
                r6.label = r2
                r4 = 200(0xc8, double:9.9E-322)
                java.lang.Object r7 = kotlinx.coroutines.DelayKt.delay(r4, r7)
                if (r7 != r0) goto L48
                return r0
            L48:
                com.soletreadmills.sole_v2._manager.BleManager r7 = com.soletreadmills.sole_v2._manager.BleManager.getInstance()
                r7.sendCmdFtms(r1)
                goto L29
            L50:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.pair.ConnectProgramFragment.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: ConnectProgramFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.pair.ConnectProgramFragment$sendCmdToMachine$3", f = "ConnectProgramFragment.kt", i = {0}, l = {481}, m = "invokeSuspend", n = {"cmd"}, s = {"L$1"})
    /* renamed from: com.soletreadmills.sole_v2.ui.pair.ConnectProgramFragment$sendCmdToMachine$3, reason: invalid class name */
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ArrayList<Data> $dataList;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(ArrayList<Data> arrayList, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$dataList = arrayList;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.$dataList, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0050  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0045 -> B:14:0x0048). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r6.label
                r2 = 1
                if (r1 == 0) goto L1f
                if (r1 != r2) goto L17
                java.lang.Object r1 = r6.L$1
                no.nordicsemi.android.ble.data.Data r1 = (no.nordicsemi.android.ble.data.Data) r1
                java.lang.Object r3 = r6.L$0
                java.util.Iterator r3 = (java.util.Iterator) r3
                kotlin.ResultKt.throwOnFailure(r7)
                goto L48
            L17:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1f:
                kotlin.ResultKt.throwOnFailure(r7)
                java.util.ArrayList<no.nordicsemi.android.ble.data.Data> r7 = r6.$dataList
                java.util.Iterator r7 = r7.iterator()
                r3 = r7
            L29:
                boolean r7 = r3.hasNext()
                if (r7 == 0) goto L50
                java.lang.Object r7 = r3.next()
                r1 = r7
                no.nordicsemi.android.ble.data.Data r1 = (no.nordicsemi.android.ble.data.Data) r1
                r7 = r6
                kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
                r6.L$0 = r3
                r6.L$1 = r1
                r6.label = r2
                r4 = 200(0xc8, double:9.9E-322)
                java.lang.Object r7 = kotlinx.coroutines.DelayKt.delay(r4, r7)
                if (r7 != r0) goto L48
                return r0
            L48:
                com.soletreadmills.sole_v2._manager.BleManager r7 = com.soletreadmills.sole_v2._manager.BleManager.getInstance()
                r7.sendCmdFtms(r1)
                goto L29
            L50:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.pair.ConnectProgramFragment.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: ConnectProgramFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.pair.ConnectProgramFragment$sendCmdToMachine$4", f = "ConnectProgramFragment.kt", i = {0}, l = {InputDeviceCompat.SOURCE_DPAD}, m = "invokeSuspend", n = {"cmd"}, s = {"L$1"})
    /* renamed from: com.soletreadmills.sole_v2.ui.pair.ConnectProgramFragment$sendCmdToMachine$4, reason: invalid class name */
    static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ArrayList<Data> $dataList;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(ArrayList<Data> arrayList, Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
            this.$dataList = arrayList;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass4(this.$dataList, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0050  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0045 -> B:14:0x0048). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r6.label
                r2 = 1
                if (r1 == 0) goto L1f
                if (r1 != r2) goto L17
                java.lang.Object r1 = r6.L$1
                no.nordicsemi.android.ble.data.Data r1 = (no.nordicsemi.android.ble.data.Data) r1
                java.lang.Object r3 = r6.L$0
                java.util.Iterator r3 = (java.util.Iterator) r3
                kotlin.ResultKt.throwOnFailure(r7)
                goto L48
            L17:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1f:
                kotlin.ResultKt.throwOnFailure(r7)
                java.util.ArrayList<no.nordicsemi.android.ble.data.Data> r7 = r6.$dataList
                java.util.Iterator r7 = r7.iterator()
                r3 = r7
            L29:
                boolean r7 = r3.hasNext()
                if (r7 == 0) goto L50
                java.lang.Object r7 = r3.next()
                r1 = r7
                no.nordicsemi.android.ble.data.Data r1 = (no.nordicsemi.android.ble.data.Data) r1
                r7 = r6
                kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
                r6.L$0 = r3
                r6.L$1 = r1
                r6.label = r2
                r4 = 200(0xc8, double:9.9E-322)
                java.lang.Object r7 = kotlinx.coroutines.DelayKt.delay(r4, r7)
                if (r7 != r0) goto L48
                return r0
            L48:
                com.soletreadmills.sole_v2._manager.BleManager r7 = com.soletreadmills.sole_v2._manager.BleManager.getInstance()
                r7.sendCmdFtms(r1)
                goto L29
            L50:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.pair.ConnectProgramFragment.AnonymousClass4.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: ConnectProgramFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.pair.ConnectProgramFragment$sendCmdToMachine$5", f = "ConnectProgramFragment.kt", i = {0}, l = {WinError.ERROR_INVALID_UNWIND_TARGET}, m = "invokeSuspend", n = {"cmd"}, s = {"L$1"})
    /* renamed from: com.soletreadmills.sole_v2.ui.pair.ConnectProgramFragment$sendCmdToMachine$5, reason: invalid class name */
    static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ArrayList<Data> $dataList;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(ArrayList<Data> arrayList, Continuation<? super AnonymousClass5> continuation) {
            super(2, continuation);
            this.$dataList = arrayList;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass5(this.$dataList, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0050  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0045 -> B:14:0x0048). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r6.label
                r2 = 1
                if (r1 == 0) goto L1f
                if (r1 != r2) goto L17
                java.lang.Object r1 = r6.L$1
                no.nordicsemi.android.ble.data.Data r1 = (no.nordicsemi.android.ble.data.Data) r1
                java.lang.Object r3 = r6.L$0
                java.util.Iterator r3 = (java.util.Iterator) r3
                kotlin.ResultKt.throwOnFailure(r7)
                goto L48
            L17:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1f:
                kotlin.ResultKt.throwOnFailure(r7)
                java.util.ArrayList<no.nordicsemi.android.ble.data.Data> r7 = r6.$dataList
                java.util.Iterator r7 = r7.iterator()
                r3 = r7
            L29:
                boolean r7 = r3.hasNext()
                if (r7 == 0) goto L50
                java.lang.Object r7 = r3.next()
                r1 = r7
                no.nordicsemi.android.ble.data.Data r1 = (no.nordicsemi.android.ble.data.Data) r1
                r7 = r6
                kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
                r6.L$0 = r3
                r6.L$1 = r1
                r6.label = r2
                r4 = 200(0xc8, double:9.9E-322)
                java.lang.Object r7 = kotlinx.coroutines.DelayKt.delay(r4, r7)
                if (r7 != r0) goto L48
                return r0
            L48:
                com.soletreadmills.sole_v2._manager.BleManager r7 = com.soletreadmills.sole_v2._manager.BleManager.getInstance()
                r7.sendCmdFtms(r1)
                goto L29
            L50:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.pair.ConnectProgramFragment.AnonymousClass5.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: ConnectProgramFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.pair.ConnectProgramFragment$sendCmdToMachine$6", f = "ConnectProgramFragment.kt", i = {0}, l = {WinError.ERROR_THREAD_NOT_IN_PROCESS}, m = "invokeSuspend", n = {"cmd"}, s = {"L$1"})
    /* renamed from: com.soletreadmills.sole_v2.ui.pair.ConnectProgramFragment$sendCmdToMachine$6, reason: invalid class name */
    static final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ArrayList<Data> $dataList;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass6(ArrayList<Data> arrayList, Continuation<? super AnonymousClass6> continuation) {
            super(2, continuation);
            this.$dataList = arrayList;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass6(this.$dataList, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass6) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0050  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0045 -> B:14:0x0048). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r6.label
                r2 = 1
                if (r1 == 0) goto L1f
                if (r1 != r2) goto L17
                java.lang.Object r1 = r6.L$1
                no.nordicsemi.android.ble.data.Data r1 = (no.nordicsemi.android.ble.data.Data) r1
                java.lang.Object r3 = r6.L$0
                java.util.Iterator r3 = (java.util.Iterator) r3
                kotlin.ResultKt.throwOnFailure(r7)
                goto L48
            L17:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1f:
                kotlin.ResultKt.throwOnFailure(r7)
                java.util.ArrayList<no.nordicsemi.android.ble.data.Data> r7 = r6.$dataList
                java.util.Iterator r7 = r7.iterator()
                r3 = r7
            L29:
                boolean r7 = r3.hasNext()
                if (r7 == 0) goto L50
                java.lang.Object r7 = r3.next()
                r1 = r7
                no.nordicsemi.android.ble.data.Data r1 = (no.nordicsemi.android.ble.data.Data) r1
                r7 = r6
                kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
                r6.L$0 = r3
                r6.L$1 = r1
                r6.label = r2
                r4 = 200(0xc8, double:9.9E-322)
                java.lang.Object r7 = kotlinx.coroutines.DelayKt.delay(r4, r7)
                if (r7 != r0) goto L48
                return r0
            L48:
                com.soletreadmills.sole_v2._manager.BleManager r7 = com.soletreadmills.sole_v2._manager.BleManager.getInstance()
                r7.sendCmdFtms(r1)
                goto L29
            L50:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.pair.ConnectProgramFragment.AnonymousClass6.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: ConnectProgramFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.pair.ConnectProgramFragment$sendCmdToMachine$7", f = "ConnectProgramFragment.kt", i = {0}, l = {WinError.ERROR_VDM_HARD_ERROR}, m = "invokeSuspend", n = {"cmd"}, s = {"L$1"})
    /* renamed from: com.soletreadmills.sole_v2.ui.pair.ConnectProgramFragment$sendCmdToMachine$7, reason: invalid class name */
    static final class AnonymousClass7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ArrayList<Data> $dataList;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass7(ArrayList<Data> arrayList, Continuation<? super AnonymousClass7> continuation) {
            super(2, continuation);
            this.$dataList = arrayList;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass7(this.$dataList, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass7) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0050  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0045 -> B:14:0x0048). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r6.label
                r2 = 1
                if (r1 == 0) goto L1f
                if (r1 != r2) goto L17
                java.lang.Object r1 = r6.L$1
                no.nordicsemi.android.ble.data.Data r1 = (no.nordicsemi.android.ble.data.Data) r1
                java.lang.Object r3 = r6.L$0
                java.util.Iterator r3 = (java.util.Iterator) r3
                kotlin.ResultKt.throwOnFailure(r7)
                goto L48
            L17:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1f:
                kotlin.ResultKt.throwOnFailure(r7)
                java.util.ArrayList<no.nordicsemi.android.ble.data.Data> r7 = r6.$dataList
                java.util.Iterator r7 = r7.iterator()
                r3 = r7
            L29:
                boolean r7 = r3.hasNext()
                if (r7 == 0) goto L50
                java.lang.Object r7 = r3.next()
                r1 = r7
                no.nordicsemi.android.ble.data.Data r1 = (no.nordicsemi.android.ble.data.Data) r1
                r7 = r6
                kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
                r6.L$0 = r3
                r6.L$1 = r1
                r6.label = r2
                r4 = 200(0xc8, double:9.9E-322)
                java.lang.Object r7 = kotlinx.coroutines.DelayKt.delay(r4, r7)
                if (r7 != r0) goto L48
                return r0
            L48:
                com.soletreadmills.sole_v2._manager.BleManager r7 = com.soletreadmills.sole_v2._manager.BleManager.getInstance()
                r7.sendCmdFtms(r1)
                goto L29
            L50:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.pair.ConnectProgramFragment.AnonymousClass7.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: ConnectProgramFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.pair.ConnectProgramFragment$sendCmdToMachine$8", f = "ConnectProgramFragment.kt", i = {0}, l = {WinError.ERROR_VALIDATE_CONTINUE}, m = "invokeSuspend", n = {"cmd"}, s = {"L$1"})
    /* renamed from: com.soletreadmills.sole_v2.ui.pair.ConnectProgramFragment$sendCmdToMachine$8, reason: invalid class name */
    static final class AnonymousClass8 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ArrayList<Data> $dataList;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass8(ArrayList<Data> arrayList, Continuation<? super AnonymousClass8> continuation) {
            super(2, continuation);
            this.$dataList = arrayList;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass8(this.$dataList, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass8) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0050  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0045 -> B:14:0x0048). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r6.label
                r2 = 1
                if (r1 == 0) goto L1f
                if (r1 != r2) goto L17
                java.lang.Object r1 = r6.L$1
                no.nordicsemi.android.ble.data.Data r1 = (no.nordicsemi.android.ble.data.Data) r1
                java.lang.Object r3 = r6.L$0
                java.util.Iterator r3 = (java.util.Iterator) r3
                kotlin.ResultKt.throwOnFailure(r7)
                goto L48
            L17:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1f:
                kotlin.ResultKt.throwOnFailure(r7)
                java.util.ArrayList<no.nordicsemi.android.ble.data.Data> r7 = r6.$dataList
                java.util.Iterator r7 = r7.iterator()
                r3 = r7
            L29:
                boolean r7 = r3.hasNext()
                if (r7 == 0) goto L50
                java.lang.Object r7 = r3.next()
                r1 = r7
                no.nordicsemi.android.ble.data.Data r1 = (no.nordicsemi.android.ble.data.Data) r1
                r7 = r6
                kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
                r6.L$0 = r3
                r6.L$1 = r1
                r6.label = r2
                r4 = 200(0xc8, double:9.9E-322)
                java.lang.Object r7 = kotlinx.coroutines.DelayKt.delay(r4, r7)
                if (r7 != r0) goto L48
                return r0
            L48:
                com.soletreadmills.sole_v2._manager.BleManager r7 = com.soletreadmills.sole_v2._manager.BleManager.getInstance()
                r7.sendCmdFtms(r1)
                goto L29
            L50:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.pair.ConnectProgramFragment.AnonymousClass8.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final void reSetBoolean() {
        this.checkE1 = false;
        this.checkE2 = false;
        this.checkE3 = false;
        this.checkE4 = false;
        this.checkE5 = false;
        this.checkE6 = false;
        this.checkE7 = false;
    }

    public final void checkAllStatus() {
        View root;
        View root2;
        ConnectProgramNameType connectProgramNameType = this.type;
        if ((connectProgramNameType == null ? -1 : WhenMappings.$EnumSwitchMapping$1[connectProgramNameType.ordinal()]) == 8) {
            BleFtmsMachineType bleFtmsMachineType = this.machineType;
            int i = bleFtmsMachineType != null ? WhenMappings.$EnumSwitchMapping$0[bleFtmsMachineType.ordinal()] : -1;
            if (i == 1) {
                if (this.checkE1 && this.checkE2 && this.checkE3 && this.checkE4 && this.checkE5) {
                    stopLoading();
                    FragmentConnectProgramBinding binding = getBinding();
                    if (binding != null && (root = binding.getRoot()) != null) {
                        root.removeCallbacks(this.cancelLoadingRunnable);
                    }
                    BaseFragment.safeNavigateWithPopUp$default(this, R.id.displayDashboardFragment, R.id.connectedPageFragment, false, null, 8, null);
                    return;
                }
                return;
            }
            if ((i == 2 || i == 3) && this.checkE1 && this.checkE4 && this.checkE5 && this.checkE6 && this.checkE7) {
                stopLoading();
                FragmentConnectProgramBinding binding2 = getBinding();
                if (binding2 != null && (root2 = binding2.getRoot()) != null) {
                    root2.removeCallbacks(this.cancelLoadingRunnable);
                }
                BaseFragment.safeNavigateWithPopUp$default(this, R.id.displayDashboardFragment, R.id.connectedPageFragment, false, null, 8, null);
            }
        }
    }

    public final Runnable getCancelLoadingRunnable() {
        return this.cancelLoadingRunnable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cancelLoadingRunnable$lambda$1(ConnectProgramFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.stopLoading();
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this$0), Dispatchers.getMain(), null, new ConnectProgramFragment$cancelLoadingRunnable$1$1(this$0, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showDisplayBoard(TrainingStatusType trainingStatusType) {
        if (trainingStatusType == BleDataManager.getInstance().getOldTrainingStatusType()) {
            Timber.INSTANCE.d("showDisplayBoard-0", new Object[0]);
            return;
        }
        if (trainingStatusType == null) {
            Timber.INSTANCE.d("showDisplayBoard-1", new Object[0]);
            return;
        }
        if (trainingStatusType != TrainingStatusType.MANUAL_MODE_QUICK_START) {
            Timber.INSTANCE.d("showDisplayBoard-2 (" + trainingStatusType + ')', new Object[0]);
            return;
        }
        MainActivity mainActivity = getMainActivity();
        if (mainActivity != null) {
            mainActivity.runOnUiThread(new Runnable() { // from class: com.soletreadmills.sole_v2.ui.pair.ConnectProgramFragment$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    ConnectProgramFragment.showDisplayBoard$lambda$2(this.f$0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDisplayBoard$lambda$2(ConnectProgramFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Timber.INSTANCE.d("showDisplayBoard-true", new Object[0]);
        BaseFragment.safeNavigate$default(this$0, R.id.displayDashboardFragment, null, 2, null);
    }
}
