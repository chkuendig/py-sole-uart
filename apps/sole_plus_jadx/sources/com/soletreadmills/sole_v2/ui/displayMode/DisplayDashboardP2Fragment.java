package com.soletreadmills.sole_v2.ui.displayMode;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.android.SdkConstants;
import com.github.mikephil.charting.charts.LineChart;
import com.soletreadmills.sole_v2.Global;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.displayMode.ChartHolder;
import com.soletreadmills.sole_v2._data.displayMode.ChartHolderKt;
import com.soletreadmills.sole_v2._helper.customChart.CustomChartHelper;
import com.soletreadmills.sole_v2._manager.BleManager;
import com.soletreadmills.sole_v2._type.DisplayStatsType;
import com.soletreadmills.sole_v2.ble.data.FtmsBaseData;
import com.soletreadmills.sole_v2.ble.manager.BleDataManager;
import com.soletreadmills.sole_v2.ble.manager.FtmsDeviceManager;
import com.soletreadmills.sole_v2.ble.type.BleFtmsMachineType;
import com.soletreadmills.sole_v2.databinding.CustomDashboardChartBinding;
import com.soletreadmills.sole_v2.databinding.FragmentDisplayDashboardP2Binding;
import com.soletreadmills.sole_v2.ui.MainActivity;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import com.soletreadmills.sole_v2.ui.widget.displayDashboard.DisplayItemView;
import com.sun.jna.platform.win32.WinError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
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
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import timber.log.Timber;

