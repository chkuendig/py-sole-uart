package com.soletreadmills.sole_v2.ui.pair;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.android.SdkConstants;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.soletreadmills.sole_v2.Global;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.ble.BleDeviceInfoData;
import com.soletreadmills.sole_v2._manager.BleManager;
import com.soletreadmills.sole_v2._roomDataBase.bleDevice.BleDeviceInfoDao;
import com.soletreadmills.sole_v2._roomDataBase.bleDevice.BleDeviceInfoDatabase;
import com.soletreadmills.sole_v2._roomDataBase.bleDevice.BleDeviceInfoEntity;
import com.soletreadmills.sole_v2._type.BluetoothConnectType;
import com.soletreadmills.sole_v2.databinding.CustomTabBinding;
import com.soletreadmills.sole_v2.databinding.FragmentPairDeviceBinding;
import com.soletreadmills.sole_v2.listener.EnabledBluetoothListener;
import com.soletreadmills.sole_v2.ui.MainActivity;
import com.soletreadmills.sole_v2.ui._base.BaseActivity;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import com.soletreadmills.sole_v2.ui.adapter.viewpage.PairDeviceViewPageAdapter;
import com.soletreadmills.sole_v2.ui.pair.PairDeviceFragment;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import timber.log.Timber;

/* compiled from: PairDeviceFragment.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t*\u0002\u0013 \b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010(\u001a\u00020)H\u0002J\u0006\u0010*\u001a\u00020)J\u000e\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020#J\b\u0010.\u001a\u00020)H\u0002J\u001a\u0010/\u001a\u00020\u00022\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103H\u0016J\b\u00104\u001a\u00020)H\u0016J\u0012\u00105\u001a\u00020)2\b\u00106\u001a\u0004\u0018\u00010,H\u0016J\b\u00107\u001a\u00020)H\u0016J\b\u00108\u001a\u00020)H\u0002J\u0010\u00109\u001a\u00020)2\u0006\u0010:\u001a\u00020#H\u0002J\u0006\u0010;\u001a\u00020)R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001a\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\n\u001a\u0004\b\u001b\u0010\bR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010!R\u001a\u0010\"\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006<"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/pair/PairDeviceFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/databinding/FragmentPairDeviceBinding;", "Landroid/view/View$OnClickListener;", "()V", "autoCloseRunnable", "Ljava/lang/Runnable;", "getAutoCloseRunnable", "()Ljava/lang/Runnable;", "autoCloseRunnable$delegate", "Lkotlin/Lazy;", "bleDeviceList", "", "Lcom/soletreadmills/sole_v2/_data/ble/BleDeviceInfoData;", "getBleDeviceList", "()Ljava/util/List;", "setBleDeviceList", "(Ljava/util/List;)V", "bluetoothCallbackListener", "com/soletreadmills/sole_v2/ui/pair/PairDeviceFragment$bluetoothCallbackListener$1", "Lcom/soletreadmills/sole_v2/ui/pair/PairDeviceFragment$bluetoothCallbackListener$1;", "connectFtmsBleDeviceInfoData", "getConnectFtmsBleDeviceInfoData", "()Lcom/soletreadmills/sole_v2/_data/ble/BleDeviceInfoData;", "setConnectFtmsBleDeviceInfoData", "(Lcom/soletreadmills/sole_v2/_data/ble/BleDeviceInfoData;)V", "failAutoHideRunnable", "getFailAutoHideRunnable", "failAutoHideRunnable$delegate", "handler", "Landroid/os/Handler;", "viewPageOnPageChangeCallback", "com/soletreadmills/sole_v2/ui/pair/PairDeviceFragment$viewPageOnPageChangeCallback$1", "Lcom/soletreadmills/sole_v2/ui/pair/PairDeviceFragment$viewPageOnPageChangeCallback$1;", "viewPagePosition", "", "getViewPagePosition", "()I", "setViewPagePosition", "(I)V", "checkHasDevice", "", "checkPermission", "createCustomTabView", "Landroid/view/View;", "position", "hideProgressbar", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", SdkConstants.ATTR_ON_CLICK, "v", "onDestroyView", "setTabLayout", "showProgressbar", "type", "startScan", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PairDeviceFragment extends BaseFragment<FragmentPairDeviceBinding> implements View.OnClickListener {
    public static final int $stable = 8;
    private BleDeviceInfoData connectFtmsBleDeviceInfoData;
    private int viewPagePosition;
    private List<BleDeviceInfoData> bleDeviceList = new ArrayList();
    private final Handler handler = new Handler(Looper.getMainLooper());

    /* renamed from: autoCloseRunnable$delegate, reason: from kotlin metadata */
    private final Lazy autoCloseRunnable = LazyKt.lazy(new PairDeviceFragment$autoCloseRunnable$2(this));

    /* renamed from: failAutoHideRunnable$delegate, reason: from kotlin metadata */
    private final Lazy failAutoHideRunnable = LazyKt.lazy(new PairDeviceFragment$failAutoHideRunnable$2(this));
    private final PairDeviceFragment$viewPageOnPageChangeCallback$1 viewPageOnPageChangeCallback = new ViewPager2.OnPageChangeCallback() { // from class: com.soletreadmills.sole_v2.ui.pair.PairDeviceFragment$viewPageOnPageChangeCallback$1
        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            super.onPageSelected(position);
            this.this$0.setViewPagePosition(position);
        }
    };
    private final PairDeviceFragment$bluetoothCallbackListener$1 bluetoothCallbackListener = new PairDeviceFragment$bluetoothCallbackListener$1(this);

    public static final /* synthetic */ FragmentPairDeviceBinding access$getBinding(PairDeviceFragment pairDeviceFragment) {
        return pairDeviceFragment.getBinding();
    }

    public final List<BleDeviceInfoData> getBleDeviceList() {
        return this.bleDeviceList;
    }

    public final void setBleDeviceList(List<BleDeviceInfoData> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.bleDeviceList = list;
    }

    public final int getViewPagePosition() {
        return this.viewPagePosition;
    }

    public final void setViewPagePosition(int i) {
        this.viewPagePosition = i;
    }

    public final BleDeviceInfoData getConnectFtmsBleDeviceInfoData() {
        return this.connectFtmsBleDeviceInfoData;
    }

    public final void setConnectFtmsBleDeviceInfoData(BleDeviceInfoData bleDeviceInfoData) {
        this.connectFtmsBleDeviceInfoData = bleDeviceInfoData;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public FragmentPairDeviceBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentPairDeviceBinding fragmentPairDeviceBindingInflate = FragmentPairDeviceBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentPairDeviceBindingInflate, "inflate(...)");
        return fragmentPairDeviceBindingInflate;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.handler.removeCallbacks(getAutoCloseRunnable());
        this.handler.removeCallbacks(getFailAutoHideRunnable());
        BleManager.getInstance().removeBluetoothCallbackListener(this.bluetoothCallbackListener);
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public void initViews() {
        OnBackPressedDispatcher onBackPressedDispatcher;
        ViewPager2 viewPager2;
        TextView textView;
        ConstraintLayout constraintLayout;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        TextView textView2;
        BleManager.getInstance().removeBluetoothCallbackListener(this.bluetoothCallbackListener);
        BleManager.getInstance().addBluetoothCallbackListener(this.bluetoothCallbackListener);
        FragmentPairDeviceBinding binding = getBinding();
        if (binding != null && (textView2 = binding.cancel) != null) {
            textView2.setOnClickListener(this);
        }
        FragmentPairDeviceBinding binding2 = getBinding();
        if (binding2 != null && (linearLayout2 = binding2.pair) != null) {
            linearLayout2.setOnClickListener(this);
        }
        FragmentPairDeviceBinding binding3 = getBinding();
        if (binding3 != null && (linearLayout = binding3.tryAgain) != null) {
            linearLayout.setOnClickListener(this);
        }
        FragmentPairDeviceBinding binding4 = getBinding();
        if (binding4 != null && (constraintLayout = binding4.CLProgressbar) != null) {
            constraintLayout.setOnClickListener(this);
        }
        FragmentPairDeviceBinding binding5 = getBinding();
        if (binding5 != null && (textView = binding5.tvSearch) != null) {
            textView.setOnClickListener(this);
        }
        FragmentPairDeviceBinding binding6 = getBinding();
        if (binding6 != null && (viewPager2 = binding6.viewPager) != null) {
            viewPager2.registerOnPageChangeCallback(this.viewPageOnPageChangeCallback);
        }
        OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback() { // from class: com.soletreadmills.sole_v2.ui.pair.PairDeviceFragment$initViews$backCallback$1
            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
            }
        };
        MainActivity mainActivity = getMainActivity();
        if (mainActivity != null && (onBackPressedDispatcher = mainActivity.getOnBackPressedDispatcher()) != null) {
            onBackPressedDispatcher.addCallback(this, onBackPressedCallback);
        }
        checkPermission();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        String loginUuid;
        BleDeviceInfoDao bleDeviceInfoDao;
        BleDeviceInfoDao bleDeviceInfoDao2;
        BleDeviceInfoDao bleDeviceInfoDao3;
        View root;
        BleDeviceInfoEntity bleDeviceInfoEntityFindByBleName = null;
        Integer numValueOf = v != null ? Integer.valueOf(v.getId()) : null;
        int i = R.id.cancel;
        if (numValueOf != null && numValueOf.intValue() == i) {
            safeNavigateUp();
            return;
        }
        int i2 = R.id.tryAgain;
        if (numValueOf == null || numValueOf.intValue() != i2) {
            int i3 = R.id.tv_search;
            if (numValueOf == null || numValueOf.intValue() != i3) {
                int i4 = R.id.pair;
                if (numValueOf != null && numValueOf.intValue() == i4) {
                    try {
                        showProgressbar(0);
                        BleDeviceInfoData bleDeviceInfoData = this.bleDeviceList.get(this.viewPagePosition);
                        this.connectFtmsBleDeviceInfoData = bleDeviceInfoData;
                        if (bleDeviceInfoData == null || (loginUuid = Global.getLoginUuid()) == null) {
                            return;
                        }
                        BleDeviceInfoDatabase bleDeviceInfoDatabase = BleManager.getInstance().getBleDeviceInfoDatabase();
                        if (bleDeviceInfoDatabase != null && (bleDeviceInfoDao3 = bleDeviceInfoDatabase.bleDeviceInfoDao()) != null) {
                            bleDeviceInfoEntityFindByBleName = bleDeviceInfoDao3.findByBleName(bleDeviceInfoData.getName(), loginUuid);
                        }
                        if (bleDeviceInfoEntityFindByBleName == null) {
                            BleDeviceInfoEntity bleDeviceInfoEntity = new BleDeviceInfoEntity(bleDeviceInfoData.getAddress(), bleDeviceInfoData.getName(), loginUuid, null, bleDeviceInfoData.getIsHasAdv0x16(), 8, null);
                            bleDeviceInfoEntity.setMachineType(bleDeviceInfoData.getMachineType());
                            BleDeviceInfoDatabase bleDeviceInfoDatabase2 = BleManager.getInstance().getBleDeviceInfoDatabase();
                            if (bleDeviceInfoDatabase2 != null && (bleDeviceInfoDao2 = bleDeviceInfoDatabase2.bleDeviceInfoDao()) != null) {
                                bleDeviceInfoDao2.insert(bleDeviceInfoEntity);
                            }
                        } else if (bleDeviceInfoEntityFindByBleName.getMachineType02() == null || (bleDeviceInfoData.getMachineType() != null && bleDeviceInfoEntityFindByBleName.getMachineType02() != bleDeviceInfoData.getMachineType())) {
                            bleDeviceInfoEntityFindByBleName.setMachineType(bleDeviceInfoData.getMachineType());
                            try {
                                BleDeviceInfoDatabase bleDeviceInfoDatabase3 = BleManager.getInstance().getBleDeviceInfoDatabase();
                                if (bleDeviceInfoDatabase3 != null && (bleDeviceInfoDao = bleDeviceInfoDatabase3.bleDeviceInfoDao()) != null) {
                                    bleDeviceInfoDao.update(bleDeviceInfoEntityFindByBleName);
                                }
                            } catch (Exception e) {
                                Timber.INSTANCE.e(e.fillInStackTrace());
                            }
                        }
                        if (bleDeviceInfoData != null) {
                            BleManager.getInstance().bleFtmsConnect(bleDeviceInfoData, false);
                            return;
                        }
                        return;
                    } catch (Exception e2) {
                        Timber.INSTANCE.e(e2.getMessage(), new Object[0]);
                        return;
                    }
                }
                return;
            }
        }
        this.bleDeviceList.clear();
        FragmentPairDeviceBinding binding = getBinding();
        if (binding != null && (root = binding.getRoot()) != null) {
            root.post(new Runnable() { // from class: com.soletreadmills.sole_v2.ui.pair.PairDeviceFragment$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    PairDeviceFragment.onClick$lambda$0(this.f$0);
                }
            });
        }
        checkPermission();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onClick$lambda$0(PairDeviceFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentPairDeviceBinding binding = this$0.getBinding();
        ConstraintLayout constraintLayout = binding != null ? binding.CLNoSearch : null;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(8);
        }
        FragmentPairDeviceBinding binding2 = this$0.getBinding();
        TextView textView = binding2 != null ? binding2.tvSearch : null;
        if (textView != null) {
            textView.setVisibility(8);
        }
        FragmentPairDeviceBinding binding3 = this$0.getBinding();
        ConstraintLayout constraintLayout2 = binding3 != null ? binding3.CLSearchProgressbar : null;
        if (constraintLayout2 != null) {
            constraintLayout2.setVisibility(0);
        }
        FragmentPairDeviceBinding binding4 = this$0.getBinding();
        ConstraintLayout constraintLayout3 = binding4 != null ? binding4.CLProgressbar : null;
        if (constraintLayout3 != null) {
            constraintLayout3.setVisibility(8);
        }
        FragmentPairDeviceBinding binding5 = this$0.getBinding();
        ConstraintLayout constraintLayout4 = binding5 != null ? binding5.CLDeviceList : null;
        if (constraintLayout4 == null) {
            return;
        }
        constraintLayout4.setVisibility(8);
    }

    /* compiled from: PairDeviceFragment.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "granted", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.soletreadmills.sole_v2.ui.pair.PairDeviceFragment$checkPermission$1, reason: invalid class name */
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
                MainActivity mainActivity = PairDeviceFragment.this.getMainActivity();
                if (mainActivity != null && (bleManager2 = mainActivity.getBleManager()) != null && !bleManager2.isServiceConnection) {
                    MainActivity mainActivity2 = PairDeviceFragment.this.getMainActivity();
                    if (mainActivity2 != null && (bleManager3 = mainActivity2.getBleManager()) != null) {
                        bleManager3.init();
                    }
                    FragmentPairDeviceBinding fragmentPairDeviceBindingAccess$getBinding = PairDeviceFragment.access$getBinding(PairDeviceFragment.this);
                    if (fragmentPairDeviceBindingAccess$getBinding == null || (root = fragmentPairDeviceBindingAccess$getBinding.getRoot()) == null) {
                        return;
                    }
                    final PairDeviceFragment pairDeviceFragment = PairDeviceFragment.this;
                    root.postDelayed(new Runnable() { // from class: com.soletreadmills.sole_v2.ui.pair.PairDeviceFragment$checkPermission$1$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            PairDeviceFragment.AnonymousClass1.invoke$lambda$0(pairDeviceFragment);
                        }
                    }, 5000L);
                    return;
                }
                MainActivity mainActivity3 = PairDeviceFragment.this.getMainActivity();
                if (mainActivity3 == null || (bleManager = mainActivity3.getBleManager()) == null) {
                    return;
                }
                bleManager.checkBleEnabled(new AnonymousClass2(PairDeviceFragment.this));
                return;
            }
            MainActivity mainActivity4 = PairDeviceFragment.this.getMainActivity();
            if (mainActivity4 != null) {
                MainActivity mainActivity5 = mainActivity4;
                String string = PairDeviceFragment.this.getString(R.string.permission_error);
                String string2 = PairDeviceFragment.this.getString(R.string.confirm);
                final PairDeviceFragment pairDeviceFragment2 = PairDeviceFragment.this;
                BaseActivity.showBaseDialog$default(mainActivity5, string, null, string2, new DialogInterface.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.pair.PairDeviceFragment$checkPermission$1$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        PairDeviceFragment.AnonymousClass1.invoke$lambda$1(pairDeviceFragment2, dialogInterface, i);
                    }
                }, PairDeviceFragment.this.getString(R.string.cancel), null, null, null, null, null, null, 1984, null);
            }
            PairDeviceFragment.this.checkHasDevice();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$0(PairDeviceFragment this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            BleManager.getInstance().stopScanBleDevice();
            this$0.checkHasDevice();
        }

        /* compiled from: PairDeviceFragment.kt */
        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/soletreadmills/sole_v2/ui/pair/PairDeviceFragment$checkPermission$1$2", "Lcom/soletreadmills/sole_v2/listener/EnabledBluetoothListener;", "OnDisable", "", "OnEnabled", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        /* renamed from: com.soletreadmills.sole_v2.ui.pair.PairDeviceFragment$checkPermission$1$2, reason: invalid class name */
        public static final class AnonymousClass2 implements EnabledBluetoothListener {
            final /* synthetic */ PairDeviceFragment this$0;

            AnonymousClass2(PairDeviceFragment pairDeviceFragment) {
                this.this$0 = pairDeviceFragment;
            }

            @Override // com.soletreadmills.sole_v2.listener.EnabledBluetoothListener
            public void OnEnabled() {
                Timber.INSTANCE.e("startScanBleDevice 0", new Object[0]);
                this.this$0.startScan();
            }

            @Override // com.soletreadmills.sole_v2.listener.EnabledBluetoothListener
            public void OnDisable() {
                View root;
                FragmentPairDeviceBinding fragmentPairDeviceBindingAccess$getBinding = PairDeviceFragment.access$getBinding(this.this$0);
                if (fragmentPairDeviceBindingAccess$getBinding == null || (root = fragmentPairDeviceBindingAccess$getBinding.getRoot()) == null) {
                    return;
                }
                final PairDeviceFragment pairDeviceFragment = this.this$0;
                root.postDelayed(new Runnable() { // from class: com.soletreadmills.sole_v2.ui.pair.PairDeviceFragment$checkPermission$1$2$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        PairDeviceFragment.AnonymousClass1.AnonymousClass2.OnDisable$lambda$0(pairDeviceFragment);
                    }
                }, 5000L);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void OnDisable$lambda$0(PairDeviceFragment this$0) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                BleManager.getInstance().stopScanBleDevice();
                this$0.checkHasDevice();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$1(PairDeviceFragment this$0, DialogInterface dialogInterface, int i) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            MainActivity mainActivity = this$0.getMainActivity();
            Intrinsics.checkNotNull(mainActivity);
            intent.setData(Uri.fromParts("package", mainActivity.getPackageName(), null));
            this$0.startActivity(intent);
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
        FragmentPairDeviceBinding binding = getBinding();
        if (binding != null && (root2 = binding.getRoot()) != null) {
            root2.post(new Runnable() { // from class: com.soletreadmills.sole_v2.ui.pair.PairDeviceFragment$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    PairDeviceFragment.startScan$lambda$2(this.f$0);
                }
            });
        }
        FragmentPairDeviceBinding binding2 = getBinding();
        if (binding2 == null || (root = binding2.getRoot()) == null) {
            return;
        }
        root.postDelayed(new Runnable() { // from class: com.soletreadmills.sole_v2.ui.pair.PairDeviceFragment$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                PairDeviceFragment.startScan$lambda$3(this.f$0);
            }
        }, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startScan$lambda$2(PairDeviceFragment this$0) {
        BleManager bleManager;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
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
    public static final void startScan$lambda$3(PairDeviceFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BleManager.getInstance().stopScanBleDevice();
        this$0.checkHasDevice();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkHasDevice() {
        ConstraintLayout constraintLayout;
        if (!isAdded() || getBinding() == null) {
            Timber.INSTANCE.e("checkHasDevice return", new Object[0]);
            return;
        }
        ArrayList<BleDeviceInfoData> bleDeviceInfoDataList = BleManager.getInstance().getBleDeviceInfoDataList();
        Intrinsics.checkNotNullExpressionValue(bleDeviceInfoDataList, "getBleDeviceInfoDataList(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : bleDeviceInfoDataList) {
            if (((BleDeviceInfoData) obj).getConnectionState() != 2) {
                arrayList.add(obj);
            }
        }
        List<BleDeviceInfoData> mutableList = CollectionsKt.toMutableList((Collection) arrayList);
        this.bleDeviceList = mutableList;
        if (mutableList.size() > 0) {
            FragmentPairDeviceBinding binding = getBinding();
            ConstraintLayout constraintLayout2 = binding != null ? binding.CLNoSearch : null;
            if (constraintLayout2 != null) {
                constraintLayout2.setVisibility(8);
            }
            FragmentPairDeviceBinding binding2 = getBinding();
            TextView textView = binding2 != null ? binding2.tvSearch : null;
            if (textView != null) {
                textView.setVisibility(0);
            }
            FragmentPairDeviceBinding binding3 = getBinding();
            ConstraintLayout constraintLayout3 = binding3 != null ? binding3.CLSearchProgressbar : null;
            if (constraintLayout3 != null) {
                constraintLayout3.setVisibility(8);
            }
            FragmentPairDeviceBinding binding4 = getBinding();
            ConstraintLayout constraintLayout4 = binding4 != null ? binding4.CLProgressbar : null;
            if (constraintLayout4 != null) {
                constraintLayout4.setVisibility(8);
            }
            FragmentPairDeviceBinding binding5 = getBinding();
            constraintLayout = binding5 != null ? binding5.CLDeviceList : null;
            if (constraintLayout != null) {
                constraintLayout.setVisibility(0);
            }
            setTabLayout();
            return;
        }
        FragmentPairDeviceBinding binding6 = getBinding();
        ConstraintLayout constraintLayout5 = binding6 != null ? binding6.CLNoSearch : null;
        if (constraintLayout5 != null) {
            constraintLayout5.setVisibility(0);
        }
        FragmentPairDeviceBinding binding7 = getBinding();
        TextView textView2 = binding7 != null ? binding7.tvSearch : null;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        FragmentPairDeviceBinding binding8 = getBinding();
        ConstraintLayout constraintLayout6 = binding8 != null ? binding8.CLSearchProgressbar : null;
        if (constraintLayout6 != null) {
            constraintLayout6.setVisibility(8);
        }
        FragmentPairDeviceBinding binding9 = getBinding();
        ConstraintLayout constraintLayout7 = binding9 != null ? binding9.CLProgressbar : null;
        if (constraintLayout7 != null) {
            constraintLayout7.setVisibility(8);
        }
        FragmentPairDeviceBinding binding10 = getBinding();
        constraintLayout = binding10 != null ? binding10.CLDeviceList : null;
        if (constraintLayout == null) {
            return;
        }
        constraintLayout.setVisibility(8);
    }

    private final Runnable getAutoCloseRunnable() {
        return (Runnable) this.autoCloseRunnable.getValue();
    }

    private final Runnable getFailAutoHideRunnable() {
        return (Runnable) this.failAutoHideRunnable.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showProgressbar(int type) {
        ConstraintLayout constraintLayout;
        LinearLayout linearLayout;
        ConstraintLayout constraintLayout2;
        FragmentPairDeviceBinding binding = getBinding();
        ConstraintLayout constraintLayout3 = binding != null ? binding.CLProgressbar : null;
        if (constraintLayout3 != null) {
            constraintLayout3.setVisibility(0);
        }
        this.handler.removeCallbacks(getAutoCloseRunnable());
        this.handler.removeCallbacks(getFailAutoHideRunnable());
        boolean z = type == 1 || type == 2;
        FragmentPairDeviceBinding binding2 = getBinding();
        ConstraintLayout constraintLayout4 = binding2 != null ? binding2.CLProgressbar : null;
        if (constraintLayout4 != null) {
            constraintLayout4.setClickable(z);
        }
        if (z) {
            FragmentPairDeviceBinding binding3 = getBinding();
            if (binding3 != null && (constraintLayout2 = binding3.CLProgressbar) != null) {
                constraintLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.pair.PairDeviceFragment$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        PairDeviceFragment.showProgressbar$lambda$6(this.f$0, view);
                    }
                });
            }
        } else {
            FragmentPairDeviceBinding binding4 = getBinding();
            if (binding4 != null && (constraintLayout = binding4.CLProgressbar) != null) {
                constraintLayout.setOnClickListener(null);
            }
        }
        if (type == 0) {
            FragmentPairDeviceBinding binding5 = getBinding();
            LinearLayout linearLayout2 = binding5 != null ? binding5.LLPairingProgressbar : null;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(0);
            }
            FragmentPairDeviceBinding binding6 = getBinding();
            LinearLayout linearLayout3 = binding6 != null ? binding6.LLPairFailed : null;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(8);
            }
            FragmentPairDeviceBinding binding7 = getBinding();
            linearLayout = binding7 != null ? binding7.LLPairSuccess : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            this.handler.postDelayed(getAutoCloseRunnable(), 20000L);
            return;
        }
        if (type == 1) {
            FragmentPairDeviceBinding binding8 = getBinding();
            LinearLayout linearLayout4 = binding8 != null ? binding8.LLPairingProgressbar : null;
            if (linearLayout4 != null) {
                linearLayout4.setVisibility(8);
            }
            FragmentPairDeviceBinding binding9 = getBinding();
            LinearLayout linearLayout5 = binding9 != null ? binding9.LLPairFailed : null;
            if (linearLayout5 != null) {
                linearLayout5.setVisibility(8);
            }
            FragmentPairDeviceBinding binding10 = getBinding();
            linearLayout = binding10 != null ? binding10.LLPairSuccess : null;
            if (linearLayout == null) {
                return;
            }
            linearLayout.setVisibility(0);
            return;
        }
        if (type != 2) {
            return;
        }
        FragmentPairDeviceBinding binding11 = getBinding();
        LinearLayout linearLayout6 = binding11 != null ? binding11.LLPairingProgressbar : null;
        if (linearLayout6 != null) {
            linearLayout6.setVisibility(8);
        }
        FragmentPairDeviceBinding binding12 = getBinding();
        LinearLayout linearLayout7 = binding12 != null ? binding12.LLPairFailed : null;
        if (linearLayout7 != null) {
            linearLayout7.setVisibility(0);
        }
        FragmentPairDeviceBinding binding13 = getBinding();
        linearLayout = binding13 != null ? binding13.LLPairSuccess : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        this.handler.postDelayed(getFailAutoHideRunnable(), 1500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showProgressbar$lambda$6(PairDeviceFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getBinding() != null) {
            this$0.hideProgressbar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideProgressbar() {
        this.handler.removeCallbacks(getAutoCloseRunnable());
        this.handler.removeCallbacks(getFailAutoHideRunnable());
        FragmentPairDeviceBinding binding = getBinding();
        if (binding != null) {
            binding.CLProgressbar.setVisibility(8);
            binding.LLPairingProgressbar.setVisibility(8);
            binding.LLPairFailed.setVisibility(8);
            binding.LLPairSuccess.setVisibility(8);
            binding.CLProgressbar.setOnClickListener(null);
        }
    }

    private final void setTabLayout() {
        TabLayout tabLayout;
        List<BleDeviceInfoData> list = this.bleDeviceList;
        MainActivity mainActivity = getMainActivity();
        if (mainActivity != null) {
            PairDeviceViewPageAdapter pairDeviceViewPageAdapter = new PairDeviceViewPageAdapter(mainActivity, list);
            FragmentPairDeviceBinding binding = getBinding();
            ViewPager2 viewPager2 = binding != null ? binding.viewPager : null;
            if (viewPager2 != null) {
                viewPager2.setAdapter(pairDeviceViewPageAdapter);
            }
            FragmentPairDeviceBinding binding2 = getBinding();
            ViewPager2 viewPager22 = binding2 != null ? binding2.viewPager : null;
            FragmentPairDeviceBinding binding3 = getBinding();
            TabLayout tabLayout2 = binding3 != null ? binding3.dotsIndicator : null;
            if (tabLayout2 != null && viewPager22 != null) {
                new TabLayoutMediator(tabLayout2, viewPager22, new TabLayoutMediator.TabConfigurationStrategy() { // from class: com.soletreadmills.sole_v2.ui.pair.PairDeviceFragment$$ExternalSyntheticLambda1
                    @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
                    public final void onConfigureTab(TabLayout.Tab tab, int i) {
                        PairDeviceFragment.setTabLayout$lambda$9$lambda$8(this.f$0, tab, i);
                    }
                }).attach();
            }
        }
        FragmentPairDeviceBinding binding4 = getBinding();
        if (binding4 == null || (tabLayout = binding4.dotsIndicator) == null) {
            return;
        }
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.soletreadmills.sole_v2.ui.pair.PairDeviceFragment.setTabLayout.2
            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabReselected(TabLayout.Tab tab) {
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                View customView = tab != null ? tab.getCustomView() : null;
                ImageView imageView = customView != null ? (ImageView) customView.findViewById(R.id.tab_icon) : null;
                if (imageView != null) {
                    imageView.setImageResource(R.drawable.label3_circle);
                }
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                View customView = tab != null ? tab.getCustomView() : null;
                ImageView imageView = customView != null ? (ImageView) customView.findViewById(R.id.tab_icon) : null;
                if (imageView != null) {
                    imageView.setImageResource(R.drawable.gray_circle);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTabLayout$lambda$9$lambda$8(PairDeviceFragment this$0, TabLayout.Tab tab, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(tab, "tab");
        tab.setCustomView(this$0.createCustomTabView(i));
    }

    public final View createCustomTabView(int position) {
        CustomTabBinding customTabBindingInflate = CustomTabBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(customTabBindingInflate, "inflate(...)");
        if (position == 0) {
            customTabBindingInflate.tabIcon.setImageResource(R.drawable.label3_circle);
        } else {
            customTabBindingInflate.tabIcon.setImageResource(R.drawable.gray_circle);
        }
        View root = customTabBindingInflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }
}
