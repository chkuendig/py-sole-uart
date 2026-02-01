package com.soletreadmills.sole_v2.ui.displayMode;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.viewpager2.widget.ViewPager2;
import com.android.SdkConstants;
import com.google.android.exoplayer2.source.rtsp.RtspMediaSource;
import com.soletreadmills.sole_v2.Global;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.login.LoginUserData;
import com.soletreadmills.sole_v2._extension.CustomDialogKt;
import com.soletreadmills.sole_v2._manager.BleManager;
import com.soletreadmills.sole_v2._sharedPreferences.MySharedPreferences;
import com.soletreadmills.sole_v2._tools.ConvertUtils;
import com.soletreadmills.sole_v2._tools.UnitConversion;
import com.soletreadmills.sole_v2._tools.WearDataTool;
import com.soletreadmills.sole_v2._type.WearStatusType;
import com.soletreadmills.sole_v2.ble.cmd.FitnessMachineControlPointCmd;
import com.soletreadmills.sole_v2.ble.data.CrossTrainerData;
import com.soletreadmills.sole_v2.ble.data.FtmsBaseData;
import com.soletreadmills.sole_v2.ble.data.IndoorBikeData;
import com.soletreadmills.sole_v2.ble.data.RowerData;
import com.soletreadmills.sole_v2.ble.data.StepClimberData;
import com.soletreadmills.sole_v2.ble.data.TreadmillData;
import com.soletreadmills.sole_v2.ble.manager.BleDataManager;
import com.soletreadmills.sole_v2.ble.manager.FtmsDeviceManager;
import com.soletreadmills.sole_v2.ble.tool.CheckSimpleFtmsDeviceTool;
import com.soletreadmills.sole_v2.ble.type.BleFtmsMachineType;
import com.soletreadmills.sole_v2.ble.type.FitnessMachineFeatureType;
import com.soletreadmills.sole_v2.ble.type.FitnessMachineStatusType;
import com.soletreadmills.sole_v2.ble.type.TrainingStatusType;
import com.soletreadmills.sole_v2.databinding.FragmentDisplayDashboardBinding;
import com.soletreadmills.sole_v2.ui.MainActivity;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import com.soletreadmills.sole_v2.ui.displayMode.DisplayModeAdjustCustomView;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import timber.log.Timber;

