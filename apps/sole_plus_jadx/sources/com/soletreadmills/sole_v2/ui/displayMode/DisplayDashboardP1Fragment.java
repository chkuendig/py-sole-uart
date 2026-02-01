package com.soletreadmills.sole_v2.ui.displayMode;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.camera.video.AudioStats;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.SdkConstants;
import com.soletreadmills.sole_v2.Global;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.club.DisplaySelectStatsData;
import com.soletreadmills.sole_v2._data.login.LoginUserData;
import com.soletreadmills.sole_v2._manager.BleManager;
import com.soletreadmills.sole_v2._manager.ChangeViewManager;
import com.soletreadmills.sole_v2._tools.ConvertUtils;
import com.soletreadmills.sole_v2._tools.TimeTools;
import com.soletreadmills.sole_v2._tools.UnitConversion;
import com.soletreadmills.sole_v2._type.DisplayStatsType;
import com.soletreadmills.sole_v2.ble.data.FtmsBaseData;
import com.soletreadmills.sole_v2.ble.manager.FtmsDeviceManager;
import com.soletreadmills.sole_v2.ble.type.BleFtmsMachineType;
import com.soletreadmills.sole_v2.databinding.FragmentDisplayDashboardP1Binding;
import com.soletreadmills.sole_v2.ui.MainActivity;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import com.soletreadmills.sole_v2.ui.adapter.displayMode.DisplayModeItemAdapter;
import com.soletreadmills.sole_v2.ui.customview.DisplayStatsSelectCustom;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
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
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import timber.log.Timber;

