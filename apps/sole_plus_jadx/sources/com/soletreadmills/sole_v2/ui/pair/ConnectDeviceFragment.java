package com.soletreadmills.sole_v2.ui.pair;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.SdkConstants;
import com.soletreadmills.sole_v2.Global;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data._base.JwtApiBaseData;
import com.soletreadmills.sole_v2._data.api.JwtErrorCode;
import com.soletreadmills.sole_v2._data.api.settings.BluetoothSubscriptionApiData;
import com.soletreadmills.sole_v2._data.ble.BleDeviceInfoData;
import com.soletreadmills.sole_v2._extension.CustomDialogKt;
import com.soletreadmills.sole_v2._manager.BleManager;
import com.soletreadmills.sole_v2._network.JwtDyacoApiKt;
import com.soletreadmills.sole_v2._type.BluetoothComeClassType;
import com.soletreadmills.sole_v2._type.BluetoothConnectType;
import com.soletreadmills.sole_v2._type.MachineType;
import com.soletreadmills.sole_v2.ble.manager.FtmsDeviceManager;
import com.soletreadmills.sole_v2.databinding.FragmentConnectDeviceBinding;
import com.soletreadmills.sole_v2.listener.EnabledBluetoothListener;
import com.soletreadmills.sole_v2.listener.OnItemClickListener;
import com.soletreadmills.sole_v2.ui.MainActivity;
import com.soletreadmills.sole_v2.ui._base.BaseActivity;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import com.soletreadmills.sole_v2.ui.adapter.pair.ConnectDevicesAdapter;
import com.soletreadmills.sole_v2.ui.home.HomeViewModel;
import com.soletreadmills.sole_v2.ui.pair.ConnectDeviceFragment;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import retrofit2.Response;
import timber.log.Timber;

