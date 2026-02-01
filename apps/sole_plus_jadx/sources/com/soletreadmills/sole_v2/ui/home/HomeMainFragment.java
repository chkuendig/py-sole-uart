package com.soletreadmills.sole_v2.ui.home;

import android.app.AlertDialog;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.android.SdkConstants;
import com.android.ddmlib.internal.commands.DisconnectCommand;
import com.blankj.utilcode.util.SnackbarUtils;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.soletreadmills.sole_v2.Global;
import com.soletreadmills.sole_v2.MyApplication;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data._base.JwtApiBaseData;
import com.soletreadmills.sole_v2._data.api.JwtErrorCode;
import com.soletreadmills.sole_v2._data.api.goal.GetMyUserGoalListApiData;
import com.soletreadmills.sole_v2._data.api.goal.GetVideoRecommendationsApiData;
import com.soletreadmills.sole_v2._data.api.home.GetMyConnectedMachineListApiData;
import com.soletreadmills.sole_v2._data.ble.BleDeviceInfoData;
import com.soletreadmills.sole_v2._data.classes.ClassCollectionData;
import com.soletreadmills.sole_v2._data.classes.FavoritesData;
import com.soletreadmills.sole_v2._data.classes.GetCollectionsApiData;
import com.soletreadmills.sole_v2._data.classes.GetFavoritesApiData;
import com.soletreadmills.sole_v2._data.classes.GetSubscriptionStatusApiData;
import com.soletreadmills.sole_v2._data.classes.GetSubscriptionStatusDataMap;
import com.soletreadmills.sole_v2._data.classes.SubscriptionStatusType;
import com.soletreadmills.sole_v2._data.goal.UserGoalData;
import com.soletreadmills.sole_v2._data.home.PickedForYouData;
import com.soletreadmills.sole_v2._extension.CustomDialogKt;
import com.soletreadmills.sole_v2._manager.BleManager;
import com.soletreadmills.sole_v2._network.DyacoApiKt;
import com.soletreadmills.sole_v2._network.JwtDyacoApiKt;
import com.soletreadmills.sole_v2._sharedPreferences.MySharedPreferences;
import com.soletreadmills.sole_v2._type.BluetoothConnectType;
import com.soletreadmills.sole_v2._type.MachineType;
import com.soletreadmills.sole_v2.ble.cmd.FitnessMachineControlPointCmd;
import com.soletreadmills.sole_v2.ble.manager.BleDataManager;
import com.soletreadmills.sole_v2.ble.manager.FtmsDeviceManager;
import com.soletreadmills.sole_v2.databinding.FragmentHomeMainBinding;
import com.soletreadmills.sole_v2.listener.EnabledBluetoothListener;
import com.soletreadmills.sole_v2.listener.OnItemClickListener;
import com.soletreadmills.sole_v2.ui.MainActivity;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import com.soletreadmills.sole_v2.ui._base.OnPairingDialogDismissListener;
import com.soletreadmills.sole_v2.ui._interface.ScrollToTopHandler;
import com.soletreadmills.sole_v2.ui.adapter.goals.GoalsAdapter;
import com.soletreadmills.sole_v2.ui.adapter.home.CollectionAdapter;
import com.soletreadmills.sole_v2.ui.adapter.home.FavoritesAdapter;
import com.soletreadmills.sole_v2.ui.adapter.home.HomeConnectAdapter;
import com.soletreadmills.sole_v2.ui.adapter.home.PickForYouAdapter;
import com.soletreadmills.sole_v2.ui.customview.GoalsDetailView;
import com.soletreadmills.sole_v2.ui.customview.SelectBleConnectCustom;
import com.soletreadmills.sole_v2.ui.goals.GoalsViewModel;
import com.sun.jna.platform.win32.WinError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
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
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import org.objectweb.asm.Opcodes;
import retrofit2.Response;
import timber.log.Timber;