/* compiled from: DisplayDashboardP1Fragment.kt */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J!\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0002\u0010\u001cJ!\u0010\u001d\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0002\u0010\u001cJ)\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010!\u001a\u0004\u0018\u00010\u001f2\b\u0010\"\u001a\u0004\u0018\u00010\u001f¢\u0006\u0002\u0010#J\u0015\u0010$\u001a\u00020\u00182\b\u0010%\u001a\u0004\u0018\u00010\u001f¢\u0006\u0002\u0010&J#\u0010'\u001a\u00020\u00182\b\u0010(\u001a\u0004\u0018\u00010)2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0002\u0010*J\u0017\u0010+\u001a\u00020\u00182\b\u0010,\u001a\u0004\u0018\u00010)H\u0002¢\u0006\u0002\u0010-J\u0017\u0010.\u001a\u00020\u00182\b\u0010%\u001a\u0004\u0018\u00010)H\u0002¢\u0006\u0002\u0010-J\u0017\u0010/\u001a\u00020\u00182\b\u00100\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0002\u00101J\u001a\u00102\u001a\u00020\u00182\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000106H\u0002J\u001a\u00107\u001a\u00020\u00022\u0006\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\b\u0010<\u001a\u00020=H\u0016J\u0010\u0010>\u001a\u00020=2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0012\u0010?\u001a\u00020=2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\u0012\u0010B\u001a\u00020=2\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J\u001a\u0010E\u001a\u00020=2\u0006\u0010F\u001a\u00020A2\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J\u0010\u0010G\u001a\u00020=2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0016\u0010H\u001a\u00020=2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020K0JH\u0002J\u0018\u0010L\u001a\u00020=2\u0006\u0010M\u001a\u00020K2\u0006\u0010N\u001a\u000206H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u00020\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014¨\u0006O"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/displayMode/DisplayDashboardP1Fragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/databinding/FragmentDisplayDashboardP1Binding;", "Landroid/view/View$OnClickListener;", "()V", "displayModeAdapter", "Lcom/soletreadmills/sole_v2/ui/adapter/displayMode/DisplayModeItemAdapter;", "isDragging", "", "itemTouchHelper", "Landroidx/recyclerview/widget/ItemTouchHelper;", "machineType", "Lcom/soletreadmills/sole_v2/ble/type/BleFtmsMachineType;", "getMachineType", "()Lcom/soletreadmills/sole_v2/ble/type/BleFtmsMachineType;", "setMachineType", "(Lcom/soletreadmills/sole_v2/ble/type/BleFtmsMachineType;)V", "viewModel", "Lcom/soletreadmills/sole_v2/ui/displayMode/DisplayModeViewModel;", "getViewModel", "()Lcom/soletreadmills/sole_v2/ui/displayMode/DisplayModeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "calculateAveragePace", "", "totalTimeSec", "", "distance", "(Ljava/lang/Integer;Ljava/lang/Integer;)Ljava/lang/String;", "calculateAveragePaceRower", "calculateMets", "", "speed", "inclinePercent", "watt", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)D", "calculatePace", "speedKmh", "(Ljava/lang/Double;)Ljava/lang/String;", "convertDistance", "distanceM", "", "(Ljava/lang/Float;Lcom/soletreadmills/sole_v2/ble/type/BleFtmsMachineType;)Ljava/lang/String;", "convertElevationGain", "elevationGainM", "(Ljava/lang/Float;)Ljava/lang/String;", "convertSpeed", "convertTime", "seconds", "(Ljava/lang/Integer;)Ljava/lang/String;", "getDisplayValue", "type", "Lcom/soletreadmills/sole_v2/_type/DisplayStatsType;", "ftmsData", "Lcom/soletreadmills/sole_v2/ble/data/FtmsBaseData;", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", "", "loadStatData", SdkConstants.ATTR_ON_CLICK, "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setDisplayModeItemRecyclerView", "updateDisplayModeStatItem", "displayList", "", "Lcom/soletreadmills/sole_v2/_data/club/DisplaySelectStatsData;", "updateItemValue", "selectStat", "ftmsBaseData", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DisplayDashboardP1Fragment extends BaseFragment<FragmentDisplayDashboardP1Binding> implements View.OnClickListener {
    public static final int $stable = 8;
    private DisplayModeItemAdapter displayModeAdapter;
    private boolean isDragging;
    private ItemTouchHelper itemTouchHelper;
    private BleFtmsMachineType machineType = BleFtmsMachineType.TREADMILL;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: DisplayDashboardP1Fragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[DisplayStatsType.values().length];
            try {
                iArr[DisplayStatsType.TIME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DisplayStatsType.REMAINING_TIME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DisplayStatsType.DISTANCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DisplayStatsType.SPEED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[DisplayStatsType.PACE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[DisplayStatsType.AVG_PACE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[DisplayStatsType.HEART_RATE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[DisplayStatsType.INCLINE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[DisplayStatsType.CALORIES.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[DisplayStatsType.ASCENT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[DisplayStatsType.OUTPUT.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[DisplayStatsType.METS.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[DisplayStatsType.AVG_SPEED.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[DisplayStatsType.CADENCE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[DisplayStatsType.AVG_CADENCE.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[DisplayStatsType.RESISTANCE.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[DisplayStatsType.STRIDES.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[DisplayStatsType.FLOORS.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[DisplayStatsType.STEPS.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[DisplayStatsType.CALORIES_PER_MIN.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[DisplayStatsType.STROKES.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[BleFtmsMachineType.values().length];
            try {
                iArr2[BleFtmsMachineType.TREADMILL.ordinal()] = 1;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr2[BleFtmsMachineType.BIKE.ordinal()] = 2;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr2[BleFtmsMachineType.ELLIPTICAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr2[BleFtmsMachineType.STEPPER.ordinal()] = 4;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr2[BleFtmsMachineType.ROWER.ordinal()] = 5;
            } catch (NoSuchFieldError unused26) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    public DisplayDashboardP1Fragment() {
        final DisplayDashboardP1Fragment displayDashboardP1Fragment = this;
        final Function0 function0 = null;
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(displayDashboardP1Fragment, Reflection.getOrCreateKotlinClass(DisplayModeViewModel.class), new Function0<ViewModelStore>() { // from class: com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardP1Fragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = displayDashboardP1Fragment.requireActivity().getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardP1Fragment$special$$inlined$activityViewModels$default$2
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
                CreationExtras defaultViewModelCreationExtras = displayDashboardP1Fragment.requireActivity().getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardP1Fragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = displayDashboardP1Fragment.requireActivity().getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

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

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public FragmentDisplayDashboardP1Binding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentDisplayDashboardP1Binding fragmentDisplayDashboardP1BindingInflate = FragmentDisplayDashboardP1Binding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentDisplayDashboardP1BindingInflate, "inflate(...)");
        return fragmentDisplayDashboardP1BindingInflate;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public void initViews() {
        BleManager bleManager;
        FtmsDeviceManager ftmsDeviceManager;
        MainActivity mainActivity = getMainActivity();
        BleFtmsMachineType bleFtmsMachineType = (mainActivity == null || (bleManager = mainActivity.getBleManager()) == null || (ftmsDeviceManager = bleManager.getFtmsDeviceManager()) == null) ? null : ftmsDeviceManager.getBleFtmsMachineType();
        if (bleFtmsMachineType == null) {
            bleFtmsMachineType = BleFtmsMachineType.TREADMILL;
        }
        this.machineType = bleFtmsMachineType;
        Timber.INSTANCE.d("initViews-machineType:" + this.machineType, new Object[0]);
        setDisplayModeItemRecyclerView(this.machineType);
        loadStatData(this.machineType);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new AnonymousClass1(null), 3, null);
    }

    /* compiled from: DisplayDashboardP1Fragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardP1Fragment$initViews$1", f = "DisplayDashboardP1Fragment.kt", i = {}, l = {86}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardP1Fragment$initViews$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DisplayDashboardP1Fragment.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: DisplayDashboardP1Fragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardP1Fragment$initViews$1$1", f = "DisplayDashboardP1Fragment.kt", i = {}, l = {97}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardP1Fragment$initViews$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02411 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ DisplayDashboardP1Fragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02411(DisplayDashboardP1Fragment displayDashboardP1Fragment, Continuation<? super C02411> continuation) {
                super(2, continuation);
                this.this$0 = displayDashboardP1Fragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C02411(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C02411) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Timber.INSTANCE.e("viewModel.isRunning %s", this.this$0.getViewModel().isRunning().getValue());
                    Flow flowM10619catch = FlowKt.m10619catch(FlowKt.transformLatest(this.this$0.getViewModel().isRunning(), new DisplayDashboardP1Fragment$initViews$1$1$invokeSuspend$$inlined$flatMapLatest$1(null, this.this$0)), new AnonymousClass2(null));
                    final DisplayDashboardP1Fragment displayDashboardP1Fragment = this.this$0;
                    this.label = 1;
                    if (flowM10619catch.collect(new FlowCollector() { // from class: com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardP1Fragment.initViews.1.1.3
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                            return emit((FtmsBaseData) obj2, (Continuation<? super Unit>) continuation);
                        }

                        public final Object emit(FtmsBaseData ftmsBaseData, Continuation<? super Unit> continuation) {
                            if (displayDashboardP1Fragment.getViewModel().isRunning().getValue().booleanValue()) {
                                List<DisplaySelectStatsData> value = displayDashboardP1Fragment.getViewModel().getSelectedList().getValue();
                                DisplayDashboardP1Fragment displayDashboardP1Fragment2 = displayDashboardP1Fragment;
                                Iterator<T> it = value.iterator();
                                while (it.hasNext()) {
                                    displayDashboardP1Fragment2.updateItemValue((DisplaySelectStatsData) it.next(), ftmsBaseData);
                                }
                            }
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

            /* compiled from: DisplayDashboardP1Fragment.kt */
            @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/soletreadmills/sole_v2/ble/data/FtmsBaseData;", "e", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
            @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardP1Fragment$initViews$1$1$2", f = "DisplayDashboardP1Fragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardP1Fragment$initViews$1$1$2, reason: invalid class name */
            static final class AnonymousClass2 extends SuspendLambda implements Function3<FlowCollector<? super FtmsBaseData>, Throwable, Continuation<? super Unit>, Object> {
                /* synthetic */ Object L$0;
                int label;

                AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
                    super(3, continuation);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(FlowCollector<? super FtmsBaseData> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
                    anonymousClass2.L$0 = th;
                    return anonymousClass2.invokeSuspend(Unit.INSTANCE);
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
                if (RepeatOnLifecycleKt.repeatOnLifecycle(DisplayDashboardP1Fragment.this.getViewLifecycleOwner().getLifecycle(), Lifecycle.State.STARTED, new C02411(DisplayDashboardP1Fragment.this, null), this) == coroutine_suspended) {
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

    private final void setDisplayModeItemRecyclerView(final BleFtmsMachineType machineType) {
        RecyclerView recyclerView;
        Context context = getContext();
        if (context != null) {
            FragmentDisplayDashboardP1Binding binding = getBinding();
            DisplayModeItemAdapter displayModeItemAdapter = null;
            if (((binding == null || (recyclerView = binding.rvDisplayModeItem) == null) ? null : recyclerView.getLayoutManager()) == null) {
                FragmentDisplayDashboardP1Binding binding2 = getBinding();
                RecyclerView recyclerView2 = binding2 != null ? binding2.rvDisplayModeItem : null;
                if (recyclerView2 != null) {
                    recyclerView2.setLayoutManager(new LinearLayoutManager(context, 1, false));
                }
            }
            FragmentDisplayDashboardP1Binding binding3 = getBinding();
            RecyclerView recyclerView3 = binding3 != null ? binding3.rvDisplayModeItem : null;
            if (recyclerView3 != null) {
                recyclerView3.setItemAnimator(null);
            }
            if (this.displayModeAdapter == null) {
                this.displayModeAdapter = new DisplayModeItemAdapter(context, machineType, new Function2<DisplaySelectStatsData, Integer, Unit>() { // from class: com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardP1Fragment$setDisplayModeItemRecyclerView$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(DisplaySelectStatsData displaySelectStatsData, Integer num) {
                        invoke(displaySelectStatsData, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(DisplaySelectStatsData type, int i) {
                        Intrinsics.checkNotNullParameter(type, "type");
                        if (this.this$0.isDragging) {
                            return;
                        }
                        Timber.INSTANCE.d("Clicked: " + type + " at " + i, new Object[0]);
                        this.this$0.getViewModel().updateSelection(i);
                        this.this$0.getViewModel().getStatsList();
                        MainActivity mainActivity = this.this$0.getMainActivity();
                        if (mainActivity != null) {
                            final DisplayDashboardP1Fragment displayDashboardP1Fragment = this.this$0;
                            final BleFtmsMachineType bleFtmsMachineType = machineType;
                            ChangeViewManager changeViewManager = mainActivity.getChangeViewManager();
                            if (changeViewManager != null) {
                                String string = displayDashboardP1Fragment.getString(R.string.select_parameter);
                                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                                changeViewManager.changePage(new DisplayStatsSelectCustom(mainActivity, string, displayDashboardP1Fragment.getViewModel().getStatsList().getValue(), new DisplayStatsSelectCustom.BottomDialogCustomListener() { // from class: com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardP1Fragment$setDisplayModeItemRecyclerView$1$1$1$1
                                    @Override // com.soletreadmills.sole_v2.ui.customview.DisplayStatsSelectCustom.BottomDialogCustomListener
                                    public void onClick(int pos, DisplayStatsType newType) {
                                        Intrinsics.checkNotNullParameter(newType, "newType");
                                        displayDashboardP1Fragment.getViewModel().updateSelectionWithNewType(newType);
                                        displayDashboardP1Fragment.loadStatData(bleFtmsMachineType);
                                    }
                                }));
                            }
                        }
                    }
                });
            }
            FragmentDisplayDashboardP1Binding binding4 = getBinding();
            RecyclerView recyclerView4 = binding4 != null ? binding4.rvDisplayModeItem : null;
            if (recyclerView4 == null) {
                return;
            }
            DisplayModeItemAdapter displayModeItemAdapter2 = this.displayModeAdapter;
            if (displayModeItemAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("displayModeAdapter");
            } else {
                displayModeItemAdapter = displayModeItemAdapter2;
            }
            recyclerView4.setAdapter(displayModeItemAdapter);
        }
    }

    private final void updateDisplayModeStatItem(List<DisplaySelectStatsData> displayList) {
        DisplayModeItemAdapter displayModeItemAdapter = this.displayModeAdapter;
        if (displayModeItemAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("displayModeAdapter");
            displayModeItemAdapter = null;
        }
        displayModeItemAdapter.submitList(CollectionsKt.toMutableList((Collection) displayList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadStatData(BleFtmsMachineType machineType) {
        DisplayModeViewModel.loadStatsForMachine$default(getViewModel(), machineType, false, 2, null);
        updateDisplayModeStatItem(getViewModel().getSelectedList().getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateItemValue(DisplaySelectStatsData selectStat, FtmsBaseData ftmsBaseData) {
        DisplayModeItemAdapter displayModeItemAdapter = this.displayModeAdapter;
        if (displayModeItemAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("displayModeAdapter");
            displayModeItemAdapter = null;
        }
        displayModeItemAdapter.updateItemValue(selectStat, getDisplayValue(selectStat.getType(), ftmsBaseData));
    }

    /* JADX WARN: Removed duplicated region for block: B:141:0x01a8 A[PHI: r12
      0x01a8: PHI (r12v8 java.lang.String) = 
      (r12v3 java.lang.String)
      (r12v11 java.lang.String)
      (r12v16 java.lang.String)
      (r12v20 java.lang.String)
      (r12v23 java.lang.String)
     binds: [B:323:0x0487, B:271:0x0385, B:213:0x02ae, B:139:0x01a3, B:67:0x00dc] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01ab A[PHI: r10
      0x01ab: PHI (r10v5 java.lang.String) = 
      (r10v3 java.lang.String)
      (r10v8 java.lang.String)
      (r10v13 java.lang.String)
      (r10v18 java.lang.String)
      (r10v24 java.lang.String)
     binds: [B:323:0x0487, B:271:0x0385, B:213:0x02ae, B:139:0x01a3, B:75:0x00eb] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01ae A[PHI: r9
      0x01ae: PHI (r9v2 java.lang.String) = (r9v1 java.lang.String), (r9v5 java.lang.String), (r9v14 java.lang.String), (r9v20 java.lang.String) binds: [B:323:0x0487, B:271:0x0385, B:213:0x02ae, B:139:0x01a3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01b1 A[PHI: r4
      0x01b1: PHI (r4v8 java.lang.String) = (r4v5 java.lang.String), (r4v13 java.lang.String), (r4v17 java.lang.String), (r4v20 java.lang.String) binds: [B:323:0x0487, B:271:0x0385, B:213:0x02ae, B:139:0x01a3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01b4 A[PHI: r5
      0x01b4: PHI (r5v2 java.lang.String) = (r5v1 java.lang.String), (r5v5 java.lang.String), (r5v7 java.lang.String), (r5v10 java.lang.String) binds: [B:323:0x0487, B:271:0x0385, B:213:0x02ae, B:139:0x01a3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01b7 A[PHI: r7
      0x01b7: PHI (r7v15 java.lang.String) = (r7v13 java.lang.String), (r7v24 java.lang.String), (r7v31 java.lang.String) binds: [B:271:0x0385, B:139:0x01a3, B:79:0x00f3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01ba A[PHI: r3
      0x01ba: PHI (r3v8 java.lang.String) = (r3v4 java.lang.String), (r3v10 java.lang.String), (r3v13 java.lang.String), (r3v20 java.lang.String) binds: [B:323:0x0487, B:271:0x0385, B:213:0x02ae, B:139:0x01a3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01bd A[PHI: r11
      0x01bd: PHI (r11v5 java.lang.String) = 
      (r11v3 java.lang.String)
      (r11v8 java.lang.String)
      (r11v12 java.lang.String)
      (r11v16 java.lang.String)
      (r11v20 java.lang.String)
     binds: [B:323:0x0487, B:271:0x0385, B:213:0x02ae, B:139:0x01a3, B:65:0x00d9] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01c0 A[PHI: r6
      0x01c0: PHI (r6v5 java.lang.String) = 
      (r6v3 java.lang.String)
      (r6v9 java.lang.String)
      (r6v14 java.lang.String)
      (r6v18 java.lang.String)
      (r6v22 java.lang.String)
     binds: [B:323:0x0487, B:271:0x0385, B:213:0x02ae, B:139:0x01a3, B:63:0x00d6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01c3 A[PHI: r2
      0x01c3: PHI (r2v11 java.lang.String) = (r2v10 java.lang.String), (r2v14 java.lang.String), (r2v17 java.lang.String), (r2v20 java.lang.String) binds: [B:271:0x0385, B:213:0x02ae, B:139:0x01a3, B:62:0x00d4] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01c6 A[PHI: r1
      0x01c6: PHI (r1v9 java.lang.String) = 
      (r1v4 java.lang.String)
      (r1v12 java.lang.String)
      (r1v24 java.lang.String)
      (r1v33 java.lang.String)
      (r1v35 java.lang.String)
     binds: [B:323:0x0487, B:271:0x0385, B:213:0x02ae, B:139:0x01a3, B:61:0x00d2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0105 A[PHI: r16
      0x0105: PHI (r16v1 java.lang.String) = (r16v0 java.lang.String), (r16v2 java.lang.String), (r16v5 java.lang.String), (r16v12 java.lang.String) binds: [B:323:0x0487, B:271:0x0385, B:213:0x02ae, B:71:0x00e3] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.String getDisplayValue(com.soletreadmills.sole_v2._type.DisplayStatsType r21, com.soletreadmills.sole_v2.ble.data.FtmsBaseData r22) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 1314
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardP1Fragment.getDisplayValue(com.soletreadmills.sole_v2._type.DisplayStatsType, com.soletreadmills.sole_v2.ble.data.FtmsBaseData):java.lang.String");
    }

    private final String calculateAveragePace(Integer totalTimeSec, Integer distance) {
        double dDoubleValue;
        if (totalTimeSec == null || totalTimeSec.intValue() <= 0 || distance == null || distance.intValue() <= 0) {
            return "0:00";
        }
        try {
            float fIntValue = distance.intValue() / 1000.0f;
            if (Global.INSTANCE.getUnitType()) {
                Double doubleOrNull = StringsKt.toDoubleOrNull(UnitConversion.INSTANCE.getMi(String.valueOf(fIntValue)));
                if (doubleOrNull == null) {
                    return "0:00";
                }
                dDoubleValue = doubleOrNull.doubleValue();
            } else {
                dDoubleValue = fIntValue;
            }
            int iIntValue = (int) (totalTimeSec.intValue() / dDoubleValue);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format(Locale.US, "%d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(iIntValue / 60), Integer.valueOf(iIntValue % 60)}, 2));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        } catch (Exception e) {
            Timber.INSTANCE.e(e);
            return "0:00";
        }
    }

    private final String calculateAveragePaceRower(Integer totalTimeSec, Integer distance) {
        if (totalTimeSec == null || totalTimeSec.intValue() <= 0 || distance == null || distance.intValue() <= 0) {
            return "0:00";
        }
        try {
            int iIntValue = (int) (totalTimeSec.intValue() / (distance.intValue() / 500.0f));
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format(Locale.US, "%d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(iIntValue / 60), Integer.valueOf(iIntValue % 60)}, 2));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        } catch (Exception e) {
            Timber.INSTANCE.e(e);
            return "0:00";
        }
    }

    public final double calculateMets(Double speed, Double inclinePercent, Double watt) throws NumberFormatException {
        DisplayDashboardP1Fragment displayDashboardP1Fragment;
        double d;
        double d2;
        double d3;
        String weight;
        LoginUserData loginUserData = Global.userData;
        double d4 = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (loginUserData == null || (weight = loginUserData.getWeight()) == null) {
            displayDashboardP1Fragment = this;
            d = 0.0d;
        } else {
            d = Double.parseDouble(weight);
            displayDashboardP1Fragment = this;
        }
        try {
            int i = WhenMappings.$EnumSwitchMapping$1[displayDashboardP1Fragment.machineType.ordinal()];
            if (i == 1) {
                double dDoubleValue = speed != null ? speed.doubleValue() : 0.0d;
                double d5 = 26.8d * dDoubleValue;
                double dDoubleValue2 = (inclinePercent != null ? inclinePercent.doubleValue() : 0.0d) / 100.0d;
                if (dDoubleValue >= 4.5d) {
                    d2 = (0.2d * d5) + 3.5d;
                    d3 = d5 * 0.9d;
                } else {
                    d2 = (0.1d * d5) + 3.5d;
                    d3 = d5 * 1.8d;
                }
                double d6 = d2 + (d3 * dDoubleValue2);
                if (d6 > AudioStats.AUDIO_AMPLITUDE_NONE) {
                    d4 = d6 / 3.5d;
                }
            } else if (i == 2 || i == 3) {
                double dDoubleValue3 = (watt != null ? watt.doubleValue() : 0.0d) * 6;
                if (dDoubleValue3 > AudioStats.AUDIO_AMPLITUDE_NONE && d > AudioStats.AUDIO_AMPLITUDE_NONE) {
                    d4 = (7 + ((dDoubleValue3 * 1.8d) / d)) / 3.5d;
                }
            }
        } catch (Exception e) {
            Timber.INSTANCE.e(e);
        }
        return MathKt.roundToInt(d4 * 10) / 10.0d;
    }

    private final String convertElevationGain(Float elevationGainM) {
        if (elevationGainM == null) {
            return SdkConstants.RES_QUALIFIER_SEP;
        }
        if (Global.INSTANCE.getUnitType()) {
            return ConvertUtils.INSTANCE.formatToOneDecimal02(UnitConversion.INSTANCE.getM_ToFt(elevationGainM.toString()), SdkConstants.RES_QUALIFIER_SEP);
        }
        return ConvertUtils.INSTANCE.formatToOneDecimal02(elevationGainM.toString(), SdkConstants.RES_QUALIFIER_SEP);
    }

    static /* synthetic */ String convertDistance$default(DisplayDashboardP1Fragment displayDashboardP1Fragment, Float f, BleFtmsMachineType bleFtmsMachineType, int i, Object obj) {
        if ((i & 2) != 0) {
            bleFtmsMachineType = null;
        }
        return displayDashboardP1Fragment.convertDistance(f, bleFtmsMachineType);
    }

    private final String convertDistance(Float distanceM, BleFtmsMachineType machineType) {
        if (distanceM == null) {
            return SdkConstants.RES_QUALIFIER_SEP;
        }
        if (machineType == BleFtmsMachineType.ROWER) {
            try {
                DecimalFormat decimalFormat = new DecimalFormat("#0.##", DecimalFormatSymbols.getInstance(Locale.US));
                decimalFormat.setRoundingMode(RoundingMode.FLOOR);
                String str = decimalFormat.format(distanceM);
                Intrinsics.checkNotNull(str);
                return str;
            } catch (Exception e) {
                Timber.INSTANCE.e(e);
                return SdkConstants.RES_QUALIFIER_SEP;
            }
        }
        try {
            BigDecimal bigDecimal = new BigDecimal(String.valueOf(distanceM.floatValue()));
            BigDecimal bigDecimalValueOf = BigDecimal.valueOf(1000);
            Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, "valueOf(...)");
            BigDecimal bigDecimalDivide = bigDecimal.divide(bigDecimalValueOf, 4, RoundingMode.FLOOR);
            if (Global.INSTANCE.getUnitType()) {
                bigDecimalDivide = new BigDecimal(UnitConversion.INSTANCE.getMi(bigDecimalDivide.toString()));
            }
            DecimalFormat decimalFormat2 = new DecimalFormat("#0.##", DecimalFormatSymbols.getInstance(Locale.US));
            decimalFormat2.setRoundingMode(RoundingMode.FLOOR);
            String str2 = decimalFormat2.format(bigDecimalDivide);
            Intrinsics.checkNotNull(str2);
            return str2;
        } catch (Exception e2) {
            Timber.INSTANCE.e(e2);
            return SdkConstants.RES_QUALIFIER_SEP;
        }
    }

    private final String convertTime(Integer seconds) {
        return TimeTools.INSTANCE.secToTime02(seconds != null ? seconds.intValue() : 0L, false);
    }

    private final String convertSpeed(Float speedKmh) throws NumberFormatException {
        double dFloatValue;
        if (speedKmh == null) {
            return SdkConstants.RES_QUALIFIER_SEP;
        }
        try {
            if (Global.INSTANCE.getUnitType()) {
                dFloatValue = Double.parseDouble(UnitConversion.INSTANCE.getMi(speedKmh.toString()));
            } else {
                dFloatValue = speedKmh.floatValue();
            }
            DecimalFormat decimalFormat = new DecimalFormat("#0.#", DecimalFormatSymbols.getInstance(Locale.US));
            decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
            String str = decimalFormat.format(dFloatValue);
            Intrinsics.checkNotNull(str);
            return str;
        } catch (Exception e) {
            Timber.INSTANCE.e(e);
            return SdkConstants.RES_QUALIFIER_SEP;
        }
    }

    public final String calculatePace(Double speedKmh) throws NumberFormatException {
        double dDoubleValue;
        if (speedKmh == null || speedKmh.doubleValue() <= AudioStats.AUDIO_AMPLITUDE_NONE) {
            return SdkConstants.RES_QUALIFIER_SEP;
        }
        try {
            if (Global.INSTANCE.getUnitType()) {
                dDoubleValue = Double.parseDouble(UnitConversion.INSTANCE.getMi(speedKmh.toString()));
            } else {
                dDoubleValue = speedKmh.doubleValue();
            }
            double d = 60.0d / dDoubleValue;
            int i = (int) d;
            int iRoundToInt = MathKt.roundToInt((d - i) * 60);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format(Locale.US, "%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i), Integer.valueOf(iRoundToInt)}, 2));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        } catch (Exception e) {
            Timber.INSTANCE.e(e);
            return SdkConstants.RES_QUALIFIER_SEP;
        }
    }
}
