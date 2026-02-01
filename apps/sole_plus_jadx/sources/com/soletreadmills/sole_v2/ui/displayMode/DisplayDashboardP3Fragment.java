package com.soletreadmills.sole_v2.ui.displayMode;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
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
import com.soletreadmills.sole_v2.MyApplication;
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
import com.soletreadmills.sole_v2.databinding.FragmentDisplayDashboardP3Binding;
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
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import timber.log.Timber;

/* compiled from: DisplayDashboardP3Fragment.kt */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J$\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0019H\u0002J\u0010\u0010\"\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0019H\u0002J\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010$\u001a\u00020 2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u001f\u0010%\u001a\u0004\u0018\u00010\u001c2\u0006\u0010&\u001a\u00020\u001e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002¢\u0006\u0002\u0010'J\u001a\u0010(\u001a\u00020\u00022\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010-\u001a\u00020\u0015H\u0016J\b\u0010.\u001a\u00020\u0015H\u0002J\u0012\u0010/\u001a\u00020\u00152\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u001a\u00102\u001a\u00020\u00152\u0006\u00103\u001a\u0002012\b\u00104\u001a\u0004\u0018\u000105H\u0016J\u0018\u00106\u001a\u00020\u00152\u0006\u00103\u001a\u0002072\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u00108\u001a\u00020\u0015H\u0002J\u0018\u00109\u001a\u00020\u00152\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0002J\u001e\u0010>\u001a\u00020\u00152\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001b2\u0006\u0010?\u001a\u00020\u001eH\u0002J.\u0010@\u001a\u00020\u00152\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020C2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010E\u001a\u00020\u00152\u0006\u0010F\u001a\u00020\u001c2\u0006\u0010G\u001a\u00020\u001cH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011¨\u0006H"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/displayMode/DisplayDashboardP3Fragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/databinding/FragmentDisplayDashboardP3Binding;", "Landroid/view/View$OnClickListener;", "()V", "chartHolders", "", "Lcom/soletreadmills/sole_v2/_data/displayMode/ChartHolder;", "machineType", "Lcom/soletreadmills/sole_v2/ble/type/BleFtmsMachineType;", "getMachineType", "()Lcom/soletreadmills/sole_v2/ble/type/BleFtmsMachineType;", "setMachineType", "(Lcom/soletreadmills/sole_v2/ble/type/BleFtmsMachineType;)V", "viewModel", "Lcom/soletreadmills/sole_v2/ui/displayMode/DisplayModeViewModel;", "getViewModel", "()Lcom/soletreadmills/sole_v2/ui/displayMode/DisplayModeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "createChartForType", "", "statsType", "Lcom/soletreadmills/sole_v2/_type/DisplayStatsType;", "index", "", "extractChartData", "", "", "historyDataList", "Lcom/soletreadmills/sole_v2/ble/data/FtmsBaseData;", "getHrSelectColor", "", "percent", "getHrSelectText", "getInitialDataForType", "getUnitText", "getValueFromFtmsData", "ftmsData", "(Lcom/soletreadmills/sole_v2/ble/data/FtmsBaseData;Lcom/soletreadmills/sole_v2/_type/DisplayStatsType;)Ljava/lang/Float;", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", "observeFtmsData", SdkConstants.ATTR_ON_CLICK, "v", "Landroid/view/View;", "onViewCreated", "view", "savedInstanceState", "Landroid/os/Bundle;", "setupDisplayItemView", "Lcom/soletreadmills/sole_v2/ui/widget/displayDashboard/DisplayItemView;", "setupDynamicCharts", "showEmptyState", "binding", "Lcom/soletreadmills/sole_v2/databinding/CustomDashboardChartBinding;", "isEmpty", "", "updateAllChartsIncremental", "latestData", "updateChartLabels", "data", "maxLabel", "Landroid/widget/TextView;", "minLabel", "updateHrRangeChart", "maxHr", "latestValue", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DisplayDashboardP3Fragment extends BaseFragment<FragmentDisplayDashboardP3Binding> implements View.OnClickListener {
    public static final int $stable = 8;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    private BleFtmsMachineType machineType = BleFtmsMachineType.TREADMILL;
    private final List<ChartHolder> chartHolders = new ArrayList();

    /* compiled from: DisplayDashboardP3Fragment.kt */
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

    public DisplayDashboardP3Fragment() {
        final DisplayDashboardP3Fragment displayDashboardP3Fragment = this;
        final Function0 function0 = null;
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(displayDashboardP3Fragment, Reflection.getOrCreateKotlinClass(DisplayModeViewModel.class), new Function0<ViewModelStore>() { // from class: com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardP3Fragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = displayDashboardP3Fragment.requireActivity().getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardP3Fragment$special$$inlined$activityViewModels$default$2
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
                CreationExtras defaultViewModelCreationExtras = displayDashboardP3Fragment.requireActivity().getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardP3Fragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = displayDashboardP3Fragment.requireActivity().getDefaultViewModelProviderFactory();
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
    public FragmentDisplayDashboardP3Binding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentDisplayDashboardP3Binding fragmentDisplayDashboardP3BindingInflate = FragmentDisplayDashboardP3Binding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentDisplayDashboardP3BindingInflate, "inflate(...)");
        return fragmentDisplayDashboardP3BindingInflate;
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
        setupDynamicCharts();
        observeFtmsData();
    }

    private final void updateHrRangeChart(float maxHr, float latestValue) throws NumberFormatException {
        DisplayItemView displayItemView;
        Guideline guideline;
        int i = Integer.parseInt(Global.INSTANCE.calculateAge());
        Timber.INSTANCE.d("age:" + i, new Object[0]);
        int i2 = 220 - i;
        Timber.INSTANCE.d("maxHeartRate:" + i2, new Object[0]);
        Timber.INSTANCE.d("latestValue:" + latestValue, new Object[0]);
        float fCoerceIn = RangesKt.coerceIn(latestValue / i2, 0.0f, 1.0f);
        Timber.INSTANCE.d("maxHrPercent:" + fCoerceIn, new Object[0]);
        int iRoundToInt = MathKt.roundToInt(100.0f * fCoerceIn);
        Timber.INSTANCE.d("percentInt:" + iRoundToInt, new Object[0]);
        FragmentDisplayDashboardP3Binding binding = getBinding();
        ViewGroup.LayoutParams layoutParams = (binding == null || (guideline = binding.hrSelectPosition) == null) ? null : guideline.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        layoutParams2.guidePercent = fCoerceIn;
        FragmentDisplayDashboardP3Binding binding2 = getBinding();
        Guideline guideline2 = binding2 != null ? binding2.hrSelectPosition : null;
        if (guideline2 != null) {
            guideline2.setLayoutParams(layoutParams2);
        }
        String hrSelectColor = getHrSelectColor(iRoundToInt);
        Timber.INSTANCE.d("color========" + hrSelectColor, new Object[0]);
        Drawable drawable = ContextCompat.getDrawable(MyApplication.INSTANCE.getAppContext(), R.drawable.bg_corner10_white);
        if (drawable != null) {
            drawable.setTint(Color.parseColor(hrSelectColor));
        }
        FragmentDisplayDashboardP3Binding binding3 = getBinding();
        LinearLayout linearLayout = binding3 != null ? binding3.selectAreaBg : null;
        if (linearLayout != null) {
            linearLayout.setBackground(drawable);
        }
        FragmentDisplayDashboardP3Binding binding4 = getBinding();
        TextView textView = binding4 != null ? binding4.selectAreaText : null;
        if (textView != null) {
            textView.setText(getHrSelectText(iRoundToInt));
        }
        String str = iRoundToInt + " %";
        FragmentDisplayDashboardP3Binding binding5 = getBinding();
        if (binding5 == null || (displayItemView = binding5.maxHrItemView) == null) {
            return;
        }
        displayItemView.setDisplayValue(str);
    }

    private final void setupDynamicCharts() {
        LinearLayout linearLayout;
        List listListOf = CollectionsKt.listOf(DisplayStatsType.HEART_RATE);
        FragmentDisplayDashboardP3Binding binding = getBinding();
        if (binding != null && (linearLayout = binding.chartContainer) != null) {
            linearLayout.removeAllViews();
        }
        this.chartHolders.clear();
        int i = 0;
        for (Object obj : listListOf) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            createChartForType((DisplayStatsType) obj, i);
            i = i2;
        }
    }

    private final void createChartForType(DisplayStatsType statsType, int index) {
        FragmentDisplayDashboardP3Binding binding = getBinding();
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
            TextView maxLabel = customDashboardChartBindingInflate.maxLabel;
            Intrinsics.checkNotNullExpressionValue(maxLabel, "maxLabel");
            TextView minLabel = customDashboardChartBindingInflate.minLabel;
            Intrinsics.checkNotNullExpressionValue(minLabel, "minLabel");
            updateChartLabels(initialDataForType, maxLabel, minLabel, statsType);
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

    /* compiled from: DisplayDashboardP3Fragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardP3Fragment$observeFtmsData$1", f = "DisplayDashboardP3Fragment.kt", i = {}, l = {268}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardP3Fragment$observeFtmsData$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DisplayDashboardP3Fragment.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: DisplayDashboardP3Fragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardP3Fragment$observeFtmsData$1$1", f = "DisplayDashboardP3Fragment.kt", i = {}, l = {WinError.ERROR_INVALID_EA_HANDLE}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardP3Fragment$observeFtmsData$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02431 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ DisplayDashboardP3Fragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02431(DisplayDashboardP3Fragment displayDashboardP3Fragment, Continuation<? super C02431> continuation) {
                super(2, continuation);
                this.this$0 = displayDashboardP3Fragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C02431(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C02431) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Flow flowM10619catch = FlowKt.m10619catch(FlowKt.transformLatest(this.this$0.getViewModel().isRunning(), new DisplayDashboardP3Fragment$observeFtmsData$1$1$invokeSuspend$$inlined$flatMapLatest$1(null, this.this$0)), new AnonymousClass2(null));
                    final DisplayDashboardP3Fragment displayDashboardP3Fragment = this.this$0;
                    this.label = 1;
                    if (flowM10619catch.collect(new FlowCollector() { // from class: com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardP3Fragment.observeFtmsData.1.1.3
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                            return emit((FtmsBaseData) obj2, (Continuation<? super Unit>) continuation);
                        }

                        public final Object emit(FtmsBaseData ftmsBaseData, Continuation<? super Unit> continuation) throws NumberFormatException {
                            ArrayList<FtmsBaseData> nowFtmsDataArrayList = BleDataManager.getInstance().getNowFtmsDataArrayList();
                            Intrinsics.checkNotNullExpressionValue(nowFtmsDataArrayList, "getNowFtmsDataArrayList(...)");
                            List list = CollectionsKt.toList(nowFtmsDataArrayList);
                            Timber.INSTANCE.d("History data size: " + list.size(), new Object[0]);
                            displayDashboardP3Fragment.updateAllChartsIncremental(list, ftmsBaseData);
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

            /* compiled from: DisplayDashboardP3Fragment.kt */
            @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/soletreadmills/sole_v2/ble/data/FtmsBaseData;", "e", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
            @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardP3Fragment$observeFtmsData$1$1$2", f = "DisplayDashboardP3Fragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardP3Fragment$observeFtmsData$1$1$2, reason: invalid class name */
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
                if (RepeatOnLifecycleKt.repeatOnLifecycle(DisplayDashboardP3Fragment.this.getViewLifecycleOwner().getLifecycle(), Lifecycle.State.STARTED, new C02431(DisplayDashboardP3Fragment.this, null), this) == coroutine_suspended) {
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
    public final void updateAllChartsIncremental(List<? extends FtmsBaseData> historyDataList, FtmsBaseData latestData) throws NumberFormatException {
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
                        CustomChartHelper customChartHelper = CustomChartHelper.INSTANCE;
                        LineChart lineChart = chartHolder.getBinding().lineChart;
                        Intrinsics.checkNotNullExpressionValue(lineChart, "lineChart");
                        customChartHelper.updateDataWithDownSample(lineChart, chartHolder.getConfig(), listExtractChartData, (96 & 8) != 0 ? null : null, (96 & 16) != 0 ? 300 : 300, (96 & 32) != 0 ? null : null, (96 & 64) != 0 ? null : null);
                        TextView maxLabel = chartHolder.getBinding().maxLabel;
                        Intrinsics.checkNotNullExpressionValue(maxLabel, "maxLabel");
                        TextView minLabel = chartHolder.getBinding().minLabel;
                        Intrinsics.checkNotNullExpressionValue(minLabel, "minLabel");
                        updateChartLabels(listExtractChartData, maxLabel, minLabel, chartHolder.getStatsType());
                        chartHolder.setLastDataSize(size);
                        if (valueFromFtmsData2 != null) {
                            updateHrRangeChart(CollectionsKt.maxOrThrow((Iterable<Double>) listExtractChartData), valueFromFtmsData2.floatValue());
                        } else {
                            Timber.INSTANCE.d("顯示空資料畫面", new Object[0]);
                        }
                    }
                }
            }
        }
    }

    private final void showEmptyState(CustomDashboardChartBinding binding, boolean isEmpty) {
        ConstraintLayout constraintLayout;
        if (isEmpty) {
            binding.lineChart.setVisibility(8);
            binding.lineChartEmptyText.setVisibility(0);
            FragmentDisplayDashboardP3Binding binding2 = getBinding();
            ConstraintLayout constraintLayout2 = binding2 != null ? binding2.clRainbowChart : null;
            if (constraintLayout2 != null) {
                constraintLayout2.setVisibility(8);
            }
            FragmentDisplayDashboardP3Binding binding3 = getBinding();
            constraintLayout = binding3 != null ? binding3.clRainbowChartEmpty : null;
            if (constraintLayout == null) {
                return;
            }
            constraintLayout.setVisibility(0);
            return;
        }
        binding.lineChart.setVisibility(0);
        binding.lineChartEmptyText.setVisibility(8);
        FragmentDisplayDashboardP3Binding binding4 = getBinding();
        ConstraintLayout constraintLayout3 = binding4 != null ? binding4.clRainbowChart : null;
        if (constraintLayout3 != null) {
            constraintLayout3.setVisibility(0);
        }
        FragmentDisplayDashboardP3Binding binding5 = getBinding();
        constraintLayout = binding5 != null ? binding5.clRainbowChartEmpty : null;
        if (constraintLayout == null) {
            return;
        }
        constraintLayout.setVisibility(8);
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

    /* JADX WARN: Removed duplicated region for block: B:69:0x00dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Float getValueFromFtmsData(com.soletreadmills.sole_v2.ble.data.FtmsBaseData r5, com.soletreadmills.sole_v2._type.DisplayStatsType r6) {
        /*
            Method dump skipped, instructions count: 241
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardP3Fragment.getValueFromFtmsData(com.soletreadmills.sole_v2.ble.data.FtmsBaseData, com.soletreadmills.sole_v2._type.DisplayStatsType):java.lang.Float");
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

    private final void updateChartLabels(List<Float> data, TextView maxLabel, TextView minLabel, DisplayStatsType statsType) {
        if (data.isEmpty()) {
            return;
        }
        int i = R.string.max_title;
        DisplayModeViewModel viewModel = getViewModel();
        List<Float> list = data;
        Float fMaxOrNull = CollectionsKt.maxOrNull((Iterable<? extends Float>) list);
        String string = getString(i, viewModel.formatValue(fMaxOrNull != null ? fMaxOrNull.floatValue() : 0.0f, statsType));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        int i2 = R.string.min_title;
        DisplayModeViewModel viewModel2 = getViewModel();
        Float fMinOrNull = CollectionsKt.minOrNull((Iterable<? extends Float>) list);
        String string2 = getString(i2, viewModel2.formatValue(fMinOrNull != null ? fMinOrNull.floatValue() : 0.0f, statsType));
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        maxLabel.setText(string);
        minLabel.setText(string2);
    }

    private final String getHrSelectText(int percent) {
        int iCoerceIn = RangesKt.coerceIn(percent, 0, 100);
        if (iCoerceIn >= 0 && iCoerceIn < 50) {
            String string = getString(R.string.hr_resting);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }
        if (50 <= iCoerceIn && iCoerceIn < 60) {
            String string2 = getString(R.string.hr_light);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            return string2;
        }
        if (60 <= iCoerceIn && iCoerceIn < 70) {
            String string3 = getString(R.string.hr_moderate);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            return string3;
        }
        if (70 <= iCoerceIn && iCoerceIn < 80) {
            String string4 = getString(R.string.hr_hard);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            return string4;
        }
        if (80 <= iCoerceIn && iCoerceIn < 90) {
            String string5 = getString(R.string.hr_very_hard);
            Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
            return string5;
        }
        if (90 <= iCoerceIn && iCoerceIn < 101) {
            String string6 = getString(R.string.hr_maximum);
            Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
            return string6;
        }
        String string7 = getString(R.string.hr_unknown);
        Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
        return string7;
    }

    private final String getHrSelectColor(int percent) {
        String str = (String) MapsKt.mapOf(TuplesKt.to(0, "#E2E2E2"), TuplesKt.to(5, "#E2E2E2"), TuplesKt.to(10, "#E2E2E2"), TuplesKt.to(15, "#E2E2E2"), TuplesKt.to(20, "#E2E2E2"), TuplesKt.to(25, "#E2E2E2"), TuplesKt.to(30, "#E2E2E2"), TuplesKt.to(35, "#E2E2E2"), TuplesKt.to(40, "#E1E1E4"), TuplesKt.to(45, "#D4D7E3"), TuplesKt.to(50, "#BDC4DF"), TuplesKt.to(55, "#A2ADDD"), TuplesKt.to(60, "#6F84EA"), TuplesKt.to(65, "#365DF6"), TuplesKt.to(70, "#5B968D"), TuplesKt.to(75, "#85CD30"), TuplesKt.to(80, "#B8D62C"), TuplesKt.to(85, "#E6D829"), TuplesKt.to(90, "#F38A2D"), TuplesKt.to(95, "#FA5F2F"), TuplesKt.to(100, "#FF3B30")).get(Integer.valueOf((RangesKt.coerceIn(percent, 0, 100) / 5) * 5));
        return str == null ? "#000000" : str;
    }
}