/* compiled from: HomeMainFragment.kt */
@Metadata(d1 = {"\u0000³\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0006\u0010&\u001a\u00020'J\u0010\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\u0012H\u0002J\u0014\u0010*\u001a\u00020'2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\f0,J\b\u0010-\u001a\u00020'H\u0002J\b\u0010.\u001a\u00020'H\u0002J\b\u0010/\u001a\u00020'H\u0002J\b\u00100\u001a\u00020'H\u0002J\u0006\u00101\u001a\u00020'J\b\u00102\u001a\u00020'H\u0002J\u0010\u00103\u001a\u00020'2\u0006\u00104\u001a\u00020\fH\u0002J\u001a\u00105\u001a\u00020\u00022\u0006\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u000109H\u0016J\b\u0010:\u001a\u00020'H\u0016J\u0012\u0010;\u001a\u00020'2\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\u0012\u0010>\u001a\u00020'2\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J\b\u0010A\u001a\u00020'H\u0016J\u001a\u0010B\u001a\u00020'2\u0006\u0010C\u001a\u00020=2\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J\b\u0010D\u001a\u00020'H\u0016J\b\u0010E\u001a\u00020'H\u0002J\b\u0010F\u001a\u00020'H\u0002J\b\u0010G\u001a\u00020'H\u0002J\b\u0010H\u001a\u00020'H\u0002J\b\u0010I\u001a\u00020'H\u0002J\u0018\u0010J\u001a\u00020'2\u0006\u00104\u001a\u00020\f2\u0006\u0010K\u001a\u00020LH\u0002J\u0016\u0010M\u001a\u00020'2\f\u0010N\u001a\b\u0012\u0004\u0012\u00020P0OH\u0002J\u0016\u0010Q\u001a\u00020'2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020S0OH\u0002J\u0016\u0010T\u001a\u00020'2\f\u0010U\u001a\b\u0012\u0004\u0012\u00020V0OH\u0002J\u0016\u0010W\u001a\u00020'2\f\u0010X\u001a\b\u0012\u0004\u0012\u00020Y0OH\u0002R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b\u001f\u0010 R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082.¢\u0006\u0002\n\u0000¨\u0006Z"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/home/HomeMainFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/databinding/FragmentHomeMainBinding;", "Landroid/view/View$OnClickListener;", "Lcom/soletreadmills/sole_v2/ui/_interface/ScrollToTopHandler;", "()V", "bluetoothCallbackListener", "com/soletreadmills/sole_v2/ui/home/HomeMainFragment$bluetoothCallbackListener$1", "Lcom/soletreadmills/sole_v2/ui/home/HomeMainFragment$bluetoothCallbackListener$1;", "collectionsAdapter", "Lcom/soletreadmills/sole_v2/ui/adapter/home/CollectionAdapter;", "connectFtmsBleDeviceInfoData", "Lcom/soletreadmills/sole_v2/_data/ble/BleDeviceInfoData;", "getConnectFtmsBleDeviceInfoData", "()Lcom/soletreadmills/sole_v2/_data/ble/BleDeviceInfoData;", "setConnectFtmsBleDeviceInfoData", "(Lcom/soletreadmills/sole_v2/_data/ble/BleDeviceInfoData;)V", "currentCollapseMode", "", "favoritesAdapter", "Lcom/soletreadmills/sole_v2/ui/adapter/home/FavoritesAdapter;", "goalsAdapter", "Lcom/soletreadmills/sole_v2/ui/adapter/goals/GoalsAdapter;", "goalsViewModel", "Lcom/soletreadmills/sole_v2/ui/goals/GoalsViewModel;", "getGoalsViewModel", "()Lcom/soletreadmills/sole_v2/ui/goals/GoalsViewModel;", "goalsViewModel$delegate", "Lkotlin/Lazy;", "homeViewModel", "Lcom/soletreadmills/sole_v2/ui/home/HomeViewModel;", "getHomeViewModel", "()Lcom/soletreadmills/sole_v2/ui/home/HomeViewModel;", "homeViewModel$delegate", "isUserClickConnectBtn", "", "pickForYouAdapter", "Lcom/soletreadmills/sole_v2/ui/adapter/home/PickForYouAdapter;", "apiGetSubscriptionStatus", "", "changeCollapseMode", "collapseMode", "checkAutoConnectBleName", "bleList", "", "createGoal", "getCollectionsData", "getFavorites", "getGoalsData", "getMyConnectedMachineList", "getPickFouYouData", "handleBleConnection", "data", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", SdkConstants.ATTR_ON_CLICK, "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "scrollToTop", "setCollectionsRecyclerview", "setConnectRecyclerView", "setFavoritesRecyclerview", "setGoalsRecyclerView", "setPickForYouRecyclerview", "showConnectionFailedDialog", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/soletreadmills/sole_v2/ui/_base/OnPairingDialogDismissListener;", "updateCollectionsData", "collectionsList", "", "Lcom/soletreadmills/sole_v2/_data/classes/ClassCollectionData;", "updateFavoritesData", "favoritesList", "Lcom/soletreadmills/sole_v2/_data/classes/FavoritesData;", "updateGoalsData", "goalsList", "Lcom/soletreadmills/sole_v2/_data/goal/UserGoalData;", "updatePickForYouData", "datas", "Lcom/soletreadmills/sole_v2/_data/home/PickedForYouData;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HomeMainFragment extends BaseFragment<FragmentHomeMainBinding> implements View.OnClickListener, ScrollToTopHandler {
    public static final int $stable = 8;
    private CollectionAdapter collectionsAdapter;
    private BleDeviceInfoData connectFtmsBleDeviceInfoData;
    private FavoritesAdapter favoritesAdapter;
    private GoalsAdapter goalsAdapter;

    /* renamed from: goalsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy goalsViewModel;

    /* renamed from: homeViewModel$delegate, reason: from kotlin metadata */
    private final Lazy homeViewModel;
    private boolean isUserClickConnectBtn;
    private PickForYouAdapter pickForYouAdapter;
    private int currentCollapseMode = 2;
    private final HomeMainFragment$bluetoothCallbackListener$1 bluetoothCallbackListener = new HomeMainFragment$bluetoothCallbackListener$1(this);

    @Override // com.soletreadmills.sole_v2.ui._interface.ScrollToTopHandler
    public void scrollToTop() {
    }

    public HomeMainFragment() {
        final HomeMainFragment homeMainFragment = this;
        final Function0 function0 = null;
        this.homeViewModel = FragmentViewModelLazyKt.createViewModelLazy(homeMainFragment, Reflection.getOrCreateKotlinClass(HomeViewModel.class), new Function0<ViewModelStore>() { // from class: com.soletreadmills.sole_v2.ui.home.HomeMainFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = homeMainFragment.requireActivity().getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: com.soletreadmills.sole_v2.ui.home.HomeMainFragment$special$$inlined$activityViewModels$default$2
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
                CreationExtras defaultViewModelCreationExtras = homeMainFragment.requireActivity().getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.soletreadmills.sole_v2.ui.home.HomeMainFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = homeMainFragment.requireActivity().getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.goalsViewModel = FragmentViewModelLazyKt.createViewModelLazy(homeMainFragment, Reflection.getOrCreateKotlinClass(GoalsViewModel.class), new Function0<ViewModelStore>() { // from class: com.soletreadmills.sole_v2.ui.home.HomeMainFragment$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = homeMainFragment.requireActivity().getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: com.soletreadmills.sole_v2.ui.home.HomeMainFragment$special$$inlined$activityViewModels$default$5
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
                CreationExtras defaultViewModelCreationExtras = homeMainFragment.requireActivity().getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.soletreadmills.sole_v2.ui.home.HomeMainFragment$special$$inlined$activityViewModels$default$6
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = homeMainFragment.requireActivity().getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    public static final /* synthetic */ FragmentHomeMainBinding access$getBinding(HomeMainFragment homeMainFragment) {
        return homeMainFragment.getBinding();
    }

    public static final /* synthetic */ void access$setConnectRecyclerView(HomeMainFragment homeMainFragment) throws CloneNotSupportedException {
        homeMainFragment.setConnectRecyclerView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HomeViewModel getHomeViewModel() {
        return (HomeViewModel) this.homeViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GoalsViewModel getGoalsViewModel() {
        return (GoalsViewModel) this.goalsViewModel.getValue();
    }

    public final BleDeviceInfoData getConnectFtmsBleDeviceInfoData() {
        return this.connectFtmsBleDeviceInfoData;
    }

    public final void setConnectFtmsBleDeviceInfoData(BleDeviceInfoData bleDeviceInfoData) {
        this.connectFtmsBleDeviceInfoData = bleDeviceInfoData;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public FragmentHomeMainBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentHomeMainBinding fragmentHomeMainBindingInflate = FragmentHomeMainBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentHomeMainBindingInflate, "inflate(...)");
        return fragmentHomeMainBindingInflate;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        AlertDialog pairingDialog;
        super.onDestroyView();
        BleManager.getInstance().removeBluetoothCallbackListener(this.bluetoothCallbackListener);
        MainActivity mainActivity = getMainActivity();
        if (mainActivity != null && (pairingDialog = mainActivity.getPairingDialog()) != null) {
            pairingDialog.dismiss();
        }
        this.isUserClickConnectBtn = false;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public void initViews() {
        SwipeRefreshLayout swipeRefreshLayout;
        LinearLayout linearLayout;
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        ImageView imageView4;
        LinearLayout linearLayout2;
        AppBarLayout appBarLayout;
        BleManager.getInstance().removeBluetoothCallbackListener(this.bluetoothCallbackListener);
        BleManager.getInstance().addBluetoothCallbackListener(this.bluetoothCallbackListener);
        this.isUserClickConnectBtn = false;
        FragmentHomeMainBinding binding = getBinding();
        if (binding != null && (appBarLayout = binding.appBarLayout) != null) {
            appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.soletreadmills.sole_v2.ui.home.HomeMainFragment$$ExternalSyntheticLambda3
                @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
                public final void onOffsetChanged(AppBarLayout appBarLayout2, int i) {
                    HomeMainFragment.initViews$lambda$0(this.f$0, appBarLayout2, i);
                }
            });
        }
        FragmentHomeMainBinding binding2 = getBinding();
        if (binding2 != null && (linearLayout2 = binding2.LLGoals) != null) {
            linearLayout2.setOnClickListener(this);
        }
        FragmentHomeMainBinding binding3 = getBinding();
        if (binding3 != null && (imageView4 = binding3.imgConnectPlus) != null) {
            imageView4.setOnClickListener(this);
        }
        FragmentHomeMainBinding binding4 = getBinding();
        if (binding4 != null && (imageView3 = binding4.imgConnect) != null) {
            imageView3.setOnClickListener(this);
        }
        FragmentHomeMainBinding binding5 = getBinding();
        if (binding5 != null && (imageView2 = binding5.imgFavoritesMoreBtn) != null) {
            imageView2.setOnClickListener(this);
        }
        FragmentHomeMainBinding binding6 = getBinding();
        if (binding6 != null && (imageView = binding6.imgCollectionsMoreBtn) != null) {
            imageView.setOnClickListener(this);
        }
        FragmentHomeMainBinding binding7 = getBinding();
        if (binding7 != null && (linearLayout = binding7.LLGetPremium) != null) {
            linearLayout.setOnClickListener(this);
        }
        setFavoritesRecyclerview();
        setCollectionsRecyclerview();
        setGoalsRecyclerView();
        setPickForYouRecyclerview();
        FragmentHomeMainBinding binding8 = getBinding();
        if (binding8 != null && (swipeRefreshLayout = binding8.swipeRefreshLayout) != null) {
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.soletreadmills.sole_v2.ui.home.HomeMainFragment$$ExternalSyntheticLambda4
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
                public final void onRefresh() {
                    HomeMainFragment.initViews$lambda$1(this.f$0);
                }
            });
        }
        getFavorites();
        getGoalsData();
        getCollectionsData();
        getPickFouYouData();
        apiGetSubscriptionStatus();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new AnonymousClass3(null), 3, null);
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner2), null, null, new AnonymousClass4(null), 3, null);
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner3), null, null, new AnonymousClass5(null), 3, null);
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner4), null, null, new AnonymousClass6(null), 3, null);
        getMyConnectedMachineList();
        if (getHomeViewModel().getCallBannerApi()) {
            return;
        }
        getHomeViewModel().setCallBannerApi(true);
        getBanner();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$0(HomeMainFragment this$0, AppBarLayout appBarLayout, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i2 = ((float) Math.abs(i)) / ((float) appBarLayout.getTotalScrollRange()) >= 0.85f ? 1 : 2;
        if (this$0.currentCollapseMode != i2) {
            this$0.changeCollapseMode(i2);
            this$0.currentCollapseMode = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$1(HomeMainFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getFavorites();
        this$0.getGoalsData();
        this$0.getCollectionsData();
        this$0.getPickFouYouData();
        FragmentHomeMainBinding binding = this$0.getBinding();
        SwipeRefreshLayout swipeRefreshLayout = binding != null ? binding.swipeRefreshLayout : null;
        if (swipeRefreshLayout == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    /* compiled from: HomeMainFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.home.HomeMainFragment$initViews$3", f = "HomeMainFragment.kt", i = {}, l = {174}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.home.HomeMainFragment$initViews$3, reason: invalid class name */
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HomeMainFragment.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: HomeMainFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.home.HomeMainFragment$initViews$3$1", f = "HomeMainFragment.kt", i = {}, l = {Opcodes.DRETURN}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.soletreadmills.sole_v2.ui.home.HomeMainFragment$initViews$3$1, reason: invalid class name */
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ HomeMainFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(HomeMainFragment homeMainFragment, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = homeMainFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    StateFlow<List<FavoritesData>> favoritesList = this.this$0.getHomeViewModel().getFavoritesList();
                    final HomeMainFragment homeMainFragment = this.this$0;
                    this.label = 1;
                    if (favoritesList.collect(new FlowCollector() { // from class: com.soletreadmills.sole_v2.ui.home.HomeMainFragment.initViews.3.1.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                            return emit((List<FavoritesData>) obj2, (Continuation<? super Unit>) continuation);
                        }

                        public final Object emit(List<FavoritesData> list, Continuation<? super Unit> continuation) {
                            TextView textView;
                            if (list.isEmpty()) {
                                FragmentHomeMainBinding fragmentHomeMainBindingAccess$getBinding = HomeMainFragment.access$getBinding(homeMainFragment);
                                textView = fragmentHomeMainBindingAccess$getBinding != null ? fragmentHomeMainBindingAccess$getBinding.tvFavoritesEmptyDesc : null;
                                if (textView != null) {
                                    textView.setVisibility(0);
                                }
                            } else {
                                FragmentHomeMainBinding fragmentHomeMainBindingAccess$getBinding2 = HomeMainFragment.access$getBinding(homeMainFragment);
                                textView = fragmentHomeMainBindingAccess$getBinding2 != null ? fragmentHomeMainBindingAccess$getBinding2.tvFavoritesEmptyDesc : null;
                                if (textView != null) {
                                    textView.setVisibility(8);
                                }
                            }
                            homeMainFragment.updateFavoritesData(list);
                            return Unit.INSTANCE;
                        }
                    }, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                throw new KotlinNothingValueException();
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(HomeMainFragment.this.getViewLifecycleOwner().getLifecycle(), Lifecycle.State.STARTED, new AnonymousClass1(HomeMainFragment.this, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: HomeMainFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.home.HomeMainFragment$initViews$4", f = "HomeMainFragment.kt", i = {}, l = {189}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.home.HomeMainFragment$initViews$4, reason: invalid class name */
    static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass4(Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HomeMainFragment.this.new AnonymousClass4(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: HomeMainFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.home.HomeMainFragment$initViews$4$1", f = "HomeMainFragment.kt", i = {}, l = {190}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.soletreadmills.sole_v2.ui.home.HomeMainFragment$initViews$4$1, reason: invalid class name */
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ HomeMainFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(HomeMainFragment homeMainFragment, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = homeMainFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    StateFlow<List<PickedForYouData>> pickUpList = this.this$0.getHomeViewModel().getPickUpList();
                    final HomeMainFragment homeMainFragment = this.this$0;
                    this.label = 1;
                    if (pickUpList.collect(new FlowCollector() { // from class: com.soletreadmills.sole_v2.ui.home.HomeMainFragment.initViews.4.1.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                            return emit((List<PickedForYouData>) obj2, (Continuation<? super Unit>) continuation);
                        }

                        public final Object emit(List<PickedForYouData> list, Continuation<? super Unit> continuation) {
                            homeMainFragment.updatePickForYouData(list);
                            return Unit.INSTANCE;
                        }
                    }, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                throw new KotlinNothingValueException();
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(HomeMainFragment.this.getViewLifecycleOwner().getLifecycle(), Lifecycle.State.STARTED, new AnonymousClass1(HomeMainFragment.this, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: HomeMainFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.home.HomeMainFragment$initViews$5", f = "HomeMainFragment.kt", i = {}, l = {198}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.home.HomeMainFragment$initViews$5, reason: invalid class name */
    static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass5(Continuation<? super AnonymousClass5> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HomeMainFragment.this.new AnonymousClass5(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: HomeMainFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.home.HomeMainFragment$initViews$5$1", f = "HomeMainFragment.kt", i = {}, l = {199}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.soletreadmills.sole_v2.ui.home.HomeMainFragment$initViews$5$1, reason: invalid class name */
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ HomeMainFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(HomeMainFragment homeMainFragment, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = homeMainFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    StateFlow<List<ClassCollectionData>> collectionsList = this.this$0.getHomeViewModel().getCollectionsList();
                    final HomeMainFragment homeMainFragment = this.this$0;
                    this.label = 1;
                    if (collectionsList.collect(new FlowCollector() { // from class: com.soletreadmills.sole_v2.ui.home.HomeMainFragment.initViews.5.1.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                            return emit((List<ClassCollectionData>) obj2, (Continuation<? super Unit>) continuation);
                        }

                        public final Object emit(List<ClassCollectionData> list, Continuation<? super Unit> continuation) {
                            homeMainFragment.updateCollectionsData(list);
                            return Unit.INSTANCE;
                        }
                    }, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                throw new KotlinNothingValueException();
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(HomeMainFragment.this.getViewLifecycleOwner().getLifecycle(), Lifecycle.State.STARTED, new AnonymousClass1(HomeMainFragment.this, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: HomeMainFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.home.HomeMainFragment$initViews$6", f = "HomeMainFragment.kt", i = {}, l = {WinError.ERROR_META_EXPANSION_TOO_LONG}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.home.HomeMainFragment$initViews$6, reason: invalid class name */
    static final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass6(Continuation<? super AnonymousClass6> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HomeMainFragment.this.new AnonymousClass6(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass6) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: HomeMainFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.home.HomeMainFragment$initViews$6$1", f = "HomeMainFragment.kt", i = {}, l = {WinError.ERROR_INVALID_SIGNAL_NUMBER}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.soletreadmills.sole_v2.ui.home.HomeMainFragment$initViews$6$1, reason: invalid class name */
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ HomeMainFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(HomeMainFragment homeMainFragment, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = homeMainFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    StateFlow<List<UserGoalData>> goalsList = this.this$0.getGoalsViewModel().getGoalsList();
                    final HomeMainFragment homeMainFragment = this.this$0;
                    this.label = 1;
                    if (goalsList.collect(new FlowCollector() { // from class: com.soletreadmills.sole_v2.ui.home.HomeMainFragment.initViews.6.1.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                            return emit((List<UserGoalData>) obj2, (Continuation<? super Unit>) continuation);
                        }

                        public final Object emit(List<UserGoalData> list, Continuation<? super Unit> continuation) {
                            Timber.INSTANCE.d("update goals List:" + list, new Object[0]);
                            homeMainFragment.updateGoalsData(list);
                            return Unit.INSTANCE;
                        }
                    }, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                throw new KotlinNothingValueException();
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(HomeMainFragment.this.getViewLifecycleOwner().getLifecycle(), Lifecycle.State.STARTED, new AnonymousClass1(HomeMainFragment.this, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    private final void changeCollapseMode(int collapseMode) {
        LinearLayout linearLayout;
        Toolbar toolbar;
        FragmentHomeMainBinding binding = getBinding();
        ViewGroup.LayoutParams layoutParams = (binding == null || (toolbar = binding.collapsingToolbar) == null) ? null : toolbar.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.google.android.material.appbar.CollapsingToolbarLayout.LayoutParams");
        CollapsingToolbarLayout.LayoutParams layoutParams2 = (CollapsingToolbarLayout.LayoutParams) layoutParams;
        layoutParams2.setCollapseMode(collapseMode);
        FragmentHomeMainBinding binding2 = getBinding();
        Toolbar toolbar2 = binding2 != null ? binding2.collapsingToolbar : null;
        if (toolbar2 != null) {
            toolbar2.setLayoutParams(layoutParams2);
        }
        if (collapseMode == 1) {
            FragmentHomeMainBinding binding3 = getBinding();
            TextView textView = binding3 != null ? binding3.title : null;
            if (textView != null) {
                textView.setVisibility(0);
            }
            FragmentHomeMainBinding binding4 = getBinding();
            linearLayout = binding4 != null ? binding4.LLGetPremium : null;
            if (linearLayout == null) {
                return;
            }
            linearLayout.setVisibility(8);
            return;
        }
        FragmentHomeMainBinding binding5 = getBinding();
        TextView textView2 = binding5 != null ? binding5.title : null;
        if (textView2 != null) {
            textView2.setVisibility(4);
        }
        if (Global.INSTANCE.isSubscription()) {
            FragmentHomeMainBinding binding6 = getBinding();
            linearLayout = binding6 != null ? binding6.LLGetPremium : null;
            if (linearLayout == null) {
                return;
            }
            linearLayout.setVisibility(8);
            return;
        }
        FragmentHomeMainBinding binding7 = getBinding();
        linearLayout = binding7 != null ? binding7.LLGetPremium : null;
        if (linearLayout == null) {
            return;
        }
        linearLayout.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        RecyclerView recyclerView;
        Integer numValueOf = v != null ? Integer.valueOf(v.getId()) : null;
        int i = R.id.LL_goals;
        if (numValueOf != null && numValueOf.intValue() == i) {
            BaseFragment.safeNavigate$default(this, R.id.goalsMainFragment, null, 2, null);
            return;
        }
        int i2 = R.id.img_connect_plus;
        if (numValueOf != null && numValueOf.intValue() == i2) {
            Timber.INSTANCE.d("plus", new Object[0]);
            MainActivity mainActivity = getMainActivity();
            if (mainActivity != null) {
                mainActivity.getChangeViewManager().changePage(new SelectBleConnectCustom(mainActivity, new OnItemClickListener() { // from class: com.soletreadmills.sole_v2.ui.home.HomeMainFragment$onClick$1$1
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
                return;
            }
            return;
        }
        int i3 = R.id.img_connect;
        if (numValueOf != null && numValueOf.intValue() == i3) {
            FragmentHomeMainBinding binding = getBinding();
            RecyclerView.Adapter adapter = (binding == null || (recyclerView = binding.rvConnect) == null) ? null : recyclerView.getAdapter();
            if (adapter instanceof HomeConnectAdapter) {
                List<BleDeviceInfoData> currentList = ((HomeConnectAdapter) adapter).getCurrentList();
                Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
                if (currentList.isEmpty()) {
                    return;
                }
                BaseFragment.safeNavigate$default(this, R.id.myDevicesFragment, null, 2, null);
                return;
            }
            return;
        }
        int i4 = R.id.img_favorites_more_btn;
        if (numValueOf != null && numValueOf.intValue() == i4) {
            BaseFragment.safeNavigate$default(this, R.id.myFavoritesFragment, null, 2, null);
            return;
        }
        int i5 = R.id.img_collections_more_btn;
        if (numValueOf != null && numValueOf.intValue() == i5) {
            Bundle bundle = new Bundle();
            bundle.putString("openPageName", "Collections");
            safeNavigate(R.id.classesMainFragment, bundle);
        } else {
            int i6 = R.id.LL_getPremium;
            if (numValueOf != null && numValueOf.intValue() == i6) {
                BaseFragment.safeNavigate$default(this, R.id.payWallFragment, null, 2, null);
            }
        }
    }

    public final void checkAutoConnectBleName(List<BleDeviceInfoData> bleList) {
        Object next;
        MainActivity mainActivity;
        Intrinsics.checkNotNullParameter(bleList, "bleList");
        FtmsDeviceManager ftmsDeviceManager = BleManager.getInstance().getFtmsDeviceManager();
        if (ftmsDeviceManager == null || !ftmsDeviceManager.isConnected()) {
            String connectBleName = MySharedPreferences.INSTANCE.getInstance().getConnectBleName();
            String str = connectBleName;
            if (str != null && str.length() != 0) {
                Iterator<T> it = bleList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    } else {
                        next = it.next();
                        if (Intrinsics.areEqual(((BleDeviceInfoData) next).getName(), connectBleName)) {
                            break;
                        }
                    }
                }
                final BleDeviceInfoData bleDeviceInfoData = (BleDeviceInfoData) next;
                if (bleDeviceInfoData == null || (mainActivity = getMainActivity()) == null) {
                    return;
                }
                mainActivity.checkBluetoothPermissions(new Function1<Boolean, Unit>() { // from class: com.soletreadmills.sole_v2.ui.home.HomeMainFragment.checkAutoConnectBleName.1
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
                            if (MyApplication.INSTANCE.getAUTO_RECONNECT()) {
                                return;
                            }
                            MainActivity mainActivity3 = HomeMainFragment.this.getMainActivity();
                            if (mainActivity3 != null && (bleManager2 = mainActivity3.getBleManager()) != null && !bleManager2.isServiceConnection && (mainActivity2 = HomeMainFragment.this.getMainActivity()) != null && (bleManager3 = mainActivity2.getBleManager()) != null) {
                                bleManager3.init();
                            }
                            MainActivity mainActivity4 = HomeMainFragment.this.getMainActivity();
                            if (mainActivity4 == null || (bleManager = mainActivity4.getBleManager()) == null) {
                                return;
                            }
                            final HomeMainFragment homeMainFragment = HomeMainFragment.this;
                            final BleDeviceInfoData bleDeviceInfoData2 = bleDeviceInfoData;
                            bleManager.checkBleEnabled(new EnabledBluetoothListener() { // from class: com.soletreadmills.sole_v2.ui.home.HomeMainFragment.checkAutoConnectBleName.1.1
                                @Override // com.soletreadmills.sole_v2.listener.EnabledBluetoothListener
                                public void OnDisable() {
                                    EnabledBluetoothListener.DefaultImpls.OnDisable(this);
                                }

                                @Override // com.soletreadmills.sole_v2.listener.EnabledBluetoothListener
                                public void OnEnabled() {
                                    homeMainFragment.setConnectFtmsBleDeviceInfoData(bleDeviceInfoData2);
                                    BleManager.getInstance().setBluetoothConnectType(BluetoothConnectType.MACHINE);
                                    BleManager.getInstance().setAutoReconnectFtmsBleDeviceInfoData(bleDeviceInfoData2);
                                    BleManager.getInstance().startScanBleDeviceForAutoReconnect();
                                    MyApplication.INSTANCE.setAUTO_RECONNECT(true);
                                }
                            });
                            return;
                        }
                        Toast.makeText(HomeMainFragment.this.requireContext(), "Permission error", 0).show();
                    }
                });
                return;
            }
            MyApplication.INSTANCE.setAUTO_RECONNECT(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setConnectRecyclerView() throws CloneNotSupportedException {
        String bluetoothDeviceName;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        Context context = getContext();
        if (context != null) {
            FragmentHomeMainBinding binding = getBinding();
            RecyclerView.Adapter adapter = null;
            if (!(((binding == null || (recyclerView3 = binding.rvConnect) == null) ? null : recyclerView3.getLayoutManager()) instanceof LinearLayoutManager)) {
                FragmentHomeMainBinding binding2 = getBinding();
                RecyclerView recyclerView4 = binding2 != null ? binding2.rvConnect : null;
                if (recyclerView4 != null) {
                    recyclerView4.setLayoutManager(new LinearLayoutManager(context, 1, false));
                }
            }
            FragmentHomeMainBinding binding3 = getBinding();
            RecyclerView recyclerView5 = binding3 != null ? binding3.rvConnect : null;
            if (recyclerView5 != null) {
                recyclerView5.setItemAnimator(null);
            }
            FragmentHomeMainBinding binding4 = getBinding();
            if (!(((binding4 == null || (recyclerView2 = binding4.rvConnect) == null) ? null : recyclerView2.getAdapter()) instanceof HomeConnectAdapter)) {
                HomeConnectAdapter homeConnectAdapter = new HomeConnectAdapter(new OnItemClickListener() { // from class: com.soletreadmills.sole_v2.ui.home.HomeMainFragment$setConnectRecyclerView$1$adapter$1
                    @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
                    public void onClick(int pos) {
                        RecyclerView recyclerView6;
                        RecyclerView recyclerView7;
                        this.this$0.isUserClickConnectBtn = true;
                        FragmentHomeMainBinding fragmentHomeMainBindingAccess$getBinding = HomeMainFragment.access$getBinding(this.this$0);
                        RecyclerView.Adapter adapter2 = null;
                        RecyclerView.Adapter adapter3 = (fragmentHomeMainBindingAccess$getBinding == null || (recyclerView7 = fragmentHomeMainBindingAccess$getBinding.rvConnect) == null) ? null : recyclerView7.getAdapter();
                        if (adapter3 instanceof HomeConnectAdapter) {
                            List<BleDeviceInfoData> currentList = ((HomeConnectAdapter) adapter3).getCurrentList();
                            Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
                            final BleDeviceInfoData bleDeviceInfoData = currentList.get(pos);
                            BluetoothDevice connectedBluetoothDeviceFtms = BleManager.getInstance().getConnectedBluetoothDeviceFtms();
                            if (connectedBluetoothDeviceFtms != null) {
                                connectedBluetoothDeviceFtms.getAddress();
                            }
                            if (BleManager.getInstance().isConnectedFtms()) {
                                if (bleDeviceInfoData.getConnectionState() != 2) {
                                    String string = this.this$0.getString(R.string.switch_device);
                                    String string2 = this.this$0.getString(R.string.switch_msg);
                                    String string3 = this.this$0.getString(R.string.cancel);
                                    String string4 = this.this$0.getString(R.string.switch_btn);
                                    HomeMainFragment homeMainFragment = this.this$0;
                                    final HomeMainFragment homeMainFragment2 = this.this$0;
                                    CustomDialogKt.showCustomDialog$default(homeMainFragment, string, string2, string4, string3, new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.home.HomeMainFragment$setConnectRecyclerView$1$adapter$1$onClick$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                            HomeMainFragment homeMainFragment3 = homeMainFragment2;
                                            BleDeviceInfoData data = bleDeviceInfoData;
                                            Intrinsics.checkNotNullExpressionValue(data, "$data");
                                            homeMainFragment3.handleBleConnection(data);
                                        }
                                    }, null, false, 96, null);
                                    return;
                                }
                                return;
                            }
                            bleDeviceInfoData.setConnectionState(1);
                            FragmentHomeMainBinding fragmentHomeMainBindingAccess$getBinding2 = HomeMainFragment.access$getBinding(this.this$0);
                            if (fragmentHomeMainBindingAccess$getBinding2 != null && (recyclerView6 = fragmentHomeMainBindingAccess$getBinding2.rvConnect) != null) {
                                adapter2 = recyclerView6.getAdapter();
                            }
                            if (adapter2 instanceof HomeConnectAdapter) {
                                ((HomeConnectAdapter) adapter2).notifyItemChanged(pos);
                            }
                            HomeMainFragment homeMainFragment3 = this.this$0;
                            Intrinsics.checkNotNull(bleDeviceInfoData);
                            homeMainFragment3.handleBleConnection(bleDeviceInfoData);
                        }
                    }

                    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
                    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
                    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
                    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
                    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
                    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
                    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:31)
                    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:60)
                     */
                    @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
                    public void onClick(int pos, String string) {
                        Intrinsics.checkNotNullParameter(string, "string");
                        switch (string.hashCode()) {
                            case -1466751262:
                                if (string.equals("display_stats")) {
                                    Timber.INSTANCE.d("aaaa display_stats", new Object[0]);
                                    BaseFragment.safeNavigate$default(this.this$0, R.id.displayDashboardFragment, null, 2, null);
                                    break;
                                }
                                break;
                            case -273530417:
                                if (string.equals("browse_program")) {
                                    Timber.INSTANCE.d("aaaa browse_program", new Object[0]);
                                    BaseFragment.safeNavigate$default(this.this$0, R.id.connectedPageFragment, null, 2, null);
                                    break;
                                }
                                break;
                            case 529229712:
                                if (string.equals("quick_start")) {
                                    Timber.INSTANCE.d("aaaa quick start", new Object[0]);
                                    BleManager.getInstance().sendCmdFtms(FitnessMachineControlPointCmd.startOrResume());
                                    BaseFragment.safeNavigate$default(this.this$0, R.id.displayDashboardFragment, null, 2, null);
                                    break;
                                }
                                break;
                            case 530405532:
                                if (string.equals(DisconnectCommand.COMMAND)) {
                                    Timber.INSTANCE.d("aaaa disconnect", new Object[0]);
                                    BleDataManager.getInstance().uploadSummaryData();
                                    BleManager.getInstance().bleFtmsDisconnect();
                                    break;
                                }
                                break;
                        }
                    }
                });
                FragmentHomeMainBinding binding5 = getBinding();
                RecyclerView recyclerView6 = binding5 != null ? binding5.rvConnect : null;
                if (recyclerView6 != null) {
                    recyclerView6.setAdapter(homeConnectAdapter);
                }
            }
            ArrayList arrayList = new ArrayList();
            List listPlus = CollectionsKt.plus((Collection) getBleDevice(), (Iterable) getHomeViewModel().getSyncMachineList());
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(listPlus, 10)), 16));
            for (Object obj : listPlus) {
                linkedHashMap.put(((BleDeviceInfoData) obj).getName(), obj);
            }
            List list = CollectionsKt.toList(linkedHashMap.values());
            Timber.INSTANCE.d("Debug isConnectedFtms:%s", Boolean.valueOf(BleManager.getInstance().isConnectedFtms()));
            if (BleManager.getInstance().isConnectedFtms()) {
                FtmsDeviceManager ftmsDeviceManager = BleManager.getInstance().getFtmsDeviceManager();
                bluetoothDeviceName = ftmsDeviceManager != null ? ftmsDeviceManager.getBluetoothDeviceName() : null;
            } else {
                bluetoothDeviceName = "";
            }
            Timber.INSTANCE.d("Debug connectedName:%s", bluetoothDeviceName);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                BleDeviceInfoData bleDeviceInfoDataM8608clone = ((BleDeviceInfoData) it.next()).m8608clone();
                if (Intrinsics.areEqual(bleDeviceInfoDataM8608clone.getName(), bluetoothDeviceName)) {
                    Timber.INSTANCE.d("Debug connectedName name:%s", bluetoothDeviceName);
                    bleDeviceInfoDataM8608clone.setConnectionState(2);
                }
                arrayList.add(bleDeviceInfoDataM8608clone);
            }
            if (arrayList.size() > 0) {
                FragmentHomeMainBinding binding6 = getBinding();
                TextView textView = binding6 != null ? binding6.tvConnect : null;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                FragmentHomeMainBinding binding7 = getBinding();
                ImageView imageView = binding7 != null ? binding7.imgConnect : null;
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
            } else {
                FragmentHomeMainBinding binding8 = getBinding();
                TextView textView2 = binding8 != null ? binding8.tvConnect : null;
                if (textView2 != null) {
                    textView2.setVisibility(0);
                }
                FragmentHomeMainBinding binding9 = getBinding();
                ImageView imageView2 = binding9 != null ? binding9.imgConnect : null;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                }
            }
            FragmentHomeMainBinding binding10 = getBinding();
            if (binding10 != null && (recyclerView = binding10.rvConnect) != null) {
                adapter = recyclerView.getAdapter();
            }
            if (adapter instanceof HomeConnectAdapter) {
                ((HomeConnectAdapter) adapter).submitList(arrayList);
            }
            checkAutoConnectBleName(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleBleConnection(final BleDeviceInfoData data) {
        try {
            if (BleManager.getInstance().isConnectedFtms()) {
                BleManager.getInstance().bleFtmsDisconnect();
            }
            View view = getView();
            if (view != null) {
                view.postDelayed(new Runnable() { // from class: com.soletreadmills.sole_v2.ui.home.HomeMainFragment$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        HomeMainFragment.handleBleConnection$lambda$7(this.f$0, data);
                    }
                }, 500L);
            }
        } catch (Exception e) {
            Timber.INSTANCE.e(e.getMessage(), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleBleConnection$lambda$7(final HomeMainFragment this$0, final BleDeviceInfoData data) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        MainActivity mainActivity = this$0.getMainActivity();
        if (mainActivity != null) {
            mainActivity.checkBluetoothPermissions(new Function1<Boolean, Unit>() { // from class: com.soletreadmills.sole_v2.ui.home.HomeMainFragment$handleBleConnection$1$1
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
                    if (!z) {
                        Toast.makeText(this.this$0.requireContext(), "Permission error", 0).show();
                        return;
                    }
                    MainActivity mainActivity3 = this.this$0.getMainActivity();
                    if (mainActivity3 != null && (bleManager2 = mainActivity3.getBleManager()) != null && !bleManager2.isServiceConnection && (mainActivity2 = this.this$0.getMainActivity()) != null && (bleManager3 = mainActivity2.getBleManager()) != null) {
                        bleManager3.init();
                    }
                    MainActivity mainActivity4 = this.this$0.getMainActivity();
                    if (mainActivity4 == null || (bleManager = mainActivity4.getBleManager()) == null) {
                        return;
                    }
                    final HomeMainFragment homeMainFragment = this.this$0;
                    final BleDeviceInfoData bleDeviceInfoData = data;
                    bleManager.checkBleEnabled(new EnabledBluetoothListener() { // from class: com.soletreadmills.sole_v2.ui.home.HomeMainFragment$handleBleConnection$1$1.1
                        @Override // com.soletreadmills.sole_v2.listener.EnabledBluetoothListener
                        public void OnDisable() {
                            EnabledBluetoothListener.DefaultImpls.OnDisable(this);
                        }

                        @Override // com.soletreadmills.sole_v2.listener.EnabledBluetoothListener
                        public void OnEnabled() {
                            homeMainFragment.setConnectFtmsBleDeviceInfoData(bleDeviceInfoData);
                            HomeMainFragment$handleBleConnection$1$1$1$OnEnabled$pairingListener$1 homeMainFragment$handleBleConnection$1$1$1$OnEnabled$pairingListener$1 = new HomeMainFragment$handleBleConnection$1$1$1$OnEnabled$pairingListener$1(homeMainFragment, bleDeviceInfoData);
                            MainActivity mainActivity5 = homeMainFragment.getMainActivity();
                            if (mainActivity5 != null) {
                                mainActivity5.showPairingDialog(0, null, homeMainFragment$handleBleConnection$1$1$1$OnEnabled$pairingListener$1);
                            }
                            BleManager bleManager4 = BleManager.getInstance();
                            BleDeviceInfoData bleDeviceInfoData2 = bleDeviceInfoData;
                            bleManager4.setBluetoothConnectType(BluetoothConnectType.MACHINE);
                            bleManager4.setAutoReconnectFtmsBleDeviceInfoData(bleDeviceInfoData2);
                            bleManager4.startScanBleDeviceForAutoReconnect();
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showConnectionFailedDialog(BleDeviceInfoData data, final OnPairingDialogDismissListener listener) {
        HomeMainFragment homeMainFragment = this;
        CustomDialogKt.showCustomDialog$default(homeMainFragment, getString(R.string.could_not_connect), getString(R.string.could_not_connect_msg), getString(R.string.try_again), getString(R.string.go_back), new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.home.HomeMainFragment.showConnectionFailedDialog.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                HomeMainFragment.this.isUserClickConnectBtn = true;
                MainActivity mainActivity = HomeMainFragment.this.getMainActivity();
                if (mainActivity != null) {
                    mainActivity.showPairingDialog(0, null, listener);
                }
                BleManager.getInstance().startScanBleDeviceForAutoReconnect();
            }
        }, null, false, 96, null);
    }

    private final void setFavoritesRecyclerview() {
        RecyclerView recyclerView;
        Context context = getContext();
        if (context != null) {
            FragmentHomeMainBinding binding = getBinding();
            FavoritesAdapter favoritesAdapter = null;
            if (!(((binding == null || (recyclerView = binding.rvFavorites) == null) ? null : recyclerView.getLayoutManager()) instanceof LinearLayoutManager)) {
                FragmentHomeMainBinding binding2 = getBinding();
                RecyclerView recyclerView2 = binding2 != null ? binding2.rvFavorites : null;
                if (recyclerView2 != null) {
                    recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
                }
            }
            FragmentHomeMainBinding binding3 = getBinding();
            RecyclerView recyclerView3 = binding3 != null ? binding3.rvFavorites : null;
            if (recyclerView3 != null) {
                recyclerView3.setItemAnimator(null);
            }
            if (this.favoritesAdapter == null) {
                this.favoritesAdapter = new FavoritesAdapter(context, new FavoritesAdapter.OnItemClickListener() { // from class: com.soletreadmills.sole_v2.ui.home.HomeMainFragment$setFavoritesRecyclerview$1$1
                    @Override // com.soletreadmills.sole_v2.ui.adapter.home.FavoritesAdapter.OnItemClickListener
                    public void onItemClick(FavoritesData favoritesData, int position) {
                        Intrinsics.checkNotNullParameter(favoritesData, "favoritesData");
                        Timber.INSTANCE.d("favoritesData: " + favoritesData, new Object[0]);
                        String objectType = favoritesData.getObjectType();
                        if (objectType != null) {
                            int iHashCode = objectType.hashCode();
                            if (iHashCode == 67) {
                                if (objectType.equals("C")) {
                                    Timber.INSTANCE.d("C: Class", new Object[0]);
                                    Bundle bundle = new Bundle();
                                    bundle.putString("classID", favoritesData.getObjectId());
                                    this.this$0.safeNavigate(R.id.classesDetailFragment, bundle);
                                    return;
                                }
                                return;
                            }
                            if (iHashCode != 2153) {
                                if (iHashCode == 2157 && objectType.equals("CP")) {
                                    Timber.INSTANCE.d("CP: Custom program", new Object[0]);
                                    return;
                                }
                                return;
                            }
                            if (objectType.equals("CL")) {
                                Timber.INSTANCE.d("CL: Collection", new Object[0]);
                                Bundle bundle2 = new Bundle();
                                bundle2.putString("collectionId", favoritesData.getObjectId());
                                this.this$0.safeNavigate(R.id.collectionDetailFragment, bundle2);
                            }
                        }
                    }
                });
                FragmentHomeMainBinding binding4 = getBinding();
                RecyclerView recyclerView4 = binding4 != null ? binding4.rvFavorites : null;
                if (recyclerView4 != null) {
                    FavoritesAdapter favoritesAdapter2 = this.favoritesAdapter;
                    if (favoritesAdapter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("favoritesAdapter");
                        favoritesAdapter2 = null;
                    }
                    recyclerView4.setAdapter(favoritesAdapter2);
                }
            }
            FragmentHomeMainBinding binding5 = getBinding();
            RecyclerView recyclerView5 = binding5 != null ? binding5.rvFavorites : null;
            if (recyclerView5 == null) {
                return;
            }
            FavoritesAdapter favoritesAdapter3 = this.favoritesAdapter;
            if (favoritesAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("favoritesAdapter");
            } else {
                favoritesAdapter = favoritesAdapter3;
            }
            recyclerView5.setAdapter(favoritesAdapter);
        }
    }

    private final void setPickForYouRecyclerview() {
        RecyclerView recyclerView;
        Context context = getContext();
        if (context != null) {
            FragmentHomeMainBinding binding = getBinding();
            PickForYouAdapter pickForYouAdapter = null;
            if (!(((binding == null || (recyclerView = binding.rvPickedForYou) == null) ? null : recyclerView.getLayoutManager()) instanceof LinearLayoutManager)) {
                FragmentHomeMainBinding binding2 = getBinding();
                RecyclerView recyclerView2 = binding2 != null ? binding2.rvPickedForYou : null;
                if (recyclerView2 != null) {
                    recyclerView2.setLayoutManager(new LinearLayoutManager(context, 0, false));
                }
            }
            FragmentHomeMainBinding binding3 = getBinding();
            RecyclerView recyclerView3 = binding3 != null ? binding3.rvPickedForYou : null;
            if (recyclerView3 != null) {
                recyclerView3.setItemAnimator(null);
            }
            if (this.pickForYouAdapter == null) {
                this.pickForYouAdapter = new PickForYouAdapter(context, new PickForYouAdapter.OnItemClickListener() { // from class: com.soletreadmills.sole_v2.ui.home.HomeMainFragment$setPickForYouRecyclerview$1$1
                    @Override // com.soletreadmills.sole_v2.ui.adapter.home.PickForYouAdapter.OnItemClickListener
                    public void onItemClick(PickedForYouData data, int position) {
                        Intrinsics.checkNotNullParameter(data, "data");
                        Timber.INSTANCE.d("PickedForYouData: " + data, new Object[0]);
                        Bundle bundle = new Bundle();
                        bundle.putString("classID", data.getClassId());
                        this.this$0.safeNavigate(R.id.classesDetailFragment, bundle);
                    }
                });
            }
            FragmentHomeMainBinding binding4 = getBinding();
            RecyclerView recyclerView4 = binding4 != null ? binding4.rvPickedForYou : null;
            if (recyclerView4 == null) {
                return;
            }
            PickForYouAdapter pickForYouAdapter2 = this.pickForYouAdapter;
            if (pickForYouAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pickForYouAdapter");
            } else {
                pickForYouAdapter = pickForYouAdapter2;
            }
            recyclerView4.setAdapter(pickForYouAdapter);
        }
    }

    private final void setCollectionsRecyclerview() {
        RecyclerView recyclerView;
        Context context = getContext();
        CollectionAdapter collectionAdapter = null;
        if (context != null) {
            FragmentHomeMainBinding binding = getBinding();
            if (!(((binding == null || (recyclerView = binding.rvCollections) == null) ? null : recyclerView.getLayoutManager()) instanceof LinearLayoutManager)) {
                FragmentHomeMainBinding binding2 = getBinding();
                RecyclerView recyclerView2 = binding2 != null ? binding2.rvCollections : null;
                if (recyclerView2 != null) {
                    recyclerView2.setLayoutManager(new LinearLayoutManager(context, 0, false));
                }
            }
            FragmentHomeMainBinding binding3 = getBinding();
            RecyclerView recyclerView3 = binding3 != null ? binding3.rvCollections : null;
            if (recyclerView3 != null) {
                recyclerView3.setItemAnimator(null);
            }
            if (this.collectionsAdapter == null) {
                this.collectionsAdapter = new CollectionAdapter(context, new CollectionAdapter.OnItemClickListener() { // from class: com.soletreadmills.sole_v2.ui.home.HomeMainFragment$setCollectionsRecyclerview$1$1
                    @Override // com.soletreadmills.sole_v2.ui.adapter.home.CollectionAdapter.OnItemClickListener
                    public void onItemClick(ClassCollectionData data, int position) {
                        Intrinsics.checkNotNullParameter(data, "data");
                        Timber.INSTANCE.d("collectionData: " + data, new Object[0]);
                        Bundle bundle = new Bundle();
                        bundle.putString("collectionId", data.getCollection_id());
                        this.this$0.safeNavigate(R.id.collectionDetailFragment, bundle);
                    }
                });
                FragmentHomeMainBinding binding4 = getBinding();
                RecyclerView recyclerView4 = binding4 != null ? binding4.rvCollections : null;
                if (recyclerView4 != null) {
                    CollectionAdapter collectionAdapter2 = this.collectionsAdapter;
                    if (collectionAdapter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("collectionsAdapter");
                        collectionAdapter2 = null;
                    }
                    recyclerView4.setAdapter(collectionAdapter2);
                }
            }
        }
        FragmentHomeMainBinding binding5 = getBinding();
        RecyclerView recyclerView5 = binding5 != null ? binding5.rvCollections : null;
        if (recyclerView5 == null) {
            return;
        }
        CollectionAdapter collectionAdapter3 = this.collectionsAdapter;
        if (collectionAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("collectionsAdapter");
        } else {
            collectionAdapter = collectionAdapter3;
        }
        recyclerView5.setAdapter(collectionAdapter);
    }

    private final void setGoalsRecyclerView() {
        RecyclerView recyclerView;
        Context context = getContext();
        if (context != null) {
            FragmentHomeMainBinding binding = getBinding();
            GoalsAdapter goalsAdapter = null;
            if (((binding == null || (recyclerView = binding.rvGoals) == null) ? null : recyclerView.getLayoutManager()) == null) {
                FragmentHomeMainBinding binding2 = getBinding();
                RecyclerView recyclerView2 = binding2 != null ? binding2.rvGoals : null;
                if (recyclerView2 != null) {
                    recyclerView2.setLayoutManager(new LinearLayoutManager(context, 0, false));
                }
            }
            FragmentHomeMainBinding binding3 = getBinding();
            RecyclerView recyclerView3 = binding3 != null ? binding3.rvGoals : null;
            if (recyclerView3 != null) {
                recyclerView3.setItemAnimator(null);
            }
            if (this.goalsAdapter == null) {
                this.goalsAdapter = new GoalsAdapter(context, new GoalsAdapter.OnItemClickListener() { // from class: com.soletreadmills.sole_v2.ui.home.HomeMainFragment$setGoalsRecyclerView$1$1
                    @Override // com.soletreadmills.sole_v2.ui.adapter.goals.GoalsAdapter.OnItemClickListener
                    public void onItemClick(UserGoalData userGoalData, int position) {
                        Intrinsics.checkNotNullParameter(userGoalData, "userGoalData");
                        Timber.INSTANCE.d("userGoalData: " + userGoalData, new Object[0]);
                        if (Intrinsics.areEqual(userGoalData.getUserGoalUuid(), "addGoal")) {
                            this.this$0.createGoal();
                            return;
                        }
                        this.this$0.getGoalsViewModel().setSelectedGoal(userGoalData);
                        GoalsDetailView.Companion companion = GoalsDetailView.Companion;
                        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
                        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "getParentFragmentManager(...)");
                        companion.show(parentFragmentManager);
                    }
                }, false, false, 12, null);
            }
            FragmentHomeMainBinding binding4 = getBinding();
            RecyclerView recyclerView4 = binding4 != null ? binding4.rvGoals : null;
            if (recyclerView4 == null) {
                return;
            }
            GoalsAdapter goalsAdapter2 = this.goalsAdapter;
            if (goalsAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("goalsAdapter");
            } else {
                goalsAdapter = goalsAdapter2;
            }
            recyclerView4.setAdapter(goalsAdapter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateFavoritesData(List<FavoritesData> favoritesList) {
        List mutableList = CollectionsKt.toMutableList((Collection) favoritesList);
        FavoritesAdapter favoritesAdapter = this.favoritesAdapter;
        if (favoritesAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoritesAdapter");
            favoritesAdapter = null;
        }
        favoritesAdapter.submitList(mutableList);
    }

    /* compiled from: HomeMainFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.home.HomeMainFragment$getFavorites$1", f = "HomeMainFragment.kt", i = {}, l = {WinError.ERROR_ABANDONED_WAIT_63}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.home.HomeMainFragment$getFavorites$1, reason: invalid class name and case insensitive filesystem */
    static final class C09811 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C09811(Continuation<? super C09811> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HomeMainFragment.this.new C09811(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09811) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: HomeMainFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.home.HomeMainFragment$getFavorites$1$1", f = "HomeMainFragment.kt", i = {}, l = {WinError.ERROR_VOLUME_MOUNTED}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.soletreadmills.sole_v2.ui.home.HomeMainFragment$getFavorites$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02561 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ HomeMainFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02561(HomeMainFragment homeMainFragment, Continuation<? super C02561> continuation) {
                super(2, continuation);
                this.this$0 = homeMainFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C02561(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C02561) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                JwtApiBaseData.SysResponseMessage sysMsg;
                JwtApiBaseData.SysResponseMessage sysMsg2;
                JwtApiBaseData.SysResponseMessage sysMsg3;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                try {
                    try {
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            this.this$0.showLoading();
                            this.label = 1;
                            obj = JwtDyacoApiKt.callGetFavorites(new GetFavoritesApiData.RequestBodyData(CollectionsKt.joinToString$default(new ArrayList(), ",", null, null, 0, null, null, 62, null)), this);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        GetFavoritesApiData.ResponseData responseData = (GetFavoritesApiData.ResponseData) ((Response) obj).body();
                        Timber.INSTANCE.d("getFavorites: " + responseData, new Object[0]);
                        String message = null;
                        message = null;
                        if (!Intrinsics.areEqual((responseData == null || (sysMsg3 = responseData.getSysMsg()) == null) ? null : sysMsg3.getCode(), JwtErrorCode.JWT_SUCCESS_1.getId())) {
                            String code = (responseData == null || (sysMsg2 = responseData.getSysMsg()) == null) ? null : sysMsg2.getCode();
                            if (this.this$0.shouldIgnoreError(code)) {
                                return Unit.INSTANCE;
                            }
                            HomeMainFragment homeMainFragment = this.this$0;
                            if (responseData != null && (sysMsg = responseData.getSysMsg()) != null) {
                                message = sysMsg.getMessage();
                            }
                            BaseFragment.handleUndefinedError$default(homeMainFragment, "getFavorites", code, message, false, 8, null);
                        } else {
                            List<FavoritesData> dataMap = responseData.getDataMap();
                            if (dataMap != null) {
                                this.this$0.getHomeViewModel().updateFavoritesList(dataMap);
                            }
                            List<FavoritesData> dataMap2 = responseData.getDataMap();
                            if (dataMap2 == null || dataMap2.isEmpty()) {
                                FragmentHomeMainBinding fragmentHomeMainBindingAccess$getBinding = HomeMainFragment.access$getBinding(this.this$0);
                                ImageView imageView = fragmentHomeMainBindingAccess$getBinding != null ? fragmentHomeMainBindingAccess$getBinding.imgFavoritesMoreBtn : null;
                                if (imageView != null) {
                                    imageView.setVisibility(8);
                                }
                            } else {
                                FragmentHomeMainBinding fragmentHomeMainBindingAccess$getBinding2 = HomeMainFragment.access$getBinding(this.this$0);
                                ImageView imageView2 = fragmentHomeMainBindingAccess$getBinding2 != null ? fragmentHomeMainBindingAccess$getBinding2.imgFavoritesMoreBtn : null;
                                if (imageView2 != null) {
                                    imageView2.setVisibility(0);
                                }
                            }
                        }
                    } catch (Exception e) {
                        String message2 = e.getMessage();
                        if (message2 == null) {
                            message2 = e.getClass().getSimpleName();
                        }
                        BaseFragment.handleApiError$default(this.this$0, "getFavorites", message2, false, 4, null);
                    }
                    this.this$0.stopLoading();
                    return Unit.INSTANCE;
                } finally {
                    this.this$0.stopLoading();
                }
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(HomeMainFragment.this, Lifecycle.State.STARTED, new C02561(HomeMainFragment.this, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    private final void getFavorites() {
        if (getView() == null || !isAdded()) {
            return;
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C09811(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updatePickForYouData(List<PickedForYouData> datas) {
        List mutableList = CollectionsKt.toMutableList((Collection) datas);
        PickForYouAdapter pickForYouAdapter = this.pickForYouAdapter;
        if (pickForYouAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pickForYouAdapter");
            pickForYouAdapter = null;
        }
        pickForYouAdapter.submitList(mutableList);
    }

    private final void getPickFouYouData() {
        if (getView() == null || !isAdded()) {
            return;
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C09841(null), 3, null);
    }

    /* compiled from: HomeMainFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.home.HomeMainFragment$getPickFouYouData$1", f = "HomeMainFragment.kt", i = {}, l = {798}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.home.HomeMainFragment$getPickFouYouData$1, reason: invalid class name and case insensitive filesystem */
    static final class C09841 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C09841(Continuation<? super C09841> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HomeMainFragment.this.new C09841(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09841) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: HomeMainFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.home.HomeMainFragment$getPickFouYouData$1$1", f = "HomeMainFragment.kt", i = {}, l = {800}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.soletreadmills.sole_v2.ui.home.HomeMainFragment$getPickFouYouData$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02591 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ HomeMainFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02591(HomeMainFragment homeMainFragment, Continuation<? super C02591> continuation) {
                super(2, continuation);
                this.this$0 = homeMainFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C02591(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C02591) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                GetVideoRecommendationsApiData.DataMap dataMap;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                try {
                    try {
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            this.label = 1;
                            obj = DyacoApiKt.callGetVideoRecommendations(this);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        Response response = (Response) obj;
                        GetVideoRecommendationsApiData.ResponseData responseData = (GetVideoRecommendationsApiData.ResponseData) response.body();
                        List<PickedForYouData> data = (responseData == null || (dataMap = responseData.getDataMap()) == null) ? null : dataMap.getData();
                        GetVideoRecommendationsApiData.ResponseData responseData2 = (GetVideoRecommendationsApiData.ResponseData) response.body();
                        String errorCode = responseData2 != null ? responseData2.getErrorCode() : null;
                        Timber.INSTANCE.d("callGetVideoRecommendations: " + data, new Object[0]);
                        GetVideoRecommendationsApiData.ResponseData responseData3 = (GetVideoRecommendationsApiData.ResponseData) response.body();
                        if (responseData3 == null || !responseData3.getSuccess() || data == null) {
                            if (this.this$0.shouldIgnoreError(errorCode)) {
                                return Unit.INSTANCE;
                            }
                            HomeMainFragment homeMainFragment = this.this$0;
                            GetVideoRecommendationsApiData.ResponseData responseData4 = (GetVideoRecommendationsApiData.ResponseData) response.body();
                            BaseFragment.handleUndefinedError$default(homeMainFragment, "getPickFouYouData", errorCode, responseData4 != null ? responseData4.getErrorMessage() : null, false, 8, null);
                        } else {
                            Timber.INSTANCE.d("callGetVideoRecommendations: success", new Object[0]);
                            this.this$0.getHomeViewModel().updatePickUpList(data);
                        }
                    } catch (IOException e) {
                        String message = e.getMessage();
                        if (message == null) {
                            message = e.getClass().getSimpleName();
                        }
                        BaseFragment.handleApiError$default(this.this$0, "getPickFouYouData", message, false, 4, null);
                    }
                    SnackbarUtils.dismiss();
                    this.this$0.stopLoading();
                    return Unit.INSTANCE;
                } finally {
                    SnackbarUtils.dismiss();
                    this.this$0.stopLoading();
                }
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(HomeMainFragment.this, Lifecycle.State.STARTED, new C02591(HomeMainFragment.this, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateCollectionsData(List<ClassCollectionData> collectionsList) {
        List mutableList = CollectionsKt.toMutableList((Collection) collectionsList);
        CollectionAdapter collectionAdapter = this.collectionsAdapter;
        if (collectionAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("collectionsAdapter");
            collectionAdapter = null;
        }
        collectionAdapter.submitList(mutableList);
    }

    /* compiled from: HomeMainFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.home.HomeMainFragment$getCollectionsData$1", f = "HomeMainFragment.kt", i = {}, l = {853}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.home.HomeMainFragment$getCollectionsData$1, reason: invalid class name and case insensitive filesystem */
    static final class C09801 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C09801(Continuation<? super C09801> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HomeMainFragment.this.new C09801(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09801) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: HomeMainFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.home.HomeMainFragment$getCollectionsData$1$1", f = "HomeMainFragment.kt", i = {}, l = {856}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.soletreadmills.sole_v2.ui.home.HomeMainFragment$getCollectionsData$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02551 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ HomeMainFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02551(HomeMainFragment homeMainFragment, Continuation<? super C02551> continuation) {
                super(2, continuation);
                this.this$0 = homeMainFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C02551(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C02551) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                JwtApiBaseData.SysResponseMessage sysMsg;
                JwtApiBaseData.SysResponseMessage sysMsg2;
                JwtApiBaseData.SysResponseMessage sysMsg3;
                GetCollectionsApiData.ClassCollectionListDataMap dataMap;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                try {
                    try {
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            this.this$0.showLoading();
                            this.label = 1;
                            obj = JwtDyacoApiKt.callGetCollectionsApiData((14 & 1) != 0 ? null : null, (14 & 2) != 0 ? null : null, (14 & 4) != 0 ? null : null, (14 & 8) != 0 ? false : false, (14 & 16) != 0 ? 1 : 1, (14 & 32) != 0 ? 100 : 12, this);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        Response response = (Response) obj;
                        GetCollectionsApiData.ResponseData responseData = (GetCollectionsApiData.ResponseData) response.body();
                        String message = null;
                        List<ClassCollectionData> data = (responseData == null || (dataMap = responseData.getDataMap()) == null) ? null : dataMap.getData();
                        GetCollectionsApiData.ResponseData responseData2 = (GetCollectionsApiData.ResponseData) response.body();
                        String code = (responseData2 == null || (sysMsg3 = responseData2.getSysMsg()) == null) ? null : sysMsg3.getCode();
                        Timber.INSTANCE.d("callGetCollectionsApiData: " + data, new Object[0]);
                        GetCollectionsApiData.ResponseData responseData3 = (GetCollectionsApiData.ResponseData) response.body();
                        if (!Intrinsics.areEqual((responseData3 == null || (sysMsg2 = responseData3.getSysMsg()) == null) ? null : sysMsg2.getCode(), JwtErrorCode.JWT_SUCCESS_1.getId())) {
                            if (this.this$0.shouldIgnoreError(code)) {
                                return Unit.INSTANCE;
                            }
                            HomeMainFragment homeMainFragment = this.this$0;
                            GetCollectionsApiData.ResponseData responseData4 = (GetCollectionsApiData.ResponseData) response.body();
                            if (responseData4 != null && (sysMsg = responseData4.getSysMsg()) != null) {
                                message = sysMsg.getMessage();
                            }
                            BaseFragment.handleUndefinedError$default(homeMainFragment, "getCollectionsData", code, message, false, 8, null);
                        } else {
                            Timber.INSTANCE.d("callGetCollectionsApiData: success", new Object[0]);
                            if (data != null) {
                                this.this$0.getHomeViewModel().updateCollectionsList(data);
                            }
                        }
                    } catch (IOException e) {
                        String message2 = e.getMessage();
                        if (message2 == null) {
                            message2 = e.getClass().getSimpleName();
                        }
                        BaseFragment.handleApiError$default(this.this$0, "getCollectionsData", message2, false, 4, null);
                    }
                    this.this$0.stopLoading();
                    return Unit.INSTANCE;
                } finally {
                    this.this$0.stopLoading();
                }
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(HomeMainFragment.this, Lifecycle.State.STARTED, new C02551(HomeMainFragment.this, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    private final void getCollectionsData() {
        if (getView() == null || !isAdded()) {
            return;
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C09801(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateGoalsData(List<UserGoalData> goalsList) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : goalsList) {
            if (!Intrinsics.areEqual(String.valueOf(((UserGoalData) obj).getMachineCategoryType()), MachineType.SRVO.getApiCatalogType())) {
                arrayList.add(obj);
            }
        }
        List mutableList = CollectionsKt.toMutableList((Collection) arrayList);
        List list = mutableList;
        if ((list instanceof Collection) && list.isEmpty()) {
            mutableList.add(new UserGoalData("addGoal", null, null, null, null, null, null, null, null, null, null, null, 4094, null));
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(((UserGoalData) it.next()).getUserGoalUuid(), "addGoal")) {
                    break;
                }
            }
            mutableList.add(new UserGoalData("addGoal", null, null, null, null, null, null, null, null, null, null, null, 4094, null));
        }
        GoalsAdapter goalsAdapter = this.goalsAdapter;
        if (goalsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("goalsAdapter");
            goalsAdapter = null;
        }
        goalsAdapter.submitList(mutableList, new Runnable() { // from class: com.soletreadmills.sole_v2.ui.home.HomeMainFragment$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                HomeMainFragment.updateGoalsData$lambda$15(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateGoalsData$lambda$15(final HomeMainFragment this$0) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentHomeMainBinding binding = this$0.getBinding();
        if (binding == null || (recyclerView = binding.rvGoals) == null) {
            return;
        }
        recyclerView.post(new Runnable() { // from class: com.soletreadmills.sole_v2.ui.home.HomeMainFragment$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                HomeMainFragment.updateGoalsData$lambda$15$lambda$14(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateGoalsData$lambda$15$lambda$14(HomeMainFragment this$0) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentHomeMainBinding binding = this$0.getBinding();
        if (binding == null || (recyclerView = binding.rvGoals) == null) {
            return;
        }
        recyclerView.scrollToPosition(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void createGoal() {
        Timber.INSTANCE.d("addGoal", new Object[0]);
        BaseFragment.safeNavigate$default(this, R.id.goalsCreateFragment, null, 2, null);
    }

    /* compiled from: HomeMainFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.home.HomeMainFragment$getGoalsData$1", f = "HomeMainFragment.kt", i = {}, l = {927}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.home.HomeMainFragment$getGoalsData$1, reason: invalid class name and case insensitive filesystem */
    static final class C09821 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C09821(Continuation<? super C09821> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HomeMainFragment.this.new C09821(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09821) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: HomeMainFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.home.HomeMainFragment$getGoalsData$1$1", f = "HomeMainFragment.kt", i = {}, l = {930}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.soletreadmills.sole_v2.ui.home.HomeMainFragment$getGoalsData$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02571 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ HomeMainFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02571(HomeMainFragment homeMainFragment, Continuation<? super C02571> continuation) {
                super(2, continuation);
                this.this$0 = homeMainFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C02571(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C02571) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                GetMyUserGoalListApiData.DataMap dataMap;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                try {
                    try {
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            this.this$0.showLoading();
                            this.label = 1;
                            obj = DyacoApiKt.callGetMyUserGoalList(this);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        Response response = (Response) obj;
                        GetMyUserGoalListApiData.ResponseData responseData = (GetMyUserGoalListApiData.ResponseData) response.body();
                        List<UserGoalData> data = (responseData == null || (dataMap = responseData.getDataMap()) == null) ? null : dataMap.getData();
                        GetMyUserGoalListApiData.ResponseData responseData2 = (GetMyUserGoalListApiData.ResponseData) response.body();
                        String errorCode = responseData2 != null ? responseData2.getErrorCode() : null;
                        Timber.INSTANCE.d("callGetMyUserGoalList: " + data, new Object[0]);
                        GetMyUserGoalListApiData.ResponseData responseData3 = (GetMyUserGoalListApiData.ResponseData) response.body();
                        if (responseData3 == null || !responseData3.getSuccess() || data == null) {
                            if (this.this$0.shouldIgnoreError(errorCode)) {
                                return Unit.INSTANCE;
                            }
                            HomeMainFragment homeMainFragment = this.this$0;
                            GetMyUserGoalListApiData.ResponseData responseData4 = (GetMyUserGoalListApiData.ResponseData) response.body();
                            BaseFragment.handleUndefinedError$default(homeMainFragment, "getGoalsData", errorCode, responseData4 != null ? responseData4.getErrorMessage() : null, false, 8, null);
                        } else {
                            Timber.INSTANCE.d("callGetMyUserGoalList: success", new Object[0]);
                            this.this$0.getGoalsViewModel().updateGoalList(data);
                        }
                    } catch (IOException e) {
                        String message = e.getMessage();
                        if (message == null) {
                            message = e.getClass().getSimpleName();
                        }
                        BaseFragment.handleApiError$default(this.this$0, "getGoalsData", message, false, 4, null);
                    }
                    this.this$0.stopLoading();
                    return Unit.INSTANCE;
                } finally {
                    this.this$0.stopLoading();
                }
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(HomeMainFragment.this, Lifecycle.State.STARTED, new C02571(HomeMainFragment.this, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    private final void getGoalsData() {
        if (getView() == null || !isAdded()) {
            return;
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C09821(null), 3, null);
    }

    /* compiled from: HomeMainFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.home.HomeMainFragment$getMyConnectedMachineList$1", f = "HomeMainFragment.kt", i = {}, l = {1049}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.home.HomeMainFragment$getMyConnectedMachineList$1, reason: invalid class name and case insensitive filesystem */
    static final class C09831 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C09831(Continuation<? super C09831> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HomeMainFragment.this.new C09831(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09831) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: HomeMainFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.home.HomeMainFragment$getMyConnectedMachineList$1$1", f = "HomeMainFragment.kt", i = {}, l = {WinError.ERROR_DEPENDENT_SERVICES_RUNNING}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.soletreadmills.sole_v2.ui.home.HomeMainFragment$getMyConnectedMachineList$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02581 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ HomeMainFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02581(HomeMainFragment homeMainFragment, Continuation<? super C02581> continuation) {
                super(2, continuation);
                this.this$0 = homeMainFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C02581(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C02581) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                View root;
                View root2;
                Runnable runnable;
                FragmentHomeMainBinding fragmentHomeMainBindingAccess$getBinding;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                try {
                    try {
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            this.label = 1;
                            obj = DyacoApiKt.callGetMyConnectedMachineList(this);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        GetMyConnectedMachineListApiData.ResponseData responseData = (GetMyConnectedMachineListApiData.ResponseData) ((Response) obj).body();
                        if (responseData == null || !responseData.getSuccess()) {
                            String errorCode = responseData != null ? responseData.getErrorCode() : null;
                            if (this.this$0.shouldIgnoreError(errorCode)) {
                                return Unit.INSTANCE;
                            }
                            BaseFragment.handleUndefinedError$default(this.this$0, "getMyConnectedMachineList", errorCode, responseData != null ? responseData.getErrorMessage() : null, false, 8, null);
                        } else {
                            this.this$0.getHomeViewModel().getSyncMachineList().clear();
                            GetMyConnectedMachineListApiData.DataMap dataMap = responseData.getDataMap();
                            List<GetMyConnectedMachineListApiData.ConnectedMachineData> data = dataMap != null ? dataMap.getData() : null;
                            List<GetMyConnectedMachineListApiData.ConnectedMachineData> list = data;
                            if (list != null && !list.isEmpty()) {
                                for (GetMyConnectedMachineListApiData.ConnectedMachineData connectedMachineData : data) {
                                    String machineModelName = connectedMachineData.getMachineModelName();
                                    if (machineModelName == null) {
                                        machineModelName = "";
                                    }
                                    BleDeviceInfoData bleDeviceInfoData = new BleDeviceInfoData(machineModelName, "", null, 4, null);
                                    bleDeviceInfoData.setUserSync(true);
                                    bleDeviceInfoData.setHasAdv0x16(true);
                                    bleDeviceInfoData.setMachineType(MachineType.INSTANCE.fromApiCatalogType(String.valueOf(connectedMachineData.getMachineCategoryType().getCode())));
                                    bleDeviceInfoData.setMachineConsoleUuid(connectedMachineData.getMachineConsoleUuid());
                                    this.this$0.getHomeViewModel().getSyncMachineList().add(bleDeviceInfoData);
                                }
                            }
                        }
                        Timber.INSTANCE.d(" homeViewModel.syncMachineList:" + this.this$0.getHomeViewModel().getSyncMachineList(), new Object[0]);
                        fragmentHomeMainBindingAccess$getBinding = HomeMainFragment.access$getBinding(this.this$0);
                    } catch (Exception e) {
                        Timber.INSTANCE.e(e);
                        String message = e.getMessage();
                        if (message == null) {
                            message = e.getClass().getSimpleName();
                        }
                        BaseFragment.handleApiError$default(this.this$0, "getMyConnectedMachineList", message, false, 4, null);
                        FragmentHomeMainBinding fragmentHomeMainBindingAccess$getBinding2 = HomeMainFragment.access$getBinding(this.this$0);
                        if (fragmentHomeMainBindingAccess$getBinding2 != null && (root2 = fragmentHomeMainBindingAccess$getBinding2.getRoot()) != null) {
                            final HomeMainFragment homeMainFragment = this.this$0;
                            runnable = new Runnable() { // from class: com.soletreadmills.sole_v2.ui.home.HomeMainFragment$getMyConnectedMachineList$1$1$$ExternalSyntheticLambda0
                                @Override // java.lang.Runnable
                                public final void run() throws CloneNotSupportedException {
                                    HomeMainFragment.access$setConnectRecyclerView(homeMainFragment);
                                }
                            };
                        }
                    }
                    if (fragmentHomeMainBindingAccess$getBinding != null && (root2 = fragmentHomeMainBindingAccess$getBinding.getRoot()) != null) {
                        final HomeMainFragment homeMainFragment2 = this.this$0;
                        runnable = new Runnable() { // from class: com.soletreadmills.sole_v2.ui.home.HomeMainFragment$getMyConnectedMachineList$1$1$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() throws CloneNotSupportedException {
                                HomeMainFragment.access$setConnectRecyclerView(homeMainFragment2);
                            }
                        };
                        Boxing.boxBoolean(root2.post(runnable));
                    }
                    return Unit.INSTANCE;
                } finally {
                    FragmentHomeMainBinding fragmentHomeMainBindingAccess$getBinding3 = HomeMainFragment.access$getBinding(this.this$0);
                    if (fragmentHomeMainBindingAccess$getBinding3 != null && (root = fragmentHomeMainBindingAccess$getBinding3.getRoot()) != null) {
                        final HomeMainFragment homeMainFragment3 = this.this$0;
                        Boxing.boxBoolean(root.post(new Runnable() { // from class: com.soletreadmills.sole_v2.ui.home.HomeMainFragment$getMyConnectedMachineList$1$1$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() throws CloneNotSupportedException {
                                HomeMainFragment.access$setConnectRecyclerView(homeMainFragment3);
                            }
                        }));
                    }
                }
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(HomeMainFragment.this, Lifecycle.State.STARTED, new C02581(HomeMainFragment.this, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final void getMyConnectedMachineList() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C09831(null), 3, null);
    }

    /* compiled from: HomeMainFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.home.HomeMainFragment$apiGetSubscriptionStatus$1", f = "HomeMainFragment.kt", i = {}, l = {WinError.ERROR_DLL_INIT_FAILED}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.home.HomeMainFragment$apiGetSubscriptionStatus$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HomeMainFragment.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: HomeMainFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.home.HomeMainFragment$apiGetSubscriptionStatus$1$1", f = "HomeMainFragment.kt", i = {}, l = {WinError.ERROR_NO_SHUTDOWN_IN_PROGRESS}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.soletreadmills.sole_v2.ui.home.HomeMainFragment$apiGetSubscriptionStatus$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02531 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ HomeMainFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02531(HomeMainFragment homeMainFragment, Continuation<? super C02531> continuation) {
                super(2, continuation);
                this.this$0 = homeMainFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C02531(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C02531) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                JwtApiBaseData.SysResponseMessage sysMsg;
                GetSubscriptionStatusDataMap dataMap;
                JwtApiBaseData.SysResponseMessage sysMsg2;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        obj = JwtDyacoApiKt.callGetSubscriptionStatus(this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    Response response = (Response) obj;
                    GetSubscriptionStatusApiData.ResponseData responseData = (GetSubscriptionStatusApiData.ResponseData) response.body();
                    String message = null;
                    message = null;
                    String code = (responseData == null || (sysMsg2 = responseData.getSysMsg()) == null) ? null : sysMsg2.getCode();
                    if (!Intrinsics.areEqual(code, JwtErrorCode.JWT_SUCCESS_1.getId())) {
                        if (this.this$0.shouldIgnoreError(code)) {
                            return Unit.INSTANCE;
                        }
                        HomeMainFragment homeMainFragment = this.this$0;
                        GetSubscriptionStatusApiData.ResponseData responseData2 = (GetSubscriptionStatusApiData.ResponseData) response.body();
                        if (responseData2 != null && (sysMsg = responseData2.getSysMsg()) != null) {
                            message = sysMsg.getMessage();
                        }
                        homeMainFragment.handleUndefinedError("apiGetSubscriptionStatus", code, message, false);
                    } else {
                        SubscriptionStatusType subscriptionStatus = (responseData == null || (dataMap = responseData.getDataMap()) == null) ? null : dataMap.getSubscriptionStatus();
                        if (subscriptionStatus != null && SubscriptionStatusType.INSTANCE.isSubscribedOrTrial(subscriptionStatus)) {
                            Global.INSTANCE.setSubscription(true);
                            FragmentHomeMainBinding fragmentHomeMainBindingAccess$getBinding = HomeMainFragment.access$getBinding(this.this$0);
                            LinearLayout linearLayout = fragmentHomeMainBindingAccess$getBinding != null ? fragmentHomeMainBindingAccess$getBinding.LLGetPremium : null;
                            if (linearLayout != null) {
                                linearLayout.setVisibility(8);
                            }
                        } else {
                            Global.INSTANCE.setSubscription(false);
                            FragmentHomeMainBinding fragmentHomeMainBindingAccess$getBinding2 = HomeMainFragment.access$getBinding(this.this$0);
                            LinearLayout linearLayout2 = fragmentHomeMainBindingAccess$getBinding2 != null ? fragmentHomeMainBindingAccess$getBinding2.LLGetPremium : null;
                            if (linearLayout2 != null) {
                                linearLayout2.setVisibility(0);
                            }
                        }
                    }
                } catch (Exception e) {
                    Timber.INSTANCE.e(e);
                    String message2 = e.getMessage();
                    if (message2 == null) {
                        message2 = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(this.this$0, "apiGetSubscriptionStatus", message2, false, 4, null);
                }
                return Unit.INSTANCE;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(HomeMainFragment.this, Lifecycle.State.STARTED, new C02531(HomeMainFragment.this, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final void apiGetSubscriptionStatus() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new AnonymousClass1(null), 3, null);
    }
}
