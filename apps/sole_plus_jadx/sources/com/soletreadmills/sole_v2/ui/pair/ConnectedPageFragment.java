package com.soletreadmills.sole_v2.ui.pair;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.SdkConstants;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.ble.BleDeviceInfoData;
import com.soletreadmills.sole_v2._data.ble.ConnectProgramData;
import com.soletreadmills.sole_v2._data.ble.ProgramCategoryData;
import com.soletreadmills.sole_v2._manager.BleManager;
import com.soletreadmills.sole_v2._sharedPreferences.MySharedPreferences;
import com.soletreadmills.sole_v2._type.ConnectCategoryType;
import com.soletreadmills.sole_v2._type.ConnectProgramType;
import com.soletreadmills.sole_v2._type.MachineType;
import com.soletreadmills.sole_v2.ble.cmd.FitnessMachineControlPointCmd;
import com.soletreadmills.sole_v2.ble.data.FitnessMachineControlPointResponseData;
import com.soletreadmills.sole_v2.ble.manager.BleDataManager;
import com.soletreadmills.sole_v2.ble.manager.FtmsDeviceManager;
import com.soletreadmills.sole_v2.ble.type.BleFtmsMachineType;
import com.soletreadmills.sole_v2.ble.type.FitnessMachineStatusType;
import com.soletreadmills.sole_v2.ble.type.TrainingStatusType;
import com.soletreadmills.sole_v2.databinding.FragmentConnectedPageBinding;
import com.soletreadmills.sole_v2.listener.BluetoothCallbackListener;
import com.soletreadmills.sole_v2.listener.OnItemClickListener;
import com.soletreadmills.sole_v2.ui.MainActivity;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import com.soletreadmills.sole_v2.ui.adapter.pair.ConnectPageAdapter;
import com.soletreadmills.sole_v2.ui.adapter.pair.ConnectPageCategoryAdapter;
import com.soletreadmills.sole_v2.ui.displayMode.DisplayModeViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import no.nordicsemi.android.support.v18.scanner.ScanResult;
import timber.log.Timber;

