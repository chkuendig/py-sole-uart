package com.soletreadmills.sole_v2.ui.pair;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.SdkConstants;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.ble.BleDeviceInfoData;
import com.soletreadmills.sole_v2._manager.BleManager;
import com.soletreadmills.sole_v2.ble.manager.FtmsDeviceManager;
import com.soletreadmills.sole_v2.databinding.FragmentMyDevicesBinding;
import com.soletreadmills.sole_v2.listener.EnabledBluetoothListener;
import com.soletreadmills.sole_v2.listener.OnItemClickListener;
import com.soletreadmills.sole_v2.ui.MainActivity;
import com.soletreadmills.sole_v2.ui._base.BaseActivity;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import com.soletreadmills.sole_v2.ui.adapter.pair.MyDevicesAdapter;
import com.soletreadmills.sole_v2.ui.customview.SelectBleConnectCustom;
import com.soletreadmills.sole_v2.ui.home.HomeViewModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: MyDevicesFragment.kt */
@Metadata(d1 = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0006\u0010\b\u001a\u00020\u001fJ\u001a\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010%\u001a\u00020\u001fH\u0016J\u0012\u0010&\u001a\u00020\u001f2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0012\u0010)\u001a\u00020\u001f2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u0010,\u001a\u00020\u001fH\u0016J\u0006\u0010-\u001a\u00020\u001fJ\u0006\u0010.\u001a\u00020\u001fJ\u0006\u0010/\u001a\u00020\u001fR \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0014\u001a\u00020\u00158FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u00060"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/pair/MyDevicesFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/databinding/FragmentMyDevicesBinding;", "Landroid/view/View$OnClickListener;", "()V", "bleList", "", "Lcom/soletreadmills/sole_v2/_data/ble/BleDeviceInfoData;", "getBleList", "()Ljava/util/List;", "setBleList", "(Ljava/util/List;)V", "bluetoothCallbackListener", "com/soletreadmills/sole_v2/ui/pair/MyDevicesFragment$bluetoothCallbackListener$1", "Lcom/soletreadmills/sole_v2/ui/pair/MyDevicesFragment$bluetoothCallbackListener$1;", "connectFtmsBleDeviceInfoData", "getConnectFtmsBleDeviceInfoData", "()Lcom/soletreadmills/sole_v2/_data/ble/BleDeviceInfoData;", "setConnectFtmsBleDeviceInfoData", "(Lcom/soletreadmills/sole_v2/_data/ble/BleDeviceInfoData;)V", "homeViewModel", "Lcom/soletreadmills/sole_v2/ui/home/HomeViewModel;", "getHomeViewModel", "()Lcom/soletreadmills/sole_v2/ui/home/HomeViewModel;", "homeViewModel$delegate", "Lkotlin/Lazy;", "isEdit", "", "()Z", "setEdit", "(Z)V", "", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", SdkConstants.ATTR_ON_CLICK, "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "setEditView", "setRecyclerview", "unPair", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MyDevicesFragment extends BaseFragment<FragmentMyDevicesBinding> implements View.OnClickListener {
    public static final int $stable = 8;
    private List<BleDeviceInfoData> bleList = new ArrayList();
    private final MyDevicesFragment$bluetoothCallbackListener$1 bluetoothCallbackListener = new MyDevicesFragment$bluetoothCallbackListener$1(this);
    private BleDeviceInfoData connectFtmsBleDeviceInfoData;

    /* renamed from: homeViewModel$delegate, reason: from kotlin metadata */
    private final Lazy homeViewModel;
    private boolean isEdit;

    public MyDevicesFragment() {
        final MyDevicesFragment myDevicesFragment = this;
        final Function0 function0 = null;
        this.homeViewModel = FragmentViewModelLazyKt.createViewModelLazy(myDevicesFragment, Reflection.getOrCreateKotlinClass(HomeViewModel.class), new Function0<ViewModelStore>() { // from class: com.soletreadmills.sole_v2.ui.pair.MyDevicesFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = myDevicesFragment.requireActivity().getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: com.soletreadmills.sole_v2.ui.pair.MyDevicesFragment$special$$inlined$activityViewModels$default$2
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
                CreationExtras defaultViewModelCreationExtras = myDevicesFragment.requireActivity().getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.soletreadmills.sole_v2.ui.pair.MyDevicesFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = myDevicesFragment.requireActivity().getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    public static final /* synthetic */ FragmentMyDevicesBinding access$getBinding(MyDevicesFragment myDevicesFragment) {
        return myDevicesFragment.getBinding();
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

    /* renamed from: isEdit, reason: from getter */
    public final boolean getIsEdit() {
        return this.isEdit;
    }

    public final void setEdit(boolean z) {
        this.isEdit = z;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        BleManager.getInstance().removeBluetoothCallbackListener(this.bluetoothCallbackListener);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public FragmentMyDevicesBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentMyDevicesBinding fragmentMyDevicesBindingInflate = FragmentMyDevicesBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentMyDevicesBindingInflate, "inflate(...)");
        return fragmentMyDevicesBindingInflate;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public void initViews() throws CloneNotSupportedException {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        TextView textView;
        ImageView imageView;
        BleManager.getInstance().removeBluetoothCallbackListener(this.bluetoothCallbackListener);
        BleManager.getInstance().addBluetoothCallbackListener(this.bluetoothCallbackListener);
        FragmentMyDevicesBinding binding = getBinding();
        if (binding != null && (imageView = binding.back) != null) {
            imageView.setOnClickListener(this);
        }
        FragmentMyDevicesBinding binding2 = getBinding();
        if (binding2 != null && (textView = binding2.edit) != null) {
            textView.setOnClickListener(this);
        }
        FragmentMyDevicesBinding binding3 = getBinding();
        if (binding3 != null && (linearLayout2 = binding3.LLUnpair) != null) {
            linearLayout2.setOnClickListener(this);
        }
        FragmentMyDevicesBinding binding4 = getBinding();
        if (binding4 != null && (linearLayout = binding4.LLAddDevice) != null) {
            linearLayout.setOnClickListener(this);
        }
        m8725getBleList();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) throws CloneNotSupportedException {
        MainActivity mainActivity;
        Integer numValueOf = v != null ? Integer.valueOf(v.getId()) : null;
        int i = R.id.back;
        if (numValueOf != null && numValueOf.intValue() == i) {
            safeNavigateUp();
            return;
        }
        int i2 = R.id.edit;
        if (numValueOf != null && numValueOf.intValue() == i2) {
            if (this.bleList.size() <= 0) {
                return;
            }
            this.isEdit = !this.isEdit;
            setRecyclerview();
            setEditView();
            return;
        }
        int i3 = R.id.LL_unpair;
        if (numValueOf != null && numValueOf.intValue() == i3) {
            unPair();
            return;
        }
        int i4 = R.id.LL_addDevice;
        if (numValueOf == null || numValueOf.intValue() != i4 || (mainActivity = getMainActivity()) == null) {
            return;
        }
        mainActivity.getChangeViewManager().changePage(new SelectBleConnectCustom(mainActivity, new OnItemClickListener() { // from class: com.soletreadmills.sole_v2.ui.pair.MyDevicesFragment$onClick$1$1
            @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
            public void onClick(int pos, String string) {
                Intrinsics.checkNotNullParameter(string, "string");
            }

            @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
            public void onClick(int pos) {
                if (pos == 0) {
                    BaseFragment.safeNavigate$default(this.this$0, R.id.QRCodeFragment, null, 2, null);
                } else {
                    if (pos != 1) {
                        return;
                    }
                    BaseFragment.safeNavigate$default(this.this$0, R.id.pairDeviceFragment, null, 2, null);
                }
            }
        }));
    }

    /* renamed from: getBleList, reason: collision with other method in class */
    public final void m8725getBleList() throws CloneNotSupportedException {
        List listPlus = CollectionsKt.plus((Collection) getBleDevice(), (Iterable) getHomeViewModel().getSyncMachineList());
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(listPlus, 10)), 16));
        for (Object obj : listPlus) {
            linkedHashMap.put(((BleDeviceInfoData) obj).getName(), obj);
        }
        List<BleDeviceInfoData> mutableList = CollectionsKt.toMutableList(linkedHashMap.values());
        this.bleList = mutableList;
        if (mutableList.isEmpty()) {
            this.isEdit = false;
            FragmentMyDevicesBinding binding = getBinding();
            LinearLayout linearLayout = binding != null ? binding.LLAddDevice : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            FragmentMyDevicesBinding binding2 = getBinding();
            LinearLayout linearLayout2 = binding2 != null ? binding2.LLUnpair : null;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
            FragmentMyDevicesBinding binding3 = getBinding();
            TextView textView = binding3 != null ? binding3.edit : null;
            if (textView != null) {
                textView.setText(getString(R.string.edit));
            }
        }
        setRecyclerview();
        FragmentMyDevicesBinding binding4 = getBinding();
        TextView textView2 = binding4 != null ? binding4.tvUnpair : null;
        if (textView2 == null) {
            return;
        }
        textView2.setText(getString(R.string.unpair_selected, "0"));
    }

    public final void setEditView() {
        LinearLayout linearLayout;
        if (this.isEdit) {
            FragmentMyDevicesBinding binding = getBinding();
            TextView textView = binding != null ? binding.edit : null;
            if (textView != null) {
                textView.setText(getString(R.string.done));
            }
            FragmentMyDevicesBinding binding2 = getBinding();
            LinearLayout linearLayout2 = binding2 != null ? binding2.LLAddDevice : null;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
            FragmentMyDevicesBinding binding3 = getBinding();
            linearLayout = binding3 != null ? binding3.LLUnpair : null;
            if (linearLayout == null) {
                return;
            }
            linearLayout.setVisibility(0);
            return;
        }
        FragmentMyDevicesBinding binding4 = getBinding();
        TextView textView2 = binding4 != null ? binding4.edit : null;
        if (textView2 != null) {
            textView2.setText(getString(R.string.edit));
        }
        FragmentMyDevicesBinding binding5 = getBinding();
        LinearLayout linearLayout3 = binding5 != null ? binding5.LLAddDevice : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(0);
        }
        FragmentMyDevicesBinding binding6 = getBinding();
        linearLayout = binding6 != null ? binding6.LLUnpair : null;
        if (linearLayout == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }

    public final void setRecyclerview() throws CloneNotSupportedException {
        String bluetoothDeviceName;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        Context context = getContext();
        if (context != null) {
            FragmentMyDevicesBinding binding = getBinding();
            RecyclerView.Adapter adapter = null;
            if (!(((binding == null || (recyclerView3 = binding.recyclerview) == null) ? null : recyclerView3.getLayoutManager()) instanceof LinearLayoutManager)) {
                FragmentMyDevicesBinding binding2 = getBinding();
                RecyclerView recyclerView4 = binding2 != null ? binding2.recyclerview : null;
                if (recyclerView4 != null) {
                    recyclerView4.setLayoutManager(new LinearLayoutManager(context));
                }
            }
            FragmentMyDevicesBinding binding3 = getBinding();
            if (!(((binding3 == null || (recyclerView2 = binding3.recyclerview) == null) ? null : recyclerView2.getAdapter()) instanceof MyDevicesAdapter)) {
                MyDevicesAdapter myDevicesAdapter = new MyDevicesAdapter(new OnItemClickListener() { // from class: com.soletreadmills.sole_v2.ui.pair.MyDevicesFragment$setRecyclerview$1$adapter$1
                    @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
                    public void onClick(int pos) {
                        RecyclerView recyclerView5;
                        if (this.this$0.getIsEdit()) {
                            return;
                        }
                        FragmentMyDevicesBinding fragmentMyDevicesBindingAccess$getBinding = MyDevicesFragment.access$getBinding(this.this$0);
                        RecyclerView.Adapter adapter2 = (fragmentMyDevicesBindingAccess$getBinding == null || (recyclerView5 = fragmentMyDevicesBindingAccess$getBinding.recyclerview) == null) ? null : recyclerView5.getAdapter();
                        if (adapter2 instanceof MyDevicesAdapter) {
                            List<BleDeviceInfoData> currentList = ((MyDevicesAdapter) adapter2).getCurrentList();
                            Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
                            final BleDeviceInfoData bleDeviceInfoData = currentList.get(pos);
                            if (BleManager.getInstance().isConnectedFtms()) {
                                if (bleDeviceInfoData.getConnectionState() == 2) {
                                    BleManager.getInstance().bleFtmsDisconnect();
                                }
                            } else {
                                MainActivity mainActivity = this.this$0.getMainActivity();
                                if (mainActivity != null) {
                                    final MyDevicesFragment myDevicesFragment = this.this$0;
                                    mainActivity.checkBluetoothPermissions(new Function1<Boolean, Unit>() { // from class: com.soletreadmills.sole_v2.ui.pair.MyDevicesFragment$setRecyclerview$1$adapter$1$onClick$1
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
                                                MainActivity mainActivity3 = myDevicesFragment.getMainActivity();
                                                if (mainActivity3 != null && (bleManager2 = mainActivity3.getBleManager()) != null && !bleManager2.isServiceConnection && (mainActivity2 = myDevicesFragment.getMainActivity()) != null && (bleManager3 = mainActivity2.getBleManager()) != null) {
                                                    bleManager3.init();
                                                }
                                                MainActivity mainActivity4 = myDevicesFragment.getMainActivity();
                                                if (mainActivity4 == null || (bleManager = mainActivity4.getBleManager()) == null) {
                                                    return;
                                                }
                                                final BleDeviceInfoData bleDeviceInfoData2 = bleDeviceInfoData;
                                                final MyDevicesFragment myDevicesFragment2 = myDevicesFragment;
                                                bleManager.checkBleEnabled(new EnabledBluetoothListener() { // from class: com.soletreadmills.sole_v2.ui.pair.MyDevicesFragment$setRecyclerview$1$adapter$1$onClick$1.1
                                                    @Override // com.soletreadmills.sole_v2.listener.EnabledBluetoothListener
                                                    public void OnDisable() {
                                                        EnabledBluetoothListener.DefaultImpls.OnDisable(this);
                                                    }

                                                    @Override // com.soletreadmills.sole_v2.listener.EnabledBluetoothListener
                                                    public void OnEnabled() {
                                                        BleDeviceInfoData bleDeviceInfoData3 = bleDeviceInfoData2;
                                                        if (bleDeviceInfoData3 != null) {
                                                            MyDevicesFragment myDevicesFragment3 = myDevicesFragment2;
                                                            myDevicesFragment3.setConnectFtmsBleDeviceInfoData(bleDeviceInfoData3);
                                                            MainActivity mainActivity5 = myDevicesFragment3.getMainActivity();
                                                            if (mainActivity5 != null) {
                                                                BaseActivity.showPairingDialog$default(mainActivity5, 0, null, null, 4, null);
                                                            }
                                                            BleManager.getInstance().bleFtmsConnect(bleDeviceInfoData3, false);
                                                        }
                                                    }
                                                });
                                                return;
                                            }
                                            Toast.makeText(myDevicesFragment.requireContext(), "Permission error", 0).show();
                                        }
                                    });
                                }
                            }
                        }
                    }

                    @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
                    public void onClick(int pos, String string) {
                        RecyclerView recyclerView5;
                        Intrinsics.checkNotNullParameter(string, "string");
                        if (Intrinsics.areEqual(string, "select")) {
                            FragmentMyDevicesBinding fragmentMyDevicesBindingAccess$getBinding = MyDevicesFragment.access$getBinding(this.this$0);
                            RecyclerView.Adapter adapter2 = (fragmentMyDevicesBindingAccess$getBinding == null || (recyclerView5 = fragmentMyDevicesBindingAccess$getBinding.recyclerview) == null) ? null : recyclerView5.getAdapter();
                            if (adapter2 instanceof MyDevicesAdapter) {
                                List<BleDeviceInfoData> currentList = ((MyDevicesAdapter) adapter2).getCurrentList();
                                Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
                                Iterator<BleDeviceInfoData> it = currentList.iterator();
                                int i = 0;
                                while (it.hasNext()) {
                                    if (it.next().getIsSelect()) {
                                        i++;
                                    }
                                }
                                FragmentMyDevicesBinding fragmentMyDevicesBindingAccess$getBinding2 = MyDevicesFragment.access$getBinding(this.this$0);
                                TextView textView = fragmentMyDevicesBindingAccess$getBinding2 != null ? fragmentMyDevicesBindingAccess$getBinding2.tvUnpair : null;
                                if (textView == null) {
                                    return;
                                }
                                textView.setText(this.this$0.getString(R.string.unpair_selected, String.valueOf(i)));
                            }
                        }
                    }
                });
                FragmentMyDevicesBinding binding4 = getBinding();
                RecyclerView recyclerView5 = binding4 != null ? binding4.recyclerview : null;
                if (recyclerView5 != null) {
                    recyclerView5.setAdapter(myDevicesAdapter);
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
                bleDeviceInfoDataM8608clone.setEdit(this.isEdit);
                if (Intrinsics.areEqual(bleDeviceInfoDataM8608clone.getName(), bluetoothDeviceName)) {
                    bleDeviceInfoDataM8608clone.setConnectionState(2);
                }
                arrayList.add(bleDeviceInfoDataM8608clone);
            }
            if (arrayList.isEmpty()) {
                FragmentMyDevicesBinding binding5 = getBinding();
                RecyclerView recyclerView6 = binding5 != null ? binding5.recyclerview : null;
                if (recyclerView6 != null) {
                    recyclerView6.setVisibility(8);
                }
                FragmentMyDevicesBinding binding6 = getBinding();
                ConstraintLayout constraintLayout = binding6 != null ? binding6.CLNoSearch : null;
                if (constraintLayout != null) {
                    constraintLayout.setVisibility(0);
                }
            } else {
                FragmentMyDevicesBinding binding7 = getBinding();
                RecyclerView recyclerView7 = binding7 != null ? binding7.recyclerview : null;
                if (recyclerView7 != null) {
                    recyclerView7.setVisibility(0);
                }
                FragmentMyDevicesBinding binding8 = getBinding();
                ConstraintLayout constraintLayout2 = binding8 != null ? binding8.CLNoSearch : null;
                if (constraintLayout2 != null) {
                    constraintLayout2.setVisibility(8);
                }
            }
            FragmentMyDevicesBinding binding9 = getBinding();
            if (binding9 != null && (recyclerView = binding9.recyclerview) != null) {
                adapter = recyclerView.getAdapter();
            }
            if (adapter instanceof MyDevicesAdapter) {
                ((MyDevicesAdapter) adapter).submitList(arrayList);
            }
        }
    }

    /* compiled from: MyDevicesFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.pair.MyDevicesFragment$unPair$1", f = "MyDevicesFragment.kt", i = {0, 0}, l = {408}, m = "invokeSuspend", n = {"selectDevices", "selectUserSyncDevices"}, s = {"L$0", "L$1"})
    /* renamed from: com.soletreadmills.sole_v2.ui.pair.MyDevicesFragment$unPair$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MyDevicesFragment.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:110:0x026c A[Catch: all -> 0x02c0, Exception -> 0x02c2, TRY_LEAVE, TryCatch #2 {Exception -> 0x02c2, blocks: (B:6:0x0017, B:73:0x016d, B:75:0x0177, B:77:0x017d, B:78:0x0194, B:80:0x019a, B:82:0x01a8, B:91:0x01d1, B:85:0x01b2, B:86:0x01b6, B:88:0x01bc, B:92:0x01d5, B:107:0x0262, B:108:0x0266, B:110:0x026c, B:128:0x02ab, B:94:0x01ea, B:96:0x01f1, B:98:0x01f9, B:99:0x01fd, B:101:0x0230, B:102:0x024b, B:104:0x0254, B:106:0x025b, B:11:0x0029, B:13:0x0031, B:15:0x0035, B:17:0x003b, B:19:0x003f, B:20:0x0057, B:22:0x005d, B:24:0x006a, B:25:0x006e, B:27:0x0077, B:30:0x0084, B:32:0x0098, B:35:0x009f, B:36:0x00a6, B:38:0x00ac, B:42:0x00bf, B:44:0x00c3, B:45:0x00da, B:46:0x00e1, B:48:0x00e7, B:52:0x00f6, B:54:0x00fa, B:55:0x0101, B:56:0x010f, B:58:0x0115, B:60:0x0122, B:61:0x0126, B:63:0x0132, B:64:0x013d, B:66:0x0143, B:68:0x014f, B:69:0x0157), top: B:142:0x000b, outer: #0 }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r17) throws java.lang.CloneNotSupportedException {
            /*
                Method dump skipped, instructions count: 758
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.pair.MyDevicesFragment.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final void unPair() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new AnonymousClass1(null), 3, null);
    }
}