/* compiled from: DisplayDashboardFragment.kt */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003*\u0002\n\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u001a\u00102\u001a\u00020\u00022\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000106H\u0016J\b\u00107\u001a\u000208H\u0016J\u0018\u00109\u001a\u0002082\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010:\u001a\u00020\u0010H\u0002J\b\u0010;\u001a\u000208H\u0002J\u0012\u0010<\u001a\u0002082\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\u0012\u0010?\u001a\u0002082\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\b\u0010B\u001a\u000208H\u0016J\b\u0010C\u001a\u000208H\u0016J\b\u0010D\u001a\u000208H\u0016J\b\u0010E\u001a\u000208H\u0016J\b\u0010F\u001a\u000208H\u0016J\u001a\u0010G\u001a\u0002082\u0006\u0010H\u001a\u00020>2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\b\u0010I\u001a\u000208H\u0002J\u000e\u0010J\u001a\u0002082\u0006\u0010K\u001a\u00020\u0016J\u000e\u0010L\u001a\u0002082\u0006\u0010M\u001a\u00020\bJ\u0006\u0010N\u001a\u000208J\b\u0010O\u001a\u000208H\u0002J\b\u0010P\u001a\u000208H\u0002J\u0010\u0010Q\u001a\u0002082\u0006\u0010R\u001a\u00020\u0016H\u0002J\b\u0010S\u001a\u000208H\u0002J\b\u0010T\u001a\u000208H\u0002J\b\u0010U\u001a\u00020\u0016H\u0002J\u0012\u0010V\u001a\u0002082\b\u0010W\u001a\u0004\u0018\u00010XH\u0002J\u0012\u0010Y\u001a\u0002082\b\u0010Z\u001a\u0004\u0018\u00010[H\u0002J\u0012\u0010\\\u001a\u0002082\b\u0010W\u001a\u0004\u0018\u00010XH\u0002J\b\u0010]\u001a\u000208H\u0002J\b\u0010^\u001a\u000208H\u0002J\u0016\u0010_\u001a\u0002082\u0006\u0010K\u001a\u00020\u00162\u0006\u0010`\u001a\u00020aJ\u0010\u0010b\u001a\u0002082\u0006\u0010c\u001a\u00020aH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001bR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0012\"\u0004\b&\u0010\u0014R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010*\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b,\u0010-R\u000e\u00100\u001a\u000201X\u0082.¢\u0006\u0002\n\u0000¨\u0006d"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/displayMode/DisplayDashboardFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/databinding/FragmentDisplayDashboardBinding;", "Landroid/view/View$OnClickListener;", "()V", "autoScrollHandler", "Landroid/os/Handler;", "autoScrollInterval", "", "autoScrollRunnable", "com/soletreadmills/sole_v2/ui/displayMode/DisplayDashboardFragment$autoScrollRunnable$1", "Lcom/soletreadmills/sole_v2/ui/displayMode/DisplayDashboardFragment$autoScrollRunnable$1;", "bluetoothCallbackListener", "com/soletreadmills/sole_v2/ui/displayMode/DisplayDashboardFragment$bluetoothCallbackListener$1", "Lcom/soletreadmills/sole_v2/ui/displayMode/DisplayDashboardFragment$bluetoothCallbackListener$1;", "firstFtmsData", "Lcom/soletreadmills/sole_v2/ble/data/FtmsBaseData;", "getFirstFtmsData", "()Lcom/soletreadmills/sole_v2/ble/data/FtmsBaseData;", "setFirstFtmsData", "(Lcom/soletreadmills/sole_v2/ble/data/FtmsBaseData;)V", "isAutoScrollEnabled", "", "isCloseDisplayModePage", "isFinish", "()Z", "setFinish", "(Z)V", "isOnStart", "setOnStart", "machineType", "Lcom/soletreadmills/sole_v2/ble/type/BleFtmsMachineType;", "getMachineType", "()Lcom/soletreadmills/sole_v2/ble/type/BleFtmsMachineType;", "setMachineType", "(Lcom/soletreadmills/sole_v2/ble/type/BleFtmsMachineType;)V", "oldFtmsData", "getOldFtmsData", "setOldFtmsData", "tabIndicators", "", "Landroid/widget/ImageView;", "viewModel", "Lcom/soletreadmills/sole_v2/ui/displayMode/DisplayModeViewModel;", "getViewModel", "()Lcom/soletreadmills/sole_v2/ui/displayMode/DisplayModeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "viewPager", "Landroidx/viewpager2/widget/ViewPager2;", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", "", "loadControlBtn", "ftmsData", "loadRotateSettings", SdkConstants.ATTR_ON_CLICK, "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onPause", "onResume", "onStart", "onStop", "onViewCreated", "view", "restartAutoScroll", "setAutoScrollEnabled", "enabled", "setAutoScrollInterval", "intervalMs", "setBlueToothConnectStatus", "setControlPanel", "setFinishBackBtn", "setPanelStart", "isStart", "setupCustomTabIndicator", "setupViewPager", "shouldShowAppCalculationMessage", "showIdle", "trainingStatusType", "Lcom/soletreadmills/sole_v2/ble/type/TrainingStatusType;", "showPaused", "fitnessMachineStatusType", "Lcom/soletreadmills/sole_v2/ble/type/FitnessMachineStatusType;", "showStart", "startAutoScroll", "stopAutoScroll", "updateRotateSettings", "intervalSeconds", "", "updateTabIndicator", "position", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DisplayDashboardFragment extends BaseFragment<FragmentDisplayDashboardBinding> implements View.OnClickListener {
    public static final int $stable = 8;
    private FtmsBaseData firstFtmsData;
    private final boolean isCloseDisplayModePage;
    private boolean isFinish;
    private boolean isOnStart;
    private FtmsBaseData oldFtmsData;
    private List<? extends ImageView> tabIndicators;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    private ViewPager2 viewPager;
    private final Handler autoScrollHandler = new Handler(Looper.getMainLooper());
    private long autoScrollInterval = RtspMediaSource.DEFAULT_TIMEOUT_MS;
    private boolean isAutoScrollEnabled = true;
    private final DisplayDashboardFragment$autoScrollRunnable$1 autoScrollRunnable = new Runnable() { // from class: com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardFragment$autoScrollRunnable$1
        @Override // java.lang.Runnable
        public void run() {
            if (this.this$0.isAutoScrollEnabled && this.this$0.isAdded()) {
                ViewPager2 viewPager2 = this.this$0.viewPager;
                ViewPager2 viewPager22 = null;
                if (viewPager2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                    viewPager2 = null;
                }
                int currentItem = (viewPager2.getCurrentItem() + 1) % 3;
                ViewPager2 viewPager23 = this.this$0.viewPager;
                if (viewPager23 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                } else {
                    viewPager22 = viewPager23;
                }
                viewPager22.setCurrentItem(currentItem, true);
                this.this$0.autoScrollHandler.postDelayed(this, this.this$0.autoScrollInterval);
            }
        }
    };
    private BleFtmsMachineType machineType = BleFtmsMachineType.TREADMILL;
    private final DisplayDashboardFragment$bluetoothCallbackListener$1 bluetoothCallbackListener = new DisplayDashboardFragment$bluetoothCallbackListener$1(this);

    /* compiled from: DisplayDashboardFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BleFtmsMachineType.values().length];
            try {
                iArr[BleFtmsMachineType.TREADMILL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BleFtmsMachineType.ELLIPTICAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BleFtmsMachineType.BIKE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[BleFtmsMachineType.STEPPER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[BleFtmsMachineType.ROWER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardFragment$autoScrollRunnable$1] */
    public DisplayDashboardFragment() {
        final DisplayDashboardFragment displayDashboardFragment = this;
        final Function0 function0 = null;
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(displayDashboardFragment, Reflection.getOrCreateKotlinClass(DisplayModeViewModel.class), new Function0<ViewModelStore>() { // from class: com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = displayDashboardFragment.requireActivity().getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardFragment$special$$inlined$activityViewModels$default$2
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
                CreationExtras defaultViewModelCreationExtras = displayDashboardFragment.requireActivity().getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = displayDashboardFragment.requireActivity().getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DisplayModeViewModel getViewModel() {
        return (DisplayModeViewModel) this.viewModel.getValue();
    }

    public final BleFtmsMachineType getMachineType() {
        return this.machineType;
    }

    public final void setMachineType(BleFtmsMachineType bleFtmsMachineType) {
        Intrinsics.checkNotNullParameter(bleFtmsMachineType, "<set-?>");
        this.machineType = bleFtmsMachineType;
    }

    /* renamed from: isOnStart, reason: from getter */
    public final boolean getIsOnStart() {
        return this.isOnStart;
    }

    public final void setOnStart(boolean z) {
        this.isOnStart = z;
    }

    public final FtmsBaseData getFirstFtmsData() {
        return this.firstFtmsData;
    }

    public final void setFirstFtmsData(FtmsBaseData ftmsBaseData) {
        this.firstFtmsData = ftmsBaseData;
    }

    public final FtmsBaseData getOldFtmsData() {
        return this.oldFtmsData;
    }

    public final void setOldFtmsData(FtmsBaseData ftmsBaseData) {
        this.oldFtmsData = ftmsBaseData;
    }

    /* renamed from: isFinish, reason: from getter */
    public final boolean getIsFinish() {
        return this.isFinish;
    }

    public final void setFinish(boolean z) {
        this.isFinish = z;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardFragment$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    DisplayDashboardFragment.onCreate$lambda$0(this.f$0);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(DisplayDashboardFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Timber.INSTANCE.d("call CALL_WEAR_OPEN", new Object[0]);
        WearDataTool.INSTANCE.callWearCommand(WearStatusType.CALL_WEAR_OPEN.getId(), this$0.requireContext());
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public FragmentDisplayDashboardBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentDisplayDashboardBinding fragmentDisplayDashboardBindingInflate = FragmentDisplayDashboardBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentDisplayDashboardBindingInflate, "inflate(...)");
        return fragmentDisplayDashboardBindingInflate;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setupViewPager();
        setupCustomTabIndicator();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C09601(null), 3, null);
    }

    /* compiled from: DisplayDashboardFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardFragment$onViewCreated$1", f = "DisplayDashboardFragment.kt", i = {}, l = {137}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardFragment$onViewCreated$1, reason: invalid class name and case insensitive filesystem */
    static final class C09601 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C09601(Continuation<? super C09601> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DisplayDashboardFragment.this.new C09601(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09601) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: DisplayDashboardFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardFragment$onViewCreated$1$1", f = "DisplayDashboardFragment.kt", i = {}, l = {142}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardFragment$onViewCreated$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02391 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ DisplayDashboardFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02391(DisplayDashboardFragment displayDashboardFragment, Continuation<? super C02391> continuation) {
                super(2, continuation);
                this.this$0 = displayDashboardFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C02391(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C02391) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Flow flowM10619catch = FlowKt.m10619catch(FlowKt.distinctUntilChanged(FlowKt.sample(this.this$0.getViewModel().getFtmsData(), 1000L)), new C02401(null));
                    final DisplayDashboardFragment displayDashboardFragment = this.this$0;
                    this.label = 1;
                    if (flowM10619catch.collect(new FlowCollector() { // from class: com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardFragment.onViewCreated.1.1.2
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                            return emit((FtmsBaseData) obj2, (Continuation<? super Unit>) continuation);
                        }

                        public final Object emit(FtmsBaseData ftmsBaseData, Continuation<? super Unit> continuation) {
                            Timber.INSTANCE.d("update control val: " + ftmsBaseData, new Object[0]);
                            DisplayDashboardFragment displayDashboardFragment2 = displayDashboardFragment;
                            displayDashboardFragment2.loadControlBtn(displayDashboardFragment2.getMachineType(), displayDashboardFragment.getViewModel().getFtmsData().getValue());
                            displayDashboardFragment.setControlPanel();
                            displayDashboardFragment.setFinishBackBtn();
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
                return Unit.INSTANCE;
            }

            /* compiled from: DisplayDashboardFragment.kt */
            @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/soletreadmills/sole_v2/ble/data/FtmsBaseData;", "e", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
            @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardFragment$onViewCreated$1$1$1", f = "DisplayDashboardFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardFragment$onViewCreated$1$1$1, reason: invalid class name and collision with other inner class name */
            static final class C02401 extends SuspendLambda implements Function3<FlowCollector<? super FtmsBaseData>, Throwable, Continuation<? super Unit>, Object> {
                /* synthetic */ Object L$0;
                int label;

                C02401(Continuation<? super C02401> continuation) {
                    super(3, continuation);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(FlowCollector<? super FtmsBaseData> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
                    C02401 c02401 = new C02401(continuation);
                    c02401.L$0 = th;
                    return c02401.invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    Timber.INSTANCE.e((Throwable) this.L$0, "ftmsData collect error", new Object[0]);
                    return Unit.INSTANCE;
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
                if (RepeatOnLifecycleKt.repeatOnLifecycle(DisplayDashboardFragment.this.getViewLifecycleOwner().getLifecycle(), Lifecycle.State.STARTED, new C02391(DisplayDashboardFragment.this, null), this) == coroutine_suspended) {
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

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public void initViews() {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        LinearLayout linearLayout4;
        ImageView imageView;
        ImageView imageView2;
        LinearLayout linearLayout5;
        LinearLayout linearLayout6;
        BleManager bleManager;
        FtmsDeviceManager ftmsDeviceManager;
        BleManager bleManager2;
        BleManager.getInstance().removeBluetoothCallbackListener(this.bluetoothCallbackListener);
        MainActivity mainActivity = getMainActivity();
        if (mainActivity != null && (bleManager2 = mainActivity.getBleManager()) != null) {
            bleManager2.addBluetoothCallbackListener(this.bluetoothCallbackListener);
        }
        MainActivity mainActivity2 = getMainActivity();
        BleFtmsMachineType bleFtmsMachineType = (mainActivity2 == null || (bleManager = mainActivity2.getBleManager()) == null || (ftmsDeviceManager = bleManager.getFtmsDeviceManager()) == null) ? null : ftmsDeviceManager.getBleFtmsMachineType();
        if (bleFtmsMachineType == null) {
            bleFtmsMachineType = BleFtmsMachineType.TREADMILL;
        }
        this.machineType = bleFtmsMachineType;
        DisplayModeViewModel.loadStatsForMachine$default(getViewModel(), this.machineType, false, 2, null);
        FragmentDisplayDashboardBinding binding = getBinding();
        if (binding != null && (linearLayout6 = binding.finishBtn) != null) {
            linearLayout6.setOnClickListener(this);
        }
        FragmentDisplayDashboardBinding binding2 = getBinding();
        if (binding2 != null && (linearLayout5 = binding2.backBtn) != null) {
            linearLayout5.setOnClickListener(this);
        }
        FragmentDisplayDashboardBinding binding3 = getBinding();
        if (binding3 != null && (imageView2 = binding3.rotateSetting) != null) {
            imageView2.setOnClickListener(this);
        }
        FragmentDisplayDashboardBinding binding4 = getBinding();
        if (binding4 != null && (imageView = binding4.bleWatch) != null) {
            imageView.setOnClickListener(this);
        }
        FragmentDisplayDashboardBinding binding5 = getBinding();
        if (binding5 != null && (linearLayout4 = binding5.llLeftBottomSheet) != null) {
            linearLayout4.setOnClickListener(this);
        }
        FragmentDisplayDashboardBinding binding6 = getBinding();
        if (binding6 != null && (linearLayout3 = binding6.llRightBottomSheet) != null) {
            linearLayout3.setOnClickListener(this);
        }
        FragmentDisplayDashboardBinding binding7 = getBinding();
        if (binding7 != null && (linearLayout2 = binding7.llStartBtn) != null) {
            linearLayout2.setOnClickListener(this);
        }
        FragmentDisplayDashboardBinding binding8 = getBinding();
        if (binding8 != null && (linearLayout = binding8.llPauseBtn) != null) {
            linearLayout.setOnClickListener(this);
        }
        loadRotateSettings();
        loadControlBtn(this.machineType, getViewModel().getFtmsData().getValue());
        setBlueToothConnectStatus();
        MainActivity mainActivity3 = getMainActivity();
        if (mainActivity3 != null) {
            Timber.INSTANCE.d("=== Debug Start ===", new Object[0]);
            BleManager bleManager3 = mainActivity3.getBleManager();
            Timber.INSTANCE.d("bleManager is null? " + (bleManager3 == null), new Object[0]);
            if (bleManager3 == null) {
                Timber.INSTANCE.d("bleManager is null, returning", new Object[0]);
                return;
            }
            FtmsDeviceManager ftmsDeviceManager2 = bleManager3.getFtmsDeviceManager();
            Timber.INSTANCE.d("ftmsDeviceManager is null? " + (ftmsDeviceManager2 == null), new Object[0]);
            if (ftmsDeviceManager2 == null) {
                Timber.INSTANCE.d("ftmsDeviceManager is null, returning", new Object[0]);
                return;
            }
            String bluetoothDeviceName = ftmsDeviceManager2.getBluetoothDeviceName();
            boolean zIsSimpleFtmsDevice = CheckSimpleFtmsDeviceTool.isSimpleFtmsDevice(bluetoothDeviceName);
            boolean zIsHasAdv0x16 = bleManager3.isHasAdv0x16();
            boolean zIsHasAdv0x162 = ftmsDeviceManager2.isHasAdv0x16();
            boolean zIsShowAppCalculationMessage = bleManager3.isShowAppCalculationMessage();
            Timber.INSTANCE.d("deviceName: " + bluetoothDeviceName, new Object[0]);
            Timber.INSTANCE.d("isSimpleDevice: " + zIsSimpleFtmsDevice, new Object[0]);
            Timber.INSTANCE.d("hasAdv0x16: " + zIsHasAdv0x16, new Object[0]);
            Timber.INSTANCE.d("hasAdv0x16-2: " + zIsHasAdv0x162, new Object[0]);
            Timber.INSTANCE.d("hasShownMessage: " + zIsShowAppCalculationMessage, new Object[0]);
            Timber.INSTANCE.d("Condition 1 (isSimpleDevice): " + zIsSimpleFtmsDevice, new Object[0]);
            Timber.INSTANCE.d("Condition 2 (hasAdv0x16 == false): " + (!zIsHasAdv0x16), new Object[0]);
            Timber.INSTANCE.d("Condition 3 (hasShownMessage == false): " + (!zIsShowAppCalculationMessage), new Object[0]);
            Timber.INSTANCE.d("All conditions: " + ((!zIsSimpleFtmsDevice || zIsHasAdv0x16 || zIsShowAppCalculationMessage) ? false : true), new Object[0]);
            if (zIsSimpleFtmsDevice && !zIsHasAdv0x16 && !zIsShowAppCalculationMessage) {
                Timber.INSTANCE.d("Showing dialog", new Object[0]);
                CustomDialogKt.showCustomDialog$default(this, getString(R.string.warning), getString(R.string.simple_ftms_notice_msg), getString(R.string.got_it), getString(R.string.skip_next_time), new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardFragment$initViews$1$1
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }
                }, new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardFragment$initViews$1$2
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
                        MainActivity mainActivity4 = this.this$0.getMainActivity();
                        BleManager bleManager4 = mainActivity4 != null ? mainActivity4.getBleManager() : null;
                        if (bleManager4 == null) {
                            return;
                        }
                        bleManager4.setShowAppCalculationMessage(true);
                    }
                }, false, 64, null);
            } else {
                Timber.INSTANCE.d("Not showing dialog", new Object[0]);
            }
        }
        setControlPanel();
        setFinishBackBtn();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Integer numValueOf = v != null ? Integer.valueOf(v.getId()) : null;
        int i = R.id.finishBtn;
        if (numValueOf != null && numValueOf.intValue() == i) {
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new AnonymousClass1(null), 3, null);
            return;
        }
        int i2 = R.id.backBtn;
        if (numValueOf != null && numValueOf.intValue() == i2) {
            BleDataManager.getInstance().uploadSummaryData();
            BleManager.getInstance().bleFtmsDisconnect();
            getViewModel().resetFtmsData();
            safeNavigateUp();
            return;
        }
        int i3 = R.id.rotateSetting;
        if (numValueOf != null && numValueOf.intValue() == i3) {
            BaseFragment.safeNavigate$default(this, R.id.displaySettingsFragment, null, 2, null);
            return;
        }
        int i4 = R.id.ble_watch;
        if (numValueOf != null && numValueOf.intValue() == i4) {
            BaseFragment.safeNavigate$default(this, R.id.heartRateMonitorFragment, null, 2, null);
            return;
        }
        int i5 = R.id.ll_pause_btn;
        if (numValueOf != null && numValueOf.intValue() == i5) {
            BleManager.getInstance().sendCmdFtms(FitnessMachineControlPointCmd.pause());
            return;
        }
        int i6 = R.id.ll_start_btn;
        if (numValueOf != null && numValueOf.intValue() == i6) {
            BleManager.getInstance().sendCmdFtms(FitnessMachineControlPointCmd.startOrResume());
            return;
        }
        int i7 = R.id.ll_left_bottomSheet;
        if (numValueOf != null && numValueOf.intValue() == i7) {
            if (this.machineType == BleFtmsMachineType.TREADMILL) {
                CustomDialogKt.showCustomDialog$default(this, null, getString(R.string.speed_control_msg), null, null, null, null, false, 125, null);
                return;
            }
            DisplayModeAdjustCustomView.Companion companion = DisplayModeAdjustCustomView.INSTANCE;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "getParentFragmentManager(...)");
            companion.show(parentFragmentManager, this.machineType, !Global.INSTANCE.getUnitType(), DisplayModeAdjustCustomView.Position.LEFT);
            return;
        }
        int i8 = R.id.ll_right_bottomSheet;
        if (numValueOf != null && numValueOf.intValue() == i8) {
            DisplayModeAdjustCustomView.Companion companion2 = DisplayModeAdjustCustomView.INSTANCE;
            FragmentManager parentFragmentManager2 = getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager2, "getParentFragmentManager(...)");
            companion2.show(parentFragmentManager2, this.machineType, !Global.INSTANCE.getUnitType(), DisplayModeAdjustCustomView.Position.RIGHT);
        }
    }

    /* compiled from: DisplayDashboardFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardFragment$onClick$1", f = "DisplayDashboardFragment.kt", i = {}, l = {254}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardFragment$onClick$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DisplayDashboardFragment.this.new AnonymousClass1(continuation);
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
                BleManager.getInstance().sendCmdFtms(FitnessMachineControlPointCmd.pause());
                this.label = 1;
                if (DelayKt.delay(500L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            BleManager.getInstance().sendCmdFtms(FitnessMachineControlPointCmd.stop());
            BleDataManager.getInstance().uploadSummaryData();
            DisplayDashboardFragment.this.getViewModel().resetFtmsData();
            DisplayDashboardFragment.this.safeNavigateUp();
            return Unit.INSTANCE;
        }
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment, androidx.fragment.app.Fragment
    public void onStart() {
        View root;
        super.onStart();
        Timber.INSTANCE.d("===onStart", new Object[0]);
        showStart(BleDataManager.getInstance().getNowTrainingStatusType());
        showPaused(BleDataManager.getInstance().getNowFMSTypeOnlyFourType());
        showIdle(BleDataManager.getInstance().getNowTrainingStatusType());
        this.isOnStart = true;
        MainActivity mainActivity = getMainActivity();
        if (mainActivity != null) {
            mainActivity.setScreenOn(true);
        }
        if (this.isCloseDisplayModePage) {
            Timber.INSTANCE.d("===onStart > onBackPressed", new Object[0]);
            FragmentDisplayDashboardBinding binding = getBinding();
            if (binding == null || (root = binding.getRoot()) == null) {
                return;
            }
            root.post(new Runnable() { // from class: com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardFragment$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    DisplayDashboardFragment.onStart$lambda$2(this.f$0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onStart$lambda$2(DisplayDashboardFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainActivity mainActivity = this$0.getMainActivity();
        if (mainActivity != null) {
            mainActivity.onBackPressed();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        Timber.INSTANCE.d("===onStop", new Object[0]);
        this.isOnStart = false;
        MainActivity mainActivity = getMainActivity();
        if (mainActivity != null) {
            mainActivity.setScreenOn(false);
        }
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Timber.INSTANCE.d("Resume display board", new Object[0]);
        loadRotateSettings();
        if (this.isAutoScrollEnabled) {
            startAutoScroll();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        stopAutoScroll();
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        BleManager bleManager;
        MainActivity mainActivity = getMainActivity();
        if (mainActivity != null && (bleManager = mainActivity.getBleManager()) != null) {
            bleManager.removeBluetoothCallbackListener(this.bluetoothCallbackListener);
        }
        stopAutoScroll();
        getViewModel().resetFtmsData();
        super.onDestroyView();
    }

    private final boolean shouldShowAppCalculationMessage() {
        BleManager bleManager;
        BleManager bleManager2;
        BleManager bleManager3;
        MainActivity mainActivity = getMainActivity();
        FtmsDeviceManager ftmsDeviceManager = (mainActivity == null || (bleManager3 = mainActivity.getBleManager()) == null) ? null : bleManager3.getFtmsDeviceManager();
        if (ftmsDeviceManager == null) {
            return false;
        }
        boolean zIsSimpleFtmsDevice = CheckSimpleFtmsDeviceTool.isSimpleFtmsDevice(ftmsDeviceManager.getBluetoothDeviceName());
        MainActivity mainActivity2 = getMainActivity();
        boolean z = (mainActivity2 == null || (bleManager2 = mainActivity2.getBleManager()) == null || bleManager2.isHasAdv0x16()) ? false : true;
        MainActivity mainActivity3 = getMainActivity();
        return zIsSimpleFtmsDevice && z && (mainActivity3 != null && (bleManager = mainActivity3.getBleManager()) != null && !bleManager.isShowAppCalculationMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadControlBtn(BleFtmsMachineType machineType, FtmsBaseData ftmsData) {
        LinearLayout linearLayout;
        ArrayList<FitnessMachineFeatureType> fitnessMachineFeatureList = BleDataManager.getInstance().getFitnessMachineFeatureList();
        Timber.INSTANCE.d("supportList:" + fitnessMachineFeatureList, new Object[0]);
        FragmentDisplayDashboardBinding binding = getBinding();
        LinearLayout linearLayout2 = binding != null ? binding.llLeftLine : null;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        FragmentDisplayDashboardBinding binding2 = getBinding();
        LinearLayout linearLayout3 = binding2 != null ? binding2.llLeftBottomSheet : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
        FragmentDisplayDashboardBinding binding3 = getBinding();
        LinearLayout linearLayout4 = binding3 != null ? binding3.llRightLine : null;
        if (linearLayout4 != null) {
            linearLayout4.setVisibility(8);
        }
        FragmentDisplayDashboardBinding binding4 = getBinding();
        LinearLayout linearLayout5 = binding4 != null ? binding4.llRightBottomSheet : null;
        if (linearLayout5 != null) {
            linearLayout5.setVisibility(8);
        }
        if (fitnessMachineFeatureList == null || !(!fitnessMachineFeatureList.isEmpty())) {
            return;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[machineType.ordinal()];
        if (i == 1) {
            Context context = getContext();
            if (context != null) {
                FragmentDisplayDashboardBinding binding5 = getBinding();
                TextView textView = binding5 != null ? binding5.tvLeftUnit : null;
                if (textView != null) {
                    textView.setText(context.getString(R.string.speed));
                }
                FragmentDisplayDashboardBinding binding6 = getBinding();
                TextView textView2 = binding6 != null ? binding6.tvRightUnit : null;
                if (textView2 != null) {
                    textView2.setText(context.getString(R.string.incline));
                }
            }
            TreadmillData treadmillData = ftmsData instanceof TreadmillData ? (TreadmillData) ftmsData : null;
            if (treadmillData == null) {
                return;
            }
            String strValueOf = String.valueOf(treadmillData.getInstantaneousSpeed());
            if (Global.INSTANCE.getUnitType()) {
                ConvertUtils convertUtils = ConvertUtils.INSTANCE;
                UnitConversion unitConversion = UnitConversion.INSTANCE;
                Number instantaneousSpeed = treadmillData.getInstantaneousSpeed();
                if (instantaneousSpeed == null) {
                    instantaneousSpeed = 0;
                }
                strValueOf = ConvertUtils.formatToTwoDecimalSmart$default(convertUtils, unitConversion.getMi(instantaneousSpeed.toString(), 2), null, 2, null);
            }
            FragmentDisplayDashboardBinding binding7 = getBinding();
            TextView textView3 = binding7 != null ? binding7.tvLeftValue : null;
            if (textView3 != null) {
                textView3.setText(strValueOf);
            }
            FragmentDisplayDashboardBinding binding8 = getBinding();
            TextView textView4 = binding8 != null ? binding8.tvRightValue : null;
            if (textView4 != null) {
                textView4.setText(String.valueOf(treadmillData.getInclination()));
            }
            if (fitnessMachineFeatureList.contains(FitnessMachineFeatureType.AVERAGE_SPEED_SUPPORTED) || fitnessMachineFeatureList.contains(FitnessMachineFeatureType.SPEED_TARGET_SETTING_SUPPORTED)) {
                FragmentDisplayDashboardBinding binding9 = getBinding();
                LinearLayout linearLayout6 = binding9 != null ? binding9.llLeftLine : null;
                if (linearLayout6 != null) {
                    linearLayout6.setVisibility(0);
                }
                FragmentDisplayDashboardBinding binding10 = getBinding();
                LinearLayout linearLayout7 = binding10 != null ? binding10.llLeftBottomSheet : null;
                if (linearLayout7 != null) {
                    linearLayout7.setVisibility(0);
                }
            }
            if (fitnessMachineFeatureList.contains(FitnessMachineFeatureType.INCLINATION_SUPPORTED) || fitnessMachineFeatureList.contains(FitnessMachineFeatureType.INCLINATION_TARGET_SETTING_SUPPORTED)) {
                FragmentDisplayDashboardBinding binding11 = getBinding();
                LinearLayout linearLayout8 = binding11 != null ? binding11.llRightLine : null;
                if (linearLayout8 != null) {
                    linearLayout8.setVisibility(0);
                }
                FragmentDisplayDashboardBinding binding12 = getBinding();
                linearLayout = binding12 != null ? binding12.llRightBottomSheet : null;
                if (linearLayout == null) {
                    return;
                }
                linearLayout.setVisibility(0);
                return;
            }
            return;
        }
        if (i == 2) {
            Context context2 = getContext();
            if (context2 != null) {
                FragmentDisplayDashboardBinding binding13 = getBinding();
                TextView textView5 = binding13 != null ? binding13.tvLeftUnit : null;
                if (textView5 != null) {
                    textView5.setText(context2.getString(R.string.resistance));
                }
                FragmentDisplayDashboardBinding binding14 = getBinding();
                TextView textView6 = binding14 != null ? binding14.tvRightUnit : null;
                if (textView6 != null) {
                    textView6.setText(context2.getString(R.string.incline));
                }
            }
            CrossTrainerData crossTrainerData = ftmsData instanceof CrossTrainerData ? (CrossTrainerData) ftmsData : null;
            if (crossTrainerData == null) {
                return;
            }
            FragmentDisplayDashboardBinding binding15 = getBinding();
            TextView textView7 = binding15 != null ? binding15.tvLeftValue : null;
            if (textView7 != null) {
                textView7.setText(String.valueOf(crossTrainerData.getResistanceLevel()));
            }
            FragmentDisplayDashboardBinding binding16 = getBinding();
            TextView textView8 = binding16 != null ? binding16.tvRightValue : null;
            if (textView8 != null) {
                textView8.setText(String.valueOf(crossTrainerData.getInclination()));
            }
            if (fitnessMachineFeatureList.contains(FitnessMachineFeatureType.RESISTANCE_LEVEL_SUPPORTED)) {
                FragmentDisplayDashboardBinding binding17 = getBinding();
                LinearLayout linearLayout9 = binding17 != null ? binding17.llLeftLine : null;
                if (linearLayout9 != null) {
                    linearLayout9.setVisibility(0);
                }
                FragmentDisplayDashboardBinding binding18 = getBinding();
                LinearLayout linearLayout10 = binding18 != null ? binding18.llLeftBottomSheet : null;
                if (linearLayout10 != null) {
                    linearLayout10.setVisibility(0);
                }
            }
            if (fitnessMachineFeatureList.contains(FitnessMachineFeatureType.INCLINATION_SUPPORTED)) {
                FragmentDisplayDashboardBinding binding19 = getBinding();
                LinearLayout linearLayout11 = binding19 != null ? binding19.llRightLine : null;
                if (linearLayout11 != null) {
                    linearLayout11.setVisibility(0);
                }
                FragmentDisplayDashboardBinding binding20 = getBinding();
                linearLayout = binding20 != null ? binding20.llRightBottomSheet : null;
                if (linearLayout == null) {
                    return;
                }
                linearLayout.setVisibility(0);
                return;
            }
            return;
        }
        if (i == 3) {
            Context context3 = getContext();
            if (context3 != null) {
                FragmentDisplayDashboardBinding binding21 = getBinding();
                TextView textView9 = binding21 != null ? binding21.tvLeftUnit : null;
                if (textView9 != null) {
                    textView9.setText(context3.getString(R.string.resistance));
                }
                FragmentDisplayDashboardBinding binding22 = getBinding();
                TextView textView10 = binding22 != null ? binding22.tvRightUnit : null;
                if (textView10 != null) {
                    textView10.setText(context3.getString(R.string.incline));
                }
            }
            IndoorBikeData indoorBikeData = ftmsData instanceof IndoorBikeData ? (IndoorBikeData) ftmsData : null;
            if (indoorBikeData == null) {
                return;
            }
            FragmentDisplayDashboardBinding binding23 = getBinding();
            TextView textView11 = binding23 != null ? binding23.tvLeftValue : null;
            if (textView11 != null) {
                textView11.setText(String.valueOf(indoorBikeData.getResistanceLevel()));
            }
            FragmentDisplayDashboardBinding binding24 = getBinding();
            TextView textView12 = binding24 != null ? binding24.tvRightValue : null;
            if (textView12 != null) {
                textView12.setText(String.valueOf(indoorBikeData.getInclination()));
            }
            if (fitnessMachineFeatureList.contains(FitnessMachineFeatureType.RESISTANCE_LEVEL_SUPPORTED)) {
                FragmentDisplayDashboardBinding binding25 = getBinding();
                LinearLayout linearLayout12 = binding25 != null ? binding25.llLeftLine : null;
                if (linearLayout12 != null) {
                    linearLayout12.setVisibility(0);
                }
                FragmentDisplayDashboardBinding binding26 = getBinding();
                LinearLayout linearLayout13 = binding26 != null ? binding26.llLeftBottomSheet : null;
                if (linearLayout13 != null) {
                    linearLayout13.setVisibility(0);
                }
            }
            if (fitnessMachineFeatureList.contains(FitnessMachineFeatureType.INCLINATION_SUPPORTED)) {
                FragmentDisplayDashboardBinding binding27 = getBinding();
                LinearLayout linearLayout14 = binding27 != null ? binding27.llRightLine : null;
                if (linearLayout14 != null) {
                    linearLayout14.setVisibility(0);
                }
                FragmentDisplayDashboardBinding binding28 = getBinding();
                linearLayout = binding28 != null ? binding28.llRightBottomSheet : null;
                if (linearLayout == null) {
                    return;
                }
                linearLayout.setVisibility(0);
                return;
            }
            return;
        }
        if (i == 4) {
            Context context4 = getContext();
            if (context4 != null) {
                FragmentDisplayDashboardBinding binding29 = getBinding();
                TextView textView13 = binding29 != null ? binding29.tvLeftUnit : null;
                if (textView13 != null) {
                    textView13.setText(context4.getString(R.string.resistance));
                }
            }
            StepClimberData stepClimberData = ftmsData instanceof StepClimberData ? (StepClimberData) ftmsData : null;
            if (stepClimberData == null) {
                return;
            }
            FragmentDisplayDashboardBinding binding30 = getBinding();
            TextView textView14 = binding30 != null ? binding30.tvLeftValue : null;
            if (textView14 != null) {
                textView14.setText(String.valueOf(stepClimberData.getResistanceLevel()));
            }
            FragmentDisplayDashboardBinding binding31 = getBinding();
            LinearLayout linearLayout15 = binding31 != null ? binding31.llLeftLine : null;
            if (linearLayout15 != null) {
                linearLayout15.setVisibility(0);
            }
            FragmentDisplayDashboardBinding binding32 = getBinding();
            linearLayout = binding32 != null ? binding32.llLeftBottomSheet : null;
            if (linearLayout == null) {
                return;
            }
            linearLayout.setVisibility(0);
            return;
        }
        if (i != 5) {
            return;
        }
        Context context5 = getContext();
        if (context5 != null) {
            FragmentDisplayDashboardBinding binding33 = getBinding();
            TextView textView15 = binding33 != null ? binding33.tvLeftUnit : null;
            if (textView15 != null) {
                textView15.setText(context5.getString(R.string.resistance));
            }
        }
        RowerData rowerData = ftmsData instanceof RowerData ? (RowerData) ftmsData : null;
        if (rowerData == null) {
            return;
        }
        FragmentDisplayDashboardBinding binding34 = getBinding();
        TextView textView16 = binding34 != null ? binding34.tvLeftValue : null;
        if (textView16 != null) {
            textView16.setText(String.valueOf(rowerData.getResistanceLevel()));
        }
        FragmentDisplayDashboardBinding binding35 = getBinding();
        LinearLayout linearLayout16 = binding35 != null ? binding35.llLeftLine : null;
        if (linearLayout16 != null) {
            linearLayout16.setVisibility(0);
        }
        FragmentDisplayDashboardBinding binding36 = getBinding();
        linearLayout = binding36 != null ? binding36.llLeftBottomSheet : null;
        if (linearLayout == null) {
            return;
        }
        linearLayout.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showStart(final TrainingStatusType trainingStatusType) {
        FitnessMachineStatusType nowFitnessMachineStatusType = BleDataManager.getInstance().getNowFitnessMachineStatusType();
        if (trainingStatusType == null) {
            Timber.INSTANCE.d("showStart-1", new Object[0]);
            return;
        }
        if (trainingStatusType == TrainingStatusType.IDLE) {
            Timber.INSTANCE.d("showStart-2 (" + trainingStatusType + ')', new Object[0]);
            return;
        }
        if (nowFitnessMachineStatusType == FitnessMachineStatusType.FITNESS_MACHINE_PAUSED_BY_THE_USER || nowFitnessMachineStatusType == FitnessMachineStatusType.FITNESS_MACHINE_STOPPED_BY_THE_USER) {
            Timber.INSTANCE.d("showStart-3 (" + nowFitnessMachineStatusType + ')', new Object[0]);
            return;
        }
        if (nowFitnessMachineStatusType == FitnessMachineStatusType.FITNESS_MACHINE_STOPPED_BY_SAFETY_KEY) {
            Timber.INSTANCE.d("showStart-4 X (" + trainingStatusType + ')', new Object[0]);
        }
        MainActivity mainActivity = getMainActivity();
        if (mainActivity != null) {
            mainActivity.runOnUiThread(new Runnable() { // from class: com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardFragment$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    DisplayDashboardFragment.showStart$lambda$9(trainingStatusType, this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showStart$lambda$9(TrainingStatusType trainingStatusType, final DisplayDashboardFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Timber.INSTANCE.d("showStart-true (" + trainingStatusType + ')', new Object[0]);
        this$0.setPanelStart(true);
        try {
            Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardFragment$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    DisplayDashboardFragment.showStart$lambda$9$lambda$8(this.f$0);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showStart$lambda$9$lambda$8(DisplayDashboardFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WearDataTool.INSTANCE.callWearCommand(WearStatusType.MACHINE_IS_START.getId(), this$0.requireContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showPaused(final FitnessMachineStatusType fitnessMachineStatusType) {
        BleManager bleManager;
        if (!Global.INSTANCE.isUseMachineControl()) {
            Timber.INSTANCE.d("showPaused-1", new Object[0]);
            return;
        }
        MainActivity mainActivity = getMainActivity();
        if (mainActivity != null && (bleManager = mainActivity.getBleManager()) != null && !bleManager.isFitnessMachineControlPoint()) {
            Timber.INSTANCE.d("showPaused-2", new Object[0]);
            return;
        }
        if (fitnessMachineStatusType == null) {
            Timber.INSTANCE.d("showPaused-3", new Object[0]);
            return;
        }
        if (fitnessMachineStatusType != FitnessMachineStatusType.FITNESS_MACHINE_PAUSED_BY_THE_USER && fitnessMachineStatusType != FitnessMachineStatusType.FITNESS_MACHINE_STOPPED_BY_THE_USER) {
            Timber.INSTANCE.d("showPaused-4 (" + fitnessMachineStatusType + ')', new Object[0]);
            return;
        }
        MainActivity mainActivity2 = getMainActivity();
        if (mainActivity2 != null) {
            mainActivity2.runOnUiThread(new Runnable() { // from class: com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardFragment$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    DisplayDashboardFragment.showPaused$lambda$11(fitnessMachineStatusType, this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPaused$lambda$11(FitnessMachineStatusType fitnessMachineStatusType, final DisplayDashboardFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Timber.INSTANCE.d("showPaused-false (" + fitnessMachineStatusType + ')', new Object[0]);
        this$0.setPanelStart(false);
        try {
            Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardFragment$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    DisplayDashboardFragment.showPaused$lambda$11$lambda$10(this.f$0);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPaused$lambda$11$lambda$10(DisplayDashboardFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WearDataTool.INSTANCE.callWearCommand(WearStatusType.MACHINE_IS_STOP.getId(), this$0.requireContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showIdle(TrainingStatusType trainingStatusType) {
        Timber.INSTANCE.d("aaaa:Idle", new Object[0]);
        if (trainingStatusType == null || trainingStatusType != TrainingStatusType.IDLE || BleDataManager.getInstance().getNowFMSTypeOnlyFourType() == FitnessMachineStatusType.FITNESS_MACHINE_STOPPED_BY_SAFETY_KEY) {
            return;
        }
        Timber.INSTANCE.d("aaaa:Idle OK", new Object[0]);
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
                FragmentDisplayDashboardBinding binding = getBinding();
                imageView = binding != null ? binding.imgWatch : null;
                if (imageView == null) {
                    return;
                }
                imageView.setVisibility(0);
                return;
            }
            FragmentDisplayDashboardBinding binding2 = getBinding();
            imageView = binding2 != null ? binding2.imgWatch : null;
            if (imageView == null) {
                return;
            }
            imageView.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setFinishBackBtn() {
        BleManager bleManager;
        FragmentDisplayDashboardBinding binding = getBinding();
        if (binding != null) {
            LinearLayout linearLayout = binding.finishBtn;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            LinearLayout linearLayout2 = binding.backBtn;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(0);
            }
            MainActivity mainActivity = getMainActivity();
            if (mainActivity == null || (bleManager = mainActivity.getBleManager()) == null || !bleManager.isFitnessMachineControlPoint()) {
                return;
            }
            LinearLayout linearLayout3 = binding.finishBtn;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(0);
            }
            LinearLayout linearLayout4 = binding.backBtn;
            if (linearLayout4 == null) {
                return;
            }
            linearLayout4.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setControlPanel() {
        BleManager bleManager;
        FragmentDisplayDashboardBinding binding = getBinding();
        if (binding != null) {
            LinearLayout linearLayout = binding.llControlPanel;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            MainActivity mainActivity = getMainActivity();
            if (mainActivity == null || (bleManager = mainActivity.getBleManager()) == null || !bleManager.isFitnessMachineControlPoint()) {
                return;
            }
            FragmentDisplayDashboardBinding binding2 = getBinding();
            LinearLayout linearLayout2 = binding2 != null ? binding2.llControlPanel : null;
            if (linearLayout2 == null) {
                return;
            }
            linearLayout2.setVisibility(0);
        }
    }

    private final void setPanelStart(boolean isStart) {
        LinearLayout linearLayout;
        Timber.INSTANCE.d("setPanelStart::" + isStart, new Object[0]);
        if (isStart) {
            FragmentDisplayDashboardBinding binding = getBinding();
            LinearLayout linearLayout2 = binding != null ? binding.llStartPanel : null;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(0);
            }
            FragmentDisplayDashboardBinding binding2 = getBinding();
            linearLayout = binding2 != null ? binding2.llPausePanel : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            getViewModel().setRunning(true);
            try {
                Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardFragment$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        DisplayDashboardFragment.setPanelStart$lambda$15(this.f$0);
                    }
                });
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        FragmentDisplayDashboardBinding binding3 = getBinding();
        LinearLayout linearLayout3 = binding3 != null ? binding3.llStartPanel : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
        FragmentDisplayDashboardBinding binding4 = getBinding();
        linearLayout = binding4 != null ? binding4.llPausePanel : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        getViewModel().setRunning(false);
        try {
            Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardFragment$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    DisplayDashboardFragment.setPanelStart$lambda$16(this.f$0);
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setPanelStart$lambda$15(DisplayDashboardFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WearDataTool.INSTANCE.callWearCommand(WearStatusType.MACHINE_IS_START.getId(), this$0.requireContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setPanelStart$lambda$16(DisplayDashboardFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WearDataTool.INSTANCE.callWearCommand(WearStatusType.MACHINE_IS_STOP.getId(), this$0.requireContext());
    }

    private final void loadRotateSettings() {
        String userUuid;
        Timber.INSTANCE.d("輪播設定 - loadRotateSettings", new Object[0]);
        LoginUserData loginUserData = Global.userData;
        if (loginUserData == null || (userUuid = loginUserData.getUserUuid()) == null) {
            return;
        }
        Timber.INSTANCE.d("輪播設定 - userData:" + userUuid, new Object[0]);
        this.isAutoScrollEnabled = MySharedPreferences.INSTANCE.getInstance().getRotateAutomatically(userUuid);
        long rotateEvery = MySharedPreferences.INSTANCE.getInstance().getRotateEvery(userUuid);
        this.autoScrollInterval = 1000 * rotateEvery;
        Timber.INSTANCE.d("輪播設定 - 自動: " + this.isAutoScrollEnabled + ", 間隔: " + rotateEvery + (char) 31186, new Object[0]);
    }

    private final void setupViewPager() {
        FragmentDisplayDashboardBinding binding = getBinding();
        if (binding != null) {
            ViewPager2 viewPager = binding.viewPager;
            Intrinsics.checkNotNullExpressionValue(viewPager, "viewPager");
            this.viewPager = viewPager;
        }
        DashboardPagerAdapter dashboardPagerAdapter = new DashboardPagerAdapter(this);
        ViewPager2 viewPager2 = this.viewPager;
        ViewPager2 viewPager22 = null;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager2 = null;
        }
        viewPager2.setAdapter(dashboardPagerAdapter);
        ViewPager2 viewPager23 = this.viewPager;
        if (viewPager23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager23 = null;
        }
        viewPager23.setUserInputEnabled(true);
        ViewPager2 viewPager24 = this.viewPager;
        if (viewPager24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager24 = null;
        }
        viewPager24.setOrientation(0);
        ViewPager2 viewPager25 = this.viewPager;
        if (viewPager25 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager25 = null;
        }
        viewPager25.setUserInputEnabled(true);
        ViewPager2 viewPager26 = this.viewPager;
        if (viewPager26 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager26 = null;
        }
        viewPager26.setOffscreenPageLimit(1);
        ViewPager2 viewPager27 = this.viewPager;
        if (viewPager27 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        } else {
            viewPager22 = viewPager27;
        }
        viewPager22.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardFragment.setupViewPager.2
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
                if (state != 0) {
                    if (state != 1) {
                        return;
                    }
                    DisplayDashboardFragment.this.stopAutoScroll();
                } else if (DisplayDashboardFragment.this.isAutoScrollEnabled) {
                    DisplayDashboardFragment.this.startAutoScroll();
                }
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                DisplayDashboardFragment.this.updateTabIndicator(position);
            }
        });
    }

    private final void setupCustomTabIndicator() {
        FragmentDisplayDashboardBinding binding = getBinding();
        if (binding != null) {
            ImageView tabIndicator1 = binding.tabIndicator1;
            Intrinsics.checkNotNullExpressionValue(tabIndicator1, "tabIndicator1");
            ImageView tabIndicator2 = binding.tabIndicator2;
            Intrinsics.checkNotNullExpressionValue(tabIndicator2, "tabIndicator2");
            ImageView tabIndicator3 = binding.tabIndicator3;
            Intrinsics.checkNotNullExpressionValue(tabIndicator3, "tabIndicator3");
            this.tabIndicators = CollectionsKt.listOf((Object[]) new ImageView[]{tabIndicator1, tabIndicator2, tabIndicator3});
        }
        List<? extends ImageView> list = this.tabIndicators;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabIndicators");
            list = null;
        }
        final int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ((ImageView) obj).setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DisplayDashboardFragment.setupCustomTabIndicator$lambda$20$lambda$19(this.f$0, i, view);
                }
            });
            i = i2;
        }
        updateTabIndicator(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupCustomTabIndicator$lambda$20$lambda$19(DisplayDashboardFragment this$0, int i, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ViewPager2 viewPager2 = this$0.viewPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager2 = null;
        }
        viewPager2.setCurrentItem(i);
        if (this$0.isAutoScrollEnabled) {
            this$0.restartAutoScroll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateTabIndicator(int position) {
        int i;
        int i2;
        List<? extends ImageView> list = this.tabIndicators;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabIndicators");
            list = null;
        }
        int i3 = 0;
        for (Object obj : list) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ImageView imageView = (ImageView) obj;
            if (i3 == position) {
                if (i3 == 0) {
                    i2 = R.drawable.ic_workout_tab_1;
                } else if (i3 == 1) {
                    i2 = R.drawable.ic_workout_tab_2;
                } else if (i3 == 2) {
                    i2 = R.drawable.ic_workout_tab_3;
                } else {
                    i2 = R.drawable.ic_workout_tab_1;
                }
                imageView.setImageResource(i2);
                imageView.setAlpha(1.0f);
            } else {
                if (i3 == 0) {
                    i = R.drawable.ic_workout_tab_1_gray;
                } else if (i3 == 1) {
                    i = R.drawable.ic_workout_tab_2_gray;
                } else if (i3 == 2) {
                    i = R.drawable.ic_workout_tab_3_gray;
                } else {
                    i = R.drawable.ic_workout_tab_1_gray;
                }
                imageView.setImageResource(i);
                imageView.setAlpha(0.5f);
            }
            i3 = i4;
        }
    }

    public final void updateRotateSettings(boolean enabled, int intervalSeconds) {
        this.isAutoScrollEnabled = enabled;
        this.autoScrollInterval = intervalSeconds * 1000;
        if (enabled) {
            startAutoScroll();
        } else {
            stopAutoScroll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startAutoScroll() {
        stopAutoScroll();
        if (this.isAutoScrollEnabled) {
            this.autoScrollHandler.postDelayed(this.autoScrollRunnable, this.autoScrollInterval);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopAutoScroll() {
        this.autoScrollHandler.removeCallbacks(this.autoScrollRunnable);
    }

    private final void restartAutoScroll() {
        stopAutoScroll();
        startAutoScroll();
    }

    public final void setAutoScrollEnabled(boolean enabled) {
        this.isAutoScrollEnabled = enabled;
        if (enabled) {
            startAutoScroll();
        } else {
            stopAutoScroll();
        }
    }

    public final void setAutoScrollInterval(long intervalMs) {
        stopAutoScroll();
        this.autoScrollHandler.postDelayed(this.autoScrollRunnable, intervalMs);
    }
}