/* compiled from: DisplayDashboardP2Fragment.kt */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J$\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001c2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00180\u001c2\u0006\u0010!\u001a\u00020\tH\u0002J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u001f\u0010%\u001a\u0004\u0018\u00010\u001d2\u0006\u0010&\u001a\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002¢\u0006\u0002\u0010'J\u001a\u0010(\u001a\u00020\u00022\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010-\u001a\u00020\u0015H\u0016J\b\u0010.\u001a\u00020\u0015H\u0002J\u0012\u0010/\u001a\u00020\u00152\b\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u00102\u001a\u00020\u0015H\u0016J\u0018\u00103\u001a\u00020\u00152\u0006\u00104\u001a\u0002052\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u00106\u001a\u00020\u0015H\u0002J\u0018\u00107\u001a\u00020\u00152\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0002J\u001e\u0010<\u001a\u00020\u00152\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001c2\u0006\u0010=\u001a\u00020\u001fH\u0002J0\u0010>\u001a\u00020\u00152\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020@2\u0006\u0010B\u001a\u00020\u001d2\u0006\u0010C\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011¨\u0006D"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/displayMode/DisplayDashboardP2Fragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/databinding/FragmentDisplayDashboardP2Binding;", "Landroid/view/View$OnClickListener;", "()V", "chartHolders", "", "Lcom/soletreadmills/sole_v2/_data/displayMode/ChartHolder;", "machineType", "Lcom/soletreadmills/sole_v2/ble/type/BleFtmsMachineType;", "getMachineType", "()Lcom/soletreadmills/sole_v2/ble/type/BleFtmsMachineType;", "setMachineType", "(Lcom/soletreadmills/sole_v2/ble/type/BleFtmsMachineType;)V", "viewModel", "Lcom/soletreadmills/sole_v2/ui/displayMode/DisplayModeViewModel;", "getViewModel", "()Lcom/soletreadmills/sole_v2/ui/displayMode/DisplayModeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "clearAllCharts", "", "createChartForType", "statsType", "Lcom/soletreadmills/sole_v2/_type/DisplayStatsType;", "index", "", "extractChartData", "", "", "historyDataList", "Lcom/soletreadmills/sole_v2/ble/data/FtmsBaseData;", "getChartStatsForMachine", "type", "getInitialDataForType", "getUnitText", "", "getValueFromFtmsData", "ftmsData", "(Lcom/soletreadmills/sole_v2/ble/data/FtmsBaseData;Lcom/soletreadmills/sole_v2/_type/DisplayStatsType;)Ljava/lang/Float;", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", "observeFtmsData", SdkConstants.ATTR_ON_CLICK, "v", "Landroid/view/View;", "onDestroyView", "setupDisplayItemView", "view", "Lcom/soletreadmills/sole_v2/ui/widget/displayDashboard/DisplayItemView;", "setupDynamicCharts", "showEmptyState", "binding", "Lcom/soletreadmills/sole_v2/databinding/CustomDashboardChartBinding;", "isEmpty", "", "updateAllChartsIncremental", "latestData", "updateChartLabels", "maxLabel", "Landroid/widget/TextView;", "minLabel", "maxValue", "minValue", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DisplayDashboardP2Fragment extends BaseFragment<FragmentDisplayDashboardP2Binding> implements View.OnClickListener {
    public static final int $stable = 8;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    private BleFtmsMachineType machineType = BleFtmsMachineType.TREADMILL;
    private final List<ChartHolder> chartHolders = new ArrayList();

    /* compiled from: DisplayDashboardP2Fragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[DisplayStatsType.values().length];
            try {
                iArr[DisplayStatsType.SPEED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DisplayStatsType.INCLINE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DisplayStatsType.RESISTANCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DisplayStatsType.OUTPUT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[DisplayStatsType.CADENCE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[DisplayStatsType.HEART_RATE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[DisplayStatsType.DISTANCE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[BleFtmsMachineType.values().length];
            try {
                iArr2[BleFtmsMachineType.TREADMILL.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[BleFtmsMachineType.ELLIPTICAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[BleFtmsMachineType.BIKE.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[BleFtmsMachineType.ROWER.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[BleFtmsMachineType.STEPPER.ordinal()] = 5;
            } catch (NoSuchFieldError unused12) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    public DisplayDashboardP2Fragment() {
        final DisplayDashboardP2Fragment displayDashboardP2Fragment = this;
        final Function0 function0 = null;
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(displayDashboardP2Fragment, Reflection.getOrCreateKotlinClass(DisplayModeViewModel.class), new Function0<ViewModelStore>() { // from class: com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardP2Fragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = displayDashboardP2Fragment.requireActivity().getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardP2Fragment$special$$inlined$activityViewModels$default$2
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
                CreationExtras defaultViewModelCreationExtras = displayDashboardP2Fragment.requireActivity().getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardP2Fragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = displayDashboardP2Fragment.requireActivity().getDefaultViewModelProviderFactory();
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

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public FragmentDisplayDashboardP2Binding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentDisplayDashboardP2Binding fragmentDisplayDashboardP2BindingInflate = FragmentDisplayDashboardP2Binding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentDisplayDashboardP2BindingInflate, "inflate(...)");
        return fragmentDisplayDashboardP2BindingInflate;
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
        setupDynamicCharts();
        observeFtmsData();
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.chartHolders.clear();
        super.onDestroyView();
    }

    private final void setupDynamicCharts() {
        LinearLayout linearLayout;
        List<DisplayStatsType> chartStatsForMachine = getChartStatsForMachine(this.machineType);
        int i = 0;
        Timber.INSTANCE.d("Setting up charts for " + this.machineType + ": " + chartStatsForMachine, new Object[0]);
        FragmentDisplayDashboardP2Binding binding = getBinding();
        if (binding != null && (linearLayout = binding.chartContainer) != null) {
            linearLayout.removeAllViews();
        }
        this.chartHolders.clear();
        for (Object obj : chartStatsForMachine) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            createChartForType((DisplayStatsType) obj, i);
            i = i2;
        }
    }

    private final void createChartForType(DisplayStatsType statsType, int index) {
        FragmentDisplayDashboardP2Binding binding = getBinding();
        if (binding != null) {
            CustomDashboardChartBinding customDashboardChartBindingInflate = CustomDashboardChartBinding.inflate(getLayoutInflater(), binding.chartContainer, false);
            Intrinsics.checkNotNullExpressionValue(customDashboardChartBindingInflate, "inflate(...)");
            DisplayItemView displayItemView = customDashboardChartBindingInflate.displayItemView;
            Intrinsics.checkNotNullExpressionValue(displayItemView, "displayItemView");
            setupDisplayItemView(displayItemView, statsType);
            Pair<Integer, Integer> chartColors = ChartHolderKt.getChartColors(statsType);
            CustomChartHelper.Config configCreateConfig = CustomChartHelper.INSTANCE.createConfig(ContextCompat.getColor(requireContext(), chartColors.component1().intValue()), ContextCompat.getColor(requireContext(), chartColors.component2().intValue()), (28 & 4) != 0 ? 0.01f : 0.0f, (28 & 8) != 0 ? 0.01f : 0.0f, (28 & 16) != 0 ? 0.0f : 0.0f, (28 & 32) != 0 ? false : false, (28 & 64) != 0 ? false : true, (28 & 128) != 0 ? 2.5f : 5.5f);
            List<Float> initialDataForType = getInitialDataForType(statsType);
            CustomChartHelper customChartHelper = CustomChartHelper.INSTANCE;
            LineChart lineChart = customDashboardChartBindingInflate.lineChart;
            Intrinsics.checkNotNullExpressionValue(lineChart, "lineChart");
            customChartHelper.setupChart(lineChart, initialDataForType, null, configCreateConfig);
            CustomChartHelper.INSTANCE.setDragEnabled(configCreateConfig, false);
            showEmptyState(customDashboardChartBindingInflate, true);
            List<Float> list = initialDataForType;
            Float fMinOrNull = CollectionsKt.minOrNull((Iterable<? extends Float>) CollectionsKt.filterNotNull(list));
            float fFloatValue = fMinOrNull != null ? fMinOrNull.floatValue() : 0.0f;
            Float fMaxOrNull = CollectionsKt.maxOrNull((Iterable<? extends Float>) CollectionsKt.filterNotNull(list));
            float fFloatValue2 = fMaxOrNull != null ? fMaxOrNull.floatValue() : 0.0f;
            TextView maxLabel = customDashboardChartBindingInflate.maxLabel;
            Intrinsics.checkNotNullExpressionValue(maxLabel, "maxLabel");
            TextView minLabel = customDashboardChartBindingInflate.minLabel;
            Intrinsics.checkNotNullExpressionValue(minLabel, "minLabel");
            updateChartLabels(maxLabel, minLabel, fFloatValue2, fFloatValue, statsType);
            this.chartHolders.add(new ChartHolder(customDashboardChartBindingInflate, configCreateConfig, statsType, 0, 8, null));
            binding.chartContainer.addView(customDashboardChartBindingInflate.getRoot());
        }
    }

    private final void setupDisplayItemView(DisplayItemView view, DisplayStatsType statsType) {
        String unitText = getUnitText(statsType);
        switch (WhenMappings.$EnumSwitchMapping$0[statsType.ordinal()]) {
            case 1:
                view.setDisplayUnit(unitText);
                view.setDisplayValue("--");
                view.setSrcColor(R.color.colorStats_speed);
                view.setSrcCompat(R.drawable.ic_stats_speed);
                break;
            case 2:
                view.setDisplayUnit(unitText);
                view.setDisplayValue("--");
                view.setSrcColor(R.color.colorStats_incline);
                view.setSrcCompat(R.drawable.ic_stats_incline);
                break;
            case 3:
                view.setDisplayUnit(unitText);
                view.setDisplayValue("--");
                view.setSrcColor(R.color.colorStats_resistance);
                view.setSrcCompat(R.drawable.ic_level_expert02);
                break;
            case 4:
                view.setDisplayUnit(unitText);
                view.setDisplayValue("--");
                view.setSrcColor(R.color.colorStats_output);
                view.setSrcCompat(R.drawable.ic_stats_power);
                break;
            case 5:
                view.setDisplayUnit(unitText);
                view.setDisplayValue("--");
                view.setSrcColor(R.color.colorStats_cadence);
                view.setSrcCompat(R.drawable.ic_stats_cadence_rpm);
                break;
            case 6:
                view.setDisplayUnit(unitText);
                view.setDisplayValue("--");
                view.setSrcColor(R.color.colorStats_hr);
                view.setSrcCompat(R.drawable.ic_stats_hr);
                break;
        }
    }

    /* compiled from: DisplayDashboardP2Fragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardP2Fragment$observeFtmsData$1", f = "DisplayDashboardP2Fragment.kt", i = {}, l = {WinError.ERROR_PIPE_LOCAL}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardP2Fragment$observeFtmsData$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DisplayDashboardP2Fragment.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: DisplayDashboardP2Fragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardP2Fragment$observeFtmsData$1$1", f = "DisplayDashboardP2Fragment.kt", i = {}, l = {239}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardP2Fragment$observeFtmsData$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02421 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ DisplayDashboardP2Fragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02421(DisplayDashboardP2Fragment displayDashboardP2Fragment, Continuation<? super C02421> continuation) {
                super(2, continuation);
                this.this$0 = displayDashboardP2Fragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C02421(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C02421) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Flow flowM10619catch = FlowKt.m10619catch(FlowKt.transformLatest(this.this$0.getViewModel().isRunning(), new DisplayDashboardP2Fragment$observeFtmsData$1$1$invokeSuspend$$inlined$flatMapLatest$1(null, this.this$0)), new AnonymousClass2(null));
                    final DisplayDashboardP2Fragment displayDashboardP2Fragment = this.this$0;
                    this.label = 1;
                    if (flowM10619catch.collect(new FlowCollector() { // from class: com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardP2Fragment.observeFtmsData.1.1.3
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                            return emit((FtmsBaseData) obj2, (Continuation<? super Unit>) continuation);
                        }

                        public final Object emit(FtmsBaseData ftmsBaseData, Continuation<? super Unit> continuation) {
                            ArrayList<FtmsBaseData> nowFtmsDataArrayList = BleDataManager.getInstance().getNowFtmsDataArrayList();
                            Intrinsics.checkNotNullExpressionValue(nowFtmsDataArrayList, "getNowFtmsDataArrayList(...)");
                            List list = CollectionsKt.toList(nowFtmsDataArrayList);
                            Timber.INSTANCE.d("History data size: " + list.size(), new Object[0]);
                            displayDashboardP2Fragment.updateAllChartsIncremental(list, ftmsBaseData);
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

            /* compiled from: DisplayDashboardP2Fragment.kt */
            @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/soletreadmills/sole_v2/ble/data/FtmsBaseData;", "e", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
            @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardP2Fragment$observeFtmsData$1$1$2", f = "DisplayDashboardP2Fragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardP2Fragment$observeFtmsData$1$1$2, reason: invalid class name */
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
                if (RepeatOnLifecycleKt.repeatOnLifecycle(DisplayDashboardP2Fragment.this.getViewLifecycleOwner().getLifecycle(), Lifecycle.State.STARTED, new C02421(DisplayDashboardP2Fragment.this, null), this) == coroutine_suspended) {
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

    private final void observeFtmsData() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateAllChartsIncremental(List<? extends FtmsBaseData> historyDataList, FtmsBaseData latestData) {
        if (historyDataList.isEmpty()) {
            Timber.INSTANCE.w("History data list is empty", new Object[0]);
            return;
        }
        int size = historyDataList.size();
        for (ChartHolder chartHolder : this.chartHolders) {
            if (size <= chartHolder.getLastDataSize()) {
                Timber.INSTANCE.d("No new data for " + chartHolder.getStatsType(), new Object[0]);
            } else {
                List<? extends FtmsBaseData> listSubList = historyDataList.subList(chartHolder.getLastDataSize(), size);
                Timber.INSTANCE.d("Processing " + listSubList.size() + " new data points for " + chartHolder.getStatsType(), new Object[0]);
                ArrayList arrayList = new ArrayList();
                Iterator<T> it = listSubList.iterator();
                while (it.hasNext()) {
                    Float valueFromFtmsData = getValueFromFtmsData((FtmsBaseData) it.next(), chartHolder.getStatsType());
                    if (valueFromFtmsData != null) {
                        arrayList.add(valueFromFtmsData);
                    }
                }
                if (arrayList.isEmpty()) {
                    Timber.INSTANCE.w("No new values extracted for " + chartHolder.getStatsType(), new Object[0]);
                    chartHolder.setLastDataSize(size);
                } else {
                    Float valueFromFtmsData2 = getValueFromFtmsData(latestData, chartHolder.getStatsType());
                    if (valueFromFtmsData2 != null) {
                        chartHolder.getBinding().displayItemView.setDisplayValue(getViewModel().formatValue(valueFromFtmsData2.floatValue(), chartHolder.getStatsType()));
                    }
                    List<Float> listExtractChartData = extractChartData(historyDataList, chartHolder.getStatsType());
                    if (listExtractChartData.isEmpty()) {
                        showEmptyState(chartHolder.getBinding(), true);
                    } else {
                        showEmptyState(chartHolder.getBinding(), false);
                        List<Float> list = listExtractChartData;
                        Float fMinOrNull = CollectionsKt.minOrNull((Iterable<? extends Float>) CollectionsKt.filterNotNull(list));
                        float fFloatValue = fMinOrNull != null ? fMinOrNull.floatValue() : 0.0f;
                        Float fMaxOrNull = CollectionsKt.maxOrNull((Iterable<? extends Float>) CollectionsKt.filterNotNull(list));
                        float fFloatValue2 = fMaxOrNull != null ? fMaxOrNull.floatValue() : 0.0f;
                        CustomChartHelper customChartHelper = CustomChartHelper.INSTANCE;
                        LineChart lineChart = chartHolder.getBinding().lineChart;
                        Intrinsics.checkNotNullExpressionValue(lineChart, "lineChart");
                        customChartHelper.updateDataWithDownSample(lineChart, chartHolder.getConfig(), listExtractChartData, null, 300, Float.valueOf(fFloatValue), Float.valueOf(fFloatValue2));
                        TextView maxLabel = chartHolder.getBinding().maxLabel;
                        Intrinsics.checkNotNullExpressionValue(maxLabel, "maxLabel");
                        TextView minLabel = chartHolder.getBinding().minLabel;
                        Intrinsics.checkNotNullExpressionValue(minLabel, "minLabel");
                        updateChartLabels(maxLabel, minLabel, fFloatValue2, fFloatValue, chartHolder.getStatsType());
                    }
                    chartHolder.setLastDataSize(size);
                }
            }
        }
    }

    private final void showEmptyState(CustomDashboardChartBinding binding, boolean isEmpty) {
        if (isEmpty) {
            binding.lineChart.setVisibility(8);
            binding.lineChartEmptyText.setVisibility(0);
        } else {
            binding.lineChart.setVisibility(0);
            binding.lineChartEmptyText.setVisibility(8);
        }
    }

    private final List<Float> extractChartData(List<? extends FtmsBaseData> historyDataList, DisplayStatsType statsType) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = historyDataList.iterator();
        while (it.hasNext()) {
            Float valueFromFtmsData = getValueFromFtmsData((FtmsBaseData) it.next(), statsType);
            if (valueFromFtmsData != null) {
                arrayList.add(valueFromFtmsData);
            }
        }
        return arrayList;
    }

    private final void clearAllCharts() {
        for (ChartHolder chartHolder : this.chartHolders) {
            chartHolder.setLastDataSize(0);
            CustomChartHelper customChartHelper = CustomChartHelper.INSTANCE;
            LineChart lineChart = chartHolder.getBinding().lineChart;
            Intrinsics.checkNotNullExpressionValue(lineChart, "lineChart");
            customChartHelper.setupChart(lineChart, CollectionsKt.emptyList(), null, chartHolder.getConfig());
            chartHolder.getBinding().displayItemView.setDisplayValue("0");
            chartHolder.getBinding().maxLabel.setText("Max 0.0");
            chartHolder.getBinding().minLabel.setText("Min 0.0");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Float getValueFromFtmsData(com.soletreadmills.sole_v2.ble.data.FtmsBaseData r6, com.soletreadmills.sole_v2._type.DisplayStatsType r7) {
        /*
            Method dump skipped, instructions count: 337
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardP2Fragment.getValueFromFtmsData(com.soletreadmills.sole_v2.ble.data.FtmsBaseData, com.soletreadmills.sole_v2._type.DisplayStatsType):java.lang.Float");
    }

    private final String getUnitText(DisplayStatsType statsType) {
        switch (WhenMappings.$EnumSwitchMapping$0[statsType.ordinal()]) {
            case 1:
                String string = getString(Global.INSTANCE.getUnitType() ? R.string.mph : R.string.km_h);
                Intrinsics.checkNotNull(string);
                return string;
            case 2:
                return "%";
            case 3:
                String string2 = getString(R.string.level);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                return string2;
            case 4:
                String string3 = getString(R.string.watts);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                return string3;
            case 5:
                String string4 = getString(R.string.spm);
                Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                return string4;
            case 6:
                String string5 = getString(R.string.bpm);
                Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                return string5;
            case 7:
                String string6 = getString(Global.INSTANCE.getUnitType() ? R.string.mi : R.string.km);
                Intrinsics.checkNotNull(string6);
                return string6;
            default:
                return "";
        }
    }

    private final List<Float> getInitialDataForType(DisplayStatsType statsType) {
        return CollectionsKt.emptyList();
    }

    private final void updateChartLabels(TextView maxLabel, TextView minLabel, float maxValue, float minValue, DisplayStatsType statsType) {
        maxLabel.setText("Max " + getViewModel().formatValue(maxValue, statsType));
        minLabel.setText("Min " + getViewModel().formatValue(minValue, statsType));
    }

    private final List<DisplayStatsType> getChartStatsForMachine(BleFtmsMachineType type) {
        int i = WhenMappings.$EnumSwitchMapping$1[type.ordinal()];
        if (i == 1) {
            return CollectionsKt.listOf((Object[]) new DisplayStatsType[]{DisplayStatsType.SPEED, DisplayStatsType.INCLINE});
        }
        if (i == 2) {
            return CollectionsKt.listOf((Object[]) new DisplayStatsType[]{DisplayStatsType.RESISTANCE, DisplayStatsType.OUTPUT});
        }
        if (i == 3) {
            return CollectionsKt.listOf((Object[]) new DisplayStatsType[]{DisplayStatsType.RESISTANCE, DisplayStatsType.OUTPUT});
        }
        if (i == 4) {
            return CollectionsKt.listOf((Object[]) new DisplayStatsType[]{DisplayStatsType.RESISTANCE, DisplayStatsType.OUTPUT});
        }
        if (i == 5) {
            return CollectionsKt.listOf((Object[]) new DisplayStatsType[]{DisplayStatsType.RESISTANCE, DisplayStatsType.CADENCE});
        }
        return CollectionsKt.emptyList();
    }
}