/* compiled from: ConnectDeviceFragment.kt */
@Metadata(d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0006\u0010&\u001a\u00020'J\u0006\u0010\b\u001a\u00020'J\u001a\u0010(\u001a\u00020\u00022\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010-\u001a\u00020'H\u0016J\u0012\u0010.\u001a\u00020'2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00101\u001a\u00020'H\u0016J\u001a\u00102\u001a\u00020'2\u0006\u00103\u001a\u0002002\b\u00104\u001a\u0004\u0018\u000105H\u0016J\u0006\u00106\u001a\u00020'J\u000e\u00107\u001a\u00020'2\u0006\u00108\u001a\u000209J\u0006\u0010:\u001a\u00020'J\u0006\u0010;\u001a\u00020'R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001a\u001a\u00020\u001b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006<"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/pair/ConnectDeviceFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/databinding/FragmentConnectDeviceBinding;", "Landroid/view/View$OnClickListener;", "()V", "bleList", "", "Lcom/soletreadmills/sole_v2/_data/ble/BleDeviceInfoData;", "getBleList", "()Ljava/util/List;", "setBleList", "(Ljava/util/List;)V", "bluetoothCallbackListener", "com/soletreadmills/sole_v2/ui/pair/ConnectDeviceFragment$bluetoothCallbackListener$1", "Lcom/soletreadmills/sole_v2/ui/pair/ConnectDeviceFragment$bluetoothCallbackListener$1;", "bluetoothConnectType", "Lcom/soletreadmills/sole_v2/_type/BluetoothConnectType;", "getBluetoothConnectType", "()Lcom/soletreadmills/sole_v2/_type/BluetoothConnectType;", "setBluetoothConnectType", "(Lcom/soletreadmills/sole_v2/_type/BluetoothConnectType;)V", "connectFtmsBleDeviceInfoData", "getConnectFtmsBleDeviceInfoData", "()Lcom/soletreadmills/sole_v2/_data/ble/BleDeviceInfoData;", "setConnectFtmsBleDeviceInfoData", "(Lcom/soletreadmills/sole_v2/_data/ble/BleDeviceInfoData;)V", "homeViewModel", "Lcom/soletreadmills/sole_v2/ui/home/HomeViewModel;", "getHomeViewModel", "()Lcom/soletreadmills/sole_v2/ui/home/HomeViewModel;", "homeViewModel$delegate", "Lkotlin/Lazy;", "typeFragment", "Lcom/soletreadmills/sole_v2/_type/BluetoothComeClassType;", "getTypeFragment", "()Lcom/soletreadmills/sole_v2/_type/BluetoothComeClassType;", "setTypeFragment", "(Lcom/soletreadmills/sole_v2/_type/BluetoothComeClassType;)V", "checkPermission", "", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", SdkConstants.ATTR_ON_CLICK, "v", "Landroid/view/View;", "onDestroyView", "onViewCreated", "view", "savedInstanceState", "Landroid/os/Bundle;", "setRecyclerview", "snSubscription", "name", "", "startScan", "stopScanSetList", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ConnectDeviceFragment extends BaseFragment<FragmentConnectDeviceBinding> implements View.OnClickListener {
    public static final int $stable = 8;
    private BleDeviceInfoData connectFtmsBleDeviceInfoData;

    /* renamed from: homeViewModel$delegate, reason: from kotlin metadata */
    private final Lazy homeViewModel;
    private BluetoothComeClassType typeFragment;
    private List<BleDeviceInfoData> bleList = new ArrayList();
    private BluetoothConnectType bluetoothConnectType = BluetoothConnectType.TREADMILL;
    private final ConnectDeviceFragment$bluetoothCallbackListener$1 bluetoothCallbackListener = new ConnectDeviceFragment$bluetoothCallbackListener$1(this);

    /* compiled from: ConnectDeviceFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[BluetoothConnectType.values().length];
            try {
                iArr[BluetoothConnectType.TREADMILL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BluetoothConnectType.BIKE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BluetoothConnectType.ELLIPTICAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[BluetoothConnectType.STEPPER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[BluetoothConnectType.ROWER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[BluetoothComeClassType.values().length];
            try {
                iArr2[BluetoothComeClassType.Subscription.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public ConnectDeviceFragment() {
        final ConnectDeviceFragment connectDeviceFragment = this;
        final Function0 function0 = null;
        this.homeViewModel = FragmentViewModelLazyKt.createViewModelLazy(connectDeviceFragment, Reflection.getOrCreateKotlinClass(HomeViewModel.class), new Function0<ViewModelStore>() { // from class: com.soletreadmills.sole_v2.ui.pair.ConnectDeviceFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = connectDeviceFragment.requireActivity().getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: com.soletreadmills.sole_v2.ui.pair.ConnectDeviceFragment$special$$inlined$activityViewModels$default$2
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
                CreationExtras defaultViewModelCreationExtras = connectDeviceFragment.requireActivity().getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.soletreadmills.sole_v2.ui.pair.ConnectDeviceFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = connectDeviceFragment.requireActivity().getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    public static final /* synthetic */ FragmentConnectDeviceBinding access$getBinding(ConnectDeviceFragment connectDeviceFragment) {
        return connectDeviceFragment.getBinding();
    }

    public final HomeViewModel getHomeViewModel() {
        return (HomeViewModel) this.homeViewModel.getValue();
    }

    public final List<BleDeviceInfoData> getBleList() {
        return this.bleList;
    }

    public final void setBleList(List<BleDeviceInfoData> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.bleList = list;
    }

    public final BleDeviceInfoData getConnectFtmsBleDeviceInfoData() {
        return this.connectFtmsBleDeviceInfoData;
    }

    public final void setConnectFtmsBleDeviceInfoData(BleDeviceInfoData bleDeviceInfoData) {
        this.connectFtmsBleDeviceInfoData = bleDeviceInfoData;
    }

    public final BluetoothConnectType getBluetoothConnectType() {
        return this.bluetoothConnectType;
    }

    public final void setBluetoothConnectType(BluetoothConnectType bluetoothConnectType) {
        Intrinsics.checkNotNullParameter(bluetoothConnectType, "<set-?>");
        this.bluetoothConnectType = bluetoothConnectType;
    }

    public final BluetoothComeClassType getTypeFragment() {
        return this.typeFragment;
    }

    public final void setTypeFragment(BluetoothComeClassType bluetoothComeClassType) {
        this.typeFragment = bluetoothComeClassType;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) throws CloneNotSupportedException {
        BluetoothConnectType bluetoothConnectTypeValueOf;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("type") : null;
        Bundle arguments2 = getArguments();
        String string2 = arguments2 != null ? arguments2.getString("deviceType") : null;
        this.typeFragment = BluetoothComeClassType.valueOf(string == null ? "" : string);
        Timber.INSTANCE.d("Type: " + string, new Object[0]);
        if (string2 == null || (bluetoothConnectTypeValueOf = BluetoothConnectType.valueOf(string2)) == null) {
            bluetoothConnectTypeValueOf = BluetoothConnectType.TREADMILL;
        }
        this.bluetoothConnectType = bluetoothConnectTypeValueOf;
        if (this.typeFragment == BluetoothComeClassType.Subscription) {
            checkPermission();
        } else {
            m8721getBleList();
        }
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        BleManager.getInstance().removeBluetoothCallbackListener(this.bluetoothCallbackListener);
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public FragmentConnectDeviceBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentConnectDeviceBinding fragmentConnectDeviceBindingInflate = FragmentConnectDeviceBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentConnectDeviceBindingInflate, "inflate(...)");
        return fragmentConnectDeviceBindingInflate;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public void initViews() {
        TextView textView;
        BleManager.getInstance().removeBluetoothCallbackListener(this.bluetoothCallbackListener);
        BleManager.getInstance().addBluetoothCallbackListener(this.bluetoothCallbackListener);
        FragmentConnectDeviceBinding binding = getBinding();
        if (binding == null || (textView = binding.tvDone) == null) {
            return;
        }
        textView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Integer numValueOf = v != null ? Integer.valueOf(v.getId()) : null;
        int i = R.id.tv_done;
        if (numValueOf != null && numValueOf.intValue() == i) {
            safeNavigateUp();
        }
    }

    /* compiled from: ConnectDeviceFragment.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "granted", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.soletreadmills.sole_v2.ui.pair.ConnectDeviceFragment$checkPermission$1, reason: invalid class name */
    static final class AnonymousClass1 extends Lambda implements Function1<Boolean, Unit> {
        AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.INSTANCE;
        }

        public final void invoke(boolean z) {
            BleManager bleManager;
            BleManager bleManager2;
            View root;
            BleManager bleManager3;
            if (z) {
                MainActivity mainActivity = ConnectDeviceFragment.this.getMainActivity();
                if (mainActivity != null && (bleManager2 = mainActivity.getBleManager()) != null && !bleManager2.isServiceConnection) {
                    MainActivity mainActivity2 = ConnectDeviceFragment.this.getMainActivity();
                    if (mainActivity2 != null && (bleManager3 = mainActivity2.getBleManager()) != null) {
                        bleManager3.init();
                    }
                    FragmentConnectDeviceBinding fragmentConnectDeviceBindingAccess$getBinding = ConnectDeviceFragment.access$getBinding(ConnectDeviceFragment.this);
                    if (fragmentConnectDeviceBindingAccess$getBinding == null || (root = fragmentConnectDeviceBindingAccess$getBinding.getRoot()) == null) {
                        return;
                    }
                    final ConnectDeviceFragment connectDeviceFragment = ConnectDeviceFragment.this;
                    root.postDelayed(new Runnable() { // from class: com.soletreadmills.sole_v2.ui.pair.ConnectDeviceFragment$checkPermission$1$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            ConnectDeviceFragment.AnonymousClass1.invoke$lambda$0(connectDeviceFragment);
                        }
                    }, 5000L);
                    return;
                }
                MainActivity mainActivity3 = ConnectDeviceFragment.this.getMainActivity();
                if (mainActivity3 == null || (bleManager = mainActivity3.getBleManager()) == null) {
                    return;
                }
                final ConnectDeviceFragment connectDeviceFragment2 = ConnectDeviceFragment.this;
                bleManager.checkBleEnabled(new EnabledBluetoothListener() { // from class: com.soletreadmills.sole_v2.ui.pair.ConnectDeviceFragment.checkPermission.1.2
                    @Override // com.soletreadmills.sole_v2.listener.EnabledBluetoothListener
                    public void OnDisable() {
                        EnabledBluetoothListener.DefaultImpls.OnDisable(this);
                    }

                    @Override // com.soletreadmills.sole_v2.listener.EnabledBluetoothListener
                    public void OnEnabled() {
                        Timber.INSTANCE.e("startScanBleDevice 0", new Object[0]);
                        connectDeviceFragment2.startScan();
                    }
                });
                return;
            }
            Toast.makeText(ConnectDeviceFragment.this.requireContext(), "Permission error", 0).show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$0(ConnectDeviceFragment this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            BleManager.getInstance().stopScanBleDevice();
            this$0.checkPermission();
        }
    }

    public final void checkPermission() {
        MainActivity mainActivity = getMainActivity();
        if (mainActivity != null) {
            mainActivity.checkBluetoothPermissions(new AnonymousClass1());
        }
    }

    public final void startScan() {
        View root;
        View root2;
        FragmentConnectDeviceBinding binding = getBinding();
        if (binding != null && (root2 = binding.getRoot()) != null) {
            root2.post(new Runnable() { // from class: com.soletreadmills.sole_v2.ui.pair.ConnectDeviceFragment$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ConnectDeviceFragment.startScan$lambda$1(this.f$0);
                }
            });
        }
        FragmentConnectDeviceBinding binding2 = getBinding();
        if (binding2 == null || (root = binding2.getRoot()) == null) {
            return;
        }
        root.postDelayed(new Runnable() { // from class: com.soletreadmills.sole_v2.ui.pair.ConnectDeviceFragment$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() throws CloneNotSupportedException {
                ConnectDeviceFragment.startScan$lambda$2(this.f$0);
            }
        }, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startScan$lambda$1(ConnectDeviceFragment this$0) {
        BleManager bleManager;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showLoading();
        MainActivity mainActivity = this$0.getMainActivity();
        BleManager bleManager2 = mainActivity != null ? mainActivity.getBleManager() : null;
        if (bleManager2 != null) {
            bleManager2.setBluetoothConnectType(BluetoothConnectType.MACHINE);
        }
        MainActivity mainActivity2 = this$0.getMainActivity();
        if (mainActivity2 == null || (bleManager = mainActivity2.getBleManager()) == null) {
            return;
        }
        bleManager.startScanBleDevice();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startScan$lambda$2(ConnectDeviceFragment this$0) throws CloneNotSupportedException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BleManager.getInstance().stopScanBleDevice();
        this$0.stopScanSetList();
        this$0.stopLoading();
    }

    public final void stopScanSetList() throws CloneNotSupportedException {
        ArrayList<BleDeviceInfoData> bleDeviceInfoDataList = BleManager.getInstance().getBleDeviceInfoDataList();
        Intrinsics.checkNotNullExpressionValue(bleDeviceInfoDataList, "getBleDeviceInfoDataList(...)");
        this.bleList = bleDeviceInfoDataList;
        setRecyclerview();
    }

    /* renamed from: getBleList, reason: collision with other method in class */
    public final void m8721getBleList() throws CloneNotSupportedException {
        List<BleDeviceInfoData> syncMachineList = getHomeViewModel().getSyncMachineList();
        List<BleDeviceInfoData> bleDevice = getBleDevice();
        BluetoothComeClassType bluetoothComeClassType = this.typeFragment;
        if ((bluetoothComeClassType == null ? -1 : WhenMappings.$EnumSwitchMapping$1[bluetoothComeClassType.ordinal()]) != 1) {
            List listPlus = CollectionsKt.plus((Collection) bleDevice, (Iterable) syncMachineList);
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(listPlus, 10)), 16));
            for (Object obj : listPlus) {
                linkedHashMap.put(((BleDeviceInfoData) obj).getName(), obj);
            }
            List mutableList = CollectionsKt.toMutableList(linkedHashMap.values());
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : mutableList) {
                BleDeviceInfoData bleDeviceInfoData = (BleDeviceInfoData) obj2;
                int i = WhenMappings.$EnumSwitchMapping$0[this.bluetoothConnectType.ordinal()];
                boolean z = false;
                if (i == 1 ? bleDeviceInfoData.getMachineType() == MachineType.TREADMILL : !(i == 2 ? bleDeviceInfoData.getMachineType() != MachineType.BIKE : i == 3 ? bleDeviceInfoData.getMachineType() != MachineType.ELLIPTICAL : i == 4 ? bleDeviceInfoData.getMachineType() != MachineType.STEPPER : i == 5 ? bleDeviceInfoData.getMachineType() != MachineType.ROWER : bleDeviceInfoData.getMachineType() != MachineType.TREADMILL && bleDeviceInfoData.getMachineType() != MachineType.BIKE && bleDeviceInfoData.getMachineType() != MachineType.ELLIPTICAL && bleDeviceInfoData.getMachineType() != MachineType.ROWER && bleDeviceInfoData.getMachineType() != MachineType.STEPPER)) {
                    z = true;
                }
                if (z) {
                    arrayList.add(obj2);
                }
            }
            this.bleList = CollectionsKt.toMutableList((Collection) arrayList);
        }
        setRecyclerview();
    }

    public final void setRecyclerview() throws CloneNotSupportedException {
        String bluetoothDeviceName;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        Context context = getContext();
        if (context != null) {
            FragmentConnectDeviceBinding binding = getBinding();
            RecyclerView.Adapter adapter = null;
            if (!(((binding == null || (recyclerView3 = binding.rvDevice) == null) ? null : recyclerView3.getLayoutManager()) instanceof LinearLayoutManager)) {
                FragmentConnectDeviceBinding binding2 = getBinding();
                RecyclerView recyclerView4 = binding2 != null ? binding2.rvDevice : null;
                if (recyclerView4 != null) {
                    recyclerView4.setLayoutManager(new LinearLayoutManager(context));
                }
            }
            FragmentConnectDeviceBinding binding3 = getBinding();
            if (!(((binding3 == null || (recyclerView2 = binding3.rvDevice) == null) ? null : recyclerView2.getAdapter()) instanceof ConnectDevicesAdapter)) {
                ConnectDevicesAdapter connectDevicesAdapter = new ConnectDevicesAdapter(new OnItemClickListener() { // from class: com.soletreadmills.sole_v2.ui.pair.ConnectDeviceFragment$setRecyclerview$1$adapter$1

                    /* compiled from: ConnectDeviceFragment.kt */
                    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                    public /* synthetic */ class WhenMappings {
                        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                        static {
                            int[] iArr = new int[BluetoothComeClassType.values().length];
                            try {
                                iArr[BluetoothComeClassType.ClubRaceFragment.ordinal()] = 1;
                            } catch (NoSuchFieldError unused) {
                            }
                            try {
                                iArr[BluetoothComeClassType.Rematch.ordinal()] = 2;
                            } catch (NoSuchFieldError unused2) {
                            }
                            try {
                                iArr[BluetoothComeClassType.Subscription.ordinal()] = 3;
                            } catch (NoSuchFieldError unused3) {
                            }
                            $EnumSwitchMapping$0 = iArr;
                        }
                    }

                    @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
                    public void onClick(int pos, String string) {
                        Intrinsics.checkNotNullParameter(string, "string");
                    }

                    @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
                    public void onClick(int pos) {
                        RecyclerView recyclerView5;
                        FragmentConnectDeviceBinding fragmentConnectDeviceBindingAccess$getBinding = ConnectDeviceFragment.access$getBinding(this.this$0);
                        RecyclerView.Adapter adapter2 = (fragmentConnectDeviceBindingAccess$getBinding == null || (recyclerView5 = fragmentConnectDeviceBindingAccess$getBinding.rvDevice) == null) ? null : recyclerView5.getAdapter();
                        if (adapter2 instanceof ConnectDevicesAdapter) {
                            List<BleDeviceInfoData> currentList = ((ConnectDevicesAdapter) adapter2).getCurrentList();
                            Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
                            final BleDeviceInfoData bleDeviceInfoData = currentList.get(pos);
                            if (BleManager.getInstance().isConnectedFtms() && this.this$0.getTypeFragment() != BluetoothComeClassType.Subscription) {
                                if (bleDeviceInfoData.getConnectionState() == 2) {
                                    BleManager.getInstance().bleFtmsDisconnect();
                                    return;
                                }
                                return;
                            }
                            BluetoothComeClassType typeFragment = this.this$0.getTypeFragment();
                            int i = typeFragment == null ? -1 : WhenMappings.$EnumSwitchMapping$0[typeFragment.ordinal()];
                            if (i != 1 && i != 2) {
                                if (i != 3) {
                                    return;
                                }
                                this.this$0.snSubscription(bleDeviceInfoData.getName());
                            } else {
                                MainActivity mainActivity = this.this$0.getMainActivity();
                                if (mainActivity != null) {
                                    final ConnectDeviceFragment connectDeviceFragment = this.this$0;
                                    mainActivity.checkBluetoothPermissions(new Function1<Boolean, Unit>() { // from class: com.soletreadmills.sole_v2.ui.pair.ConnectDeviceFragment$setRecyclerview$1$adapter$1$onClick$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                            invoke(bool.booleanValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(boolean z) {
                                            BleManager bleManager;
                                            BleManager bleManager2;
                                            MainActivity mainActivity2;
                                            BleManager bleManager3;
                                            if (z) {
                                                MainActivity mainActivity3 = connectDeviceFragment.getMainActivity();
                                                if (mainActivity3 != null && (bleManager2 = mainActivity3.getBleManager()) != null && !bleManager2.isServiceConnection && (mainActivity2 = connectDeviceFragment.getMainActivity()) != null && (bleManager3 = mainActivity2.getBleManager()) != null) {
                                                    bleManager3.init();
                                                }
                                                MainActivity mainActivity4 = connectDeviceFragment.getMainActivity();
                                                if (mainActivity4 == null || (bleManager = mainActivity4.getBleManager()) == null) {
                                                    return;
                                                }
                                                final BleDeviceInfoData bleDeviceInfoData2 = bleDeviceInfoData;
                                                final ConnectDeviceFragment connectDeviceFragment2 = connectDeviceFragment;
                                                bleManager.checkBleEnabled(new EnabledBluetoothListener() { // from class: com.soletreadmills.sole_v2.ui.pair.ConnectDeviceFragment$setRecyclerview$1$adapter$1$onClick$1.1
                                                    @Override // com.soletreadmills.sole_v2.listener.EnabledBluetoothListener
                                                    public void OnDisable() {
                                                        EnabledBluetoothListener.DefaultImpls.OnDisable(this);
                                                    }

                                                    @Override // com.soletreadmills.sole_v2.listener.EnabledBluetoothListener
                                                    public void OnEnabled() {
                                                        BleDeviceInfoData bleDeviceInfoData3 = bleDeviceInfoData2;
                                                        if (bleDeviceInfoData3 != null) {
                                                            ConnectDeviceFragment connectDeviceFragment3 = connectDeviceFragment2;
                                                            connectDeviceFragment3.setConnectFtmsBleDeviceInfoData(bleDeviceInfoData3);
                                                            MainActivity mainActivity5 = connectDeviceFragment3.getMainActivity();
                                                            if (mainActivity5 != null) {
                                                                BaseActivity.showPairingDialog$default(mainActivity5, 0, null, null, 4, null);
                                                            }
                                                            BleManager.getInstance().bleFtmsConnect(bleDeviceInfoData3, false);
                                                        }
                                                    }
                                                });
                                                return;
                                            }
                                            Toast.makeText(connectDeviceFragment.requireContext(), "Permission error", 0).show();
                                        }
                                    });
                                }
                            }
                        }
                    }
                });
                FragmentConnectDeviceBinding binding4 = getBinding();
                RecyclerView recyclerView5 = binding4 != null ? binding4.rvDevice : null;
                if (recyclerView5 != null) {
                    recyclerView5.setAdapter(connectDevicesAdapter);
                }
            }
            ArrayList arrayList = new ArrayList();
            if (BleManager.getInstance().isConnectedFtms()) {
                FtmsDeviceManager ftmsDeviceManager = BleManager.getInstance().getFtmsDeviceManager();
                bluetoothDeviceName = ftmsDeviceManager != null ? ftmsDeviceManager.getBluetoothDeviceName() : null;
            } else {
                bluetoothDeviceName = "";
            }
            Iterator<BleDeviceInfoData> it = this.bleList.iterator();
            while (it.hasNext()) {
                BleDeviceInfoData bleDeviceInfoDataM8608clone = it.next().m8608clone();
                if (Intrinsics.areEqual(bleDeviceInfoDataM8608clone.getName(), bluetoothDeviceName)) {
                    bleDeviceInfoDataM8608clone.setConnectionState(2);
                }
                arrayList.add(bleDeviceInfoDataM8608clone);
            }
            FragmentConnectDeviceBinding binding5 = getBinding();
            if (binding5 != null && (recyclerView = binding5.rvDevice) != null) {
                adapter = recyclerView.getAdapter();
            }
            if (adapter instanceof ConnectDevicesAdapter) {
                ((ConnectDevicesAdapter) adapter).submitList(arrayList);
            }
        }
    }

    /* compiled from: ConnectDeviceFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.pair.ConnectDeviceFragment$snSubscription$1", f = "ConnectDeviceFragment.kt", i = {}, l = {315}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.pair.ConnectDeviceFragment$snSubscription$1, reason: invalid class name and case insensitive filesystem */
    static final class C09921 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $name;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09921(String str, Continuation<? super C09921> continuation) {
            super(2, continuation);
            this.$name = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ConnectDeviceFragment.this.new C09921(this.$name, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09921) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            JwtApiBaseData.SysResponseMessage sysMsg;
            JwtApiBaseData.SysResponseMessage sysMsg2;
            JwtApiBaseData.SysResponseMessage sysMsg3;
            JwtApiBaseData.SysResponseMessage sysMsg4;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        ConnectDeviceFragment.this.showLoading();
                        this.label = 1;
                        obj = JwtDyacoApiKt.callBluetoothSubscription(new BluetoothSubscriptionApiData.RequestBody(this.$name), this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    BluetoothSubscriptionApiData.ResponseData responseData = (BluetoothSubscriptionApiData.ResponseData) ((Response) obj).body();
                    String message = null;
                    String code = (responseData == null || (sysMsg4 = responseData.getSysMsg()) == null) ? null : sysMsg4.getCode();
                    if (!Intrinsics.areEqual((responseData == null || (sysMsg3 = responseData.getSysMsg()) == null) ? null : sysMsg3.getCode(), JwtErrorCode.JWT_SUCCESS_1.getId())) {
                        String code2 = (responseData == null || (sysMsg2 = responseData.getSysMsg()) == null) ? null : sysMsg2.getCode();
                        if (ConnectDeviceFragment.this.shouldIgnoreError(code2)) {
                            return Unit.INSTANCE;
                        }
                        Integer num = (Integer) MapsKt.mapOf(TuplesKt.to(JwtErrorCode.JWT_ERROR_1501.getId(), Boxing.boxInt(R.string.error_jwt_1501))).get(code);
                        if (num != null) {
                            ConnectDeviceFragment connectDeviceFragment = ConnectDeviceFragment.this;
                            CustomDialogKt.showCustomDialog$default(connectDeviceFragment, connectDeviceFragment.getString(num.intValue()), "", null, null, null, null, false, 124, null);
                        } else {
                            ConnectDeviceFragment connectDeviceFragment2 = ConnectDeviceFragment.this;
                            if (responseData != null && (sysMsg = responseData.getSysMsg()) != null) {
                                message = sysMsg.getMessage();
                            }
                            BaseFragment.handleUndefinedError$default(connectDeviceFragment2, "snSubscription", code2, message, false, 8, null);
                        }
                    } else {
                        Global.INSTANCE.setSubscription(true);
                        BaseFragment.safeNavigateWithPopUp$default(ConnectDeviceFragment.this, R.id.userSubscriptionFragment, R.id.settingsMainFragment, false, null, 8, null);
                    }
                } catch (Exception e) {
                    String message2 = e.getMessage();
                    if (message2 == null) {
                        message2 = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(ConnectDeviceFragment.this, "snSubscription", message2, false, 4, null);
                }
                ConnectDeviceFragment.this.stopLoading();
                return Unit.INSTANCE;
            } finally {
                ConnectDeviceFragment.this.stopLoading();
            }
        }
    }

    public final void snSubscription(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C09921(name, null), 3, null);
    }
}