/* compiled from: ConnectedPageFragment.kt */
@Metadata(d1 = {"\u0000\u0089\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0015H\u0002J\u0018\u0010+\u001a\u00020)2\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\u001dH\u0002J\b\u0010.\u001a\u00020)H\u0002J\u001a\u0010/\u001a\u00020\u00022\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103H\u0016J\b\u00104\u001a\u00020)H\u0016J\u0012\u00105\u001a\u00020)2\b\u00106\u001a\u0004\u0018\u000107H\u0016J\b\u00108\u001a\u00020)H\u0016J\u001a\u00109\u001a\u00020)2\u0006\u0010:\u001a\u0002072\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\u0006\u0010=\u001a\u00020)J\u0006\u0010>\u001a\u00020)J\u0006\u0010?\u001a\u00020)J\u0006\u0010@\u001a\u00020)J\u0012\u0010A\u001a\u00020)2\b\u0010B\u001a\u0004\u0018\u00010CH\u0002J\u0016\u0010D\u001a\u00020)2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020)0FH\u0002R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001b\u0010#\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u0013\u001a\u0004\b%\u0010&¨\u0006G"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/pair/ConnectedPageFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/databinding/FragmentConnectedPageBinding;", "Landroid/view/View$OnClickListener;", "()V", "bluetoothCallbackListener", "com/soletreadmills/sole_v2/ui/pair/ConnectedPageFragment$bluetoothCallbackListener$1", "Lcom/soletreadmills/sole_v2/ui/pair/ConnectedPageFragment$bluetoothCallbackListener$1;", "connectFtmsBleDeviceInfoData", "Lcom/soletreadmills/sole_v2/_data/ble/BleDeviceInfoData;", "getConnectFtmsBleDeviceInfoData", "()Lcom/soletreadmills/sole_v2/_data/ble/BleDeviceInfoData;", "setConnectFtmsBleDeviceInfoData", "(Lcom/soletreadmills/sole_v2/_data/ble/BleDeviceInfoData;)V", "connectProgramViewModel", "Lcom/soletreadmills/sole_v2/ui/pair/ConnectProgramViewModel;", "getConnectProgramViewModel$app_release", "()Lcom/soletreadmills/sole_v2/ui/pair/ConnectProgramViewModel;", "connectProgramViewModel$delegate", "Lkotlin/Lazy;", "currentCollapseMode", "", "machineType", "Lcom/soletreadmills/sole_v2/ble/type/BleFtmsMachineType;", "getMachineType", "()Lcom/soletreadmills/sole_v2/ble/type/BleFtmsMachineType;", "setMachineType", "(Lcom/soletreadmills/sole_v2/ble/type/BleFtmsMachineType;)V", "programDataList", "", "Lcom/soletreadmills/sole_v2/_data/ble/ConnectProgramData;", "getProgramDataList", "()Ljava/util/List;", "setProgramDataList", "(Ljava/util/List;)V", "viewModel", "Lcom/soletreadmills/sole_v2/ui/displayMode/DisplayModeViewModel;", "getViewModel", "()Lcom/soletreadmills/sole_v2/ui/displayMode/DisplayModeViewModel;", "viewModel$delegate", "changeCollapseMode", "", "collapseMode", "filterProgramList", "categoryList", "Lcom/soletreadmills/sole_v2/_data/ble/ProgramCategoryData;", "goDisplayModePage", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", SdkConstants.ATTR_ON_CLICK, "v", "Landroid/view/View;", "onDestroyView", "onViewCreated", "view", "savedInstanceState", "Landroid/os/Bundle;", "setBlueToothConnectStatus", "setCategoryRecyclerView", "setProgramRecyclerView", "setView", "showDisplayBoard", "trainingStatusType", "Lcom/soletreadmills/sole_v2/ble/type/TrainingStatusType;", "startCountdownCoroutine", "onFinish", "Lkotlin/Function0;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ConnectedPageFragment extends BaseFragment<FragmentConnectedPageBinding> implements View.OnClickListener {
    public static final int $stable = 8;
    private BleDeviceInfoData connectFtmsBleDeviceInfoData;

    /* renamed from: connectProgramViewModel$delegate, reason: from kotlin metadata */
    private final Lazy connectProgramViewModel;
    public List<ConnectProgramData> programDataList;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    private int currentCollapseMode = 2;
    private BleFtmsMachineType machineType = BleFtmsMachineType.TREADMILL;
    private final ConnectedPageFragment$bluetoothCallbackListener$1 bluetoothCallbackListener = new BluetoothCallbackListener() { // from class: com.soletreadmills.sole_v2.ui.pair.ConnectedPageFragment$bluetoothCallbackListener$1
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
        public void onConnected(BluetoothCallbackListener.DeviceType deviceType, String macAddress) {
            Intrinsics.checkNotNullParameter(deviceType, "deviceType");
            Intrinsics.checkNotNullParameter(macAddress, "macAddress");
            this.this$0.setBlueToothConnectStatus();
        }

        @Override // com.soletreadmills.sole_v2.listener.BluetoothCallbackListener
        public void onDisconnected(BluetoothCallbackListener.DeviceType deviceType, String macAddress) {
            Intrinsics.checkNotNullParameter(deviceType, "deviceType");
            Intrinsics.checkNotNullParameter(macAddress, "macAddress");
            this.this$0.setBlueToothConnectStatus();
            if (deviceType == BluetoothCallbackListener.DeviceType.FTMS) {
                MySharedPreferences.INSTANCE.getInstance().resetConnectBleName();
                this.this$0.safeNavigateUp();
            }
        }

        @Override // com.soletreadmills.sole_v2.listener.BluetoothCallbackListener
        public void onReceiveTrainingStatus(TrainingStatusType trainingStatusType) {
            this.this$0.showDisplayBoard(trainingStatusType);
        }
    };

    /* compiled from: ConnectedPageFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[ConnectCategoryType.values().length];
            try {
                iArr[ConnectCategoryType.Preset.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ConnectCategoryType.Targets.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[MachineType.values().length];
            try {
                iArr2[MachineType.TREADMILL.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[MachineType.ELLIPTICAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[MachineType.BIKE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[MachineType.ROWER.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[MachineType.STEPPER.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.soletreadmills.sole_v2.ui.pair.ConnectedPageFragment$bluetoothCallbackListener$1] */
    public ConnectedPageFragment() {
        final ConnectedPageFragment connectedPageFragment = this;
        final Function0 function0 = null;
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(connectedPageFragment, Reflection.getOrCreateKotlinClass(DisplayModeViewModel.class), new Function0<ViewModelStore>() { // from class: com.soletreadmills.sole_v2.ui.pair.ConnectedPageFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = connectedPageFragment.requireActivity().getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: com.soletreadmills.sole_v2.ui.pair.ConnectedPageFragment$special$$inlined$activityViewModels$default$2
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
                CreationExtras defaultViewModelCreationExtras = connectedPageFragment.requireActivity().getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.soletreadmills.sole_v2.ui.pair.ConnectedPageFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = connectedPageFragment.requireActivity().getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.connectProgramViewModel = FragmentViewModelLazyKt.createViewModelLazy(connectedPageFragment, Reflection.getOrCreateKotlinClass(ConnectProgramViewModel.class), new Function0<ViewModelStore>() { // from class: com.soletreadmills.sole_v2.ui.pair.ConnectedPageFragment$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = connectedPageFragment.requireActivity().getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: com.soletreadmills.sole_v2.ui.pair.ConnectedPageFragment$special$$inlined$activityViewModels$default$5
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
                CreationExtras defaultViewModelCreationExtras = connectedPageFragment.requireActivity().getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.soletreadmills.sole_v2.ui.pair.ConnectedPageFragment$special$$inlined$activityViewModels$default$6
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = connectedPageFragment.requireActivity().getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    public static final /* synthetic */ FragmentConnectedPageBinding access$getBinding(ConnectedPageFragment connectedPageFragment) {
        return connectedPageFragment.getBinding();
    }

    private final DisplayModeViewModel getViewModel() {
        return (DisplayModeViewModel) this.viewModel.getValue();
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

    public final List<ConnectProgramData> getProgramDataList() {
        List<ConnectProgramData> list = this.programDataList;
        if (list != null) {
            return list;
        }
        Intrinsics.throwUninitializedPropertyAccessException("programDataList");
        return null;
    }

    public final void setProgramDataList(List<ConnectProgramData> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.programDataList = list;
    }

    public final BleFtmsMachineType getMachineType() {
        return this.machineType;
    }

    public final void setMachineType(BleFtmsMachineType bleFtmsMachineType) {
        Intrinsics.checkNotNullParameter(bleFtmsMachineType, "<set-?>");
        this.machineType = bleFtmsMachineType;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        BleManager.getInstance().removeBluetoothCallbackListener(this.bluetoothCallbackListener);
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public FragmentConnectedPageBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentConnectedPageBinding fragmentConnectedPageBindingInflate = FragmentConnectedPageBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentConnectedPageBindingInflate, "inflate(...)");
        return fragmentConnectedPageBindingInflate;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public void initViews() {
        LinearLayout linearLayout;
        TextView textView;
        LinearLayout linearLayout2;
        ImageView imageView;
        LinearLayout linearLayout3;
        LinearLayout linearLayout4;
        ImageView imageView2;
        AppBarLayout appBarLayout;
        BleManager bleManager;
        FtmsDeviceManager ftmsDeviceManager;
        BleManager.getInstance().removeBluetoothCallbackListener(this.bluetoothCallbackListener);
        BleManager.getInstance().addBluetoothCallbackListener(this.bluetoothCallbackListener);
        MainActivity mainActivity = getMainActivity();
        BleFtmsMachineType bleFtmsMachineType = (mainActivity == null || (bleManager = mainActivity.getBleManager()) == null || (ftmsDeviceManager = bleManager.getFtmsDeviceManager()) == null) ? null : ftmsDeviceManager.getBleFtmsMachineType();
        if (bleFtmsMachineType == null) {
            bleFtmsMachineType = BleFtmsMachineType.TREADMILL;
        }
        this.machineType = bleFtmsMachineType;
        setProgramDataList(ConnectProgramData.INSTANCE.filteredDataList(this.machineType));
        getConnectProgramViewModel$app_release().setMachineType(this.machineType);
        FragmentConnectedPageBinding binding = getBinding();
        if (binding != null && (appBarLayout = binding.appBarLayout) != null) {
            appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.soletreadmills.sole_v2.ui.pair.ConnectedPageFragment$$ExternalSyntheticLambda0
                @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
                public final void onOffsetChanged(AppBarLayout appBarLayout2, int i) {
                    ConnectedPageFragment.initViews$lambda$0(this.f$0, appBarLayout2, i);
                }
            });
        }
        FragmentConnectedPageBinding binding2 = getBinding();
        if (binding2 != null && (imageView2 = binding2.back) != null) {
            imageView2.setOnClickListener(this);
        }
        FragmentConnectedPageBinding binding3 = getBinding();
        if (binding3 != null && (linearLayout4 = binding3.LLDisconnect) != null) {
            linearLayout4.setOnClickListener(this);
        }
        FragmentConnectedPageBinding binding4 = getBinding();
        if (binding4 != null && (linearLayout3 = binding4.LLStart) != null) {
            linearLayout3.setOnClickListener(this);
        }
        FragmentConnectedPageBinding binding5 = getBinding();
        if (binding5 != null && (imageView = binding5.bleWatch) != null) {
            imageView.setOnClickListener(this);
        }
        FragmentConnectedPageBinding binding6 = getBinding();
        if (binding6 != null && (linearLayout2 = binding6.LLFinish) != null) {
            linearLayout2.setOnClickListener(this);
        }
        FragmentConnectedPageBinding binding7 = getBinding();
        if (binding7 != null && (textView = binding7.tvDisplay) != null) {
            textView.setOnClickListener(this);
        }
        this.connectFtmsBleDeviceInfoData = BleManager.getInstance().getConnectFtmsBleDeviceInfoData();
        FtmsDeviceManager ftmsDeviceManager2 = BleManager.getInstance().getFtmsDeviceManager();
        if (ftmsDeviceManager2 != null && ftmsDeviceManager2.isFitnessMachineControlPoint()) {
            FragmentConnectedPageBinding binding8 = getBinding();
            LinearLayout linearLayout5 = binding8 != null ? binding8.LLBottom : null;
            if (linearLayout5 != null) {
                linearLayout5.setVisibility(0);
            }
            FragmentConnectedPageBinding binding9 = getBinding();
            LinearLayout linearLayout6 = binding9 != null ? binding9.LLSimpleBottom : null;
            if (linearLayout6 != null) {
                linearLayout6.setVisibility(8);
            }
            FtmsDeviceManager ftmsDeviceManager3 = BleManager.getInstance().getFtmsDeviceManager();
            if (ftmsDeviceManager3 != null && ftmsDeviceManager3.getSupportProgram()) {
                FragmentConnectedPageBinding binding10 = getBinding();
                RecyclerView recyclerView = binding10 != null ? binding10.recyclerViewProgram : null;
                if (recyclerView != null) {
                    recyclerView.setVisibility(0);
                }
                FragmentConnectedPageBinding binding11 = getBinding();
                RecyclerView recyclerView2 = binding11 != null ? binding11.recyclerviewCategory : null;
                if (recyclerView2 != null) {
                    recyclerView2.setVisibility(0);
                }
                FragmentConnectedPageBinding binding12 = getBinding();
                linearLayout = binding12 != null ? binding12.LLNoProgram : null;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
                setProgramRecyclerView();
            } else {
                FragmentConnectedPageBinding binding13 = getBinding();
                RecyclerView recyclerView3 = binding13 != null ? binding13.recyclerViewProgram : null;
                if (recyclerView3 != null) {
                    recyclerView3.setVisibility(8);
                }
                FragmentConnectedPageBinding binding14 = getBinding();
                RecyclerView recyclerView4 = binding14 != null ? binding14.recyclerviewCategory : null;
                if (recyclerView4 != null) {
                    recyclerView4.setVisibility(8);
                }
                FragmentConnectedPageBinding binding15 = getBinding();
                linearLayout = binding15 != null ? binding15.LLNoProgram : null;
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
            }
        } else {
            FragmentConnectedPageBinding binding16 = getBinding();
            RecyclerView recyclerView5 = binding16 != null ? binding16.recyclerViewProgram : null;
            if (recyclerView5 != null) {
                recyclerView5.setVisibility(8);
            }
            FragmentConnectedPageBinding binding17 = getBinding();
            RecyclerView recyclerView6 = binding17 != null ? binding17.recyclerviewCategory : null;
            if (recyclerView6 != null) {
                recyclerView6.setVisibility(8);
            }
            FragmentConnectedPageBinding binding18 = getBinding();
            LinearLayout linearLayout7 = binding18 != null ? binding18.LLNoProgram : null;
            if (linearLayout7 != null) {
                linearLayout7.setVisibility(0);
            }
            FragmentConnectedPageBinding binding19 = getBinding();
            LinearLayout linearLayout8 = binding19 != null ? binding19.LLBottom : null;
            if (linearLayout8 != null) {
                linearLayout8.setVisibility(8);
            }
            FragmentConnectedPageBinding binding20 = getBinding();
            linearLayout = binding20 != null ? binding20.LLSimpleBottom : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
        }
        setCategoryRecyclerView();
        setBlueToothConnectStatus();
        setView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$0(ConnectedPageFragment this$0, AppBarLayout appBarLayout, int i) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i2 = ((float) Math.abs(i)) / ((float) appBarLayout.getTotalScrollRange()) >= 0.85f ? 1 : 2;
        if (this$0.currentCollapseMode != i2) {
            this$0.changeCollapseMode(i2);
            this$0.currentCollapseMode = i2;
            if (i2 == 1) {
                FragmentConnectedPageBinding binding = this$0.getBinding();
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
            FragmentConnectedPageBinding binding2 = this$0.getBinding();
            textView = binding2 != null ? binding2.title : null;
            if (textView == null) {
                return;
            }
            textView.setVisibility(4);
        }
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        showDisplayBoard(BleDataManager.getInstance().getNowTrainingStatusType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Integer numValueOf = v != null ? Integer.valueOf(v.getId()) : null;
        int i = R.id.back;
        if (numValueOf != null && numValueOf.intValue() == i) {
            safeNavigateUp();
            return;
        }
        int i2 = R.id.LL_disconnect;
        if (numValueOf != null && numValueOf.intValue() == i2) {
            BleManager.getInstance().sendCmdFtms(FitnessMachineControlPointCmd.stop());
            BleManager.getInstance().bleFtmsDisconnect();
            return;
        }
        int i3 = R.id.LL_start;
        if (numValueOf != null && numValueOf.intValue() == i3) {
            FtmsDeviceManager ftmsDeviceManager = BleManager.getInstance().getFtmsDeviceManager();
            if (ftmsDeviceManager != null && ftmsDeviceManager.isFitnessMachineControlPoint()) {
                if (BleDataManager.getInstance().getNowTrainingStatusType() == TrainingStatusType.IDLE) {
                    BleManager.getInstance().sendCmdFtms(FitnessMachineControlPointCmd.startOrResume());
                    goDisplayModePage();
                    return;
                } else {
                    if (BleDataManager.getInstance().getNowFitnessMachineStatusType() != FitnessMachineStatusType.FITNESS_MACHINE_STOPPED_BY_THE_USER) {
                        BaseFragment.safeNavigate$default(this, R.id.displayDashboardFragment, null, 2, null);
                        return;
                    }
                    return;
                }
            }
            goDisplayModePage();
            return;
        }
        int i4 = R.id.LL_finish;
        if (numValueOf != null && numValueOf.intValue() == i4) {
            BleDataManager.getInstance().uploadSummaryData();
            BleManager.getInstance().bleFtmsDisconnect();
            return;
        }
        int i5 = R.id.tv_display;
        if (numValueOf != null && numValueOf.intValue() == i5) {
            BaseFragment.safeNavigate$default(this, R.id.displayDashboardFragment, null, 2, null);
            return;
        }
        int i6 = R.id.ble_watch;
        if (numValueOf != null && numValueOf.intValue() == i6) {
            BaseFragment.safeNavigate$default(this, R.id.heartRateMonitorFragment, null, 2, null);
        }
    }

    private final void changeCollapseMode(int collapseMode) {
        Toolbar toolbar;
        FragmentConnectedPageBinding binding = getBinding();
        ViewGroup.LayoutParams layoutParams = (binding == null || (toolbar = binding.collapsingToolbar) == null) ? null : toolbar.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.google.android.material.appbar.CollapsingToolbarLayout.LayoutParams");
        CollapsingToolbarLayout.LayoutParams layoutParams2 = (CollapsingToolbarLayout.LayoutParams) layoutParams;
        layoutParams2.setCollapseMode(collapseMode);
        FragmentConnectedPageBinding binding2 = getBinding();
        Toolbar toolbar2 = binding2 != null ? binding2.collapsingToolbar : null;
        if (toolbar2 == null) {
            return;
        }
        toolbar2.setLayoutParams(layoutParams2);
    }

    public final void setCategoryRecyclerView() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        FragmentConnectedPageBinding binding = getBinding();
        RecyclerView.Adapter adapter = null;
        if (!(((binding == null || (recyclerView3 = binding.recyclerviewCategory) == null) ? null : recyclerView3.getLayoutManager()) instanceof LinearLayoutManager)) {
            FragmentConnectedPageBinding binding2 = getBinding();
            RecyclerView recyclerView4 = binding2 != null ? binding2.recyclerviewCategory : null;
            if (recyclerView4 != null) {
                recyclerView4.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
            }
        }
        FragmentConnectedPageBinding binding3 = getBinding();
        if (!(((binding3 == null || (recyclerView2 = binding3.recyclerviewCategory) == null) ? null : recyclerView2.getAdapter()) instanceof ConnectPageCategoryAdapter)) {
            ConnectPageCategoryAdapter connectPageCategoryAdapter = new ConnectPageCategoryAdapter(new OnItemClickListener() { // from class: com.soletreadmills.sole_v2.ui.pair.ConnectedPageFragment$setCategoryRecyclerView$adapter$1
                @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
                public void onClick(int pos, String string) {
                    Intrinsics.checkNotNullParameter(string, "string");
                }

                @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
                public void onClick(int pos) {
                    RecyclerView recyclerView5;
                    FragmentConnectedPageBinding fragmentConnectedPageBindingAccess$getBinding = ConnectedPageFragment.access$getBinding(this.this$0);
                    RecyclerView.Adapter adapter2 = (fragmentConnectedPageBindingAccess$getBinding == null || (recyclerView5 = fragmentConnectedPageBindingAccess$getBinding.recyclerviewCategory) == null) ? null : recyclerView5.getAdapter();
                    ConnectPageCategoryAdapter connectPageCategoryAdapter2 = adapter2 instanceof ConnectPageCategoryAdapter ? (ConnectPageCategoryAdapter) adapter2 : null;
                    if (connectPageCategoryAdapter2 == null) {
                        return;
                    }
                    List<ProgramCategoryData> currentList = connectPageCategoryAdapter2.getCurrentList();
                    Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
                    List<ProgramCategoryData> list = currentList;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    int i = 0;
                    for (Object obj : list) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        ProgramCategoryData programCategoryDataCopy$default = (ProgramCategoryData) obj;
                        if (i == pos) {
                            Intrinsics.checkNotNull(programCategoryDataCopy$default);
                            programCategoryDataCopy$default = ProgramCategoryData.copy$default(programCategoryDataCopy$default, null, !programCategoryDataCopy$default.getSelect(), 1, null);
                        }
                        arrayList.add(programCategoryDataCopy$default);
                        i = i2;
                    }
                    ArrayList arrayList2 = arrayList;
                    connectPageCategoryAdapter2.submitList(arrayList2);
                    this.this$0.filterProgramList(arrayList2);
                }
            });
            FragmentConnectedPageBinding binding4 = getBinding();
            RecyclerView recyclerView5 = binding4 != null ? binding4.recyclerviewCategory : null;
            if (recyclerView5 != null) {
                recyclerView5.setAdapter(connectPageCategoryAdapter);
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ProgramCategoryData(ConnectCategoryType.Preset, false));
        arrayList.add(new ProgramCategoryData(ConnectCategoryType.Targets, false));
        FragmentConnectedPageBinding binding5 = getBinding();
        if (binding5 != null && (recyclerView = binding5.recyclerviewCategory) != null) {
            adapter = recyclerView.getAdapter();
        }
        if (adapter instanceof ConnectPageCategoryAdapter) {
            ((ConnectPageCategoryAdapter) adapter).submitList(arrayList);
        }
    }

    public final void setProgramRecyclerView() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        FragmentConnectedPageBinding binding = getBinding();
        RecyclerView.Adapter adapter = null;
        if (!(((binding == null || (recyclerView3 = binding.recyclerViewProgram) == null) ? null : recyclerView3.getLayoutManager()) instanceof LinearLayoutManager)) {
            FragmentConnectedPageBinding binding2 = getBinding();
            RecyclerView recyclerView4 = binding2 != null ? binding2.recyclerViewProgram : null;
            if (recyclerView4 != null) {
                recyclerView4.setLayoutManager(new LinearLayoutManager(getContext()));
            }
        }
        FragmentConnectedPageBinding binding3 = getBinding();
        if (!(((binding3 == null || (recyclerView2 = binding3.recyclerViewProgram) == null) ? null : recyclerView2.getAdapter()) instanceof ConnectPageAdapter)) {
            ConnectPageAdapter connectPageAdapter = new ConnectPageAdapter(this.machineType, new OnItemClickListener() { // from class: com.soletreadmills.sole_v2.ui.pair.ConnectedPageFragment$setProgramRecyclerView$adapter$1
                @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
                public void onClick(int pos, String string) {
                    Intrinsics.checkNotNullParameter(string, "string");
                }

                @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
                public void onClick(int pos) {
                    RecyclerView recyclerView5;
                    FragmentConnectedPageBinding fragmentConnectedPageBindingAccess$getBinding = ConnectedPageFragment.access$getBinding(this.this$0);
                    RecyclerView.Adapter adapter2 = (fragmentConnectedPageBindingAccess$getBinding == null || (recyclerView5 = fragmentConnectedPageBindingAccess$getBinding.recyclerViewProgram) == null) ? null : recyclerView5.getAdapter();
                    if (adapter2 instanceof ConnectPageAdapter) {
                        List<ConnectProgramData> currentList = ((ConnectPageAdapter) adapter2).getCurrentList();
                        Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
                        this.this$0.getConnectProgramViewModel$app_release().setType(currentList.get(pos).getConnectProgramNameType());
                        BaseFragment.safeNavigate$default(this.this$0, R.id.connectProgramFragment, null, 2, null);
                    }
                }
            });
            FragmentConnectedPageBinding binding4 = getBinding();
            RecyclerView recyclerView5 = binding4 != null ? binding4.recyclerViewProgram : null;
            if (recyclerView5 != null) {
                recyclerView5.setAdapter(connectPageAdapter);
            }
        }
        FragmentConnectedPageBinding binding5 = getBinding();
        if (binding5 != null && (recyclerView = binding5.recyclerViewProgram) != null) {
            adapter = recyclerView.getAdapter();
        }
        if (adapter instanceof ConnectPageAdapter) {
            ((ConnectPageAdapter) adapter).submitList(getProgramDataList());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void filterProgramList(List<ProgramCategoryData> categoryList) {
        ArrayList arrayList;
        ConnectProgramType connectProgramType;
        RecyclerView recyclerView;
        FragmentConnectedPageBinding binding = getBinding();
        RecyclerView.Adapter adapter = (binding == null || (recyclerView = binding.recyclerViewProgram) == null) ? null : recyclerView.getAdapter();
        ConnectPageAdapter connectPageAdapter = adapter instanceof ConnectPageAdapter ? (ConnectPageAdapter) adapter : null;
        if (connectPageAdapter == null) {
            return;
        }
        if (categoryList == null) {
            arrayList = new ArrayList();
        } else {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : categoryList) {
                if (((ProgramCategoryData) obj).getSelect()) {
                    arrayList2.add(obj);
                }
            }
            ArrayList arrayList3 = arrayList2;
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
            Iterator it = arrayList3.iterator();
            while (it.hasNext()) {
                arrayList4.add(((ProgramCategoryData) it.next()).getType());
            }
            arrayList = arrayList4;
        }
        boolean zContains = arrayList.contains(ConnectCategoryType.FAVORITE);
        ArrayList arrayList5 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (((ConnectCategoryType) obj2) != ConnectCategoryType.FAVORITE) {
                arrayList5.add(obj2);
            }
        }
        ArrayList arrayList6 = new ArrayList();
        Iterator it2 = arrayList5.iterator();
        while (it2.hasNext()) {
            int i = WhenMappings.$EnumSwitchMapping$0[((ConnectCategoryType) it2.next()).ordinal()];
            if (i == 1) {
                connectProgramType = ConnectProgramType.Preset;
            } else {
                connectProgramType = i != 2 ? null : ConnectProgramType.Targets;
            }
            if (connectProgramType != null) {
                arrayList6.add(connectProgramType);
            }
        }
        ArrayList arrayList7 = arrayList6;
        List<ConnectProgramData> programDataList = getProgramDataList();
        ArrayList arrayList8 = new ArrayList();
        for (Object obj3 : programDataList) {
            ConnectProgramData connectProgramData = (ConnectProgramData) obj3;
            boolean zContains2 = !arrayList7.isEmpty() ? arrayList7.contains(connectProgramData.getType()) : true;
            if (zContains) {
                zContains2 = zContains2 && connectProgramData.isFavorites();
            }
            if (zContains2) {
                arrayList8.add(obj3);
            }
        }
        connectPageAdapter.submitList(arrayList8);
    }

    public final void setBlueToothConnectStatus() {
        ImageView imageView;
        if (getBinding() != null) {
            boolean zIsConnectedHr = BleManager.getInstance().isConnectedHr();
            boolean zIsConnectingHr = BleManager.getInstance().isConnectingHr();
            boolean zIsConnectedFtms = BleManager.getInstance().isConnectedFtms();
            Timber.INSTANCE.d("setBlueToothConnectStatus_hr:" + zIsConnectedHr, new Object[0]);
            Timber.INSTANCE.d("setBlueToothConnectStatus_hr_ing:" + zIsConnectingHr, new Object[0]);
            Timber.INSTANCE.d("setBlueToothConnectStatus_ftms:" + zIsConnectedFtms, new Object[0]);
            if (zIsConnectedHr) {
                FragmentConnectedPageBinding binding = getBinding();
                imageView = binding != null ? binding.imgWatch : null;
                if (imageView == null) {
                    return;
                }
                imageView.setVisibility(0);
                return;
            }
            FragmentConnectedPageBinding binding2 = getBinding();
            imageView = binding2 != null ? binding2.imgWatch : null;
            if (imageView == null) {
                return;
            }
            imageView.setVisibility(4);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void setView() {
        /*
            Method dump skipped, instructions count: 255
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.pair.ConnectedPageFragment.setView():void");
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
            mainActivity.runOnUiThread(new Runnable() { // from class: com.soletreadmills.sole_v2.ui.pair.ConnectedPageFragment$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    ConnectedPageFragment.showDisplayBoard$lambda$7(this.f$0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDisplayBoard$lambda$7(ConnectedPageFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Timber.INSTANCE.d("showDisplayBoard-true", new Object[0]);
        BaseFragment.safeNavigate$default(this$0, R.id.displayDashboardFragment, null, 2, null);
    }

    private final void goDisplayModePage() {
        if (this.machineType == BleFtmsMachineType.TREADMILL) {
            startCountdownCoroutine(new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.pair.ConnectedPageFragment.goDisplayModePage.1
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
                    BaseFragment.safeNavigate$default(ConnectedPageFragment.this, R.id.displayDashboardFragment, null, 2, null);
                }
            });
        } else {
            BaseFragment.safeNavigate$default(this, R.id.displayDashboardFragment, null, 2, null);
        }
    }

    private final void startCountdownCoroutine(Function0<Unit> onFinish) {
        FragmentConnectedPageBinding binding = getBinding();
        LinearLayout linearLayout = binding != null ? binding.llCountdownWrap : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C09941(onFinish, null), 3, null);
    }

    /* compiled from: ConnectedPageFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.pair.ConnectedPageFragment$startCountdownCoroutine$1", f = "ConnectedPageFragment.kt", i = {0}, l = {499}, m = "invokeSuspend", n = {"i"}, s = {"I$0"})
    /* renamed from: com.soletreadmills.sole_v2.ui.pair.ConnectedPageFragment$startCountdownCoroutine$1, reason: invalid class name and case insensitive filesystem */
    static final class C09941 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $onFinish;
        int I$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09941(Function0<Unit> function0, Continuation<? super C09941> continuation) {
            super(2, continuation);
            this.$onFinish = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ConnectedPageFragment.this.new C09941(this.$onFinish, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09941) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0020  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x004b  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0045 -> B:20:0x0048). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r5.label
                r2 = 1
                if (r1 == 0) goto L19
                if (r1 != r2) goto L11
                int r1 = r5.I$0
                kotlin.ResultKt.throwOnFailure(r6)
                goto L48
            L11:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L19:
                kotlin.ResultKt.throwOnFailure(r6)
                r6 = 3
                r1 = r6
            L1e:
                if (r1 <= 0) goto L4b
                com.soletreadmills.sole_v2.ui.pair.ConnectedPageFragment r6 = com.soletreadmills.sole_v2.ui.pair.ConnectedPageFragment.this
                com.soletreadmills.sole_v2.databinding.FragmentConnectedPageBinding r6 = com.soletreadmills.sole_v2.ui.pair.ConnectedPageFragment.access$getBinding(r6)
                if (r6 == 0) goto L2b
                android.widget.TextView r6 = r6.llCountdownNum
                goto L2c
            L2b:
                r6 = 0
            L2c:
                if (r6 != 0) goto L2f
                goto L38
            L2f:
                java.lang.String r3 = java.lang.String.valueOf(r1)
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                r6.setText(r3)
            L38:
                r6 = r5
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                r5.I$0 = r1
                r5.label = r2
                r3 = 1000(0x3e8, double:4.94E-321)
                java.lang.Object r6 = kotlinx.coroutines.DelayKt.delay(r3, r6)
                if (r6 != r0) goto L48
                return r0
            L48:
                int r1 = r1 + (-1)
                goto L1e
            L4b:
                kotlin.jvm.functions.Function0<kotlin.Unit> r6 = r5.$onFinish
                r6.invoke()
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.pair.ConnectedPageFragment.C09941.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }
}
