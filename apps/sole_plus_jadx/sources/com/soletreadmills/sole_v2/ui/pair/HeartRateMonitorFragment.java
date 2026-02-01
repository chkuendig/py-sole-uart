package com.soletreadmills.sole_v2.ui.pair;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.android.SdkConstants;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.ble.BleDeviceInfoData;
import com.soletreadmills.sole_v2._manager.BleManager;
import com.soletreadmills.sole_v2._type.BluetoothConnectType;
import com.soletreadmills.sole_v2._type.MachineType;
import com.soletreadmills.sole_v2.databinding.FragmentHeartRateMonitorBinding;
import com.soletreadmills.sole_v2.listener.EnabledBluetoothListener;
import com.soletreadmills.sole_v2.listener.OnItemClickListener;
import com.soletreadmills.sole_v2.ui.MainActivity;
import com.soletreadmills.sole_v2.ui._base.BaseActivity;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import com.soletreadmills.sole_v2.ui.adapter.pair.ConnectHRMAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* compiled from: HeartRateMonitorFragment.kt */
@Metadata(d1 = {"\u0000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u001a\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0015H\u0016J\u0012\u0010\u001c\u001a\u00020\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0015H\u0016J\u0006\u0010 \u001a\u00020\u0015J\u0006\u0010!\u001a\u00020\u0015R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\""}, d2 = {"Lcom/soletreadmills/sole_v2/ui/pair/HeartRateMonitorFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/databinding/FragmentHeartRateMonitorBinding;", "Landroid/view/View$OnClickListener;", "()V", "bleDeviceList", "", "Lcom/soletreadmills/sole_v2/_data/ble/BleDeviceInfoData;", "getBleDeviceList", "()Ljava/util/List;", "setBleDeviceList", "(Ljava/util/List;)V", "bluetoothCallbackListener", "com/soletreadmills/sole_v2/ui/pair/HeartRateMonitorFragment$bluetoothCallbackListener$1", "Lcom/soletreadmills/sole_v2/ui/pair/HeartRateMonitorFragment$bluetoothCallbackListener$1;", "connectFtmsBleDeviceInfoData", "getConnectFtmsBleDeviceInfoData", "()Lcom/soletreadmills/sole_v2/_data/ble/BleDeviceInfoData;", "setConnectFtmsBleDeviceInfoData", "(Lcom/soletreadmills/sole_v2/_data/ble/BleDeviceInfoData;)V", "checkHasDevice", "", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", SdkConstants.ATTR_ON_CLICK, "v", "Landroid/view/View;", "onDestroyView", "setRecyclerview", "startScan", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HeartRateMonitorFragment extends BaseFragment<FragmentHeartRateMonitorBinding> implements View.OnClickListener {
    public static final int $stable = 8;
    private List<BleDeviceInfoData> bleDeviceList = new ArrayList();
    private final HeartRateMonitorFragment$bluetoothCallbackListener$1 bluetoothCallbackListener = new HeartRateMonitorFragment$bluetoothCallbackListener$1(this);
    private BleDeviceInfoData connectFtmsBleDeviceInfoData;

    public final List<BleDeviceInfoData> getBleDeviceList() {
        return this.bleDeviceList;
    }

    public final void setBleDeviceList(List<BleDeviceInfoData> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.bleDeviceList = list;
    }

    public final BleDeviceInfoData getConnectFtmsBleDeviceInfoData() {
        return this.connectFtmsBleDeviceInfoData;
    }

    public final void setConnectFtmsBleDeviceInfoData(BleDeviceInfoData bleDeviceInfoData) {
        this.connectFtmsBleDeviceInfoData = bleDeviceInfoData;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        BleManager.getInstance().removeBluetoothCallbackListener(this.bluetoothCallbackListener);
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public FragmentHeartRateMonitorBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentHeartRateMonitorBinding fragmentHeartRateMonitorBindingInflate = FragmentHeartRateMonitorBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentHeartRateMonitorBindingInflate, "inflate(...)");
        return fragmentHeartRateMonitorBindingInflate;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public void initViews() {
        TextView textView;
        SwipeRefreshLayout swipeRefreshLayout;
        TextView textView2;
        BleManager.getInstance().removeBluetoothCallbackListener(this.bluetoothCallbackListener);
        BleManager.getInstance().addBluetoothCallbackListener(this.bluetoothCallbackListener);
        FragmentHeartRateMonitorBinding binding = getBinding();
        if (binding != null && (textView2 = binding.tvCancelBtn) != null) {
            textView2.setOnClickListener(this);
        }
        FragmentHeartRateMonitorBinding binding2 = getBinding();
        if (binding2 != null && (swipeRefreshLayout = binding2.swipeRefreshLayout) != null) {
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.soletreadmills.sole_v2.ui.pair.HeartRateMonitorFragment$$ExternalSyntheticLambda0
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
                public final void onRefresh() {
                    HeartRateMonitorFragment.initViews$lambda$0(this.f$0);
                }
            });
        }
        FragmentHeartRateMonitorBinding binding3 = getBinding();
        if (binding3 != null && (textView = binding3.tvCancelBtn) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.pair.HeartRateMonitorFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HeartRateMonitorFragment.initViews$lambda$1(this.f$0, view);
                }
            });
        }
        MainActivity mainActivity = getMainActivity();
        if (mainActivity != null) {
            mainActivity.checkBluetoothPermissions(new Function1<Boolean, Unit>() { // from class: com.soletreadmills.sole_v2.ui.pair.HeartRateMonitorFragment.initViews.3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) throws CloneNotSupportedException {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z) throws CloneNotSupportedException {
                    BleManager bleManager;
                    BleManager bleManager2;
                    MainActivity mainActivity2;
                    BleManager bleManager3;
                    if (z) {
                        MainActivity mainActivity3 = HeartRateMonitorFragment.this.getMainActivity();
                        if (mainActivity3 != null && (bleManager2 = mainActivity3.getBleManager()) != null && !bleManager2.isServiceConnection && (mainActivity2 = HeartRateMonitorFragment.this.getMainActivity()) != null && (bleManager3 = mainActivity2.getBleManager()) != null) {
                            bleManager3.init();
                        }
                        MainActivity mainActivity4 = HeartRateMonitorFragment.this.getMainActivity();
                        if (mainActivity4 == null || (bleManager = mainActivity4.getBleManager()) == null) {
                            return;
                        }
                        final HeartRateMonitorFragment heartRateMonitorFragment = HeartRateMonitorFragment.this;
                        bleManager.checkBleEnabled(new EnabledBluetoothListener() { // from class: com.soletreadmills.sole_v2.ui.pair.HeartRateMonitorFragment.initViews.3.1
                            @Override // com.soletreadmills.sole_v2.listener.EnabledBluetoothListener
                            public void OnDisable() {
                                EnabledBluetoothListener.DefaultImpls.OnDisable(this);
                            }

                            @Override // com.soletreadmills.sole_v2.listener.EnabledBluetoothListener
                            public void OnEnabled() {
                                heartRateMonitorFragment.startScan();
                            }
                        });
                        return;
                    }
                    Toast.makeText(HeartRateMonitorFragment.this.requireContext(), "Permission error", 0).show();
                    HeartRateMonitorFragment.this.checkHasDevice();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$0(HeartRateMonitorFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startScan();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$1(HeartRateMonitorFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.safeNavigateUp();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Integer numValueOf = v != null ? Integer.valueOf(v.getId()) : null;
        int i = R.id.btn_cancel;
        if (numValueOf != null && numValueOf.intValue() == i) {
            safeNavigateUp();
        }
    }

    public final void startScan() {
        View root;
        View root2;
        FragmentHeartRateMonitorBinding binding = getBinding();
        if (binding != null && (root2 = binding.getRoot()) != null) {
            root2.post(new Runnable() { // from class: com.soletreadmills.sole_v2.ui.pair.HeartRateMonitorFragment$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    HeartRateMonitorFragment.startScan$lambda$2(this.f$0);
                }
            });
        }
        FragmentHeartRateMonitorBinding binding2 = getBinding();
        if (binding2 == null || (root = binding2.getRoot()) == null) {
            return;
        }
        root.postDelayed(new Runnable() { // from class: com.soletreadmills.sole_v2.ui.pair.HeartRateMonitorFragment$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() throws CloneNotSupportedException {
                HeartRateMonitorFragment.startScan$lambda$3(this.f$0);
            }
        }, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startScan$lambda$2(HeartRateMonitorFragment this$0) {
        BleManager bleManager;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showLoading();
        MainActivity mainActivity = this$0.getMainActivity();
        BleManager bleManager2 = mainActivity != null ? mainActivity.getBleManager() : null;
        if (bleManager2 != null) {
            bleManager2.setBluetoothConnectType(BluetoothConnectType.WATCH);
        }
        MainActivity mainActivity2 = this$0.getMainActivity();
        if (mainActivity2 == null || (bleManager = mainActivity2.getBleManager()) == null) {
            return;
        }
        bleManager.startScanBleDevice();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startScan$lambda$3(HeartRateMonitorFragment this$0) throws CloneNotSupportedException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.stopLoading();
        BleManager.getInstance().stopScanBleDevice();
        this$0.checkHasDevice();
        FragmentHeartRateMonitorBinding binding = this$0.getBinding();
        SwipeRefreshLayout swipeRefreshLayout = binding != null ? binding.swipeRefreshLayout : null;
        if (swipeRefreshLayout == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkHasDevice() throws CloneNotSupportedException {
        if (!isAdded() || getBinding() == null) {
            Timber.INSTANCE.e("checkHasDevice return", new Object[0]);
            return;
        }
        ArrayList<BleDeviceInfoData> bleDeviceInfoDataList = BleManager.getInstance().getBleDeviceInfoDataList();
        Intrinsics.checkNotNullExpressionValue(bleDeviceInfoDataList, "getBleDeviceInfoDataList(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : bleDeviceInfoDataList) {
            if (((BleDeviceInfoData) obj).getMachineType() == MachineType.HR) {
                arrayList.add(obj);
            }
        }
        this.bleDeviceList = CollectionsKt.toMutableList((Collection) arrayList);
        setRecyclerview();
    }

    public final void setRecyclerview() throws CloneNotSupportedException {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        Context context = getContext();
        if (context != null) {
            FragmentHeartRateMonitorBinding binding = getBinding();
            RecyclerView.Adapter adapter = null;
            if (!(((binding == null || (recyclerView3 = binding.rvHrm) == null) ? null : recyclerView3.getLayoutManager()) instanceof LinearLayoutManager)) {
                FragmentHeartRateMonitorBinding binding2 = getBinding();
                RecyclerView recyclerView4 = binding2 != null ? binding2.rvHrm : null;
                if (recyclerView4 != null) {
                    recyclerView4.setLayoutManager(new LinearLayoutManager(context));
                }
            }
            FragmentHeartRateMonitorBinding binding3 = getBinding();
            if (!(((binding3 == null || (recyclerView2 = binding3.rvHrm) == null) ? null : recyclerView2.getAdapter()) instanceof ConnectHRMAdapter)) {
                ConnectHRMAdapter connectHRMAdapter = new ConnectHRMAdapter(new OnItemClickListener() { // from class: com.soletreadmills.sole_v2.ui.pair.HeartRateMonitorFragment$setRecyclerview$1$adapter$1
                    @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
                    public void onClick(int pos, String string) {
                        Intrinsics.checkNotNullParameter(string, "string");
                    }

                    @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
                    public void onClick(int pos) {
                        RecyclerView recyclerView5;
                        FragmentHeartRateMonitorBinding binding4 = this.this$0.getBinding();
                        RecyclerView.Adapter adapter2 = (binding4 == null || (recyclerView5 = binding4.rvHrm) == null) ? null : recyclerView5.getAdapter();
                        if (adapter2 instanceof ConnectHRMAdapter) {
                            List<BleDeviceInfoData> currentList = ((ConnectHRMAdapter) adapter2).getCurrentList();
                            Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
                            final BleDeviceInfoData bleDeviceInfoData = currentList.get(pos);
                            if (BleManager.getInstance().isConnectedHr()) {
                                if (bleDeviceInfoData.getConnectionState() == 2) {
                                    BleManager.getInstance().bleHrDisconnect();
                                }
                            } else {
                                MainActivity mainActivity = this.this$0.getMainActivity();
                                if (mainActivity != null) {
                                    final HeartRateMonitorFragment heartRateMonitorFragment = this.this$0;
                                    mainActivity.checkBluetoothPermissions(new Function1<Boolean, Unit>() { // from class: com.soletreadmills.sole_v2.ui.pair.HeartRateMonitorFragment$setRecyclerview$1$adapter$1$onClick$1
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
                                                MainActivity mainActivity3 = heartRateMonitorFragment.getMainActivity();
                                                if (mainActivity3 != null && (bleManager2 = mainActivity3.getBleManager()) != null && !bleManager2.isServiceConnection && (mainActivity2 = heartRateMonitorFragment.getMainActivity()) != null && (bleManager3 = mainActivity2.getBleManager()) != null) {
                                                    bleManager3.init();
                                                }
                                                MainActivity mainActivity4 = heartRateMonitorFragment.getMainActivity();
                                                if (mainActivity4 == null || (bleManager = mainActivity4.getBleManager()) == null) {
                                                    return;
                                                }
                                                final BleDeviceInfoData bleDeviceInfoData2 = bleDeviceInfoData;
                                                final HeartRateMonitorFragment heartRateMonitorFragment2 = heartRateMonitorFragment;
                                                bleManager.checkBleEnabled(new EnabledBluetoothListener() { // from class: com.soletreadmills.sole_v2.ui.pair.HeartRateMonitorFragment$setRecyclerview$1$adapter$1$onClick$1.1
                                                    @Override // com.soletreadmills.sole_v2.listener.EnabledBluetoothListener
                                                    public void OnDisable() {
                                                        EnabledBluetoothListener.DefaultImpls.OnDisable(this);
                                                    }

                                                    @Override // com.soletreadmills.sole_v2.listener.EnabledBluetoothListener
                                                    public void OnEnabled() {
                                                        BleDeviceInfoData bleDeviceInfoData3 = bleDeviceInfoData2;
                                                        if (bleDeviceInfoData3 != null) {
                                                            HeartRateMonitorFragment heartRateMonitorFragment3 = heartRateMonitorFragment2;
                                                            heartRateMonitorFragment3.setConnectFtmsBleDeviceInfoData(bleDeviceInfoData3);
                                                            MainActivity mainActivity5 = heartRateMonitorFragment3.getMainActivity();
                                                            if (mainActivity5 != null) {
                                                                BaseActivity.showPairingDialog$default(mainActivity5, 0, null, null, 4, null);
                                                            }
                                                            BleManager.getInstance().bleHrConnect(bleDeviceInfoData3, true, false);
                                                        }
                                                    }
                                                });
                                                return;
                                            }
                                            Toast.makeText(heartRateMonitorFragment.requireContext(), "Permission error", 0).show();
                                        }
                                    });
                                }
                            }
                        }
                    }
                });
                FragmentHeartRateMonitorBinding binding4 = getBinding();
                RecyclerView recyclerView5 = binding4 != null ? binding4.rvHrm : null;
                if (recyclerView5 != null) {
                    recyclerView5.setAdapter(connectHRMAdapter);
                }
            }
            ArrayList arrayList = new ArrayList();
            BluetoothDevice connectedBluetoothDeviceHr = BleManager.getInstance().getConnectedBluetoothDeviceHr();
            String address = connectedBluetoothDeviceHr != null ? connectedBluetoothDeviceHr.getAddress() : null;
            Iterator<BleDeviceInfoData> it = this.bleDeviceList.iterator();
            while (it.hasNext()) {
                BleDeviceInfoData bleDeviceInfoDataM8608clone = it.next().m8608clone();
                if (Intrinsics.areEqual(bleDeviceInfoDataM8608clone.getAddress(), address)) {
                    bleDeviceInfoDataM8608clone.setConnectionState(2);
                }
                arrayList.add(bleDeviceInfoDataM8608clone);
            }
            FragmentHeartRateMonitorBinding binding5 = getBinding();
            if (binding5 != null && (recyclerView = binding5.rvHrm) != null) {
                adapter = recyclerView.getAdapter();
            }
            if (adapter instanceof ConnectHRMAdapter) {
                ((ConnectHRMAdapter) adapter).submitList(arrayList);
            }
        }
    }
}
