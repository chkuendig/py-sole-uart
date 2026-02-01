package com.soletreadmills.sole_v2.ui.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.android.SdkConstants;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.soletreadmills.sole_v2.Global;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.DWMTrendStats;
import com.soletreadmills.sole_v2._data.TrendItemWithDWM;
import com.soletreadmills.sole_v2._data.UserWorkout12WeeklyStatsVoData;
import com.soletreadmills.sole_v2._tools.TimeTools;
import com.soletreadmills.sole_v2._type.TrendsType;
import com.soletreadmills.sole_v2.databinding.FragmentTrendChartBinding;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: TrendChartFragment.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020 J\u0010\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020\fH\u0002J\u001a\u0010$\u001a\u00020\u00022\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010)\u001a\u00020\u001eH\u0016J\u0010\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020,H\u0016J\u0016\u0010-\u001a\u00020\u001e2\f\u0010.\u001a\b\u0012\u0004\u0012\u0002000/H\u0002J\"\u00101\u001a\u00020\u001e2\b\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u00020\f2\u0006\u00105\u001a\u00020\fH\u0003R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u00066"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/activity/TrendChartFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/databinding/FragmentTrendChartBinding;", "Landroid/view/View$OnClickListener;", "()V", "activityViewModel", "Lcom/soletreadmills/sole_v2/ui/activity/ActivityViewModel;", "getActivityViewModel", "()Lcom/soletreadmills/sole_v2/ui/activity/ActivityViewModel;", "activityViewModel$delegate", "Lkotlin/Lazy;", "selectCycle", "", "getSelectCycle", "()I", "setSelectCycle", "(I)V", "trendData", "Lcom/soletreadmills/sole_v2/_data/UserWorkout12WeeklyStatsVoData;", "getTrendData", "()Lcom/soletreadmills/sole_v2/_data/UserWorkout12WeeklyStatsVoData;", "setTrendData", "(Lcom/soletreadmills/sole_v2/_data/UserWorkout12WeeklyStatsVoData;)V", "trendsType", "Lcom/soletreadmills/sole_v2/_type/TrendsType;", "getTrendsType", "()Lcom/soletreadmills/sole_v2/_type/TrendsType;", "setTrendsType", "(Lcom/soletreadmills/sole_v2/_type/TrendsType;)V", "changeSelectCycleView", "", "extractMonthWithLocalDate", "", "dateString", "getMonthAbbreviation", "month", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", SdkConstants.ATTR_ON_CLICK, "v", "Landroid/view/View;", "setBarChart", "pointList", "", "Lcom/soletreadmills/sole_v2/_data/DWMTrendStats$KeyValuePair;", "updateStatsBinding", "stats", "Lcom/soletreadmills/sole_v2/_data/DWMTrendStats;", "maxTitleRes", "avgTitleRes", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TrendChartFragment extends BaseFragment<FragmentTrendChartBinding> implements View.OnClickListener {
    public static final int $stable = 8;

    /* renamed from: activityViewModel$delegate, reason: from kotlin metadata */
    private final Lazy activityViewModel;
    private int selectCycle;
    private UserWorkout12WeeklyStatsVoData trendData;
    private TrendsType trendsType = TrendsType.TIME;

    public TrendChartFragment() {
        final TrendChartFragment trendChartFragment = this;
        final Function0 function0 = null;
        this.activityViewModel = FragmentViewModelLazyKt.createViewModelLazy(trendChartFragment, Reflection.getOrCreateKotlinClass(ActivityViewModel.class), new Function0<ViewModelStore>() { // from class: com.soletreadmills.sole_v2.ui.activity.TrendChartFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = trendChartFragment.requireActivity().getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: com.soletreadmills.sole_v2.ui.activity.TrendChartFragment$special$$inlined$activityViewModels$default$2
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
                CreationExtras defaultViewModelCreationExtras = trendChartFragment.requireActivity().getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.soletreadmills.sole_v2.ui.activity.TrendChartFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = trendChartFragment.requireActivity().getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    public final ActivityViewModel getActivityViewModel() {
        return (ActivityViewModel) this.activityViewModel.getValue();
    }

    public final int getSelectCycle() {
        return this.selectCycle;
    }

    public final void setSelectCycle(int i) {
        this.selectCycle = i;
    }

    public final TrendsType getTrendsType() {
        return this.trendsType;
    }

    public final void setTrendsType(TrendsType trendsType) {
        Intrinsics.checkNotNullParameter(trendsType, "<set-?>");
        this.trendsType = trendsType;
    }

    public final UserWorkout12WeeklyStatsVoData getTrendData() {
        return this.trendData;
    }

    public final void setTrendData(UserWorkout12WeeklyStatsVoData userWorkout12WeeklyStatsVoData) {
        this.trendData = userWorkout12WeeklyStatsVoData;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public FragmentTrendChartBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentTrendChartBinding fragmentTrendChartBindingInflate = FragmentTrendChartBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentTrendChartBindingInflate, "inflate(...)");
        return fragmentTrendChartBindingInflate;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public void initViews() {
        DWMTrendStats dailyStats;
        List<DWMTrendStats.KeyValuePair> dataKeyValueList;
        TextView textView;
        TextView textView2;
        TextView textView3;
        ImageView imageView;
        this.trendData = getActivityViewModel().getTrendData();
        TrendsType trendsType = getActivityViewModel().getTrendsType();
        if (trendsType == null) {
            trendsType = TrendsType.TIME;
        }
        this.trendsType = trendsType;
        FragmentTrendChartBinding binding = getBinding();
        if (binding != null && (imageView = binding.back) != null) {
            imageView.setOnClickListener(this);
        }
        FragmentTrendChartBinding binding2 = getBinding();
        if (binding2 != null && (textView3 = binding2.m3) != null) {
            textView3.setOnClickListener(this);
        }
        FragmentTrendChartBinding binding3 = getBinding();
        if (binding3 != null && (textView2 = binding3.m6) != null) {
            textView2.setOnClickListener(this);
        }
        FragmentTrendChartBinding binding4 = getBinding();
        if (binding4 != null && (textView = binding4.year) != null) {
            textView.setOnClickListener(this);
        }
        FragmentTrendChartBinding binding5 = getBinding();
        TextView textView4 = binding5 != null ? binding5.tvTitle : null;
        if (textView4 != null) {
            textView4.setText(getString(this.trendsType.getTitleResId()));
        }
        this.selectCycle = 0;
        changeSelectCycleView();
        UserWorkout12WeeklyStatsVoData userWorkout12WeeklyStatsVoData = this.trendData;
        if (userWorkout12WeeklyStatsVoData == null) {
            return;
        }
        TrendItemWithDWM<Double> threeMonthsDetailData = this.trendsType.getThreeMonthsDetailData(userWorkout12WeeklyStatsVoData);
        if (threeMonthsDetailData != null && (dailyStats = threeMonthsDetailData.getDailyStats()) != null && (dataKeyValueList = dailyStats.getDataKeyValueList()) != null) {
            setBarChart(dataKeyValueList);
        }
        updateStatsBinding(threeMonthsDetailData != null ? threeMonthsDetailData.getDailyStats() : null, R.string.max_daily, R.string.avg_daily);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        DWMTrendStats monthlyStats;
        List<DWMTrendStats.KeyValuePair> dataKeyValueList;
        DWMTrendStats weeklyStats;
        List<DWMTrendStats.KeyValuePair> dataKeyValueList2;
        DWMTrendStats dailyStats;
        List<DWMTrendStats.KeyValuePair> dataKeyValueList3;
        Intrinsics.checkNotNullParameter(v, "v");
        int id2 = v.getId();
        if (id2 == R.id.back) {
            safeNavigateUp();
            return;
        }
        if (id2 == R.id.m3) {
            this.selectCycle = 0;
            changeSelectCycleView();
            UserWorkout12WeeklyStatsVoData userWorkout12WeeklyStatsVoData = this.trendData;
            if (userWorkout12WeeklyStatsVoData == null) {
                return;
            }
            TrendItemWithDWM<Double> threeMonthsDetailData = this.trendsType.getThreeMonthsDetailData(userWorkout12WeeklyStatsVoData);
            if (threeMonthsDetailData != null && (dailyStats = threeMonthsDetailData.getDailyStats()) != null && (dataKeyValueList3 = dailyStats.getDataKeyValueList()) != null) {
                setBarChart(dataKeyValueList3);
            }
            updateStatsBinding(threeMonthsDetailData != null ? threeMonthsDetailData.getDailyStats() : null, R.string.max_daily, R.string.avg_daily);
            return;
        }
        if (id2 == R.id.m6) {
            this.selectCycle = 1;
            changeSelectCycleView();
            UserWorkout12WeeklyStatsVoData userWorkout12WeeklyStatsVoData2 = this.trendData;
            if (userWorkout12WeeklyStatsVoData2 == null) {
                return;
            }
            TrendItemWithDWM<Double> threeMonthsDetailData2 = this.trendsType.getThreeMonthsDetailData(userWorkout12WeeklyStatsVoData2);
            if (threeMonthsDetailData2 != null && (weeklyStats = threeMonthsDetailData2.getWeeklyStats()) != null && (dataKeyValueList2 = weeklyStats.getDataKeyValueList()) != null) {
                setBarChart(dataKeyValueList2);
            }
            updateStatsBinding(threeMonthsDetailData2 != null ? threeMonthsDetailData2.getWeeklyStats() : null, R.string.max_weekly, R.string.avg_weekly);
            return;
        }
        if (id2 == R.id.year) {
            this.selectCycle = 2;
            changeSelectCycleView();
            UserWorkout12WeeklyStatsVoData userWorkout12WeeklyStatsVoData3 = this.trendData;
            if (userWorkout12WeeklyStatsVoData3 == null) {
                return;
            }
            TrendItemWithDWM<Double> threeMonthsDetailData3 = this.trendsType.getThreeMonthsDetailData(userWorkout12WeeklyStatsVoData3);
            if (threeMonthsDetailData3 != null && (monthlyStats = threeMonthsDetailData3.getMonthlyStats()) != null && (dataKeyValueList = monthlyStats.getDataKeyValueList()) != null) {
                setBarChart(dataKeyValueList);
            }
            updateStatsBinding(threeMonthsDetailData3 != null ? threeMonthsDetailData3.getMonthlyStats() : null, R.string.max_monthly, R.string.avg_monthly);
        }
    }

    private final void updateStatsBinding(DWMTrendStats stats, int maxTitleRes, int avgTitleRes) {
        List<DWMTrendStats.KeyValuePair> dataKeyValueList;
        String str;
        TextView textView;
        String string;
        String str2;
        Context context = getContext();
        String unit = context != null ? this.trendsType.getUnit(context) : null;
        Context context2 = getContext();
        if (context2 != null) {
            int i = this.selectCycle;
            if (i == 0) {
                string = getString(R.string.daily);
            } else if (i == 1) {
                string = getString(R.string.weekly);
            } else {
                string = i != 2 ? "" : getString(R.string.monthly);
            }
            Intrinsics.checkNotNull(string);
            FragmentTrendChartBinding binding = getBinding();
            TextView textView2 = binding != null ? binding.subTitle : null;
            if (textView2 != null) {
                if (this.trendsType.getUnit(context2).length() == 0) {
                    str2 = string + ' ' + getString(this.trendsType.getTitleResId());
                } else {
                    str2 = string + ' ' + getString(this.trendsType.getTitleResId()) + ", " + this.trendsType.getUnit(context2);
                }
                textView2.setText(str2);
            }
            FragmentTrendChartBinding binding2 = getBinding();
            if (binding2 != null) {
                binding2.maxValue.setText(this.trendsType.formatValue(stats != null ? stats.getMaxValue() : null));
                binding2.avgValue.setText(this.trendsType.formatValue(stats != null ? stats.getAvgValue() : null));
                String str3 = unit;
                binding2.maxUnit.setText(str3);
                binding2.avgUnit.setText(str3);
                binding2.tvMaxTitle.setText(getString(maxTitleRes));
                binding2.tvAvgTitle.setText(getString(avgTitleRes));
                binding2.tvMaxTitle.setTextColor(ContextCompat.getColor(context2, this.trendsType.getColorResId()));
                binding2.maxValue.setTextColor(ContextCompat.getColor(context2, this.trendsType.getColorResId()));
                binding2.maxUnit.setTextColor(ContextCompat.getColor(context2, this.trendsType.getColorResId()));
            }
        }
        FragmentTrendChartBinding binding3 = getBinding();
        TextView textView3 = binding3 != null ? binding3.dateTitle : null;
        if (textView3 != null) {
            textView3.setText(SdkConstants.RES_QUALIFIER_SEP);
        }
        if (stats == null || (dataKeyValueList = stats.getDataKeyValueList()) == null) {
            return;
        }
        int i2 = this.selectCycle;
        if (i2 == 0 || i2 == 1) {
            TimeTools timeTools = TimeTools.INSTANCE;
            String key = dataKeyValueList.get(0).getKey();
            if (key == null) {
                key = "";
            }
            String toTime04 = timeTools.formatToTime04(key);
            if (toTime04 == null) {
                toTime04 = "";
            }
            TimeTools timeTools2 = TimeTools.INSTANCE;
            String key2 = dataKeyValueList.get(dataKeyValueList.size() - 1).getKey();
            if (key2 == null) {
                key2 = "";
            }
            String toTime042 = timeTools2.formatToTime04(key2);
            str = toTime042 != null ? toTime042 : "";
            FragmentTrendChartBinding binding4 = getBinding();
            textView = binding4 != null ? binding4.dateTitle : null;
            if (textView == null) {
                return;
            }
            textView.setText(toTime04 + " — " + str);
            return;
        }
        if (i2 != 2) {
            return;
        }
        TimeTools timeTools3 = TimeTools.INSTANCE;
        String key3 = dataKeyValueList.get(0).getKey();
        if (key3 == null) {
            key3 = "";
        }
        String toTime05 = timeTools3.formatToTime05(key3);
        if (toTime05 == null) {
            toTime05 = "";
        }
        TimeTools timeTools4 = TimeTools.INSTANCE;
        String key4 = dataKeyValueList.get(dataKeyValueList.size() - 1).getKey();
        if (key4 == null) {
            key4 = "";
        }
        String toTime052 = timeTools4.formatToTime05(key4);
        str = toTime052 != null ? toTime052 : "";
        FragmentTrendChartBinding binding5 = getBinding();
        textView = binding5 != null ? binding5.dateTitle : null;
        if (textView == null) {
            return;
        }
        textView.setText(toTime05 + " — " + str);
    }

    private final void setBarChart(final List<DWMTrendStats.KeyValuePair> pointList) {
        YAxis axisRight;
        XAxis xAxis;
        Context context = getContext();
        if (context != null) {
            Global.INSTANCE.getUnitType();
            FragmentTrendChartBinding binding = getBinding();
            BarChart barChart = binding != null ? binding.barChart : null;
            if (barChart != null) {
                barChart.clear();
            }
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = pointList.iterator();
            int i = 0;
            while (true) {
                float fFloatValue = 0.0f;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Number value = ((DWMTrendStats.KeyValuePair) next).getValue();
                if (value != null) {
                    fFloatValue = value.floatValue();
                }
                arrayList.add(new BarEntry(i, fFloatValue));
                i = i2;
            }
            BarDataSet barDataSet = new BarDataSet(arrayList, "Data Set");
            barDataSet.setColor(ContextCompat.getColor(context, this.trendsType.getColorResId()));
            barDataSet.setValueTextColor(-16777216);
            barDataSet.setValueTextSize(12.0f);
            barDataSet.setDrawValues(false);
            BarData barData = new BarData(barDataSet);
            if (barChart != null) {
                barChart.setData(barData);
            }
            if (barChart != null && (xAxis = barChart.getXAxis()) != null) {
                Intrinsics.checkNotNull(xAxis);
                xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
                xAxis.setTextColor(-16777216);
                xAxis.setDrawGridLines(false);
                xAxis.setGranularity(1.0f);
                xAxis.setLabelCount(pointList.size(), false);
                xAxis.setDrawGridLines(true);
                xAxis.setValueFormatter(new ValueFormatter() { // from class: com.soletreadmills.sole_v2.ui.activity.TrendChartFragment$setBarChart$1$2$1
                    private int lastMonth = -1;

                    @Override // com.github.mikephil.charting.formatter.ValueFormatter
                    public String getFormattedValue(float value2) {
                        String key;
                        int iIntValue;
                        int i3 = (int) value2;
                        if (i3 < 0 || i3 >= pointList.size() || (key = pointList.get(i3).getKey()) == null) {
                            return "";
                        }
                        String strExtractMonthWithLocalDate = this.extractMonthWithLocalDate(key);
                        Integer numValueOf = strExtractMonthWithLocalDate != null ? Integer.valueOf(Integer.parseInt(strExtractMonthWithLocalDate)) : null;
                        if (numValueOf == null || (iIntValue = numValueOf.intValue()) == this.lastMonth) {
                            return "";
                        }
                        this.lastMonth = iIntValue;
                        return this.getMonthAbbreviation(iIntValue);
                    }
                });
            }
            YAxis axisLeft = barChart != null ? barChart.getAxisLeft() : null;
            if (axisLeft != null) {
                axisLeft.setAxisMinimum(0.0f);
            }
            YAxis axisLeft2 = barChart != null ? barChart.getAxisLeft() : null;
            if (axisLeft2 != null) {
                axisLeft2.setEnabled(false);
            }
            if (barChart != null && (axisRight = barChart.getAxisRight()) != null) {
                Intrinsics.checkNotNull(axisRight);
                axisRight.setTextColor(-16777216);
                axisRight.setAxisMinimum(0.0f);
                axisRight.setValueFormatter(new ValueFormatter() { // from class: com.soletreadmills.sole_v2.ui.activity.TrendChartFragment$setBarChart$1$3$1
                    @Override // com.github.mikephil.charting.formatter.ValueFormatter
                    public String getFormattedValue(float value2) {
                        return this.this$0.getTrendsType().formatValue(Double.valueOf(value2));
                    }
                });
            }
            if (barChart != null) {
                barChart.getDescription().setEnabled(false);
                barChart.getLegend().setEnabled(false);
                barChart.setFitBars(true);
                barChart.setScaleEnabled(false);
            }
            if (barChart != null) {
                barChart.invalidate();
            }
        }
    }

    public final String extractMonthWithLocalDate(String dateString) {
        Intrinsics.checkNotNullParameter(dateString, "dateString");
        try {
            return String.valueOf(LocalDate.parse(dateString).getMonthValue());
        } catch (DateTimeParseException unused) {
            System.out.println((Object) ("日期格式錯誤: " + dateString));
            return null;
        }
    }

    private final void changeSelectCycleView() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        TextView textView7;
        TextView textView8;
        TextView textView9;
        Context context = getContext();
        if (context != null) {
            int i = this.selectCycle;
            if (i == 0) {
                FragmentTrendChartBinding binding = getBinding();
                TextView textView10 = binding != null ? binding.m3 : null;
                if (textView10 != null) {
                    textView10.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_corner32_white));
                }
                FragmentTrendChartBinding binding2 = getBinding();
                TextView textView11 = binding2 != null ? binding2.m6 : null;
                if (textView11 != null) {
                    textView11.setBackground(null);
                }
                FragmentTrendChartBinding binding3 = getBinding();
                TextView textView12 = binding3 != null ? binding3.year : null;
                if (textView12 != null) {
                    textView12.setBackground(null);
                }
                FragmentTrendChartBinding binding4 = getBinding();
                if (binding4 != null && (textView3 = binding4.m3) != null) {
                    textView3.setTextColor(ContextCompat.getColor(context, R.color.colorGlobal_accent));
                }
                FragmentTrendChartBinding binding5 = getBinding();
                if (binding5 != null && (textView2 = binding5.m6) != null) {
                    textView2.setTextColor(ContextCompat.getColor(context, R.color.colorLabel_label3));
                }
                FragmentTrendChartBinding binding6 = getBinding();
                if (binding6 == null || (textView = binding6.year) == null) {
                    return;
                }
                textView.setTextColor(ContextCompat.getColor(context, R.color.colorLabel_label3));
                return;
            }
            if (i == 1) {
                FragmentTrendChartBinding binding7 = getBinding();
                TextView textView13 = binding7 != null ? binding7.m3 : null;
                if (textView13 != null) {
                    textView13.setBackground(null);
                }
                FragmentTrendChartBinding binding8 = getBinding();
                TextView textView14 = binding8 != null ? binding8.m6 : null;
                if (textView14 != null) {
                    textView14.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_corner32_white));
                }
                FragmentTrendChartBinding binding9 = getBinding();
                TextView textView15 = binding9 != null ? binding9.year : null;
                if (textView15 != null) {
                    textView15.setBackground(null);
                }
                FragmentTrendChartBinding binding10 = getBinding();
                if (binding10 != null && (textView6 = binding10.m3) != null) {
                    textView6.setTextColor(ContextCompat.getColor(context, R.color.colorLabel_label3));
                }
                FragmentTrendChartBinding binding11 = getBinding();
                if (binding11 != null && (textView5 = binding11.m6) != null) {
                    textView5.setTextColor(ContextCompat.getColor(context, R.color.colorGlobal_accent));
                }
                FragmentTrendChartBinding binding12 = getBinding();
                if (binding12 == null || (textView4 = binding12.year) == null) {
                    return;
                }
                textView4.setTextColor(ContextCompat.getColor(context, R.color.colorLabel_label3));
                return;
            }
            if (i != 2) {
                return;
            }
            FragmentTrendChartBinding binding13 = getBinding();
            TextView textView16 = binding13 != null ? binding13.m3 : null;
            if (textView16 != null) {
                textView16.setBackground(null);
            }
            FragmentTrendChartBinding binding14 = getBinding();
            TextView textView17 = binding14 != null ? binding14.m6 : null;
            if (textView17 != null) {
                textView17.setBackground(null);
            }
            FragmentTrendChartBinding binding15 = getBinding();
            TextView textView18 = binding15 != null ? binding15.year : null;
            if (textView18 != null) {
                textView18.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_corner32_white));
            }
            FragmentTrendChartBinding binding16 = getBinding();
            if (binding16 != null && (textView9 = binding16.m3) != null) {
                textView9.setTextColor(ContextCompat.getColor(context, R.color.colorLabel_label3));
            }
            FragmentTrendChartBinding binding17 = getBinding();
            if (binding17 != null && (textView8 = binding17.m6) != null) {
                textView8.setTextColor(ContextCompat.getColor(context, R.color.colorLabel_label3));
            }
            FragmentTrendChartBinding binding18 = getBinding();
            if (binding18 == null || (textView7 = binding18.year) == null) {
                return;
            }
            textView7.setTextColor(ContextCompat.getColor(context, R.color.colorGlobal_accent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getMonthAbbreviation(int month) {
        if (this.selectCycle == 2) {
            switch (month) {
                case 1:
                case 6:
                case 7:
                    return "J";
                case 2:
                    return "F";
                case 3:
                case 5:
                    return "M";
                case 4:
                case 8:
                    return ExifInterface.GPS_MEASUREMENT_IN_PROGRESS;
                case 9:
                    return ExifInterface.LATITUDE_SOUTH;
                case 10:
                    return "O";
                case 11:
                    return "N";
                case 12:
                    return "D";
                default:
                    return "";
            }
        }
        switch (month) {
            case 1:
                return "Jan";
            case 2:
                return "Feb";
            case 3:
                return "Mar";
            case 4:
                return "Apr";
            case 5:
                return "May";
            case 6:
                return "Jun";
            case 7:
                return "Jul";
            case 8:
                return "Aug";
            case 9:
                return "Sep";
            case 10:
                return "Oct";
            case 11:
                return "Nov";
            case 12:
                return "Dec";
            default:
                return "";
        }
    }
}
